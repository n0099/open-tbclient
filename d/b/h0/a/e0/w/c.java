package d.b.h0.a.e0.w;

import android.text.TextUtils;
import android.util.Log;
import android.util.LruCache;
import d.b.h0.a.k;
/* loaded from: classes2.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f45046a = k.f45772a;

    /* renamed from: b  reason: collision with root package name */
    public static LruCache<String, Object> f45047b;

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final c f45048a = new c();
    }

    public static c b() {
        return b.f45048a;
    }

    public synchronized <CONFIG> CONFIG a(String str, CONFIG config) {
        if (TextUtils.isEmpty(str)) {
            return config;
        }
        CONFIG config2 = (CONFIG) f45047b.get(str);
        if (config2 == null) {
            return config;
        }
        if (f45046a) {
            Log.d("SwanAppConfigCache", "getConfig hit key: " + str);
        }
        return config2;
    }

    public synchronized <CONFIG> void c(String str, CONFIG config) {
        if (!TextUtils.isEmpty(str) && config != null) {
            if (f45046a) {
                Log.d("SwanAppConfigCache", "putConfig key: " + str);
            }
            f45047b.put(str, config);
        }
    }

    public c() {
        f45047b = new LruCache<>(10);
    }
}
