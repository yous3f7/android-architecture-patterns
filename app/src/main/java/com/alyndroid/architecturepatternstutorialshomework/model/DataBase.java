package com.alyndroid.architecturepatternstutorialshomework.model;

import com.alyndroid.architecturepatternstutorialshomework.ui.NumberModel;

public class DataBase {

    private NumberModel _numberModel = new NumberModel();

    public NumberModel getNumbers(){
        return _numberModel;
    }
}
