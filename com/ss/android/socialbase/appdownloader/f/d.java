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
    public static String f69939a = null;

    /* renamed from: b  reason: collision with root package name */
    public static String f69940b = "";

    /* renamed from: c  reason: collision with root package name */
    public static String f69941c = null;

    /* renamed from: d  reason: collision with root package name */
    public static String f69942d = "";

    /* renamed from: e  reason: collision with root package name */
    public static String f69943e;

    /* renamed from: f  reason: collision with root package name */
    public static String f69944f;

    /* renamed from: g  reason: collision with root package name */
    public static String f69945g;
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
            return a(f69939a);
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
            if (f69943e == null) {
                a("");
            }
            return f69943e;
        }
        return (String) invokeV.objValue;
    }

    public static String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            if (f69944f == null) {
                a("");
            }
            return f69944f;
        }
        return (String) invokeV.objValue;
    }

    public static String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            if (f69941c == null) {
                a("");
            }
            return f69941c;
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
            return "V10".equals(f69945g);
        }
        return invokeV.booleanValue;
    }

    public static boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) {
            p();
            return "V11".equals(f69945g);
        }
        return invokeV.booleanValue;
    }

    public static boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) {
            p();
            return "V12".equals(f69945g);
        }
        return invokeV.booleanValue;
    }

    public static void o() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65555, null) == null) && TextUtils.isEmpty(f69939a)) {
            com.ss.android.socialbase.downloader.downloader.c.F();
            f69939a = com.ss.android.socialbase.downloader.constants.e.f70097b;
            f69942d = "ro.build.version." + com.ss.android.socialbase.downloader.constants.e.f70098c + "rom";
            f69940b = "com." + com.ss.android.socialbase.downloader.constants.e.f70098c + ".market";
        }
    }

    public static void p() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65556, null) == null) && f69945g == null) {
            try {
                f69945g = d("ro.miui.ui.version.name");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            String str = f69945g;
            if (str == null) {
                str = "";
            }
            f69945g = str;
        }
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            o();
            String str2 = f69943e;
            if (str2 != null) {
                return str2.equals(str);
            }
            String d2 = d("ro.miui.ui.version.name");
            f69944f = d2;
            if (!TextUtils.isEmpty(d2)) {
                f69943e = "MIUI";
                f69941c = "com.xiaomi.market";
                f69945g = f69944f;
            } else {
                String d3 = d("ro.build.version.emui");
                f69944f = d3;
                if (!TextUtils.isEmpty(d3)) {
                    f69943e = "EMUI";
                    f69941c = "com.huawei.appmarket";
                } else {
                    String d4 = d(f69942d);
                    f69944f = d4;
                    if (!TextUtils.isEmpty(d4)) {
                        f69943e = f69939a;
                        if (g.a(f69940b) > -1) {
                            f69941c = f69940b;
                        } else {
                            f69941c = "com.heytap.market";
                        }
                    } else {
                        String d5 = d("ro.vivo.os.version");
                        f69944f = d5;
                        if (!TextUtils.isEmpty(d5)) {
                            f69943e = "VIVO";
                            f69941c = "com.bbk.appstore";
                        } else {
                            String d6 = d("ro.smartisan.version");
                            f69944f = d6;
                            if (!TextUtils.isEmpty(d6)) {
                                f69943e = "SMARTISAN";
                                f69941c = "com.smartisanos.appstore";
                            } else {
                                String d7 = d(RomUtils.KEY_VERSION_GIONEE);
                                f69944f = d7;
                                if (!TextUtils.isEmpty(d7)) {
                                    f69943e = "QIONEE";
                                    f69941c = "com.gionee.aora.market";
                                } else {
                                    String d8 = d("ro.lenovo.lvp.version");
                                    f69944f = d8;
                                    if (!TextUtils.isEmpty(d8)) {
                                        f69943e = "LENOVO";
                                        f69941c = "com.lenovo.leos.appstore";
                                    } else if (j().toUpperCase().contains("SAMSUNG")) {
                                        f69943e = "SAMSUNG";
                                        f69941c = "com.sec.android.app.samsungapps";
                                    } else if (j().toUpperCase().contains("ZTE")) {
                                        f69943e = "ZTE";
                                        f69941c = "zte.com.market";
                                    } else if (j().toUpperCase().contains(RomUtils.ROM_NUBIA)) {
                                        f69943e = RomUtils.ROM_NUBIA;
                                        f69941c = "cn.nubia.neostore";
                                    } else if (k().toUpperCase().contains("FLYME")) {
                                        f69943e = "FLYME";
                                        f69941c = "com.meizu.mstore";
                                        f69944f = k();
                                    } else if (j().toUpperCase().contains(RomTypeUtil.ROM_ONEPLUS)) {
                                        f69943e = RomTypeUtil.ROM_ONEPLUS;
                                        f69944f = d("ro.rom.version");
                                        if (g.a(f69940b) > -1) {
                                            f69941c = f69940b;
                                        } else {
                                            f69941c = "com.heytap.market";
                                        }
                                    } else {
                                        f69943e = j().toUpperCase();
                                        f69941c = "";
                                        f69944f = "";
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return f69943e.equals(str);
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
