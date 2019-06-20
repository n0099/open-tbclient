package com.facebook.imagepipeline.memory;

import java.util.LinkedList;
import java.util.Queue;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes2.dex */
class d<V> {
    public final int aYf;
    final Queue kbt;
    private int kbu;
    public final int mItemSize;

    public d(int i, int i2, int i3) {
        com.facebook.common.internal.g.checkState(i > 0);
        com.facebook.common.internal.g.checkState(i2 >= 0);
        com.facebook.common.internal.g.checkState(i3 >= 0);
        this.mItemSize = i;
        this.aYf = i2;
        this.kbt = new LinkedList();
        this.kbu = i3;
    }

    public boolean cGT() {
        return this.kbu + cGU() > this.aYf;
    }

    int cGU() {
        return this.kbt.size();
    }

    @Nullable
    public V get() {
        V pop = pop();
        if (pop != null) {
            this.kbu++;
        }
        return pop;
    }

    @Nullable
    public V pop() {
        return (V) this.kbt.poll();
    }

    public void cGV() {
        this.kbu++;
    }

    public void release(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        com.facebook.common.internal.g.checkState(this.kbu > 0);
        this.kbu--;
        aZ(v);
    }

    void aZ(V v) {
        this.kbt.add(v);
    }

    public void cGW() {
        com.facebook.common.internal.g.checkState(this.kbu > 0);
        this.kbu--;
    }
}
