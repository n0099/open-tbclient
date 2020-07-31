package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
/* loaded from: classes4.dex */
public class g {
    public static final int ndk = Runtime.getRuntime().availableProcessors();

    public static SparseIntArray ac(int i, int i2, int i3) {
        SparseIntArray sparseIntArray = new SparseIntArray();
        while (i <= i2) {
            sparseIntArray.put(i, i3);
            i *= 2;
        }
        return sparseIntArray;
    }

    public static r dIN() {
        return new r(4194304, ndk * 4194304, ac(131072, 4194304, ndk), 131072, 4194304, ndk);
    }
}
