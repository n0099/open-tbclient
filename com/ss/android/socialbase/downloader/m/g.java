package com.ss.android.socialbase.downloader.m;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.mobstat.Config;
/* loaded from: classes4.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public static String f13539a;
    public static String c;
    private static String e;
    private static String f;
    private static String g;
    private static String d = "";

    /* renamed from: b  reason: collision with root package name */
    public static String f13540b = "";

    public static boolean a() {
        return a(RomUtils.ROM_EMUI);
    }

    public static boolean b() {
        return a(RomUtils.ROM_MIUI);
    }

    public static boolean c() {
        return a(RomUtils.ROM_VIVO);
    }

    public static boolean d() {
        l();
        return a(f13539a);
    }

    public static boolean e() {
        return a("SAMSUNG");
    }

    public static String f() {
        if (e == null) {
            a("");
        }
        return e;
    }

    public static String g() {
        if (f == null) {
            a("");
        }
        return f;
    }

    public static String h() {
        if (c == null) {
            a("");
        }
        return c;
    }

    private static void l() {
        if (TextUtils.isEmpty(f13539a)) {
            f13539a = com.ss.android.socialbase.downloader.b.e.f13372b;
            d = "ro.build.version." + com.ss.android.socialbase.downloader.b.e.c + Config.ROM;
            f13540b = "com." + com.ss.android.socialbase.downloader.b.e.c + ".market";
        }
    }

    public static boolean a(String str) {
        l();
        if (e != null) {
            return e.equals(str);
        }
        String b2 = b("ro.miui.ui.version.name");
        f = b2;
        if (!TextUtils.isEmpty(b2)) {
            e = RomUtils.ROM_MIUI;
            c = "com.xiaomi.market";
        } else {
            String b3 = b("ro.build.version.emui");
            f = b3;
            if (!TextUtils.isEmpty(b3)) {
                e = RomUtils.ROM_EMUI;
                c = "com.huawei.appmarket";
            } else {
                String b4 = b(d);
                f = b4;
                if (!TextUtils.isEmpty(b4)) {
                    e = f13539a;
                    c = f13540b;
                } else {
                    String b5 = b("ro.vivo.os.version");
                    f = b5;
                    if (!TextUtils.isEmpty(b5)) {
                        e = RomUtils.ROM_VIVO;
                        c = "com.bbk.appstore";
                    } else {
                        String b6 = b("ro.smartisan.version");
                        f = b6;
                        if (!TextUtils.isEmpty(b6)) {
                            e = RomUtils.ROM_SMARTISAN;
                            c = "com.smartisanos.appstore";
                        } else {
                            String b7 = b("ro.gn.sv.version");
                            f = b7;
                            if (!TextUtils.isEmpty(b7)) {
                                e = "QIONEE";
                                c = "com.gionee.aora.market";
                            } else {
                                String b8 = b("ro.lenovo.lvp.version");
                                f = b8;
                                if (!TextUtils.isEmpty(b8)) {
                                    e = "LENOVO";
                                    c = "com.lenovo.leos.appstore";
                                } else if (i().toUpperCase().contains("SAMSUNG")) {
                                    e = "SAMSUNG";
                                    c = "com.sec.android.app.samsungapps";
                                } else if (i().toUpperCase().contains("ZTE")) {
                                    e = "ZTE";
                                    c = "zte.com.market";
                                } else if (i().toLowerCase().contains(RomUtils.ROM_NUBIA)) {
                                    e = RomUtils.ROM_NUBIA;
                                    c = "cn.nubia.neostore";
                                } else {
                                    f = Build.DISPLAY;
                                    if (f.toUpperCase().contains(RomUtils.ROM_FLYME)) {
                                        e = RomUtils.ROM_FLYME;
                                        c = "com.meizu.mstore";
                                    } else {
                                        f = "unknown";
                                        e = Build.MANUFACTURER.toUpperCase();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return e.equals(str);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public static java.lang.String b(java.lang.String r6) {
        /*
            r1 = 0
            r5 = 1
            r4 = 0
            java.lang.Runtime r0 = java.lang.Runtime.getRuntime()     // Catch: java.lang.Throwable -> L3e
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3e
            r2.<init>()     // Catch: java.lang.Throwable -> L3e
            java.lang.String r3 = "getprop "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> L3e
            java.lang.StringBuilder r2 = r2.append(r6)     // Catch: java.lang.Throwable -> L3e
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L3e
            java.lang.Process r0 = r0.exec(r2)     // Catch: java.lang.Throwable -> L3e
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L3e
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L3e
            java.io.InputStream r0 = r0.getInputStream()     // Catch: java.lang.Throwable -> L3e
            r3.<init>(r0)     // Catch: java.lang.Throwable -> L3e
            r0 = 1024(0x400, float:1.435E-42)
            r2.<init>(r3, r0)     // Catch: java.lang.Throwable -> L3e
            java.lang.String r0 = r2.readLine()     // Catch: java.lang.Throwable -> L55
            r2.close()     // Catch: java.lang.Throwable -> L55
            java.io.Closeable[] r1 = new java.io.Closeable[r5]
            r1[r4] = r2
            com.ss.android.socialbase.downloader.m.d.a(r1)
        L3d:
            return r0
        L3e:
            r0 = move-exception
            r0 = r1
        L40:
            java.io.Closeable[] r2 = new java.io.Closeable[r5]
            r2[r4] = r0
            com.ss.android.socialbase.downloader.m.d.a(r2)
            r0 = r1
            goto L3d
        L49:
            r0 = move-exception
        L4a:
            java.io.Closeable[] r2 = new java.io.Closeable[r5]
            r2[r4] = r1
            com.ss.android.socialbase.downloader.m.d.a(r2)
            throw r0
        L52:
            r0 = move-exception
            r1 = r2
            goto L4a
        L55:
            r0 = move-exception
            r0 = r2
            goto L40
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.m.g.b(java.lang.String):java.lang.String");
    }

    public static final String i() {
        return Build.MANUFACTURER == null ? "" : Build.MANUFACTURER.trim();
    }

    public static boolean j() {
        m();
        return "V10".equals(g);
    }

    public static boolean k() {
        m();
        return "V11".equals(g);
    }

    private static void m() {
        if (g == null) {
            try {
                g = b("ro.miui.ui.version.name");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            g = g == null ? "" : g;
        }
    }
}
