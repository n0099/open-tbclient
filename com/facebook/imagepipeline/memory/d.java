package com.facebook.imagepipeline.memory;

import java.util.LinkedList;
import java.util.Queue;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes2.dex */
class d<V> {
    final Queue isf;
    private int isg;
    public final int mItemSize;
    public final int mMaxLength;

    public d(int i, int i2, int i3) {
        com.facebook.common.internal.g.checkState(i > 0);
        com.facebook.common.internal.g.checkState(i2 >= 0);
        com.facebook.common.internal.g.checkState(i3 >= 0);
        this.mItemSize = i;
        this.mMaxLength = i2;
        this.isf = new LinkedList();
        this.isg = i3;
    }

    public boolean bZd() {
        return this.isg + bZe() > this.mMaxLength;
    }

    int bZe() {
        return this.isf.size();
    }

    @Nullable
    public V get() {
        V pop = pop();
        if (pop != null) {
            this.isg++;
        }
        return pop;
    }

    @Nullable
    public V pop() {
        return (V) this.isf.poll();
    }

    public void bZf() {
        this.isg++;
    }

    public void release(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        com.facebook.common.internal.g.checkState(this.isg > 0);
        this.isg--;
        aL(v);
    }

    void aL(V v) {
        this.isf.add(v);
    }

    public void bZg() {
        com.facebook.common.internal.g.checkState(this.isg > 0);
        this.isg--;
    }
}
