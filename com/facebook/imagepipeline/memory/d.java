package com.facebook.imagepipeline.memory;

import java.util.LinkedList;
import java.util.Queue;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes12.dex */
class d<V> {
    public final int iwF;
    final Queue lWf;
    private final boolean lWg;
    private int lWh;
    public final int mItemSize;

    public d(int i, int i2, int i3, boolean z) {
        com.facebook.common.internal.g.checkState(i > 0);
        com.facebook.common.internal.g.checkState(i2 >= 0);
        com.facebook.common.internal.g.checkState(i3 >= 0);
        this.mItemSize = i;
        this.iwF = i2;
        this.lWf = new LinkedList();
        this.lWh = i3;
        this.lWg = z;
    }

    public boolean drq() {
        return this.lWh + drr() > this.iwF;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int drr() {
        return this.lWf.size();
    }

    @Nullable
    public V get() {
        V pop = pop();
        if (pop != null) {
            this.lWh++;
        }
        return pop;
    }

    @Nullable
    public V pop() {
        return (V) this.lWf.poll();
    }

    public void drs() {
        this.lWh++;
    }

    public void release(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        if (this.lWg) {
            com.facebook.common.internal.g.checkState(this.lWh > 0);
            this.lWh--;
            bs(v);
        } else if (this.lWh > 0) {
            this.lWh--;
            bs(v);
        } else {
            com.facebook.common.c.a.h("BUCKET", "Tried to release value %s from an empty bucket!", v);
        }
    }

    void bs(V v) {
        this.lWf.add(v);
    }

    public void drt() {
        com.facebook.common.internal.g.checkState(this.lWh > 0);
        this.lWh--;
    }

    public int dov() {
        return this.lWh;
    }
}
