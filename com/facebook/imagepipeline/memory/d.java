package com.facebook.imagepipeline.memory;

import java.util.LinkedList;
import java.util.Queue;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes12.dex */
class d<V> {
    public final int jQp;
    public final int mItemSize;
    final Queue mVf;
    private final boolean mVg;
    private int mVh;

    public d(int i, int i2, int i3, boolean z) {
        com.facebook.common.internal.g.checkState(i > 0);
        com.facebook.common.internal.g.checkState(i2 >= 0);
        com.facebook.common.internal.g.checkState(i3 >= 0);
        this.mItemSize = i;
        this.jQp = i2;
        this.mVf = new LinkedList();
        this.mVh = i3;
        this.mVg = z;
    }

    public boolean dFx() {
        return this.mVh + dFy() > this.jQp;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int dFy() {
        return this.mVf.size();
    }

    @Nullable
    public V get() {
        V pop = pop();
        if (pop != null) {
            this.mVh++;
        }
        return pop;
    }

    @Nullable
    public V pop() {
        return (V) this.mVf.poll();
    }

    public void dFz() {
        this.mVh++;
    }

    public void release(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        if (this.mVg) {
            com.facebook.common.internal.g.checkState(this.mVh > 0);
            this.mVh--;
            bo(v);
        } else if (this.mVh > 0) {
            this.mVh--;
            bo(v);
        } else {
            com.facebook.common.c.a.h("BUCKET", "Tried to release value %s from an empty bucket!", v);
        }
    }

    void bo(V v) {
        this.mVf.add(v);
    }

    public void dFA() {
        com.facebook.common.internal.g.checkState(this.mVh > 0);
        this.mVh--;
    }

    public int dCC() {
        return this.mVh;
    }
}
