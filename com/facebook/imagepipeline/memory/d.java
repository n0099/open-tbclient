package com.facebook.imagepipeline.memory;

import java.util.LinkedList;
import java.util.Queue;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes2.dex */
class d<V> {
    final Queue ihJ;
    private int ihK;
    public final int mItemSize;
    public final int mMaxLength;

    public d(int i, int i2, int i3) {
        com.facebook.common.internal.g.checkState(i > 0);
        com.facebook.common.internal.g.checkState(i2 >= 0);
        com.facebook.common.internal.g.checkState(i3 >= 0);
        this.mItemSize = i;
        this.mMaxLength = i2;
        this.ihJ = new LinkedList();
        this.ihK = i3;
    }

    public boolean bWh() {
        return this.ihK + bWi() > this.mMaxLength;
    }

    int bWi() {
        return this.ihJ.size();
    }

    @Nullable
    public V get() {
        V pop = pop();
        if (pop != null) {
            this.ihK++;
        }
        return pop;
    }

    @Nullable
    public V pop() {
        return (V) this.ihJ.poll();
    }

    public void bWj() {
        this.ihK++;
    }

    public void release(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        com.facebook.common.internal.g.checkState(this.ihK > 0);
        this.ihK--;
        aK(v);
    }

    void aK(V v) {
        this.ihJ.add(v);
    }

    public void bWk() {
        com.facebook.common.internal.g.checkState(this.ihK > 0);
        this.ihK--;
    }
}
