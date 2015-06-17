package net.bitacademy.spring.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.bitacademy.spring.controller.PageController;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

@WebServlet(urlPatterns ="*.do", loadOnStartup=1)
public class DispatcherServlet extends HttpServlet{
  private static final long serialVersionUID = 1L;
  
  ApplicationContext beanContainer;
  
  @Override
  public void init() throws ServletException {
    beanContainer =
        new FileSystemXmlApplicationContext(
            this.getServletContext().getRealPath("/")
            + "/WEB-INF/config/application-context.xml");
      
  }
  
  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    req.setCharacterEncoding("UTF-8");
    resp.setContentType("text/html;charset=UTF-8");
    
    try{
    String servletPath = req.getServletPath();
    String viewUrl = null;
    
    PageController controller = (PageController)beanContainer.getBean(servletPath);
    
      if(controller != null){
        viewUrl =  controller.execute(req, resp);
      }else{
        throw new Exception("해당 URL을 처리할 수 없습니다.");
      }

      if(viewUrl.startsWith("redirect:")){
        resp.sendRedirect(viewUrl.substring(9));
      }else{
        RequestDispatcher rd = req.getRequestDispatcher(viewUrl);
        rd.include(req, resp);
      }
      
    }  catch (Exception e) {
      req.setAttribute("error", e);
      RequestDispatcher rd = req.getRequestDispatcher("/error.jsp");
      rd.include(req, resp);

    }

  }
}
