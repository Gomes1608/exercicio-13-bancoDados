package dao;

import java.util.List;
import java.util.Optional;

public interface GenericDAO<T, ID> {
    public void inserir(T entidade);
    public List<T> listar();
    public Optional<T> buscaPorID(ID id);

}