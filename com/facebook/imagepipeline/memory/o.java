package com.facebook.imagepipeline.memory;

import java.util.LinkedList;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes12.dex */
class o<V> extends d<V> {
    private LinkedList<com.facebook.common.references.b<V>> mzg;

    public o(int i, int i2, int i3) {
        super(i, i2, i3, false);
        this.mzg = new LinkedList<>();
    }

    @Override // com.facebook.imagepipeline.memory.d
    public V pop() {
        com.facebook.common.references.b<V> bVar = (com.facebook.common.references.b) this.myV.poll();
        V v = bVar.get();
        bVar.clear();
        this.mzg.add(bVar);
        return v;
    }

    @Override // com.facebook.imagepipeline.memory.d
    void bn(V v) {
        com.facebook.common.references.b<V> poll = this.mzg.poll();
        if (poll == null) {
            poll = new com.facebook.common.references.b<>();
        }
        poll.set(v);
        this.myV.add(poll);
    }
}
