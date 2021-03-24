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
    public static final /* synthetic */ boolean f30047f = !h.class.desiredAssertionStatus();

    /* renamed from: g  reason: collision with root package name */
    public static final Comparator<Comparable> f30048g = new Comparator<Comparable>() { // from class: com.bytedance.sdk.openadsdk.preload.a.b.h.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public Comparator<? super K> f30049a;

    /* renamed from: b  reason: collision with root package name */
    public d<K, V> f30050b;

    /* renamed from: c  reason: collision with root package name */
    public int f30051c;

    /* renamed from: d  reason: collision with root package name */
    public int f30052d;

    /* renamed from: e  reason: collision with root package name */
    public final d<K, V> f30053e;

    /* renamed from: h  reason: collision with root package name */
    public h<K, V>.a f30054h;
    public h<K, V>.b i;

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
            return h.this.f30051c;
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
                    return b().f30068f;
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return h.this.b(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return h.this.f30051c;
        }
    }

    /* loaded from: classes6.dex */
    public abstract class c<T> implements Iterator<T> {

        /* renamed from: b  reason: collision with root package name */
        public d<K, V> f30059b;

        /* renamed from: c  reason: collision with root package name */
        public d<K, V> f30060c;

        /* renamed from: d  reason: collision with root package name */
        public int f30061d;

        public c() {
            h hVar = h.this;
            this.f30059b = hVar.f30053e.f30066d;
            this.f30060c = null;
            this.f30061d = hVar.f30052d;
        }

        public final d<K, V> b() {
            d<K, V> dVar = this.f30059b;
            h hVar = h.this;
            if (dVar != hVar.f30053e) {
                if (hVar.f30052d == this.f30061d) {
                    this.f30059b = dVar.f30066d;
                    this.f30060c = dVar;
                    return dVar;
                }
                throw new ConcurrentModificationException();
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f30059b != h.this.f30053e;
        }

        @Override // java.util.Iterator
        public final void remove() {
            d<K, V> dVar = this.f30060c;
            if (dVar != null) {
                h.this.a((d) dVar, true);
                this.f30060c = null;
                this.f30061d = h.this.f30052d;
                return;
            }
            throw new IllegalStateException();
        }
    }

    public h() {
        this(f30048g);
    }

    /* JADX DEBUG: Type inference failed for r4v2. Raw type applied. Possible types: K, ? super K */
    public d<K, V> a(K k, boolean z) {
        int i;
        d<K, V> dVar;
        Comparator<? super K> comparator = this.f30049a;
        d<K, V> dVar2 = this.f30050b;
        if (dVar2 != null) {
            Comparable comparable = comparator == f30048g ? (Comparable) k : null;
            while (true) {
                if (comparable != null) {
                    i = comparable.compareTo(dVar2.f30068f);
                } else {
                    i = comparator.compare(k, (K) dVar2.f30068f);
                }
                if (i == 0) {
                    return dVar2;
                }
                d<K, V> dVar3 = i < 0 ? dVar2.f30064b : dVar2.f30065c;
                if (dVar3 == null) {
                    break;
                }
                dVar2 = dVar3;
            }
        } else {
            i = 0;
        }
        if (z) {
            d<K, V> dVar4 = this.f30053e;
            if (dVar2 == null) {
                if (comparator == f30048g && !(k instanceof Comparable)) {
                    throw new ClassCastException(k.getClass().getName() + " is not Comparable");
                }
                dVar = new d<>(dVar2, k, dVar4, dVar4.f30067e);
                this.f30050b = dVar;
            } else {
                dVar = new d<>(dVar2, k, dVar4, dVar4.f30067e);
                if (i < 0) {
                    dVar2.f30064b = dVar;
                } else {
                    dVar2.f30065c = dVar;
                }
                b(dVar2, true);
            }
            this.f30051c++;
            this.f30052d++;
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
        this.f30050b = null;
        this.f30051c = 0;
        this.f30052d++;
        d<K, V> dVar = this.f30053e;
        dVar.f30067e = dVar;
        dVar.f30066d = dVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return a(obj) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        h<K, V>.a aVar = this.f30054h;
        if (aVar != null) {
            return aVar;
        }
        h<K, V>.a aVar2 = new a();
        this.f30054h = aVar2;
        return aVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        d<K, V> a2 = a(obj);
        if (a2 != null) {
            return a2.f30069g;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        h<K, V>.b bVar = this.i;
        if (bVar != null) {
            return bVar;
        }
        h<K, V>.b bVar2 = new b();
        this.i = bVar2;
        return bVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k, V v) {
        if (k != null) {
            d<K, V> a2 = a((h<K, V>) k, true);
            V v2 = a2.f30069g;
            a2.f30069g = v;
            return v2;
        }
        throw new NullPointerException("key == null");
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        d<K, V> b2 = b(obj);
        if (b2 != null) {
            return b2.f30069g;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f30051c;
    }

    public h(Comparator<? super K> comparator) {
        this.f30051c = 0;
        this.f30052d = 0;
        this.f30053e = new d<>();
        this.f30049a = comparator == null ? f30048g : comparator;
    }

    /* loaded from: classes6.dex */
    public static final class d<K, V> implements Map.Entry<K, V> {

        /* renamed from: a  reason: collision with root package name */
        public d<K, V> f30063a;

        /* renamed from: b  reason: collision with root package name */
        public d<K, V> f30064b;

        /* renamed from: c  reason: collision with root package name */
        public d<K, V> f30065c;

        /* renamed from: d  reason: collision with root package name */
        public d<K, V> f30066d;

        /* renamed from: e  reason: collision with root package name */
        public d<K, V> f30067e;

        /* renamed from: f  reason: collision with root package name */
        public final K f30068f;

        /* renamed from: g  reason: collision with root package name */
        public V f30069g;

        /* renamed from: h  reason: collision with root package name */
        public int f30070h;

        public d() {
            this.f30068f = null;
            this.f30067e = this;
            this.f30066d = this;
        }

        public d<K, V> a() {
            d<K, V> dVar = this;
            for (d<K, V> dVar2 = this.f30064b; dVar2 != null; dVar2 = dVar2.f30064b) {
                dVar = dVar2;
            }
            return dVar;
        }

        public d<K, V> b() {
            d<K, V> dVar = this;
            for (d<K, V> dVar2 = this.f30065c; dVar2 != null; dVar2 = dVar2.f30065c) {
                dVar = dVar2;
            }
            return dVar;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                K k = this.f30068f;
                if (k == null) {
                    if (entry.getKey() != null) {
                        return false;
                    }
                } else if (!k.equals(entry.getKey())) {
                    return false;
                }
                V v = this.f30069g;
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
            return this.f30068f;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f30069g;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K k = this.f30068f;
            int hashCode = k == null ? 0 : k.hashCode();
            V v = this.f30069g;
            return hashCode ^ (v != null ? v.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            V v2 = this.f30069g;
            this.f30069g = v;
            return v2;
        }

        public String toString() {
            return this.f30068f + "=" + this.f30069g;
        }

        public d(d<K, V> dVar, K k, d<K, V> dVar2, d<K, V> dVar3) {
            this.f30063a = dVar;
            this.f30068f = k;
            this.f30070h = 1;
            this.f30066d = dVar2;
            this.f30067e = dVar3;
            dVar3.f30066d = this;
            dVar2.f30067e = this;
        }
    }

    private void b(d<K, V> dVar, boolean z) {
        while (dVar != null) {
            d<K, V> dVar2 = dVar.f30064b;
            d<K, V> dVar3 = dVar.f30065c;
            int i = dVar2 != null ? dVar2.f30070h : 0;
            int i2 = dVar3 != null ? dVar3.f30070h : 0;
            int i3 = i - i2;
            if (i3 == -2) {
                d<K, V> dVar4 = dVar3.f30064b;
                d<K, V> dVar5 = dVar3.f30065c;
                int i4 = (dVar4 != null ? dVar4.f30070h : 0) - (dVar5 != null ? dVar5.f30070h : 0);
                if (i4 != -1 && (i4 != 0 || z)) {
                    if (!f30047f && i4 != 1) {
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
            } else if (i3 == 2) {
                d<K, V> dVar6 = dVar2.f30064b;
                d<K, V> dVar7 = dVar2.f30065c;
                int i5 = (dVar6 != null ? dVar6.f30070h : 0) - (dVar7 != null ? dVar7.f30070h : 0);
                if (i5 != 1 && (i5 != 0 || z)) {
                    if (!f30047f && i5 != -1) {
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
            } else if (i3 == 0) {
                dVar.f30070h = i + 1;
                if (z) {
                    return;
                }
            } else if (!f30047f && i3 != -1 && i3 != 1) {
                throw new AssertionError();
            } else {
                dVar.f30070h = Math.max(i, i2) + 1;
                if (!z) {
                    return;
                }
            }
            dVar = dVar.f30063a;
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
        if (a2 != null && a(a2.f30069g, entry.getValue())) {
            return a2;
        }
        return null;
    }

    private boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public void a(d<K, V> dVar, boolean z) {
        int i;
        if (z) {
            d<K, V> dVar2 = dVar.f30067e;
            dVar2.f30066d = dVar.f30066d;
            dVar.f30066d.f30067e = dVar2;
        }
        d<K, V> dVar3 = dVar.f30064b;
        d<K, V> dVar4 = dVar.f30065c;
        d<K, V> dVar5 = dVar.f30063a;
        int i2 = 0;
        if (dVar3 != null && dVar4 != null) {
            d<K, V> b2 = dVar3.f30070h > dVar4.f30070h ? dVar3.b() : dVar4.a();
            a((d) b2, false);
            d<K, V> dVar6 = dVar.f30064b;
            if (dVar6 != null) {
                i = dVar6.f30070h;
                b2.f30064b = dVar6;
                dVar6.f30063a = b2;
                dVar.f30064b = null;
            } else {
                i = 0;
            }
            d<K, V> dVar7 = dVar.f30065c;
            if (dVar7 != null) {
                i2 = dVar7.f30070h;
                b2.f30065c = dVar7;
                dVar7.f30063a = b2;
                dVar.f30065c = null;
            }
            b2.f30070h = Math.max(i, i2) + 1;
            a((d) dVar, (d) b2);
            return;
        }
        if (dVar3 != null) {
            a((d) dVar, (d) dVar3);
            dVar.f30064b = null;
        } else if (dVar4 != null) {
            a((d) dVar, (d) dVar4);
            dVar.f30065c = null;
        } else {
            a((d) dVar, (d) null);
        }
        b(dVar5, false);
        this.f30051c--;
        this.f30052d++;
    }

    private void b(d<K, V> dVar) {
        d<K, V> dVar2 = dVar.f30064b;
        d<K, V> dVar3 = dVar.f30065c;
        d<K, V> dVar4 = dVar2.f30064b;
        d<K, V> dVar5 = dVar2.f30065c;
        dVar.f30064b = dVar5;
        if (dVar5 != null) {
            dVar5.f30063a = dVar;
        }
        a((d) dVar, (d) dVar2);
        dVar2.f30065c = dVar;
        dVar.f30063a = dVar2;
        int max = Math.max(dVar3 != null ? dVar3.f30070h : 0, dVar5 != null ? dVar5.f30070h : 0) + 1;
        dVar.f30070h = max;
        dVar2.f30070h = Math.max(max, dVar4 != null ? dVar4.f30070h : 0) + 1;
    }

    private void a(d<K, V> dVar, d<K, V> dVar2) {
        d<K, V> dVar3 = dVar.f30063a;
        dVar.f30063a = null;
        if (dVar2 != null) {
            dVar2.f30063a = dVar3;
        }
        if (dVar3 != null) {
            if (dVar3.f30064b == dVar) {
                dVar3.f30064b = dVar2;
                return;
            } else if (!f30047f && dVar3.f30065c != dVar) {
                throw new AssertionError();
            } else {
                dVar3.f30065c = dVar2;
                return;
            }
        }
        this.f30050b = dVar2;
    }

    private void a(d<K, V> dVar) {
        d<K, V> dVar2 = dVar.f30064b;
        d<K, V> dVar3 = dVar.f30065c;
        d<K, V> dVar4 = dVar3.f30064b;
        d<K, V> dVar5 = dVar3.f30065c;
        dVar.f30065c = dVar4;
        if (dVar4 != null) {
            dVar4.f30063a = dVar;
        }
        a((d) dVar, (d) dVar3);
        dVar3.f30064b = dVar;
        dVar.f30063a = dVar3;
        int max = Math.max(dVar2 != null ? dVar2.f30070h : 0, dVar4 != null ? dVar4.f30070h : 0) + 1;
        dVar.f30070h = max;
        dVar3.f30070h = Math.max(max, dVar5 != null ? dVar5.f30070h : 0) + 1;
    }
}
