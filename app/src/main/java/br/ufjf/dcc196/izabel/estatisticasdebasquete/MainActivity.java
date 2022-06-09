package br.ufjf.dcc196.izabel.estatisticasdebasquete;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textViewPontos;
    TextView textViewArremessos;
    TextView textViewBloqueios;
    Button buttonPontosInc;
    Button buttonPontosDec;
    Button buttonArremessosInc;
    Button buttonArremessosDec;
    Button buttonBloqueiosInc;
    Button buttonBloqueiosDec;

    Integer pontos = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewArremessos = findViewById(R.id.textViewArremessos);
        textViewPontos = findViewById(R.id.textViewPontos);
        textViewBloqueios = findViewById(R.id.textViewBloqueios);

        buttonPontosInc = findViewById(R.id.buttonPontosInc);
        buttonPontosDec = findViewById(R.id.buttonPontosDec);

        buttonArremessosInc = findViewById(R.id.buttonArremessosInc);
        buttonArremessosDec = findViewById(R.id.buttonArremessosDec);

        buttonBloqueiosInc = findViewById(R.id.buttonBloqueiosInc);
        buttonBloqueiosDec = findViewById(R.id.buttonBloqueiosDec);

        textViewPontos.setText(pontos.toString());
    }

    public void onButtonClick(View view){
        switch (view.getId()){
            case R.id.buttonPontosInc:
                pontos ++;
                textViewPontos.setText(pontos.toString());
                break;

            case R.id.buttonPontosDec:
                if (pontos>0)
                pontos--;
                textViewPontos.setText(pontos.toString());
        }
    }


}