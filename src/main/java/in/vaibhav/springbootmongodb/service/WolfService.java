package in.vaibhav.springbootmongodb.service;

import javax.validation.ConstraintViolationException;

import in.vaibhav.springbootmongodb.exception.WolfCollectionExeception;
import in.vaibhav.springbootmongodb.model.Wolf;

public interface WolfService {
	public void createWolf(Wolf wolf) throws ConstraintViolationException, WolfCollectionExeception;

}
