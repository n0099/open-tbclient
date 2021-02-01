package com.bytedance.sdk.openadsdk.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.meizu.cloud.pushsdk.constants.PushConstants;
/* loaded from: classes6.dex */
public class aa {

    /* renamed from: a  reason: collision with root package name */
    private static String f7537a = null;

    public static String a(Context context) {
        String str = f7537a;
        if (TextUtils.isEmpty(str)) {
            try {
                int myPid = Process.myPid();
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningAppProcesses()) {
                    if (runningAppProcessInfo.pid == myPid) {
                        if (u.a()) {
                            u.b("Process", "processName = " + runningAppProcessInfo.processName);
                        }
                        f7537a = runningAppProcessInfo.processName;
                        return f7537a;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            f7537a = a();
            return f7537a;
        }
        return str;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [66=4] */
    private static java.lang.String a() {
        /*
            r0 = 0
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L8a
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L8a
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L8a
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L8a
            r4.<init>()     // Catch: java.lang.Throwable -> L8a
            java.lang.String r5 = "/proc/"
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch: java.lang.Throwable -> L8a
            int r5 = android.os.Process.myPid()     // Catch: java.lang.Throwable -> L8a
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch: java.lang.Throwable -> L8a
            java.lang.String r5 = "/cmdline"
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch: java.lang.Throwable -> L8a
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L8a
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L8a
            java.lang.String r4 = "iso-8859-1"
            r2.<init>(r3, r4)     // Catch: java.lang.Throwable -> L8a
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L8a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L42
            r2.<init>()     // Catch: java.lang.Throwable -> L42
        L37:
            int r3 = r1.read()     // Catch: java.lang.Throwable -> L42
            if (r3 <= 0) goto L49
            char r3 = (char) r3     // Catch: java.lang.Throwable -> L42
            r2.append(r3)     // Catch: java.lang.Throwable -> L42
            goto L37
        L42:
            r2 = move-exception
        L43:
            if (r1 == 0) goto L48
            r1.close()     // Catch: java.lang.Exception -> L82
        L48:
            return r0
        L49:
            boolean r3 = com.bytedance.sdk.openadsdk.utils.u.a()     // Catch: java.lang.Throwable -> L42
            if (r3 == 0) goto L6d
            java.lang.String r3 = "Process"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L42
            r4.<init>()     // Catch: java.lang.Throwable -> L42
            java.lang.String r5 = "get processName = "
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch: java.lang.Throwable -> L42
            java.lang.String r5 = r2.toString()     // Catch: java.lang.Throwable -> L42
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch: java.lang.Throwable -> L42
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L42
            com.bytedance.sdk.openadsdk.utils.u.b(r3, r4)     // Catch: java.lang.Throwable -> L42
        L6d:
            java.lang.String r0 = r2.toString()     // Catch: java.lang.Throwable -> L42
            if (r1 == 0) goto L48
            r1.close()     // Catch: java.lang.Exception -> L77
            goto L48
        L77:
            r1 = move-exception
            goto L48
        L79:
            r1 = move-exception
            r2 = r1
            r3 = r0
        L7c:
            if (r3 == 0) goto L81
            r3.close()     // Catch: java.lang.Exception -> L84
        L81:
            throw r2
        L82:
            r1 = move-exception
            goto L48
        L84:
            r0 = move-exception
            goto L81
        L86:
            r0 = move-exception
            r2 = r0
            r3 = r1
            goto L7c
        L8a:
            r1 = move-exception
            r1 = r0
            goto L43
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.utils.aa.a():java.lang.String");
    }
}
