package controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;

import model.Avaliacao;

public class AvaliacaoService {
    
    static BufferedReader leitor;
    
    public static void Avaliacao(Hashtable<String,Avaliacao>aval){
        
        try{
            leitor= new BufferedReader(new FileReader("avaliações.csv"));
            String linha = null;

            while((linha=leitor.readLine())!=null){
               linha.trim();
               String dividir[] = linha.split(";");
               String id = dividir[0];
               String nome = dividir[1];
               String avaliacao = dividir[2];
               String key = id+nome;
               Avaliacao aux = new Avaliacao(id,nome,avaliacao);
               aval.put(key,aux);
            }
            leitor.close();
        }catch(FileNotFoundException file){
            System.out.println("Arquivo não encontrado");
        }catch(IOException e){
            System.out.println("Erro ao ler o arquivo");
        }catch(IndexOutOfBoundsException i){
            System.out.println("Erro no Index");
        }

    }
}

