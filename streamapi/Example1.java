package streamapi;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Example1
{
   public static void main(String args[])
   {
	 List<Integer>list=new ArrayList<>();
	  list.add(3);
	  list.add(2);
	  list.add(4);
	  list.add(6);
	  List<Integer>list1= list.stream().filter(i->i%2==0).collect(Collectors.toList());
	  System.out.print(list1);
	 
   }
   
}
