package in.vaibhav.springbootmongodb.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.vaibhav.springbootmongodb.model.Wolf;
import in.vaibhav.springbootmongodb.repository.WolfRepository;

@RestController
public class WolfController {
	@Autowired
	private WolfRepository wolfRepo;

	@GetMapping("/wolfs")
	public ResponseEntity<?> getAllWolfs() {
		List<Wolf> wolfs = wolfRepo.findAll();
		if (wolfs.size() > 0) {
			return new ResponseEntity<List<Wolf>>(wolfs, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("No wolfs available", HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/wolfs")
	public ResponseEntity<?> createWolf(@RequestBody Wolf wolf) {
		try {
			wolf.setCreatedAt(new Date(System.currentTimeMillis()));
			wolfRepo.save(wolf);
			return new ResponseEntity<Wolf>(wolf, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/wolfs/{id}")
	public ResponseEntity<?> getSingleWolf(@PathVariable("id") String id) {
		Optional<Wolf> wolfOptional = wolfRepo.findById(id);
		if (wolfOptional.isPresent()) {
			return new ResponseEntity<>(wolfOptional.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Wolf not found with id" + id, HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/wolfs/{id}")
	public ResponseEntity<?> updateById(@PathVariable("id") String id, @RequestBody Wolf wolf) {
		Optional<Wolf> wolfOptional = wolfRepo.findById(id);
		if (wolfOptional.isPresent()) {
			Wolf wolfToSave = wolfOptional.get();
			wolfToSave.setCompleted(wolf.getCompleted() != null ? wolf.getCompleted() : wolfToSave.getCompleted());
			wolfToSave.setWolf(wolf.getWolf() != null ? wolf.getWolf() : wolfToSave.getWolf());
			wolfToSave.setDescription(
					wolf.getDescription() != null ? wolf.getDescription() : wolfToSave.getDescription());
			wolfToSave.setUpdatedAt(new Date(System.currentTimeMillis()));
			wolfRepo.save(wolfToSave);
			return new ResponseEntity<>(wolfToSave, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Wolf not found with id" + id, HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/wolfs/{id}")
	public ResponseEntity<?> deleteById(@PathVariable("id") String id) {
		try {
			wolfRepo.deleteById(id);
			return new ResponseEntity<>("Succesfully deleted with id" + id, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);

		}
	}
}
