package principal;

import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import static principal.Auxiliar.loadCliente;
import static principal.Auxiliar.loadPedidos;
import static principal.Auxiliar.loadProduto;
import static principal.Auxiliar.saveArray;

public class principal {

    //
    public static void main(String[] args) throws IOException {
        ArrayList<Papel> listaPapel = loadProduto("papel");
        ArrayList<Caderno> listaCaderno = loadProduto("caderno");
        ArrayList<CaixaLapis> listaCaixaLapis = loadProduto("caixaLapis");
        ArrayList<Cliente> listaCliente = loadCliente();

        ArrayList<Pedido> listaPedido = loadPedidos();

        //listaPedido.add(new Pedido());
        //JOptionPane.showMessageDialog(null, objPedido.consulta());System.out.println(objPedido.toString());
        int ponteiroPrincipal = 999;

        while (ponteiroPrincipal != 0) {
            ponteiroPrincipal = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Escolha uma opção:\n1) Cadastrar\n2) Consultar \n3) Listar todos\n\n0) Sair"));

            if (ponteiroPrincipal == 1) {// Rotina Cadastro
                boolean newCadastro = false;
                int ponteiroCadastro = 99;
                do {
                    ponteiroCadastro = Integer.parseInt(JOptionPane.showInputDialog(null,
                            "Escolha uma opção:\nCadastrar:\n\n1) Cliente\n2) Produto\n3)Venda\n\n0) Voltar"));

                    if (ponteiroCadastro == 1) {// cadastra Cliente
                        do {
                            newCadastro = listaCliente.get(0).cadastro();
                        } while (newCadastro);
                        listaPapel = loadCliente();

                    } else if (ponteiroCadastro == 2) {// cadastra Produto
                        int ponteiroCadastroProduto = 999;
                        while (ponteiroCadastroProduto != 0) {
                            ponteiroCadastroProduto = Integer.parseInt(JOptionPane.showInputDialog(null,
                                    "Escolha um tipo de produto para Cadastrar:\n\n1) Papel\n2) Caixa de lápis\n3)Caderno\n\n0) Voltar"));
                            if (ponteiroCadastroProduto == 1) {// Cadastro Papel
                                do {
                                    newCadastro = listaPapel.get(0).cadastro();
                                } while (newCadastro);

                                listaPapel = loadProduto("papel");
                            }
                            if (ponteiroCadastroProduto == 2) {// Cadastro caixa de lapis

                                do {
                                    newCadastro = listaCaixaLapis.get(0).cadastro();
                                } while (newCadastro);
                                listaCaixaLapis = loadProduto("caixaLapis");

                            } else if (ponteiroCadastroProduto == 3) {// Cadastro Caderno
                                do {
                                    newCadastro = listaCaderno.get(0).cadastro();
                                } while (newCadastro);
                                listaCaderno = loadProduto("caderno");

                            }
                        }
                    } // cadastra venda
                    else if (ponteiroCadastro == 3) {// cadastra Pedido
                        do {
                            newCadastro = listaPedido.get(0).cadastro();
                        } while (newCadastro);
                        listaPedido = loadPedidos();
                    }
                    ponteiroCadastro = 0;

                } while (ponteiroCadastro != 0);
            } // Rotina Consulta
            else if (ponteiroPrincipal == 2) {// Rotina Consulta
                int ponteiroConsulta = 99;
                do {
                    ponteiroConsulta = Integer.parseInt(JOptionPane.showInputDialog(null,
                            "Escolha uma opção:\nConsultar:\n\n1) Cliente\n2) Produto\n3) Pedido\n\n0) Voltar"));

                    if (ponteiroConsulta == 1) {// Rotina Consulta Cliente
                        int codigo = Integer.parseInt(
                                JOptionPane.showInputDialog(null, "Insira o código do cliente que deseja consultar"));
                        if (codigo < listaCliente.size()) {
                            JOptionPane.showMessageDialog(null, listaCliente.get(codigo).consulta());
                        } else {
                            JOptionPane.showMessageDialog(null, "Cliente " + codigo + " não localizado");
                        }
                        listaCliente = loadCliente();
                    } else if (ponteiroConsulta == 2) {// Rotina Consulta Produto
                        int ponteiroConsultaProduto = 0;
                        do {
                            ponteiroConsultaProduto = Integer.parseInt(
                                    JOptionPane.showInputDialog(null, "Escolha uma opção:\n" + "Consultar Produto:\n\n"
                                            + "1) Papel\n" + "2) Caixa de lápis\n" + "3) Caderno\n\n" + "0) Voltar"));
                            if (ponteiroConsultaProduto == 1) {// Consulta papel
                                int codigo = Integer.parseInt(JOptionPane.showInputDialog(null,
                                        "Insira o número do produto papel que deseja consultar"));
                                if (codigo < listaPapel.size()) {
                                    JOptionPane.showMessageDialog(null, listaPapel.get(codigo).consulta());
                                } else {
                                    JOptionPane.showMessageDialog(null, "Produto " + codigo + " não localizado");
                                }
                            } else if (ponteiroConsultaProduto == 2) {// Consulta Lapis
                                int codigo = Integer.parseInt(JOptionPane.showInputDialog(null,
                                        "Insira o número do produto lapis que deseja consultar"));
                                if (codigo < listaCaixaLapis.size()) {
                                    JOptionPane.showMessageDialog(null, listaCaixaLapis.get(codigo).consulta());
                                } else {
                                    JOptionPane.showMessageDialog(null, "Produto " + codigo + " não localizado");
                                }
                            } else if (ponteiroConsultaProduto == 3) {// Consulta caderno
                                int codigo = Integer.parseInt(JOptionPane.showInputDialog(null,
                                        "Insira o número do produto caderno que deseja consultar"));
                                if (codigo < listaCaderno.size()) {
                                    JOptionPane.showMessageDialog(null, listaCaderno.get(codigo).consulta());
                                } else {
                                    JOptionPane.showMessageDialog(null, "Produto " + codigo + " não localizado");
                                }
                            }
                        } while (ponteiroConsultaProduto != 0);
                    } else if (ponteiroConsulta == 3) {// Rotina Consulta Pedido
                        int codigo = Integer.parseInt(JOptionPane.showInputDialog(null,
                                "Insira o número do produto pedido que deseja consultar"));
                        if (codigo < listaPedido.size()) {
                            JOptionPane.showMessageDialog(null, listaPedido.get(codigo).consulta());
                        } else {
                            JOptionPane.showMessageDialog(null, "Pedido " + codigo + " não localizado");
                        }
                        ponteiroConsulta = 0;
                    }

                } while (ponteiroConsulta != 0);
            } else if (ponteiroPrincipal == 3) {//lista todos
                String pedidos = "";
                if (listaPedido.size() > 0) {
                    pedidos += "Códigos: \n\n";

                    for (int i = 0; i < listaPedido.size(); i++) {
                        pedidos += i + "\n";
                        System.out.println("Pedido " + i + ":");
                        System.out.println(listaPedido.get(i).consulta());
                        System.out.println("\n");

                    }
                    pedidos += "\n\n Detalhamento dos pedidos no console";

                } else {
                    pedidos = "Nenhum pedidos cadastrado";
                }

                JOptionPane.showMessageDialog(null, "Pedidos disponíveis para consulta\n" + pedidos);
            }
        }
        JOptionPane.showMessageDialog(null, "Programa encerrado");
    }
}
