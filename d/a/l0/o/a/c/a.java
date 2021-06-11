package d.a.l0.o.a.c;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
/* loaded from: classes3.dex */
public class a<K, V> extends f<K, V> implements Map<K, V> {
    public e<K, V> l;

    /* renamed from: d.a.l0.o.a.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1138a extends e<K, V> {
        public C1138a() {
        }

        @Override // d.a.l0.o.a.c.e
        public void a() {
            a.this.clear();
        }

        @Override // d.a.l0.o.a.c.e
        public Object b(int i2, int i3) {
            return a.this.f51979f[(i2 << 1) + i3];
        }

        @Override // d.a.l0.o.a.c.e
        public Map<K, V> c() {
            return a.this;
        }

        @Override // d.a.l0.o.a.c.e
        public int d() {
            return a.this.f51980g;
        }

        @Override // d.a.l0.o.a.c.e
        public int e(Object obj) {
            return a.this.e(obj);
        }

        @Override // d.a.l0.o.a.c.e
        public int f(Object obj) {
            return a.this.g(obj);
        }

        @Override // d.a.l0.o.a.c.e
        public void g(K k, V v) {
            a.this.put(k, v);
        }

        @Override // d.a.l0.o.a.c.e
        public void h(int i2) {
            a.this.i(i2);
        }

        @Override // d.a.l0.o.a.c.e
        public V i(int i2, V v) {
            return a.this.j(i2, v);
        }
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return l().l();
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        return l().m();
    }

    public final e<K, V> l() {
        if (this.l == null) {
            this.l = new C1138a();
        }
        return this.l;
    }

    public boolean m(Collection<?> collection) {
        return e.p(this, collection);
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        b(this.f51980g + map.size());
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public Collection<V> values() {
        return l().n();
    }
}
