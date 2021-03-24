package d.b.b.e.k;

import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class a<K, V> {

    /* renamed from: a  reason: collision with root package name */
    public final LinkedHashMap<K, V> f41830a = new LinkedHashMap<>(0, 0.75f, true);

    /* renamed from: b  reason: collision with root package name */
    public int f41831b;

    /* renamed from: c  reason: collision with root package name */
    public int f41832c;

    /* renamed from: d  reason: collision with root package name */
    public int f41833d;

    /* renamed from: e  reason: collision with root package name */
    public int f41834e;

    /* renamed from: f  reason: collision with root package name */
    public int f41835f;

    /* renamed from: g  reason: collision with root package name */
    public int f41836g;

    public a(int i) {
        this.f41832c = i;
    }

    public final synchronized void a() {
        c();
        this.f41833d = 0;
        this.f41834e = 0;
        this.f41835f = 0;
        this.f41836g = 0;
    }

    public void b(boolean z, K k, V v, V v2) {
    }

    public final void c() {
        n(-1);
    }

    public final synchronized int d() {
        return this.f41834e;
    }

    public synchronized boolean e(int i) {
        double d2 = this.f41831b + i;
        double d3 = this.f41832c;
        Double.isNaN(d3);
        if (d2 > d3 * 0.8d) {
            n(this.f41831b - i);
        }
        return true;
    }

    public final V f(K k) {
        if (k == null) {
            return null;
        }
        synchronized (this) {
            V v = this.f41830a.get(k);
            if (v != null) {
                this.f41835f++;
                return v;
            }
            this.f41836g++;
            return null;
        }
    }

    public final synchronized int g() {
        return this.f41832c;
    }

    public final V h(K k, V v) {
        V put;
        if (k == null || v == null) {
            return null;
        }
        synchronized (this) {
            this.f41833d++;
            this.f41831b += j(k, v);
            put = this.f41830a.put(k, v);
            if (put != null) {
                this.f41831b -= j(k, put);
            }
        }
        if (put != null) {
            b(false, k, put, v);
        }
        n(this.f41832c);
        return put;
    }

    public final V i(K k) {
        V remove;
        if (k == null) {
            return null;
        }
        synchronized (this) {
            remove = this.f41830a.remove(k);
            if (remove != null) {
                this.f41831b -= j(k, remove);
            }
        }
        if (remove != null) {
            b(false, k, remove, null);
        }
        return remove;
    }

    public final int j(K k, V v) {
        int m = m(k, v);
        if (m >= 0) {
            return m;
        }
        throw new IllegalStateException("Negative size: " + k + "=" + v);
    }

    public final void k(int i) {
        synchronized (this) {
            this.f41832c = i;
            n(i);
        }
    }

    public final synchronized int l() {
        return this.f41831b;
    }

    public int m(K k, V v) {
        return 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0070, code lost:
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void n(int i) {
        K key;
        V value;
        while (true) {
            synchronized (this) {
                if (this.f41831b >= 0 && (!this.f41830a.isEmpty() || this.f41831b == 0)) {
                    if (this.f41831b <= i || this.f41830a.isEmpty()) {
                        break;
                    }
                    Map.Entry<K, V> next = this.f41830a.entrySet().iterator().next();
                    key = next.getKey();
                    value = next.getValue();
                    this.f41830a.remove(key);
                    this.f41831b -= j(key, value);
                    this.f41834e++;
                } else {
                    break;
                }
            }
            b(true, key, value, null);
        }
    }
}
