package com.kuaishou.weapon.un;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
/* loaded from: classes7.dex */
public class g {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "MIUI";

    /* renamed from: b  reason: collision with root package name */
    public static final String f53616b = "EMUI";

    /* renamed from: c  reason: collision with root package name */
    public static final String f53617c = "FLYME";

    /* renamed from: d  reason: collision with root package name */
    public static final String f53618d = "OPPO";

    /* renamed from: e  reason: collision with root package name */
    public static final String f53619e = "SMARTISAN";

    /* renamed from: f  reason: collision with root package name */
    public static final String f53620f = "VIVO";

    /* renamed from: g  reason: collision with root package name */
    public static final String f53621g = "QIKU";

    /* renamed from: h  reason: collision with root package name */
    public static final String f53622h = "360";

    /* renamed from: i  reason: collision with root package name */
    public static final String f53623i = "OnePlus";

    /* renamed from: j  reason: collision with root package name */
    public static final String f53624j = "SAMSUNG";
    public static final String k = "ro.miui.ui.version.name";
    public static final String l = "ro.build.version.emui";
    public static final String m = "ro.build.version.opporom";
    public static final String n = "ro.smartisan.version";
    public static final String o = "ro.vivo.os.version";
    public static final String p = "ro.product.system.manufacturer";
    public static final String q = "ro.product.manufacturer";
    public static String r;
    public static String s;
    public transient /* synthetic */ FieldHolder $fh;

    public g() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (r == null) {
                a("");
            }
            return r;
        }
        return (String) invokeV.objValue;
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        String upperCase;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            String str2 = r;
            if (str2 != null) {
                return str2.contains(str);
            }
            String b2 = b("ro.build.version.opporom");
            s = b2;
            if (TextUtils.isEmpty(b2)) {
                String b3 = b("ro.vivo.os.version");
                s = b3;
                if (TextUtils.isEmpty(b3)) {
                    String b4 = b("ro.build.version.emui");
                    s = b4;
                    if (TextUtils.isEmpty(b4)) {
                        String b5 = b("ro.miui.ui.version.name");
                        s = b5;
                        if (TextUtils.isEmpty(b5)) {
                            String b6 = b(p);
                            s = b6;
                            if (TextUtils.isEmpty(b6)) {
                                String b7 = b("ro.smartisan.version");
                                s = b7;
                                if (TextUtils.isEmpty(b7)) {
                                    String upperCase2 = b(q).toUpperCase();
                                    String str3 = f53624j;
                                    if (!upperCase2.contains(f53624j)) {
                                        String str4 = Build.DISPLAY;
                                        s = str4;
                                        str3 = "FLYME";
                                        if (!str4.toUpperCase().contains("FLYME")) {
                                            s = "unknown";
                                            upperCase = Build.MANUFACTURER.toUpperCase();
                                        }
                                    }
                                    r = str3;
                                    return r.contains(str);
                                }
                                upperCase = "SMARTISAN";
                            } else {
                                upperCase = f53623i;
                            }
                        } else {
                            upperCase = "MIUI";
                        }
                    } else {
                        upperCase = "EMUI";
                    }
                } else {
                    upperCase = "VIVO";
                }
            } else {
                upperCase = "OPPO";
            }
            r = upperCase;
            return r.contains(str);
        }
        return invokeL.booleanValue;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (s == null) {
                a("");
            }
            return s;
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(6:3|(4:4|5|6|7)|8|9|(6:13|14|16|17|18|19)|11) */
    /* JADX WARN: Removed duplicated region for block: B:48:0x003e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @SuppressLint({"PrivateApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String b(String str) {
        InterceptResult invokeL;
        String str2;
        BufferedReader bufferedReader;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            BufferedReader bufferedReader2 = null;
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                str2 = (String) cls.getDeclaredMethod("get", String.class).invoke(cls, str);
            } catch (ClassNotFoundException e2) {
                e2.printStackTrace();
                str2 = null;
                if (TextUtils.isEmpty(str2)) {
                }
                return str2;
            } catch (IllegalAccessException e3) {
                e3.printStackTrace();
                str2 = null;
                if (TextUtils.isEmpty(str2)) {
                }
                return str2;
            } catch (NoSuchMethodException e4) {
                e4.printStackTrace();
                str2 = null;
                if (TextUtils.isEmpty(str2)) {
                }
                return str2;
            } catch (InvocationTargetException e5) {
                e5.printStackTrace();
                str2 = null;
                if (TextUtils.isEmpty(str2)) {
                }
                return str2;
            }
            if (TextUtils.isEmpty(str2)) {
                try {
                    try {
                        bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()), 1024);
                    } catch (IOException e6) {
                        e = e6;
                    }
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    str2 = bufferedReader.readLine();
                    bufferedReader.close();
                } catch (IOException e7) {
                    e = e7;
                    bufferedReader2 = bufferedReader;
                    e.printStackTrace();
                    if (bufferedReader2 != null) {
                        bufferedReader2.close();
                    }
                    return str2;
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader2 = bufferedReader;
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException unused) {
                        }
                    }
                    throw th;
                }
            }
            return str2;
        }
        return (String) invokeL.objValue;
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? a("QIKU") || a(f53622h) : invokeV.booleanValue;
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? a("EMUI") : invokeV.booleanValue;
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? a("FLYME") : invokeV.booleanValue;
    }

    public static boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            try {
                return Build.MODEL.toUpperCase().contains("M5");
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            try {
                return Build.MANUFACTURER.toUpperCase().contains("MEITU");
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? a("MIUI") : invokeV.booleanValue;
    }

    public static boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? a(f53623i) : invokeV.booleanValue;
    }

    public static boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? a("OPPO") : invokeV.booleanValue;
    }

    public static boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) ? a(f53624j) : invokeV.booleanValue;
    }

    public static boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) ? a("SMARTISAN") : invokeV.booleanValue;
    }

    public static boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) ? a("VIVO") : invokeV.booleanValue;
    }
}
