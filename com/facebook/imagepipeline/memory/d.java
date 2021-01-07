package com.facebook.imagepipeline.memory;

import java.util.LinkedList;
import java.util.Queue;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes3.dex */
class d<V> {
    public final int lxy;
    public final int mItemSize;
    final Queue pET;
    private final boolean pEU;
    private int pEV;

    public d(int i, int i2, int i3, boolean z) {
        com.facebook.common.internal.g.checkState(i > 0);
        com.facebook.common.internal.g.checkState(i2 >= 0);
        com.facebook.common.internal.g.checkState(i3 >= 0);
        this.mItemSize = i;
        this.lxy = i2;
        this.pET = new LinkedList();
        this.pEV = i3;
        this.pEU = z;
    }

    public boolean eAc() {
        return this.pEV + eAd() > this.lxy;
    }

    int eAd() {
        return this.pET.size();
    }

    @Nullable
    public V get() {
        V pop = pop();
        if (pop != null) {
            this.pEV++;
        }
        return pop;
    }

    @Nullable
    public V pop() {
        return (V) this.pET.poll();
    }

    public void eAe() {
        this.pEV++;
    }

    public void release(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        if (this.pEU) {
            com.facebook.common.internal.g.checkState(this.pEV > 0);
            this.pEV--;
            bz(v);
        } else if (this.pEV > 0) {
            this.pEV--;
            bz(v);
        } else {
            com.facebook.common.c.a.e("BUCKET", "Tried to release value %s from an empty bucket!", v);
        }
    }

    void bz(V v) {
        this.pET.add(v);
    }

    public void eAf() {
        com.facebook.common.internal.g.checkState(this.pEV > 0);
        this.pEV--;
    }
}
