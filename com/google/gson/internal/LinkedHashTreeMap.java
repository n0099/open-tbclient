package com.google.gson.internal;

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
/* loaded from: classes2.dex */
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
        f<K, V> fVar2 = fVar.kqP;
        while (fVar2 != fVar) {
            f<K, V> fVar3 = fVar2.kqP;
            fVar2.kqV = null;
            fVar2.kqP = null;
            fVar2 = fVar3;
        }
        fVar.kqV = fVar;
        fVar.kqP = fVar;
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
        int EC = EC(k.hashCode());
        int length = EC & (fVarArr.length - 1);
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
                f<K, V> fVar3 = compare < 0 ? fVar2.kqT : fVar2.kqU;
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
                fVar = new f<>(fVar2, k, EC, fVar4, fVar4.kqV);
                fVarArr[length] = fVar;
            } else {
                fVar = new f<>(fVar2, k, EC, fVar4, fVar4.kqV);
                if (i < 0) {
                    fVar2.kqT = fVar;
                } else {
                    fVar2.kqU = fVar;
                }
                a((f) fVar2, true);
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

    private static int EC(int i) {
        int i2 = ((i >>> 20) ^ (i >>> 12)) ^ i;
        return (i2 >>> 4) ^ ((i2 >>> 7) ^ i2);
    }

    void removeInternal(f<K, V> fVar, boolean z) {
        int i;
        int i2 = 0;
        if (z) {
            fVar.kqV.kqP = fVar.kqP;
            fVar.kqP.kqV = fVar.kqV;
            fVar.kqV = null;
            fVar.kqP = null;
        }
        f<K, V> fVar2 = fVar.kqT;
        f<K, V> fVar3 = fVar.kqU;
        f<K, V> fVar4 = fVar.kqS;
        if (fVar2 != null && fVar3 != null) {
            f<K, V> cNv = fVar2.height > fVar3.height ? fVar2.cNv() : fVar3.cNu();
            removeInternal(cNv, false);
            f<K, V> fVar5 = fVar.kqT;
            if (fVar5 != null) {
                i = fVar5.height;
                cNv.kqT = fVar5;
                fVar5.kqS = cNv;
                fVar.kqT = null;
            } else {
                i = 0;
            }
            f<K, V> fVar6 = fVar.kqU;
            if (fVar6 != null) {
                i2 = fVar6.height;
                cNv.kqU = fVar6;
                fVar6.kqS = cNv;
                fVar.kqU = null;
            }
            cNv.height = Math.max(i, i2) + 1;
            a(fVar, cNv);
            return;
        }
        if (fVar2 != null) {
            a(fVar, fVar2);
            fVar.kqT = null;
        } else if (fVar3 != null) {
            a(fVar, fVar3);
            fVar.kqU = null;
        } else {
            a(fVar, (f) null);
        }
        a((f) fVar4, false);
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

    private void a(f<K, V> fVar, f<K, V> fVar2) {
        f<K, V> fVar3 = fVar.kqS;
        fVar.kqS = null;
        if (fVar2 != null) {
            fVar2.kqS = fVar3;
        }
        if (fVar3 != null) {
            if (fVar3.kqT == fVar) {
                fVar3.kqT = fVar2;
                return;
            } else if (!$assertionsDisabled && fVar3.kqU != fVar) {
                throw new AssertionError();
            } else {
                fVar3.kqU = fVar2;
                return;
            }
        }
        this.table[fVar.hash & (this.table.length - 1)] = fVar2;
    }

    private void a(f<K, V> fVar, boolean z) {
        while (fVar != null) {
            f<K, V> fVar2 = fVar.kqT;
            f<K, V> fVar3 = fVar.kqU;
            int i = fVar2 != null ? fVar2.height : 0;
            int i2 = fVar3 != null ? fVar3.height : 0;
            int i3 = i - i2;
            if (i3 == -2) {
                f<K, V> fVar4 = fVar3.kqT;
                f<K, V> fVar5 = fVar3.kqU;
                int i4 = (fVar4 != null ? fVar4.height : 0) - (fVar5 != null ? fVar5.height : 0);
                if (i4 == -1 || (i4 == 0 && !z)) {
                    a(fVar);
                } else if (!$assertionsDisabled && i4 != 1) {
                    throw new AssertionError();
                } else {
                    b(fVar3);
                    a(fVar);
                }
                if (z) {
                    return;
                }
            } else if (i3 == 2) {
                f<K, V> fVar6 = fVar2.kqT;
                f<K, V> fVar7 = fVar2.kqU;
                int i5 = (fVar6 != null ? fVar6.height : 0) - (fVar7 != null ? fVar7.height : 0);
                if (i5 == 1 || (i5 == 0 && !z)) {
                    b(fVar);
                } else if (!$assertionsDisabled && i5 != -1) {
                    throw new AssertionError();
                } else {
                    a(fVar2);
                    b(fVar);
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
            fVar = fVar.kqS;
        }
    }

    private void a(f<K, V> fVar) {
        f<K, V> fVar2 = fVar.kqT;
        f<K, V> fVar3 = fVar.kqU;
        f<K, V> fVar4 = fVar3.kqT;
        f<K, V> fVar5 = fVar3.kqU;
        fVar.kqU = fVar4;
        if (fVar4 != null) {
            fVar4.kqS = fVar;
        }
        a(fVar, fVar3);
        fVar3.kqT = fVar;
        fVar.kqS = fVar3;
        fVar.height = Math.max(fVar2 != null ? fVar2.height : 0, fVar4 != null ? fVar4.height : 0) + 1;
        fVar3.height = Math.max(fVar.height, fVar5 != null ? fVar5.height : 0) + 1;
    }

    private void b(f<K, V> fVar) {
        f<K, V> fVar2 = fVar.kqT;
        f<K, V> fVar3 = fVar.kqU;
        f<K, V> fVar4 = fVar2.kqT;
        f<K, V> fVar5 = fVar2.kqU;
        fVar.kqT = fVar5;
        if (fVar5 != null) {
            fVar5.kqS = fVar;
        }
        a(fVar, fVar2);
        fVar2.kqU = fVar;
        fVar.kqS = fVar2;
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
    /* loaded from: classes2.dex */
    public static final class f<K, V> implements Map.Entry<K, V> {
        final int hash;
        int height;
        final K key;
        f<K, V> kqP;
        f<K, V> kqS;
        f<K, V> kqT;
        f<K, V> kqU;
        f<K, V> kqV;
        V value;

        f() {
            this.key = null;
            this.hash = -1;
            this.kqV = this;
            this.kqP = this;
        }

        f(f<K, V> fVar, K k, int i, f<K, V> fVar2, f<K, V> fVar3) {
            this.kqS = fVar;
            this.key = k;
            this.hash = i;
            this.height = 1;
            this.kqP = fVar2;
            this.kqV = fVar3;
            fVar3.kqP = this;
            fVar2.kqV = this;
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
            return this.key + "=" + this.value;
        }

        public f<K, V> cNu() {
            for (f<K, V> fVar = this.kqT; fVar != null; fVar = fVar.kqT) {
                this = fVar;
            }
            return this;
        }

        public f<K, V> cNv() {
            for (f<K, V> fVar = this.kqU; fVar != null; fVar = fVar.kqU) {
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
                bVar.d(fVar);
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    f<K, V> cNs = bVar.cNs();
                    if (cNs == null) {
                        break;
                    } else if ((cNs.hash & length) == 0) {
                        i3++;
                    } else {
                        i2++;
                    }
                }
                aVar.reset(i3);
                aVar2.reset(i2);
                bVar.d(fVar);
                while (true) {
                    f<K, V> cNs2 = bVar.cNs();
                    if (cNs2 == null) {
                        break;
                    } else if ((cNs2.hash & length) == 0) {
                        aVar.c(cNs2);
                    } else {
                        aVar2.c(cNs2);
                    }
                }
                fVarArr2[i] = i3 > 0 ? aVar.cNr() : null;
                fVarArr2[i + length] = i2 > 0 ? aVar2.cNr() : null;
            }
        }
        return fVarArr2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class b<K, V> {
        private f<K, V> kqL;

        b() {
        }

        void d(f<K, V> fVar) {
            f<K, V> fVar2 = null;
            while (fVar != null) {
                fVar.kqS = fVar2;
                fVar2 = fVar;
                fVar = fVar.kqT;
            }
            this.kqL = fVar2;
        }

        public f<K, V> cNs() {
            f<K, V> fVar = this.kqL;
            if (fVar == null) {
                return null;
            }
            f<K, V> fVar2 = fVar.kqS;
            fVar.kqS = null;
            for (f<K, V> fVar3 = fVar.kqU; fVar3 != null; fVar3 = fVar3.kqT) {
                fVar3.kqS = fVar2;
                fVar2 = fVar3;
            }
            this.kqL = fVar2;
            return fVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a<K, V> {
        private f<K, V> kqI;
        private int kqJ;
        private int kqK;
        private int size;

        a() {
        }

        void reset(int i) {
            this.kqJ = ((Integer.highestOneBit(i) * 2) - 1) - i;
            this.size = 0;
            this.kqK = 0;
            this.kqI = null;
        }

        void c(f<K, V> fVar) {
            fVar.kqU = null;
            fVar.kqS = null;
            fVar.kqT = null;
            fVar.height = 1;
            if (this.kqJ > 0 && (this.size & 1) == 0) {
                this.size++;
                this.kqJ--;
                this.kqK++;
            }
            fVar.kqS = this.kqI;
            this.kqI = fVar;
            this.size++;
            if (this.kqJ > 0 && (this.size & 1) == 0) {
                this.size++;
                this.kqJ--;
                this.kqK++;
            }
            for (int i = 4; (this.size & (i - 1)) == i - 1; i *= 2) {
                if (this.kqK == 0) {
                    f<K, V> fVar2 = this.kqI;
                    f<K, V> fVar3 = fVar2.kqS;
                    f<K, V> fVar4 = fVar3.kqS;
                    fVar3.kqS = fVar4.kqS;
                    this.kqI = fVar3;
                    fVar3.kqT = fVar4;
                    fVar3.kqU = fVar2;
                    fVar3.height = fVar2.height + 1;
                    fVar4.kqS = fVar3;
                    fVar2.kqS = fVar3;
                } else if (this.kqK == 1) {
                    f<K, V> fVar5 = this.kqI;
                    f<K, V> fVar6 = fVar5.kqS;
                    this.kqI = fVar6;
                    fVar6.kqU = fVar5;
                    fVar6.height = fVar5.height + 1;
                    fVar5.kqS = fVar6;
                    this.kqK = 0;
                } else if (this.kqK == 2) {
                    this.kqK = 0;
                }
            }
        }

        f<K, V> cNr() {
            f<K, V> fVar = this.kqI;
            if (fVar.kqS != null) {
                throw new IllegalStateException();
            }
            return fVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public abstract class e<T> implements Iterator<T> {
        f<K, V> kqP;
        f<K, V> kqQ = null;
        int kqR;

        e() {
            this.kqP = LinkedHashTreeMap.this.header.kqP;
            this.kqR = LinkedHashTreeMap.this.modCount;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.kqP != LinkedHashTreeMap.this.header;
        }

        final f<K, V> cNt() {
            f<K, V> fVar = this.kqP;
            if (fVar == LinkedHashTreeMap.this.header) {
                throw new NoSuchElementException();
            }
            if (LinkedHashTreeMap.this.modCount != this.kqR) {
                throw new ConcurrentModificationException();
            }
            this.kqP = fVar.kqP;
            this.kqQ = fVar;
            return fVar;
        }

        @Override // java.util.Iterator
        public final void remove() {
            if (this.kqQ == null) {
                throw new IllegalStateException();
            }
            LinkedHashTreeMap.this.removeInternal(this.kqQ, true);
            this.kqQ = null;
            this.kqR = LinkedHashTreeMap.this.modCount;
        }
    }

    /* loaded from: classes2.dex */
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
                    return cNt();
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

    /* loaded from: classes2.dex */
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
                    return cNt().key;
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
