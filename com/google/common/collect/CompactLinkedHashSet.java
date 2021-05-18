package com.google.common.collect;

import d.g.c.c.j0;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
/* loaded from: classes6.dex */
public class CompactLinkedHashSet<E> extends CompactHashSet<E> {

    /* renamed from: h  reason: collision with root package name */
    public transient int[] f31036h;

    /* renamed from: i  reason: collision with root package name */
    public transient int[] f31037i;
    public transient int j;
    public transient int k;

    public CompactLinkedHashSet() {
    }

    public static <E> CompactLinkedHashSet<E> create() {
        return new CompactLinkedHashSet<>();
    }

    public static <E> CompactLinkedHashSet<E> createWithExpectedSize(int i2) {
        return new CompactLinkedHashSet<>(i2);
    }

    @Override // com.google.common.collect.CompactHashSet
    public int adjustAfterRemove(int i2, int i3) {
        return i2 >= size() ? i3 : i2;
    }

    @Override // com.google.common.collect.CompactHashSet
    public void allocArrays() {
        super.allocArrays();
        int length = this.elements.length;
        int[] iArr = new int[length];
        this.f31036h = iArr;
        this.f31037i = new int[length];
        Arrays.fill(iArr, -1);
        Arrays.fill(this.f31037i, -1);
    }

    @Override // com.google.common.collect.CompactHashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        if (needsAllocArrays()) {
            return;
        }
        this.j = -2;
        this.k = -2;
        Arrays.fill(this.f31036h, 0, size(), -1);
        Arrays.fill(this.f31037i, 0, size(), -1);
        super.clear();
    }

    @Override // com.google.common.collect.CompactHashSet
    public int firstEntryIndex() {
        return this.j;
    }

    @Override // com.google.common.collect.CompactHashSet
    public int getSuccessor(int i2) {
        return this.f31037i[i2];
    }

    @Override // com.google.common.collect.CompactHashSet
    public void init(int i2) {
        super.init(i2);
        this.j = -2;
        this.k = -2;
    }

    @Override // com.google.common.collect.CompactHashSet
    public void insertEntry(int i2, E e2, int i3) {
        super.insertEntry(i2, e2, i3);
        l(this.k, i2);
        l(i2, -2);
    }

    public final int j(int i2) {
        return this.f31036h[i2];
    }

    public final void k(int i2, int i3) {
        this.f31036h[i2] = i3;
    }

    public final void l(int i2, int i3) {
        if (i2 == -2) {
            this.j = i3;
        } else {
            m(i2, i3);
        }
        if (i3 == -2) {
            this.k = i2;
        } else {
            k(i3, i2);
        }
    }

    public final void m(int i2, int i3) {
        this.f31037i[i2] = i3;
    }

    @Override // com.google.common.collect.CompactHashSet
    public void moveLastEntry(int i2) {
        int size = size() - 1;
        super.moveLastEntry(i2);
        l(j(i2), getSuccessor(i2));
        if (i2 < size) {
            l(j(size), i2);
            l(i2, getSuccessor(size));
        }
        this.f31036h[size] = -1;
        this.f31037i[size] = -1;
    }

    @Override // com.google.common.collect.CompactHashSet
    public void resizeEntries(int i2) {
        super.resizeEntries(i2);
        int[] iArr = this.f31036h;
        int length = iArr.length;
        this.f31036h = Arrays.copyOf(iArr, i2);
        this.f31037i = Arrays.copyOf(this.f31037i, i2);
        if (length < i2) {
            Arrays.fill(this.f31036h, length, i2, -1);
            Arrays.fill(this.f31037i, length, i2, -1);
        }
    }

    @Override // com.google.common.collect.CompactHashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray() {
        return j0.f(this);
    }

    public CompactLinkedHashSet(int i2) {
        super(i2);
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
