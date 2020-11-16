package com.facebook.imagepipeline.memory;

import java.util.LinkedList;
import java.util.Queue;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes15.dex */
class d<V> {
    public final int leP;
    public final int mItemSize;
    final Queue oYS;
    private final boolean oYT;
    private int oYU;

    public d(int i, int i2, int i3, boolean z) {
        com.facebook.common.internal.g.checkState(i > 0);
        com.facebook.common.internal.g.checkState(i2 >= 0);
        com.facebook.common.internal.g.checkState(i3 >= 0);
        this.mItemSize = i;
        this.leP = i2;
        this.oYS = new LinkedList();
        this.oYU = i3;
        this.oYT = z;
    }

    public boolean eqo() {
        return this.oYU + eqp() > this.leP;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int eqp() {
        return this.oYS.size();
    }

    @Nullable
    public V get() {
        V pop = pop();
        if (pop != null) {
            this.oYU++;
        }
        return pop;
    }

    @Nullable
    public V pop() {
        return (V) this.oYS.poll();
    }

    public void eqq() {
        this.oYU++;
    }

    public void release(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        if (this.oYT) {
            com.facebook.common.internal.g.checkState(this.oYU > 0);
            this.oYU--;
            bA(v);
        } else if (this.oYU > 0) {
            this.oYU--;
            bA(v);
        } else {
            com.facebook.common.c.a.g("BUCKET", "Tried to release value %s from an empty bucket!", v);
        }
    }

    void bA(V v) {
        this.oYS.add(v);
    }

    public void eqr() {
        com.facebook.common.internal.g.checkState(this.oYU > 0);
        this.oYU--;
    }

    public int ens() {
        return this.oYU;
    }
}
