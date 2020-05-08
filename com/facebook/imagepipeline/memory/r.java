package com.facebook.imagepipeline.memory;

import android.support.v7.widget.ActivityChooserView;
import android.util.SparseIntArray;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class r {
    public final int meq;
    public final int mer;
    public final SparseIntArray mes;
    public final int met;
    public final int meu;
    public boolean mev;
    public final int mew;

    public r(int i, int i2, @Nullable SparseIntArray sparseIntArray) {
        this(i, i2, sparseIntArray, 0, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, -1);
    }

    public r(int i, int i2, @Nullable SparseIntArray sparseIntArray, int i3, int i4, int i5) {
        com.facebook.common.internal.g.checkState(i >= 0 && i2 >= i);
        this.mer = i;
        this.meq = i2;
        this.mes = sparseIntArray;
        this.met = i3;
        this.meu = i4;
        this.mew = i5;
    }
}
