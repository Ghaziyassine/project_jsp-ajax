<%@page import="java.util.Date"%>
<%@page import="ma.school.beans.Etudiant"%>
<%@page import="ma.school.service.EtudiantService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="script/script.js" type="text/javascript"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="script/jsonExemple.js" type="text/javascript"></script>
        <link href="style/monStyle.css" rel="stylesheet" type="text/css"/>
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>

    </head>
    <script>
        function confirmDelete(id) {
            var confirmation = confirm("Voulez-vous vraiment supprimer cet étudiant ?");
            if (confirmation) {
                window.location.href = "EtudiantController?op=delete&id=" + id;
            } else {
                // Annulation de la suppression
            }
        }
     function modifierEtudiant(id) {
    Swal.fire({
        title: 'Modifier un étudiant',
        html:
            '<input id="nom" class="swal2-input" placeholder="Nom">' +
            '<input id="prenom" class="swal2-input" placeholder="Prénom">' +
            '<input id="ville" class="swal2-input" placeholder="Ville">' +
            '<input id="date" class="swal2-input" placeholder="Date:xx/xx/xxxx">' +
            '<input id="sexe" class="swal2-input" placeholder="Sexe (Homme ou Femme)">',
        showCancelButton: true,
        confirmButtonText: 'Modifier',
        preConfirm: () => {
            const nom = Swal.getPopup().querySelector('#nom').value;
            const prenom = Swal.getPopup().querySelector('#prenom').value;
            const ville = Swal.getPopup().querySelector('#ville').value;
            const date = Swal.getPopup().querySelector('#date').value;
            const sexe = Swal.getPopup().querySelector('#sexe').value;

            if (!nom || !prenom || !ville || !date || !sexe) {
                Swal.showValidationMessage('Veuillez remplir tous les champs.');
            }

            return { nom, prenom, ville, date, sexe };
        }
    }).then((result) => {
        if (!result.dismiss) {
            const { nom, prenom, ville, date, sexe } = result.value;
            // Construisez l'URL avec les données
            const url = "EtudiantController?op=update&id=" + id +
                "&nom=" + nom + "&prenom=" + prenom +
                "&ville=" + ville + "&date=" + date +
                "&sexe=" + sexe;

            // Redirigez l'utilisateur vers l'URL
            window.location.href = url;
        }
    });
}

    </script>

    <body>
        <%@include file="template/header.jsp" %>
        <%@include file="template/menu.jsp" %>
        <div class="content">
            <form method="GET" action="EtudiantController">
                <fieldset>
                    <legend>Informations Etudiant</legend>
                    <table border="0">
                        <tr>
                            <td>Nom</td>
                            <td><input id="nom" type="text" name="nom" value=""  required=""/></td>
                        </tr>
                        <tr>
                            <td>Prenom</td>
                            <td><input id="prenom" type="text" name="prenom" value="" required="" /></td>
                        </tr>
                        <tr>
                            <td>Ville</td>
                            <td>
                                <select id="ville" name="ville">
                                    <option value="Rabat">Rabat</option>
                                    <option value="Fes">Fes</option>
                                    <option value="Marakech">Marrakech</option>

                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Date de naissance</td>
                            <td><input id="date" type="date" name="dateNaissance" value="" required="" /></td>
                        </tr>
                        <tr>
                            <td>Sexe</td>
                            <td>M<input id="m" type="radio" name="sexe" value="homme" />
                                F<input id="f" type="radio" name="sexe" value="femme" checked="checked" /></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td>
                                <input name="op" type="submit" value="Envoyer" />
                            </td>
                        </tr>
                    </table>
                </fieldset>
            </form>
            <%
                EtudiantService es = new EtudiantService();
            %>
            <fieldset>
                <legend>Liste des étudiants</legend>

                <table border="1" class="tab">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Nom <br>
                               
                            <th>Prenom</th>
                            <th>Ville</th>
                            <th>Date de naissance</th>
                            <th>Sexe</th>
                            <th>Supprimer</th>
                            <th>Modifier</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            for (Etudiant e : es.findAll()) {
                        %>
                        <tr>
                            <td><%=e.getId()%></td>
                            <td><%=e.getNom()%></td>
                            <td><%=e.getPrenom()%></td>
                            <td><%=e.getVille()%></td>
                            <td><%=e.getDateNaissance()%></td>
                            <td><%=e.getSexe()%></td>
                            <td><a class="bndelete" href="#" onclick="confirmDelete(<%=e.getId()%>)">Supprimer</a></td>
                            <td>
                                <a class="bnupdate" href="javascript:void(0);" onclick="modifierEtudiant(<%=e.getId()%>)">Modifier</a>
                            </td>
                        </tr>
                        <%}%>
                    </tbody>
                </table>

            </fieldset>
        </form>            
</body>
</html>
