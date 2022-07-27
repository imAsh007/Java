package streamapi;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeeDetails 
{
  public static void main(String[] args)
  {
	List<Employee> employeeList=new ArrayList<>();
	employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
	employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
	employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
	employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
	employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
	employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
	employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
	employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
	employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
	employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
	employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
	employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
	employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
	employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
	employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
	employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
	employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));

	countMaleFemale(employeeList);
	nameOfDepartment( employeeList);
	averageAgeOfMaleAndFemale(employeeList);
	averageAge(employeeList);
	countMale( employeeList);
	LowestPaidEmployee(employeeList);
	highestPaidEmployee(employeeList);
	joiningDetails(employeeList);
	//eachDepartmentEmployee(employeeList);
	 averageSalary(employeeList);
	  yongestEmployee(employeeList);
	  most_Experienced_Employee(employeeList);
	count_Male_Female_In_Sales_And_Marketing(employeeList);
	average_Salary_Of_Male_And_Female_Employee(employeeList);
	//name_Of_Employee_In_Each_Department(employeeList);
	
  }
  public static  void countMaleFemale(List<Employee> employeeList)
  {
	  Map<String, Long> noOfMaleAndFemaleEmployees=
			  employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
			           
			  System.out.println(noOfMaleAndFemaleEmployees);
  }
  
  
  public static void countMale(List<Employee> employeeList)
  {
	  employeeList.stream().filter(e->e.getGender().equals("Male")).forEach(System.out::println);
  }
  
  
  public static void nameOfDepartment(List<Employee> employeeList)
  {
	  employeeList.stream().map(Employee::getDepartment).forEach(System.out::println);
	    //distinct.forEach(System.out::println);   
	    //  List<String> collect = distinct.collect(Collectors.toList());
	    //  System.out.println(collect);
	  //Stream<String> distinct =
  }
  
  public static void averageAgeOfMaleAndFemale(List<Employee> employeeList)
  {
	 Map<String,Double>averageage= employeeList.stream().
			 collect(Collectors.groupingBy(Employee::getGender,Collectors.averagingDouble(Employee::getAge)));
	 System.out.println(averageage);
  }
  
  public static void averageAge(List<Employee> employeeList)
  {
	  Double collect = employeeList.stream().collect(Collectors.averagingDouble(Employee::getAge));
	  System.out.println(collect);
  }
  
  
  public static void highestPaidEmployee(List<Employee> employeeList)
  {
	 Optional<Employee> collect = employeeList.stream().collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));
	 System.out.println(collect);
  }
  
  
  public static void LowestPaidEmployee(List<Employee> employeeList)
  {
	   Optional<Employee> collect = employeeList.stream().collect(Collectors.minBy(Comparator.comparingDouble(Employee::getSalary)));
      System.out.println(collect);
	//  Employee employee1 = collect.get();
	 // Employee employee2 = collect.get();
	 // System.out.println("Age:"+" "+employee1.getAge());
	 // System.out.println("Age:"+" "+employee2.getSalary());
  }
  
  public static void joiningDetails(List<Employee>employeeList)
  {
	  //Optional<Employee> collect = employeeList.stream().collect(Collectors.minBy(Comparator.comparingInt(Employee::getYearOfJoining))); 
	  //System.out.println(collect);     //Oldest employee
	  
	  // long filter = employeeList.stream().filter(i->i.getYearOfJoining()>2015).count();
	 // System.out.println(filter);    //No of people who joined after 2015
	  
	  employeeList.stream().filter(i->i.getYearOfJoining()>2015).map(Employee::getName).forEach(System.out::println);
  }
  
 /* public static void eachDepartmentEmployee(List<Employee>employeeList)
  {
	 //Map<String,Long>number= employeeList.stream().collect(Collectors.groupingBy(Employee::getName),Collectors.counting());
 
	 Map<String, List<Employee>> dept = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment));
      //how to make it as a list	
  }*/
  
  
  public static void averageSalary(List<Employee>employeeList)
  {
	Map<String,Double>ashu= employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.averagingDouble(Employee::getSalary))); 
     System.out.println(ashu);
  }
  
  public static void yongestEmployee(List<Employee>employeeList)
  { 
	 // employeeList.stream().filter(e->e.getDepartment().equals("Product Development")).forEach(System.out::println);
	       //All emp of product dept.
	  
	
	 //Optional<Employee> collect = employeeList.stream().filter(e->e.getDepartment().equals("Product Development")).
		 // collect(Collectors.minBy(Comparator.comparingDouble(Employee::getSalary)));  // new Joiner   
	    // System.out.println(collect);
	  
	  
	  Optional<Employee> collect = employeeList.stream().filter(e->e.getDepartment().equals("Product Development")&& e.getGender().equals("Male")).
				 collect(Collectors.minBy(Comparator.comparingDouble(Employee::getAge)));
            System.out.println(collect);           //youngest employee
  }

  
  public static void most_Experienced_Employee(List<Employee>employeeList)
  {
	  Optional<Employee> collect = employeeList.stream().collect(Collectors.minBy(Comparator.comparingInt(Employee::getYearOfJoining)));
	  System.out.println(collect);
  }
  
  
  public static void count_Male_Female_In_Sales_And_Marketing(List<Employee>employeeList)
  {
	// Long collect = employeeList.stream().filter(i->i.getDepartment().equals("Sales And Marketing")).collect(Collectors.counting());
     // System.out.println(collect);   //Total employee in dept
	  
	  
   	 // Map<String,Long>number= employeeList.stream().filter(i->i.getDepartment().equals("Sales And Marketing")
	  //.collect(Collectors.groupingBy(Employee::getGender), Collectors.counting()));
     // System.out.println(number);

  }
  
  public static void average_Salary_Of_Male_And_Female_Employee(List<Employee>employeeList)
  {
	  //Map<String, Double>average= employeeList.stream()
	  //.collect(Collectors.groupingBy(Employee::getGender),Collectors.averagingDouble(Employee::getSalary))); 
	

		Map<String,Double>ashu= employeeList.stream().collect
			(Collectors.groupingBy(Employee::getGender,Collectors.averagingDouble(Employee::getSalary))); 
	     System.out.println(ashu);
  }
  
  /*public static void name_Of_Employee_In_Each_Department(List<Employee>employeeList)
  {
	employeeList.stream().map(Employee::getDepartment).distinct().forEach(System.out::println);//it will print all dept name without repeatition
	
	//employeeList.stream().collect(Collectors.groupingBy(Employee::getName)).map(Employee::getDepartment);
	//.collect(Collectors.groupingBy(Employee::getName),Collectors.counting());
  }*/
  
}


