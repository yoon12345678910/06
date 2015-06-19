package step01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Test01 {
  
  public static void main(String[] args) {
    ApplicationContext ctx =
        new ClassPathXmlApplicationContext(new String[] {"step01/application-context01.xml"});
    
    Car c1 = (Car)ctx.getBean("c1");
    Car c2 = (Car)ctx.getBean("c1");
    Car c3 = (Car)ctx.getBean("c3");
    Car c4 = (Car)ctx.getBean("c4");
    
    if(c1 == c2){
      System.out.println("c1과 c2는 같다");
    }
    
    if(c1 != c3){
      System.out.println("c1 != c3");
    }
    
    if(c3 != c4){
      System.out.println("c3 != c4");
    }

    if(c1 != c4){
      System.out.println("c1 != c4");
    }
    
    //존재하지 않는 빈을 요청할 때?
    Car c5 = (Car)ctx.getBean("c5");
    
  }
  
  /*public static void main(String[] args) {
    
    Car c = new Car();
    c.setModel("티코");
    c.setCapacity(5);
    c.setOutDate(Date.valueOf("2015-06-19"));
    
    System.out.println(c);
    
  }*/
}
