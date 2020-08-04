package com.facebook.imagepipeline.memory;

import java.util.LinkedList;
import java.util.Queue;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes4.dex */
class d<V> {
    public final int jYP;
    public final int mItemSize;
    final Queue ndi;
    private final boolean ndj;
    private int ndk;

    public d(int i, int i2, int i3, boolean z) {
        com.facebook.common.internal.g.checkState(i > 0);
        com.facebook.common.internal.g.checkState(i2 >= 0);
        com.facebook.common.internal.g.checkState(i3 >= 0);
        this.mItemSize = i;
        this.jYP = i2;
        this.ndi = new LinkedList();
        this.ndk = i3;
        this.ndj = z;
    }

    public boolean dIK() {
        return this.ndk + dIL() > this.jYP;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int dIL() {
        return this.ndi.size();
    }

    @Nullable
    public V get() {
        V pop = pop();
        if (pop != null) {
            this.ndk++;
        }
        return pop;
    }

    @Nullable
    public V pop() {
        return (V) this.ndi.poll();
    }

    public void dIM() {
        this.ndk++;
    }

    public void release(V v) {
        com.facebook.common.internal.g.checkNotNull(v);
        if (this.ndj) {
            com.facebook.common.internal.g.checkState(this.ndk > 0);
            this.ndk--;
            bo(v);
        } else if (this.ndk > 0) {
            this.ndk--;
            bo(v);
        } else {
            com.facebook.common.c.a.h("BUCKET", "Tried to release value %s from an empty bucket!", v);
        }
    }

    void bo(V v) {
        this.ndi.add(v);
    }

    public void dIN() {
        com.facebook.common.internal.g.checkState(this.ndk > 0);
        this.ndk--;
    }

    public int dFP() {
        return this.ndk;
    }
}
