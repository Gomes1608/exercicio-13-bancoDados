package view;

import dao.VendaDAO;
import dao.VendedorDAO;
import model.Venda;
import model.Vendedor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import static java.lang.Double.parseDouble;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.*;

public class MenuVenda {
    public void menu(){
        String[] item ={"Inserir","Listar","Pesquisar","Atualizar",
                "Relatório","Excluir","Sair"};
        String opcao;
        do {
            opcao =(String)showInputDialog(null,
                    "Selecione uma opção",
                    "--- MENU PRINCIPAL ---",
                    INFORMATION_MESSAGE,
                    null,
                    item,
                    item[0]);
            switch(opcao.toLowerCase()){
                case "inserir" -> inserir();
                case "relatório" -> relatorio();
                case "listar" -> listar();
                case "pesquisar" -> pesquisar();
                case "atualizar" -> atualizar();
                case "excluir" -> excluir();
            }
        }while(!opcao.toLowerCase().equals("sair"));
    }

    private void relatorio() {
        List<Venda> lista = new VendaDAO().relatorio();
        String aux ="";
        for (Venda venda: lista){
            aux+= venda.getVendedor().getNome() +" | ";
            aux+= venda.getTotal() + " | ";
            aux+= venda.getData()+"\n";
        }
        showMessageDialog(null,aux);
    }

    private void excluir() {
    }

    private void atualizar() {
    }

    private void pesquisar() {
    }

    private void listar() {

    }

    private void inserir() {
        List<Vendedor> lista = new VendedorDAO().listar();
        double total;
        String data;
        Vendedor vendedor;
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        vendedor = (Vendedor)showInputDialog(null,
                "Selecione um vendedor",
                "--- MENU PRINCIPAL ---",
                INFORMATION_MESSAGE,
                null,
                lista.toArray(),
                lista.get(0));

        total = parseDouble(showInputDialog("Total das vendas"));
        data = showInputDialog("Data da Venda");
        Venda venda = new Venda();
        venda.setTotal(total);
        venda.setVendedor(vendedor);
        venda.setData(LocalDate.parse(data, formato));
        new VendaDAO().inserir(venda);
    }
}