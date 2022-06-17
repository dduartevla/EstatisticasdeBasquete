package br.ufjf.dcc196.izabel.estatisticasdebasquete;

import android.content.Context;
import android.content.SharedPreferences;

public class EstatisticasRepository {

    private Context context;
    private SharedPreferences preferences;
    private final String PREFERENCES_NAME = "br.ufjf.dcc196.izabel.estatisticasbasquete";
    public final static String PONTOS_KEY = "PONTOS_KEY";
    public final static String ARREMESSOS_KEY = "ARREMESSOS_KEY";
    public final static String BLOQUEIOS_KEY = "BLOQUEIOS_KEY";

    public EstatisticasRepository(Context context){
        this.context = context;
        preferences = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
    }

    public Integer getPontos(){
        return preferences.getInt(PONTOS_KEY,0);
    }

    public Integer getArremessos(){
        return preferences.getInt(ARREMESSOS_KEY, 0);
    }

    public Integer getBloqueios(){
        return preferences.getInt(BLOQUEIOS_KEY,0);
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

    public void incArremessos(){
        Integer arremessos = getArremessos() + 1;
        setArremessos(arremessos);
        System.out.println(getArremessos() + "repoIncA");
    }

    public void decArremessos(){
        Integer arremessos = getArremessos() - 1;
        setArremessos(arremessos);
        System.out.println(getArremessos() + "repoDecA");
    }

    public void setArremessos(Integer arremessos){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(ARREMESSOS_KEY, arremessos);
        editor.apply();
        editor.apply();
    }

    public void incBloqueios(){
        Integer bloqueios = getBloqueios() + 1;
        setBloqueios(bloqueios);
    }

    public void decBloqueios(){
        Integer bloqueios = getBloqueios() - 1;
        setBloqueios(bloqueios);
    }

    public void setBloqueios(Integer bloqueios){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(BLOQUEIOS_KEY, bloqueios);
        editor.apply();
        editor.apply();
    }
}
