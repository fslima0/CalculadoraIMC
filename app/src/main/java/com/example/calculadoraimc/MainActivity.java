package com.example.calculadoraimc;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText peso;
    EditText altura;
    TextView imc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        peso = findViewById(R.id.peso);
        altura = findViewById(R.id.altura);
        imc = findViewById(R.id.imc);

        Button bt = findViewById(R.id.calcular);

        bt.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onClick(View view) {
                double n1 = Double.parseDouble(peso.getText().toString());
                double n2 = Double.parseDouble(altura.getText().toString());
                double resultado = n1/(n2*n2);

                imc.setText(String.format("%.1f", resultado));


                if (resultado < 17) {
                    Toast.makeText(getApplicationContext(), "Muito abaixo do peso", Toast.LENGTH_SHORT).show();
                }
                else if (resultado > 17 && resultado < 18.49) {
                    Toast.makeText(getApplicationContext(), "Abaixo do peso", Toast.LENGTH_SHORT).show();
                }
                else if (resultado > 18.5 && resultado < 24.99) {
                    Toast.makeText(getApplicationContext(), "Peso normal", Toast.LENGTH_SHORT).show();
                }
                else if (resultado > 25 && resultado < 29.99) {
                    Toast.makeText(getApplicationContext(), "Acima do peso", Toast.LENGTH_SHORT).show();
                }
                else if (resultado > 30 && resultado < 34.99) {
                    Toast.makeText(getApplicationContext(), "Obesidade I", Toast.LENGTH_SHORT).show();
                }
                else if (resultado > 35 && resultado < 39.99) {
                    Toast.makeText(getApplicationContext(), "Obesidade II (severa)", Toast.LENGTH_SHORT).show();
                }
                else if (resultado > 40){
                    Toast.makeText(getApplicationContext(), "Obesidade III (mórbida)", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void limpar(View view) {
        peso.setText("");
        altura.setText("");
        imc.setText("0.0");
    }
}
