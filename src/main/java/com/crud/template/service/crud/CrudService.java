package com.crud.template.service.crud;

import com.crud.template.helper.ObjectHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CrudService<Z, ID, R extends JpaRepository<Z, ID>> implements BaseCrudService<Z, ID> {

    @Autowired private R repository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Z save(Z entity) {
        ObjectHelper.throwExceptionIfEmpty(entity);
        return this.repository.save(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public Z getById(ID id) {
        ObjectHelper.throwExceptionIfEmpty(id);
        return this.repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID " + id + " not found"));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Z> getAll() {
        return this.repository.findAll();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Z updateById(ID id, Z entity) {
        getById(id);
        return save(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteById(ID id) {
        ObjectHelper.throwExceptionIfEmpty(id);
        this.repository.deleteById(id);
    }
}
