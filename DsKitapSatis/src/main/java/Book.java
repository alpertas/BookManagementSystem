
public class Book {
    private int id;
    private String book_name;
    private String book_writer;
    private String book_type;
    private String book_publisher;
    private int bookshelf;
    private int shelf;
    private int fiyat;  
    private int stok;
    private String kullanici;

    public String getKullanici() {
        return kullanici;
    }

    public void setKullanici(String kullanici) {
        this.kullanici = kullanici;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }
    
    public Book(int fiyat) {
        this.fiyat = fiyat;
    }
    
    public int getFiyat() {
        return fiyat;
    }

    public void setFiyat(int fiyat) {
        this.fiyat = fiyat;
    }
    
    
    public Book(int id, String book_name, String book_writer, String book_type, String book_publisher, int bookshelf, int shelf, int fiyat,int stok) {
        this.id = id;
        this.book_name = book_name;
        this.book_writer = book_writer;
        this.book_type = book_type;
        this.book_publisher = book_publisher;
        this.bookshelf = bookshelf;
        this.shelf = shelf;
        this.fiyat = fiyat;
        this.stok=stok;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getBook_writer() {
        return book_writer;
    }

    public void setBook_writer(String book_writer) {
        this.book_writer = book_writer;
    }

    public String getBook_type() {
        return book_type;
    }

    public void setBook_type(String book_type) {
        this.book_type = book_type;
    }

    public String getBook_publisher() {
        return book_publisher;
    }

    public void setBook_publisher(String book_publisher) {
        this.book_publisher = book_publisher;
    }

    public int getBookshelf() {
        return bookshelf;
    }

    public void setBookshelf(int bookshelf) {
        this.bookshelf = bookshelf;
    }

    public int getShelf() {
        return shelf;
    }

    public void setShelf(int shelf) {
        this.shelf = shelf;
    }
    
}
