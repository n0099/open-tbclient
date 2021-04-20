package d.b.g0.a.e0.w;

import android.text.TextUtils;
import android.util.Log;
import android.util.LruCache;
import d.b.g0.a.k;
/* loaded from: classes2.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f44717a = k.f45443a;

    /* renamed from: b  reason: collision with root package name */
    public static LruCache<String, Object> f44718b;

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final c f44719a = new c();
    }

    public static c b() {
        return b.f44719a;
    }

    public synchronized <CONFIG> CONFIG a(String str, CONFIG config) {
        if (TextUtils.isEmpty(str)) {
            return config;
        }
        CONFIG config2 = (CONFIG) f44718b.get(str);
        if (config2 == null) {
            return config;
        }
        if (f44717a) {
            Log.d("SwanAppConfigCache", "getConfig hit key: " + str);
        }
        return config2;
    }

    public synchronized <CONFIG> void c(String str, CONFIG config) {
        if (!TextUtils.isEmpty(str) && config != null) {
            if (f44717a) {
                Log.d("SwanAppConfigCache", "putConfig key: " + str);
            }
            f44718b.put(str, config);
        }
    }

    public c() {
        f44718b = new LruCache<>(10);
    }
}
