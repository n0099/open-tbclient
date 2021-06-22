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
    public static String f71000a = null;

    /* renamed from: b  reason: collision with root package name */
    public static String f71001b = "";

    /* renamed from: c  reason: collision with root package name */
    public static String f71002c = "";

    /* renamed from: d  reason: collision with root package name */
    public static String f71003d;

    /* renamed from: e  reason: collision with root package name */
    public static String f71004e;

    /* renamed from: f  reason: collision with root package name */
    public static String f71005f;

    /* renamed from: g  reason: collision with root package name */
    public static String f71006g;

    public static boolean a() {
        return b("EMUI");
    }

    public static boolean b(String str) {
        p();
        String str2 = f71003d;
        if (str2 != null) {
            return str2.equals(str);
        }
        String c2 = c("ro.miui.ui.version.name");
        f71004e = c2;
        if (!TextUtils.isEmpty(c2)) {
            f71003d = "MIUI";
            f71005f = "com.xiaomi.market";
        } else {
            String c3 = c("ro.build.version.emui");
            f71004e = c3;
            if (!TextUtils.isEmpty(c3)) {
                f71003d = "EMUI";
                f71005f = "com.huawei.appmarket";
            } else {
                String c4 = c(f71001b);
                f71004e = c4;
                if (!TextUtils.isEmpty(c4)) {
                    f71003d = f71000a;
                    if (j.a(f71002c) > -1) {
                        f71005f = f71002c;
                    } else {
                        f71005f = "com.heytap.market";
                    }
                } else {
                    String c5 = c("ro.vivo.os.version");
                    f71004e = c5;
                    if (!TextUtils.isEmpty(c5)) {
                        f71003d = "VIVO";
                        f71005f = "com.bbk.appstore";
                    } else {
                        String c6 = c("ro.smartisan.version");
                        f71004e = c6;
                        if (!TextUtils.isEmpty(c6)) {
                            f71003d = "SMARTISAN";
                            f71005f = "com.smartisanos.appstore";
                        } else {
                            String c7 = c(RomUtils.KEY_VERSION_GIONEE);
                            f71004e = c7;
                            if (!TextUtils.isEmpty(c7)) {
                                f71003d = "QIONEE";
                                f71005f = "com.gionee.aora.market";
                            } else {
                                String c8 = c("ro.lenovo.lvp.version");
                                f71004e = c8;
                                if (!TextUtils.isEmpty(c8)) {
                                    f71003d = "LENOVO";
                                    f71005f = "com.lenovo.leos.appstore";
                                } else if (l().toUpperCase().contains("SAMSUNG")) {
                                    f71003d = "SAMSUNG";
                                    f71005f = "com.sec.android.app.samsungapps";
                                } else if (l().toUpperCase().contains("ZTE")) {
                                    f71003d = "ZTE";
                                    f71005f = "zte.com.market";
                                } else if (l().toLowerCase().contains(RomUtils.ROM_NUBIA)) {
                                    f71003d = RomUtils.ROM_NUBIA;
                                    f71005f = "cn.nubia.neostore";
                                } else {
                                    String str3 = Build.DISPLAY;
                                    f71004e = str3;
                                    if (str3.toUpperCase().contains("FLYME")) {
                                        f71003d = "FLYME";
                                        f71005f = "com.meizu.mstore";
                                    } else {
                                        f71004e = "unknown";
                                        f71003d = Build.MANUFACTURER.toUpperCase();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return f71003d.equals(str);
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
        return b(f71000a);
    }

    public static boolean g() {
        return b("FLYME");
    }

    public static boolean h() {
        return b("SAMSUNG");
    }

    public static String i() {
        if (f71003d == null) {
            b("");
        }
        return f71003d;
    }

    public static String j() {
        if (f71004e == null) {
            b("");
        }
        return f71004e;
    }

    public static String k() {
        if (f71005f == null) {
            b("");
        }
        return f71005f;
    }

    public static final String l() {
        String str = Build.MANUFACTURER;
        return str == null ? "" : str.trim();
    }

    public static boolean m() {
        q();
        return "V10".equals(f71006g);
    }

    public static boolean n() {
        q();
        return "V11".equals(f71006g);
    }

    public static boolean o() {
        q();
        return "V12".equals(f71006g);
    }

    public static void p() {
        if (TextUtils.isEmpty(f71000a)) {
            f71000a = d.o.a.e.b.d.c.f71069b;
            f71001b = "ro.build.version." + d.o.a.e.b.d.c.f71070c + Config.ROM;
            f71002c = "com." + d.o.a.e.b.d.c.f71070c + ".market";
        }
    }

    public static void q() {
        if (f71006g == null) {
            try {
                f71006g = c("ro.miui.ui.version.name");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            String str = f71006g;
            if (str == null) {
                str = "";
            }
            f71006g = str;
        }
    }
}
