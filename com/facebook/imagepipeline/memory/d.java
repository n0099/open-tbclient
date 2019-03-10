package com.facebook.imagepipeline.memory;

import java.util.LinkedList;
import java.util.Queue;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes2.dex */
class d<V> {
    public final int aVa;
    final Queue jJp;
    private int jJq;
    public final int mItemSize;

    public d(int i, int i2, int i3) {
        com.facebook.common.internal.g.checkState(i > 0);
        com.facebook.common.internal.g.checkState(i2 >= 0);
        com.facebook.common.internal.g.checkState(i3 >= 0);
        this.mItemSize = i;
        this.aVa = i2;
        this.jJp = new LinkedList();
        this.jJq = i3;
    }

    public boolean cza() {
        return this.jJq + czb() > this.aVa;
    }

    int czb() {
        return this.jJp.size();
    }

    @Nullable
    public V get() {
        V pop = pop();
        if (pop != null) {
            this.jJq++;
        }
        return pop;
    }

    @Nullable
    public V pop() {
        return (V) this.jJp.poll();
    }

    public void czc() {
        this.jJq++;
    }

    public void release(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        com.facebook.common.internal.g.checkState(this.jJq > 0);
        this.jJq--;
        bb(v);
    }

    void bb(V v) {
        this.jJp.add(v);
    }

    public void czd() {
        com.facebook.common.internal.g.checkState(this.jJq > 0);
        this.jJq--;
    }
}
