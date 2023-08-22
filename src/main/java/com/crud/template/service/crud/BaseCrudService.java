package com.crud.template.service.crud;

import java.util.List;

public interface BaseCrudService<Z, ID> {

    Z save(Z entity);
    Z getById(ID id);
    List<Z> getAll();
    Z updateById(ID id, Z entity);
    void deleteById(ID id);
}
