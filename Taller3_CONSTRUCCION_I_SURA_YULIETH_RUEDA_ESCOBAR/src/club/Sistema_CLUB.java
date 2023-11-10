package club;

import java.util.Scanner;

public class Sistema_CLUB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int Option;
		boolean ban = true;
		String id = "";
		
		Scanner input = new Scanner (System.in);
		Socios newMember = new Socios();
		Socios member = new Socios();
		Autorizados atorizados = new Autorizados(350);
		Bill bill = new Bill();
		
		
		while(ban) {
		System.out.println("Choose an option: " +
		"\n 1. Add a new member" + 
		"\n 2. Eliminate a member" + 
		"\n 3. Add a person authorized by a member" + 
		"\n 4. Pay a bill" + 
		"\n 5. Register a consumption in a member's account" +
		"\n 6. Increase a partner's funds" + 
		"\n 7. finish");
		Option = input.nextInt();
		
		switch (Option) {
		
		
			case 1:
				
				int a = 1;
				while (a==1) {
				int existing = 0;
				String cedula = "";
				String nombre = "";
				System.out.println("Add a new member");
				System.out.println("Enter the ID");
				cedula = String.valueOf(input.nextInt());
				existing = newMember.memberExisting(cedula);
				
				if(existing == 1) {	
					System.out.println("The ID is registered.");
				} 
				else{
					input.nextLine();
					System.out.println("What is the name of the member?");
					nombre = input.nextLine();
					
					System.out.println("Do you want to be a VIP member or a regular member?");
					newMember.setTipoSuscripcion(input.nextLine().toLowerCase());
					
					System.out.println("How much is your starting fund?");
					newMember.setFondosDisponibles(input.nextLine());
					
					if (newMember.getTipoSuscripcion().equals("regular") && Integer.parseInt(newMember.getFondosDisponibles()) >= 50000 || 
							newMember.getTipoSuscripcion().equals("vip") && Integer.parseInt(newMember.getFondosDisponibles()) >= 100000) {
						System.out.print("This is a new member.");
						newMember.addMembers(cedula, nombre, newMember.getFondosDisponibles(),
								newMember.getTipoSuscripcion(), "This is a new member.");

						System.out.println("It was added successfully.");
						
						for(int i=0; i<newMember.getMember().length; i++) {
							for(int j=0; j<newMember.getMember()[i].length; j++) {
								if(newMember.getMember()[i][j] != null && !newMember.getMember()[i][j].isEmpty()) {
									System.out.print(newMember.getMember()[i][j] + " ");
								}
							}	
						}
					}
					else {
						System.out.println("Write a valid option");
					}

				}
				
				System.out.println("Do you want add more members? "
						+ "\n 1. Yes" 
						+ "\n 2. No");
				a = input.nextInt();
				}
				break;
				
				
				
				
			case 2: 
				
			    id = "";
				System.out.println("What is your ID?");
				id = input.nextLine();
				id = input.nextLine();
			
				System.out.println(newMember.deleteMember(id));
				input.nextLine();
				break;
				
				
				
				
				
			case 3: 
				
				id = "";
				int authorizedPeople = 0;
				
				System.out.println("Enter the ID");
				id = input.nextLine();
				int count = 10 - atorizados.countAutorizados(id);
				input.nextLine();
				System.out.println("You have " + count + " space available." + 
									"\n Maximun ten authorized.");
				
				System.out.println("How many people do you want to add?");
				authorizedPeople = input.nextInt();
				
				
				for(int i=0; i<authorizedPeople ;i++) {
					System.out.println("What is the name of the authorized?");
					atorizados.setAutorizados( i, id,  input.nextLine());
					input.nextLine();
				}
				break;	
				
				
				
				
				
			case 4:
				int desicion = 0;
				id = "";
				
				System.out.println("Enter the ID");
				id = input.nextLine();
				id = input.nextLine();
				
				for(int i=0; i<bill.getBills().length; i++) {
					
						if(bill.getBills()[i][0] != null && !bill.getBills()[i][0].isEmpty() && bill.getBills()[i][0].equals(id)) {
							System.out.print(bill.getBills()[i][0] + " " +
						                     bill.getBills()[i][1] + " " +	
						                     bill.getBills()[i][2] + " " +	
						                     bill.getBills()[i][3] + " " +
						                     bill.getBills()[i][4] + " " 
									        );
							System.out.print("\n");
					}			
				}
				input.nextLine();
				
				System.out.println("Do you want to pay all the mount? 1.yes/ 2.No");
				desicion = input.nextInt();
				
				if (desicion == 1) {
					for(int i=0; i<bill.getBills().length; i++) {
						
						if(bill.getBills()[i][0] != null && !bill.getBills()[i][0].isEmpty() && bill.getBills()[i][0].equals(id)) {
							bill.getBills()[i][0] = null;
						    bill.getBills()[i][1] = null;
						    bill.getBills()[i][2] = null;
						    bill.getBills()[i][3] = null;
		                    bill.getBills()[i][4] = null;	
					}		
				}
					System.out.print("Bill paid");
				}
				input.nextLine();
				
				break;	
				
				
				
				
				
			case 5:
				
				int existing = 0;
				id = "";
				a = 1;
				String concept = "";
				int mount = 0;
				int Option1 = 0;
				String[][] product = new String[1][2];
				
				System.out.println("Enter the ID");
				id = input.nextLine();
				id = input.nextLine();
				
				existing = newMember.memberExisting(id);
				
				if(existing == 0) {
					System.out.println("The ID is not registered.");
				}
				
				while (a == 1 && existing == 1) {
					input.nextLine();
					System.out.println("What do you want to buy?" + id);
					System.out.println("Choose an option: " +
							"\n 1. soda" + 
							"\n 2. snack" + 
							"\n 3. hamburguer");
							Option1 = input.nextInt();
							
					if(Option1 <= 3) {
						product = bill.products(Option1);
						concept = concept + ", " + product[0][0];
						mount = mount + Integer.parseInt(product[0][1]);
						System.out.println("Do you want to buy more else? 1.yes/ 2.No");
						a = input.nextInt();
					}
				}
				
				if(existing == 1) {
					input.nextLine();
					System.out.println("Pay now or then?");
					bill.setData(input.nextLine());
					
					if(bill.getData().equals("then")) {
						bill.bills_debt(id, newMember.setNombre(id), concept,  String.valueOf(mount), bill.getData());
					}
				}
				break;	
				
				
				
			
			case 6:
				
				id = "";
				int value = 0; 
				System.out.println("Enter the ID");
				id = input.nextLine();
				id = input.nextLine();
				
				System.out.println("How many you want to increase the found?");
				value = Integer.parseInt(input.nextLine());
				
				System.out.println( newMember.increaseFund(id, value) );
				
				break;	

				
				
			case 7:
				ban = false;
				break;	
					
				
		}
	

	}}}


