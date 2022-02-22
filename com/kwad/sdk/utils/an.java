package com.kwad.sdk.utils;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
/* loaded from: classes4.dex */
public class an {
    public static String a;

    /* renamed from: b  reason: collision with root package name */
    public static String f58109b;

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
        f58109b = b2;
        if (TextUtils.isEmpty(b2)) {
            String b3 = b("ro.vivo.os.version");
            f58109b = b3;
            if (TextUtils.isEmpty(b3)) {
                String b4 = b("ro.build.version.emui");
                f58109b = b4;
                if (TextUtils.isEmpty(b4)) {
                    String b5 = b("ro.miui.ui.version.name");
                    f58109b = b5;
                    if (TextUtils.isEmpty(b5)) {
                        String b6 = b(com.kuaishou.weapon.un.g.p);
                        f58109b = b6;
                        if (TextUtils.isEmpty(b6)) {
                            String b7 = b("ro.smartisan.version");
                            f58109b = b7;
                            if (TextUtils.isEmpty(b7)) {
                                String upperCase2 = b(com.kuaishou.weapon.un.g.q).toUpperCase();
                                String str3 = com.kuaishou.weapon.un.g.f55274j;
                                if (!upperCase2.contains(com.kuaishou.weapon.un.g.f55274j)) {
                                    String str4 = Build.DISPLAY;
                                    f58109b = str4;
                                    str3 = "FLYME";
                                    if (!str4.toUpperCase().contains("FLYME")) {
                                        f58109b = "unknown";
                                        upperCase = Build.MANUFACTURER.toUpperCase();
                                    }
                                }
                                a = str3;
                                return a.contains(str);
                            }
                            upperCase = "SMARTISAN";
                        } else {
                            upperCase = com.kuaishou.weapon.un.g.f55273i;
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
        if (f58109b == null) {
            a("");
        }
        return f58109b;
    }
}
