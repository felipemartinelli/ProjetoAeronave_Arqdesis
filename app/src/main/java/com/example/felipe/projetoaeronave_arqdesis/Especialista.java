package com.example.felipe.projetoaeronave_arqdesis;

import java.util.ArrayList;
import java.util.TreeSet;

public class Especialista {
    private static final ArrayList<Voo> voos = cadastroDeVoos();

    public Especialista() {

    }


    public TreeSet<Voo> listarVoos(String origem, String destino) {
        TreeSet<Voo> lista = new TreeSet<Voo>();

        if (origem.length() > 0 && destino.length() > 0 ) {
            lista = buscarOrigemDestino(origem, destino);
        } else if (origem.length() > 0 ) {
            lista = buscarOrigem(origem);
        } else if (destino.length() > 0) {
            lista = buscarDestino(destino);
        } else {
            lista = todas();
        }

        return lista;
    }


    private TreeSet<Voo> buscarOrigem(String origem) {
        TreeSet<Voo> lista = new TreeSet<Voo>();
        for (Voo voo : voos) {
            if (origem.equals(voo.getOrigem())) {
                lista.add(voo);
            }
        }
        return lista;
    }

    private TreeSet<Voo> buscarDestino(String destino) {
        TreeSet<Voo> lista = new TreeSet<Voo>();
        for (Voo voo : voos) {
            if (destino.equals(voo.getDestino())) {
                lista.add(voo);
            }
        }
        return lista;
    }


    private TreeSet<Voo> buscarOrigemDestino(String origem, String destino) {
        TreeSet<Voo> lista = new TreeSet<Voo>();
        for (Voo voo : voos) {
            if (origem.equals(voo.getOrigem())
                    && destino.equals(voo.getDestino())) {
                lista.add(voo);
            }
        }
        return lista;
    }



    private TreeSet<Voo> todas() {
        TreeSet<Voo> lista = new TreeSet<Voo>();
        for (Voo voo : voos) {
            lista.add(voo);
        }
        return lista;
    }

    private static ArrayList<Voo> cadastroDeVoos() {
        ArrayList<Voo> voos = new ArrayList<Voo>();
        voos.add(new Voo("Congonhas", "Minas Gerais", "13:00",  "aviao001", 150.00));
        voos.add(new Voo("Congonhas", "Bahia", "16:00", "aviao001", 150.00));
        voos.add(new Voo("Minas Gerais", "Espirito Santo", "15:00", "aviao001", 150.00));
        voos.add(new Voo("Minas Gerais", "Brasilia", "19:00", "aviao001", 150.00));
        voos.add(new Voo("Espirito Santo", "Pernambuco", "12:00", "aviao001", 150.00));
        voos.add(new Voo("Espirito Santo", "Congonhas", "10:00", "aviao001", 150.00));
        voos.add(new Voo("Bahia", "Minas Gerais", "18:00", "aviao001", 150.00));
        voos.add(new Voo("Bahia", "Brasilia", "19:00", "aviao001", 150.00));
        voos.add(new Voo("Pernambuco", "Espirito Santo", "09:00", "aviao001", 150.00));
        voos.add(new Voo("Pernambuco", "Congonhas", "14:00", "aviao001", 150.00));
        voos.add(new Voo("Brasilia", "Bahia", "18:00", "aviao001", 150.00));
        voos.add(new Voo("Brasilia", "Congonhas", "15:00", "aviao001", 150.00));



        return voos;
    }
}