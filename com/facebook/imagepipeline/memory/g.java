package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
/* loaded from: classes15.dex */
public class g {
    public static final int oYW = Runtime.getRuntime().availableProcessors();

    public static SparseIntArray aj(int i, int i2, int i3) {
        SparseIntArray sparseIntArray = new SparseIntArray();
        while (i <= i2) {
            sparseIntArray.put(i, i3);
            i *= 2;
        }
        return sparseIntArray;
    }

    public static r eqs() {
        return new r(4194304, oYW * 4194304, aj(131072, 4194304, oYW), 131072, 4194304, oYW);
    }
}
