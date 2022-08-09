package com.repackage;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.live.interfaces.defaultimpl.service.LivePreStartPlayServiceImpl;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.repackage.wl2;
/* loaded from: classes7.dex */
public class wt3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, String str2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{str, str2, Long.valueOf(j)}) == null) {
            vt3 vt3Var = new vt3();
            vt3Var.b = str;
            vt3Var.e = str2;
            if (z03.M() != null && z03.M().Y() != null) {
                wl2.a Y = z03.M().Y();
                vt3Var.a = s73.n(Y.G());
                vt3Var.f = Y.H();
                vt3Var.c = Y.T();
                vt3Var.a("play_time", Long.valueOf(j));
            }
            s73.y("916", "68", vt3Var);
        }
    }

    public static void b(String str, String str2) {
        String str3;
        wl2.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, str2) == null) {
            if (z03.M() == null || z03.M().Y() == null) {
                str3 = "";
                aVar = null;
            } else {
                aVar = z03.M().Y();
                str3 = s73.n(aVar.G());
            }
            if (aVar == null || !TextUtils.equals(str3, SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME)) {
                return;
            }
            vt3 vt3Var = new vt3();
            vt3Var.b = str;
            vt3Var.e = str2;
            vt3Var.a = str3;
            vt3Var.f = aVar.H();
            vt3Var.c = aVar.T();
            s73.y("916", "68", vt3Var);
        }
    }

    public static void c(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, str, str2, str3) == null) {
            vt3 vt3Var = new vt3();
            vt3Var.b = str;
            vt3Var.e = str2;
            if (z03.M() != null && z03.M().Y() != null) {
                wl2.a Y = z03.M().Y();
                vt3Var.a = s73.n(Y.G());
                vt3Var.f = Y.H();
                vt3Var.c = Y.T();
            }
            vt3Var.k = str3;
            s73.y("916", "68", vt3Var);
        }
    }

    public static void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            vt3 vt3Var = new vt3();
            vt3Var.b = str;
            vt3Var.e = "show";
            if (z03.M() != null && z03.M().Y() != null) {
                wl2.a Y = z03.M().Y();
                vt3Var.a = s73.n(Y.G());
                vt3Var.f = Y.H();
                vt3Var.c = Y.T();
            }
            vt3Var.a("early", e() ? "0" : "1");
            s73.y("916", "68", vt3Var);
        }
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? v14.c() > 0 && ix3.c() && System.currentTimeMillis() - v14.c() > LivePreStartPlayServiceImpl.PLAYER_TIME_OUT_DURATION : invokeV.booleanValue;
    }
}
