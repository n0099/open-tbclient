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

    public static <K, V> CompactLinkedHashMap<K, V> createWithExpectedSize(int i2) {
        return new CompactLinkedHashMap<>(i2);
    }

    @Override // com.google.common.collect.CompactHashMap
    public void accessEntry(int i2) {
        if (this.accessOrder) {
            n(l(i2), getSuccessor(i2));
            n(this.k, i2);
            n(i2, -2);
            this.modCount++;
        }
    }

    @Override // com.google.common.collect.CompactHashMap
    public int adjustAfterRemove(int i2, int i3) {
        return i2 >= size() ? i3 : i2;
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
    public int getSuccessor(int i2) {
        return (int) this.links[i2];
    }

    @Override // com.google.common.collect.CompactHashMap
    public void init(int i2) {
        super.init(i2);
        this.j = -2;
        this.k = -2;
    }

    @Override // com.google.common.collect.CompactHashMap
    public void insertEntry(int i2, K k, V v, int i3) {
        super.insertEntry(i2, k, v, i3);
        n(this.k, i2);
        n(i2, -2);
    }

    public final int l(int i2) {
        return (int) (this.links[i2] >>> 32);
    }

    public final void m(int i2, int i3) {
        long[] jArr = this.links;
        jArr[i2] = (jArr[i2] & 4294967295L) | (i3 << 32);
    }

    @Override // com.google.common.collect.CompactHashMap
    public void moveLastEntry(int i2) {
        int size = size() - 1;
        super.moveLastEntry(i2);
        n(l(i2), getSuccessor(i2));
        if (i2 < size) {
            n(l(size), i2);
            n(i2, getSuccessor(size));
        }
        this.links[size] = -1;
    }

    public final void n(int i2, int i3) {
        if (i2 == -2) {
            this.j = i3;
        } else {
            o(i2, i3);
        }
        if (i3 == -2) {
            this.k = i2;
        } else {
            m(i3, i2);
        }
    }

    public final void o(int i2, int i3) {
        long[] jArr = this.links;
        jArr[i2] = (jArr[i2] & (-4294967296L)) | (i3 & 4294967295L);
    }

    @Override // com.google.common.collect.CompactHashMap
    public void resizeEntries(int i2) {
        super.resizeEntries(i2);
        long[] jArr = this.links;
        int length = jArr.length;
        long[] copyOf = Arrays.copyOf(jArr, i2);
        this.links = copyOf;
        if (length < i2) {
            Arrays.fill(copyOf, length, i2, -1L);
        }
    }

    public CompactLinkedHashMap(int i2) {
        this(i2, false);
    }

    public CompactLinkedHashMap(int i2, boolean z) {
        super(i2);
        this.accessOrder = z;
    }
}
