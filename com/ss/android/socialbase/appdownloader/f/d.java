package com.ss.android.socialbase.appdownloader.f;

import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.util.RomTypeUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.ss.android.socialbase.appdownloader.g;
import com.ss.android.socialbase.downloader.i.f;
import java.io.BufferedReader;
import java.io.InputStreamReader;
/* loaded from: classes2.dex */
public class d {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static String f69020a = null;

    /* renamed from: b  reason: collision with root package name */
    public static String f69021b = "";

    /* renamed from: c  reason: collision with root package name */
    public static String f69022c = null;

    /* renamed from: d  reason: collision with root package name */
    public static String f69023d = "";

    /* renamed from: e  reason: collision with root package name */
    public static String f69024e;

    /* renamed from: f  reason: collision with root package name */
    public static String f69025f;

    /* renamed from: g  reason: collision with root package name */
    public static String f69026g;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? a("VIVO") : invokeV.booleanValue;
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            o();
            return a(f69020a);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? a("SAMSUNG") : invokeV.booleanValue;
    }

    public static String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (f69024e == null) {
                a("");
            }
            return f69024e;
        }
        return (String) invokeV.objValue;
    }

    public static String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            if (f69025f == null) {
                a("");
            }
            return f69025f;
        }
        return (String) invokeV.objValue;
    }

    public static String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            if (f69022c == null) {
                a("");
            }
            return f69022c;
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
            return "V10".equals(f69026g);
        }
        return invokeV.booleanValue;
    }

    public static boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) {
            p();
            return "V11".equals(f69026g);
        }
        return invokeV.booleanValue;
    }

    public static boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) {
            p();
            return "V12".equals(f69026g);
        }
        return invokeV.booleanValue;
    }

    public static void o() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65555, null) == null) && TextUtils.isEmpty(f69020a)) {
            com.ss.android.socialbase.downloader.downloader.c.F();
            f69020a = com.ss.android.socialbase.downloader.constants.e.f69178b;
            f69023d = "ro.build.version." + com.ss.android.socialbase.downloader.constants.e.f69179c + "rom";
            f69021b = "com." + com.ss.android.socialbase.downloader.constants.e.f69179c + ".market";
        }
    }

    public static void p() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65556, null) == null) && f69026g == null) {
            try {
                f69026g = d("ro.miui.ui.version.name");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            String str = f69026g;
            if (str == null) {
                str = "";
            }
            f69026g = str;
        }
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            o();
            String str2 = f69024e;
            if (str2 != null) {
                return str2.equals(str);
            }
            String d2 = d("ro.miui.ui.version.name");
            f69025f = d2;
            if (!TextUtils.isEmpty(d2)) {
                f69024e = "MIUI";
                f69022c = "com.xiaomi.market";
                f69026g = f69025f;
            } else {
                String d3 = d("ro.build.version.emui");
                f69025f = d3;
                if (!TextUtils.isEmpty(d3)) {
                    f69024e = "EMUI";
                    f69022c = "com.huawei.appmarket";
                } else {
                    String d4 = d(f69023d);
                    f69025f = d4;
                    if (!TextUtils.isEmpty(d4)) {
                        f69024e = f69020a;
                        if (g.a(f69021b) > -1) {
                            f69022c = f69021b;
                        } else {
                            f69022c = "com.heytap.market";
                        }
                    } else {
                        String d5 = d("ro.vivo.os.version");
                        f69025f = d5;
                        if (!TextUtils.isEmpty(d5)) {
                            f69024e = "VIVO";
                            f69022c = "com.bbk.appstore";
                        } else {
                            String d6 = d("ro.smartisan.version");
                            f69025f = d6;
                            if (!TextUtils.isEmpty(d6)) {
                                f69024e = "SMARTISAN";
                                f69022c = "com.smartisanos.appstore";
                            } else {
                                String d7 = d(RomUtils.KEY_VERSION_GIONEE);
                                f69025f = d7;
                                if (!TextUtils.isEmpty(d7)) {
                                    f69024e = "QIONEE";
                                    f69022c = "com.gionee.aora.market";
                                } else {
                                    String d8 = d("ro.lenovo.lvp.version");
                                    f69025f = d8;
                                    if (!TextUtils.isEmpty(d8)) {
                                        f69024e = "LENOVO";
                                        f69022c = "com.lenovo.leos.appstore";
                                    } else if (j().toUpperCase().contains("SAMSUNG")) {
                                        f69024e = "SAMSUNG";
                                        f69022c = "com.sec.android.app.samsungapps";
                                    } else if (j().toUpperCase().contains("ZTE")) {
                                        f69024e = "ZTE";
                                        f69022c = "zte.com.market";
                                    } else if (j().toUpperCase().contains(RomUtils.ROM_NUBIA)) {
                                        f69024e = RomUtils.ROM_NUBIA;
                                        f69022c = "cn.nubia.neostore";
                                    } else if (k().toUpperCase().contains("FLYME")) {
                                        f69024e = "FLYME";
                                        f69022c = "com.meizu.mstore";
                                        f69025f = k();
                                    } else if (j().toUpperCase().contains(RomTypeUtil.ROM_ONEPLUS)) {
                                        f69024e = RomTypeUtil.ROM_ONEPLUS;
                                        f69025f = d("ro.rom.version");
                                        if (g.a(f69021b) > -1) {
                                            f69022c = f69021b;
                                        } else {
                                            f69022c = "com.heytap.market";
                                        }
                                    } else {
                                        f69024e = j().toUpperCase();
                                        f69022c = "";
                                        f69025f = "";
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return f69024e.equals(str);
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
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) ? (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, str) : (String) invokeL.objValue;
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
