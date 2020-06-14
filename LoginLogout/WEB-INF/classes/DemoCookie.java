import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

public class DemoCookie extends HttpServlet{
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        Cookie ck[]=req.getCookies();  
          
        PrintWriter out=res.getWriter();
        out.println("<html><body>");
        out.print("Hello "+ck[0].getValue());
        out.println("</html></body>");
        out.close();
    }
}