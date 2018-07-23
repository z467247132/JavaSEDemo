package com.zjj.dao;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class Person {
	private String name;
	private int age;
	
	public Person(String name,int age) {
		this.name = name;
		this.age = age;
	}
	
	public boolean equals(Object obj) {
		if(this==obj) {//地址值相等
			return true;
		}
		if(obj != null&&getClass() == obj.getClass()) {
			Person other = (Person)obj;
			if(other.getName()==null||other.getAge()==0) {
				return false;
			}else if(other.getName().equals(this.name)&&other.getAge()==this.age){
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}
	
	public int hashCode() {//使用HashCodeBuilder
		return new HashCodeBuilder().append(this.name).toHashCode();
	}
	
	public String toString() {
		//使用apache的toString工具类
		return ToStringBuilder.reflectionToString(this,ToStringStyle.SIMPLE_STYLE);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
