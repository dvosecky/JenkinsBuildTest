

import java.util.List;

//import com.revature.beans.Candy;
//import com.revature.beans.Family;
//import com.revature.beans.Member;
//import com.revature.dao.CandyDao;
//import com.revature.dao.FamilyDao;
//import com.revature.dao.MemberDao;

public class Driver {
	public static void main(String[] args) {
		System.out.println("APPLICATION START");
		
		CandyDao cd = new CandyDao();
		cd.insertCandy(new Candy(null, "Ryan Kats", 2500, "Salty and Caramellicious"));
		cd.insertCandy(new Candy(null, "Bobbert Cakes", 3750, "Sour and Caramellicious"));
		int id = cd.insertCandy(new Candy(null, "Timber Pops", 12, "Woodchips and Caramellicious"));
		
		System.out.println(cd.getAllCandys());
		
//		System.out.println("=============families=================");
//		FamilyDao fd = new FamilyDao();
//		fd.insertFamily(new Family(null, "The Hibernettisons"));
//		List<Family> familys = fd.getAllFamilys();
//		for (Family fam: familys) {
//			System.out.println(fam);
//		}
//		
//		System.out.println("===============Candy con't===============");
//		cd.updateCandyByIdFull(new Candy(id, "Little Bobbert's Bobbables", 95000, "Seaweed and Caramellishish"));
//		System.out.println(cd.getAllCandys());
//		
//		System.out.println("===========get members=============");
//		MemberDao md = new MemberDao();
//		List<Member> members = md.selectAllMember();
//		for (Member member : members) {
//			System.out.println(member);
//		}
//		
//		System.out.println("============tasks=============");
////		for (Member member : members) {
////			member.getTasks().forEach(System.out::println);
////		}
//		
//		cd.getVsLoad();
//		
//		
//		
//		System.out.println(cd.HQL(5));
//		
//		cd.criteriasGetAll();
//		System.out.println("APPLICATION TERMINATES");
//		
//		cd.criteriaConditional();
//		
//		cd.executeNamedQueries();
		System.exit(0);
	}
}
















