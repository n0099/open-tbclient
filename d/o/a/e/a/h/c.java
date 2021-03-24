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
    public static String f66881a = null;

    /* renamed from: b  reason: collision with root package name */
    public static String f66882b = "";

    /* renamed from: c  reason: collision with root package name */
    public static String f66883c = "";

    /* renamed from: d  reason: collision with root package name */
    public static String f66884d;

    /* renamed from: e  reason: collision with root package name */
    public static String f66885e;

    /* renamed from: f  reason: collision with root package name */
    public static String f66886f;

    /* renamed from: g  reason: collision with root package name */
    public static String f66887g;

    public static boolean a() {
        return b("EMUI");
    }

    public static boolean b(String str) {
        p();
        String str2 = f66884d;
        if (str2 != null) {
            return str2.equals(str);
        }
        String c2 = c("ro.miui.ui.version.name");
        f66885e = c2;
        if (!TextUtils.isEmpty(c2)) {
            f66884d = "MIUI";
            f66886f = "com.xiaomi.market";
        } else {
            String c3 = c("ro.build.version.emui");
            f66885e = c3;
            if (!TextUtils.isEmpty(c3)) {
                f66884d = "EMUI";
                f66886f = "com.huawei.appmarket";
            } else {
                String c4 = c(f66882b);
                f66885e = c4;
                if (!TextUtils.isEmpty(c4)) {
                    f66884d = f66881a;
                    if (j.a(f66883c) > -1) {
                        f66886f = f66883c;
                    } else {
                        f66886f = "com.heytap.market";
                    }
                } else {
                    String c5 = c("ro.vivo.os.version");
                    f66885e = c5;
                    if (!TextUtils.isEmpty(c5)) {
                        f66884d = "VIVO";
                        f66886f = "com.bbk.appstore";
                    } else {
                        String c6 = c("ro.smartisan.version");
                        f66885e = c6;
                        if (!TextUtils.isEmpty(c6)) {
                            f66884d = "SMARTISAN";
                            f66886f = "com.smartisanos.appstore";
                        } else {
                            String c7 = c(RomUtils.KEY_VERSION_GIONEE);
                            f66885e = c7;
                            if (!TextUtils.isEmpty(c7)) {
                                f66884d = "QIONEE";
                                f66886f = "com.gionee.aora.market";
                            } else {
                                String c8 = c("ro.lenovo.lvp.version");
                                f66885e = c8;
                                if (!TextUtils.isEmpty(c8)) {
                                    f66884d = "LENOVO";
                                    f66886f = "com.lenovo.leos.appstore";
                                } else if (l().toUpperCase().contains("SAMSUNG")) {
                                    f66884d = "SAMSUNG";
                                    f66886f = "com.sec.android.app.samsungapps";
                                } else if (l().toUpperCase().contains("ZTE")) {
                                    f66884d = "ZTE";
                                    f66886f = "zte.com.market";
                                } else if (l().toLowerCase().contains(RomUtils.ROM_NUBIA)) {
                                    f66884d = RomUtils.ROM_NUBIA;
                                    f66886f = "cn.nubia.neostore";
                                } else {
                                    String str3 = Build.DISPLAY;
                                    f66885e = str3;
                                    if (str3.toUpperCase().contains("FLYME")) {
                                        f66884d = "FLYME";
                                        f66886f = "com.meizu.mstore";
                                    } else {
                                        f66885e = "unknown";
                                        f66884d = Build.MANUFACTURER.toUpperCase();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return f66884d.equals(str);
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
        return b(f66881a);
    }

    public static boolean g() {
        return b("FLYME");
    }

    public static boolean h() {
        return b("SAMSUNG");
    }

    public static String i() {
        if (f66884d == null) {
            b("");
        }
        return f66884d;
    }

    public static String j() {
        if (f66885e == null) {
            b("");
        }
        return f66885e;
    }

    public static String k() {
        if (f66886f == null) {
            b("");
        }
        return f66886f;
    }

    public static final String l() {
        String str = Build.MANUFACTURER;
        return str == null ? "" : str.trim();
    }

    public static boolean m() {
        q();
        return "V10".equals(f66887g);
    }

    public static boolean n() {
        q();
        return "V11".equals(f66887g);
    }

    public static boolean o() {
        q();
        return "V12".equals(f66887g);
    }

    public static void p() {
        if (TextUtils.isEmpty(f66881a)) {
            f66881a = d.o.a.e.b.d.c.f66949b;
            f66882b = "ro.build.version." + d.o.a.e.b.d.c.f66950c + Config.ROM;
            f66883c = "com." + d.o.a.e.b.d.c.f66950c + ".market";
        }
    }

    public static void q() {
        if (f66887g == null) {
            try {
                f66887g = c("ro.miui.ui.version.name");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            String str = f66887g;
            if (str == null) {
                str = "";
            }
            f66887g = str;
        }
    }
}
