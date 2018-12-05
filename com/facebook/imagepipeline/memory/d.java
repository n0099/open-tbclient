package com.facebook.imagepipeline.memory;

import java.util.LinkedList;
import java.util.Queue;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes2.dex */
class d<V> {
    final Queue ioV;
    private int ioW;
    public final int mItemSize;
    public final int mMaxLength;

    public d(int i, int i2, int i3) {
        com.facebook.common.internal.g.checkState(i > 0);
        com.facebook.common.internal.g.checkState(i2 >= 0);
        com.facebook.common.internal.g.checkState(i3 >= 0);
        this.mItemSize = i;
        this.mMaxLength = i2;
        this.ioV = new LinkedList();
        this.ioW = i3;
    }

    public boolean bYn() {
        return this.ioW + bYo() > this.mMaxLength;
    }

    int bYo() {
        return this.ioV.size();
    }

    @Nullable
    public V get() {
        V pop = pop();
        if (pop != null) {
            this.ioW++;
        }
        return pop;
    }

    @Nullable
    public V pop() {
        return (V) this.ioV.poll();
    }

    public void bYp() {
        this.ioW++;
    }

    public void release(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        com.facebook.common.internal.g.checkState(this.ioW > 0);
        this.ioW--;
        aL(v);
    }

    void aL(V v) {
        this.ioV.add(v);
    }

    public void bYq() {
        com.facebook.common.internal.g.checkState(this.ioW > 0);
        this.ioW--;
    }
}
