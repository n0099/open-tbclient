package d.a.i0.a.f1.c;

import android.os.Looper;
import android.util.Log;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import d.a.i0.a.a2.n.d;
import d.a.i0.a.v2.k0;
import java.io.File;
import java.util.List;
/* loaded from: classes3.dex */
public class a implements d.a.i0.a.f1.f.a {
    public static SwanAppConfigData a(File file) {
        if (file == null || !file.exists()) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        SwanAppConfigData b2 = d.b(file.getAbsolutePath());
        if (d.a.i0.a.f1.f.a.f41678a) {
            long currentTimeMillis2 = System.currentTimeMillis();
            StringBuilder sb = new StringBuilder();
            sb.append("buildAppJsonConfig cost = ");
            sb.append(currentTimeMillis2 - currentTimeMillis);
            sb.append("ms ; current thread is main = ");
            sb.append(Looper.getMainLooper() == Looper.myLooper());
            sb.append(" ; path = ");
            sb.append(file);
            Log.d("SwanPerformance", sb.toString());
        }
        return b2;
    }

    public static SwanAppConfigData b(File file) {
        if (file == null || !file.exists()) {
            return null;
        }
        SwanAppConfigData swanAppConfigData = (SwanAppConfigData) b.c().b(file.getAbsolutePath());
        if (swanAppConfigData == null) {
            swanAppConfigData = d.a.i0.a.r1.l.f.a.e().j(file);
            if (swanAppConfigData == null) {
                swanAppConfigData = a(file);
            }
            b.c().d(file.getAbsolutePath(), swanAppConfigData);
        } else if (d.a.i0.a.f1.f.a.f41678a) {
            Log.d("SwanPerformance", "adopt cached app.json");
        }
        return swanAppConfigData;
    }

    public static Boolean c(boolean z) {
        Boolean bool = (Boolean) b.c().b("getNightModeStateCache");
        if (bool == null) {
            return Boolean.valueOf(d.a.i0.a.c1.a.H().a());
        }
        if (z) {
            b.c().e("getNightModeStateCache");
        }
        return bool;
    }

    public static List<k0.a> d() {
        List<k0.a> list = (List) b.c().b("getStorageListCache");
        if (list == null) {
            List<k0.a> d2 = k0.d();
            b.c().d("getStorageListCache", d2);
            return d2;
        }
        return list;
    }

    public static void e(Boolean bool) {
        b.c().d("getNightModeStateCache", bool);
    }
}
