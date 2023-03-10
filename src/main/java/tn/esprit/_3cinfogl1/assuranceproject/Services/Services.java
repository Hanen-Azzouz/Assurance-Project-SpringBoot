package tn.esprit._3cinfogl1.assuranceproject.Services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit._3cinfogl1.assuranceproject.DAO.Entities.Assurance;
import tn.esprit._3cinfogl1.assuranceproject.DAO.Entities.Beneficiaire;
import tn.esprit._3cinfogl1.assuranceproject.DAO.Entities.Contrat;
import tn.esprit._3cinfogl1.assuranceproject.DAO.Entities.TypeContrat;
import tn.esprit._3cinfogl1.assuranceproject.DAO.Repositories.AssuranceRepository;
import tn.esprit._3cinfogl1.assuranceproject.DAO.Repositories.BeneficiaireRepository;
import tn.esprit._3cinfogl1.assuranceproject.DAO.Repositories.ContratRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
@Slf4j
@Service
public class Services implements IServices {

    @Autowired
    private ContratRepository contratRepo;
    @Autowired
    private BeneficiaireRepository benefRepo;
    @Autowired
    private AssuranceRepository AssuranceRepo;

    @Override
    public Beneficiaire ajouterBeneficiaire(Beneficiaire bf) {
        return benefRepo.save(bf);
    }

    @Override
    public Contrat ajouterContrat(Contrat c) {
        return contratRepo.save(c);
    }

    @Override
    public Assurance ajouterAssurance(Assurance a, int cinBF, String matricule) {
       Beneficiaire benefaffecte=benefRepo.getBeneficiaireByCin(cinBF);
     Contrat contrataffecte=contratRepo.getContratByMatricule(matricule);
     a.setBeneficiaire(benefaffecte);
     a.setContract(contrataffecte);
     AssuranceRepo.save(a);
        return a;
    }

    @Override
    public Contrat getContratBF(int idBF) {


        List<Contrat> lstContrats = new ArrayList<Contrat>();

        lstContrats = contratRepo.getContratByIdBeneficiaireSQL(idBF);
        Contrat contrat = lstContrats.get(0);
           Date oldDate=lstContrats.get(0).getDateEffet();
        for (Contrat c : lstContrats) {
            if (oldDate.after(c.getDateEffet())) {
              contrat=c;
            }
        }

        return contrat;
    }

    @Override
    public Set<Beneficiaire> getBeneficiaireByType(TypeContrat typeContrat) {

        return benefRepo.getBeneficiaireByTypeJPQL(typeContrat);
    }

    @Override
    public float getMontantBf(int cinBf) {
        float montant=0;
        Beneficiaire beneficiaire=benefRepo.getBeneficiaireByCin(cinBf);
        List<Assurance> lstAssurance=beneficiaire.getAssurances();
        for (Assurance a:lstAssurance){
            //Contrat c=a.getContract();

            if((a.getContract().getType()==TypeContrat.Mensuel)){
                montant+=(a.getMontant()*12);
            }
            else if((a.getContract().getType()==TypeContrat.Semestriel)){
               montant+=(a.getMontant()*2);
            }
            else {
                montant+=a.getMontant();}

            }
        return montant;
        }
    @Scheduled(cron = "4 * * * * *")
    @Override
    public void statistiques() {
        String msg="";
        int nbrAssurances=0;
        List<Beneficiaire> lstBeneficiaire= (List<Beneficiaire>) benefRepo.findAll();
        for (Beneficiaire b:lstBeneficiaire) {
            nbrAssurances=AssuranceRepo.nbrAssuranceSQL(b.getIdBenef());
            msg+= "le beneficiaire dont le cin est "+" "+b.getCin()+" "+"a"+" "+nbrAssurances+" "+"assurances\n" ;
            log.info(msg);
        }



    }


}



