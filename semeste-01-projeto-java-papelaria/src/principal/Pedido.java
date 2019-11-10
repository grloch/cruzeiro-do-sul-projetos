package principal;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static principal.Auxiliar.loadCliente;
import static principal.Auxiliar.loadProduto;
import static principal.Auxiliar.saveArray;

public class Pedido implements Manipulacao {

    private Data data;
    private Cliente cliente;
    private float totalpedido = 0;
    private ArrayList<Papel> listaPapel = new ArrayList<Papel>();
    private ArrayList<Caderno> listaCaderno = new ArrayList<Caderno>();
    private ArrayList<CaixaLapis> listaCaixaLapis = new ArrayList<CaixaLapis>();

    /**
     *
     * @return @throws FileNotFoundException
     * @throws IOException
     */
    @Override
    public boolean cadastro() {
        Pedido novoPedido = null;
        try {
            novoPedido = new Pedido();
        } catch (IOException ex) {
            Logger.getLogger(Pedido.class.getName()).log(Level.SEVERE, null, ex);
        }
        saveArray(novoPedido.toString(), "pedidos");
        int opcao;
        int i = 0;
        while (0 == 0) {
            System.out.println(i);
            i++;
            opcao = Integer.parseInt(JOptionPane.showInputDialog(null, "Pedido cadastrado, deseja cadastrar um novo pedido?\n\n1) SIM    2) NÃO"));

            if (opcao == 1) {
                return true;
            } else if (opcao == 2) {
                return false;
            }
        }
    }

    public String consulta() {
        String outputPapel = "", outputCaderno = "", outputCaixaLapis = "";

        for (int i = 0; i < listaPapel.size(); i++) {
            outputPapel = outputPapel + listaPapel.get(i).consulta() + "\n\n";
        }
        for (int i = 0; i < listaCaderno.size(); i++) {
            outputCaderno = outputCaderno + listaCaderno.get(i).consulta() + "\n\n";
        }
        for (int i = 0; i < listaCaixaLapis.size(); i++) {
            outputCaixaLapis = outputCaixaLapis + listaCaixaLapis.get(i).consulta() + "\n\n";
        }
        System.out.println("\n");
        System.out.println("Pedido - cliente: " + this.cliente.getNome() + "\nData: " + this.data.getData() + "\nComprou:\n\nLista de papéis adquiridos:\n" + outputPapel + "\n\nLista de cadernos adquiridos:\n" + outputCaderno + "\n\nLista de caixas de lápis adquiridas:\n" + outputCaixaLapis);

        return "Consulta Pedido:\n\n"
                + "Data: " + data.toString() + "\nCliente:\n|-Nome: " + cliente.getNome() + "\n|-CPF: " + cliente.getCpf() + "\n|-Telefone: " + cliente.getTelefone() + "\n"
                + "Total do pedido: R$" + totalpedido + "\n(lista de produtos no console)";
    }

    public void calculaTotalPedido() {
        for (int i = 0; i < listaCaixaLapis.size(); i++) {
            totalpedido = totalpedido + listaCaixaLapis.get(i).getValor();
        }
        for (int i = 0; i < listaPapel.size(); i++) {
            totalpedido = totalpedido + listaPapel.get(i).getValor();
        }
        for (int i = 0; i < listaCaderno.size(); i++) {
            totalpedido = totalpedido + listaCaderno.get(i).getValor();
        }

        totalpedido = totalpedido + (totalpedido * 0.18f);
    }

    public Pedido() throws FileNotFoundException, IOException {
        System.out.println("\nRotina de venda iniciada");
        totalpedido = 0;
        ArrayList<Cliente> listaCliente = loadCliente();
        ArrayList<Papel> produtosPapel = loadProduto("papel");
        ArrayList<Caderno> produtosCaderno = loadProduto("caderno");
        ArrayList<CaixaLapis> produtosCaixaLapis = loadProduto("caixaLapis");
        //ArrayList<String> listaProdutos = new ArrayList<>();

        this.data = new Data();
        boolean finalizado = false;

        do {
            int tempCliente = Integer.parseInt(JOptionPane.showInputDialog(null, "Novo pedido:\n" + data.getDia() + "." + data.getMes() + "." + data.getAno() + "\n\nInforme o código do cliente: "));
            if (tempCliente < listaCliente.size()) {
                cliente = new Cliente(listaCliente.get(tempCliente).getNome(), listaCliente.get(tempCliente).getCpf(), listaCliente.get(tempCliente).getTelefone());
                System.out.println("Cliente localizado");
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Cliente " + tempCliente + " não localizado, tente novamente.");
            }
        } while (!finalizado);
        finalizado = false;

        int y = 0;
        do {
            String selector = JOptionPane.showInputDialog(null,
                    "Novo pedido:\n\n"
                    + data.getDia() + "." + data.getMes() + "." + data.getAno() + "\n\n" + "Cliente: " + cliente.getNome() + "\n\n"
                    + "Total do pedido: R$ " + totalpedido
                    + "\n\nInforme um produto para adicionar ao pedido:\n"
                    + "Papel: p-numero\nCaixa de lapis: l-numero\nCaderno: c-numero\nFIM para finalizar");
            if (selector.toLowerCase().equals("fim")) {
                finalizado = true;
            } else {
                Scanner raw = new Scanner(selector).useDelimiter("\\-");
                ArrayList<String> rawString = new ArrayList<String>();

                while (raw.hasNext()) {
                    rawString.add(raw.next());
                }
                raw.close();

                int codProduto = Integer.parseInt(rawString.get(1));

                if (rawString.get(0).toLowerCase().equals("p")) {//localiza papel
                    if (codProduto < produtosPapel.size()) {
                        listaPapel.add(
                                new Papel(
                                        produtosPapel.get(codProduto).getMarca(),
                                        produtosPapel.get(codProduto).getValor(),
                                        produtosPapel.get(codProduto).getCor(),
                                        produtosPapel.get(codProduto).getTipo(),
                                        produtosPapel.get(codProduto).getLargura(),
                                        produtosPapel.get(codProduto).getAltura(),
                                        produtosPapel.get(codProduto).getGramatura(),
                                        produtosPapel.get(codProduto).isPaltado())
                        );
                        this.calculaTotalPedido();
                    } else {
                        JOptionPane.showMessageDialog(null, "Produto papel Cod " + codProduto + " não localizado");
                    }
                } else if (rawString.get(0).toLowerCase().equals("l")) {//localiza caixa lapis
                    if (codProduto < produtosCaixaLapis.size()) {
                        listaCaixaLapis.add(new CaixaLapis(
                                produtosCaixaLapis.get(codProduto).getMarca(),
                                produtosCaixaLapis.get(codProduto).getValor(),
                                produtosCaixaLapis.get(codProduto).getQuantidade(),
                                produtosCaixaLapis.get(codProduto).isColorido()
                        ));
                        this.calculaTotalPedido();
                    } else {
                        JOptionPane.showMessageDialog(null, "Produto papel Cod " + codProduto + " não localizado");
                    }
                } else if (rawString.get(0).toLowerCase().equals("c")) {//localiza caderno
                    //listaCaderno
                    if (codProduto < produtosCaderno.size()) {
                        listaCaderno.add(
                                new Caderno(
                                        produtosCaderno.get(codProduto).getMarca(),
                                        produtosCaderno.get(codProduto).getValor(),
                                        produtosCaderno.get(codProduto).getQtdefolhas(),
                                        produtosCaderno.get(codProduto).getTamanho(),
                                        produtosCaderno.get(codProduto).getTipo(),
                                        produtosCaderno.get(codProduto).isCapadura()
                                ));
                        this.calculaTotalPedido();
                    } else {
                        JOptionPane.showMessageDialog(null, "Produto caderno Cod " + codProduto + " não localizado");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Código de produto inserido (" + rawString.get(0) + ") não localizado");
                }
            }

            if (y > 5) {
                finalizado = true;
            }
        } while (!finalizado);

    }

    public Pedido(String dataString, String cpfCliente, String listaPapelString, String listaCadernoString, String listaCaixaLapisString) throws FileNotFoundException, IOException {
        //ArrayList<Papel> listaPapel = loadProduto("papel");ArrayList<Caderno> listaCaderno = loadProduto("caderno");ArrayList<CaixaLapis> listaCaixaLapis = loadProduto("caixaLapis");
        ArrayList<Cliente> listaCliente = loadCliente();

        Scanner dataRaw = new Scanner(dataString).useDelimiter(";");
        ArrayList<String> dataRawArray = new ArrayList<String>();

        while (dataRaw.hasNext()) {
            dataRawArray.add(dataRaw.next());
        }
        dataRaw.close();

        this.data = new Data(
                Integer.parseInt(dataRawArray.get(0)),
                Integer.parseInt(dataRawArray.get(1)),
                Integer.parseInt(dataRawArray.get(2))
        );

        for (int i = 0; i < listaCliente.size(); i++) {
            if (listaCliente.get(i).getCpf().equals(cpfCliente)) {
                cliente = new Cliente(listaCliente.get(i).getNome(), listaCliente.get(i).getCpf(), listaCliente.get(i).getTelefone());
            }
        }
        if (cliente.getNome() == null) {
            System.out.println("cliente cpf " + cpfCliente + "não localizado");
        }

        if (!listaPapelString.equals("")) {
            Scanner listaPapelRaw = new Scanner(listaPapelString).useDelimiter(";");
            ArrayList<String> listaPapelRawArray = new ArrayList<String>();

            while (listaPapelRaw.hasNext()) {
                listaPapelRawArray.add(listaPapelRaw.next());
            }
            listaPapelRaw.close();

            for (int i = 0; i < listaPapelRawArray.size(); i += 8) {
                listaPapel.add(new Papel(
                        listaPapelRawArray.get(i), //marca
                        Float.parseFloat(listaPapelRawArray.get(i + 1)), //valor
                        listaPapelRawArray.get(i + 2), //cor
                        listaPapelRawArray.get(i + 3), //tipo
                        Float.parseFloat(listaPapelRawArray.get(i + 4)), //largura
                        Float.parseFloat(listaPapelRawArray.get(i + 5)), //altura
                        Integer.parseInt(listaPapelRawArray.get(i + 6)), //gramatura
                        Boolean.parseBoolean((listaPapelRawArray.get(i + 7))) //paltado
                ));

            }
            System.out.println("");
        }

        if (!listaCadernoString.equals("")) {
            Scanner listaCadernoRaw = new Scanner(listaCadernoString).useDelimiter(";");
            ArrayList<String> listaCadernoRawArray = new ArrayList<String>();

            while (listaCadernoRaw.hasNext()) {
                listaCadernoRawArray.add(listaCadernoRaw.next());
            }
            listaCadernoRaw.close();

            for (int i = 0; i < listaCadernoRawArray.size(); i += 6) {
                listaCaderno.add(
                        new Caderno(
                                listaCadernoRawArray.get(i), //marca
                                Float.parseFloat(listaCadernoRawArray.get(i + 1)), //valor
                                Integer.parseInt(listaCadernoRawArray.get(i + 2)), //folhas
                                listaCadernoRawArray.get(i + 3), //tamanho
                                listaCadernoRawArray.get(i + 4), //tipo
                                Boolean.parseBoolean(listaCadernoRawArray.get(i + 5)) //capa dura
                        )
                );

            }
        }

        if (!listaCaixaLapisString.equals("")) {
            Scanner listaCaixaLapisRaw = new Scanner(listaCaixaLapisString).useDelimiter(";");
            ArrayList<String> listaCaixaLapisRawArray = new ArrayList<String>();

            while (listaCaixaLapisRaw.hasNext()) {
                listaCaixaLapisRawArray.add(listaCaixaLapisRaw.next());
            }
            listaCaixaLapisRaw.close();

            for (int i = 0; i < listaCaixaLapisRawArray.size(); i += 4) {
                listaCaixaLapis.add(
                        new CaixaLapis(
                                listaCaixaLapisRawArray.get(i), //marca
                                Float.parseFloat(listaCaixaLapisRawArray.get(i + 1)), //valor
                                Integer.parseInt(listaCaixaLapisRawArray.get(i + 2)), //qtdefolhas
                                Boolean.parseBoolean(listaCaixaLapisRawArray.get(i + 3))) //colorido
                );
            }
        }
        this.calculaTotalPedido();
    }

    @Override
    public String toString() {
        String listaPapelToString = "", listaCadernoToString = "", listaCaixaLapisToString = "";

        for (int i = 0; i < listaPapel.size(); i++) {
            listaPapelToString += listaPapel.get(i).getMarca() + ";" + listaPapel.get(i).getValor() + ";" + listaPapel.get(i).getCor() + ";" + listaPapel.get(i).getTipo() + ";" + listaPapel.get(i).getLargura() + ";" + listaPapel.get(i).getAltura() + ";" + listaPapel.get(i).getGramatura() + ";" + listaPapel.get(i).isPaltado() + ";";
        }

        for (int i = 0; i < listaCaderno.size(); i++) {
            listaCadernoToString += listaCaderno.get(i).getMarca() + ";" + listaCaderno.get(i).getValor() + ";" + listaCaderno.get(i).getQtdefolhas() + ";" + listaCaderno.get(i).getTamanho() + ";" + listaCaderno.get(i).getTipo() + ";" + listaCaderno.get(i).isCapadura() + ";";

        }
        for (int i = 0; i < listaCaixaLapis.size(); i++) {
            listaCaixaLapisToString = listaCaixaLapis.get(i).getMarca() + ';' + listaCaixaLapis.get(i).getValor() + ";" + listaCaixaLapis.get(i).getQuantidade() + ";" + listaCaixaLapis.get(i).isColorido() + ";";

        }

        System.out.println(listaPapelToString);
        System.out.println(listaCadernoToString);
        System.out.println(listaCaixaLapisToString);

        return data.toString() + "," + cliente.getCpf() + "," + listaPapelToString + "," + listaCadernoToString + "," + listaCaixaLapisToString;
    }

}
