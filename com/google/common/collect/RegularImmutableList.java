package com.google.common.collect;

import d.g.c.a.n;
/* loaded from: classes6.dex */
public class RegularImmutableList<E> extends ImmutableList<E> {
    public static final ImmutableList<Object> EMPTY = new RegularImmutableList(new Object[0], 0);
    public final transient Object[] array;

    /* renamed from: e  reason: collision with root package name */
    public final transient int f30985e;

    public RegularImmutableList(Object[] objArr, int i) {
        this.array = objArr;
        this.f30985e = i;
    }

    @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection
    public int copyIntoArray(Object[] objArr, int i) {
        System.arraycopy(this.array, 0, objArr, i, this.f30985e);
        return i + this.f30985e;
    }

    @Override // java.util.List
    public E get(int i) {
        n.n(i, this.f30985e);
        return (E) this.array[i];
    }

    @Override // com.google.common.collect.ImmutableCollection
    public Object[] internalArray() {
        return this.array;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public int internalArrayEnd() {
        return this.f30985e;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public int internalArrayStart() {
        return 0;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f30985e;
    }
}
