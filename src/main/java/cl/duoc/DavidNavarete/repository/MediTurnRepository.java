package cl.duoc.DavidNavarete.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import cl.duoc.DavidNavarete.model.MediTurnModel;

@Repository

public class MediTurnRepository {
    private final Map <Long, MediTurnModel> mediTurnCom = new HashMap<> ();

    public List<MediTurnModel> findAll(){
        return new ArrayList<>(mediTurnCom.values());

    }
    public Optional<MediTurnModel>findByRut(Long rut){
        return Optional.ofNullable(mediTurnCom.get(rut));
    }
    public MediTurnModel save(MediTurnModel mediTurnModel){
        mediTurnCom.put(mediTurnModel.getRut(),mediTurnModel);
        return mediTurnModel;

    }
    public void deleteByRut(Long rut){
        mediTurnCom.remove(rut);
    }
    public boolean existsByRut(Long rut){
        return mediTurnCom.containsKey(rut);

    }


}
