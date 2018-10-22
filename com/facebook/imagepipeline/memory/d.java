package com.facebook.imagepipeline.memory;

import java.util.LinkedList;
import java.util.Queue;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes2.dex */
class d<V> {
    final Queue ifZ;
    private int iga;
    public final int mItemSize;
    public final int mMaxLength;

    public d(int i, int i2, int i3) {
        com.facebook.common.internal.g.checkState(i > 0);
        com.facebook.common.internal.g.checkState(i2 >= 0);
        com.facebook.common.internal.g.checkState(i3 >= 0);
        this.mItemSize = i;
        this.mMaxLength = i2;
        this.ifZ = new LinkedList();
        this.iga = i3;
    }

    public boolean bWM() {
        return this.iga + bWN() > this.mMaxLength;
    }

    int bWN() {
        return this.ifZ.size();
    }

    @Nullable
    public V get() {
        V pop = pop();
        if (pop != null) {
            this.iga++;
        }
        return pop;
    }

    @Nullable
    public V pop() {
        return (V) this.ifZ.poll();
    }

    public void bWO() {
        this.iga++;
    }

    public void release(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        com.facebook.common.internal.g.checkState(this.iga > 0);
        this.iga--;
        aL(v);
    }

    void aL(V v) {
        this.ifZ.add(v);
    }

    public void bWP() {
        com.facebook.common.internal.g.checkState(this.iga > 0);
        this.iga--;
    }
}
