package com.ss.android.socialbase.appdownloader.f;

import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.mobstat.Config;
import com.baidu.sofire.sharedpreferences.SharedPreferenceManager;
import com.baidu.tbadk.core.util.RomTypeUtil;
import com.kuaishou.weapon.un.g;
import com.ss.android.socialbase.downloader.i.f;
import java.io.BufferedReader;
import java.io.InputStreamReader;
/* loaded from: classes7.dex */
public class d {
    public static String a = null;

    /* renamed from: b  reason: collision with root package name */
    public static String f43090b = "";

    /* renamed from: c  reason: collision with root package name */
    public static String f43091c = null;

    /* renamed from: d  reason: collision with root package name */
    public static String f43092d = "";

    /* renamed from: e  reason: collision with root package name */
    public static String f43093e;

    /* renamed from: f  reason: collision with root package name */
    public static String f43094f;

    /* renamed from: g  reason: collision with root package name */
    public static String f43095g;

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
        return a(g.j);
    }

    public static String g() {
        if (f43093e == null) {
            a("");
        }
        return f43093e;
    }

    public static String h() {
        if (f43094f == null) {
            a("");
        }
        return f43094f;
    }

    public static String i() {
        if (f43091c == null) {
            a("");
        }
        return f43091c;
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
        return "V10".equals(f43095g);
    }

    public static boolean m() {
        p();
        return "V11".equals(f43095g);
    }

    public static boolean n() {
        p();
        return "V12".equals(f43095g);
    }

    public static void o() {
        if (TextUtils.isEmpty(a)) {
            com.ss.android.socialbase.downloader.downloader.c.F();
            a = com.ss.android.socialbase.downloader.constants.e.f43196b;
            f43092d = "ro.build.version." + com.ss.android.socialbase.downloader.constants.e.f43197c + Config.ROM;
            f43090b = "com." + com.ss.android.socialbase.downloader.constants.e.f43197c + ".market";
        }
    }

    public static void p() {
        if (f43095g == null) {
            try {
                f43095g = d("ro.miui.ui.version.name");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            String str = f43095g;
            if (str == null) {
                str = "";
            }
            f43095g = str;
        }
    }

    public static boolean a(String str) {
        o();
        String str2 = f43093e;
        if (str2 != null) {
            return str2.equals(str);
        }
        String d2 = d("ro.miui.ui.version.name");
        f43094f = d2;
        if (!TextUtils.isEmpty(d2)) {
            f43093e = "MIUI";
            f43091c = "com.xiaomi.market";
            f43095g = f43094f;
        } else {
            String d3 = d("ro.build.version.emui");
            f43094f = d3;
            if (!TextUtils.isEmpty(d3)) {
                f43093e = "EMUI";
                f43091c = "com.huawei.appmarket";
            } else {
                String d4 = d(f43092d);
                f43094f = d4;
                if (!TextUtils.isEmpty(d4)) {
                    f43093e = a;
                    if (com.ss.android.socialbase.appdownloader.g.a(f43090b) > -1) {
                        f43091c = f43090b;
                    } else {
                        f43091c = "com.heytap.market";
                    }
                } else {
                    String d5 = d("ro.vivo.os.version");
                    f43094f = d5;
                    if (!TextUtils.isEmpty(d5)) {
                        f43093e = "VIVO";
                        f43091c = "com.bbk.appstore";
                    } else {
                        String d6 = d("ro.smartisan.version");
                        f43094f = d6;
                        if (!TextUtils.isEmpty(d6)) {
                            f43093e = "SMARTISAN";
                            f43091c = "com.smartisanos.appstore";
                        } else {
                            String d7 = d(RomUtils.KEY_VERSION_GIONEE);
                            f43094f = d7;
                            if (!TextUtils.isEmpty(d7)) {
                                f43093e = "QIONEE";
                                f43091c = "com.gionee.aora.market";
                            } else {
                                String d8 = d("ro.lenovo.lvp.version");
                                f43094f = d8;
                                if (!TextUtils.isEmpty(d8)) {
                                    f43093e = "LENOVO";
                                    f43091c = "com.lenovo.leos.appstore";
                                } else if (j().toUpperCase().contains(g.j)) {
                                    f43093e = g.j;
                                    f43091c = "com.sec.android.app.samsungapps";
                                } else if (j().toUpperCase().contains("ZTE")) {
                                    f43093e = "ZTE";
                                    f43091c = "zte.com.market";
                                } else if (j().toUpperCase().contains(RomUtils.ROM_NUBIA)) {
                                    f43093e = RomUtils.ROM_NUBIA;
                                    f43091c = "cn.nubia.neostore";
                                } else if (k().toUpperCase().contains("FLYME")) {
                                    f43093e = "FLYME";
                                    f43091c = "com.meizu.mstore";
                                    f43094f = k();
                                } else if (j().toUpperCase().contains(RomTypeUtil.ROM_ONEPLUS)) {
                                    f43093e = RomTypeUtil.ROM_ONEPLUS;
                                    f43094f = d("ro.rom.version");
                                    if (com.ss.android.socialbase.appdownloader.g.a(f43090b) > -1) {
                                        f43091c = f43090b;
                                    } else {
                                        f43091c = "com.heytap.market";
                                    }
                                } else {
                                    f43093e = j().toUpperCase();
                                    f43091c = "";
                                    f43094f = "";
                                }
                            }
                        }
                    }
                }
            }
        }
        return f43093e.equals(str);
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
        return (String) Class.forName("android.os.SystemProperties").getMethod(SharedPreferenceManager.OPERATION_GET_PERFIX, String.class).invoke(null, str);
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
