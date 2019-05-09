<%--@elvariable id="connexion" type="bean.Connexion"--%>
<%@ page pageEncoding="UTF-8" %>
<%@ page import="bean.Connexion" %>
<%--
  Created by IntelliJ IDEA.
  User: Alexis
  Date: 30/04/2019
  Time: 09:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>My EPSI Blog</title>
  <link rel="stylesheet" type="text/css" href="style.css">


</head>
<body>
<div class="container">

  <div>
    <button id="signin-button">Connexion</button>
    <button id="signup-button">Inscription</button>
  </div>
  <%--@elvariable id="user" type="bean.Utilisateur"--%>
  <div>
    <form id="signup-form">
      <input type="text" placeholder="USERNAME" id="nom" name="nom" value="${user.nom}" size="20" maxlength="60"/>
      <span class="erreur">${connexion.erreurs['nom']}</span>
      <input type="email" placeholder="EMAIL" id= "email" name="email" value=" ${user.email}" size="20" maxlength="60"/>
      <span class="erreurs">${connexion.erreurs['email']}</span>
      <input type="password" placeholder="PASSWORD" id= "modepasse" name="motdepasse" value="${user.password}" size="20" maxlength="60"/>
      <span class =erreurs>${connexion.erreurs['motdepasse']}</span>
      <button type="button" class="submit-button" >Sign up !</button>
    </form>
    <form id="signin-form">
      <input type="email" placeholder="USERNAME" id="mail" name="email" value="${user.email}" size="20" maxlength="60"/>
      <input type="password" placeholder="PASSWORD" id="motdepasse" name="motdepasse" value="${user.password}" size="20" maxlength="60"/>
        <button type="button" class="submit-button" >Sign In</button>
      <p class="${empty connexion.erreurs ? 'succes' : 'erreur'}">${connexion.resultat}</p>
    </form>
  </div>
</div>

<script type="text/javascript" src="https://code.jquery.com/jquery.js"></script>
<script type="text/javascript" src="index.js"></script>
</body>

</html>
