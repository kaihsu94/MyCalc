package com.example.mikehsu.mycalc;

import android.app.Activity;
import android.media.Image;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

public class CalcActivity extends Activity {

    public enum Op{
        ADD,SUB,DIV,MUL,EQU
    }
    Op currentOp;
    String runningNumber="";
    String rightVal;
    String leftVal;
    int result;
    int flag=0;
    TextView totalResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);
        Button button1 = (Button)findViewById(R.id.button1);
        Button button2 = (Button)findViewById(R.id.button2);
        Button button3 = (Button)findViewById(R.id.button3);
        Button button4 = (Button)findViewById(R.id.button4);
        Button button5 = (Button)findViewById(R.id.button5);
        Button button6 = (Button)findViewById(R.id.button6);
        Button button7 = (Button)findViewById(R.id.button7);
        Button button8 = (Button)findViewById(R.id.button8);
        Button button9 = (Button)findViewById(R.id.button9);
        Button button0 = (Button)findViewById(R.id.button0);
        ImageButton addBtn = (ImageButton)findViewById(R.id.addBtn);
        ImageButton subBtn = (ImageButton)findViewById(R.id.subBtn);
        ImageButton divBtn = (ImageButton)findViewById(R.id.divBtn);
        ImageButton mulBtn = (ImageButton)findViewById(R.id.mulBtn);
        Button clearBtn = (Button)findViewById(R.id.clearnBtn);
        ImageButton calcBtn = (ImageButton)findViewById(R.id.calcBtn);
        totalResult = (TextView)findViewById(R.id.resultView);


        totalResult.setText("");

        clearBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                leftVal = "";
                rightVal = "";
                result =0;
                runningNumber="";
                currentOp=null;
                totalResult.setText("0");
            }
        });

        button0.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                numberPressed(0);
            }



        });
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                numberPressed(1);
            }



        });
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                numberPressed(2);
            }



        });
        button3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                numberPressed(3);
            }



        });
        button4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                numberPressed(4);
            }



        });
        button5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                numberPressed(5);
            }



        });
        button6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                numberPressed(6);
            }



        });
        button7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                numberPressed(7);
            }



        });
        button8.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                numberPressed(8);
            }



        });
        button9.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                numberPressed(9);
            }



        });
        mulBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                flag=0;
                doOp(Op.MUL);
            }
        });
        addBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                flag=0;
                doOp(Op.ADD);
            }
        });
        subBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                flag=0;
                doOp(Op.SUB);
            }
        });
        divBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                flag=0;
                doOp(Op.DIV);
            }
        });
        calcBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                doOp(Op.EQU);
            }
        });

    }

    void doOp(Op operation){
        if(operation == Op.EQU) {
         //   Log.d("flag", "setting flag now");
            flag = 1;
        }

        if(currentOp != null){
            if (runningNumber != ""){
                rightVal = runningNumber;
                runningNumber ="";
                switch (currentOp){
                    case ADD:
                        result = Integer.parseInt(leftVal) + Integer.parseInt(rightVal);
                        break;
                    case SUB:
                        result = Integer.parseInt(leftVal) - Integer.parseInt(rightVal);
                        break;
                    case MUL:
                        result = Integer.parseInt(leftVal) * Integer.parseInt(rightVal);
                        break;
                    case DIV:
                        if (Integer.parseInt(rightVal) == 0){
                            totalResult.setText("cant div by 0");
                        }
                        else {
                            result = Integer.parseInt(leftVal) / Integer.parseInt(rightVal);
                        }
                        break;

                }
                leftVal = String.valueOf(result);
                totalResult.setText(leftVal);
            }

        }else{
            leftVal = runningNumber;
            runningNumber = "";

        }
        currentOp = operation;
    }
    void numberPressed( int num){
        if(flag == 0) {
            runningNumber += String.valueOf(num);
            totalResult.setText(runningNumber);
        }
        else if (flag==1){
           // Log.d("all", "here");
            leftVal = "";
            rightVal = "";
            result =0;
            runningNumber="";
            currentOp=null;
            runningNumber += String.valueOf(num);
            totalResult.setText(runningNumber);
            flag=0;
        }
    }
}
