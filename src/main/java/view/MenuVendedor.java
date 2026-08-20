package view;

import dao.VendedorDAO;
import model.Vendedor;

import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.showInputDialog;

public class MenuVendedor {
    public void menu(){
        String[] item ={"Inserir","Listar","Pesquisar","Atualizar",
        "Excluir","Sair"};
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
                case "listar" -> listar();
                case "pesquisar" -> pesquisar();
                case "atualizar" -> atualizar();
                case "excluir" -> excluir();
            }
        }while(!opcao.toLowerCase().equals("sair"));
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
        Vendedor vendedor = new Vendedor();
        String nome = showInputDialog("Nome");
        vendedor.setNome(nome);
        new VendedorDAO().inserir(vendedor);
    }
}
