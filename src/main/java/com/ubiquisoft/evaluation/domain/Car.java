package com.ubiquisoft.evaluation.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Car {

    private static final int NUM_PARTS = 1;
    private static final int NUM_TIRES = 4;

	private String year;
	private String make;
	private String model;

	private List<Part> parts;

	public Map<PartType, Integer> getMissingPartsMap() {
		/*
		 * Return map of the part types missing.
		 *
		 * Each car requires one of each of the following types:
		 *      ENGINE, ELECTRICAL, FUEL_FILTER, OIL_FILTER
		 * and four of the type: TIRE
		 *
		 * Example: a car only missing three of the four tires should return a map like this:
		 *
		 *      {
		 *          "TIRE": 3
		 *      }
		 */
        int numEngines = 0;
        int numElectrical = 0;
        int numFuelFilters = 0;
        int numOilFilters = 0;
        int numTires = 0;
        for (Part part : parts) {
            switch (part.getType()) {
                case ENGINE:
                    numEngines++;
                    break;
                case ELECTRICAL:
                    numElectrical++;
                    break;
                case TIRE:
                    numTires++;
                    break;
                case FUEL_FILTER:
                    numFuelFilters++;
                    break;
                case OIL_FILTER:
                    numOilFilters++;
                    break;
            }
        }
        Map<PartType, Integer> map = new HashMap<>();
        if (numEngines < NUM_PARTS) {
            map.put(PartType.ENGINE, NUM_PARTS);
        }
        if (numElectrical < NUM_PARTS) {
            map.put(PartType.ELECTRICAL, NUM_PARTS);
        }
        if (numFuelFilters < NUM_PARTS) {
            map.put(PartType.FUEL_FILTER, NUM_PARTS);
        }
        if (numOilFilters < NUM_PARTS) {
            map.put(PartType.OIL_FILTER, NUM_PARTS);
        }
        if (numTires < NUM_TIRES) {
            map.put(PartType.TIRE, NUM_TIRES - numTires);
        }
        return map;
	}

	@Override
	public String toString() {
		return "Car{" +
				       "year='" + year + '\'' +
				       ", make='" + make + '\'' +
				       ", model='" + model + '\'' +
				       ", parts=" + parts +
				       '}';
	}

	/* --------------------------------------------------------------------------------------------------------------- */
	/*  Getters and Setters *///region
	/* --------------------------------------------------------------------------------------------------------------- */

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public List<Part> getParts() {
		return parts;
	}

	public void setParts(List<Part> parts) {
		this.parts = parts;
	}

	/* --------------------------------------------------------------------------------------------------------------- */
	/*  Getters and Setters End *///endregion
	/* --------------------------------------------------------------------------------------------------------------- */

}
