package com.bytedance.sdk.openadsdk.utils;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
/* loaded from: classes6.dex */
public class ad {
    private static final CharSequence c = "sony";
    private static final CharSequence d = "amigo";
    private static final CharSequence e = "funtouch";

    /* renamed from: a  reason: collision with root package name */
    public static boolean f5115a = false;
    public static boolean b = false;

    public static String a() {
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
            return TextUtils.isEmpty(j) ? Build.DISPLAY : j;
        }
        return m;
    }

    public static boolean b() {
        return Build.DISPLAY.contains("Flyme") || Build.USER.equals("flyme");
    }

    public static String c() {
        return d("ro.build.uiversion") + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + Build.DISPLAY;
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
        if (!b) {
            try {
                if (Class.forName("miui.os.Build") != null) {
                    f5115a = true;
                    b = true;
                    return f5115a;
                }
            } catch (Exception e2) {
            }
            b = true;
        }
        return f5115a;
    }

    public static String f() {
        return d("ro.vivo.os.build.display.id") + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + d("ro.vivo.product.version");
    }

    public static boolean g() {
        String d2 = d("ro.vivo.os.build.display.id");
        return !TextUtils.isEmpty(d2) && d2.toLowerCase().contains(e);
    }

    public static boolean h() {
        return !TextUtils.isEmpty(Build.DISPLAY) && Build.DISPLAY.toLowerCase().contains(d);
    }

    public static String i() {
        return Build.DISPLAY + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + d("ro.gn.sv.version");
    }

    public static String j() {
        return k() ? "eui_" + d("ro.letv.release.version") + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + Build.DISPLAY : "";
    }

    public static boolean k() {
        return !TextUtils.isEmpty(d("ro.letv.release.version"));
    }

    public static String l() {
        return e() ? "miui_" + d("ro.miui.ui.version.name") + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + Build.VERSION.INCREMENTAL : "";
    }

    public static String m() {
        String n = n();
        return (n == null || !n.toLowerCase().contains("emotionui")) ? "" : n + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + Build.DISPLAY;
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
                return "smartisan_" + d("ro.smartisan.version");
            } catch (Throwable th) {
            }
        }
        return Build.DISPLAY;
    }

    public static String q() {
        String str = Build.DISPLAY;
        return (str == null || !str.toLowerCase().contains("flyme")) ? "" : str;
    }

    public static boolean r() {
        String str = Build.MANUFACTURER;
        return !TextUtils.isEmpty(str) && str.toLowerCase().contains(aj.m("kllk"));
    }

    public static String s() {
        if (r()) {
            return "coloros_" + d(aj.m("ro.build.version.kllkrom")) + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + Build.DISPLAY;
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
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            str = n();
        }
        return (!TextUtils.isEmpty(str) && str.toLowerCase().startsWith("emotionui")) || t();
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [301=5, 303=4, 304=4, 305=4] */
    /* JADX INFO: Access modifiers changed from: private */
    public static String c(String str) {
        Process process;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        String str2 = "";
        try {
            try {
                try {
                    process = Runtime.getRuntime().exec("getprop " + str);
                    try {
                        bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()), 1024);
                    } catch (IllegalThreadStateException e2) {
                        bufferedReader = null;
                    }
                } catch (IllegalThreadStateException e3) {
                    process = null;
                    bufferedReader = null;
                }
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            str2 = bufferedReader.readLine();
            process.exitValue();
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e4) {
                    u.c("ToolUtils", "Exception while closing InputStream", e4);
                }
            }
        } catch (IllegalThreadStateException e5) {
            try {
                process.destroy();
            } catch (Throwable th3) {
            }
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e6) {
                    u.c("ToolUtils", "Exception while closing InputStream", e6);
                }
            }
            return str2;
        } catch (Throwable th4) {
            th = th4;
            bufferedReader2 = bufferedReader;
            u.c("ToolUtils", "Unable to read sysprop " + str, th);
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (IOException e7) {
                    u.c("ToolUtils", "Exception while closing InputStream", e7);
                }
            }
            return str2;
        }
        return str2;
    }

    private static String d(String str) {
        String str2;
        String str3 = "";
        try {
            str3 = u();
            if (TextUtils.isEmpty(str3)) {
                final com.bytedance.sdk.openadsdk.j.f fVar = new com.bytedance.sdk.openadsdk.j.f(new a(str), 5, 2);
                com.bytedance.sdk.openadsdk.j.e.a().execute(new com.bytedance.sdk.openadsdk.j.g() { // from class: com.bytedance.sdk.openadsdk.utils.ad.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.bytedance.sdk.openadsdk.j.f.this.run();
                    }
                });
                str2 = (String) fVar.get(1L, TimeUnit.SECONDS);
            } else {
                str2 = str3;
            }
        } catch (Throwable th) {
            str2 = str3;
        }
        if (str2 == null) {
            return "";
        }
        return str2;
    }

    /* loaded from: classes6.dex */
    public static class a implements Callable<String> {

        /* renamed from: a  reason: collision with root package name */
        private String f5117a;

        public a(String str) {
            this.f5117a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public String call() throws Exception {
            long currentTimeMillis = System.currentTimeMillis();
            String c = ad.c(this.f5117a);
            u.b("RomUtils", "property:" + c + ",getSystemProperty use time :" + (System.currentTimeMillis() - currentTimeMillis));
            if (!TextUtils.isEmpty(c)) {
                try {
                    if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                        u.d("RomUtils", "SPMultiHelper-getPropertyFromSPMultiHelper:" + c);
                        com.bytedance.sdk.openadsdk.multipro.d.a.a("rom_info", "rom_property_info", c);
                    } else {
                        u.d("RomUtils", "SP-getPropertyFromSP:" + c);
                        ae.a("rom_info", com.bytedance.sdk.openadsdk.core.p.a()).a("rom_property_info", c);
                    }
                } catch (Throwable th) {
                }
            }
            return c;
        }
    }

    private static String u() {
        String b2;
        try {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                b2 = com.bytedance.sdk.openadsdk.multipro.d.a.b("rom_info", "rom_property_info", "");
                u.c("RomUtils", "get Property From SPMultiHelper..." + b2);
            } else {
                b2 = ae.a("rom_info", com.bytedance.sdk.openadsdk.core.p.a()).b("rom_property_info", "");
                u.c("RomUtils", "get Property From SP...=" + b2);
            }
            return b2;
        } catch (Throwable th) {
            return "";
        }
    }
}
