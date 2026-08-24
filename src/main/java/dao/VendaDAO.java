package dao;

import factory.ConnectionFactory;
import model.Venda;
import model.Vendedor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class VendaDAO implements GenericDAO<Venda, Integer>{
    @Override
    public void inserir(Venda entidade) {
        String sql = "insert into java_venda(vendedor, total, data) values(?, ? ,?)";
        try(Connection connection = ConnectionFactory.obterConexao();
            PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setInt(1,entidade.getVendedor().getId());
            ps.setDouble(1,entidade.getTotal());
            ps.execute();
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Venda> listar() {
        List<Venda> lista = new ArrayList<>();
        String sql = "select * from java_venda";
        try(Connection connection = ConnectionFactory.obterConexao();
            PreparedStatement ps =  connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()){
            while (rs.next()){
                Venda venda = new Venda();
                venda.setId(rs.getInt("id"));
                lista.add(venda);
            }

        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return lista;
    }

    @Override
    public Optional<Venda> buscaPorID(Integer integer) {
        return Optional.empty();
    }
}
