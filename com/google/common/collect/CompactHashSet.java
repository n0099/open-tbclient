package com.google.common.collect;

import d.g.c.a.k;
import d.g.c.a.n;
import d.g.c.c.e0;
import d.g.c.c.j0;
import d.g.c.c.m;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
/* loaded from: classes6.dex */
public class CompactHashSet<E> extends AbstractSet<E> implements Serializable {
    public static final int DEFAULT_SIZE = 3;
    public static final int UNSET = -1;

    /* renamed from: e  reason: collision with root package name */
    public transient int[] f31029e;
    public transient Object[] elements;

    /* renamed from: f  reason: collision with root package name */
    public transient long[] f31030f;

    /* renamed from: g  reason: collision with root package name */
    public transient int f31031g;
    public transient int modCount;

    /* loaded from: classes6.dex */
    public class a implements Iterator<E> {

        /* renamed from: e  reason: collision with root package name */
        public int f31032e;

        /* renamed from: f  reason: collision with root package name */
        public int f31033f;

        /* renamed from: g  reason: collision with root package name */
        public int f31034g;

        public a() {
            CompactHashSet compactHashSet = CompactHashSet.this;
            this.f31032e = compactHashSet.modCount;
            this.f31033f = compactHashSet.firstEntryIndex();
            this.f31034g = -1;
        }

        public final void a() {
            if (CompactHashSet.this.modCount != this.f31032e) {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f31033f >= 0;
        }

        @Override // java.util.Iterator
        public E next() {
            a();
            if (hasNext()) {
                int i2 = this.f31033f;
                this.f31034g = i2;
                CompactHashSet compactHashSet = CompactHashSet.this;
                E e2 = (E) compactHashSet.elements[i2];
                this.f31033f = compactHashSet.getSuccessor(i2);
                return e2;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            a();
            m.e(this.f31034g >= 0);
            this.f31032e++;
            CompactHashSet compactHashSet = CompactHashSet.this;
            compactHashSet.f(compactHashSet.elements[this.f31034g], CompactHashSet.a(compactHashSet.f31030f[this.f31034g]));
            this.f31033f = CompactHashSet.this.adjustAfterRemove(this.f31033f, this.f31034g);
            this.f31034g = -1;
        }
    }

    public CompactHashSet() {
        init(3);
    }

    public static int a(long j) {
        return (int) (j >>> 32);
    }

    public static int b(long j) {
        return (int) j;
    }

    public static <E> CompactHashSet<E> create() {
        return new CompactHashSet<>();
    }

    public static <E> CompactHashSet<E> createWithExpectedSize(int i2) {
        return new CompactHashSet<>(i2);
    }

    public static long[] d(int i2) {
        long[] jArr = new long[i2];
        Arrays.fill(jArr, -1L);
        return jArr;
    }

    public static int[] e(int i2) {
        int[] iArr = new int[i2];
        Arrays.fill(iArr, -1);
        return iArr;
    }

    public static long i(long j, int i2) {
        return (j & (-4294967296L)) | (i2 & 4294967295L);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.google.common.collect.CompactHashSet<E> */
    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int readInt = objectInputStream.readInt();
        if (readInt >= 0) {
            init(readInt);
            for (int i2 = 0; i2 < readInt; i2++) {
                add(objectInputStream.readObject());
            }
            return;
        }
        throw new InvalidObjectException("Invalid size: " + readInt);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.f31031g);
        int firstEntryIndex = firstEntryIndex();
        while (firstEntryIndex >= 0) {
            objectOutputStream.writeObject(this.elements[firstEntryIndex]);
            firstEntryIndex = getSuccessor(firstEntryIndex);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(E e2) {
        if (needsAllocArrays()) {
            allocArrays();
        }
        long[] jArr = this.f31030f;
        Object[] objArr = this.elements;
        int d2 = e0.d(e2);
        int c2 = c() & d2;
        int i2 = this.f31031g;
        int[] iArr = this.f31029e;
        int i3 = iArr[c2];
        if (i3 == -1) {
            iArr[c2] = i2;
        } else {
            while (true) {
                long j = jArr[i3];
                if (a(j) == d2 && k.a(e2, objArr[i3])) {
                    return false;
                }
                int b2 = b(j);
                if (b2 == -1) {
                    jArr[i3] = i(j, i2);
                    break;
                }
                i3 = b2;
            }
        }
        if (i2 != Integer.MAX_VALUE) {
            int i4 = i2 + 1;
            g(i4);
            insertEntry(i2, e2, d2);
            this.f31031g = i4;
            int length = this.f31029e.length;
            if (e0.b(i2, length, 1.0d)) {
                h(length * 2);
            }
            this.modCount++;
            return true;
        }
        throw new IllegalStateException("Cannot contain more than Integer.MAX_VALUE elements!");
    }

    public int adjustAfterRemove(int i2, int i3) {
        return i2 - 1;
    }

    public void allocArrays() {
        n.x(needsAllocArrays(), "Arrays already allocated");
        int i2 = this.modCount;
        this.f31029e = e(e0.a(i2, 1.0d));
        this.f31030f = d(i2);
        this.elements = new Object[i2];
    }

    public final int c() {
        return this.f31029e.length - 1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        if (needsAllocArrays()) {
            return;
        }
        this.modCount++;
        Arrays.fill(this.elements, 0, this.f31031g, (Object) null);
        Arrays.fill(this.f31029e, -1);
        Arrays.fill(this.f31030f, 0, this.f31031g, -1L);
        this.f31031g = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        if (needsAllocArrays()) {
            return false;
        }
        int d2 = e0.d(obj);
        int i2 = this.f31029e[c() & d2];
        while (i2 != -1) {
            long j = this.f31030f[i2];
            if (a(j) == d2 && k.a(obj, this.elements[i2])) {
                return true;
            }
            i2 = b(j);
        }
        return false;
    }

    public final boolean f(Object obj, int i2) {
        int c2 = c() & i2;
        int i3 = this.f31029e[c2];
        if (i3 == -1) {
            return false;
        }
        int i4 = -1;
        while (true) {
            if (a(this.f31030f[i3]) == i2 && k.a(obj, this.elements[i3])) {
                if (i4 == -1) {
                    this.f31029e[c2] = b(this.f31030f[i3]);
                } else {
                    long[] jArr = this.f31030f;
                    jArr[i4] = i(jArr[i4], b(jArr[i3]));
                }
                moveLastEntry(i3);
                this.f31031g--;
                this.modCount++;
                return true;
            }
            int b2 = b(this.f31030f[i3]);
            if (b2 == -1) {
                return false;
            }
            i4 = i3;
            i3 = b2;
        }
    }

    public int firstEntryIndex() {
        return isEmpty() ? -1 : 0;
    }

    public final void g(int i2) {
        int length = this.f31030f.length;
        if (i2 > length) {
            int max = Math.max(1, length >>> 1) + length;
            if (max < 0) {
                max = Integer.MAX_VALUE;
            }
            if (max != length) {
                resizeEntries(max);
            }
        }
    }

    public int getSuccessor(int i2) {
        int i3 = i2 + 1;
        if (i3 < this.f31031g) {
            return i3;
        }
        return -1;
    }

    public final void h(int i2) {
        int[] e2 = e(i2);
        long[] jArr = this.f31030f;
        int length = e2.length - 1;
        for (int i3 = 0; i3 < this.f31031g; i3++) {
            int a2 = a(jArr[i3]);
            int i4 = a2 & length;
            int i5 = e2[i4];
            e2[i4] = i3;
            jArr[i3] = (a2 << 32) | (i5 & 4294967295L);
        }
        this.f31029e = e2;
    }

    public void init(int i2) {
        n.e(i2 >= 0, "Initial capacity must be non-negative");
        this.modCount = Math.max(1, i2);
    }

    public void insertEntry(int i2, E e2, int i3) {
        this.f31030f[i2] = (i3 << 32) | 4294967295L;
        this.elements[i2] = e2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f31031g == 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return new a();
    }

    public void moveLastEntry(int i2) {
        int size = size() - 1;
        if (i2 < size) {
            Object[] objArr = this.elements;
            objArr[i2] = objArr[size];
            objArr[size] = null;
            long[] jArr = this.f31030f;
            long j = jArr[size];
            jArr[i2] = j;
            jArr[size] = -1;
            int a2 = a(j) & c();
            int[] iArr = this.f31029e;
            int i3 = iArr[a2];
            if (i3 == size) {
                iArr[a2] = i2;
                return;
            }
            while (true) {
                long j2 = this.f31030f[i3];
                int b2 = b(j2);
                if (b2 == size) {
                    this.f31030f[i3] = i(j2, i2);
                    return;
                }
                i3 = b2;
            }
        } else {
            this.elements[i2] = null;
            this.f31030f[i2] = -1;
        }
    }

    public boolean needsAllocArrays() {
        return this.f31029e == null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        if (needsAllocArrays()) {
            return false;
        }
        return f(obj, e0.d(obj));
    }

    public void resizeEntries(int i2) {
        this.elements = Arrays.copyOf(this.elements, i2);
        long[] jArr = this.f31030f;
        int length = jArr.length;
        long[] copyOf = Arrays.copyOf(jArr, i2);
        if (i2 > length) {
            Arrays.fill(copyOf, length, i2, -1L);
        }
        this.f31030f = copyOf;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.f31031g;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray() {
        return needsAllocArrays() ? new Object[0] : Arrays.copyOf(this.elements, this.f31031g);
    }

    public void trimToSize() {
        if (needsAllocArrays()) {
            return;
        }
        int i2 = this.f31031g;
        if (i2 < this.f31030f.length) {
            resizeEntries(i2);
        }
        int a2 = e0.a(i2, 1.0d);
        if (a2 < this.f31029e.length) {
            h(a2);
        }
    }

    public static <E> CompactHashSet<E> create(Collection<? extends E> collection) {
        CompactHashSet<E> createWithExpectedSize = createWithExpectedSize(collection.size());
        createWithExpectedSize.addAll(collection);
        return createWithExpectedSize;
    }

    public CompactHashSet(int i2) {
        init(i2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        if (needsAllocArrays()) {
            if (tArr.length > 0) {
                tArr[0] = null;
            }
            return tArr;
        }
        return (T[]) j0.h(this.elements, 0, this.f31031g, tArr);
    }

    public static <E> CompactHashSet<E> create(E... eArr) {
        CompactHashSet<E> createWithExpectedSize = createWithExpectedSize(eArr.length);
        Collections.addAll(createWithExpectedSize, eArr);
        return createWithExpectedSize;
    }
}
