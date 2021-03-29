package d.b.h.a.k;

import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class e<K, V> {

    /* renamed from: a  reason: collision with root package name */
    public final LinkedHashMap<K, V> f49460a;

    /* renamed from: b  reason: collision with root package name */
    public int f49461b;

    /* renamed from: c  reason: collision with root package name */
    public int f49462c;

    /* renamed from: d  reason: collision with root package name */
    public int f49463d;

    /* renamed from: e  reason: collision with root package name */
    public int f49464e;

    /* renamed from: f  reason: collision with root package name */
    public int f49465f;

    /* renamed from: g  reason: collision with root package name */
    public int f49466g;

    /* renamed from: h  reason: collision with root package name */
    public int f49467h;

    public e(int i) {
        if (i > 0) {
            this.f49462c = i;
            this.f49460a = new LinkedHashMap<>(0, 0.75f, true);
            return;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    public V a(K k) {
        return null;
    }

    public void b(boolean z, K k, V v, V v2) {
    }

    public final V c(K k) {
        V put;
        if (k != null) {
            synchronized (this) {
                V v = this.f49460a.get(k);
                if (v != null) {
                    this.f49466g++;
                    return v;
                }
                this.f49467h++;
                V a2 = a(k);
                if (a2 == null) {
                    return null;
                }
                synchronized (this) {
                    this.f49464e++;
                    put = this.f49460a.put(k, a2);
                    if (put != null) {
                        this.f49460a.put(k, put);
                    } else {
                        this.f49461b += e(k, a2);
                    }
                }
                if (put != null) {
                    b(false, k, a2, put);
                    return put;
                }
                g(this.f49462c);
                return a2;
            }
        }
        throw new NullPointerException("key == null");
    }

    public final V d(K k, V v) {
        V put;
        if (k != null && v != null) {
            synchronized (this) {
                this.f49463d++;
                this.f49461b += e(k, v);
                put = this.f49460a.put(k, v);
                if (put != null) {
                    this.f49461b -= e(k, put);
                }
            }
            if (put != null) {
                b(false, k, put, v);
            }
            g(this.f49462c);
            return put;
        }
        throw new NullPointerException("key == null || value == null");
    }

    public final int e(K k, V v) {
        int f2 = f(k, v);
        if (f2 >= 0) {
            return f2;
        }
        throw new IllegalStateException("Negative size: " + k + "=" + v);
    }

    public int f(K k, V v) {
        return 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0070, code lost:
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void g(int i) {
        K key;
        V value;
        while (true) {
            synchronized (this) {
                if (this.f49461b >= 0 && (!this.f49460a.isEmpty() || this.f49461b == 0)) {
                    if (this.f49461b <= i || this.f49460a.isEmpty()) {
                        break;
                    }
                    Map.Entry<K, V> next = this.f49460a.entrySet().iterator().next();
                    key = next.getKey();
                    value = next.getValue();
                    this.f49460a.remove(key);
                    this.f49461b -= e(key, value);
                    this.f49465f++;
                } else {
                    break;
                }
            }
            b(true, key, value, null);
        }
    }

    public final synchronized String toString() {
        int i;
        i = this.f49466g + this.f49467h;
        return String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.f49462c), Integer.valueOf(this.f49466g), Integer.valueOf(this.f49467h), Integer.valueOf(i != 0 ? (this.f49466g * 100) / i : 0));
    }
}
