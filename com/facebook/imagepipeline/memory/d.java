package com.facebook.imagepipeline.memory;

import java.util.LinkedList;
import java.util.Queue;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes8.dex */
class d<V> {
    public final int kol;
    public final int mItemSize;
    final Queue nwY;
    private final boolean nwZ;
    private int nxa;

    public d(int i, int i2, int i3, boolean z) {
        com.facebook.common.internal.g.checkState(i > 0);
        com.facebook.common.internal.g.checkState(i2 >= 0);
        com.facebook.common.internal.g.checkState(i3 >= 0);
        this.mItemSize = i;
        this.kol = i2;
        this.nwY = new LinkedList();
        this.nxa = i3;
        this.nwZ = z;
    }

    public boolean dUJ() {
        return this.nxa + dUK() > this.kol;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int dUK() {
        return this.nwY.size();
    }

    @Nullable
    public V get() {
        V pop = pop();
        if (pop != null) {
            this.nxa++;
        }
        return pop;
    }

    @Nullable
    public V pop() {
        return (V) this.nwY.poll();
    }

    public void dUL() {
        this.nxa++;
    }

    public void release(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        if (this.nwZ) {
            com.facebook.common.internal.g.checkState(this.nxa > 0);
            this.nxa--;
            bq(v);
        } else if (this.nxa > 0) {
            this.nxa--;
            bq(v);
        } else {
            com.facebook.common.c.a.g("BUCKET", "Tried to release value %s from an empty bucket!", v);
        }
    }

    void bq(V v) {
        this.nwY.add(v);
    }

    public void dUM() {
        com.facebook.common.internal.g.checkState(this.nxa > 0);
        this.nxa--;
    }

    public int dRO() {
        return this.nxa;
    }
}
