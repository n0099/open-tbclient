package com.facebook.imagepipeline.memory;

import java.util.LinkedList;
import java.util.Queue;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes12.dex */
class d<V> {
    public final int iuT;
    final Queue lUo;
    private final boolean lUp;
    private int lUq;
    public final int mItemSize;

    public d(int i, int i2, int i3, boolean z) {
        com.facebook.common.internal.g.checkState(i > 0);
        com.facebook.common.internal.g.checkState(i2 >= 0);
        com.facebook.common.internal.g.checkState(i3 >= 0);
        this.mItemSize = i;
        this.iuT = i2;
        this.lUo = new LinkedList();
        this.lUq = i3;
        this.lUp = z;
    }

    public boolean dqS() {
        return this.lUq + dqT() > this.iuT;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int dqT() {
        return this.lUo.size();
    }

    @Nullable
    public V get() {
        V pop = pop();
        if (pop != null) {
            this.lUq++;
        }
        return pop;
    }

    @Nullable
    public V pop() {
        return (V) this.lUo.poll();
    }

    public void dqU() {
        this.lUq++;
    }

    public void release(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        if (this.lUp) {
            com.facebook.common.internal.g.checkState(this.lUq > 0);
            this.lUq--;
            bs(v);
        } else if (this.lUq > 0) {
            this.lUq--;
            bs(v);
        } else {
            com.facebook.common.c.a.h("BUCKET", "Tried to release value %s from an empty bucket!", v);
        }
    }

    void bs(V v) {
        this.lUo.add(v);
    }

    public void dqV() {
        com.facebook.common.internal.g.checkState(this.lUq > 0);
        this.lUq--;
    }

    public int dnX() {
        return this.lUq;
    }
}
