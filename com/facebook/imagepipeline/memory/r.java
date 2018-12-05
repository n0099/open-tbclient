package com.facebook.imagepipeline.memory;

import android.support.v7.widget.ActivityChooserView;
import android.util.SparseIntArray;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class r {
    public final int ipr;
    public final int ips;
    public final SparseIntArray ipt;
    public final int ipu;
    public final int ipv;
    public final int ipw;

    public r(int i, int i2, @Nullable SparseIntArray sparseIntArray) {
        this(i, i2, sparseIntArray, 0, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, -1);
    }

    public r(int i, int i2, @Nullable SparseIntArray sparseIntArray, int i3, int i4, int i5) {
        com.facebook.common.internal.g.checkState(i >= 0 && i2 >= i);
        this.ips = i;
        this.ipr = i2;
        this.ipt = sparseIntArray;
        this.ipu = i3;
        this.ipv = i4;
        this.ipw = i5;
    }
}
