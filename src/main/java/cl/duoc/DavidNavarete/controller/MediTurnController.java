package cl.duoc.DavidNavarete.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.duoc.DavidNavarete.model.MediTurnModel;
import cl.duoc.DavidNavarete.service.MediTurnService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/MediTurn")

public class MediTurnController {
    @Autowired
    private MediTurnService mediTurnService;
    @GetMapping
    public ResponseEntity<List<MediTurnModel>>getAllMediturnModel(){
        return ResponseEntity.ok(mediTurnService.getAllMediTurnModel());
    }
    @GetMapping("/{rut}")
    public ResponseEntity<?>getMediturnModelByRut(@PathVariable Long rut){
        return mediTurnService.getMediTurnModelByRut(rut)
        .map(ResponseEntity :: ok)
        .orElse(ResponseEntity.notFound().build());

    }
    @PostMapping
    public ResponseEntity<?>createMediTurnModel(@Valid@RequestBody MediTurnModel mediTurnModel){
        return ResponseEntity.ok(mediTurnService.createMediTurnModel(mediTurnModel));
    }
    @PutMapping("/{rut}")
    public ResponseEntity<?>updateMediTurnModel(@PathVariable Long rut,@Valid@RequestBody MediTurnModel mediTurnModel){
        return mediTurnService.updateMediTurnModel(rut, mediTurnModel)
        .map(ResponseEntity :: ok)
        .orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping ("/{rut}")
    public ResponseEntity<?>deleteMediTurnModel(@PathVariable Long rut){
        return mediTurnService.delete(rut)
        ?ResponseEntity.noContent().build()
        :ResponseEntity.notFound().build();
    }

}
