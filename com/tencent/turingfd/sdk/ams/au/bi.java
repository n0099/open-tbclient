package com.tencent.turingfd.sdk.ams.au;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import java.io.File;
/* loaded from: classes4.dex */
public class bi {

    /* renamed from: a  reason: collision with root package name */
    public static final String f13813a = y.a(y.f13855b);

    /* renamed from: b  reason: collision with root package name */
    public static final String f13814b = y.a(y.c);
    public static final String c = y.a(y.d);
    public static final String d = y.a(y.e);
    public static final String e = y.a(y.f);
    public static long f = 0;
    public static final String[] g = {"^/data/user/\\d+$", "^/data/data$"};

    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f13815a;

        /* renamed from: b  reason: collision with root package name */
        public final String f13816b;

        public a(boolean z, String str) {
            this.f13815a = z;
            this.f13816b = str;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public static java.lang.String a(android.content.Context r13) {
        /*
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            long r8 = java.lang.System.currentTimeMillis()
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            android.content.Context r0 = r13.getApplicationContext()
            java.io.File r0 = r0.getFilesDir()
            java.io.File r2 = r0.getParentFile()
            if (r2 != 0) goto L12e
            com.tencent.turingfd.sdk.ams.au.bi$a r0 = new com.tencent.turingfd.sdk.ams.au.bi$a
            r1 = 0
            java.lang.String r2 = ""
            r0.<init>(r1, r2)
        L25:
            boolean r1 = r0.f13815a
            if (r1 == 0) goto L1c5
            java.lang.String r1 = r0.f13816b
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L1c5
            r1 = 0
            r2 = 1
            r3 = 0
            int r1 = com.tencent.turingfd.sdk.ams.au.aj.a(r1, r2, r3)
            com.tencent.turingfd.sdk.ams.au.au r2 = new com.tencent.turingfd.sdk.ams.au.au
            r2.<init>()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = com.tencent.turingfd.sdk.ams.au.bi.f13813a
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r4 = com.tencent.turingfd.sdk.ams.au.bi.c
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r3 = r3.toString()
            r2.f13792a = r3
            java.lang.String r0 = r0.f13816b
            r2.f13793b = r0
            r10.add(r2)
            r0 = r1
        L5c:
            android.content.Context r11 = r13.getApplicationContext()
            if (r11 != 0) goto L1ce
            com.tencent.turingfd.sdk.ams.au.bi$a r1 = new com.tencent.turingfd.sdk.ams.au.bi$a
            r2 = 0
            java.lang.String r3 = ""
            r1.<init>(r2, r3)
        L6b:
            boolean r2 = r1.f13815a
            r3 = 1
            int r2 = com.tencent.turingfd.sdk.ams.au.aj.a(r0, r2, r3)
            boolean r0 = r1.f13815a
            if (r0 == 0) goto L99
            com.tencent.turingfd.sdk.ams.au.au r0 = new com.tencent.turingfd.sdk.ams.au.au
            r0.<init>()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = com.tencent.turingfd.sdk.ams.au.bi.f13813a
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r4 = com.tencent.turingfd.sdk.ams.au.bi.d
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r3 = r3.toString()
            r0.f13792a = r3
            java.lang.String r1 = r1.f13816b
            r0.f13793b = r1
            r10.add(r0)
        L99:
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 17
            if (r0 >= r1) goto L30c
            com.tencent.turingfd.sdk.ams.au.bi$a r0 = new com.tencent.turingfd.sdk.ams.au.bi$a
            r1 = 0
            java.lang.String r3 = ""
            r0.<init>(r1, r3)
        La8:
            boolean r1 = r0.f13815a
            r3 = 2
            int r1 = com.tencent.turingfd.sdk.ams.au.aj.a(r2, r1, r3)
            boolean r2 = r0.f13815a
            if (r2 == 0) goto Ld6
            com.tencent.turingfd.sdk.ams.au.au r2 = new com.tencent.turingfd.sdk.ams.au.au
            r2.<init>()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = com.tencent.turingfd.sdk.ams.au.bi.f13813a
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r4 = com.tencent.turingfd.sdk.ams.au.bi.e
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r3 = r3.toString()
            r2.f13792a = r3
            java.lang.String r0 = r0.f13816b
            r2.f13793b = r0
            r10.add(r2)
        Ld6:
            if (r1 <= 0) goto L100
            com.tencent.turingfd.sdk.ams.au.au r0 = new com.tencent.turingfd.sdk.ams.au.au
            r0.<init>()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = com.tencent.turingfd.sdk.ams.au.bi.f13813a
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = com.tencent.turingfd.sdk.ams.au.bi.f13814b
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0.f13792a = r2
            java.lang.String r2 = ""
            java.lang.String r1 = com.tencent.turingfd.sdk.ams.au.ab.a(r2, r1)
            r0.f13793b = r1
            r10.add(r0)
        L100:
            long r0 = java.lang.System.currentTimeMillis()
            long r0 = r0 - r8
            com.tencent.turingfd.sdk.ams.au.bi.f = r0
            java.util.Iterator r1 = r10.iterator()
        L10b:
            boolean r0 = r1.hasNext()
            if (r0 == 0) goto L412
            java.lang.Object r0 = r1.next()
            com.tencent.turingfd.sdk.ams.au.au r0 = (com.tencent.turingfd.sdk.ams.au.au) r0
            java.lang.String r2 = r0.f13792a
            r7.append(r2)
            java.lang.String r2 = ":"
            r7.append(r2)
            java.lang.String r0 = r0.f13793b
            r7.append(r0)
            java.lang.String r0 = ","
            r7.append(r0)
            goto L10b
        L12e:
            java.io.File r3 = r2.getParentFile()
            if (r3 != 0) goto L13f
            com.tencent.turingfd.sdk.ams.au.bi$a r0 = new com.tencent.turingfd.sdk.ams.au.bi$a
            r1 = 0
            java.lang.String r2 = ""
            r0.<init>(r1, r2)
            goto L25
        L13f:
            r0 = 1
            java.lang.String[] r4 = com.tencent.turingfd.sdk.ams.au.bi.g
            int r5 = r4.length
            r1 = 0
        L144:
            if (r1 >= r5) goto L42f
            r6 = r4[r1]
            java.util.regex.Pattern r6 = java.util.regex.Pattern.compile(r6)
            java.lang.String r11 = r3.getAbsolutePath()
            java.util.regex.Matcher r6 = r6.matcher(r11)
            boolean r6 = r6.find()
            if (r6 == 0) goto L19d
            r0 = 0
            r1 = r0
        L15c:
            java.lang.String r2 = r2.getAbsolutePath()
            java.lang.String r0 = r13.getPackageName()
            java.lang.String r3 = "/"
            r4 = 6
            java.lang.String[] r3 = r2.split(r3, r4)
            java.lang.String r4 = "/data/data/"
            boolean r4 = r2.startsWith(r4)
            if (r4 == 0) goto L1a0
            int r4 = r3.length
            r5 = 4
            if (r4 < r5) goto L1a0
            r4 = 3
            r4 = r3[r4]
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L1a0
            r0 = 3
            r0 = r3[r0]
            r2 = r0
        L186:
            if (r1 == 0) goto L1bb
            java.lang.String r0 = r13.getPackageName()
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L1bb
            com.tencent.turingfd.sdk.ams.au.bi$a r0 = new com.tencent.turingfd.sdk.ams.au.bi$a
            java.lang.String r2 = a(r13, r2)
            r0.<init>(r1, r2)
            goto L25
        L19d:
            int r1 = r1 + 1
            goto L144
        L1a0:
            java.lang.String r4 = "/data/user/"
            boolean r2 = r2.startsWith(r4)
            if (r2 == 0) goto L42c
            int r2 = r3.length
            r4 = 5
            if (r2 < r4) goto L42c
            r2 = 4
            r2 = r3[r2]
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L42c
            r0 = 4
            r0 = r3[r0]
            r2 = r0
            goto L186
        L1bb:
            com.tencent.turingfd.sdk.ams.au.bi$a r0 = new com.tencent.turingfd.sdk.ams.au.bi$a
            java.lang.String r2 = ""
            r0.<init>(r1, r2)
            goto L25
        L1c5:
            r0 = 0
            r1 = 0
            r2 = 0
            int r0 = com.tencent.turingfd.sdk.ams.au.aj.a(r0, r1, r2)
            goto L5c
        L1ce:
            r6 = 0
            r2 = 0
            r1 = 0
            java.io.FileReader r3 = new java.io.FileReader     // Catch: java.lang.Throwable -> L2c0
            java.lang.String r4 = "/proc/self/maps"
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L2c0
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L2b7
            r4.<init>(r3)     // Catch: java.lang.Throwable -> L2b7
        L1de:
            java.lang.String r5 = r4.readLine()     // Catch: java.lang.Throwable -> L2a0
            if (r5 == 0) goto L251
            r6 = 47
            int r6 = r5.indexOf(r6)     // Catch: java.lang.Throwable -> L2a0
            r12 = -1
            if (r6 == r12) goto L1de
            java.lang.String r5 = r5.substring(r6)     // Catch: java.lang.Throwable -> L2a0
            java.lang.String r5 = r5.trim()     // Catch: java.lang.Throwable -> L2a0
            int r6 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L2a0
            r12 = 23
            if (r6 >= r12) goto L27f
            java.lang.String r6 = "/data/dalvik-cache/"
            boolean r6 = r5.startsWith(r6)     // Catch: java.lang.Throwable -> L2a0
            if (r6 == 0) goto L1de
            java.lang.String r6 = ".apk@classes.dex"
            boolean r6 = r5.endsWith(r6)     // Catch: java.lang.Throwable -> L2a0
            if (r6 == 0) goto L1de
            r6 = 47
            int r6 = r5.lastIndexOf(r6)     // Catch: java.lang.Throwable -> L2a0
            r12 = -1
            if (r6 == r12) goto L1de
            int r12 = r5.length()     // Catch: java.lang.Throwable -> L2a0
            int r12 = r12 + (-12)
            java.lang.String r5 = r5.substring(r6, r12)     // Catch: java.lang.Throwable -> L2a0
            r6 = 64
            r12 = 47
            java.lang.String r5 = r5.replace(r6, r12)     // Catch: java.lang.Throwable -> L2a0
            java.lang.String r6 = "/data/app/"
            boolean r6 = r5.startsWith(r6)     // Catch: java.lang.Throwable -> L2a0
            if (r6 == 0) goto L1de
            java.io.File r6 = new java.io.File     // Catch: java.lang.Throwable -> L2a0
            r6.<init>(r5)     // Catch: java.lang.Throwable -> L2a0
            java.lang.String r5 = "base.apk"
            java.lang.String r12 = r6.getName()     // Catch: java.lang.Throwable -> L2a0
            boolean r5 = r5.equals(r12)     // Catch: java.lang.Throwable -> L2a0
            if (r5 == 0) goto L27a
            java.io.File r5 = r6.getParentFile()     // Catch: java.lang.Throwable -> L2a0
            if (r5 == 0) goto L251
            java.io.File r1 = r6.getParentFile()     // Catch: java.lang.Throwable -> L2a0
            java.lang.String r1 = r1.getName()     // Catch: java.lang.Throwable -> L2a0
        L251:
            com.tencent.turingfd.sdk.ams.au.aj.b(r3)
            com.tencent.turingfd.sdk.ams.au.aj.b(r4)
        L257:
            r3 = 0
            java.lang.String r2 = r11.getPackageName()
            boolean r4 = android.text.TextUtils.isEmpty(r1)
            if (r4 != 0) goto L26c
            java.lang.String r4 = "-"
            int r4 = r1.indexOf(r4)
            r5 = -1
            if (r4 != r5) goto L2c6
        L26c:
            r4 = r2
        L26d:
            if (r3 == 0) goto L302
            com.tencent.turingfd.sdk.ams.au.bi$a r1 = new com.tencent.turingfd.sdk.ams.au.bi$a
            java.lang.String r2 = a(r13, r4)
            r1.<init>(r3, r2)
            goto L6b
        L27a:
            java.lang.String r1 = r6.getName()     // Catch: java.lang.Throwable -> L2a0
            goto L251
        L27f:
            java.lang.String r6 = "/data/app/"
            boolean r6 = r5.startsWith(r6)     // Catch: java.lang.Throwable -> L2a0
            if (r6 == 0) goto L1de
            java.lang.String r6 = "/base.odex"
            boolean r6 = r5.endsWith(r6)     // Catch: java.lang.Throwable -> L2a0
            if (r6 == 0) goto L1de
            java.lang.String r6 = "/"
            java.lang.String[] r5 = r5.split(r6)     // Catch: java.lang.Throwable -> L2a0
            int r6 = r5.length     // Catch: java.lang.Throwable -> L2a0
            r12 = 7
            if (r6 < r12) goto L1de
            r1 = 3
            r1 = r5[r1]
            goto L251
        L2a0:
            r1 = move-exception
            r5 = r1
            r1 = r3
        L2a3:
            r5.printStackTrace()     // Catch: java.lang.Throwable -> L41d
            com.tencent.turingfd.sdk.ams.au.aj.b(r1)
            com.tencent.turingfd.sdk.ams.au.aj.b(r4)
            r1 = r2
            goto L257
        L2ae:
            r0 = move-exception
            r2 = 0
        L2b0:
            com.tencent.turingfd.sdk.ams.au.aj.b(r3)
            com.tencent.turingfd.sdk.ams.au.aj.b(r2)
            throw r0
        L2b7:
            r1 = move-exception
            r5 = r1
            r4 = r6
            r1 = r3
            goto L2a3
        L2bc:
            r0 = move-exception
            r3 = 0
            r2 = 0
            goto L2b0
        L2c0:
            r1 = move-exception
            r3 = r1
            r1 = 0
            r5 = r3
            r4 = r6
            goto L2a3
        L2c6:
            r5 = 0
            java.lang.String r1 = r1.substring(r5, r4)
            boolean r4 = android.text.TextUtils.isEmpty(r1)
            if (r4 != 0) goto L26c
            java.io.File r3 = new java.io.File
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "/data/data/"
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.StringBuilder r4 = r4.append(r1)
            java.lang.String r4 = r4.toString()
            r3.<init>(r4)
            boolean r4 = r3.exists()
            if (r4 == 0) goto L300
            boolean r3 = r3.canWrite()
            if (r3 == 0) goto L300
        L2f6:
            boolean r2 = android.text.TextUtils.equals(r2, r1)
            r2 = r2 ^ 1
            r3 = r2
            r4 = r1
            goto L26d
        L300:
            r1 = r2
            goto L2f6
        L302:
            com.tencent.turingfd.sdk.ams.au.bi$a r1 = new com.tencent.turingfd.sdk.ams.au.bi$a
            java.lang.String r2 = ""
            r1.<init>(r3, r2)
            goto L6b
        L30c:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r0 = "HUAWEI"
            java.lang.String r1 = android.os.Build.BRAND
            boolean r0 = r0.equalsIgnoreCase(r1)
            if (r0 == 0) goto L387
            java.lang.String r0 = "android.os.UserManager"
            java.lang.Class r1 = java.lang.Class.forName(r0)     // Catch: java.lang.Throwable -> L429
            java.lang.Class r0 = r13.getClass()     // Catch: java.lang.Throwable -> L429
            java.lang.String r4 = "USER_SERVICE"
            java.lang.reflect.Field r0 = r0.getField(r4)     // Catch: java.lang.Throwable -> L429
            r4 = 1
            r0.setAccessible(r4)     // Catch: java.lang.Throwable -> L429
            java.lang.Object r0 = r0.get(r13)     // Catch: java.lang.Throwable -> L429
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Throwable -> L429
            java.lang.Object r0 = r13.getSystemService(r0)     // Catch: java.lang.Throwable -> L429
            if (r0 != 0) goto L36d
        L33e:
            java.lang.String r0 = ""
        L341:
            java.lang.String r1 = new java.lang.String     // Catch: java.lang.Throwable -> L420
            java.lang.String r4 = "5YiG6Lqr5bqU55So"
            r5 = 0
            byte[] r4 = android.util.Base64.decode(r4, r5)     // Catch: java.lang.Throwable -> L420
            r1.<init>(r4)     // Catch: java.lang.Throwable -> L420
            boolean r4 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L420
            if (r4 != 0) goto L425
            boolean r0 = r1.equals(r0)     // Catch: java.lang.Throwable -> L420
            if (r0 == 0) goto L425
            r0 = 1
            java.lang.String r1 = "HuaWei"
            r3.append(r1)     // Catch: java.lang.Throwable -> L40d
            r1 = r0
        L362:
            com.tencent.turingfd.sdk.ams.au.bi$a r0 = new com.tencent.turingfd.sdk.ams.au.bi$a
            java.lang.String r3 = r3.toString()
            r0.<init>(r1, r3)
            goto La8
        L36d:
            java.lang.String r4 = "getUserName"
            r5 = 0
            java.lang.Class[] r5 = new java.lang.Class[r5]     // Catch: java.lang.Throwable -> L429
            java.lang.reflect.Method r1 = r1.getMethod(r4, r5)     // Catch: java.lang.Throwable -> L429
            if (r1 == 0) goto L33e
            r4 = 1
            r1.setAccessible(r4)     // Catch: java.lang.Throwable -> L429
            r4 = 0
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch: java.lang.Throwable -> L429
            java.lang.Object r0 = r1.invoke(r0, r4)     // Catch: java.lang.Throwable -> L429
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Throwable -> L429
            goto L341
        L387:
            java.lang.String r0 = "xiaomi"
            java.lang.String r1 = android.os.Build.BRAND
            boolean r0 = r0.equalsIgnoreCase(r1)
            if (r0 == 0) goto L3a1
            boolean r0 = a()
            if (r0 == 0) goto L425
            r0 = 1
            java.lang.String r1 = "XiaoMi"
            r3.append(r1)
            r1 = r0
            goto L362
        L3a1:
            java.lang.String r0 = "oppo"
            java.lang.String r1 = android.os.Build.BRAND
            boolean r0 = r0.equalsIgnoreCase(r1)
            if (r0 == 0) goto L3bb
            boolean r0 = a()
            if (r0 == 0) goto L425
            r0 = 1
            java.lang.String r1 = "OPPO"
            r3.append(r1)
            r1 = r0
            goto L362
        L3bb:
            java.lang.String r0 = "vivo"
            java.lang.String r1 = android.os.Build.BRAND
            boolean r0 = r0.equalsIgnoreCase(r1)
            if (r0 == 0) goto L425
            boolean r0 = a()
            if (r0 == 0) goto L3d5
            r0 = 1
            java.lang.String r1 = "VIVO_A"
            r3.append(r1)
            r1 = r0
            goto L362
        L3d5:
            java.lang.String r0 = new java.lang.String     // Catch: java.lang.Throwable -> L420
            java.lang.String r1 = "/proc/self/mountinfo"
            byte[] r1 = com.tencent.turingfd.sdk.ams.au.aj.b(r1)     // Catch: java.lang.Throwable -> L420
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L420
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L420
            r1.<init>()     // Catch: java.lang.Throwable -> L420
            android.content.Context r4 = r13.getApplicationContext()     // Catch: java.lang.Throwable -> L420
            java.lang.String r4 = r4.getPackageName()     // Catch: java.lang.Throwable -> L420
            java.lang.StringBuilder r1 = r1.append(r4)     // Catch: java.lang.Throwable -> L420
            java.lang.String r4 = "_cloned"
            java.lang.StringBuilder r1 = r1.append(r4)     // Catch: java.lang.Throwable -> L420
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L420
            boolean r0 = r0.contains(r1)     // Catch: java.lang.Throwable -> L420
            if (r0 == 0) goto L425
            r0 = 1
            java.lang.String r1 = "VIVO_B"
            r3.append(r1)     // Catch: java.lang.Throwable -> L40d
            r1 = r0
            goto L362
        L40d:
            r0 = move-exception
            r0 = 1
            r1 = r0
            goto L362
        L412:
            java.lang.String r0 = r7.toString()
            return r0
        L417:
            r0 = move-exception
            r1 = r3
            r2 = r4
        L41a:
            r3 = r1
            goto L2b0
        L41d:
            r0 = move-exception
            r2 = r4
            goto L41a
        L420:
            r0 = move-exception
            r0 = 0
            r1 = r0
            goto L362
        L425:
            r0 = 0
            r1 = r0
            goto L362
        L429:
            r0 = move-exception
            goto L33e
        L42c:
            r2 = r0
            goto L186
        L42f:
            r1 = r0
            goto L15c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.turingfd.sdk.ams.au.bi.a(android.content.Context):java.lang.String");
    }

    public static String a(Context context, String str) {
        String str2;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
        try {
            str2 = context.getPackageManager().getApplicationInfo(str, 0).sourceDir;
        } catch (PackageManager.NameNotFoundException e2) {
            str2 = "";
        }
        try {
            sb.append(aj.b(new File(str2)).get(0));
        } catch (Throwable th) {
            sb.append("");
        }
        sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
        long j = -1;
        if (!TextUtils.isEmpty(str2)) {
            File file = new File(str2);
            if (file.exists()) {
                j = file.length();
            }
        }
        sb.append(j);
        sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
        sb.append(Process.myUid());
        return sb.toString();
    }

    public static boolean a() {
        return 999 == Process.myUid() / 100000;
    }

    public static String b() {
        return ab.a("").append(f).toString();
    }
}
