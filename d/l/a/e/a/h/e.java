package d.l.a.e.a.h;

import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.util.RomTypeUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.l.a.e.a.j;
import d.l.a.e.b.j.a;
import java.io.BufferedReader;
import java.io.InputStreamReader;
/* loaded from: classes8.dex */
public class e {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static String f72122a = null;

    /* renamed from: b  reason: collision with root package name */
    public static String f72123b = "";

    /* renamed from: c  reason: collision with root package name */
    public static String f72124c = "";

    /* renamed from: d  reason: collision with root package name */
    public static String f72125d;

    /* renamed from: e  reason: collision with root package name */
    public static String f72126e;

    /* renamed from: f  reason: collision with root package name */
    public static String f72127f;

    /* renamed from: g  reason: collision with root package name */
    public static String f72128g;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1770999773, "Ld/l/a/e/a/h/e;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1770999773, "Ld/l/a/e/a/h/e;");
        }
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? b("EMUI") : invokeV.booleanValue;
    }

    public static boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            s();
            String str2 = f72125d;
            if (str2 != null) {
                return str2.equals(str);
            }
            String g2 = g("ro.miui.ui.version.name");
            f72126e = g2;
            if (!TextUtils.isEmpty(g2)) {
                f72125d = "MIUI";
                f72127f = "com.xiaomi.market";
                f72128g = f72126e;
            } else {
                String g3 = g("ro.build.version.emui");
                f72126e = g3;
                if (!TextUtils.isEmpty(g3)) {
                    f72125d = "EMUI";
                    f72127f = "com.huawei.appmarket";
                } else {
                    String g4 = g(f72123b);
                    f72126e = g4;
                    if (!TextUtils.isEmpty(g4)) {
                        f72125d = f72122a;
                        if (j.a(f72124c) > -1) {
                            f72127f = f72124c;
                        } else {
                            f72127f = "com.heytap.market";
                        }
                    } else {
                        String g5 = g("ro.vivo.os.version");
                        f72126e = g5;
                        if (!TextUtils.isEmpty(g5)) {
                            f72125d = "VIVO";
                            f72127f = "com.bbk.appstore";
                        } else {
                            String g6 = g("ro.smartisan.version");
                            f72126e = g6;
                            if (!TextUtils.isEmpty(g6)) {
                                f72125d = "SMARTISAN";
                                f72127f = "com.smartisanos.appstore";
                            } else {
                                String g7 = g(RomUtils.KEY_VERSION_GIONEE);
                                f72126e = g7;
                                if (!TextUtils.isEmpty(g7)) {
                                    f72125d = "QIONEE";
                                    f72127f = "com.gionee.aora.market";
                                } else {
                                    String g8 = g("ro.lenovo.lvp.version");
                                    f72126e = g8;
                                    if (!TextUtils.isEmpty(g8)) {
                                        f72125d = "LENOVO";
                                        f72127f = "com.lenovo.leos.appstore";
                                    } else if (n().toUpperCase().contains("SAMSUNG")) {
                                        f72125d = "SAMSUNG";
                                        f72127f = "com.sec.android.app.samsungapps";
                                    } else if (n().toUpperCase().contains("ZTE")) {
                                        f72125d = "ZTE";
                                        f72127f = "zte.com.market";
                                    } else if (n().toUpperCase().contains(RomUtils.ROM_NUBIA)) {
                                        f72125d = RomUtils.ROM_NUBIA;
                                        f72127f = "cn.nubia.neostore";
                                    } else if (o().toUpperCase().contains("FLYME")) {
                                        f72125d = "FLYME";
                                        f72127f = "com.meizu.mstore";
                                        f72126e = o();
                                    } else if (n().toUpperCase().contains(RomTypeUtil.ROM_ONEPLUS)) {
                                        f72125d = RomTypeUtil.ROM_ONEPLUS;
                                        f72126e = g("ro.rom.version");
                                        if (j.a(f72124c) > -1) {
                                            f72127f = f72124c;
                                        } else {
                                            f72127f = "com.heytap.market";
                                        }
                                    } else {
                                        f72125d = n().toUpperCase();
                                        f72127f = "";
                                        f72126e = "";
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return f72125d.equals(str);
        }
        return invokeL.booleanValue;
    }

    public static String c(String str) {
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
                d.l.a.e.b.l.f.E(bufferedReader);
                return readLine;
            } catch (Throwable unused) {
                d.l.a.e.b.l.f.E(bufferedReader);
                return null;
            }
        } catch (Throwable unused2) {
            bufferedReader = null;
        }
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? b("MIUI") : invokeV.booleanValue;
    }

    public static String e(String str) throws Throwable {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) ? (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, str) : (String) invokeL.objValue;
    }

    public static boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? b("VIVO") : invokeV.booleanValue;
    }

    public static String g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            if (a.o().optBoolean("enable_reflect_system_properties", true)) {
                try {
                    return e(str);
                } catch (Throwable th) {
                    th.printStackTrace();
                    return c(str);
                }
            }
            return c(str);
        }
        return (String) invokeL.objValue;
    }

    public static boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            s();
            return b(f72122a);
        }
        return invokeV.booleanValue;
    }

    public static boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? b("FLYME") : invokeV.booleanValue;
    }

    public static boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? b("SAMSUNG") : invokeV.booleanValue;
    }

    public static String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (f72125d == null) {
                b("");
            }
            return f72125d;
        }
        return (String) invokeV.objValue;
    }

    public static String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            if (f72126e == null) {
                b("");
            }
            return f72126e;
        }
        return (String) invokeV.objValue;
    }

    public static String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            if (f72127f == null) {
                b("");
            }
            return f72127f;
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public static String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            String str = Build.MANUFACTURER;
            return str == null ? "" : str.trim();
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public static String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
            String str = Build.DISPLAY;
            return str == null ? "" : str.trim();
        }
        return (String) invokeV.objValue;
    }

    public static boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) {
            t();
            return "V10".equals(f72128g);
        }
        return invokeV.booleanValue;
    }

    public static boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) {
            t();
            return "V11".equals(f72128g);
        }
        return invokeV.booleanValue;
    }

    public static boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) {
            t();
            return "V12".equals(f72128g);
        }
        return invokeV.booleanValue;
    }

    public static void s() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65555, null) == null) && TextUtils.isEmpty(f72122a)) {
            d.l.a.e.b.g.e.f();
            f72122a = d.l.a.e.b.d.c.f72191b;
            f72123b = "ro.build.version." + d.l.a.e.b.d.c.f72192c + Config.ROM;
            f72124c = "com." + d.l.a.e.b.d.c.f72192c + ".market";
        }
    }

    public static void t() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65556, null) == null) && f72128g == null) {
            try {
                f72128g = g("ro.miui.ui.version.name");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            String str = f72128g;
            if (str == null) {
                str = "";
            }
            f72128g = str;
        }
    }
}
