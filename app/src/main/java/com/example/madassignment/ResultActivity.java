package com.example.madassignment;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    TextView resultTextView;
    Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        resultTextView = findViewById(R.id.resultTextView);
        backButton = findViewById(R.id.backButton);

        String num1Str = getIntent().getStringExtra("num1");
        String num2Str = getIntent().getStringExtra("num2");
        String operation = getIntent().getStringExtra("operation");

        double num1 = Double.parseDouble(num1Str);
        double num2 = Double.parseDouble(num2Str);
        double result = 0.0;

        switch (operation) {
            case "add":
                result = num1 + num2;
                break;
            case "subtract":
                result = num1 - num2;
                break;
            case "multiply":
                result = num1 * num2;
                break;
            case "divide":
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    resultTextView.setText("Cannot divide by zero!");
                    return;
                }
                break;
        }

        resultTextView.setText("Result: " + result);

        backButton.setOnClickListener(v -> {
            Intent intent = new Intent(ResultActivity.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // Clears back stack
            startActivity(intent);
            finish();
        });
    }
}