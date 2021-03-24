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
/* loaded from: classes6.dex */
public final class LinkedTreeMap<K, V> extends AbstractMap<K, V> implements Serializable {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final Comparator<Comparable> NATURAL_ORDER = new a();
    public Comparator<? super K> comparator;
    public LinkedTreeMap<K, V>.b entrySet;
    public final e<K, V> header;
    public LinkedTreeMap<K, V>.c keySet;
    public int modCount;
    public e<K, V> root;
    public int size;

    /* loaded from: classes6.dex */
    public static class a implements Comparator<Comparable> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    }

    /* loaded from: classes6.dex */
    public class b extends AbstractSet<Map.Entry<K, V>> {

        /* loaded from: classes6.dex */
        public class a extends LinkedTreeMap<K, V>.d<Map.Entry<K, V>> {
            public a(b bVar) {
                super();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Iterator
            /* renamed from: b */
            public Map.Entry<K, V> next() {
                return a();
            }
        }

        public b() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            LinkedTreeMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return (obj instanceof Map.Entry) && LinkedTreeMap.this.findByEntry((Map.Entry) obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new a(this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            e<K, V> findByEntry;
            if ((obj instanceof Map.Entry) && (findByEntry = LinkedTreeMap.this.findByEntry((Map.Entry) obj)) != null) {
                LinkedTreeMap.this.removeInternal(findByEntry, true);
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return LinkedTreeMap.this.size;
        }
    }

    /* loaded from: classes6.dex */
    public final class c extends AbstractSet<K> {

        /* loaded from: classes6.dex */
        public class a extends LinkedTreeMap<K, V>.d<K> {
            public a(c cVar) {
                super();
            }

            @Override // java.util.Iterator
            public K next() {
                return a().j;
            }
        }

        public c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            LinkedTreeMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return LinkedTreeMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new a(this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return LinkedTreeMap.this.removeInternalByKey(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return LinkedTreeMap.this.size;
        }
    }

    /* loaded from: classes6.dex */
    public abstract class d<T> implements Iterator<T> {

        /* renamed from: e  reason: collision with root package name */
        public e<K, V> f30933e;

        /* renamed from: f  reason: collision with root package name */
        public e<K, V> f30934f;

        /* renamed from: g  reason: collision with root package name */
        public int f30935g;

        public d() {
            LinkedTreeMap linkedTreeMap = LinkedTreeMap.this;
            this.f30933e = linkedTreeMap.header.f30940h;
            this.f30934f = null;
            this.f30935g = linkedTreeMap.modCount;
        }

        public final e<K, V> a() {
            e<K, V> eVar = this.f30933e;
            LinkedTreeMap linkedTreeMap = LinkedTreeMap.this;
            if (eVar != linkedTreeMap.header) {
                if (linkedTreeMap.modCount == this.f30935g) {
                    this.f30933e = eVar.f30940h;
                    this.f30934f = eVar;
                    return eVar;
                }
                throw new ConcurrentModificationException();
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f30933e != LinkedTreeMap.this.header;
        }

        @Override // java.util.Iterator
        public final void remove() {
            e<K, V> eVar = this.f30934f;
            if (eVar != null) {
                LinkedTreeMap.this.removeInternal(eVar, true);
                this.f30934f = null;
                this.f30935g = LinkedTreeMap.this.modCount;
                return;
            }
            throw new IllegalStateException();
        }
    }

    public LinkedTreeMap() {
        this(NATURAL_ORDER);
    }

    private boolean equal(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    private void rebalance(e<K, V> eVar, boolean z) {
        while (eVar != null) {
            e<K, V> eVar2 = eVar.f30938f;
            e<K, V> eVar3 = eVar.f30939g;
            int i = eVar2 != null ? eVar2.l : 0;
            int i2 = eVar3 != null ? eVar3.l : 0;
            int i3 = i - i2;
            if (i3 == -2) {
                e<K, V> eVar4 = eVar3.f30938f;
                e<K, V> eVar5 = eVar3.f30939g;
                int i4 = (eVar4 != null ? eVar4.l : 0) - (eVar5 != null ? eVar5.l : 0);
                if (i4 != -1 && (i4 != 0 || z)) {
                    rotateRight(eVar3);
                    rotateLeft(eVar);
                } else {
                    rotateLeft(eVar);
                }
                if (z) {
                    return;
                }
            } else if (i3 == 2) {
                e<K, V> eVar6 = eVar2.f30938f;
                e<K, V> eVar7 = eVar2.f30939g;
                int i5 = (eVar6 != null ? eVar6.l : 0) - (eVar7 != null ? eVar7.l : 0);
                if (i5 != 1 && (i5 != 0 || z)) {
                    rotateLeft(eVar2);
                    rotateRight(eVar);
                } else {
                    rotateRight(eVar);
                }
                if (z) {
                    return;
                }
            } else if (i3 == 0) {
                eVar.l = i + 1;
                if (z) {
                    return;
                }
            } else {
                eVar.l = Math.max(i, i2) + 1;
                if (!z) {
                    return;
                }
            }
            eVar = eVar.f30937e;
        }
    }

    private void replaceInParent(e<K, V> eVar, e<K, V> eVar2) {
        e<K, V> eVar3 = eVar.f30937e;
        eVar.f30937e = null;
        if (eVar2 != null) {
            eVar2.f30937e = eVar3;
        }
        if (eVar3 != null) {
            if (eVar3.f30938f == eVar) {
                eVar3.f30938f = eVar2;
                return;
            } else {
                eVar3.f30939g = eVar2;
                return;
            }
        }
        this.root = eVar2;
    }

    private void rotateLeft(e<K, V> eVar) {
        e<K, V> eVar2 = eVar.f30938f;
        e<K, V> eVar3 = eVar.f30939g;
        e<K, V> eVar4 = eVar3.f30938f;
        e<K, V> eVar5 = eVar3.f30939g;
        eVar.f30939g = eVar4;
        if (eVar4 != null) {
            eVar4.f30937e = eVar;
        }
        replaceInParent(eVar, eVar3);
        eVar3.f30938f = eVar;
        eVar.f30937e = eVar3;
        int max = Math.max(eVar2 != null ? eVar2.l : 0, eVar4 != null ? eVar4.l : 0) + 1;
        eVar.l = max;
        eVar3.l = Math.max(max, eVar5 != null ? eVar5.l : 0) + 1;
    }

    private void rotateRight(e<K, V> eVar) {
        e<K, V> eVar2 = eVar.f30938f;
        e<K, V> eVar3 = eVar.f30939g;
        e<K, V> eVar4 = eVar2.f30938f;
        e<K, V> eVar5 = eVar2.f30939g;
        eVar.f30938f = eVar5;
        if (eVar5 != null) {
            eVar5.f30937e = eVar;
        }
        replaceInParent(eVar, eVar2);
        eVar2.f30939g = eVar;
        eVar.f30937e = eVar2;
        int max = Math.max(eVar3 != null ? eVar3.l : 0, eVar5 != null ? eVar5.l : 0) + 1;
        eVar.l = max;
        eVar2.l = Math.max(max, eVar4 != null ? eVar4.l : 0) + 1;
    }

    private Object writeReplace() throws ObjectStreamException {
        return new LinkedHashMap(this);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.root = null;
        this.size = 0;
        this.modCount++;
        e<K, V> eVar = this.header;
        eVar.i = eVar;
        eVar.f30940h = eVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return findByObject(obj) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        LinkedTreeMap<K, V>.b bVar = this.entrySet;
        if (bVar != null) {
            return bVar;
        }
        LinkedTreeMap<K, V>.b bVar2 = new b();
        this.entrySet = bVar2;
        return bVar2;
    }

    /* JADX DEBUG: Type inference failed for r4v2. Raw type applied. Possible types: K, ? super K */
    public e<K, V> find(K k, boolean z) {
        int i;
        e<K, V> eVar;
        Comparator<? super K> comparator = this.comparator;
        e<K, V> eVar2 = this.root;
        if (eVar2 != null) {
            Comparable comparable = comparator == NATURAL_ORDER ? (Comparable) k : null;
            while (true) {
                if (comparable != null) {
                    i = comparable.compareTo(eVar2.j);
                } else {
                    i = comparator.compare(k, (K) eVar2.j);
                }
                if (i == 0) {
                    return eVar2;
                }
                e<K, V> eVar3 = i < 0 ? eVar2.f30938f : eVar2.f30939g;
                if (eVar3 == null) {
                    break;
                }
                eVar2 = eVar3;
            }
        } else {
            i = 0;
        }
        if (z) {
            e<K, V> eVar4 = this.header;
            if (eVar2 == null) {
                if (comparator == NATURAL_ORDER && !(k instanceof Comparable)) {
                    throw new ClassCastException(k.getClass().getName() + " is not Comparable");
                }
                eVar = new e<>(eVar2, k, eVar4, eVar4.i);
                this.root = eVar;
            } else {
                eVar = new e<>(eVar2, k, eVar4, eVar4.i);
                if (i < 0) {
                    eVar2.f30938f = eVar;
                } else {
                    eVar2.f30939g = eVar;
                }
                rebalance(eVar2, true);
            }
            this.size++;
            this.modCount++;
            return eVar;
        }
        return null;
    }

    public e<K, V> findByEntry(Map.Entry<?, ?> entry) {
        e<K, V> findByObject = findByObject(entry.getKey());
        if (findByObject != null && equal(findByObject.k, entry.getValue())) {
            return findByObject;
        }
        return null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    public e<K, V> findByObject(Object obj) {
        if (obj != 0) {
            try {
                return find(obj, false);
            } catch (ClassCastException unused) {
                return null;
            }
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        e<K, V> findByObject = findByObject(obj);
        if (findByObject != null) {
            return findByObject.k;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        LinkedTreeMap<K, V>.c cVar = this.keySet;
        if (cVar != null) {
            return cVar;
        }
        LinkedTreeMap<K, V>.c cVar2 = new c();
        this.keySet = cVar2;
        return cVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k, V v) {
        if (k != null) {
            e<K, V> find = find(k, true);
            V v2 = find.k;
            find.k = v;
            return v2;
        }
        throw new NullPointerException("key == null");
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        e<K, V> removeInternalByKey = removeInternalByKey(obj);
        if (removeInternalByKey != null) {
            return removeInternalByKey.k;
        }
        return null;
    }

    public void removeInternal(e<K, V> eVar, boolean z) {
        int i;
        if (z) {
            e<K, V> eVar2 = eVar.i;
            eVar2.f30940h = eVar.f30940h;
            eVar.f30940h.i = eVar2;
        }
        e<K, V> eVar3 = eVar.f30938f;
        e<K, V> eVar4 = eVar.f30939g;
        e<K, V> eVar5 = eVar.f30937e;
        int i2 = 0;
        if (eVar3 != null && eVar4 != null) {
            e<K, V> b2 = eVar3.l > eVar4.l ? eVar3.b() : eVar4.a();
            removeInternal(b2, false);
            e<K, V> eVar6 = eVar.f30938f;
            if (eVar6 != null) {
                i = eVar6.l;
                b2.f30938f = eVar6;
                eVar6.f30937e = b2;
                eVar.f30938f = null;
            } else {
                i = 0;
            }
            e<K, V> eVar7 = eVar.f30939g;
            if (eVar7 != null) {
                i2 = eVar7.l;
                b2.f30939g = eVar7;
                eVar7.f30937e = b2;
                eVar.f30939g = null;
            }
            b2.l = Math.max(i, i2) + 1;
            replaceInParent(eVar, b2);
            return;
        }
        if (eVar3 != null) {
            replaceInParent(eVar, eVar3);
            eVar.f30938f = null;
        } else if (eVar4 != null) {
            replaceInParent(eVar, eVar4);
            eVar.f30939g = null;
        } else {
            replaceInParent(eVar, null);
        }
        rebalance(eVar5, false);
        this.size--;
        this.modCount++;
    }

    public e<K, V> removeInternalByKey(Object obj) {
        e<K, V> findByObject = findByObject(obj);
        if (findByObject != null) {
            removeInternal(findByObject, true);
        }
        return findByObject;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.size;
    }

    public LinkedTreeMap(Comparator<? super K> comparator) {
        this.size = 0;
        this.modCount = 0;
        this.header = new e<>();
        this.comparator = comparator == null ? NATURAL_ORDER : comparator;
    }

    /* loaded from: classes6.dex */
    public static final class e<K, V> implements Map.Entry<K, V> {

        /* renamed from: e  reason: collision with root package name */
        public e<K, V> f30937e;

        /* renamed from: f  reason: collision with root package name */
        public e<K, V> f30938f;

        /* renamed from: g  reason: collision with root package name */
        public e<K, V> f30939g;

        /* renamed from: h  reason: collision with root package name */
        public e<K, V> f30940h;
        public e<K, V> i;
        public final K j;
        public V k;
        public int l;

        public e() {
            this.j = null;
            this.i = this;
            this.f30940h = this;
        }

        public e<K, V> a() {
            e<K, V> eVar = this;
            for (e<K, V> eVar2 = this.f30938f; eVar2 != null; eVar2 = eVar2.f30938f) {
                eVar = eVar2;
            }
            return eVar;
        }

        public e<K, V> b() {
            e<K, V> eVar = this;
            for (e<K, V> eVar2 = this.f30939g; eVar2 != null; eVar2 = eVar2.f30939g) {
                eVar = eVar2;
            }
            return eVar;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                K k = this.j;
                if (k == null) {
                    if (entry.getKey() != null) {
                        return false;
                    }
                } else if (!k.equals(entry.getKey())) {
                    return false;
                }
                V v = this.k;
                if (v == null) {
                    if (entry.getValue() != null) {
                        return false;
                    }
                } else if (!v.equals(entry.getValue())) {
                    return false;
                }
                return true;
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.j;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.k;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K k = this.j;
            int hashCode = k == null ? 0 : k.hashCode();
            V v = this.k;
            return hashCode ^ (v != null ? v.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            V v2 = this.k;
            this.k = v;
            return v2;
        }

        public String toString() {
            return this.j + "=" + this.k;
        }

        public e(e<K, V> eVar, K k, e<K, V> eVar2, e<K, V> eVar3) {
            this.f30937e = eVar;
            this.j = k;
            this.l = 1;
            this.f30940h = eVar2;
            this.i = eVar3;
            eVar3.f30940h = this;
            eVar2.i = this;
        }
    }
}
