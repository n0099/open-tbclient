package com.google.common.collect;

import d.g.c.c.i0;
import d.g.c.c.v0;
/* loaded from: classes6.dex */
public final class DescendingImmutableSortedMultiset<E> extends ImmutableSortedMultiset<E> {

    /* renamed from: e  reason: collision with root package name */
    public final transient ImmutableSortedMultiset<E> f31807e;

    public DescendingImmutableSortedMultiset(ImmutableSortedMultiset<E> immutableSortedMultiset) {
        this.f31807e = immutableSortedMultiset;
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.ImmutableSortedMultisetFauxverideShim, com.google.common.collect.ImmutableMultiset, d.g.c.c.i0
    public int count(Object obj) {
        return this.f31807e.count(obj);
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, d.g.c.c.v0
    public i0.a<E> firstEntry() {
        return this.f31807e.lastEntry();
    }

    @Override // com.google.common.collect.ImmutableMultiset
    public i0.a<E> getEntry(int i2) {
        return this.f31807e.entrySet().asList().reverse().get(i2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedMultiset, d.g.c.c.v0
    public /* bridge */ /* synthetic */ v0 headMultiset(Object obj, BoundType boundType) {
        return headMultiset((DescendingImmutableSortedMultiset<E>) obj, boundType);
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return this.f31807e.isPartialView();
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, d.g.c.c.v0
    public i0.a<E> lastEntry() {
        return this.f31807e.firstEntry();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, d.g.c.c.i0
    public int size() {
        return this.f31807e.size();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedMultiset, d.g.c.c.v0
    public /* bridge */ /* synthetic */ v0 tailMultiset(Object obj, BoundType boundType) {
        return tailMultiset((DescendingImmutableSortedMultiset<E>) obj, boundType);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.ImmutableSortedMultiset, d.g.c.c.v0
    public ImmutableSortedMultiset<E> descendingMultiset() {
        return this.f31807e;
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, d.g.c.c.v0
    public ImmutableSortedMultiset<E> headMultiset(E e2, BoundType boundType) {
        return this.f31807e.tailMultiset((ImmutableSortedMultiset<E>) e2, boundType).descendingMultiset();
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, d.g.c.c.v0
    public ImmutableSortedMultiset<E> tailMultiset(E e2, BoundType boundType) {
        return this.f31807e.headMultiset((ImmutableSortedMultiset<E>) e2, boundType).descendingMultiset();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.ImmutableMultiset, d.g.c.c.i0
    public ImmutableSortedSet<E> elementSet() {
        return this.f31807e.elementSet().descendingSet();
    }
}
