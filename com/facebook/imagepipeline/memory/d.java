package com.facebook.imagepipeline.memory;

import java.util.LinkedList;
import java.util.Queue;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes12.dex */
class d<V> {
    public final int jgO;
    public final int mItemSize;
    final Queue mdU;
    private final boolean mdV;
    private int mdW;

    public d(int i, int i2, int i3, boolean z) {
        com.facebook.common.internal.g.checkState(i > 0);
        com.facebook.common.internal.g.checkState(i2 >= 0);
        com.facebook.common.internal.g.checkState(i3 >= 0);
        this.mItemSize = i;
        this.jgO = i2;
        this.mdU = new LinkedList();
        this.mdW = i3;
        this.mdV = z;
    }

    public boolean dtm() {
        return this.mdW + dtn() > this.jgO;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int dtn() {
        return this.mdU.size();
    }

    @Nullable
    public V get() {
        V pop = pop();
        if (pop != null) {
            this.mdW++;
        }
        return pop;
    }

    @Nullable
    public V pop() {
        return (V) this.mdU.poll();
    }

    public void dto() {
        this.mdW++;
    }

    public void release(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        if (this.mdV) {
            com.facebook.common.internal.g.checkState(this.mdW > 0);
            this.mdW--;
            bj(v);
        } else if (this.mdW > 0) {
            this.mdW--;
            bj(v);
        } else {
            com.facebook.common.c.a.h("BUCKET", "Tried to release value %s from an empty bucket!", v);
        }
    }

    void bj(V v) {
        this.mdU.add(v);
    }

    public void dtp() {
        com.facebook.common.internal.g.checkState(this.mdW > 0);
        this.mdW--;
    }

    public int dqq() {
        return this.mdW;
    }
}
