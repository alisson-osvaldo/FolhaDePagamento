package com.example.pagamento.model;

public class Funcionario {

    private String nome;
    private int hrTrabalhada;
    private float valorHr;
    private float salarioBruto;
    private float ir;
    private float inss;
    private float fgts;
    private float salarioLiquido;

    public Funcionario() { }

    //Get and Set
    public Funcionario(String nome, int hrTrabalhada, float valorHr) {
        this.nome = nome;
        this.hrTrabalhada = hrTrabalhada;
        this.valorHr = valorHr;
    }


    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public int getHrTrabalhada() {
        return hrTrabalhada;
    }

    public void setHrTrabalhada(int hrTrabalhada) {
        this.hrTrabalhada = hrTrabalhada;
    }

    public float getValorHr() {
        return valorHr;
    }

    public void setValorHr(float valorHr) { this.valorHr = valorHr; }

    public float getSalarioBruto() { return salarioBruto; }

    public void setSalarioBruto(float salarioBruto) { this.salarioBruto = salarioBruto; }

    public float getIr() { return ir; }

    public void setIr(float ir) { this.ir = ir; }

    public float getInss() { return inss; }

    public void setInss(float inss) { this.inss = inss; }

    public float getFgts() { return fgts; }

    public void setFgts(float fgts) { this.fgts = fgts; }

    public float getSalarioLiquido() { return salarioLiquido; }

    public void setSalarioLiquido(float salarioLiquido) { this.salarioLiquido = salarioLiquido; }

    @Override
    public String toString() { return this.nome; }

    //Calculo do Salario Bruto
    public void calculoSalarioBruto(){
        salarioBruto = hrTrabalhada * valorHr;
    }

    //Calculo do IR
    public void calcularIR(){
        if(salarioBruto <= 1372.81f){
            ir = 0;
        } else if ( salarioBruto <= 2743.25f){
            ir = salarioBruto * 0.15f;
        } else {
            ir = salarioBruto * 0.275f; //ou 27.5f ????
        }
    }

    //Calculo do INSS
    public void calculoINSS(){
        if(salarioBruto <= 868.29f){
            inss = salarioBruto * 0.08f;
        } else if(salarioBruto <= 1147.14f){
            inss = salarioBruto * 0.09f;
        } else if(salarioBruto <= 2894.28f){
            inss = salarioBruto * 0.11f;
        } else {
            inss = 318.37f;
        }
    }

    //Calculo do FGTS
    public void calculoFGTS(){
        fgts = salarioBruto * 0.08f;
    }

    //Calculo Salario Liquido
    public void calculoSalarioLiquido(){
        salarioLiquido = salarioBruto - ir - inss;
    }

}
