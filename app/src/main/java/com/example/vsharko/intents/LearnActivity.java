package com.example.vsharko.intents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class LearnActivity extends AppCompatActivity implements View.OnClickListener {
        TextView resultText,firstNumber,operationText,secondNumber,scoreText;
    int firstNumberInt,secondNumberInt,result,score,skillLevel;

    public void gameSetup(int score){
        firstNumber = findViewById(R.id.firstNumber);
        operationText = findViewById(R.id.operationText);
        resultText = findViewById(R.id.resultText);
        scoreText = findViewById(R.id.scoreText);
        secondNumber = findViewById(R.id.secondNumber);
        resultText.setText("");
            if(score==10){

            }else{
                scoreText.setText(score + "/10");
                Random randNumber = new Random();
                firstNumber.setText(Integer.toString(randNumber.nextInt(100-1)+1));
                secondNumber.setText(Integer.toString(randNumber.nextInt(100-1)+1));
                if(Integer.valueOf(firstNumber.getText().toString()) <= 10 || Integer.valueOf(secondNumber.getText().toString()) <= 10 ){
                    operationText.setText("*");
                }else{
                    operationText.setText("+");
                }

            }
    }

    public void onClick(View view) {
        firstNumber = findViewById(R.id.firstNumber);
        operationText = findViewById(R.id.operationText);
        resultText = findViewById(R.id.resultText);
        scoreText = findViewById(R.id.scoreText);
        secondNumber = findViewById(R.id.secondNumber);

        firstNumberInt=Integer.parseInt(firstNumber.getText().toString());
        secondNumberInt=Integer.parseInt(secondNumber.getText().toString());
        switch  (operationText.getText().toString()){
            case "+":
                result = firstNumberInt + secondNumberInt;
                break;
            case "*":
                result= firstNumberInt * secondNumberInt;
                break;
        }
            switch (view.getId()) {
                case R.id.button1:
                    resultText.setText(resultText.getText()+"1");
                    if (result == Integer.parseInt(resultText.getText().toString())){
                        score++;
                        gameSetup(score);
                        break;
                    }
                    break;
                case R.id.button2:
                    resultText.setText(resultText.getText()+"2");
                    if (result == Integer.parseInt(resultText.getText().toString())){
                        score++;
                        gameSetup(score);
                        break;
                    }break;
                case R.id.button3:
                    resultText.setText(resultText.getText()+"3");
                    if (result == Integer.parseInt(resultText.getText().toString())){
                        score++;
                        gameSetup(score);
                        break;
                    }break;
                case R.id.button4:
                    resultText.setText(resultText.getText()+"4");
                    if (result == Integer.parseInt(resultText.getText().toString())){
                        score++;
                        gameSetup(score);
                        break;
                    }break;
                case R.id.button5:
                    resultText.setText(resultText.getText()+"5");
                    if (result == Integer.parseInt(resultText.getText().toString())){
                        score++;
                        gameSetup(score);
                        break;
                    }break;
                case R.id.button6:
                    resultText.setText(resultText.getText()+"6");
                    if (result == Integer.parseInt(resultText.getText().toString())){
                        score++;
                        gameSetup(score);
                        break;
                    }break;
                case R.id.button7:
                    resultText.setText(resultText.getText()+"7");
                    if (result == Integer.parseInt(resultText.getText().toString())){
                        score++;
                        gameSetup(score);
                        break;
                    }break;
                case R.id.button8:
                    resultText.setText(resultText.getText()+"8");
                    if (result == Integer.parseInt(resultText.getText().toString())){
                        score++;
                        gameSetup(score);
                        break;
                    }break;
                case R.id.button9:
                    resultText.setText(resultText.getText()+"9");
                    if (result == Integer.parseInt(resultText.getText().toString())){
                        score++;
                        gameSetup(score);
                        break;
                    }break;
                case R.id.button0:
                    resultText.setText(resultText.getText()+"0");
                    if (result == Integer.parseInt(resultText.getText().toString())){
                        score++;
                        gameSetup(score);
                        break;
                    }break;
                case R.id.buttonDelete:
                    resultText.setText("");
                    break;
            }
        }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);
        skillLevel = getIntent().getExtras().getInt("skillPoints");

        List<Integer> buttons = Arrays.asList(R.id.button1, R.id.button2, R.id.button3,
                R.id.button4, R.id.button5, R.id.button6, R.id.button7,
                R.id.button8, R.id.button9, R.id.button0, R.id.buttonDelete);
        for(Integer i: buttons) {
        View b = findViewById(i);
        b.setOnClickListener(this); // calling onClick() method
            gameSetup(0);

    }
    }
    @Override
    public void finish(){
        Intent intent = new Intent();

        skillLevel = skillLevel+(score*10);
        intent.putExtra("skillLevel",skillLevel);
        setResult(RESULT_OK, intent);

        super.finish();
    }

}
