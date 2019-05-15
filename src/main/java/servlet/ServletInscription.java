package servlet;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("Inscription")
public class ServletInscription extends javax.servlet.http.HttpServlet {

    public static final String ATT_NOM = "nom";
    public static final String ATT_EMAIL = "email";
    public static final String ATT_PASS = "motdepasse";
    public static final String VUE = " /web/index.jsp";


    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        /* Récupération des champs du formulaire. */
        String email = request.getParameter( ATT_EMAIL );
        String motDePasse = request.getParameter( ATT_PASS );
        String nom = request.getParameter( ATT_NOM);

        try {
            validationEmail( email );
            validationMotsDePasse( motDePasse);
            validationNom( nom );
        } catch (Exception e) {
            /* Gérer les erreurs de validation ici. */
        }

        /*Affiche la page de connexion (index.jsp)*/
        this.getServletContext().getRequestDispatcher(VUE).forward(request,response);

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        this.getServletContext().getRequestDispatcher(VUE).forward(request,response);
    }

    /**
     * Valide l'adresse mail saisie.
     */
    private void validationEmail( String email ) throws Exception {
        if ( email != null && email.trim().length() != 0 ) {
            if ( !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
                throw new Exception( "Merci de saisir une adresse mail valide." );
            }
        } else {
            throw new Exception( "Merci de saisir une adresse mail." );
        }
    }

    /**
     * Valide le mot de passe saisi.
     */
    private void validationMotsDePasse( String motDePasse) throws Exception{
        if (motDePasse != null && motDePasse.trim().length() != 0) {
             if (motDePasse.trim().length() < 3) {
                 throw new Exception("Le mot de passe doit être composé de minimum 3 caractères");
             }
        }
    }

    /**
     * Valide le nom d'utilisateur saisi.
     */
    private void validationNom( String nom ) throws Exception {
        if ( nom != null && nom.trim().length() < 3 ) {
            throw new Exception( "Le nom d'utilisateur doit contenir au moins 3 caractères." );
        }
    }

}
