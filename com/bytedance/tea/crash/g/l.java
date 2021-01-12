package com.bytedance.tea.crash.g;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import java.util.Locale;
/* loaded from: classes4.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    private static final CharSequence f7667a = "sony";

    /* renamed from: b  reason: collision with root package name */
    private static final CharSequence f7668b = "amigo";
    private static final CharSequence c = "funtouch";

    public static String a() {
        if (c.c()) {
            return j();
        }
        if (c.d()) {
            return l();
        }
        if (m()) {
            return n();
        }
        String k = k();
        if (TextUtils.isEmpty(k)) {
            if (e()) {
                return d();
            }
            if (f()) {
                return g();
            }
            if (c()) {
                return b();
            }
            String h = h();
            return TextUtils.isEmpty(h) ? Build.DISPLAY : h;
        }
        return k;
    }

    public static String b() {
        return a("ro.build.uiversion") + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + Build.DISPLAY;
    }

    public static boolean c() {
        String str = Build.MANUFACTURER + Build.BRAND;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String lowerCase = str.toLowerCase(Locale.getDefault());
        return lowerCase.contains("360") || lowerCase.contains("qiku");
    }

    public static String d() {
        return a("ro.vivo.os.build.display.id") + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + a("ro.vivo.product.version");
    }

    public static boolean e() {
        String a2 = a("ro.vivo.os.build.display.id");
        return !TextUtils.isEmpty(a2) && a2.toLowerCase(Locale.getDefault()).contains(c);
    }

    public static boolean f() {
        return !TextUtils.isEmpty(Build.DISPLAY) && Build.DISPLAY.toLowerCase(Locale.getDefault()).contains(f7668b);
    }

    public static String g() {
        return Build.DISPLAY + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + a("ro.gn.sv.version");
    }

    public static String h() {
        return i() ? "eui_" + a("ro.letv.release.version") + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + Build.DISPLAY : "";
    }

    public static boolean i() {
        return !TextUtils.isEmpty(a("ro.letv.release.version"));
    }

    public static String j() {
        return c.c() ? "miui_" + a("ro.miui.ui.version.name") + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + Build.VERSION.INCREMENTAL : "";
    }

    public static String k() {
        String a2 = c.a();
        return (a2 == null || !a2.toLowerCase(Locale.getDefault()).contains("emotionui")) ? "" : a2 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + Build.DISPLAY;
    }

    public static String l() {
        String str = Build.DISPLAY;
        return (str == null || !str.toLowerCase(Locale.getDefault()).contains("flyme")) ? "" : str;
    }

    public static boolean m() {
        String str = Build.MANUFACTURER;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.toLowerCase(Locale.getDefault()).contains(RomUtils.MANUFACTURER_OPPO);
    }

    public static String n() {
        return m() ? "coloros_" + a("ro.build.version.opporom") + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + Build.DISPLAY : "";
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    private static java.lang.String a(java.lang.String r6) {
        /*
            java.lang.String r0 = ""
            r2 = 0
            java.lang.Runtime r1 = java.lang.Runtime.getRuntime()     // Catch: java.lang.Throwable -> L3b
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3b
            r3.<init>()     // Catch: java.lang.Throwable -> L3b
            java.lang.String r4 = "getprop "
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch: java.lang.Throwable -> L3b
            java.lang.StringBuilder r3 = r3.append(r6)     // Catch: java.lang.Throwable -> L3b
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L3b
            java.lang.Process r3 = r1.exec(r3)     // Catch: java.lang.Throwable -> L3b
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L3b
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L3b
            java.io.InputStream r5 = r3.getInputStream()     // Catch: java.lang.Throwable -> L3b
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L3b
            r5 = 1024(0x400, float:1.435E-42)
            r1.<init>(r4, r5)     // Catch: java.lang.Throwable -> L3b
            java.lang.String r0 = r1.readLine()     // Catch: java.lang.Throwable -> L49
            r3.destroy()     // Catch: java.lang.Throwable -> L49
            com.bytedance.tea.crash.g.f.a(r1)
        L3a:
            return r0
        L3b:
            r1 = move-exception
            r1 = r2
        L3d:
            com.bytedance.tea.crash.g.f.a(r1)
            goto L3a
        L41:
            r0 = move-exception
        L42:
            com.bytedance.tea.crash.g.f.a(r2)
            throw r0
        L46:
            r0 = move-exception
            r2 = r1
            goto L42
        L49:
            r2 = move-exception
            goto L3d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.tea.crash.g.l.a(java.lang.String):java.lang.String");
    }
}
