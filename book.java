package bookstore;

public class Book {
	
	public int getBookPrice() {
		return bookPrice;
	}
	
	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}
	
	
	
   enum bookType{
	   Poetry,
	   Romance,
	   Fantasy,
	   Horror,
	   Classics
   }

   public Book(String bookName, bookType bookType) {
	   setBookType(bookType);
	   setBookName(bookName);
   }
	   
	   public void setbookPrice() {
	        switch (bookType) {
	            case Classics:
	            case Fantasy:
	                setBookPrice(15);
	                break;
	            case Romance:
	            case Horror:
	                setBookPrice(10);
	                break;
	            case Poetry:
	                setBookPrice(8);
	                break;
	            default:
	                System.out.println("Invalid Type");
	        }
	        setBookPrice(bookPrice);
   }
   
   private String bookName;
   private bookType bookType;
   private int bookPrice;
   
   public String getBookName() {
	   return bookName;
   }
   public void setBookName( String bookName) {
	   this.bookName = bookName;
   }
   
   public Book.bookType getBookType(){
	   return bookType;
   }
   
   public void setBookType(Book.bookType bookType) {
	   this.bookType = bookType;
   }
   
}
