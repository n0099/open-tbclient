package d.a.n0.e.l;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.swan.facade.init.SwanAppInitHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.n0.a.z1.b.f.e;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, str) == null) {
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
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            SchemeRouter.invokeSchemeForInner(AppRuntime.getAppContext(), Uri.parse(str));
        }
    }

    public static void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            a.e(str);
        }
    }
}
