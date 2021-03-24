package d.b.h.a.k;

import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class e<K, V> {

    /* renamed from: a  reason: collision with root package name */
    public final LinkedHashMap<K, V> f49459a;

    /* renamed from: b  reason: collision with root package name */
    public int f49460b;

    /* renamed from: c  reason: collision with root package name */
    public int f49461c;

    /* renamed from: d  reason: collision with root package name */
    public int f49462d;

    /* renamed from: e  reason: collision with root package name */
    public int f49463e;

    /* renamed from: f  reason: collision with root package name */
    public int f49464f;

    /* renamed from: g  reason: collision with root package name */
    public int f49465g;

    /* renamed from: h  reason: collision with root package name */
    public int f49466h;

    public e(int i) {
        if (i > 0) {
            this.f49461c = i;
            this.f49459a = new LinkedHashMap<>(0, 0.75f, true);
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
                V v = this.f49459a.get(k);
                if (v != null) {
                    this.f49465g++;
                    return v;
                }
                this.f49466h++;
                V a2 = a(k);
                if (a2 == null) {
                    return null;
                }
                synchronized (this) {
                    this.f49463e++;
                    put = this.f49459a.put(k, a2);
                    if (put != null) {
                        this.f49459a.put(k, put);
                    } else {
                        this.f49460b += e(k, a2);
                    }
                }
                if (put != null) {
                    b(false, k, a2, put);
                    return put;
                }
                g(this.f49461c);
                return a2;
            }
        }
        throw new NullPointerException("key == null");
    }

    public final V d(K k, V v) {
        V put;
        if (k != null && v != null) {
            synchronized (this) {
                this.f49462d++;
                this.f49460b += e(k, v);
                put = this.f49459a.put(k, v);
                if (put != null) {
                    this.f49460b -= e(k, put);
                }
            }
            if (put != null) {
                b(false, k, put, v);
            }
            g(this.f49461c);
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
                if (this.f49460b >= 0 && (!this.f49459a.isEmpty() || this.f49460b == 0)) {
                    if (this.f49460b <= i || this.f49459a.isEmpty()) {
                        break;
                    }
                    Map.Entry<K, V> next = this.f49459a.entrySet().iterator().next();
                    key = next.getKey();
                    value = next.getValue();
                    this.f49459a.remove(key);
                    this.f49460b -= e(key, value);
                    this.f49464f++;
                } else {
                    break;
                }
            }
            b(true, key, value, null);
        }
    }

    public final synchronized String toString() {
        int i;
        i = this.f49465g + this.f49466h;
        return String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.f49461c), Integer.valueOf(this.f49465g), Integer.valueOf(this.f49466h), Integer.valueOf(i != 0 ? (this.f49465g * 100) / i : 0));
    }
}
