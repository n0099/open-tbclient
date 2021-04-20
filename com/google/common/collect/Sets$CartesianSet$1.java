package com.google.common.collect;

import java.util.List;
/* loaded from: classes6.dex */
public final class Sets$CartesianSet$1 extends ImmutableList<List<E>> {
    public final /* synthetic */ ImmutableList val$axes;

    public Sets$CartesianSet$1(ImmutableList immutableList) {
        this.val$axes = immutableList;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.val$axes.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.List
    public List<E> get(int i) {
        return ((ImmutableSet) this.val$axes.get(i)).asList();
    }
}
