package d.a.l0.a.e0.f.c;

import android.os.Environment;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import d.a.l0.a.a1.e;
import d.a.l0.t.d;
import java.io.File;
/* loaded from: classes2.dex */
public class a {
    public static e.g a(d.a.l0.a.f1.e.b bVar) {
        File file = new File(Environment.getExternalStorageDirectory() + "/" + b.d());
        e.K(file, b(), bVar);
        d.i(file);
        e.g gVar = new e.g();
        File file2 = new File(b(), "app.json");
        SwanAppConfigData c2 = SwanAppConfigData.c(d.D(file2), b());
        gVar.f44367a = b().getPath() + File.separator;
        gVar.f44368b = c2;
        d.a.l0.a.e0.d.h("ADBDebugBundleHelper", "configFile path: " + file2.getPath() + " exist: " + file2.exists() + " info.mAppBundlePath path: " + gVar.f44367a);
        return gVar;
    }

    public static File b() {
        File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_adb_debug");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static String c() {
        return AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_adb_debug";
    }
}
