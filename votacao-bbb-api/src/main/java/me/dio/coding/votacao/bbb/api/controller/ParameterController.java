package me.dio.coding.votacao.bbb.api.controller;

import lombok.AllArgsConstructor;
import me.dio.coding.votacao.bbb.api.model.ParameterModel;
import me.dio.coding.votacao.bbb.api.repository.ParameterRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/parameters")
@AllArgsConstructor
public class ParameterController {

    private final ParameterRepository repository;

    @PostMapping()
    public ResponseEntity<ParameterModel> save(@RequestBody ParameterModel parameter) {
        ParameterModel entity = repository.save(parameter);
        return ResponseEntity.ok(entity);
    }

    @GetMapping()
    public ResponseEntity<List<ParameterModel>> getAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/parameter")
    public ResponseEntity<ParameterModel> get(@RequestParam String key) {
        Optional<ParameterModel> optParameter = repository.findById(key);
        if (optParameter.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(optParameter.get());
    }

}
