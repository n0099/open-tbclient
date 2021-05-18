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
    public static String f67067a = null;

    /* renamed from: b  reason: collision with root package name */
    public static String f67068b = "";

    /* renamed from: c  reason: collision with root package name */
    public static String f67069c = "";

    /* renamed from: d  reason: collision with root package name */
    public static String f67070d;

    /* renamed from: e  reason: collision with root package name */
    public static String f67071e;

    /* renamed from: f  reason: collision with root package name */
    public static String f67072f;

    /* renamed from: g  reason: collision with root package name */
    public static String f67073g;

    public static boolean a() {
        return b("EMUI");
    }

    public static boolean b(String str) {
        p();
        String str2 = f67070d;
        if (str2 != null) {
            return str2.equals(str);
        }
        String c2 = c("ro.miui.ui.version.name");
        f67071e = c2;
        if (!TextUtils.isEmpty(c2)) {
            f67070d = "MIUI";
            f67072f = "com.xiaomi.market";
        } else {
            String c3 = c("ro.build.version.emui");
            f67071e = c3;
            if (!TextUtils.isEmpty(c3)) {
                f67070d = "EMUI";
                f67072f = "com.huawei.appmarket";
            } else {
                String c4 = c(f67068b);
                f67071e = c4;
                if (!TextUtils.isEmpty(c4)) {
                    f67070d = f67067a;
                    if (j.a(f67069c) > -1) {
                        f67072f = f67069c;
                    } else {
                        f67072f = "com.heytap.market";
                    }
                } else {
                    String c5 = c("ro.vivo.os.version");
                    f67071e = c5;
                    if (!TextUtils.isEmpty(c5)) {
                        f67070d = "VIVO";
                        f67072f = "com.bbk.appstore";
                    } else {
                        String c6 = c("ro.smartisan.version");
                        f67071e = c6;
                        if (!TextUtils.isEmpty(c6)) {
                            f67070d = "SMARTISAN";
                            f67072f = "com.smartisanos.appstore";
                        } else {
                            String c7 = c(RomUtils.KEY_VERSION_GIONEE);
                            f67071e = c7;
                            if (!TextUtils.isEmpty(c7)) {
                                f67070d = "QIONEE";
                                f67072f = "com.gionee.aora.market";
                            } else {
                                String c8 = c("ro.lenovo.lvp.version");
                                f67071e = c8;
                                if (!TextUtils.isEmpty(c8)) {
                                    f67070d = "LENOVO";
                                    f67072f = "com.lenovo.leos.appstore";
                                } else if (l().toUpperCase().contains("SAMSUNG")) {
                                    f67070d = "SAMSUNG";
                                    f67072f = "com.sec.android.app.samsungapps";
                                } else if (l().toUpperCase().contains("ZTE")) {
                                    f67070d = "ZTE";
                                    f67072f = "zte.com.market";
                                } else if (l().toLowerCase().contains(RomUtils.ROM_NUBIA)) {
                                    f67070d = RomUtils.ROM_NUBIA;
                                    f67072f = "cn.nubia.neostore";
                                } else {
                                    String str3 = Build.DISPLAY;
                                    f67071e = str3;
                                    if (str3.toUpperCase().contains("FLYME")) {
                                        f67070d = "FLYME";
                                        f67072f = "com.meizu.mstore";
                                    } else {
                                        f67071e = "unknown";
                                        f67070d = Build.MANUFACTURER.toUpperCase();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return f67070d.equals(str);
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
        return b(f67067a);
    }

    public static boolean g() {
        return b("FLYME");
    }

    public static boolean h() {
        return b("SAMSUNG");
    }

    public static String i() {
        if (f67070d == null) {
            b("");
        }
        return f67070d;
    }

    public static String j() {
        if (f67071e == null) {
            b("");
        }
        return f67071e;
    }

    public static String k() {
        if (f67072f == null) {
            b("");
        }
        return f67072f;
    }

    public static final String l() {
        String str = Build.MANUFACTURER;
        return str == null ? "" : str.trim();
    }

    public static boolean m() {
        q();
        return "V10".equals(f67073g);
    }

    public static boolean n() {
        q();
        return "V11".equals(f67073g);
    }

    public static boolean o() {
        q();
        return "V12".equals(f67073g);
    }

    public static void p() {
        if (TextUtils.isEmpty(f67067a)) {
            f67067a = d.o.a.e.b.d.c.f67136b;
            f67068b = "ro.build.version." + d.o.a.e.b.d.c.f67137c + Config.ROM;
            f67069c = "com." + d.o.a.e.b.d.c.f67137c + ".market";
        }
    }

    public static void q() {
        if (f67073g == null) {
            try {
                f67073g = c("ro.miui.ui.version.name");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            String str = f67073g;
            if (str == null) {
                str = "";
            }
            f67073g = str;
        }
    }
}
