package br.pdm.klebson.lostboard;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Activity_perdi_minha_placa extends AppCompatActivity implements View.OnClickListener{

    //declara os editText que será utilizado para passagemde parametro
    //declara os button

    private EditText editText_nome, editText_telefone, editText_placa;
    private EditText editText_cidadeDaPlaca, editText_dataDaPerda, editText_localDaPerda, editText_observação;

    private Button button_cadastrarPerdiMinhaPlaca;
    private Button button_cancelarPerdiMinhaPlaca;

    private Handler handler = new Handler();
    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_perdi_minha_placa);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        editText_nome = (EditText) findViewById(R.id.editText_nome);
        editText_telefone = (EditText) findViewById(R.id.editText_telefone);
        editText_placa = (EditText) findViewById(R.id.editText_placa);


        editText_cidadeDaPlaca = (EditText) findViewById(R.id.editText_cidadeDaPlaca);
        editText_dataDaPerda = (EditText) findViewById(R.id.editText_dataDaPerda);
        editText_localDaPerda = (EditText) findViewById(R.id.editText_localDaPerda);
        editText_observação = (EditText) findViewById(R.id.editText_observação);

        button_cadastrarPerdiMinhaPlaca = (Button) findViewById(R.id.button_cadastrarPerdiMinhaPlaca);
        button_cancelarPerdiMinhaPlaca = (Button) findViewById((R.id.button_cancelarEncontreiUmaPlaca));

        button_cadastrarPerdiMinhaPlaca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               dialog = new ProgressDialog(this);
                dialog.setMessage("Processando... ");
                dialog.setTitle("Conectando WebService!!");
                dialog.show();

                Thread t = new Thread(this);
                t.start();
            }
        });

    }
/*
    public void onClick(View view){
        //classe responsável por charmar outra tela intent
        Intent it = new Intent(this, MainHome.class);
        startActivity(it);

        finish(); // método para finalizar uma actvity
    }
*/

    @Override
    public void run() {

        String editText_nome = Integer.parseInt(editText_nome.getText().toString());
                editText_telefone, editText_placa;
        int valor1 = Integer.parseInt(edtValor1.getText().toString());
        int valor2 = Integer.parseInt(edtValor2.getText().toString());

        try {
            CalculatorWS ws = new CalculatorWS();
            //chamada para o webservice
            final int resultado = ws.add(valor1, valor2);

            handler.post(new Runnable(){

                @Override
                public void run(){
                    txtResultado.setText("Resultado: " + resultado);
                }


            });

        }catch (Exception ex){
            Log.e("teste_werb service", "Erro", ex);

        }
        finally{
            dialog.dismiss();
        }



    }
}
