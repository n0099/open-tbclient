package d.b.h0.d.h;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.swan.facade.init.SwanAppInitHelper;
import d.b.h0.a.q1.b.f.d;
/* loaded from: classes3.dex */
public class b {
    public static void a(String str) {
        if (!SwanAppInitHelper.entranceOK()) {
            Log.w("SwanAppLaunchHelper", "entrance not open");
            d.f(AppRuntime.getAppContext(), "not support for this android version").C();
        } else if (TextUtils.isEmpty(str)) {
            d.f(AppRuntime.getAppContext(), "url is empty").C();
        } else if (str.startsWith(SchemeConfig.getSchemeHead())) {
            b(str);
        } else if (str.startsWith("bdswan")) {
            b(str.replace("bdswan", SchemeConfig.getSchemeHead()));
        } else if (!str.startsWith("https") && !str.startsWith("http")) {
            d.f(AppRuntime.getAppContext(), "not support this uri").C();
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
