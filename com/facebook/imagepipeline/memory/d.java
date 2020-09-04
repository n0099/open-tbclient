package com.facebook.imagepipeline.memory;

import java.util.LinkedList;
import java.util.Queue;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes8.dex */
class d<V> {
    public final int kos;
    public final int mItemSize;
    final Queue nxq;
    private final boolean nxr;
    private int nxs;

    public d(int i, int i2, int i3, boolean z) {
        com.facebook.common.internal.g.checkState(i > 0);
        com.facebook.common.internal.g.checkState(i2 >= 0);
        com.facebook.common.internal.g.checkState(i3 >= 0);
        this.mItemSize = i;
        this.kos = i2;
        this.nxq = new LinkedList();
        this.nxs = i3;
        this.nxr = z;
    }

    public boolean dUS() {
        return this.nxs + dUT() > this.kos;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int dUT() {
        return this.nxq.size();
    }

    @Nullable
    public V get() {
        V pop = pop();
        if (pop != null) {
            this.nxs++;
        }
        return pop;
    }

    @Nullable
    public V pop() {
        return (V) this.nxq.poll();
    }

    public void dUU() {
        this.nxs++;
    }

    public void release(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        if (this.nxr) {
            com.facebook.common.internal.g.checkState(this.nxs > 0);
            this.nxs--;
            bq(v);
        } else if (this.nxs > 0) {
            this.nxs--;
            bq(v);
        } else {
            com.facebook.common.c.a.g("BUCKET", "Tried to release value %s from an empty bucket!", v);
        }
    }

    void bq(V v) {
        this.nxq.add(v);
    }

    public void dUV() {
        com.facebook.common.internal.g.checkState(this.nxs > 0);
        this.nxs--;
    }

    public int dRX() {
        return this.nxs;
    }
}
