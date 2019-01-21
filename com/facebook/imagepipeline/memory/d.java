package com.facebook.imagepipeline.memory;

import java.util.LinkedList;
import java.util.Queue;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes2.dex */
class d<V> {
    final Queue itn;
    private int ito;
    public final int mItemSize;
    public final int mMaxLength;

    public d(int i, int i2, int i3) {
        com.facebook.common.internal.g.checkState(i > 0);
        com.facebook.common.internal.g.checkState(i2 >= 0);
        com.facebook.common.internal.g.checkState(i3 >= 0);
        this.mItemSize = i;
        this.mMaxLength = i2;
        this.itn = new LinkedList();
        this.ito = i3;
    }

    public boolean bZL() {
        return this.ito + bZM() > this.mMaxLength;
    }

    int bZM() {
        return this.itn.size();
    }

    @Nullable
    public V get() {
        V pop = pop();
        if (pop != null) {
            this.ito++;
        }
        return pop;
    }

    @Nullable
    public V pop() {
        return (V) this.itn.poll();
    }

    public void bZN() {
        this.ito++;
    }

    public void release(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        com.facebook.common.internal.g.checkState(this.ito > 0);
        this.ito--;
        aL(v);
    }

    void aL(V v) {
        this.itn.add(v);
    }

    public void bZO() {
        com.facebook.common.internal.g.checkState(this.ito > 0);
        this.ito--;
    }
}
