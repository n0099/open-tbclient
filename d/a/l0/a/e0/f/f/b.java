package d.a.l0.a.e0.f.f;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import d.a.l0.a.a1.e;
import java.io.File;
/* loaded from: classes2.dex */
public class b {
    public static e.g a(d.a.l0.a.f1.e.b bVar) {
        File e2 = e();
        e.K(b(), e2, bVar);
        e.g gVar = new e.g();
        File file = new File(e2, "app.json");
        SwanAppConfigData b2 = d.a.l0.a.a2.n.d.b(e2.getAbsolutePath());
        gVar.f40691a = e2.getPath() + File.separator;
        gVar.f40692b = b2;
        d.a.l0.a.e0.d.h("WirelessDebugBundleHelper", "configFile path: " + file.getPath() + " exist: " + file.exists() + " info.mAppBundlePath path: " + gVar.f40691a);
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

    public static String d() {
        return AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_wireless_debug_zip";
    }

    public static File e() {
        File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_wireless_debug");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static String f() {
        return AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_wireless_debug";
    }
}
