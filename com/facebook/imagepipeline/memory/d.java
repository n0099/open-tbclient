package com.facebook.imagepipeline.memory;

import java.util.LinkedList;
import java.util.Queue;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes5.dex */
class d<V> {
    public final int lAX;
    public final int mItemSize;
    final Queue pKB;
    private final boolean pKC;
    private int pKD;

    public d(int i, int i2, int i3, boolean z) {
        com.facebook.common.internal.g.checkState(i > 0);
        com.facebook.common.internal.g.checkState(i2 >= 0);
        com.facebook.common.internal.g.checkState(i3 >= 0);
        this.mItemSize = i;
        this.lAX = i2;
        this.pKB = new LinkedList();
        this.pKD = i3;
        this.pKC = z;
    }

    public boolean eyC() {
        return this.pKD + eyD() > this.lAX;
    }

    int eyD() {
        return this.pKB.size();
    }

    @Nullable
    public V get() {
        V pop = pop();
        if (pop != null) {
            this.pKD++;
        }
        return pop;
    }

    @Nullable
    public V pop() {
        return (V) this.pKB.poll();
    }

    public void eyE() {
        this.pKD++;
    }

    public void release(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        if (this.pKC) {
            com.facebook.common.internal.g.checkState(this.pKD > 0);
            this.pKD--;
            bz(v);
        } else if (this.pKD > 0) {
            this.pKD--;
            bz(v);
        } else {
            com.facebook.common.c.a.e("BUCKET", "Tried to release value %s from an empty bucket!", v);
        }
    }

    void bz(V v) {
        this.pKB.add(v);
    }

    public void eyF() {
        com.facebook.common.internal.g.checkState(this.pKD > 0);
        this.pKD--;
    }
}
