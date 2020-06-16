package com.lish.LinkedList;

/**
 * @ClassName: Josepfu
 * @Author: lish
 * @Date: 2020/6/9 11:35
 * @Description:
 */
public class Josepfu {
    public static void main(String[] args) {
        CircleList list = new CircleList();
        list.removeBoy(1,2,5);
    }

}

class CircleList{
    Boy first = null;

    public void createList(int num){
        if(num<1){
            System.out.println("num数值错误,无法生成循环链表");
        }
        Boy flag = null;
        for (int i = 1; i <= num; i++) {
            Boy boy = new Boy(i, null);
            if(i==1){
                first=boy;
                first.setNext(first);
                flag=first;
            }else {
                flag.setNext(boy);
                boy.setNext(first);
                flag=boy;
            }
        }
    }
    public void printList(){
        if(first==null){
            System.out.println("链表为空");
            return;
        }
        Boy flag=first;
        while (true){
            System.out.println("打印当前小孩:"+flag);
            if(flag.getNext()==first){
                break;
            }
            flag=flag.getNext();

        }
    }

    /** @param startNo * 表示从第几个小孩开始数数
     * @param countNum * 表示数几下
     * @param nums * 表示最初有多少小孩在圈中 */
    //1.  需求创建一个辅助指针(变量) helper , 事先应该指向环形链表的最后这个节点.
    //补充： 小孩报数前，先让 first 和  helper 移动 k - 1次
    //2.  当小孩报数时，让first 和 helper 指针同时 的移动  m  - 1 次
    //3.  这时就可以将first 指向的小孩节点 出圈
    public void removeBoy(int startNo,int countNum ,int nums){
        createList(nums);
        Boy helper = first;
        while(helper.getNext()!=first){
            helper=helper.getNext();
        }

        for (int i = 0; i < startNo-1; i++) {
            first=first.getNext();
            helper=helper.getNext();
        }
        while (true){
            if(first==helper){
                System.out.printf("最后移除的是%d\n",first.getNo());
                break;
            }
            for (int i = 0; i < countNum-1; i++) {
                first=first.getNext();
                helper=helper.getNext();
            }
            System.out.printf("当前移除%d \n",first.getNo());
            first=first.getNext();
            helper.setNext(first);
        }
    }

}


class Boy{
    private int no;
    private Boy next;

    public Boy() {
    }

    public Boy(int no, Boy next) {
        this.no = no;
        this.next = next;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "no=" + no +
                '}';
    }
}
