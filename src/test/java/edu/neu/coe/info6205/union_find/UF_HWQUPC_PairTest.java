package edu.neu.coe.info6205.union_find;
import java.util.Random;

public class UF_HWQUPC_PairTest {
    public static int randomNum(int min, int max) {
        Random random = new Random();
        return random.ints(min, max)
                .findFirst()
                .getAsInt();
    }

    public static int getConnections(UF_HWQUPC h, int sites) {
        int pairs = 0;
        while (h.components() != 1) {
            h.connect(randomNum(0, sites), randomNum(0, sites));
            pairs++;
        }
        return pairs;
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            int num = randomNum(0, 1000);
            UF_HWQUPC p = new UF_HWQUPC(num);
            int conns = getConnections(p, num);
            System.out.println("Sites:" + num + "_______Total Connections:"+ conns);
        }
    }
}
