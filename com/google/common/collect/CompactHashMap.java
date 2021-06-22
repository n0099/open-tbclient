package com.google.common.collect;

import d.g.c.a.k;
import d.g.c.a.n;
import d.g.c.c.e0;
import d.g.c.c.m;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
/* loaded from: classes6.dex */
public class CompactHashMap<K, V> extends AbstractMap<K, V> implements Serializable {
    public static final int DEFAULT_SIZE = 3;
    public static final int UNSET = -1;

    /* renamed from: e  reason: collision with root package name */
    public transient int[] f31129e;
    public transient long[] entries;

    /* renamed from: f  reason: collision with root package name */
    public transient int f31130f;

    /* renamed from: g  reason: collision with root package name */
    public transient Set<K> f31131g;

    /* renamed from: h  reason: collision with root package name */
    public transient Set<Map.Entry<K, V>> f31132h;

    /* renamed from: i  reason: collision with root package name */
    public transient Collection<V> f31133i;
    public transient Object[] keys;
    public transient int modCount;
    public transient Object[] values;

    /* loaded from: classes6.dex */
    public class a extends CompactHashMap<K, V>.e<K> {
        public a() {
            super(CompactHashMap.this, null);
        }

        @Override // com.google.common.collect.CompactHashMap.e
        public K b(int i2) {
            return (K) CompactHashMap.this.keys[i2];
        }
    }

    /* loaded from: classes6.dex */
    public class b extends CompactHashMap<K, V>.e<Map.Entry<K, V>> {
        public b() {
            super(CompactHashMap.this, null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.CompactHashMap.e
        /* renamed from: c */
        public Map.Entry<K, V> b(int i2) {
            return new g(i2);
        }
    }

    /* loaded from: classes6.dex */
    public class c extends CompactHashMap<K, V>.e<V> {
        public c() {
            super(CompactHashMap.this, null);
        }

        @Override // com.google.common.collect.CompactHashMap.e
        public V b(int i2) {
            return (V) CompactHashMap.this.values[i2];
        }
    }

    /* loaded from: classes6.dex */
    public class d extends AbstractSet<Map.Entry<K, V>> {
        public d() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            CompactHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                int d2 = CompactHashMap.this.d(entry.getKey());
                return d2 != -1 && k.a(CompactHashMap.this.values[d2], entry.getValue());
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return CompactHashMap.this.entrySetIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                int d2 = CompactHashMap.this.d(entry.getKey());
                if (d2 == -1 || !k.a(CompactHashMap.this.values[d2], entry.getValue())) {
                    return false;
                }
                CompactHashMap.this.h(d2);
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return CompactHashMap.this.f31130f;
        }
    }

    /* loaded from: classes6.dex */
    public class f extends AbstractSet<K> {
        public f() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            CompactHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return CompactHashMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return CompactHashMap.this.keySetIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            int d2 = CompactHashMap.this.d(obj);
            if (d2 == -1) {
                return false;
            }
            CompactHashMap.this.h(d2);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return CompactHashMap.this.f31130f;
        }
    }

    /* loaded from: classes6.dex */
    public final class g extends d.g.c.c.b<K, V> {

        /* renamed from: e  reason: collision with root package name */
        public final K f31143e;

        /* renamed from: f  reason: collision with root package name */
        public int f31144f;

        public g(int i2) {
            this.f31143e = (K) CompactHashMap.this.keys[i2];
            this.f31144f = i2;
        }

        public final void a() {
            int i2 = this.f31144f;
            if (i2 == -1 || i2 >= CompactHashMap.this.size() || !k.a(this.f31143e, CompactHashMap.this.keys[this.f31144f])) {
                this.f31144f = CompactHashMap.this.d(this.f31143e);
            }
        }

        @Override // d.g.c.c.b, java.util.Map.Entry
        public K getKey() {
            return this.f31143e;
        }

        @Override // d.g.c.c.b, java.util.Map.Entry
        public V getValue() {
            a();
            int i2 = this.f31144f;
            if (i2 == -1) {
                return null;
            }
            return (V) CompactHashMap.this.values[i2];
        }

        @Override // d.g.c.c.b, java.util.Map.Entry
        public V setValue(V v) {
            a();
            int i2 = this.f31144f;
            if (i2 == -1) {
                CompactHashMap.this.put(this.f31143e, v);
                return null;
            }
            Object[] objArr = CompactHashMap.this.values;
            V v2 = (V) objArr[i2];
            objArr[i2] = v;
            return v2;
        }
    }

    /* loaded from: classes6.dex */
    public class h extends AbstractCollection<V> {
        public h() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            CompactHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return CompactHashMap.this.valuesIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return CompactHashMap.this.f31130f;
        }
    }

    public CompactHashMap() {
        init(3);
    }

    public static int a(long j) {
        return (int) (j >>> 32);
    }

    public static int b(long j) {
        return (int) j;
    }

    public static <K, V> CompactHashMap<K, V> create() {
        return new CompactHashMap<>();
    }

    public static <K, V> CompactHashMap<K, V> createWithExpectedSize(int i2) {
        return new CompactHashMap<>(i2);
    }

    public static long[] e(int i2) {
        long[] jArr = new long[i2];
        Arrays.fill(jArr, -1L);
        return jArr;
    }

    public static int[] f(int i2) {
        int[] iArr = new int[i2];
        Arrays.fill(iArr, -1);
        return iArr;
    }

    public static long k(long j, int i2) {
        return (j & (-4294967296L)) | (i2 & 4294967295L);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.google.common.collect.CompactHashMap<K, V> */
    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int readInt = objectInputStream.readInt();
        if (readInt >= 0) {
            init(readInt);
            for (int i2 = 0; i2 < readInt; i2++) {
                put(objectInputStream.readObject(), objectInputStream.readObject());
            }
            return;
        }
        throw new InvalidObjectException("Invalid size: " + readInt);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.f31130f);
        int firstEntryIndex = firstEntryIndex();
        while (firstEntryIndex >= 0) {
            objectOutputStream.writeObject(this.keys[firstEntryIndex]);
            objectOutputStream.writeObject(this.values[firstEntryIndex]);
            firstEntryIndex = getSuccessor(firstEntryIndex);
        }
    }

    public void accessEntry(int i2) {
    }

    public int adjustAfterRemove(int i2, int i3) {
        return i2 - 1;
    }

    public void allocArrays() {
        n.x(needsAllocArrays(), "Arrays already allocated");
        int i2 = this.modCount;
        this.f31129e = f(e0.a(i2, 1.0d));
        this.entries = e(i2);
        this.keys = new Object[i2];
        this.values = new Object[i2];
    }

    public final int c() {
        return this.f31129e.length - 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        if (needsAllocArrays()) {
            return;
        }
        this.modCount++;
        Arrays.fill(this.keys, 0, this.f31130f, (Object) null);
        Arrays.fill(this.values, 0, this.f31130f, (Object) null);
        Arrays.fill(this.f31129e, -1);
        Arrays.fill(this.entries, 0, this.f31130f, -1L);
        this.f31130f = 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return d(obj) != -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        for (int i2 = 0; i2 < this.f31130f; i2++) {
            if (k.a(obj, this.values[i2])) {
                return true;
            }
        }
        return false;
    }

    public Set<Map.Entry<K, V>> createEntrySet() {
        return new d();
    }

    public Set<K> createKeySet() {
        return new f();
    }

    public Collection<V> createValues() {
        return new h();
    }

    public final int d(Object obj) {
        if (needsAllocArrays()) {
            return -1;
        }
        int d2 = e0.d(obj);
        int i2 = this.f31129e[c() & d2];
        while (i2 != -1) {
            long j = this.entries[i2];
            if (a(j) == d2 && k.a(obj, this.keys[i2])) {
                return i2;
            }
            i2 = b(j);
        }
        return -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.f31132h;
        if (set == null) {
            Set<Map.Entry<K, V>> createEntrySet = createEntrySet();
            this.f31132h = createEntrySet;
            return createEntrySet;
        }
        return set;
    }

    public Iterator<Map.Entry<K, V>> entrySetIterator() {
        return new b();
    }

    public int firstEntryIndex() {
        return isEmpty() ? -1 : 0;
    }

    public final V g(Object obj, int i2) {
        int c2 = c() & i2;
        int i3 = this.f31129e[c2];
        if (i3 == -1) {
            return null;
        }
        int i4 = -1;
        while (true) {
            if (a(this.entries[i3]) == i2 && k.a(obj, this.keys[i3])) {
                V v = (V) this.values[i3];
                if (i4 == -1) {
                    this.f31129e[c2] = b(this.entries[i3]);
                } else {
                    long[] jArr = this.entries;
                    jArr[i4] = k(jArr[i4], b(jArr[i3]));
                }
                moveLastEntry(i3);
                this.f31130f--;
                this.modCount++;
                return v;
            }
            int b2 = b(this.entries[i3]);
            if (b2 == -1) {
                return null;
            }
            i4 = i3;
            i3 = b2;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        int d2 = d(obj);
        accessEntry(d2);
        if (d2 == -1) {
            return null;
        }
        return (V) this.values[d2];
    }

    public int getSuccessor(int i2) {
        int i3 = i2 + 1;
        if (i3 < this.f31130f) {
            return i3;
        }
        return -1;
    }

    public final V h(int i2) {
        return g(this.keys[i2], a(this.entries[i2]));
    }

    public final void i(int i2) {
        int length = this.entries.length;
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

    public void init(int i2) {
        n.e(i2 >= 0, "Expected size must be non-negative");
        this.modCount = Math.max(1, i2);
    }

    public void insertEntry(int i2, K k, V v, int i3) {
        this.entries[i2] = (i3 << 32) | 4294967295L;
        this.keys[i2] = k;
        this.values[i2] = v;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        return this.f31130f == 0;
    }

    public final void j(int i2) {
        int[] f2 = f(i2);
        long[] jArr = this.entries;
        int length = f2.length - 1;
        for (int i3 = 0; i3 < this.f31130f; i3++) {
            int a2 = a(jArr[i3]);
            int i4 = a2 & length;
            int i5 = f2[i4];
            f2[i4] = i3;
            jArr[i3] = (a2 << 32) | (i5 & 4294967295L);
        }
        this.f31129e = f2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.f31131g;
        if (set == null) {
            Set<K> createKeySet = createKeySet();
            this.f31131g = createKeySet;
            return createKeySet;
        }
        return set;
    }

    public Iterator<K> keySetIterator() {
        return new a();
    }

    public void moveLastEntry(int i2) {
        int size = size() - 1;
        if (i2 < size) {
            Object[] objArr = this.keys;
            objArr[i2] = objArr[size];
            Object[] objArr2 = this.values;
            objArr2[i2] = objArr2[size];
            objArr[size] = null;
            objArr2[size] = null;
            long[] jArr = this.entries;
            long j = jArr[size];
            jArr[i2] = j;
            jArr[size] = -1;
            int a2 = a(j) & c();
            int[] iArr = this.f31129e;
            int i3 = iArr[a2];
            if (i3 == size) {
                iArr[a2] = i2;
                return;
            }
            while (true) {
                long j2 = this.entries[i3];
                int b2 = b(j2);
                if (b2 == size) {
                    this.entries[i3] = k(j2, i2);
                    return;
                }
                i3 = b2;
            }
        } else {
            this.keys[i2] = null;
            this.values[i2] = null;
            this.entries[i2] = -1;
        }
    }

    public boolean needsAllocArrays() {
        return this.f31129e == null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k, V v) {
        if (needsAllocArrays()) {
            allocArrays();
        }
        long[] jArr = this.entries;
        Object[] objArr = this.keys;
        Object[] objArr2 = this.values;
        int d2 = e0.d(k);
        int c2 = c() & d2;
        int i2 = this.f31130f;
        int[] iArr = this.f31129e;
        int i3 = iArr[c2];
        if (i3 == -1) {
            iArr[c2] = i2;
        } else {
            while (true) {
                long j = jArr[i3];
                if (a(j) == d2 && k.a(k, objArr[i3])) {
                    V v2 = (V) objArr2[i3];
                    objArr2[i3] = v;
                    accessEntry(i3);
                    return v2;
                }
                int b2 = b(j);
                if (b2 == -1) {
                    jArr[i3] = k(j, i2);
                    break;
                }
                i3 = b2;
            }
        }
        if (i2 != Integer.MAX_VALUE) {
            int i4 = i2 + 1;
            i(i4);
            insertEntry(i2, k, v, d2);
            this.f31130f = i4;
            int length = this.f31129e.length;
            if (e0.b(i2, length, 1.0d)) {
                j(length * 2);
            }
            this.modCount++;
            return null;
        }
        throw new IllegalStateException("Cannot contain more than Integer.MAX_VALUE elements!");
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        if (needsAllocArrays()) {
            return null;
        }
        return g(obj, e0.d(obj));
    }

    public void resizeEntries(int i2) {
        this.keys = Arrays.copyOf(this.keys, i2);
        this.values = Arrays.copyOf(this.values, i2);
        long[] jArr = this.entries;
        int length = jArr.length;
        long[] copyOf = Arrays.copyOf(jArr, i2);
        if (i2 > length) {
            Arrays.fill(copyOf, length, i2, -1L);
        }
        this.entries = copyOf;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f31130f;
    }

    public void trimToSize() {
        if (needsAllocArrays()) {
            return;
        }
        int i2 = this.f31130f;
        if (i2 < this.entries.length) {
            resizeEntries(i2);
        }
        int a2 = e0.a(i2, 1.0d);
        if (a2 < this.f31129e.length) {
            j(a2);
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> collection = this.f31133i;
        if (collection == null) {
            Collection<V> createValues = createValues();
            this.f31133i = createValues;
            return createValues;
        }
        return collection;
    }

    public Iterator<V> valuesIterator() {
        return new c();
    }

    public CompactHashMap(int i2) {
        init(i2);
    }

    /* loaded from: classes6.dex */
    public abstract class e<T> implements Iterator<T> {

        /* renamed from: e  reason: collision with root package name */
        public int f31138e;

        /* renamed from: f  reason: collision with root package name */
        public int f31139f;

        /* renamed from: g  reason: collision with root package name */
        public int f31140g;

        public e() {
            CompactHashMap compactHashMap = CompactHashMap.this;
            this.f31138e = compactHashMap.modCount;
            this.f31139f = compactHashMap.firstEntryIndex();
            this.f31140g = -1;
        }

        public final void a() {
            if (CompactHashMap.this.modCount != this.f31138e) {
                throw new ConcurrentModificationException();
            }
        }

        public abstract T b(int i2);

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f31139f >= 0;
        }

        @Override // java.util.Iterator
        public T next() {
            a();
            if (hasNext()) {
                int i2 = this.f31139f;
                this.f31140g = i2;
                T b2 = b(i2);
                this.f31139f = CompactHashMap.this.getSuccessor(this.f31139f);
                return b2;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            a();
            m.e(this.f31140g >= 0);
            this.f31138e++;
            CompactHashMap.this.h(this.f31140g);
            this.f31139f = CompactHashMap.this.adjustAfterRemove(this.f31139f, this.f31140g);
            this.f31140g = -1;
        }

        public /* synthetic */ e(CompactHashMap compactHashMap, a aVar) {
            this();
        }
    }
}
