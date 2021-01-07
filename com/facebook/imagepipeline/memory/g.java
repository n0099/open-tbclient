package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
/* loaded from: classes3.dex */
public class g {
    public static final int pEX = Runtime.getRuntime().availableProcessors();

    public static SparseIntArray al(int i, int i2, int i3) {
        SparseIntArray sparseIntArray = new SparseIntArray();
        while (i <= i2) {
            sparseIntArray.put(i, i3);
            i *= 2;
        }
        return sparseIntArray;
    }

    public static r eAg() {
        return new r(4194304, pEX * 4194304, al(131072, 4194304, pEX), 131072, 4194304, pEX);
    }
}
