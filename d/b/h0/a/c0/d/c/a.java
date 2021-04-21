package d.b.h0.a.c0.d.c;

import android.os.Environment;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import d.b.h0.a.c0.c;
import d.b.h0.a.u0.d;
import java.io.File;
/* loaded from: classes2.dex */
public class a {
    public static d.g a(d.b.h0.a.y0.e.b bVar) {
        File file = new File(Environment.getExternalStorageDirectory() + "/" + b.d());
        d.u(file, b(), bVar);
        d.b.h0.p.d.f(file);
        d.g gVar = new d.g();
        File file2 = new File(b(), "app.json");
        SwanAppConfigData c2 = SwanAppConfigData.c(d.b.h0.p.d.r(file2), b());
        gVar.f47321a = b().getPath() + File.separator;
        gVar.f47322b = c2;
        c.h("ADBDebugBundleHelper", "configFile path: " + file2.getPath() + " exist: " + file2.exists() + " info.mAppBundlePath path: " + gVar.f47321a);
        return gVar;
    }

    public static File b() {
        File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_adb_debug");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }
}
