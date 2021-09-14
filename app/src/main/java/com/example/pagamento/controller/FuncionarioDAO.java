package com.example.pagamento.controller;

import com.example.pagamento.model.Funcionario;

import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {

    private static List<Funcionario> lista = new ArrayList<>();

    public void salvar(Funcionario funcionario) { lista.add(funcionario); }

    public void excluir(int position) { lista.remove(position);}

    public Funcionario getFuncionario(int position) { return lista.get(position); }

    //retornar Arraylist
    public List<Funcionario> getLista() { return lista; }
}
