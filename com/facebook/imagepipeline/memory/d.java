package com.facebook.imagepipeline.memory;

import java.util.LinkedList;
import java.util.Queue;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes3.dex */
class d<V> {
    public final int lsS;
    public final int mItemSize;
    final Queue pAs;
    private final boolean pAt;
    private int pAu;

    public d(int i, int i2, int i3, boolean z) {
        com.facebook.common.internal.g.checkState(i > 0);
        com.facebook.common.internal.g.checkState(i2 >= 0);
        com.facebook.common.internal.g.checkState(i3 >= 0);
        this.mItemSize = i;
        this.lsS = i2;
        this.pAs = new LinkedList();
        this.pAu = i3;
        this.pAt = z;
    }

    public boolean ewk() {
        return this.pAu + ewl() > this.lsS;
    }

    int ewl() {
        return this.pAs.size();
    }

    @Nullable
    public V get() {
        V pop = pop();
        if (pop != null) {
            this.pAu++;
        }
        return pop;
    }

    @Nullable
    public V pop() {
        return (V) this.pAs.poll();
    }

    public void ewm() {
        this.pAu++;
    }

    public void release(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        if (this.pAt) {
            com.facebook.common.internal.g.checkState(this.pAu > 0);
            this.pAu--;
            bz(v);
        } else if (this.pAu > 0) {
            this.pAu--;
            bz(v);
        } else {
            com.facebook.common.c.a.e("BUCKET", "Tried to release value %s from an empty bucket!", v);
        }
    }

    void bz(V v) {
        this.pAs.add(v);
    }

    public void ewn() {
        com.facebook.common.internal.g.checkState(this.pAu > 0);
        this.pAu--;
    }
}
