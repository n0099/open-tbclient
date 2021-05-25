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
    public static final /* synthetic */ boolean f29822f = !h.class.desiredAssertionStatus();

    /* renamed from: g  reason: collision with root package name */
    public static final Comparator<Comparable> f29823g = new Comparator<Comparable>() { // from class: com.bytedance.sdk.openadsdk.preload.a.b.h.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public Comparator<? super K> f29824a;

    /* renamed from: b  reason: collision with root package name */
    public d<K, V> f29825b;

    /* renamed from: c  reason: collision with root package name */
    public int f29826c;

    /* renamed from: d  reason: collision with root package name */
    public int f29827d;

    /* renamed from: e  reason: collision with root package name */
    public final d<K, V> f29828e;

    /* renamed from: h  reason: collision with root package name */
    public h<K, V>.a f29829h;

    /* renamed from: i  reason: collision with root package name */
    public h<K, V>.b f29830i;

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
            return h.this.f29826c;
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
                    return b().f29844f;
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return h.this.b(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return h.this.f29826c;
        }
    }

    /* loaded from: classes6.dex */
    public abstract class c<T> implements Iterator<T> {

        /* renamed from: b  reason: collision with root package name */
        public d<K, V> f29835b;

        /* renamed from: c  reason: collision with root package name */
        public d<K, V> f29836c;

        /* renamed from: d  reason: collision with root package name */
        public int f29837d;

        public c() {
            h hVar = h.this;
            this.f29835b = hVar.f29828e.f29842d;
            this.f29836c = null;
            this.f29837d = hVar.f29827d;
        }

        public final d<K, V> b() {
            d<K, V> dVar = this.f29835b;
            h hVar = h.this;
            if (dVar != hVar.f29828e) {
                if (hVar.f29827d == this.f29837d) {
                    this.f29835b = dVar.f29842d;
                    this.f29836c = dVar;
                    return dVar;
                }
                throw new ConcurrentModificationException();
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f29835b != h.this.f29828e;
        }

        @Override // java.util.Iterator
        public final void remove() {
            d<K, V> dVar = this.f29836c;
            if (dVar != null) {
                h.this.a((d) dVar, true);
                this.f29836c = null;
                this.f29837d = h.this.f29827d;
                return;
            }
            throw new IllegalStateException();
        }
    }

    public h() {
        this(f29823g);
    }

    /* JADX DEBUG: Type inference failed for r4v2. Raw type applied. Possible types: K, ? super K */
    public d<K, V> a(K k, boolean z) {
        int i2;
        d<K, V> dVar;
        Comparator<? super K> comparator = this.f29824a;
        d<K, V> dVar2 = this.f29825b;
        if (dVar2 != null) {
            Comparable comparable = comparator == f29823g ? (Comparable) k : null;
            while (true) {
                if (comparable != null) {
                    i2 = comparable.compareTo(dVar2.f29844f);
                } else {
                    i2 = comparator.compare(k, (K) dVar2.f29844f);
                }
                if (i2 == 0) {
                    return dVar2;
                }
                d<K, V> dVar3 = i2 < 0 ? dVar2.f29840b : dVar2.f29841c;
                if (dVar3 == null) {
                    break;
                }
                dVar2 = dVar3;
            }
        } else {
            i2 = 0;
        }
        if (z) {
            d<K, V> dVar4 = this.f29828e;
            if (dVar2 == null) {
                if (comparator == f29823g && !(k instanceof Comparable)) {
                    throw new ClassCastException(k.getClass().getName() + " is not Comparable");
                }
                dVar = new d<>(dVar2, k, dVar4, dVar4.f29843e);
                this.f29825b = dVar;
            } else {
                dVar = new d<>(dVar2, k, dVar4, dVar4.f29843e);
                if (i2 < 0) {
                    dVar2.f29840b = dVar;
                } else {
                    dVar2.f29841c = dVar;
                }
                b(dVar2, true);
            }
            this.f29826c++;
            this.f29827d++;
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
        this.f29825b = null;
        this.f29826c = 0;
        this.f29827d++;
        d<K, V> dVar = this.f29828e;
        dVar.f29843e = dVar;
        dVar.f29842d = dVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return a(obj) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        h<K, V>.a aVar = this.f29829h;
        if (aVar != null) {
            return aVar;
        }
        h<K, V>.a aVar2 = new a();
        this.f29829h = aVar2;
        return aVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        d<K, V> a2 = a(obj);
        if (a2 != null) {
            return a2.f29845g;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        h<K, V>.b bVar = this.f29830i;
        if (bVar != null) {
            return bVar;
        }
        h<K, V>.b bVar2 = new b();
        this.f29830i = bVar2;
        return bVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k, V v) {
        if (k != null) {
            d<K, V> a2 = a((h<K, V>) k, true);
            V v2 = a2.f29845g;
            a2.f29845g = v;
            return v2;
        }
        throw new NullPointerException("key == null");
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        d<K, V> b2 = b(obj);
        if (b2 != null) {
            return b2.f29845g;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f29826c;
    }

    public h(Comparator<? super K> comparator) {
        this.f29826c = 0;
        this.f29827d = 0;
        this.f29828e = new d<>();
        this.f29824a = comparator == null ? f29823g : comparator;
    }

    /* loaded from: classes6.dex */
    public static final class d<K, V> implements Map.Entry<K, V> {

        /* renamed from: a  reason: collision with root package name */
        public d<K, V> f29839a;

        /* renamed from: b  reason: collision with root package name */
        public d<K, V> f29840b;

        /* renamed from: c  reason: collision with root package name */
        public d<K, V> f29841c;

        /* renamed from: d  reason: collision with root package name */
        public d<K, V> f29842d;

        /* renamed from: e  reason: collision with root package name */
        public d<K, V> f29843e;

        /* renamed from: f  reason: collision with root package name */
        public final K f29844f;

        /* renamed from: g  reason: collision with root package name */
        public V f29845g;

        /* renamed from: h  reason: collision with root package name */
        public int f29846h;

        public d() {
            this.f29844f = null;
            this.f29843e = this;
            this.f29842d = this;
        }

        public d<K, V> a() {
            d<K, V> dVar = this;
            for (d<K, V> dVar2 = this.f29840b; dVar2 != null; dVar2 = dVar2.f29840b) {
                dVar = dVar2;
            }
            return dVar;
        }

        public d<K, V> b() {
            d<K, V> dVar = this;
            for (d<K, V> dVar2 = this.f29841c; dVar2 != null; dVar2 = dVar2.f29841c) {
                dVar = dVar2;
            }
            return dVar;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                K k = this.f29844f;
                if (k == null) {
                    if (entry.getKey() != null) {
                        return false;
                    }
                } else if (!k.equals(entry.getKey())) {
                    return false;
                }
                V v = this.f29845g;
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
            return this.f29844f;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f29845g;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K k = this.f29844f;
            int hashCode = k == null ? 0 : k.hashCode();
            V v = this.f29845g;
            return hashCode ^ (v != null ? v.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            V v2 = this.f29845g;
            this.f29845g = v;
            return v2;
        }

        public String toString() {
            return this.f29844f + "=" + this.f29845g;
        }

        public d(d<K, V> dVar, K k, d<K, V> dVar2, d<K, V> dVar3) {
            this.f29839a = dVar;
            this.f29844f = k;
            this.f29846h = 1;
            this.f29842d = dVar2;
            this.f29843e = dVar3;
            dVar3.f29842d = this;
            dVar2.f29843e = this;
        }
    }

    private void b(d<K, V> dVar, boolean z) {
        while (dVar != null) {
            d<K, V> dVar2 = dVar.f29840b;
            d<K, V> dVar3 = dVar.f29841c;
            int i2 = dVar2 != null ? dVar2.f29846h : 0;
            int i3 = dVar3 != null ? dVar3.f29846h : 0;
            int i4 = i2 - i3;
            if (i4 == -2) {
                d<K, V> dVar4 = dVar3.f29840b;
                d<K, V> dVar5 = dVar3.f29841c;
                int i5 = (dVar4 != null ? dVar4.f29846h : 0) - (dVar5 != null ? dVar5.f29846h : 0);
                if (i5 != -1 && (i5 != 0 || z)) {
                    if (!f29822f && i5 != 1) {
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
                d<K, V> dVar6 = dVar2.f29840b;
                d<K, V> dVar7 = dVar2.f29841c;
                int i6 = (dVar6 != null ? dVar6.f29846h : 0) - (dVar7 != null ? dVar7.f29846h : 0);
                if (i6 != 1 && (i6 != 0 || z)) {
                    if (!f29822f && i6 != -1) {
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
                dVar.f29846h = i2 + 1;
                if (z) {
                    return;
                }
            } else if (!f29822f && i4 != -1 && i4 != 1) {
                throw new AssertionError();
            } else {
                dVar.f29846h = Math.max(i2, i3) + 1;
                if (!z) {
                    return;
                }
            }
            dVar = dVar.f29839a;
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
        if (a2 != null && a(a2.f29845g, entry.getValue())) {
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
            d<K, V> dVar2 = dVar.f29843e;
            dVar2.f29842d = dVar.f29842d;
            dVar.f29842d.f29843e = dVar2;
        }
        d<K, V> dVar3 = dVar.f29840b;
        d<K, V> dVar4 = dVar.f29841c;
        d<K, V> dVar5 = dVar.f29839a;
        int i3 = 0;
        if (dVar3 != null && dVar4 != null) {
            d<K, V> b2 = dVar3.f29846h > dVar4.f29846h ? dVar3.b() : dVar4.a();
            a((d) b2, false);
            d<K, V> dVar6 = dVar.f29840b;
            if (dVar6 != null) {
                i2 = dVar6.f29846h;
                b2.f29840b = dVar6;
                dVar6.f29839a = b2;
                dVar.f29840b = null;
            } else {
                i2 = 0;
            }
            d<K, V> dVar7 = dVar.f29841c;
            if (dVar7 != null) {
                i3 = dVar7.f29846h;
                b2.f29841c = dVar7;
                dVar7.f29839a = b2;
                dVar.f29841c = null;
            }
            b2.f29846h = Math.max(i2, i3) + 1;
            a((d) dVar, (d) b2);
            return;
        }
        if (dVar3 != null) {
            a((d) dVar, (d) dVar3);
            dVar.f29840b = null;
        } else if (dVar4 != null) {
            a((d) dVar, (d) dVar4);
            dVar.f29841c = null;
        } else {
            a((d) dVar, (d) null);
        }
        b(dVar5, false);
        this.f29826c--;
        this.f29827d++;
    }

    private void b(d<K, V> dVar) {
        d<K, V> dVar2 = dVar.f29840b;
        d<K, V> dVar3 = dVar.f29841c;
        d<K, V> dVar4 = dVar2.f29840b;
        d<K, V> dVar5 = dVar2.f29841c;
        dVar.f29840b = dVar5;
        if (dVar5 != null) {
            dVar5.f29839a = dVar;
        }
        a((d) dVar, (d) dVar2);
        dVar2.f29841c = dVar;
        dVar.f29839a = dVar2;
        int max = Math.max(dVar3 != null ? dVar3.f29846h : 0, dVar5 != null ? dVar5.f29846h : 0) + 1;
        dVar.f29846h = max;
        dVar2.f29846h = Math.max(max, dVar4 != null ? dVar4.f29846h : 0) + 1;
    }

    private void a(d<K, V> dVar, d<K, V> dVar2) {
        d<K, V> dVar3 = dVar.f29839a;
        dVar.f29839a = null;
        if (dVar2 != null) {
            dVar2.f29839a = dVar3;
        }
        if (dVar3 != null) {
            if (dVar3.f29840b == dVar) {
                dVar3.f29840b = dVar2;
                return;
            } else if (!f29822f && dVar3.f29841c != dVar) {
                throw new AssertionError();
            } else {
                dVar3.f29841c = dVar2;
                return;
            }
        }
        this.f29825b = dVar2;
    }

    private void a(d<K, V> dVar) {
        d<K, V> dVar2 = dVar.f29840b;
        d<K, V> dVar3 = dVar.f29841c;
        d<K, V> dVar4 = dVar3.f29840b;
        d<K, V> dVar5 = dVar3.f29841c;
        dVar.f29841c = dVar4;
        if (dVar4 != null) {
            dVar4.f29839a = dVar;
        }
        a((d) dVar, (d) dVar3);
        dVar3.f29840b = dVar;
        dVar.f29839a = dVar3;
        int max = Math.max(dVar2 != null ? dVar2.f29846h : 0, dVar4 != null ? dVar4.f29846h : 0) + 1;
        dVar.f29846h = max;
        dVar3.f29846h = Math.max(max, dVar5 != null ? dVar5.f29846h : 0) + 1;
    }
}
