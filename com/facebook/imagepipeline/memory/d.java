package com.facebook.imagepipeline.memory;

import java.util.LinkedList;
import java.util.Queue;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes2.dex */
class d<V> {
    public final int aVe;
    final Queue jIB;
    private int jIC;
    public final int mItemSize;

    public d(int i, int i2, int i3) {
        com.facebook.common.internal.g.checkState(i > 0);
        com.facebook.common.internal.g.checkState(i2 >= 0);
        com.facebook.common.internal.g.checkState(i3 >= 0);
        this.mItemSize = i;
        this.aVe = i2;
        this.jIB = new LinkedList();
        this.jIC = i3;
    }

    public boolean cyW() {
        return this.jIC + cyX() > this.aVe;
    }

    int cyX() {
        return this.jIB.size();
    }

    @Nullable
    public V get() {
        V pop = pop();
        if (pop != null) {
            this.jIC++;
        }
        return pop;
    }

    @Nullable
    public V pop() {
        return (V) this.jIB.poll();
    }

    public void cyY() {
        this.jIC++;
    }

    public void release(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        com.facebook.common.internal.g.checkState(this.jIC > 0);
        this.jIC--;
        aX(v);
    }

    void aX(V v) {
        this.jIB.add(v);
    }

    public void cyZ() {
        com.facebook.common.internal.g.checkState(this.jIC > 0);
        this.jIC--;
    }
}
