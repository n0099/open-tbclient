package com.facebook.imagepipeline.memory;

import java.util.LinkedList;
import java.util.Queue;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes2.dex */
class d<V> {
    public final int aYf;
    final Queue kbq;
    private int kbr;
    public final int mItemSize;

    public d(int i, int i2, int i3) {
        com.facebook.common.internal.g.checkState(i > 0);
        com.facebook.common.internal.g.checkState(i2 >= 0);
        com.facebook.common.internal.g.checkState(i3 >= 0);
        this.mItemSize = i;
        this.aYf = i2;
        this.kbq = new LinkedList();
        this.kbr = i3;
    }

    public boolean cGU() {
        return this.kbr + cGV() > this.aYf;
    }

    int cGV() {
        return this.kbq.size();
    }

    @Nullable
    public V get() {
        V pop = pop();
        if (pop != null) {
            this.kbr++;
        }
        return pop;
    }

    @Nullable
    public V pop() {
        return (V) this.kbq.poll();
    }

    public void cGW() {
        this.kbr++;
    }

    public void release(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        com.facebook.common.internal.g.checkState(this.kbr > 0);
        this.kbr--;
        aZ(v);
    }

    void aZ(V v) {
        this.kbq.add(v);
    }

    public void cGX() {
        com.facebook.common.internal.g.checkState(this.kbr > 0);
        this.kbr--;
    }
}
