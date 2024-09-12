import java.util.List;

// Create a class for the sellers. 
// They will be linked to the book class made earlier. 
// Book title and price will be listed 
public class Seller {
    private String name;
    private List<Book> catalogue; 

    public Seller(String name, List<Book> catalogue) {
        this.name = name;
        this.catalogue = catalogue; 
    }

    //Returns the seller name and seller's catalogue when called
    public String returnName() {
        return name; 
    }

    public List<Book> returnCatalogue() {
        return catalogue; 
    }

    //For-each loop needed to run through the books in the catalogue and returns back its price
    //Case insentively code inspired from: 
    //https://www.geeksforgeeks.org/java-string-equalsignorecase-method-with-examples/
    //Retuns back -1 if book is not in the catalogue 
    public double returnBookPrice(String bookTitle) {
        for (Book book : catalogue) {
            if (book.returnTitle().equalsIgnoreCase(bookTitle)) {
                return book.returnPrice();
            }
        }
        return -1; 
    }
    //Book removed from catalogue when purchased by buyer 
    public void removeBook(String bookTitle) {
        catalogue.removeIf(book -> book.returnTitle().equalsIgnoreCase(bookTitle));
    }

}
