package br.pdm.klebson.lostboard;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class Activity_encontrei_uma_placa extends AppCompatActivity {

    private Button button_cadastrarEncontreiUmaPlaca;
    private Button button_cancelarEncontreiUmaPlaca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encontrei_uma_placa);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        button_cadastrarEncontreiUmaPlaca = (Button)findViewById (R.id.button_cadastrarEncontreiUmaPlaca);
        button_cadastrarEncontreiUmaPlaca = (Button)findViewById (R.id.button_cancelarEncontreiUmaPlaca);

    }

    public void onClick(View view){
        //classe responsável por charmar outra tela intent
        Intent it = new Intent(this, MainHome.class);
        startActivity(it);

        finish(); // método para finalizar uma actvity
    }

}
