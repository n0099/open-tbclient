package com.repackage;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.v8.NodeJS;
import com.repackage.r44;
/* loaded from: classes7.dex */
public class u44 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755310948, "Lcom/repackage/u44;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755310948, "Lcom/repackage/u44;");
                return;
            }
        }
        a = eh1.a;
    }

    public static void a(@NonNull u03 u03Var, @NonNull r44.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, u03Var, eVar) == null) {
            long l = u03Var.V().l("launch_time", 0L);
            if (l <= 0) {
                if (a) {
                    Log.d("GameWebViewStatistic", "doH5GameLoadingFinishStats: launchTime is invalid.");
                    return;
                }
                return;
            }
            w73 w73Var = new w73();
            w73Var.a = n73.n(u03Var.V().G());
            w73Var.f = u03Var.getAppId();
            w73Var.c = u03Var.V().T();
            w73Var.b = NodeJS.STARTUP_SCRIPT_NAME;
            w73Var.g = eVar.a;
            w73Var.e = eVar.b;
            w73Var.a("na_start", Long.valueOf(l));
            w73Var.a("h5_start", Long.valueOf(eVar.c));
            w73Var.a("h5_finish", Long.valueOf(eVar.d));
            n73.x("1235", w73Var);
        }
    }
}
