package servlet;




import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

@WebServlet
public class Connection extends HttpServlet {

    public static final String ATT_NOM = "nom";
    public static final String ATT_PASS = "motdepasse";
    public static final String VUE = "/web/blog.jsp";

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        /* Récupération des champs du formulaire. */
        String motdepasse = request.getParameter( ATT_PASS );
        String nom = request.getParameter( ATT_NOM);

        try {
            validationMotsDePasse( motdepasse);
            validationNom( nom );
        } catch (Exception e) {
            /* Gérer les erreurs de validation ici. */
        }

        /*Affiche la page de connexion (index.jsp)*/
        this.getServletContext().getRequestDispatcher(VUE).forward(request, response);

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException{

        this.getServletContext().getRequestDispatcher(VUE).forward(request, response);

    }

    private void validationNom( String nom ) throws Exception {
        if ( nom != null && nom.trim().length() < 3 ) {
            throw new Exception( "Le nom d'utilisateur doit contenir au moins 3 caractères." );
        }
    }

    private void validationMotsDePasse( String motDePasse) throws Exception{
        if (motDePasse != null && motDePasse.trim().length() != 0) {
            if (motDePasse.trim().length() < 3) {
                throw new Exception("Le mot de passe doit être composé de minimum 3 caractères");
            }
        }
    }

}
