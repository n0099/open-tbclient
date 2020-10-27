package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
/* loaded from: classes18.dex */
public class g {
    public static final int oOa = Runtime.getRuntime().availableProcessors();

    public static SparseIntArray ag(int i, int i2, int i3) {
        SparseIntArray sparseIntArray = new SparseIntArray();
        while (i <= i2) {
            sparseIntArray.put(i, i3);
            i *= 2;
        }
        return sparseIntArray;
    }

    public static r emD() {
        return new r(4194304, oOa * 4194304, ag(131072, 4194304, oOa), 131072, 4194304, oOa);
    }
}
