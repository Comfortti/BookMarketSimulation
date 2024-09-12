import java.util.List;

//Create a class for the buyers 
//Buyers have a name that will be called on in class Market
public class Buyer {
    private String name;

    public Buyer(String name) {
        this.name = name;
    }

    public String returnName() {
        return name; 
    }

//Method of the buyers buying from a list of books from the allSellers   
    //initialise the lowestPrice and the selectedSeller
    public void buyBook(List<Seller> allSellers, String bookTitle) {
        double lowestPrice = Double.MAX_VALUE; 
        Seller selectedSeller = null; 

        //iteration through all the sellers in allSellers and returns back the price of the book within the specified constrictor: bookTitle
        //i.e. a bookTitle will be requested and the returnBookPrice function is called from the Seller class 
        //if the price is not -1 and the price is smaller than the initator (maximum value the code can operate with)
        //then the lowestPrice is reassigned to price from this selectedSeller
        //lowestPrice is appropriately reassigned through the iterations of all the sellers 
        for (Seller seller : allSellers) {
            double price = seller.returnBookPrice(bookTitle);
            if (price != -1 && price < lowestPrice) {
                lowestPrice = price;
                selectedSeller = seller; 
            }
        }
        //Visualisation (via text) of what is going on with these multi-agent interactions via the interactions being printed out 
        if (selectedSeller != null) {
            System.out.println("Buyer " + name + " bought \"" + bookTitle + "\" from " + selectedSeller.returnName() + " for £" + lowestPrice);
            selectedSeller.removeBook(bookTitle);
        } else {
            System.out.println("Buyer " + name + " did not find \"" + bookTitle + "\" from any sellers");
        }
    }
}
