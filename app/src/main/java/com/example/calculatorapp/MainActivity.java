package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{


    private TextView resultTextView;
    private String operand1, operand2;
    private String operator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTextView = findViewById(R.id.resultTextView);
        operand1 = "";
        operand2 = "";
        operator = "";

    }

    public void onDigitClick(View view)
    {
        Button button = (Button) view;
        operand1 += button.getText().toString();
        updateResult();
    }

    public void onOperatorClick(View view) {
        Button button = (Button) view;
        operator = button.getText().toString();
        operand2 = operand1;
        operand1 = "";
    }

    public void updateResult() {
        resultTextView.setText(operand1);
    }

    public void onClearClick(View view) {
        operand1 = "";
        operand2 = "";
        operator = "";
        updateResult();
    }

    public void onEqualClick(View view)
    {
        double result = 0;
        double op1 = Double.parseDouble(operand2);
        double op2 = Double.parseDouble(operand1);

        switch (operator) {
            case "+":
                result = op1 + op2;
                break;
            case "-":
                result = op1 - op2;
                break;
            case "*":
                result = op1 * op2;
                break;
            case "/":
                if (op2 != 0) {
                    result = op1 / op2;
                } else {
                    Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
                }
                break;
        }

        operand1 = String.valueOf(result);
        updateResult();
    }

}