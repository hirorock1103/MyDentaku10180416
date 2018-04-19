package com.example.amb01.mydentaku10180416;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private long input = 0;//入力値
    private long answer = 0;//演算結果を保持する
    private int calcType = 0; //演算の種類（ 1:+ 2:- 3:÷ 4:×）
    private boolean isCalcEnd = false;//=ボタンを押したか

    private TextView showTextNumber;
    private TextView showTextCalculation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //数字を表示
        showTextNumber = findViewById(R.id.my_main_activity_calc_result);
        //演算ボタン押下時に表示
        showTextCalculation = findViewById(R.id.my_main_activity_calculation);

        //0～9までの数字ボタン
        Button[] buttons = new Button[10];
        for(int i = 0 ; i < buttons.length; i++){
            int buttonId = getResources().getIdentifier("my_main_activity_button_" + i, "id", getPackageName());
            buttons[i] = findViewById(buttonId);
            //数字ボタンの値
            final int numValue = i;
            buttons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    input = (input * 10) + numValue;
                    showTextNumber.setText(String.valueOf(input));
                }
            });
        }


        //演算ボタンなど
        Button btMultipul = findViewById(R.id.my_main_activity_button_kakeru);
        Button btDivine = findViewById(R.id.my_main_activity_button_devine);
        Button btMinus = findViewById(R.id.my_main_activity_button_minus);
        Button btPlus = findViewById(R.id.my_main_activity_button_plus);
        Button btCalc = findViewById(R.id.my_main_activity_button_calc);
        Button btDelete = findViewById(R.id.my_main_activity_button_del);
        btMultipul.setOnClickListener(this);
        btDivine.setOnClickListener(this);
        btMinus.setOnClickListener(this);
        btPlus.setOnClickListener(this);
        btDelete.setOnClickListener(this);
        btCalc.setOnClickListener(this);

    }

    /**
     * 選択している演算方法で計算する
     * @param left
     * @param right
     * @param calcType
     * @return
     */
    private long calc( long left , long right,  int calcType){

        long ans = 0;

        if(calcType == 1){
            ans = left + right;
        }else if(calcType == 2){
            ans = left - right;
        }else if(calcType == 3) {
            ans = left / right;
        }else if(calcType == 4){
            ans = left * right;
        }

        return ans;

    }


    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.my_main_activity_button_calc:

                if(calcType > 0){
                    //計算する
                    answer = calc(answer, input, calcType);
                }else{
                    answer = input;
                }

                isCalcEnd = true;

                //show ans
                showTextNumber.setText(String.valueOf(answer));
                showTextCalculation.setText("");
                showTextCalculation.setBackgroundColor(Color.WHITE);

                break;

            case R.id.my_main_activity_button_plus:


                if( calcType > 0 && isCalcEnd == false){

                    answer = calc(answer, input, calcType);
                    showTextNumber.setText(String.valueOf(answer));

                }else if( calcType > 0 && isCalcEnd == true ){

                    showTextNumber.setText(String.valueOf(answer));
                    isCalcEnd = false;

                }else{
                    //演算機能は無効
                    answer = input;
                }

                //input 初期化
                input = 0;

                //表示する
                showTextCalculation.setText("＋");
                showTextCalculation.setBackgroundColor(Color.BLACK);

                //1:＋をセット
                calcType = 1;

                break;

            case R.id.my_main_activity_button_minus:


                if( calcType > 0 && isCalcEnd == false){

                    answer = calc(answer, input, calcType);
                    showTextNumber.setText(String.valueOf(answer));

                }else if( calcType > 0 && isCalcEnd == true ){

                    showTextNumber.setText(String.valueOf(answer));
                    isCalcEnd = false;

                }else{
                    //演算機能は無効
                    answer = input;
                }

                //input 初期化
                input = 0;

                //表示する
                showTextCalculation.setText("-");
                showTextCalculation.setBackgroundColor(Color.BLACK);

                //2:-をセット
                calcType = 2;

                break;

            case R.id.my_main_activity_button_kakeru:


                if( calcType > 0 && isCalcEnd == false){

                    answer = calc(answer, input, calcType);
                    showTextNumber.setText(String.valueOf(answer));

                }else if( calcType > 0 && isCalcEnd == true ){

                    showTextNumber.setText(String.valueOf(answer));
                    isCalcEnd = false;

                }else{
                    //演算機能は無効
                    answer = input;
                }

                //input 初期化
                input = 0;


                //表示する
                showTextCalculation.setText("×");
                showTextCalculation.setBackgroundColor(Color.BLACK);

                //4:×をセット
                calcType = 4;

                break;

            case R.id.my_main_activity_button_devine:


                if( calcType > 0 && isCalcEnd == false){

                    answer = calc(answer, input, calcType);
                    showTextNumber.setText(String.valueOf(answer));

                }else if( calcType > 0 && isCalcEnd == true ){

                    showTextNumber.setText(String.valueOf(answer));
                    isCalcEnd = false;

                }else{
                    //演算機能は無効
                    answer = input;
                }

                //input 初期化
                input = 0;

                //表示する
                showTextCalculation.setText("÷");
                showTextCalculation.setBackgroundColor(Color.BLACK);

                //3:÷をセット
                calcType = 3;

                break;

            case R.id.my_main_activity_button_del:

                //値をクリアする
                input = 0;
                calcType = 0;
                answer = 0;

                //表示をクリア
                showTextNumber.setText("0");
                showTextCalculation.setText("");
                showTextCalculation.setBackgroundColor(Color.WHITE);
                break;

        }


    }
}
