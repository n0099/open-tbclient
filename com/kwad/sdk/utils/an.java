package com.kwad.sdk.utils;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.sofire.sharedpreferences.SharedPreferenceManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
/* loaded from: classes5.dex */
public class an {
    public static String a;
    public static String b;

    public static boolean a() {
        return a("EMUI");
    }

    public static boolean a(String str) {
        String upperCase;
        String str2 = a;
        if (str2 != null) {
            return str2.contains(str);
        }
        String b2 = b("ro.build.version.opporom");
        b = b2;
        if (TextUtils.isEmpty(b2)) {
            String b3 = b("ro.vivo.os.version");
            b = b3;
            if (TextUtils.isEmpty(b3)) {
                String b4 = b("ro.build.version.emui");
                b = b4;
                if (TextUtils.isEmpty(b4)) {
                    String b5 = b("ro.miui.ui.version.name");
                    b = b5;
                    if (TextUtils.isEmpty(b5)) {
                        String b6 = b(com.kuaishou.weapon.un.g.p);
                        b = b6;
                        if (TextUtils.isEmpty(b6)) {
                            String b7 = b("ro.smartisan.version");
                            b = b7;
                            if (TextUtils.isEmpty(b7)) {
                                String upperCase2 = b(com.kuaishou.weapon.un.g.q).toUpperCase();
                                String str3 = com.kuaishou.weapon.un.g.j;
                                if (!upperCase2.contains(com.kuaishou.weapon.un.g.j)) {
                                    String str4 = Build.DISPLAY;
                                    b = str4;
                                    str3 = "FLYME";
                                    if (!str4.toUpperCase().contains("FLYME")) {
                                        b = "unknown";
                                        upperCase = Build.MANUFACTURER.toUpperCase();
                                    }
                                }
                                a = str3;
                                return a.contains(str);
                            }
                            upperCase = "SMARTISAN";
                        } else {
                            upperCase = com.kuaishou.weapon.un.g.i;
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
                str2 = (String) cls.getDeclaredMethod(SharedPreferenceManager.OPERATION_GET_PERFIX, String.class).invoke(cls, str);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                str2 = null;
                if (TextUtils.isEmpty(str2)) {
                }
                return str2;
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
                str2 = null;
                if (TextUtils.isEmpty(str2)) {
                }
                return str2;
            } catch (NoSuchMethodException e3) {
                e3.printStackTrace();
                str2 = null;
                if (TextUtils.isEmpty(str2)) {
                }
                return str2;
            } catch (InvocationTargetException e4) {
                e4.printStackTrace();
                str2 = null;
                if (TextUtils.isEmpty(str2)) {
                }
                return str2;
            }
            if (TextUtils.isEmpty(str2)) {
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()), 1024);
                } catch (IOException e5) {
                    e = e5;
                }
                try {
                    str2 = bufferedReader.readLine();
                    bufferedReader.close();
                } catch (IOException e6) {
                    e = e6;
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
        return a("MIUI");
    }

    public static boolean c() {
        return a("FLYME");
    }

    public static String d() {
        if (a == null) {
            a("");
        }
        return a;
    }

    public static String e() {
        if (b == null) {
            a("");
        }
        return b;
    }
}
