package com.facebook.imagepipeline.memory;

import java.util.LinkedList;
import java.util.Queue;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes5.dex */
class d<V> {
    public final int lDn;
    public final int mItemSize;
    final Queue pNg;
    private final boolean pNh;
    private int pNi;

    public d(int i, int i2, int i3, boolean z) {
        com.facebook.common.internal.g.checkState(i > 0);
        com.facebook.common.internal.g.checkState(i2 >= 0);
        com.facebook.common.internal.g.checkState(i3 >= 0);
        this.mItemSize = i;
        this.lDn = i2;
        this.pNg = new LinkedList();
        this.pNi = i3;
        this.pNh = z;
    }

    public boolean eyT() {
        return this.pNi + eyU() > this.lDn;
    }

    int eyU() {
        return this.pNg.size();
    }

    @Nullable
    public V get() {
        V pop = pop();
        if (pop != null) {
            this.pNi++;
        }
        return pop;
    }

    @Nullable
    public V pop() {
        return (V) this.pNg.poll();
    }

    public void eyV() {
        this.pNi++;
    }

    public void release(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        if (this.pNh) {
            com.facebook.common.internal.g.checkState(this.pNi > 0);
            this.pNi--;
            bB(v);
        } else if (this.pNi > 0) {
            this.pNi--;
            bB(v);
        } else {
            com.facebook.common.c.a.e("BUCKET", "Tried to release value %s from an empty bucket!", v);
        }
    }

    void bB(V v) {
        this.pNg.add(v);
    }

    public void eyW() {
        com.facebook.common.internal.g.checkState(this.pNi > 0);
        this.pNi--;
    }
}
