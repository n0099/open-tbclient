package com.kwad.sdk.utils;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
/* loaded from: classes10.dex */
public class aj {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static String f73704a;

    /* renamed from: b  reason: collision with root package name */
    public static String f73705b;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) ? a("MIUI") : invokeV.booleanValue;
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        String upperCase;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            String str2 = f73704a;
            if (str2 != null) {
                return str2.contains(str);
            }
            String b2 = b("ro.build.version.opporom");
            f73705b = b2;
            if (TextUtils.isEmpty(b2)) {
                String b3 = b("ro.vivo.os.version");
                f73705b = b3;
                if (TextUtils.isEmpty(b3)) {
                    String b4 = b("ro.build.version.emui");
                    f73705b = b4;
                    if (TextUtils.isEmpty(b4)) {
                        String b5 = b("ro.miui.ui.version.name");
                        f73705b = b5;
                        if (TextUtils.isEmpty(b5)) {
                            String b6 = b("ro.product.system.manufacturer");
                            f73705b = b6;
                            if (TextUtils.isEmpty(b6)) {
                                String b7 = b("ro.smartisan.version");
                                f73705b = b7;
                                if (TextUtils.isEmpty(b7)) {
                                    String str3 = "SAMSUNG";
                                    if (!b("ro.product.manufacturer").toUpperCase().contains("SAMSUNG")) {
                                        String str4 = Build.DISPLAY;
                                        f73705b = str4;
                                        str3 = "FLYME";
                                        if (!str4.toUpperCase().contains("FLYME")) {
                                            f73705b = "unknown";
                                            upperCase = Build.MANUFACTURER.toUpperCase();
                                        }
                                    }
                                    f73704a = str3;
                                    return f73704a.contains(str);
                                }
                                upperCase = "SMARTISAN";
                            } else {
                                upperCase = "OnePlus";
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
            f73704a = upperCase;
            return f73704a.contains(str);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? a("FLYME") : invokeV.booleanValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (f73704a == null) {
                a("");
            }
            return f73704a;
        }
        return (String) invokeV.objValue;
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            if (f73705b == null) {
                a("");
            }
            return f73705b;
        }
        return (String) invokeV.objValue;
    }
}
