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
        f<K, V> fVar2 = fVar.peX;
        while (fVar2 != fVar) {
            f<K, V> fVar3 = fVar2.peX;
            fVar2.pfc = null;
            fVar2.peX = null;
            fVar2 = fVar3;
        }
        fVar.pfc = fVar;
        fVar.peX = fVar;
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
                f<K, V> fVar3 = compare < 0 ? fVar2.pfa : fVar2.pfb;
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
                fVar = new f<>(fVar2, k, secondaryHash, fVar4, fVar4.pfc);
                fVarArr[length] = fVar;
            } else {
                fVar = new f<>(fVar2, k, secondaryHash, fVar4, fVar4.pfc);
                if (i < 0) {
                    fVar2.pfa = fVar;
                } else {
                    fVar2.pfb = fVar;
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
            fVar.pfc.peX = fVar.peX;
            fVar.peX.pfc = fVar.pfc;
            fVar.pfc = null;
            fVar.peX = null;
        }
        f<K, V> fVar2 = fVar.pfa;
        f<K, V> fVar3 = fVar.pfb;
        f<K, V> fVar4 = fVar.peZ;
        if (fVar2 != null && fVar3 != null) {
            f<K, V> esP = fVar2.height > fVar3.height ? fVar2.esP() : fVar3.esO();
            removeInternal(esP, false);
            f<K, V> fVar5 = fVar.pfa;
            if (fVar5 != null) {
                i = fVar5.height;
                esP.pfa = fVar5;
                fVar5.peZ = esP;
                fVar.pfa = null;
            } else {
                i = 0;
            }
            f<K, V> fVar6 = fVar.pfb;
            if (fVar6 != null) {
                i2 = fVar6.height;
                esP.pfb = fVar6;
                fVar6.peZ = esP;
                fVar.pfb = null;
            }
            esP.height = Math.max(i, i2) + 1;
            replaceInParent(fVar, esP);
            return;
        }
        if (fVar2 != null) {
            replaceInParent(fVar, fVar2);
            fVar.pfa = null;
        } else if (fVar3 != null) {
            replaceInParent(fVar, fVar3);
            fVar.pfb = null;
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
        f<K, V> fVar3 = fVar.peZ;
        fVar.peZ = null;
        if (fVar2 != null) {
            fVar2.peZ = fVar3;
        }
        if (fVar3 != null) {
            if (fVar3.pfa == fVar) {
                fVar3.pfa = fVar2;
                return;
            } else if (!$assertionsDisabled && fVar3.pfb != fVar) {
                throw new AssertionError();
            } else {
                fVar3.pfb = fVar2;
                return;
            }
        }
        this.table[fVar.hash & (this.table.length - 1)] = fVar2;
    }

    private void rebalance(f<K, V> fVar, boolean z) {
        while (fVar != null) {
            f<K, V> fVar2 = fVar.pfa;
            f<K, V> fVar3 = fVar.pfb;
            int i = fVar2 != null ? fVar2.height : 0;
            int i2 = fVar3 != null ? fVar3.height : 0;
            int i3 = i - i2;
            if (i3 == -2) {
                f<K, V> fVar4 = fVar3.pfa;
                f<K, V> fVar5 = fVar3.pfb;
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
                f<K, V> fVar6 = fVar2.pfa;
                f<K, V> fVar7 = fVar2.pfb;
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
            fVar = fVar.peZ;
        }
    }

    private void rotateLeft(f<K, V> fVar) {
        f<K, V> fVar2 = fVar.pfa;
        f<K, V> fVar3 = fVar.pfb;
        f<K, V> fVar4 = fVar3.pfa;
        f<K, V> fVar5 = fVar3.pfb;
        fVar.pfb = fVar4;
        if (fVar4 != null) {
            fVar4.peZ = fVar;
        }
        replaceInParent(fVar, fVar3);
        fVar3.pfa = fVar;
        fVar.peZ = fVar3;
        fVar.height = Math.max(fVar2 != null ? fVar2.height : 0, fVar4 != null ? fVar4.height : 0) + 1;
        fVar3.height = Math.max(fVar.height, fVar5 != null ? fVar5.height : 0) + 1;
    }

    private void rotateRight(f<K, V> fVar) {
        f<K, V> fVar2 = fVar.pfa;
        f<K, V> fVar3 = fVar.pfb;
        f<K, V> fVar4 = fVar2.pfa;
        f<K, V> fVar5 = fVar2.pfb;
        fVar.pfa = fVar5;
        if (fVar5 != null) {
            fVar5.peZ = fVar;
        }
        replaceInParent(fVar, fVar2);
        fVar2.pfb = fVar;
        fVar.peZ = fVar2;
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
        f<K, V> peX;
        f<K, V> peZ;
        f<K, V> pfa;
        f<K, V> pfb;
        f<K, V> pfc;
        V value;

        f() {
            this.key = null;
            this.hash = -1;
            this.pfc = this;
            this.peX = this;
        }

        f(f<K, V> fVar, K k, int i, f<K, V> fVar2, f<K, V> fVar3) {
            this.peZ = fVar;
            this.key = k;
            this.hash = i;
            this.height = 1;
            this.peX = fVar2;
            this.pfc = fVar3;
            fVar3.peX = this;
            fVar2.pfc = this;
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

        public f<K, V> esO() {
            for (f<K, V> fVar = this.pfa; fVar != null; fVar = fVar.pfa) {
                this = fVar;
            }
            return this;
        }

        public f<K, V> esP() {
            for (f<K, V> fVar = this.pfb; fVar != null; fVar = fVar.pfb) {
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
                    f<K, V> esM = bVar.esM();
                    if (esM == null) {
                        break;
                    } else if ((esM.hash & length) == 0) {
                        i3++;
                    } else {
                        i2++;
                    }
                }
                aVar.reset(i3);
                aVar2.reset(i2);
                bVar.b(fVar);
                while (true) {
                    f<K, V> esM2 = bVar.esM();
                    if (esM2 == null) {
                        break;
                    } else if ((esM2.hash & length) == 0) {
                        aVar.a(esM2);
                    } else {
                        aVar2.a(esM2);
                    }
                }
                fVarArr2[i] = i3 > 0 ? aVar.esL() : null;
                fVarArr2[i + length] = i2 > 0 ? aVar2.esL() : null;
            }
        }
        return fVarArr2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class b<K, V> {
        private f<K, V> peT;

        b() {
        }

        void b(f<K, V> fVar) {
            f<K, V> fVar2 = null;
            while (fVar != null) {
                fVar.peZ = fVar2;
                fVar2 = fVar;
                fVar = fVar.pfa;
            }
            this.peT = fVar2;
        }

        public f<K, V> esM() {
            f<K, V> fVar = this.peT;
            if (fVar == null) {
                return null;
            }
            f<K, V> fVar2 = fVar.peZ;
            fVar.peZ = null;
            for (f<K, V> fVar3 = fVar.pfb; fVar3 != null; fVar3 = fVar3.pfa) {
                fVar3.peZ = fVar2;
                fVar2 = fVar3;
            }
            this.peT = fVar2;
            return fVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class a<K, V> {
        private f<K, V> peQ;
        private int peR;
        private int peS;
        private int size;

        a() {
        }

        void reset(int i) {
            this.peR = ((Integer.highestOneBit(i) * 2) - 1) - i;
            this.size = 0;
            this.peS = 0;
            this.peQ = null;
        }

        void a(f<K, V> fVar) {
            fVar.pfb = null;
            fVar.peZ = null;
            fVar.pfa = null;
            fVar.height = 1;
            if (this.peR > 0 && (this.size & 1) == 0) {
                this.size++;
                this.peR--;
                this.peS++;
            }
            fVar.peZ = this.peQ;
            this.peQ = fVar;
            this.size++;
            if (this.peR > 0 && (this.size & 1) == 0) {
                this.size++;
                this.peR--;
                this.peS++;
            }
            for (int i = 4; (this.size & (i - 1)) == i - 1; i *= 2) {
                if (this.peS == 0) {
                    f<K, V> fVar2 = this.peQ;
                    f<K, V> fVar3 = fVar2.peZ;
                    f<K, V> fVar4 = fVar3.peZ;
                    fVar3.peZ = fVar4.peZ;
                    this.peQ = fVar3;
                    fVar3.pfa = fVar4;
                    fVar3.pfb = fVar2;
                    fVar3.height = fVar2.height + 1;
                    fVar4.peZ = fVar3;
                    fVar2.peZ = fVar3;
                } else if (this.peS == 1) {
                    f<K, V> fVar5 = this.peQ;
                    f<K, V> fVar6 = fVar5.peZ;
                    this.peQ = fVar6;
                    fVar6.pfb = fVar5;
                    fVar6.height = fVar5.height + 1;
                    fVar5.peZ = fVar6;
                    this.peS = 0;
                } else if (this.peS == 2) {
                    this.peS = 0;
                }
            }
        }

        f<K, V> esL() {
            f<K, V> fVar = this.peQ;
            if (fVar.peZ != null) {
                throw new IllegalStateException();
            }
            return fVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public abstract class e<T> implements Iterator<T> {
        int expectedModCount;
        f<K, V> peX;
        f<K, V> peY = null;

        e() {
            this.peX = LinkedHashTreeMap.this.header.peX;
            this.expectedModCount = LinkedHashTreeMap.this.modCount;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.peX != LinkedHashTreeMap.this.header;
        }

        final f<K, V> esN() {
            f<K, V> fVar = this.peX;
            if (fVar == LinkedHashTreeMap.this.header) {
                throw new NoSuchElementException();
            }
            if (LinkedHashTreeMap.this.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
            this.peX = fVar.peX;
            this.peY = fVar;
            return fVar;
        }

        @Override // java.util.Iterator
        public final void remove() {
            if (this.peY == null) {
                throw new IllegalStateException();
            }
            LinkedHashTreeMap.this.removeInternal(this.peY, true);
            this.peY = null;
            this.expectedModCount = LinkedHashTreeMap.this.modCount;
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
                    return esN();
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
                    return esN().key;
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
