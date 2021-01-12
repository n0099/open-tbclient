package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.AdSlot;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;
import java.lang.reflect.Method;
/* loaded from: classes4.dex */
public class ag implements Thread.UncaughtExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    private Thread.UncaughtExceptionHandler f7546a = Thread.getDefaultUncaughtExceptionHandler();

    /* renamed from: b  reason: collision with root package name */
    private String f7547b;

    public static ag a() {
        return new ag();
    }

    private ag() {
        Thread.setDefaultUncaughtExceptionHandler(this);
        b();
    }

    private void b() {
        File externalFilesDir;
        Context a2 = com.bytedance.sdk.openadsdk.core.p.a();
        if (a2 != null) {
            try {
                if ("mounted".equals(Environment.getExternalStorageState()) && (externalFilesDir = a2.getExternalFilesDir("TTCache")) != null) {
                    externalFilesDir.mkdirs();
                    this.f7547b = externalFilesDir.getPath();
                }
                if (TextUtils.isEmpty(this.f7547b)) {
                    File file = new File(a2.getFilesDir(), "TTCache");
                    file.mkdirs();
                    this.f7547b = file.getPath();
                }
            } catch (Throwable th) {
            }
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        boolean z = false;
        try {
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            String stringWriter2 = stringWriter.toString();
            if (stringWriter2 != null) {
                z = stringWriter2.contains(AdSlot.class.getPackage().getName());
            }
        } catch (Throwable th2) {
        }
        if (z) {
            a(thread, th);
        }
        if (this.f7546a != null && this.f7546a != this) {
            this.f7546a.uncaughtException(thread, th);
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
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [172=5, 174=4, 179=4, 181=4, 182=4] */
    private void a(java.lang.Thread r13, java.lang.Throwable r14) {
        /*
            r12 = this;
            r2 = 0
            r0 = 0
            r4 = 1
            r1 = 0
            r3 = 0
            java.lang.String r5 = r12.f7547b     // Catch: java.lang.Throwable -> L170
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> L170
            if (r5 == 0) goto L10
            r12.b()     // Catch: java.lang.Throwable -> L170
        L10:
            java.lang.String r5 = r12.f7547b     // Catch: java.lang.Throwable -> L170
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> L170
            if (r5 == 0) goto L23
            if (r2 == 0) goto L1d
            r1.close()     // Catch: java.lang.Throwable -> L159
        L1d:
            if (r2 == 0) goto L22
            r3.close()     // Catch: java.lang.Throwable -> L15c
        L22:
            return
        L23:
            java.io.File r6 = new java.io.File     // Catch: java.lang.Throwable -> L170
            java.lang.String r1 = r12.f7547b     // Catch: java.lang.Throwable -> L170
            java.lang.String r3 = "tt_crash_count.properties"
            r6.<init>(r1, r3)     // Catch: java.lang.Throwable -> L170
            boolean r1 = r6.exists()     // Catch: java.lang.Throwable -> L170
            if (r1 == 0) goto L116
            boolean r1 = r6.isFile()     // Catch: java.lang.Throwable -> L170
            if (r1 == 0) goto L116
            boolean r1 = r6.canRead()     // Catch: java.lang.Throwable -> L170
            if (r1 == 0) goto L116
            java.util.Properties r7 = new java.util.Properties     // Catch: java.lang.Throwable -> L170
            r7.<init>()     // Catch: java.lang.Throwable -> L170
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L170
            r3.<init>(r6)     // Catch: java.lang.Throwable -> L170
            r7.load(r3)     // Catch: java.lang.Throwable -> L174
            java.lang.String r1 = "crash_count"
            java.lang.String r5 = "0"
            java.lang.String r1 = r7.getProperty(r1, r5)     // Catch: java.lang.Throwable -> L174
            java.lang.String r5 = "crash_last_time"
            java.lang.String r8 = "0"
            java.lang.String r5 = r7.getProperty(r5, r8)     // Catch: java.lang.Throwable -> L174
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch: java.lang.Throwable -> L174
            int r1 = r1.intValue()     // Catch: java.lang.Throwable -> L174
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch: java.lang.Throwable -> L174
            long r8 = r5.longValue()     // Catch: java.lang.Throwable -> L174
            long r10 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L174
            long r8 = r10 - r8
            r10 = 300000(0x493e0, double:1.482197E-318)
            int r5 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r5 >= 0) goto Lcf
            int r1 = r1 + 1
            r5 = r0
        L80:
            r8 = 3
            if (r1 < r8) goto Ld2
        L83:
            if (r4 == 0) goto L17a
        L85:
            java.lang.String r1 = "TTCrashHandler"
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L174
            r8.<init>()     // Catch: java.lang.Throwable -> L174
            java.lang.String r9 = "=="
            java.lang.StringBuilder r8 = r8.append(r9)     // Catch: java.lang.Throwable -> L174
            java.lang.StringBuilder r8 = r8.append(r0)     // Catch: java.lang.Throwable -> L174
            java.lang.String r9 = ", "
            java.lang.StringBuilder r8 = r8.append(r9)     // Catch: java.lang.Throwable -> L174
            java.lang.StringBuilder r8 = r8.append(r4)     // Catch: java.lang.Throwable -> L174
            java.lang.String r9 = ", "
            java.lang.StringBuilder r8 = r8.append(r9)     // Catch: java.lang.Throwable -> L174
            java.lang.StringBuilder r8 = r8.append(r5)     // Catch: java.lang.Throwable -> L174
            java.lang.String r8 = r8.toString()     // Catch: java.lang.Throwable -> L174
            com.bytedance.sdk.openadsdk.utils.u.f(r1, r8)     // Catch: java.lang.Throwable -> L174
            if (r4 == 0) goto Ld7
            r6.delete()     // Catch: java.lang.Throwable -> Ld4
            r1 = r2
        Lbb:
            if (r4 == 0) goto Lc0
            r12.c()     // Catch: java.lang.Throwable -> Lfd
        Lc0:
            if (r3 == 0) goto Lc5
            r3.close()     // Catch: java.lang.Throwable -> L15f
        Lc5:
            if (r1 == 0) goto L22
            r1.close()     // Catch: java.lang.Throwable -> Lcc
            goto L22
        Lcc:
            r0 = move-exception
            goto L22
        Lcf:
            r5 = r4
            r1 = r4
            goto L80
        Ld2:
            r4 = r0
            goto L83
        Ld4:
            r0 = move-exception
            r1 = r2
            goto Lbb
        Ld7:
            java.lang.String r1 = "crash_count"
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch: java.lang.Throwable -> L174
            r7.setProperty(r1, r0)     // Catch: java.lang.Throwable -> L174
            if (r5 == 0) goto Lf1
            java.lang.String r0 = "crash_last_time"
            long r8 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L174
            java.lang.String r1 = java.lang.String.valueOf(r8)     // Catch: java.lang.Throwable -> L174
            r7.setProperty(r0, r1)     // Catch: java.lang.Throwable -> L174
        Lf1:
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L174
            r1.<init>(r6)     // Catch: java.lang.Throwable -> L174
            java.lang.String r0 = "tt_crash_info"
            r7.store(r1, r0)     // Catch: java.lang.Throwable -> Lfd
            goto Lbb
        Lfd:
            r0 = move-exception
        Lfe:
            java.lang.String r2 = "TTCrashHandler"
            java.lang.String r4 = "crash count error"
            com.bytedance.sdk.openadsdk.utils.u.c(r2, r4, r0)     // Catch: java.lang.Throwable -> L16b
            if (r3 == 0) goto L10c
            r3.close()     // Catch: java.lang.Throwable -> L162
        L10c:
            if (r1 == 0) goto L22
            r1.close()     // Catch: java.lang.Throwable -> L113
            goto L22
        L113:
            r0 = move-exception
            goto L22
        L116:
            java.util.Properties r0 = new java.util.Properties     // Catch: java.lang.Throwable -> L170
            r0.<init>()     // Catch: java.lang.Throwable -> L170
            java.lang.String r1 = "crash_count"
            r3 = 1
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch: java.lang.Throwable -> L170
            r0.setProperty(r1, r3)     // Catch: java.lang.Throwable -> L170
            java.lang.String r1 = "crash_last_time"
            long r4 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L170
            java.lang.String r3 = java.lang.String.valueOf(r4)     // Catch: java.lang.Throwable -> L170
            r0.setProperty(r1, r3)     // Catch: java.lang.Throwable -> L170
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L170
            r1.<init>(r6)     // Catch: java.lang.Throwable -> L170
            java.lang.String r3 = "tt_crash_info"
            r0.store(r1, r3)     // Catch: java.lang.Throwable -> L177
            java.lang.String r0 = "TTCrashHandler"
            java.lang.String r3 = "==first"
            com.bytedance.sdk.openadsdk.utils.u.f(r0, r3)     // Catch: java.lang.Throwable -> L177
            r3 = r2
            goto Lc0
        L14b:
            r0 = move-exception
            r1 = r2
            r3 = r2
        L14e:
            if (r3 == 0) goto L153
            r3.close()     // Catch: java.lang.Throwable -> L164
        L153:
            if (r1 == 0) goto L158
            r1.close()     // Catch: java.lang.Throwable -> L166
        L158:
            throw r0
        L159:
            r0 = move-exception
            goto L1d
        L15c:
            r0 = move-exception
            goto L22
        L15f:
            r0 = move-exception
            goto Lc5
        L162:
            r0 = move-exception
            goto L10c
        L164:
            r2 = move-exception
            goto L153
        L166:
            r1 = move-exception
            goto L158
        L168:
            r0 = move-exception
            r1 = r2
            goto L14e
        L16b:
            r0 = move-exception
            goto L14e
        L16d:
            r0 = move-exception
            r3 = r2
            goto L14e
        L170:
            r0 = move-exception
            r1 = r2
            r3 = r2
            goto Lfe
        L174:
            r0 = move-exception
            r1 = r2
            goto Lfe
        L177:
            r0 = move-exception
            r3 = r2
            goto Lfe
        L17a:
            r0 = r1
            goto L85
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.utils.ag.a(java.lang.Thread, java.lang.Throwable):void");
    }

    private void c() {
        try {
            Method a2 = ah.a("com.bytedance.sdk.openadsdk.TTC2Proxy", "a", Context.class);
            if (a2 != null) {
                a2.invoke(null, com.bytedance.sdk.openadsdk.core.p.a());
            }
        } catch (Throwable th) {
        }
        try {
            Method a3 = ah.a("com.bytedance.sdk.openadsdk.TTC3Proxy", "a", Context.class);
            if (a3 != null) {
                a3.invoke(null, com.bytedance.sdk.openadsdk.core.p.a());
            }
        } catch (Throwable th2) {
        }
        try {
            com.bytedance.sdk.openadsdk.core.h.i.a();
        } catch (Throwable th3) {
        }
        try {
            com.bytedance.sdk.openadsdk.core.widget.webview.a.a.b();
        } catch (Throwable th4) {
        }
        try {
            String b2 = com.bytedance.sdk.adnet.a.b(com.bytedance.sdk.openadsdk.core.p.a());
            if (!TextUtils.isEmpty(b2)) {
                File file = new File(b2);
                if (file.exists()) {
                    l.c(file);
                }
            }
        } catch (Throwable th5) {
        }
        try {
            com.bytedance.sdk.openadsdk.downloadnew.a.e.e();
        } catch (Throwable th6) {
        }
    }
}
