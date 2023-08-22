package com.crud.template.repository;

import com.crud.template.entity.Example;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExampleRepository extends JpaRepository<Example, Short> {
}
