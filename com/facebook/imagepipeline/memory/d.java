package com.facebook.imagepipeline.memory;

import java.util.LinkedList;
import java.util.Queue;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes2.dex */
class d<V> {
    public final int aZn;
    final Queue kmd;
    private int kme;
    public final int mItemSize;

    public d(int i, int i2, int i3) {
        com.facebook.common.internal.g.checkState(i > 0);
        com.facebook.common.internal.g.checkState(i2 >= 0);
        com.facebook.common.internal.g.checkState(i3 >= 0);
        this.mItemSize = i;
        this.aZn = i2;
        this.kmd = new LinkedList();
        this.kme = i3;
    }

    public boolean cLg() {
        return this.kme + cLh() > this.aZn;
    }

    int cLh() {
        return this.kmd.size();
    }

    @Nullable
    public V get() {
        V pop = pop();
        if (pop != null) {
            this.kme++;
        }
        return pop;
    }

    @Nullable
    public V pop() {
        return (V) this.kmd.poll();
    }

    public void cLi() {
        this.kme++;
    }

    public void release(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        com.facebook.common.internal.g.checkState(this.kme > 0);
        this.kme--;
        aZ(v);
    }

    void aZ(V v) {
        this.kmd.add(v);
    }

    public void cLj() {
        com.facebook.common.internal.g.checkState(this.kme > 0);
        this.kme--;
    }
}
