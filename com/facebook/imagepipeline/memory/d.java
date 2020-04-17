package com.facebook.imagepipeline.memory;

import java.util.LinkedList;
import java.util.Queue;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes12.dex */
class d<V> {
    public final int jgK;
    public final int mItemSize;
    final Queue mdQ;
    private final boolean mdR;
    private int mdS;

    public d(int i, int i2, int i3, boolean z) {
        com.facebook.common.internal.g.checkState(i > 0);
        com.facebook.common.internal.g.checkState(i2 >= 0);
        com.facebook.common.internal.g.checkState(i3 >= 0);
        this.mItemSize = i;
        this.jgK = i2;
        this.mdQ = new LinkedList();
        this.mdS = i3;
        this.mdR = z;
    }

    public boolean dto() {
        return this.mdS + dtp() > this.jgK;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int dtp() {
        return this.mdQ.size();
    }

    @Nullable
    public V get() {
        V pop = pop();
        if (pop != null) {
            this.mdS++;
        }
        return pop;
    }

    @Nullable
    public V pop() {
        return (V) this.mdQ.poll();
    }

    public void dtq() {
        this.mdS++;
    }

    public void release(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        if (this.mdR) {
            com.facebook.common.internal.g.checkState(this.mdS > 0);
            this.mdS--;
            bi(v);
        } else if (this.mdS > 0) {
            this.mdS--;
            bi(v);
        } else {
            com.facebook.common.c.a.h("BUCKET", "Tried to release value %s from an empty bucket!", v);
        }
    }

    void bi(V v) {
        this.mdQ.add(v);
    }

    public void dtr() {
        com.facebook.common.internal.g.checkState(this.mdS > 0);
        this.mdS--;
    }

    public int dqs() {
        return this.mdS;
    }
}
