package d.a.l0.a.h0.n.a;

import android.text.TextUtils;
import d.a.l0.a.a1.e;
import d.a.l0.a.e0.d;
import d.a.l0.a.g1.f;
import d.a.l0.a.k;
import d.a.l0.a.v2.o0;
import java.io.File;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static int f46096a;

    static {
        boolean z = k.f46875a;
        f46096a = -1;
    }

    public static int a() {
        if (f46096a < 0) {
            d.a.l0.a.c1.a.Z().getSwitch("swan_app_precreate_video_switch", 0);
            f46096a = 0;
        }
        d.g("PreCreateVideoHelper", "getCacheVideoSwitch:" + f46096a);
        return f46096a;
    }

    public static boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            str = f.V().f();
        }
        String f2 = o0.f(str);
        boolean z = f.V().d(f2, f.V().s(), e.C0617e.i(d.a.l0.a.a2.d.g().getAppId(), d.a.l0.a.a2.d.g().r().L().u1()).getPath() + File.separator).o;
        d.g("PreCreateVideoHelper", "hasVideoInPage path : " + f2 + " has video :" + z);
        return z;
    }

    public static boolean c() {
        boolean z = (a() > 0) && b(d.a.l0.a.a2.d.g().r().L().e0());
        d.g("PreCreateVideoHelper", "isEnableVideoCache: hasVideoInCurPage " + z);
        return z;
    }
}
