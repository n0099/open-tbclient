package d.a.m0.e.l;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.swan.facade.init.SwanAppInitHelper;
import d.a.m0.a.z1.b.f.e;
/* loaded from: classes3.dex */
public class b {
    public static void a(String str) {
        if (!SwanAppInitHelper.entranceOK()) {
            Log.w("SwanAppLaunchHelper", "entrance not open");
            e.g(AppRuntime.getAppContext(), "not support for this android version").F();
        } else if (TextUtils.isEmpty(str)) {
            e.g(AppRuntime.getAppContext(), "url is empty").F();
        } else if (str.startsWith(SchemeConfig.getSchemeHead())) {
            b(str);
        } else if (str.startsWith("bdswan")) {
            b(str.replace("bdswan", SchemeConfig.getSchemeHead()));
        } else if (!str.startsWith("https") && !str.startsWith("http")) {
            e.g(AppRuntime.getAppContext(), "not support this uri").F();
        } else {
            c(str);
        }
    }

    public static void b(String str) {
        SchemeRouter.invokeSchemeForInner(AppRuntime.getAppContext(), Uri.parse(str));
    }

    public static void c(String str) {
        a.e(str);
    }
}
