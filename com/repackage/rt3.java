package com.repackage;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.repackage.rl2;
/* loaded from: classes7.dex */
public class rt3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, String str2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{str, str2, Long.valueOf(j)}) == null) {
            qt3 qt3Var = new qt3();
            qt3Var.b = str;
            qt3Var.e = str2;
            if (u03.L() != null && u03.L().X() != null) {
                rl2.a X = u03.L().X();
                qt3Var.a = n73.n(X.G());
                qt3Var.f = X.H();
                qt3Var.c = X.T();
                qt3Var.a("play_time", Long.valueOf(j));
            }
            n73.y("916", "68", qt3Var);
        }
    }

    public static void b(String str, String str2) {
        String str3;
        rl2.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, str2) == null) {
            if (u03.L() == null || u03.L().X() == null) {
                str3 = "";
                aVar = null;
            } else {
                aVar = u03.L().X();
                str3 = n73.n(aVar.G());
            }
            if (aVar == null || !TextUtils.equals(str3, SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME)) {
                return;
            }
            qt3 qt3Var = new qt3();
            qt3Var.b = str;
            qt3Var.e = str2;
            qt3Var.a = str3;
            qt3Var.f = aVar.H();
            qt3Var.c = aVar.T();
            n73.y("916", "68", qt3Var);
        }
    }

    public static void c(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, str, str2, str3) == null) {
            qt3 qt3Var = new qt3();
            qt3Var.b = str;
            qt3Var.e = str2;
            if (u03.L() != null && u03.L().X() != null) {
                rl2.a X = u03.L().X();
                qt3Var.a = n73.n(X.G());
                qt3Var.f = X.H();
                qt3Var.c = X.T();
            }
            qt3Var.k = str3;
            n73.y("916", "68", qt3Var);
        }
    }

    public static void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            qt3 qt3Var = new qt3();
            qt3Var.b = str;
            qt3Var.e = "show";
            if (u03.L() != null && u03.L().X() != null) {
                rl2.a X = u03.L().X();
                qt3Var.a = n73.n(X.G());
                qt3Var.f = X.H();
                qt3Var.c = X.T();
            }
            qt3Var.a("early", e() ? "0" : "1");
            n73.y("916", "68", qt3Var);
        }
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? q14.c() > 0 && dx3.c() && System.currentTimeMillis() - q14.c() > 6000 : invokeV.booleanValue;
    }
}
