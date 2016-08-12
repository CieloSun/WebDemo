package com.cielo.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.cielo.entity.HibernateSessionFactory;
import com.cielo.entity.TbUser;
@Repository
public class TbUserDao {
	public boolean add(TbUser tbUser) {
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			session.beginTransaction();
			session.save(tbUser);
			session.getTransaction().commit();
			System.out.println("Success to add the user");
			return true;
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.out.println("Fail to add the user");
			e.printStackTrace();
		}
		return false;
	}
	
	public TbUser selectById(int id){
		Session session=null;
		try{
			session=HibernateSessionFactory.getSession();
			String hql="from TbUser as tb_user where tb_user.id=:id";
			Query query=session.createQuery(hql);
			query.setInteger("id", id);
			List list=query.list();
			return (TbUser) list.get(0);
		}catch(Exception e){
			System.out.println("Fail to select the item by id");
			e.printStackTrace();
		}
		return null;
	}
	
	public TbUser selectByName(String name){
		Session session=null;
		try{
			session=HibernateSessionFactory.getSession();
			String hql="from TbUser as tb_user where tb_user.name=:name";
			Query query=session.createQuery(hql);
			query.setString("name", name);
			List list=query.list();
			return (TbUser) list.get(0);
		}catch(Exception e){
			System.out.println("Fail to select the item by name");
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean deleteById(int id){
		Session session=null;
		try{
			session=HibernateSessionFactory.getSession();
			session.beginTransaction();
			String hqlString="delete from TbUser tb_user where tb_user.id=:id";
			Query query=session.createQuery(hqlString);
			query.setInteger("id", id);
			session.getTransaction().commit();
			return true;
		}catch(Exception e){
			session.getTransaction().rollback();
			System.out.println("Fail to delete the item by id");
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean deleteByName(String name){
		Session session=null;
		try{
			session=HibernateSessionFactory.getSession();
			session.beginTransaction();
			String hqlString="delete from TbUser tb_user where tb_user.name=:name";
			Query query=session.createQuery(hqlString);
			query.setString("name", name);
			session.getTransaction().commit();
			return true;
		}catch(Exception e){
			session.getTransaction().rollback();
			System.out.println("Fail to delete the item by name");
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean deleteByTbUser(TbUser tbUser){
		Session session=null;
		try{
			session=HibernateSessionFactory.getSession();
			session.beginTransaction();
			session.delete(tbUser);
			session.getTransaction().commit();
			return true;
		}catch(Exception e){
			session.getTransaction().rollback();
			System.out.println("Fail to delete the item by tbUser");
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean update(TbUser tbUser) {
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			session.beginTransaction();
			session.update(tbUser);
			session.getTransaction().commit();
			System.out.println("Success to update the user");
			return true;
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.out.println("Fail to update the user");
			e.printStackTrace();
		}
		return false;
	}

	public TbUserDao() {
		// TODO Auto-generated constructor stub
	}
}
