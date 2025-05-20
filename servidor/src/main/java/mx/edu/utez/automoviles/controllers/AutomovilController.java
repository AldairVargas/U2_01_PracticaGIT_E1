package mx.edu.utez.automoviles.controllers;

import mx.edu.utez.automoviles.model.Automovil;
import mx.edu.utez.automoviles.repository.AutomovilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/automoviles")
@CrossOrigin(origins = "*")
public class AutomovilController {
    @Autowired
    private AutomovilRepository repository;

    @GetMapping
    public ResponseEntity<List<Automovil>> listar() {
        return ResponseEntity.ok(repository.findAll());
    }

    @PostMapping
    public ResponseEntity<Automovil> crear(@RequestBody Automovil automovil) {
        return ResponseEntity.ok(repository.save(automovil));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Automovil> obtener(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Automovil> actualizar(@PathVariable Long id, @RequestBody Automovil automovilActualizado) {
        return repository.findById(id)
                .map(automovil -> {
                    automovil.setMarca(automovilActualizado.getMarca());
                    automovil.setModelo(automovilActualizado.getModelo());
                    automovil.setColor(automovilActualizado.getColor());
                    automovil.setPlacas(automovilActualizado.getPlacas());
                    automovil.setTipo(automovilActualizado.getTipo());
                    automovil.setContactoProveedor(automovilActualizado.getContactoProveedor());
                    return ResponseEntity.ok(repository.save(automovil));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}