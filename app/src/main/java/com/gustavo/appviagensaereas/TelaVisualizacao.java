package com.gustavo.appviagensaereas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;


public class TelaVisualizacao extends AppCompatActivity {

    private TextView tvResTipoViag;
    private TextView tvResData1;
    private TextView tvResData2;
    private TextView tvResPesoBag;
    private TextView cbResLugar;
    private TextView tvResSpinnerHotel;

    private Cliente c1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_visualizacao);

        buscarReferencias();
        preencherDados();
    }

    public void buscarReferencias(){
        tvResTipoViag = (TextView) findViewById(R.id.tvResTipoViag);
        tvResData1 = (TextView) findViewById(R.id.tvResData1);
        tvResData2 = (TextView) findViewById(R.id.tvResData2);
        tvResPesoBag = (TextView) findViewById(R.id.tvResPesoBag);
        cbResLugar = (TextView) findViewById(R.id.cbResLugar);
        tvResSpinnerHotel = (TextView) findViewById(R.id.tvResSpinnerHotel);
    }

    public void preencherDados(){
        //tipo da viagem RadioButtons

        c1 = new Cliente();

        Bundle b1 = getIntent().getExtras();

        c1 = (Cliente) b1.getSerializable("cliente");

        //ida ou ida e volta

        if(c1.getViagem().equals("Ida")){
            tvResTipoViag.setText(c1.getViagem());
        } else {
            tvResTipoViag.setText(c1.getViagem());
        }

        //datas

        tvResData1.setText(c1.getEtDate());
        tvResData2.setText(c1.getEtDate2());

        //peso

        tvResPesoBag.setText(c1.getEtPesoKg());

        //lugar

        if(c1.getLugar().equals("Edimburgo, Escócia")){
            cbResLugar.setText(c1.getLugar());
        } else{}

        if(c1.getLugar().equals("Cidade do cabo, África do Sul")){
            cbResLugar.setText(c1.getLugar());
        }else{}

        if(c1.getLugar().equals("Porto de galinhas, BH")){
            cbResLugar.setText(c1.getLugar());
        } else {}

        if (c1.getLugar().equals("Cataratas do Iguaçu, PR")){
            cbResLugar.setText(c1.getLugar());
        }

        if (c1.getLugar().equals("Fortaleza, CE")){
            cbResLugar.setText(c1.getLugar());
        }else{}

        //hotel

        tvResSpinnerHotel.setText(c1.getHotel());
    }
}