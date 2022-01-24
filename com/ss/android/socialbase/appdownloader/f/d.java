package com.ss.android.socialbase.appdownloader.f;

import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.tbadk.core.util.RomTypeUtil;
import com.kuaishou.weapon.un.g;
import com.ss.android.socialbase.downloader.i.f;
import java.io.BufferedReader;
import java.io.InputStreamReader;
/* loaded from: classes4.dex */
public class d {
    public static String a = null;

    /* renamed from: b  reason: collision with root package name */
    public static String f59840b = "";

    /* renamed from: c  reason: collision with root package name */
    public static String f59841c = null;

    /* renamed from: d  reason: collision with root package name */
    public static String f59842d = "";

    /* renamed from: e  reason: collision with root package name */
    public static String f59843e;

    /* renamed from: f  reason: collision with root package name */
    public static String f59844f;

    /* renamed from: g  reason: collision with root package name */
    public static String f59845g;

    public static boolean a() {
        return a("EMUI");
    }

    public static boolean b() {
        return a("MIUI");
    }

    public static boolean c() {
        return a("VIVO");
    }

    public static boolean d() {
        o();
        return a(a);
    }

    public static boolean e() {
        return a("FLYME");
    }

    public static boolean f() {
        return a(g.f55107j);
    }

    public static String g() {
        if (f59843e == null) {
            a("");
        }
        return f59843e;
    }

    public static String h() {
        if (f59844f == null) {
            a("");
        }
        return f59844f;
    }

    public static String i() {
        if (f59841c == null) {
            a("");
        }
        return f59841c;
    }

    @NonNull
    public static String j() {
        String str = Build.MANUFACTURER;
        return str == null ? "" : str.trim();
    }

    @NonNull
    public static String k() {
        String str = Build.DISPLAY;
        return str == null ? "" : str.trim();
    }

    public static boolean l() {
        p();
        return "V10".equals(f59845g);
    }

    public static boolean m() {
        p();
        return "V11".equals(f59845g);
    }

    public static boolean n() {
        p();
        return "V12".equals(f59845g);
    }

    public static void o() {
        if (TextUtils.isEmpty(a)) {
            com.ss.android.socialbase.downloader.downloader.c.F();
            a = com.ss.android.socialbase.downloader.constants.e.f59948b;
            f59842d = "ro.build.version." + com.ss.android.socialbase.downloader.constants.e.f59949c + "rom";
            f59840b = "com." + com.ss.android.socialbase.downloader.constants.e.f59949c + ".market";
        }
    }

    public static void p() {
        if (f59845g == null) {
            try {
                f59845g = d("ro.miui.ui.version.name");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            String str = f59845g;
            if (str == null) {
                str = "";
            }
            f59845g = str;
        }
    }

    public static boolean a(String str) {
        o();
        String str2 = f59843e;
        if (str2 != null) {
            return str2.equals(str);
        }
        String d2 = d("ro.miui.ui.version.name");
        f59844f = d2;
        if (!TextUtils.isEmpty(d2)) {
            f59843e = "MIUI";
            f59841c = "com.xiaomi.market";
            f59845g = f59844f;
        } else {
            String d3 = d("ro.build.version.emui");
            f59844f = d3;
            if (!TextUtils.isEmpty(d3)) {
                f59843e = "EMUI";
                f59841c = "com.huawei.appmarket";
            } else {
                String d4 = d(f59842d);
                f59844f = d4;
                if (!TextUtils.isEmpty(d4)) {
                    f59843e = a;
                    if (com.ss.android.socialbase.appdownloader.g.a(f59840b) > -1) {
                        f59841c = f59840b;
                    } else {
                        f59841c = "com.heytap.market";
                    }
                } else {
                    String d5 = d("ro.vivo.os.version");
                    f59844f = d5;
                    if (!TextUtils.isEmpty(d5)) {
                        f59843e = "VIVO";
                        f59841c = "com.bbk.appstore";
                    } else {
                        String d6 = d("ro.smartisan.version");
                        f59844f = d6;
                        if (!TextUtils.isEmpty(d6)) {
                            f59843e = "SMARTISAN";
                            f59841c = "com.smartisanos.appstore";
                        } else {
                            String d7 = d(RomUtils.KEY_VERSION_GIONEE);
                            f59844f = d7;
                            if (!TextUtils.isEmpty(d7)) {
                                f59843e = "QIONEE";
                                f59841c = "com.gionee.aora.market";
                            } else {
                                String d8 = d("ro.lenovo.lvp.version");
                                f59844f = d8;
                                if (!TextUtils.isEmpty(d8)) {
                                    f59843e = "LENOVO";
                                    f59841c = "com.lenovo.leos.appstore";
                                } else if (j().toUpperCase().contains(g.f55107j)) {
                                    f59843e = g.f55107j;
                                    f59841c = "com.sec.android.app.samsungapps";
                                } else if (j().toUpperCase().contains("ZTE")) {
                                    f59843e = "ZTE";
                                    f59841c = "zte.com.market";
                                } else if (j().toUpperCase().contains(RomUtils.ROM_NUBIA)) {
                                    f59843e = RomUtils.ROM_NUBIA;
                                    f59841c = "cn.nubia.neostore";
                                } else if (k().toUpperCase().contains("FLYME")) {
                                    f59843e = "FLYME";
                                    f59841c = "com.meizu.mstore";
                                    f59844f = k();
                                } else if (j().toUpperCase().contains(RomTypeUtil.ROM_ONEPLUS)) {
                                    f59843e = RomTypeUtil.ROM_ONEPLUS;
                                    f59844f = d("ro.rom.version");
                                    if (com.ss.android.socialbase.appdownloader.g.a(f59840b) > -1) {
                                        f59841c = f59840b;
                                    } else {
                                        f59841c = "com.heytap.market";
                                    }
                                } else {
                                    f59843e = j().toUpperCase();
                                    f59841c = "";
                                    f59844f = "";
                                }
                            }
                        }
                    }
                }
            }
        }
        return f59843e.equals(str);
    }

    public static String b(String str) {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()), 1024);
        } catch (Throwable unused) {
            bufferedReader = null;
        }
        try {
            String readLine = bufferedReader.readLine();
            bufferedReader.close();
            f.a(bufferedReader);
            return readLine;
        } catch (Throwable unused2) {
            f.a(bufferedReader);
            return null;
        }
    }

    public static String c(String str) throws Throwable {
        return (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, str);
    }

    public static String d(String str) {
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
}
