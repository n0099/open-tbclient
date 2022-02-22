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
    public static String f60007b = "";

    /* renamed from: c  reason: collision with root package name */
    public static String f60008c = null;

    /* renamed from: d  reason: collision with root package name */
    public static String f60009d = "";

    /* renamed from: e  reason: collision with root package name */
    public static String f60010e;

    /* renamed from: f  reason: collision with root package name */
    public static String f60011f;

    /* renamed from: g  reason: collision with root package name */
    public static String f60012g;

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
        return a(g.f55274j);
    }

    public static String g() {
        if (f60010e == null) {
            a("");
        }
        return f60010e;
    }

    public static String h() {
        if (f60011f == null) {
            a("");
        }
        return f60011f;
    }

    public static String i() {
        if (f60008c == null) {
            a("");
        }
        return f60008c;
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
        return "V10".equals(f60012g);
    }

    public static boolean m() {
        p();
        return "V11".equals(f60012g);
    }

    public static boolean n() {
        p();
        return "V12".equals(f60012g);
    }

    public static void o() {
        if (TextUtils.isEmpty(a)) {
            com.ss.android.socialbase.downloader.downloader.c.F();
            a = com.ss.android.socialbase.downloader.constants.e.f60115b;
            f60009d = "ro.build.version." + com.ss.android.socialbase.downloader.constants.e.f60116c + "rom";
            f60007b = "com." + com.ss.android.socialbase.downloader.constants.e.f60116c + ".market";
        }
    }

    public static void p() {
        if (f60012g == null) {
            try {
                f60012g = d("ro.miui.ui.version.name");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            String str = f60012g;
            if (str == null) {
                str = "";
            }
            f60012g = str;
        }
    }

    public static boolean a(String str) {
        o();
        String str2 = f60010e;
        if (str2 != null) {
            return str2.equals(str);
        }
        String d2 = d("ro.miui.ui.version.name");
        f60011f = d2;
        if (!TextUtils.isEmpty(d2)) {
            f60010e = "MIUI";
            f60008c = "com.xiaomi.market";
            f60012g = f60011f;
        } else {
            String d3 = d("ro.build.version.emui");
            f60011f = d3;
            if (!TextUtils.isEmpty(d3)) {
                f60010e = "EMUI";
                f60008c = "com.huawei.appmarket";
            } else {
                String d4 = d(f60009d);
                f60011f = d4;
                if (!TextUtils.isEmpty(d4)) {
                    f60010e = a;
                    if (com.ss.android.socialbase.appdownloader.g.a(f60007b) > -1) {
                        f60008c = f60007b;
                    } else {
                        f60008c = "com.heytap.market";
                    }
                } else {
                    String d5 = d("ro.vivo.os.version");
                    f60011f = d5;
                    if (!TextUtils.isEmpty(d5)) {
                        f60010e = "VIVO";
                        f60008c = "com.bbk.appstore";
                    } else {
                        String d6 = d("ro.smartisan.version");
                        f60011f = d6;
                        if (!TextUtils.isEmpty(d6)) {
                            f60010e = "SMARTISAN";
                            f60008c = "com.smartisanos.appstore";
                        } else {
                            String d7 = d(RomUtils.KEY_VERSION_GIONEE);
                            f60011f = d7;
                            if (!TextUtils.isEmpty(d7)) {
                                f60010e = "QIONEE";
                                f60008c = "com.gionee.aora.market";
                            } else {
                                String d8 = d("ro.lenovo.lvp.version");
                                f60011f = d8;
                                if (!TextUtils.isEmpty(d8)) {
                                    f60010e = "LENOVO";
                                    f60008c = "com.lenovo.leos.appstore";
                                } else if (j().toUpperCase().contains(g.f55274j)) {
                                    f60010e = g.f55274j;
                                    f60008c = "com.sec.android.app.samsungapps";
                                } else if (j().toUpperCase().contains("ZTE")) {
                                    f60010e = "ZTE";
                                    f60008c = "zte.com.market";
                                } else if (j().toUpperCase().contains(RomUtils.ROM_NUBIA)) {
                                    f60010e = RomUtils.ROM_NUBIA;
                                    f60008c = "cn.nubia.neostore";
                                } else if (k().toUpperCase().contains("FLYME")) {
                                    f60010e = "FLYME";
                                    f60008c = "com.meizu.mstore";
                                    f60011f = k();
                                } else if (j().toUpperCase().contains(RomTypeUtil.ROM_ONEPLUS)) {
                                    f60010e = RomTypeUtil.ROM_ONEPLUS;
                                    f60011f = d("ro.rom.version");
                                    if (com.ss.android.socialbase.appdownloader.g.a(f60007b) > -1) {
                                        f60008c = f60007b;
                                    } else {
                                        f60008c = "com.heytap.market";
                                    }
                                } else {
                                    f60010e = j().toUpperCase();
                                    f60008c = "";
                                    f60011f = "";
                                }
                            }
                        }
                    }
                }
            }
        }
        return f60010e.equals(str);
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
