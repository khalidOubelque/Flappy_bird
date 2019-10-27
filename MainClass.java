package Flappy_bird;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainClass {

	
	public static Boolean You_rTheOne(String[] notre_besoin, String[] tes_competences){
		Boolean you_rTheOne = false;
		if(tes_competences.length > 0){  //You'r not child that's for sure =D
			for(int i = 0; i<notre_besoin.length; i++){
				for(int j = 0; j<tes_competences.length; j++){	
					if(notre_besoin[i] == tes_competences[j]){
						you_rTheOne = true;
						break;
					}else{
						you_rTheOne = false;
					}
				}
				if(you_rTheOne == false){
					break;
				}
			}
		}
		return you_rTheOne;
	}
	
	public static Boolean test(List<String> notre_besoin, List<String> tes_competences) throws Exception {
		
		if(notre_besoin ==null){
			throw new Exception("can t ");
		}
		System.out.println("hello");
		return null;
		
	}

		
	public static void main(String[] args) throws Exception {
		//FlappyBird flappyBird = FlappyBird.getInstance();
//		Profile profile = new Profile();
//		String[] profile_techs = {"JAVA","J2EE","SPRING","SONAR","JPA"};
//		profile.setTechs(profile_techs);
//		
		String[] techs = {"JAVA","J2EE","SPRING","SONAR","VM"};
		String[] tech = {"JAVA","J2EE","SPRING","SONAR","VM"};
		
		List<String> te = new ArrayList<String>();
		List<String> tec = new ArrayList<String>();

//		
//		if(profile.getTechs().length > 0){
//			for(int i = 0; i<techs.length; i++){
//				if(techs[i] == profile.getTechs()[i]){
//					System.out.println("Good");
//				}else{
//					System.out.println("Maybe next time");
//				}
//				
//			}
//			
//		}
//		Boolean test = You_rTheOne(techs,profile.getTechs());
//		System.out.println(test);
			int e = 1;
		float t = e/4;
		te = null;
		test(te,tec);
	}

}
