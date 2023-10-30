package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import ma.school.beans.Etudiant;
import ma.school.service.EtudiantService;

public final class modifierEtudiant_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <title>Modifier un étudiant</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    ");
      out.write("\n");
      out.write("<div class=\"header\" style=\"height:110px;width: 100%;\">\n");
      out.write("    <img id=\"logo\" src=\"images/logo.png\" alt=\"logo\" style=\"width:100px;height:100px;\"/>     \n");
      out.write("    <span id=\"horloge\" style=\"font-family: Courier New;text-align: center; width:100%;\"></span>\n");
      out.write("</div>\n");
      out.write("<script src=\"script/horloge.js\" type=\"text/javascript\"></script>\n");
      out.write("\n");
      out.write("\n");
      out.write("    ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<ul>\n");
      out.write("    <li><a class=\"active\" href=\"#home\">Home</a></li>\n");
      out.write("    <li><a href=\"etudiantForm.jsp\">Gestion des etudiants</a></li>\n");
      out.write("    <li><a href=\"marqueForm.jsp\">Gestion des marques</a></li>\n");
      out.write("    <li><a href=\"machineForm.jsp\">Gestion des machines</a></li>\n");
      out.write("    <li><a href=\"machineByMarqueForm.jsp\">Machines par marque</a></li>\n");
      out.write("\n");
      out.write("</ul>");
      out.write("\n");
      out.write("    <div class=\"content\">\n");
      out.write("        <h1>Modifier un étudiant</h1>\n");
      out.write("        \n");
      out.write("        ");
 
            // Récupérez l'ID de l'étudiant à partir de la requête
            int etudiantId = Integer.parseInt(request.getParameter("id"));
            
            // Utilisez un service pour obtenir les détails de l'étudiant par son ID
            EtudiantService es = new EtudiantService();
            Etudiant etudiant = es.findById(etudiantId);
        
      out.write("\n");
      out.write("        \n");
      out.write("        <form method=\"POST\" action=\"EtudiantController\">\n");
      out.write("            <input type=\"hidden\" name=\"op\" value=\"update\">\n");
      out.write("            <input type=\"hidden\" name=\"id\" value=\"");
      out.print(etudiant.getId());
      out.write("\">\n");
      out.write("            \n");
      out.write("            <fieldset>\n");
      out.write("                <legend>Informations Etudiant</legend>\n");
      out.write("                <table border=\"0\">\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Nom</td>\n");
      out.write("                        <td><input type=\"text\" name=\"nom\" value=\"");
      out.print(etudiant.getNom());
      out.write("\" required></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Prénom</td>\n");
      out.write("                        <td><input type=\"text\" name=\"prenom\" value=\"");
      out.print(etudiant.getPrenom());
      out.write("\" required></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Ville</td>\n");
      out.write("                        <td>\n");
      out.write("                            <select name=\"ville\">\n");
      out.write("                                <option value=\"Rabat\" ");
      out.print( etudiant.getVille().equals("Rabat") ? "selected" : "" );
      out.write(">Rabat</option>\n");
      out.write("                                <option value=\"Fes\" ");
      out.print( etudiant.getVille().equals("Fes") ? "selected" : "" );
      out.write(">Fes</option>\n");
      out.write("                                <option value=\"Marrakech\" ");
      out.print( etudiant.getVille().equals("Marrakech") ? "selected" : "" );
      out.write(">Marrakech</option>\n");
      out.write("                            </select>\n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Date de naissance</td>\n");
      out.write("                        <td><input type=\"date\" name=\"dateNaissance\" value=\"");
      out.print(etudiant.getDateNaissance());
      out.write("\" required></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Sexe</td>\n");
      out.write("                        <td>\n");
      out.write("                            M<input type=\"radio\" name=\"sexe\" value=\"homme\" ");
      out.print( etudiant.getSexe().equals("homme") ? "checked" : "" );
      out.write(">\n");
      out.write("                            F<input type=\"radio\" name=\"sexe\" value=\"femme\" ");
      out.print( etudiant.getSexe().equals("femme") ? "checked" : "" );
      out.write(">\n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td></td>\n");
      out.write("                        <td>\n");
      out.write("                            <input type=\"submit\" value=\"Mettre à jour\">\n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                </table>\n");
      out.write("            </fieldset>\n");
      out.write("        </form>\n");
      out.write("    </div>\n");
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
