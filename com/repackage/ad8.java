package com.repackage;

import android.app.ActivityManager;
import android.os.Process;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class ad8 {
    public static /* synthetic */ Interceptable $ic;
    public static String a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755860516, "Lcom/repackage/ad8;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755860516, "Lcom/repackage/ad8;");
        }
    }

    public static void a(zc8 zc8Var, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65537, null, zc8Var, i) == null) {
            zc8Var.i(706);
            boolean z = i == 1000;
            zc8Var.c(z ? "APP" : "URL");
            if (!z) {
                zc8Var.l(i);
            }
            zc8Var.h("DEEPLINK");
        }
    }

    public static String b(HashMap hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, hashMap)) == null) {
            String valueOf = hashMap != null ? String.valueOf(hashMap.get("da_area")) : null;
            return TextUtils.isEmpty(valueOf) ? "hotarea" : valueOf;
        }
        return (String) invokeL.objValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            try {
                int myPid = Process.myPid();
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) TbadkCoreApplication.getInst().getContext().getSystemService("activity")).getRunningAppProcesses()) {
                    if (runningAppProcessInfo.pid == myPid) {
                        return runningAppProcessInfo.processName;
                    }
                }
                return "GET_PROCESS_NAME_FAIL";
            } catch (Exception unused) {
                return "GET_PROCESS_NAME_FAIL";
            }
        }
        return (String) invokeV.objValue;
    }

    public static void d(String str, String str2, int i, int i2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), str3}) == null) {
            zc8 zc8Var = new zc8();
            zc8Var.h(str);
            zc8Var.v(str2);
            zc8Var.d(i);
            zc8Var.i(i2);
            zc8Var.k(str3);
            bd8.b().d(zc8Var);
        }
    }

    public static void e(String str, @NonNull String str2, int i, int i2, String str3, String str4, String str5, String str6, String str7, String str8) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), str3, str4, str5, str6, str7, str8}) == null) {
            zc8 zc8Var = new zc8();
            zc8Var.h(str);
            zc8Var.v(str2);
            zc8Var.d(i);
            zc8Var.i(i2);
            zc8Var.c(str3);
            zc8Var.k(str4);
            zc8Var.m(str5);
            zc8Var.o(str6);
            zc8Var.q(str7);
            zc8Var.s(str8);
            bd8.b().d(zc8Var);
        }
    }

    public static void f(AdvertAppInfo advertAppInfo, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65542, null, advertAppInfo, i) == null) {
            g(advertAppInfo, 0, "", i);
        }
    }

    public static void g(AdvertAppInfo advertAppInfo, int i, String str, int i2) {
        kh0 kh0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{advertAppInfo, Integer.valueOf(i), str, Integer.valueOf(i2)}) == null) {
            zc8 b = dd8.b(advertAppInfo, 2, i);
            if (TextUtils.isEmpty(str)) {
                str = "hotarea";
            }
            if (advertAppInfo != null && (kh0Var = advertAppInfo.u) != null) {
                b.o(kh0Var.a());
            }
            b.c(str);
            bd8.b().d(b);
            a(b, i2);
            bd8.b().d(b);
        }
    }

    public static void h(AdvertAppInfo advertAppInfo, int i, HashMap hashMap, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{advertAppInfo, Integer.valueOf(i), hashMap, Integer.valueOf(i2)}) == null) {
            g(advertAppInfo, i, b(hashMap), i2);
        }
    }

    public static void i(AdvertAppInfo advertAppInfo, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65545, null, advertAppInfo, i, i2) == null) {
            j(advertAppInfo, i, i2, -999, -999);
        }
    }

    public static void j(AdvertAppInfo advertAppInfo, int i, int i2, int i3, int i4) {
        int i5;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{advertAppInfo, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) || advertAppInfo == null || (i5 = advertAppInfo.c) == 1001 || i5 == -1001) {
            return;
        }
        zc8 h = dd8.h(advertAppInfo, 5, i, i2);
        if (i3 != -999) {
            h.l(i3);
        }
        if (i4 != -999) {
            h.n(i4);
        }
        if (i2 == 31) {
            if (TextUtils.isEmpty(a)) {
                a = c();
            }
            h.s(a);
        }
        bd8.b().d(h);
    }

    public static void k(cl8 cl8Var, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65547, null, cl8Var, i) == null) {
            l(cl8Var, i, -999, -999);
        }
    }

    public static void l(cl8 cl8Var, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIII(65548, null, cl8Var, i, i2, i3) == null) || cl8Var == null || cl8Var.getAdvertAppInfo() == null || cl8Var.getAdvertAppInfo().c == 1001 || cl8Var.getAdvertAppInfo().c == -1001) {
            return;
        }
        zc8 e = dd8.e(cl8Var, 5);
        e.j(i);
        if (i2 != -999) {
            e.l(i2);
        }
        if (i3 != -999) {
            e.n(i3);
        }
        bd8.b().d(e);
    }

    public static void m(AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, null, advertAppInfo) == null) {
            bd8.b().d(dd8.b(advertAppInfo, 7, 0));
        }
    }

    public static void n(AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, null, advertAppInfo) == null) {
            o(advertAppInfo, 0, "", "", "");
        }
    }

    public static void o(AdvertAppInfo advertAppInfo, int i, String str, String str2, String str3) {
        kh0 kh0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65551, null, new Object[]{advertAppInfo, Integer.valueOf(i), str, str2, str3}) == null) {
            zc8 c = dd8.c(advertAppInfo, 2, i);
            c.w(str2);
            if (TextUtils.isEmpty(str3)) {
                str3 = "hotarea";
            }
            if (advertAppInfo != null && (kh0Var = advertAppInfo.u) != null) {
                c.o(kh0Var.a());
            }
            c.c(str3);
            bd8.b().d(c);
        }
    }

    public static void p(AdvertAppInfo advertAppInfo, int i, String str, String str2, HashMap hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65552, null, new Object[]{advertAppInfo, Integer.valueOf(i), str, str2, hashMap}) == null) {
            o(advertAppInfo, i, str, str2, b(hashMap));
        }
    }

    public static void q(AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, advertAppInfo) == null) {
            bd8.b().d(dd8.b(advertAppInfo, 3, 0));
        }
    }
}
