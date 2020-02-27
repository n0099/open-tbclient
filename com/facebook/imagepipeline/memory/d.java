package com.facebook.imagepipeline.memory;

import java.util.LinkedList;
import java.util.Queue;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes12.dex */
class d<V> {
    public final int iuR;
    final Queue lUm;
    private final boolean lUn;
    private int lUo;
    public final int mItemSize;

    public d(int i, int i2, int i3, boolean z) {
        com.facebook.common.internal.g.checkState(i > 0);
        com.facebook.common.internal.g.checkState(i2 >= 0);
        com.facebook.common.internal.g.checkState(i3 >= 0);
        this.mItemSize = i;
        this.iuR = i2;
        this.lUm = new LinkedList();
        this.lUo = i3;
        this.lUn = z;
    }

    public boolean dqQ() {
        return this.lUo + dqR() > this.iuR;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int dqR() {
        return this.lUm.size();
    }

    @Nullable
    public V get() {
        V pop = pop();
        if (pop != null) {
            this.lUo++;
        }
        return pop;
    }

    @Nullable
    public V pop() {
        return (V) this.lUm.poll();
    }

    public void dqS() {
        this.lUo++;
    }

    public void release(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        if (this.lUn) {
            com.facebook.common.internal.g.checkState(this.lUo > 0);
            this.lUo--;
            bs(v);
        } else if (this.lUo > 0) {
            this.lUo--;
            bs(v);
        } else {
            com.facebook.common.c.a.h("BUCKET", "Tried to release value %s from an empty bucket!", v);
        }
    }

    void bs(V v) {
        this.lUm.add(v);
    }

    public void dqT() {
        com.facebook.common.internal.g.checkState(this.lUo > 0);
        this.lUo--;
    }

    public int dnV() {
        return this.lUo;
    }
}
