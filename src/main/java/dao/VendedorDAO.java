package dao;

import factory.ConnectionFactory;
import model.Vendedor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class VendedorDAO implements GenericDAO<Vendedor, Integer> {
    @Override
    public void inserir(Vendedor entidade) {
        String sql = "insert into java_vendedor(nome) values(?)";
        try(Connection connection = ConnectionFactory.obterConexao();
        PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setString(1, entidade.getNome());
            ps.execute();
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Vendedor> listar() {
        List<Vendedor> lista = new ArrayList<>();
        String sql = "select * from java_vendedor";
        try(Connection connection = ConnectionFactory.obterConexao();
            PreparedStatement ps =  connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()){
            while (rs.next()){
                Vendedor vendedor = new Vendedor();
                vendedor.setId(rs.getInt("id"));
                vendedor.setNome(rs.getString("nome"));
                lista.add(vendedor);
            }

        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return lista;
    }

    @Override
    public Optional<Vendedor> buscaPorID(Integer id) {
        String sql ="select * from java_vendedor where id = ?";
        try(Connection connection = ConnectionFactory.obterConexao();
        PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setInt(1,id);
            try(ResultSet rs = ps.executeQuery()) {
                if (rs.next()){
                    Vendedor vendedor = new Vendedor();
                    vendedor.setId(rs.getInt("id"));
                    vendedor.setNome(rs.getString("nome"));
                    return  Optional.of(vendedor);
                }
            }

        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return Optional.empty();
    }
}
