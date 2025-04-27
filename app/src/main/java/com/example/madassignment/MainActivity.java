package com.example.madassignment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView mainroot;
    EditText num1EditText, num2EditText;
    Button addButton, subtractButton, multiplyButton, divideButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1EditText = findViewById(R.id.num1EditText);
        num2EditText = findViewById(R.id.num2EditText);

        addButton = findViewById(R.id.addButton);
        subtractButton = findViewById(R.id.subtractButton);
        multiplyButton = findViewById(R.id.multiplyButton);
        divideButton = findViewById(R.id.divideButton);

        addButton.setOnClickListener(v -> navigateToResultActivity("add"));
        subtractButton.setOnClickListener(v -> navigateToResultActivity("subtract"));
        multiplyButton.setOnClickListener(v -> navigateToResultActivity("multiply"));
        divideButton.setOnClickListener(v -> navigateToResultActivity("divide"));
    }

    private void navigateToResultActivity(String operation) {
        String num1 = num1EditText.getText().toString();
        String num2 = num2EditText.getText().toString();

        if (!num1.isEmpty() && !num2.isEmpty()) {
            Intent intent = new Intent(MainActivity.this, ResultActivity.class);
            intent.putExtra("num1", num1);
            intent.putExtra("num2", num2);
            intent.putExtra("operation", operation);
            startActivity(intent);
        } else {
            Toast.makeText(MainActivity.this, "Please enter both numbers", Toast.LENGTH_SHORT).show();
        }
    }
}
