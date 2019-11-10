package principal;

import javax.swing.JOptionPane;
import static principal.Auxiliar.saveArray;

public class Cliente implements Manipulacao {

    private String nome;
    private String cpf;
    private String telefone;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;

    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Cliente() {
        int ponteiro = 0;
        while (ponteiro != 1) {
            this.nome = JOptionPane.showInputDialog("Novo cadastro: Cliente\n\nNome:");
            this.cpf = JOptionPane.showInputDialog("Novo cadastro: Cliente\nNome: " + this.nome + "\n\nInsira o CPF: ");
            this.telefone = JOptionPane.showInputDialog("Novo cadastro: Cliente\nNome: " + this.nome + "\nCPF: " + this.cpf + "\n\nInsira o Telefone: ");

            ponteiro = Integer.parseInt(
                    JOptionPane.showInputDialog(null,
                            "Novo cadastro: Cliente\nNome: " + this.nome
                            + "\nCPF: " + this.cpf
                            + "\nTelefone: " + this.telefone
                            + "\n\nVocê confirma os dados informados?\n1) SIM    2) Não"));
        }
    }

    public Cliente(String nome, String cpf, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
    }

    public String consulta() {
        return "Consulta cliente:\n" + "Nome: " + nome + "\nCPF: " + cpf + "\nTelefone: " + telefone;
    }

    public boolean cadastro() {
        Cliente novoCliente = new Cliente();
        saveArray(novoCliente.toString(), "clientes");
        int opcao;
        int i = 0;
        while (0 == 0) {
            System.out.println(i);
            i++;
            opcao = Integer.parseInt(JOptionPane.showInputDialog(null, "Cliente cadastrado, deseja cadastrar um novo cliente?\n\n1) SIM    2) NÃO"));

            if (opcao == 1) {
                return true;
            } else if (opcao == 2) {
                return false;
            }
        }
    }

    @Override
    public String toString() {
        return nome + "," + cpf + "," + telefone;
    }

}
