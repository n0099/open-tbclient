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
    public transient int[] f30719e;
    public transient long[] entries;

    /* renamed from: f  reason: collision with root package name */
    public transient int f30720f;

    /* renamed from: g  reason: collision with root package name */
    public transient Set<K> f30721g;

    /* renamed from: h  reason: collision with root package name */
    public transient Set<Map.Entry<K, V>> f30722h;
    public transient Collection<V> i;
    public transient Object[] keys;
    public transient int modCount;
    public transient Object[] values;

    /* loaded from: classes6.dex */
    public class a extends CompactHashMap<K, V>.e<K> {
        public a() {
            super(CompactHashMap.this, null);
        }

        @Override // com.google.common.collect.CompactHashMap.e
        public K b(int i) {
            return (K) CompactHashMap.this.keys[i];
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
        public Map.Entry<K, V> b(int i) {
            return new g(i);
        }
    }

    /* loaded from: classes6.dex */
    public class c extends CompactHashMap<K, V>.e<V> {
        public c() {
            super(CompactHashMap.this, null);
        }

        @Override // com.google.common.collect.CompactHashMap.e
        public V b(int i) {
            return (V) CompactHashMap.this.values[i];
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
            return CompactHashMap.this.f30720f;
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
            return CompactHashMap.this.f30720f;
        }
    }

    /* loaded from: classes6.dex */
    public final class g extends d.g.c.c.b<K, V> {

        /* renamed from: e  reason: collision with root package name */
        public final K f30729e;

        /* renamed from: f  reason: collision with root package name */
        public int f30730f;

        public g(int i) {
            this.f30729e = (K) CompactHashMap.this.keys[i];
            this.f30730f = i;
        }

        public final void a() {
            int i = this.f30730f;
            if (i == -1 || i >= CompactHashMap.this.size() || !k.a(this.f30729e, CompactHashMap.this.keys[this.f30730f])) {
                this.f30730f = CompactHashMap.this.d(this.f30729e);
            }
        }

        @Override // d.g.c.c.b, java.util.Map.Entry
        public K getKey() {
            return this.f30729e;
        }

        @Override // d.g.c.c.b, java.util.Map.Entry
        public V getValue() {
            a();
            int i = this.f30730f;
            if (i == -1) {
                return null;
            }
            return (V) CompactHashMap.this.values[i];
        }

        @Override // d.g.c.c.b, java.util.Map.Entry
        public V setValue(V v) {
            a();
            int i = this.f30730f;
            if (i == -1) {
                CompactHashMap.this.put(this.f30729e, v);
                return null;
            }
            Object[] objArr = CompactHashMap.this.values;
            V v2 = (V) objArr[i];
            objArr[i] = v;
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
            return CompactHashMap.this.f30720f;
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

    public static <K, V> CompactHashMap<K, V> createWithExpectedSize(int i) {
        return new CompactHashMap<>(i);
    }

    public static long[] e(int i) {
        long[] jArr = new long[i];
        Arrays.fill(jArr, -1L);
        return jArr;
    }

    public static int[] f(int i) {
        int[] iArr = new int[i];
        Arrays.fill(iArr, -1);
        return iArr;
    }

    public static long k(long j, int i) {
        return (j & (-4294967296L)) | (i & 4294967295L);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.google.common.collect.CompactHashMap<K, V> */
    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int readInt = objectInputStream.readInt();
        if (readInt >= 0) {
            init(readInt);
            for (int i = 0; i < readInt; i++) {
                put(objectInputStream.readObject(), objectInputStream.readObject());
            }
            return;
        }
        throw new InvalidObjectException("Invalid size: " + readInt);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.f30720f);
        int firstEntryIndex = firstEntryIndex();
        while (firstEntryIndex >= 0) {
            objectOutputStream.writeObject(this.keys[firstEntryIndex]);
            objectOutputStream.writeObject(this.values[firstEntryIndex]);
            firstEntryIndex = getSuccessor(firstEntryIndex);
        }
    }

    public void accessEntry(int i) {
    }

    public int adjustAfterRemove(int i, int i2) {
        return i - 1;
    }

    public void allocArrays() {
        n.x(needsAllocArrays(), "Arrays already allocated");
        int i = this.modCount;
        this.f30719e = f(e0.a(i, 1.0d));
        this.entries = e(i);
        this.keys = new Object[i];
        this.values = new Object[i];
    }

    public final int c() {
        return this.f30719e.length - 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        if (needsAllocArrays()) {
            return;
        }
        this.modCount++;
        Arrays.fill(this.keys, 0, this.f30720f, (Object) null);
        Arrays.fill(this.values, 0, this.f30720f, (Object) null);
        Arrays.fill(this.f30719e, -1);
        Arrays.fill(this.entries, 0, this.f30720f, -1L);
        this.f30720f = 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return d(obj) != -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        for (int i = 0; i < this.f30720f; i++) {
            if (k.a(obj, this.values[i])) {
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
        int i = this.f30719e[c() & d2];
        while (i != -1) {
            long j = this.entries[i];
            if (a(j) == d2 && k.a(obj, this.keys[i])) {
                return i;
            }
            i = b(j);
        }
        return -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.f30722h;
        if (set == null) {
            Set<Map.Entry<K, V>> createEntrySet = createEntrySet();
            this.f30722h = createEntrySet;
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

    public final V g(Object obj, int i) {
        int c2 = c() & i;
        int i2 = this.f30719e[c2];
        if (i2 == -1) {
            return null;
        }
        int i3 = -1;
        while (true) {
            if (a(this.entries[i2]) == i && k.a(obj, this.keys[i2])) {
                V v = (V) this.values[i2];
                if (i3 == -1) {
                    this.f30719e[c2] = b(this.entries[i2]);
                } else {
                    long[] jArr = this.entries;
                    jArr[i3] = k(jArr[i3], b(jArr[i2]));
                }
                moveLastEntry(i2);
                this.f30720f--;
                this.modCount++;
                return v;
            }
            int b2 = b(this.entries[i2]);
            if (b2 == -1) {
                return null;
            }
            i3 = i2;
            i2 = b2;
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

    public int getSuccessor(int i) {
        int i2 = i + 1;
        if (i2 < this.f30720f) {
            return i2;
        }
        return -1;
    }

    public final V h(int i) {
        return g(this.keys[i], a(this.entries[i]));
    }

    public final void i(int i) {
        int length = this.entries.length;
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

    public void init(int i) {
        n.e(i >= 0, "Expected size must be non-negative");
        this.modCount = Math.max(1, i);
    }

    public void insertEntry(int i, K k, V v, int i2) {
        this.entries[i] = (i2 << 32) | 4294967295L;
        this.keys[i] = k;
        this.values[i] = v;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        return this.f30720f == 0;
    }

    public final void j(int i) {
        int[] f2 = f(i);
        long[] jArr = this.entries;
        int length = f2.length - 1;
        for (int i2 = 0; i2 < this.f30720f; i2++) {
            int a2 = a(jArr[i2]);
            int i3 = a2 & length;
            int i4 = f2[i3];
            f2[i3] = i2;
            jArr[i2] = (a2 << 32) | (i4 & 4294967295L);
        }
        this.f30719e = f2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.f30721g;
        if (set == null) {
            Set<K> createKeySet = createKeySet();
            this.f30721g = createKeySet;
            return createKeySet;
        }
        return set;
    }

    public Iterator<K> keySetIterator() {
        return new a();
    }

    public void moveLastEntry(int i) {
        int size = size() - 1;
        if (i < size) {
            Object[] objArr = this.keys;
            objArr[i] = objArr[size];
            Object[] objArr2 = this.values;
            objArr2[i] = objArr2[size];
            objArr[size] = null;
            objArr2[size] = null;
            long[] jArr = this.entries;
            long j = jArr[size];
            jArr[i] = j;
            jArr[size] = -1;
            int a2 = a(j) & c();
            int[] iArr = this.f30719e;
            int i2 = iArr[a2];
            if (i2 == size) {
                iArr[a2] = i;
                return;
            }
            while (true) {
                long j2 = this.entries[i2];
                int b2 = b(j2);
                if (b2 == size) {
                    this.entries[i2] = k(j2, i);
                    return;
                }
                i2 = b2;
            }
        } else {
            this.keys[i] = null;
            this.values[i] = null;
            this.entries[i] = -1;
        }
    }

    public boolean needsAllocArrays() {
        return this.f30719e == null;
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
        int i = this.f30720f;
        int[] iArr = this.f30719e;
        int i2 = iArr[c2];
        if (i2 == -1) {
            iArr[c2] = i;
        } else {
            while (true) {
                long j = jArr[i2];
                if (a(j) == d2 && k.a(k, objArr[i2])) {
                    V v2 = (V) objArr2[i2];
                    objArr2[i2] = v;
                    accessEntry(i2);
                    return v2;
                }
                int b2 = b(j);
                if (b2 == -1) {
                    jArr[i2] = k(j, i);
                    break;
                }
                i2 = b2;
            }
        }
        if (i != Integer.MAX_VALUE) {
            int i3 = i + 1;
            i(i3);
            insertEntry(i, k, v, d2);
            this.f30720f = i3;
            int length = this.f30719e.length;
            if (e0.b(i, length, 1.0d)) {
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

    public void resizeEntries(int i) {
        this.keys = Arrays.copyOf(this.keys, i);
        this.values = Arrays.copyOf(this.values, i);
        long[] jArr = this.entries;
        int length = jArr.length;
        long[] copyOf = Arrays.copyOf(jArr, i);
        if (i > length) {
            Arrays.fill(copyOf, length, i, -1L);
        }
        this.entries = copyOf;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f30720f;
    }

    public void trimToSize() {
        if (needsAllocArrays()) {
            return;
        }
        int i = this.f30720f;
        if (i < this.entries.length) {
            resizeEntries(i);
        }
        int a2 = e0.a(i, 1.0d);
        if (a2 < this.f30719e.length) {
            j(a2);
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> collection = this.i;
        if (collection == null) {
            Collection<V> createValues = createValues();
            this.i = createValues;
            return createValues;
        }
        return collection;
    }

    public Iterator<V> valuesIterator() {
        return new c();
    }

    public CompactHashMap(int i) {
        init(i);
    }

    /* loaded from: classes6.dex */
    public abstract class e<T> implements Iterator<T> {

        /* renamed from: e  reason: collision with root package name */
        public int f30724e;

        /* renamed from: f  reason: collision with root package name */
        public int f30725f;

        /* renamed from: g  reason: collision with root package name */
        public int f30726g;

        public e() {
            CompactHashMap compactHashMap = CompactHashMap.this;
            this.f30724e = compactHashMap.modCount;
            this.f30725f = compactHashMap.firstEntryIndex();
            this.f30726g = -1;
        }

        public final void a() {
            if (CompactHashMap.this.modCount != this.f30724e) {
                throw new ConcurrentModificationException();
            }
        }

        public abstract T b(int i);

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f30725f >= 0;
        }

        @Override // java.util.Iterator
        public T next() {
            a();
            if (hasNext()) {
                int i = this.f30725f;
                this.f30726g = i;
                T b2 = b(i);
                this.f30725f = CompactHashMap.this.getSuccessor(this.f30725f);
                return b2;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            a();
            m.e(this.f30726g >= 0);
            this.f30724e++;
            CompactHashMap.this.h(this.f30726g);
            this.f30725f = CompactHashMap.this.adjustAfterRemove(this.f30725f, this.f30726g);
            this.f30726g = -1;
        }

        public /* synthetic */ e(CompactHashMap compactHashMap, a aVar) {
            this();
        }
    }
}
