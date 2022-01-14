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
    public static String f59795b = "";

    /* renamed from: c  reason: collision with root package name */
    public static String f59796c = null;

    /* renamed from: d  reason: collision with root package name */
    public static String f59797d = "";

    /* renamed from: e  reason: collision with root package name */
    public static String f59798e;

    /* renamed from: f  reason: collision with root package name */
    public static String f59799f;

    /* renamed from: g  reason: collision with root package name */
    public static String f59800g;

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
        return a(g.f55062j);
    }

    public static String g() {
        if (f59798e == null) {
            a("");
        }
        return f59798e;
    }

    public static String h() {
        if (f59799f == null) {
            a("");
        }
        return f59799f;
    }

    public static String i() {
        if (f59796c == null) {
            a("");
        }
        return f59796c;
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
        return "V10".equals(f59800g);
    }

    public static boolean m() {
        p();
        return "V11".equals(f59800g);
    }

    public static boolean n() {
        p();
        return "V12".equals(f59800g);
    }

    public static void o() {
        if (TextUtils.isEmpty(a)) {
            com.ss.android.socialbase.downloader.downloader.c.F();
            a = com.ss.android.socialbase.downloader.constants.e.f59903b;
            f59797d = "ro.build.version." + com.ss.android.socialbase.downloader.constants.e.f59904c + "rom";
            f59795b = "com." + com.ss.android.socialbase.downloader.constants.e.f59904c + ".market";
        }
    }

    public static void p() {
        if (f59800g == null) {
            try {
                f59800g = d("ro.miui.ui.version.name");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            String str = f59800g;
            if (str == null) {
                str = "";
            }
            f59800g = str;
        }
    }

    public static boolean a(String str) {
        o();
        String str2 = f59798e;
        if (str2 != null) {
            return str2.equals(str);
        }
        String d2 = d("ro.miui.ui.version.name");
        f59799f = d2;
        if (!TextUtils.isEmpty(d2)) {
            f59798e = "MIUI";
            f59796c = "com.xiaomi.market";
            f59800g = f59799f;
        } else {
            String d3 = d("ro.build.version.emui");
            f59799f = d3;
            if (!TextUtils.isEmpty(d3)) {
                f59798e = "EMUI";
                f59796c = "com.huawei.appmarket";
            } else {
                String d4 = d(f59797d);
                f59799f = d4;
                if (!TextUtils.isEmpty(d4)) {
                    f59798e = a;
                    if (com.ss.android.socialbase.appdownloader.g.a(f59795b) > -1) {
                        f59796c = f59795b;
                    } else {
                        f59796c = "com.heytap.market";
                    }
                } else {
                    String d5 = d("ro.vivo.os.version");
                    f59799f = d5;
                    if (!TextUtils.isEmpty(d5)) {
                        f59798e = "VIVO";
                        f59796c = "com.bbk.appstore";
                    } else {
                        String d6 = d("ro.smartisan.version");
                        f59799f = d6;
                        if (!TextUtils.isEmpty(d6)) {
                            f59798e = "SMARTISAN";
                            f59796c = "com.smartisanos.appstore";
                        } else {
                            String d7 = d(RomUtils.KEY_VERSION_GIONEE);
                            f59799f = d7;
                            if (!TextUtils.isEmpty(d7)) {
                                f59798e = "QIONEE";
                                f59796c = "com.gionee.aora.market";
                            } else {
                                String d8 = d("ro.lenovo.lvp.version");
                                f59799f = d8;
                                if (!TextUtils.isEmpty(d8)) {
                                    f59798e = "LENOVO";
                                    f59796c = "com.lenovo.leos.appstore";
                                } else if (j().toUpperCase().contains(g.f55062j)) {
                                    f59798e = g.f55062j;
                                    f59796c = "com.sec.android.app.samsungapps";
                                } else if (j().toUpperCase().contains("ZTE")) {
                                    f59798e = "ZTE";
                                    f59796c = "zte.com.market";
                                } else if (j().toUpperCase().contains(RomUtils.ROM_NUBIA)) {
                                    f59798e = RomUtils.ROM_NUBIA;
                                    f59796c = "cn.nubia.neostore";
                                } else if (k().toUpperCase().contains("FLYME")) {
                                    f59798e = "FLYME";
                                    f59796c = "com.meizu.mstore";
                                    f59799f = k();
                                } else if (j().toUpperCase().contains(RomTypeUtil.ROM_ONEPLUS)) {
                                    f59798e = RomTypeUtil.ROM_ONEPLUS;
                                    f59799f = d("ro.rom.version");
                                    if (com.ss.android.socialbase.appdownloader.g.a(f59795b) > -1) {
                                        f59796c = f59795b;
                                    } else {
                                        f59796c = "com.heytap.market";
                                    }
                                } else {
                                    f59798e = j().toUpperCase();
                                    f59796c = "";
                                    f59799f = "";
                                }
                            }
                        }
                    }
                }
            }
        }
        return f59798e.equals(str);
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
