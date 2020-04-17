package com.facebook.imagepipeline.memory;

import android.support.v7.widget.ActivityChooserView;
import android.util.SparseIntArray;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class r {
    public final int mem;
    public final int men;
    public final SparseIntArray meo;
    public final int mep;
    public final int meq;
    public boolean mer;
    public final int mes;

    public r(int i, int i2, @Nullable SparseIntArray sparseIntArray) {
        this(i, i2, sparseIntArray, 0, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, -1);
    }

    public r(int i, int i2, @Nullable SparseIntArray sparseIntArray, int i3, int i4, int i5) {
        com.facebook.common.internal.g.checkState(i >= 0 && i2 >= i);
        this.men = i;
        this.mem = i2;
        this.meo = sparseIntArray;
        this.mep = i3;
        this.meq = i4;
        this.mes = i5;
    }
}
