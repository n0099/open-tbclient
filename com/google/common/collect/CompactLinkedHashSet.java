package com.google.common.collect;

import d.h.c.c.j0;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
/* loaded from: classes6.dex */
public class CompactLinkedHashSet<E> extends CompactHashSet<E> {

    /* renamed from: h  reason: collision with root package name */
    public transient int[] f30835h;
    public transient int[] i;
    public transient int j;
    public transient int k;

    public CompactLinkedHashSet() {
    }

    public static <E> CompactLinkedHashSet<E> create() {
        return new CompactLinkedHashSet<>();
    }

    public static <E> CompactLinkedHashSet<E> createWithExpectedSize(int i) {
        return new CompactLinkedHashSet<>(i);
    }

    @Override // com.google.common.collect.CompactHashSet
    public int adjustAfterRemove(int i, int i2) {
        return i >= size() ? i2 : i;
    }

    @Override // com.google.common.collect.CompactHashSet
    public void allocArrays() {
        super.allocArrays();
        int length = this.elements.length;
        int[] iArr = new int[length];
        this.f30835h = iArr;
        this.i = new int[length];
        Arrays.fill(iArr, -1);
        Arrays.fill(this.i, -1);
    }

    @Override // com.google.common.collect.CompactHashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        if (needsAllocArrays()) {
            return;
        }
        this.j = -2;
        this.k = -2;
        Arrays.fill(this.f30835h, 0, size(), -1);
        Arrays.fill(this.i, 0, size(), -1);
        super.clear();
    }

    @Override // com.google.common.collect.CompactHashSet
    public int firstEntryIndex() {
        return this.j;
    }

    @Override // com.google.common.collect.CompactHashSet
    public int getSuccessor(int i) {
        return this.i[i];
    }

    @Override // com.google.common.collect.CompactHashSet
    public void init(int i) {
        super.init(i);
        this.j = -2;
        this.k = -2;
    }

    @Override // com.google.common.collect.CompactHashSet
    public void insertEntry(int i, E e2, int i2) {
        super.insertEntry(i, e2, i2);
        l(this.k, i);
        l(i, -2);
    }

    public final int j(int i) {
        return this.f30835h[i];
    }

    public final void k(int i, int i2) {
        this.f30835h[i] = i2;
    }

    public final void l(int i, int i2) {
        if (i == -2) {
            this.j = i2;
        } else {
            m(i, i2);
        }
        if (i2 == -2) {
            this.k = i;
        } else {
            k(i2, i);
        }
    }

    public final void m(int i, int i2) {
        this.i[i] = i2;
    }

    @Override // com.google.common.collect.CompactHashSet
    public void moveLastEntry(int i) {
        int size = size() - 1;
        super.moveLastEntry(i);
        l(j(i), getSuccessor(i));
        if (i < size) {
            l(j(size), i);
            l(i, getSuccessor(size));
        }
        this.f30835h[size] = -1;
        this.i[size] = -1;
    }

    @Override // com.google.common.collect.CompactHashSet
    public void resizeEntries(int i) {
        super.resizeEntries(i);
        int[] iArr = this.f30835h;
        int length = iArr.length;
        this.f30835h = Arrays.copyOf(iArr, i);
        this.i = Arrays.copyOf(this.i, i);
        if (length < i) {
            Arrays.fill(this.f30835h, length, i, -1);
            Arrays.fill(this.i, length, i, -1);
        }
    }

    @Override // com.google.common.collect.CompactHashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray() {
        return j0.f(this);
    }

    public CompactLinkedHashSet(int i) {
        super(i);
    }

    public static <E> CompactLinkedHashSet<E> create(Collection<? extends E> collection) {
        CompactLinkedHashSet<E> createWithExpectedSize = createWithExpectedSize(collection.size());
        createWithExpectedSize.addAll(collection);
        return createWithExpectedSize;
    }

    @Override // com.google.common.collect.CompactHashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        return (T[]) j0.g(this, tArr);
    }

    public static <E> CompactLinkedHashSet<E> create(E... eArr) {
        CompactLinkedHashSet<E> createWithExpectedSize = createWithExpectedSize(eArr.length);
        Collections.addAll(createWithExpectedSize, eArr);
        return createWithExpectedSize;
    }
}
