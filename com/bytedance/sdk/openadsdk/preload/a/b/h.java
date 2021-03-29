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
    public static final /* synthetic */ boolean f30048f = !h.class.desiredAssertionStatus();

    /* renamed from: g  reason: collision with root package name */
    public static final Comparator<Comparable> f30049g = new Comparator<Comparable>() { // from class: com.bytedance.sdk.openadsdk.preload.a.b.h.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public Comparator<? super K> f30050a;

    /* renamed from: b  reason: collision with root package name */
    public d<K, V> f30051b;

    /* renamed from: c  reason: collision with root package name */
    public int f30052c;

    /* renamed from: d  reason: collision with root package name */
    public int f30053d;

    /* renamed from: e  reason: collision with root package name */
    public final d<K, V> f30054e;

    /* renamed from: h  reason: collision with root package name */
    public h<K, V>.a f30055h;
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
            return h.this.f30052c;
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
                    return b().f30069f;
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return h.this.b(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return h.this.f30052c;
        }
    }

    /* loaded from: classes6.dex */
    public abstract class c<T> implements Iterator<T> {

        /* renamed from: b  reason: collision with root package name */
        public d<K, V> f30060b;

        /* renamed from: c  reason: collision with root package name */
        public d<K, V> f30061c;

        /* renamed from: d  reason: collision with root package name */
        public int f30062d;

        public c() {
            h hVar = h.this;
            this.f30060b = hVar.f30054e.f30067d;
            this.f30061c = null;
            this.f30062d = hVar.f30053d;
        }

        public final d<K, V> b() {
            d<K, V> dVar = this.f30060b;
            h hVar = h.this;
            if (dVar != hVar.f30054e) {
                if (hVar.f30053d == this.f30062d) {
                    this.f30060b = dVar.f30067d;
                    this.f30061c = dVar;
                    return dVar;
                }
                throw new ConcurrentModificationException();
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f30060b != h.this.f30054e;
        }

        @Override // java.util.Iterator
        public final void remove() {
            d<K, V> dVar = this.f30061c;
            if (dVar != null) {
                h.this.a((d) dVar, true);
                this.f30061c = null;
                this.f30062d = h.this.f30053d;
                return;
            }
            throw new IllegalStateException();
        }
    }

    public h() {
        this(f30049g);
    }

    /* JADX DEBUG: Type inference failed for r4v2. Raw type applied. Possible types: K, ? super K */
    public d<K, V> a(K k, boolean z) {
        int i;
        d<K, V> dVar;
        Comparator<? super K> comparator = this.f30050a;
        d<K, V> dVar2 = this.f30051b;
        if (dVar2 != null) {
            Comparable comparable = comparator == f30049g ? (Comparable) k : null;
            while (true) {
                if (comparable != null) {
                    i = comparable.compareTo(dVar2.f30069f);
                } else {
                    i = comparator.compare(k, (K) dVar2.f30069f);
                }
                if (i == 0) {
                    return dVar2;
                }
                d<K, V> dVar3 = i < 0 ? dVar2.f30065b : dVar2.f30066c;
                if (dVar3 == null) {
                    break;
                }
                dVar2 = dVar3;
            }
        } else {
            i = 0;
        }
        if (z) {
            d<K, V> dVar4 = this.f30054e;
            if (dVar2 == null) {
                if (comparator == f30049g && !(k instanceof Comparable)) {
                    throw new ClassCastException(k.getClass().getName() + " is not Comparable");
                }
                dVar = new d<>(dVar2, k, dVar4, dVar4.f30068e);
                this.f30051b = dVar;
            } else {
                dVar = new d<>(dVar2, k, dVar4, dVar4.f30068e);
                if (i < 0) {
                    dVar2.f30065b = dVar;
                } else {
                    dVar2.f30066c = dVar;
                }
                b(dVar2, true);
            }
            this.f30052c++;
            this.f30053d++;
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
        this.f30051b = null;
        this.f30052c = 0;
        this.f30053d++;
        d<K, V> dVar = this.f30054e;
        dVar.f30068e = dVar;
        dVar.f30067d = dVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return a(obj) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        h<K, V>.a aVar = this.f30055h;
        if (aVar != null) {
            return aVar;
        }
        h<K, V>.a aVar2 = new a();
        this.f30055h = aVar2;
        return aVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        d<K, V> a2 = a(obj);
        if (a2 != null) {
            return a2.f30070g;
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
            V v2 = a2.f30070g;
            a2.f30070g = v;
            return v2;
        }
        throw new NullPointerException("key == null");
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        d<K, V> b2 = b(obj);
        if (b2 != null) {
            return b2.f30070g;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f30052c;
    }

    public h(Comparator<? super K> comparator) {
        this.f30052c = 0;
        this.f30053d = 0;
        this.f30054e = new d<>();
        this.f30050a = comparator == null ? f30049g : comparator;
    }

    /* loaded from: classes6.dex */
    public static final class d<K, V> implements Map.Entry<K, V> {

        /* renamed from: a  reason: collision with root package name */
        public d<K, V> f30064a;

        /* renamed from: b  reason: collision with root package name */
        public d<K, V> f30065b;

        /* renamed from: c  reason: collision with root package name */
        public d<K, V> f30066c;

        /* renamed from: d  reason: collision with root package name */
        public d<K, V> f30067d;

        /* renamed from: e  reason: collision with root package name */
        public d<K, V> f30068e;

        /* renamed from: f  reason: collision with root package name */
        public final K f30069f;

        /* renamed from: g  reason: collision with root package name */
        public V f30070g;

        /* renamed from: h  reason: collision with root package name */
        public int f30071h;

        public d() {
            this.f30069f = null;
            this.f30068e = this;
            this.f30067d = this;
        }

        public d<K, V> a() {
            d<K, V> dVar = this;
            for (d<K, V> dVar2 = this.f30065b; dVar2 != null; dVar2 = dVar2.f30065b) {
                dVar = dVar2;
            }
            return dVar;
        }

        public d<K, V> b() {
            d<K, V> dVar = this;
            for (d<K, V> dVar2 = this.f30066c; dVar2 != null; dVar2 = dVar2.f30066c) {
                dVar = dVar2;
            }
            return dVar;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                K k = this.f30069f;
                if (k == null) {
                    if (entry.getKey() != null) {
                        return false;
                    }
                } else if (!k.equals(entry.getKey())) {
                    return false;
                }
                V v = this.f30070g;
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
            return this.f30069f;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f30070g;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K k = this.f30069f;
            int hashCode = k == null ? 0 : k.hashCode();
            V v = this.f30070g;
            return hashCode ^ (v != null ? v.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            V v2 = this.f30070g;
            this.f30070g = v;
            return v2;
        }

        public String toString() {
            return this.f30069f + "=" + this.f30070g;
        }

        public d(d<K, V> dVar, K k, d<K, V> dVar2, d<K, V> dVar3) {
            this.f30064a = dVar;
            this.f30069f = k;
            this.f30071h = 1;
            this.f30067d = dVar2;
            this.f30068e = dVar3;
            dVar3.f30067d = this;
            dVar2.f30068e = this;
        }
    }

    private void b(d<K, V> dVar, boolean z) {
        while (dVar != null) {
            d<K, V> dVar2 = dVar.f30065b;
            d<K, V> dVar3 = dVar.f30066c;
            int i = dVar2 != null ? dVar2.f30071h : 0;
            int i2 = dVar3 != null ? dVar3.f30071h : 0;
            int i3 = i - i2;
            if (i3 == -2) {
                d<K, V> dVar4 = dVar3.f30065b;
                d<K, V> dVar5 = dVar3.f30066c;
                int i4 = (dVar4 != null ? dVar4.f30071h : 0) - (dVar5 != null ? dVar5.f30071h : 0);
                if (i4 != -1 && (i4 != 0 || z)) {
                    if (!f30048f && i4 != 1) {
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
                d<K, V> dVar6 = dVar2.f30065b;
                d<K, V> dVar7 = dVar2.f30066c;
                int i5 = (dVar6 != null ? dVar6.f30071h : 0) - (dVar7 != null ? dVar7.f30071h : 0);
                if (i5 != 1 && (i5 != 0 || z)) {
                    if (!f30048f && i5 != -1) {
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
                dVar.f30071h = i + 1;
                if (z) {
                    return;
                }
            } else if (!f30048f && i3 != -1 && i3 != 1) {
                throw new AssertionError();
            } else {
                dVar.f30071h = Math.max(i, i2) + 1;
                if (!z) {
                    return;
                }
            }
            dVar = dVar.f30064a;
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
        if (a2 != null && a(a2.f30070g, entry.getValue())) {
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
            d<K, V> dVar2 = dVar.f30068e;
            dVar2.f30067d = dVar.f30067d;
            dVar.f30067d.f30068e = dVar2;
        }
        d<K, V> dVar3 = dVar.f30065b;
        d<K, V> dVar4 = dVar.f30066c;
        d<K, V> dVar5 = dVar.f30064a;
        int i2 = 0;
        if (dVar3 != null && dVar4 != null) {
            d<K, V> b2 = dVar3.f30071h > dVar4.f30071h ? dVar3.b() : dVar4.a();
            a((d) b2, false);
            d<K, V> dVar6 = dVar.f30065b;
            if (dVar6 != null) {
                i = dVar6.f30071h;
                b2.f30065b = dVar6;
                dVar6.f30064a = b2;
                dVar.f30065b = null;
            } else {
                i = 0;
            }
            d<K, V> dVar7 = dVar.f30066c;
            if (dVar7 != null) {
                i2 = dVar7.f30071h;
                b2.f30066c = dVar7;
                dVar7.f30064a = b2;
                dVar.f30066c = null;
            }
            b2.f30071h = Math.max(i, i2) + 1;
            a((d) dVar, (d) b2);
            return;
        }
        if (dVar3 != null) {
            a((d) dVar, (d) dVar3);
            dVar.f30065b = null;
        } else if (dVar4 != null) {
            a((d) dVar, (d) dVar4);
            dVar.f30066c = null;
        } else {
            a((d) dVar, (d) null);
        }
        b(dVar5, false);
        this.f30052c--;
        this.f30053d++;
    }

    private void b(d<K, V> dVar) {
        d<K, V> dVar2 = dVar.f30065b;
        d<K, V> dVar3 = dVar.f30066c;
        d<K, V> dVar4 = dVar2.f30065b;
        d<K, V> dVar5 = dVar2.f30066c;
        dVar.f30065b = dVar5;
        if (dVar5 != null) {
            dVar5.f30064a = dVar;
        }
        a((d) dVar, (d) dVar2);
        dVar2.f30066c = dVar;
        dVar.f30064a = dVar2;
        int max = Math.max(dVar3 != null ? dVar3.f30071h : 0, dVar5 != null ? dVar5.f30071h : 0) + 1;
        dVar.f30071h = max;
        dVar2.f30071h = Math.max(max, dVar4 != null ? dVar4.f30071h : 0) + 1;
    }

    private void a(d<K, V> dVar, d<K, V> dVar2) {
        d<K, V> dVar3 = dVar.f30064a;
        dVar.f30064a = null;
        if (dVar2 != null) {
            dVar2.f30064a = dVar3;
        }
        if (dVar3 != null) {
            if (dVar3.f30065b == dVar) {
                dVar3.f30065b = dVar2;
                return;
            } else if (!f30048f && dVar3.f30066c != dVar) {
                throw new AssertionError();
            } else {
                dVar3.f30066c = dVar2;
                return;
            }
        }
        this.f30051b = dVar2;
    }

    private void a(d<K, V> dVar) {
        d<K, V> dVar2 = dVar.f30065b;
        d<K, V> dVar3 = dVar.f30066c;
        d<K, V> dVar4 = dVar3.f30065b;
        d<K, V> dVar5 = dVar3.f30066c;
        dVar.f30066c = dVar4;
        if (dVar4 != null) {
            dVar4.f30064a = dVar;
        }
        a((d) dVar, (d) dVar3);
        dVar3.f30065b = dVar;
        dVar.f30064a = dVar3;
        int max = Math.max(dVar2 != null ? dVar2.f30071h : 0, dVar4 != null ? dVar4.f30071h : 0) + 1;
        dVar.f30071h = max;
        dVar3.f30071h = Math.max(max, dVar5 != null ? dVar5.f30071h : 0) + 1;
    }
}
