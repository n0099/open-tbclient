package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
/* loaded from: classes6.dex */
public class DefaultFlexByteArrayPoolParams {
    public static final int DEFAULT_MAX_BYTE_ARRAY_SIZE = 4194304;
    public static final int DEFAULT_MAX_NUM_THREADS = Runtime.getRuntime().availableProcessors();
    public static final int DEFAULT_MIN_BYTE_ARRAY_SIZE = 131072;

    public static SparseIntArray generateBuckets(int i2, int i3, int i4) {
        SparseIntArray sparseIntArray = new SparseIntArray();
        while (i2 <= i3) {
            sparseIntArray.put(i2, i4);
            i2 *= 2;
        }
        return sparseIntArray;
    }

    public static PoolParams get() {
        int i2 = DEFAULT_MAX_NUM_THREADS;
        return new PoolParams(4194304, i2 * 4194304, generateBuckets(131072, 4194304, i2), 131072, 4194304, DEFAULT_MAX_NUM_THREADS);
    }
}
