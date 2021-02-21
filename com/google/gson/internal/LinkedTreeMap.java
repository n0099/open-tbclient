package com.google.gson.internal;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
/* loaded from: classes5.dex */
public final class LinkedTreeMap<K, V> extends AbstractMap<K, V> implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final Comparator<Comparable> NATURAL_ORDER;
    Comparator<? super K> comparator;
    private LinkedTreeMap<K, V>.a entrySet;
    final d<K, V> header;
    private LinkedTreeMap<K, V>.b keySet;
    int modCount;
    d<K, V> root;
    int size;

    static {
        $assertionsDisabled = !LinkedTreeMap.class.desiredAssertionStatus();
        NATURAL_ORDER = new Comparator<Comparable>() { // from class: com.google.gson.internal.LinkedTreeMap.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: b */
            public int compare(Comparable comparable, Comparable comparable2) {
                return comparable.compareTo(comparable2);
            }
        };
    }

    public LinkedTreeMap() {
        this(NATURAL_ORDER);
    }

    public LinkedTreeMap(Comparator<? super K> comparator) {
        this.size = 0;
        this.modCount = 0;
        this.header = new d<>();
        this.comparator = comparator == null ? NATURAL_ORDER : comparator;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.size;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        d<K, V> findByObject = findByObject(obj);
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
        d<K, V> find = find(k, true);
        V v2 = find.value;
        find.value = v;
        return v2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.root = null;
        this.size = 0;
        this.modCount++;
        d<K, V> dVar = this.header;
        dVar.pTj = dVar;
        dVar.pTe = dVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        d<K, V> removeInternalByKey = removeInternalByKey(obj);
        if (removeInternalByKey != null) {
            return removeInternalByKey.value;
        }
        return null;
    }

    /* JADX DEBUG: Type inference failed for r3v3. Raw type applied. Possible types: K, ? super K */
    d<K, V> find(K k, boolean z) {
        int i;
        d<K, V> dVar;
        Comparator<? super K> comparator = this.comparator;
        d<K, V> dVar2 = this.root;
        if (dVar2 == null) {
            i = 0;
        } else {
            Comparable comparable = comparator == NATURAL_ORDER ? (Comparable) k : null;
            while (true) {
                if (comparable != null) {
                    i = comparable.compareTo(dVar2.key);
                } else {
                    i = comparator.compare(k, (K) dVar2.key);
                }
                if (i == 0) {
                    return dVar2;
                }
                d<K, V> dVar3 = i < 0 ? dVar2.pTh : dVar2.pTi;
                if (dVar3 == null) {
                    break;
                }
                dVar2 = dVar3;
            }
        }
        if (z) {
            d<K, V> dVar4 = this.header;
            if (dVar2 == null) {
                if (comparator == NATURAL_ORDER && !(k instanceof Comparable)) {
                    throw new ClassCastException(k.getClass().getName() + " is not Comparable");
                }
                dVar = new d<>(dVar2, k, dVar4, dVar4.pTj);
                this.root = dVar;
            } else {
                dVar = new d<>(dVar2, k, dVar4, dVar4.pTj);
                if (i < 0) {
                    dVar2.pTh = dVar;
                } else {
                    dVar2.pTi = dVar;
                }
                rebalance(dVar2, true);
            }
            this.size++;
            this.modCount++;
            return dVar;
        }
        return null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    d<K, V> findByObject(Object obj) {
        if (obj != 0) {
            try {
                return find(obj, false);
            } catch (ClassCastException e) {
                return null;
            }
        }
        return null;
    }

    d<K, V> findByEntry(Map.Entry<?, ?> entry) {
        d<K, V> findByObject = findByObject(entry.getKey());
        if (findByObject != null && equal(findByObject.value, entry.getValue())) {
            return findByObject;
        }
        return null;
    }

    private boolean equal(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    void removeInternal(d<K, V> dVar, boolean z) {
        int i;
        int i2 = 0;
        if (z) {
            dVar.pTj.pTe = dVar.pTe;
            dVar.pTe.pTj = dVar.pTj;
        }
        d<K, V> dVar2 = dVar.pTh;
        d<K, V> dVar3 = dVar.pTi;
        d<K, V> dVar4 = dVar.pTg;
        if (dVar2 != null && dVar3 != null) {
            d<K, V> eBt = dVar2.height > dVar3.height ? dVar2.eBt() : dVar3.eBs();
            removeInternal(eBt, false);
            d<K, V> dVar5 = dVar.pTh;
            if (dVar5 != null) {
                i = dVar5.height;
                eBt.pTh = dVar5;
                dVar5.pTg = eBt;
                dVar.pTh = null;
            } else {
                i = 0;
            }
            d<K, V> dVar6 = dVar.pTi;
            if (dVar6 != null) {
                i2 = dVar6.height;
                eBt.pTi = dVar6;
                dVar6.pTg = eBt;
                dVar.pTi = null;
            }
            eBt.height = Math.max(i, i2) + 1;
            replaceInParent(dVar, eBt);
            return;
        }
        if (dVar2 != null) {
            replaceInParent(dVar, dVar2);
            dVar.pTh = null;
        } else if (dVar3 != null) {
            replaceInParent(dVar, dVar3);
            dVar.pTi = null;
        } else {
            replaceInParent(dVar, null);
        }
        rebalance(dVar4, false);
        this.size--;
        this.modCount++;
    }

    d<K, V> removeInternalByKey(Object obj) {
        d<K, V> findByObject = findByObject(obj);
        if (findByObject != null) {
            removeInternal(findByObject, true);
        }
        return findByObject;
    }

    private void replaceInParent(d<K, V> dVar, d<K, V> dVar2) {
        d<K, V> dVar3 = dVar.pTg;
        dVar.pTg = null;
        if (dVar2 != null) {
            dVar2.pTg = dVar3;
        }
        if (dVar3 != null) {
            if (dVar3.pTh == dVar) {
                dVar3.pTh = dVar2;
                return;
            } else if (!$assertionsDisabled && dVar3.pTi != dVar) {
                throw new AssertionError();
            } else {
                dVar3.pTi = dVar2;
                return;
            }
        }
        this.root = dVar2;
    }

    private void rebalance(d<K, V> dVar, boolean z) {
        while (dVar != null) {
            d<K, V> dVar2 = dVar.pTh;
            d<K, V> dVar3 = dVar.pTi;
            int i = dVar2 != null ? dVar2.height : 0;
            int i2 = dVar3 != null ? dVar3.height : 0;
            int i3 = i - i2;
            if (i3 == -2) {
                d<K, V> dVar4 = dVar3.pTh;
                d<K, V> dVar5 = dVar3.pTi;
                int i4 = (dVar4 != null ? dVar4.height : 0) - (dVar5 != null ? dVar5.height : 0);
                if (i4 == -1 || (i4 == 0 && !z)) {
                    rotateLeft(dVar);
                } else if (!$assertionsDisabled && i4 != 1) {
                    throw new AssertionError();
                } else {
                    rotateRight(dVar3);
                    rotateLeft(dVar);
                }
                if (z) {
                    return;
                }
            } else if (i3 == 2) {
                d<K, V> dVar6 = dVar2.pTh;
                d<K, V> dVar7 = dVar2.pTi;
                int i5 = (dVar6 != null ? dVar6.height : 0) - (dVar7 != null ? dVar7.height : 0);
                if (i5 == 1 || (i5 == 0 && !z)) {
                    rotateRight(dVar);
                } else if (!$assertionsDisabled && i5 != -1) {
                    throw new AssertionError();
                } else {
                    rotateLeft(dVar2);
                    rotateRight(dVar);
                }
                if (z) {
                    return;
                }
            } else if (i3 == 0) {
                dVar.height = i + 1;
                if (z) {
                    return;
                }
            } else if (!$assertionsDisabled && i3 != -1 && i3 != 1) {
                throw new AssertionError();
            } else {
                dVar.height = Math.max(i, i2) + 1;
                if (!z) {
                    return;
                }
            }
            dVar = dVar.pTg;
        }
    }

    private void rotateLeft(d<K, V> dVar) {
        d<K, V> dVar2 = dVar.pTh;
        d<K, V> dVar3 = dVar.pTi;
        d<K, V> dVar4 = dVar3.pTh;
        d<K, V> dVar5 = dVar3.pTi;
        dVar.pTi = dVar4;
        if (dVar4 != null) {
            dVar4.pTg = dVar;
        }
        replaceInParent(dVar, dVar3);
        dVar3.pTh = dVar;
        dVar.pTg = dVar3;
        dVar.height = Math.max(dVar2 != null ? dVar2.height : 0, dVar4 != null ? dVar4.height : 0) + 1;
        dVar3.height = Math.max(dVar.height, dVar5 != null ? dVar5.height : 0) + 1;
    }

    private void rotateRight(d<K, V> dVar) {
        d<K, V> dVar2 = dVar.pTh;
        d<K, V> dVar3 = dVar.pTi;
        d<K, V> dVar4 = dVar2.pTh;
        d<K, V> dVar5 = dVar2.pTi;
        dVar.pTh = dVar5;
        if (dVar5 != null) {
            dVar5.pTg = dVar;
        }
        replaceInParent(dVar, dVar2);
        dVar2.pTi = dVar;
        dVar.pTg = dVar2;
        dVar.height = Math.max(dVar3 != null ? dVar3.height : 0, dVar5 != null ? dVar5.height : 0) + 1;
        dVar2.height = Math.max(dVar.height, dVar4 != null ? dVar4.height : 0) + 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        LinkedTreeMap<K, V>.a aVar = this.entrySet;
        if (aVar != null) {
            return aVar;
        }
        LinkedTreeMap<K, V>.a aVar2 = new a();
        this.entrySet = aVar2;
        return aVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        LinkedTreeMap<K, V>.b bVar = this.keySet;
        if (bVar != null) {
            return bVar;
        }
        LinkedTreeMap<K, V>.b bVar2 = new b();
        this.keySet = bVar2;
        return bVar2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class d<K, V> implements Map.Entry<K, V> {
        int height;
        final K key;
        d<K, V> pTe;
        d<K, V> pTg;
        d<K, V> pTh;
        d<K, V> pTi;
        d<K, V> pTj;
        V value;

        d() {
            this.key = null;
            this.pTj = this;
            this.pTe = this;
        }

        d(d<K, V> dVar, K k, d<K, V> dVar2, d<K, V> dVar3) {
            this.pTg = dVar;
            this.key = k;
            this.height = 1;
            this.pTe = dVar2;
            this.pTj = dVar3;
            dVar3.pTe = this;
            dVar2.pTj = this;
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

        public d<K, V> eBs() {
            for (d<K, V> dVar = this.pTh; dVar != null; dVar = dVar.pTh) {
                this = dVar;
            }
            return this;
        }

        public d<K, V> eBt() {
            for (d<K, V> dVar = this.pTi; dVar != null; dVar = dVar.pTi) {
                this = dVar;
            }
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public abstract class c<T> implements Iterator<T> {
        int expectedModCount;
        d<K, V> pTe;
        d<K, V> pTf = null;

        c() {
            this.pTe = LinkedTreeMap.this.header.pTe;
            this.expectedModCount = LinkedTreeMap.this.modCount;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.pTe != LinkedTreeMap.this.header;
        }

        final d<K, V> eBr() {
            d<K, V> dVar = this.pTe;
            if (dVar == LinkedTreeMap.this.header) {
                throw new NoSuchElementException();
            }
            if (LinkedTreeMap.this.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
            this.pTe = dVar.pTe;
            this.pTf = dVar;
            return dVar;
        }

        @Override // java.util.Iterator
        public final void remove() {
            if (this.pTf == null) {
                throw new IllegalStateException();
            }
            LinkedTreeMap.this.removeInternal(this.pTf, true);
            this.pTf = null;
            this.expectedModCount = LinkedTreeMap.this.modCount;
        }
    }

    /* loaded from: classes5.dex */
    class a extends AbstractSet<Map.Entry<K, V>> {
        a() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return LinkedTreeMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new LinkedTreeMap<K, V>.c<Map.Entry<K, V>>() { // from class: com.google.gson.internal.LinkedTreeMap.a.1
                {
                    LinkedTreeMap linkedTreeMap = LinkedTreeMap.this;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Iterator
                public Map.Entry<K, V> next() {
                    return eBr();
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return (obj instanceof Map.Entry) && LinkedTreeMap.this.findByEntry((Map.Entry) obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            d<K, V> findByEntry;
            if ((obj instanceof Map.Entry) && (findByEntry = LinkedTreeMap.this.findByEntry((Map.Entry) obj)) != null) {
                LinkedTreeMap.this.removeInternal(findByEntry, true);
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            LinkedTreeMap.this.clear();
        }
    }

    /* loaded from: classes5.dex */
    final class b extends AbstractSet<K> {
        b() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return LinkedTreeMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new LinkedTreeMap<K, V>.c<K>() { // from class: com.google.gson.internal.LinkedTreeMap.b.1
                {
                    LinkedTreeMap linkedTreeMap = LinkedTreeMap.this;
                }

                @Override // java.util.Iterator
                public K next() {
                    return eBr().key;
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return LinkedTreeMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return LinkedTreeMap.this.removeInternalByKey(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            LinkedTreeMap.this.clear();
        }
    }

    private Object writeReplace() throws ObjectStreamException {
        return new LinkedHashMap(this);
    }
}
