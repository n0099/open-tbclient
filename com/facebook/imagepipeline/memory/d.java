package com.facebook.imagepipeline.memory;

import java.util.LinkedList;
import java.util.Queue;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes10.dex */
class d<V> {
    public final int isW;
    final Queue lTF;
    private final boolean lTG;
    private int lTH;
    public final int mItemSize;

    public d(int i, int i2, int i3, boolean z) {
        com.facebook.common.internal.g.checkState(i > 0);
        com.facebook.common.internal.g.checkState(i2 >= 0);
        com.facebook.common.internal.g.checkState(i3 >= 0);
        this.mItemSize = i;
        this.isW = i2;
        this.lTF = new LinkedList();
        this.lTH = i3;
        this.lTG = z;
    }

    public boolean dpE() {
        return this.lTH + dpF() > this.isW;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int dpF() {
        return this.lTF.size();
    }

    @Nullable
    public V get() {
        V pop = pop();
        if (pop != null) {
            this.lTH++;
        }
        return pop;
    }

    @Nullable
    public V pop() {
        return (V) this.lTF.poll();
    }

    public void dpG() {
        this.lTH++;
    }

    public void release(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        if (this.lTG) {
            com.facebook.common.internal.g.checkState(this.lTH > 0);
            this.lTH--;
            bq(v);
        } else if (this.lTH > 0) {
            this.lTH--;
            bq(v);
        } else {
            com.facebook.common.c.a.h("BUCKET", "Tried to release value %s from an empty bucket!", v);
        }
    }

    void bq(V v) {
        this.lTF.add(v);
    }

    public void dpH() {
        com.facebook.common.internal.g.checkState(this.lTH > 0);
        this.lTH--;
    }

    public int dmI() {
        return this.lTH;
    }
}
