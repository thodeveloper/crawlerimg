package codedi.crawlerimg;

import java.io.FileNotFoundException;

import org.hibernate.Session;

import codedi.crawlerimg.entity.Xkcn;
import codedi.crawlerimg.persistence.HibernateUtil;
import codedi.crawlerimg.util.CommonUtil;

public class App 
{
    public static void main( String[] args ) throws FileNotFoundException
    {	
    	CommonUtil.uploadFileToS3();
//    	System.out.println("Maven + Hibernate + MySQL");
//    	Session session = HibernateUtil.getSessionFactory().openSession();
// 
//        session.beginTransaction();
//        Xkcn stock = new Xkcn();
// 
//        stock.setName("4715");
//        stock.setPath("GENM");
// 
//        session.save(stock);
//        session.getTransaction().commit();
    }
}
