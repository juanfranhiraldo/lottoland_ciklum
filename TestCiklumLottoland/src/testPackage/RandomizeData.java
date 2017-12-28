package testPackage;

import java.util.Random;

public class RandomizeData {
	static Random r=new Random(System.currentTimeMillis());
	public static String randomizeMarital(){ //Random marital status
		String[] marital={"single","married","divorced"};
		int value=r.nextInt(3);
		return marital[value];
	}
	public static String[] randomizeHobbies(){
		String[] hobbies={"dance","reading","cricket "};
		int value=r.nextInt(3)+1;
		String finalHobbies[]=new String[value];
		for(int i=0;i<value;i++){
			finalHobbies[i]="";
		}
		for(int i=0;i<value;i++){
			addToRes(hobbies,i,finalHobbies);
		}
		return finalHobbies;
	}
	
	public static String randomizeCountry(){
		String lowerCase="abcdefghijklmnopqrstuvwxyz";
		String res="";
		for(int i=0;i<3;i++);
		res=res+lowerCase.charAt(r.nextInt(lowerCase.length()));
		return res;
	}
	
	public static Date randomizeDate(){
		int month=r.nextInt(12)+1;
		int day=r.nextInt(31)+1;
		int yearIncrement=r.nextInt(64);
		int year=1950+yearIncrement;
		return new Date(day,month,year);
	}
	
	public static String randomizePhoneNumber(){
		String res="";
		String numbers="0123456789";
		int phoneLength=r.nextInt(11)+10;
		for(int i=0;i<phoneLength;i++){
			char digit=numbers.charAt(r.nextInt(numbers.length()));
			res=res+digit;
		}
		return res;
	}
	
	public static String randomizeUserName(){
		String letters="abcdefghijklmnopqrstuvwxyz";
		letters=letters+letters.toUpperCase();
		String numbers="0123456789";
		String lettersAndNumbers=letters+numbers;
		int length=r.nextInt(10)+5;
		String res=""+letters.charAt(r.nextInt(letters.length()));
		for(int i=0;i<length;i++){
			res=res+lettersAndNumbers.charAt(r.nextInt(lettersAndNumbers.length()));
		}
		return res;
	}
	
	public static String randomizeEmail(){
		String res="";
		String firstPart;
		String secondPart;
		
		return res;
	}
	
	
	private static void addToRes(String[] hobbies, int i, String[] finalHobbies) {
		Random r=new Random(System.currentTimeMillis());
		int value=r.nextInt(3);
		while(containing(hobbies[value],finalHobbies)){
			value=r.nextInt(3);
		}
		finalHobbies[i]=hobbies[value];
		
	}
	private static boolean containing(String string, String[] finalHobbies) {
		int i=0;
		boolean found=false;
		while(!found&&i<finalHobbies.length){
			if(finalHobbies[i].equals(string)){
				found=true;
			}else
				i++;
		}
		return found;
	}
}
