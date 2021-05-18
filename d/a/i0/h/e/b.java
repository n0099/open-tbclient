package d.a.i0.h.e;

import android.util.Log;
import d.a.i0.a.k;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f47133a = k.f43025a;

    /* renamed from: b  reason: collision with root package name */
    public static int f47134b = -1;

    public static a a() {
        a aVar = new a();
        aVar.f47130a = b();
        aVar.f47131b = c();
        aVar.f47132c = d();
        if (f47133a) {
            Log.d("GameCodeCacheSwitcher", "getCodeCacheConfig() maxCount: " + aVar.f47130a + " ,sizeLimit: " + aVar.f47131b);
        }
        return aVar;
    }

    public static int b() {
        if (f47134b < 0) {
            d.a.i0.a.c1.a.Z().getSwitch("minigame_code_cache_max_count", 20);
            f47134b = 20;
        }
        return f47134b;
    }

    public static int c() {
        return 102400;
    }

    public static long d() {
        return b() * 6 * 1048576;
    }
}
