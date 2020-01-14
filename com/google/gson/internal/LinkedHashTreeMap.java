package com.google.gson.internal;

import com.baidu.webkit.internal.ETAG;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
/* loaded from: classes5.dex */
public final class LinkedHashTreeMap<K, V> extends AbstractMap<K, V> implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final Comparator<Comparable> NATURAL_ORDER;
    Comparator<? super K> comparator;
    private LinkedHashTreeMap<K, V>.c entrySet;
    final f<K, V> header;
    private LinkedHashTreeMap<K, V>.d keySet;
    int modCount;
    int size;
    f<K, V>[] table;
    int threshold;

    static {
        $assertionsDisabled = !LinkedHashTreeMap.class.desiredAssertionStatus();
        NATURAL_ORDER = new Comparator<Comparable>() { // from class: com.google.gson.internal.LinkedHashTreeMap.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: b */
            public int compare(Comparable comparable, Comparable comparable2) {
                return comparable.compareTo(comparable2);
            }
        };
    }

    public LinkedHashTreeMap() {
        this(NATURAL_ORDER);
    }

    public LinkedHashTreeMap(Comparator<? super K> comparator) {
        this.size = 0;
        this.modCount = 0;
        this.comparator = comparator == null ? NATURAL_ORDER : comparator;
        this.header = new f<>();
        this.table = new f[16];
        this.threshold = (this.table.length / 2) + (this.table.length / 4);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.size;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        f<K, V> findByObject = findByObject(obj);
        if (findByObject != null) {
            return findByObject.value;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return findByObject(obj) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k, V v) {
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        f<K, V> find = find(k, true);
        V v2 = find.value;
        find.value = v;
        return v2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        Arrays.fill(this.table, (Object) null);
        this.size = 0;
        this.modCount++;
        f<K, V> fVar = this.header;
        f<K, V> fVar2 = fVar.mKd;
        while (fVar2 != fVar) {
            f<K, V> fVar3 = fVar2.mKd;
            fVar2.mKj = null;
            fVar2.mKd = null;
            fVar2 = fVar3;
        }
        fVar.mKj = fVar;
        fVar.mKd = fVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        f<K, V> removeInternalByKey = removeInternalByKey(obj);
        if (removeInternalByKey != null) {
            return removeInternalByKey.value;
        }
        return null;
    }

    /* JADX DEBUG: Type inference failed for r4v1. Raw type applied. Possible types: K, ? super K */
    f<K, V> find(K k, boolean z) {
        int i;
        f<K, V> fVar;
        int compare;
        Comparator<? super K> comparator = this.comparator;
        f<K, V>[] fVarArr = this.table;
        int secondaryHash = secondaryHash(k.hashCode());
        int length = secondaryHash & (fVarArr.length - 1);
        f<K, V> fVar2 = fVarArr[length];
        if (fVar2 == null) {
            i = 0;
        } else {
            Comparable comparable = comparator == NATURAL_ORDER ? (Comparable) k : null;
            while (true) {
                if (comparable != null) {
                    compare = comparable.compareTo(fVar2.key);
                } else {
                    compare = comparator.compare(k, (K) fVar2.key);
                }
                if (compare == 0) {
                    return fVar2;
                }
                f<K, V> fVar3 = compare < 0 ? fVar2.mKh : fVar2.mKi;
                if (fVar3 == null) {
                    i = compare;
                    break;
                }
                fVar2 = fVar3;
            }
        }
        if (z) {
            f<K, V> fVar4 = this.header;
            if (fVar2 == null) {
                if (comparator == NATURAL_ORDER && !(k instanceof Comparable)) {
                    throw new ClassCastException(k.getClass().getName() + " is not Comparable");
                }
                fVar = new f<>(fVar2, k, secondaryHash, fVar4, fVar4.mKj);
                fVarArr[length] = fVar;
            } else {
                fVar = new f<>(fVar2, k, secondaryHash, fVar4, fVar4.mKj);
                if (i < 0) {
                    fVar2.mKh = fVar;
                } else {
                    fVar2.mKi = fVar;
                }
                rebalance(fVar2, true);
            }
            int i2 = this.size;
            this.size = i2 + 1;
            if (i2 > this.threshold) {
                doubleCapacity();
            }
            this.modCount++;
            return fVar;
        }
        return null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    f<K, V> findByObject(Object obj) {
        if (obj != 0) {
            try {
                return find(obj, false);
            } catch (ClassCastException e2) {
                return null;
            }
        }
        return null;
    }

    f<K, V> findByEntry(Map.Entry<?, ?> entry) {
        f<K, V> findByObject = findByObject(entry.getKey());
        if (findByObject != null && equal(findByObject.value, entry.getValue())) {
            return findByObject;
        }
        return null;
    }

    private boolean equal(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    private static int secondaryHash(int i) {
        int i2 = ((i >>> 20) ^ (i >>> 12)) ^ i;
        return (i2 >>> 4) ^ ((i2 >>> 7) ^ i2);
    }

    void removeInternal(f<K, V> fVar, boolean z) {
        int i;
        int i2 = 0;
        if (z) {
            fVar.mKj.mKd = fVar.mKd;
            fVar.mKd.mKj = fVar.mKj;
            fVar.mKj = null;
            fVar.mKd = null;
        }
        f<K, V> fVar2 = fVar.mKh;
        f<K, V> fVar3 = fVar.mKi;
        f<K, V> fVar4 = fVar.mKg;
        if (fVar2 != null && fVar3 != null) {
            f<K, V> dzC = fVar2.height > fVar3.height ? fVar2.dzC() : fVar3.dzB();
            removeInternal(dzC, false);
            f<K, V> fVar5 = fVar.mKh;
            if (fVar5 != null) {
                i = fVar5.height;
                dzC.mKh = fVar5;
                fVar5.mKg = dzC;
                fVar.mKh = null;
            } else {
                i = 0;
            }
            f<K, V> fVar6 = fVar.mKi;
            if (fVar6 != null) {
                i2 = fVar6.height;
                dzC.mKi = fVar6;
                fVar6.mKg = dzC;
                fVar.mKi = null;
            }
            dzC.height = Math.max(i, i2) + 1;
            replaceInParent(fVar, dzC);
            return;
        }
        if (fVar2 != null) {
            replaceInParent(fVar, fVar2);
            fVar.mKh = null;
        } else if (fVar3 != null) {
            replaceInParent(fVar, fVar3);
            fVar.mKi = null;
        } else {
            replaceInParent(fVar, null);
        }
        rebalance(fVar4, false);
        this.size--;
        this.modCount++;
    }

    f<K, V> removeInternalByKey(Object obj) {
        f<K, V> findByObject = findByObject(obj);
        if (findByObject != null) {
            removeInternal(findByObject, true);
        }
        return findByObject;
    }

    private void replaceInParent(f<K, V> fVar, f<K, V> fVar2) {
        f<K, V> fVar3 = fVar.mKg;
        fVar.mKg = null;
        if (fVar2 != null) {
            fVar2.mKg = fVar3;
        }
        if (fVar3 != null) {
            if (fVar3.mKh == fVar) {
                fVar3.mKh = fVar2;
                return;
            } else if (!$assertionsDisabled && fVar3.mKi != fVar) {
                throw new AssertionError();
            } else {
                fVar3.mKi = fVar2;
                return;
            }
        }
        this.table[fVar.hash & (this.table.length - 1)] = fVar2;
    }

    private void rebalance(f<K, V> fVar, boolean z) {
        while (fVar != null) {
            f<K, V> fVar2 = fVar.mKh;
            f<K, V> fVar3 = fVar.mKi;
            int i = fVar2 != null ? fVar2.height : 0;
            int i2 = fVar3 != null ? fVar3.height : 0;
            int i3 = i - i2;
            if (i3 == -2) {
                f<K, V> fVar4 = fVar3.mKh;
                f<K, V> fVar5 = fVar3.mKi;
                int i4 = (fVar4 != null ? fVar4.height : 0) - (fVar5 != null ? fVar5.height : 0);
                if (i4 == -1 || (i4 == 0 && !z)) {
                    rotateLeft(fVar);
                } else if (!$assertionsDisabled && i4 != 1) {
                    throw new AssertionError();
                } else {
                    rotateRight(fVar3);
                    rotateLeft(fVar);
                }
                if (z) {
                    return;
                }
            } else if (i3 == 2) {
                f<K, V> fVar6 = fVar2.mKh;
                f<K, V> fVar7 = fVar2.mKi;
                int i5 = (fVar6 != null ? fVar6.height : 0) - (fVar7 != null ? fVar7.height : 0);
                if (i5 == 1 || (i5 == 0 && !z)) {
                    rotateRight(fVar);
                } else if (!$assertionsDisabled && i5 != -1) {
                    throw new AssertionError();
                } else {
                    rotateLeft(fVar2);
                    rotateRight(fVar);
                }
                if (z) {
                    return;
                }
            } else if (i3 == 0) {
                fVar.height = i + 1;
                if (z) {
                    return;
                }
            } else if (!$assertionsDisabled && i3 != -1 && i3 != 1) {
                throw new AssertionError();
            } else {
                fVar.height = Math.max(i, i2) + 1;
                if (!z) {
                    return;
                }
            }
            fVar = fVar.mKg;
        }
    }

    private void rotateLeft(f<K, V> fVar) {
        f<K, V> fVar2 = fVar.mKh;
        f<K, V> fVar3 = fVar.mKi;
        f<K, V> fVar4 = fVar3.mKh;
        f<K, V> fVar5 = fVar3.mKi;
        fVar.mKi = fVar4;
        if (fVar4 != null) {
            fVar4.mKg = fVar;
        }
        replaceInParent(fVar, fVar3);
        fVar3.mKh = fVar;
        fVar.mKg = fVar3;
        fVar.height = Math.max(fVar2 != null ? fVar2.height : 0, fVar4 != null ? fVar4.height : 0) + 1;
        fVar3.height = Math.max(fVar.height, fVar5 != null ? fVar5.height : 0) + 1;
    }

    private void rotateRight(f<K, V> fVar) {
        f<K, V> fVar2 = fVar.mKh;
        f<K, V> fVar3 = fVar.mKi;
        f<K, V> fVar4 = fVar2.mKh;
        f<K, V> fVar5 = fVar2.mKi;
        fVar.mKh = fVar5;
        if (fVar5 != null) {
            fVar5.mKg = fVar;
        }
        replaceInParent(fVar, fVar2);
        fVar2.mKi = fVar;
        fVar.mKg = fVar2;
        fVar.height = Math.max(fVar3 != null ? fVar3.height : 0, fVar5 != null ? fVar5.height : 0) + 1;
        fVar2.height = Math.max(fVar.height, fVar4 != null ? fVar4.height : 0) + 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        LinkedHashTreeMap<K, V>.c cVar = this.entrySet;
        if (cVar != null) {
            return cVar;
        }
        LinkedHashTreeMap<K, V>.c cVar2 = new c();
        this.entrySet = cVar2;
        return cVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        LinkedHashTreeMap<K, V>.d dVar = this.keySet;
        if (dVar != null) {
            return dVar;
        }
        LinkedHashTreeMap<K, V>.d dVar2 = new d();
        this.keySet = dVar2;
        return dVar2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class f<K, V> implements Map.Entry<K, V> {
        final int hash;
        int height;
        final K key;
        f<K, V> mKd;
        f<K, V> mKg;
        f<K, V> mKh;
        f<K, V> mKi;
        f<K, V> mKj;
        V value;

        f() {
            this.key = null;
            this.hash = -1;
            this.mKj = this;
            this.mKd = this;
        }

        f(f<K, V> fVar, K k, int i, f<K, V> fVar2, f<K, V> fVar3) {
            this.mKg = fVar;
            this.key = k;
            this.hash = i;
            this.height = 1;
            this.mKd = fVar2;
            this.mKj = fVar3;
            fVar3.mKd = this;
            fVar2.mKj = this;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.key;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.value;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            V v2 = this.value;
            this.value = v;
            return v2;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                if (this.key == null) {
                    if (entry.getKey() != null) {
                        return false;
                    }
                } else if (!this.key.equals(entry.getKey())) {
                    return false;
                }
                if (this.value == null) {
                    if (entry.getValue() != null) {
                        return false;
                    }
                } else if (!this.value.equals(entry.getValue())) {
                    return false;
                }
                return true;
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return (this.key == null ? 0 : this.key.hashCode()) ^ (this.value != null ? this.value.hashCode() : 0);
        }

        public String toString() {
            return this.key + ETAG.EQUAL + this.value;
        }

        public f<K, V> dzB() {
            for (f<K, V> fVar = this.mKh; fVar != null; fVar = fVar.mKh) {
                this = fVar;
            }
            return this;
        }

        public f<K, V> dzC() {
            for (f<K, V> fVar = this.mKi; fVar != null; fVar = fVar.mKi) {
                this = fVar;
            }
            return this;
        }
    }

    private void doubleCapacity() {
        this.table = doubleCapacity(this.table);
        this.threshold = (this.table.length / 2) + (this.table.length / 4);
    }

    static <K, V> f<K, V>[] doubleCapacity(f<K, V>[] fVarArr) {
        int length = fVarArr.length;
        f<K, V>[] fVarArr2 = new f[length * 2];
        b bVar = new b();
        a aVar = new a();
        a aVar2 = new a();
        for (int i = 0; i < length; i++) {
            f<K, V> fVar = fVarArr[i];
            if (fVar != null) {
                bVar.b(fVar);
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    f<K, V> dzz = bVar.dzz();
                    if (dzz == null) {
                        break;
                    } else if ((dzz.hash & length) == 0) {
                        i3++;
                    } else {
                        i2++;
                    }
                }
                aVar.reset(i3);
                aVar2.reset(i2);
                bVar.b(fVar);
                while (true) {
                    f<K, V> dzz2 = bVar.dzz();
                    if (dzz2 == null) {
                        break;
                    } else if ((dzz2.hash & length) == 0) {
                        aVar.a(dzz2);
                    } else {
                        aVar2.a(dzz2);
                    }
                }
                fVarArr2[i] = i3 > 0 ? aVar.dzy() : null;
                fVarArr2[i + length] = i2 > 0 ? aVar2.dzy() : null;
            }
        }
        return fVarArr2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class b<K, V> {
        private f<K, V> mJZ;

        b() {
        }

        void b(f<K, V> fVar) {
            f<K, V> fVar2 = null;
            while (fVar != null) {
                fVar.mKg = fVar2;
                fVar2 = fVar;
                fVar = fVar.mKh;
            }
            this.mJZ = fVar2;
        }

        public f<K, V> dzz() {
            f<K, V> fVar = this.mJZ;
            if (fVar == null) {
                return null;
            }
            f<K, V> fVar2 = fVar.mKg;
            fVar.mKg = null;
            for (f<K, V> fVar3 = fVar.mKi; fVar3 != null; fVar3 = fVar3.mKh) {
                fVar3.mKg = fVar2;
                fVar2 = fVar3;
            }
            this.mJZ = fVar2;
            return fVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class a<K, V> {
        private f<K, V> mJW;
        private int mJX;
        private int mJY;
        private int size;

        a() {
        }

        void reset(int i) {
            this.mJX = ((Integer.highestOneBit(i) * 2) - 1) - i;
            this.size = 0;
            this.mJY = 0;
            this.mJW = null;
        }

        void a(f<K, V> fVar) {
            fVar.mKi = null;
            fVar.mKg = null;
            fVar.mKh = null;
            fVar.height = 1;
            if (this.mJX > 0 && (this.size & 1) == 0) {
                this.size++;
                this.mJX--;
                this.mJY++;
            }
            fVar.mKg = this.mJW;
            this.mJW = fVar;
            this.size++;
            if (this.mJX > 0 && (this.size & 1) == 0) {
                this.size++;
                this.mJX--;
                this.mJY++;
            }
            for (int i = 4; (this.size & (i - 1)) == i - 1; i *= 2) {
                if (this.mJY == 0) {
                    f<K, V> fVar2 = this.mJW;
                    f<K, V> fVar3 = fVar2.mKg;
                    f<K, V> fVar4 = fVar3.mKg;
                    fVar3.mKg = fVar4.mKg;
                    this.mJW = fVar3;
                    fVar3.mKh = fVar4;
                    fVar3.mKi = fVar2;
                    fVar3.height = fVar2.height + 1;
                    fVar4.mKg = fVar3;
                    fVar2.mKg = fVar3;
                } else if (this.mJY == 1) {
                    f<K, V> fVar5 = this.mJW;
                    f<K, V> fVar6 = fVar5.mKg;
                    this.mJW = fVar6;
                    fVar6.mKi = fVar5;
                    fVar6.height = fVar5.height + 1;
                    fVar5.mKg = fVar6;
                    this.mJY = 0;
                } else if (this.mJY == 2) {
                    this.mJY = 0;
                }
            }
        }

        f<K, V> dzy() {
            f<K, V> fVar = this.mJW;
            if (fVar.mKg != null) {
                throw new IllegalStateException();
            }
            return fVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public abstract class e<T> implements Iterator<T> {
        f<K, V> mKd;
        f<K, V> mKe = null;
        int mKf;

        e() {
            this.mKd = LinkedHashTreeMap.this.header.mKd;
            this.mKf = LinkedHashTreeMap.this.modCount;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.mKd != LinkedHashTreeMap.this.header;
        }

        final f<K, V> dzA() {
            f<K, V> fVar = this.mKd;
            if (fVar == LinkedHashTreeMap.this.header) {
                throw new NoSuchElementException();
            }
            if (LinkedHashTreeMap.this.modCount != this.mKf) {
                throw new ConcurrentModificationException();
            }
            this.mKd = fVar.mKd;
            this.mKe = fVar;
            return fVar;
        }

        @Override // java.util.Iterator
        public final void remove() {
            if (this.mKe == null) {
                throw new IllegalStateException();
            }
            LinkedHashTreeMap.this.removeInternal(this.mKe, true);
            this.mKe = null;
            this.mKf = LinkedHashTreeMap.this.modCount;
        }
    }

    /* loaded from: classes5.dex */
    final class c extends AbstractSet<Map.Entry<K, V>> {
        c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return LinkedHashTreeMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new LinkedHashTreeMap<K, V>.e<Map.Entry<K, V>>() { // from class: com.google.gson.internal.LinkedHashTreeMap.c.1
                {
                    LinkedHashTreeMap linkedHashTreeMap = LinkedHashTreeMap.this;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Iterator
                public Map.Entry<K, V> next() {
                    return dzA();
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return (obj instanceof Map.Entry) && LinkedHashTreeMap.this.findByEntry((Map.Entry) obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            f<K, V> findByEntry;
            if ((obj instanceof Map.Entry) && (findByEntry = LinkedHashTreeMap.this.findByEntry((Map.Entry) obj)) != null) {
                LinkedHashTreeMap.this.removeInternal(findByEntry, true);
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            LinkedHashTreeMap.this.clear();
        }
    }

    /* loaded from: classes5.dex */
    final class d extends AbstractSet<K> {
        d() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return LinkedHashTreeMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new LinkedHashTreeMap<K, V>.e<K>() { // from class: com.google.gson.internal.LinkedHashTreeMap.d.1
                {
                    LinkedHashTreeMap linkedHashTreeMap = LinkedHashTreeMap.this;
                }

                @Override // java.util.Iterator
                public K next() {
                    return dzA().key;
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return LinkedHashTreeMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return LinkedHashTreeMap.this.removeInternalByKey(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            LinkedHashTreeMap.this.clear();
        }
    }

    private Object writeReplace() throws ObjectStreamException {
        return new LinkedHashMap(this);
    }
}
