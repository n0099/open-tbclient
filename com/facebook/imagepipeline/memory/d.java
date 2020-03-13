package com.facebook.imagepipeline.memory;

import java.util.LinkedList;
import java.util.Queue;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes12.dex */
class d<V> {
    public final int ivf;
    private final boolean lUA;
    private int lUB;
    final Queue lUz;
    public final int mItemSize;

    public d(int i, int i2, int i3, boolean z) {
        com.facebook.common.internal.g.checkState(i > 0);
        com.facebook.common.internal.g.checkState(i2 >= 0);
        com.facebook.common.internal.g.checkState(i3 >= 0);
        this.mItemSize = i;
        this.ivf = i2;
        this.lUz = new LinkedList();
        this.lUB = i3;
        this.lUA = z;
    }

    public boolean dqT() {
        return this.lUB + dqU() > this.ivf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int dqU() {
        return this.lUz.size();
    }

    @Nullable
    public V get() {
        V pop = pop();
        if (pop != null) {
            this.lUB++;
        }
        return pop;
    }

    @Nullable
    public V pop() {
        return (V) this.lUz.poll();
    }

    public void dqV() {
        this.lUB++;
    }

    public void release(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        if (this.lUA) {
            com.facebook.common.internal.g.checkState(this.lUB > 0);
            this.lUB--;
            bs(v);
        } else if (this.lUB > 0) {
            this.lUB--;
            bs(v);
        } else {
            com.facebook.common.c.a.h("BUCKET", "Tried to release value %s from an empty bucket!", v);
        }
    }

    void bs(V v) {
        this.lUz.add(v);
    }

    public void dqW() {
        com.facebook.common.internal.g.checkState(this.lUB > 0);
        this.lUB--;
    }

    public int dnY() {
        return this.lUB;
    }
}
