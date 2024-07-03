package Bai4;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        HashSet<Point> set1= new HashSet<>();
        HashSet<Point> set2 = new HashSet<>();
        HashSet<Point> set3 = new HashSet<>();

        while(set1.size() < 8000){
            int x = (int) (Math.random() * 1000);
            int y = (int) (Math.random() * 1000);

            if(Math.sqrt(x - 800) + Math.sqrt(y - 800) <= Math.sqrt(400))
                set1.add(new Point(x, y));
        }

        while(set2.size() < 10000){
            int x = (int) (Math.random() * 10000);
            int y = (int) (Math.random() * 10000);
            Point p = new Point(x, y);

            if(Math.sqrt(x - 4000) + Math.sqrt(y - 800) <= Math.sqrt(500) && !set1.contains(p))
                set2.add(p);
        }

        while(set3.size() < 12000){
            int x = (int) (Math.random() * 10000);
            int y = (int) (Math.random() * 10000);
            Point p = new Point(x, y);

            if(Math.sqrt(x - 2400) + Math.sqrt(y - 2400) <= Math.sqrt(600) && !set1.contains(p) && !set2.contains(p))
                set3.add(p);
        }

        set1.addAll(set2);
        set1.addAll(set3);

        List<Point> pointList = new ArrayList<>(set1.stream().toList());
        Collections.shuffle(pointList);

        try {
            FileWriter myWriter = new FileWriter("output4.txt");

            for(Point p : pointList)
                myWriter.write(p.getX() + ", " + p.getY() + "\n");

            myWriter.close();

        } catch (IOException e) {
            System.out.println("loi ghi");

            e.printStackTrace();
        }
    }
}
