package cn.linadan.programming_language.exam1.exam1_1.managersystem;

import java.util.ArrayList;
import java.util.Scanner;


public class ManagerSystemFunction {
	
	static ArrayList<String> namelist = new ArrayList();
	static ArrayList<Integer> numberlist = new ArrayList();
	static ArrayList<Integer> agelist = new ArrayList();
	static ArrayList<String> sexlist = new ArrayList();
	static ArrayList<Double> gradelist = new ArrayList();
	static ArrayList<String> yearlist = new ArrayList();
	public static void main(String[] args) {
		/*String name;
		int number;
		int age;
		String sex;
		double grade;
		String year;*/
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
				
				long start=System.nanoTime();   //��ȡ��ʼʱ��
				insert(name,number,age,sex,grade,year);
				long end=System.nanoTime();   //��ȡ����ʱ��
				System.out.println("��������ʱ�䣺 "+(end-start)/1000000.0+"ms");
				System.out.println("��ӳɹ�");
				System.out.println();
			}
			else if(type == 2){
				System.out.print("������Ҫ��ѯ��ѧ�ţ�");
				int number = s.nextInt();
				long start=System.nanoTime();
				int i = findnumber(number);
				long end=System.nanoTime();   
				System.out.println("��������ʱ�䣺 "+(end-start)/1000000.0+"ms");
				if(i != -1)
					display(i);
				else{
					System.out.println("�����ѧ�Ų�����");
					System.out.println();
				}
			}
			else if(type == 3){
				System.out.print("������Ҫ��ѯ��������");
				String name = s.next();
				long start=System.nanoTime();
				int i = findname(name);
				long end=System.nanoTime();   
				System.out.println("��������ʱ�䣺 "+(end-start)/1000000.0+"ms");
				if(i != -1)
					display(i);
				else{
					System.out.println("���������������");
					System.out.println();
				}
			}
			else if(type == 4){
				System.out.print("������Ҫ��ѯ�ĳɼ���");
				double grade = s.nextDouble();
				long start=System.nanoTime();
				ArrayList<Integer> g = findgrade(grade);
				long end=System.nanoTime();   
				System.out.println("��������ʱ�䣺 "+(end-start)/1000000.0+"ms");
				if(g != null){
					System.out.println("����ѧ���ɼ�Ϊ"+ grade + "��");
					for(int i = 0;i < g.size();i++)
						display(g.get(i));
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
				for(int i = 0;i < numberlist.size();i++)
					display(i);
			}
			else if(type == 6){
				long start=System.nanoTime();
				sortgrade();
				long end=System.nanoTime();   
				System.out.println("��������ʱ�䣺 "+(end-start)/1000000.0+"ms");
				for(int i = 0;i < gradelist.size();i++)
					display(i);
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
		namelist.add(name);
		numberlist.add(number);
		agelist.add(age);
		sexlist.add(sex);
		gradelist.add(grade);
		yearlist.add(year);
	}
	static int findnumber(int number)
	{
		for(int i = 0;i < numberlist.size();i++)
			if(numberlist.get(i) == number)
				return i;
		return -1;
	}
	static int findname(String name)
	{
		for(int i = 0;i < namelist.size();i++)
			if(name.equals(namelist.get(i)))
				return i;
		return -1;
	}
	static ArrayList<Integer> findgrade(double garde)
	{
		ArrayList<Integer> mygradelist = new ArrayList<Integer>();
		for(int i = 0;i < gradelist.size();i++)
			if(gradelist.get(i) == garde)
				mygradelist.add(i);
		return mygradelist;
	}
	static void sortnumber()
	{
		int n = numberlist.size();
		for(int i = 0;i < n-1;i++)
			for(int j = 0;j < n-1-i;j++)
				if(numberlist.get(j) > numberlist.get(j+1))
				{
					int number = numberlist.get(j);
					numberlist.set(j, numberlist.get(j+1));
					numberlist.set(j+1, number);
					
					String name = namelist.get(j);
					namelist.set(j, namelist.get(j+1));
					namelist.set(j+1, name);
					
					int age = agelist.get(j);
					agelist.set(j, agelist.get(j+1));
					agelist.set(j+1, age);
					
					String sex = sexlist.get(j);
					sexlist.set(j, sexlist.get(j+1));
					sexlist.set(j+1, sex);
					
					double grade = gradelist.get(j);
					gradelist.set(j, gradelist.get(j+1));
					gradelist.set(j+1, grade);
					
					String year = yearlist.get(j);
					yearlist.set(j, yearlist.get(j+1));
					yearlist.set(j+1, year);
				}
	}
	static void sortgrade()
	{
		int n = gradelist.size();
		for(int i = 0;i < n-1;i++)
			for(int j = 0;j < n-1-i;j++)
				if(gradelist.get(j) < gradelist.get(j+1))
				{
					double grade = gradelist.get(j);
					gradelist.set(j, gradelist.get(j+1));
					gradelist.set(j+1, grade);
					
					String name = namelist.get(j);
					namelist.set(j, namelist.get(j+1));
					namelist.set(j+1, name);
					
					int number = numberlist.get(j);
					numberlist.set(j, numberlist.get(j+1));
					numberlist.set(j+1, number);
					
					int age = agelist.get(j);
					agelist.set(j, agelist.get(j+1));
					agelist.set(j+1, age);
					
					String sex = sexlist.get(j);
					sexlist.set(j, sexlist.get(j+1));
					sexlist.set(j+1, sex);

					String year = yearlist.get(j);
					yearlist.set(j, yearlist.get(j+1));
					yearlist.set(j+1, year);
				}
	}
	static void display(int i)
	{
			System.out.println("������"+ namelist.get(i));
			System.out.println("ѧ�ţ�"+ numberlist.get(i));
			System.out.println("���䣺"+ agelist.get(i));
			System.out.println("�Ա�"+ sexlist.get(i));
			System.out.println("�ɼ���"+ gradelist.get(i));
			System.out.println("�꼶��"+ yearlist.get(i));
			System.out.println();
	}
}
