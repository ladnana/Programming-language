package cn.linadan.programming_language.exam1.exam1_2.recursion_and_iteration;

import java.util.Scanner;
import java.util.Stack;

public class Hanoi {
	
	public static void main(String[] args) {
		System.out.println( " 输入汉诺塔层数 ");
		Scanner s1 = new Scanner(System.in);
		int n = s1.nextInt();
		long start=System.nanoTime();   
		HanoiRecursion ( n,  'A' ,  'B' , 'C' ) ;
	    long end=System.nanoTime();   
		System.out.println("汉诺塔递归运行时间： "+(end-start)/1000000.0+"ms");
		start=System.nanoTime();   
		HanoiIteration ( n,  'A' ,  'B' , 'C' ) ;
	    end=System.nanoTime();   
		System.out.println("汉诺塔迭代运行时间： "+(end-start)/1000000.0+"ms");
		start=System.nanoTime();   
		play_regular (n) ;
	    end=System.nanoTime();   
		System.out.println("汉诺塔迭代运行时间2： "+(end-start)/1000000.0+"ms");

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
	                 // 反顺序添加
	                 // 将执行移动 popDisk 的下一步的Disk添加到Stack
	                 stack.push(new Disk(popDisk.status - 1, popDisk.B, popDisk.A,
	                         popDisk.C));
	                 // 将一个status为 "1" 且移动顺序与 popDisk 相同的Disk 添加到Stack中
	                 stack.push(new Disk(1, popDisk.A, popDisk.B, popDisk.C));
	                 // 将执行移动 popDisk 的前一步的Disk添加到Stack中
	                 stack.push(new Disk(popDisk.status - 1, popDisk.A, popDisk.C,
	                         popDisk.B));
	             }
	         }
	 }
	// 非递归实现：根据Hanoi规律
   static void play_regular(int diskNum) {

        // 根据规律，需要根据 Disk 的个数，多塔的位置进行调整
        // 塔的个数为偶数时，将三个塔按“A->B->C”的顺序排列成三角形
        // 塔的个数为奇数时，将三个塔按"A->C->B"的顺序排列成三角形
        // 将diskNum个Disk按”上小下大“的顺序放在A塔中（堆栈实现），同时将B塔和C塔置空
        Stack_play_regular A = new Stack_play_regular('A');
        Stack_play_regular B = new Stack_play_regular('B');
        Stack_play_regular C = new Stack_play_regular('C');
        for (int i = diskNum; i > 0; i--) {
            A.push(i);
        }
        // 将三个塔模拟成三角形形状排列
        Stack_play_regular[] towers = new Stack_play_regular[3];
        towers[0] = A;
        if (diskNum % 2 == 0) {
            towers[1] = B;
            towers[2] = C;
        } else {
            towers[1] = C;
            towers[2] = B;
        }
        // 最小Disk所在的塔，通过该塔在towers中的
        int towerOfMinimunDisk = 0;
        // 根据证明：n个Disk移动完成至少需要2^n-1次
        // 不断交替进行以下两步
        // 将最小的Disk按以上塔的顺序下移到下一个塔
        // 对除了最小Disk所在的塔的另外两个塔进行操作，可能出现两种情况
        // 情况一：一个塔中没有Disk，此时将存在Disk的塔最上面的Disk移动到没Disk的塔上
        // 情况二：两个塔都有Disk，此时对他们最上面的塔进行比较，将较小的Disk移动到较大的Disk上
        // 不会存在两个塔都没有Disk的情况，除非移动已经完成或未开始或只有一个盘子时的移动
        for (int i = 0; i < (Math.pow(2, diskNum) - 1);) {// --------------注意在此处不进行i++
            // 取出三个塔，使代码更清晰
            Stack_play_regular tower = towers[towerOfMinimunDisk];
            Stack_play_regular tower_1 = towers[(int) ((towerOfMinimunDisk + 1) % 3)];
            Stack_play_regular tower_2 = towers[(int) ((towerOfMinimunDisk + 2) % 3)];
            // 移动最小的盘子
           // System.out.println(tower.name + " -> " + tower_1.name);
            tower_1.push(tower.pop());
            i++;// --------------注意在此处进行i++
            towerOfMinimunDisk = (int) ((towerOfMinimunDisk + 1) % 3);
            // ------------注意此时对三个tower进行重新赋值
            tower = towers[towerOfMinimunDisk];
            tower_1 = towers[(int) ((towerOfMinimunDisk + 1) % 3)];
            tower_2 = towers[(int) ((towerOfMinimunDisk + 2) % 3)];
            // 对另外两个塔进行处理
            if ((tower_2.getTop() != -1 && (tower_1.showTopDisk() > tower_2
                    .showTopDisk()))
            // --------------注意要再加上 tower_2.getTop() != -1
            // 进行判断，否则可能数组访问越界
                    || (tower_1.getTop() == -1 && tower_2.getTop() != -1)) {
              //  System.out.println(tower_2.name + " -> " + tower_1.name);
                tower_1.push(tower_2.pop());
                i++;// --------------注意在此处进行i++
            } else if (((tower_1.getTop() != -1 && tower_1.showTopDisk() < tower_2
                    .showTopDisk()))
            // --------------注意要再加上 tower_1.getTop() != -1
            // 进行判断，否则可能数组访问越界
                    || (tower_1.getTop() != -1 && tower_2.getTop() == -1)) {
               // System.out.println(tower_1.name + " -> " + tower_2.name);
                tower_2.push(tower_1.pop());
                i++;// --------------注意在此处进行i++
            }
        }
    }


}
// 存放信息的结构体
class Disk {
    // 从A塔通过B塔移动到C塔
    char A;
    char B;
    char C;
    // 塔的状态:当status=1时，表示可以直接将该Disk移动到目标塔
    int status;

    // 重写构造函数
    public Disk(int status, char A, char B, char C) {
        this.status = status;
        this.A = A;
        this.B = B;
        this.C = C;
    }
}
class Stack_play_regular {
    // 塔名
    char name;
    // 塔顶
    private int top = -1;

    public int getTop() {
        return top;
    }

    // 通过数组实现Stack,最多64个Disk
    int[] stack = new int[100];

    // 重写构造函数，初始化塔的名字name
    public Stack_play_regular(char name) {
        this.name = name;
    }

    // 查看栈顶
    public int showTopDisk() {
        if (top == -1) {
            return -1;
        }
        return stack[top];
    }

    // 入栈
    public void push(int diskId) {
        stack[++top] = diskId;
    }

    // 出栈
    public int pop() {
        return stack[top--];
    }
}
