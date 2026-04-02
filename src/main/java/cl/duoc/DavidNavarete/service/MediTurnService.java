package cl.duoc.DavidNavarete.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.duoc.DavidNavarete.model.MediTurnModel;
import cl.duoc.DavidNavarete.repository.MediTurnRepository;

@Service

public class MediTurnService {
    @Autowired
    private MediTurnRepository mediTurnRepository;
    public MediTurnService(MediTurnRepository mediTurnRepository){
        this.mediTurnRepository = mediTurnRepository;
    }
    public List<MediTurnModel>getAllMediTurnModel(){
        return mediTurnRepository.findAll();
    }
    public Optional <MediTurnModel>getMediTurnModelByRut(Long rut){
        return mediTurnRepository.findByRut(rut);

    }
    public MediTurnModel createMediTurnModel(MediTurnModel mediTurnModel){
        return mediTurnRepository.save(mediTurnModel);

    }
    public Optional<MediTurnModel>updateMediTurnModel(Long rut, MediTurnModel mediTurnModel){
        if (mediTurnRepository.existsByRut(rut)){
            mediTurnModel.setRut(rut);
            return Optional.of(mediTurnRepository.save(mediTurnModel));

        }
        return Optional.empty();
    }
    public boolean delete(Long rut){
        if(mediTurnRepository.existsByRut(rut)){
            mediTurnRepository.deleteByRut(rut);
            return true;
        }
        return false;
    }
    


}
