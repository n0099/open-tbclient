package com.google.common.collect;

import d.h.c.c.f0;
import d.h.c.c.k0;
import java.util.Set;
/* loaded from: classes6.dex */
public class HashMultiset<E> extends AbstractMapBasedMultiset<E> {
    public static final long serialVersionUID = 0;

    public HashMultiset(int i) {
        super(i);
    }

    public static <E> HashMultiset<E> create() {
        return create(3);
    }

    @Override // d.h.c.c.d, java.util.AbstractCollection, java.util.Collection, d.h.c.c.i0
    public /* bridge */ /* synthetic */ boolean contains(Object obj) {
        return super.contains(obj);
    }

    @Override // d.h.c.c.d, d.h.c.c.i0
    public /* bridge */ /* synthetic */ Set elementSet() {
        return super.elementSet();
    }

    @Override // d.h.c.c.d, d.h.c.c.i0
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @Override // com.google.common.collect.AbstractMapBasedMultiset
    public void init(int i) {
        this.backingMap = new k0<>(i);
    }

    @Override // d.h.c.c.d, java.util.AbstractCollection, java.util.Collection
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    public static <E> HashMultiset<E> create(int i) {
        return new HashMultiset<>(i);
    }

    public static <E> HashMultiset<E> create(Iterable<? extends E> iterable) {
        HashMultiset<E> create = create(Multisets.h(iterable));
        f0.a(create, iterable);
        return create;
    }
}
