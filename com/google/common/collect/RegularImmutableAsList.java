package com.google.common.collect;

import d.g.c.c.d1;
/* loaded from: classes6.dex */
public class RegularImmutableAsList<E> extends ImmutableAsList<E> {
    public final ImmutableCollection<E> delegate;
    public final ImmutableList<? extends E> delegateList;

    public RegularImmutableAsList(ImmutableCollection<E> immutableCollection, ImmutableList<? extends E> immutableList) {
        this.delegate = immutableCollection;
        this.delegateList = immutableList;
    }

    @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection
    public int copyIntoArray(Object[] objArr, int i2) {
        return this.delegateList.copyIntoArray(objArr, i2);
    }

    @Override // com.google.common.collect.ImmutableAsList
    public ImmutableCollection<E> delegateCollection() {
        return this.delegate;
    }

    public ImmutableList<? extends E> delegateList() {
        return this.delegateList;
    }

    @Override // java.util.List
    public E get(int i2) {
        return this.delegateList.get(i2);
    }

    @Override // com.google.common.collect.ImmutableCollection
    public Object[] internalArray() {
        return this.delegateList.internalArray();
    }

    @Override // com.google.common.collect.ImmutableCollection
    public int internalArrayEnd() {
        return this.delegateList.internalArrayEnd();
    }

    @Override // com.google.common.collect.ImmutableCollection
    public int internalArrayStart() {
        return this.delegateList.internalArrayStart();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: d.g.c.c.d1<? extends E>, d.g.c.c.d1<E> */
    @Override // com.google.common.collect.ImmutableList, java.util.List
    public d1<E> listIterator(int i2) {
        return (d1<? extends E>) this.delegateList.listIterator(i2);
    }

    public RegularImmutableAsList(ImmutableCollection<E> immutableCollection, Object[] objArr) {
        this(immutableCollection, ImmutableList.asImmutableList(objArr));
    }

    public RegularImmutableAsList(ImmutableCollection<E> immutableCollection, Object[] objArr, int i2) {
        this(immutableCollection, ImmutableList.asImmutableList(objArr, i2));
    }
}
