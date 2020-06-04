package com.facebook.imagepipeline.memory;

import java.util.LinkedList;
import java.util.Queue;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes12.dex */
class d<V> {
    public final int jwX;
    public final int mItemSize;
    final Queue myV;
    private final boolean myW;
    private int myX;

    public d(int i, int i2, int i3, boolean z) {
        com.facebook.common.internal.g.checkState(i > 0);
        com.facebook.common.internal.g.checkState(i2 >= 0);
        com.facebook.common.internal.g.checkState(i3 >= 0);
        this.mItemSize = i;
        this.jwX = i2;
        this.myV = new LinkedList();
        this.myX = i3;
        this.myW = z;
    }

    public boolean dAR() {
        return this.myX + dAS() > this.jwX;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int dAS() {
        return this.myV.size();
    }

    @Nullable
    public V get() {
        V pop = pop();
        if (pop != null) {
            this.myX++;
        }
        return pop;
    }

    @Nullable
    public V pop() {
        return (V) this.myV.poll();
    }

    public void dAT() {
        this.myX++;
    }

    public void release(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        if (this.myW) {
            com.facebook.common.internal.g.checkState(this.myX > 0);
            this.myX--;
            bn(v);
        } else if (this.myX > 0) {
            this.myX--;
            bn(v);
        } else {
            com.facebook.common.c.a.h("BUCKET", "Tried to release value %s from an empty bucket!", v);
        }
    }

    void bn(V v) {
        this.myV.add(v);
    }

    public void dAU() {
        com.facebook.common.internal.g.checkState(this.myX > 0);
        this.myX--;
    }

    public int dxW() {
        return this.myX;
    }
}
