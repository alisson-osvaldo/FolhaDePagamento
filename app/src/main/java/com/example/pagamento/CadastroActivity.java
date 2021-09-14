package com.example.pagamento;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pagamento.controller.FuncionarioDAO;
import com.example.pagamento.model.Funcionario;

public class CadastroActivity extends AppCompatActivity {

    EditText etNome;
    EditText etHrTrabalhada;
    EditText etValorHr;
    Button bSalvar;

    FuncionarioDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        etNome         = findViewById(R.id.etNome);
        etHrTrabalhada = findViewById(R.id.etHrTrabalhada);
        etValorHr      = findViewById(R.id.etValorHr);
        bSalvar        = findViewById(R.id.bSalvar);

        dao = new FuncionarioDAO();

        bSalvar.setOnClickListener(v -> {
            if(etNome.getText().toString().isEmpty() ||
               etHrTrabalhada.getText().toString().isEmpty() ||
               etValorHr.getText().toString().isEmpty()) {
                Toast.makeText(this, "Por favor, preencha todos os campos...", Toast.LENGTH_SHORT).show();
            } else {
                //float SalarioBruto = Float.parseFloat(etSalarioBruto.getText().toString());
                //float ir = Float.parseFloat(etIR.getText().toString());

                Funcionario funcionario = new Funcionario(
                        etNome.getText().toString(),
                        Integer.parseInt(etHrTrabalhada.getText().toString()),
                        Float.parseFloat(etValorHr.getText().toString())
                );

                dao.salvar(funcionario);

                Toast.makeText(this, "Contato salvo com sucesso!", Toast.LENGTH_SHORT).show();

                finish();
            }
        });
    }
}