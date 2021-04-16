package com.wolken.wolkenapp.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.wolken.wolkenapp.dto.GarageDTO;

@Component
public class GarageDAOImpl implements GarageDAO {

	Logger logger = Logger.getLogger("GarageDAOImpl");

	// LocalSessionFactoryBean bean = new LocalSessionFactoryBean();
//	BasicDataSource basicDataSource = new BasicDataSource();
	Configuration configuration = new Configuration();

	public GarageDAOImpl() {

//		basicDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//		basicDataSource.setUrl("jdbc:mysql://localhost:3306/wolken");
//		basicDataSource.setUsername("root");
//		basicDataSource.setPassword("Sparkleruby24!");

//		bean.setDataSource(basicDataSource);
//		bean.setAnnotatedClasses(com.wolken.wolkenapp.dto.GarageDTO.class);

		configuration = new Configuration();

		configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		configuration.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
		configuration.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/wolken");
		configuration.setProperty("hibernate.connection.username", "root");
		configuration.setProperty("hibernate.connection.password", "Sparkleruby24!");
		configuration.addAnnotatedClass(GarageDTO.class);

	}

	@Override
	public String add(GarageDTO garageDTO) {

		logger.info("INSIDE ADD()");

//		Configuration configuration = new Configuration();
//
//		configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
//		configuration.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
//		configuration.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/wolken");
//		configuration.setProperty("hibernate.connection.username", "root");
//		configuration.setProperty("hibernate.connection.password", "Sparkleruby24!");
//		configuration.addAnnotatedClass(GarageDTO.class);

		SessionFactory factory = configuration.buildSessionFactory();

		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();
		session.save(garageDTO);
		transaction.commit();
		session.close();

		return "Successfully Added";

	}

	@Override
	public List<GarageDTO> getAll() {
		// TODO Auto-generated method stub

		logger.info("INSIDE getAll()");

		SessionFactory factory = configuration.buildSessionFactory();

		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from GarageDTO");

		List<GarageDTO> itemList = query.list();

		transaction.commit();
		session.close();

		return itemList;
	}

	@Override
	public String updatePricebyName(double newPrice, String nameToBeUpdated) {
		// TODO Auto-generated method stub

		logger.info("INSIDE updatePricebyName()");

		SessionFactory factory = configuration.buildSessionFactory();

		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("Update GarageDTO garDTO set garDTO.price=: pr where garDTO.name=: nm");
		query.setParameter("pr", newPrice);
		query.setParameter("nm", nameToBeUpdated);

		query.executeUpdate();

		transaction.commit();
		session.close();

		return "Sucessfully Updated";
	}

	@Override
	public String deleteByName(String nameToBeDeleted) {
		// TODO Auto-generated method stub

		logger.info("INSIDE deleteByName()");

		SessionFactory factory = configuration.buildSessionFactory();

		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("delete from GarageDTO garDTO where garDTO.name=:nm ");
		query.setParameter("nm", nameToBeDeleted);

		query.executeUpdate();

		transaction.commit();
		session.close();

		return "Sucessfully Deleted";

	}

}
