package com.facebook.imagepipeline.memory;

import java.util.LinkedList;
import java.util.Queue;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes12.dex */
class d<V> {
    public final int jvR;
    public final int mItemSize;
    final Queue mxL;
    private final boolean mxM;
    private int mxN;

    public d(int i, int i2, int i3, boolean z) {
        com.facebook.common.internal.g.checkState(i > 0);
        com.facebook.common.internal.g.checkState(i2 >= 0);
        com.facebook.common.internal.g.checkState(i3 >= 0);
        this.mItemSize = i;
        this.jvR = i2;
        this.mxL = new LinkedList();
        this.mxN = i3;
        this.mxM = z;
    }

    public boolean dAD() {
        return this.mxN + dAE() > this.jvR;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int dAE() {
        return this.mxL.size();
    }

    @Nullable
    public V get() {
        V pop = pop();
        if (pop != null) {
            this.mxN++;
        }
        return pop;
    }

    @Nullable
    public V pop() {
        return (V) this.mxL.poll();
    }

    public void dAF() {
        this.mxN++;
    }

    public void release(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        if (this.mxM) {
            com.facebook.common.internal.g.checkState(this.mxN > 0);
            this.mxN--;
            bn(v);
        } else if (this.mxN > 0) {
            this.mxN--;
            bn(v);
        } else {
            com.facebook.common.c.a.h("BUCKET", "Tried to release value %s from an empty bucket!", v);
        }
    }

    void bn(V v) {
        this.mxL.add(v);
    }

    public void dAG() {
        com.facebook.common.internal.g.checkState(this.mxN > 0);
        this.mxN--;
    }

    public int dxI() {
        return this.mxN;
    }
}
