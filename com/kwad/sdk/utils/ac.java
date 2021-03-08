package com.kwad.sdk.utils;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.util.devices.RomUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
/* loaded from: classes3.dex */
public class ac {

    /* renamed from: a  reason: collision with root package name */
    private static String f7112a;
    private static String b;

    public static boolean a() {
        return a(RomUtils.ROM_MIUI);
    }

    public static boolean a(String str) {
        if (f7112a != null) {
            return f7112a.contains(str);
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
                        String b6 = b("ro.product.system.manufacturer");
                        b = b6;
                        if (TextUtils.isEmpty(b6)) {
                            String b7 = b("ro.smartisan.version");
                            b = b7;
                            if (!TextUtils.isEmpty(b7)) {
                                f7112a = RomUtils.ROM_SMARTISAN;
                            } else if (b("ro.product.manufacturer").toUpperCase().contains("SAMSUNG")) {
                                f7112a = "SAMSUNG";
                            } else {
                                b = Build.DISPLAY;
                                if (b.toUpperCase().contains(RomUtils.ROM_FLYME)) {
                                    f7112a = RomUtils.ROM_FLYME;
                                } else {
                                    b = "unknown";
                                    f7112a = Build.MANUFACTURER.toUpperCase();
                                }
                            }
                        } else {
                            f7112a = "OnePlus";
                        }
                    } else {
                        f7112a = RomUtils.ROM_MIUI;
                    }
                } else {
                    f7112a = RomUtils.ROM_EMUI;
                }
            } else {
                f7112a = RomUtils.ROM_VIVO;
            }
        } else {
            f7112a = RomUtils.ROM_OPPO;
        }
        return f7112a.contains(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0087 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @SuppressLint({"PrivateApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String b(String str) {
        String str2;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            str2 = (String) cls.getDeclaredMethod("get", String.class).invoke(cls, str);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            str2 = null;
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            str2 = null;
        } catch (NoSuchMethodException e3) {
            e3.printStackTrace();
            str2 = null;
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
            str2 = null;
        }
        if (TextUtils.isEmpty(str2)) {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()), 1024);
                try {
                    try {
                        str2 = bufferedReader.readLine();
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e5) {
                            }
                        }
                    } catch (IOException e6) {
                        e = e6;
                        e.printStackTrace();
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e7) {
                            }
                        }
                        return str2;
                    }
                } catch (Throwable th) {
                    th = th;
                    bufferedReader2 = bufferedReader;
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e8) {
                        }
                    }
                    throw th;
                }
            } catch (IOException e9) {
                e = e9;
                bufferedReader = null;
            } catch (Throwable th2) {
                th = th2;
                if (bufferedReader2 != null) {
                }
                throw th;
            }
        }
        return str2;
    }

    public static boolean b() {
        return a(RomUtils.ROM_FLYME);
    }
}
