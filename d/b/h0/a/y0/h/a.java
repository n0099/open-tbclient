package d.b.h0.a.y0.h;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.pms.model.PMSAppInfo;
import d.b.h0.a.e0.p.e;
import d.b.h0.a.i2.i0;
import d.b.h0.a.k;
import d.b.h0.a.u0.d;
import d.b.h0.g.q.a;
import d.b.h0.l.l.k.c;
import java.io.File;
import java.util.List;
import java.util.Locale;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f47845a = k.f45772a;

    /* renamed from: d.b.h0.a.y0.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0919a extends e {
        public C0919a(String str) {
            super(str);
        }

        @Override // d.b.h0.l.h.g, d.b.h0.l.h.d
        public void k(String str, String str2) {
            List<UbcFlowEvent> list;
            super.k(str, str2);
            if (TextUtils.isEmpty(str2) || !TextUtils.equals(str, "770") || (list = this.s) == null) {
                return;
            }
            list.add(new UbcFlowEvent(str2));
        }
    }

    public static void a(@NonNull Bundle bundle) {
        if (f47845a) {
            Log.i("SwanAppLaunchUtils", "asyncUpdatePkg: swanAsyncUpdate -> 异步更新小程序包 开始");
        }
        String string = bundle.getString("mAppId");
        if (TextUtils.isEmpty(string)) {
            return;
        }
        int i = bundle.getInt("appFrameType");
        if (1 != i) {
            i = 0;
        }
        c cVar = new c(string, i);
        if (bundle.containsKey("pms_update_expect_pkg_ver")) {
            cVar.n(bundle.getInt("pms_update_expect_pkg_ver"));
        }
        if (f47845a) {
            Log.i("SwanAppLaunchUtils", String.format(Locale.getDefault(), "asyncUpdatePkg: swanAsyncUpdate -> 异步更新 appid=%s frameType=%d expectVer=%d", string, Integer.valueOf(i), Integer.valueOf(cVar.h())));
        }
        cVar.d("4");
        C0919a c0919a = new C0919a(string);
        c0919a.K(3);
        d.b.h0.l.c.a(cVar, c0919a);
    }

    public static boolean b(@Nullable PMSAppInfo pMSAppInfo, @Nullable Bundle bundle) {
        boolean z = false;
        if (pMSAppInfo != null && !TextUtils.isEmpty(pMSAppInfo.appId)) {
            long j = pMSAppInfo.versionCode;
            if (j == 0 || bundle == null || pMSAppInfo.appCategory == 1) {
                return false;
            }
            File h2 = d.e.h(pMSAppInfo.appId, String.valueOf(j));
            if (h2.exists()) {
                String string = bundle.getString("mPage");
                if (TextUtils.isEmpty(string)) {
                    boolean exists = new File(h2, "app.json").exists();
                    d.b.h0.a.c0.c.h("SwanAppLaunchUtils", "checkSwanAppPageDirExist app.json exists: " + exists);
                    return exists;
                }
                String e2 = i0.e(string);
                int lastIndexOf = e2.lastIndexOf(File.separator);
                if (lastIndexOf >= 0) {
                    e2 = e2.substring(0, lastIndexOf);
                }
                boolean exists2 = new File(h2, e2).exists();
                if (exists2) {
                    if (new File(h2, "app.json").exists()) {
                        return true;
                    }
                    int lastIndexOf2 = e2.lastIndexOf(File.separator);
                    while (true) {
                        if (lastIndexOf2 < 0) {
                            break;
                        }
                        e2 = e2.substring(0, lastIndexOf2);
                        if (new File(h2, e2 + File.separator + "app.json").exists()) {
                            z = true;
                            break;
                        }
                        lastIndexOf2 = e2.lastIndexOf(File.separator);
                    }
                    if (f47845a) {
                        Log.d("SwanAppLaunchUtils", "isInDependentPkg=" + z + ", pagePath=" + e2);
                    }
                    if (z && !TextUtils.isEmpty(e2)) {
                        bundle.putBoolean("swan_app_independent", true);
                        bundle.putString("swan_app_sub_root_path", e2);
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
        String e2 = i0.e(str);
        int lastIndexOf = e2.lastIndexOf(File.separator);
        while (lastIndexOf != -1) {
            e2 = e2.substring(0, lastIndexOf);
            if (d.q(pMSAppInfo.appId, String.valueOf(pMSAppInfo.versionCode), e2)) {
                return e2;
            }
            lastIndexOf = e2.lastIndexOf(File.separator);
        }
        return d.q(pMSAppInfo.appId, String.valueOf(pMSAppInfo.versionCode), e2) ? e2 : "";
    }

    public static boolean d(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return e(d.b.h0.l.i.a.h().r(str));
    }

    public static boolean e(@Nullable PMSAppInfo pMSAppInfo) {
        if (pMSAppInfo == null || TextUtils.isEmpty(pMSAppInfo.appId)) {
            return false;
        }
        long j = pMSAppInfo.versionCode;
        if (j == 0) {
            return false;
        }
        if (pMSAppInfo.appCategory == 1) {
            return a.d.h(pMSAppInfo.appId, String.valueOf(j)).exists();
        }
        return d.o(d.e.h(pMSAppInfo.appId, String.valueOf(j)));
    }

    public static boolean f(PMSAppInfo pMSAppInfo, String str) {
        if (pMSAppInfo == null || TextUtils.isEmpty(str)) {
            return false;
        }
        String e2 = i0.e(str);
        if (e2.lastIndexOf(File.separator) != -1) {
            e2 = e2.substring(0, e2.lastIndexOf(File.separator));
        }
        return d.i(pMSAppInfo.appId, String.valueOf(pMSAppInfo.versionCode), e2).exists();
    }
}
