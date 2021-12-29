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
/* loaded from: classes3.dex */
public class d {
    public static String a = null;

    /* renamed from: b  reason: collision with root package name */
    public static String f62141b = "";

    /* renamed from: c  reason: collision with root package name */
    public static String f62142c = null;

    /* renamed from: d  reason: collision with root package name */
    public static String f62143d = "";

    /* renamed from: e  reason: collision with root package name */
    public static String f62144e;

    /* renamed from: f  reason: collision with root package name */
    public static String f62145f;

    /* renamed from: g  reason: collision with root package name */
    public static String f62146g;

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
        return a(g.f57226j);
    }

    public static String g() {
        if (f62144e == null) {
            a("");
        }
        return f62144e;
    }

    public static String h() {
        if (f62145f == null) {
            a("");
        }
        return f62145f;
    }

    public static String i() {
        if (f62142c == null) {
            a("");
        }
        return f62142c;
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
        return "V10".equals(f62146g);
    }

    public static boolean m() {
        p();
        return "V11".equals(f62146g);
    }

    public static boolean n() {
        p();
        return "V12".equals(f62146g);
    }

    public static void o() {
        if (TextUtils.isEmpty(a)) {
            com.ss.android.socialbase.downloader.downloader.c.F();
            a = com.ss.android.socialbase.downloader.constants.e.f62249b;
            f62143d = "ro.build.version." + com.ss.android.socialbase.downloader.constants.e.f62250c + "rom";
            f62141b = "com." + com.ss.android.socialbase.downloader.constants.e.f62250c + ".market";
        }
    }

    public static void p() {
        if (f62146g == null) {
            try {
                f62146g = d("ro.miui.ui.version.name");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            String str = f62146g;
            if (str == null) {
                str = "";
            }
            f62146g = str;
        }
    }

    public static boolean a(String str) {
        o();
        String str2 = f62144e;
        if (str2 != null) {
            return str2.equals(str);
        }
        String d2 = d("ro.miui.ui.version.name");
        f62145f = d2;
        if (!TextUtils.isEmpty(d2)) {
            f62144e = "MIUI";
            f62142c = "com.xiaomi.market";
            f62146g = f62145f;
        } else {
            String d3 = d("ro.build.version.emui");
            f62145f = d3;
            if (!TextUtils.isEmpty(d3)) {
                f62144e = "EMUI";
                f62142c = "com.huawei.appmarket";
            } else {
                String d4 = d(f62143d);
                f62145f = d4;
                if (!TextUtils.isEmpty(d4)) {
                    f62144e = a;
                    if (com.ss.android.socialbase.appdownloader.g.a(f62141b) > -1) {
                        f62142c = f62141b;
                    } else {
                        f62142c = "com.heytap.market";
                    }
                } else {
                    String d5 = d("ro.vivo.os.version");
                    f62145f = d5;
                    if (!TextUtils.isEmpty(d5)) {
                        f62144e = "VIVO";
                        f62142c = "com.bbk.appstore";
                    } else {
                        String d6 = d("ro.smartisan.version");
                        f62145f = d6;
                        if (!TextUtils.isEmpty(d6)) {
                            f62144e = "SMARTISAN";
                            f62142c = "com.smartisanos.appstore";
                        } else {
                            String d7 = d(RomUtils.KEY_VERSION_GIONEE);
                            f62145f = d7;
                            if (!TextUtils.isEmpty(d7)) {
                                f62144e = "QIONEE";
                                f62142c = "com.gionee.aora.market";
                            } else {
                                String d8 = d("ro.lenovo.lvp.version");
                                f62145f = d8;
                                if (!TextUtils.isEmpty(d8)) {
                                    f62144e = "LENOVO";
                                    f62142c = "com.lenovo.leos.appstore";
                                } else if (j().toUpperCase().contains(g.f57226j)) {
                                    f62144e = g.f57226j;
                                    f62142c = "com.sec.android.app.samsungapps";
                                } else if (j().toUpperCase().contains("ZTE")) {
                                    f62144e = "ZTE";
                                    f62142c = "zte.com.market";
                                } else if (j().toUpperCase().contains(RomUtils.ROM_NUBIA)) {
                                    f62144e = RomUtils.ROM_NUBIA;
                                    f62142c = "cn.nubia.neostore";
                                } else if (k().toUpperCase().contains("FLYME")) {
                                    f62144e = "FLYME";
                                    f62142c = "com.meizu.mstore";
                                    f62145f = k();
                                } else if (j().toUpperCase().contains(RomTypeUtil.ROM_ONEPLUS)) {
                                    f62144e = RomTypeUtil.ROM_ONEPLUS;
                                    f62145f = d("ro.rom.version");
                                    if (com.ss.android.socialbase.appdownloader.g.a(f62141b) > -1) {
                                        f62142c = f62141b;
                                    } else {
                                        f62142c = "com.heytap.market";
                                    }
                                } else {
                                    f62144e = j().toUpperCase();
                                    f62142c = "";
                                    f62145f = "";
                                }
                            }
                        }
                    }
                }
            }
        }
        return f62144e.equals(str);
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
