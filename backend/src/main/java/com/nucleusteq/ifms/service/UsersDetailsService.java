package com.nucleusteq.ifms.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.nucleusteq.ifms.repository.UserRepository;
import com.nucleusteq.ifms.security.UserPrincipal;
import com.nucleusteq.ifms.model.User;

@Service
public class UsersDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository usersRepository;
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user =usersRepository.findByEmail(email);
		if(user==null) {
			System.out.println("User Not found"); 
			throw new UsernameNotFoundException("user not found");
		}
		return new UserPrincipal(user);
	}


}