package com.merlin.Queue;

public class circleArrayQueueDemo {
    public static void main(String[] args) {
        CircleArrayQueue circleArrayQueue = new CircleArrayQueue(3);
    }
}

//使用数组模拟队列
class CircleArrayQueue {
    private final int maxSize; //表示数组的最大容量
    private final int[] arr; //该数据用于存放数组，模拟队列
    private int front; //队列头
    private int rear;//队列尾

    //创建队列的构造器
    public CircleArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = 0; // 指向队列头部，分析出front是指向队列头的前一个位置
        rear = 0; //指向队列尾部，指向队列尾的数据（即就是队列最后一个数据）
    }

    // 判断队列是否满
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return front == rear;
    }

    //添加数据到队列
    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列满，不能加入数据");
            return;
        }
        arr[rear] = n;  //先添加数据
        rear = (rear + 1) % maxSize; //rear后移,必须考虑取模
    }

    //获取队列数据，出队列
    public int getQueue() {
        //判断对垒是否为空
        if (isEmpty()) {
            //抛出异常
            throw new RuntimeException("队列空，不能取数据");
        }
        //先用一个变量存front对应的值
        //front后移，考虑取模
        //返回
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    //显示队列的数据
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空");
        }
        //从front开始遍历，遍历多少个元素
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    //显示队列的头数据，不是取数据
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列空，不能取数据");
        }
        return arr[front];
    }
}