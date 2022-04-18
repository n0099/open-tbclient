package com.repackage;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.repackage.gl2;
/* loaded from: classes6.dex */
public class gt3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, String str2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{str, str2, Long.valueOf(j)}) == null) {
            ft3 ft3Var = new ft3();
            ft3Var.b = str;
            ft3Var.e = str2;
            if (j03.L() != null && j03.L().X() != null) {
                gl2.a X = j03.L().X();
                ft3Var.a = c73.n(X.G());
                ft3Var.f = X.H();
                ft3Var.c = X.T();
                ft3Var.a("play_time", Long.valueOf(j));
            }
            c73.y("916", "68", ft3Var);
        }
    }

    public static void b(String str, String str2) {
        String str3;
        gl2.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, str2) == null) {
            if (j03.L() == null || j03.L().X() == null) {
                str3 = "";
                aVar = null;
            } else {
                aVar = j03.L().X();
                str3 = c73.n(aVar.G());
            }
            if (aVar == null || !TextUtils.equals(str3, SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME)) {
                return;
            }
            ft3 ft3Var = new ft3();
            ft3Var.b = str;
            ft3Var.e = str2;
            ft3Var.a = str3;
            ft3Var.f = aVar.H();
            ft3Var.c = aVar.T();
            c73.y("916", "68", ft3Var);
        }
    }

    public static void c(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, str, str2, str3) == null) {
            ft3 ft3Var = new ft3();
            ft3Var.b = str;
            ft3Var.e = str2;
            if (j03.L() != null && j03.L().X() != null) {
                gl2.a X = j03.L().X();
                ft3Var.a = c73.n(X.G());
                ft3Var.f = X.H();
                ft3Var.c = X.T();
            }
            ft3Var.k = str3;
            c73.y("916", "68", ft3Var);
        }
    }

    public static void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            ft3 ft3Var = new ft3();
            ft3Var.b = str;
            ft3Var.e = "show";
            if (j03.L() != null && j03.L().X() != null) {
                gl2.a X = j03.L().X();
                ft3Var.a = c73.n(X.G());
                ft3Var.f = X.H();
                ft3Var.c = X.T();
            }
            ft3Var.a("early", e() ? "0" : "1");
            c73.y("916", "68", ft3Var);
        }
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? f14.c() > 0 && sw3.c() && System.currentTimeMillis() - f14.c() > 6000 : invokeV.booleanValue;
    }
}
