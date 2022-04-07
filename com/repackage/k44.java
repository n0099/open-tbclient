package com.repackage;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.v8.NodeJS;
import com.repackage.h44;
/* loaded from: classes6.dex */
public class k44 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755608858, "Lcom/repackage/k44;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755608858, "Lcom/repackage/k44;");
                return;
            }
        }
        a = tg1.a;
    }

    public static void a(@NonNull j03 j03Var, @NonNull h44.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, j03Var, eVar) == null) {
            long l = j03Var.V().l("launch_time", 0L);
            if (l <= 0) {
                if (a) {
                    Log.d("GameWebViewStatistic", "doH5GameLoadingFinishStats: launchTime is invalid.");
                    return;
                }
                return;
            }
            l73 l73Var = new l73();
            l73Var.a = c73.n(j03Var.V().G());
            l73Var.f = j03Var.getAppId();
            l73Var.c = j03Var.V().T();
            l73Var.b = NodeJS.STARTUP_SCRIPT_NAME;
            l73Var.g = eVar.a;
            l73Var.e = eVar.b;
            l73Var.a("na_start", Long.valueOf(l));
            l73Var.a("h5_start", Long.valueOf(eVar.c));
            l73Var.a("h5_finish", Long.valueOf(eVar.d));
            c73.x("1235", l73Var);
        }
    }
}
