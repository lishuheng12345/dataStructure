package com.lish.LinkedList;

/**
 * @ClassName: LinkedListDemo
 * @Author: lish
 * @Date: 2020/6/4 15:55
 * @Description:
 */
public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedListVo linkedList = new LinkedListVo();
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
        HeroNode hero5 = new HeroNode(4, "111", "111");
        linkedList.insert(hero1);
        linkedList.insert(hero3);
        linkedList.insert(hero2);
        linkedList.insert(hero4);
        linkedList.selectAll();
//        LinkedListVo linkedList2 = new LinkedListVo();
//        linkedList2.insertByOrder(hero4);
//        linkedList2.insertByOrder(hero2);
//        linkedList2.insertByOrder(hero1);
//        linkedList2.insertByOrder(hero3);
//        linkedList2.selectAll();
//
//        linkedList.update(hero5);
//        linkedList.selectAll();
//
//        linkedList2.del(hero2);
//        linkedList2.del(hero3);
//        linkedList2.selectAll();
//        System.out.println(linkedList.size());
//        System.out.println(linkedList.findLastIndexNode(2));
//        linkedList.reverseList();
//        linkedList.selectAll();
            linkedList.printList();

    }
}
