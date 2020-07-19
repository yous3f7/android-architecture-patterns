package com.alyndroid.architecturepatternstutorialshomework.ui;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import static com.alyndroid.architecturepatternstutorialshomework.ui.MainActivity.dataBase;

public class CalculatorViewModel extends ViewModel {
    public MutableLiveData<String> multiplicationMutableLiveData =
            new MutableLiveData<>("mul result");

    public MutableLiveData<String> firstMutableLiveData =
            new MutableLiveData<>("4");

    public MutableLiveData<String> secondMutableLiveData =
            new MutableLiveData<>("4");

    public void setFirstMutableLiveData(String f){
        int newVal;
        try {
            newVal = Integer.decode(f);
            firstMutableLiveData.setValue(f);
            dataBase.getNumbers().setFirstNum(newVal);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public void setSecondMutableLiveData(String f){
        int newVal;
        try {
            newVal = Integer.decode(f);
            secondMutableLiveData.setValue(f);
            dataBase.getNumbers().setSecondNum(newVal);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public void multiplication(){
        int number;
        try {
            number = dataBase.getNumbers().getFirstNum()
                    *
                    dataBase.getNumbers().getSecondNum();
            multiplicationMutableLiveData.setValue(String.valueOf(number));
        } catch (Exception e) {
            e.printStackTrace();
            multiplicationMutableLiveData.setValue("Failure");
        }
    }

}
