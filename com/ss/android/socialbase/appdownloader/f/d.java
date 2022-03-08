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
/* loaded from: classes8.dex */
public class d {
    public static String a = null;

    /* renamed from: b  reason: collision with root package name */
    public static String f58357b = "";

    /* renamed from: c  reason: collision with root package name */
    public static String f58358c = null;

    /* renamed from: d  reason: collision with root package name */
    public static String f58359d = "";

    /* renamed from: e  reason: collision with root package name */
    public static String f58360e;

    /* renamed from: f  reason: collision with root package name */
    public static String f58361f;

    /* renamed from: g  reason: collision with root package name */
    public static String f58362g;

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
        return a(g.f53624j);
    }

    public static String g() {
        if (f58360e == null) {
            a("");
        }
        return f58360e;
    }

    public static String h() {
        if (f58361f == null) {
            a("");
        }
        return f58361f;
    }

    public static String i() {
        if (f58358c == null) {
            a("");
        }
        return f58358c;
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
        return "V10".equals(f58362g);
    }

    public static boolean m() {
        p();
        return "V11".equals(f58362g);
    }

    public static boolean n() {
        p();
        return "V12".equals(f58362g);
    }

    public static void o() {
        if (TextUtils.isEmpty(a)) {
            com.ss.android.socialbase.downloader.downloader.c.F();
            a = com.ss.android.socialbase.downloader.constants.e.f58465b;
            f58359d = "ro.build.version." + com.ss.android.socialbase.downloader.constants.e.f58466c + "rom";
            f58357b = "com." + com.ss.android.socialbase.downloader.constants.e.f58466c + ".market";
        }
    }

    public static void p() {
        if (f58362g == null) {
            try {
                f58362g = d("ro.miui.ui.version.name");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            String str = f58362g;
            if (str == null) {
                str = "";
            }
            f58362g = str;
        }
    }

    public static boolean a(String str) {
        o();
        String str2 = f58360e;
        if (str2 != null) {
            return str2.equals(str);
        }
        String d2 = d("ro.miui.ui.version.name");
        f58361f = d2;
        if (!TextUtils.isEmpty(d2)) {
            f58360e = "MIUI";
            f58358c = "com.xiaomi.market";
            f58362g = f58361f;
        } else {
            String d3 = d("ro.build.version.emui");
            f58361f = d3;
            if (!TextUtils.isEmpty(d3)) {
                f58360e = "EMUI";
                f58358c = "com.huawei.appmarket";
            } else {
                String d4 = d(f58359d);
                f58361f = d4;
                if (!TextUtils.isEmpty(d4)) {
                    f58360e = a;
                    if (com.ss.android.socialbase.appdownloader.g.a(f58357b) > -1) {
                        f58358c = f58357b;
                    } else {
                        f58358c = "com.heytap.market";
                    }
                } else {
                    String d5 = d("ro.vivo.os.version");
                    f58361f = d5;
                    if (!TextUtils.isEmpty(d5)) {
                        f58360e = "VIVO";
                        f58358c = "com.bbk.appstore";
                    } else {
                        String d6 = d("ro.smartisan.version");
                        f58361f = d6;
                        if (!TextUtils.isEmpty(d6)) {
                            f58360e = "SMARTISAN";
                            f58358c = "com.smartisanos.appstore";
                        } else {
                            String d7 = d(RomUtils.KEY_VERSION_GIONEE);
                            f58361f = d7;
                            if (!TextUtils.isEmpty(d7)) {
                                f58360e = "QIONEE";
                                f58358c = "com.gionee.aora.market";
                            } else {
                                String d8 = d("ro.lenovo.lvp.version");
                                f58361f = d8;
                                if (!TextUtils.isEmpty(d8)) {
                                    f58360e = "LENOVO";
                                    f58358c = "com.lenovo.leos.appstore";
                                } else if (j().toUpperCase().contains(g.f53624j)) {
                                    f58360e = g.f53624j;
                                    f58358c = "com.sec.android.app.samsungapps";
                                } else if (j().toUpperCase().contains("ZTE")) {
                                    f58360e = "ZTE";
                                    f58358c = "zte.com.market";
                                } else if (j().toUpperCase().contains(RomUtils.ROM_NUBIA)) {
                                    f58360e = RomUtils.ROM_NUBIA;
                                    f58358c = "cn.nubia.neostore";
                                } else if (k().toUpperCase().contains("FLYME")) {
                                    f58360e = "FLYME";
                                    f58358c = "com.meizu.mstore";
                                    f58361f = k();
                                } else if (j().toUpperCase().contains(RomTypeUtil.ROM_ONEPLUS)) {
                                    f58360e = RomTypeUtil.ROM_ONEPLUS;
                                    f58361f = d("ro.rom.version");
                                    if (com.ss.android.socialbase.appdownloader.g.a(f58357b) > -1) {
                                        f58358c = f58357b;
                                    } else {
                                        f58358c = "com.heytap.market";
                                    }
                                } else {
                                    f58360e = j().toUpperCase();
                                    f58358c = "";
                                    f58361f = "";
                                }
                            }
                        }
                    }
                }
            }
        }
        return f58360e.equals(str);
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
