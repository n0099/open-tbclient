package d.a.i0.a.h0.n.a;

import android.text.TextUtils;
import d.a.i0.a.a1.e;
import d.a.i0.a.e0.d;
import d.a.i0.a.g1.f;
import d.a.i0.a.k;
import d.a.i0.a.v2.o0;
import java.io.File;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static int f42246a;

    static {
        boolean z = k.f43025a;
        f42246a = -1;
    }

    public static int a() {
        if (f42246a < 0) {
            d.a.i0.a.c1.a.Z().getSwitch("swan_app_precreate_video_switch", 0);
            f42246a = 0;
        }
        d.g("PreCreateVideoHelper", "getCacheVideoSwitch:" + f42246a);
        return f42246a;
    }

    public static boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            str = f.V().f();
        }
        String f2 = o0.f(str);
        boolean z = f.V().d(f2, f.V().s(), e.C0550e.i(d.a.i0.a.a2.d.g().getAppId(), d.a.i0.a.a2.d.g().r().L().u1()).getPath() + File.separator).o;
        d.g("PreCreateVideoHelper", "hasVideoInPage path : " + f2 + " has video :" + z);
        return z;
    }

    public static boolean c() {
        boolean z = (a() > 0) && b(d.a.i0.a.a2.d.g().r().L().e0());
        d.g("PreCreateVideoHelper", "isEnableVideoCache: hasVideoInCurPage " + z);
        return z;
    }
}
