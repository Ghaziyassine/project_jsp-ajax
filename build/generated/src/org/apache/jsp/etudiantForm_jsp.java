package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Date;
import ma.school.beans.Etudiant;
import ma.school.service.EtudiantService;

public final class etudiantForm_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/template/header.jsp");
    _jspx_dependants.add("/template/menu.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <script src=\"script/script.js\" type=\"text/javascript\"></script>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <script src=\"script/jsonExemple.js\" type=\"text/javascript\"></script>\n");
      out.write("        <link href=\"style/monStyle.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/sweetalert2@11\"></script>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <script>\n");
      out.write("        function confirmDelete(id) {\n");
      out.write("            var confirmation = confirm(\"Voulez-vous vraiment supprimer cet étudiant ?\");\n");
      out.write("            if (confirmation) {\n");
      out.write("                window.location.href = \"EtudiantController?op=delete&id=\" + id;\n");
      out.write("            } else {\n");
      out.write("                // Annulation de la suppression\n");
      out.write("            }\n");
      out.write("        }\n");
      out.write("     function modifierEtudiant(id) {\n");
      out.write("    Swal.fire({\n");
      out.write("        title: 'Modifier un étudiant',\n");
      out.write("        html:\n");
      out.write("            '<input id=\"nom\" class=\"swal2-input\" placeholder=\"Nom\">' +\n");
      out.write("            '<input id=\"prenom\" class=\"swal2-input\" placeholder=\"Prénom\">' +\n");
      out.write("            '<input id=\"ville\" class=\"swal2-input\" placeholder=\"Ville\">' +\n");
      out.write("            '<input id=\"date\" class=\"swal2-input\" placeholder=\"Date:xx/xx/xxxx\">' +\n");
      out.write("            '<input id=\"sexe\" class=\"swal2-input\" placeholder=\"Sexe (Homme ou Femme)\">',\n");
      out.write("        showCancelButton: true,\n");
      out.write("        confirmButtonText: 'Modifier',\n");
      out.write("        preConfirm: () => {\n");
      out.write("            const nom = Swal.getPopup().querySelector('#nom').value;\n");
      out.write("            const prenom = Swal.getPopup().querySelector('#prenom').value;\n");
      out.write("            const ville = Swal.getPopup().querySelector('#ville').value;\n");
      out.write("            const date = Swal.getPopup().querySelector('#date').value;\n");
      out.write("            const sexe = Swal.getPopup().querySelector('#sexe').value;\n");
      out.write("\n");
      out.write("            if (!nom || !prenom || !ville || !date || !sexe) {\n");
      out.write("                Swal.showValidationMessage('Veuillez remplir tous les champs.');\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            return { nom, prenom, ville, date, sexe };\n");
      out.write("        }\n");
      out.write("    }).then((result) => {\n");
      out.write("        if (!result.dismiss) {\n");
      out.write("            const { nom, prenom, ville, date, sexe } = result.value;\n");
      out.write("            // Construisez l'URL avec les données\n");
      out.write("            const url = \"EtudiantController?op=update&id=\" + id +\n");
      out.write("                \"&nom=\" + nom + \"&prenom=\" + prenom +\n");
      out.write("                \"&ville=\" + ville + \"&date=\" + date +\n");
      out.write("                \"&sexe=\" + sexe;\n");
      out.write("\n");
      out.write("            // Redirigez l'utilisateur vers l'URL\n");
      out.write("            window.location.href = url;\n");
      out.write("        }\n");
      out.write("    });\n");
      out.write("}\n");
      out.write("\n");
      out.write("    </script>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("        ");
      out.write("\n");
      out.write("<div class=\"header\" style=\"height:110px;width: 100%;\">\n");
      out.write("    <img id=\"logo\" src=\"images/Logo_Ensaj.png\" alt=\"logo\" style=\"width:100px;height:100px;\"/>     \n");
      out.write("    <span id=\"horloge\" style=\"font-family: Courier New;text-align: center; width:100%;\"></span>\n");
      out.write("</div>\n");
      out.write("<script src=\"script/horloge.js\" type=\"text/javascript\"></script>\n");
      out.write("\n");
      out.write("\n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<ul>\n");
      out.write("    <li><a class=\"active\" href=\"#home\">Home</a></li>\n");
      out.write("    <li><a href=\"etudiantForm.jsp\">Gestion des etudiants</a></li>\n");
      out.write("    <li><a href=\"marqueForm.jsp\">Gestion des marques</a></li>\n");
      out.write("    <li><a href=\"machineForm.jsp\">Gestion des machines</a></li>\n");
      out.write("    <li><a href=\"machineByMarqueForm.jsp\">Machines par marque</a></li>\n");
      out.write("    <li><a href=\"MachineByReference.jsp\">Machines par Reference</a></li>\n");
      out.write("\n");
      out.write("</ul>");
      out.write("\n");
      out.write("        <div class=\"content\">\n");
      out.write("            <form method=\"GET\" action=\"EtudiantController\">\n");
      out.write("                <fieldset>\n");
      out.write("                    <legend>Informations Etudiant</legend>\n");
      out.write("                    <table border=\"0\">\n");
      out.write("                        <tr>\n");
      out.write("                            <td>Nom</td>\n");
      out.write("                            <td><input id=\"nom\" type=\"text\" name=\"nom\" value=\"\"  required=\"\"/></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>Prenom</td>\n");
      out.write("                            <td><input id=\"prenom\" type=\"text\" name=\"prenom\" value=\"\" required=\"\" /></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>Ville</td>\n");
      out.write("                            <td>\n");
      out.write("                                <select id=\"ville\" name=\"ville\">\n");
      out.write("                                    <option value=\"Rabat\">Rabat</option>\n");
      out.write("                                    <option value=\"Fes\">Fes</option>\n");
      out.write("                                    <option value=\"Marakech\">Marrakech</option>\n");
      out.write("\n");
      out.write("                                </select>\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>Date de naissance</td>\n");
      out.write("                            <td><input id=\"date\" type=\"date\" name=\"dateNaissance\" value=\"\" required=\"\" /></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>Sexe</td>\n");
      out.write("                            <td>M<input id=\"m\" type=\"radio\" name=\"sexe\" value=\"homme\" />\n");
      out.write("                                F<input id=\"f\" type=\"radio\" name=\"sexe\" value=\"femme\" checked=\"checked\" /></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td></td>\n");
      out.write("                            <td>\n");
      out.write("                                <input name=\"op\" type=\"submit\" value=\"Envoyer\" />\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                    </table>\n");
      out.write("                </fieldset>\n");
      out.write("            </form>\n");
      out.write("            ");

                EtudiantService es = new EtudiantService();
            
      out.write("\n");
      out.write("            <fieldset>\n");
      out.write("                <legend>Liste des étudiants</legend>\n");
      out.write("\n");
      out.write("                <table border=\"1\" class=\"tab\">\n");
      out.write("                    <thead>\n");
      out.write("                        <tr>\n");
      out.write("                            <th>Id</th>\n");
      out.write("                            <th>Nom <br>\n");
      out.write("                               \n");
      out.write("                            <th>Prenom</th>\n");
      out.write("                            <th>Ville</th>\n");
      out.write("                            <th>Date de naissance</th>\n");
      out.write("                            <th>Sexe</th>\n");
      out.write("                            <th>Supprimer</th>\n");
      out.write("                            <th>Modifier</th>\n");
      out.write("                        </tr>\n");
      out.write("                    </thead>\n");
      out.write("                    <tbody>\n");
      out.write("                        ");

                            for (Etudiant e : es.findAll()) {
                        
      out.write("\n");
      out.write("                        <tr>\n");
      out.write("                            <td>");
      out.print(e.getId());
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(e.getNom());
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(e.getPrenom());
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(e.getVille());
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(e.getDateNaissance());
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(e.getSexe());
      out.write("</td>\n");
      out.write("                            <td><a class=\"bndelete\" href=\"#\" onclick=\"confirmDelete(");
      out.print(e.getId());
      out.write(")\">Supprimer</a></td>\n");
      out.write("                            <td>\n");
      out.write("                                <a class=\"bnupdate\" href=\"javascript:void(0);\" onclick=\"modifierEtudiant(");
      out.print(e.getId());
      out.write(")\">Modifier</a>\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                        ");
}
      out.write("\n");
      out.write("                    </tbody>\n");
      out.write("                </table>\n");
      out.write("\n");
      out.write("            </fieldset>\n");
      out.write("        </form>            \n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
