package d.a.c0.k.a;

import java.util.Map;
/* loaded from: classes2.dex */
public abstract class d<K, V> {

    /* renamed from: a  reason: collision with root package name */
    public Map<K, V> f43140a = d.a.c0.n.e.a();

    public void a(Map<K, V> map) {
        this.f43140a = map;
    }

    public V b(K k) {
        return this.f43140a.get(k);
    }

    public Map<K, V> c() {
        return this.f43140a;
    }

    public Map<K, V> d() {
        return this.f43140a;
    }

    public void e(K k, V v) {
        this.f43140a.put(k, v);
    }
}
