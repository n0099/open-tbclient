package com.facebook.imagepipeline.memory;

import java.util.LinkedList;
import java.util.Queue;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes2.dex */
class d<V> {
    public final int aVb;
    final Queue jJh;
    private int jJi;
    public final int mItemSize;

    public d(int i, int i2, int i3) {
        com.facebook.common.internal.g.checkState(i > 0);
        com.facebook.common.internal.g.checkState(i2 >= 0);
        com.facebook.common.internal.g.checkState(i3 >= 0);
        this.mItemSize = i;
        this.aVb = i2;
        this.jJh = new LinkedList();
        this.jJi = i3;
    }

    public boolean czd() {
        return this.jJi + cze() > this.aVb;
    }

    int cze() {
        return this.jJh.size();
    }

    @Nullable
    public V get() {
        V pop = pop();
        if (pop != null) {
            this.jJi++;
        }
        return pop;
    }

    @Nullable
    public V pop() {
        return (V) this.jJh.poll();
    }

    public void czf() {
        this.jJi++;
    }

    public void release(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        com.facebook.common.internal.g.checkState(this.jJi > 0);
        this.jJi--;
        bb(v);
    }

    void bb(V v) {
        this.jJh.add(v);
    }

    public void czg() {
        com.facebook.common.internal.g.checkState(this.jJi > 0);
        this.jJi--;
    }
}
