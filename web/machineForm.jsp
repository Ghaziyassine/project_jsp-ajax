<%@page import="ma.school.beans.Machine"%>
<%@page import="ma.school.service.MachineService"%>
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
            var confirmation = confirm("Voulez-vous vraiment supprimer cette machine ?");
            if (confirmation) {
                window.location.href = "MachineController?op=delete&id=" + id;
            } else {
                // Annulation de la suppression
            }
        }
function modifierEtudiant(id) {
    Swal.fire({
        title: 'Modifier une machine',
        html:
            '<input id="reference" class="swal2-input" style="width: 70%;" placeholder="Référence">' +
            '<input id="prix" class="swal2-input" style="width: 70%;" placeholder="Prix">' +
            '<select id="marque" class="swal2-select" style="width: 70%;">' +
                                    <%
                                        MarqueService mrs = new MarqueService();
                                        for(Marque mq : mrs.findAll()){
                                    %>
                '<option value="<%=mq.getId()%>"><%=mq.getLibelle()%></option>' +
                
                <%}%>
            '</select>' +
            '<input id="dateAchat" class="swal2-input" style="width: 70%;" placeholder="Date d\'achat xx/xx/xxxx">',
        showCancelButton: true,
        confirmButtonText: 'Modifier',
        cancelButtonText: 'Annuler',
        onOpen: () => {
            flatpickr('#dateAchat', {
                dateFormat: 'Y-m-d',
            });
        },
        preConfirm: () => {
            const reference = Swal.getPopup().querySelector('#reference').value;
            const prix = Swal.getPopup().querySelector('#prix').value;
            const marque = Swal.getPopup().querySelector('#marque').value;
            const dateAchat = Swal.getPopup().querySelector('#dateAchat').value;

            if (!reference || !prix || !marque || !dateAchat) {
                Swal.showValidationMessage('Veuillez remplir tous les champs.');
            }

            return { reference, prix, marque, dateAchat };
        }
    }).then((result) => {
        if (!result.dismiss) {
            const { reference, prix, marque, dateAchat } = result.value;
            // Construisez l'URL avec les données
            const url = "MachineController?op=update&id=" + id +
                "&reference=" + reference + "&prix=" + prix +
                "&marque=" + marque + "&dateAchat=" + dateAchat;

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
            <form method="GET" action="MachineController">
                <fieldset>
                    <legend>Informations Machine</legend>
                    <table border="0">
                        <tr>
                            <td>Reference</td>
                            <td><input id="ref" type="text" name="ref" value=""  required=""/></td>
                        </tr>
                        <tr>
                            <td>Prix</td>
                            <td><input id="prix" type="text" name="prix" value="" required="" /></td>
                        </tr>
                        <tr>
                            <td>Marque</td>
                            <td>
                                <select id="marque" name="marque">
                                    <%
                                        MarqueService ms = new MarqueService();
                                        for(Marque m : ms.findAll()){
                                    %>
                                    <option value="<%=m.getId()%>"><%=m.getLibelle()%></option>
                                    <%}%>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Date Achat</td>
                            <td><input id="date" type="date" name="dateAchat" value="" required="" /></td>
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
                MachineService mms = new MachineService();
            %>
            <fieldset>
                <legend>Liste des Machines</legend>

                <table border="1" class="tab">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Reference <br>
                               
                            <th>Prix</th>
                            <th>Marque</th>
                            <th>Date d'achat</th>
                       
                            <th>Supprimer</th>
                            <th>Modifier</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            for (Machine mm : mms.findAll()) {
                        %>
                        <tr>
                            <td><%=mm.getId()%></td>
                            <td><%=mm.getReference()%></td>
                            <td><%=mm.getPrix()%></td>
                            <td><%=mm.getMarque().getLibelle()%></td>
                            <td><%=mm.getDateAchat()%></td>
                           <td><a class="bndelete" href="#" onclick="confirmDelete(<%=mm.getId()%>)">Supprimer</a></td>
                            <td>
                                <a class="bnupdate" href="javascript:void(0);" onclick="modifierEtudiant(<%=mm.getId()%>)">Modifier</a>
                            </td>
                        </tr>
                        <%}%>
                    </tbody>
                </table>

            </fieldset>
        </form>            
</body>
</html>
