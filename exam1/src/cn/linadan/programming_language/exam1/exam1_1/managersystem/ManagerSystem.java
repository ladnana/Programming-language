package cn.linadan.programming_language.exam1.exam1_1.managersystem;

import java.util.Scanner;

public class ManagerSystem {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("������");
		String name = s.nextLine();
		System.out.print("���䣺");
		int age = s.nextInt();
		System.out.print("�Ա�");
		String sex = s.nextLine();
		System.out.print("�ɼ���");
		double grade = s.nextDouble();
		System.out.print("�꼶��");
		int year = s.nextInt();
		
	}

}
class Student
{
	String name;
	int age;
	String sex;
	double grade;
	int year;
	Student()
	{
		
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public double getGrade() {
		return grade;
	}
	public void setGrade(double grade) {
		this.grade = grade;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
		
}