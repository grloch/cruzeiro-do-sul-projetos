package principal;

import javax.swing.JOptionPane;
import static principal.Auxiliar.saveArray;

public class Papel extends Produto implements Manipulacao {

    private String cor;
    private String tipo;
    private float largura;
    private float altura;
    private int gramatura;
    private boolean paltado;

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public float getLargura() {
        return largura;
    }

    public void setLargura(float largura) {
        this.largura = largura;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public int getGramatura() {
        return gramatura;
    }

    public void setGramatura(int gramatura) {
        this.gramatura = gramatura;
    }

    public boolean isPaltado() {
        return paltado;
    }

    public void setPaltado(boolean paltado) {
        this.paltado = paltado;
    }

    public Papel() {
        this.Papel();
    }

    public boolean cadastro() {
        
        Papel novoProduto = new Papel();
        saveArray(novoProduto.toString(), "papel");
        int opcao;
        int i = 0;
        while (0 == 0) {
            System.out.println(i);
            i++;
            opcao = Integer.parseInt(JOptionPane.showInputDialog(null, "Produto cadastrado, deseja cadastrar um novo produto(papel?)\n\n1) SIM    2) NÃO"));

            if (opcao == 1) {
                return true;
            } else if (opcao == 2) {
                return false;
            }
        }
    }

    public String consulta() {
        return "Marca: " + getMarca() + "\nValor: R$ " + getValor() + "\nCor: " + this.cor + "\nTipo:" + this.tipo + "\nLargura: " + this.largura + " cm\nAltura: " + this.altura + " cm\nGramatura do Papel: " + this.gramatura + "g\nPapel paltado: " + Auxiliar.checaBoolean(this.paltado);
    }

    public Papel(
            String marca, 
            float valor, 
            String cor, 
            String tipo, 
            float largura,
            float altura, 
            int gramatura,
            boolean paltado) {
        this.setMarca(marca);
        this.setValor(valor);
        this.cor = cor;
        this.tipo = tipo;
        this.largura = largura;
        this.altura = altura;
        this.gramatura = gramatura;
        this.paltado = paltado;

    }

    public void Papel() {
        int ponteiro = 1;
        String tempMarca;
        float tempValor;
        String tempCor;
        String tempTipo;
        float tempLargura;
        float tempAltura;
        int tempGramatura;
        boolean tempPaltado = false;

        do {
            //usuário informa a marca
            tempMarca = JOptionPane.showInputDialog(null, "Cadastro de novo Produto:\n" + "Tipo: Papel\n\n" + "Marca: ");
            //usuário define valor
            tempValor = Float.parseFloat(JOptionPane.showInputDialog(null, "Cadastro de novo Produto:\n" + "Tipo: Papel\n" + "Marca: " + tempMarca + "\n\n" + "Valor:"));
            //usuário define cor
            tempCor = JOptionPane.showInputDialog(null, "Cadastro de novo Produto:\n" + "Tipo: Papel\n" + "Marca: " + tempMarca + "\n" + "Valor: " + tempValor + "\n\n" + "Cor do papel:");
            //usuário define tipo
            tempTipo = JOptionPane.showInputDialog(null, "Cadastro de novo Produto:\n" + "Tipo: Papel\n" + "Marca: " + tempMarca + "\n" + "Valor: " + tempValor + "\n" + "Cor: " + tempCor + "\n\n" + "Tipo do papel:");

            //usuario define a largura
            tempLargura = Float.parseFloat(JOptionPane.showInputDialog(null, "Cadastro de novo Produto:\nTipo: Papel\nMarca: " + tempMarca + "\nValor: " + tempValor + "\nCor: " + tempCor + "\nTipo:" + tempTipo + "\n\nLargura do Papel:   (em cm)"));

            //usuario define a altura
            tempAltura = Float.parseFloat(JOptionPane.showInputDialog(null, "Cadastro de novo Produto:\nTipo: Papel\nMarca: " + tempMarca + "\nValor: " + tempValor + "\nCor: " + tempCor + "\nTipo:" + tempTipo + "\nLargura: " + tempLargura + " cm\n\nAltura do Papel:  (em cm)"));

//usuario define a gramatura
            tempGramatura = Integer.parseInt(JOptionPane.showInputDialog(null, "Cadastro de novo Produto:\nTipo: Papel\nMarca: " + tempMarca + "\nValor: " + tempValor + "\nCor: " + tempCor + "\nTipo:" + tempTipo + "\nLargura: " + tempLargura + " cm\nAltura: " + tempAltura + " cm\n\nGramatura do Papel:"));

            //usuario define se é paltado ou não
            int index = 0;
            while (index == 0) {
                String input = JOptionPane.showInputDialog(null, "Cadastro de novo Produto:\nTipo: Papel\nMarca: " + tempMarca + "\nValor: " + tempValor + "\nCor: " + tempCor + "\nTipo:" + tempTipo + "\nLargura: " + tempLargura + " cm\nAltura: " + tempAltura + " cm\nGramatura do Papel: " + tempGramatura + "g\n\nPapel paltado?\n1) SIM    2)NÃO");

                if (Integer.parseInt(input) == Integer.parseInt("1")) {
                    tempPaltado = true;
                    index = 1;
                } else if (Integer.parseInt(input) == Integer.parseInt("2")) {
                    tempPaltado = false;
                    index = 1;
                }

            }
            String input = JOptionPane.showInputDialog(null, "Cadastro de novo Produto:\nTipo: Papel\nMarca: " + tempMarca + "\nValor: " + tempValor + "\nCor: " + tempCor + "\nTipo:" + tempTipo + "\nLargura: " + tempLargura + " cm\nAltura: " + tempAltura + " cm\nGramatura do Papel: " + tempGramatura + "g\nPapel paltado: " + Auxiliar.checaBoolean(tempPaltado) + "\n\nVocê confirma os dados inseridos?\n1) SIM      2)Não");
            if (Integer.parseInt(input) == Integer.parseInt("1")) {
                ponteiro = 10;
            }
        } while (ponteiro == 1);

        this.setMarca(tempMarca);
        this.setValor(tempValor);
        this.cor = tempCor;
        this.tipo = tempTipo;
        this.largura = tempLargura;
        this.altura = tempAltura;
        this.gramatura = tempGramatura;
        this.paltado = tempPaltado;

    }

    @Override
    public String toString() {
        return getMarca() + "," + getValor() + "," + cor + "," + tipo + "," + largura + "," + altura + "," + gramatura + "," + paltado;
    }

}
