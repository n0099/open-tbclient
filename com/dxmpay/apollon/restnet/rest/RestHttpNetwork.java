package com.dxmpay.apollon.restnet.rest;

import b.f.a.g.a;
import b.f.a.g.d.c;
import b.f.a.g.d.d;
import b.f.a.g.d.e;
import b.f.a.g.d.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.apollon.restnet.http.HttpStatus;
import com.dxmpay.apollon.utils.LogUtil;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.concurrent.TimeoutException;
/* loaded from: classes11.dex */
public class RestHttpNetwork implements c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final c f62163a;

    /* renamed from: b  reason: collision with root package name */
    public final g f62164b;

    public RestHttpNetwork(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = objArr;
            Object[] objArr = {cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f62163a = cVar;
        this.f62164b = new g(3, 1000);
    }

    /*  JADX ERROR: IF instruction can be used only in fallback mode
        jadx.core.utils.exceptions.CodegenException: IF instruction can be used only in fallback mode
        	at jadx.core.codegen.InsnGen.fallbackOnlyInsn(InsnGen.java:664)
        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:522)
        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:280)
        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:91)
        	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
        	at jadx.core.dex.regions.Region.generate(Region.java:35)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:80)
        	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:175)
        	at jadx.core.dex.regions.loops.LoopRegion.generate(LoopRegion.java:171)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
        	at jadx.core.dex.regions.Region.generate(Region.java:35)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:80)
        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:123)
        	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
        	at jadx.core.dex.regions.Region.generate(Region.java:35)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
        	at jadx.core.dex.regions.Region.generate(Region.java:35)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:296)
        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:275)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:377)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:306)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:272)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
        */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00b6 A[SYNTHETIC] */
    @Override // b.f.a.g.d.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public b.f.a.g.d.e a(b.f.a.g.d.d r11) throws java.lang.Exception {
        /*
            r10 = this;
            com.baidu.titan.sdk.runtime.Interceptable r0 = com.dxmpay.apollon.restnet.rest.RestHttpNetwork.$ic
            if (r0 != 0) goto Le3
        L4:
            java.lang.String r0 = r11.f()
            b.f.a.g.a$a r1 = b.f.a.g.a.a()
            r2 = 0
            r3 = 1
            r4 = 0
            r5 = 1
            r6 = 0
        L11:
            if (r5 == 0) goto Le2
            b.f.a.g.d.c r4 = r10.f62163a     // Catch: java.io.IOException -> L31 java.util.concurrent.TimeoutException -> L3c java.lang.NullPointerException -> L60 java.net.UnknownHostException -> L87
            b.f.a.g.d.e r4 = r4.a(r11)     // Catch: java.io.IOException -> L31 java.util.concurrent.TimeoutException -> L3c java.lang.NullPointerException -> L60 java.net.UnknownHostException -> L87
            if (r4 == 0) goto L30
            com.dxmpay.apollon.restnet.http.HttpStatus r5 = r4.d()     // Catch: java.io.IOException -> L31 java.util.concurrent.TimeoutException -> L3c java.lang.NullPointerException -> L60 java.net.UnknownHostException -> L87
            com.dxmpay.apollon.restnet.http.HttpStatus r7 = com.dxmpay.apollon.restnet.http.HttpStatus.OK     // Catch: java.io.IOException -> L31 java.util.concurrent.TimeoutException -> L3c java.lang.NullPointerException -> L60 java.net.UnknownHostException -> L87
            if (r5 != r7) goto L30
            if (r1 == 0) goto L30
            java.lang.String r5 = r11.f()     // Catch: java.io.IOException -> L31 java.util.concurrent.TimeoutException -> L3c java.lang.NullPointerException -> L60 java.net.UnknownHostException -> L87
            java.lang.String r7 = r11.b()     // Catch: java.io.IOException -> L31 java.util.concurrent.TimeoutException -> L3c java.lang.NullPointerException -> L60 java.net.UnknownHostException -> L87
            r1.a(r5, r7)     // Catch: java.io.IOException -> L31 java.util.concurrent.TimeoutException -> L3c java.lang.NullPointerException -> L60 java.net.UnknownHostException -> L87
        L30:
            return r4
        L31:
            r4 = move-exception
            b.f.a.g.d.g r5 = r10.f62164b
            int r6 = r6 + 1
            boolean r5 = r5.a(r4, r6)
            goto Lb2
        L3c:
            r4 = move-exception
            java.util.concurrent.TimeoutException r5 = new java.util.concurrent.TimeoutException
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "TimeoutException exception: "
            r7.append(r8)
            java.lang.String r8 = r4.getMessage()
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            r5.<init>(r7)
            b.f.a.g.d.g r7 = r10.f62164b
            int r6 = r6 + 1
            boolean r4 = r7.a(r4, r6)
            goto L83
        L60:
            r4 = move-exception
            java.lang.NullPointerException r5 = new java.lang.NullPointerException
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "NPE in HttpClient: "
            r7.append(r8)
            java.lang.String r4 = r4.getMessage()
            r7.append(r4)
            java.lang.String r4 = r7.toString()
            r5.<init>(r4)
            b.f.a.g.d.g r4 = r10.f62164b
            int r6 = r6 + 1
            boolean r4 = r4.a(r5, r6)
        L83:
            r9 = r5
            r5 = r4
            r4 = r9
            goto Lb2
        L87:
            r4 = move-exception
            java.net.UnknownHostException r5 = new java.net.UnknownHostException
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "UnknownHostException exception: "
            r7.append(r8)
            java.lang.String r8 = r4.getMessage()
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            r5.<init>(r7)
            if (r6 <= 0) goto Lb0
            b.f.a.g.d.g r7 = r10.f62164b
            int r6 = r6 + 1
            boolean r4 = r7.a(r4, r6)
            if (r4 == 0) goto Lb0
            r4 = 1
            goto L83
        Lb0:
            r4 = 0
            goto L83
        Lb2:
            if (r5 == 0) goto Lb6
            goto L11
        Lb6:
            if (r1 == 0) goto Le2
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "RestHttpNetwork performRequest retry count:"
            r1.append(r2)
            r1.append(r6)
            java.lang.String r2 = " failure, url:"
            r1.append(r2)
            java.lang.String r11 = r11.b()
            r1.append(r11)
            java.lang.String r11 = ", origUrl:"
            r1.append(r11)
            r1.append(r0)
            java.lang.String r11 = r1.toString()
            java.lang.String r0 = "RestHttpNetwork"
            com.dxmpay.apollon.utils.LogUtil.errord(r0, r11)
        Le2:
            throw r4
        Le3:
            r8 = r0
            r9 = 1048576(0x100000, float:1.469368E-39)
            com.baidu.titan.sdk.runtime.InterceptResult r0 = r8.invokeL(r9, r10, r11)
            if (r0 == 0) goto L4
            java.lang.Object r1 = r0.objValue
            b.f.a.g.d.e r1 = (b.f.a.g.d.e) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dxmpay.apollon.restnet.rest.RestHttpNetwork.a(b.f.a.g.d.d):b.f.a.g.d.e");
    }

    @Override // b.f.a.g.d.c
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f62163a.a();
        }
    }
}
