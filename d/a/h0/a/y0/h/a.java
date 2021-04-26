package d.a.h0.a.y0.h;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.pms.model.PMSAppInfo;
import d.a.h0.a.e0.p.e;
import d.a.h0.a.i2.i0;
import d.a.h0.a.k;
import d.a.h0.a.u0.d;
import d.a.h0.g.q.a;
import d.a.h0.l.l.k.c;
import java.io.File;
import java.util.List;
import java.util.Locale;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f45280a = k.f43101a;

    /* renamed from: d.a.h0.a.y0.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0858a extends e {
        public C0858a(String str) {
            super(str);
        }

        @Override // d.a.h0.l.h.g, d.a.h0.l.h.d
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
        if (f45280a) {
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
            cVar.n(bundle.getInt("pms_update_expect_pkg_ver"));
        }
        if (f45280a) {
            Log.i("SwanAppLaunchUtils", String.format(Locale.getDefault(), "asyncUpdatePkg: swanAsyncUpdate -> 异步更新 appid=%s frameType=%d expectVer=%d", string, Integer.valueOf(i2), Integer.valueOf(cVar.h())));
        }
        cVar.d("4");
        C0858a c0858a = new C0858a(string);
        c0858a.K(3);
        d.a.h0.l.c.a(cVar, c0858a);
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
                    d.a.h0.a.c0.c.h("SwanAppLaunchUtils", "checkSwanAppPageDirExist app.json exists: " + exists);
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
                    if (f45280a) {
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
        return e(d.a.h0.l.i.a.h().r(str));
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
