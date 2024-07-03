package Bai1;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        HashSet<Integer> TapA = new HashSet<>();
        HashSet<Integer> TapB = new HashSet<>();

        for (int i = 0; i < 2000000; i++) {
            TapA.add(i);
            TapB.add(i * 2);
        }

        System.out.println(TimGiao(TapA, TapB).size());
        System.out.println(TimHop(TapA, TapB).size());
    }

    public static HashSet<Integer> TimGiao(HashSet<Integer> tapA, HashSet<Integer> tapB){
        HashSet<Integer> TapGiao = new HashSet<>();

        for(int i : tapA)
            if(tapB.contains(i))
                TapGiao.add(i);

        return TapGiao;
    }

    public static HashSet<Integer> TimHop(HashSet<Integer> tapA, HashSet<Integer> tapB){
        HashSet<Integer> TapHop = new HashSet<>(tapA);
        TapHop.addAll(tapB);

        return TapHop;
    }
}
