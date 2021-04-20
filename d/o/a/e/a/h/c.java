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
    public static String f67879a = null;

    /* renamed from: b  reason: collision with root package name */
    public static String f67880b = "";

    /* renamed from: c  reason: collision with root package name */
    public static String f67881c = "";

    /* renamed from: d  reason: collision with root package name */
    public static String f67882d;

    /* renamed from: e  reason: collision with root package name */
    public static String f67883e;

    /* renamed from: f  reason: collision with root package name */
    public static String f67884f;

    /* renamed from: g  reason: collision with root package name */
    public static String f67885g;

    public static boolean a() {
        return b("EMUI");
    }

    public static boolean b(String str) {
        p();
        String str2 = f67882d;
        if (str2 != null) {
            return str2.equals(str);
        }
        String c2 = c("ro.miui.ui.version.name");
        f67883e = c2;
        if (!TextUtils.isEmpty(c2)) {
            f67882d = "MIUI";
            f67884f = "com.xiaomi.market";
        } else {
            String c3 = c("ro.build.version.emui");
            f67883e = c3;
            if (!TextUtils.isEmpty(c3)) {
                f67882d = "EMUI";
                f67884f = "com.huawei.appmarket";
            } else {
                String c4 = c(f67880b);
                f67883e = c4;
                if (!TextUtils.isEmpty(c4)) {
                    f67882d = f67879a;
                    if (j.a(f67881c) > -1) {
                        f67884f = f67881c;
                    } else {
                        f67884f = "com.heytap.market";
                    }
                } else {
                    String c5 = c("ro.vivo.os.version");
                    f67883e = c5;
                    if (!TextUtils.isEmpty(c5)) {
                        f67882d = "VIVO";
                        f67884f = "com.bbk.appstore";
                    } else {
                        String c6 = c("ro.smartisan.version");
                        f67883e = c6;
                        if (!TextUtils.isEmpty(c6)) {
                            f67882d = "SMARTISAN";
                            f67884f = "com.smartisanos.appstore";
                        } else {
                            String c7 = c(RomUtils.KEY_VERSION_GIONEE);
                            f67883e = c7;
                            if (!TextUtils.isEmpty(c7)) {
                                f67882d = "QIONEE";
                                f67884f = "com.gionee.aora.market";
                            } else {
                                String c8 = c("ro.lenovo.lvp.version");
                                f67883e = c8;
                                if (!TextUtils.isEmpty(c8)) {
                                    f67882d = "LENOVO";
                                    f67884f = "com.lenovo.leos.appstore";
                                } else if (l().toUpperCase().contains("SAMSUNG")) {
                                    f67882d = "SAMSUNG";
                                    f67884f = "com.sec.android.app.samsungapps";
                                } else if (l().toUpperCase().contains("ZTE")) {
                                    f67882d = "ZTE";
                                    f67884f = "zte.com.market";
                                } else if (l().toLowerCase().contains(RomUtils.ROM_NUBIA)) {
                                    f67882d = RomUtils.ROM_NUBIA;
                                    f67884f = "cn.nubia.neostore";
                                } else {
                                    String str3 = Build.DISPLAY;
                                    f67883e = str3;
                                    if (str3.toUpperCase().contains("FLYME")) {
                                        f67882d = "FLYME";
                                        f67884f = "com.meizu.mstore";
                                    } else {
                                        f67883e = "unknown";
                                        f67882d = Build.MANUFACTURER.toUpperCase();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return f67882d.equals(str);
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
        return b(f67879a);
    }

    public static boolean g() {
        return b("FLYME");
    }

    public static boolean h() {
        return b("SAMSUNG");
    }

    public static String i() {
        if (f67882d == null) {
            b("");
        }
        return f67882d;
    }

    public static String j() {
        if (f67883e == null) {
            b("");
        }
        return f67883e;
    }

    public static String k() {
        if (f67884f == null) {
            b("");
        }
        return f67884f;
    }

    public static final String l() {
        String str = Build.MANUFACTURER;
        return str == null ? "" : str.trim();
    }

    public static boolean m() {
        q();
        return "V10".equals(f67885g);
    }

    public static boolean n() {
        q();
        return "V11".equals(f67885g);
    }

    public static boolean o() {
        q();
        return "V12".equals(f67885g);
    }

    public static void p() {
        if (TextUtils.isEmpty(f67879a)) {
            f67879a = d.o.a.e.b.d.c.f67947b;
            f67880b = "ro.build.version." + d.o.a.e.b.d.c.f67948c + Config.ROM;
            f67881c = "com." + d.o.a.e.b.d.c.f67948c + ".market";
        }
    }

    public static void q() {
        if (f67885g == null) {
            try {
                f67885g = c("ro.miui.ui.version.name");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            String str = f67885g;
            if (str == null) {
                str = "";
            }
            f67885g = str;
        }
    }
}
