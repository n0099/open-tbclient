package com.facebook.imagepipeline.memory;

import java.util.LinkedList;
import java.util.Queue;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes2.dex */
class d<V> {
    public final int aYP;
    final Queue kjG;
    private int kjH;
    public final int mItemSize;

    public d(int i, int i2, int i3) {
        com.facebook.common.internal.g.checkState(i > 0);
        com.facebook.common.internal.g.checkState(i2 >= 0);
        com.facebook.common.internal.g.checkState(i3 >= 0);
        this.mItemSize = i;
        this.aYP = i2;
        this.kjG = new LinkedList();
        this.kjH = i3;
    }

    public boolean cKs() {
        return this.kjH + cKt() > this.aYP;
    }

    int cKt() {
        return this.kjG.size();
    }

    @Nullable
    public V get() {
        V pop = pop();
        if (pop != null) {
            this.kjH++;
        }
        return pop;
    }

    @Nullable
    public V pop() {
        return (V) this.kjG.poll();
    }

    public void cKu() {
        this.kjH++;
    }

    public void release(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        com.facebook.common.internal.g.checkState(this.kjH > 0);
        this.kjH--;
        aZ(v);
    }

    void aZ(V v) {
        this.kjG.add(v);
    }

    public void cKv() {
        com.facebook.common.internal.g.checkState(this.kjH > 0);
        this.kjH--;
    }
}
