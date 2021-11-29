/* Alg to generate random employees */

import java.util.Scanner;
import java.util.Random;
import java.util.HashMap;

public class EmployeesDM {
	

	public static void main(String[] args) {

		String[] first_names = {"Juan","Jose","Luis","Maria","Guadalupe","Francisco","Juana",
				"Antonio","Jesus","Elena","Pedro","Angel","Manuel","Margarita","Carmen","Carlos",
				"Roberto","Josefina","Veronica","Fernando"};
		String[] last_names = {"Hernandez","Garcia","Martinez","Lopez","Gonzales","Perez","Rodriguez",
				"Sanchez","Ramirez","Cruz","Flores","Gomez","Peña","Sandoval","Avila","Corona","Mex",
				"Puc","Argaez","Llanes"};
		
		boolean ans=true;
		Scanner n = new Scanner(System.in);
		Scanner input = new Scanner(System.in);
		
		generate(first_names,last_names,n,input,ans); //call generate function for request employees.
	} 
	
	
	public static void generate(String[] first_names,String[] last_names,Scanner n,Scanner input,boolean ans) {
		
		HashMap<String,String> employees = new HashMap<>(); //to store all employees generated.
		String full_name; //employee's full name
		String email; //employee's full email
		int count=1;
		
		while (ans==true) {
			
			try {  //following good flow of the requests (without exceptions)
				
				System.out.println("Insert how many employees u want to generate: ");
				int times = n.nextInt();	
				
				//random choose of first and last names.
				Random id = new Random();  
				for(int i=1; i<=times; i++) {
					int x = id.nextInt(first_names.length);
					int y = id.nextInt(last_names.length);
					
					full_name = first_names[x]+" "+last_names[y];
					email = first_names[x]+"."+last_names[y]+"@mail.com";
					
					//verify employee has been already generated (avoid duplicate)
					if (employees.containsKey(full_name)==true) {
						i-=1;
						}
					else {
						employees.put(full_name, email);
						System.out.println("Adding employee: "+full_name+" with email "+email);
						}
					}
				
				//request to more employees
				System.out.println();
				System.out.println("Do u want to generate more employees? (Y/y or N/n): ");
				String newans = input.nextLine();
				
				if (newans.equals("N")||newans.equals("n")){
					ans=false;
					System.out.println();
					}
				else if(newans.equals("Y")||newans.equals("y")) {
					System.out.println();
					continue;
					}
				else {
					System.out.println();
					System.out.println("x Invalid option! Type Y/y if 'yes' or N/n if 'not'. Try it again");
					System.out.println("Do u want to generate more employees? (Y/y or N/n): ");
					newans = input.nextLine();
					if (newans.equals("N")||newans.equals("n")){
						ans=false;
						System.out.println();
						}
					else if(newans.equals("Y")||newans.equals("y")) {
						System.out.println();
						continue;
						}
					else {
						System.out.println();
						System.out.println("Sorry :(, invalid again! Finishing...");
						ans=false;
						System.out.println();
						}
					}
				
			//end try	
			}
			catch(Exception e) { //exception for first request (input format)
				System.out.println("Error! ONLY INT NUMBERS are acepted for this request. Start again...");
				return;
			}
			
		} //end while
		
		//show all employess with their respective email
		System.out.println("These are your "+employees.size()+" new employees, welcome!:");
		for (String i: employees.keySet()) {
			System.out.println(count+" "+i+" ("+employees.get(i)+")");
			count++;
			}

	}
	
} //end class