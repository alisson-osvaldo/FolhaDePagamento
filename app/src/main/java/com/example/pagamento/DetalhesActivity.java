package com.example.pagamento;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.pagamento.controller.FuncionarioDAO;
import com.example.pagamento.model.Funcionario;

import java.util.Locale; // Que permitirá a configuração da localidade.
import java.text.NumberFormat;
import java.util.Locale;


public class DetalhesActivity extends AppCompatActivity {

    TextView tvNome;
    TextView tvSalarioBruto;
    TextView tvIR;
    TextView tvINSS;
    TextView tvFGTS;
    TextView tvSalarioLiquido;

    FuncionarioDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);

        tvNome           = findViewById(R.id.tvNome);
        tvSalarioBruto   = findViewById(R.id.tvSalarioBruto);
        tvIR             = findViewById(R.id.tvIR);
        tvINSS           = findViewById(R.id.tvINSS);
        tvFGTS           = findViewById(R.id.tvFGTS);
        tvSalarioLiquido = findViewById(R.id.tvSalarioLiquido);

        dao = new FuncionarioDAO();

        Intent intent = getIntent();

        int position = intent.getIntExtra("position", -1);

        if (position == -1){ finish(); }

        Funcionario funcionario = dao.getFuncionario(position);
        //chamando os métodos dos calculos
        funcionario.calculoSalarioBruto();
        funcionario.calcularIR();
        funcionario.calculoINSS();
        funcionario.calculoFGTS();
        funcionario.calculoSalarioLiquido();
        funcionario.calculoSalarioLiquido();

        //Alimentar nosso TextViews
        tvNome.setText(funcionario.getNome());
        tvSalarioBruto.setText(tvSalarioBruto.getText().toString() + converter(funcionario.getSalarioBruto()));
        tvIR.setText(tvIR.getText().toString() + converter(funcionario.getIr()));
        tvINSS.setText(tvINSS.getText().toString() + converter(funcionario.getInss()));
        tvFGTS.setText(tvFGTS.getText().toString() + converter(funcionario.getFgts()));
       tvSalarioLiquido.setText(tvSalarioLiquido.getText().toString() + converter(funcionario.getSalarioLiquido()));

    }

    //convertendo de float para String e formatando moeda para BR para mostrar no textView
    Locale localBrasil = new Locale("pt", "BR");

    public String converter(float valor){
        String brasil = NumberFormat.getCurrencyInstance(localBrasil).format(valor);
        return brasil;
    }
}