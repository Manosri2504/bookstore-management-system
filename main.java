package bookstore;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {

	public static ArrayList<User> Users = new ArrayList<>();
	public static ArrayList<Book> books = new ArrayList<>();
	public static User activeUser;
	public static int cart;
	
	public static void createBooks() {
		Book book = new Book( "safahat", Book.bookType.Poetry);
		Book book1 = new Book(  "Goge Bakna Duragi", Book.bookType.Poetry);
		Book book2 = new Book( "Yercekimli Karanfil", Book.bookType.Poetry);
		books.add(book);
		books.add(book1);
		books.add(book2);
		Book book3 = new Book(  "Masumiyet Muzei", Book.bookType.Romance);
		Book book4 = new Book(  "Kurk Mantolu Madonna", Book.bookType.Romance);
		Book book5 = new Book(  "Kolera Gunlerinde Ask", Book.bookType.Romance);
		books.add(book3);
		books.add(book4);
		books.add(book5);
		Book book6 = new Book(  "Yuzuklerin Efendisi", Book.bookType.Fantasy);
		Book book7 = new Book(  "Narnia", Book.bookType.Fantasy);
		Book book8 = new Book(  "Alice", Book.bookType.Fantasy);
		books.add(book6);
		books.add(book7);
		books.add(book8);
		Book book9 = new Book( "Hayvan", Book.bookType.Horror);
		Book book10 = new Book(  "Yabanci", Book.bookType.Horror);
		Book book11 = new Book(  "Yesil", Book.bookType.Horror);
		books.add(book9);
		books.add(book10);
		books.add(book11);
		Book book12 = new Book( "Suc ve Ceza", Book.bookType.Classics);
		Book book13 = new Book(  "Kucuk kadinlar", Book.bookType.Classics);
		Book book14= new Book( "Insanlar", Book.bookType.Classics);
		books.add(book12);
		books.add(book13);
		books.add(book14);
	}
	
	public static void createUsers() {
		User mano = new User(  "Mano",  "190503", User.UserType.ADMIN);
		Users.add(mano);
		User durga = new User(  " Durga",  "12345", User.UserType.USER);
		Users.add(durga);
	}
	
	@SuppressWarnings("resource")
	public static void login() {
		for (User User : Users) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Username:");
			String Username = scanner.next();
			System.out.println("Password:");
			String Password = scanner.next();
			if (User.getUsername().equals(Username) && User.getPassword().equals(Password)){
				System.out.println("You have been logged in successfully.");
				activeUser = User;
			}
			
				
			}
			
		}
	public static void register() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Username:");
		String Username = scanner.next();
		System.out.println("Password:");
		String Password = scanner.next();
		
		User newUser = new User(Username, Password, User.UserType.USER);
		activeUser = newUser;
		cart += 30;
		Users.add(newUser);
		System.out.println("You have registered Successfully.");
	}
	
	@SuppressWarnings("resource")
	public static void addBookToCart() {
		Scanner scanner = new Scanner(System.in);
		int choice = 0;
		for (int i = 0; i < 15; i++) {
			System.out.println(i + "-" + books.get(i).getBookName());
		}
		choice = scanner.nextInt()%15;
		if(activeUser.getType() == User.UserType.ADMIN || activeUser.getType() == User.UserType.USER) {
			cart += books.get(choice).getBookPrice();
		}
		else {
			cart += books.get(choice).getBookPrice()*1.5;
		}
		System.out.println("your fee:" + cart);
		
		if (activeUser.getType() == User.UserType.CUSTOMER) {
			choice = 0;
			System.out.println("Do YOu want to login as User? [1:Yes, 2:No]");
			choice = scanner.nextInt();
			if (choice == 1) {
				register();
			}
			else { 
				System.out.println("Do you want to buy more book or exit?(press 1 to exit.)");
				int option = scanner.nextInt();
				if(option == 1) {
					System.out.println("Thank you for choosing us. Hope to see you again dear customer.");
					System.exit( 0);
					
				}
			}
		}
	}
	
	public static void pay() {
		System.out.println("Thank you" + " " + activeUser.getUsername() + "!" + "you payed" + " " + cart + "$");
		cart = 30;
	}
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		createUsers();
		createBooks();
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			int choice = 0;
			if (activeUser == null) {
				System.out.println("Welcome to the chromatics Bookstore.");
				System.out.println("There are the option:");
				String options ="1-Login as an user\n"
						+ "2-Buy as a customer\n"
						+ "3-Eit the system";
				System.out.println(options);
				choice = scanner.nextInt();
				if (choice == 1) {
					login();
				} else if (choice == 2) {
					activeUser = new User("TemporaryUser","test123", User.UserType.CUSTOMER);
					addBookToCart();
				} else {
					break;
				}
			} else {
				System.out.println("1-Buy a book");
				if (cart != 0) {
					System.out.println("2-pay");
					System.out.println("3-Shut down");
				} else {
					System.out.println("2-Shut down");
				}
				choice = scanner.nextInt();
				if (choice == 1) {
					addBookToCart();
				} else if (cart != 0 && choice == 2) {
					pay();
				} else {
					System.out.println("Thank You for choosing us dear customer. Hope to see you again.");
					break;
				}
			}
			
		}

	}

}
