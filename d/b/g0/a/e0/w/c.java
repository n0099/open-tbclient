package d.b.g0.a.e0.w;

import android.text.TextUtils;
import android.util.Log;
import android.util.LruCache;
import d.b.g0.a.k;
/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f44324a = k.f45050a;

    /* renamed from: b  reason: collision with root package name */
    public static LruCache<String, Object> f44325b;

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final c f44326a = new c();
    }

    public static c b() {
        return b.f44326a;
    }

    public synchronized <CONFIG> CONFIG a(String str, CONFIG config) {
        if (TextUtils.isEmpty(str)) {
            return config;
        }
        CONFIG config2 = (CONFIG) f44325b.get(str);
        if (config2 == null) {
            return config;
        }
        if (f44324a) {
            Log.d("SwanAppConfigCache", "getConfig hit key: " + str);
        }
        return config2;
    }

    public synchronized <CONFIG> void c(String str, CONFIG config) {
        if (!TextUtils.isEmpty(str) && config != null) {
            if (f44324a) {
                Log.d("SwanAppConfigCache", "putConfig key: " + str);
            }
            f44325b.put(str, config);
        }
    }

    public c() {
        f44325b = new LruCache<>(10);
    }
}
