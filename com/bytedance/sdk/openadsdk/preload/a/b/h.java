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
    public static final /* synthetic */ boolean f29925f = !h.class.desiredAssertionStatus();

    /* renamed from: g  reason: collision with root package name */
    public static final Comparator<Comparable> f29926g = new Comparator<Comparable>() { // from class: com.bytedance.sdk.openadsdk.preload.a.b.h.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public Comparator<? super K> f29927a;

    /* renamed from: b  reason: collision with root package name */
    public d<K, V> f29928b;

    /* renamed from: c  reason: collision with root package name */
    public int f29929c;

    /* renamed from: d  reason: collision with root package name */
    public int f29930d;

    /* renamed from: e  reason: collision with root package name */
    public final d<K, V> f29931e;

    /* renamed from: h  reason: collision with root package name */
    public h<K, V>.a f29932h;

    /* renamed from: i  reason: collision with root package name */
    public h<K, V>.b f29933i;

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
            return h.this.f29929c;
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
                    return b().f29947f;
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return h.this.b(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return h.this.f29929c;
        }
    }

    /* loaded from: classes6.dex */
    public abstract class c<T> implements Iterator<T> {

        /* renamed from: b  reason: collision with root package name */
        public d<K, V> f29938b;

        /* renamed from: c  reason: collision with root package name */
        public d<K, V> f29939c;

        /* renamed from: d  reason: collision with root package name */
        public int f29940d;

        public c() {
            h hVar = h.this;
            this.f29938b = hVar.f29931e.f29945d;
            this.f29939c = null;
            this.f29940d = hVar.f29930d;
        }

        public final d<K, V> b() {
            d<K, V> dVar = this.f29938b;
            h hVar = h.this;
            if (dVar != hVar.f29931e) {
                if (hVar.f29930d == this.f29940d) {
                    this.f29938b = dVar.f29945d;
                    this.f29939c = dVar;
                    return dVar;
                }
                throw new ConcurrentModificationException();
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f29938b != h.this.f29931e;
        }

        @Override // java.util.Iterator
        public final void remove() {
            d<K, V> dVar = this.f29939c;
            if (dVar != null) {
                h.this.a((d) dVar, true);
                this.f29939c = null;
                this.f29940d = h.this.f29930d;
                return;
            }
            throw new IllegalStateException();
        }
    }

    public h() {
        this(f29926g);
    }

    /* JADX DEBUG: Type inference failed for r4v2. Raw type applied. Possible types: K, ? super K */
    public d<K, V> a(K k, boolean z) {
        int i2;
        d<K, V> dVar;
        Comparator<? super K> comparator = this.f29927a;
        d<K, V> dVar2 = this.f29928b;
        if (dVar2 != null) {
            Comparable comparable = comparator == f29926g ? (Comparable) k : null;
            while (true) {
                if (comparable != null) {
                    i2 = comparable.compareTo(dVar2.f29947f);
                } else {
                    i2 = comparator.compare(k, (K) dVar2.f29947f);
                }
                if (i2 == 0) {
                    return dVar2;
                }
                d<K, V> dVar3 = i2 < 0 ? dVar2.f29943b : dVar2.f29944c;
                if (dVar3 == null) {
                    break;
                }
                dVar2 = dVar3;
            }
        } else {
            i2 = 0;
        }
        if (z) {
            d<K, V> dVar4 = this.f29931e;
            if (dVar2 == null) {
                if (comparator == f29926g && !(k instanceof Comparable)) {
                    throw new ClassCastException(k.getClass().getName() + " is not Comparable");
                }
                dVar = new d<>(dVar2, k, dVar4, dVar4.f29946e);
                this.f29928b = dVar;
            } else {
                dVar = new d<>(dVar2, k, dVar4, dVar4.f29946e);
                if (i2 < 0) {
                    dVar2.f29943b = dVar;
                } else {
                    dVar2.f29944c = dVar;
                }
                b(dVar2, true);
            }
            this.f29929c++;
            this.f29930d++;
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
        this.f29928b = null;
        this.f29929c = 0;
        this.f29930d++;
        d<K, V> dVar = this.f29931e;
        dVar.f29946e = dVar;
        dVar.f29945d = dVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return a(obj) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        h<K, V>.a aVar = this.f29932h;
        if (aVar != null) {
            return aVar;
        }
        h<K, V>.a aVar2 = new a();
        this.f29932h = aVar2;
        return aVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        d<K, V> a2 = a(obj);
        if (a2 != null) {
            return a2.f29948g;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        h<K, V>.b bVar = this.f29933i;
        if (bVar != null) {
            return bVar;
        }
        h<K, V>.b bVar2 = new b();
        this.f29933i = bVar2;
        return bVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k, V v) {
        if (k != null) {
            d<K, V> a2 = a((h<K, V>) k, true);
            V v2 = a2.f29948g;
            a2.f29948g = v;
            return v2;
        }
        throw new NullPointerException("key == null");
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        d<K, V> b2 = b(obj);
        if (b2 != null) {
            return b2.f29948g;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f29929c;
    }

    public h(Comparator<? super K> comparator) {
        this.f29929c = 0;
        this.f29930d = 0;
        this.f29931e = new d<>();
        this.f29927a = comparator == null ? f29926g : comparator;
    }

    /* loaded from: classes6.dex */
    public static final class d<K, V> implements Map.Entry<K, V> {

        /* renamed from: a  reason: collision with root package name */
        public d<K, V> f29942a;

        /* renamed from: b  reason: collision with root package name */
        public d<K, V> f29943b;

        /* renamed from: c  reason: collision with root package name */
        public d<K, V> f29944c;

        /* renamed from: d  reason: collision with root package name */
        public d<K, V> f29945d;

        /* renamed from: e  reason: collision with root package name */
        public d<K, V> f29946e;

        /* renamed from: f  reason: collision with root package name */
        public final K f29947f;

        /* renamed from: g  reason: collision with root package name */
        public V f29948g;

        /* renamed from: h  reason: collision with root package name */
        public int f29949h;

        public d() {
            this.f29947f = null;
            this.f29946e = this;
            this.f29945d = this;
        }

        public d<K, V> a() {
            d<K, V> dVar = this;
            for (d<K, V> dVar2 = this.f29943b; dVar2 != null; dVar2 = dVar2.f29943b) {
                dVar = dVar2;
            }
            return dVar;
        }

        public d<K, V> b() {
            d<K, V> dVar = this;
            for (d<K, V> dVar2 = this.f29944c; dVar2 != null; dVar2 = dVar2.f29944c) {
                dVar = dVar2;
            }
            return dVar;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                K k = this.f29947f;
                if (k == null) {
                    if (entry.getKey() != null) {
                        return false;
                    }
                } else if (!k.equals(entry.getKey())) {
                    return false;
                }
                V v = this.f29948g;
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
            return this.f29947f;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f29948g;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K k = this.f29947f;
            int hashCode = k == null ? 0 : k.hashCode();
            V v = this.f29948g;
            return hashCode ^ (v != null ? v.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            V v2 = this.f29948g;
            this.f29948g = v;
            return v2;
        }

        public String toString() {
            return this.f29947f + "=" + this.f29948g;
        }

        public d(d<K, V> dVar, K k, d<K, V> dVar2, d<K, V> dVar3) {
            this.f29942a = dVar;
            this.f29947f = k;
            this.f29949h = 1;
            this.f29945d = dVar2;
            this.f29946e = dVar3;
            dVar3.f29945d = this;
            dVar2.f29946e = this;
        }
    }

    private void b(d<K, V> dVar, boolean z) {
        while (dVar != null) {
            d<K, V> dVar2 = dVar.f29943b;
            d<K, V> dVar3 = dVar.f29944c;
            int i2 = dVar2 != null ? dVar2.f29949h : 0;
            int i3 = dVar3 != null ? dVar3.f29949h : 0;
            int i4 = i2 - i3;
            if (i4 == -2) {
                d<K, V> dVar4 = dVar3.f29943b;
                d<K, V> dVar5 = dVar3.f29944c;
                int i5 = (dVar4 != null ? dVar4.f29949h : 0) - (dVar5 != null ? dVar5.f29949h : 0);
                if (i5 != -1 && (i5 != 0 || z)) {
                    if (!f29925f && i5 != 1) {
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
                d<K, V> dVar6 = dVar2.f29943b;
                d<K, V> dVar7 = dVar2.f29944c;
                int i6 = (dVar6 != null ? dVar6.f29949h : 0) - (dVar7 != null ? dVar7.f29949h : 0);
                if (i6 != 1 && (i6 != 0 || z)) {
                    if (!f29925f && i6 != -1) {
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
                dVar.f29949h = i2 + 1;
                if (z) {
                    return;
                }
            } else if (!f29925f && i4 != -1 && i4 != 1) {
                throw new AssertionError();
            } else {
                dVar.f29949h = Math.max(i2, i3) + 1;
                if (!z) {
                    return;
                }
            }
            dVar = dVar.f29942a;
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
        if (a2 != null && a(a2.f29948g, entry.getValue())) {
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
            d<K, V> dVar2 = dVar.f29946e;
            dVar2.f29945d = dVar.f29945d;
            dVar.f29945d.f29946e = dVar2;
        }
        d<K, V> dVar3 = dVar.f29943b;
        d<K, V> dVar4 = dVar.f29944c;
        d<K, V> dVar5 = dVar.f29942a;
        int i3 = 0;
        if (dVar3 != null && dVar4 != null) {
            d<K, V> b2 = dVar3.f29949h > dVar4.f29949h ? dVar3.b() : dVar4.a();
            a((d) b2, false);
            d<K, V> dVar6 = dVar.f29943b;
            if (dVar6 != null) {
                i2 = dVar6.f29949h;
                b2.f29943b = dVar6;
                dVar6.f29942a = b2;
                dVar.f29943b = null;
            } else {
                i2 = 0;
            }
            d<K, V> dVar7 = dVar.f29944c;
            if (dVar7 != null) {
                i3 = dVar7.f29949h;
                b2.f29944c = dVar7;
                dVar7.f29942a = b2;
                dVar.f29944c = null;
            }
            b2.f29949h = Math.max(i2, i3) + 1;
            a((d) dVar, (d) b2);
            return;
        }
        if (dVar3 != null) {
            a((d) dVar, (d) dVar3);
            dVar.f29943b = null;
        } else if (dVar4 != null) {
            a((d) dVar, (d) dVar4);
            dVar.f29944c = null;
        } else {
            a((d) dVar, (d) null);
        }
        b(dVar5, false);
        this.f29929c--;
        this.f29930d++;
    }

    private void b(d<K, V> dVar) {
        d<K, V> dVar2 = dVar.f29943b;
        d<K, V> dVar3 = dVar.f29944c;
        d<K, V> dVar4 = dVar2.f29943b;
        d<K, V> dVar5 = dVar2.f29944c;
        dVar.f29943b = dVar5;
        if (dVar5 != null) {
            dVar5.f29942a = dVar;
        }
        a((d) dVar, (d) dVar2);
        dVar2.f29944c = dVar;
        dVar.f29942a = dVar2;
        int max = Math.max(dVar3 != null ? dVar3.f29949h : 0, dVar5 != null ? dVar5.f29949h : 0) + 1;
        dVar.f29949h = max;
        dVar2.f29949h = Math.max(max, dVar4 != null ? dVar4.f29949h : 0) + 1;
    }

    private void a(d<K, V> dVar, d<K, V> dVar2) {
        d<K, V> dVar3 = dVar.f29942a;
        dVar.f29942a = null;
        if (dVar2 != null) {
            dVar2.f29942a = dVar3;
        }
        if (dVar3 != null) {
            if (dVar3.f29943b == dVar) {
                dVar3.f29943b = dVar2;
                return;
            } else if (!f29925f && dVar3.f29944c != dVar) {
                throw new AssertionError();
            } else {
                dVar3.f29944c = dVar2;
                return;
            }
        }
        this.f29928b = dVar2;
    }

    private void a(d<K, V> dVar) {
        d<K, V> dVar2 = dVar.f29943b;
        d<K, V> dVar3 = dVar.f29944c;
        d<K, V> dVar4 = dVar3.f29943b;
        d<K, V> dVar5 = dVar3.f29944c;
        dVar.f29944c = dVar4;
        if (dVar4 != null) {
            dVar4.f29942a = dVar;
        }
        a((d) dVar, (d) dVar3);
        dVar3.f29943b = dVar;
        dVar.f29942a = dVar3;
        int max = Math.max(dVar2 != null ? dVar2.f29949h : 0, dVar4 != null ? dVar4.f29949h : 0) + 1;
        dVar.f29949h = max;
        dVar3.f29949h = Math.max(max, dVar5 != null ? dVar5.f29949h : 0) + 1;
    }
}
