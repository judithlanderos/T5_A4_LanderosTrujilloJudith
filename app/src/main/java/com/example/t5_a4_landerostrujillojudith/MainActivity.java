package com.example.t5_a4_landerostrujillojudith;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText txtIngresa;
    RadioButton radioButton, radioBinario, radioOctal, radioHexadecimal;
    CheckBox checkBinario, checkOctal, checkHexadecimal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txtIngresa = (EditText) findViewById(R.id.txtIngresa);
        radioButton = (RadioButton) findViewById(R.id.radioButton);
        radioBinario = (RadioButton) findViewById(R.id.radioBinario);
        radioOctal = (RadioButton) findViewById(R.id.radioOctal);
        radioHexadecimal = (RadioButton) findViewById(R.id.radioHexadecimal);
        checkBinario = (CheckBox) findViewById(R.id.checkBinario);
        checkOctal = (CheckBox) findViewById(R.id.checkOctal);
        checkHexadecimal = (CheckBox) findViewById(R.id.checkHexadecimal);

        radioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performConversion();
            }
        });
        radioBinario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performConversion();
            }
        });
        radioOctal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performConversion();
            }
        });
        radioHexadecimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performConversion();
            }
        });

        checkBinario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performConversion();
            }
        });
        checkOctal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performConversion();
            }
        });
        checkHexadecimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performConversion();
            }
        });
    }

    private void performConversion() {
        String input = txtIngresa.getText().toString();
        if (input.isEmpty()) {
            Toast.makeText(this, "Por favor, ingrese un número", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            int number = 0;
            if (radioButton.isChecked()) {
                number = Integer.parseInt(input);
            } else if (radioBinario.isChecked()) {
                number = Integer.parseInt(input, 2);
            } else if (radioOctal.isChecked()) {
                number = Integer.parseInt(input, 8);
            } else if (radioHexadecimal.isChecked()) {
                number = Integer.parseInt(input, 16);
            }

            if (checkBinario.isChecked()) {
                showConversionResult("Binario: " + Integer.toBinaryString(number));
            }
            if (checkOctal.isChecked()) {
                showConversionResult("Octal: " + Integer.toOctalString(number));
            }
            if (checkHexadecimal.isChecked()) {
                showConversionResult("Hexadecimal: " + Integer.toHexString(number));
            }
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Número inválido", Toast.LENGTH_SHORT).show();
        }
    }

    private void showConversionResult(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
