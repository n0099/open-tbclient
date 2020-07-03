package com.facebook.imagepipeline.memory;

import android.support.v7.widget.ActivityChooserView;
import android.util.SparseIntArray;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class r {
    public final SparseIntArray mVA;
    public final int mVB;
    public final int mVC;
    public boolean mVD;
    public final int mVE;
    public final int mVy;
    public final int mVz;

    public r(int i, int i2, @Nullable SparseIntArray sparseIntArray) {
        this(i, i2, sparseIntArray, 0, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, -1);
    }

    public r(int i, int i2, @Nullable SparseIntArray sparseIntArray, int i3, int i4, int i5) {
        com.facebook.common.internal.g.checkState(i >= 0 && i2 >= i);
        this.mVz = i;
        this.mVy = i2;
        this.mVA = sparseIntArray;
        this.mVB = i3;
        this.mVC = i4;
        this.mVE = i5;
    }
}
