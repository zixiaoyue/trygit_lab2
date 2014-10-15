package action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;

import com.opensymphony.xwork2.ActionSupport;
public class book extends ActionSupport{
	   private String[] booktitle = null;   
	   private String title;
       private String Author;
       private int Authorid;
       private String Name;
       private String Age;
       private String Country;
       private String Isbn;
       private String Publisher;
       private String PublishData;
       private String Price;
       private int i=0;
    public String[] getBooktitle() {
   		return booktitle;
   	}
   	public void setBooktitle(String[] booktitle) {
   		this.booktitle = booktitle;
   	}
    public int getI() {
    		return i;
    	}
    public void setI(int i) {
    		this.i = i;
    	}
    public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	} 
	public String getAuthor() {
		return Author;
	}
	public void setAuthor(String Author) {
		this.Author = Author;
	}
	public int getAuthorid(){
		return Authorid; 
	}
	public void setAuthorid(int Authorid){
		this.Authorid = Authorid;
	}
	 public String getName() {
			return Name;
		}
	public void setName(String Name) {
			this.Name = Name;
		} 
	 public String getAge() {
			return Age;
		}
	public void setAge(String Age) {
			this.Age = Age;
		} 
	public String getCountry() {
		return Country;
	}
	public void setCountry(String Country) {
		this.Country = Country;
	} 
	public String getIsbn() {
		return Isbn;
	}
	public void setIsbn(String Isbn) {
		this.Isbn = Isbn;
	} 
	public String getPublisher() {
		return Publisher;
	}
	public void setPublisher(String Publisher) {
		this.Publisher = Publisher;
	} 
	public String getPublishData() {
		return PublishData;
	}
	public void setPublishData(String PublishData) {
		this.PublishData = PublishData;
	} 
	public String getPrice() {
		return Price;
	}
	public void setPrice(String Price) {
		this.Price = Price;
	} 
	public static void main(String[] args){
			DaoCon dd = new DaoCon();
		}
	public void queryid() throws Exception{
		DaoCon coc = new DaoCon();
		Connection conn = coc.getCon();
		String sql = "select * from author where name=?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1,Author);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()){
			Authorid = rs.getInt("Authorid");
		}
		rs.close();
		stmt.close();
		conn.close();
	}
	public void querytitle() throws Exception{
		DaoCon coc = new DaoCon();
		Connection conn = coc.getCon();
		String sql = "select * from book where Authorid=?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1,Authorid);
		ResultSet rs = stmt.executeQuery();
		booktitle = new String[5];
		while(rs.next()){
			booktitle[i++] = rs.getString("title");
			//System.out.println(rs.getString("title"));
		}
		i--;
		rs.close();
		stmt.close();
		conn.close();
	}
	public void PlayAuthor() throws Exception{
		DaoCon coc = new DaoCon();
		Connection conn = coc.getCon();
		String sql = "select * from author where Authorid=?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1,Authorid);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()){
			Authorid = rs.getInt("Authorid");
			Name = rs.getString("Name");
			Country = rs.getString("Country");
			Age = rs.getString("Age");
		}
		rs.close();
		stmt.close();
		conn.close();
	}
	public void PlayBook() throws Exception{
		DaoCon coc = new DaoCon();
		Connection conn = coc.getCon();
		String sql = "select * from book where title=?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1,booktitle[0]);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()){
			Isbn = rs.getString("Isbn");
			Publisher = rs.getString("Publisher");
			String PublishDate = rs.getString("PublishDate");
			Price = rs.getString("Price");
		}
		rs.close();
		stmt.close();
		conn.close();
	} 

	
public String execute(){
			try {
				queryid();
				querytitle();
				PlayAuthor();
				PlayBook();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "success";
		}

}