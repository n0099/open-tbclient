package com.google.common.collect;

import d.h.c.a.n;
import d.h.c.c.l;
import java.util.List;
/* loaded from: classes6.dex */
public class CartesianList$1 extends ImmutableList<E> {
    public final /* synthetic */ l this$0;
    public final /* synthetic */ int val$index;

    public CartesianList$1(l lVar, int i) {
        this.this$0 = lVar;
        this.val$index = i;
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [E, java.lang.Object] */
    @Override // java.util.List
    public E get(int i) {
        int c2;
        ImmutableList immutableList;
        n.n(i, size());
        c2 = this.this$0.c(this.val$index, i);
        immutableList = this.this$0.f67147e;
        return ((List) immutableList.get(i)).get(c2);
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        ImmutableList immutableList;
        immutableList = this.this$0.f67147e;
        return immutableList.size();
    }
}
