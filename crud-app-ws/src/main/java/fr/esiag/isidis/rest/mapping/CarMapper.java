package fr.esiag.isidis.rest.mapping;

import fr.esiag.isidis.data.model.Car;
import fr.esiag.isidis.rest.model.CarRest;
import fr.xebia.extras.selma.IgnoreMissing;
import fr.xebia.extras.selma.Mapper;

@Mapper(withIgnoreMissing = IgnoreMissing.ALL)
public interface CarMapper {

	CarRest asCarRest(Car car);

	
	Car asCarEntity(CarRest carRest);

}
