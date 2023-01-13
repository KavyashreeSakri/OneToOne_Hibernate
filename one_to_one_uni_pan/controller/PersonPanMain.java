package one_to_one_uni_pan.controller;

import java.util.List;
import java.util.Scanner;

import one_to_one_uni_pan.dao.PanCardDao;
import one_to_one_uni_pan.dao.PersonDao;
import one_to_one_uni_pan.dto.PanCard;
import one_to_one_uni_pan.dto.Person;

public class PersonPanMain {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		Person person = new Person();
		PanCard panCard = new PanCard();
		PersonDao personDao = new PersonDao();
		PanCardDao panCardDao = new PanCardDao();

		boolean repeat = true;
		do {
			System.out.println("Press 1. to save Person and pancard details");
			System.out.println("Press 2. to update person and pancard details");
			System.out.println("Press 3. to delete person and pancard details");
			System.out.println("Press 4. to getPerson by Id and get Pancard by id");
			System.out.println("Press 5. to getAllPerson and pancard details");
			System.out.println("Press 6. To exit");
			System.out.println("Enter your choice");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1: {
				System.out.println("Enter the person id");
				int id = scanner.nextInt();
				System.out.println("Enter the person name");
				String name = scanner.next();
				System.out.println("Enter the person phone");
				long phone = scanner.nextLong();
				System.out.println("Enter the person address");
				String address = scanner.next();

				person.setId(id);
				person.setName(name);
				person.setAddress(address);
				person.setPhone(phone);
				person.setPanCard(panCard);

				System.out.println("Enter the pan id");
				int panid = scanner.nextInt();
				System.out.println("Enter the panCard name");
				String pan_name = scanner.next();
				System.out.println("Enter the pan address");
				String pan_address = scanner.next();
				panCard.setPanid(panid);
				panCard.setPan_name(pan_name);
				panCard.setAddress(pan_address);

				personDao.savePerson(person);
				System.out.println("inserted successfully");

			}
				break;

			case 2: {
				boolean b = true;
				do {
					System.out.println("Press 1. to update person");
					System.out.println("Press 2. to update pancard");
					System.out.println("Press 3. to exit");
					System.out.println("Enter your choice");
					int updatechoice = scanner.nextInt();
					switch (updatechoice) {
					case 1: {
						System.out.println("Enter the person id");
						int id = scanner.nextInt();
						System.out.println("Enter the person name");
						String name = scanner.next();
						person.setId(id);
						person.setName(name);
						personDao.updatePerson(name, id);
						System.out.println("Person updated successfully...");
					}
						break;
					case 2: {
						System.out.println("Enter the pan id");
						int panid = scanner.nextInt();
						System.out.println("Enter the panCard name");
						String pan_name = scanner.next();
						panCard.setPanid(panid);
						panCard.setPan_name(pan_name);
						panCardDao.updatePan(pan_name, panid);
						System.out.println("Pancard updated successfully...");

					}
						break;
					case 3: {
						b = false;
						System.out.println("Thank You");
					}
						break;
					default:
						System.out.println("Invalid Input");
					}
				} while (b);
			}
				break;
			case 3: {
				boolean a = true;
				do {
					System.out.println("Press 1. to delete person");
					System.out.println("Press 2. to delete pancard");
					System.out.println("Press 3. to exit");
					System.out.println("Enter your choice");
					int deletechoice = scanner.nextInt();
					switch (deletechoice) {
					case 1: {
						System.out.println("Enter the person id");
						int id = scanner.nextInt();
						personDao.deletePerson(id);
						System.out.println("person deleted successfully...");
					}
						break;
					case 2: {
						System.out.println("Enter the pan id");
						int panid = scanner.nextInt();
						panCardDao.deletePan(panid);
						System.out.println("pan deleted successfully...");

					}
						break;
					case 3: {
						a = false;
						System.out.println("Thank You");
					}
						break;
					default:
						System.out.println("");
					}
				} while (a);
			}
				break;
			case 4: {
				boolean a = true;
				do {
					System.out.println("Press 1. to get person by id");
					System.out.println("Press 2. to get pancard by pan id");
					System.out.println("Press 3. to exit");
					System.out.println("Enter your choice");
					int getchoice = scanner.nextInt();
					switch (getchoice) {
					case 1: {
						System.out.println("Enter the person id");
						int id = scanner.nextInt();
						Person person1 = personDao.getPersonById(id);
						System.out.println(person1);

					}
						break;
					case 2: {
						System.out.println("Enter the pan id");
						int id = scanner.nextInt();
						PanCard panCard1 = panCardDao.getPanById(id);
						System.out.println(panCard1);
					}
						break;
					case 3: {
						a = false;
						System.out.println("Thank You");
					}
						break;
					default:
						System.out.println("Invalid input");

					}
				} while (a);

			}
				break;
			case 5: {

				boolean a = true;
				do {
					System.out.println("Press 1. to get all person ");
					System.out.println("Press 2. to get all pancard ");
					System.out.println("Press 3. to exit");
					System.out.println("Enter your choice");
					int getchoice = scanner.nextInt();
					switch (getchoice) {
					case 1: {
						List<Person> list = personDao.getAllPerson();
						System.out.println(list);

					}
						break;
					case 2: {

						List<PanCard> list = panCardDao.getAllPan();
						System.out.println(list);
					}
						break;
					case 3: {
						a = false;
						System.out.println("Thank You");
					}
						break;
					default:
						System.out.println("Invalid input");
					}
				} while (a);

			}
			}
		} while (repeat);

	}
}
