import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.net.URLDecoder;
public class LogoutServlet extends HttpServlet{
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        res.setContentType("text/html");
        
        
        PrintWriter out=res.getWriter();
        req.getRequestDispatcher("link.html").include(req,res); 
        Cookie ck[]=req.getCookies(); 
        if(ck!=null){
            String name=URLDecoder.decode(ck[0].getValue(),"UTF-8");
            if(name.equals("")||name!=null){
                ck[0].setValue("");
                ck[0].setMaxAge(0);
                res.addCookie(ck[0]);
                out.print("<br/>You are successfully loggedout");
            }
            
        }else{
            out.println("Please login first");
            req.getRequestDispatcher("login.html").include(req,res);
        }
        out.close();
    }
}