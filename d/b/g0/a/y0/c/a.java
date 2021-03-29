package d.b.g0.a.y0.c;

import android.util.Log;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import d.b.g0.a.i2.f0;
import d.b.g0.a.j1.m.c;
import d.b.g0.a.u0.d;
import java.io.File;
import java.util.List;
/* loaded from: classes2.dex */
public class a implements d.b.g0.a.y0.f.a {
    public static SwanAppConfigData a(File file) {
        if (file == null || !file.exists()) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        SwanAppConfigData c2 = SwanAppConfigData.c(d.h(new File(file, "app.json")), file);
        if (d.b.g0.a.y0.f.a.f47107a) {
            long currentTimeMillis2 = System.currentTimeMillis();
            Log.d("SwanPreProcess", "buildAppJsonConfig cost = " + (currentTimeMillis2 - currentTimeMillis) + "ms ; current thread = " + Thread.currentThread().getId());
        }
        return c2;
    }

    public static SwanAppConfigData b(File file) {
        if (file == null || !file.exists()) {
            return null;
        }
        if (c.d()) {
            SwanAppConfigData swanAppConfigData = (SwanAppConfigData) b.c().b(file.getAbsolutePath());
            if (swanAppConfigData == null) {
                SwanAppConfigData a2 = a(file);
                b.c().d(file.getAbsolutePath(), a2);
                return a2;
            }
            if (d.b.g0.a.y0.f.a.f47107a) {
                Log.d("SwanPreProcess", "adopt cached app.json");
            }
            return swanAppConfigData;
        }
        return a(file);
    }

    public static Boolean c(boolean z) {
        Boolean bool = (Boolean) b.c().b("getNightModeStateCache");
        if (bool == null) {
            return Boolean.valueOf(d.b.g0.a.w0.a.z().a());
        }
        if (z) {
            b.c().e("getNightModeStateCache");
        }
        return bool;
    }

    public static List<f0.a> d() {
        List<f0.a> list = (List) b.c().b("getStorageListCache");
        if (list == null) {
            List<f0.a> c2 = f0.c();
            b.c().d("getStorageListCache", c2);
            return c2;
        }
        return list;
    }

    public static void e(Boolean bool) {
        b.c().d("getNightModeStateCache", bool);
    }
}
