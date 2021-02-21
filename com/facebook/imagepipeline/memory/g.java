package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
/* loaded from: classes5.dex */
public class g {
    public static final int pLf = Runtime.getRuntime().availableProcessors();

    public static SparseIntArray aj(int i, int i2, int i3) {
        SparseIntArray sparseIntArray = new SparseIntArray();
        while (i <= i2) {
            sparseIntArray.put(i, i3);
            i *= 2;
        }
        return sparseIntArray;
    }

    public static r eyO() {
        return new r(4194304, pLf * 4194304, aj(131072, 4194304, pLf), 131072, 4194304, pLf);
    }
}
