package com.facebook.imagepipeline.memory;

import java.util.LinkedList;
import java.util.Queue;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes2.dex */
class d<V> {
    public final int aVa;
    final Queue jIW;
    private int jIX;
    public final int mItemSize;

    public d(int i, int i2, int i3) {
        com.facebook.common.internal.g.checkState(i > 0);
        com.facebook.common.internal.g.checkState(i2 >= 0);
        com.facebook.common.internal.g.checkState(i3 >= 0);
        this.mItemSize = i;
        this.aVa = i2;
        this.jIW = new LinkedList();
        this.jIX = i3;
    }

    public boolean cyQ() {
        return this.jIX + cyR() > this.aVa;
    }

    int cyR() {
        return this.jIW.size();
    }

    @Nullable
    public V get() {
        V pop = pop();
        if (pop != null) {
            this.jIX++;
        }
        return pop;
    }

    @Nullable
    public V pop() {
        return (V) this.jIW.poll();
    }

    public void cyS() {
        this.jIX++;
    }

    public void release(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        com.facebook.common.internal.g.checkState(this.jIX > 0);
        this.jIX--;
        ba(v);
    }

    void ba(V v) {
        this.jIW.add(v);
    }

    public void cyT() {
        com.facebook.common.internal.g.checkState(this.jIX > 0);
        this.jIX--;
    }
}
