package com.lish.LinkedList;

import java.util.Stack;

/**
 * @ClassName: LinkedListVo
 * @Author: lish
 * @Date: 2020/6/4 15:39
 * @Description:
 */
public class LinkedListVo {
    public HeroNode head = new HeroNode(0, "", "");


    //按照顺序插入
    public void insert(HeroNode listDo) {
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = listDo;
    }

    //按照编号顺序插入
    public void insertByOrder(HeroNode node) {
        HeroNode temp = head;
        Boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            } else if (node.id < temp.next.id) {
                break;
            } else if (node.id == temp.next.id) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.printf("准备插入的英雄的编号 %d 已经存在了, 不能加入/n", head.id);
        } else {
            node.next = temp.next;
            temp.next = node;
        }


    }

    //查询
    public void selectAll() {
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            System.out.println(temp.next);
            temp = temp.next;

        }
        System.out.println("==========");
    }

    //修改
    public void update(HeroNode node) {
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                flag = true;
                break;
            } else if (node.id == temp.next.id) {
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.printf("%d 编号已存在", node.id);
        } else {
            temp.next.name = node.name;
            temp.next.nickname = node.nickname;
        }
    }

    //删除
    public void del(HeroNode node) {
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                flag = true;
                break;
            } else if (node.id == temp.next.id) {
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.printf("%d 编号不存在", node.id);
        } else {
            temp.next = temp.next.next;
        }
    }

    //求单链表中有效节点的个数
    public int size() {
        if (head.next == null) {
            return 0;
        }
        int size = 0;
        HeroNode temp = head;
        while (temp.next != null) {
            size++;
            temp = temp.next;
        }
        return size;
    }

    //查找单链表中的倒数第 k 个结点
    public HeroNode findLastIndexNode(int index) {
        int size = size();
        if (index > size) {
            return null;
        }
        HeroNode temp = head;
        for (int i = 0; i <= size - index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    //单链表的反转
    public void reverseList() {
        if (head.next == null || head.next.next == null) {
            return;
        }
        HeroNode reverseHead = new HeroNode(0, "", "");
        HeroNode cur = head.next;
        HeroNode next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = reverseHead.next;
            reverseHead.next = cur;
            cur = next;
        }
        head.next = reverseHead.next;
    }

    //从尾到头打印单链表 【百度，要求方式 1：反向遍历 。 方式 2：Stack 栈】
    public void printList(){
        if(head.next==null){
            return;
        }
        Stack<HeroNode> stack= new Stack<>();
        HeroNode temp = head.next;
        while (temp!=null){
            stack.push(temp);
            temp=temp.next;
        }
        while (stack.size()>0){
            HeroNode node = stack.pop();
            System.out.println(node);
        }
    }

}
