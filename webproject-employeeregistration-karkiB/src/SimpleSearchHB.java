import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datamodel.Employeekarki;
import util.Info;
import util.UtilDBkarki;

@WebServlet("/SimpleSearchHB")
public class SimpleSearchHB extends HttpServlet implements Info {
   private static final long serialVersionUID = 1L;

   public SimpleSearchHB() {
      super();
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String keyword = request.getParameter("keyword").trim();

      response.setContentType("text/html");
      PrintWriter out = response.getWriter();
      String title = "Database Result";
      String docType = "<!doctype html public \"-//w3c//dtd html 4.0 transitional//en\">\n"; //
      out.println(docType + //
            "<html>\n" + //
            "<head><title>" + title + "</title></head>\n" + //
            "<body bgcolor=\"#f0f0f0\">\n" + //
            "<h1 align=\"center\">" + title + "</h1>\n");
      out.println("<ul>");

      List<Employeekarki> listEmployees = null;
      if (keyword != null && !keyword.isEmpty()) {
         listEmployees = UtilDBkarki.listEmployees(keyword);
      } else {
         listEmployees = UtilDBkarki.listEmployees();
      }
      display(listEmployees, out);
      out.println("</ul>");
      out.println("<a href=/" + projectName + "/" + searchWebName + ">Search Data</a> <br>");
      out.println("</body></html>");
   }

   void display(List<Employeekarki> listEmployees, PrintWriter out) {
      for (Employeekarki employeekarki : listEmployees) {
    	  System.out.println("[DBG] " + employeekarki.getId() + ", " //
                  + employeekarki.getFirstName() + ", " //
                  + employeekarki.getLastName() + ", " 
                  + employeekarki.getUserName() + ", " 
                  + employeekarki.getPassword() + ", " 
                  + employeekarki.getAddress() + ", " 
                  + employeekarki.getContact());


    	  out.println("<li>" + employeekarki.getId() + ", " //
          		+ employeekarki.getFirstName() + ", " //
                  + employeekarki.getLastName() + ", " 
                  + employeekarki.getUserName() + ", " 
                  + employeekarki.getPassword() + ", " 
                  + employeekarki.getAddress() + ", " 
                  + employeekarki.getContact() + "</li>");
      }
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }
}
