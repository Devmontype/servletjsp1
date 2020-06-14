import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.net.URLEncoder;
public class LoginServlet extends HttpServlet{
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        
        
        PrintWriter out=res.getWriter();
        req.getRequestDispatcher("link.html").include(req,res);
        String name=req.getParameter("name");
        String password=req.getParameter("password");
        
        if(name!=null&&!name.equals("")&&password.length()>=8){
            out.print("<br><p>You are logged in</p>");
            out.print("<br/>Welcome "+name);
            Cookie ck=new Cookie("name",URLEncoder.encode(name, "UTF-8"));
            res.addCookie(ck);
        }else{
            out.print("All fields are required and password length must be 8 charactered");
            req.getRequestDispatcher("login.html").include(req,res);
        }
        out.close();
    }
}