package com.facebook.imagepipeline.memory;

import java.util.LinkedList;
import java.util.Queue;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes2.dex */
class d<V> {
    final Queue itm;
    private int itn;
    public final int mItemSize;
    public final int mMaxLength;

    public d(int i, int i2, int i3) {
        com.facebook.common.internal.g.checkState(i > 0);
        com.facebook.common.internal.g.checkState(i2 >= 0);
        com.facebook.common.internal.g.checkState(i3 >= 0);
        this.mItemSize = i;
        this.mMaxLength = i2;
        this.itm = new LinkedList();
        this.itn = i3;
    }

    public boolean bZL() {
        return this.itn + bZM() > this.mMaxLength;
    }

    int bZM() {
        return this.itm.size();
    }

    @Nullable
    public V get() {
        V pop = pop();
        if (pop != null) {
            this.itn++;
        }
        return pop;
    }

    @Nullable
    public V pop() {
        return (V) this.itm.poll();
    }

    public void bZN() {
        this.itn++;
    }

    public void release(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        com.facebook.common.internal.g.checkState(this.itn > 0);
        this.itn--;
        aL(v);
    }

    void aL(V v) {
        this.itm.add(v);
    }

    public void bZO() {
        com.facebook.common.internal.g.checkState(this.itn > 0);
        this.itn--;
    }
}
