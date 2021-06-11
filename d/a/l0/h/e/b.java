package d.a.l0.h.e;

import android.util.Log;
import d.a.l0.a.k;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f50983a = k.f46875a;

    /* renamed from: b  reason: collision with root package name */
    public static int f50984b = -1;

    public static a a() {
        a aVar = new a();
        aVar.f50980a = b();
        aVar.f50981b = c();
        aVar.f50982c = d();
        if (f50983a) {
            Log.d("GameCodeCacheSwitcher", "getCodeCacheConfig() maxCount: " + aVar.f50980a + " ,sizeLimit: " + aVar.f50981b);
        }
        return aVar;
    }

    public static int b() {
        if (f50984b < 0) {
            d.a.l0.a.c1.a.Z().getSwitch("minigame_code_cache_max_count", 20);
            f50984b = 20;
        }
        return f50984b;
    }

    public static int c() {
        return 102400;
    }

    public static long d() {
        return b() * 6 * 1048576;
    }
}
