package com.crud.template.controller;

import com.crud.template.entity.Example;
import com.crud.template.service.example.ExampleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/examples")
public class ExampleController {

    private final ExampleService exampleService;

    private static final String EXAMPLE_CONTENT = "example content";
    private static final String UPDATED_EXAMPLE_CONTENT = "updated example";

    @RequestMapping(method = RequestMethod.POST, value = "")
    public ResponseEntity<?> createExample() {
        Example example = exampleService.save(makeExample(EXAMPLE_CONTENT));

        return new ResponseEntity<>(example, HttpStatus.CREATED);
    }

    private Example makeExample(String exampleContent) {
        return new Example(exampleContent);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{exampleId}")
    public ResponseEntity<?> getExampleById(@PathVariable short exampleId) {
        Example example = exampleService.getById(exampleId);

        return new ResponseEntity<>(example, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "")
    public ResponseEntity<?> getAllExample() {
        List<Example> examples = exampleService.getAll();

        return new ResponseEntity<>(examples, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{exampleId}")
    public ResponseEntity<?> updateExampleById(@PathVariable short exampleId) {
        Example updatingExample = makeExample(exampleId, UPDATED_EXAMPLE_CONTENT);
        Example updatedExample = exampleService.updateById(exampleId, updatingExample);

        return new ResponseEntity<>(updatedExample, HttpStatus.OK);
    }

    private Example makeExample(short exampleId, String exampleContent) {
        return new Example(exampleId, exampleContent);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{exampleId}")
    public ResponseEntity<?> deleteExampleById(@PathVariable short exampleId) {
        exampleService.deleteById(exampleId);

        boolean isDeleted = true;
        return new ResponseEntity<>(isDeleted, HttpStatus.OK);
    }
}
