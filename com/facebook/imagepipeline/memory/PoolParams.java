package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
import com.facebook.common.internal.Preconditions;
import javax.annotation.Nullable;
/* loaded from: classes6.dex */
public class PoolParams {
    public static final int IGNORE_THREADS = -1;
    public String bitmapPoolType;
    public final SparseIntArray bucketSizes;
    public boolean fixBucketsReinitialization;
    public final int maxBucketSize;
    public final int maxNumThreads;
    public final int maxSizeHardCap;
    public final int maxSizeSoftCap;
    public final int minBucketSize;

    public PoolParams(int i2, @Nullable SparseIntArray sparseIntArray) {
        this(i2, i2, sparseIntArray, 0, Integer.MAX_VALUE, -1);
    }

    public PoolParams(int i2, int i3, @Nullable SparseIntArray sparseIntArray) {
        this(i2, i3, sparseIntArray, 0, Integer.MAX_VALUE, -1);
    }

    public PoolParams(int i2, int i3, @Nullable SparseIntArray sparseIntArray, int i4, int i5, int i6) {
        Preconditions.checkState(i2 >= 0 && i3 >= i2);
        this.maxSizeSoftCap = i2;
        this.maxSizeHardCap = i3;
        this.bucketSizes = sparseIntArray;
        this.minBucketSize = i4;
        this.maxBucketSize = i5;
        this.maxNumThreads = i6;
    }
}
