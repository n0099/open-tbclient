package com.repackage;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.repackage.e44;
/* loaded from: classes6.dex */
public class h44 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755698231, "Lcom/repackage/h44;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755698231, "Lcom/repackage/h44;");
                return;
            }
        }
        a = rg1.a;
    }

    public static void a(@NonNull h03 h03Var, @NonNull e44.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, h03Var, eVar) == null) {
            long l = h03Var.W().l("launch_time", 0L);
            if (l <= 0) {
                if (a) {
                    Log.d("GameWebViewStatistic", "doH5GameLoadingFinishStats: launchTime is invalid.");
                    return;
                }
                return;
            }
            j73 j73Var = new j73();
            j73Var.a = a73.n(h03Var.W().G());
            j73Var.f = h03Var.getAppId();
            j73Var.c = h03Var.W().T();
            j73Var.b = "startup";
            j73Var.g = eVar.a;
            j73Var.e = eVar.b;
            j73Var.a("na_start", Long.valueOf(l));
            j73Var.a("h5_start", Long.valueOf(eVar.c));
            j73Var.a("h5_finish", Long.valueOf(eVar.d));
            a73.x("1235", j73Var);
        }
    }
}
