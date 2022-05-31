package com.repackage;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.v8.NodeJS;
import com.repackage.e34;
/* loaded from: classes6.dex */
public class h34 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755699192, "Lcom/repackage/h34;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755699192, "Lcom/repackage/h34;");
                return;
            }
        }
        a = rf1.a;
    }

    public static void a(@NonNull hz2 hz2Var, @NonNull e34.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, hz2Var, eVar) == null) {
            long l = hz2Var.V().l("launch_time", 0L);
            if (l <= 0) {
                if (a) {
                    Log.d("GameWebViewStatistic", "doH5GameLoadingFinishStats: launchTime is invalid.");
                    return;
                }
                return;
            }
            j63 j63Var = new j63();
            j63Var.a = a63.n(hz2Var.V().G());
            j63Var.f = hz2Var.getAppId();
            j63Var.c = hz2Var.V().T();
            j63Var.b = NodeJS.STARTUP_SCRIPT_NAME;
            j63Var.g = eVar.a;
            j63Var.e = eVar.b;
            j63Var.a("na_start", Long.valueOf(l));
            j63Var.a("h5_start", Long.valueOf(eVar.c));
            j63Var.a("h5_finish", Long.valueOf(eVar.d));
            a63.x("1235", j63Var);
        }
    }
}
