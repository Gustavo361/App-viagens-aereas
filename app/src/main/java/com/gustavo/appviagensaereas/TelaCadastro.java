package com.gustavo.appviagensaereas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class TelaCadastro extends AppCompatActivity {

    private EditText etNomeCadastro;
    private EditText etIdade;
    private EditText etEmail;
    private EditText etSenha;
    private EditText etCpf;

    private Button btlimpar;
    private Button btCadastrar;

    private FirebaseAuth fAuth;

    FirebaseDatabase database;
    DatabaseReference baseRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro);

        cadastro();
        proximaTela();
        buscarReferencias();
    }

    public void buscarReferencias(){
        etNomeCadastro = findViewById(R.id.etNomeCadastro);
        etIdade = findViewById(R.id.etIdade);
        etEmail = findViewById(R.id.etEmail);
        etSenha = findViewById(R.id.etSenha);
        etCpf = findViewById(R.id.etCpf);

        btlimpar = findViewById(R.id.btLimpar);
        btCadastrar = findViewById(R.id.btCadastrar);

        fAuth = FirebaseAuth.getInstance();

        if(fAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(), TelaVisualizacao.class));
            finish();
        }

    }

    public void cadastro() {
        btCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = etNomeCadastro.getText().toString().trim();
                String idade = etIdade.getText().toString().trim();
                String email = etEmail.getText().toString().trim();
                String password = etSenha.getText().toString().trim();
                String cpf = etCpf.getText().toString().trim();

                if (TextUtils.isEmpty(nome)) {
                    etNomeCadastro.setError("Preencha o campo 'nome'");
                    return;
                }

                if (TextUtils.isEmpty(idade)) {
                    etIdade.setError("Preencha o campo 'idade'");
                    return;
                }

                if (TextUtils.isEmpty(email)) {
                    etEmail.setError("Preencha o campo 'email'");
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    etSenha.setError("Preencha o campo 'senha'");
                    return;
                }

                if (password.length() > 8) {
                    etSenha.setError("Apenas senhas com até 8 caracteres");
                    return;
                }

                if (TextUtils.isEmpty(cpf)) {
                    etCpf.setError("Preencha o campo 'CPF'");
                    return;
                }

                fAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(TelaCadastro.this, "Usuário criado com sucesso!", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), TelaVisualizacao.class));
                        }else{
                            Toast.makeText(TelaCadastro.this, "Erro" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }

    public void proximaTela() {
        btCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(TelaCadastro.this, TelaPreferencias1.class);
                startActivity(it);
            }
        });
    }
}