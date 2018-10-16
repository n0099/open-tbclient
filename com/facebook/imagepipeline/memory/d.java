package com.facebook.imagepipeline.memory;

import java.util.LinkedList;
import java.util.Queue;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes2.dex */
class d<V> {
    final Queue ifY;
    private int ifZ;
    public final int mItemSize;
    public final int mMaxLength;

    public d(int i, int i2, int i3) {
        com.facebook.common.internal.g.checkState(i > 0);
        com.facebook.common.internal.g.checkState(i2 >= 0);
        com.facebook.common.internal.g.checkState(i3 >= 0);
        this.mItemSize = i;
        this.mMaxLength = i2;
        this.ifY = new LinkedList();
        this.ifZ = i3;
    }

    public boolean bWM() {
        return this.ifZ + bWN() > this.mMaxLength;
    }

    int bWN() {
        return this.ifY.size();
    }

    @Nullable
    public V get() {
        V pop = pop();
        if (pop != null) {
            this.ifZ++;
        }
        return pop;
    }

    @Nullable
    public V pop() {
        return (V) this.ifY.poll();
    }

    public void bWO() {
        this.ifZ++;
    }

    public void release(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        com.facebook.common.internal.g.checkState(this.ifZ > 0);
        this.ifZ--;
        aL(v);
    }

    void aL(V v) {
        this.ifY.add(v);
    }

    public void bWP() {
        com.facebook.common.internal.g.checkState(this.ifZ > 0);
        this.ifZ--;
    }
}
