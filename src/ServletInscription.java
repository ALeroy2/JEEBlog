import bean.Connexion;
import bean.Utilisateur;

import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ServletInscription extends javax.servlet.http.HttpServlet {

    public static final String ATT_USER = "user";
    public static final String ATT_CONNEXION = "connexion";
    public static final String ATT_SESSION_USER = "sessionUser";
    public static final String VUE = " /web/index.jsp";


    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        /*Affiche la page de connexion (index.jsp)*/
        this.getServletContext().getRequestDispatcher(VUE).forward(request,response);

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        /*Préparation de l'objet connexion*/
        Connexion connexion = new Connexion();

        /*traitement de la requête et récupération du bean en résultat*/
        Utilisateur user = connexion.connecterUtilisateur(request);

        /*Récupération de la session  depuis la requête*/
        HttpSession session = request.getSession();

        /**
         * Si aucune erreur de validation n'a eu lieu , alors ajout du bean
         * utilisateur  à la session, sinon suppression  du bean de la session
         */
        if (connexion.getErreurs().isEmpty()){
            session.setAttribute(ATT_SESSION_USER,user);
        } else{
            session.setAttribute(ATT_SESSION_USER,null);
        }

        /*Stockage de la connexion et du bean dans l'objet request*/
        request.setAttribute(ATT_CONNEXION,connexion);
        request.setAttribute(ATT_USER,user);

        this.getServletContext().getRequestDispatcher(VUE).forward(request,response);
    }
}
