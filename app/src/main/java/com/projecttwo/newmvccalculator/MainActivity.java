package com.projecttwo.newmvccalculator;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CalcLogic cl = new CalcLogic();

    private Double val1 = Double.NaN;
    private Double val2 = Double.NaN;
    private Double lastAnswer = Double.NaN;
    private char ACTION = '0';
    private TextView workingVal1, workingAction, workingVal2,answerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Bind view variables to widgets
        workingVal1 = findViewById(R.id.workingVal1);
        workingAction = findViewById(R.id.workingAction);
        workingVal2 = findViewById(R.id.workingVal2);
        answerView = findViewById(R.id.answer);

        answerView.setText("0");

    }

/*** Listener for Clear  ***/
    public void onClickClear(View view){
        val1 = Double.NaN;
        val2 = Double.NaN;
        lastAnswer = Double.NaN;
        ACTION = '0';
        UpdateViews();
        answerView.setText("0");
    }

/*** Listener for Equals  ***/
    public void onClickEqu(View view){
        if(!Double.isNaN(val1) && ACTION == '0') {
            answerView.setText(String.valueOf(val1));
            lastAnswer = val1;
            val1 = Double.NaN;
            ACTION = '0';
            UpdateViews();
        }
        if(!Double.isNaN(val1) && ACTION != '0' && !Double.isNaN(val2)){
            val1 = cl.switchAction(val1, val2, ACTION);
            answerView.setText(String.valueOf(val1));
            lastAnswer = val1;
            val1 = Double.NaN;
            val2 = Double.NaN;
            ACTION = '0';
            UpdateViews();
        }
    }

/*** Listener for Add  ***/
    public void onClickAdd(View view){
        if(Double.isNaN(val1) && Double.isNaN(lastAnswer)){
            val1 = 0.0;
            ACTION = '+';
            UpdateViews();
        }
        if(Double.isNaN(val1) && !Double.isNaN(lastAnswer)){
            val1 = lastAnswer;
            ACTION = '+';
            UpdateViews();
        }
        if(!Double.isNaN(val1) && Double.isNaN(val2)){
            ACTION = '+';
            UpdateViews();
        }
        else{
            val1 = cl.addition(val1, val2);
            val2 = Double.NaN;
            ACTION = '+';
            UpdateViews();
        }
    }

/*** Listener for Subtraction ***/
    public void onClickSub(View view){
        if(Double.isNaN(val1) && Double.isNaN(lastAnswer)){
            val1 = 0.0;
            ACTION = '-';
            UpdateViews();
        }
        if(Double.isNaN(val1) && !Double.isNaN(lastAnswer)){
            val1 = lastAnswer;
            ACTION = '-';
            UpdateViews();
        }
        if(!Double.isNaN(val1) && Double.isNaN(val2)){
            ACTION = '-';
            UpdateViews();
        }
        else{
            val1 = cl.subtraction(val1, val2);
            val2 = Double.NaN;
            ACTION = '-';
            UpdateViews();
        }
    }

/*** Listener for Multiplication ***/
    public void onClickMul(View view){
        if(Double.isNaN(val1) && Double.isNaN(lastAnswer)){
            Toast.makeText(getApplicationContext(), "Insert a Number",Toast.LENGTH_SHORT).show();
            return;
        }
        if(Double.isNaN(val1) && !Double.isNaN(lastAnswer)){
            val1 = lastAnswer;
            ACTION = '*';
            UpdateViews();
        }
        if(!Double.isNaN(val1) && Double.isNaN(val2)){
            ACTION = '*';
            UpdateViews();
        }
        else{
            val1 = cl.multiplication(val1, val2);
            val2 = Double.NaN;
            ACTION = '*';
            UpdateViews();
        }
    }

/*** Listener for Division ***/
    public void onClickDiv(View view){
        if(Double.isNaN(val1) && Double.isNaN(lastAnswer)){
            Toast.makeText(getApplicationContext(), "Insert a Non-zero Number",Toast.LENGTH_SHORT).show();
            return;
        }
        if(Double.isNaN(val1) && !Double.isNaN(lastAnswer)){
            val1 = lastAnswer;
            if(val1 == 0) {
                Toast.makeText(getApplicationContext(), "Cannot Divide by Zero", Toast.LENGTH_SHORT).show();
                return;
            }
            else{
                ACTION = '/';
                UpdateViews();
            }
        }
        if(!Double.isNaN(val1) && Double.isNaN(val2)){
            if(val1 == 0) {
                Toast.makeText(getApplicationContext(), "Cannot Divide by Zero", Toast.LENGTH_SHORT).show();
            }
            else{
                ACTION = '/';
                UpdateViews();
            }
        }
        else {
            if (val1 == 0) {
                Toast.makeText(getApplicationContext(), "Cannot Divide by Zero", Toast.LENGTH_SHORT).show();
            } else {
                val1 = cl.division(val1, val2);
                val2 = Double.NaN;
                ACTION = '/';
                UpdateViews();
            }
        }
    }

/*** Listener for 0  ***/
    public void onClick0(View view){
        if(Double.isNaN(val1)) {
            val1 = 0.0;
            UpdateViews();
            return;
        }
        if(!Double.isNaN(val1) && val1 != 0 && ACTION == '0') {
            val1 = (val1 * 10);
            UpdateViews();
            return;
        }
        if(!Double.isNaN(val1) && ACTION != '0' && (Double.isNaN(val2) || val2 == 0.0)) {
            val2 = 0.0;
            UpdateViews();
            return;
        }
        if(!Double.isNaN(val1) && ACTION != '0' && !Double.isNaN(val2)) {
            val2 = (val2 * 10);
            UpdateViews();
        }
    }

/*** Listener for 1  ***/
    public void onClick1(View view){
        if(Double.isNaN(val1)) {
            val1 = 1.0;
            UpdateViews();
            return;
        }
        if(!Double.isNaN(val1) && val1 != 0 && ACTION == '0') {
            val1 = (val1 * 10) + 1;
            UpdateViews();
            return;
        }
        if(!Double.isNaN(val1) && ACTION != '0' && (Double.isNaN(val2) || val2 == 0.0)) {
            val2 = 1.0;
            UpdateViews();
            return;
        }
        if(!Double.isNaN(val1) && ACTION != '0' && !Double.isNaN(val2)) {
            val2 = (val2 * 10) + 1;
            UpdateViews();
        }
    }

/*** Listener for 2  ***/
    public void onClick2(View view){
        if(Double.isNaN(val1)) {
            val1 = 2.0;
            UpdateViews();
            return;
        }
        if(!Double.isNaN(val1) && val1 != 0 && ACTION == '0') {
            val1 = (val1 * 10) + 2;
            UpdateViews();
            return;
        }
        if(!Double.isNaN(val1) && ACTION != '0' && (Double.isNaN(val2) || val2 == 0.0)) {
            val2 = 2.0;
            UpdateViews();
            return;
        }
        if(!Double.isNaN(val1) && ACTION != '0' && !Double.isNaN(val2)) {
            val2 = (val2 * 10) + 2;
            UpdateViews();
        }
    }

/*** Listener for 3  ***/
    public void onClick3(View view){
        if(Double.isNaN(val1)) {
            val1 = 3.0;
            UpdateViews();
            return;
        }
        if(!Double.isNaN(val1) && val1 != 0 && ACTION == '0') {
            val1 = (val1 * 10) + 3;
            UpdateViews();
            return;
        }
        if(!Double.isNaN(val1) && ACTION != '0' && (Double.isNaN(val2) || val2 == 0.0)) {
            val2 = 3.0;
            UpdateViews();
            return;
        }
        if(!Double.isNaN(val1) && ACTION != '0' && !Double.isNaN(val2)) {
            val2 = (val2 * 10) + 3;
            UpdateViews();
        }
    }

/*** Listener for 4  ***/
    public void onClick4(View view){
        if(Double.isNaN(val1)) {
            val1 = 4.0;
            UpdateViews();
            return;
        }
        if(!Double.isNaN(val1) && val1 != 0 && ACTION == '0') {
            val1 = (val1 * 10) + 4;
            UpdateViews();
            return;
        }
        if(!Double.isNaN(val1) && ACTION != '0' && (Double.isNaN(val2) || val2 == 0.0)) {
            val2 = 4.0;
            UpdateViews();
            return;
        }
        if(!Double.isNaN(val1) && ACTION != '0' && !Double.isNaN(val2)) {
            val2 = (val2 * 10) + 4;
            UpdateViews();
        }
    }

/*** Listener for 5  ***/
    public void onClick5(View view){
        if(Double.isNaN(val1)) {
            val1 = 5.0;
            UpdateViews();
            return;
        }
        if(!Double.isNaN(val1) && val1 != 0 && ACTION == '0') {
            val1 = (val1 * 10) + 5;
            UpdateViews();
            return;
        }
        if(!Double.isNaN(val1) && ACTION != '0' && (Double.isNaN(val2) || val2 == 0.0)) {
            val2 = 5.0;
            UpdateViews();
            return;
        }
        if(!Double.isNaN(val1) && ACTION != '0' && !Double.isNaN(val2)) {
            val2 = (val2 * 10) + 5;
            UpdateViews();
        }
    }

/*** Listener for 6  ***/
    public void onClick6(View view){
        if(Double.isNaN(val1)) {
            val1 = 6.0;
            UpdateViews();
            return;
        }
        if(!Double.isNaN(val1) && val1 != 0 && ACTION == '0') {
            val1 = (val1 * 10) + 6;
            UpdateViews();
            return;
        }
        if(!Double.isNaN(val1) && ACTION != '0' && (Double.isNaN(val2) || val2 == 0.0)) {
            val2 = 6.0;
            UpdateViews();
            return;
        }
        if(!Double.isNaN(val1) && ACTION != '0' && !Double.isNaN(val2)) {
            val2 = (val2 * 10) + 6;
            UpdateViews();
        }
    }

/*** Listener for 7  ***/
    public void onClick7(View view){
        if(Double.isNaN(val1)) {
            val1 = 7.0;
            UpdateViews();
            return;
        }
        if(!Double.isNaN(val1) && val1 != 0 && ACTION == '0') {
            val1 = (val1 * 10) + 7;
            UpdateViews();
            return;
        }
        if(!Double.isNaN(val1) && ACTION != '0' && (Double.isNaN(val2) || val2 == 0.0)) {
            val2 = 7.0;
            UpdateViews();
            return;
        }
        if(!Double.isNaN(val1) && ACTION != '0' && !Double.isNaN(val2)) {
            val2 = (val2 * 10) + 7;
            UpdateViews();
        }
    }

/*** Listener for 8  ***/
    public void onClick8(View view){
        if(Double.isNaN(val1)) {
            val1 = 8.0;
            UpdateViews();
            return;
        }
        if(!Double.isNaN(val1) && val1 != 0 && ACTION == '0') {
            val1 = (val1 * 10) + 8;
            UpdateViews();
            return;
        }
        if(!Double.isNaN(val1) && ACTION != '0' && (Double.isNaN(val2) || val2 == 0.0)) {
            val2 = 8.0;
            UpdateViews();
            return;
        }
        if(!Double.isNaN(val1) && ACTION != '0' && !Double.isNaN(val2)) {
            val2 = (val2 * 10) + 8;
            UpdateViews();
        }
    }

/*** Listener for 9  ***/
    public void onClick9(View view){
        if(Double.isNaN(val1)) {
            val1 = 9.0;
            UpdateViews();
            return;
        }
        if(!Double.isNaN(val1) && val1 != 0 && ACTION == '0') {
            val1 = (val1 * 10) + 9;
            UpdateViews();
            return;
        }
        if(!Double.isNaN(val1) && ACTION != '0' && (Double.isNaN(val2) || val2 == 0.0)) {
            val2 = 9.0;
            UpdateViews();
            return;
        }
        if(!Double.isNaN(val1) && ACTION != '0' && !Double.isNaN(val2)) {
            val2 = (val2 * 10) + 9;
            UpdateViews();
        }
    }

/*** Updates working views  ***/
    public void UpdateViews(){
        if(Double.isNaN(val1) && Double.isNaN(val2)){
            workingVal1.setText("");
            workingAction.setText("");
            workingVal2.setText("");
        }
        if(!Double.isNaN(val1) && ACTION == '0'){
            workingVal1.setText(String.valueOf(val1));
            workingAction.setText("");
            workingVal2.setText("");
            answerView.setText("");
        }
        if(!Double.isNaN(val1) && ACTION != '0' && Double.isNaN(val2)){
            workingVal1.setText(String.valueOf(val1));
            workingAction.setText(String.valueOf(ACTION));
        }
        if(!Double.isNaN(val1) && ACTION != '0' && !Double.isNaN(val2)){
            workingVal1.setText(String.valueOf(val1));
            workingAction.setText(String.valueOf(ACTION));
            workingVal2.setText(String.valueOf(val2));
        }
    }
}
