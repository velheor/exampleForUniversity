package com.example.masterclass;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.l4.R;

import by.grsu.getrandomnumber.guessNum;

public class MainActivity extends AppCompatActivity {

    int number = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        number = guessNum.getRandomNumber();
        final Button btn_guess = (Button) findViewById(R.id.btn_guess);
        final TextView textView = (TextView) findViewById(R.id.show_attempts);
        final EditText editText = (EditText) findViewById(R.id.edit_num);
        final TextView textView1 = (TextView) findViewById(R.id.textView5);

        View.OnClickListener OnClickBtn_guess = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int attempts = Integer.parseInt(String.valueOf(textView.getText()));
                int userNumber = Integer.parseInt(String.valueOf(editText.getText()));

                textView1.setText(GetHint(number, userNumber));

                if (userNumber == number) {
                    Toast t = Toast.makeText(getApplicationContext(), R.string.win_str, Toast.LENGTH_LONG);
                    t.show();
                    btn_guess.setClickable(false);
                    number = guessNum.getRandomNumber();
                } else if (attempts > 3) {
                    attempts--;
                    textView.setText(String.valueOf(attempts));
                } else if (attempts > 1) {
                    attempts--;
                    textView.setText(String.valueOf(attempts));
                    textView.setTextColor(Color.parseColor("#FF0000"));
                } else {
                    Toast t = Toast.makeText(getApplicationContext(), R.string.lose_str, Toast.LENGTH_LONG);
                    t.show();
                    restart(view);
                }
            }
        };
        btn_guess.setOnClickListener(OnClickBtn_guess);


    }

    public String GetHint(int x, int userNumber) {
        String hint = String.valueOf(userNumber);
        if (x > userNumber) {
            return hint.concat(": меньше \n");
        } else if (x < userNumber) {
            return hint.concat(":больше \n");
        } else {
            return "";
        }
    }

    public void restart(View view) {
        String hint = "5";

        TextView textView = (TextView) findViewById(R.id.show_attempts);
        Button btn_guess = (Button) findViewById(R.id.btn_guess);
        TextView textView1 = (TextView) findViewById((R.id.textView5));

        btn_guess.setClickable(true);
        textView1.setText("Подсказки: \n");
        textView.setText(hint);
        textView.setTextColor(Color.parseColor("#000000"));
        number = guessNum.getRandomNumber();
    }
}