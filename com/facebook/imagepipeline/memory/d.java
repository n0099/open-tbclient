package com.facebook.imagepipeline.memory;

import java.util.LinkedList;
import java.util.Queue;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes5.dex */
class d<V> {
    public final int lBl;
    public final int mItemSize;
    final Queue pLb;
    private final boolean pLc;
    private int pLd;

    public d(int i, int i2, int i3, boolean z) {
        com.facebook.common.internal.g.checkState(i > 0);
        com.facebook.common.internal.g.checkState(i2 >= 0);
        com.facebook.common.internal.g.checkState(i3 >= 0);
        this.mItemSize = i;
        this.lBl = i2;
        this.pLb = new LinkedList();
        this.pLd = i3;
        this.pLc = z;
    }

    public boolean eyK() {
        return this.pLd + eyL() > this.lBl;
    }

    int eyL() {
        return this.pLb.size();
    }

    @Nullable
    public V get() {
        V pop = pop();
        if (pop != null) {
            this.pLd++;
        }
        return pop;
    }

    @Nullable
    public V pop() {
        return (V) this.pLb.poll();
    }

    public void eyM() {
        this.pLd++;
    }

    public void release(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        if (this.pLc) {
            com.facebook.common.internal.g.checkState(this.pLd > 0);
            this.pLd--;
            bz(v);
        } else if (this.pLd > 0) {
            this.pLd--;
            bz(v);
        } else {
            com.facebook.common.c.a.e("BUCKET", "Tried to release value %s from an empty bucket!", v);
        }
    }

    void bz(V v) {
        this.pLb.add(v);
    }

    public void eyN() {
        com.facebook.common.internal.g.checkState(this.pLd > 0);
        this.pLd--;
    }
}
