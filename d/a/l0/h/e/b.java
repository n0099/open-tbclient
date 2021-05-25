package d.a.l0.h.e;

import android.util.Log;
import d.a.l0.a.k;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f47309a = k.f43199a;

    /* renamed from: b  reason: collision with root package name */
    public static int f47310b = -1;

    public static a a() {
        a aVar = new a();
        aVar.f47306a = b();
        aVar.f47307b = c();
        aVar.f47308c = d();
        if (f47309a) {
            Log.d("GameCodeCacheSwitcher", "getCodeCacheConfig() maxCount: " + aVar.f47306a + " ,sizeLimit: " + aVar.f47307b);
        }
        return aVar;
    }

    public static int b() {
        if (f47310b < 0) {
            d.a.l0.a.c1.a.Z().getSwitch("minigame_code_cache_max_count", 20);
            f47310b = 20;
        }
        return f47310b;
    }

    public static int c() {
        return 102400;
    }

    public static long d() {
        return b() * 6 * 1048576;
    }
}
