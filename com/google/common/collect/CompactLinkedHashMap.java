package com.google.common.collect;

import java.util.Arrays;
/* loaded from: classes6.dex */
public class CompactLinkedHashMap<K, V> extends CompactHashMap<K, V> {
    public final boolean accessOrder;
    public transient int j;
    public transient int k;
    public transient long[] links;

    public CompactLinkedHashMap() {
        this(3);
    }

    public static <K, V> CompactLinkedHashMap<K, V> create() {
        return new CompactLinkedHashMap<>();
    }

    public static <K, V> CompactLinkedHashMap<K, V> createWithExpectedSize(int i) {
        return new CompactLinkedHashMap<>(i);
    }

    @Override // com.google.common.collect.CompactHashMap
    public void accessEntry(int i) {
        if (this.accessOrder) {
            n(l(i), getSuccessor(i));
            n(this.k, i);
            n(i, -2);
            this.modCount++;
        }
    }

    @Override // com.google.common.collect.CompactHashMap
    public int adjustAfterRemove(int i, int i2) {
        return i >= size() ? i2 : i;
    }

    @Override // com.google.common.collect.CompactHashMap
    public void allocArrays() {
        super.allocArrays();
        long[] jArr = new long[this.keys.length];
        this.links = jArr;
        Arrays.fill(jArr, -1L);
    }

    @Override // com.google.common.collect.CompactHashMap, java.util.AbstractMap, java.util.Map
    public void clear() {
        if (needsAllocArrays()) {
            return;
        }
        this.j = -2;
        this.k = -2;
        Arrays.fill(this.links, 0, size(), -1L);
        super.clear();
    }

    @Override // com.google.common.collect.CompactHashMap
    public int firstEntryIndex() {
        return this.j;
    }

    @Override // com.google.common.collect.CompactHashMap
    public int getSuccessor(int i) {
        return (int) this.links[i];
    }

    @Override // com.google.common.collect.CompactHashMap
    public void init(int i) {
        super.init(i);
        this.j = -2;
        this.k = -2;
    }

    @Override // com.google.common.collect.CompactHashMap
    public void insertEntry(int i, K k, V v, int i2) {
        super.insertEntry(i, k, v, i2);
        n(this.k, i);
        n(i, -2);
    }

    public final int l(int i) {
        return (int) (this.links[i] >>> 32);
    }

    public final void m(int i, int i2) {
        long[] jArr = this.links;
        jArr[i] = (jArr[i] & 4294967295L) | (i2 << 32);
    }

    @Override // com.google.common.collect.CompactHashMap
    public void moveLastEntry(int i) {
        int size = size() - 1;
        super.moveLastEntry(i);
        n(l(i), getSuccessor(i));
        if (i < size) {
            n(l(size), i);
            n(i, getSuccessor(size));
        }
        this.links[size] = -1;
    }

    public final void n(int i, int i2) {
        if (i == -2) {
            this.j = i2;
        } else {
            o(i, i2);
        }
        if (i2 == -2) {
            this.k = i;
        } else {
            m(i2, i);
        }
    }

    public final void o(int i, int i2) {
        long[] jArr = this.links;
        jArr[i] = (jArr[i] & (-4294967296L)) | (i2 & 4294967295L);
    }

    @Override // com.google.common.collect.CompactHashMap
    public void resizeEntries(int i) {
        super.resizeEntries(i);
        long[] jArr = this.links;
        int length = jArr.length;
        long[] copyOf = Arrays.copyOf(jArr, i);
        this.links = copyOf;
        if (length < i) {
            Arrays.fill(copyOf, length, i, -1L);
        }
    }

    public CompactLinkedHashMap(int i) {
        this(i, false);
    }

    public CompactLinkedHashMap(int i, boolean z) {
        super(i);
        this.accessOrder = z;
    }
}
