package com.repackage;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.repackage.ek2;
/* loaded from: classes5.dex */
public class es3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, String str2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{str, str2, Long.valueOf(j)}) == null) {
            ds3 ds3Var = new ds3();
            ds3Var.b = str;
            ds3Var.e = str2;
            if (hz2.L() != null && hz2.L().X() != null) {
                ek2.a X = hz2.L().X();
                ds3Var.a = a63.n(X.G());
                ds3Var.f = X.H();
                ds3Var.c = X.T();
                ds3Var.a("play_time", Long.valueOf(j));
            }
            a63.y("916", "68", ds3Var);
        }
    }

    public static void b(String str, String str2) {
        String str3;
        ek2.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, str2) == null) {
            if (hz2.L() == null || hz2.L().X() == null) {
                str3 = "";
                aVar = null;
            } else {
                aVar = hz2.L().X();
                str3 = a63.n(aVar.G());
            }
            if (aVar == null || !TextUtils.equals(str3, SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME)) {
                return;
            }
            ds3 ds3Var = new ds3();
            ds3Var.b = str;
            ds3Var.e = str2;
            ds3Var.a = str3;
            ds3Var.f = aVar.H();
            ds3Var.c = aVar.T();
            a63.y("916", "68", ds3Var);
        }
    }

    public static void c(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, str, str2, str3) == null) {
            ds3 ds3Var = new ds3();
            ds3Var.b = str;
            ds3Var.e = str2;
            if (hz2.L() != null && hz2.L().X() != null) {
                ek2.a X = hz2.L().X();
                ds3Var.a = a63.n(X.G());
                ds3Var.f = X.H();
                ds3Var.c = X.T();
            }
            ds3Var.k = str3;
            a63.y("916", "68", ds3Var);
        }
    }

    public static void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            ds3 ds3Var = new ds3();
            ds3Var.b = str;
            ds3Var.e = "show";
            if (hz2.L() != null && hz2.L().X() != null) {
                ek2.a X = hz2.L().X();
                ds3Var.a = a63.n(X.G());
                ds3Var.f = X.H();
                ds3Var.c = X.T();
            }
            ds3Var.a("early", e() ? "0" : "1");
            a63.y("916", "68", ds3Var);
        }
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? d04.c() > 0 && qv3.c() && System.currentTimeMillis() - d04.c() > 6000 : invokeV.booleanValue;
    }
}
