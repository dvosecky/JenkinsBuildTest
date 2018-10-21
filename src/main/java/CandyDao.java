

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
//
//import com.revature.beans.Candy;
//import com.revature.util.HibernateUtil;

public class CandyDao {
	public Integer insertCandy(Candy candy) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		Integer id = null;
		
		try {
			tx = session.beginTransaction();
			id = (Integer)session.save(candy);
			tx.commit();
		} catch (HibernateException e) {
			System.out.println("hey");
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
		}
		
		return id;
	}
	
	public List<Candy> getAllCandys() {
		List<Candy> candys = null;
		Session session = HibernateUtil.getSession();
		
		try {
			candys = (List<Candy>)session.createQuery("FROM Candy").list();

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return candys;
	}
	
	public Candy updateCandyByIdFull(Candy c) {
		Candy candy = null;
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			candy = (Candy)session.get(Candy.class, c.getId());
			
			candy.setFlavor(c.getFlavor());
			candy.setSugar(c.getSugar());
			candy.setName(c.getName());
			
			session.save(candy);
			tx.commit();
			
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return candy;
	}
	
	public void removeCandy(Integer id) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			session.delete(session.get(Candy.class, id));
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
		}
	}
	
	public Candy selectCandyById(Integer id) {
		
		Session session = HibernateUtil.getSession();
		Candy c = null;
		try {
			c = (Candy)session.get(Candy.class, id);
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return c;
	}
	
	public void getVsLoad() {
		Session session = HibernateUtil.getSession();
		
		System.out.println("GET EXISTING CANDY");
		Candy cGet = (Candy)session.get(Candy.class, 1);
		System.out.println("CANDY GETTED");
		System.out.println(cGet);
		
		System.out.println("LOAD EXISTING CANDY");
		Candy cLoad = (Candy)session.load(Candy.class, 2);
		System.out.println("CANDY LOADED");
		System.out.println(cLoad);
		
		System.out.println("GET NON-EXISTING CANDY");
		cGet = (Candy)session.get(Candy.class, 1000);
		System.out.println(cGet);
		
		System.out.println("GET EXISTING CANDY AGAIN");
		cGet = (Candy)session.get(Candy.class, 1);
		System.out.println("CANDY GETTED");
		System.out.println(cGet);
		
//		System.out.println("LOAD NON-EXISTING CANDY");
//		cLoad = (Candy)session.load(Candy.class, 2000);
//		System.out.println(cLoad);
	}
	
	public Candy HQL(Integer id) {
		Query query;
		Session session = HibernateUtil.getSession();
		
		String hql;
		
		System.out.println("========GET ALL CANDY========");
		//hql = "FROM Candy WHERE id = 3";
		hql = "FROM Candy WHERE id = :id";
		query = session.createQuery(hql);
		query.setParameter("id", id);
		return (Candy)query.uniqueResult();
	}
	
	public void criteriasGetAll() {
		System.out.println("CRITERIA GET ALL");
		Session session = HibernateUtil.getSession();
		List<Candy> candys;
//		Criteria crit = session.createCriteria(Candy.class);
//		candys = crit.list();
		candys = session.createCriteria(Candy.class).list();
		
		for (Candy c : candys) {
			System.out.println(c);
		}
	}
	
	public void criteriaConditional() {
		System.out.println("----=====CONDITIONAL CRITERIAS-=-=-=-=-=-=-==-+++");
		Session session = HibernateUtil.getSession();
		
		Criteria crit = session.createCriteria(Candy.class);
//				.setProjection(Projections.count("id"));
		
		crit.add(Restrictions.and(
				Restrictions.eq("name", "Ryan Kats"),
				Restrictions.lt("id", 30)
				)).setProjection(Projections.projectionList()
						.add(Projections.count("id"))
					//	.add(Projections.groupProperty("name"))
						);
		
		System.out.println("Number of Ryan Kats, with ID below 30: " + crit.uniqueResult());
	}
	
	public void executeNamedQueries() {
		Session session = HibernateUtil.getSession();
		Query q1 = session.getNamedQuery("getAllCandys");
		Query q2 = session.getNamedQuery("getCandyById");
		Query q3 = session.getNamedQuery("originalSQL");
		
		q2.setParameter("grapes", 6);
		q3.setParameter("bananas", 15);
		
		System.out.println(q1.list());
		System.out.println(q2.list());
		System.out.println(q3.list());
	}
}




























