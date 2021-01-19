package com.pgl.sys.ces.a;

import java.io.File;
import java.io.FileFilter;
import java.util.HashMap;
import java.util.regex.Pattern;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {
    private static final FileFilter pQa = new FileFilter() { // from class: com.pgl.sys.ces.a.b.1
        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return Pattern.matches("cpu[0-9]", file.getName());
        }
    };

    public static String a() {
        JSONObject jSONObject = new JSONObject();
        try {
            HashMap<String, String> b2 = b();
            jSONObject.put("core", c());
            jSONObject.put("hw", c(b2, "Hardware"));
            jSONObject.put("max", a("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq"));
            jSONObject.put("min", a("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_min_freq"));
            jSONObject.put("ft", c(b2, "Features"));
        } catch (Throwable th) {
        }
        String jSONObject2 = jSONObject.toString();
        return jSONObject2 == null ? "{}" : jSONObject2.trim();
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
            r1 = 0
            java.io.FileReader r0 = new java.io.FileReader     // Catch: java.lang.Throwable -> L1f
            r0.<init>(r6)     // Catch: java.lang.Throwable -> L1f
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L57
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L57
            java.lang.String r1 = r2.readLine()     // Catch: java.lang.Throwable -> L5a
            if (r2 == 0) goto L14
            r2.close()     // Catch: java.lang.Throwable -> L43
        L14:
            if (r0 == 0) goto L19
            r0.close()     // Catch: java.lang.Throwable -> L45
        L19:
            if (r1 != 0) goto L3e
            java.lang.String r0 = "0"
        L1e:
            return r0
        L1f:
            r0 = move-exception
            r0 = r1
            r2 = r1
        L22:
            if (r2 == 0) goto L27
            r2.close()     // Catch: java.lang.Throwable -> L47
        L27:
            if (r0 == 0) goto L19
            r0.close()     // Catch: java.lang.Throwable -> L2d
            goto L19
        L2d:
            r0 = move-exception
            goto L19
        L2f:
            r0 = move-exception
            r3 = r0
            r4 = r1
            r5 = r1
        L33:
            if (r5 == 0) goto L38
            r5.close()     // Catch: java.lang.Throwable -> L49
        L38:
            if (r4 == 0) goto L3d
            r4.close()     // Catch: java.lang.Throwable -> L4b
        L3d:
            throw r3
        L3e:
            java.lang.String r0 = r1.trim()
            goto L1e
        L43:
            r2 = move-exception
            goto L14
        L45:
            r0 = move-exception
            goto L19
        L47:
            r2 = move-exception
            goto L27
        L49:
            r0 = move-exception
            goto L38
        L4b:
            r0 = move-exception
            goto L3d
        L4d:
            r2 = move-exception
            r3 = r2
            r4 = r0
            r5 = r1
            goto L33
        L52:
            r1 = move-exception
            r3 = r1
            r4 = r0
            r5 = r2
            goto L33
        L57:
            r2 = move-exception
            r2 = r1
            goto L22
        L5a:
            r3 = move-exception
            goto L22
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pgl.sys.ces.a.b.a(java.lang.String):java.lang.String");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    private static java.util.HashMap<java.lang.String, java.lang.String> b() {
        /*
            r1 = 0
            r6 = 2
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            java.io.FileReader r2 = new java.io.FileReader     // Catch: java.lang.Throwable -> L77
            java.lang.String r0 = "/proc/cpuinfo"
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L77
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L7b
            r0.<init>(r2)     // Catch: java.lang.Throwable -> L7b
        L14:
            java.lang.String r1 = r0.readLine()     // Catch: java.lang.Throwable -> L48
            if (r1 != 0) goto L25
            if (r0 == 0) goto L1f
            r0.close()     // Catch: java.lang.Throwable -> L65
        L1f:
            if (r2 == 0) goto L24
            r2.close()     // Catch: java.lang.Throwable -> L67
        L24:
            return r3
        L25:
            java.lang.String r4 = ":"
            r5 = 2
            java.lang.String[] r1 = r1.split(r4, r5)     // Catch: java.lang.Throwable -> L48
            int r4 = r1.length     // Catch: java.lang.Throwable -> L48
            if (r4 < r6) goto L14
            r4 = 0
            r4 = r1[r4]     // Catch: java.lang.Throwable -> L48
            java.lang.String r4 = r4.trim()     // Catch: java.lang.Throwable -> L48
            r5 = 1
            r1 = r1[r5]     // Catch: java.lang.Throwable -> L48
            java.lang.String r1 = r1.trim()     // Catch: java.lang.Throwable -> L48
            java.lang.Object r5 = r3.get(r4)     // Catch: java.lang.Throwable -> L48
            if (r5 != 0) goto L14
            r3.put(r4, r1)     // Catch: java.lang.Throwable -> L48
            goto L14
        L48:
            r1 = move-exception
        L49:
            if (r0 == 0) goto L4e
            r0.close()     // Catch: java.lang.Throwable -> L69
        L4e:
            if (r2 == 0) goto L24
            r2.close()     // Catch: java.lang.Throwable -> L54
            goto L24
        L54:
            r0 = move-exception
            goto L24
        L56:
            r0 = move-exception
            r3 = r0
            r4 = r1
            r2 = r1
        L5a:
            if (r4 == 0) goto L5f
            r4.close()     // Catch: java.lang.Throwable -> L6b
        L5f:
            if (r2 == 0) goto L64
            r2.close()     // Catch: java.lang.Throwable -> L6d
        L64:
            throw r3
        L65:
            r0 = move-exception
            goto L1f
        L67:
            r0 = move-exception
            goto L24
        L69:
            r0 = move-exception
            goto L4e
        L6b:
            r0 = move-exception
            goto L5f
        L6d:
            r0 = move-exception
            goto L64
        L6f:
            r0 = move-exception
            r3 = r0
            r4 = r1
            goto L5a
        L73:
            r1 = move-exception
            r3 = r1
            r4 = r0
            goto L5a
        L77:
            r0 = move-exception
            r0 = r1
            r2 = r1
            goto L49
        L7b:
            r0 = move-exception
            r0 = r1
            goto L49
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pgl.sys.ces.a.b.b():java.util.HashMap");
    }

    private static int c() {
        try {
            return new File("/sys/devices/system/cpu/").listFiles(pQa).length;
        } catch (Throwable th) {
            return -1;
        }
    }

    private static String c(HashMap<String, String> hashMap, String str) {
        String str2;
        try {
            str2 = hashMap.get(str);
        } catch (Throwable th) {
            str2 = null;
        }
        return str2 == null ? "" : str2.trim();
    }
}
