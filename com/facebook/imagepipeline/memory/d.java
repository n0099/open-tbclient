package com.facebook.imagepipeline.memory;

import java.util.LinkedList;
import java.util.Queue;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes18.dex */
class d<V> {
    public final int kMd;
    public final int mItemSize;
    final Queue nWE;
    private final boolean nWF;
    private int nWG;

    public d(int i, int i2, int i3, boolean z) {
        com.facebook.common.internal.g.checkState(i > 0);
        com.facebook.common.internal.g.checkState(i2 >= 0);
        com.facebook.common.internal.g.checkState(i3 >= 0);
        this.mItemSize = i;
        this.kMd = i2;
        this.nWE = new LinkedList();
        this.nWG = i3;
        this.nWF = z;
    }

    public boolean ecB() {
        return this.nWG + ecC() > this.kMd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int ecC() {
        return this.nWE.size();
    }

    @Nullable
    public V get() {
        V pop = pop();
        if (pop != null) {
            this.nWG++;
        }
        return pop;
    }

    @Nullable
    public V pop() {
        return (V) this.nWE.poll();
    }

    public void ecD() {
        this.nWG++;
    }

    public void release(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        if (this.nWF) {
            com.facebook.common.internal.g.checkState(this.nWG > 0);
            this.nWG--;
            bv(v);
        } else if (this.nWG > 0) {
            this.nWG--;
            bv(v);
        } else {
            com.facebook.common.c.a.g("BUCKET", "Tried to release value %s from an empty bucket!", v);
        }
    }

    void bv(V v) {
        this.nWE.add(v);
    }

    public void ecE() {
        com.facebook.common.internal.g.checkState(this.nWG > 0);
        this.nWG--;
    }

    public int dZG() {
        return this.nWG;
    }
}
