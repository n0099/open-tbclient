package com.google.common.collect;

import d.g.c.c.f0;
import d.g.c.c.k0;
import java.util.Set;
/* loaded from: classes6.dex */
public class HashMultiset<E> extends AbstractMapBasedMultiset<E> {
    public static final long serialVersionUID = 0;

    public HashMultiset(int i2) {
        super(i2);
    }

    public static <E> HashMultiset<E> create() {
        return create(3);
    }

    @Override // d.g.c.c.d, java.util.AbstractCollection, java.util.Collection, d.g.c.c.i0
    public /* bridge */ /* synthetic */ boolean contains(Object obj) {
        return super.contains(obj);
    }

    @Override // d.g.c.c.d, d.g.c.c.i0
    public /* bridge */ /* synthetic */ Set elementSet() {
        return super.elementSet();
    }

    @Override // d.g.c.c.d, d.g.c.c.i0
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @Override // com.google.common.collect.AbstractMapBasedMultiset
    public void init(int i2) {
        this.backingMap = new k0<>(i2);
    }

    @Override // d.g.c.c.d, java.util.AbstractCollection, java.util.Collection
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    public static <E> HashMultiset<E> create(int i2) {
        return new HashMultiset<>(i2);
    }

    public static <E> HashMultiset<E> create(Iterable<? extends E> iterable) {
        HashMultiset<E> create = create(Multisets.h(iterable));
        f0.a(create, iterable);
        return create;
    }
}
