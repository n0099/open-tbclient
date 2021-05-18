package d.a.i0.a.h0.u;

import android.text.TextUtils;
import android.util.Log;
import android.util.LruCache;
import d.a.i0.a.k;
/* loaded from: classes2.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f42450a = k.f43025a;

    /* renamed from: b  reason: collision with root package name */
    public static LruCache<String, Object> f42451b;

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final f f42452a = new f();
    }

    public static f b() {
        return b.f42452a;
    }

    public synchronized <CONFIG> CONFIG a(String str, CONFIG config) {
        if (TextUtils.isEmpty(str)) {
            return config;
        }
        CONFIG config2 = (CONFIG) f42451b.get(str);
        if (config2 == null) {
            return config;
        }
        if (f42450a) {
            Log.d("SwanAppConfigCache", "getConfig hit key: " + str);
        }
        return config2;
    }

    public synchronized <CONFIG> void c(String str, CONFIG config) {
        if (!TextUtils.isEmpty(str) && config != null) {
            if (f42450a) {
                Log.d("SwanAppConfigCache", "putConfig key: " + str);
            }
            f42451b.put(str, config);
        }
    }

    public f() {
        f42451b = new LruCache<>(10);
    }
}
