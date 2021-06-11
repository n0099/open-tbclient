package d.a.l0.a.h0.u;

import android.text.TextUtils;
import android.util.Log;
import android.util.LruCache;
import d.a.l0.a.k;
/* loaded from: classes3.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f46300a = k.f46875a;

    /* renamed from: b  reason: collision with root package name */
    public static LruCache<String, Object> f46301b;

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final f f46302a = new f();
    }

    public static f b() {
        return b.f46302a;
    }

    public synchronized <CONFIG> CONFIG a(String str, CONFIG config) {
        if (TextUtils.isEmpty(str)) {
            return config;
        }
        CONFIG config2 = (CONFIG) f46301b.get(str);
        if (config2 == null) {
            return config;
        }
        if (f46300a) {
            Log.d("SwanAppConfigCache", "getConfig hit key: " + str);
        }
        return config2;
    }

    public synchronized <CONFIG> void c(String str, CONFIG config) {
        if (!TextUtils.isEmpty(str) && config != null) {
            if (f46300a) {
                Log.d("SwanAppConfigCache", "putConfig key: " + str);
            }
            f46301b.put(str, config);
        }
    }

    public f() {
        f46301b = new LruCache<>(10);
    }
}
