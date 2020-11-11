package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
/* loaded from: classes18.dex */
public class g {
    public static final int oXt = Runtime.getRuntime().availableProcessors();

    public static SparseIntArray ag(int i, int i2, int i3) {
        SparseIntArray sparseIntArray = new SparseIntArray();
        while (i <= i2) {
            sparseIntArray.put(i, i3);
            i *= 2;
        }
        return sparseIntArray;
    }

    public static r equ() {
        return new r(4194304, oXt * 4194304, ag(131072, 4194304, oXt), 131072, 4194304, oXt);
    }
}
