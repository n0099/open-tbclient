package com.ss.android.socialbase.appdownloader.f;

import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.util.RomTypeUtil;
import com.ss.android.socialbase.downloader.i.f;
import java.io.BufferedReader;
import java.io.InputStreamReader;
/* loaded from: classes8.dex */
public class d {
    public static String a = null;
    public static String b = "";
    public static String c = null;
    public static String d = "";
    public static String e;
    public static String f;
    public static String g;

    public static boolean a() {
        return a("EMUI");
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x005b, code lost:
        if (com.ss.android.socialbase.appdownloader.g.a(com.ss.android.socialbase.appdownloader.f.d.b) > (-1)) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x005d, code lost:
        r0 = com.ss.android.socialbase.appdownloader.f.d.b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0060, code lost:
        com.ss.android.socialbase.appdownloader.f.d.c = "com.heytap.market";
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0137, code lost:
        if (com.ss.android.socialbase.appdownloader.g.a(com.ss.android.socialbase.appdownloader.f.d.b) > (-1)) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(String str) {
        String str2;
        String str3;
        o();
        String str4 = e;
        if (str4 != null) {
            return str4.equals(str);
        }
        String d2 = d("ro.miui.ui.version.name");
        f = d2;
        if (TextUtils.isEmpty(d2)) {
            String d3 = d("ro.build.version.emui");
            f = d3;
            if (TextUtils.isEmpty(d3)) {
                String d4 = d(d);
                f = d4;
                if (TextUtils.isEmpty(d4)) {
                    String d5 = d("ro.vivo.os.version");
                    f = d5;
                    if (TextUtils.isEmpty(d5)) {
                        String d6 = d("ro.smartisan.version");
                        f = d6;
                        if (TextUtils.isEmpty(d6)) {
                            String d7 = d(RomUtils.KEY_VERSION_GIONEE);
                            f = d7;
                            if (TextUtils.isEmpty(d7)) {
                                String d8 = d("ro.lenovo.lvp.version");
                                f = d8;
                                if (!TextUtils.isEmpty(d8)) {
                                    e = "LENOVO";
                                    str3 = "com.lenovo.leos.appstore";
                                } else if (j().toUpperCase().contains("SAMSUNG")) {
                                    e = "SAMSUNG";
                                    str3 = "com.sec.android.app.samsungapps";
                                } else if (j().toUpperCase().contains("ZTE")) {
                                    e = "ZTE";
                                    str3 = "zte.com.market";
                                } else if (j().toUpperCase().contains(RomUtils.ROM_NUBIA)) {
                                    e = RomUtils.ROM_NUBIA;
                                    str3 = "cn.nubia.neostore";
                                } else {
                                    if (k().toUpperCase().contains("FLYME")) {
                                        e = "FLYME";
                                        c = "com.meizu.mstore";
                                        str2 = k();
                                    } else if (j().toUpperCase().contains(RomTypeUtil.ROM_ONEPLUS)) {
                                        e = RomTypeUtil.ROM_ONEPLUS;
                                        f = d("ro.rom.version");
                                    } else {
                                        e = j().toUpperCase();
                                        str2 = "";
                                        c = "";
                                    }
                                    f = str2;
                                }
                            } else {
                                e = "QIONEE";
                                str3 = "com.gionee.aora.market";
                            }
                        } else {
                            e = "SMARTISAN";
                            str3 = "com.smartisanos.appstore";
                        }
                    } else {
                        e = "VIVO";
                        str3 = "com.bbk.appstore";
                    }
                } else {
                    e = a;
                }
            } else {
                e = "EMUI";
                str3 = "com.huawei.appmarket";
            }
            c = str3;
        } else {
            e = "MIUI";
            c = "com.xiaomi.market";
            g = f;
        }
        return e.equals(str);
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

    public static boolean b() {
        return a("MIUI");
    }

    public static String c(String str) throws Throwable {
        return (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, str);
    }

    public static boolean c() {
        return a("VIVO");
    }

    public static String d(String str) {
        if (com.ss.android.socialbase.downloader.g.a.b().optBoolean("enable_reflect_system_properties", true)) {
            try {
                return c(str);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return b(str);
    }

    public static boolean d() {
        o();
        return a(a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0000, code lost:
        continue;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String d1654612903251dc(String str) {
        while (true) {
            char c2 = 'I';
            char c3 = '`';
            while (true) {
                switch (c2) {
                    case 'H':
                        c2 = 'J';
                        c3 = '7';
                    case 'I':
                        switch (c3) {
                            case '_':
                            case '`':
                                c2 = 'J';
                                c3 = '7';
                        }
                        break;
                    case 'J':
                        break;
                    default:
                        c2 = 'H';
                }
                switch (c3) {
                    case '7':
                        char[] charArray = str.toCharArray();
                        for (int i = 0; i < charArray.length; i++) {
                            charArray[i] = (char) (charArray[i] ^ i);
                        }
                        return new String(charArray);
                }
            }
        }
    }

    public static boolean e() {
        return a("FLYME");
    }

    public static boolean f() {
        return a("SAMSUNG");
    }

    public static String g() {
        if (e == null) {
            a("");
        }
        return e;
    }

    public static String h() {
        if (f == null) {
            a("");
        }
        return f;
    }

    public static String i() {
        if (c == null) {
            a("");
        }
        return c;
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
        return "V10".equals(g);
    }

    public static boolean m() {
        p();
        return "V11".equals(g);
    }

    public static boolean n() {
        p();
        return "V12".equals(g);
    }

    public static void o() {
        if (TextUtils.isEmpty(a)) {
            com.ss.android.socialbase.downloader.downloader.c.F();
            a = com.ss.android.socialbase.downloader.constants.e.b;
            d = "ro.build.version." + com.ss.android.socialbase.downloader.constants.e.c + Config.ROM;
            b = "com." + com.ss.android.socialbase.downloader.constants.e.c + ".market";
        }
    }

    public static void p() {
        if (g == null) {
            try {
                g = d("ro.miui.ui.version.name");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            String str = g;
            if (str == null) {
                str = "";
            }
            g = str;
        }
    }
}
