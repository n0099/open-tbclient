package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
/* loaded from: classes18.dex */
public class e {
    private static final SparseIntArray nWH = new SparseIntArray(0);

    private static int ecz() {
        int min = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        return min > 16777216 ? (min / 4) * 3 : min / 2;
    }

    public static r ecF() {
        return new r(0, ecz(), nWH);
    }
}
