package d.b.c0.k.a;

import java.util.Map;
/* loaded from: classes2.dex */
public abstract class d<K, V> {

    /* renamed from: a  reason: collision with root package name */
    public Map<K, V> f42544a = d.b.c0.n.e.a();

    public void a(Map<K, V> map) {
        this.f42544a = map;
    }

    public V b(K k) {
        return this.f42544a.get(k);
    }

    public Map<K, V> c() {
        return this.f42544a;
    }

    public Map<K, V> d() {
        return this.f42544a;
    }

    public void e(K k, V v) {
        this.f42544a.put(k, v);
    }
}
