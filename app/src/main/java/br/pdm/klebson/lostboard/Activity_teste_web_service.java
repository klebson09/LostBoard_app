package br.pdm.klebson.lostboard;

import android.app.ProgressDialog;
import android.media.tv.TvContract;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.*;

import java.util.logging.LogRecord;

public class Activity_teste_web_service extends AppCompatActivity implements GridView.OnClickListener, Runnable{

//teste web service
    private EditText edtValor1;
    private EditText edtValor2;
    private Button btnCalcular;
    private TextView txtResultado;

    private Handler handler = new Handler();
    private ProgressDialog dialog;
//fim do teste



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teste_web_service);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //recuperar as referencias
        edtValor1 = (EditText) findViewById(R.id.edtValor1);
        edtValor2 =(EditText) findViewById(R.id.edtValor2);
        txtResultado =(TextView) findViewById(R.id.txtResultado);
        btnCalcular = (Button) findViewById(R.id.btnCalcular);


        btnCalcular.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        dialog = new ProgressDialog(this);
        dialog.setMessage("Processando... ");
        dialog.setTitle("Teste com WebService");
        dialog.show();

        Thread t = new Thread(this);
        t.start();

    }

    @Override
    public void run() {

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
