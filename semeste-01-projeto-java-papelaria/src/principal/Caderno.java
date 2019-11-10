package principal;

import javax.swing.JOptionPane;
import static principal.Auxiliar.saveArray;

public class Caderno extends Produto implements Manipulacao {

    private int qtdefolhas;
    private String tamanho;
    private String tipo;
    private boolean capadura;

    public int getQtdefolhas() {
        return qtdefolhas;
    }

    public void setQtdefolhas(int qtdefolhas) {
        this.qtdefolhas = qtdefolhas;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isCapadura() {
        return capadura;
    }

    public void setCapadura(boolean capadura) {
        this.capadura = capadura;
    }

    public boolean cadastro() {
        Caderno novoProduto = new Caderno();
        saveArray(novoProduto.toString(), "caderno");
        int opcao;
        int i = 0;
        while (0 == 0) {
            System.out.println(i);
            i++;
            opcao = Integer.parseInt(JOptionPane.showInputDialog(null, "Produto cadastrado, deseja cadastrar um novo produto(caderno?)\n\n1) SIM    2) NÃO"));

            if (opcao == 1) {
                return true;
            } else if (opcao == 2) {
                return false;
            }
        }
    }

    public Caderno() {
        int ponteiro = 1;
        String tempMarca;
        float tempValor;
        int tempQtdefolhas;
        String tempTamanho;
        String tempTipo;
        boolean tempCapadura = false;

        do {
            // usuário informa a marca
            tempMarca = JOptionPane.showInputDialog(null,
                    "Cadastro de novo Produto:\n" + "Tipo: Caderno\n\n" + "Marca: ");
            tempValor = Float.parseFloat(JOptionPane.showInputDialog(null,
                    "Cadastro de novo Produto:\n" + "Tipo: Caderno\n" + "Marca: " + tempMarca + "\n\n" + "Valor:"));

            tempQtdefolhas = Integer
                    .parseInt(JOptionPane.showInputDialog(null, "Cadastro de novo Produto:\n" + "Tipo: Caderno\n"
                            + "Marca: " + tempMarca + "\n" + "Valor R$: " + tempValor + "\n\nQuantidade de folhas: "));
            tempTamanho = JOptionPane.showInputDialog(null,
                    "Cadastro de novo Produto:\n" + "Tipo: Caderno\n" + "Marca: " + tempMarca + "\n" + "Valor R$: "
                    + tempValor + "\nQuantidade de folhas: " + tempQtdefolhas + "\n\nTamanho:");
            tempTipo = JOptionPane.showInputDialog(null,
                    "Cadastro de novo Produto:\n" + "Tipo: Caderno\n" + "Marca: " + tempMarca + "\n" + "Valor R$: "
                    + tempValor + "\nQuantidade de folhas: " + tempQtdefolhas + "\nTamanho: " + tempTamanho
                    + "\n\nTipo: ");

            // usuario define se é capadura ou não
            int index = 0;
            while (index == 0) {
                String input = JOptionPane.showInputDialog(null,
                        "Cadastro de novo Produto:\n" + "Tipo: Caderno\n" + "Marca: " + tempMarca + "\n" + "Valor R$: "
                        + tempValor + "\nQuantidade de folhas: " + tempQtdefolhas + "\nTamanho: " + tempTamanho
                        + "\n\nTipo: \n\nCapa dura?\n1) SIM    2)NÃO");

                if (Integer.parseInt(input) == Integer.parseInt("1")) {
                    tempCapadura = true;
                    index = 1;
                } else if (Integer.parseInt(input) == Integer.parseInt("2")) {
                    tempCapadura = false;
                    index = 1;
                }

            }
            String input = JOptionPane.showInputDialog(null,
                    "Cadastro de novo Produto:\n" + "Tipo: Caderno\n" + "Marca: " + tempMarca + "\n" + "Valor R$: "
                    + tempValor + "\nQuantidade de folhas: " + tempQtdefolhas + "\nTamanho: " + tempTamanho
                    + "\n\nTipo: \n\nCapa dura" + Auxiliar.checaBoolean(tempCapadura)
                    + "\n\nVocê confirma os dados inseridos?\n1) SIM      2)Não"
            );
            if (Integer.parseInt(input) == Integer.parseInt("1")) {
                break;
            }
        } while (ponteiro == 1);

        this.setMarca(tempMarca);
        this.setValor(tempValor);
        this.qtdefolhas = tempQtdefolhas;
        this.tamanho = tempTamanho;
        this.tipo = tempTipo;
        this.capadura = tempCapadura;

    }

    public Caderno(String marca, float valor, int qtdefolhas, String tamanho, String tipo, boolean capadura) {
        this.setMarca(marca);
        this.setValor(valor);
        this.qtdefolhas = qtdefolhas;
        this.tamanho = tamanho;
        this.tipo = tipo;
        this.capadura = capadura;
    }

    public String consulta() {
        return "Marca: " + getMarca() + "\n" + "Valor R$: "
                + getValor() + "\nQuantidade de folhas: " + qtdefolhas + "\nTamanho: " + tamanho
                + "\nTipo: " + tipo + "\nCapa dura: " + Auxiliar.checaBoolean(capadura);
    }

    @Override
    public String toString() {
        return getMarca() + "," + getValor() + "," + qtdefolhas + "," + tamanho + "," + tipo + "," + capadura;
    }

}
