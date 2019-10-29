package com.facebook.imagepipeline.memory;

import java.util.LinkedList;
import java.util.Queue;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes2.dex */
class d<V> {
    public final int bso;
    final Queue kkp;
    private int kkq;
    public final int mItemSize;

    public d(int i, int i2, int i3) {
        com.facebook.common.internal.g.checkState(i > 0);
        com.facebook.common.internal.g.checkState(i2 >= 0);
        com.facebook.common.internal.g.checkState(i3 >= 0);
        this.mItemSize = i;
        this.bso = i2;
        this.kkp = new LinkedList();
        this.kkq = i3;
    }

    public boolean cId() {
        return this.kkq + cIe() > this.bso;
    }

    int cIe() {
        return this.kkp.size();
    }

    @Nullable
    public V get() {
        V pop = pop();
        if (pop != null) {
            this.kkq++;
        }
        return pop;
    }

    @Nullable
    public V pop() {
        return (V) this.kkp.poll();
    }

    public void cIf() {
        this.kkq++;
    }

    public void release(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        com.facebook.common.internal.g.checkState(this.kkq > 0);
        this.kkq--;
        aU(v);
    }

    void aU(V v) {
        this.kkp.add(v);
    }

    public void cIg() {
        com.facebook.common.internal.g.checkState(this.kkq > 0);
        this.kkq--;
    }
}
