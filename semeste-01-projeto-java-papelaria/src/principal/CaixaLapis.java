package principal;

import javax.swing.JOptionPane;
import static principal.Auxiliar.saveArray;

public class CaixaLapis extends Produto implements Manipulacao {

    private int quantidade;
    private boolean colorido;

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public boolean isColorido() {
        return colorido;
    }

    public void setColorido(boolean colorido) {
        this.colorido = colorido;
    }

    public boolean cadastro() {
        CaixaLapis novoProduto = new CaixaLapis();
        saveArray(novoProduto.toString(), "caixaLapis");
        int opcao;
        int i = 0;
        while (0 == 0) {
            System.out.println(i);
            i++;
            opcao = Integer.parseInt(JOptionPane.showInputDialog(null, "Produto cadastrado, deseja cadastrar um novo produto(caixa lápis?)\n\n1) SIM    2) NÃO"));

            if (opcao == 1) {
                return true;
            } else if (opcao == 2) {
                return false;
            }
        }
    }

    public String consulta() {

        return "\nMarca: " + getMarca() + "\n" + "Valor: R$ " + getValor() + "\n"
                + "Unidades na caixa: " + quantidade + "\n" + "Colorido: "
                + Auxiliar.checaBoolean(this.colorido);
    }

    public CaixaLapis() {

        int ponteiro = 1;
        String tempMarca;
        float tempValor;

        int tempQuantidade;
        boolean tempColorido = false;

        do {
            tempMarca = JOptionPane.showInputDialog(null,
                    "Cadastro de novo Produto:\n" + "Tipo: Caixa de lápis\n\n" + "Marca: ");
            tempValor = Float.parseFloat(JOptionPane.showInputDialog(null, "Cadastro de novo Produto:\n"
                    + "Tipo: Caixa de lápis\n" + "Marca: " + tempMarca + "\n\n" + "Valor:"));

            tempQuantidade = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Cadastro de novo Produto:\n" + "Tipo: Caixa de lápis\n" + "Marca: " + tempMarca + "\n"
                    + "Valor: R$ " + tempValor + "\n\nQuantidade de lápis na caixa: "));
            int index = 0;
            while (index == 0) {
                String input = JOptionPane.showInputDialog(null,
                        "Cadastro de novo Produto:\n" + "Tipo: Caixa de lápis\n" + "Marca: " + tempMarca + "\n"
                        + "Valor: R$ " + tempValor + "\nQuantidade de lápis na caixa: " + tempQuantidade
                        + "\n\nColorido?\n1) SIM    2)NÃO");

                if (Integer.parseInt(input) == Integer.parseInt("1")) {
                    tempColorido = true;
                    index = 1;
                } else if (Integer.parseInt(input) == Integer.parseInt("2")) {
                    tempColorido = false;
                    index = 1;
                }

            }
            String input = JOptionPane.showInputDialog(null,
                    "Cadastro de novo Produto:\n" + "Tipo: Caixa de lápis\n" + "Marca: " + tempMarca + "\n"
                    + "Valor: R$ " + tempValor + "\nQuantidade de lápis na caixa: " + tempQuantidade
                    + "\nColorido: " + Auxiliar.checaBoolean(tempColorido)
                    + "\n\nVocê confirma os dados inseridos?\n1) SIM      2)Não");
            if (Integer.parseInt(input) == Integer.parseInt("1")) {
                break;
            }
        } while (ponteiro != 0);

        setMarca(tempMarca);
        setValor(tempValor);
        this.quantidade = tempQuantidade;
        this.colorido = tempColorido;

    }

    public CaixaLapis(String marca, float valor, int quantidade, boolean colorido) {
        this.setMarca(marca);
        this.setValor(valor);
        this.quantidade = quantidade;
        this.colorido = colorido;
    }

    @Override
    public String toString() {
        return getMarca() + "," + getValor() + "," + quantidade + "," + colorido;
    }

}
