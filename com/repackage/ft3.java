package com.repackage;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.repackage.fl2;
/* loaded from: classes6.dex */
public class ft3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, String str2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{str, str2, Long.valueOf(j)}) == null) {
            et3 et3Var = new et3();
            et3Var.b = str;
            et3Var.e = str2;
            if (i03.M() != null && i03.M().Y() != null) {
                fl2.a Y = i03.M().Y();
                et3Var.a = b73.n(Y.G());
                et3Var.f = Y.H();
                et3Var.c = Y.T();
                et3Var.a("play_time", Long.valueOf(j));
            }
            b73.y("916", "68", et3Var);
        }
    }

    public static void b(String str, String str2) {
        String str3;
        fl2.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, str2) == null) {
            if (i03.M() == null || i03.M().Y() == null) {
                str3 = "";
                aVar = null;
            } else {
                aVar = i03.M().Y();
                str3 = b73.n(aVar.G());
            }
            if (aVar == null || !TextUtils.equals(str3, SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME)) {
                return;
            }
            et3 et3Var = new et3();
            et3Var.b = str;
            et3Var.e = str2;
            et3Var.a = str3;
            et3Var.f = aVar.H();
            et3Var.c = aVar.T();
            b73.y("916", "68", et3Var);
        }
    }

    public static void c(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, str, str2, str3) == null) {
            et3 et3Var = new et3();
            et3Var.b = str;
            et3Var.e = str2;
            if (i03.M() != null && i03.M().Y() != null) {
                fl2.a Y = i03.M().Y();
                et3Var.a = b73.n(Y.G());
                et3Var.f = Y.H();
                et3Var.c = Y.T();
            }
            et3Var.k = str3;
            b73.y("916", "68", et3Var);
        }
    }

    public static void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            et3 et3Var = new et3();
            et3Var.b = str;
            et3Var.e = "show";
            if (i03.M() != null && i03.M().Y() != null) {
                fl2.a Y = i03.M().Y();
                et3Var.a = b73.n(Y.G());
                et3Var.f = Y.H();
                et3Var.c = Y.T();
            }
            et3Var.a("early", e() ? "0" : "1");
            b73.y("916", "68", et3Var);
        }
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? e14.c() > 0 && rw3.c() && System.currentTimeMillis() - e14.c() > 6000 : invokeV.booleanValue;
    }
}
