package com.google.common.collect;

import com.google.common.collect.ImmutableMultiset;
import com.google.common.primitives.Ints;
import d.g.c.c.i0;
import d.g.c.c.k0;
import java.io.Serializable;
/* loaded from: classes6.dex */
public class RegularImmutableMultiset<E> extends ImmutableMultiset<E> {
    public static final RegularImmutableMultiset<Object> EMPTY = new RegularImmutableMultiset<>(k0.b());
    public final transient k0<E> contents;

    /* renamed from: e  reason: collision with root package name */
    public final transient int f31235e;

    /* renamed from: f  reason: collision with root package name */
    public transient ImmutableSet<E> f31236f;

    /* loaded from: classes6.dex */
    public final class ElementSet extends IndexedImmutableSet<E> {
        public ElementSet() {
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return RegularImmutableMultiset.this.contains(obj);
        }

        @Override // com.google.common.collect.IndexedImmutableSet
        public E get(int i2) {
            return RegularImmutableMultiset.this.contents.i(i2);
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return RegularImmutableMultiset.this.contents.C();
        }
    }

    /* loaded from: classes6.dex */
    public static class SerializedForm implements Serializable {
        public static final long serialVersionUID = 0;
        public final int[] counts;
        public final Object[] elements;

        public SerializedForm(i0<?> i0Var) {
            int size = i0Var.entrySet().size();
            this.elements = new Object[size];
            this.counts = new int[size];
            int i2 = 0;
            for (i0.a<?> aVar : i0Var.entrySet()) {
                this.elements[i2] = aVar.getElement();
                this.counts[i2] = aVar.getCount();
                i2++;
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.common.collect.ImmutableMultiset$b */
        /* JADX WARN: Multi-variable type inference failed */
        public Object readResolve() {
            ImmutableMultiset.b bVar = new ImmutableMultiset.b(this.elements.length);
            int i2 = 0;
            while (true) {
                Object[] objArr = this.elements;
                if (i2 < objArr.length) {
                    bVar.j(objArr[i2], this.counts[i2]);
                    i2++;
                } else {
                    return bVar.k();
                }
            }
        }
    }

    public RegularImmutableMultiset(k0<E> k0Var) {
        this.contents = k0Var;
        long j = 0;
        for (int i2 = 0; i2 < k0Var.C(); i2++) {
            j += k0Var.k(i2);
        }
        this.f31235e = Ints.j(j);
    }

    @Override // com.google.common.collect.ImmutableMultiset, d.g.c.c.i0
    public int count(Object obj) {
        return this.contents.f(obj);
    }

    @Override // com.google.common.collect.ImmutableMultiset
    public i0.a<E> getEntry(int i2) {
        return this.contents.g(i2);
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, d.g.c.c.i0
    public int size() {
        return this.f31235e;
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.ImmutableCollection
    public Object writeReplace() {
        return new SerializedForm(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.ImmutableMultiset, d.g.c.c.i0
    public ImmutableSet<E> elementSet() {
        ImmutableSet<E> immutableSet = this.f31236f;
        if (immutableSet == null) {
            ElementSet elementSet = new ElementSet();
            this.f31236f = elementSet;
            return elementSet;
        }
        return immutableSet;
    }
}
