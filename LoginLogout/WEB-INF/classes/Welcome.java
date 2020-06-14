import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.Enumeration;

public class Welcome extends HttpServlet{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    
    public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
        res.setContentType("text/html");
        ServletConfig config=getServletConfig();
        PrintWriter out=res.getWriter();
        // String createdBy=config.getInitParameter("createdby");
        Enumeration<String> e=config.getInitParameterNames();  

        String str="";  
        while(e.hasMoreElements()){  
            str=e.nextElement();  
            out.print("<br>Name: "+str);  
            out.print(" value: "+config.getInitParameter(str));  
        } 
        
        String name=req.getParameter("name");
        Cookie ck=new Cookie("uname",name);
        res.addCookie(ck);
        out.print("HI");
        out.print(name);
        out.close();
    }
}