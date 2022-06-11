package web;
import java.io.PrintWriter;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/show")
public class Sample extends HttpServlet { // Servlet is small service
    
    @Override
    public void service(HttpServletRequest request,
                        HttpServletResponse response) 
    {
        // in JSP, we can use out.print() directly
        try {
            PrintWriter out = response.getWriter();
            String s = request.getParameter("city");
            if (s == null) {
                out.print("Please enter your city.");
            } else {
                String result = "No";
                for (int i = 0; i < branches.length; i++) {
                    if (branches[i].equals(s)) {
                        result = "Yes";
                    }
                }
                out.print("Your city is " + s + " : " + result);
            }
        } catch (Exception e) { }
    }
    String[] branches = { "New York", "London", "Paris" };         
}// There are two ways to use servlet
// 1. Write deployment descriptor (web.xml)
// 2. Use Annotation