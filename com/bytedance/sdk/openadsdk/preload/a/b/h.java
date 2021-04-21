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
/* loaded from: classes5.dex */
public final class h<K, V> extends AbstractMap<K, V> implements Serializable {

    /* renamed from: f  reason: collision with root package name */
    public static final /* synthetic */ boolean f29741f = !h.class.desiredAssertionStatus();

    /* renamed from: g  reason: collision with root package name */
    public static final Comparator<Comparable> f29742g = new Comparator<Comparable>() { // from class: com.bytedance.sdk.openadsdk.preload.a.b.h.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public Comparator<? super K> f29743a;

    /* renamed from: b  reason: collision with root package name */
    public d<K, V> f29744b;

    /* renamed from: c  reason: collision with root package name */
    public int f29745c;

    /* renamed from: d  reason: collision with root package name */
    public int f29746d;

    /* renamed from: e  reason: collision with root package name */
    public final d<K, V> f29747e;

    /* renamed from: h  reason: collision with root package name */
    public h<K, V>.a f29748h;
    public h<K, V>.b i;

    /* loaded from: classes5.dex */
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
            return h.this.f29745c;
        }
    }

    /* loaded from: classes5.dex */
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
                    return b().f29762f;
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return h.this.b(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return h.this.f29745c;
        }
    }

    /* loaded from: classes5.dex */
    public abstract class c<T> implements Iterator<T> {

        /* renamed from: b  reason: collision with root package name */
        public d<K, V> f29753b;

        /* renamed from: c  reason: collision with root package name */
        public d<K, V> f29754c;

        /* renamed from: d  reason: collision with root package name */
        public int f29755d;

        public c() {
            h hVar = h.this;
            this.f29753b = hVar.f29747e.f29760d;
            this.f29754c = null;
            this.f29755d = hVar.f29746d;
        }

        public final d<K, V> b() {
            d<K, V> dVar = this.f29753b;
            h hVar = h.this;
            if (dVar != hVar.f29747e) {
                if (hVar.f29746d == this.f29755d) {
                    this.f29753b = dVar.f29760d;
                    this.f29754c = dVar;
                    return dVar;
                }
                throw new ConcurrentModificationException();
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f29753b != h.this.f29747e;
        }

        @Override // java.util.Iterator
        public final void remove() {
            d<K, V> dVar = this.f29754c;
            if (dVar != null) {
                h.this.a((d) dVar, true);
                this.f29754c = null;
                this.f29755d = h.this.f29746d;
                return;
            }
            throw new IllegalStateException();
        }
    }

    public h() {
        this(f29742g);
    }

    /* JADX DEBUG: Type inference failed for r4v2. Raw type applied. Possible types: K, ? super K */
    public d<K, V> a(K k, boolean z) {
        int i;
        d<K, V> dVar;
        Comparator<? super K> comparator = this.f29743a;
        d<K, V> dVar2 = this.f29744b;
        if (dVar2 != null) {
            Comparable comparable = comparator == f29742g ? (Comparable) k : null;
            while (true) {
                if (comparable != null) {
                    i = comparable.compareTo(dVar2.f29762f);
                } else {
                    i = comparator.compare(k, (K) dVar2.f29762f);
                }
                if (i == 0) {
                    return dVar2;
                }
                d<K, V> dVar3 = i < 0 ? dVar2.f29758b : dVar2.f29759c;
                if (dVar3 == null) {
                    break;
                }
                dVar2 = dVar3;
            }
        } else {
            i = 0;
        }
        if (z) {
            d<K, V> dVar4 = this.f29747e;
            if (dVar2 == null) {
                if (comparator == f29742g && !(k instanceof Comparable)) {
                    throw new ClassCastException(k.getClass().getName() + " is not Comparable");
                }
                dVar = new d<>(dVar2, k, dVar4, dVar4.f29761e);
                this.f29744b = dVar;
            } else {
                dVar = new d<>(dVar2, k, dVar4, dVar4.f29761e);
                if (i < 0) {
                    dVar2.f29758b = dVar;
                } else {
                    dVar2.f29759c = dVar;
                }
                b(dVar2, true);
            }
            this.f29745c++;
            this.f29746d++;
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
        this.f29744b = null;
        this.f29745c = 0;
        this.f29746d++;
        d<K, V> dVar = this.f29747e;
        dVar.f29761e = dVar;
        dVar.f29760d = dVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return a(obj) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        h<K, V>.a aVar = this.f29748h;
        if (aVar != null) {
            return aVar;
        }
        h<K, V>.a aVar2 = new a();
        this.f29748h = aVar2;
        return aVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        d<K, V> a2 = a(obj);
        if (a2 != null) {
            return a2.f29763g;
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
            V v2 = a2.f29763g;
            a2.f29763g = v;
            return v2;
        }
        throw new NullPointerException("key == null");
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        d<K, V> b2 = b(obj);
        if (b2 != null) {
            return b2.f29763g;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f29745c;
    }

    public h(Comparator<? super K> comparator) {
        this.f29745c = 0;
        this.f29746d = 0;
        this.f29747e = new d<>();
        this.f29743a = comparator == null ? f29742g : comparator;
    }

    /* loaded from: classes5.dex */
    public static final class d<K, V> implements Map.Entry<K, V> {

        /* renamed from: a  reason: collision with root package name */
        public d<K, V> f29757a;

        /* renamed from: b  reason: collision with root package name */
        public d<K, V> f29758b;

        /* renamed from: c  reason: collision with root package name */
        public d<K, V> f29759c;

        /* renamed from: d  reason: collision with root package name */
        public d<K, V> f29760d;

        /* renamed from: e  reason: collision with root package name */
        public d<K, V> f29761e;

        /* renamed from: f  reason: collision with root package name */
        public final K f29762f;

        /* renamed from: g  reason: collision with root package name */
        public V f29763g;

        /* renamed from: h  reason: collision with root package name */
        public int f29764h;

        public d() {
            this.f29762f = null;
            this.f29761e = this;
            this.f29760d = this;
        }

        public d<K, V> a() {
            d<K, V> dVar = this;
            for (d<K, V> dVar2 = this.f29758b; dVar2 != null; dVar2 = dVar2.f29758b) {
                dVar = dVar2;
            }
            return dVar;
        }

        public d<K, V> b() {
            d<K, V> dVar = this;
            for (d<K, V> dVar2 = this.f29759c; dVar2 != null; dVar2 = dVar2.f29759c) {
                dVar = dVar2;
            }
            return dVar;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                K k = this.f29762f;
                if (k == null) {
                    if (entry.getKey() != null) {
                        return false;
                    }
                } else if (!k.equals(entry.getKey())) {
                    return false;
                }
                V v = this.f29763g;
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
            return this.f29762f;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f29763g;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K k = this.f29762f;
            int hashCode = k == null ? 0 : k.hashCode();
            V v = this.f29763g;
            return hashCode ^ (v != null ? v.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            V v2 = this.f29763g;
            this.f29763g = v;
            return v2;
        }

        public String toString() {
            return this.f29762f + "=" + this.f29763g;
        }

        public d(d<K, V> dVar, K k, d<K, V> dVar2, d<K, V> dVar3) {
            this.f29757a = dVar;
            this.f29762f = k;
            this.f29764h = 1;
            this.f29760d = dVar2;
            this.f29761e = dVar3;
            dVar3.f29760d = this;
            dVar2.f29761e = this;
        }
    }

    private void b(d<K, V> dVar, boolean z) {
        while (dVar != null) {
            d<K, V> dVar2 = dVar.f29758b;
            d<K, V> dVar3 = dVar.f29759c;
            int i = dVar2 != null ? dVar2.f29764h : 0;
            int i2 = dVar3 != null ? dVar3.f29764h : 0;
            int i3 = i - i2;
            if (i3 == -2) {
                d<K, V> dVar4 = dVar3.f29758b;
                d<K, V> dVar5 = dVar3.f29759c;
                int i4 = (dVar4 != null ? dVar4.f29764h : 0) - (dVar5 != null ? dVar5.f29764h : 0);
                if (i4 != -1 && (i4 != 0 || z)) {
                    if (!f29741f && i4 != 1) {
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
                d<K, V> dVar6 = dVar2.f29758b;
                d<K, V> dVar7 = dVar2.f29759c;
                int i5 = (dVar6 != null ? dVar6.f29764h : 0) - (dVar7 != null ? dVar7.f29764h : 0);
                if (i5 != 1 && (i5 != 0 || z)) {
                    if (!f29741f && i5 != -1) {
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
                dVar.f29764h = i + 1;
                if (z) {
                    return;
                }
            } else if (!f29741f && i3 != -1 && i3 != 1) {
                throw new AssertionError();
            } else {
                dVar.f29764h = Math.max(i, i2) + 1;
                if (!z) {
                    return;
                }
            }
            dVar = dVar.f29757a;
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
        if (a2 != null && a(a2.f29763g, entry.getValue())) {
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
            d<K, V> dVar2 = dVar.f29761e;
            dVar2.f29760d = dVar.f29760d;
            dVar.f29760d.f29761e = dVar2;
        }
        d<K, V> dVar3 = dVar.f29758b;
        d<K, V> dVar4 = dVar.f29759c;
        d<K, V> dVar5 = dVar.f29757a;
        int i2 = 0;
        if (dVar3 != null && dVar4 != null) {
            d<K, V> b2 = dVar3.f29764h > dVar4.f29764h ? dVar3.b() : dVar4.a();
            a((d) b2, false);
            d<K, V> dVar6 = dVar.f29758b;
            if (dVar6 != null) {
                i = dVar6.f29764h;
                b2.f29758b = dVar6;
                dVar6.f29757a = b2;
                dVar.f29758b = null;
            } else {
                i = 0;
            }
            d<K, V> dVar7 = dVar.f29759c;
            if (dVar7 != null) {
                i2 = dVar7.f29764h;
                b2.f29759c = dVar7;
                dVar7.f29757a = b2;
                dVar.f29759c = null;
            }
            b2.f29764h = Math.max(i, i2) + 1;
            a((d) dVar, (d) b2);
            return;
        }
        if (dVar3 != null) {
            a((d) dVar, (d) dVar3);
            dVar.f29758b = null;
        } else if (dVar4 != null) {
            a((d) dVar, (d) dVar4);
            dVar.f29759c = null;
        } else {
            a((d) dVar, (d) null);
        }
        b(dVar5, false);
        this.f29745c--;
        this.f29746d++;
    }

    private void b(d<K, V> dVar) {
        d<K, V> dVar2 = dVar.f29758b;
        d<K, V> dVar3 = dVar.f29759c;
        d<K, V> dVar4 = dVar2.f29758b;
        d<K, V> dVar5 = dVar2.f29759c;
        dVar.f29758b = dVar5;
        if (dVar5 != null) {
            dVar5.f29757a = dVar;
        }
        a((d) dVar, (d) dVar2);
        dVar2.f29759c = dVar;
        dVar.f29757a = dVar2;
        int max = Math.max(dVar3 != null ? dVar3.f29764h : 0, dVar5 != null ? dVar5.f29764h : 0) + 1;
        dVar.f29764h = max;
        dVar2.f29764h = Math.max(max, dVar4 != null ? dVar4.f29764h : 0) + 1;
    }

    private void a(d<K, V> dVar, d<K, V> dVar2) {
        d<K, V> dVar3 = dVar.f29757a;
        dVar.f29757a = null;
        if (dVar2 != null) {
            dVar2.f29757a = dVar3;
        }
        if (dVar3 != null) {
            if (dVar3.f29758b == dVar) {
                dVar3.f29758b = dVar2;
                return;
            } else if (!f29741f && dVar3.f29759c != dVar) {
                throw new AssertionError();
            } else {
                dVar3.f29759c = dVar2;
                return;
            }
        }
        this.f29744b = dVar2;
    }

    private void a(d<K, V> dVar) {
        d<K, V> dVar2 = dVar.f29758b;
        d<K, V> dVar3 = dVar.f29759c;
        d<K, V> dVar4 = dVar3.f29758b;
        d<K, V> dVar5 = dVar3.f29759c;
        dVar.f29759c = dVar4;
        if (dVar4 != null) {
            dVar4.f29757a = dVar;
        }
        a((d) dVar, (d) dVar3);
        dVar3.f29758b = dVar;
        dVar.f29757a = dVar3;
        int max = Math.max(dVar2 != null ? dVar2.f29764h : 0, dVar4 != null ? dVar4.f29764h : 0) + 1;
        dVar.f29764h = max;
        dVar3.f29764h = Math.max(max, dVar5 != null ? dVar5.f29764h : 0) + 1;
    }
}
