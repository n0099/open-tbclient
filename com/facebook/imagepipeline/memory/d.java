package com.facebook.imagepipeline.memory;

import java.util.LinkedList;
import java.util.Queue;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes2.dex */
class d<V> {
    public final int aYf;
    final Queue kbp;
    private int kbq;
    public final int mItemSize;

    public d(int i, int i2, int i3) {
        com.facebook.common.internal.g.checkState(i > 0);
        com.facebook.common.internal.g.checkState(i2 >= 0);
        com.facebook.common.internal.g.checkState(i3 >= 0);
        this.mItemSize = i;
        this.aYf = i2;
        this.kbp = new LinkedList();
        this.kbq = i3;
    }

    public boolean cGS() {
        return this.kbq + cGT() > this.aYf;
    }

    int cGT() {
        return this.kbp.size();
    }

    @Nullable
    public V get() {
        V pop = pop();
        if (pop != null) {
            this.kbq++;
        }
        return pop;
    }

    @Nullable
    public V pop() {
        return (V) this.kbp.poll();
    }

    public void cGU() {
        this.kbq++;
    }

    public void release(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        com.facebook.common.internal.g.checkState(this.kbq > 0);
        this.kbq--;
        aZ(v);
    }

    void aZ(V v) {
        this.kbp.add(v);
    }

    public void cGV() {
        com.facebook.common.internal.g.checkState(this.kbq > 0);
        this.kbq--;
    }
}
