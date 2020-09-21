package com.facebook.imagepipeline.memory;

import java.util.LinkedList;
import java.util.Queue;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes25.dex */
class d<V> {
    public final int kwR;
    public final int mItemSize;
    final Queue nHn;
    private final boolean nHo;
    private int nHp;

    public d(int i, int i2, int i3, boolean z) {
        com.facebook.common.internal.g.checkState(i > 0);
        com.facebook.common.internal.g.checkState(i2 >= 0);
        com.facebook.common.internal.g.checkState(i3 >= 0);
        this.mItemSize = i;
        this.kwR = i2;
        this.nHn = new LinkedList();
        this.nHp = i3;
        this.nHo = z;
    }

    public boolean dYQ() {
        return this.nHp + dYR() > this.kwR;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int dYR() {
        return this.nHn.size();
    }

    @Nullable
    public V get() {
        V pop = pop();
        if (pop != null) {
            this.nHp++;
        }
        return pop;
    }

    @Nullable
    public V pop() {
        return (V) this.nHn.poll();
    }

    public void dYS() {
        this.nHp++;
    }

    public void release(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        if (this.nHo) {
            com.facebook.common.internal.g.checkState(this.nHp > 0);
            this.nHp--;
            bs(v);
        } else if (this.nHp > 0) {
            this.nHp--;
            bs(v);
        } else {
            com.facebook.common.c.a.g("BUCKET", "Tried to release value %s from an empty bucket!", v);
        }
    }

    void bs(V v) {
        this.nHn.add(v);
    }

    public void dYT() {
        com.facebook.common.internal.g.checkState(this.nHp > 0);
        this.nHp--;
    }

    public int dVV() {
        return this.nHp;
    }
}
