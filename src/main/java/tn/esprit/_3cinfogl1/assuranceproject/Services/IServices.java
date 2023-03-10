package tn.esprit._3cinfogl1.assuranceproject.Services;

import tn.esprit._3cinfogl1.assuranceproject.DAO.Entities.Assurance;
import tn.esprit._3cinfogl1.assuranceproject.DAO.Entities.Beneficiaire;
import tn.esprit._3cinfogl1.assuranceproject.DAO.Entities.Contrat;
import tn.esprit._3cinfogl1.assuranceproject.DAO.Entities.TypeContrat;

import java.util.Set;

public interface IServices {


    public Beneficiaire ajouterBeneficiaire(Beneficiaire bf);
    public Contrat ajouterContrat(Contrat c);

    public Assurance ajouterAssurance(Assurance a,int cinBF,String matricule);

    public Contrat getContratBF(int idBF);

   public Set<Beneficiaire> getBeneficiaireByType(TypeContrat typeContrat);
  public  float getMontantBf(int cinBf);
  public  void  statistiques();

















}
