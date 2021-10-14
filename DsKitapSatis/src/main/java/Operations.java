
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;


public class Operations {
    //import edilecekler
    Connection con = null;
    Statement sta = null;
    PreparedStatement psta = null;
    ResultSet rs = null;
    
    public void userUpdate(int id, String new_name, String new_password){
        String sorgu = "Update kullanici SET kullanici=?,password=? WHERE id=?";
        try {
            psta=con.prepareStatement(sorgu);
            psta.setString(1, new_name);
            psta.setString(2, new_password);
            psta.setInt(3, id);
            psta.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    public void userDelete(int id){
        String sorgu = "DELETE FROM kullanici WHERE id=?";
        try {
            psta=con.prepareStatement(sorgu);
            psta.setInt(1, id);
            psta.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void userAdd(String name,String password){
        String sorgu ="Insert into kullanici(kullanici, password) VALUES (?,?)";
        try {
            psta=con.prepareStatement(sorgu);
            psta.setString(1, name);
            psta.setString(2, password);
            psta.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public void kEkle(String kullaniciAdi, String kullaniciSifre){
        String sorgu ="Insert into kullanici(kullanici, password) VALUES (?,?)";
        try {
            psta=con.prepareStatement(sorgu);
            psta.setString(1, kullaniciAdi);
            psta.setString(2, kullaniciSifre);
            psta.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<User> UserCome()
    {
        ArrayList<User> list = new ArrayList<User>();
        String sorgu = "Select * from kullanici";
        
        try {
            sta=con.createStatement();
            ResultSet rs= sta.executeQuery(sorgu);
            
            while(rs.next()){
                int id = rs.getInt("id");
                String user_name = rs.getString("kullanici");
                String user_password = rs.getString("password");
                list.add(new User(id, user_name, user_password));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    
    public int bookCount(){
        int label=0;
        String sorgu =  "SELECT COUNT(*) FROM books_database";
        try {
            sta=con.createStatement();
            ResultSet rs = sta.executeQuery(sorgu);
            rs.next();
            label=rs.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
        return label;
        
    }
    
    public void sepetBookDelete(int id){
        String sorgu = "DELETE FROM sepet WHERE id=?";
        try {
            psta=con.prepareStatement(sorgu);
            psta.setInt(1, id);
            psta.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void bookDelete(int id)
    {
        String sorgu = "DELETE FROM books_database WHERE id=?";
        try {
            psta=con.prepareStatement(sorgu);
            psta.setInt(1, id);
            psta.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void SepetUpdate(String kitapAd,int stok)
    {
        int a=stok;
        String sorgu="Update books_database SET stok = stok-? WHERE book_name= ?";
        try {
            psta=con.prepareStatement(sorgu);
            psta.setInt(1, stok);
            psta.setString(2, kitapAd);
            psta.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void bookUpdate(String new_name, String new_writer, String new_type, String new_publisher, String new_bookshelf, String new_shelf,String fiyat, int id)
    {
        String sorgu = "Update books_database SET book_name=?,book_writer=?,book_type=?,book_publisher=?,bookshelf=?,shelf=?,fiyat=? WHERE id=?";
        try {
            psta=con.prepareStatement(sorgu);
            psta.setString(1, new_name);
            psta.setString(2, new_writer);
            psta.setString(3, new_type);
            psta.setString(4, new_publisher);
            psta.setString(5, new_bookshelf);
            psta.setString(6, new_shelf);
            psta.setInt(8, id);
            psta.setString(7, fiyat);
            psta.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void bookAdd(String name, String writer, String type, String publisher, String bookshelf, String shelf, String fiyat,int stok)
    {
        String sorgu = "Insert into books_database(book_name, book_writer, book_type, book_publisher, bookshelf, shelf, fiyat, stok) VALUES (?,?,?,?,?,?,?,?)";
        try {
            psta=con.prepareStatement(sorgu);
            psta.setString(1, name);
            psta.setString(2, writer);
            psta.setString(3, type);
            psta.setString(4, publisher);
            psta.setString(5, bookshelf);
            psta.setString(6, shelf);
            psta.setString(7, fiyat);
            psta.setInt(8, stok);
            psta.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void sepetAdd(String kullaniciAdi, String kitapAdi, String kitapYazar, String kitapTip, String kitapYEvi, int kitapFiyat, int kitapStok, int adet)
    {
        String sorgu ="Insert into sepet(kullanici_adı, kitap_adi, kitap_yazar, kitap_tip, kitap_yayinevi, fiyat, stok, adet) VALUES (?,?,?,?,?,?,?,?)";
        try {
            psta=con.prepareStatement(sorgu);
            psta.setString(1, kullaniciAdi);
            psta.setString(2, kitapAdi);
            psta.setString(3, kitapYazar);
            psta.setString(4, kitapTip);
            psta.setString(5, kitapYEvi);
            psta.setInt(6, kitapFiyat);
            psta.setInt(7, kitapStok);
            psta.setInt(8, adet);
            psta.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public ArrayList<Sepet> SepetListe()
    {
        ArrayList<Sepet> list = new ArrayList<Sepet>();
        String sorgu = "Select * from sepet";
        
        try {
            sta=con.createStatement();
            ResultSet rs= sta.executeQuery(sorgu);
            while(rs.next())
            {
                int id=rs.getInt("id");
                String kullanici_adi=rs.getString("kullanici_adi");
                String kitap_ad=rs.getString("kitap_adi");
                String kitap_yazar=rs.getString("kitap_yazar");
                String kitap_tip=rs.getString("kitap_tip");
                String kitap_yayinevi=rs.getString("kitap_yayinevi");
                int fiyat=rs.getInt("fiyat");
                int stok=rs.getInt("stok");
                int adet=rs.getInt("adet");
                list.add(new Sepet(id,kullanici_adi,kitap_ad,kitap_yazar,kitap_tip,kitap_yayinevi,fiyat,stok,adet));
            } 
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public ArrayList<Book> BookCome()
    {
        ArrayList<Book> list = new ArrayList<Book>();
        String sorgu = "Select * from books_database";
        
        try {
            sta=con.createStatement();
            ResultSet rs= sta.executeQuery(sorgu);
            while(rs.next())
            {
                int id=rs.getInt("id");
                String book_name=rs.getString("book_name");
                String book_writer=rs.getString("book_writer");
                String book_type=rs.getString("book_type");
                String book_publisher=rs.getString("book_publisher");
                int bookshelf=rs.getInt("bookshelf");
                int shelf=rs.getInt("shelf");
                int fiyat=rs.getInt("fiyat");
                int stok=rs.getInt("stok");
                list.add(new Book(id,book_name,book_writer,book_type,book_publisher,bookshelf,shelf,fiyat,stok));
            } 
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public boolean Login(String id, String pw){
        String sorgu = "Select * from admin where a_id=? and a_password=?";
        try {
            psta = con.prepareStatement(sorgu);
            psta.setString(1, id);
            psta.setString(2, pw);
            ResultSet rs = psta.executeQuery();
            return rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public boolean LoginKullanici(String id, String pw){
        String sorgu = "Select * from kullanici where kullanici=? and password=?";
        try {
            psta = con.prepareStatement(sorgu);
            psta.setString(1, id);
            psta.setString(2, pw);
            ResultSet rs = psta.executeQuery();
            return rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
   
    public Operations() 
    {
        
        
        String url="jdbc:mysql://"+Database.host+":"+Database.port+"/"+Database.db_name;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url,Database.id,Database.password);
            System.out.println("Bağlantı Başarılı");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Driver sağlanamadı");
        } catch (SQLException ex) {
            Logger.getLogger(Operations.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Connection çalışmadı");
        }
        
    }
    
    public static void main(String[] args) {
        Operations op = new Operations();
    }

   

    
}
