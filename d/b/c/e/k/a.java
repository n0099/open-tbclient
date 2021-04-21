package d.b.c.e.k;

import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class a<K, V> {

    /* renamed from: a  reason: collision with root package name */
    public final LinkedHashMap<K, V> f42568a = new LinkedHashMap<>(0, 0.75f, true);

    /* renamed from: b  reason: collision with root package name */
    public int f42569b;

    /* renamed from: c  reason: collision with root package name */
    public int f42570c;

    /* renamed from: d  reason: collision with root package name */
    public int f42571d;

    /* renamed from: e  reason: collision with root package name */
    public int f42572e;

    /* renamed from: f  reason: collision with root package name */
    public int f42573f;

    /* renamed from: g  reason: collision with root package name */
    public int f42574g;

    public a(int i) {
        this.f42570c = i;
    }

    public final synchronized void a() {
        c();
        this.f42571d = 0;
        this.f42572e = 0;
        this.f42573f = 0;
        this.f42574g = 0;
    }

    public void b(boolean z, K k, V v, V v2) {
    }

    public final void c() {
        n(-1);
    }

    public final synchronized int d() {
        return this.f42572e;
    }

    public synchronized boolean e(int i) {
        if (this.f42569b + i > this.f42570c * 0.8d) {
            n(this.f42569b - i);
        }
        return true;
    }

    public final V f(K k) {
        if (k == null) {
            return null;
        }
        synchronized (this) {
            V v = this.f42568a.get(k);
            if (v != null) {
                this.f42573f++;
                return v;
            }
            this.f42574g++;
            return null;
        }
    }

    public final synchronized int g() {
        return this.f42570c;
    }

    public final V h(K k, V v) {
        V put;
        if (k == null || v == null) {
            return null;
        }
        synchronized (this) {
            this.f42571d++;
            this.f42569b += j(k, v);
            put = this.f42568a.put(k, v);
            if (put != null) {
                this.f42569b -= j(k, put);
            }
        }
        if (put != null) {
            b(false, k, put, v);
        }
        n(this.f42570c);
        return put;
    }

    public final V i(K k) {
        V remove;
        if (k == null) {
            return null;
        }
        synchronized (this) {
            remove = this.f42568a.remove(k);
            if (remove != null) {
                this.f42569b -= j(k, remove);
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
            this.f42570c = i;
            n(i);
        }
    }

    public final synchronized int l() {
        return this.f42569b;
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
                if (this.f42569b >= 0 && (!this.f42568a.isEmpty() || this.f42569b == 0)) {
                    if (this.f42569b <= i || this.f42568a.isEmpty()) {
                        break;
                    }
                    Map.Entry<K, V> next = this.f42568a.entrySet().iterator().next();
                    key = next.getKey();
                    value = next.getValue();
                    this.f42568a.remove(key);
                    this.f42569b -= j(key, value);
                    this.f42572e++;
                } else {
                    break;
                }
            }
            b(true, key, value, null);
        }
    }
}
