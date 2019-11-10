package principal;

import java.io.File;
import java.sql.JDBCType;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Data {

    private int dia;
    private int mes;
    private int ano;

    @Override
    public String toString() {
        return dia + ";" + mes + ";" + ano;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public Data(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public Data() {
        String newDate = JOptionPane.showInputDialog("Novo pedido:\n\nInforme a data do pedido:   (formato dd.mm.yyyy)");

        Scanner raw = new Scanner(newDate).useDelimiter("\\.");
        ArrayList<String> rawString = new ArrayList<String>();

        while (raw.hasNext()) {
            rawString.add(raw.next());
        }
        raw.close();
        this.dia = Integer.parseInt(rawString.get(0));
        this.mes = Integer.parseInt(rawString.get(1));
        this.ano = Integer.parseInt(rawString.get(2));

    }

    public String getData() {
        return dia + "." + mes + "." + ano;
    }

}
