package com.facebook.imagepipeline.memory;

import java.util.LinkedList;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes15.dex */
class o<V> extends d<V> {
    private LinkedList<com.facebook.common.references.b<V>> pnS;

    public o(int i, int i2, int i3) {
        super(i, i2, i3, false);
        this.pnS = new LinkedList<>();
    }

    @Override // com.facebook.imagepipeline.memory.d
    public V pop() {
        com.facebook.common.references.b<V> bVar = (com.facebook.common.references.b) this.pnH.poll();
        V v = bVar.get();
        bVar.clear();
        this.pnS.add(bVar);
        return v;
    }

    @Override // com.facebook.imagepipeline.memory.d
    void bz(V v) {
        com.facebook.common.references.b<V> poll = this.pnS.poll();
        if (poll == null) {
            poll = new com.facebook.common.references.b<>();
        }
        poll.set(v);
        this.pnH.add(poll);
    }
}
