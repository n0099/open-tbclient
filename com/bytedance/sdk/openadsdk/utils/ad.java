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
/* loaded from: classes4.dex */
public class ad {
    private static final CharSequence c = "sony";
    private static final CharSequence d = "amigo";
    private static final CharSequence e = "funtouch";

    /* renamed from: a  reason: collision with root package name */
    public static boolean f7839a = false;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f7840b = false;

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
        if (!f7840b) {
            try {
                if (Class.forName("miui.os.Build") != null) {
                    f7839a = true;
                    f7840b = true;
                    return f7839a;
                }
            } catch (Exception e2) {
            }
            f7840b = true;
        }
        return f7839a;
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
        return !TextUtils.isEmpty(str) && str.toLowerCase().contains(aj.r("kllk"));
    }

    public static String s() {
        if (r()) {
            return "coloros_" + d(aj.r("ro.build.version.kllkrom")) + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + Build.DISPLAY;
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [300=5, 302=4, 303=4, 304=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:14:0x004e */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:40:0x00a8 */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r3v15, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v7 */
    public static String c(String str) {
        Process process;
        ?? r3;
        BufferedReader bufferedReader = null;
        String str2 = "";
        try {
            try {
                try {
                    try {
                        process = Runtime.getRuntime().exec("getprop " + str);
                        try {
                            r3 = new BufferedReader(new InputStreamReader(process.getInputStream()), 1024);
                        } catch (IllegalThreadStateException e2) {
                            r3 = 0;
                        }
                    } catch (IllegalThreadStateException e3) {
                        process = null;
                        r3 = 0;
                    }
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    str2 = r3.readLine();
                    process.exitValue();
                    if (r3 != 0) {
                        try {
                            r3.close();
                        } catch (IOException e4) {
                            r3 = "Exception while closing InputStream";
                            u.c("ToolUtils", "Exception while closing InputStream", e4);
                        }
                    }
                } catch (IllegalThreadStateException e5) {
                    try {
                        process.destroy();
                    } catch (Exception e6) {
                    }
                    if (r3 != 0) {
                        try {
                            r3.close();
                        } catch (IOException e7) {
                            r3 = "Exception while closing InputStream";
                            u.c("ToolUtils", "Exception while closing InputStream", e7);
                        }
                    }
                    return str2;
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader = r3;
                    u.c("ToolUtils", "Unable to read sysprop " + str, th);
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e8) {
                            u.c("ToolUtils", "Exception while closing InputStream", e8);
                        }
                    }
                    return str2;
                }
                return str2;
            } catch (Throwable th3) {
                th = th3;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e9) {
                        u.c("ToolUtils", "Exception while closing InputStream", e9);
                    }
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = r3;
        }
    }

    private static String d(String str) {
        String str2;
        String str3 = "";
        try {
            str3 = u();
            if (TextUtils.isEmpty(str3)) {
                final com.bytedance.sdk.openadsdk.k.b bVar = new com.bytedance.sdk.openadsdk.k.b(new a(str), 5, 2);
                com.bytedance.sdk.openadsdk.k.a.a().b(new com.bytedance.sdk.openadsdk.k.c() { // from class: com.bytedance.sdk.openadsdk.utils.ad.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.bytedance.sdk.openadsdk.k.b.this.run();
                    }
                });
                str2 = (String) bVar.get(1L, TimeUnit.SECONDS);
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

    /* loaded from: classes4.dex */
    public static class a implements Callable<String> {

        /* renamed from: a  reason: collision with root package name */
        private String f7842a;

        public a(String str) {
            this.f7842a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public String call() throws Exception {
            long currentTimeMillis = System.currentTimeMillis();
            String c = ad.c(this.f7842a);
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
