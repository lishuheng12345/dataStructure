package com.lish.LinkedList;

/**
 * @ClassName: HeroNode
 * @Author: lish
 * @Date: 2020/6/4 15:35
 * @Description:
 */
public class HeroNode {
    public int id;
    public String name;
    public String nickname;
    public HeroNode next;

    public HeroNode() {
    }

    public HeroNode(int id, String name, String nickname) {
        this.id = id;
        this.name = name;
        this.nickname = nickname;

    }


    @Override
    public String toString() {
        return "HeroNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
