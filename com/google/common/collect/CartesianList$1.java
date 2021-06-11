package com.google.common.collect;

import d.g.c.a.n;
import d.g.c.c.l;
import java.util.List;
/* loaded from: classes6.dex */
public class CartesianList$1 extends ImmutableList<E> {
    public final /* synthetic */ l this$0;
    public final /* synthetic */ int val$index;

    public CartesianList$1(l lVar, int i2) {
        this.this$0 = lVar;
        this.val$index = i2;
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [E, java.lang.Object] */
    @Override // java.util.List
    public E get(int i2) {
        int c2;
        ImmutableList immutableList;
        n.n(i2, size());
        c2 = this.this$0.c(this.val$index, i2);
        immutableList = this.this$0.f70022e;
        return ((List) immutableList.get(i2)).get(c2);
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        ImmutableList immutableList;
        immutableList = this.this$0.f70022e;
        return immutableList.size();
    }
}
