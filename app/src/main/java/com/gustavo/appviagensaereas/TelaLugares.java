package com.gustavo.appviagensaereas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class TelaLugares extends AppCompatActivity {

    private RadioGroup rgEdim;
    private RadioButton rbEdim;

    private RadioGroup rgCidCabo;
    private RadioButton rbCidCabo;

    private RadioGroup rgPortoGali;
    private RadioButton rbPortoGali;

    private RadioGroup rgCataratas;
    private RadioButton rbCataratas;

    private RadioGroup rgFortaleza;
    private RadioButton rbFortaleza;

    //SPINNER

    private Spinner spinnerHoteis;

    //

    private Button btProximo;

    private Cliente c1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_lugares);

        editarViagem();
        enviarDados();
    }

    public void editarViagem() {
        rgEdim = (RadioGroup) findViewById(R.id.rgEdim);
        rbEdim = (RadioButton) findViewById(R.id.rbEdim);

        rgCidCabo = (RadioGroup) findViewById(R.id.rgCidCabo);
        rbCidCabo = (RadioButton) findViewById(R.id.rbCidCabo);

        rgPortoGali = (RadioGroup) findViewById(R.id.rgPortoGali);
        rbPortoGali = (RadioButton) findViewById(R.id.rbPortGali);

        rgCataratas = (RadioGroup) findViewById(R.id.rgCataratas);
        rbCataratas = (RadioButton) findViewById(R.id.rbCataratas);

        rgFortaleza = (RadioGroup) findViewById(R.id.rgFortaleza);
        rbFortaleza = (RadioButton) findViewById(R.id.rbFortaleza);

        //SPINNER

        spinnerHoteis = (Spinner) findViewById(R.id.spinnerHoteis);

        //

        btProximo = (Button) findViewById(R.id.btProximo);

        c1 = new Cliente();

        spinnerHoteis.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView adapterView, View view, int position, long l) {
                if (position == 0) {
                    Toast.makeText(getBaseContext(), "Selecione um hotel",
                            Toast.LENGTH_LONG).show();
                    btProximo.setVisibility(View.INVISIBLE);
                } else if (position == 1) {
                    btProximo.setVisibility(View.VISIBLE);
                } else if (position == 2) {
                    btProximo.setVisibility(View.VISIBLE);
                } else if (position == 3) {
                    btProximo.setVisibility(View.VISIBLE);
                } else if (position == 4) {
                    btProximo.setVisibility(View.VISIBLE);
                } else if (position == 5) {
                    btProximo.setVisibility(View.VISIBLE);
                } else if (position == 6) {
                    btProximo.setVisibility(View.VISIBLE);
                } else if (position == 7) {
                    btProximo.setVisibility(View.VISIBLE);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        }); //fecha o spinner

        btProximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                c1.setHotel((String)spinnerHoteis.getSelectedItem().toString());
            }
        });

    }// fecha o editar viagem

        public void enviarDados(){
            btProximo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    c1 = new Cliente();

                    if (rgEdim.getCheckedRadioButtonId() == R.id.rbEdim) {
                        c1.setLugar(rbEdim.getText().toString());
                    } else {
                    }

                    if (rgCidCabo.getCheckedRadioButtonId() == R.id.rbCidCabo) {
                        c1.setLugar(rbCidCabo.getText().toString());
                    } else {
                    }

                    if (rgPortoGali.getCheckedRadioButtonId() == R.id.rbPortGali) {
                        c1.setLugar(rbPortoGali.getText().toString());
                    } else {

                    }

                    if (rgCataratas.getCheckedRadioButtonId() == R.id.rbCataratas) {
                        c1.setLugar(rbCataratas.getText().toString());
                    } else {

                    }

                    if (rgFortaleza.getCheckedRadioButtonId() == R.id.rbFortaleza) {
                        c1.setLugar(rbFortaleza.getText().toString());
                    } else {

                    }

                    c1.setHotel((String) spinnerHoteis.getSelectedItem().toString());

                    Intent it = new Intent(TelaLugares.this, TelaVisualizacao.class);
                    it.putExtra("cliente", c1);
                    startActivity(it);
                }
            });
        }
    }

