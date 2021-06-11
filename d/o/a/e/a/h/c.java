package d.o.a.e.a.h;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.mobstat.Config;
import d.o.a.e.a.j;
import d.o.a.e.b.l.e;
import java.io.BufferedReader;
import java.io.InputStreamReader;
/* loaded from: classes7.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static String f70896a = null;

    /* renamed from: b  reason: collision with root package name */
    public static String f70897b = "";

    /* renamed from: c  reason: collision with root package name */
    public static String f70898c = "";

    /* renamed from: d  reason: collision with root package name */
    public static String f70899d;

    /* renamed from: e  reason: collision with root package name */
    public static String f70900e;

    /* renamed from: f  reason: collision with root package name */
    public static String f70901f;

    /* renamed from: g  reason: collision with root package name */
    public static String f70902g;

    public static boolean a() {
        return b("EMUI");
    }

    public static boolean b(String str) {
        p();
        String str2 = f70899d;
        if (str2 != null) {
            return str2.equals(str);
        }
        String c2 = c("ro.miui.ui.version.name");
        f70900e = c2;
        if (!TextUtils.isEmpty(c2)) {
            f70899d = "MIUI";
            f70901f = "com.xiaomi.market";
        } else {
            String c3 = c("ro.build.version.emui");
            f70900e = c3;
            if (!TextUtils.isEmpty(c3)) {
                f70899d = "EMUI";
                f70901f = "com.huawei.appmarket";
            } else {
                String c4 = c(f70897b);
                f70900e = c4;
                if (!TextUtils.isEmpty(c4)) {
                    f70899d = f70896a;
                    if (j.a(f70898c) > -1) {
                        f70901f = f70898c;
                    } else {
                        f70901f = "com.heytap.market";
                    }
                } else {
                    String c5 = c("ro.vivo.os.version");
                    f70900e = c5;
                    if (!TextUtils.isEmpty(c5)) {
                        f70899d = "VIVO";
                        f70901f = "com.bbk.appstore";
                    } else {
                        String c6 = c("ro.smartisan.version");
                        f70900e = c6;
                        if (!TextUtils.isEmpty(c6)) {
                            f70899d = "SMARTISAN";
                            f70901f = "com.smartisanos.appstore";
                        } else {
                            String c7 = c(RomUtils.KEY_VERSION_GIONEE);
                            f70900e = c7;
                            if (!TextUtils.isEmpty(c7)) {
                                f70899d = "QIONEE";
                                f70901f = "com.gionee.aora.market";
                            } else {
                                String c8 = c("ro.lenovo.lvp.version");
                                f70900e = c8;
                                if (!TextUtils.isEmpty(c8)) {
                                    f70899d = "LENOVO";
                                    f70901f = "com.lenovo.leos.appstore";
                                } else if (l().toUpperCase().contains("SAMSUNG")) {
                                    f70899d = "SAMSUNG";
                                    f70901f = "com.sec.android.app.samsungapps";
                                } else if (l().toUpperCase().contains("ZTE")) {
                                    f70899d = "ZTE";
                                    f70901f = "zte.com.market";
                                } else if (l().toLowerCase().contains(RomUtils.ROM_NUBIA)) {
                                    f70899d = RomUtils.ROM_NUBIA;
                                    f70901f = "cn.nubia.neostore";
                                } else {
                                    String str3 = Build.DISPLAY;
                                    f70900e = str3;
                                    if (str3.toUpperCase().contains("FLYME")) {
                                        f70899d = "FLYME";
                                        f70901f = "com.meizu.mstore";
                                    } else {
                                        f70900e = "unknown";
                                        f70899d = Build.MANUFACTURER.toUpperCase();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return f70899d.equals(str);
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
        return b(f70896a);
    }

    public static boolean g() {
        return b("FLYME");
    }

    public static boolean h() {
        return b("SAMSUNG");
    }

    public static String i() {
        if (f70899d == null) {
            b("");
        }
        return f70899d;
    }

    public static String j() {
        if (f70900e == null) {
            b("");
        }
        return f70900e;
    }

    public static String k() {
        if (f70901f == null) {
            b("");
        }
        return f70901f;
    }

    public static final String l() {
        String str = Build.MANUFACTURER;
        return str == null ? "" : str.trim();
    }

    public static boolean m() {
        q();
        return "V10".equals(f70902g);
    }

    public static boolean n() {
        q();
        return "V11".equals(f70902g);
    }

    public static boolean o() {
        q();
        return "V12".equals(f70902g);
    }

    public static void p() {
        if (TextUtils.isEmpty(f70896a)) {
            f70896a = d.o.a.e.b.d.c.f70965b;
            f70897b = "ro.build.version." + d.o.a.e.b.d.c.f70966c + Config.ROM;
            f70898c = "com." + d.o.a.e.b.d.c.f70966c + ".market";
        }
    }

    public static void q() {
        if (f70902g == null) {
            try {
                f70902g = c("ro.miui.ui.version.name");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            String str = f70902g;
            if (str == null) {
                str = "";
            }
            f70902g = str;
        }
    }
}
