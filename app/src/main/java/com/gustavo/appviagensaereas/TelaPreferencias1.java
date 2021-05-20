package com.gustavo.appviagensaereas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class TelaPreferencias1 extends AppCompatActivity {

    private RadioGroup rgTipos;
    private RadioButton rbIda;
    private RadioButton rbIdaVolta;

    private EditText etDate;
    private EditText etDate2;

    private EditText etPesoKg;

    private Button btBuscar;

    Cliente c1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_preferencias1);

        buscarReferencias();
        enviarDados();
    }

    public void buscarReferencias(){
        rgTipos = (RadioGroup) findViewById(R.id.rgTipos);
        rbIda = (RadioButton) findViewById(R.id.rbIda);
        rbIdaVolta = (RadioButton) findViewById(R.id.rbIdaVolta);

        etDate = (EditText) findViewById(R.id.etDate);
        etDate2 = (EditText) findViewById(R.id.etDate2);

        etPesoKg = (EditText) findViewById(R.id.etPesoKg);

        btBuscar = (Button) findViewById(R.id.btBuscar);
    }

    public void enviarDados(){
        btBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                c1 = new Cliente();

                if (rgTipos.getCheckedRadioButtonId() == R.id.rbIda){
                    c1.setViagem(rbIda.getText().toString());
                } else {
                    c1.setViagem(rbIdaVolta.getText().toString());
                }

                c1.setEtDate(etDate.getText().toString());
                c1.setEtDate2(etDate2.getText().toString());
                c1.setEtPesoKg(etPesoKg.getText().toString());

                Intent it = new Intent(TelaPreferencias1.this, TelaLugares.class);
                it.putExtra("cliente", c1);
                startActivity(it);
            }
        });
    }
}