package model;

import java.util.ArrayList;
import java.util.List;

public class Aluno {

    private String nome;
    private List<Double> notas = new ArrayList<>();

    public Aluno() {
        super();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome.length() == 0  || nome.length() > 100) throw new RuntimeException("Nome inválido!!");
        this.nome = nome;
    }

    public List<Double> getNotas() {
        return notas;
    }

    public void entraNota(Double nota) {
        if (nota < 0.0 || nota > 30.0) throw new RuntimeException("Nota inválida!!");
        if (retornaNotaTotal() == 100) throw new RuntimeException("O valor total da nota já atingiu o maximo permitido(100)!!");
        if ((retornaNotaTotal() + nota) > 100.0) throw new RuntimeException("O valor total da nota não pode ser maior que 100!!");
        notas.add(nota);
    }

    public Double retornaNotaTotal() {
        return notas.stream().reduce(0.0, Double::sum);
    }

}
