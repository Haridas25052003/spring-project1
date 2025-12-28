package spring_project1.spring_project1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dao.StudentDao;
import com.model.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context=new ClassPathXmlApplicationContext("bean.xml");
        
        StudentDao sd=context.getBean(StudentDao.class);
        
        Student s=new Student();
        
//        s.setName("sneha shinde");
//    	s.setCity("pangra shinde");
//    	s.setPercentage(86.89);
    	
    	System.out.println(sd.deleteStudentById(2));
    }
}
