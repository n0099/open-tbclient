package com.google.common.collect;

import d.g.c.c.c1;
import d.g.c.c.e0;
/* loaded from: classes6.dex */
public final class RegularImmutableSet<E> extends ImmutableSet<E> {
    public static final RegularImmutableSet<Object> EMPTY = new RegularImmutableSet<>(new Object[0], 0, null, 0, 0);

    /* renamed from: e  reason: collision with root package name */
    public final transient int f32063e;
    public final transient Object[] elements;

    /* renamed from: f  reason: collision with root package name */
    public final transient int f32064f;

    /* renamed from: g  reason: collision with root package name */
    public final transient int f32065g;
    public final transient Object[] table;

    public RegularImmutableSet(Object[] objArr, int i2, Object[] objArr2, int i3, int i4) {
        this.elements = objArr;
        this.table = objArr2;
        this.f32063e = i3;
        this.f32064f = i2;
        this.f32065g = i4;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        Object[] objArr = this.table;
        if (obj == null || objArr == null) {
            return false;
        }
        int d2 = e0.d(obj);
        while (true) {
            int i2 = d2 & this.f32063e;
            Object obj2 = objArr[i2];
            if (obj2 == null) {
                return false;
            }
            if (obj2.equals(obj)) {
                return true;
            }
            d2 = i2 + 1;
        }
    }

    @Override // com.google.common.collect.ImmutableCollection
    public int copyIntoArray(Object[] objArr, int i2) {
        System.arraycopy(this.elements, 0, objArr, i2, this.f32065g);
        return i2 + this.f32065g;
    }

    @Override // com.google.common.collect.ImmutableSet
    public ImmutableList<E> createAsList() {
        return ImmutableList.asImmutableList(this.elements, this.f32065g);
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public int hashCode() {
        return this.f32064f;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public Object[] internalArray() {
        return this.elements;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public int internalArrayEnd() {
        return this.f32065g;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public int internalArrayStart() {
        return 0;
    }

    @Override // com.google.common.collect.ImmutableSet
    public boolean isHashCodeFast() {
        return true;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.f32065g;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public c1<E> iterator() {
        return asList().iterator();
    }
}
