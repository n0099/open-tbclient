package com.bytedance.sdk.openadsdk.utils;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.apollon.statusbar.ImmersiveOSUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
/* loaded from: classes6.dex */
public class ae {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f30219a = false;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f30220b = false;

    /* renamed from: c  reason: collision with root package name */
    public static final CharSequence f30221c = "sony";

    /* renamed from: d  reason: collision with root package name */
    public static final CharSequence f30222d = "amigo";

    /* renamed from: e  reason: collision with root package name */
    public static final CharSequence f30223e = "funtouch";

    /* renamed from: f  reason: collision with root package name */
    public static String f30224f = null;

    /* renamed from: g  reason: collision with root package name */
    public static int f30225g = Integer.MAX_VALUE;

    /* loaded from: classes6.dex */
    public static class a implements Callable<String> {

        /* renamed from: a  reason: collision with root package name */
        public String f30227a;

        public a(String str) {
            this.f30227a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public String call() throws Exception {
            long currentTimeMillis = System.currentTimeMillis();
            String c2 = ae.c(this.f30227a);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            u.b("RomUtils", "property:" + c2 + ",getSystemProperty use time :" + currentTimeMillis2);
            if (!TextUtils.isEmpty(c2)) {
                try {
                    if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                        u.d("RomUtils", "SPMultiHelper-getPropertyFromSPMultiHelper:" + c2);
                        com.bytedance.sdk.openadsdk.multipro.d.a.a("rom_info", "rom_property_info", c2);
                    } else {
                        u.d("RomUtils", "SP-getPropertyFromSP:" + c2);
                        af.a("rom_info", com.bytedance.sdk.openadsdk.core.p.a()).a("rom_property_info", c2);
                    }
                } catch (Throwable unused) {
                }
            }
            return c2;
        }
    }

    public static String a() {
        if (!TextUtils.isEmpty(f30224f)) {
            return f30224f;
        }
        String a2 = com.bytedance.sdk.openadsdk.core.i.a("sdk_local_rom_info", 604800000L);
        f30224f = a2;
        if (TextUtils.isEmpty(a2)) {
            String u = u();
            f30224f = u;
            com.bytedance.sdk.openadsdk.core.i.a("sdk_local_rom_info", u);
        }
        return f30224f;
    }

    public static String c() {
        return d("ro.build.uiversion") + "_" + Build.DISPLAY;
    }

    public static boolean d() {
        String str = Build.MANUFACTURER + Build.BRAND;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        return lowerCase.contains("360") || lowerCase.contains("qiku");
    }

    public static boolean e() {
        if (!f30220b) {
            try {
                if (Class.forName("miui.os.Build") != null) {
                    f30219a = true;
                    f30220b = true;
                    return true;
                }
            } catch (Exception unused) {
            }
            f30220b = true;
        }
        return f30219a;
    }

    public static String f() {
        return d("ro.vivo.os.build.display.id") + "_" + d("ro.vivo.product.version");
    }

    public static boolean g() {
        String d2 = d("ro.vivo.os.build.display.id");
        return !TextUtils.isEmpty(d2) && d2.toLowerCase().contains(f30223e);
    }

    public static boolean h() {
        return !TextUtils.isEmpty(Build.DISPLAY) && Build.DISPLAY.toLowerCase().contains(f30222d);
    }

    public static String i() {
        return Build.DISPLAY + "_" + d(RomUtils.KEY_VERSION_GIONEE);
    }

    public static String j() {
        if (k()) {
            return "eui_" + d("ro.letv.release.version") + "_" + Build.DISPLAY;
        }
        return "";
    }

    public static boolean k() {
        return !TextUtils.isEmpty(d("ro.letv.release.version"));
    }

    public static String l() {
        if (e()) {
            return "miui_" + d("ro.miui.ui.version.name") + "_" + Build.VERSION.INCREMENTAL;
        }
        return "";
    }

    public static String m() {
        String n = n();
        if (n == null || !n.toLowerCase().contains("emotionui")) {
            return "";
        }
        return n + "_" + Build.DISPLAY;
    }

    public static String n() {
        return d("ro.build.version.emui");
    }

    public static boolean o() {
        return RomUtils.MANUFACTURER_SMARTISAN.equalsIgnoreCase(Build.MANUFACTURER) || RomUtils.MANUFACTURER_SMARTISAN.equalsIgnoreCase(Build.BRAND);
    }

    public static String p() {
        if (o()) {
            try {
                String d2 = d("ro.smartisan.version");
                return "smartisan_" + d2;
            } catch (Throwable unused) {
            }
        }
        return Build.DISPLAY;
    }

    public static String q() {
        String str = Build.DISPLAY;
        return (str == null || !str.toLowerCase().contains(ImmersiveOSUtils.FLYME)) ? "" : str;
    }

    public static boolean r() {
        if (f30225g == Integer.MAX_VALUE) {
            String str = Build.MANUFACTURER;
            String m = ak.m("kllk");
            if (!TextUtils.isEmpty(str) && str.toLowerCase().contains(m)) {
                f30225g = 1;
            } else {
                f30225g = 0;
            }
        }
        return f30225g == 1;
    }

    public static String s() {
        if (r()) {
            String m = ak.m("ro.build.version.kllkrom");
            return "coloros_" + d(m) + "_" + Build.DISPLAY;
        }
        return "";
    }

    public static boolean t() {
        try {
            if (TextUtils.isEmpty(Build.BRAND) || !Build.BRAND.toLowerCase().startsWith(RomUtils.MANUFACTURER_HUAWEI)) {
                if (TextUtils.isEmpty(Build.MANUFACTURER)) {
                    return false;
                }
                if (!Build.MANUFACTURER.toLowerCase().startsWith(RomUtils.MANUFACTURER_HUAWEI)) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String u() {
        if (o()) {
            return p();
        }
        if (e()) {
            return l();
        }
        if (b()) {
            return q();
        }
        if (r()) {
            return s();
        }
        String m = m();
        if (TextUtils.isEmpty(m)) {
            if (g()) {
                return f();
            }
            if (h()) {
                return i();
            }
            if (d()) {
                return c();
            }
            String j = j();
            return !TextUtils.isEmpty(j) ? j : Build.DISPLAY;
        }
        return m;
    }

    public static String v() {
        try {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                String b2 = com.bytedance.sdk.openadsdk.multipro.d.a.b("rom_info", "rom_property_info", "");
                u.c("RomUtils", "get Property From SPMultiHelper..." + b2);
                return b2;
            }
            String b3 = af.a("rom_info", com.bytedance.sdk.openadsdk.core.p.a()).b("rom_property_info", "");
            u.c("RomUtils", "get Property From SP...=" + b3);
            return b3;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static boolean b() {
        return Build.DISPLAY.contains("Flyme") || Build.USER.equals(ImmersiveOSUtils.FLYME);
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    public static String c(String str) {
        BufferedReader bufferedReader;
        Throwable th;
        Process exec;
        String str2 = "";
        Process process = null;
        try {
            try {
                try {
                    exec = Runtime.getRuntime().exec("getprop " + str);
                    try {
                        bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()), 1024);
                    } catch (IllegalThreadStateException unused) {
                        bufferedReader = null;
                    }
                } catch (Throwable th2) {
                    bufferedReader = null;
                    th = th2;
                }
            } catch (IllegalThreadStateException unused2) {
                bufferedReader = null;
            }
        } catch (IOException e2) {
            u.c("ToolUtils", "Exception while closing InputStream", e2);
        }
        try {
            str2 = bufferedReader.readLine();
            exec.exitValue();
            bufferedReader.close();
        } catch (IllegalThreadStateException unused3) {
            process = exec;
            try {
                process.destroy();
            } catch (Throwable unused4) {
            }
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            return str2;
        } catch (Throwable th3) {
            th = th3;
            try {
                u.c("ToolUtils", "Unable to read sysprop " + str, th);
                return str2;
            } finally {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e3) {
                        u.c("ToolUtils", "Exception while closing InputStream", e3);
                    }
                }
            }
        }
        return str2;
    }

    public static String d(String str) {
        String str2;
        try {
            str2 = v();
            try {
                if (TextUtils.isEmpty(str2)) {
                    final com.bytedance.sdk.openadsdk.l.f fVar = new com.bytedance.sdk.openadsdk.l.f(new a(str), 5, 2);
                    com.bytedance.sdk.openadsdk.l.e.a(new com.bytedance.sdk.openadsdk.l.g("getSystemPropertyTask") { // from class: com.bytedance.sdk.openadsdk.utils.ae.1
                        @Override // java.lang.Runnable
                        public void run() {
                            fVar.run();
                        }
                    });
                    str2 = (String) fVar.get(1L, TimeUnit.SECONDS);
                }
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            str2 = "";
        }
        return str2 == null ? "" : str2;
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            str = n();
        }
        return (!TextUtils.isEmpty(str) && str.toLowerCase().startsWith("emotionui")) || t();
    }
}
