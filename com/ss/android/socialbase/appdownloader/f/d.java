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
/* loaded from: classes2.dex */
public class d {
    public static /* synthetic */ Interceptable $ic = null;
    public static String a = null;

    /* renamed from: b  reason: collision with root package name */
    public static String f61560b = "";

    /* renamed from: c  reason: collision with root package name */
    public static String f61561c = null;

    /* renamed from: d  reason: collision with root package name */
    public static String f61562d = "";

    /* renamed from: e  reason: collision with root package name */
    public static String f61563e;

    /* renamed from: f  reason: collision with root package name */
    public static String f61564f;

    /* renamed from: g  reason: collision with root package name */
    public static String f61565g;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? a(g.f56645j) : invokeV.booleanValue;
    }

    public static String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (f61563e == null) {
                a("");
            }
            return f61563e;
        }
        return (String) invokeV.objValue;
    }

    public static String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            if (f61564f == null) {
                a("");
            }
            return f61564f;
        }
        return (String) invokeV.objValue;
    }

    public static String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            if (f61561c == null) {
                a("");
            }
            return f61561c;
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
            return "V10".equals(f61565g);
        }
        return invokeV.booleanValue;
    }

    public static boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) {
            p();
            return "V11".equals(f61565g);
        }
        return invokeV.booleanValue;
    }

    public static boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) {
            p();
            return "V12".equals(f61565g);
        }
        return invokeV.booleanValue;
    }

    public static void o() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65555, null) == null) && TextUtils.isEmpty(a)) {
            com.ss.android.socialbase.downloader.downloader.c.F();
            a = com.ss.android.socialbase.downloader.constants.e.f61668b;
            f61562d = "ro.build.version." + com.ss.android.socialbase.downloader.constants.e.f61669c + "rom";
            f61560b = "com." + com.ss.android.socialbase.downloader.constants.e.f61669c + ".market";
        }
    }

    public static void p() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65556, null) == null) && f61565g == null) {
            try {
                f61565g = d("ro.miui.ui.version.name");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            String str = f61565g;
            if (str == null) {
                str = "";
            }
            f61565g = str;
        }
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            o();
            String str2 = f61563e;
            if (str2 != null) {
                return str2.equals(str);
            }
            String d2 = d("ro.miui.ui.version.name");
            f61564f = d2;
            if (!TextUtils.isEmpty(d2)) {
                f61563e = "MIUI";
                f61561c = "com.xiaomi.market";
                f61565g = f61564f;
            } else {
                String d3 = d("ro.build.version.emui");
                f61564f = d3;
                if (!TextUtils.isEmpty(d3)) {
                    f61563e = "EMUI";
                    f61561c = "com.huawei.appmarket";
                } else {
                    String d4 = d(f61562d);
                    f61564f = d4;
                    if (!TextUtils.isEmpty(d4)) {
                        f61563e = a;
                        if (com.ss.android.socialbase.appdownloader.g.a(f61560b) > -1) {
                            f61561c = f61560b;
                        } else {
                            f61561c = "com.heytap.market";
                        }
                    } else {
                        String d5 = d("ro.vivo.os.version");
                        f61564f = d5;
                        if (!TextUtils.isEmpty(d5)) {
                            f61563e = "VIVO";
                            f61561c = "com.bbk.appstore";
                        } else {
                            String d6 = d("ro.smartisan.version");
                            f61564f = d6;
                            if (!TextUtils.isEmpty(d6)) {
                                f61563e = "SMARTISAN";
                                f61561c = "com.smartisanos.appstore";
                            } else {
                                String d7 = d(RomUtils.KEY_VERSION_GIONEE);
                                f61564f = d7;
                                if (!TextUtils.isEmpty(d7)) {
                                    f61563e = "QIONEE";
                                    f61561c = "com.gionee.aora.market";
                                } else {
                                    String d8 = d("ro.lenovo.lvp.version");
                                    f61564f = d8;
                                    if (!TextUtils.isEmpty(d8)) {
                                        f61563e = "LENOVO";
                                        f61561c = "com.lenovo.leos.appstore";
                                    } else if (j().toUpperCase().contains(g.f56645j)) {
                                        f61563e = g.f56645j;
                                        f61561c = "com.sec.android.app.samsungapps";
                                    } else if (j().toUpperCase().contains("ZTE")) {
                                        f61563e = "ZTE";
                                        f61561c = "zte.com.market";
                                    } else if (j().toUpperCase().contains(RomUtils.ROM_NUBIA)) {
                                        f61563e = RomUtils.ROM_NUBIA;
                                        f61561c = "cn.nubia.neostore";
                                    } else if (k().toUpperCase().contains("FLYME")) {
                                        f61563e = "FLYME";
                                        f61561c = "com.meizu.mstore";
                                        f61564f = k();
                                    } else if (j().toUpperCase().contains(RomTypeUtil.ROM_ONEPLUS)) {
                                        f61563e = RomTypeUtil.ROM_ONEPLUS;
                                        f61564f = d("ro.rom.version");
                                        if (com.ss.android.socialbase.appdownloader.g.a(f61560b) > -1) {
                                            f61561c = f61560b;
                                        } else {
                                            f61561c = "com.heytap.market";
                                        }
                                    } else {
                                        f61563e = j().toUpperCase();
                                        f61561c = "";
                                        f61564f = "";
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return f61563e.equals(str);
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
