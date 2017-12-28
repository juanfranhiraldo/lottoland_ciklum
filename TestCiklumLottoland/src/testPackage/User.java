package testPackage;

import java.util.ArrayList;
import java.util.List;

public class User {
	String firstName;
	String lastName;
	String completeName;
	public String getCompleteName() {
		return completeName;
	}

	public User(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public static List<User> returnListOfUsers(String[] names){
		List<User> res=new ArrayList<User>();
		String firstName,lastName;
		String lowerCase="abcdefghijklmnñopqrstuvwxyz&";
		for(int i=0;i<names.length;i++){
			String nameToAdd=names[i];
			String[]nameParts=nameToAdd.split(" ");
			firstName=nameParts[0]; //We suppose first part of the name is with upper case
			int indexInsideName=1;
			while(lowerCase.contains(nameParts[indexInsideName].charAt(0)+""))
			{
				indexInsideName++;
			}
			lastName=nameParts[indexInsideName];
			User user=new User(firstName,lastName);
			user.completeName=nameToAdd;
			res.add(user);
		}
		return res;
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
	public boolean equals(User u){
		return u.firstName.equals(firstName) && u.lastName.equals(lastName);
	}
	
}
