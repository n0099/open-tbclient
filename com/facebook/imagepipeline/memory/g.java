package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
/* loaded from: classes9.dex */
public class g {
    public static final int lPS = Runtime.getRuntime().availableProcessors();

    public static SparseIntArray ad(int i, int i2, int i3) {
        SparseIntArray sparseIntArray = new SparseIntArray();
        while (i <= i2) {
            sparseIntArray.put(i, i3);
            i *= 2;
        }
        return sparseIntArray;
    }

    public static r dox() {
        return new r(4194304, lPS * 4194304, ad(131072, 4194304, lPS), 131072, 4194304, lPS);
    }
}
