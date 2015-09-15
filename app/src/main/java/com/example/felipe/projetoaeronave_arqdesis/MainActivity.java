package com.example.felipe.projetoaeronave_arqdesis;

/**
 * Created by Felipe on 13/09/2015.
 */
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends ActionBarActivity {

    Spinner spinnerOrigem;
    Spinner spinnerDestino;
    Button btnConsultar;
    String origem, destino;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        setupViews();

    }

    private void setupViews() {
        origem = "";
        destino = "";
        btnConsultar = (Button) findViewById(R.id.botao_enviar);
        spinnerOrigem = (Spinner) findViewById(R.id.dropdown_origem);
        spinnerOrigem.setOnItemSelectedListener(new OrigemSelecionado());
        spinnerDestino = (Spinner) findViewById(R.id.dropdown_destino);
        spinnerDestino.setOnItemSelectedListener(new DestinoSelecionada());
        }

    private class OrigemSelecionado implements AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            origem = (String) parent.getItemAtPosition(position);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }

    private class DestinoSelecionada implements AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            destino = (String) parent.getItemAtPosition(position);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }


    // constante static para identificar a mensagem
    public final static String ORIGEM = "com.example.felipe.ORIGEM";
    public final static String DESTINO = "com.example.felipe.DESTINO";
    public final static String MODO = "com.example.felipe.MODO";
    public final static String SIMPLES = "com.example.felipe.SIMPLES";
    public final static String MELHOR = "com.example.felipe.MELHOR";
    //será chamado quando o usuário clicar em enviar
    public void consultarVoo(View view) {
        consultar(view, SIMPLES);
    }

    public void consultarVooMelhor(View view) {
        consultar(view, MELHOR);
    }

    public void consultar(View view, String modo){
        String pOrigem = this.origem.equals("Escolha a origem")?"":origem;
        String pDestino = this.destino.equals("Escolha o destino")?"":destino;


        Intent intent = new Intent(this, ListaVooCompleto.class);
        intent.putExtra(ORIGEM, pOrigem);
        intent.putExtra(DESTINO, pDestino);
        intent.putExtra(MODO, modo);
        startActivity(intent);
    }

}