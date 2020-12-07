package com.facebook.imagepipeline.memory;

import java.util.LinkedList;
import java.util.Queue;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes15.dex */
class d<V> {
    public final int lso;
    public final int mItemSize;
    final Queue pnH;
    private final boolean pnI;
    private int pnJ;

    public d(int i, int i2, int i3, boolean z) {
        com.facebook.common.internal.g.checkState(i > 0);
        com.facebook.common.internal.g.checkState(i2 >= 0);
        com.facebook.common.internal.g.checkState(i3 >= 0);
        this.mItemSize = i;
        this.lso = i2;
        this.pnH = new LinkedList();
        this.pnJ = i3;
        this.pnI = z;
    }

    public boolean evQ() {
        return this.pnJ + evR() > this.lso;
    }

    int evR() {
        return this.pnH.size();
    }

    @Nullable
    public V get() {
        V pop = pop();
        if (pop != null) {
            this.pnJ++;
        }
        return pop;
    }

    @Nullable
    public V pop() {
        return (V) this.pnH.poll();
    }

    public void evS() {
        this.pnJ++;
    }

    public void release(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        if (this.pnI) {
            com.facebook.common.internal.g.checkState(this.pnJ > 0);
            this.pnJ--;
            bz(v);
        } else if (this.pnJ > 0) {
            this.pnJ--;
            bz(v);
        } else {
            com.facebook.common.c.a.g("BUCKET", "Tried to release value %s from an empty bucket!", v);
        }
    }

    void bz(V v) {
        this.pnH.add(v);
    }

    public void evT() {
        com.facebook.common.internal.g.checkState(this.pnJ > 0);
        this.pnJ--;
    }
}
