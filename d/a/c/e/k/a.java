package d.a.c.e.k;

import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class a<K, V> {

    /* renamed from: a  reason: collision with root package name */
    public final LinkedHashMap<K, V> f42331a = new LinkedHashMap<>(0, 0.75f, true);

    /* renamed from: b  reason: collision with root package name */
    public int f42332b;

    /* renamed from: c  reason: collision with root package name */
    public int f42333c;

    /* renamed from: d  reason: collision with root package name */
    public int f42334d;

    /* renamed from: e  reason: collision with root package name */
    public int f42335e;

    /* renamed from: f  reason: collision with root package name */
    public int f42336f;

    /* renamed from: g  reason: collision with root package name */
    public int f42337g;

    public a(int i2) {
        this.f42333c = i2;
    }

    public final synchronized void a() {
        c();
        this.f42334d = 0;
        this.f42335e = 0;
        this.f42336f = 0;
        this.f42337g = 0;
    }

    public void b(boolean z, K k, V v, V v2) {
    }

    public final void c() {
        n(-1);
    }

    public final synchronized int d() {
        return this.f42335e;
    }

    public synchronized boolean e(int i2) {
        if (this.f42332b + i2 > this.f42333c * 0.8d) {
            n(this.f42332b - i2);
        }
        return true;
    }

    public final V f(K k) {
        if (k == null) {
            return null;
        }
        synchronized (this) {
            V v = this.f42331a.get(k);
            if (v != null) {
                this.f42336f++;
                return v;
            }
            this.f42337g++;
            return null;
        }
    }

    public final synchronized int g() {
        return this.f42333c;
    }

    public final V h(K k, V v) {
        V put;
        if (k == null || v == null) {
            return null;
        }
        synchronized (this) {
            this.f42334d++;
            this.f42332b += j(k, v);
            put = this.f42331a.put(k, v);
            if (put != null) {
                this.f42332b -= j(k, put);
            }
        }
        if (put != null) {
            b(false, k, put, v);
        }
        n(this.f42333c);
        return put;
    }

    public final V i(K k) {
        V remove;
        if (k == null) {
            return null;
        }
        synchronized (this) {
            remove = this.f42331a.remove(k);
            if (remove != null) {
                this.f42332b -= j(k, remove);
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
            this.f42333c = i2;
            n(i2);
        }
    }

    public final synchronized int l() {
        return this.f42332b;
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
                if (this.f42332b >= 0 && (!this.f42331a.isEmpty() || this.f42332b == 0)) {
                    if (this.f42332b <= i2 || this.f42331a.isEmpty()) {
                        break;
                    }
                    Map.Entry<K, V> next = this.f42331a.entrySet().iterator().next();
                    key = next.getKey();
                    value = next.getValue();
                    this.f42331a.remove(key);
                    this.f42332b -= j(key, value);
                    this.f42335e++;
                } else {
                    break;
                }
            }
            b(true, key, value, null);
        }
    }
}
