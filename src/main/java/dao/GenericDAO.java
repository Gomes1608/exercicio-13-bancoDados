package dao;

import java.util.List;

public interface GenericDAO<T, ID> {
    public void inserir(T entidade);
    public List<T> listar();
}