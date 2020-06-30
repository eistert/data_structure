package K_Union_Find;

import K_Union_Find.impl.UnionFind_1;
import K_Union_Find.impl.UnionFind_2;
import K_Union_Find.impl.UnionFind_3;
import K_Union_Find.impl.UnionFind_4;

import java.util.Random;

public class Main {

    private static double testUF(UF uf, int m) {

        int size = uf.getSize();
        Random random = new Random();

        long startTime = System.nanoTime();


        for (int i = 0; i < m; i++) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.unionElements(a, b);
        }

        for (int i = 0; i < m; i++) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.isConnected(a, b);
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {

        // UnionFind1 慢于 UnionFind2
//        int size = 100000;
//        int m = 10000;

        // UnionFind2 慢于 UnionFind1, 但UnionFind3最快
//        int size = 100000;
//        int m = 100000;

        int size = 10000000;
        int m = 10000000;

//        UnionFind_1 uf1 = new UnionFind_1(size);
//        System.out.println("UnionFind1 : " + testUF(uf1, m) + " s");
//
//        UnionFind_2 uf2 = new UnionFind_2(size);
//        System.out.println("UnionFind2 : " + testUF(uf2, m) + " s");

        UnionFind_3 uf3 = new UnionFind_3(size);
        System.out.println("UnionFind3 : " + testUF(uf3, m) + " s");

        UnionFind_4 uf4 = new UnionFind_4(size);
        System.out.println("UnionFind4 : " + testUF(uf4, m) + " s");
    }
}
