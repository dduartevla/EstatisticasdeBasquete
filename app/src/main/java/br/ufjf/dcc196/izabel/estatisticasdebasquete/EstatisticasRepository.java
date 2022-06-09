package br.ufjf.dcc196.izabel.estatisticasdebasquete;

import android.content.Context;
import android.content.SharedPreferences;

public class EstatisticasRepository {

    private Context context;
    private SharedPreferences preferences;
    private final String PREFERENCES_NAME = "br.ufjf.dcc196.izabel.estatisticasbasquete";
    private final String PONTOS_KEY = "PONTOS_KEY";

    public EstatisticasRepository(Context context){
        this.context = context;
        preferences = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
    }

    public Integer getPontos(){
        return preferences.getInt(PONTOS_KEY,0);
    }

    public void incPontos(){
        Integer pontos = getPontos() + 1;
        setPontos(pontos);
    }

    public void decPontos(){
        Integer pontos = getPontos() - 1;
        setPontos(pontos);
    }

    public void setPontos(Integer pontos){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(PONTOS_KEY, pontos);
        editor.apply();
        editor.apply();
    }
}
