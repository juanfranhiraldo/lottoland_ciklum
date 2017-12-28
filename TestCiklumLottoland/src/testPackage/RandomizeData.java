package testPackage;

import java.util.Random;

public class RandomizeData {
	public static String randomizeMarital(){ //Random marital status
		String[] marital={"single","married","divorced"};
		Random r=new Random(System.currentTimeMillis());
		int value=r.nextInt(3);
		return marital[value];
	}
	public static String[] randomizeHobbies(){
		String[] hobbies={"dance","reading","cricket "};
		Random r=new Random(System.currentTimeMillis());
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
		Random r=new Random(System.currentTimeMillis());
		for(int i=0;i<3;i++);
		res=res+lowerCase.charAt(r.nextInt(lowerCase.length()));
		return res;
	}
	
	public static Date randomizeDate(){
		Random r=new Random(System.currentTimeMillis());
		int month=r.nextInt(13)+1;
		int day=r.nextInt(31)+1;
		int yearIncrement=r.nextInt(64);
		int year=1950+yearIncrement;
		return new Date(day,month,year);
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
