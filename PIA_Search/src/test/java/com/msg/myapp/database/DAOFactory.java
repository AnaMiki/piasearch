package com.msg.myapp.database;

/**
 * DAO
 * @category Database
 * @author alexander lavado
 *
 */


public class DAOFactory {
	public static DAOUser getDAOUser(){
		return new DAOUser();
	}	
}