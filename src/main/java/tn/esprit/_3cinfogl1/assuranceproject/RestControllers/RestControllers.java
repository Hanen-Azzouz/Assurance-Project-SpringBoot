package tn.esprit._3cinfogl1.assuranceproject.RestControllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit._3cinfogl1.assuranceproject.DAO.Entities.Assurance;
import tn.esprit._3cinfogl1.assuranceproject.DAO.Entities.Beneficiaire;
import tn.esprit._3cinfogl1.assuranceproject.DAO.Entities.Contrat;
import tn.esprit._3cinfogl1.assuranceproject.DAO.Entities.TypeContrat;
import tn.esprit._3cinfogl1.assuranceproject.Services.IServices;

import java.util.Set;

@RequestMapping("Assurance Project")
@RestController
public class RestControllers {


    @Autowired
    private IServices AssuranceRest;
  @PostMapping("ajouterBeneficiaire")
    Beneficiaire ajouterBeneficiaire(@RequestBody Beneficiaire bf){

       return AssuranceRest.ajouterBeneficiaire(bf);
    }
  @PostMapping("ajouterContrat")
    Contrat ajouterContrat(@RequestBody Contrat c){
      return AssuranceRest.ajouterContrat(c);
    }
@PostMapping("ajouterAssurance")
    Assurance ajouterAssurance(@RequestBody Assurance a, @RequestParam int cinBF, @RequestParam String matricule){

      return AssuranceRest.ajouterAssurance(a,cinBF,matricule);
    }

@GetMapping("getAncienContratPar_Beneficiaire")
    Contrat getContratBF(@RequestParam int idBF){
      return AssuranceRest.getContratBF(idBF);

    }


    @GetMapping("getBeneficiaireByType")
    Set<Beneficiaire> getBeneficiaireByType(@RequestParam TypeContrat typeContrat){

      return AssuranceRest.getBeneficiaireByType(typeContrat);
    }


    @GetMapping("getMontantBf")
    float getMontantBf(@RequestParam int cinBf){
      return  AssuranceRest.getMontantBf(cinBf);

    }

















}
