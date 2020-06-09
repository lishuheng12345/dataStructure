package com.lish.sparse;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * @ClassName: SparseDemo
 * @Author: lish
 * @Date: 2020/5/25 22:39
 * @Description:
 */
public class SparseDemo {
    public static void main(String[] args) throws Exception {
        // 11*11的棋盘,1为白棋,2为黑棋,0为空
        int[][] num = new int[11][11];
        num[1][2] = 1;
        num[2][3] = 2;
        num[3][4] = 1;
        readFile();
    }

    public static void wirteFile(int[][] num) throws Exception {
        System.out.println("原二维数组:");
        int count = 0;
        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < num[i].length; j++) {
                System.out.printf(num[i][j] + "    ");
                if (num[i][j] != 0) {
                    count++;
                }
            }
            System.out.println(" ");
        }
        int[][] sparse = new int[count + 1][3];
        sparse[0][0] = 11;
        sparse[0][1] = 11;
        sparse[0][2] = count;
        int flag = 0;
        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < num[i].length; j++) {
                if (num[i][j] != 0) {
                    flag++;
                    sparse[flag][0] = i;
                    sparse[flag][1] = j;
                    sparse[flag][2] = num[i][j];
                }
            }
        }
        System.out.println("稀疏数组为:");
        File file = new File("H:\\temp.data");
        if (file.exists()) {
            file.delete();
        }
        file.createNewFile();
        FileWriter fw = new FileWriter(file);
        for (int[] arrays : sparse) {
            for (int array : arrays) {
                System.out.printf(array + "   ");
                fw.write(array + " ");
            }
            fw.write("\r\n");
            System.out.println(" ");
        }
        fw.close();
    }

    public static void readFile() throws Exception{
        File file = new File("H:\\temp.data");
        FileReader fr = new FileReader(file);
        BufferedReader bf = new BufferedReader(fr);
        String line=null;
        StringBuffer sb = new StringBuffer();

        while ((line = bf.readLine())!= null){
            sb.append(line+"t");
        }
        String[] temp = sb.toString().split("t");
        System.out.println("还原的稀疏数组:");
        int[][] sparse = new int[temp.length][3];
        for (int i = 0; i < temp.length; i++) {
            String[] split = temp[i].split(" ");
            System.out.println(temp[i]);
            for (int j = 0; j < split.length; j++) {
                sparse[i][j]=Integer.parseInt(split[j]);
            }
        }

        int[][] num = new int[sparse[0][0]][sparse[0][1]];
        for (int i = 1; i < sparse.length; i++) {
            num[sparse[i][0]][sparse[i][1]]=sparse[i][2];
        }
        System.out.println("原二维数组:");
        for (int[] ints : num) {
            for (int i : ints) {
                System.out.printf(i+"   ");
            }
            System.out.println("");
        }

    }
}
