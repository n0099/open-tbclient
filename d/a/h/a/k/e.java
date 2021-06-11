package d.a.h.a.k;

import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class e<K, V> {

    /* renamed from: a  reason: collision with root package name */
    public final LinkedHashMap<K, V> f43646a;

    /* renamed from: b  reason: collision with root package name */
    public int f43647b;

    /* renamed from: c  reason: collision with root package name */
    public int f43648c;

    /* renamed from: d  reason: collision with root package name */
    public int f43649d;

    /* renamed from: e  reason: collision with root package name */
    public int f43650e;

    /* renamed from: f  reason: collision with root package name */
    public int f43651f;

    /* renamed from: g  reason: collision with root package name */
    public int f43652g;

    /* renamed from: h  reason: collision with root package name */
    public int f43653h;

    public e(int i2) {
        if (i2 > 0) {
            this.f43648c = i2;
            this.f43646a = new LinkedHashMap<>(0, 0.75f, true);
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
                V v = this.f43646a.get(k);
                if (v != null) {
                    this.f43652g++;
                    return v;
                }
                this.f43653h++;
                V a2 = a(k);
                if (a2 == null) {
                    return null;
                }
                synchronized (this) {
                    this.f43650e++;
                    put = this.f43646a.put(k, a2);
                    if (put != null) {
                        this.f43646a.put(k, put);
                    } else {
                        this.f43647b += e(k, a2);
                    }
                }
                if (put != null) {
                    b(false, k, a2, put);
                    return put;
                }
                g(this.f43648c);
                return a2;
            }
        }
        throw new NullPointerException("key == null");
    }

    public final V d(K k, V v) {
        V put;
        if (k != null && v != null) {
            synchronized (this) {
                this.f43649d++;
                this.f43647b += e(k, v);
                put = this.f43646a.put(k, v);
                if (put != null) {
                    this.f43647b -= e(k, put);
                }
            }
            if (put != null) {
                b(false, k, put, v);
            }
            g(this.f43648c);
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
    public void g(int i2) {
        K key;
        V value;
        while (true) {
            synchronized (this) {
                if (this.f43647b >= 0 && (!this.f43646a.isEmpty() || this.f43647b == 0)) {
                    if (this.f43647b <= i2 || this.f43646a.isEmpty()) {
                        break;
                    }
                    Map.Entry<K, V> next = this.f43646a.entrySet().iterator().next();
                    key = next.getKey();
                    value = next.getValue();
                    this.f43646a.remove(key);
                    this.f43647b -= e(key, value);
                    this.f43651f++;
                } else {
                    break;
                }
            }
            b(true, key, value, null);
        }
    }

    public final synchronized String toString() {
        int i2;
        i2 = this.f43652g + this.f43653h;
        return String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.f43648c), Integer.valueOf(this.f43652g), Integer.valueOf(this.f43653h), Integer.valueOf(i2 != 0 ? (this.f43652g * 100) / i2 : 0));
    }
}
