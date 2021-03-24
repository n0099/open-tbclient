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
/* loaded from: classes6.dex */
public final class LinkedHashTreeMap<K, V> extends AbstractMap<K, V> implements Serializable {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final Comparator<Comparable> NATURAL_ORDER = new a();
    public Comparator<? super K> comparator;
    public LinkedHashTreeMap<K, V>.d entrySet;
    public final g<K, V> header;
    public LinkedHashTreeMap<K, V>.e keySet;
    public int modCount;
    public int size;
    public g<K, V>[] table;
    public int threshold;

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
    public static final class b<K, V> {

        /* renamed from: a  reason: collision with root package name */
        public g<K, V> f30916a;

        /* renamed from: b  reason: collision with root package name */
        public int f30917b;

        /* renamed from: c  reason: collision with root package name */
        public int f30918c;

        /* renamed from: d  reason: collision with root package name */
        public int f30919d;

        public void a(g<K, V> gVar) {
            gVar.f30929g = null;
            gVar.f30927e = null;
            gVar.f30928f = null;
            gVar.m = 1;
            int i = this.f30917b;
            if (i > 0) {
                int i2 = this.f30919d;
                if ((i2 & 1) == 0) {
                    this.f30919d = i2 + 1;
                    this.f30917b = i - 1;
                    this.f30918c++;
                }
            }
            gVar.f30927e = this.f30916a;
            this.f30916a = gVar;
            int i3 = this.f30919d + 1;
            this.f30919d = i3;
            int i4 = this.f30917b;
            if (i4 > 0 && (i3 & 1) == 0) {
                this.f30919d = i3 + 1;
                this.f30917b = i4 - 1;
                this.f30918c++;
            }
            int i5 = 4;
            while (true) {
                int i6 = i5 - 1;
                if ((this.f30919d & i6) != i6) {
                    return;
                }
                int i7 = this.f30918c;
                if (i7 == 0) {
                    g<K, V> gVar2 = this.f30916a;
                    g<K, V> gVar3 = gVar2.f30927e;
                    g<K, V> gVar4 = gVar3.f30927e;
                    gVar3.f30927e = gVar4.f30927e;
                    this.f30916a = gVar3;
                    gVar3.f30928f = gVar4;
                    gVar3.f30929g = gVar2;
                    gVar3.m = gVar2.m + 1;
                    gVar4.f30927e = gVar3;
                    gVar2.f30927e = gVar3;
                } else if (i7 == 1) {
                    g<K, V> gVar5 = this.f30916a;
                    g<K, V> gVar6 = gVar5.f30927e;
                    this.f30916a = gVar6;
                    gVar6.f30929g = gVar5;
                    gVar6.m = gVar5.m + 1;
                    gVar5.f30927e = gVar6;
                    this.f30918c = 0;
                } else if (i7 == 2) {
                    this.f30918c = 0;
                }
                i5 *= 2;
            }
        }

        public void b(int i) {
            this.f30917b = ((Integer.highestOneBit(i) * 2) - 1) - i;
            this.f30919d = 0;
            this.f30918c = 0;
            this.f30916a = null;
        }

        public g<K, V> c() {
            g<K, V> gVar = this.f30916a;
            if (gVar.f30927e == null) {
                return gVar;
            }
            throw new IllegalStateException();
        }
    }

    /* loaded from: classes6.dex */
    public static class c<K, V> {

        /* renamed from: a  reason: collision with root package name */
        public g<K, V> f30920a;

        public g<K, V> a() {
            g<K, V> gVar = this.f30920a;
            if (gVar == null) {
                return null;
            }
            g<K, V> gVar2 = gVar.f30927e;
            gVar.f30927e = null;
            g<K, V> gVar3 = gVar.f30929g;
            while (true) {
                g<K, V> gVar4 = gVar2;
                gVar2 = gVar3;
                if (gVar2 != null) {
                    gVar2.f30927e = gVar4;
                    gVar3 = gVar2.f30928f;
                } else {
                    this.f30920a = gVar4;
                    return gVar;
                }
            }
        }

        public void b(g<K, V> gVar) {
            g<K, V> gVar2 = null;
            while (gVar != null) {
                gVar.f30927e = gVar2;
                gVar2 = gVar;
                gVar = gVar.f30928f;
            }
            this.f30920a = gVar2;
        }
    }

    /* loaded from: classes6.dex */
    public final class d extends AbstractSet<Map.Entry<K, V>> {

        /* loaded from: classes6.dex */
        public class a extends LinkedHashTreeMap<K, V>.f<Map.Entry<K, V>> {
            public a(d dVar) {
                super();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Iterator
            /* renamed from: b */
            public Map.Entry<K, V> next() {
                return a();
            }
        }

        public d() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            LinkedHashTreeMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return (obj instanceof Map.Entry) && LinkedHashTreeMap.this.findByEntry((Map.Entry) obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new a(this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            g<K, V> findByEntry;
            if ((obj instanceof Map.Entry) && (findByEntry = LinkedHashTreeMap.this.findByEntry((Map.Entry) obj)) != null) {
                LinkedHashTreeMap.this.removeInternal(findByEntry, true);
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return LinkedHashTreeMap.this.size;
        }
    }

    /* loaded from: classes6.dex */
    public final class e extends AbstractSet<K> {

        /* loaded from: classes6.dex */
        public class a extends LinkedHashTreeMap<K, V>.f<K> {
            public a(e eVar) {
                super();
            }

            @Override // java.util.Iterator
            public K next() {
                return a().j;
            }
        }

        public e() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            LinkedHashTreeMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return LinkedHashTreeMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new a(this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return LinkedHashTreeMap.this.removeInternalByKey(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return LinkedHashTreeMap.this.size;
        }
    }

    /* loaded from: classes6.dex */
    public abstract class f<T> implements Iterator<T> {

        /* renamed from: e  reason: collision with root package name */
        public g<K, V> f30923e;

        /* renamed from: f  reason: collision with root package name */
        public g<K, V> f30924f;

        /* renamed from: g  reason: collision with root package name */
        public int f30925g;

        public f() {
            LinkedHashTreeMap linkedHashTreeMap = LinkedHashTreeMap.this;
            this.f30923e = linkedHashTreeMap.header.f30930h;
            this.f30924f = null;
            this.f30925g = linkedHashTreeMap.modCount;
        }

        public final g<K, V> a() {
            g<K, V> gVar = this.f30923e;
            LinkedHashTreeMap linkedHashTreeMap = LinkedHashTreeMap.this;
            if (gVar != linkedHashTreeMap.header) {
                if (linkedHashTreeMap.modCount == this.f30925g) {
                    this.f30923e = gVar.f30930h;
                    this.f30924f = gVar;
                    return gVar;
                }
                throw new ConcurrentModificationException();
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f30923e != LinkedHashTreeMap.this.header;
        }

        @Override // java.util.Iterator
        public final void remove() {
            g<K, V> gVar = this.f30924f;
            if (gVar != null) {
                LinkedHashTreeMap.this.removeInternal(gVar, true);
                this.f30924f = null;
                this.f30925g = LinkedHashTreeMap.this.modCount;
                return;
            }
            throw new IllegalStateException();
        }
    }

    public LinkedHashTreeMap() {
        this(NATURAL_ORDER);
    }

    private void doubleCapacity() {
        g<K, V>[] doubleCapacity = doubleCapacity(this.table);
        this.table = doubleCapacity;
        this.threshold = (doubleCapacity.length / 2) + (doubleCapacity.length / 4);
    }

    private boolean equal(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    private void rebalance(g<K, V> gVar, boolean z) {
        while (gVar != null) {
            g<K, V> gVar2 = gVar.f30928f;
            g<K, V> gVar3 = gVar.f30929g;
            int i = gVar2 != null ? gVar2.m : 0;
            int i2 = gVar3 != null ? gVar3.m : 0;
            int i3 = i - i2;
            if (i3 == -2) {
                g<K, V> gVar4 = gVar3.f30928f;
                g<K, V> gVar5 = gVar3.f30929g;
                int i4 = (gVar4 != null ? gVar4.m : 0) - (gVar5 != null ? gVar5.m : 0);
                if (i4 != -1 && (i4 != 0 || z)) {
                    rotateRight(gVar3);
                    rotateLeft(gVar);
                } else {
                    rotateLeft(gVar);
                }
                if (z) {
                    return;
                }
            } else if (i3 == 2) {
                g<K, V> gVar6 = gVar2.f30928f;
                g<K, V> gVar7 = gVar2.f30929g;
                int i5 = (gVar6 != null ? gVar6.m : 0) - (gVar7 != null ? gVar7.m : 0);
                if (i5 != 1 && (i5 != 0 || z)) {
                    rotateLeft(gVar2);
                    rotateRight(gVar);
                } else {
                    rotateRight(gVar);
                }
                if (z) {
                    return;
                }
            } else if (i3 == 0) {
                gVar.m = i + 1;
                if (z) {
                    return;
                }
            } else {
                gVar.m = Math.max(i, i2) + 1;
                if (!z) {
                    return;
                }
            }
            gVar = gVar.f30927e;
        }
    }

    private void replaceInParent(g<K, V> gVar, g<K, V> gVar2) {
        g<K, V> gVar3 = gVar.f30927e;
        gVar.f30927e = null;
        if (gVar2 != null) {
            gVar2.f30927e = gVar3;
        }
        if (gVar3 != null) {
            if (gVar3.f30928f == gVar) {
                gVar3.f30928f = gVar2;
                return;
            } else {
                gVar3.f30929g = gVar2;
                return;
            }
        }
        int i = gVar.k;
        g<K, V>[] gVarArr = this.table;
        gVarArr[i & (gVarArr.length - 1)] = gVar2;
    }

    private void rotateLeft(g<K, V> gVar) {
        g<K, V> gVar2 = gVar.f30928f;
        g<K, V> gVar3 = gVar.f30929g;
        g<K, V> gVar4 = gVar3.f30928f;
        g<K, V> gVar5 = gVar3.f30929g;
        gVar.f30929g = gVar4;
        if (gVar4 != null) {
            gVar4.f30927e = gVar;
        }
        replaceInParent(gVar, gVar3);
        gVar3.f30928f = gVar;
        gVar.f30927e = gVar3;
        int max = Math.max(gVar2 != null ? gVar2.m : 0, gVar4 != null ? gVar4.m : 0) + 1;
        gVar.m = max;
        gVar3.m = Math.max(max, gVar5 != null ? gVar5.m : 0) + 1;
    }

    private void rotateRight(g<K, V> gVar) {
        g<K, V> gVar2 = gVar.f30928f;
        g<K, V> gVar3 = gVar.f30929g;
        g<K, V> gVar4 = gVar2.f30928f;
        g<K, V> gVar5 = gVar2.f30929g;
        gVar.f30928f = gVar5;
        if (gVar5 != null) {
            gVar5.f30927e = gVar;
        }
        replaceInParent(gVar, gVar2);
        gVar2.f30929g = gVar;
        gVar.f30927e = gVar2;
        int max = Math.max(gVar3 != null ? gVar3.m : 0, gVar5 != null ? gVar5.m : 0) + 1;
        gVar.m = max;
        gVar2.m = Math.max(max, gVar4 != null ? gVar4.m : 0) + 1;
    }

    public static int secondaryHash(int i) {
        int i2 = i ^ ((i >>> 20) ^ (i >>> 12));
        return (i2 >>> 4) ^ ((i2 >>> 7) ^ i2);
    }

    private Object writeReplace() throws ObjectStreamException {
        return new LinkedHashMap(this);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        Arrays.fill(this.table, (Object) null);
        this.size = 0;
        this.modCount++;
        g<K, V> gVar = this.header;
        g<K, V> gVar2 = gVar.f30930h;
        while (gVar2 != gVar) {
            g<K, V> gVar3 = gVar2.f30930h;
            gVar2.i = null;
            gVar2.f30930h = null;
            gVar2 = gVar3;
        }
        gVar.i = gVar;
        gVar.f30930h = gVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return findByObject(obj) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        LinkedHashTreeMap<K, V>.d dVar = this.entrySet;
        if (dVar != null) {
            return dVar;
        }
        LinkedHashTreeMap<K, V>.d dVar2 = new d();
        this.entrySet = dVar2;
        return dVar2;
    }

    /* JADX DEBUG: Type inference failed for r7v2. Raw type applied. Possible types: K, ? super K */
    public g<K, V> find(K k, boolean z) {
        g<K, V> gVar;
        int i;
        g<K, V> gVar2;
        int compare;
        Comparator<? super K> comparator = this.comparator;
        g<K, V>[] gVarArr = this.table;
        int secondaryHash = secondaryHash(k.hashCode());
        int length = (gVarArr.length - 1) & secondaryHash;
        g<K, V> gVar3 = gVarArr[length];
        if (gVar3 != null) {
            Comparable comparable = comparator == NATURAL_ORDER ? (Comparable) k : null;
            while (true) {
                if (comparable != null) {
                    compare = comparable.compareTo(gVar3.j);
                } else {
                    compare = comparator.compare(k, (K) gVar3.j);
                }
                if (compare == 0) {
                    return gVar3;
                }
                g<K, V> gVar4 = compare < 0 ? gVar3.f30928f : gVar3.f30929g;
                if (gVar4 == null) {
                    gVar = gVar3;
                    i = compare;
                    break;
                }
                gVar3 = gVar4;
            }
        } else {
            gVar = gVar3;
            i = 0;
        }
        if (z) {
            g<K, V> gVar5 = this.header;
            if (gVar == null) {
                if (comparator == NATURAL_ORDER && !(k instanceof Comparable)) {
                    throw new ClassCastException(k.getClass().getName() + " is not Comparable");
                }
                gVar2 = new g<>(gVar, k, secondaryHash, gVar5, gVar5.i);
                gVarArr[length] = gVar2;
            } else {
                gVar2 = new g<>(gVar, k, secondaryHash, gVar5, gVar5.i);
                if (i < 0) {
                    gVar.f30928f = gVar2;
                } else {
                    gVar.f30929g = gVar2;
                }
                rebalance(gVar, true);
            }
            int i2 = this.size;
            this.size = i2 + 1;
            if (i2 > this.threshold) {
                doubleCapacity();
            }
            this.modCount++;
            return gVar2;
        }
        return null;
    }

    public g<K, V> findByEntry(Map.Entry<?, ?> entry) {
        g<K, V> findByObject = findByObject(entry.getKey());
        if (findByObject != null && equal(findByObject.l, entry.getValue())) {
            return findByObject;
        }
        return null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    public g<K, V> findByObject(Object obj) {
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
        g<K, V> findByObject = findByObject(obj);
        if (findByObject != null) {
            return findByObject.l;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        LinkedHashTreeMap<K, V>.e eVar = this.keySet;
        if (eVar != null) {
            return eVar;
        }
        LinkedHashTreeMap<K, V>.e eVar2 = new e();
        this.keySet = eVar2;
        return eVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k, V v) {
        if (k != null) {
            g<K, V> find = find(k, true);
            V v2 = find.l;
            find.l = v;
            return v2;
        }
        throw new NullPointerException("key == null");
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        g<K, V> removeInternalByKey = removeInternalByKey(obj);
        if (removeInternalByKey != null) {
            return removeInternalByKey.l;
        }
        return null;
    }

    public void removeInternal(g<K, V> gVar, boolean z) {
        int i;
        if (z) {
            g<K, V> gVar2 = gVar.i;
            gVar2.f30930h = gVar.f30930h;
            gVar.f30930h.i = gVar2;
            gVar.i = null;
            gVar.f30930h = null;
        }
        g<K, V> gVar3 = gVar.f30928f;
        g<K, V> gVar4 = gVar.f30929g;
        g<K, V> gVar5 = gVar.f30927e;
        int i2 = 0;
        if (gVar3 != null && gVar4 != null) {
            g<K, V> b2 = gVar3.m > gVar4.m ? gVar3.b() : gVar4.a();
            removeInternal(b2, false);
            g<K, V> gVar6 = gVar.f30928f;
            if (gVar6 != null) {
                i = gVar6.m;
                b2.f30928f = gVar6;
                gVar6.f30927e = b2;
                gVar.f30928f = null;
            } else {
                i = 0;
            }
            g<K, V> gVar7 = gVar.f30929g;
            if (gVar7 != null) {
                i2 = gVar7.m;
                b2.f30929g = gVar7;
                gVar7.f30927e = b2;
                gVar.f30929g = null;
            }
            b2.m = Math.max(i, i2) + 1;
            replaceInParent(gVar, b2);
            return;
        }
        if (gVar3 != null) {
            replaceInParent(gVar, gVar3);
            gVar.f30928f = null;
        } else if (gVar4 != null) {
            replaceInParent(gVar, gVar4);
            gVar.f30929g = null;
        } else {
            replaceInParent(gVar, null);
        }
        rebalance(gVar5, false);
        this.size--;
        this.modCount++;
    }

    public g<K, V> removeInternalByKey(Object obj) {
        g<K, V> findByObject = findByObject(obj);
        if (findByObject != null) {
            removeInternal(findByObject, true);
        }
        return findByObject;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.size;
    }

    public LinkedHashTreeMap(Comparator<? super K> comparator) {
        this.size = 0;
        this.modCount = 0;
        this.comparator = comparator == null ? NATURAL_ORDER : comparator;
        this.header = new g<>();
        g<K, V>[] gVarArr = new g[16];
        this.table = gVarArr;
        this.threshold = (gVarArr.length / 2) + (gVarArr.length / 4);
    }

    public static <K, V> g<K, V>[] doubleCapacity(g<K, V>[] gVarArr) {
        int length = gVarArr.length;
        g<K, V>[] gVarArr2 = new g[length * 2];
        c cVar = new c();
        b bVar = new b();
        b bVar2 = new b();
        for (int i = 0; i < length; i++) {
            g<K, V> gVar = gVarArr[i];
            if (gVar != null) {
                cVar.b(gVar);
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    g<K, V> a2 = cVar.a();
                    if (a2 == null) {
                        break;
                    } else if ((a2.k & length) == 0) {
                        i2++;
                    } else {
                        i3++;
                    }
                }
                bVar.b(i2);
                bVar2.b(i3);
                cVar.b(gVar);
                while (true) {
                    g<K, V> a3 = cVar.a();
                    if (a3 == null) {
                        break;
                    } else if ((a3.k & length) == 0) {
                        bVar.a(a3);
                    } else {
                        bVar2.a(a3);
                    }
                }
                gVarArr2[i] = i2 > 0 ? bVar.c() : null;
                gVarArr2[i + length] = i3 > 0 ? bVar2.c() : null;
            }
        }
        return gVarArr2;
    }

    /* loaded from: classes6.dex */
    public static final class g<K, V> implements Map.Entry<K, V> {

        /* renamed from: e  reason: collision with root package name */
        public g<K, V> f30927e;

        /* renamed from: f  reason: collision with root package name */
        public g<K, V> f30928f;

        /* renamed from: g  reason: collision with root package name */
        public g<K, V> f30929g;

        /* renamed from: h  reason: collision with root package name */
        public g<K, V> f30930h;
        public g<K, V> i;
        public final K j;
        public final int k;
        public V l;
        public int m;

        public g() {
            this.j = null;
            this.k = -1;
            this.i = this;
            this.f30930h = this;
        }

        public g<K, V> a() {
            g<K, V> gVar = this;
            for (g<K, V> gVar2 = this.f30928f; gVar2 != null; gVar2 = gVar2.f30928f) {
                gVar = gVar2;
            }
            return gVar;
        }

        public g<K, V> b() {
            g<K, V> gVar = this;
            for (g<K, V> gVar2 = this.f30929g; gVar2 != null; gVar2 = gVar2.f30929g) {
                gVar = gVar2;
            }
            return gVar;
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
                V v = this.l;
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
            return this.l;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K k = this.j;
            int hashCode = k == null ? 0 : k.hashCode();
            V v = this.l;
            return hashCode ^ (v != null ? v.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            V v2 = this.l;
            this.l = v;
            return v2;
        }

        public String toString() {
            return this.j + "=" + this.l;
        }

        public g(g<K, V> gVar, K k, int i, g<K, V> gVar2, g<K, V> gVar3) {
            this.f30927e = gVar;
            this.j = k;
            this.k = i;
            this.m = 1;
            this.f30930h = gVar2;
            this.i = gVar3;
            gVar3.f30930h = this;
            gVar2.i = this;
        }
    }
}
