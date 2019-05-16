package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
/* loaded from: classes2.dex */
public class g {
    public static final int kbs = Runtime.getRuntime().availableProcessors();

    public static SparseIntArray ai(int i, int i2, int i3) {
        SparseIntArray sparseIntArray = new SparseIntArray();
        while (i <= i2) {
            sparseIntArray.put(i, i3);
            i *= 2;
        }
        return sparseIntArray;
    }

    public static r cGW() {
        return new r(4194304, kbs * 4194304, ai(131072, 4194304, kbs), 131072, 4194304, kbs);
    }
}
