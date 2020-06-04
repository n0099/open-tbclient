package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
/* loaded from: classes12.dex */
public class e {
    private static final SparseIntArray myY = new SparseIntArray(0);

    private static int dAP() {
        int min = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        return min > 16777216 ? (min / 4) * 3 : min / 2;
    }

    public static r dAV() {
        return new r(0, dAP(), myY);
    }
}
