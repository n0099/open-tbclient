package d.b.a0.k.a;

import java.util.Map;
/* loaded from: classes2.dex */
public abstract class d<K, V> {

    /* renamed from: a  reason: collision with root package name */
    public Map<K, V> f41914a = d.b.a0.n.e.a();

    public void a(Map<K, V> map) {
        this.f41914a = map;
    }

    public V b(K k) {
        return this.f41914a.get(k);
    }

    public Map<K, V> c() {
        return this.f41914a;
    }

    public Map<K, V> d() {
        return this.f41914a;
    }

    public void e(K k, V v) {
        this.f41914a.put(k, v);
    }
}
