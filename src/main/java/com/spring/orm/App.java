package com.spring.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        StudentDao studentDao = context.getBean("studentDao",StudentDao.class);
        
//        Student student=new Student(1234,"Kishan jha","Patna");
//        
//        int r = studentDao.insert(student);
//        System.out.println("Done..." +r);
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean go=true;
        
        
        while(go) {
        	System.out.println("Press 1 for add new Student.");
        	System.out.println("Press 2 for display Student.");
        	System.out.println("Press 3 for get detail of single Student.");
        	System.out.println("Press 4 for delete Student.");
        	System.out.println("Press 5 for update Student.");
        	System.out.println("Press 6 exit.");
        	
        	try {
        		
        		int input = Integer.parseInt(br.readLine());
        		
        		switch (input) {
				case 1:
					//add new Student
					//taking input from user
					System.out.println("Enter user id : ");
					int uId = Integer.parseInt(br.readLine());
					
					System.out.println("Enter user name : ");
					String uName = br.readLine();
					
					System.out.println("Enter user city : ");
					String uCity = br.readLine();
					
					//creating object of Student
					Student student = new Student();
					student.setStudentId(uId);
					student.setStudentName(uName);
					student.setStudentCity(uCity);
					
					//inserting student data
					int r = studentDao.insert(student);
					System.out.println(r + "Student added");
					System.out.println("*******************************************");
					System.out.println();
					
					break;
				case 2:
					//display Student
					System.out.println("*******************************************");
					List<Student> allStudents = studentDao.getAllStudents();
					for (Student student2 : allStudents) {
						System.out.println("Id : " +student2.getStudentId());
						System.out.println("Name : " +student2.getStudentName());
						System.out.println("City : " +student2.getStudentCity());
						System.out.println("---------------------------------------------");
					}
					System.out.println("*******************************************");
					break;
				case 3:
					//get detail of single Student
					System.out.println("Enter user id : ");
					int userId = Integer.parseInt(br.readLine());
					Student student2 = studentDao.getStudent(userId);
					System.out.println("Id : " +student2.getStudentId());
					System.out.println("Name : " +student2.getStudentName());
					System.out.println("City : " +student2.getStudentCity());
					System.out.println("---------------------------------------------");
					
					
					break;
				case 4:
					//delete Student
					System.out.println("Enter user id : ");
					int id = Integer.parseInt(br.readLine());
					studentDao.deleteStudent(id);
					System.out.println("Student deleted...");
					
					break;
				case 5:
					// update Student
					break;
				case 6:
					//exit
					go = false;
					break;

				
				}
				
			} catch (Exception e) {
				System.out.println("Invalid input try with another one!!");
			}
        }
        
        System.out.println("Thank you for using springorm application.");
        System.out.println("See you soon...!!");
    }
}
