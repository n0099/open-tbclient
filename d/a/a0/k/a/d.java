package d.a.a0.k.a;

import java.util.Map;
/* loaded from: classes2.dex */
public abstract class d<K, V> {

    /* renamed from: a  reason: collision with root package name */
    public Map<K, V> f38336a = d.a.a0.n.e.a();

    public void a(Map<K, V> map) {
        this.f38336a = map;
    }

    public V b(K k) {
        return this.f38336a.get(k);
    }

    public Map<K, V> c() {
        return this.f38336a;
    }

    public Map<K, V> d() {
        return this.f38336a;
    }

    public void e(K k, V v) {
        this.f38336a.put(k, v);
    }
}
