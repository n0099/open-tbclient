package com.ss.android.socialbase.appdownloader.f;

import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.tbadk.core.util.RomTypeUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kuaishou.weapon.un.g;
import com.ss.android.socialbase.downloader.i.f;
import java.io.BufferedReader;
import java.io.InputStreamReader;
/* loaded from: classes3.dex */
public class d {
    public static /* synthetic */ Interceptable $ic = null;
    public static String a = null;

    /* renamed from: b  reason: collision with root package name */
    public static String f62141b = "";

    /* renamed from: c  reason: collision with root package name */
    public static String f62142c = null;

    /* renamed from: d  reason: collision with root package name */
    public static String f62143d = "";

    /* renamed from: e  reason: collision with root package name */
    public static String f62144e;

    /* renamed from: f  reason: collision with root package name */
    public static String f62145f;

    /* renamed from: g  reason: collision with root package name */
    public static String f62146g;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1108190731, "Lcom/ss/android/socialbase/appdownloader/f/d;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1108190731, "Lcom/ss/android/socialbase/appdownloader/f/d;");
        }
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? a("EMUI") : invokeV.booleanValue;
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? a("MIUI") : invokeV.booleanValue;
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? a("VIVO") : invokeV.booleanValue;
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            o();
            return a(a);
        }
        return invokeV.booleanValue;
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? a("FLYME") : invokeV.booleanValue;
    }

    public static boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? a(g.f57226j) : invokeV.booleanValue;
    }

    public static String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (f62144e == null) {
                a("");
            }
            return f62144e;
        }
        return (String) invokeV.objValue;
    }

    public static String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            if (f62145f == null) {
                a("");
            }
            return f62145f;
        }
        return (String) invokeV.objValue;
    }

    public static String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            if (f62142c == null) {
                a("");
            }
            return f62142c;
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public static String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            String str = Build.MANUFACTURER;
            return str == null ? "" : str.trim();
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public static String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
            String str = Build.DISPLAY;
            return str == null ? "" : str.trim();
        }
        return (String) invokeV.objValue;
    }

    public static boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) {
            p();
            return "V10".equals(f62146g);
        }
        return invokeV.booleanValue;
    }

    public static boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) {
            p();
            return "V11".equals(f62146g);
        }
        return invokeV.booleanValue;
    }

    public static boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) {
            p();
            return "V12".equals(f62146g);
        }
        return invokeV.booleanValue;
    }

    public static void o() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65555, null) == null) && TextUtils.isEmpty(a)) {
            com.ss.android.socialbase.downloader.downloader.c.F();
            a = com.ss.android.socialbase.downloader.constants.e.f62249b;
            f62143d = "ro.build.version." + com.ss.android.socialbase.downloader.constants.e.f62250c + "rom";
            f62141b = "com." + com.ss.android.socialbase.downloader.constants.e.f62250c + ".market";
        }
    }

    public static void p() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65556, null) == null) && f62146g == null) {
            try {
                f62146g = d("ro.miui.ui.version.name");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            String str = f62146g;
            if (str == null) {
                str = "";
            }
            f62146g = str;
        }
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            o();
            String str2 = f62144e;
            if (str2 != null) {
                return str2.equals(str);
            }
            String d2 = d("ro.miui.ui.version.name");
            f62145f = d2;
            if (!TextUtils.isEmpty(d2)) {
                f62144e = "MIUI";
                f62142c = "com.xiaomi.market";
                f62146g = f62145f;
            } else {
                String d3 = d("ro.build.version.emui");
                f62145f = d3;
                if (!TextUtils.isEmpty(d3)) {
                    f62144e = "EMUI";
                    f62142c = "com.huawei.appmarket";
                } else {
                    String d4 = d(f62143d);
                    f62145f = d4;
                    if (!TextUtils.isEmpty(d4)) {
                        f62144e = a;
                        if (com.ss.android.socialbase.appdownloader.g.a(f62141b) > -1) {
                            f62142c = f62141b;
                        } else {
                            f62142c = "com.heytap.market";
                        }
                    } else {
                        String d5 = d("ro.vivo.os.version");
                        f62145f = d5;
                        if (!TextUtils.isEmpty(d5)) {
                            f62144e = "VIVO";
                            f62142c = "com.bbk.appstore";
                        } else {
                            String d6 = d("ro.smartisan.version");
                            f62145f = d6;
                            if (!TextUtils.isEmpty(d6)) {
                                f62144e = "SMARTISAN";
                                f62142c = "com.smartisanos.appstore";
                            } else {
                                String d7 = d(RomUtils.KEY_VERSION_GIONEE);
                                f62145f = d7;
                                if (!TextUtils.isEmpty(d7)) {
                                    f62144e = "QIONEE";
                                    f62142c = "com.gionee.aora.market";
                                } else {
                                    String d8 = d("ro.lenovo.lvp.version");
                                    f62145f = d8;
                                    if (!TextUtils.isEmpty(d8)) {
                                        f62144e = "LENOVO";
                                        f62142c = "com.lenovo.leos.appstore";
                                    } else if (j().toUpperCase().contains(g.f57226j)) {
                                        f62144e = g.f57226j;
                                        f62142c = "com.sec.android.app.samsungapps";
                                    } else if (j().toUpperCase().contains("ZTE")) {
                                        f62144e = "ZTE";
                                        f62142c = "zte.com.market";
                                    } else if (j().toUpperCase().contains(RomUtils.ROM_NUBIA)) {
                                        f62144e = RomUtils.ROM_NUBIA;
                                        f62142c = "cn.nubia.neostore";
                                    } else if (k().toUpperCase().contains("FLYME")) {
                                        f62144e = "FLYME";
                                        f62142c = "com.meizu.mstore";
                                        f62145f = k();
                                    } else if (j().toUpperCase().contains(RomTypeUtil.ROM_ONEPLUS)) {
                                        f62144e = RomTypeUtil.ROM_ONEPLUS;
                                        f62145f = d("ro.rom.version");
                                        if (com.ss.android.socialbase.appdownloader.g.a(f62141b) > -1) {
                                            f62142c = f62141b;
                                        } else {
                                            f62142c = "com.heytap.market";
                                        }
                                    } else {
                                        f62144e = j().toUpperCase();
                                        f62142c = "";
                                        f62145f = "";
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return f62144e.equals(str);
        }
        return invokeL.booleanValue;
    }

    public static String b(String str) {
        InterceptResult invokeL;
        BufferedReader bufferedReader;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65539, null, str)) != null) {
            return (String) invokeL.objValue;
        }
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()), 1024);
            try {
                String readLine = bufferedReader.readLine();
                bufferedReader.close();
                f.a(bufferedReader);
                return readLine;
            } catch (Throwable unused) {
                f.a(bufferedReader);
                return null;
            }
        } catch (Throwable unused2) {
            bufferedReader = null;
        }
    }

    public static String c(String str) throws Throwable {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) ? (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, str) : (String) invokeL.objValue;
    }

    public static String d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            if (com.ss.android.socialbase.downloader.g.a.b().optBoolean("enable_reflect_system_properties", true)) {
                try {
                    return c(str);
                } catch (Throwable th) {
                    th.printStackTrace();
                    return b(str);
                }
            }
            return b(str);
        }
        return (String) invokeL.objValue;
    }
}
