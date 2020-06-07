package K_Union_Find.impl;

import K_Union_Find.UF;

public class UnionFind_1 implements UF {
    private int[] id;

    public UnionFind_1(int size) {

        id = new int[size];

        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }


    @Override
    public int getSize() {

        return id.length;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void unionElements(int p, int q) {
        int pID = find(p);
        int qID = find(q);

        if (pID == qID) return;

        for (int i = 0; i < id.length; i++) {

            if (id[i] == pID)
                id[i] = qID;
        }
    }

    // 查找元素p所对应的集合编号
    private int find(int p) {
        if (p < 0 && p >= id.length)
            throw new IllegalArgumentException("p is out of bound.");
        return id[p];
    }
}
