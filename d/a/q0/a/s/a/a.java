package d.a.q0.a.s.a;

import android.content.Context;
import android.os.Bundle;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.wallet.core.Domains;
import com.baidu.webkit.sdk.CookieManager;
import com.baidu.webkit.sdk.CookieSyncManager;
import d.a.q0.a.v2.o0;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Context context, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65536, null, context, str) == null) || context == null) {
            return;
        }
        CookieManager.getInstance().setCookie(Domains.BAIDU, o0.k(Domains.BAIDU, "OPENBDUSS", str, 31449600L));
        CookieSyncManager.createInstance(AppRuntime.getAppContext());
        CookieSyncManager.getInstance().sync();
    }

    public static void b(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, context, str) == null) {
            if (ProcessUtils.isMainProcess()) {
                a(context, str);
            } else {
                c(context, str);
            }
        }
    }

    public static void c(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, context, str) == null) {
            Bundle bundle = new Bundle();
            bundle.putString("bduss", str);
            d.a.q0.a.v1.b.d.a(b.class, bundle);
        }
    }
}
