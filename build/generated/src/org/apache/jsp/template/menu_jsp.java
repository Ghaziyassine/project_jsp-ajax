package org.apache.jsp.template;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class menu_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

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
      out.write("<ul class=\"bg-blue-500 text-white p-4 space-y-2\">\n");
      out.write("    <li>\n");
      out.write("        <a class=\"block p-2 hover:bg-blue-600\" href=\"#home\">Home</a>\n");
      out.write("    </li>\n");
      out.write("    <li>\n");
      out.write("        <a class=\"block p-2 hover:bg-blue-600\" href=\"etudiantForm.jsp\">Gestion des étudiants</a>\n");
      out.write("    </li>\n");
      out.write("    <li>\n");
      out.write("        <a class=\"block p-2 hover:bg-blue-600\" href=\"marqueForm.jsp\">Gestion des marques</a>\n");
      out.write("    </li>\n");
      out.write("    <li>\n");
      out.write("        <a class=\"block p-2 hover:bg-blue-600\" href=\"machineForm.jsp\">Gestion des machines</a>\n");
      out.write("    </li>\n");
      out.write("    <li>\n");
      out.write("        <a class=\"block p-2 hover:bg-blue-600\" href=\"machineByMarqueForm.jsp\">Machines par marque</a>\n");
      out.write("    </li>\n");
      out.write("</ul>\n");
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
