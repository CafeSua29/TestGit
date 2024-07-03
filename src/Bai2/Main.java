package Bai2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        StringBuilder data = new StringBuilder();
        HashMap<String, Integer> hm = new HashMap<>();

        try {
            File myFile = new File("01.txt");

            Scanner myReader = new Scanner(myFile);

            while (myReader.hasNextLine())
                data.append(myReader.nextLine());

            myReader.close();

        } catch (IOException e) {
            System.out.println("loi doc");

            e.printStackTrace();
        }

        StringTokenizer st = new StringTokenizer(data.toString()," .,!=+-");

        while (st.hasMoreTokens()){
            String token = st.nextToken();

            if(hm.containsKey(token))
                hm.put(token, hm.get(token) + 1);
            else
                hm.put(token, 1);
        }

        try {
            FileWriter myWriter = new FileWriter("output.txt");

            for(String key : hm.keySet())
                myWriter.write(key + " = " + hm.get(key) + "\n");

            myWriter.close();

        } catch (IOException e) {
            System.out.println("loi ghi");

            e.printStackTrace();
        }
    }
}
