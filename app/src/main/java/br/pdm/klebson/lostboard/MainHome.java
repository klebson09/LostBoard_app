package br.pdm.klebson.lostboard;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.content.*;
import android.widget.Button;
import android.widget.Toast;

public class MainHome extends AppCompatActivity implements View.OnClickListener{

    private Button button_PerdiMinhaPlaca;
    private Button button_EncontreiUmaPlaca;
    private Button button_ListaDePlaca;
    private Button button_Informativo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        button_PerdiMinhaPlaca = (Button) findViewById(R.id.button_PerdiMinhaPlaca);
        button_EncontreiUmaPlaca = (Button) findViewById(R.id.button_EncontreiUmaPlaca);
        button_ListaDePlaca = (Button) findViewById(R.id.button_ListaDePlaca);
        button_Informativo = (Button) findViewById(R.id.button_Informativo);

    }
    public void onClick(View view){
        //classe responsável por charmar outra tela intent
        Intent it = new Intent(this, Activity_perdi_minha_placa.class);
        startActivity(it);
    }

    public void clickPerdiMinhaPlaca(View view){

    }

    public void clickEncontreiUmaPlaca(View view){
        //classe responsável por charmar outra tela intent
        Intent it = new Intent(this, Activity_encontrei_uma_placa.class);
        startActivity(it);
    }

    public void clickListaDePlaca(View view){
        //classe responsável por charmar outra tela intent
        Intent it = new Intent(this, Activity_lista_de_placa.class);
        startActivity(it);
    }
    public void clickInformativo(View view){
        //classe responsável por charmar outra tela intent
        Intent it = new Intent(this, Activity_encontrei_uma_placa.class);
        startActivity(it);
    }

    public void clickSoma(View view){
        //classe responsável por charmar outra tela intent
        Intent it = new Intent(this, Activity_teste_web_service.class);
        startActivity(it);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
