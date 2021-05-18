package d.a.c.e.k;

import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class a<K, V> {

    /* renamed from: a  reason: collision with root package name */
    public final LinkedHashMap<K, V> f39014a = new LinkedHashMap<>(0, 0.75f, true);

    /* renamed from: b  reason: collision with root package name */
    public int f39015b;

    /* renamed from: c  reason: collision with root package name */
    public int f39016c;

    /* renamed from: d  reason: collision with root package name */
    public int f39017d;

    /* renamed from: e  reason: collision with root package name */
    public int f39018e;

    /* renamed from: f  reason: collision with root package name */
    public int f39019f;

    /* renamed from: g  reason: collision with root package name */
    public int f39020g;

    public a(int i2) {
        this.f39016c = i2;
    }

    public final synchronized void a() {
        c();
        this.f39017d = 0;
        this.f39018e = 0;
        this.f39019f = 0;
        this.f39020g = 0;
    }

    public void b(boolean z, K k, V v, V v2) {
    }

    public final void c() {
        n(-1);
    }

    public final synchronized int d() {
        return this.f39018e;
    }

    public synchronized boolean e(int i2) {
        if (this.f39015b + i2 > this.f39016c * 0.8d) {
            n(this.f39015b - i2);
        }
        return true;
    }

    public final V f(K k) {
        if (k == null) {
            return null;
        }
        synchronized (this) {
            V v = this.f39014a.get(k);
            if (v != null) {
                this.f39019f++;
                return v;
            }
            this.f39020g++;
            return null;
        }
    }

    public final synchronized int g() {
        return this.f39016c;
    }

    public final V h(K k, V v) {
        V put;
        if (k == null || v == null) {
            return null;
        }
        synchronized (this) {
            this.f39017d++;
            this.f39015b += j(k, v);
            put = this.f39014a.put(k, v);
            if (put != null) {
                this.f39015b -= j(k, put);
            }
        }
        if (put != null) {
            b(false, k, put, v);
        }
        n(this.f39016c);
        return put;
    }

    public final V i(K k) {
        V remove;
        if (k == null) {
            return null;
        }
        synchronized (this) {
            remove = this.f39014a.remove(k);
            if (remove != null) {
                this.f39015b -= j(k, remove);
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
            this.f39016c = i2;
            n(i2);
        }
    }

    public final synchronized int l() {
        return this.f39015b;
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
                if (this.f39015b >= 0 && (!this.f39014a.isEmpty() || this.f39015b == 0)) {
                    if (this.f39015b <= i2 || this.f39014a.isEmpty()) {
                        break;
                    }
                    Map.Entry<K, V> next = this.f39014a.entrySet().iterator().next();
                    key = next.getKey();
                    value = next.getValue();
                    this.f39014a.remove(key);
                    this.f39015b -= j(key, value);
                    this.f39018e++;
                } else {
                    break;
                }
            }
            b(true, key, value, null);
        }
    }
}
