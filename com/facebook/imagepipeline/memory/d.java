package com.facebook.imagepipeline.memory;

import java.util.LinkedList;
import java.util.Queue;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes4.dex */
class d<V> {
    public final int jYN;
    public final int mItemSize;
    final Queue ndg;
    private final boolean ndh;
    private int ndi;

    public d(int i, int i2, int i3, boolean z) {
        com.facebook.common.internal.g.checkState(i > 0);
        com.facebook.common.internal.g.checkState(i2 >= 0);
        com.facebook.common.internal.g.checkState(i3 >= 0);
        this.mItemSize = i;
        this.jYN = i2;
        this.ndg = new LinkedList();
        this.ndi = i3;
        this.ndh = z;
    }

    public boolean dIJ() {
        return this.ndi + dIK() > this.jYN;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int dIK() {
        return this.ndg.size();
    }

    @Nullable
    public V get() {
        V pop = pop();
        if (pop != null) {
            this.ndi++;
        }
        return pop;
    }

    @Nullable
    public V pop() {
        return (V) this.ndg.poll();
    }

    public void dIL() {
        this.ndi++;
    }

    public void release(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        if (this.ndh) {
            com.facebook.common.internal.g.checkState(this.ndi > 0);
            this.ndi--;
            bo(v);
        } else if (this.ndi > 0) {
            this.ndi--;
            bo(v);
        } else {
            com.facebook.common.c.a.h("BUCKET", "Tried to release value %s from an empty bucket!", v);
        }
    }

    void bo(V v) {
        this.ndg.add(v);
    }

    public void dIM() {
        com.facebook.common.internal.g.checkState(this.ndi > 0);
        this.ndi--;
    }

    public int dFO() {
        return this.ndi;
    }
}
