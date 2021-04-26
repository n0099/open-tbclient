package d.a.h0.a.e0.w;

import android.text.TextUtils;
import android.util.Log;
import android.util.LruCache;
import d.a.h0.a.k;
/* loaded from: classes2.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f42354a = k.f43101a;

    /* renamed from: b  reason: collision with root package name */
    public static LruCache<String, Object> f42355b;

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final c f42356a = new c();
    }

    public static c b() {
        return b.f42356a;
    }

    public synchronized <CONFIG> CONFIG a(String str, CONFIG config) {
        if (TextUtils.isEmpty(str)) {
            return config;
        }
        CONFIG config2 = (CONFIG) f42355b.get(str);
        if (config2 == null) {
            return config;
        }
        if (f42354a) {
            Log.d("SwanAppConfigCache", "getConfig hit key: " + str);
        }
        return config2;
    }

    public synchronized <CONFIG> void c(String str, CONFIG config) {
        if (!TextUtils.isEmpty(str) && config != null) {
            if (f42354a) {
                Log.d("SwanAppConfigCache", "putConfig key: " + str);
            }
            f42355b.put(str, config);
        }
    }

    public c() {
        f42355b = new LruCache<>(10);
    }
}
