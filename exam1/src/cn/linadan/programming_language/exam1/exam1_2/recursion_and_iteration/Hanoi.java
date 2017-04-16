package cn.linadan.programming_language.exam1.exam1_2.recursion_and_iteration;

import java.util.Scanner;
import java.util.Stack;

public class Hanoi {
	
	public static void main(String[] args) {
		System.out.println( " ���뺺ŵ������ ");
		Scanner s1 = new Scanner(System.in);
		int n = s1.nextInt();
		long start=System.nanoTime();   
		HanoiRecursion ( n,  'A' ,  'B' , 'C' ) ;
	    long end=System.nanoTime();   
		System.out.println("��ŵ���ݹ�����ʱ�䣺 "+(end-start)/1000000.0+"ms");
		start=System.nanoTime();   
		HanoiIteration ( n,  'A' ,  'B' , 'C' ) ;
	    end=System.nanoTime();   
		System.out.println("��ŵ����������ʱ�䣺 "+(end-start)/1000000.0+"ms");
		start=System.nanoTime();   
		play_regular (n) ;
	    end=System.nanoTime();   
		System.out.println("��ŵ����������ʱ��2�� "+(end-start)/1000000.0+"ms");

	}
	
	static void HanoiRecursion ( int n, char a,  char b,  char c )
	{ 
		if  ( n >= 1 )
	    { 
			HanoiRecursion ( n-1,  a,  c,  b ) ;
	       // System.out.println(a + " --> " + c );
	        HanoiRecursion ( n-1,  b,  a,  c ) ;
	    }
	}
	static void HanoiIteration ( int n, char a,  char b,  char c )
	{ 
	         Stack stack = new Stack();
	         stack.push(new Disk(n, a, b, c));
	         Disk popDisk = null;
	         while (!stack.isEmpty()) {
	        	 popDisk = (Disk) stack.pop();
	             if (popDisk.status == 1) {
	               //  System.out.println(popDisk.A + " -> " + popDisk.C);
	             } else {
	                 // ��˳�����
	                 // ��ִ���ƶ� popDisk ����һ����Disk��ӵ�Stack
	                 stack.push(new Disk(popDisk.status - 1, popDisk.B, popDisk.A,
	                         popDisk.C));
	                 // ��һ��statusΪ "1" ���ƶ�˳���� popDisk ��ͬ��Disk ��ӵ�Stack��
	                 stack.push(new Disk(1, popDisk.A, popDisk.B, popDisk.C));
	                 // ��ִ���ƶ� popDisk ��ǰһ����Disk��ӵ�Stack��
	                 stack.push(new Disk(popDisk.status - 1, popDisk.A, popDisk.C,
	                         popDisk.B));
	             }
	         }
	 }
	// �ǵݹ�ʵ�֣�����Hanoi����
   static void play_regular(int diskNum) {

        // ���ݹ��ɣ���Ҫ���� Disk �ĸ�����������λ�ý��е���
        // ���ĸ���Ϊż��ʱ��������������A->B->C����˳�����г�������
        // ���ĸ���Ϊ����ʱ������������"A->C->B"��˳�����г�������
        // ��diskNum��Disk������С�´󡰵�˳�����A���У���ջʵ�֣���ͬʱ��B����C���ÿ�
        Stack_play_regular A = new Stack_play_regular('A');
        Stack_play_regular B = new Stack_play_regular('B');
        Stack_play_regular C = new Stack_play_regular('C');
        for (int i = diskNum; i > 0; i--) {
            A.push(i);
        }
        // ��������ģ�����������״����
        Stack_play_regular[] towers = new Stack_play_regular[3];
        towers[0] = A;
        if (diskNum % 2 == 0) {
            towers[1] = B;
            towers[2] = C;
        } else {
            towers[1] = C;
            towers[2] = B;
        }
        // ��СDisk���ڵ�����ͨ��������towers�е�
        int towerOfMinimunDisk = 0;
        // ����֤����n��Disk�ƶ����������Ҫ2^n-1��
        // ���Ͻ��������������
        // ����С��Disk����������˳�����Ƶ���һ����
        // �Գ�����СDisk���ڵ������������������в��������ܳ����������
        // ���һ��һ������û��Disk����ʱ������Disk�����������Disk�ƶ���ûDisk������
        // �����������������Disk����ʱ������������������бȽϣ�����С��Disk�ƶ����ϴ��Disk��
        // ���������������û��Disk������������ƶ��Ѿ���ɻ�δ��ʼ��ֻ��һ������ʱ���ƶ�
        for (int i = 0; i < (Math.pow(2, diskNum) - 1);) {// --------------ע���ڴ˴�������i++
            // ȡ����������ʹ���������
            Stack_play_regular tower = towers[towerOfMinimunDisk];
            Stack_play_regular tower_1 = towers[(int) ((towerOfMinimunDisk + 1) % 3)];
            Stack_play_regular tower_2 = towers[(int) ((towerOfMinimunDisk + 2) % 3)];
            // �ƶ���С������
           // System.out.println(tower.name + " -> " + tower_1.name);
            tower_1.push(tower.pop());
            i++;// --------------ע���ڴ˴�����i++
            towerOfMinimunDisk = (int) ((towerOfMinimunDisk + 1) % 3);
            // ------------ע���ʱ������tower�������¸�ֵ
            tower = towers[towerOfMinimunDisk];
            tower_1 = towers[(int) ((towerOfMinimunDisk + 1) % 3)];
            tower_2 = towers[(int) ((towerOfMinimunDisk + 2) % 3)];
            // ���������������д���
            if ((tower_2.getTop() != -1 && (tower_1.showTopDisk() > tower_2
                    .showTopDisk()))
            // --------------ע��Ҫ�ټ��� tower_2.getTop() != -1
            // �����жϣ���������������Խ��
                    || (tower_1.getTop() == -1 && tower_2.getTop() != -1)) {
              //  System.out.println(tower_2.name + " -> " + tower_1.name);
                tower_1.push(tower_2.pop());
                i++;// --------------ע���ڴ˴�����i++
            } else if (((tower_1.getTop() != -1 && tower_1.showTopDisk() < tower_2
                    .showTopDisk()))
            // --------------ע��Ҫ�ټ��� tower_1.getTop() != -1
            // �����жϣ���������������Խ��
                    || (tower_1.getTop() != -1 && tower_2.getTop() == -1)) {
               // System.out.println(tower_1.name + " -> " + tower_2.name);
                tower_2.push(tower_1.pop());
                i++;// --------------ע���ڴ˴�����i++
            }
        }
    }


}
// �����Ϣ�Ľṹ��
class Disk {
    // ��A��ͨ��B���ƶ���C��
    char A;
    char B;
    char C;
    // ����״̬:��status=1ʱ����ʾ����ֱ�ӽ���Disk�ƶ���Ŀ����
    int status;

    // ��д���캯��
    public Disk(int status, char A, char B, char C) {
        this.status = status;
        this.A = A;
        this.B = B;
        this.C = C;
    }
}
class Stack_play_regular {
    // ����
    char name;
    // ����
    private int top = -1;

    public int getTop() {
        return top;
    }

    // ͨ������ʵ��Stack,���64��Disk
    int[] stack = new int[100];

    // ��д���캯������ʼ����������name
    public Stack_play_regular(char name) {
        this.name = name;
    }

    // �鿴ջ��
    public int showTopDisk() {
        if (top == -1) {
            return -1;
        }
        return stack[top];
    }

    // ��ջ
    public void push(int diskId) {
        stack[++top] = diskId;
    }

    // ��ջ
    public int pop() {
        return stack[top--];
    }
}
