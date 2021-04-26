package d.o.a.e.a.h;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.mobstat.Config;
import d.o.a.e.a.j;
import d.o.a.e.b.l.e;
import java.io.BufferedReader;
import java.io.InputStreamReader;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static String f66381a = null;

    /* renamed from: b  reason: collision with root package name */
    public static String f66382b = "";

    /* renamed from: c  reason: collision with root package name */
    public static String f66383c = "";

    /* renamed from: d  reason: collision with root package name */
    public static String f66384d;

    /* renamed from: e  reason: collision with root package name */
    public static String f66385e;

    /* renamed from: f  reason: collision with root package name */
    public static String f66386f;

    /* renamed from: g  reason: collision with root package name */
    public static String f66387g;

    public static boolean a() {
        return b("EMUI");
    }

    public static boolean b(String str) {
        p();
        String str2 = f66384d;
        if (str2 != null) {
            return str2.equals(str);
        }
        String c2 = c("ro.miui.ui.version.name");
        f66385e = c2;
        if (!TextUtils.isEmpty(c2)) {
            f66384d = "MIUI";
            f66386f = "com.xiaomi.market";
        } else {
            String c3 = c("ro.build.version.emui");
            f66385e = c3;
            if (!TextUtils.isEmpty(c3)) {
                f66384d = "EMUI";
                f66386f = "com.huawei.appmarket";
            } else {
                String c4 = c(f66382b);
                f66385e = c4;
                if (!TextUtils.isEmpty(c4)) {
                    f66384d = f66381a;
                    if (j.a(f66383c) > -1) {
                        f66386f = f66383c;
                    } else {
                        f66386f = "com.heytap.market";
                    }
                } else {
                    String c5 = c("ro.vivo.os.version");
                    f66385e = c5;
                    if (!TextUtils.isEmpty(c5)) {
                        f66384d = "VIVO";
                        f66386f = "com.bbk.appstore";
                    } else {
                        String c6 = c("ro.smartisan.version");
                        f66385e = c6;
                        if (!TextUtils.isEmpty(c6)) {
                            f66384d = "SMARTISAN";
                            f66386f = "com.smartisanos.appstore";
                        } else {
                            String c7 = c(RomUtils.KEY_VERSION_GIONEE);
                            f66385e = c7;
                            if (!TextUtils.isEmpty(c7)) {
                                f66384d = "QIONEE";
                                f66386f = "com.gionee.aora.market";
                            } else {
                                String c8 = c("ro.lenovo.lvp.version");
                                f66385e = c8;
                                if (!TextUtils.isEmpty(c8)) {
                                    f66384d = "LENOVO";
                                    f66386f = "com.lenovo.leos.appstore";
                                } else if (l().toUpperCase().contains("SAMSUNG")) {
                                    f66384d = "SAMSUNG";
                                    f66386f = "com.sec.android.app.samsungapps";
                                } else if (l().toUpperCase().contains("ZTE")) {
                                    f66384d = "ZTE";
                                    f66386f = "zte.com.market";
                                } else if (l().toLowerCase().contains(RomUtils.ROM_NUBIA)) {
                                    f66384d = RomUtils.ROM_NUBIA;
                                    f66386f = "cn.nubia.neostore";
                                } else {
                                    String str3 = Build.DISPLAY;
                                    f66385e = str3;
                                    if (str3.toUpperCase().contains("FLYME")) {
                                        f66384d = "FLYME";
                                        f66386f = "com.meizu.mstore";
                                    } else {
                                        f66385e = "unknown";
                                        f66384d = Build.MANUFACTURER.toUpperCase();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return f66384d.equals(str);
    }

    public static String c(String str) {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()), 1024);
        } catch (Throwable unused) {
            bufferedReader = null;
        }
        try {
            String readLine = bufferedReader.readLine();
            bufferedReader.close();
            e.C(bufferedReader);
            return readLine;
        } catch (Throwable unused2) {
            e.C(bufferedReader);
            return null;
        }
    }

    public static boolean d() {
        return b("MIUI");
    }

    public static boolean e() {
        return b("VIVO");
    }

    public static boolean f() {
        p();
        return b(f66381a);
    }

    public static boolean g() {
        return b("FLYME");
    }

    public static boolean h() {
        return b("SAMSUNG");
    }

    public static String i() {
        if (f66384d == null) {
            b("");
        }
        return f66384d;
    }

    public static String j() {
        if (f66385e == null) {
            b("");
        }
        return f66385e;
    }

    public static String k() {
        if (f66386f == null) {
            b("");
        }
        return f66386f;
    }

    public static final String l() {
        String str = Build.MANUFACTURER;
        return str == null ? "" : str.trim();
    }

    public static boolean m() {
        q();
        return "V10".equals(f66387g);
    }

    public static boolean n() {
        q();
        return "V11".equals(f66387g);
    }

    public static boolean o() {
        q();
        return "V12".equals(f66387g);
    }

    public static void p() {
        if (TextUtils.isEmpty(f66381a)) {
            f66381a = d.o.a.e.b.d.c.f66450b;
            f66382b = "ro.build.version." + d.o.a.e.b.d.c.f66451c + Config.ROM;
            f66383c = "com." + d.o.a.e.b.d.c.f66451c + ".market";
        }
    }

    public static void q() {
        if (f66387g == null) {
            try {
                f66387g = c("ro.miui.ui.version.name");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            String str = f66387g;
            if (str == null) {
                str = "";
            }
            f66387g = str;
        }
    }
}
