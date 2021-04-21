package d.p.a.e.a.h;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.mobstat.Config;
import d.p.a.e.a.j;
import d.p.a.e.b.l.e;
import java.io.BufferedReader;
import java.io.InputStreamReader;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static String f68026a = null;

    /* renamed from: b  reason: collision with root package name */
    public static String f68027b = "";

    /* renamed from: c  reason: collision with root package name */
    public static String f68028c = "";

    /* renamed from: d  reason: collision with root package name */
    public static String f68029d;

    /* renamed from: e  reason: collision with root package name */
    public static String f68030e;

    /* renamed from: f  reason: collision with root package name */
    public static String f68031f;

    /* renamed from: g  reason: collision with root package name */
    public static String f68032g;

    public static boolean a() {
        return b("EMUI");
    }

    public static boolean b(String str) {
        p();
        String str2 = f68029d;
        if (str2 != null) {
            return str2.equals(str);
        }
        String c2 = c("ro.miui.ui.version.name");
        f68030e = c2;
        if (!TextUtils.isEmpty(c2)) {
            f68029d = "MIUI";
            f68031f = "com.xiaomi.market";
        } else {
            String c3 = c("ro.build.version.emui");
            f68030e = c3;
            if (!TextUtils.isEmpty(c3)) {
                f68029d = "EMUI";
                f68031f = "com.huawei.appmarket";
            } else {
                String c4 = c(f68027b);
                f68030e = c4;
                if (!TextUtils.isEmpty(c4)) {
                    f68029d = f68026a;
                    if (j.a(f68028c) > -1) {
                        f68031f = f68028c;
                    } else {
                        f68031f = "com.heytap.market";
                    }
                } else {
                    String c5 = c("ro.vivo.os.version");
                    f68030e = c5;
                    if (!TextUtils.isEmpty(c5)) {
                        f68029d = "VIVO";
                        f68031f = "com.bbk.appstore";
                    } else {
                        String c6 = c("ro.smartisan.version");
                        f68030e = c6;
                        if (!TextUtils.isEmpty(c6)) {
                            f68029d = "SMARTISAN";
                            f68031f = "com.smartisanos.appstore";
                        } else {
                            String c7 = c(RomUtils.KEY_VERSION_GIONEE);
                            f68030e = c7;
                            if (!TextUtils.isEmpty(c7)) {
                                f68029d = "QIONEE";
                                f68031f = "com.gionee.aora.market";
                            } else {
                                String c8 = c("ro.lenovo.lvp.version");
                                f68030e = c8;
                                if (!TextUtils.isEmpty(c8)) {
                                    f68029d = "LENOVO";
                                    f68031f = "com.lenovo.leos.appstore";
                                } else if (l().toUpperCase().contains("SAMSUNG")) {
                                    f68029d = "SAMSUNG";
                                    f68031f = "com.sec.android.app.samsungapps";
                                } else if (l().toUpperCase().contains("ZTE")) {
                                    f68029d = "ZTE";
                                    f68031f = "zte.com.market";
                                } else if (l().toLowerCase().contains(RomUtils.ROM_NUBIA)) {
                                    f68029d = RomUtils.ROM_NUBIA;
                                    f68031f = "cn.nubia.neostore";
                                } else {
                                    String str3 = Build.DISPLAY;
                                    f68030e = str3;
                                    if (str3.toUpperCase().contains("FLYME")) {
                                        f68029d = "FLYME";
                                        f68031f = "com.meizu.mstore";
                                    } else {
                                        f68030e = "unknown";
                                        f68029d = Build.MANUFACTURER.toUpperCase();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return f68029d.equals(str);
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
        return b(f68026a);
    }

    public static boolean g() {
        return b("FLYME");
    }

    public static boolean h() {
        return b("SAMSUNG");
    }

    public static String i() {
        if (f68029d == null) {
            b("");
        }
        return f68029d;
    }

    public static String j() {
        if (f68030e == null) {
            b("");
        }
        return f68030e;
    }

    public static String k() {
        if (f68031f == null) {
            b("");
        }
        return f68031f;
    }

    public static final String l() {
        String str = Build.MANUFACTURER;
        return str == null ? "" : str.trim();
    }

    public static boolean m() {
        q();
        return "V10".equals(f68032g);
    }

    public static boolean n() {
        q();
        return "V11".equals(f68032g);
    }

    public static boolean o() {
        q();
        return "V12".equals(f68032g);
    }

    public static void p() {
        if (TextUtils.isEmpty(f68026a)) {
            f68026a = d.p.a.e.b.d.c.f68094b;
            f68027b = "ro.build.version." + d.p.a.e.b.d.c.f68095c + Config.ROM;
            f68028c = "com." + d.p.a.e.b.d.c.f68095c + ".market";
        }
    }

    public static void q() {
        if (f68032g == null) {
            try {
                f68032g = c("ro.miui.ui.version.name");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            String str = f68032g;
            if (str == null) {
                str = "";
            }
            f68032g = str;
        }
    }
}
