package bean;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public final class Connexion {
    private static final String CHAMP_EMAIL = "email";
    private static final String CHAMP_PASS = "motdepasse";

    private String resultat;
    private Map<String,String> erreurs = new HashMap<String, String>();


    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public Utilisateur connecterUtilisateur(HttpServletRequest request){
        /* Récupération des champs du formulaire*/
        String email = getValeurChamp(request, CHAMP_EMAIL);
        String motDePasse = getValeurChamp( request, CHAMP_PASS);

        Utilisateur user = new Utilisateur();

        /* Validation du champ Email*/
        try{
            validationEmail(email);
        } catch (Exception e) {
            setErreur(CHAMP_EMAIL, e.getMessage());
        }
        user.setEmail(email);
        
        /* Validation du mot de passe */
        try{
            validationMotDePasse(motDePasse);
        }catch (Exception e) {
            setErreur(CHAMP_PASS, e.getMessage());
        }
        user.setPassword(motDePasse);

        /**/
        if (erreurs.isEmpty()){
            resultat="Succès de la connexion";
        }else{
           resultat="Echec de la connexion";
        }

        return user;
    }

    private void validationMotDePasse(String motDePasse) throws Exception {
        if(motDePasse != null){
            if(motDePasse.length() < 3){
                throw new Exception(" Le mot de passe est trop court il doit contenir au moins 3 caractères");
            }
        } else {
            throw new Exception("Veuillez saisir un mot de passe");
        }
    }

    private String getValeurChamp(HttpServletRequest request, String nomChamp) {
        String valeur = request.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur;
        }
    }

    private void setErreur(String champ, String message) {
        erreurs.put(champ,message);
    }

    private void validationEmail(String email) throws Exception {
        if ( email != null && !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
            throw new Exception( "Merci de saisir une adresse mail valide." );
        }
    }

    public String getResultat() {
        return resultat;
    }
}