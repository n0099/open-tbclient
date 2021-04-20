package d.b.z.k.a;

import java.util.Map;
/* loaded from: classes2.dex */
public abstract class d<K, V> {

    /* renamed from: a  reason: collision with root package name */
    public Map<K, V> f65612a = d.b.z.n.e.a();

    public void a(Map<K, V> map) {
        this.f65612a = map;
    }

    public V b(K k) {
        return this.f65612a.get(k);
    }

    public Map<K, V> c() {
        return this.f65612a;
    }

    public Map<K, V> d() {
        return this.f65612a;
    }

    public void e(K k, V v) {
        this.f65612a.put(k, v);
    }
}
