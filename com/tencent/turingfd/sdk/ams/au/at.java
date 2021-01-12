package com.tencent.turingfd.sdk.ams.au;

import android.content.Context;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import java.io.File;
/* loaded from: classes3.dex */
public class at {

    /* renamed from: a  reason: collision with root package name */
    public static final String f13491a = ab.a("mpdc_").append(af.f13467a).append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS).append(1).toString();

    public static File a(Context context) {
        File dir = context.getDir("turingfd", 0);
        if (dir == null) {
            return null;
        }
        return new File(dir, f13491a);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public static java.lang.String b(android.content.Context r16) {
        /*
            java.lang.Class<com.tencent.turingfd.sdk.ams.au.at> r0 = com.tencent.turingfd.sdk.ams.au.at.class
            monitor-enter(r0)
            java.lang.String r3 = r16.getPackageName()     // Catch: java.lang.Throwable -> L111
            boolean r0 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Throwable -> L111
            if (r0 == 0) goto L17
        Ld:
            r0 = 0
        Le:
            if (r0 != 0) goto L128
            java.lang.String r0 = ""
        L13:
            java.lang.Class<com.tencent.turingfd.sdk.ams.au.at> r1 = com.tencent.turingfd.sdk.ams.au.at.class
            monitor-exit(r1)
            return r0
        L17:
            android.content.pm.PackageManager r0 = r16.getPackageManager()     // Catch: java.lang.Throwable -> L111
            r1 = 64
            android.content.pm.PackageInfo r2 = r0.getPackageInfo(r3, r1)     // Catch: java.lang.Throwable -> L25f
            android.content.pm.ApplicationInfo r0 = r2.applicationInfo     // Catch: java.lang.Throwable -> L111
            if (r0 == 0) goto Ld
            java.lang.String r8 = r0.sourceDir     // Catch: java.lang.Throwable -> L111
            if (r8 == 0) goto Ld
            java.io.File r4 = new java.io.File     // Catch: java.lang.Throwable -> L111
            r4.<init>(r8)     // Catch: java.lang.Throwable -> L111
            int r9 = r0.flags     // Catch: java.lang.Throwable -> L111
            long r0 = r4.length()     // Catch: java.lang.Throwable -> Lff
            r6 = r0
        L35:
            long r0 = r4.lastModified()     // Catch: java.lang.Throwable -> L105
            r4 = 1000(0x3e8, double:4.94E-321)
            long r0 = r0 / r4
            r4 = r0
        L3d:
            java.lang.String r0 = r2.versionName     // Catch: java.lang.Throwable -> L111
            java.lang.String r10 = com.tencent.turingfd.sdk.ams.au.aj.d(r0)     // Catch: java.lang.Throwable -> L111
            int r11 = r2.versionCode     // Catch: java.lang.Throwable -> L111
            long r12 = r2.firstInstallTime     // Catch: java.lang.Throwable -> L111
            long r14 = r2.lastUpdateTime     // Catch: java.lang.Throwable -> L111
            java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L111
            android.content.pm.Signature[] r0 = r2.signatures     // Catch: java.lang.Throwable -> L111
            if (r0 == 0) goto L11f
            int r1 = r0.length     // Catch: java.lang.Throwable -> L111
            if (r1 <= 0) goto L11f
            r1 = 0
            r0 = r0[r1]
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream     // Catch: java.lang.Throwable -> L116
            byte[] r0 = r0.toByteArray()     // Catch: java.lang.Throwable -> L116
            r1.<init>(r0)     // Catch: java.lang.Throwable -> L116
            java.lang.String r0 = "X.509"
            java.security.cert.CertificateFactory r0 = java.security.cert.CertificateFactory.getInstance(r0)     // Catch: java.lang.Throwable -> L25b
            java.security.cert.Certificate r0 = r0.generateCertificate(r1)     // Catch: java.lang.Throwable -> L25b
            java.security.cert.X509Certificate r0 = (java.security.cert.X509Certificate) r0     // Catch: java.lang.Throwable -> L25b
            byte[] r0 = r0.getEncoded()     // Catch: java.lang.Throwable -> L25b
            java.lang.String r0 = com.tencent.turingfd.sdk.ams.au.aj.b(r0)     // Catch: java.lang.Throwable -> L25b
            com.tencent.turingfd.sdk.ams.au.aj.b(r1)     // Catch: java.lang.Throwable -> L111
            r1 = r0
        L78:
            boolean r0 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L111
            if (r0 == 0) goto L125
            java.io.File r0 = new java.io.File     // Catch: java.lang.Throwable -> L124
            r0.<init>(r8)     // Catch: java.lang.Throwable -> L124
            java.util.List r0 = com.tencent.turingfd.sdk.ams.au.aj.b(r0)     // Catch: java.lang.Throwable -> L124
            int r2 = r0.size()     // Catch: java.lang.Throwable -> L124
            if (r2 <= 0) goto L125
            r2 = 0
            java.lang.Object r0 = r0.get(r2)     // Catch: java.lang.Throwable -> L124
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Throwable -> L124
            java.lang.String r0 = com.tencent.turingfd.sdk.ams.au.aj.d(r0)     // Catch: java.lang.Throwable -> L124
        L98:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L111
            r1.<init>()     // Catch: java.lang.Throwable -> L111
            java.lang.StringBuilder r1 = r1.append(r6)     // Catch: java.lang.Throwable -> L111
            java.lang.String r2 = ":"
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> L111
            java.lang.StringBuilder r0 = r1.append(r0)     // Catch: java.lang.Throwable -> L111
            java.lang.String r1 = ":"
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> L111
            java.lang.StringBuilder r0 = r0.append(r3)     // Catch: java.lang.Throwable -> L111
            java.lang.String r1 = ":"
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> L111
            java.lang.StringBuilder r0 = r0.append(r10)     // Catch: java.lang.Throwable -> L111
            java.lang.String r1 = ":"
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> L111
            java.lang.StringBuilder r0 = r0.append(r11)     // Catch: java.lang.Throwable -> L111
            java.lang.String r1 = ":"
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> L111
            java.lang.StringBuilder r0 = r0.append(r12)     // Catch: java.lang.Throwable -> L111
            java.lang.String r1 = ":"
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> L111
            java.lang.StringBuilder r0 = r0.append(r14)     // Catch: java.lang.Throwable -> L111
            java.lang.String r1 = ":"
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> L111
            java.lang.StringBuilder r0 = r0.append(r9)     // Catch: java.lang.Throwable -> L111
            java.lang.String r1 = ":"
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> L111
            java.lang.StringBuilder r0 = r0.append(r4)     // Catch: java.lang.Throwable -> L111
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L111
            goto Le
        Lff:
            r0 = move-exception
            r0 = -1
            r6 = r0
            goto L35
        L105:
            r0 = move-exception
            r0 = -1
            r4 = r0
            goto L3d
        L10b:
            r0 = move-exception
            r3 = 0
        L10d:
            com.tencent.turingfd.sdk.ams.au.aj.b(r3)     // Catch: java.lang.Throwable -> L111
            throw r0     // Catch: java.lang.Throwable -> L111
        L111:
            r0 = move-exception
            java.lang.Class<com.tencent.turingfd.sdk.ams.au.at> r1 = com.tencent.turingfd.sdk.ams.au.at.class
            monitor-exit(r1)
            throw r0
        L116:
            r1 = move-exception
            r0 = 0
            r2 = r1
        L119:
            r2.printStackTrace()     // Catch: java.lang.Throwable -> L276
            com.tencent.turingfd.sdk.ams.au.aj.b(r0)     // Catch: java.lang.Throwable -> L111
        L11f:
            java.lang.String r1 = ""
            goto L78
        L124:
            r0 = move-exception
        L125:
            r0 = r1
            goto L98
        L128:
            byte[] r1 = r0.getBytes()     // Catch: java.lang.Throwable -> L111
            byte[] r1 = com.tencent.turingfd.sdk.ams.au.aj.c(r1)     // Catch: java.lang.Throwable -> L111
            java.lang.String r6 = com.tencent.turingfd.sdk.ams.au.aj.d(r1)     // Catch: java.lang.Throwable -> L111
            java.io.File r7 = a(r16)     // Catch: java.lang.Throwable -> L111
            if (r7 != 0) goto L142
            r3 = 0
        L13b:
            if (r3 != 0) goto L1cd
            java.lang.String r0 = ""
            goto L13
        L142:
            boolean r1 = r7.exists()     // Catch: java.lang.Throwable -> L111
            if (r1 != 0) goto L14c
            java.lang.String r3 = ""
            goto L13b
        L14c:
            boolean r1 = r7.isFile()     // Catch: java.lang.Throwable -> L111
            if (r1 != 0) goto L159
            com.tencent.turingfd.sdk.ams.au.aj.a(r7)     // Catch: java.lang.Throwable -> L111
            java.lang.String r3 = ""
            goto L13b
        L159:
            r2 = 0
            r5 = 0
            java.io.ByteArrayOutputStream r8 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L111
            r8.<init>()     // Catch: java.lang.Throwable -> L111
            r3 = 0
            r4 = 0
            java.io.RandomAccessFile r1 = new java.io.RandomAccessFile     // Catch: java.lang.Throwable -> L1c9
            java.lang.String r9 = "rw"
            r1.<init>(r7, r9)     // Catch: java.lang.Throwable -> L1c9
            java.nio.channels.FileChannel r2 = r1.getChannel()     // Catch: java.lang.Throwable -> L246
            java.nio.channels.FileLock r4 = r2.lock()     // Catch: java.lang.Throwable -> L265
            r3 = 32
            java.nio.ByteBuffer r3 = java.nio.ByteBuffer.allocate(r3)     // Catch: java.lang.Throwable -> L187
        L178:
            int r5 = r2.read(r3)     // Catch: java.lang.Throwable -> L187
            if (r5 <= 0) goto L1a0
            byte[] r7 = r3.array()     // Catch: java.lang.Throwable -> L187
            r9 = 0
            r8.write(r7, r9, r5)     // Catch: java.lang.Throwable -> L187
            goto L178
        L187:
            r3 = move-exception
        L188:
            r3 = 0
            r5 = 0
            if (r4 == 0) goto L27c
            boolean r7 = r4.isValid()     // Catch: java.lang.Throwable -> L111
            if (r7 == 0) goto L27c
            r4.release()     // Catch: java.lang.Throwable -> L111 java.io.IOException -> L1b0
            r3 = r5
        L196:
            com.tencent.turingfd.sdk.ams.au.aj.b(r2)     // Catch: java.lang.Throwable -> L111
            com.tencent.turingfd.sdk.ams.au.aj.b(r1)     // Catch: java.lang.Throwable -> L111
            com.tencent.turingfd.sdk.ams.au.aj.b(r8)     // Catch: java.lang.Throwable -> L111
            goto L13b
        L1a0:
            java.lang.String r3 = r8.toString()     // Catch: java.lang.Throwable -> L187
            if (r4 == 0) goto L196
            boolean r5 = r4.isValid()     // Catch: java.lang.Throwable -> L111
            if (r5 == 0) goto L196
            r4.release()     // Catch: java.lang.Throwable -> L111 java.io.IOException -> L1b0
            goto L196
        L1b0:
            r4 = move-exception
            goto L196
        L1b2:
            r0 = move-exception
            r1 = 0
        L1b4:
            if (r3 == 0) goto L1bf
            boolean r4 = r3.isValid()     // Catch: java.lang.Throwable -> L111
            if (r4 == 0) goto L1bf
            r3.release()     // Catch: java.lang.Throwable -> L111 java.io.IOException -> L26b
        L1bf:
            com.tencent.turingfd.sdk.ams.au.aj.b(r2)     // Catch: java.lang.Throwable -> L111
            com.tencent.turingfd.sdk.ams.au.aj.b(r1)     // Catch: java.lang.Throwable -> L111
            com.tencent.turingfd.sdk.ams.au.aj.b(r8)     // Catch: java.lang.Throwable -> L111
            throw r0     // Catch: java.lang.Throwable -> L111
        L1c9:
            r1 = move-exception
            r1 = 0
            r2 = r5
            goto L188
        L1cd:
            boolean r1 = android.text.TextUtils.equals(r3, r6)     // Catch: java.lang.Throwable -> L111
            if (r1 == 0) goto L1d8
            java.lang.String r0 = ""
            goto L13
        L1d8:
            java.io.File r7 = a(r16)     // Catch: java.lang.Throwable -> L111
            if (r7 == 0) goto L13
            r3 = 0
            r5 = 0
            r1 = 0
            r4 = 0
            java.io.RandomAccessFile r2 = new java.io.RandomAccessFile     // Catch: java.lang.Throwable -> L241
            java.lang.String r8 = "rw"
            r2.<init>(r7, r8)     // Catch: java.lang.Throwable -> L241
            java.nio.channels.FileChannel r3 = r2.getChannel()     // Catch: java.lang.Throwable -> L24a
            java.nio.channels.FileLock r1 = r3.lock()     // Catch: java.lang.Throwable -> L24e
            byte[] r4 = r6.getBytes()     // Catch: java.lang.Throwable -> L20b
            int r5 = r4.length     // Catch: java.lang.Throwable -> L20b
            java.nio.ByteBuffer r5 = java.nio.ByteBuffer.allocate(r5)     // Catch: java.lang.Throwable -> L20b
            r5.put(r4)     // Catch: java.lang.Throwable -> L20b
            r5.flip()     // Catch: java.lang.Throwable -> L20b
        L201:
            boolean r6 = r5.hasRemaining()     // Catch: java.lang.Throwable -> L20b
            if (r6 == 0) goto L21f
            r3.write(r5)     // Catch: java.lang.Throwable -> L20b
            goto L201
        L20b:
            r4 = move-exception
        L20c:
            if (r1 == 0) goto L217
            boolean r4 = r1.isValid()     // Catch: java.lang.Throwable -> L111
            if (r4 == 0) goto L217
        L214:
            r1.release()     // Catch: java.lang.Throwable -> L111 java.io.IOException -> L272
        L217:
            com.tencent.turingfd.sdk.ams.au.aj.b(r3)     // Catch: java.lang.Throwable -> L111
            com.tencent.turingfd.sdk.ams.au.aj.b(r2)     // Catch: java.lang.Throwable -> L111
            goto L13
        L21f:
            int r4 = r4.length     // Catch: java.lang.Throwable -> L20b
            long r4 = (long) r4     // Catch: java.lang.Throwable -> L20b
            r3.truncate(r4)     // Catch: java.lang.Throwable -> L20b
            if (r1 == 0) goto L217
            boolean r4 = r1.isValid()     // Catch: java.lang.Throwable -> L111
            if (r4 == 0) goto L217
            goto L214
        L22d:
            r0 = move-exception
            r2 = 0
        L22f:
            if (r1 == 0) goto L23a
            boolean r4 = r1.isValid()     // Catch: java.lang.Throwable -> L111
            if (r4 == 0) goto L23a
            r1.release()     // Catch: java.lang.Throwable -> L111 java.io.IOException -> L274
        L23a:
            com.tencent.turingfd.sdk.ams.au.aj.b(r3)     // Catch: java.lang.Throwable -> L111
            com.tencent.turingfd.sdk.ams.au.aj.b(r2)     // Catch: java.lang.Throwable -> L111
            throw r0     // Catch: java.lang.Throwable -> L111
        L241:
            r1 = move-exception
            r2 = 0
            r1 = r4
            r3 = r5
            goto L20c
        L246:
            r2 = move-exception
            r2 = r5
            goto L188
        L24a:
            r1 = move-exception
            r1 = r4
            r3 = r5
            goto L20c
        L24e:
            r1 = move-exception
            r1 = r4
            goto L20c
        L251:
            r0 = move-exception
            r3 = r4
            goto L1b4
        L255:
            r0 = move-exception
            r2 = r0
            r3 = r1
        L258:
            r0 = r2
            goto L10d
        L25b:
            r2 = move-exception
            r0 = r1
            goto L119
        L25f:
            r0 = move-exception
            goto Ld
        L262:
            r0 = move-exception
            goto L1b4
        L265:
            r3 = move-exception
            goto L188
        L268:
            r0 = move-exception
            goto L1b4
        L26b:
            r3 = move-exception
            goto L1bf
        L26e:
            r0 = move-exception
            goto L22f
        L270:
            r0 = move-exception
            goto L22f
        L272:
            r1 = move-exception
            goto L217
        L274:
            r1 = move-exception
            goto L23a
        L276:
            r1 = move-exception
            r2 = r1
            r3 = r0
            goto L258
        L27a:
            r0 = move-exception
            goto L22f
        L27c:
            r3 = r5
            goto L196
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.turingfd.sdk.ams.au.at.b(android.content.Context):java.lang.String");
    }
}
