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
    public static String f67110a = null;

    /* renamed from: b  reason: collision with root package name */
    public static String f67111b = "";

    /* renamed from: c  reason: collision with root package name */
    public static String f67112c = "";

    /* renamed from: d  reason: collision with root package name */
    public static String f67113d;

    /* renamed from: e  reason: collision with root package name */
    public static String f67114e;

    /* renamed from: f  reason: collision with root package name */
    public static String f67115f;

    /* renamed from: g  reason: collision with root package name */
    public static String f67116g;

    public static boolean a() {
        return b("EMUI");
    }

    public static boolean b(String str) {
        p();
        String str2 = f67113d;
        if (str2 != null) {
            return str2.equals(str);
        }
        String c2 = c("ro.miui.ui.version.name");
        f67114e = c2;
        if (!TextUtils.isEmpty(c2)) {
            f67113d = "MIUI";
            f67115f = "com.xiaomi.market";
        } else {
            String c3 = c("ro.build.version.emui");
            f67114e = c3;
            if (!TextUtils.isEmpty(c3)) {
                f67113d = "EMUI";
                f67115f = "com.huawei.appmarket";
            } else {
                String c4 = c(f67111b);
                f67114e = c4;
                if (!TextUtils.isEmpty(c4)) {
                    f67113d = f67110a;
                    if (j.a(f67112c) > -1) {
                        f67115f = f67112c;
                    } else {
                        f67115f = "com.heytap.market";
                    }
                } else {
                    String c5 = c("ro.vivo.os.version");
                    f67114e = c5;
                    if (!TextUtils.isEmpty(c5)) {
                        f67113d = "VIVO";
                        f67115f = "com.bbk.appstore";
                    } else {
                        String c6 = c("ro.smartisan.version");
                        f67114e = c6;
                        if (!TextUtils.isEmpty(c6)) {
                            f67113d = "SMARTISAN";
                            f67115f = "com.smartisanos.appstore";
                        } else {
                            String c7 = c(RomUtils.KEY_VERSION_GIONEE);
                            f67114e = c7;
                            if (!TextUtils.isEmpty(c7)) {
                                f67113d = "QIONEE";
                                f67115f = "com.gionee.aora.market";
                            } else {
                                String c8 = c("ro.lenovo.lvp.version");
                                f67114e = c8;
                                if (!TextUtils.isEmpty(c8)) {
                                    f67113d = "LENOVO";
                                    f67115f = "com.lenovo.leos.appstore";
                                } else if (l().toUpperCase().contains("SAMSUNG")) {
                                    f67113d = "SAMSUNG";
                                    f67115f = "com.sec.android.app.samsungapps";
                                } else if (l().toUpperCase().contains("ZTE")) {
                                    f67113d = "ZTE";
                                    f67115f = "zte.com.market";
                                } else if (l().toLowerCase().contains(RomUtils.ROM_NUBIA)) {
                                    f67113d = RomUtils.ROM_NUBIA;
                                    f67115f = "cn.nubia.neostore";
                                } else {
                                    String str3 = Build.DISPLAY;
                                    f67114e = str3;
                                    if (str3.toUpperCase().contains("FLYME")) {
                                        f67113d = "FLYME";
                                        f67115f = "com.meizu.mstore";
                                    } else {
                                        f67114e = "unknown";
                                        f67113d = Build.MANUFACTURER.toUpperCase();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return f67113d.equals(str);
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
        return b(f67110a);
    }

    public static boolean g() {
        return b("FLYME");
    }

    public static boolean h() {
        return b("SAMSUNG");
    }

    public static String i() {
        if (f67113d == null) {
            b("");
        }
        return f67113d;
    }

    public static String j() {
        if (f67114e == null) {
            b("");
        }
        return f67114e;
    }

    public static String k() {
        if (f67115f == null) {
            b("");
        }
        return f67115f;
    }

    public static final String l() {
        String str = Build.MANUFACTURER;
        return str == null ? "" : str.trim();
    }

    public static boolean m() {
        q();
        return "V10".equals(f67116g);
    }

    public static boolean n() {
        q();
        return "V11".equals(f67116g);
    }

    public static boolean o() {
        q();
        return "V12".equals(f67116g);
    }

    public static void p() {
        if (TextUtils.isEmpty(f67110a)) {
            f67110a = d.o.a.e.b.d.c.f67179b;
            f67111b = "ro.build.version." + d.o.a.e.b.d.c.f67180c + Config.ROM;
            f67112c = "com." + d.o.a.e.b.d.c.f67180c + ".market";
        }
    }

    public static void q() {
        if (f67116g == null) {
            try {
                f67116g = c("ro.miui.ui.version.name");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            String str = f67116g;
            if (str == null) {
                str = "";
            }
            f67116g = str;
        }
    }
}
