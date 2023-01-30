package com.cisco.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cisco.model.UserInfoModel;

@Repository
public interface UsersDao extends CrudRepository<UserInfoModel, Integer> {
	
	
	 
	@Query("from UserInfoModel where firstname=:username and password=:password")
    public UserInfoModel  isValidAdminUser(String username,String password );
	
	 
	
	 @Query("from UserInfoModel where rollid=:rollid")
	    public Iterable<UserInfoModel> getUserDatabyRollid(int rollid);
	 
	  
	 
	 @Query("from UserInfoModel where password=:password")
	    public  UserInfoModel  isCorrectPassword_or_Not(String password);
  
	 @Modifying
	 @Transactional
	 @Query("update UserInfoModel   set  password = :password where rollid=1 and firstname=:username")
	 public int updateAdminPassword(@Param("password") String password, @Param("username") String username);
	 
	 


}
