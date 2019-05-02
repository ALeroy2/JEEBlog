import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ServletInscription extends javax.servlet.http.HttpServlet {

    public static final String VUE = "/web/index.jsp";
    public static final String CHAMP_EMAIL = "email";
    public static final String CHAMPS_PASS = "motdepasse";
    public static final String CHAMP_CONF = "confirmation";
    public static final String CHAMP_NOM = "nom";
    public static final String ATT_ERREURS = "erreurs";
    public  static final String ATT_RESULTAT = "resultat";

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        String resultat;
        Map<String, String> erreurs = new HashMap<String, String>();

        /* Récupération des champs du formulaire */
        String email = request.getParameter(CHAMP_EMAIL);
        String motDePasse = request.getParameter(CHAMPS_PASS);
        String confirmation = request.getParameter(CHAMP_CONF);
        String nom = request.getParameter(CHAMP_NOM);

        /*Validation du champs email*/
        try{
            validationEmail(email);
        }catch (Exception e){
            erreurs.put(CHAMP_EMAIL, e.getMessage());
        }

        /*Validation des champs de mots de passe et confirmation*/
        try{
            validationMotDePasse( motDePasse, confirmation);
        }catch (Exception e){
            erreurs.put(CHAMPS_PASS, e.getMessage());
        }

        /*Validation du champ nom*/
        try{
            validationNom(nom);
        }catch (Exception e){
            erreurs.put(CHAMP_NOM, e.getMessage());
        }

        /*Initialisation du résultat de la validation*/
        if(erreurs.isEmpty()){
            resultat = "Succès de l'inscription";
        }else {
            resultat = "Echec de l'inscrition";
        }

        /*Stockage du résultat et des messages d'erreur dans l'objet request*/
        request.setAttribute(ATT_ERREURS, erreurs);
        request.setAttribute(ATT_RESULTAT, resultat);

        /*transmission de la paire d'objet request/response au JSP*/
        this.getServletContext().getRequestDispatcher(VUE).forward(request,response);

    }

    /**
     * Valide l'adresse mail saisi
     */

    private void validationEmail(String email) throws Exception {
        if(email != null && email.trim().length() != 0){
            if( !email.matches("([^.@]+)(\\.[^.@]+\\.)+([^.@]+)")){
                throw new Exception("Merci de saisir une adresse mail valide");
            }
        }else {
            throw new Exception("Merci de saisir une adresse mail");
        }
    }
    /**
     * Valide les mots de passes saisis
     */

    private void validationMotDePasse(String motDePasse, String confirmation) throws Exception {
        if(motDePasse != null && motDePasse.trim().length() != 0 && confirmation != null && confirmation.trim().length() != 0){
            if (!motDePasse.equals(confirmation)){
                throw  new Exception("Les mots de passe entrés sont différents, merci de les saisir à nouveau");
            } else if (motDePasse.trim().length() < 3){
                throw new Exception("Les mots de passse doivent contenir au minimum 3 caractères");
            }
        }else {
            throw new Exception("Merci de saisir et confirmer votre mot de passe");
        }
    }
    /**
     * Valide le nom de l'utilisateur saisi
     */

    private void validationNom(String nom) throws Exception {
        if (nom != null && nom.trim().length() < 2){
            throw new Exception("Le nom de l'utilisateur doit contenir au moins 2 caratères");
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        /* Affichage de la page d'inscription */
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );

    }
}
