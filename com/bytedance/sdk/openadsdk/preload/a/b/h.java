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
    public static final /* synthetic */ boolean f30648f = !h.class.desiredAssertionStatus();

    /* renamed from: g  reason: collision with root package name */
    public static final Comparator<Comparable> f30649g = new Comparator<Comparable>() { // from class: com.bytedance.sdk.openadsdk.preload.a.b.h.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public Comparator<? super K> f30650a;

    /* renamed from: b  reason: collision with root package name */
    public d<K, V> f30651b;

    /* renamed from: c  reason: collision with root package name */
    public int f30652c;

    /* renamed from: d  reason: collision with root package name */
    public int f30653d;

    /* renamed from: e  reason: collision with root package name */
    public final d<K, V> f30654e;

    /* renamed from: h  reason: collision with root package name */
    public h<K, V>.a f30655h;

    /* renamed from: i  reason: collision with root package name */
    public h<K, V>.b f30656i;

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
            return h.this.f30652c;
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
                    return b().f30670f;
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return h.this.b(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return h.this.f30652c;
        }
    }

    /* loaded from: classes5.dex */
    public abstract class c<T> implements Iterator<T> {

        /* renamed from: b  reason: collision with root package name */
        public d<K, V> f30661b;

        /* renamed from: c  reason: collision with root package name */
        public d<K, V> f30662c;

        /* renamed from: d  reason: collision with root package name */
        public int f30663d;

        public c() {
            h hVar = h.this;
            this.f30661b = hVar.f30654e.f30668d;
            this.f30662c = null;
            this.f30663d = hVar.f30653d;
        }

        public final d<K, V> b() {
            d<K, V> dVar = this.f30661b;
            h hVar = h.this;
            if (dVar != hVar.f30654e) {
                if (hVar.f30653d == this.f30663d) {
                    this.f30661b = dVar.f30668d;
                    this.f30662c = dVar;
                    return dVar;
                }
                throw new ConcurrentModificationException();
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f30661b != h.this.f30654e;
        }

        @Override // java.util.Iterator
        public final void remove() {
            d<K, V> dVar = this.f30662c;
            if (dVar != null) {
                h.this.a((d) dVar, true);
                this.f30662c = null;
                this.f30663d = h.this.f30653d;
                return;
            }
            throw new IllegalStateException();
        }
    }

    public h() {
        this(f30649g);
    }

    /* JADX DEBUG: Type inference failed for r4v2. Raw type applied. Possible types: K, ? super K */
    public d<K, V> a(K k, boolean z) {
        int i2;
        d<K, V> dVar;
        Comparator<? super K> comparator = this.f30650a;
        d<K, V> dVar2 = this.f30651b;
        if (dVar2 != null) {
            Comparable comparable = comparator == f30649g ? (Comparable) k : null;
            while (true) {
                if (comparable != null) {
                    i2 = comparable.compareTo(dVar2.f30670f);
                } else {
                    i2 = comparator.compare(k, (K) dVar2.f30670f);
                }
                if (i2 == 0) {
                    return dVar2;
                }
                d<K, V> dVar3 = i2 < 0 ? dVar2.f30666b : dVar2.f30667c;
                if (dVar3 == null) {
                    break;
                }
                dVar2 = dVar3;
            }
        } else {
            i2 = 0;
        }
        if (z) {
            d<K, V> dVar4 = this.f30654e;
            if (dVar2 == null) {
                if (comparator == f30649g && !(k instanceof Comparable)) {
                    throw new ClassCastException(k.getClass().getName() + " is not Comparable");
                }
                dVar = new d<>(dVar2, k, dVar4, dVar4.f30669e);
                this.f30651b = dVar;
            } else {
                dVar = new d<>(dVar2, k, dVar4, dVar4.f30669e);
                if (i2 < 0) {
                    dVar2.f30666b = dVar;
                } else {
                    dVar2.f30667c = dVar;
                }
                b(dVar2, true);
            }
            this.f30652c++;
            this.f30653d++;
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
        this.f30651b = null;
        this.f30652c = 0;
        this.f30653d++;
        d<K, V> dVar = this.f30654e;
        dVar.f30669e = dVar;
        dVar.f30668d = dVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return a(obj) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        h<K, V>.a aVar = this.f30655h;
        if (aVar != null) {
            return aVar;
        }
        h<K, V>.a aVar2 = new a();
        this.f30655h = aVar2;
        return aVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        d<K, V> a2 = a(obj);
        if (a2 != null) {
            return a2.f30671g;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        h<K, V>.b bVar = this.f30656i;
        if (bVar != null) {
            return bVar;
        }
        h<K, V>.b bVar2 = new b();
        this.f30656i = bVar2;
        return bVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k, V v) {
        if (k != null) {
            d<K, V> a2 = a((h<K, V>) k, true);
            V v2 = a2.f30671g;
            a2.f30671g = v;
            return v2;
        }
        throw new NullPointerException("key == null");
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        d<K, V> b2 = b(obj);
        if (b2 != null) {
            return b2.f30671g;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f30652c;
    }

    public h(Comparator<? super K> comparator) {
        this.f30652c = 0;
        this.f30653d = 0;
        this.f30654e = new d<>();
        this.f30650a = comparator == null ? f30649g : comparator;
    }

    /* loaded from: classes5.dex */
    public static final class d<K, V> implements Map.Entry<K, V> {

        /* renamed from: a  reason: collision with root package name */
        public d<K, V> f30665a;

        /* renamed from: b  reason: collision with root package name */
        public d<K, V> f30666b;

        /* renamed from: c  reason: collision with root package name */
        public d<K, V> f30667c;

        /* renamed from: d  reason: collision with root package name */
        public d<K, V> f30668d;

        /* renamed from: e  reason: collision with root package name */
        public d<K, V> f30669e;

        /* renamed from: f  reason: collision with root package name */
        public final K f30670f;

        /* renamed from: g  reason: collision with root package name */
        public V f30671g;

        /* renamed from: h  reason: collision with root package name */
        public int f30672h;

        public d() {
            this.f30670f = null;
            this.f30669e = this;
            this.f30668d = this;
        }

        public d<K, V> a() {
            d<K, V> dVar = this;
            for (d<K, V> dVar2 = this.f30666b; dVar2 != null; dVar2 = dVar2.f30666b) {
                dVar = dVar2;
            }
            return dVar;
        }

        public d<K, V> b() {
            d<K, V> dVar = this;
            for (d<K, V> dVar2 = this.f30667c; dVar2 != null; dVar2 = dVar2.f30667c) {
                dVar = dVar2;
            }
            return dVar;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                K k = this.f30670f;
                if (k == null) {
                    if (entry.getKey() != null) {
                        return false;
                    }
                } else if (!k.equals(entry.getKey())) {
                    return false;
                }
                V v = this.f30671g;
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
            return this.f30670f;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f30671g;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K k = this.f30670f;
            int hashCode = k == null ? 0 : k.hashCode();
            V v = this.f30671g;
            return hashCode ^ (v != null ? v.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            V v2 = this.f30671g;
            this.f30671g = v;
            return v2;
        }

        public String toString() {
            return this.f30670f + "=" + this.f30671g;
        }

        public d(d<K, V> dVar, K k, d<K, V> dVar2, d<K, V> dVar3) {
            this.f30665a = dVar;
            this.f30670f = k;
            this.f30672h = 1;
            this.f30668d = dVar2;
            this.f30669e = dVar3;
            dVar3.f30668d = this;
            dVar2.f30669e = this;
        }
    }

    private void b(d<K, V> dVar, boolean z) {
        while (dVar != null) {
            d<K, V> dVar2 = dVar.f30666b;
            d<K, V> dVar3 = dVar.f30667c;
            int i2 = dVar2 != null ? dVar2.f30672h : 0;
            int i3 = dVar3 != null ? dVar3.f30672h : 0;
            int i4 = i2 - i3;
            if (i4 == -2) {
                d<K, V> dVar4 = dVar3.f30666b;
                d<K, V> dVar5 = dVar3.f30667c;
                int i5 = (dVar4 != null ? dVar4.f30672h : 0) - (dVar5 != null ? dVar5.f30672h : 0);
                if (i5 != -1 && (i5 != 0 || z)) {
                    if (!f30648f && i5 != 1) {
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
                d<K, V> dVar6 = dVar2.f30666b;
                d<K, V> dVar7 = dVar2.f30667c;
                int i6 = (dVar6 != null ? dVar6.f30672h : 0) - (dVar7 != null ? dVar7.f30672h : 0);
                if (i6 != 1 && (i6 != 0 || z)) {
                    if (!f30648f && i6 != -1) {
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
                dVar.f30672h = i2 + 1;
                if (z) {
                    return;
                }
            } else if (!f30648f && i4 != -1 && i4 != 1) {
                throw new AssertionError();
            } else {
                dVar.f30672h = Math.max(i2, i3) + 1;
                if (!z) {
                    return;
                }
            }
            dVar = dVar.f30665a;
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
        if (a2 != null && a(a2.f30671g, entry.getValue())) {
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
            d<K, V> dVar2 = dVar.f30669e;
            dVar2.f30668d = dVar.f30668d;
            dVar.f30668d.f30669e = dVar2;
        }
        d<K, V> dVar3 = dVar.f30666b;
        d<K, V> dVar4 = dVar.f30667c;
        d<K, V> dVar5 = dVar.f30665a;
        int i3 = 0;
        if (dVar3 != null && dVar4 != null) {
            d<K, V> b2 = dVar3.f30672h > dVar4.f30672h ? dVar3.b() : dVar4.a();
            a((d) b2, false);
            d<K, V> dVar6 = dVar.f30666b;
            if (dVar6 != null) {
                i2 = dVar6.f30672h;
                b2.f30666b = dVar6;
                dVar6.f30665a = b2;
                dVar.f30666b = null;
            } else {
                i2 = 0;
            }
            d<K, V> dVar7 = dVar.f30667c;
            if (dVar7 != null) {
                i3 = dVar7.f30672h;
                b2.f30667c = dVar7;
                dVar7.f30665a = b2;
                dVar.f30667c = null;
            }
            b2.f30672h = Math.max(i2, i3) + 1;
            a((d) dVar, (d) b2);
            return;
        }
        if (dVar3 != null) {
            a((d) dVar, (d) dVar3);
            dVar.f30666b = null;
        } else if (dVar4 != null) {
            a((d) dVar, (d) dVar4);
            dVar.f30667c = null;
        } else {
            a((d) dVar, (d) null);
        }
        b(dVar5, false);
        this.f30652c--;
        this.f30653d++;
    }

    private void b(d<K, V> dVar) {
        d<K, V> dVar2 = dVar.f30666b;
        d<K, V> dVar3 = dVar.f30667c;
        d<K, V> dVar4 = dVar2.f30666b;
        d<K, V> dVar5 = dVar2.f30667c;
        dVar.f30666b = dVar5;
        if (dVar5 != null) {
            dVar5.f30665a = dVar;
        }
        a((d) dVar, (d) dVar2);
        dVar2.f30667c = dVar;
        dVar.f30665a = dVar2;
        int max = Math.max(dVar3 != null ? dVar3.f30672h : 0, dVar5 != null ? dVar5.f30672h : 0) + 1;
        dVar.f30672h = max;
        dVar2.f30672h = Math.max(max, dVar4 != null ? dVar4.f30672h : 0) + 1;
    }

    private void a(d<K, V> dVar, d<K, V> dVar2) {
        d<K, V> dVar3 = dVar.f30665a;
        dVar.f30665a = null;
        if (dVar2 != null) {
            dVar2.f30665a = dVar3;
        }
        if (dVar3 != null) {
            if (dVar3.f30666b == dVar) {
                dVar3.f30666b = dVar2;
                return;
            } else if (!f30648f && dVar3.f30667c != dVar) {
                throw new AssertionError();
            } else {
                dVar3.f30667c = dVar2;
                return;
            }
        }
        this.f30651b = dVar2;
    }

    private void a(d<K, V> dVar) {
        d<K, V> dVar2 = dVar.f30666b;
        d<K, V> dVar3 = dVar.f30667c;
        d<K, V> dVar4 = dVar3.f30666b;
        d<K, V> dVar5 = dVar3.f30667c;
        dVar.f30667c = dVar4;
        if (dVar4 != null) {
            dVar4.f30665a = dVar;
        }
        a((d) dVar, (d) dVar3);
        dVar3.f30666b = dVar;
        dVar.f30665a = dVar3;
        int max = Math.max(dVar2 != null ? dVar2.f30672h : 0, dVar4 != null ? dVar4.f30672h : 0) + 1;
        dVar.f30672h = max;
        dVar3.f30672h = Math.max(max, dVar5 != null ? dVar5.f30672h : 0) + 1;
    }
}
