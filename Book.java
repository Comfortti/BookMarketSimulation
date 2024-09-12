// create book class for buyers and sellers to interact with
public class Book {
    private String title;
    private double price;

// use of "this" keyword and creation of public/private modifiers 
//inspired from: https://www.youtube.com/watch?v=ETLHbHenW44
    public Book(String title, double price) {
        this.title = title;
        this.price = price;
    }
//enables access of title and price outside of this class i.e. in the class Market
    public String returnTitle() {
        return title;
    }

    public double returnPrice() {
        return price;
    }
}
