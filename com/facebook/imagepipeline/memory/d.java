package com.facebook.imagepipeline.memory;

import java.util.LinkedList;
import java.util.Queue;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes12.dex */
class d<V> {
    public final int jQp;
    public final int mItemSize;
    final Queue mVc;
    private final boolean mVd;
    private int mVe;

    public d(int i, int i2, int i3, boolean z) {
        com.facebook.common.internal.g.checkState(i > 0);
        com.facebook.common.internal.g.checkState(i2 >= 0);
        com.facebook.common.internal.g.checkState(i3 >= 0);
        this.mItemSize = i;
        this.jQp = i2;
        this.mVc = new LinkedList();
        this.mVe = i3;
        this.mVd = z;
    }

    public boolean dFt() {
        return this.mVe + dFu() > this.jQp;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int dFu() {
        return this.mVc.size();
    }

    @Nullable
    public V get() {
        V pop = pop();
        if (pop != null) {
            this.mVe++;
        }
        return pop;
    }

    @Nullable
    public V pop() {
        return (V) this.mVc.poll();
    }

    public void dFv() {
        this.mVe++;
    }

    public void release(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        if (this.mVd) {
            com.facebook.common.internal.g.checkState(this.mVe > 0);
            this.mVe--;
            bo(v);
        } else if (this.mVe > 0) {
            this.mVe--;
            bo(v);
        } else {
            com.facebook.common.c.a.h("BUCKET", "Tried to release value %s from an empty bucket!", v);
        }
    }

    void bo(V v) {
        this.mVc.add(v);
    }

    public void dFw() {
        com.facebook.common.internal.g.checkState(this.mVe > 0);
        this.mVe--;
    }

    public int dCy() {
        return this.mVe;
    }
}
