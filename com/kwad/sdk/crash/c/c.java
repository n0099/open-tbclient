package com.kwad.sdk.crash.c;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.crash.e;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import java.io.File;
import java.util.concurrent.CountDownLatch;
/* loaded from: classes6.dex */
public final class c extends b {

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final c f34738a = new c();
    }

    public c() {
    }

    public static c d() {
        return a.f34738a;
    }

    @Override // com.kwad.sdk.crash.c.b
    public void a(File file, e eVar, com.kwad.sdk.crash.report.c cVar) {
        super.a(file, eVar, cVar);
        if (com.kwad.sdk.crash.d.a().i()) {
            b.a(new File("sdcard/kwad_ex/java_crash/dump"));
        }
    }

    public void a(@NonNull Throwable th, @NonNull ExceptionMessage exceptionMessage, @Nullable Context context) {
        a(th, exceptionMessage, context, false);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:57:0x0170
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public void a(@androidx.annotation.NonNull java.lang.Throwable r22, @androidx.annotation.NonNull com.kwad.sdk.crash.model.message.ExceptionMessage r23, @androidx.annotation.Nullable android.content.Context r24, boolean r25) {
        /*
            r21 = this;
            r1 = r21
            r2 = r23
            java.lang.String r3 = "java_crash_mkdir_fail"
            java.lang.String r4 = "uploader.uploadEvent(message);"
            java.lang.String r5 = "java_crash_dump_error"
            java.lang.String r6 = "------  Java Crash Happened Begin ------\n"
            java.lang.String r7 = "ExceptionCollector"
            java.util.concurrent.atomic.AtomicInteger r0 = r1.f34732d
            int r0 = r0.getAndIncrement()
            java.io.File r8 = r1.f34734f
            java.io.File r9 = r1.f34735g
            java.io.File r10 = r1.f34736h
            java.io.File r11 = r1.i
            com.kwad.sdk.crash.report.c r12 = r21.a()
            java.lang.String r13 = r22.toString()     // Catch: java.lang.Throwable -> L1b7
            r2.mCrashDetail = r13     // Catch: java.lang.Throwable -> L1b7
            java.io.File r13 = r1.f34733e     // Catch: java.lang.Throwable -> L1b7
            boolean r13 = r13.exists()     // Catch: java.lang.Throwable -> L1b7
            if (r13 != 0) goto L62
            java.io.File r13 = r1.f34733e     // Catch: java.lang.Throwable -> L5f
            boolean r13 = r13.mkdirs()     // Catch: java.lang.Throwable -> L5f
            if (r13 != 0) goto L62
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5f
            r13.<init>()     // Catch: java.lang.Throwable -> L5f
            java.lang.String r14 = r2.mErrorMessage     // Catch: java.lang.Throwable -> L5f
            r13.append(r14)     // Catch: java.lang.Throwable -> L5f
            java.lang.String r14 = "create "
            r13.append(r14)     // Catch: java.lang.Throwable -> L5f
            com.kwad.sdk.crash.c.c r14 = d()     // Catch: java.lang.Throwable -> L5f
            java.io.File r14 = r14.f34733e     // Catch: java.lang.Throwable -> L5f
            java.lang.String r14 = r14.getPath()     // Catch: java.lang.Throwable -> L5f
            r13.append(r14)     // Catch: java.lang.Throwable -> L5f
            java.lang.String r14 = " failed!\n"
            r13.append(r14)     // Catch: java.lang.Throwable -> L5f
            java.lang.String r13 = r13.toString()     // Catch: java.lang.Throwable -> L5f
            r2.mErrorMessage = r13     // Catch: java.lang.Throwable -> L5f
            r13 = 0
            goto L63
        L5f:
            r0 = move-exception
            goto L1be
        L62:
            r13 = 1
        L63:
            java.lang.String r14 = "-"
            if (r8 == 0) goto L6f
            if (r0 == 0) goto L6a
            goto L6f
        L6a:
            r18 = r3
            r17 = r5
            goto L96
        L6f:
            java.io.File r15 = new java.io.File     // Catch: java.lang.Throwable -> L1af
            r16 = r8
            java.io.File r8 = r1.f34733e     // Catch: java.lang.Throwable -> L1a7
            r17 = r5
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L19f
            r5.<init>()     // Catch: java.lang.Throwable -> L19f
            r18 = r3
            java.lang.String r3 = com.kwad.sdk.crash.c.b.f34729a     // Catch: java.lang.Throwable -> L195
            r5.append(r3)     // Catch: java.lang.Throwable -> L195
            r5.append(r14)     // Catch: java.lang.Throwable -> L195
            r5.append(r0)     // Catch: java.lang.Throwable -> L195
            java.lang.String r3 = ".dump"
            r5.append(r3)     // Catch: java.lang.Throwable -> L195
            java.lang.String r3 = r5.toString()     // Catch: java.lang.Throwable -> L195
            r15.<init>(r8, r3)     // Catch: java.lang.Throwable -> L195
            r8 = r15
        L96:
            if (r9 == 0) goto L9a
            if (r0 == 0) goto Lbd
        L9a:
            java.io.File r3 = new java.io.File     // Catch: java.lang.Throwable -> L18b
            java.io.File r5 = r1.f34733e     // Catch: java.lang.Throwable -> L18b
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L18b
            r15.<init>()     // Catch: java.lang.Throwable -> L18b
            r19 = r9
            java.lang.String r9 = com.kwad.sdk.crash.c.b.f34729a     // Catch: java.lang.Throwable -> L181
            r15.append(r9)     // Catch: java.lang.Throwable -> L181
            r15.append(r14)     // Catch: java.lang.Throwable -> L181
            r15.append(r0)     // Catch: java.lang.Throwable -> L181
            java.lang.String r9 = ".log"
            r15.append(r9)     // Catch: java.lang.Throwable -> L181
            java.lang.String r9 = r15.toString()     // Catch: java.lang.Throwable -> L181
            r3.<init>(r5, r9)     // Catch: java.lang.Throwable -> L181
            r9 = r3
        Lbd:
            if (r10 == 0) goto Lc1
            if (r0 == 0) goto Le4
        Lc1:
            java.io.File r3 = new java.io.File     // Catch: java.lang.Throwable -> L17f
            java.io.File r5 = r1.f34733e     // Catch: java.lang.Throwable -> L17f
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L17f
            r15.<init>()     // Catch: java.lang.Throwable -> L17f
            r20 = r10
            java.lang.String r10 = com.kwad.sdk.crash.c.b.f34729a     // Catch: java.lang.Throwable -> L177
            r15.append(r10)     // Catch: java.lang.Throwable -> L177
            r15.append(r14)     // Catch: java.lang.Throwable -> L177
            r15.append(r0)     // Catch: java.lang.Throwable -> L177
            java.lang.String r0 = ".jtrace"
            r15.append(r0)     // Catch: java.lang.Throwable -> L177
            java.lang.String r0 = r15.toString()     // Catch: java.lang.Throwable -> L177
            r3.<init>(r5, r0)     // Catch: java.lang.Throwable -> L177
            r10 = r3
        Le4:
            com.kwad.sdk.crash.utils.f.a(r22, r23, r24)     // Catch: java.lang.Throwable -> L175
            int r0 = r21.c()     // Catch: java.lang.Throwable -> L175
            com.kwad.sdk.crash.utils.f.a(r2, r0)     // Catch: java.lang.Throwable -> L175
            com.kwad.sdk.crash.e r0 = r1.f34731c     // Catch: java.lang.Throwable -> L175
            if (r0 == 0) goto Lfb
            com.kwad.sdk.crash.e r0 = r1.f34731c     // Catch: java.lang.Throwable -> L175
            int r3 = r21.c()     // Catch: java.lang.Throwable -> L175
            r0.a(r3, r2)     // Catch: java.lang.Throwable -> L175
        Lfb:
            org.json.JSONObject r0 = r23.toJson()     // Catch: java.lang.Throwable -> L167
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L167
            if (r13 == 0) goto L146
            com.kwad.sdk.crash.utils.f.a(r8, r0)     // Catch: java.lang.Throwable -> L167
            com.kwad.sdk.crash.utils.f.c(r10)     // Catch: java.lang.Throwable -> L167
            com.kwad.sdk.crash.utils.f.a(r9)     // Catch: java.lang.Throwable -> L167
            com.kwad.sdk.crash.d r0 = com.kwad.sdk.crash.d.a()     // Catch: java.lang.Throwable -> L167
            boolean r0 = r0.i()     // Catch: java.lang.Throwable -> L167
            if (r0 == 0) goto L11d
            java.io.File r0 = r1.f34733e     // Catch: java.lang.Throwable -> L167
            r1.b(r0)     // Catch: java.lang.Throwable -> L167
        L11d:
            if (r12 == 0) goto L141
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L167
            r0.<init>()     // Catch: java.lang.Throwable -> L167
            r0.append(r6)     // Catch: java.lang.Throwable -> L167
            r0.append(r2)     // Catch: java.lang.Throwable -> L167
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L167
            r12.a(r7, r0)     // Catch: java.lang.Throwable -> L167
            if (r25 == 0) goto L13e
            r2 = 1
            java.io.File[] r0 = new java.io.File[r2]     // Catch: java.lang.Throwable -> L167
            r2 = 0
            r0[r2] = r8     // Catch: java.lang.Throwable -> L167
            r2 = 0
            r1.a(r0, r2)     // Catch: java.lang.Throwable -> L167
            goto L141
        L13e:
            r21.b()     // Catch: java.lang.Throwable -> L167
        L141:
            com.kwad.sdk.crash.utils.f.d(r11)     // Catch: java.lang.Throwable -> L167
            goto L243
        L146:
            if (r12 == 0) goto L243
            com.kwad.sdk.core.d.a.a(r7, r4)     // Catch: java.lang.Throwable -> L167
            r12.a(r2)     // Catch: java.lang.Throwable -> L167
            r3 = r18
            r12.b(r3, r0)     // Catch: java.lang.Throwable -> L167
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L167
            r0.<init>()     // Catch: java.lang.Throwable -> L167
            r0.append(r6)     // Catch: java.lang.Throwable -> L167
            r0.append(r2)     // Catch: java.lang.Throwable -> L167
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L167
            r12.a(r7, r0)     // Catch: java.lang.Throwable -> L167
            goto L243
        L167:
            r0 = move-exception
            if (r12 == 0) goto L243
            java.lang.String r0 = com.kwad.sdk.crash.utils.f.a(r0)     // Catch: java.lang.Exception -> L243
            r5 = r17
        L170:
            r12.b(r5, r0)     // Catch: java.lang.Exception -> L243
            goto L243
        L175:
            r0 = move-exception
            goto L190
        L177:
            r0 = move-exception
            r5 = r17
            r3 = r18
            r10 = r20
            goto L1bf
        L17f:
            r0 = move-exception
            goto L18e
        L181:
            r0 = move-exception
            r20 = r10
            r5 = r17
            r3 = r18
            r9 = r19
            goto L1bf
        L18b:
            r0 = move-exception
            r19 = r9
        L18e:
            r20 = r10
        L190:
            r5 = r17
            r3 = r18
            goto L1bf
        L195:
            r0 = move-exception
            r19 = r9
            r20 = r10
            r5 = r17
            r3 = r18
            goto L1ac
        L19f:
            r0 = move-exception
            r19 = r9
            r20 = r10
            r5 = r17
            goto L1ac
        L1a7:
            r0 = move-exception
            r19 = r9
            r20 = r10
        L1ac:
            r8 = r16
            goto L1bf
        L1af:
            r0 = move-exception
            r16 = r8
            r19 = r9
            r20 = r10
            goto L1bf
        L1b7:
            r0 = move-exception
            r16 = r8
            r19 = r9
            r20 = r10
        L1be:
            r13 = 1
        L1bf:
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L244
            r14.<init>()     // Catch: java.lang.Throwable -> L244
            java.lang.String r15 = r2.mErrorMessage     // Catch: java.lang.Throwable -> L244
            r14.append(r15)     // Catch: java.lang.Throwable -> L244
            r14.append(r0)     // Catch: java.lang.Throwable -> L244
            java.lang.String r0 = r14.toString()     // Catch: java.lang.Throwable -> L244
            r2.mErrorMessage = r0     // Catch: java.lang.Throwable -> L244
            org.json.JSONObject r0 = r23.toJson()     // Catch: java.lang.Throwable -> L23a
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L23a
            if (r13 == 0) goto L21c
            com.kwad.sdk.crash.utils.f.a(r8, r0)     // Catch: java.lang.Throwable -> L23a
            com.kwad.sdk.crash.utils.f.c(r10)     // Catch: java.lang.Throwable -> L23a
            com.kwad.sdk.crash.utils.f.a(r9)     // Catch: java.lang.Throwable -> L23a
            com.kwad.sdk.crash.d r0 = com.kwad.sdk.crash.d.a()     // Catch: java.lang.Throwable -> L23a
            boolean r0 = r0.i()     // Catch: java.lang.Throwable -> L23a
            if (r0 == 0) goto L1f4
            java.io.File r0 = r1.f34733e     // Catch: java.lang.Throwable -> L23a
            r1.b(r0)     // Catch: java.lang.Throwable -> L23a
        L1f4:
            if (r12 == 0) goto L218
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L23a
            r0.<init>()     // Catch: java.lang.Throwable -> L23a
            r0.append(r6)     // Catch: java.lang.Throwable -> L23a
            r0.append(r2)     // Catch: java.lang.Throwable -> L23a
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L23a
            r12.a(r7, r0)     // Catch: java.lang.Throwable -> L23a
            if (r25 == 0) goto L215
            r2 = 1
            java.io.File[] r0 = new java.io.File[r2]     // Catch: java.lang.Throwable -> L23a
            r2 = 0
            r0[r2] = r8     // Catch: java.lang.Throwable -> L23a
            r2 = 0
            r1.a(r0, r2)     // Catch: java.lang.Throwable -> L23a
            goto L218
        L215:
            r21.b()     // Catch: java.lang.Throwable -> L23a
        L218:
            com.kwad.sdk.crash.utils.f.d(r11)     // Catch: java.lang.Throwable -> L23a
            goto L243
        L21c:
            if (r12 == 0) goto L243
            com.kwad.sdk.core.d.a.a(r7, r4)     // Catch: java.lang.Throwable -> L23a
            r12.a(r2)     // Catch: java.lang.Throwable -> L23a
            r12.b(r3, r0)     // Catch: java.lang.Throwable -> L23a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L23a
            r0.<init>()     // Catch: java.lang.Throwable -> L23a
            r0.append(r6)     // Catch: java.lang.Throwable -> L23a
            r0.append(r2)     // Catch: java.lang.Throwable -> L23a
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L23a
            r12.a(r7, r0)     // Catch: java.lang.Throwable -> L23a
            goto L243
        L23a:
            r0 = move-exception
            if (r12 == 0) goto L243
            java.lang.String r0 = com.kwad.sdk.crash.utils.f.a(r0)     // Catch: java.lang.Exception -> L243
            goto L170
        L243:
            return
        L244:
            r0 = move-exception
            r14 = r0
            org.json.JSONObject r0 = r23.toJson()     // Catch: java.lang.Throwable -> L2ae
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L2ae
            if (r13 == 0) goto L290
            com.kwad.sdk.crash.utils.f.a(r8, r0)     // Catch: java.lang.Throwable -> L2ae
            com.kwad.sdk.crash.utils.f.c(r10)     // Catch: java.lang.Throwable -> L2ae
            com.kwad.sdk.crash.utils.f.a(r9)     // Catch: java.lang.Throwable -> L2ae
            com.kwad.sdk.crash.d r0 = com.kwad.sdk.crash.d.a()     // Catch: java.lang.Throwable -> L2ae
            boolean r0 = r0.i()     // Catch: java.lang.Throwable -> L2ae
            if (r0 == 0) goto L268
            java.io.File r0 = r1.f34733e     // Catch: java.lang.Throwable -> L2ae
            r1.b(r0)     // Catch: java.lang.Throwable -> L2ae
        L268:
            if (r12 == 0) goto L28c
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2ae
            r0.<init>()     // Catch: java.lang.Throwable -> L2ae
            r0.append(r6)     // Catch: java.lang.Throwable -> L2ae
            r0.append(r2)     // Catch: java.lang.Throwable -> L2ae
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L2ae
            r12.a(r7, r0)     // Catch: java.lang.Throwable -> L2ae
            if (r25 == 0) goto L289
            r2 = 1
            java.io.File[] r0 = new java.io.File[r2]     // Catch: java.lang.Throwable -> L2ae
            r2 = 0
            r0[r2] = r8     // Catch: java.lang.Throwable -> L2ae
            r2 = 0
            r1.a(r0, r2)     // Catch: java.lang.Throwable -> L2ae
            goto L28c
        L289:
            r21.b()     // Catch: java.lang.Throwable -> L2ae
        L28c:
            com.kwad.sdk.crash.utils.f.d(r11)     // Catch: java.lang.Throwable -> L2ae
            goto L2b8
        L290:
            if (r12 == 0) goto L2b8
            com.kwad.sdk.core.d.a.a(r7, r4)     // Catch: java.lang.Throwable -> L2ae
            r12.a(r2)     // Catch: java.lang.Throwable -> L2ae
            r12.b(r3, r0)     // Catch: java.lang.Throwable -> L2ae
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2ae
            r0.<init>()     // Catch: java.lang.Throwable -> L2ae
            r0.append(r6)     // Catch: java.lang.Throwable -> L2ae
            r0.append(r2)     // Catch: java.lang.Throwable -> L2ae
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L2ae
            r12.a(r7, r0)     // Catch: java.lang.Throwable -> L2ae
            goto L2b8
        L2ae:
            r0 = move-exception
            if (r12 == 0) goto L2b8
            java.lang.String r0 = com.kwad.sdk.crash.utils.f.a(r0)     // Catch: java.lang.Exception -> L2b8
            r12.b(r5, r0)     // Catch: java.lang.Exception -> L2b8
        L2b8:
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.crash.c.c.a(java.lang.Throwable, com.kwad.sdk.crash.model.message.ExceptionMessage, android.content.Context, boolean):void");
    }

    @Override // com.kwad.sdk.crash.c.b
    public void a(@NonNull File[] fileArr, @Nullable CountDownLatch countDownLatch) {
        com.kwad.sdk.crash.report.d dVar = new com.kwad.sdk.crash.report.d();
        dVar.a(a());
        for (File file : fileArr) {
            dVar.b(file);
        }
    }

    @Override // com.kwad.sdk.crash.c.b
    public int c() {
        return 1;
    }
}
