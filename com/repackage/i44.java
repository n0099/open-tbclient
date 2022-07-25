package com.repackage;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.repackage.f44;
/* loaded from: classes6.dex */
public class i44 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755668440, "Lcom/repackage/i44;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755668440, "Lcom/repackage/i44;");
                return;
            }
        }
        a = sg1.a;
    }

    public static void a(@NonNull i03 i03Var, @NonNull f44.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, i03Var, eVar) == null) {
            long l = i03Var.W().l("launch_time", 0L);
            if (l <= 0) {
                if (a) {
                    Log.d("GameWebViewStatistic", "doH5GameLoadingFinishStats: launchTime is invalid.");
                    return;
                }
                return;
            }
            k73 k73Var = new k73();
            k73Var.a = b73.n(i03Var.W().G());
            k73Var.f = i03Var.getAppId();
            k73Var.c = i03Var.W().T();
            k73Var.b = "startup";
            k73Var.g = eVar.a;
            k73Var.e = eVar.b;
            k73Var.a("na_start", Long.valueOf(l));
            k73Var.a("h5_start", Long.valueOf(eVar.c));
            k73Var.a("h5_finish", Long.valueOf(eVar.d));
            b73.x("1235", k73Var);
        }
    }
}
