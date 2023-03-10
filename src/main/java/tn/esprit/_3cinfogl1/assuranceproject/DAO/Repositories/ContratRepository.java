package tn.esprit._3cinfogl1.assuranceproject.DAO.Repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit._3cinfogl1.assuranceproject.DAO.Entities.Contrat;

import java.util.List;

@Repository
public interface ContratRepository extends CrudRepository<Contrat,Integer> {
    Contrat getContratByMatricule(String matricule);




    @Query(value = "select * from contrat alias join assurance ass on alias.id_contrat=ass.contract_id_contrat " +
            "where ass.beneficiaire_id_benef=?1",nativeQuery = true)
    List<Contrat> getContratByIdBeneficiaireSQL(int idBF);

















}
