package com.bytedance.tea.crash.g;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.util.devices.RomUtils;
import java.util.Locale;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f7963a = false;

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            str = a();
        }
        if (TextUtils.isEmpty(str) || !str.toLowerCase(Locale.getDefault()).startsWith("emotionui")) {
            return b();
        }
        return true;
    }

    public static String a() {
        return b("ro.build.version.emui");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    private static java.lang.String b(java.lang.String r4) {
        /*
            r2 = 0
            java.lang.Runtime r0 = java.lang.Runtime.getRuntime()     // Catch: java.lang.Throwable -> L38
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L38
            r1.<init>()     // Catch: java.lang.Throwable -> L38
            java.lang.String r3 = "getprop "
            java.lang.StringBuilder r1 = r1.append(r3)     // Catch: java.lang.Throwable -> L38
            java.lang.StringBuilder r1 = r1.append(r4)     // Catch: java.lang.Throwable -> L38
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L38
            java.lang.Process r0 = r0.exec(r1)     // Catch: java.lang.Throwable -> L38
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L38
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L38
            java.io.InputStream r0 = r0.getInputStream()     // Catch: java.lang.Throwable -> L38
            r3.<init>(r0)     // Catch: java.lang.Throwable -> L38
            r0 = 1024(0x400, float:1.435E-42)
            r1.<init>(r3, r0)     // Catch: java.lang.Throwable -> L38
            java.lang.String r0 = r1.readLine()     // Catch: java.lang.Throwable -> L47
            r1.close()     // Catch: java.lang.Throwable -> L4a
            com.bytedance.tea.crash.g.f.a(r1)
        L37:
            return r0
        L38:
            r0 = move-exception
            r1 = r2
            r0 = r2
        L3b:
            com.bytedance.tea.crash.g.f.a(r1)
            goto L37
        L3f:
            r0 = move-exception
        L40:
            com.bytedance.tea.crash.g.f.a(r2)
            throw r0
        L44:
            r0 = move-exception
            r2 = r1
            goto L40
        L47:
            r0 = move-exception
            r0 = r2
            goto L3b
        L4a:
            r2 = move-exception
            goto L3b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.tea.crash.g.c.b(java.lang.String):java.lang.String");
    }

    public static boolean b() {
        try {
            if (TextUtils.isEmpty(Build.BRAND) || !Build.BRAND.toLowerCase(Locale.getDefault()).startsWith(RomUtils.MANUFACTURER_HUAWEI)) {
                if (TextUtils.isEmpty(Build.MANUFACTURER)) {
                    return false;
                }
                if (!Build.MANUFACTURER.toLowerCase(Locale.getDefault()).startsWith(RomUtils.MANUFACTURER_HUAWEI)) {
                    return false;
                }
            }
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean c() {
        if (!f7963a) {
            try {
                if (Class.forName("miui.os.Build") != null) {
                    com.bytedance.tea.crash.upload.b.f7972a = true;
                    f7963a = true;
                    return com.bytedance.tea.crash.upload.b.f7972a;
                }
            } catch (Exception e) {
            }
            f7963a = true;
        }
        return com.bytedance.tea.crash.upload.b.f7972a;
    }

    public static boolean d() {
        return Build.DISPLAY.contains("Flyme") || Build.USER.equals("flyme");
    }
}
