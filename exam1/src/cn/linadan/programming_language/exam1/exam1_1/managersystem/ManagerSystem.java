package cn.linadan.programming_language.exam1.exam1_1.managersystem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class ManagerSystem {
	static ArrayList<Student> studentlist = new ArrayList();
	public static void main(String[] args) {
		while(true){
			System.out.println("������Ҫ���еĲ�����");
			System.out.println("1.����ѧ�� 2.��ѧ�Ų�ѯ 3.�����ֲ�ѯ 4.���ɼ���ѯ"
					+ " 5.��ѧ������ 6.���ɼ����� 7.�˳�");
			Scanner s = new Scanner(System.in);
			int type = s.nextInt();
			if(type == 1){
				Scanner s1 = new Scanner(System.in);
				System.out.print("������");
				String name = s1.next();
				System.out.print("ѧ�ţ�");
				int number = s1.nextInt();
				System.out.print("���䣺");
				int age = s1.nextInt();
				System.out.print("�Ա�");
				String sex = s1.next();
				System.out.print("�ɼ���");
				double grade = s1.nextDouble();
				System.out.print("�꼶��");
				String year = s1.next();
				
				long start=System.nanoTime(); 
				insert(name,number,age,sex,grade,year);
				long end=System.nanoTime();   
				System.out.println("��������ʱ�䣺 "+(end-start)/1000000.0+"ms");
				System.out.println("��ӳɹ�");
				System.out.println();
			}
			else if(type == 2){
				System.out.print("������Ҫ��ѯ��ѧ�ţ�");
				int number = s.nextInt();
				long start=System.nanoTime(); 
				Student stu = findnumber(number);
				long end=System.nanoTime();   
				System.out.println("��������ʱ�䣺 "+(end-start)/1000000.0+"ms");
				if(stu != null)
					display(stu);
				else{
					System.out.println("�����ѧ�Ų�����");
					System.out.println();
				}
			}
			else if(type == 3){
				System.out.print("������Ҫ��ѯ��������");
				String name = s.next();
				long start=System.nanoTime(); 
				Student stu = findname(name);
				long end=System.nanoTime();   
				System.out.println("��������ʱ�䣺 "+(end-start)/1000000.0+"ms");
				if(stu != null)
					display(stu);
				else{
					System.out.println("���������������");
					System.out.println();
				}
			}
			else if(type == 4){
				System.out.print("������Ҫ��ѯ�ĳɼ���");
				double grade = s.nextDouble();
				long start=System.nanoTime(); 
				ArrayList<Student> stu = findgrade(grade);
				long end=System.nanoTime();   
				System.out.println("��������ʱ�䣺 "+(end-start)/1000000.0+"ms");
				if(stu != null){
					System.out.println("����ѧ���ɼ�Ϊ"+ grade + "��");
					for(int i = 0;i < stu.size();i++)
						display(stu.get(i));
				}
				else{
					System.out.println("������ѧ���ɼ�Ϊ"+ grade + "��");
					System.out.println();
				}
			}
			else if(type == 5){
				long start=System.nanoTime(); 
				sortnumber();
				long end=System.nanoTime();   
				System.out.println("��������ʱ�䣺 "+(end-start)/1000000.0+"ms");
				for(int i = 0;i < studentlist.size();i++)
					display(studentlist.get(i));
			}
			else if(type == 6){
				long start=System.nanoTime(); 
				sortgrade();
				long end=System.nanoTime();   
				System.out.println("��������ʱ�䣺 "+(end-start)/1000000.0+"ms");
				for(int i = 0;i < studentlist.size();i++)
					display(studentlist.get(i));
			}
			else if(type == 7){
				break;
			}
			else{
				System.out.println("���벻�Ϸ�������������");
				continue;
			}
		}
	}
	static void insert(String name,int number,int age,String sex,double grade,String year)
	{
		Student stu = new Student(name, number,age, sex, grade,year);
		studentlist.add(stu);
	}
	static Student findnumber(int number)
	{
		for(int i = 0;i < studentlist.size();i++)
			if(studentlist.get(i).getNumber() == number)
				return studentlist.get(i);
		return null;
	}
	static Student findname(String name)
	{
		for(int i = 0;i < studentlist.size();i++)
			if(name.equals(studentlist.get(i).getName()))
				return studentlist.get(i);
		return null;
	}
	static ArrayList<Student> findgrade(double garde)
	{
		ArrayList<Student> gradelist = new ArrayList<Student>();
		for(int i = 0;i < studentlist.size();i++)
			if(studentlist.get(i).getGrade() == garde)
				gradelist.add(studentlist.get(i));
		return gradelist;
	}
	static void sortnumber()
	{
		//Collections.sort(studentlist, new numberComparator());
		int n = studentlist.size();
		for(int i = 0;i < n-1;i++)
			for(int j = 0;j < n-1-i;j++)
				if(studentlist.get(j).getNumber() > studentlist.get(j+1).getNumber())
				{
					Student stu = studentlist.get(j);
					studentlist.set(j, studentlist.get(j+1));
					studentlist.set(j+1, stu);
				}
	}
	static void sortgrade()
	{
		//Collections.sort(studentlist, new gradeComparator());
		int n = studentlist.size();
		for(int i = 0;i < n-1;i++)
			for(int j = 0;j < n-1-i;j++)
				if(studentlist.get(j).getGrade() < studentlist.get(j+1).getGrade())
				{
					Student stu = studentlist.get(j);
					studentlist.set(j, studentlist.get(j+1));
					studentlist.set(j+1, stu);
				}
	}
	static void display(Student s)
	{
			System.out.println("������"+ s.getName());
			System.out.println("ѧ�ţ�"+ s.getNumber());
			System.out.println("���䣺"+ s.getAge());
			System.out.println("�Ա�"+ s.getSex());
			System.out.println("�ɼ���"+ s.getGrade());
			System.out.println("�꼶��"+ s.getYear());
			System.out.println();
	}
}
/*class numberComparator implements Comparator<Student> {
	@Override
	public int compare(Student arg0, Student arg1) {
		if(arg0.number > arg1.number)
			return 1;
		else if(arg0.number < arg1.number)
			return -1;
		else
			return 0;
	}
}
class gradeComparator implements Comparator<Student> {
	@Override
	public int compare(Student arg0, Student arg1) {
		if(arg0.grade > arg1.grade)
			return 1;
		else if(arg0.grade < arg1.grade)
			return -1;
		else
			return 0;
	}
}*/
class Student
{
	String name;
	int number;
	int age;
	String sex;
	double grade;
	String year;
	Student(String name,int number,int age,String sex,double grade,String year)
	{
		this.name = name;
		this.number = number;
		this.age = age;
		this.sex = sex;
		this.grade = grade;
		this.year = year;
	}     
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
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
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
		
}