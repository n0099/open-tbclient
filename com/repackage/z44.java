package com.repackage;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.repackage.w44;
/* loaded from: classes7.dex */
public class z44 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755161993, "Lcom/repackage/z44;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755161993, "Lcom/repackage/z44;");
                return;
            }
        }
        a = jh1.a;
    }

    public static void a(@NonNull z03 z03Var, @NonNull w44.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, z03Var, eVar) == null) {
            long l = z03Var.W().l("launch_time", 0L);
            if (l <= 0) {
                if (a) {
                    Log.d("GameWebViewStatistic", "doH5GameLoadingFinishStats: launchTime is invalid.");
                    return;
                }
                return;
            }
            b83 b83Var = new b83();
            b83Var.a = s73.n(z03Var.W().G());
            b83Var.f = z03Var.getAppId();
            b83Var.c = z03Var.W().T();
            b83Var.b = "startup";
            b83Var.g = eVar.a;
            b83Var.e = eVar.b;
            b83Var.a("na_start", Long.valueOf(l));
            b83Var.a("h5_start", Long.valueOf(eVar.c));
            b83Var.a("h5_finish", Long.valueOf(eVar.d));
            s73.x("1235", b83Var);
        }
    }
}
