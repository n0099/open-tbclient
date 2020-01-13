package com.facebook.imagepipeline.memory;

import java.util.LinkedList;
import java.util.Queue;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes10.dex */
class d<V> {
    public final int isW;
    final Queue lTA;
    private final boolean lTB;
    private int lTC;
    public final int mItemSize;

    public d(int i, int i2, int i3, boolean z) {
        com.facebook.common.internal.g.checkState(i > 0);
        com.facebook.common.internal.g.checkState(i2 >= 0);
        com.facebook.common.internal.g.checkState(i3 >= 0);
        this.mItemSize = i;
        this.isW = i2;
        this.lTA = new LinkedList();
        this.lTC = i3;
        this.lTB = z;
    }

    public boolean dpC() {
        return this.lTC + dpD() > this.isW;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int dpD() {
        return this.lTA.size();
    }

    @Nullable
    public V get() {
        V pop = pop();
        if (pop != null) {
            this.lTC++;
        }
        return pop;
    }

    @Nullable
    public V pop() {
        return (V) this.lTA.poll();
    }

    public void dpE() {
        this.lTC++;
    }

    public void release(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        if (this.lTB) {
            com.facebook.common.internal.g.checkState(this.lTC > 0);
            this.lTC--;
            bq(v);
        } else if (this.lTC > 0) {
            this.lTC--;
            bq(v);
        } else {
            com.facebook.common.c.a.h("BUCKET", "Tried to release value %s from an empty bucket!", v);
        }
    }

    void bq(V v) {
        this.lTA.add(v);
    }

    public void dpF() {
        com.facebook.common.internal.g.checkState(this.lTC > 0);
        this.lTC--;
    }

    public int dmG() {
        return this.lTC;
    }
}
