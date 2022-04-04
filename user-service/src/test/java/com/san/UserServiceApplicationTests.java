package com.san;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.san.model.Role;
import com.san.model.UserProfile;
import com.san.repository.UserProfileRepository;
import com.san.service.UserProfileService;

@SpringBootTest(classes= {UserServiceApplicationTests.class})
class UserServiceApplicationTests {

	@Mock
	private UserProfileRepository repo;
	
	@InjectMocks
	private UserProfileService service;
	
	@Test
	public void getAll() {
		
		when(repo.findAll()).thenReturn(list());
		assertEquals(2, service.getAll().size());
	}
	
	@Test
	public void getById() {
		Integer id=1;
		Optional<UserProfile> user=list().stream().filter(u->u.getId().equals(id)).findFirst();
		when(repo.findById(id)).thenReturn(user);
		assertEquals(id, service.getById(id).getId());
	}
	
	@Test
	public void save() {
		UserProfile user=new UserProfile(1,"amit","amit@gmail.com","1234",new Date(2022-03-29),Set.of(new Role(1,"Administrator")));
		when(repo.save(user)).thenReturn(user);
		assertEquals(user, service.save(user));
	}
	
	@Test
	public void update() {
		UserProfile user=new UserProfile(1,"amit","amit@gmail.com","1234",new Date(2022-03-29),Set.of(new Role(1,"Administrator")));
		when(repo.save(user)).thenReturn(user);
		assertEquals(user, service.update(user));
	}
	
	@Test
	public void deleteById() {
		Integer id=1;
		service.deleteById(id);
		verify(repo,times(1)).deleteById(id);
	}

	public List<UserProfile> list(){
		return List.of(
				new UserProfile(1,"amit","amit@gmail.com","1234",new Date(2022-03-29),Set.of(new Role(1,"Administrator"))),
				new UserProfile(2,"ajit","ajit@gmail.com","1234",new Date(2022-03-30),Set.of(new Role(2,"Traveler")))
				);
	}
}
