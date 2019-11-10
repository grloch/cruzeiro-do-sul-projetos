package principal;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Scanner;

public class Auxiliar {

    public static String checaBoolean(boolean var) {
        if (var) {
            return "Sim";
        } else {
            return "Não";
        }
    }

    public static void saveArray(ArrayList array, String filename) {
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("Data/" + filename + ".txt", true), "UTF-8"))) {
            for (int i = 0; i < array.size(); i++) {
                writer.write(array.get(i).toString() + ",");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        System.out.println(array.size() + " " + filename + " salvos em Data/" + filename + ".txt");
    }

    public static void saveArray(String strToSave, String filename) {
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("Data/" + filename + ".txt", true), "UTF-8"))) {

            writer.write(strToSave + ",");

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        System.out.println("produto " + filename + " acrescentado em Data/" + filename + ".txt");
    }

    public static ArrayList loadProduto(String type) throws IOException {
        boolean debug = true;
        if (type == "papel") {
            ArrayList<Papel> output = new ArrayList<Papel>();
            Scanner raw = new Scanner(new File("Data/papel.txt")).useDelimiter(",");
            ArrayList<String> rawString = new ArrayList<String>();

            while (raw.hasNext()) {
                rawString.add(raw.next());
            }
            raw.close();

            for (int i = 0; i < rawString.size(); i = i + 8) {
                output.add(new Papel(
                        rawString.get(i), //marca
                        Float.parseFloat(rawString.get(i + 1)), //valor
                        rawString.get(i + 2), //cor
                        rawString.get(i + 3), //tipo
                        Float.parseFloat(rawString.get(i + 4)), //largura
                        Float.parseFloat(rawString.get(i + 5)), //altura
                        Integer.parseInt(rawString.get(i + 6)), //gramatura
                        Boolean.parseBoolean((rawString.get(i + 7))) //paltado
                ));

            }
            if (debug) {
                System.out.println("Produtos " + type + " carregou, número de produtos carregados: " + +(output.size() - 1));
            }
            return output;
        } else if (type == "caderno") {
            ArrayList<Caderno> output = new ArrayList<Caderno>();
            Scanner raw = new Scanner(new File("Data/caderno.txt")).useDelimiter(",");
            ArrayList<String> rawString = new ArrayList<String>();

            while (raw.hasNext()) {
                rawString.add(raw.next());
            }
            raw.close();

            for (int i = 0; i < rawString.size(); i = i + 6) {
                output.add(
                        new Caderno(
                                rawString.get(i), //marca
                                Float.parseFloat(rawString.get(i + 1)), //valor
                                Integer.parseInt(rawString.get(i + 2)), //folhas
                                rawString.get(i + 3), //tamanho
                                rawString.get(i + 4), //tipo
                                Boolean.parseBoolean(rawString.get(i + 5)) //capa dura
                        )
                );
            }
            if (debug) {
                System.out.println("Produtos " + type + " carregou, número de produtos carregados: " + (output.size() - 1));
            }
            return output;
        } else if (type == "caixaLapis") {
            ArrayList<CaixaLapis> output = new ArrayList<CaixaLapis>();
            Scanner raw = new Scanner(new File("Data/caixaLapis.txt")).useDelimiter(",");
            ArrayList<String> rawString = new ArrayList<String>();

            while (raw.hasNext()) {
                rawString.add(raw.next());
            }
            raw.close();

            for (int i = 0; i < rawString.size(); i = i + 4) {
                output.add(
                        new CaixaLapis(
                                rawString.get(i), //marca
                                Float.parseFloat(rawString.get(i + 1)), //valor
                                Integer.parseInt(rawString.get(i + 2)), //qtdefolhas
                                Boolean.parseBoolean(rawString.get(i + 3))) //colorido
                );
            }
            if (debug) {
                System.out.println("Produtos " + type + " carregou, número de produtos carregados: " + (output.size() - 1));
            }
            return output;
        }
        return null;
    }

    public static ArrayList loadCliente() throws FileNotFoundException {
        boolean debug = true;

        ArrayList<Cliente> output = new ArrayList<Cliente>();
        Scanner raw = new Scanner(new File("Data/clientes.txt")).useDelimiter(",");
        ArrayList<String> rawString = new ArrayList<String>();

        while (raw.hasNext()) {
            rawString.add(raw.next());
        }
        raw.close();

        for (int i = 0; i < rawString.size(); i = i + 3) {
            output.add(
                    new Cliente(rawString.get(i), rawString.get(i + 1), rawString.get(i + 2))
            );
        }
        if (debug) {
            System.out.println("Clientes carregados: " + (output.size() - 1));
        }
        return output;
    }

    public static ArrayList loadPedidos() throws FileNotFoundException, IOException {
        boolean debug = true;

        ArrayList<Pedido> output = new ArrayList<Pedido>();
        Scanner raw = new Scanner(new File("Data/pedidos.txt")).useDelimiter(",");
        ArrayList<String> rawString = new ArrayList<String>();

        while (raw.hasNext()) {
            rawString.add(raw.next());
        }
        raw.close();

        for (int i = 0; i < rawString.size(); i++) {
            output.add(new Pedido(
                    rawString.get(i), //data
                    rawString.get(++i), //cpf cliente
                    rawString.get(++i), //raw papel
                    rawString.get(++i), //raw caderno
                    rawString.get(++i) //raw caixa lapis
            ));
        }
        if (debug) {
            System.out.println("Pedidos carregados: " + (output.size() - 1));
        }
        return output;
    }
}
