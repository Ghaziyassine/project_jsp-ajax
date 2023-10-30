<%@page import="ma.school.beans.Marque"%>
<%@page import="ma.school.service.MarqueService"%>
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
        <link href="style/monStyle.css" rel="stylesheet" type="text/css"/>
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    </head>
    <script>
                function confirmDelete(id) {
                var confirmation = confirm("Voulez-vous vraiment supprimer cette marque ?");
                        if (confirmation) {
                window.location.href = "MarqueController?op=delete&id=" + id;
                } else {
                // Annulation de la suppression
                }
                }

function modifierEtudiant(id) {
    Swal.fire({
        title: 'Modifier une marque',
        html:
            '<input id="code" class="swal2-input" placeholder="Code">' +
            '<input id="libelle" class="swal2-input" placeholder="Libellé">',
        showCancelButton: true,
        confirmButtonText: 'Modifier',
        onOpen: () => {
            // Vous pouvez également ajouter un sélecteur de date ici si nécessaire
        },
        preConfirm: () => {
            const code = Swal.getPopup().querySelector('#code').value;
            const libelle = Swal.getPopup().querySelector('#libelle').value;

            if (!code || !libelle) {
                Swal.showValidationMessage('Veuillez remplir tous les champs.');
            }

            return { code, libelle };
        }
    }).then((result) => {
        if (!result.dismiss) {
            const { code, libelle } = result.value;
            // Construisez l'URL avec les données
            const url = "MarqueController?op=update&id=" + id +
                "&code=" + code + "&libelle=" + libelle;

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
            <form method="GET" action="MarqueController">
                <fieldset>
                    <legend>Informations Marque</legend>
                    <table border="0">
                        <tr>
                            <td>Code</td>
                            <td><input id="code" type="text" name="code" value=""  required=""/></td>
                        </tr>
                        <tr>
                            <td>Libelle</td>
                            <td><input id="libelle" type="text" name="libelle" value="" required="" /></td>
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
                MarqueService ms = new MarqueService();
            %>
            <fieldset>
                <legend>Liste des marque</legend>

                <table border="1" class="tab">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Code <br>
                            <th>Libelle</th>

                            <th>Supprimer</th>
                            <th>Modifier</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            for (Marque m : ms.findAll()) {
                        %>
                        <tr>
                            <td><%=m.getId()%></td>
                            <td><%=m.getCode()%></td>
                            <td><%=m.getLibelle()%></td>

                            <td><a class="bndelete" href="#" onclick="confirmDelete(<%=m.getId()%>)">Supprimer</a></td>
                            <td>
                                <a class="bnupdate" href="javascript:void(0);" onclick="modifierEtudiant(<%=m.getId()%>)">Modifier</a>
                            </td>
                        </tr>
                        <%}%>
                    </tbody>
                </table>

            </fieldset>
        </form>            
</body>
</html>
