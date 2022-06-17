package br.ufjf.dcc196.izabel.estatisticasdebasquete;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SharedPreferences.OnSharedPreferenceChangeListener {

    TextView textViewPontos;
    TextView textViewArremessos;
    TextView textViewBloqueios;
    Button buttonPontosInc;
    Button buttonPontosDec;
    Button buttonArremessosInc;
    Button buttonArremessosDec;
    Button buttonBloqueiosInc;
    Button buttonBloqueiosDec;


    EstatisticasRepository repo;
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

        repo = new EstatisticasRepository(getApplicationContext());
        textViewPontos.setText(repo.getPontos().toString());

    }

    public void onButtonClick(View view){
        switch (view.getId()){
            case R.id.buttonPontosInc:
                repo.incPontos();
                System.out.println("pontos");
                textViewPontos.setText(repo.getPontos().toString());
                break;

            case R.id.buttonPontosDec:
                if (repo.getPontos() >0)
                    repo.decPontos();
                textViewPontos.setText(repo.getPontos().toString());
                break;

            case R.id.buttonArremessosInc:
                repo.incArremessos();
                System.out.println(repo.getArremessos() + "repoIncA");
                textViewArremessos.setText(repo.getArremessos().toString());
                break;

            case R.id.buttonArremessosDec:
                if(repo.getArremessos() > 0)
                   repo.decArremessos();
                System.out.println(repo.getArremessos() + "repoDecA");
                textViewArremessos.setText(repo.getArremessos().toString());
                break;

            case R.id.buttonBloqueiosInc:
                repo.incBloqueios();
                textViewBloqueios.setText(repo.getBloqueios().toString());
                break;

            case R.id.buttonBloqueiosDec:
                if (repo.getBloqueios() >0)
                    repo.decBloqueios();
                textViewBloqueios.setText(repo.getBloqueios().toString());
                break;
        }
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key){
        switch (key){
            case EstatisticasRepository.PONTOS_KEY:
                textViewPontos.setText(repo.getPontos().toString());
                break;

            case EstatisticasRepository.ARREMESSOS_KEY:
                textViewBloqueios.setText(repo.getArremessos().toString());
                break;

            case EstatisticasRepository.BLOQUEIOS_KEY:
                textViewBloqueios.setText(repo.getBloqueios().toString());
                break;
        }
    }

}