package com.kwad.sdk.utils;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
/* loaded from: classes3.dex */
public class an {
    public static /* synthetic */ Interceptable $ic;
    public static String a;

    /* renamed from: b  reason: collision with root package name */
    public static String f60181b;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) ? a("EMUI") : invokeV.booleanValue;
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        String upperCase;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            String str2 = a;
            if (str2 != null) {
                return str2.contains(str);
            }
            String b2 = b("ro.build.version.opporom");
            f60181b = b2;
            if (TextUtils.isEmpty(b2)) {
                String b3 = b("ro.vivo.os.version");
                f60181b = b3;
                if (TextUtils.isEmpty(b3)) {
                    String b4 = b("ro.build.version.emui");
                    f60181b = b4;
                    if (TextUtils.isEmpty(b4)) {
                        String b5 = b("ro.miui.ui.version.name");
                        f60181b = b5;
                        if (TextUtils.isEmpty(b5)) {
                            String b6 = b(com.kuaishou.weapon.un.g.p);
                            f60181b = b6;
                            if (TextUtils.isEmpty(b6)) {
                                String b7 = b("ro.smartisan.version");
                                f60181b = b7;
                                if (TextUtils.isEmpty(b7)) {
                                    String upperCase2 = b(com.kuaishou.weapon.un.g.q).toUpperCase();
                                    String str3 = com.kuaishou.weapon.un.g.f57226j;
                                    if (!upperCase2.contains(com.kuaishou.weapon.un.g.f57226j)) {
                                        String str4 = Build.DISPLAY;
                                        f60181b = str4;
                                        str3 = "FLYME";
                                        if (!str4.toUpperCase().contains("FLYME")) {
                                            f60181b = "unknown";
                                            upperCase = Build.MANUFACTURER.toUpperCase();
                                        }
                                    }
                                    a = str3;
                                    return a.contains(str);
                                }
                                upperCase = "SMARTISAN";
                            } else {
                                upperCase = com.kuaishou.weapon.un.g.f57225i;
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
            a = upperCase;
            return a.contains(str);
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(6:3|(2:4|5)|6|7|(6:11|12|14|15|16|17)|9) */
    /* JADX WARN: Removed duplicated region for block: B:46:0x003e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @SuppressLint({"PrivateApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String b(String str) {
        InterceptResult invokeL;
        String str2;
        BufferedReader bufferedReader;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
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

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? a("MIUI") : invokeV.booleanValue;
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? a("FLYME") : invokeV.booleanValue;
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (a == null) {
                a("");
            }
            return a;
        }
        return (String) invokeV.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            if (f60181b == null) {
                a("");
            }
            return f60181b;
        }
        return (String) invokeV.objValue;
    }
}
