import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.Info;
import util.UtilDBkarki;

@WebServlet("/insertEmployeeInfo")
public class insertEmployeeInfo extends HttpServlet implements Info {
   private static final long serialVersionUID = 1L;

   public insertEmployeeInfo() {
      super();
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String firstName = request.getParameter("firstName").trim();
      String lastName = request.getParameter("lastName").trim();
      String userName = request.getParameter("userName").trim();
      String password = request.getParameter("password").trim();
      String address = request.getParameter("address").trim();
      String contact = request.getParameter("contact").trim();
      UtilDBkarki.createEmployees(firstName, lastName, userName, password, address, contact);

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
      out.println("<li> First Name: " + firstName);
      out.println("<li> Last Name: " + lastName);
      out.println("<li> User Name: " + userName);
      out.println("<li> Password: " + password);
      out.println("<li> Address: " + address);
      out.println("<li> Contact: " + contact);
      out.println("</ul>");
      out.println("<a href=/" + projectName + "/" + searchWebName + ">Search Data</a> <br>");
      out.println("</body></html>");
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }
}
