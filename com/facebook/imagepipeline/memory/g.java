package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
/* loaded from: classes5.dex */
public class g {
    public static final int pDq = Runtime.getRuntime().availableProcessors();

    public static SparseIntArray ak(int i, int i2, int i3) {
        SparseIntArray sparseIntArray = new SparseIntArray();
        while (i <= i2) {
            sparseIntArray.put(i, i3);
            i *= 2;
        }
        return sparseIntArray;
    }

    public static r ezC() {
        return new r(4194304, pDq * 4194304, ak(131072, 4194304, pDq), 131072, 4194304, pDq);
    }
}
