package com.example.vaslivanov.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

    Button btnOne, btnTwo, btnThree, btnFour, btnFive;
    Button btnSix, btnSeven, btnEight, btnNine, btnZero;
    Button btnPlus, btnMinus, btnMulti, btnDiv, btnEqual, btnClear;
    TextView tvLCD;
    int operand1, operand2, flagAction;
    double result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnOne = (Button) findViewById(R.id.btnOne);
        btnTwo = (Button) findViewById(R.id.btnTwo);
        btnThree = (Button) findViewById(R.id.btnThree);
        btnFour = (Button) findViewById(R.id.btnFour);
        btnFive = (Button) findViewById(R.id.btnFive);
        btnSix = (Button) findViewById(R.id.btnSix);
        btnSeven = (Button) findViewById(R.id.btnSeven);
        btnEight = (Button) findViewById(R.id.btnEight);
        btnNine = (Button) findViewById(R.id.btnNine);
        btnZero = (Button) findViewById(R.id.btnZero);
        btnPlus = (Button) findViewById(R.id.btnPlus);
        btnMinus = (Button) findViewById(R.id.btnMinus);
        btnMulti = (Button) findViewById(R.id.btnMulti);
        btnDiv = (Button) findViewById(R.id.btnDiv);
        btnEqual = (Button) findViewById(R.id.btnEqual);
        btnClear = (Button) findViewById(R.id.btnClear);
        tvLCD = (TextView) findViewById(R.id.tvLCD);

        btnOne.setOnClickListener(this);
        btnTwo.setOnClickListener(this);
        btnThree.setOnClickListener(this);
        btnFour.setOnClickListener(this);
        btnFive.setOnClickListener(this);
        btnSix.setOnClickListener(this);
        btnSeven.setOnClickListener(this);
        btnEight.setOnClickListener(this);
        btnNine.setOnClickListener(this);
        btnZero.setOnClickListener(this);
        btnPlus.setOnClickListener(this);
        btnMinus.setOnClickListener(this);
        btnMulti.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
        btnClear.setOnClickListener(this);
        btnEqual.setOnClickListener(this);

        operand1 = 0;
        operand2 = 0;
        result = 0;
        flagAction = 0;

        tvLCD.setText(Integer.toString(operand1));
    }

        private void ClickNumber(int num) {
            if(flagAction == 0){
                operand1 = operand1*10 + num;
                tvLCD.setText(Integer.toString(operand1));
            }else{
                operand2 = operand2*10 + num;
                tvLCD.setText(Integer.toString(operand2));
            }
        }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnOne:
                ClickNumber(1);
                break;
            case R.id.btnTwo:
                ClickNumber(2);
                break;
            case R.id.btnThree:
                ClickNumber(3);
                break;
            case R.id.btnFour:
                ClickNumber(4);
                break;
            case R.id.btnFive:
                ClickNumber(5);
                break;
            case R.id.btnSix:
                ClickNumber(6);
                break;
            case R.id.btnSeven:
                ClickNumber(7);
                break;
            case R.id.btnEight:
                ClickNumber(8);
                break;
            case R.id.btnNine:
                ClickNumber(9);
                break;
            case R.id.btnZero:
                ClickNumber(0);
                break;
            case R.id.btnPlus:
                if(flagAction == 0)flagAction = 1;
                break;
            case R.id.btnMinus:
                if(flagAction == 0)flagAction = 2;
                break;
            case R.id.btnMulti:
                if(flagAction == 0)flagAction = 3;
                break;
            case R.id.btnDiv:
                if(flagAction == 0)flagAction = 4;
                break;
            case R.id.btnEqual:
                switch(flagAction){
                    case 1:
                        result = operand1 + operand2;
                        break;
                    case 2:
                        result = operand1 - operand2;
                        break;
                    case 3:
                        result = operand1 * operand2;
                        break;
                    case 4:
                        result =(double) operand1 / (double) operand2;
                        break;
                    default:
                        Toast.makeText(this, "Операция не задана", Toast.LENGTH_LONG);
                }
                if(flagAction != 0){
                    tvLCD.setText(Double.toString(result));
                    operand1 = 0;
                    operand2 = 0;
                    result = 0;
                    flagAction = 0;
                }
                break;
            case R.id.btnClear:
                operand1 = 0;
                operand2 = 0;
                result = 0;
                flagAction = 0;
                tvLCD.setText(Integer.toString(operand1));
                break;
        }
    }
}
