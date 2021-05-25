package d.a.l0.o.a.c;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
/* loaded from: classes3.dex */
public abstract class e<K, V> {

    /* renamed from: a  reason: collision with root package name */
    public e<K, V>.b f48287a;

    /* renamed from: b  reason: collision with root package name */
    public e<K, V>.c f48288b;

    /* renamed from: c  reason: collision with root package name */
    public e<K, V>.C1083e f48289c;

    /* loaded from: classes3.dex */
    public final class a<T> implements Iterator<T> {

        /* renamed from: e  reason: collision with root package name */
        public final int f48290e;

        /* renamed from: f  reason: collision with root package name */
        public int f48291f;

        /* renamed from: g  reason: collision with root package name */
        public int f48292g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f48293h = false;

        public a(int i2) {
            this.f48290e = i2;
            this.f48291f = e.this.d();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f48292g < this.f48291f;
        }

        @Override // java.util.Iterator
        public T next() {
            T t = (T) e.this.b(this.f48292g, this.f48290e);
            this.f48292g++;
            this.f48293h = true;
            return t;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.f48293h) {
                int i2 = this.f48292g - 1;
                this.f48292g = i2;
                this.f48291f--;
                this.f48293h = false;
                e.this.h(i2);
                return;
            }
            throw new IllegalStateException();
        }
    }

    /* loaded from: classes3.dex */
    public final class b implements Set<Map.Entry<K, V>> {
        public b() {
        }

        public boolean a(Map.Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public /* bridge */ /* synthetic */ boolean add(Object obj) {
            a((Map.Entry) obj);
            throw null;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends Map.Entry<K, V>> collection) {
            int d2 = e.this.d();
            for (Map.Entry<K, V> entry : collection) {
                e.this.g(entry.getKey(), entry.getValue());
            }
            return d2 != e.this.d();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            e.this.a();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                int e2 = e.this.e(entry.getKey());
                if (e2 < 0) {
                    return false;
                }
                return d.a.l0.o.a.c.b.b(e.this.b(e2, 1), entry.getValue());
            }
            return false;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return e.k(this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int i2 = 0;
            for (int d2 = e.this.d() - 1; d2 >= 0; d2--) {
                Object b2 = e.this.b(d2, 0);
                Object b3 = e.this.b(d2, 1);
                i2 += (b2 == null ? 0 : b2.hashCode()) ^ (b3 == null ? 0 : b3.hashCode());
            }
            return i2;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return e.this.d() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<Map.Entry<K, V>> iterator() {
            return new d();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return e.this.d();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            throw new UnsupportedOperationException();
        }
    }

    /* loaded from: classes3.dex */
    public final class c implements Set<K> {
        public c() {
        }

        @Override // java.util.Set, java.util.Collection
        public boolean add(K k) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            e.this.a();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            return e.this.e(obj) >= 0;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            return e.j(e.this.c(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return e.k(this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int i2 = 0;
            for (int d2 = e.this.d() - 1; d2 >= 0; d2--) {
                Object b2 = e.this.b(d2, 0);
                i2 += b2 == null ? 0 : b2.hashCode();
            }
            return i2;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return e.this.d() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<K> iterator() {
            return new a(0);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            int e2 = e.this.e(obj);
            if (e2 >= 0) {
                e.this.h(e2);
                return true;
            }
            return false;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            return e.o(e.this.c(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            return e.p(e.this.c(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return e.this.d();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            return e.this.q(0);
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) e.this.r(tArr, 0);
        }
    }

    /* loaded from: classes3.dex */
    public final class d implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V> {

        /* renamed from: e  reason: collision with root package name */
        public int f48297e;

        /* renamed from: g  reason: collision with root package name */
        public boolean f48299g = false;

        /* renamed from: f  reason: collision with root package name */
        public int f48298f = -1;

        public d() {
            this.f48297e = e.this.d() - 1;
        }

        public Map.Entry<K, V> a() {
            this.f48298f++;
            this.f48299g = true;
            return this;
        }

        @Override // java.util.Map.Entry
        public final boolean equals(Object obj) {
            if (this.f48299g) {
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    return d.a.l0.o.a.c.b.b(entry.getKey(), e.this.b(this.f48298f, 0)) && d.a.l0.o.a.c.b.b(entry.getValue(), e.this.b(this.f48298f, 1));
                }
                return false;
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            if (this.f48299g) {
                return (K) e.this.b(this.f48298f, 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            if (this.f48299g) {
                return (V) e.this.b(this.f48298f, 1);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f48298f < this.f48297e;
        }

        @Override // java.util.Map.Entry
        public final int hashCode() {
            if (this.f48299g) {
                Object b2 = e.this.b(this.f48298f, 0);
                Object b3 = e.this.b(this.f48298f, 1);
                return (b2 == null ? 0 : b2.hashCode()) ^ (b3 != null ? b3.hashCode() : 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            a();
            return this;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.f48299g) {
                e.this.h(this.f48298f);
                this.f48298f--;
                this.f48297e--;
                this.f48299g = false;
                return;
            }
            throw new IllegalStateException();
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            if (this.f48299g) {
                return (V) e.this.i(this.f48298f, v);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final String toString() {
            return getKey() + "=" + getValue();
        }
    }

    /* renamed from: d.a.l0.o.a.c.e$e  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public final class C1083e implements Collection<V> {
        public C1083e() {
        }

        @Override // java.util.Collection
        public boolean add(V v) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public void clear() {
            e.this.a();
        }

        @Override // java.util.Collection
        public boolean contains(Object obj) {
            return e.this.f(obj) >= 0;
        }

        @Override // java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return e.this.d() == 0;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new a(1);
        }

        @Override // java.util.Collection
        public boolean remove(Object obj) {
            int f2 = e.this.f(obj);
            if (f2 >= 0) {
                e.this.h(f2);
                return true;
            }
            return false;
        }

        @Override // java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            int d2 = e.this.d();
            int i2 = 0;
            boolean z = false;
            while (i2 < d2) {
                if (collection.contains(e.this.b(i2, 1))) {
                    e.this.h(i2);
                    i2--;
                    d2--;
                    z = true;
                }
                i2++;
            }
            return z;
        }

        @Override // java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            int d2 = e.this.d();
            int i2 = 0;
            boolean z = false;
            while (i2 < d2) {
                if (!collection.contains(e.this.b(i2, 1))) {
                    e.this.h(i2);
                    i2--;
                    d2--;
                    z = true;
                }
                i2++;
            }
            return z;
        }

        @Override // java.util.Collection
        public int size() {
            return e.this.d();
        }

        @Override // java.util.Collection
        public Object[] toArray() {
            return e.this.q(1);
        }

        @Override // java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) e.this.r(tArr, 1);
        }
    }

    public static <K, V> boolean j(Map<K, V> map, Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!map.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static <T> boolean k(Set<T> set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() == set2.size()) {
                    if (set.containsAll(set2)) {
                        return true;
                    }
                }
                return false;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public static <K, V> boolean o(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            map.remove(it.next());
        }
        return size != map.size();
    }

    public static <K, V> boolean p(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<K> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    public abstract void a();

    public abstract Object b(int i2, int i3);

    public abstract Map<K, V> c();

    public abstract int d();

    public abstract int e(Object obj);

    public abstract int f(Object obj);

    public abstract void g(K k, V v);

    public abstract void h(int i2);

    public abstract V i(int i2, V v);

    public Set<Map.Entry<K, V>> l() {
        if (this.f48287a == null) {
            this.f48287a = new b();
        }
        return this.f48287a;
    }

    public Set<K> m() {
        if (this.f48288b == null) {
            this.f48288b = new c();
        }
        return this.f48288b;
    }

    public Collection<V> n() {
        if (this.f48289c == null) {
            this.f48289c = new C1083e();
        }
        return this.f48289c;
    }

    public Object[] q(int i2) {
        int d2 = d();
        Object[] objArr = new Object[d2];
        for (int i3 = 0; i3 < d2; i3++) {
            objArr[i3] = b(i3, i2);
        }
        return objArr;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v9, resolved type: T[] */
    /* JADX WARN: Multi-variable type inference failed */
    public <T> T[] r(T[] tArr, int i2) {
        int d2 = d();
        if (tArr.length < d2) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), d2));
        }
        for (int i3 = 0; i3 < d2; i3++) {
            tArr[i3] = b(i3, i2);
        }
        if (tArr.length > d2) {
            tArr[d2] = null;
        }
        return tArr;
    }
}
