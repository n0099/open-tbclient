package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
/* loaded from: classes2.dex */
public class g {
    public static final int jIZ = Runtime.getRuntime().availableProcessors();

    public static SparseIntArray ah(int i, int i2, int i3) {
        SparseIntArray sparseIntArray = new SparseIntArray();
        while (i <= i2) {
            sparseIntArray.put(i, i3);
            i *= 2;
        }
        return sparseIntArray;
    }

    public static r cyU() {
        return new r(4194304, jIZ * 4194304, ah(131072, 4194304, jIZ), 131072, 4194304, jIZ);
    }
}
