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
    public static String f66886a = null;

    /* renamed from: b  reason: collision with root package name */
    public static String f66887b = "";

    /* renamed from: c  reason: collision with root package name */
    public static String f66888c = "";

    /* renamed from: d  reason: collision with root package name */
    public static String f66889d;

    /* renamed from: e  reason: collision with root package name */
    public static String f66890e;

    /* renamed from: f  reason: collision with root package name */
    public static String f66891f;

    /* renamed from: g  reason: collision with root package name */
    public static String f66892g;

    public static boolean a() {
        return b("EMUI");
    }

    public static boolean b(String str) {
        p();
        String str2 = f66889d;
        if (str2 != null) {
            return str2.equals(str);
        }
        String c2 = c("ro.miui.ui.version.name");
        f66890e = c2;
        if (!TextUtils.isEmpty(c2)) {
            f66889d = "MIUI";
            f66891f = "com.xiaomi.market";
        } else {
            String c3 = c("ro.build.version.emui");
            f66890e = c3;
            if (!TextUtils.isEmpty(c3)) {
                f66889d = "EMUI";
                f66891f = "com.huawei.appmarket";
            } else {
                String c4 = c(f66887b);
                f66890e = c4;
                if (!TextUtils.isEmpty(c4)) {
                    f66889d = f66886a;
                    if (j.a(f66888c) > -1) {
                        f66891f = f66888c;
                    } else {
                        f66891f = "com.heytap.market";
                    }
                } else {
                    String c5 = c("ro.vivo.os.version");
                    f66890e = c5;
                    if (!TextUtils.isEmpty(c5)) {
                        f66889d = "VIVO";
                        f66891f = "com.bbk.appstore";
                    } else {
                        String c6 = c("ro.smartisan.version");
                        f66890e = c6;
                        if (!TextUtils.isEmpty(c6)) {
                            f66889d = "SMARTISAN";
                            f66891f = "com.smartisanos.appstore";
                        } else {
                            String c7 = c(RomUtils.KEY_VERSION_GIONEE);
                            f66890e = c7;
                            if (!TextUtils.isEmpty(c7)) {
                                f66889d = "QIONEE";
                                f66891f = "com.gionee.aora.market";
                            } else {
                                String c8 = c("ro.lenovo.lvp.version");
                                f66890e = c8;
                                if (!TextUtils.isEmpty(c8)) {
                                    f66889d = "LENOVO";
                                    f66891f = "com.lenovo.leos.appstore";
                                } else if (l().toUpperCase().contains("SAMSUNG")) {
                                    f66889d = "SAMSUNG";
                                    f66891f = "com.sec.android.app.samsungapps";
                                } else if (l().toUpperCase().contains("ZTE")) {
                                    f66889d = "ZTE";
                                    f66891f = "zte.com.market";
                                } else if (l().toLowerCase().contains(RomUtils.ROM_NUBIA)) {
                                    f66889d = RomUtils.ROM_NUBIA;
                                    f66891f = "cn.nubia.neostore";
                                } else {
                                    String str3 = Build.DISPLAY;
                                    f66890e = str3;
                                    if (str3.toUpperCase().contains("FLYME")) {
                                        f66889d = "FLYME";
                                        f66891f = "com.meizu.mstore";
                                    } else {
                                        f66890e = "unknown";
                                        f66889d = Build.MANUFACTURER.toUpperCase();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return f66889d.equals(str);
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
        return b(f66886a);
    }

    public static boolean g() {
        return b("FLYME");
    }

    public static boolean h() {
        return b("SAMSUNG");
    }

    public static String i() {
        if (f66889d == null) {
            b("");
        }
        return f66889d;
    }

    public static String j() {
        if (f66890e == null) {
            b("");
        }
        return f66890e;
    }

    public static String k() {
        if (f66891f == null) {
            b("");
        }
        return f66891f;
    }

    public static final String l() {
        String str = Build.MANUFACTURER;
        return str == null ? "" : str.trim();
    }

    public static boolean m() {
        q();
        return "V10".equals(f66892g);
    }

    public static boolean n() {
        q();
        return "V11".equals(f66892g);
    }

    public static boolean o() {
        q();
        return "V12".equals(f66892g);
    }

    public static void p() {
        if (TextUtils.isEmpty(f66886a)) {
            f66886a = d.o.a.e.b.d.c.f66954b;
            f66887b = "ro.build.version." + d.o.a.e.b.d.c.f66955c + Config.ROM;
            f66888c = "com." + d.o.a.e.b.d.c.f66955c + ".market";
        }
    }

    public static void q() {
        if (f66892g == null) {
            try {
                f66892g = c("ro.miui.ui.version.name");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            String str = f66892g;
            if (str == null) {
                str = "";
            }
            f66892g = str;
        }
    }
}
