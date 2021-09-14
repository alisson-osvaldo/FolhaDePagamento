package com.example.pagamento;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.service.controls.actions.FloatAction;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.pagamento.controller.FuncionarioDAO;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    ListView lvFuncionarios;
    FloatingActionButton fabNovo;

    FuncionarioDAO dao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvFuncionarios = findViewById(R.id.lvFuncionarios);
        fabNovo = findViewById(R.id.fabNovo);

        dao = new FuncionarioDAO();

        //Ação de click do button
        fabNovo.setOnClickListener(v -> {
            startActivity(new Intent(this, CadastroActivity.class));
        });

        //A ação de click dos elementos da lista
        lvFuncionarios.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(this, DetalhesActivity.class);
            intent.putExtra("position", position);
            startActivity(intent);
        });

        //Ação de click longo dos elementos da lista
        lvFuncionarios.setOnItemLongClickListener((parent, view, position, id) -> {
            dao.excluir(position);
            Toast.makeText(this, "Folha de pagamento excluido!", Toast.LENGTH_SHORT).show();
            onResume();
            return false;
        });

    }

    @Override
    protected void onResume() {
        super.onResume();

        lvFuncionarios.setAdapter(new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                dao.getLista()
        ));

    }
}