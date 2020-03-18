package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
/* loaded from: classes12.dex */
public class g {
    public static final int lWj = Runtime.getRuntime().availableProcessors();

    public static SparseIntArray ae(int i, int i2, int i3) {
        SparseIntArray sparseIntArray = new SparseIntArray();
        while (i <= i2) {
            sparseIntArray.put(i, i3);
            i *= 2;
        }
        return sparseIntArray;
    }

    public static r dru() {
        return new r(4194304, lWj * 4194304, ae(131072, 4194304, lWj), 131072, 4194304, lWj);
    }
}
