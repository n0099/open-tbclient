package d.a.m0.h.e;

import android.util.Log;
import d.a.m0.a.k;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f51091a = k.f46983a;

    /* renamed from: b  reason: collision with root package name */
    public static int f51092b = -1;

    public static a a() {
        a aVar = new a();
        aVar.f51088a = b();
        aVar.f51089b = c();
        aVar.f51090c = d();
        if (f51091a) {
            Log.d("GameCodeCacheSwitcher", "getCodeCacheConfig() maxCount: " + aVar.f51088a + " ,sizeLimit: " + aVar.f51089b);
        }
        return aVar;
    }

    public static int b() {
        if (f51092b < 0) {
            d.a.m0.a.c1.a.Z().getSwitch("minigame_code_cache_max_count", 20);
            f51092b = 20;
        }
        return f51092b;
    }

    public static int c() {
        return 102400;
    }

    public static long d() {
        return b() * 6 * 1048576;
    }
}
