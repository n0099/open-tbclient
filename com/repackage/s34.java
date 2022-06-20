package com.repackage;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.v8.NodeJS;
import com.repackage.p34;
/* loaded from: classes7.dex */
public class s34 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755371491, "Lcom/repackage/s34;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755371491, "Lcom/repackage/s34;");
                return;
            }
        }
        a = cg1.a;
    }

    public static void a(@NonNull sz2 sz2Var, @NonNull p34.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, sz2Var, eVar) == null) {
            long l = sz2Var.W().l("launch_time", 0L);
            if (l <= 0) {
                if (a) {
                    Log.d("GameWebViewStatistic", "doH5GameLoadingFinishStats: launchTime is invalid.");
                    return;
                }
                return;
            }
            u63 u63Var = new u63();
            u63Var.a = l63.n(sz2Var.W().G());
            u63Var.f = sz2Var.getAppId();
            u63Var.c = sz2Var.W().T();
            u63Var.b = NodeJS.STARTUP_SCRIPT_NAME;
            u63Var.g = eVar.a;
            u63Var.e = eVar.b;
            u63Var.a("na_start", Long.valueOf(l));
            u63Var.a("h5_start", Long.valueOf(eVar.c));
            u63Var.a("h5_finish", Long.valueOf(eVar.d));
            l63.x("1235", u63Var);
        }
    }
}
