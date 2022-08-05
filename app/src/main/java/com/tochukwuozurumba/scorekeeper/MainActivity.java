package com.tochukwuozurumba.scorekeeper;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private RadioButton selectedRadioButton;
    private RadioGroup rgButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rgButton = findViewById(R.id.radio_groups);
        Button buttonA_1 = findViewById(R.id.button_team_a_increase_id);
        Button buttonA_2 = findViewById(R.id.button_team_a_decrease_id);
        Button buttonB_1 = findViewById(R.id.button_team_b_increase_id);
        Button buttonB_2 = findViewById(R.id.button_team_b_decrease_id);

        TextView teamAScore = findViewById(R.id.score_team_a);
        TextView teamBScore = findViewById(R.id.score_team_b);

        buttonA_1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                int result = calculateScore(Integer.parseInt(teamAScore.getText().toString()), getRadioButtonValue(), "add");
                teamAScore.setText(String.valueOf(result));
            }
        });

        buttonA_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int result = calculateScore(Integer.parseInt(teamAScore.getText().toString()), getRadioButtonValue(), "subtract");
                teamAScore.setText(String.valueOf(result));
            }
        });

        buttonB_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int result = calculateScore(Integer.parseInt(teamBScore.getText().toString()), getRadioButtonValue(), "add");
                teamBScore.setText(String.valueOf(result));
            }
        });

        buttonB_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int result = calculateScore(Integer.parseInt(teamBScore.getText().toString()), getRadioButtonValue(), "subtract");
                teamBScore.setText(String.valueOf(result));
            }
        });
    }

    private int calculateScore(int oldNumber, int newNumber, String sign) {
        int finalScore;

        if (sign == "add") {
            finalScore = oldNumber + newNumber;
        } else {
            finalScore = oldNumber - newNumber;
        }

        return finalScore;
    }

    private int getRadioButtonValue() {
        int result;

        int selectedRadioButtonId = rgButton.getCheckedRadioButtonId();
        if (selectedRadioButtonId != -1) {
            selectedRadioButton = findViewById(selectedRadioButtonId);
            String selectedRbText = selectedRadioButton.getText().toString();
            result = Integer.parseInt(selectedRbText);
        } else {
            result = 0;
        }

        return result;
    }
}