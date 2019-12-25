package com.facebook.imagepipeline.memory;

import java.util.LinkedList;
import java.util.Queue;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes9.dex */
class d<V> {
    public final int ips;
    final Queue lPO;
    private final boolean lPP;
    private int lPQ;
    public final int mItemSize;

    public d(int i, int i2, int i3, boolean z) {
        com.facebook.common.internal.g.checkState(i > 0);
        com.facebook.common.internal.g.checkState(i2 >= 0);
        com.facebook.common.internal.g.checkState(i3 >= 0);
        this.mItemSize = i;
        this.ips = i2;
        this.lPO = new LinkedList();
        this.lPQ = i3;
        this.lPP = z;
    }

    public boolean dot() {
        return this.lPQ + dou() > this.ips;
    }

    int dou() {
        return this.lPO.size();
    }

    @Nullable
    public V get() {
        V pop = pop();
        if (pop != null) {
            this.lPQ++;
        }
        return pop;
    }

    @Nullable
    public V pop() {
        return (V) this.lPO.poll();
    }

    public void dov() {
        this.lPQ++;
    }

    public void release(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        if (this.lPP) {
            com.facebook.common.internal.g.checkState(this.lPQ > 0);
            this.lPQ--;
            bp(v);
        } else if (this.lPQ > 0) {
            this.lPQ--;
            bp(v);
        } else {
            com.facebook.common.c.a.h("BUCKET", "Tried to release value %s from an empty bucket!", v);
        }
    }

    void bp(V v) {
        this.lPO.add(v);
    }

    public void dow() {
        com.facebook.common.internal.g.checkState(this.lPQ > 0);
        this.lPQ--;
    }
}
