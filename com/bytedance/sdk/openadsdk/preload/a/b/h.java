package com.bytedance.sdk.openadsdk.preload.a.b;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
/* loaded from: classes6.dex */
public final class h<K, V> extends AbstractMap<K, V> implements Serializable {

    /* renamed from: f  reason: collision with root package name */
    public static final /* synthetic */ boolean f29893f = !h.class.desiredAssertionStatus();

    /* renamed from: g  reason: collision with root package name */
    public static final Comparator<Comparable> f29894g = new Comparator<Comparable>() { // from class: com.bytedance.sdk.openadsdk.preload.a.b.h.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public Comparator<? super K> f29895a;

    /* renamed from: b  reason: collision with root package name */
    public d<K, V> f29896b;

    /* renamed from: c  reason: collision with root package name */
    public int f29897c;

    /* renamed from: d  reason: collision with root package name */
    public int f29898d;

    /* renamed from: e  reason: collision with root package name */
    public final d<K, V> f29899e;

    /* renamed from: h  reason: collision with root package name */
    public h<K, V>.a f29900h;

    /* renamed from: i  reason: collision with root package name */
    public h<K, V>.b f29901i;

    /* loaded from: classes6.dex */
    public class a extends AbstractSet<Map.Entry<K, V>> {
        public a() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            h.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return (obj instanceof Map.Entry) && h.this.a((Map.Entry) obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new h<K, V>.c<Map.Entry<K, V>>() { // from class: com.bytedance.sdk.openadsdk.preload.a.b.h.a.1
                {
                    h hVar = h.this;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Iterator
                /* renamed from: a */
                public Map.Entry<K, V> next() {
                    return b();
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            d<K, V> a2;
            if ((obj instanceof Map.Entry) && (a2 = h.this.a((Map.Entry) obj)) != null) {
                h.this.a((d) a2, true);
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return h.this.f29897c;
        }
    }

    /* loaded from: classes6.dex */
    public final class b extends AbstractSet<K> {
        public b() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            h.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return h.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new h<K, V>.c<K>() { // from class: com.bytedance.sdk.openadsdk.preload.a.b.h.b.1
                {
                    h hVar = h.this;
                }

                @Override // java.util.Iterator
                public K next() {
                    return b().f29915f;
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return h.this.b(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return h.this.f29897c;
        }
    }

    /* loaded from: classes6.dex */
    public abstract class c<T> implements Iterator<T> {

        /* renamed from: b  reason: collision with root package name */
        public d<K, V> f29906b;

        /* renamed from: c  reason: collision with root package name */
        public d<K, V> f29907c;

        /* renamed from: d  reason: collision with root package name */
        public int f29908d;

        public c() {
            h hVar = h.this;
            this.f29906b = hVar.f29899e.f29913d;
            this.f29907c = null;
            this.f29908d = hVar.f29898d;
        }

        public final d<K, V> b() {
            d<K, V> dVar = this.f29906b;
            h hVar = h.this;
            if (dVar != hVar.f29899e) {
                if (hVar.f29898d == this.f29908d) {
                    this.f29906b = dVar.f29913d;
                    this.f29907c = dVar;
                    return dVar;
                }
                throw new ConcurrentModificationException();
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f29906b != h.this.f29899e;
        }

        @Override // java.util.Iterator
        public final void remove() {
            d<K, V> dVar = this.f29907c;
            if (dVar != null) {
                h.this.a((d) dVar, true);
                this.f29907c = null;
                this.f29908d = h.this.f29898d;
                return;
            }
            throw new IllegalStateException();
        }
    }

    public h() {
        this(f29894g);
    }

    /* JADX DEBUG: Type inference failed for r4v2. Raw type applied. Possible types: K, ? super K */
    public d<K, V> a(K k, boolean z) {
        int i2;
        d<K, V> dVar;
        Comparator<? super K> comparator = this.f29895a;
        d<K, V> dVar2 = this.f29896b;
        if (dVar2 != null) {
            Comparable comparable = comparator == f29894g ? (Comparable) k : null;
            while (true) {
                if (comparable != null) {
                    i2 = comparable.compareTo(dVar2.f29915f);
                } else {
                    i2 = comparator.compare(k, (K) dVar2.f29915f);
                }
                if (i2 == 0) {
                    return dVar2;
                }
                d<K, V> dVar3 = i2 < 0 ? dVar2.f29911b : dVar2.f29912c;
                if (dVar3 == null) {
                    break;
                }
                dVar2 = dVar3;
            }
        } else {
            i2 = 0;
        }
        if (z) {
            d<K, V> dVar4 = this.f29899e;
            if (dVar2 == null) {
                if (comparator == f29894g && !(k instanceof Comparable)) {
                    throw new ClassCastException(k.getClass().getName() + " is not Comparable");
                }
                dVar = new d<>(dVar2, k, dVar4, dVar4.f29914e);
                this.f29896b = dVar;
            } else {
                dVar = new d<>(dVar2, k, dVar4, dVar4.f29914e);
                if (i2 < 0) {
                    dVar2.f29911b = dVar;
                } else {
                    dVar2.f29912c = dVar;
                }
                b(dVar2, true);
            }
            this.f29897c++;
            this.f29898d++;
            return dVar;
        }
        return null;
    }

    public d<K, V> b(Object obj) {
        d<K, V> a2 = a(obj);
        if (a2 != null) {
            a((d) a2, true);
        }
        return a2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.f29896b = null;
        this.f29897c = 0;
        this.f29898d++;
        d<K, V> dVar = this.f29899e;
        dVar.f29914e = dVar;
        dVar.f29913d = dVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return a(obj) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        h<K, V>.a aVar = this.f29900h;
        if (aVar != null) {
            return aVar;
        }
        h<K, V>.a aVar2 = new a();
        this.f29900h = aVar2;
        return aVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        d<K, V> a2 = a(obj);
        if (a2 != null) {
            return a2.f29916g;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        h<K, V>.b bVar = this.f29901i;
        if (bVar != null) {
            return bVar;
        }
        h<K, V>.b bVar2 = new b();
        this.f29901i = bVar2;
        return bVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k, V v) {
        if (k != null) {
            d<K, V> a2 = a((h<K, V>) k, true);
            V v2 = a2.f29916g;
            a2.f29916g = v;
            return v2;
        }
        throw new NullPointerException("key == null");
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        d<K, V> b2 = b(obj);
        if (b2 != null) {
            return b2.f29916g;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f29897c;
    }

    public h(Comparator<? super K> comparator) {
        this.f29897c = 0;
        this.f29898d = 0;
        this.f29899e = new d<>();
        this.f29895a = comparator == null ? f29894g : comparator;
    }

    /* loaded from: classes6.dex */
    public static final class d<K, V> implements Map.Entry<K, V> {

        /* renamed from: a  reason: collision with root package name */
        public d<K, V> f29910a;

        /* renamed from: b  reason: collision with root package name */
        public d<K, V> f29911b;

        /* renamed from: c  reason: collision with root package name */
        public d<K, V> f29912c;

        /* renamed from: d  reason: collision with root package name */
        public d<K, V> f29913d;

        /* renamed from: e  reason: collision with root package name */
        public d<K, V> f29914e;

        /* renamed from: f  reason: collision with root package name */
        public final K f29915f;

        /* renamed from: g  reason: collision with root package name */
        public V f29916g;

        /* renamed from: h  reason: collision with root package name */
        public int f29917h;

        public d() {
            this.f29915f = null;
            this.f29914e = this;
            this.f29913d = this;
        }

        public d<K, V> a() {
            d<K, V> dVar = this;
            for (d<K, V> dVar2 = this.f29911b; dVar2 != null; dVar2 = dVar2.f29911b) {
                dVar = dVar2;
            }
            return dVar;
        }

        public d<K, V> b() {
            d<K, V> dVar = this;
            for (d<K, V> dVar2 = this.f29912c; dVar2 != null; dVar2 = dVar2.f29912c) {
                dVar = dVar2;
            }
            return dVar;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                K k = this.f29915f;
                if (k == null) {
                    if (entry.getKey() != null) {
                        return false;
                    }
                } else if (!k.equals(entry.getKey())) {
                    return false;
                }
                V v = this.f29916g;
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
            return this.f29915f;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f29916g;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K k = this.f29915f;
            int hashCode = k == null ? 0 : k.hashCode();
            V v = this.f29916g;
            return hashCode ^ (v != null ? v.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            V v2 = this.f29916g;
            this.f29916g = v;
            return v2;
        }

        public String toString() {
            return this.f29915f + "=" + this.f29916g;
        }

        public d(d<K, V> dVar, K k, d<K, V> dVar2, d<K, V> dVar3) {
            this.f29910a = dVar;
            this.f29915f = k;
            this.f29917h = 1;
            this.f29913d = dVar2;
            this.f29914e = dVar3;
            dVar3.f29913d = this;
            dVar2.f29914e = this;
        }
    }

    private void b(d<K, V> dVar, boolean z) {
        while (dVar != null) {
            d<K, V> dVar2 = dVar.f29911b;
            d<K, V> dVar3 = dVar.f29912c;
            int i2 = dVar2 != null ? dVar2.f29917h : 0;
            int i3 = dVar3 != null ? dVar3.f29917h : 0;
            int i4 = i2 - i3;
            if (i4 == -2) {
                d<K, V> dVar4 = dVar3.f29911b;
                d<K, V> dVar5 = dVar3.f29912c;
                int i5 = (dVar4 != null ? dVar4.f29917h : 0) - (dVar5 != null ? dVar5.f29917h : 0);
                if (i5 != -1 && (i5 != 0 || z)) {
                    if (!f29893f && i5 != 1) {
                        throw new AssertionError();
                    }
                    b((d) dVar3);
                    a((d) dVar);
                } else {
                    a((d) dVar);
                }
                if (z) {
                    return;
                }
            } else if (i4 == 2) {
                d<K, V> dVar6 = dVar2.f29911b;
                d<K, V> dVar7 = dVar2.f29912c;
                int i6 = (dVar6 != null ? dVar6.f29917h : 0) - (dVar7 != null ? dVar7.f29917h : 0);
                if (i6 != 1 && (i6 != 0 || z)) {
                    if (!f29893f && i6 != -1) {
                        throw new AssertionError();
                    }
                    a((d) dVar2);
                    b((d) dVar);
                } else {
                    b((d) dVar);
                }
                if (z) {
                    return;
                }
            } else if (i4 == 0) {
                dVar.f29917h = i2 + 1;
                if (z) {
                    return;
                }
            } else if (!f29893f && i4 != -1 && i4 != 1) {
                throw new AssertionError();
            } else {
                dVar.f29917h = Math.max(i2, i3) + 1;
                if (!z) {
                    return;
                }
            }
            dVar = dVar.f29910a;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    public d<K, V> a(Object obj) {
        if (obj != 0) {
            try {
                return a((h<K, V>) obj, false);
            } catch (ClassCastException unused) {
                return null;
            }
        }
        return null;
    }

    public d<K, V> a(Map.Entry<?, ?> entry) {
        d<K, V> a2 = a(entry.getKey());
        if (a2 != null && a(a2.f29916g, entry.getValue())) {
            return a2;
        }
        return null;
    }

    private boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public void a(d<K, V> dVar, boolean z) {
        int i2;
        if (z) {
            d<K, V> dVar2 = dVar.f29914e;
            dVar2.f29913d = dVar.f29913d;
            dVar.f29913d.f29914e = dVar2;
        }
        d<K, V> dVar3 = dVar.f29911b;
        d<K, V> dVar4 = dVar.f29912c;
        d<K, V> dVar5 = dVar.f29910a;
        int i3 = 0;
        if (dVar3 != null && dVar4 != null) {
            d<K, V> b2 = dVar3.f29917h > dVar4.f29917h ? dVar3.b() : dVar4.a();
            a((d) b2, false);
            d<K, V> dVar6 = dVar.f29911b;
            if (dVar6 != null) {
                i2 = dVar6.f29917h;
                b2.f29911b = dVar6;
                dVar6.f29910a = b2;
                dVar.f29911b = null;
            } else {
                i2 = 0;
            }
            d<K, V> dVar7 = dVar.f29912c;
            if (dVar7 != null) {
                i3 = dVar7.f29917h;
                b2.f29912c = dVar7;
                dVar7.f29910a = b2;
                dVar.f29912c = null;
            }
            b2.f29917h = Math.max(i2, i3) + 1;
            a((d) dVar, (d) b2);
            return;
        }
        if (dVar3 != null) {
            a((d) dVar, (d) dVar3);
            dVar.f29911b = null;
        } else if (dVar4 != null) {
            a((d) dVar, (d) dVar4);
            dVar.f29912c = null;
        } else {
            a((d) dVar, (d) null);
        }
        b(dVar5, false);
        this.f29897c--;
        this.f29898d++;
    }

    private void b(d<K, V> dVar) {
        d<K, V> dVar2 = dVar.f29911b;
        d<K, V> dVar3 = dVar.f29912c;
        d<K, V> dVar4 = dVar2.f29911b;
        d<K, V> dVar5 = dVar2.f29912c;
        dVar.f29911b = dVar5;
        if (dVar5 != null) {
            dVar5.f29910a = dVar;
        }
        a((d) dVar, (d) dVar2);
        dVar2.f29912c = dVar;
        dVar.f29910a = dVar2;
        int max = Math.max(dVar3 != null ? dVar3.f29917h : 0, dVar5 != null ? dVar5.f29917h : 0) + 1;
        dVar.f29917h = max;
        dVar2.f29917h = Math.max(max, dVar4 != null ? dVar4.f29917h : 0) + 1;
    }

    private void a(d<K, V> dVar, d<K, V> dVar2) {
        d<K, V> dVar3 = dVar.f29910a;
        dVar.f29910a = null;
        if (dVar2 != null) {
            dVar2.f29910a = dVar3;
        }
        if (dVar3 != null) {
            if (dVar3.f29911b == dVar) {
                dVar3.f29911b = dVar2;
                return;
            } else if (!f29893f && dVar3.f29912c != dVar) {
                throw new AssertionError();
            } else {
                dVar3.f29912c = dVar2;
                return;
            }
        }
        this.f29896b = dVar2;
    }

    private void a(d<K, V> dVar) {
        d<K, V> dVar2 = dVar.f29911b;
        d<K, V> dVar3 = dVar.f29912c;
        d<K, V> dVar4 = dVar3.f29911b;
        d<K, V> dVar5 = dVar3.f29912c;
        dVar.f29912c = dVar4;
        if (dVar4 != null) {
            dVar4.f29910a = dVar;
        }
        a((d) dVar, (d) dVar3);
        dVar3.f29911b = dVar;
        dVar.f29910a = dVar3;
        int max = Math.max(dVar2 != null ? dVar2.f29917h : 0, dVar4 != null ? dVar4.f29917h : 0) + 1;
        dVar.f29917h = max;
        dVar3.f29917h = Math.max(max, dVar5 != null ? dVar5.f29917h : 0) + 1;
    }
}
