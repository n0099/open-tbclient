package com.repackage;

import android.app.ActivityManager;
import android.os.Process;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class ja8 {
    public static /* synthetic */ Interceptable $ic;
    public static String a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755595280, "Lcom/repackage/ja8;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755595280, "Lcom/repackage/ja8;");
        }
    }

    public static void a(ClogBuilder clogBuilder, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65537, null, clogBuilder, i) == null) {
            clogBuilder.w(ClogBuilder.LogType.DEEP_LINK);
            boolean z = i == 1000;
            clogBuilder.h(z ? "APP" : "URL");
            if (!z) {
                clogBuilder.j(String.valueOf(i));
            }
            clogBuilder.t("DEEPLINK");
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

    public static void d(String str, @NonNull String str2, int i, int i2, String str3, String str4, String str5, String str6, String str7, String str8) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), str3, str4, str5, str6, str7, str8}) == null) {
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.x(String.valueOf(i2)).o(String.valueOf(i)).t(str).h(str3).i(str4).j(str5).k(str6).l(str7).m(str8).n(str2);
            vx0.c(clogBuilder);
        }
    }

    public static void e(AdvertAppInfo advertAppInfo, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65541, null, advertAppInfo, i) == null) {
            f(advertAppInfo, 0, "", i);
        }
    }

    public static void f(AdvertAppInfo advertAppInfo, int i, String str, int i2) {
        eg0 eg0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{advertAppInfo, Integer.valueOf(i), str, Integer.valueOf(i2)}) == null) || advertAppInfo == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = "hotarea";
        }
        boolean equals = "PB_BANNER".equals(advertAppInfo.j);
        ClogBuilder clogBuilder = new ClogBuilder();
        ClogBuilder o = clogBuilder.w(ClogBuilder.LogType.CLICK).o(String.valueOf(equals ? -1 : advertAppInfo.position + 1));
        if (equals) {
            i = -1;
        }
        o.u(String.valueOf(i)).t(advertAppInfo.j).h(str).n(advertAppInfo.g);
        if (advertAppInfo != null && (eg0Var = advertAppInfo.r) != null) {
            clogBuilder.k(eg0Var.a());
        }
        vx0.c(clogBuilder);
        a(clogBuilder, i2);
        vx0.c(clogBuilder);
    }

    public static void g(AdvertAppInfo advertAppInfo, int i, HashMap hashMap, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{advertAppInfo, Integer.valueOf(i), hashMap, Integer.valueOf(i2)}) == null) {
            f(advertAppInfo, i, b(hashMap), i2);
        }
    }

    public static void h(AdvertAppInfo advertAppInfo, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65544, null, advertAppInfo, i, i2) == null) {
            i(advertAppInfo, i, i2, -999, -999);
        }
    }

    public static void i(AdvertAppInfo advertAppInfo, int i, int i2, int i3, int i4) {
        int i5;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{advertAppInfo, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) || advertAppInfo == null || (i5 = advertAppInfo.c) == 1001 || i5 == -1001) {
            return;
        }
        boolean equals = "PB_BANNER".equals(advertAppInfo.j);
        ClogBuilder clogBuilder = new ClogBuilder();
        ClogBuilder o = clogBuilder.w(ClogBuilder.LogType.DISCARD).i(String.valueOf(i2)).o(String.valueOf(equals ? -1 : advertAppInfo.position + 1));
        if (equals) {
            i = -1;
        }
        o.u(String.valueOf(i)).t(advertAppInfo.j).n(advertAppInfo.g);
        if (i3 != -999) {
            clogBuilder.j(String.valueOf(i3));
        }
        if (i4 != -999) {
            clogBuilder.k(String.valueOf(i4));
        }
        if (i2 == 31) {
            if (TextUtils.isEmpty(a)) {
                a = c();
            }
            clogBuilder.m(a);
        }
        vx0.c(clogBuilder);
    }

    public static void j(sh8 sh8Var, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65546, null, sh8Var, i) == null) {
            k(sh8Var, i, -999, -999);
        }
    }

    public static void k(sh8 sh8Var, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIII(65547, null, sh8Var, i, i2, i3) == null) || sh8Var == null || sh8Var.getAdvertAppInfo() == null || sh8Var.getAdvertAppInfo().c == 1001 || sh8Var.getAdvertAppInfo().c == -1001) {
            return;
        }
        AdvertAppInfo advertAppInfo = sh8Var.getAdvertAppInfo();
        ClogBuilder clogBuilder = new ClogBuilder();
        clogBuilder.w(ClogBuilder.LogType.DISCARD).i(String.valueOf(i)).o(String.valueOf(sh8Var.H0 ? -1 : sh8Var.O0 + 1)).u(String.valueOf(sh8Var.H0 ? -1 : sh8Var.M0)).t(sh8Var.P0()).p(sh8Var.J0).q(sh8Var.K0).r(sh8Var.I0).n(advertAppInfo.g);
        if (i2 != -999) {
            clogBuilder.j(String.valueOf(i2));
        }
        if (i3 != -999) {
            clogBuilder.k(String.valueOf(i3));
        }
        vx0.c(clogBuilder);
    }

    public static void l(AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, advertAppInfo) == null) {
            m(advertAppInfo, 0, "");
        }
    }

    public static void m(AdvertAppInfo advertAppInfo, int i, String str) {
        eg0 eg0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(65549, null, advertAppInfo, i, str) == null) || advertAppInfo == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = "hotarea";
        }
        boolean equals = "PB_BANNER".equals(advertAppInfo.j);
        ClogBuilder clogBuilder = new ClogBuilder();
        ClogBuilder o = clogBuilder.w(ClogBuilder.LogType.CLICK).o(String.valueOf(equals ? -1 : advertAppInfo.position + 1));
        if (equals) {
            i = -1;
        }
        o.u(String.valueOf(i)).t(advertAppInfo.j).h(str).n(advertAppInfo.g);
        if (advertAppInfo != null && (eg0Var = advertAppInfo.r) != null) {
            clogBuilder.k(eg0Var.a());
        }
        vx0.c(clogBuilder);
    }

    public static void n(AdvertAppInfo advertAppInfo, int i, String str, String str2, HashMap hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65550, null, new Object[]{advertAppInfo, Integer.valueOf(i), str, str2, hashMap}) == null) {
            m(advertAppInfo, i, b(hashMap));
        }
    }

    public static void o(AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65551, null, advertAppInfo) == null) || advertAppInfo == null) {
            return;
        }
        ClogBuilder clogBuilder = new ClogBuilder();
        clogBuilder.w(ClogBuilder.LogType.SHOW).o(String.valueOf(advertAppInfo.position + 1)).u(String.valueOf(-1)).t(advertAppInfo.j).n(advertAppInfo.g);
        vx0.c(clogBuilder);
    }
}
