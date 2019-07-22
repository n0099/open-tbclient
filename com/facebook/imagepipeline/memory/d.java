package com.facebook.imagepipeline.memory;

import java.util.LinkedList;
import java.util.Queue;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes2.dex */
class d<V> {
    public final int aYP;
    final Queue kiA;
    private int kiB;
    public final int mItemSize;

    public d(int i, int i2, int i3) {
        com.facebook.common.internal.g.checkState(i > 0);
        com.facebook.common.internal.g.checkState(i2 >= 0);
        com.facebook.common.internal.g.checkState(i3 >= 0);
        this.mItemSize = i;
        this.aYP = i2;
        this.kiA = new LinkedList();
        this.kiB = i3;
    }

    public boolean cJX() {
        return this.kiB + cJY() > this.aYP;
    }

    int cJY() {
        return this.kiA.size();
    }

    @Nullable
    public V get() {
        V pop = pop();
        if (pop != null) {
            this.kiB++;
        }
        return pop;
    }

    @Nullable
    public V pop() {
        return (V) this.kiA.poll();
    }

    public void cJZ() {
        this.kiB++;
    }

    public void release(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        com.facebook.common.internal.g.checkState(this.kiB > 0);
        this.kiB--;
        aZ(v);
    }

    void aZ(V v) {
        this.kiA.add(v);
    }

    public void cKa() {
        com.facebook.common.internal.g.checkState(this.kiB > 0);
        this.kiB--;
    }
}
