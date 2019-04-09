package com.facebook.imagepipeline.memory;

import java.util.LinkedList;
import java.util.Queue;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes2.dex */
class d<V> {
    public final int aVf;
    final Queue jIC;
    private int jID;
    public final int mItemSize;

    public d(int i, int i2, int i3) {
        com.facebook.common.internal.g.checkState(i > 0);
        com.facebook.common.internal.g.checkState(i2 >= 0);
        com.facebook.common.internal.g.checkState(i3 >= 0);
        this.mItemSize = i;
        this.aVf = i2;
        this.jIC = new LinkedList();
        this.jID = i3;
    }

    public boolean cyW() {
        return this.jID + cyX() > this.aVf;
    }

    int cyX() {
        return this.jIC.size();
    }

    @Nullable
    public V get() {
        V pop = pop();
        if (pop != null) {
            this.jID++;
        }
        return pop;
    }

    @Nullable
    public V pop() {
        return (V) this.jIC.poll();
    }

    public void cyY() {
        this.jID++;
    }

    public void release(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        com.facebook.common.internal.g.checkState(this.jID > 0);
        this.jID--;
        aX(v);
    }

    void aX(V v) {
        this.jIC.add(v);
    }

    public void cyZ() {
        com.facebook.common.internal.g.checkState(this.jID > 0);
        this.jID--;
    }
}
