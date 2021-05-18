package d.a.i0.a.f1.h;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.pms.model.PMSAppInfo;
import d.a.i0.a.a1.e;
import d.a.i0.a.e0.d;
import d.a.i0.a.h0.m.e;
import d.a.i0.a.k;
import d.a.i0.a.v2.o0;
import d.a.i0.n.i.m.c;
import java.io.File;
import java.util.List;
import java.util.Locale;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f41695a = k.f43025a;

    /* renamed from: d.a.i0.a.f1.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0625a implements d.a.i0.a.v2.e1.b<PMSAppInfo> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(PMSAppInfo pMSAppInfo) {
            if (pMSAppInfo == null || !pMSAppInfo.l()) {
                return;
            }
            d.a.i0.a.c2.f.g0.a.h(pMSAppInfo.appKey, pMSAppInfo.appStatus);
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends e {
        public b(String str) {
            super(str);
        }

        @Override // d.a.i0.n.f.g, d.a.i0.n.f.d
        public void n(String str, String str2) {
            List<UbcFlowEvent> list;
            super.n(str, str2);
            if (TextUtils.isEmpty(str2) || !TextUtils.equals(str, "770") || (list = this.s) == null) {
                return;
            }
            list.add(new UbcFlowEvent(str2));
        }
    }

    public static void a(@NonNull Bundle bundle) {
        if (f41695a) {
            Log.i("SwanAppLaunchUtils", "asyncUpdatePkg: swanAsyncUpdate -> 异步更新小程序包 开始");
        }
        String string = bundle.getString("mAppId");
        if (TextUtils.isEmpty(string)) {
            return;
        }
        int i2 = bundle.getInt("appFrameType");
        if (1 != i2) {
            i2 = 0;
        }
        c cVar = new c(string, i2);
        if (bundle.containsKey("pms_update_expect_pkg_ver")) {
            cVar.o(bundle.getLong("pms_update_expect_pkg_ver"));
        }
        if (f41695a) {
            Log.i("SwanAppLaunchUtils", String.format(Locale.getDefault(), "asyncUpdatePkg: swanAsyncUpdate -> 异步更新 appid=%s frameType=%d expectVer=%d", string, Integer.valueOf(i2), Long.valueOf(cVar.h())));
        }
        cVar.d("4");
        b bVar = new b(string);
        bVar.b0(new C0625a());
        bVar.K(3);
        d.a.i0.n.b.b(cVar, bVar);
    }

    public static boolean b(@Nullable PMSAppInfo pMSAppInfo, @Nullable Bundle bundle) {
        boolean z = false;
        if (pMSAppInfo != null && !TextUtils.isEmpty(pMSAppInfo.appId)) {
            long j = pMSAppInfo.versionCode;
            if (j == 0 || bundle == null || pMSAppInfo.appCategory == 1) {
                return false;
            }
            File i2 = e.C0550e.i(pMSAppInfo.appId, String.valueOf(j));
            if (i2.exists()) {
                String string = bundle.getString("mPage");
                if (TextUtils.isEmpty(string)) {
                    boolean exists = new File(i2, "app.json").exists();
                    d.h("SwanAppLaunchUtils", "checkSwanAppPageDirExist app.json exists: " + exists);
                    return exists;
                }
                String g2 = o0.g(string);
                int lastIndexOf = g2.lastIndexOf(File.separator);
                if (lastIndexOf >= 0) {
                    g2 = g2.substring(0, lastIndexOf);
                }
                boolean exists2 = new File(i2, g2).exists();
                if (exists2) {
                    if (new File(i2, "app.json").exists()) {
                        return System.currentTimeMillis() - new File(i2, g2).lastModified() > 1800000;
                    }
                    int lastIndexOf2 = g2.lastIndexOf(File.separator);
                    while (true) {
                        if (lastIndexOf2 < 0) {
                            break;
                        }
                        g2 = g2.substring(0, lastIndexOf2);
                        if (new File(i2, g2 + File.separator + "app.json").exists()) {
                            z = true;
                            break;
                        }
                        lastIndexOf2 = g2.lastIndexOf(File.separator);
                    }
                    if (f41695a) {
                        Log.d("SwanAppLaunchUtils", "isInDependentPkg=" + z + ", pagePath=" + g2);
                    }
                    if (z && !TextUtils.isEmpty(g2)) {
                        bundle.putBoolean("swan_app_independent", true);
                        bundle.putString("swan_app_sub_root_path", g2);
                    }
                }
                return exists2;
            }
            return false;
        }
        return false;
    }

    public static String c(PMSAppInfo pMSAppInfo, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String g2 = o0.g(str);
        int lastIndexOf = g2.lastIndexOf(File.separator);
        while (lastIndexOf != -1) {
            g2 = g2.substring(0, lastIndexOf);
            if (d.a.i0.a.a1.e.B(pMSAppInfo.appId, String.valueOf(pMSAppInfo.versionCode), g2)) {
                return g2;
            }
            lastIndexOf = g2.lastIndexOf(File.separator);
        }
        return d.a.i0.a.a1.e.B(pMSAppInfo.appId, String.valueOf(pMSAppInfo.versionCode), g2) ? g2 : "";
    }

    public static boolean d(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return e(d.a.i0.n.g.a.h().s(str));
    }

    public static boolean e(@Nullable PMSAppInfo pMSAppInfo) {
        if (pMSAppInfo != null && !TextUtils.isEmpty(pMSAppInfo.appId)) {
            long j = pMSAppInfo.versionCode;
            if (j != 0) {
                if (pMSAppInfo.appCategory == 1) {
                    File a2 = d.a.i0.a.c1.b.g().a(pMSAppInfo.appId, String.valueOf(pMSAppInfo.versionCode));
                    if (a2 != null) {
                        return a2.exists();
                    }
                    return false;
                }
                return d.a.i0.a.a1.e.z(e.C0550e.i(pMSAppInfo.appId, String.valueOf(j)));
            }
        }
        return false;
    }

    public static boolean f(PMSAppInfo pMSAppInfo, String str) {
        if (pMSAppInfo == null || TextUtils.isEmpty(str)) {
            return false;
        }
        String g2 = o0.g(str);
        if (g2.lastIndexOf(File.separator) != -1) {
            g2 = g2.substring(0, g2.lastIndexOf(File.separator));
        }
        return d.a.i0.a.a1.e.p(pMSAppInfo.appId, String.valueOf(pMSAppInfo.versionCode), g2).exists();
    }
}
