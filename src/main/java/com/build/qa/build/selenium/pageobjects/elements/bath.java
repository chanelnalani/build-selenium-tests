package com.build.qa.build.selenium.pageobjects.elements;

public enum bath {

	BathroomFaucets("Bathroom Faucets"), BathroomSinks("Bathroom Sinks");

	private String name;

	private bath(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
	
