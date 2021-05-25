package com.google.common.collect;

import d.g.c.a.n;
import d.g.c.c.c1;
/* loaded from: classes6.dex */
public final class SingletonImmutableSet<E> extends ImmutableSet<E> {

    /* renamed from: e  reason: collision with root package name */
    public transient int f31247e;
    public final transient E element;

    public SingletonImmutableSet(E e2) {
        n.p(e2);
        this.element = e2;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return this.element.equals(obj);
    }

    @Override // com.google.common.collect.ImmutableCollection
    public int copyIntoArray(Object[] objArr, int i2) {
        objArr[i2] = this.element;
        return i2 + 1;
    }

    @Override // com.google.common.collect.ImmutableSet
    public ImmutableList<E> createAsList() {
        return ImmutableList.of((Object) this.element);
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public final int hashCode() {
        int i2 = this.f31247e;
        if (i2 == 0) {
            int hashCode = this.element.hashCode();
            this.f31247e = hashCode;
            return hashCode;
        }
        return i2;
    }

    @Override // com.google.common.collect.ImmutableSet
    public boolean isHashCodeFast() {
        return this.f31247e != 0;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return 1;
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return '[' + this.element.toString() + ']';
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public c1<E> iterator() {
        return Iterators.t(this.element);
    }

    public SingletonImmutableSet(E e2, int i2) {
        this.element = e2;
        this.f31247e = i2;
    }
}
