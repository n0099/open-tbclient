package com.facebook.imagepipeline.memory;

import java.util.LinkedList;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes2.dex */
class o<V> extends d<V> {
    private LinkedList<com.facebook.common.references.b<V>> ihU;

    public o(int i, int i2, int i3) {
        super(i, i2, i3);
        this.ihU = new LinkedList<>();
    }

    @Override // com.facebook.imagepipeline.memory.d
    public V pop() {
        com.facebook.common.references.b<V> bVar = (com.facebook.common.references.b) this.ihJ.poll();
        V v = bVar.get();
        bVar.clear();
        this.ihU.add(bVar);
        return v;
    }

    @Override // com.facebook.imagepipeline.memory.d
    void aK(V v) {
        com.facebook.common.references.b<V> poll = this.ihU.poll();
        if (poll == null) {
            poll = new com.facebook.common.references.b<>();
        }
        poll.set(v);
        this.ihJ.add(poll);
    }
}
