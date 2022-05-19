package in.vaibhav.springbootmongodb.service;

import java.util.Date;
import java.util.Optional;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.vaibhav.springbootmongodb.exception.WolfCollectionExeception;
import in.vaibhav.springbootmongodb.model.Wolf;
import in.vaibhav.springbootmongodb.repository.WolfRepository;

@Service
public class WolfServiceimpl implements WolfService {
	@Autowired
	private WolfRepository wolfRepo;

	public void createWolf(Wolf wolf) throws ConstraintViolationException, WolfCollectionExeception {
		Optional<Wolf> wolfOptional = wolfRepo.findByWolf(wolf.getWolf());

		if (wolfOptional.isPresent()) {
			throw new WolfCollectionExeception(WolfCollectionExeception.WolfAlreadyExists());
		} else {
			wolf.setCreatedAt(new Date(System.currentTimeMillis()));
			wolfRepo.save(wolf);
		}
		
	}
		
}
