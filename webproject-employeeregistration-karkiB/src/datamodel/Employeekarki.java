package datamodel;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employeeRegistrationInfo")
public class Employeekarki {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id")
   private Integer id;
   
   @Column(name = "FistName")
   private String firstName;
   
   @Column(name = "LastName")
   private String lastName;
   
   @Column(name = "UserName")
   private String userName;
   
   @Column(name = "Password")
   private String password;
   
   @Column(name = "Address")
   private String address;

  // @Column(name = "ContactNumber")
  // private Integer contact;
   
   @Column(name = "ContactNumber")
   private String contact;

   public Employeekarki() {
   }

  // public Employeekarki(Integer id, String firstName, String lastName,String userName, String password,String address, Integer contact) {
   public Employeekarki(Integer id, String firstName, String lastName,String userName, String password,String address, String contact) {
      this.id = id;
      this.firstName = firstName;
      this.lastName = lastName;
      this.userName = userName;
      this.password = password;
      this.address = address;
      this.contact = contact;
   }
   
   
   //public Employeekarki(String firstName, String lastName,String userName, String password,String address, Integer contact) {
   public Employeekarki(String firstName, String lastName,String userName, String password,String address, String contact) {
	      this.firstName = firstName;
	      this.lastName = lastName;
	      this.userName = userName;
	      this.password = password;
	      this.address = address;
	      this.contact = contact;
   }

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public String getUserName() {
	return userName;
}

public void setUserName(String userName) {
	this.userName = userName;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

/**public Integer getContact() {
	return contact;
}

public void setContact(Integer contact) {
	this.contact = contact;
}**/

public String getContact() {
	return contact;
}

public void setContact(String contact) {
	this.contact = contact;
}

@Override
public String toString() {
   return "Employee: " + this.id + ", " + this.firstName + ", " + this.lastName+ ", " + this.userName+ ", " + this.password+ ", " + this.address+ ", " + this.contact;
}

}