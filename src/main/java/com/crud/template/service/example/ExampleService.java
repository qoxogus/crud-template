package com.crud.template.service.example;

import com.crud.template.entity.Example;
import com.crud.template.repository.ExampleRepository;
import com.crud.template.service.crud.CrudService;
import org.springframework.stereotype.Service;

@Service
public class ExampleService extends CrudService<Example, Short, ExampleRepository> {

    @Override
    public Example getById(Short aShort) {
        return super.getById(aShort); // 복잡한 로직 필요할 시 재정의하여 사용
    }
}
