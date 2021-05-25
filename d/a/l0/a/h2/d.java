package d.a.l0.a.h2;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.so.SoLoader;
/* loaded from: classes3.dex */
public final class d {
    public static String a() {
        return d.a.l0.a.c1.a.X().c();
    }

    public static boolean b() {
        return SoLoader.load(AppRuntime.getAppContext(), "audioengine");
    }

    public static f c() {
        if (!d.a.l0.a.c1.a.n0().d()) {
            return d.a.l0.a.h0.s.a.c(false);
        }
        return SoLoader.loadV8EngineSo(AppRuntime.getAppContext());
    }
}
