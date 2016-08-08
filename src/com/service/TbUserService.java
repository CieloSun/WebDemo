package com.service;

import com.dao.TbUserDao;
import com.entity.TbUser;

public class TbUserService {
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
