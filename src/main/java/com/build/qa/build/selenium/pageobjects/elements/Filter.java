package com.build.qa.build.selenium.pageobjects.elements;

public enum Filter {
	Modern("Modern"), Traditional("Traditional"), Transitional("Transitional");

	private String name;

	private Filter(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
