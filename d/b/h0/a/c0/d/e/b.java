package d.b.h0.a.c0.d.e;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import d.b.h0.a.u0.d;
import java.io.File;
/* loaded from: classes2.dex */
public class b {
    public static d.g a(d.b.h0.a.y0.e.b bVar) {
        File d2 = d();
        d.b.h0.a.u0.d.u(b(), d2, bVar);
        d.g gVar = new d.g();
        File file = new File(d2, "app.json");
        SwanAppConfigData c2 = SwanAppConfigData.c(d.b.h0.p.d.r(file), d2);
        gVar.f47321a = d2.getPath() + File.separator;
        gVar.f47322b = c2;
        d.b.h0.a.c0.c.h("WirelessDebugBundleHelper", "configFile path: " + file.getPath() + " exist: " + file.exists() + " info.mAppBundlePath path: " + gVar.f47321a);
        return gVar;
    }

    public static File b() {
        return new File(c(), "wireless_debug.aiapps");
    }

    public static File c() {
        File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_wireless_debug_zip");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File d() {
        File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_wireless_debug");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }
}
