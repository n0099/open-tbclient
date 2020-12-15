package com.facebook.imagepipeline.memory;

import java.util.LinkedList;
import java.util.Queue;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes15.dex */
class d<V> {
    public final int lsq;
    public final int mItemSize;
    final Queue pnJ;
    private final boolean pnK;
    private int pnL;

    public d(int i, int i2, int i3, boolean z) {
        com.facebook.common.internal.g.checkState(i > 0);
        com.facebook.common.internal.g.checkState(i2 >= 0);
        com.facebook.common.internal.g.checkState(i3 >= 0);
        this.mItemSize = i;
        this.lsq = i2;
        this.pnJ = new LinkedList();
        this.pnL = i3;
        this.pnK = z;
    }

    public boolean evR() {
        return this.pnL + evS() > this.lsq;
    }

    int evS() {
        return this.pnJ.size();
    }

    @Nullable
    public V get() {
        V pop = pop();
        if (pop != null) {
            this.pnL++;
        }
        return pop;
    }

    @Nullable
    public V pop() {
        return (V) this.pnJ.poll();
    }

    public void evT() {
        this.pnL++;
    }

    public void release(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        if (this.pnK) {
            com.facebook.common.internal.g.checkState(this.pnL > 0);
            this.pnL--;
            bz(v);
        } else if (this.pnL > 0) {
            this.pnL--;
            bz(v);
        } else {
            com.facebook.common.c.a.g("BUCKET", "Tried to release value %s from an empty bucket!", v);
        }
    }

    void bz(V v) {
        this.pnJ.add(v);
    }

    public void evU() {
        com.facebook.common.internal.g.checkState(this.pnL > 0);
        this.pnL--;
    }
}
