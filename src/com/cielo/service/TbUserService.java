package com.cielo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cielo.dao.TbUserDao;
import com.cielo.entity.TbUser;
@Service
public class TbUserService {
	@Autowired
	private TbUserDao tbUserDao;
	public boolean addAUserByNameAndPassword(String name, String password) {
		TbUser tbUser = new TbUser();
		tbUser.setName(name);
		tbUser.setPassword(password);
		return tbUserDao.add(tbUser);
	}
	public TbUserDao getTbUserDao() {
		return tbUserDao;
	}
	public void setTbUserDao(TbUserDao tbUserDao) {
		this.tbUserDao = tbUserDao;
	}
	public TbUserService(TbUserDao tbUserDao) {
		this.tbUserDao = tbUserDao;
	}
	public TbUserService() {
		// TODO Auto-generated constructor stub
	}
}
