package com.kwad.sdk.crash.c;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.crash.e;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import java.io.File;
import java.util.concurrent.CountDownLatch;
/* loaded from: classes7.dex */
public final class c extends b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.kwad.sdk.crash.c.c$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final c f36959a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1459355594, "Lcom/kwad/sdk/crash/c/c$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1459355594, "Lcom/kwad/sdk/crash/c/c$a;");
                    return;
                }
            }
            f36959a = new c(null);
        }
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public /* synthetic */ c(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static c d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a.f36959a : (c) invokeV.objValue;
    }

    @Override // com.kwad.sdk.crash.c.b
    public void a(File file, e eVar, com.kwad.sdk.crash.report.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, file, eVar, cVar) == null) {
            super.a(file, eVar, cVar);
            if (com.kwad.sdk.crash.d.a().i()) {
                b.a(new File("sdcard/kwad_ex/java_crash/dump"));
            }
        }
    }

    public void a(@NonNull Throwable th, @NonNull ExceptionMessage exceptionMessage, @Nullable Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th, exceptionMessage, context) == null) {
            a(th, exceptionMessage, context, false);
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:59:0x0174
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public void a(@androidx.annotation.NonNull java.lang.Throwable r22, @androidx.annotation.NonNull com.kwad.sdk.crash.model.message.ExceptionMessage r23, @androidx.annotation.Nullable android.content.Context r24, boolean r25) {
        /*
            r21 = this;
            com.baidu.titan.sdk.runtime.Interceptable r0 = com.kwad.sdk.crash.c.c.$ic
            if (r0 != 0) goto L2bd
        L4:
            r1 = r21
            r2 = r23
            java.lang.String r3 = "java_crash_mkdir_fail"
            java.lang.String r4 = "uploader.uploadEvent(message);"
            java.lang.String r5 = "java_crash_dump_error"
            java.lang.String r6 = "------  Java Crash Happened Begin ------\n"
            java.lang.String r7 = "ExceptionCollector"
            java.util.concurrent.atomic.AtomicInteger r0 = r1.f36952d
            int r0 = r0.getAndIncrement()
            java.io.File r8 = r1.f36954f
            java.io.File r9 = r1.f36955g
            java.io.File r10 = r1.f36956h
            java.io.File r11 = r1.f36957i
            com.kwad.sdk.crash.report.c r12 = r21.a()
            java.lang.String r13 = r22.toString()     // Catch: java.lang.Throwable -> L1bb
            r2.mCrashDetail = r13     // Catch: java.lang.Throwable -> L1bb
            java.io.File r13 = r1.f36953e     // Catch: java.lang.Throwable -> L1bb
            boolean r13 = r13.exists()     // Catch: java.lang.Throwable -> L1bb
            if (r13 != 0) goto L66
            java.io.File r13 = r1.f36953e     // Catch: java.lang.Throwable -> L63
            boolean r13 = r13.mkdirs()     // Catch: java.lang.Throwable -> L63
            if (r13 != 0) goto L66
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L63
            r13.<init>()     // Catch: java.lang.Throwable -> L63
            java.lang.String r14 = r2.mErrorMessage     // Catch: java.lang.Throwable -> L63
            r13.append(r14)     // Catch: java.lang.Throwable -> L63
            java.lang.String r14 = "create "
            r13.append(r14)     // Catch: java.lang.Throwable -> L63
            com.kwad.sdk.crash.c.c r14 = d()     // Catch: java.lang.Throwable -> L63
            java.io.File r14 = r14.f36953e     // Catch: java.lang.Throwable -> L63
            java.lang.String r14 = r14.getPath()     // Catch: java.lang.Throwable -> L63
            r13.append(r14)     // Catch: java.lang.Throwable -> L63
            java.lang.String r14 = " failed!\n"
            r13.append(r14)     // Catch: java.lang.Throwable -> L63
            java.lang.String r13 = r13.toString()     // Catch: java.lang.Throwable -> L63
            r2.mErrorMessage = r13     // Catch: java.lang.Throwable -> L63
            r13 = 0
            goto L67
        L63:
            r0 = move-exception
            goto L1c2
        L66:
            r13 = 1
        L67:
            java.lang.String r14 = "-"
            if (r8 == 0) goto L73
            if (r0 == 0) goto L6e
            goto L73
        L6e:
            r18 = r3
            r17 = r5
            goto L9a
        L73:
            java.io.File r15 = new java.io.File     // Catch: java.lang.Throwable -> L1b3
            r16 = r8
            java.io.File r8 = r1.f36953e     // Catch: java.lang.Throwable -> L1ab
            r17 = r5
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L1a3
            r5.<init>()     // Catch: java.lang.Throwable -> L1a3
            r18 = r3
            java.lang.String r3 = com.kwad.sdk.crash.c.b.f36949a     // Catch: java.lang.Throwable -> L199
            r5.append(r3)     // Catch: java.lang.Throwable -> L199
            r5.append(r14)     // Catch: java.lang.Throwable -> L199
            r5.append(r0)     // Catch: java.lang.Throwable -> L199
            java.lang.String r3 = ".dump"
            r5.append(r3)     // Catch: java.lang.Throwable -> L199
            java.lang.String r3 = r5.toString()     // Catch: java.lang.Throwable -> L199
            r15.<init>(r8, r3)     // Catch: java.lang.Throwable -> L199
            r8 = r15
        L9a:
            if (r9 == 0) goto L9e
            if (r0 == 0) goto Lc1
        L9e:
            java.io.File r3 = new java.io.File     // Catch: java.lang.Throwable -> L18f
            java.io.File r5 = r1.f36953e     // Catch: java.lang.Throwable -> L18f
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L18f
            r15.<init>()     // Catch: java.lang.Throwable -> L18f
            r19 = r9
            java.lang.String r9 = com.kwad.sdk.crash.c.b.f36949a     // Catch: java.lang.Throwable -> L185
            r15.append(r9)     // Catch: java.lang.Throwable -> L185
            r15.append(r14)     // Catch: java.lang.Throwable -> L185
            r15.append(r0)     // Catch: java.lang.Throwable -> L185
            java.lang.String r9 = ".log"
            r15.append(r9)     // Catch: java.lang.Throwable -> L185
            java.lang.String r9 = r15.toString()     // Catch: java.lang.Throwable -> L185
            r3.<init>(r5, r9)     // Catch: java.lang.Throwable -> L185
            r9 = r3
        Lc1:
            if (r10 == 0) goto Lc5
            if (r0 == 0) goto Le8
        Lc5:
            java.io.File r3 = new java.io.File     // Catch: java.lang.Throwable -> L183
            java.io.File r5 = r1.f36953e     // Catch: java.lang.Throwable -> L183
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L183
            r15.<init>()     // Catch: java.lang.Throwable -> L183
            r20 = r10
            java.lang.String r10 = com.kwad.sdk.crash.c.b.f36949a     // Catch: java.lang.Throwable -> L17b
            r15.append(r10)     // Catch: java.lang.Throwable -> L17b
            r15.append(r14)     // Catch: java.lang.Throwable -> L17b
            r15.append(r0)     // Catch: java.lang.Throwable -> L17b
            java.lang.String r0 = ".jtrace"
            r15.append(r0)     // Catch: java.lang.Throwable -> L17b
            java.lang.String r0 = r15.toString()     // Catch: java.lang.Throwable -> L17b
            r3.<init>(r5, r0)     // Catch: java.lang.Throwable -> L17b
            r10 = r3
        Le8:
            com.kwad.sdk.crash.utils.f.a(r22, r23, r24)     // Catch: java.lang.Throwable -> L179
            int r0 = r21.c()     // Catch: java.lang.Throwable -> L179
            com.kwad.sdk.crash.utils.f.a(r2, r0)     // Catch: java.lang.Throwable -> L179
            com.kwad.sdk.crash.e r0 = r1.f36951c     // Catch: java.lang.Throwable -> L179
            if (r0 == 0) goto Lff
            com.kwad.sdk.crash.e r0 = r1.f36951c     // Catch: java.lang.Throwable -> L179
            int r3 = r21.c()     // Catch: java.lang.Throwable -> L179
            r0.a(r3, r2)     // Catch: java.lang.Throwable -> L179
        Lff:
            org.json.JSONObject r0 = r23.toJson()     // Catch: java.lang.Throwable -> L16b
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L16b
            if (r13 == 0) goto L14a
            com.kwad.sdk.crash.utils.f.a(r8, r0)     // Catch: java.lang.Throwable -> L16b
            com.kwad.sdk.crash.utils.f.c(r10)     // Catch: java.lang.Throwable -> L16b
            com.kwad.sdk.crash.utils.f.a(r9)     // Catch: java.lang.Throwable -> L16b
            com.kwad.sdk.crash.d r0 = com.kwad.sdk.crash.d.a()     // Catch: java.lang.Throwable -> L16b
            boolean r0 = r0.i()     // Catch: java.lang.Throwable -> L16b
            if (r0 == 0) goto L121
            java.io.File r0 = r1.f36953e     // Catch: java.lang.Throwable -> L16b
            r1.b(r0)     // Catch: java.lang.Throwable -> L16b
        L121:
            if (r12 == 0) goto L145
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L16b
            r0.<init>()     // Catch: java.lang.Throwable -> L16b
            r0.append(r6)     // Catch: java.lang.Throwable -> L16b
            r0.append(r2)     // Catch: java.lang.Throwable -> L16b
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L16b
            r12.a(r7, r0)     // Catch: java.lang.Throwable -> L16b
            if (r25 == 0) goto L142
            r2 = 1
            java.io.File[] r0 = new java.io.File[r2]     // Catch: java.lang.Throwable -> L16b
            r2 = 0
            r0[r2] = r8     // Catch: java.lang.Throwable -> L16b
            r2 = 0
            r1.a(r0, r2)     // Catch: java.lang.Throwable -> L16b
            goto L145
        L142:
            r21.b()     // Catch: java.lang.Throwable -> L16b
        L145:
            com.kwad.sdk.crash.utils.f.d(r11)     // Catch: java.lang.Throwable -> L16b
            goto L247
        L14a:
            if (r12 == 0) goto L247
            com.kwad.sdk.core.d.a.a(r7, r4)     // Catch: java.lang.Throwable -> L16b
            r12.a(r2)     // Catch: java.lang.Throwable -> L16b
            r3 = r18
            r12.b(r3, r0)     // Catch: java.lang.Throwable -> L16b
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L16b
            r0.<init>()     // Catch: java.lang.Throwable -> L16b
            r0.append(r6)     // Catch: java.lang.Throwable -> L16b
            r0.append(r2)     // Catch: java.lang.Throwable -> L16b
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L16b
            r12.a(r7, r0)     // Catch: java.lang.Throwable -> L16b
            goto L247
        L16b:
            r0 = move-exception
            if (r12 == 0) goto L247
            java.lang.String r0 = com.kwad.sdk.crash.utils.f.a(r0)     // Catch: java.lang.Exception -> L247
            r5 = r17
        L174:
            r12.b(r5, r0)     // Catch: java.lang.Exception -> L247
            goto L247
        L179:
            r0 = move-exception
            goto L194
        L17b:
            r0 = move-exception
            r5 = r17
            r3 = r18
            r10 = r20
            goto L1c3
        L183:
            r0 = move-exception
            goto L192
        L185:
            r0 = move-exception
            r20 = r10
            r5 = r17
            r3 = r18
            r9 = r19
            goto L1c3
        L18f:
            r0 = move-exception
            r19 = r9
        L192:
            r20 = r10
        L194:
            r5 = r17
            r3 = r18
            goto L1c3
        L199:
            r0 = move-exception
            r19 = r9
            r20 = r10
            r5 = r17
            r3 = r18
            goto L1b0
        L1a3:
            r0 = move-exception
            r19 = r9
            r20 = r10
            r5 = r17
            goto L1b0
        L1ab:
            r0 = move-exception
            r19 = r9
            r20 = r10
        L1b0:
            r8 = r16
            goto L1c3
        L1b3:
            r0 = move-exception
            r16 = r8
            r19 = r9
            r20 = r10
            goto L1c3
        L1bb:
            r0 = move-exception
            r16 = r8
            r19 = r9
            r20 = r10
        L1c2:
            r13 = 1
        L1c3:
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L248
            r14.<init>()     // Catch: java.lang.Throwable -> L248
            java.lang.String r15 = r2.mErrorMessage     // Catch: java.lang.Throwable -> L248
            r14.append(r15)     // Catch: java.lang.Throwable -> L248
            r14.append(r0)     // Catch: java.lang.Throwable -> L248
            java.lang.String r0 = r14.toString()     // Catch: java.lang.Throwable -> L248
            r2.mErrorMessage = r0     // Catch: java.lang.Throwable -> L248
            org.json.JSONObject r0 = r23.toJson()     // Catch: java.lang.Throwable -> L23e
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L23e
            if (r13 == 0) goto L220
            com.kwad.sdk.crash.utils.f.a(r8, r0)     // Catch: java.lang.Throwable -> L23e
            com.kwad.sdk.crash.utils.f.c(r10)     // Catch: java.lang.Throwable -> L23e
            com.kwad.sdk.crash.utils.f.a(r9)     // Catch: java.lang.Throwable -> L23e
            com.kwad.sdk.crash.d r0 = com.kwad.sdk.crash.d.a()     // Catch: java.lang.Throwable -> L23e
            boolean r0 = r0.i()     // Catch: java.lang.Throwable -> L23e
            if (r0 == 0) goto L1f8
            java.io.File r0 = r1.f36953e     // Catch: java.lang.Throwable -> L23e
            r1.b(r0)     // Catch: java.lang.Throwable -> L23e
        L1f8:
            if (r12 == 0) goto L21c
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L23e
            r0.<init>()     // Catch: java.lang.Throwable -> L23e
            r0.append(r6)     // Catch: java.lang.Throwable -> L23e
            r0.append(r2)     // Catch: java.lang.Throwable -> L23e
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L23e
            r12.a(r7, r0)     // Catch: java.lang.Throwable -> L23e
            if (r25 == 0) goto L219
            r2 = 1
            java.io.File[] r0 = new java.io.File[r2]     // Catch: java.lang.Throwable -> L23e
            r2 = 0
            r0[r2] = r8     // Catch: java.lang.Throwable -> L23e
            r2 = 0
            r1.a(r0, r2)     // Catch: java.lang.Throwable -> L23e
            goto L21c
        L219:
            r21.b()     // Catch: java.lang.Throwable -> L23e
        L21c:
            com.kwad.sdk.crash.utils.f.d(r11)     // Catch: java.lang.Throwable -> L23e
            goto L247
        L220:
            if (r12 == 0) goto L247
            com.kwad.sdk.core.d.a.a(r7, r4)     // Catch: java.lang.Throwable -> L23e
            r12.a(r2)     // Catch: java.lang.Throwable -> L23e
            r12.b(r3, r0)     // Catch: java.lang.Throwable -> L23e
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L23e
            r0.<init>()     // Catch: java.lang.Throwable -> L23e
            r0.append(r6)     // Catch: java.lang.Throwable -> L23e
            r0.append(r2)     // Catch: java.lang.Throwable -> L23e
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L23e
            r12.a(r7, r0)     // Catch: java.lang.Throwable -> L23e
            goto L247
        L23e:
            r0 = move-exception
            if (r12 == 0) goto L247
            java.lang.String r0 = com.kwad.sdk.crash.utils.f.a(r0)     // Catch: java.lang.Exception -> L247
            goto L174
        L247:
            return
        L248:
            r0 = move-exception
            r14 = r0
            org.json.JSONObject r0 = r23.toJson()     // Catch: java.lang.Throwable -> L2b2
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L2b2
            if (r13 == 0) goto L294
            com.kwad.sdk.crash.utils.f.a(r8, r0)     // Catch: java.lang.Throwable -> L2b2
            com.kwad.sdk.crash.utils.f.c(r10)     // Catch: java.lang.Throwable -> L2b2
            com.kwad.sdk.crash.utils.f.a(r9)     // Catch: java.lang.Throwable -> L2b2
            com.kwad.sdk.crash.d r0 = com.kwad.sdk.crash.d.a()     // Catch: java.lang.Throwable -> L2b2
            boolean r0 = r0.i()     // Catch: java.lang.Throwable -> L2b2
            if (r0 == 0) goto L26c
            java.io.File r0 = r1.f36953e     // Catch: java.lang.Throwable -> L2b2
            r1.b(r0)     // Catch: java.lang.Throwable -> L2b2
        L26c:
            if (r12 == 0) goto L290
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2b2
            r0.<init>()     // Catch: java.lang.Throwable -> L2b2
            r0.append(r6)     // Catch: java.lang.Throwable -> L2b2
            r0.append(r2)     // Catch: java.lang.Throwable -> L2b2
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L2b2
            r12.a(r7, r0)     // Catch: java.lang.Throwable -> L2b2
            if (r25 == 0) goto L28d
            r2 = 1
            java.io.File[] r0 = new java.io.File[r2]     // Catch: java.lang.Throwable -> L2b2
            r2 = 0
            r0[r2] = r8     // Catch: java.lang.Throwable -> L2b2
            r2 = 0
            r1.a(r0, r2)     // Catch: java.lang.Throwable -> L2b2
            goto L290
        L28d:
            r21.b()     // Catch: java.lang.Throwable -> L2b2
        L290:
            com.kwad.sdk.crash.utils.f.d(r11)     // Catch: java.lang.Throwable -> L2b2
            goto L2bc
        L294:
            if (r12 == 0) goto L2bc
            com.kwad.sdk.core.d.a.a(r7, r4)     // Catch: java.lang.Throwable -> L2b2
            r12.a(r2)     // Catch: java.lang.Throwable -> L2b2
            r12.b(r3, r0)     // Catch: java.lang.Throwable -> L2b2
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2b2
            r0.<init>()     // Catch: java.lang.Throwable -> L2b2
            r0.append(r6)     // Catch: java.lang.Throwable -> L2b2
            r0.append(r2)     // Catch: java.lang.Throwable -> L2b2
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L2b2
            r12.a(r7, r0)     // Catch: java.lang.Throwable -> L2b2
            goto L2bc
        L2b2:
            r0 = move-exception
            if (r12 == 0) goto L2bc
            java.lang.String r0 = com.kwad.sdk.crash.utils.f.a(r0)     // Catch: java.lang.Exception -> L2bc
            r12.b(r5, r0)     // Catch: java.lang.Exception -> L2bc
        L2bc:
            throw r14
        L2bd:
            r3 = 4
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r1 = 0
            r3[r1] = r22
            r1 = 1
            r3[r1] = r23
            r1 = 2
            r3[r1] = r24
            r1 = 3
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r25)
            r3[r1] = r2
            r1 = 1048578(0x100002, float:1.469371E-39)
            r2 = r21
            com.baidu.titan.sdk.runtime.InterceptResult r0 = r0.invokeCommon(r1, r2, r3)
            if (r0 == 0) goto L4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.crash.c.c.a(java.lang.Throwable, com.kwad.sdk.crash.model.message.ExceptionMessage, android.content.Context, boolean):void");
    }

    @Override // com.kwad.sdk.crash.c.b
    public void a(@NonNull File[] fileArr, @Nullable CountDownLatch countDownLatch) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, fileArr, countDownLatch) == null) {
            com.kwad.sdk.crash.report.d dVar = new com.kwad.sdk.crash.report.d();
            dVar.a(a());
            for (File file : fileArr) {
                dVar.b(file);
            }
        }
    }

    @Override // com.kwad.sdk.crash.c.b
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }
}
