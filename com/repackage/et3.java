package com.repackage;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.repackage.el2;
/* loaded from: classes6.dex */
public class et3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, String str2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{str, str2, Long.valueOf(j)}) == null) {
            dt3 dt3Var = new dt3();
            dt3Var.b = str;
            dt3Var.e = str2;
            if (h03.M() != null && h03.M().Y() != null) {
                el2.a Y = h03.M().Y();
                dt3Var.a = a73.n(Y.G());
                dt3Var.f = Y.H();
                dt3Var.c = Y.T();
                dt3Var.a("play_time", Long.valueOf(j));
            }
            a73.y("916", "68", dt3Var);
        }
    }

    public static void b(String str, String str2) {
        String str3;
        el2.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, str2) == null) {
            if (h03.M() == null || h03.M().Y() == null) {
                str3 = "";
                aVar = null;
            } else {
                aVar = h03.M().Y();
                str3 = a73.n(aVar.G());
            }
            if (aVar == null || !TextUtils.equals(str3, SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME)) {
                return;
            }
            dt3 dt3Var = new dt3();
            dt3Var.b = str;
            dt3Var.e = str2;
            dt3Var.a = str3;
            dt3Var.f = aVar.H();
            dt3Var.c = aVar.T();
            a73.y("916", "68", dt3Var);
        }
    }

    public static void c(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, str, str2, str3) == null) {
            dt3 dt3Var = new dt3();
            dt3Var.b = str;
            dt3Var.e = str2;
            if (h03.M() != null && h03.M().Y() != null) {
                el2.a Y = h03.M().Y();
                dt3Var.a = a73.n(Y.G());
                dt3Var.f = Y.H();
                dt3Var.c = Y.T();
            }
            dt3Var.k = str3;
            a73.y("916", "68", dt3Var);
        }
    }

    public static void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            dt3 dt3Var = new dt3();
            dt3Var.b = str;
            dt3Var.e = "show";
            if (h03.M() != null && h03.M().Y() != null) {
                el2.a Y = h03.M().Y();
                dt3Var.a = a73.n(Y.G());
                dt3Var.f = Y.H();
                dt3Var.c = Y.T();
            }
            dt3Var.a("early", e() ? "0" : "1");
            a73.y("916", "68", dt3Var);
        }
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? d14.c() > 0 && qw3.c() && System.currentTimeMillis() - d14.c() > 6000 : invokeV.booleanValue;
    }
}
