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
/* loaded from: classes2.dex */
public final class LinkedTreeMap<K, V> extends AbstractMap<K, V> implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final Comparator<Comparable> hNk;
    Comparator<? super K> comparator;
    private LinkedTreeMap<K, V>.a entrySet;
    final d<K, V> header;
    private LinkedTreeMap<K, V>.b keySet;
    int modCount;
    d<K, V> root;
    int size;

    static {
        $assertionsDisabled = !LinkedTreeMap.class.desiredAssertionStatus();
        hNk = new Comparator<Comparable>() { // from class: com.google.gson.internal.LinkedTreeMap.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: b */
            public int compare(Comparable comparable, Comparable comparable2) {
                return comparable.compareTo(comparable2);
            }
        };
    }

    public LinkedTreeMap() {
        this(hNk);
    }

    public LinkedTreeMap(Comparator<? super K> comparator) {
        this.size = 0;
        this.modCount = 0;
        this.header = new d<>();
        this.comparator = comparator == null ? hNk : comparator;
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
        dVar.hNu = dVar;
        dVar.hNo = dVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        d<K, V> removeInternalByKey = removeInternalByKey(obj);
        if (removeInternalByKey != null) {
            return removeInternalByKey.value;
        }
        return null;
    }

    /* JADX DEBUG: Type inference failed for r3v2. Raw type applied. Possible types: K, ? super K */
    d<K, V> find(K k, boolean z) {
        d<K, V> dVar;
        int i;
        d<K, V> dVar2;
        Comparator<? super K> comparator = this.comparator;
        d<K, V> dVar3 = this.root;
        if (dVar3 == null) {
            dVar = dVar3;
            i = 0;
        } else {
            Comparable comparable = comparator == hNk ? (Comparable) k : null;
            while (true) {
                int compareTo = comparable != null ? comparable.compareTo(dVar3.hNv) : comparator.compare(k, (K) dVar3.hNv);
                if (compareTo == 0) {
                    return dVar3;
                }
                d<K, V> dVar4 = compareTo < 0 ? dVar3.hNs : dVar3.hNt;
                if (dVar4 == null) {
                    int i2 = compareTo;
                    dVar = dVar3;
                    i = i2;
                    break;
                }
                dVar3 = dVar4;
            }
        }
        if (z) {
            d<K, V> dVar5 = this.header;
            if (dVar == null) {
                if (comparator == hNk && !(k instanceof Comparable)) {
                    throw new ClassCastException(k.getClass().getName() + " is not Comparable");
                }
                dVar2 = new d<>(dVar, k, dVar5, dVar5.hNu);
                this.root = dVar2;
            } else {
                dVar2 = new d<>(dVar, k, dVar5, dVar5.hNu);
                if (i < 0) {
                    dVar.hNs = dVar2;
                } else {
                    dVar.hNt = dVar2;
                }
                a((d) dVar, true);
            }
            this.size++;
            this.modCount++;
            return dVar2;
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
            dVar.hNu.hNo = dVar.hNo;
            dVar.hNo.hNu = dVar.hNu;
        }
        d<K, V> dVar2 = dVar.hNs;
        d<K, V> dVar3 = dVar.hNt;
        d<K, V> dVar4 = dVar.hNr;
        if (dVar2 != null && dVar3 != null) {
            d<K, V> bOw = dVar2.height > dVar3.height ? dVar2.bOw() : dVar3.bOv();
            removeInternal(bOw, false);
            d<K, V> dVar5 = dVar.hNs;
            if (dVar5 != null) {
                i = dVar5.height;
                bOw.hNs = dVar5;
                dVar5.hNr = bOw;
                dVar.hNs = null;
            } else {
                i = 0;
            }
            d<K, V> dVar6 = dVar.hNt;
            if (dVar6 != null) {
                i2 = dVar6.height;
                bOw.hNt = dVar6;
                dVar6.hNr = bOw;
                dVar.hNt = null;
            }
            bOw.height = Math.max(i, i2) + 1;
            a(dVar, bOw);
            return;
        }
        if (dVar2 != null) {
            a(dVar, dVar2);
            dVar.hNs = null;
        } else if (dVar3 != null) {
            a(dVar, dVar3);
            dVar.hNt = null;
        } else {
            a(dVar, (d) null);
        }
        a((d) dVar4, false);
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

    private void a(d<K, V> dVar, d<K, V> dVar2) {
        d<K, V> dVar3 = dVar.hNr;
        dVar.hNr = null;
        if (dVar2 != null) {
            dVar2.hNr = dVar3;
        }
        if (dVar3 != null) {
            if (dVar3.hNs == dVar) {
                dVar3.hNs = dVar2;
                return;
            } else if (!$assertionsDisabled && dVar3.hNt != dVar) {
                throw new AssertionError();
            } else {
                dVar3.hNt = dVar2;
                return;
            }
        }
        this.root = dVar2;
    }

    private void a(d<K, V> dVar, boolean z) {
        while (dVar != null) {
            d<K, V> dVar2 = dVar.hNs;
            d<K, V> dVar3 = dVar.hNt;
            int i = dVar2 != null ? dVar2.height : 0;
            int i2 = dVar3 != null ? dVar3.height : 0;
            int i3 = i - i2;
            if (i3 == -2) {
                d<K, V> dVar4 = dVar3.hNs;
                d<K, V> dVar5 = dVar3.hNt;
                int i4 = (dVar4 != null ? dVar4.height : 0) - (dVar5 != null ? dVar5.height : 0);
                if (i4 == -1 || (i4 == 0 && !z)) {
                    a(dVar);
                } else if (!$assertionsDisabled && i4 != 1) {
                    throw new AssertionError();
                } else {
                    b(dVar3);
                    a(dVar);
                }
                if (z) {
                    return;
                }
            } else if (i3 == 2) {
                d<K, V> dVar6 = dVar2.hNs;
                d<K, V> dVar7 = dVar2.hNt;
                int i5 = (dVar6 != null ? dVar6.height : 0) - (dVar7 != null ? dVar7.height : 0);
                if (i5 == 1 || (i5 == 0 && !z)) {
                    b(dVar);
                } else if (!$assertionsDisabled && i5 != -1) {
                    throw new AssertionError();
                } else {
                    a(dVar2);
                    b(dVar);
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
            dVar = dVar.hNr;
        }
    }

    private void a(d<K, V> dVar) {
        d<K, V> dVar2 = dVar.hNs;
        d<K, V> dVar3 = dVar.hNt;
        d<K, V> dVar4 = dVar3.hNs;
        d<K, V> dVar5 = dVar3.hNt;
        dVar.hNt = dVar4;
        if (dVar4 != null) {
            dVar4.hNr = dVar;
        }
        a(dVar, dVar3);
        dVar3.hNs = dVar;
        dVar.hNr = dVar3;
        dVar.height = Math.max(dVar2 != null ? dVar2.height : 0, dVar4 != null ? dVar4.height : 0) + 1;
        dVar3.height = Math.max(dVar.height, dVar5 != null ? dVar5.height : 0) + 1;
    }

    private void b(d<K, V> dVar) {
        d<K, V> dVar2 = dVar.hNs;
        d<K, V> dVar3 = dVar.hNt;
        d<K, V> dVar4 = dVar2.hNs;
        d<K, V> dVar5 = dVar2.hNt;
        dVar.hNs = dVar5;
        if (dVar5 != null) {
            dVar5.hNr = dVar;
        }
        a(dVar, dVar2);
        dVar2.hNt = dVar;
        dVar.hNr = dVar2;
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
    /* loaded from: classes2.dex */
    public static final class d<K, V> implements Map.Entry<K, V> {
        d<K, V> hNo;
        d<K, V> hNr;
        d<K, V> hNs;
        d<K, V> hNt;
        d<K, V> hNu;
        final K hNv;
        int height;
        V value;

        d() {
            this.hNv = null;
            this.hNu = this;
            this.hNo = this;
        }

        d(d<K, V> dVar, K k, d<K, V> dVar2, d<K, V> dVar3) {
            this.hNr = dVar;
            this.hNv = k;
            this.height = 1;
            this.hNo = dVar2;
            this.hNu = dVar3;
            dVar3.hNo = this;
            dVar2.hNu = this;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.hNv;
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
                if (this.hNv == null) {
                    if (entry.getKey() != null) {
                        return false;
                    }
                } else if (!this.hNv.equals(entry.getKey())) {
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
            return (this.hNv == null ? 0 : this.hNv.hashCode()) ^ (this.value != null ? this.value.hashCode() : 0);
        }

        public String toString() {
            return this.hNv + "=" + this.value;
        }

        public d<K, V> bOv() {
            for (d<K, V> dVar = this.hNs; dVar != null; dVar = dVar.hNs) {
                this = dVar;
            }
            return this;
        }

        public d<K, V> bOw() {
            for (d<K, V> dVar = this.hNt; dVar != null; dVar = dVar.hNt) {
                this = dVar;
            }
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public abstract class c<T> implements Iterator<T> {
        d<K, V> hNo;
        d<K, V> hNp;
        int hNq;

        private c() {
            this.hNo = LinkedTreeMap.this.header.hNo;
            this.hNp = null;
            this.hNq = LinkedTreeMap.this.modCount;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.hNo != LinkedTreeMap.this.header;
        }

        final d<K, V> bOu() {
            d<K, V> dVar = this.hNo;
            if (dVar == LinkedTreeMap.this.header) {
                throw new NoSuchElementException();
            }
            if (LinkedTreeMap.this.modCount != this.hNq) {
                throw new ConcurrentModificationException();
            }
            this.hNo = dVar.hNo;
            this.hNp = dVar;
            return dVar;
        }

        @Override // java.util.Iterator
        public final void remove() {
            if (this.hNp == null) {
                throw new IllegalStateException();
            }
            LinkedTreeMap.this.removeInternal(this.hNp, true);
            this.hNp = null;
            this.hNq = LinkedTreeMap.this.modCount;
        }
    }

    /* loaded from: classes2.dex */
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
                    return bOu();
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

    /* loaded from: classes2.dex */
    class b extends AbstractSet<K> {
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
                    return bOu().hNv;
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
