package d.a.c.e.k;

import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class a<K, V> {

    /* renamed from: a  reason: collision with root package name */
    public final LinkedHashMap<K, V> f38678a = new LinkedHashMap<>(0, 0.75f, true);

    /* renamed from: b  reason: collision with root package name */
    public int f38679b;

    /* renamed from: c  reason: collision with root package name */
    public int f38680c;

    /* renamed from: d  reason: collision with root package name */
    public int f38681d;

    /* renamed from: e  reason: collision with root package name */
    public int f38682e;

    /* renamed from: f  reason: collision with root package name */
    public int f38683f;

    /* renamed from: g  reason: collision with root package name */
    public int f38684g;

    public a(int i2) {
        this.f38680c = i2;
    }

    public final synchronized void a() {
        c();
        this.f38681d = 0;
        this.f38682e = 0;
        this.f38683f = 0;
        this.f38684g = 0;
    }

    public void b(boolean z, K k, V v, V v2) {
    }

    public final void c() {
        n(-1);
    }

    public final synchronized int d() {
        return this.f38682e;
    }

    public synchronized boolean e(int i2) {
        if (this.f38679b + i2 > this.f38680c * 0.8d) {
            n(this.f38679b - i2);
        }
        return true;
    }

    public final V f(K k) {
        if (k == null) {
            return null;
        }
        synchronized (this) {
            V v = this.f38678a.get(k);
            if (v != null) {
                this.f38683f++;
                return v;
            }
            this.f38684g++;
            return null;
        }
    }

    public final synchronized int g() {
        return this.f38680c;
    }

    public final V h(K k, V v) {
        V put;
        if (k == null || v == null) {
            return null;
        }
        synchronized (this) {
            this.f38681d++;
            this.f38679b += j(k, v);
            put = this.f38678a.put(k, v);
            if (put != null) {
                this.f38679b -= j(k, put);
            }
        }
        if (put != null) {
            b(false, k, put, v);
        }
        n(this.f38680c);
        return put;
    }

    public final V i(K k) {
        V remove;
        if (k == null) {
            return null;
        }
        synchronized (this) {
            remove = this.f38678a.remove(k);
            if (remove != null) {
                this.f38679b -= j(k, remove);
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

    public final void k(int i2) {
        synchronized (this) {
            this.f38680c = i2;
            n(i2);
        }
    }

    public final synchronized int l() {
        return this.f38679b;
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
    public void n(int i2) {
        K key;
        V value;
        while (true) {
            synchronized (this) {
                if (this.f38679b >= 0 && (!this.f38678a.isEmpty() || this.f38679b == 0)) {
                    if (this.f38679b <= i2 || this.f38678a.isEmpty()) {
                        break;
                    }
                    Map.Entry<K, V> next = this.f38678a.entrySet().iterator().next();
                    key = next.getKey();
                    value = next.getValue();
                    this.f38678a.remove(key);
                    this.f38679b -= j(key, value);
                    this.f38682e++;
                } else {
                    break;
                }
            }
            b(true, key, value, null);
        }
    }
}
