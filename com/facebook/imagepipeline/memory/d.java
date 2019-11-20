package com.facebook.imagepipeline.memory;

import java.util.LinkedList;
import java.util.Queue;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes2.dex */
class d<V> {
    public final int brx;
    final Queue kjy;
    private int kjz;
    public final int mItemSize;

    public d(int i, int i2, int i3) {
        com.facebook.common.internal.g.checkState(i > 0);
        com.facebook.common.internal.g.checkState(i2 >= 0);
        com.facebook.common.internal.g.checkState(i3 >= 0);
        this.mItemSize = i;
        this.brx = i2;
        this.kjy = new LinkedList();
        this.kjz = i3;
    }

    public boolean cIb() {
        return this.kjz + cIc() > this.brx;
    }

    int cIc() {
        return this.kjy.size();
    }

    @Nullable
    public V get() {
        V pop = pop();
        if (pop != null) {
            this.kjz++;
        }
        return pop;
    }

    @Nullable
    public V pop() {
        return (V) this.kjy.poll();
    }

    public void cId() {
        this.kjz++;
    }

    public void release(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        com.facebook.common.internal.g.checkState(this.kjz > 0);
        this.kjz--;
        aU(v);
    }

    void aU(V v) {
        this.kjy.add(v);
    }

    public void cIe() {
        com.facebook.common.internal.g.checkState(this.kjz > 0);
        this.kjz--;
    }
}
