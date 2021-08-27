package view;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Scanner;

import model.*;
import controller.*;

public class Status {
   
    public static void leitor( Hashtable<String, Avaliacao> hashAval){
        AvaliacaoService.Avaliacao(hashAval);
    }

    public static void InserirAval(Scanner teclado,Hashtable<String, Avaliacao> hashAval) throws IOException{
    
        System.out.println("\nInforme o Identificador: ");
        System.out.println("\nExemplo :ICN-IARIA");
        String id = teclado.nextLine();
        
        System.out.println("\nInforme o Titulo : ");
        System.out.println("\nExemplo :IARIA International Conference on Networks ");
        String titulo = teclado.nextLine();
        
        System.out.println("Informe a nova nota :");
        String nota = teclado.nextLine();

        for(Avaliacao aux : hashAval.values()){
            if(aux.getIdentificador().contains(id) && aux.getNome().contentEquals(titulo)){
                aux.setAvaliacao(nota);
            }
        }
        BufferedWriter escreve; 
        try {
                escreve = new BufferedWriter(new FileWriter("avaliaçõesAtualizadas.csv"));
                for(Avaliacao i : hashAval.values()){
                    
                    if(i.getIdentificador().contains(id) && i.getNome().contentEquals(titulo)){
                        //atualizando o arquivo aqui
                        escreve.write(id+";"+titulo+";"+nota); 
                    }else{
                        escreve.write(i.getIdentificador() + ";" + i.getNome() + ";" + i.getAvaliacao());
                    }
                    escreve.write("\n");
                }
            escreve.close();
        }catch(FileNotFoundException a){
            System.out.println("Arquivo não encotrado");
        }catch(NullPointerException b){
            System.out.println("NULL");
        }
    }
    public static void remover(Scanner teclado,Hashtable<String, Avaliacao> hashAval) throws IOException{
       
        System.out.println("\nInforme o Identificador: ");
        System.out.println("\nExemplo :ICN-IARIA");
        String id = teclado.nextLine();
        
        System.out.println("\nInforme o Titulo : ");
        System.out.println("\nExemplo :IARIA International Conference on Networks ");
        String titulo = teclado.nextLine();
       
        for(Avaliacao aux : hashAval.values()){
            if(aux.getIdentificador().contains(id) && aux.getNome().contentEquals(titulo)){
                aux.setAvaliacao("null");
                break;
            }
        }

        BufferedWriter escreve;
        try{
            escreve = new BufferedWriter(new FileWriter("avaliaçõesAtualizadas.csv"));
        
            for(Avaliacao aux : hashAval.values()){
                if(aux.getIdentificador().contains(id) && aux.getNome().contentEquals(titulo)){
                    escreve.write(id+";"+titulo+"; null");
                }else{
                    escreve.write(aux.getIdentificador()+";"+aux.getNome()+";"+aux.getAvaliacao());
                }
                escreve.write("\n");
            }
            escreve.close();
        }catch(NullPointerException e){
            System.out.println("NULL");
        }
    }

    public static void Menu(){
        System.out.println("\nBem vindo ao mini Banco de Dados!");
        System.out.println("---------------------------------");
        System.out.println("1 - Inserir Avaliação            |");
        System.out.println("2 - Remover Avaliação            |");
        System.out.println("0 - Sair                         |");
        System.out.println("---------------------------------");
    }

}