package com.facebook.imagepipeline.memory;

import java.util.LinkedList;
import java.util.Queue;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes18.dex */
class d<V> {
    public final int ley;
    public final int mItemSize;
    final Queue oXp;
    private final boolean oXq;
    private int oXr;

    public d(int i, int i2, int i3, boolean z) {
        com.facebook.common.internal.g.checkState(i > 0);
        com.facebook.common.internal.g.checkState(i2 >= 0);
        com.facebook.common.internal.g.checkState(i3 >= 0);
        this.mItemSize = i;
        this.ley = i2;
        this.oXp = new LinkedList();
        this.oXr = i3;
        this.oXq = z;
    }

    public boolean eqq() {
        return this.oXr + eqr() > this.ley;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int eqr() {
        return this.oXp.size();
    }

    @Nullable
    public V get() {
        V pop = pop();
        if (pop != null) {
            this.oXr++;
        }
        return pop;
    }

    @Nullable
    public V pop() {
        return (V) this.oXp.poll();
    }

    public void eqs() {
        this.oXr++;
    }

    public void release(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        if (this.oXq) {
            com.facebook.common.internal.g.checkState(this.oXr > 0);
            this.oXr--;
            bz(v);
        } else if (this.oXr > 0) {
            this.oXr--;
            bz(v);
        } else {
            com.facebook.common.c.a.g("BUCKET", "Tried to release value %s from an empty bucket!", v);
        }
    }

    void bz(V v) {
        this.oXp.add(v);
    }

    public void eqt() {
        com.facebook.common.internal.g.checkState(this.oXr > 0);
        this.oXr--;
    }

    public int enu() {
        return this.oXr;
    }
}
