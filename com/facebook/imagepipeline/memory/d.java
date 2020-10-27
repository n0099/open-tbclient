package com.facebook.imagepipeline.memory;

import java.util.LinkedList;
import java.util.Queue;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes18.dex */
class d<V> {
    public final int kYA;
    public final int mItemSize;
    final Queue oNW;
    private final boolean oNX;
    private int oNY;

    public d(int i, int i2, int i3, boolean z) {
        com.facebook.common.internal.g.checkState(i > 0);
        com.facebook.common.internal.g.checkState(i2 >= 0);
        com.facebook.common.internal.g.checkState(i3 >= 0);
        this.mItemSize = i;
        this.kYA = i2;
        this.oNW = new LinkedList();
        this.oNY = i3;
        this.oNX = z;
    }

    public boolean emz() {
        return this.oNY + emA() > this.kYA;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int emA() {
        return this.oNW.size();
    }

    @Nullable
    public V get() {
        V pop = pop();
        if (pop != null) {
            this.oNY++;
        }
        return pop;
    }

    @Nullable
    public V pop() {
        return (V) this.oNW.poll();
    }

    public void emB() {
        this.oNY++;
    }

    public void release(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        if (this.oNX) {
            com.facebook.common.internal.g.checkState(this.oNY > 0);
            this.oNY--;
            bz(v);
        } else if (this.oNY > 0) {
            this.oNY--;
            bz(v);
        } else {
            com.facebook.common.c.a.g("BUCKET", "Tried to release value %s from an empty bucket!", v);
        }
    }

    void bz(V v) {
        this.oNW.add(v);
    }

    public void emC() {
        com.facebook.common.internal.g.checkState(this.oNY > 0);
        this.oNY--;
    }

    public int ejE() {
        return this.oNY;
    }
}
