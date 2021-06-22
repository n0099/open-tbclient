package com.kwad.sdk.utils;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
/* loaded from: classes7.dex */
public class ac {

    /* renamed from: a  reason: collision with root package name */
    public static String f37551a;

    /* renamed from: b  reason: collision with root package name */
    public static String f37552b;

    public static boolean a() {
        return a("MIUI");
    }

    public static boolean a(String str) {
        String upperCase;
        String str2 = f37551a;
        if (str2 != null) {
            return str2.contains(str);
        }
        String b2 = b("ro.build.version.opporom");
        f37552b = b2;
        if (TextUtils.isEmpty(b2)) {
            String b3 = b("ro.vivo.os.version");
            f37552b = b3;
            if (TextUtils.isEmpty(b3)) {
                String b4 = b("ro.build.version.emui");
                f37552b = b4;
                if (TextUtils.isEmpty(b4)) {
                    String b5 = b("ro.miui.ui.version.name");
                    f37552b = b5;
                    if (TextUtils.isEmpty(b5)) {
                        String b6 = b("ro.product.system.manufacturer");
                        f37552b = b6;
                        if (TextUtils.isEmpty(b6)) {
                            String b7 = b("ro.smartisan.version");
                            f37552b = b7;
                            if (TextUtils.isEmpty(b7)) {
                                String str3 = "SAMSUNG";
                                if (!b("ro.product.manufacturer").toUpperCase().contains("SAMSUNG")) {
                                    String str4 = Build.DISPLAY;
                                    f37552b = str4;
                                    str3 = "FLYME";
                                    if (!str4.toUpperCase().contains("FLYME")) {
                                        f37552b = "unknown";
                                        upperCase = Build.MANUFACTURER.toUpperCase();
                                    }
                                }
                                f37551a = str3;
                                return f37551a.contains(str);
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
        f37551a = upperCase;
        return f37551a.contains(str);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:1|(2:2|3)|4|5|(7:9|10|12|13|14|15|17)|7|(1:(0))) */
    /* JADX WARN: Removed duplicated region for block: B:42:0x003a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @SuppressLint({"PrivateApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String b(String str) {
        String str2;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
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
                    bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()), 1024);
                } catch (IOException e6) {
                    e = e6;
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
                } catch (Throwable th) {
                    th = th;
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
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean b() {
        return a("FLYME");
    }
}
