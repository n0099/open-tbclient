package com.facebook.imagepipeline.memory;

import java.util.LinkedList;
import java.util.Queue;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes5.dex */
class d<V> {
    public final int lxy;
    public final int mItemSize;
    final Queue pDm;
    private final boolean pDn;
    private int pDo;

    public d(int i, int i2, int i3, boolean z) {
        com.facebook.common.internal.g.checkState(i > 0);
        com.facebook.common.internal.g.checkState(i2 >= 0);
        com.facebook.common.internal.g.checkState(i3 >= 0);
        this.mItemSize = i;
        this.lxy = i2;
        this.pDm = new LinkedList();
        this.pDo = i3;
        this.pDn = z;
    }

    public boolean ezy() {
        return this.pDo + ezz() > this.lxy;
    }

    int ezz() {
        return this.pDm.size();
    }

    @Nullable
    public V get() {
        V pop = pop();
        if (pop != null) {
            this.pDo++;
        }
        return pop;
    }

    @Nullable
    public V pop() {
        return (V) this.pDm.poll();
    }

    public void ezA() {
        this.pDo++;
    }

    public void release(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        if (this.pDn) {
            com.facebook.common.internal.g.checkState(this.pDo > 0);
            this.pDo--;
            by(v);
        } else if (this.pDo > 0) {
            this.pDo--;
            by(v);
        } else {
            com.facebook.common.c.a.e("BUCKET", "Tried to release value %s from an empty bucket!", v);
        }
    }

    void by(V v) {
        this.pDm.add(v);
    }

    public void ezB() {
        com.facebook.common.internal.g.checkState(this.pDo > 0);
        this.pDo--;
    }
}
