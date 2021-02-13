package org.notna.model;

public class Student {
	private int id;
	private String name;
	private String mobileNr;
	private String course;

	public Student(String name, String mobileNr, String course) {
		this.name = name;
		this.mobileNr = mobileNr;
		this.course = course;
	}

	public Student(int id, String name, String mobileNr, String course) {
		this(name, mobileNr, course);
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNr() {
		return mobileNr;
	}

	public void setMobileNr(String mobileNr) {
		this.mobileNr = mobileNr;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}
}
