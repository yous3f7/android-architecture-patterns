package com.alyndroid.architecturepatternstutorialshomework.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.alyndroid.architecturepatternstutorialshomework.R;
import com.alyndroid.architecturepatternstutorialshomework.databinding.ActivityMainBinding;
import com.alyndroid.architecturepatternstutorialshomework.model.DataBase;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ICalculator{
    // initialise Database
    static public DataBase dataBase= new DataBase();
    Button plusButton;
    Button divButton;
    TextView plusResultTextView;
    TextView divResultTextView;
    EditText firstNumber;
    EditText secondNumber;
    CalculatorPresenter calculatorPresenter;
    CalculatorViewModel calculatorViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /// initialise presenter
        calculatorPresenter = new CalculatorPresenter(this);

        /// Enable data binding
        ActivityMainBinding binding =
                DataBindingUtil.setContentView(this,R.layout.activity_main);

        // initialise ViewModel
        calculatorViewModel =
                new ViewModelProvider(this).get(CalculatorViewModel.class);
        binding.setViewModel(calculatorViewModel);
        binding.setLifecycleOwner(this);


        plusButton = binding.plusButton;
        plusButton.setOnClickListener(this);
        divButton = binding.divButton;
        divButton.setOnClickListener(this);

        plusResultTextView = binding.plusResultTextView;
        plusResultTextView.setText("plus result");

        divResultTextView = binding.divResultTextView;
        divResultTextView.setText("div result");


        firstNumber = binding.textView4;
        secondNumber = binding.textView5;

        firstNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                calculatorViewModel.setFirstMutableLiveData(s.toString());
            }
        });

        secondNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                calculatorViewModel.setSecondMutableLiveData(s.toString());
            }
        });
    }


    /// MVC pattern
    private void CalculatorPlus(){
        int number;
        try {
            number = dataBase.getNumbers().getFirstNum() +
                    dataBase.getNumbers().getSecondNum();
            plusResultTextView.setText(String.valueOf(number));
        } catch (Exception e) {
            e.printStackTrace();
            plusResultTextView.setText("Failure");
        }
    }

    /// MVC pattern
    @Override
    public void onClick(View v) {
        if(v.getId() == plusButton.getId())
            CalculatorPlus();
        if(v.getId() == divButton.getId())
            calculatorPresenter.divCalculator();

    }

    /// MVP pattern
    @Override
    public void div(String number) {
        divResultTextView.setText(number);
    }
}
