package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
/* loaded from: classes12.dex */
public class g {
    public static final int myZ = Runtime.getRuntime().availableProcessors();

    public static SparseIntArray af(int i, int i2, int i3) {
        SparseIntArray sparseIntArray = new SparseIntArray();
        while (i <= i2) {
            sparseIntArray.put(i, i3);
            i *= 2;
        }
        return sparseIntArray;
    }

    public static r dAV() {
        return new r(4194304, myZ * 4194304, af(131072, 4194304, myZ), 131072, 4194304, myZ);
    }
}
