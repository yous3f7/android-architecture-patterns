package com.alyndroid.architecturepatternstutorialshomework.ui;

import static com.alyndroid.architecturepatternstutorialshomework.ui.MainActivity.dataBase;

public class CalculatorPresenter {
    private  ICalculator iCalculator;

    public CalculatorPresenter(ICalculator iCalculator) {
        this.iCalculator = iCalculator;
    }

    public void divCalculator(){
        int number;
        try {
            number = dataBase.getNumbers().getFirstNum() /
                    dataBase.getNumbers().getSecondNum();
            iCalculator.div(String.valueOf(number));
        } catch (Exception e) {
            e.printStackTrace();
            iCalculator.div("Failure");
        }
    }
}
