package com.repackage;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.repackage.pk2;
/* loaded from: classes6.dex */
public class ps3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, String str2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{str, str2, Long.valueOf(j)}) == null) {
            os3 os3Var = new os3();
            os3Var.b = str;
            os3Var.e = str2;
            if (sz2.M() != null && sz2.M().Y() != null) {
                pk2.a Y = sz2.M().Y();
                os3Var.a = l63.n(Y.G());
                os3Var.f = Y.H();
                os3Var.c = Y.T();
                os3Var.a("play_time", Long.valueOf(j));
            }
            l63.y("916", "68", os3Var);
        }
    }

    public static void b(String str, String str2) {
        String str3;
        pk2.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, str2) == null) {
            if (sz2.M() == null || sz2.M().Y() == null) {
                str3 = "";
                aVar = null;
            } else {
                aVar = sz2.M().Y();
                str3 = l63.n(aVar.G());
            }
            if (aVar == null || !TextUtils.equals(str3, SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME)) {
                return;
            }
            os3 os3Var = new os3();
            os3Var.b = str;
            os3Var.e = str2;
            os3Var.a = str3;
            os3Var.f = aVar.H();
            os3Var.c = aVar.T();
            l63.y("916", "68", os3Var);
        }
    }

    public static void c(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, str, str2, str3) == null) {
            os3 os3Var = new os3();
            os3Var.b = str;
            os3Var.e = str2;
            if (sz2.M() != null && sz2.M().Y() != null) {
                pk2.a Y = sz2.M().Y();
                os3Var.a = l63.n(Y.G());
                os3Var.f = Y.H();
                os3Var.c = Y.T();
            }
            os3Var.k = str3;
            l63.y("916", "68", os3Var);
        }
    }

    public static void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            os3 os3Var = new os3();
            os3Var.b = str;
            os3Var.e = "show";
            if (sz2.M() != null && sz2.M().Y() != null) {
                pk2.a Y = sz2.M().Y();
                os3Var.a = l63.n(Y.G());
                os3Var.f = Y.H();
                os3Var.c = Y.T();
            }
            os3Var.a("early", e() ? "0" : "1");
            l63.y("916", "68", os3Var);
        }
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? o04.c() > 0 && bw3.c() && System.currentTimeMillis() - o04.c() > 6000 : invokeV.booleanValue;
    }
}
