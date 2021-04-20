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
    public transient int[] f30733e;
    public transient Object[] elements;

    /* renamed from: f  reason: collision with root package name */
    public transient long[] f30734f;

    /* renamed from: g  reason: collision with root package name */
    public transient int f30735g;
    public transient int modCount;

    /* loaded from: classes6.dex */
    public class a implements Iterator<E> {

        /* renamed from: e  reason: collision with root package name */
        public int f30736e;

        /* renamed from: f  reason: collision with root package name */
        public int f30737f;

        /* renamed from: g  reason: collision with root package name */
        public int f30738g;

        public a() {
            CompactHashSet compactHashSet = CompactHashSet.this;
            this.f30736e = compactHashSet.modCount;
            this.f30737f = compactHashSet.firstEntryIndex();
            this.f30738g = -1;
        }

        public final void a() {
            if (CompactHashSet.this.modCount != this.f30736e) {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f30737f >= 0;
        }

        @Override // java.util.Iterator
        public E next() {
            a();
            if (hasNext()) {
                int i = this.f30737f;
                this.f30738g = i;
                CompactHashSet compactHashSet = CompactHashSet.this;
                E e2 = (E) compactHashSet.elements[i];
                this.f30737f = compactHashSet.getSuccessor(i);
                return e2;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            a();
            m.e(this.f30738g >= 0);
            this.f30736e++;
            CompactHashSet compactHashSet = CompactHashSet.this;
            compactHashSet.f(compactHashSet.elements[this.f30738g], CompactHashSet.a(compactHashSet.f30734f[this.f30738g]));
            this.f30737f = CompactHashSet.this.adjustAfterRemove(this.f30737f, this.f30738g);
            this.f30738g = -1;
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

    public static <E> CompactHashSet<E> createWithExpectedSize(int i) {
        return new CompactHashSet<>(i);
    }

    public static long[] d(int i) {
        long[] jArr = new long[i];
        Arrays.fill(jArr, -1L);
        return jArr;
    }

    public static int[] e(int i) {
        int[] iArr = new int[i];
        Arrays.fill(iArr, -1);
        return iArr;
    }

    public static long i(long j, int i) {
        return (j & (-4294967296L)) | (i & 4294967295L);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.google.common.collect.CompactHashSet<E> */
    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int readInt = objectInputStream.readInt();
        if (readInt >= 0) {
            init(readInt);
            for (int i = 0; i < readInt; i++) {
                add(objectInputStream.readObject());
            }
            return;
        }
        throw new InvalidObjectException("Invalid size: " + readInt);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.f30735g);
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
        long[] jArr = this.f30734f;
        Object[] objArr = this.elements;
        int d2 = e0.d(e2);
        int c2 = c() & d2;
        int i = this.f30735g;
        int[] iArr = this.f30733e;
        int i2 = iArr[c2];
        if (i2 == -1) {
            iArr[c2] = i;
        } else {
            while (true) {
                long j = jArr[i2];
                if (a(j) == d2 && k.a(e2, objArr[i2])) {
                    return false;
                }
                int b2 = b(j);
                if (b2 == -1) {
                    jArr[i2] = i(j, i);
                    break;
                }
                i2 = b2;
            }
        }
        if (i != Integer.MAX_VALUE) {
            int i3 = i + 1;
            g(i3);
            insertEntry(i, e2, d2);
            this.f30735g = i3;
            int length = this.f30733e.length;
            if (e0.b(i, length, 1.0d)) {
                h(length * 2);
            }
            this.modCount++;
            return true;
        }
        throw new IllegalStateException("Cannot contain more than Integer.MAX_VALUE elements!");
    }

    public int adjustAfterRemove(int i, int i2) {
        return i - 1;
    }

    public void allocArrays() {
        n.x(needsAllocArrays(), "Arrays already allocated");
        int i = this.modCount;
        this.f30733e = e(e0.a(i, 1.0d));
        this.f30734f = d(i);
        this.elements = new Object[i];
    }

    public final int c() {
        return this.f30733e.length - 1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        if (needsAllocArrays()) {
            return;
        }
        this.modCount++;
        Arrays.fill(this.elements, 0, this.f30735g, (Object) null);
        Arrays.fill(this.f30733e, -1);
        Arrays.fill(this.f30734f, 0, this.f30735g, -1L);
        this.f30735g = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        if (needsAllocArrays()) {
            return false;
        }
        int d2 = e0.d(obj);
        int i = this.f30733e[c() & d2];
        while (i != -1) {
            long j = this.f30734f[i];
            if (a(j) == d2 && k.a(obj, this.elements[i])) {
                return true;
            }
            i = b(j);
        }
        return false;
    }

    public final boolean f(Object obj, int i) {
        int c2 = c() & i;
        int i2 = this.f30733e[c2];
        if (i2 == -1) {
            return false;
        }
        int i3 = -1;
        while (true) {
            if (a(this.f30734f[i2]) == i && k.a(obj, this.elements[i2])) {
                if (i3 == -1) {
                    this.f30733e[c2] = b(this.f30734f[i2]);
                } else {
                    long[] jArr = this.f30734f;
                    jArr[i3] = i(jArr[i3], b(jArr[i2]));
                }
                moveLastEntry(i2);
                this.f30735g--;
                this.modCount++;
                return true;
            }
            int b2 = b(this.f30734f[i2]);
            if (b2 == -1) {
                return false;
            }
            i3 = i2;
            i2 = b2;
        }
    }

    public int firstEntryIndex() {
        return isEmpty() ? -1 : 0;
    }

    public final void g(int i) {
        int length = this.f30734f.length;
        if (i > length) {
            int max = Math.max(1, length >>> 1) + length;
            if (max < 0) {
                max = Integer.MAX_VALUE;
            }
            if (max != length) {
                resizeEntries(max);
            }
        }
    }

    public int getSuccessor(int i) {
        int i2 = i + 1;
        if (i2 < this.f30735g) {
            return i2;
        }
        return -1;
    }

    public final void h(int i) {
        int[] e2 = e(i);
        long[] jArr = this.f30734f;
        int length = e2.length - 1;
        for (int i2 = 0; i2 < this.f30735g; i2++) {
            int a2 = a(jArr[i2]);
            int i3 = a2 & length;
            int i4 = e2[i3];
            e2[i3] = i2;
            jArr[i2] = (a2 << 32) | (i4 & 4294967295L);
        }
        this.f30733e = e2;
    }

    public void init(int i) {
        n.e(i >= 0, "Initial capacity must be non-negative");
        this.modCount = Math.max(1, i);
    }

    public void insertEntry(int i, E e2, int i2) {
        this.f30734f[i] = (i2 << 32) | 4294967295L;
        this.elements[i] = e2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f30735g == 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return new a();
    }

    public void moveLastEntry(int i) {
        int size = size() - 1;
        if (i < size) {
            Object[] objArr = this.elements;
            objArr[i] = objArr[size];
            objArr[size] = null;
            long[] jArr = this.f30734f;
            long j = jArr[size];
            jArr[i] = j;
            jArr[size] = -1;
            int a2 = a(j) & c();
            int[] iArr = this.f30733e;
            int i2 = iArr[a2];
            if (i2 == size) {
                iArr[a2] = i;
                return;
            }
            while (true) {
                long j2 = this.f30734f[i2];
                int b2 = b(j2);
                if (b2 == size) {
                    this.f30734f[i2] = i(j2, i);
                    return;
                }
                i2 = b2;
            }
        } else {
            this.elements[i] = null;
            this.f30734f[i] = -1;
        }
    }

    public boolean needsAllocArrays() {
        return this.f30733e == null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        if (needsAllocArrays()) {
            return false;
        }
        return f(obj, e0.d(obj));
    }

    public void resizeEntries(int i) {
        this.elements = Arrays.copyOf(this.elements, i);
        long[] jArr = this.f30734f;
        int length = jArr.length;
        long[] copyOf = Arrays.copyOf(jArr, i);
        if (i > length) {
            Arrays.fill(copyOf, length, i, -1L);
        }
        this.f30734f = copyOf;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.f30735g;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray() {
        return needsAllocArrays() ? new Object[0] : Arrays.copyOf(this.elements, this.f30735g);
    }

    public void trimToSize() {
        if (needsAllocArrays()) {
            return;
        }
        int i = this.f30735g;
        if (i < this.f30734f.length) {
            resizeEntries(i);
        }
        int a2 = e0.a(i, 1.0d);
        if (a2 < this.f30733e.length) {
            h(a2);
        }
    }

    public static <E> CompactHashSet<E> create(Collection<? extends E> collection) {
        CompactHashSet<E> createWithExpectedSize = createWithExpectedSize(collection.size());
        createWithExpectedSize.addAll(collection);
        return createWithExpectedSize;
    }

    public CompactHashSet(int i) {
        init(i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        if (needsAllocArrays()) {
            if (tArr.length > 0) {
                tArr[0] = null;
            }
            return tArr;
        }
        return (T[]) j0.h(this.elements, 0, this.f30735g, tArr);
    }

    public static <E> CompactHashSet<E> create(E... eArr) {
        CompactHashSet<E> createWithExpectedSize = createWithExpectedSize(eArr.length);
        Collections.addAll(createWithExpectedSize, eArr);
        return createWithExpectedSize;
    }
}
