package d.a.i0.a.e0.f.d;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import d.a.i0.a.a1.e;
import java.io.File;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final String f41199a = "__localDebug__" + File.separator + "master.js";

    /* renamed from: b  reason: collision with root package name */
    public static final String f41200b = "__localDebug__" + File.separator + "main.js";

    /* renamed from: c  reason: collision with root package name */
    public static final String f41201c = "__localDebug__" + File.separator + "slave.js";

    public static e.g a(d.a.i0.a.f1.e.b bVar) {
        File d2 = d();
        d.e().f("unzipstart");
        d.a.i0.a.a1.e.K(b(), d2, bVar);
        d.e().f("unzipend");
        e.g gVar = new e.g();
        File file = new File(d2, "app.json");
        SwanAppConfigData b2 = d.a.i0.a.a2.n.d.b(d2.getAbsolutePath());
        gVar.f40517a = d2.getPath() + File.separator;
        gVar.f40518b = b2;
        d.a.i0.a.e0.d.h("LocalDebugBundleHelper", "configFile path: " + file.getPath() + " exist: " + file.exists() + " info.mAppBundlePath path: " + gVar.f40517a);
        return gVar;
    }

    public static File b() {
        return new File(c(), "local_debug.swan");
    }

    public static File c() {
        File file = new File(AppRuntime.getAppContext().getFilesDir(), "swan_local_debug_zip");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File d() {
        File file = new File(AppRuntime.getAppContext().getFilesDir(), "swan_local_debug");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static String e() {
        return d() + File.separator + f41199a;
    }

    public static String f() {
        return d() + File.separator + f41201c;
    }
}
