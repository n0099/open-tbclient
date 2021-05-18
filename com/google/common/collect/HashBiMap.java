package com.google.common.collect;

import com.google.common.collect.ImmutableCollection;
import d.g.c.a.n;
import d.g.c.c.e0;
import d.g.c.c.k;
import d.g.c.c.m;
import d.g.c.c.r0;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
/* loaded from: classes6.dex */
public final class HashBiMap<K, V> extends AbstractMap<K, V> implements k<K, V>, Serializable {
    public static final int ABSENT = -1;
    public static final int ENDPOINT = -2;
    public transient Set<Map.Entry<K, V>> entrySet;
    public transient int firstInInsertionOrder;
    public transient int[] hashTableKToV;
    public transient int[] hashTableVToK;
    public transient k<V, K> inverse;
    public transient Set<K> keySet;
    public transient K[] keys;
    public transient int lastInInsertionOrder;
    public transient int modCount;
    public transient int[] nextInBucketKToV;
    public transient int[] nextInBucketVToK;
    public transient int[] nextInInsertionOrder;
    public transient int[] prevInInsertionOrder;
    public transient int size;
    public transient Set<V> valueSet;
    public transient V[] values;

    /* loaded from: classes6.dex */
    public static class Inverse<K, V> extends AbstractMap<V, K> implements k<V, K>, Serializable {

        /* renamed from: e  reason: collision with root package name */
        public transient Set<Map.Entry<V, K>> f31066e;
        public final HashBiMap<K, V> forward;

        public Inverse(HashBiMap<K, V> hashBiMap) {
            this.forward = hashBiMap;
        }

        private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
            objectInputStream.defaultReadObject();
            this.forward.inverse = this;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            this.forward.clear();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return this.forward.containsValue(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsValue(Object obj) {
            return this.forward.containsKey(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<V, K>> entrySet() {
            Set<Map.Entry<V, K>> set = this.f31066e;
            if (set == null) {
                d dVar = new d(this.forward);
                this.f31066e = dVar;
                return dVar;
            }
            return set;
        }

        @Override // d.g.c.c.k
        public K forcePut(V v, K k) {
            return this.forward.putInverse(v, k, true);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public K get(Object obj) {
            return this.forward.getInverse(obj);
        }

        @Override // d.g.c.c.k
        public k<K, V> inverse() {
            return this.forward;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<V> keySet() {
            return this.forward.values();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public K put(V v, K k) {
            return this.forward.putInverse(v, k, false);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public K remove(Object obj) {
            return this.forward.removeInverse(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.forward.size;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.AbstractMap, java.util.Map, d.g.c.c.k
        public Set<K> values() {
            return this.forward.keySet();
        }
    }

    /* loaded from: classes6.dex */
    public final class a extends d.g.c.c.b<K, V> {

        /* renamed from: e  reason: collision with root package name */
        public final K f31067e;

        /* renamed from: f  reason: collision with root package name */
        public int f31068f;

        public a(int i2) {
            this.f31067e = HashBiMap.this.keys[i2];
            this.f31068f = i2;
        }

        public void a() {
            int i2 = this.f31068f;
            if (i2 != -1) {
                HashBiMap hashBiMap = HashBiMap.this;
                if (i2 <= hashBiMap.size && d.g.c.a.k.a(hashBiMap.keys[i2], this.f31067e)) {
                    return;
                }
            }
            this.f31068f = HashBiMap.this.findEntryByKey(this.f31067e);
        }

        @Override // d.g.c.c.b, java.util.Map.Entry
        public K getKey() {
            return this.f31067e;
        }

        @Override // d.g.c.c.b, java.util.Map.Entry
        public V getValue() {
            a();
            int i2 = this.f31068f;
            if (i2 == -1) {
                return null;
            }
            return HashBiMap.this.values[i2];
        }

        @Override // d.g.c.c.b, java.util.Map.Entry
        public V setValue(V v) {
            a();
            int i2 = this.f31068f;
            if (i2 == -1) {
                return (V) HashBiMap.this.put(this.f31067e, v);
            }
            V v2 = HashBiMap.this.values[i2];
            if (d.g.c.a.k.a(v2, v)) {
                return v;
            }
            HashBiMap.this.replaceValueInEntry(this.f31068f, v, false);
            return v2;
        }
    }

    /* loaded from: classes6.dex */
    public static final class b<K, V> extends d.g.c.c.b<V, K> {

        /* renamed from: e  reason: collision with root package name */
        public final HashBiMap<K, V> f31070e;

        /* renamed from: f  reason: collision with root package name */
        public final V f31071f;

        /* renamed from: g  reason: collision with root package name */
        public int f31072g;

        public b(HashBiMap<K, V> hashBiMap, int i2) {
            this.f31070e = hashBiMap;
            this.f31071f = hashBiMap.values[i2];
            this.f31072g = i2;
        }

        public final void a() {
            int i2 = this.f31072g;
            if (i2 != -1) {
                HashBiMap<K, V> hashBiMap = this.f31070e;
                if (i2 <= hashBiMap.size && d.g.c.a.k.a(this.f31071f, hashBiMap.values[i2])) {
                    return;
                }
            }
            this.f31072g = this.f31070e.findEntryByValue(this.f31071f);
        }

        @Override // d.g.c.c.b, java.util.Map.Entry
        public V getKey() {
            return this.f31071f;
        }

        @Override // d.g.c.c.b, java.util.Map.Entry
        public K getValue() {
            a();
            int i2 = this.f31072g;
            if (i2 == -1) {
                return null;
            }
            return this.f31070e.keys[i2];
        }

        @Override // d.g.c.c.b, java.util.Map.Entry
        public K setValue(K k) {
            a();
            int i2 = this.f31072g;
            if (i2 == -1) {
                return this.f31070e.putInverse(this.f31071f, k, false);
            }
            K k2 = this.f31070e.keys[i2];
            if (d.g.c.a.k.a(k2, k)) {
                return k;
            }
            this.f31070e.replaceKeyInEntry(this.f31072g, k, false);
            return k2;
        }
    }

    /* loaded from: classes6.dex */
    public final class c extends g<K, V, Map.Entry<K, V>> {
        public c() {
            super(HashBiMap.this);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.HashBiMap.g
        /* renamed from: b */
        public Map.Entry<K, V> a(int i2) {
            return new a(i2);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                Object key = entry.getKey();
                Object value = entry.getValue();
                int findEntryByKey = HashBiMap.this.findEntryByKey(key);
                return findEntryByKey != -1 && d.g.c.a.k.a(value, HashBiMap.this.values[findEntryByKey]);
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                Object key = entry.getKey();
                Object value = entry.getValue();
                int d2 = e0.d(key);
                int findEntryByKey = HashBiMap.this.findEntryByKey(key, d2);
                if (findEntryByKey == -1 || !d.g.c.a.k.a(value, HashBiMap.this.values[findEntryByKey])) {
                    return false;
                }
                HashBiMap.this.removeEntryKeyHashKnown(findEntryByKey, d2);
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes6.dex */
    public static class d<K, V> extends g<K, V, Map.Entry<V, K>> {
        public d(HashBiMap<K, V> hashBiMap) {
            super(hashBiMap);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.HashBiMap.g
        /* renamed from: b */
        public Map.Entry<V, K> a(int i2) {
            return new b(this.f31076e, i2);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                Object key = entry.getKey();
                Object value = entry.getValue();
                int findEntryByValue = this.f31076e.findEntryByValue(key);
                return findEntryByValue != -1 && d.g.c.a.k.a(this.f31076e.keys[findEntryByValue], value);
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                Object key = entry.getKey();
                Object value = entry.getValue();
                int d2 = e0.d(key);
                int findEntryByValue = this.f31076e.findEntryByValue(key, d2);
                if (findEntryByValue == -1 || !d.g.c.a.k.a(this.f31076e.keys[findEntryByValue], value)) {
                    return false;
                }
                this.f31076e.removeEntryValueHashKnown(findEntryByValue, d2);
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes6.dex */
    public final class e extends g<K, V, K> {
        public e() {
            super(HashBiMap.this);
        }

        @Override // com.google.common.collect.HashBiMap.g
        public K a(int i2) {
            return HashBiMap.this.keys[i2];
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return HashBiMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            int d2 = e0.d(obj);
            int findEntryByKey = HashBiMap.this.findEntryByKey(obj, d2);
            if (findEntryByKey != -1) {
                HashBiMap.this.removeEntryKeyHashKnown(findEntryByKey, d2);
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes6.dex */
    public final class f extends g<K, V, V> {
        public f() {
            super(HashBiMap.this);
        }

        @Override // com.google.common.collect.HashBiMap.g
        public V a(int i2) {
            return HashBiMap.this.values[i2];
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return HashBiMap.this.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            int d2 = e0.d(obj);
            int findEntryByValue = HashBiMap.this.findEntryByValue(obj, d2);
            if (findEntryByValue != -1) {
                HashBiMap.this.removeEntryValueHashKnown(findEntryByValue, d2);
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes6.dex */
    public static abstract class g<K, V, T> extends AbstractSet<T> {

        /* renamed from: e  reason: collision with root package name */
        public final HashBiMap<K, V> f31076e;

        /* loaded from: classes6.dex */
        public class a implements Iterator<T> {

            /* renamed from: e  reason: collision with root package name */
            public int f31077e;

            /* renamed from: f  reason: collision with root package name */
            public int f31078f = -1;

            /* renamed from: g  reason: collision with root package name */
            public int f31079g;

            /* renamed from: h  reason: collision with root package name */
            public int f31080h;

            public a() {
                this.f31077e = g.this.f31076e.firstInInsertionOrder;
                HashBiMap<K, V> hashBiMap = g.this.f31076e;
                this.f31079g = hashBiMap.modCount;
                this.f31080h = hashBiMap.size;
            }

            public final void a() {
                if (g.this.f31076e.modCount != this.f31079g) {
                    throw new ConcurrentModificationException();
                }
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                a();
                return this.f31077e != -2 && this.f31080h > 0;
            }

            @Override // java.util.Iterator
            public T next() {
                if (hasNext()) {
                    T t = (T) g.this.a(this.f31077e);
                    this.f31078f = this.f31077e;
                    this.f31077e = g.this.f31076e.nextInInsertionOrder[this.f31077e];
                    this.f31080h--;
                    return t;
                }
                throw new NoSuchElementException();
            }

            @Override // java.util.Iterator
            public void remove() {
                a();
                m.e(this.f31078f != -1);
                g.this.f31076e.removeEntry(this.f31078f);
                if (this.f31077e == g.this.f31076e.size) {
                    this.f31077e = this.f31078f;
                }
                this.f31078f = -1;
                this.f31079g = g.this.f31076e.modCount;
            }
        }

        public g(HashBiMap<K, V> hashBiMap) {
            this.f31076e = hashBiMap;
        }

        public abstract T a(int i2);

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.f31076e.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<T> iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f31076e.size;
        }
    }

    public HashBiMap(int i2) {
        init(i2);
    }

    private int bucket(int i2) {
        return i2 & (this.hashTableKToV.length - 1);
    }

    public static <K, V> HashBiMap<K, V> create() {
        return create(16);
    }

    public static int[] createFilledWithAbsent(int i2) {
        int[] iArr = new int[i2];
        Arrays.fill(iArr, -1);
        return iArr;
    }

    private void deleteFromTableKToV(int i2, int i3) {
        n.d(i2 != -1);
        int bucket = bucket(i3);
        int[] iArr = this.hashTableKToV;
        if (iArr[bucket] == i2) {
            int[] iArr2 = this.nextInBucketKToV;
            iArr[bucket] = iArr2[i2];
            iArr2[i2] = -1;
            return;
        }
        int i4 = iArr[bucket];
        int i5 = this.nextInBucketKToV[i4];
        while (true) {
            int i6 = i5;
            int i7 = i4;
            i4 = i6;
            if (i4 == -1) {
                throw new AssertionError("Expected to find entry with key " + this.keys[i2]);
            } else if (i4 == i2) {
                int[] iArr3 = this.nextInBucketKToV;
                iArr3[i7] = iArr3[i2];
                iArr3[i2] = -1;
                return;
            } else {
                i5 = this.nextInBucketKToV[i4];
            }
        }
    }

    private void deleteFromTableVToK(int i2, int i3) {
        n.d(i2 != -1);
        int bucket = bucket(i3);
        int[] iArr = this.hashTableVToK;
        if (iArr[bucket] == i2) {
            int[] iArr2 = this.nextInBucketVToK;
            iArr[bucket] = iArr2[i2];
            iArr2[i2] = -1;
            return;
        }
        int i4 = iArr[bucket];
        int i5 = this.nextInBucketVToK[i4];
        while (true) {
            int i6 = i5;
            int i7 = i4;
            i4 = i6;
            if (i4 == -1) {
                throw new AssertionError("Expected to find entry with value " + this.values[i2]);
            } else if (i4 == i2) {
                int[] iArr3 = this.nextInBucketVToK;
                iArr3[i7] = iArr3[i2];
                iArr3[i2] = -1;
                return;
            } else {
                i5 = this.nextInBucketVToK[i4];
            }
        }
    }

    private void ensureCapacity(int i2) {
        int[] iArr = this.nextInBucketKToV;
        if (iArr.length < i2) {
            int e2 = ImmutableCollection.b.e(iArr.length, i2);
            this.keys = (K[]) Arrays.copyOf(this.keys, e2);
            this.values = (V[]) Arrays.copyOf(this.values, e2);
            this.nextInBucketKToV = expandAndFillWithAbsent(this.nextInBucketKToV, e2);
            this.nextInBucketVToK = expandAndFillWithAbsent(this.nextInBucketVToK, e2);
            this.prevInInsertionOrder = expandAndFillWithAbsent(this.prevInInsertionOrder, e2);
            this.nextInInsertionOrder = expandAndFillWithAbsent(this.nextInInsertionOrder, e2);
        }
        if (this.hashTableKToV.length < i2) {
            int a2 = e0.a(i2, 1.0d);
            this.hashTableKToV = createFilledWithAbsent(a2);
            this.hashTableVToK = createFilledWithAbsent(a2);
            for (int i3 = 0; i3 < this.size; i3++) {
                int bucket = bucket(e0.d(this.keys[i3]));
                int[] iArr2 = this.nextInBucketKToV;
                int[] iArr3 = this.hashTableKToV;
                iArr2[i3] = iArr3[bucket];
                iArr3[bucket] = i3;
                int bucket2 = bucket(e0.d(this.values[i3]));
                int[] iArr4 = this.nextInBucketVToK;
                int[] iArr5 = this.hashTableVToK;
                iArr4[i3] = iArr5[bucket2];
                iArr5[bucket2] = i3;
            }
        }
    }

    public static int[] expandAndFillWithAbsent(int[] iArr, int i2) {
        int length = iArr.length;
        int[] copyOf = Arrays.copyOf(iArr, i2);
        Arrays.fill(copyOf, length, i2, -1);
        return copyOf;
    }

    private void insertIntoTableKToV(int i2, int i3) {
        n.d(i2 != -1);
        int bucket = bucket(i3);
        int[] iArr = this.nextInBucketKToV;
        int[] iArr2 = this.hashTableKToV;
        iArr[i2] = iArr2[bucket];
        iArr2[bucket] = i2;
    }

    private void insertIntoTableVToK(int i2, int i3) {
        n.d(i2 != -1);
        int bucket = bucket(i3);
        int[] iArr = this.nextInBucketVToK;
        int[] iArr2 = this.hashTableVToK;
        iArr[i2] = iArr2[bucket];
        iArr2[bucket] = i2;
    }

    private void moveEntryToIndex(int i2, int i3) {
        int i4;
        int i5;
        if (i2 == i3) {
            return;
        }
        int i6 = this.prevInInsertionOrder[i2];
        int i7 = this.nextInInsertionOrder[i2];
        setSucceeds(i6, i3);
        setSucceeds(i3, i7);
        K[] kArr = this.keys;
        K k = kArr[i2];
        V[] vArr = this.values;
        V v = vArr[i2];
        kArr[i3] = k;
        vArr[i3] = v;
        int bucket = bucket(e0.d(k));
        int[] iArr = this.hashTableKToV;
        if (iArr[bucket] == i2) {
            iArr[bucket] = i3;
        } else {
            int i8 = iArr[bucket];
            int i9 = this.nextInBucketKToV[i8];
            while (true) {
                int i10 = i9;
                i4 = i8;
                i8 = i10;
                if (i8 == i2) {
                    break;
                }
                i9 = this.nextInBucketKToV[i8];
            }
            this.nextInBucketKToV[i4] = i3;
        }
        int[] iArr2 = this.nextInBucketKToV;
        iArr2[i3] = iArr2[i2];
        iArr2[i2] = -1;
        int bucket2 = bucket(e0.d(v));
        int[] iArr3 = this.hashTableVToK;
        if (iArr3[bucket2] == i2) {
            iArr3[bucket2] = i3;
        } else {
            int i11 = iArr3[bucket2];
            int i12 = this.nextInBucketVToK[i11];
            while (true) {
                int i13 = i12;
                i5 = i11;
                i11 = i13;
                if (i11 == i2) {
                    break;
                }
                i12 = this.nextInBucketVToK[i11];
            }
            this.nextInBucketVToK[i5] = i3;
        }
        int[] iArr4 = this.nextInBucketVToK;
        iArr4[i3] = iArr4[i2];
        iArr4[i2] = -1;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int h2 = r0.h(objectInputStream);
        init(16);
        r0.c(this, objectInputStream, h2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void replaceKeyInEntry(int i2, K k, boolean z) {
        n.d(i2 != -1);
        int d2 = e0.d(k);
        int findEntryByKey = findEntryByKey(k, d2);
        int i3 = this.lastInInsertionOrder;
        int i4 = -2;
        if (findEntryByKey != -1) {
            if (z) {
                i3 = this.prevInInsertionOrder[findEntryByKey];
                i4 = this.nextInInsertionOrder[findEntryByKey];
                removeEntryKeyHashKnown(findEntryByKey, d2);
                if (i2 == this.size) {
                    i2 = findEntryByKey;
                }
            } else {
                throw new IllegalArgumentException("Key already present in map: " + k);
            }
        }
        if (i3 == i2) {
            i3 = this.prevInInsertionOrder[i2];
        } else if (i3 == this.size) {
            i3 = findEntryByKey;
        }
        if (i4 == i2) {
            findEntryByKey = this.nextInInsertionOrder[i2];
        } else if (i4 != this.size) {
            findEntryByKey = i4;
        }
        setSucceeds(this.prevInInsertionOrder[i2], this.nextInInsertionOrder[i2]);
        deleteFromTableKToV(i2, e0.d(this.keys[i2]));
        this.keys[i2] = k;
        insertIntoTableKToV(i2, e0.d(k));
        setSucceeds(i3, i2);
        setSucceeds(i2, findEntryByKey);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void replaceValueInEntry(int i2, V v, boolean z) {
        n.d(i2 != -1);
        int d2 = e0.d(v);
        int findEntryByValue = findEntryByValue(v, d2);
        if (findEntryByValue != -1) {
            if (z) {
                removeEntryValueHashKnown(findEntryByValue, d2);
                if (i2 == this.size) {
                    i2 = findEntryByValue;
                }
            } else {
                throw new IllegalArgumentException("Value already present in map: " + v);
            }
        }
        deleteFromTableVToK(i2, e0.d(this.values[i2]));
        this.values[i2] = v;
        insertIntoTableVToK(i2, d2);
    }

    private void setSucceeds(int i2, int i3) {
        if (i2 == -2) {
            this.firstInInsertionOrder = i3;
        } else {
            this.nextInInsertionOrder[i2] = i3;
        }
        if (i3 == -2) {
            this.lastInInsertionOrder = i2;
        } else {
            this.prevInInsertionOrder[i3] = i2;
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        r0.i(this, objectOutputStream);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        Arrays.fill(this.keys, 0, this.size, (Object) null);
        Arrays.fill(this.values, 0, this.size, (Object) null);
        Arrays.fill(this.hashTableKToV, -1);
        Arrays.fill(this.hashTableVToK, -1);
        Arrays.fill(this.nextInBucketKToV, 0, this.size, -1);
        Arrays.fill(this.nextInBucketVToK, 0, this.size, -1);
        Arrays.fill(this.prevInInsertionOrder, 0, this.size, -1);
        Arrays.fill(this.nextInInsertionOrder, 0, this.size, -1);
        this.size = 0;
        this.firstInInsertionOrder = -2;
        this.lastInInsertionOrder = -2;
        this.modCount++;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return findEntryByKey(obj) != -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        return findEntryByValue(obj) != -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.entrySet;
        if (set == null) {
            c cVar = new c();
            this.entrySet = cVar;
            return cVar;
        }
        return set;
    }

    public int findEntry(Object obj, int i2, int[] iArr, int[] iArr2, Object[] objArr) {
        int i3 = iArr[bucket(i2)];
        while (i3 != -1) {
            if (d.g.c.a.k.a(objArr[i3], obj)) {
                return i3;
            }
            i3 = iArr2[i3];
        }
        return -1;
    }

    public int findEntryByKey(Object obj) {
        return findEntryByKey(obj, e0.d(obj));
    }

    public int findEntryByValue(Object obj) {
        return findEntryByValue(obj, e0.d(obj));
    }

    @Override // d.g.c.c.k
    public V forcePut(K k, V v) {
        return put(k, v, true);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        int findEntryByKey = findEntryByKey(obj);
        if (findEntryByKey == -1) {
            return null;
        }
        return this.values[findEntryByKey];
    }

    public K getInverse(Object obj) {
        int findEntryByValue = findEntryByValue(obj);
        if (findEntryByValue == -1) {
            return null;
        }
        return this.keys[findEntryByValue];
    }

    public void init(int i2) {
        m.b(i2, "expectedSize");
        int a2 = e0.a(i2, 1.0d);
        this.size = 0;
        this.keys = (K[]) new Object[i2];
        this.values = (V[]) new Object[i2];
        this.hashTableKToV = createFilledWithAbsent(a2);
        this.hashTableVToK = createFilledWithAbsent(a2);
        this.nextInBucketKToV = createFilledWithAbsent(i2);
        this.nextInBucketVToK = createFilledWithAbsent(i2);
        this.firstInInsertionOrder = -2;
        this.lastInInsertionOrder = -2;
        this.prevInInsertionOrder = createFilledWithAbsent(i2);
        this.nextInInsertionOrder = createFilledWithAbsent(i2);
    }

    @Override // d.g.c.c.k
    public k<V, K> inverse() {
        k<V, K> kVar = this.inverse;
        if (kVar == null) {
            Inverse inverse = new Inverse(this);
            this.inverse = inverse;
            return inverse;
        }
        return kVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.keySet;
        if (set == null) {
            e eVar = new e();
            this.keySet = eVar;
            return eVar;
        }
        return set;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k, V v) {
        return put(k, v, false);
    }

    public K putInverse(V v, K k, boolean z) {
        int d2 = e0.d(v);
        int findEntryByValue = findEntryByValue(v, d2);
        if (findEntryByValue != -1) {
            K k2 = this.keys[findEntryByValue];
            if (d.g.c.a.k.a(k2, k)) {
                return k;
            }
            replaceKeyInEntry(findEntryByValue, k, z);
            return k2;
        }
        int i2 = this.lastInInsertionOrder;
        int d3 = e0.d(k);
        int findEntryByKey = findEntryByKey(k, d3);
        if (!z) {
            n.k(findEntryByKey == -1, "Key already present: %s", k);
        } else if (findEntryByKey != -1) {
            i2 = this.prevInInsertionOrder[findEntryByKey];
            removeEntryKeyHashKnown(findEntryByKey, d3);
        }
        ensureCapacity(this.size + 1);
        K[] kArr = this.keys;
        int i3 = this.size;
        kArr[i3] = k;
        this.values[i3] = v;
        insertIntoTableKToV(i3, d3);
        insertIntoTableVToK(this.size, d2);
        int i4 = i2 == -2 ? this.firstInInsertionOrder : this.nextInInsertionOrder[i2];
        setSucceeds(i2, this.size);
        setSucceeds(this.size, i4);
        this.size++;
        this.modCount++;
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        int d2 = e0.d(obj);
        int findEntryByKey = findEntryByKey(obj, d2);
        if (findEntryByKey == -1) {
            return null;
        }
        V v = this.values[findEntryByKey];
        removeEntryKeyHashKnown(findEntryByKey, d2);
        return v;
    }

    public void removeEntry(int i2) {
        removeEntryKeyHashKnown(i2, e0.d(this.keys[i2]));
    }

    public void removeEntryKeyHashKnown(int i2, int i3) {
        removeEntry(i2, i3, e0.d(this.values[i2]));
    }

    public void removeEntryValueHashKnown(int i2, int i3) {
        removeEntry(i2, e0.d(this.keys[i2]), i3);
    }

    public K removeInverse(Object obj) {
        int d2 = e0.d(obj);
        int findEntryByValue = findEntryByValue(obj, d2);
        if (findEntryByValue == -1) {
            return null;
        }
        K k = this.keys[findEntryByValue];
        removeEntryValueHashKnown(findEntryByValue, d2);
        return k;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.size;
    }

    public static <K, V> HashBiMap<K, V> create(int i2) {
        return new HashBiMap<>(i2);
    }

    private void removeEntry(int i2, int i3, int i4) {
        n.d(i2 != -1);
        deleteFromTableKToV(i2, i3);
        deleteFromTableVToK(i2, i4);
        setSucceeds(this.prevInInsertionOrder[i2], this.nextInInsertionOrder[i2]);
        moveEntryToIndex(this.size - 1, i2);
        K[] kArr = this.keys;
        int i5 = this.size;
        kArr[i5 - 1] = null;
        this.values[i5 - 1] = null;
        this.size = i5 - 1;
        this.modCount++;
    }

    public int findEntryByKey(Object obj, int i2) {
        return findEntry(obj, i2, this.hashTableKToV, this.nextInBucketKToV, this.keys);
    }

    public int findEntryByValue(Object obj, int i2) {
        return findEntry(obj, i2, this.hashTableVToK, this.nextInBucketVToK, this.values);
    }

    public V put(K k, V v, boolean z) {
        int d2 = e0.d(k);
        int findEntryByKey = findEntryByKey(k, d2);
        if (findEntryByKey != -1) {
            V v2 = this.values[findEntryByKey];
            if (d.g.c.a.k.a(v2, v)) {
                return v;
            }
            replaceValueInEntry(findEntryByKey, v, z);
            return v2;
        }
        int d3 = e0.d(v);
        int findEntryByValue = findEntryByValue(v, d3);
        if (!z) {
            n.k(findEntryByValue == -1, "Value already present: %s", v);
        } else if (findEntryByValue != -1) {
            removeEntryValueHashKnown(findEntryByValue, d3);
        }
        ensureCapacity(this.size + 1);
        K[] kArr = this.keys;
        int i2 = this.size;
        kArr[i2] = k;
        this.values[i2] = v;
        insertIntoTableKToV(i2, d2);
        insertIntoTableVToK(this.size, d3);
        setSucceeds(this.lastInInsertionOrder, this.size);
        setSucceeds(this.size, -2);
        this.size++;
        this.modCount++;
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.AbstractMap, java.util.Map, d.g.c.c.k
    public Set<V> values() {
        Set<V> set = this.valueSet;
        if (set == null) {
            f fVar = new f();
            this.valueSet = fVar;
            return fVar;
        }
        return set;
    }

    public static <K, V> HashBiMap<K, V> create(Map<? extends K, ? extends V> map) {
        HashBiMap<K, V> create = create(map.size());
        create.putAll(map);
        return create;
    }
}
