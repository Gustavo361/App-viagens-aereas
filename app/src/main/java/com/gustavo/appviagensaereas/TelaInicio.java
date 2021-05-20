package com.gustavo.appviagensaereas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.security.MessageDigest;

public class TelaInicio extends AppCompatActivity {

    private EditText etNomeLog;
    private EditText etSenhaLog;

    public static String usuario;
    public static String senha;

    private Button btLogar;
    private Button btCadastarSe;

    //
    FirebaseDatabase database;
    DatabaseReference baseRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicio);

        etNomeLog = (EditText) findViewById(R.id.etNomeLog);
        etSenhaLog = (EditText) findViewById(R.id.etSenha);

        btLogar = (Button) findViewById(R.id.btLogar);
        btCadastarSe = (Button) findViewById(R.id.btCadastrarSe);

        btCadastarSe.setVisibility(View.GONE);

        database = FirebaseDatabase.getInstance();
        baseRef = database.getReference();

        //Buttons

        btCadastarSe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registrar(usuario, senha);
            }
        });

        btLogar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                usuario = etNomeLog.getText().toString();
                senha = etSenhaLog.getText().toString();
                logar(usuario,senha);
            }
        });
    }

    private void logar(final String nomeUsuario, final String senhaUsuario){
        baseRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.child("usuarios").child(nomeUsuario).getValue() == null) {
                    Toast.makeText(TelaInicio.this, "Este usuário não existe. " +
                                    "Caso deseje cadastrar um novo usuário, clique no botão 'Cadastrar-se'",
                            Toast.LENGTH_LONG).show();
                    btCadastarSe.setVisibility(View.VISIBLE);
                } else {
                    if(dataSnapshot.child("usuarios").child(nomeUsuario).child("senha").getValue().equals(md5(senhaUsuario))){
                        proximaTela();
                    } else {
                        Toast.makeText(TelaInicio.this, "Senha incorreta!",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void  proximaTela(){
        Intent novaJanela = new Intent(TelaInicio.this, TelaCadastro.class);
        startActivity(novaJanela);
    }

    //

    private  void registrar(final String nomeUsuario, final String senhaUsuario){
        baseRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                baseRef.child("usuarios").child(nomeUsuario).child("nome").setValue(0);
                baseRef.child("usuarios").child(nomeUsuario).child("idade").setValue(0);
                baseRef.child("usuarios").child(nomeUsuario).child("email").setValue(0);
                baseRef.child("usuarios").child(nomeUsuario).child("senha").setValue(md5(senhaUsuario));
                baseRef.child("usuarios").child(nomeUsuario).child("cpf").setValue(0);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private static final String md5(final String toEncrypt) {
        try {
            final MessageDigest digest = MessageDigest.getInstance("md5");
            digest.update(toEncrypt.getBytes());
            final byte [] bytes = digest.digest();
            final StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(String.format("%02X", bytes[i]));
            }
            return sb.toString().toLowerCase();
        }catch (Exception exc) {
            return "";
        }
    }
}