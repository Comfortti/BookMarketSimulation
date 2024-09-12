import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//create the market that will simulate the multi-agent interactions 
//populate each seller's catalogue (stored as an arraylist)

//NB: user can change the title and price in of the books in each catalogue 
//NB: user can change the number of sellers and their names below, list of sellers must be updated accordingly
public class Market {
    public static void main(String[] args) {
        List<Book> seller1Catalogue = new ArrayList<>();
        seller1Catalogue.add(new Book("Children of Blood and Bone", 16.99));
        seller1Catalogue.add(new Book("Children of Virtue and Vengeance", 11.99));
        seller1Catalogue.add(new Book("Children of Anguish and Anarchy", 14.99));
        Seller seller1 = new Seller("Little Literary Haven", seller1Catalogue);

        List<Book> seller2Catalogue = new ArrayList<>();
        seller2Catalogue.add(new Book("The Fifth Season", 14.99));
        seller2Catalogue.add(new Book("The Obeslisk Gate", 12.99));
        seller2Catalogue.add(new Book("The Stone Sky", 9.99));
        Seller seller2 = new Seller("Petite Pages", seller2Catalogue);

        List<Book> seller3Catalogue = new ArrayList<>();
        seller3Catalogue.add(new Book("Children of Virtue and Vengeance", 7.99));
        seller3Catalogue.add(new Book("The Obeslisk Gate", 6.99));
        seller3Catalogue.add(new Book("This Poison Heart", 4.99));
        Seller seller3 = new Seller("Cosy Corner", seller3Catalogue);

        List<Seller> allSellers = List.of(seller1, seller2, seller3);

        //NB: user can change the number of buyers and their names here
        //NB: any change in number of buyers in should be reflected in while loop below too 
        Buyer buyer1 = new Buyer("Comfort");
        Buyer buyer2 = new Buyer("Nifemi");
        Buyer buyer3 = new Buyer("Jadesola");

        //code choses a random seller and then a random book from this seller
        //the random book is the book all the buyers wish to buy until it is sold out.

        //while loop runs until all the books in all the catalogues have been bought. 
        
        //Inspiration on how to code for "not empty" was inspired from: 
        //https://javarevisited.blogspot.com/2016/01/how-to-check-if-string-is-not-null-and-empty-in-java-example.html

        //Inspiration on how to use the random package obtained from:
        //https://www.geeksforgeeks.org/java-util-random-nextint-java/ 
        Random random = new Random();

        while (!seller1Catalogue.isEmpty() || !seller2Catalogue.isEmpty() || !seller3Catalogue.isEmpty()) {
            Seller randomSeller = allSellers.get(random.nextInt(allSellers.size()));

            if (!randomSeller.returnCatalogue().isEmpty()) {
                Book randomBook = randomSeller.returnCatalogue().get(random.nextInt(randomSeller.returnCatalogue().size()));

                buyer1.buyBook(allSellers, randomBook.returnTitle());
                buyer2.buyBook(allSellers, randomBook.returnTitle());
                buyer3.buyBook(allSellers, randomBook.returnTitle());
            }
        }

        System.out.println("Market is closed. All Catalogues are Empty.");
    }
}
