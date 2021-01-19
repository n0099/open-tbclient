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
    final Queue pAt;
    private final boolean pAu;
    private int pAv;

    public d(int i, int i2, int i3, boolean z) {
        com.facebook.common.internal.g.checkState(i > 0);
        com.facebook.common.internal.g.checkState(i2 >= 0);
        com.facebook.common.internal.g.checkState(i3 >= 0);
        this.mItemSize = i;
        this.lsS = i2;
        this.pAt = new LinkedList();
        this.pAv = i3;
        this.pAu = z;
    }

    public boolean ewk() {
        return this.pAv + ewl() > this.lsS;
    }

    int ewl() {
        return this.pAt.size();
    }

    @Nullable
    public V get() {
        V pop = pop();
        if (pop != null) {
            this.pAv++;
        }
        return pop;
    }

    @Nullable
    public V pop() {
        return (V) this.pAt.poll();
    }

    public void ewm() {
        this.pAv++;
    }

    public void release(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        if (this.pAu) {
            com.facebook.common.internal.g.checkState(this.pAv > 0);
            this.pAv--;
            bz(v);
        } else if (this.pAv > 0) {
            this.pAv--;
            bz(v);
        } else {
            com.facebook.common.c.a.e("BUCKET", "Tried to release value %s from an empty bucket!", v);
        }
    }

    void bz(V v) {
        this.pAt.add(v);
    }

    public void ewn() {
        com.facebook.common.internal.g.checkState(this.pAv > 0);
        this.pAv--;
    }
}
