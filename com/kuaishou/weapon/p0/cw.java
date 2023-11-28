package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class cw implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    public cw(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:49:0x03d2
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    private com.kuaishou.weapon.p0.y b(java.lang.String r21) {
        /*
            r20 = this;
            com.baidu.titan.sdk.runtime.Interceptable r0 = com.kuaishou.weapon.p0.cw.$ic
            if (r0 != 0) goto L4e1
        L4:
            java.lang.String r0 = "ie"
            java.lang.String r1 = "n"
            java.lang.String r2 = "btm"
            java.lang.String r3 = "ic"
            java.lang.String r4 = "w"
            java.lang.String r5 = "d"
            java.lang.String r6 = "p"
            java.lang.String r7 = "c"
            java.lang.String r8 = "r"
            java.lang.String r9 = "ac"
            java.lang.String r10 = "a"
            java.lang.String r11 = "mc"
            java.lang.String r12 = "is"
            com.kuaishou.weapon.p0.y r14 = new com.kuaishou.weapon.p0.y     // Catch: java.lang.Exception -> L4df
            r14.<init>()     // Catch: java.lang.Exception -> L4df
            org.json.JSONObject r15 = new org.json.JSONObject     // Catch: java.lang.Exception -> L4df
            r13 = r21
            r15.<init>(r13)     // Catch: java.lang.Exception -> L4df
            java.lang.String r13 = "status"
            r16 = r6
            r6 = 1
            int r13 = r15.optInt(r13, r6)     // Catch: java.lang.Exception -> L4df
            r14.e(r13)     // Catch: java.lang.Exception -> L4df
            int r13 = r14.z()     // Catch: java.lang.Exception -> L4df
            if (r13 == r6) goto L3e
            r13 = 0
            return r13
        L3e:
            java.lang.String r13 = "bwc"
            r6 = 0
            int r13 = r15.optInt(r13, r6)     // Catch: java.lang.Exception -> L4df
            r14.f(r13)     // Catch: java.lang.Exception -> L4df
            java.lang.String r13 = "blpc"
            r6 = 1
            int r13 = r15.optInt(r13, r6)     // Catch: java.lang.Exception -> L4df
            r14.g(r13)     // Catch: java.lang.Exception -> L4df
            java.lang.String r6 = "scc"
            r13 = 0
            int r6 = r15.optInt(r6, r13)     // Catch: java.lang.Exception -> L4df
            r14.h(r6)     // Catch: java.lang.Exception -> L4df
            java.lang.String r6 = "dpver"
            java.lang.String r6 = r15.optString(r6)     // Catch: java.lang.Exception -> L4df
            r14.j(r6)     // Catch: java.lang.Exception -> L4df
            java.lang.String r6 = "bver"
            java.lang.String r6 = r15.optString(r6)     // Catch: java.lang.Exception -> L4df
            r14.k(r6)     // Catch: java.lang.Exception -> L4df
            java.lang.String r6 = "dpd"
            r13 = 12
            int r6 = r15.optInt(r6, r13)     // Catch: java.lang.Exception -> L4df
            r14.d(r6)     // Catch: java.lang.Exception -> L4df
            java.lang.String r6 = "aar"
            r13 = 30
            int r6 = r15.optInt(r6, r13)     // Catch: java.lang.Exception -> L4df
            r14.b(r6)     // Catch: java.lang.Exception -> L4df
            java.lang.String r6 = "dir"
            java.lang.String r6 = r15.optString(r6)     // Catch: java.lang.Exception -> L4df
            r14.e(r6)     // Catch: java.lang.Exception -> L4df
            java.lang.String r6 = r15.optString(r12)     // Catch: java.lang.Exception -> L4df
            r14.f(r6)     // Catch: java.lang.Exception -> L4df
            java.lang.String r6 = "ii"
            int r6 = r15.optInt(r6)     // Catch: java.lang.Exception -> L4df
            r14.a(r6)     // Catch: java.lang.Exception -> L4df
            java.lang.String r6 = "act"
            r13 = 0
            int r6 = r15.optInt(r6, r13)     // Catch: java.lang.Exception -> L4df
            r14.c(r6)     // Catch: java.lang.Exception -> L4df
            java.lang.String r6 = "aver"
            java.lang.String r6 = r15.optString(r6)     // Catch: java.lang.Exception -> Lf3
            r14.h(r6)     // Catch: java.lang.Exception -> Lf3
            org.json.JSONObject r6 = r15.getJSONObject(r10)     // Catch: java.lang.Exception -> Lf3
            if (r6 == 0) goto Lf3
            com.kuaishou.weapon.p0.y$a r13 = new com.kuaishou.weapon.p0.y$a     // Catch: java.lang.Exception -> Lf3
            r13.<init>()     // Catch: java.lang.Exception -> Lf3
            r18 = r2
            java.lang.String r2 = "as"
            r19 = r3
            r3 = 0
            int r2 = r6.optInt(r2, r3)     // Catch: java.lang.Exception -> Lf7
            r13.c(r2)     // Catch: java.lang.Exception -> Lf7
            r2 = 3
            int r3 = r6.optInt(r9, r2)     // Catch: java.lang.Exception -> Lf7
            r13.d(r3)     // Catch: java.lang.Exception -> Lf7
            java.lang.String r2 = "ai"
            r3 = 8
            int r2 = r6.optInt(r2, r3)     // Catch: java.lang.Exception -> Lf7
            r13.e(r2)     // Catch: java.lang.Exception -> Lf7
            java.lang.String r2 = "ab"
            r3 = 0
            int r2 = r6.optInt(r2, r3)     // Catch: java.lang.Exception -> Lf7
            r13.b(r2)     // Catch: java.lang.Exception -> Lf7
            java.lang.String r2 = "am"
            int r2 = r6.optInt(r2, r3)     // Catch: java.lang.Exception -> Lf7
            r13.a(r2)     // Catch: java.lang.Exception -> Lf7
            r14.a(r13)     // Catch: java.lang.Exception -> Lf7
            goto Lf7
        Lf3:
            r18 = r2
        Lf5:
            r19 = r3
        Lf7:
            java.lang.String r2 = "acver"
            java.lang.String r2 = r15.optString(r2)     // Catch: java.lang.Exception -> L12d
            r14.b(r2)     // Catch: java.lang.Exception -> L12d
            org.json.JSONObject r2 = r15.getJSONObject(r9)     // Catch: java.lang.Exception -> L12d
            if (r2 == 0) goto L12d
            com.kuaishou.weapon.p0.y$b r3 = new com.kuaishou.weapon.p0.y$b     // Catch: java.lang.Exception -> L12d
            r3.<init>()     // Catch: java.lang.Exception -> L12d
            java.lang.String r6 = "acs"
            r9 = 1
            int r6 = r2.optInt(r6, r9)     // Catch: java.lang.Exception -> L12d
            r3.a(r6)     // Catch: java.lang.Exception -> L12d
            java.lang.String r6 = "acc"
            r9 = 3
            int r6 = r2.optInt(r6, r9)     // Catch: java.lang.Exception -> L12d
            r3.b(r6)     // Catch: java.lang.Exception -> L12d
            java.lang.String r6 = "aci"
            r9 = 8
            int r2 = r2.optInt(r6, r9)     // Catch: java.lang.Exception -> L12d
            r3.c(r2)     // Catch: java.lang.Exception -> L12d
            r14.a(r3)     // Catch: java.lang.Exception -> L12d
        L12d:
            java.lang.String r2 = "rver"
            java.lang.String r2 = r15.optString(r2)     // Catch: java.lang.Exception -> L204
            r14.a(r2)     // Catch: java.lang.Exception -> L204
            com.kuaishou.weapon.p0.y$g r2 = new com.kuaishou.weapon.p0.y$g     // Catch: java.lang.Exception -> L204
            r2.<init>()     // Catch: java.lang.Exception -> L204
            org.json.JSONObject r3 = r15.getJSONObject(r8)     // Catch: java.lang.Exception -> L204
            if (r3 == 0) goto L204
            java.lang.String r6 = "rs"
            r9 = 1
            int r6 = r3.optInt(r6, r9)     // Catch: java.lang.Exception -> L204
            r2.b(r6)     // Catch: java.lang.Exception -> L204
            java.lang.String r6 = "rc"
            r9 = 6
            int r6 = r3.optInt(r6, r9)     // Catch: java.lang.Exception -> L204
            r2.c(r6)     // Catch: java.lang.Exception -> L204
            java.lang.String r6 = "ri"
            r9 = 4
            int r6 = r3.optInt(r6, r9)     // Catch: java.lang.Exception -> L204
            r2.d(r6)     // Catch: java.lang.Exception -> L204
            java.lang.String r6 = "ro"
            r9 = 5
            int r6 = r3.optInt(r6, r9)     // Catch: java.lang.Exception -> L204
            r2.e(r6)     // Catch: java.lang.Exception -> L204
            java.lang.String r6 = "rb"
            r9 = 0
            int r6 = r3.optInt(r6, r9)     // Catch: java.lang.Exception -> L204
            r2.a(r6)     // Catch: java.lang.Exception -> L204
            java.lang.String r6 = "rcl"
            org.json.JSONObject r3 = r3.getJSONObject(r6)     // Catch: java.lang.Exception -> L204
            com.kuaishou.weapon.p0.y$g$a r6 = new com.kuaishou.weapon.p0.y$g$a     // Catch: java.lang.Exception -> L204
            r6.<init>()     // Catch: java.lang.Exception -> L204
            java.lang.String r9 = "da"
            r13 = 1
            int r9 = r3.optInt(r9, r13)     // Catch: java.lang.Exception -> L204
            r6.l(r9)     // Catch: java.lang.Exception -> L204
            java.lang.String r9 = "em"
            int r9 = r3.optInt(r9, r13)     // Catch: java.lang.Exception -> L204
            r6.b(r9)     // Catch: java.lang.Exception -> L204
            java.lang.String r9 = "li"
            int r9 = r3.optInt(r9, r13)     // Catch: java.lang.Exception -> L204
            r6.m(r9)     // Catch: java.lang.Exception -> L204
            java.lang.String r9 = "rcd"
            int r9 = r3.optInt(r9, r13)     // Catch: java.lang.Exception -> L204
            r6.f(r9)     // Catch: java.lang.Exception -> L204
            java.lang.String r9 = "dv"
            int r9 = r3.optInt(r9, r13)     // Catch: java.lang.Exception -> L204
            r6.g(r9)     // Catch: java.lang.Exception -> L204
            java.lang.String r9 = "re"
            int r9 = r3.optInt(r9, r13)     // Catch: java.lang.Exception -> L204
            r6.h(r9)     // Catch: java.lang.Exception -> L204
            java.lang.String r9 = "fr"
            int r9 = r3.optInt(r9, r13)     // Catch: java.lang.Exception -> L204
            r6.c(r9)     // Catch: java.lang.Exception -> L204
            java.lang.String r9 = "hk"
            r13 = 0
            int r9 = r3.optInt(r9, r13)     // Catch: java.lang.Exception -> L204
            r6.a(r9)     // Catch: java.lang.Exception -> L204
            java.lang.String r9 = "vp"
            int r9 = r3.optInt(r9, r13)     // Catch: java.lang.Exception -> L204
            r6.k(r9)     // Catch: java.lang.Exception -> L204
            int r9 = r3.optInt(r11, r13)     // Catch: java.lang.Exception -> L204
            r6.i(r9)     // Catch: java.lang.Exception -> L204
            java.lang.String r9 = "sc"
            r13 = 1
            int r9 = r3.optInt(r9, r13)     // Catch: java.lang.Exception -> L204
            r6.e(r9)     // Catch: java.lang.Exception -> L204
            java.lang.String r9 = "ud"
            int r9 = r3.optInt(r9, r13)     // Catch: java.lang.Exception -> L204
            r6.d(r9)     // Catch: java.lang.Exception -> L204
            java.lang.String r9 = "xp"
            int r9 = r3.optInt(r9, r13)     // Catch: java.lang.Exception -> L204
            r6.j(r9)     // Catch: java.lang.Exception -> L204
            java.lang.String r9 = "vl"
            r13 = 0
            int r3 = r3.optInt(r9, r13)     // Catch: java.lang.Exception -> L204
            r6.n(r3)     // Catch: java.lang.Exception -> L204
            r2.a(r6)     // Catch: java.lang.Exception -> L204
            r14.a(r2)     // Catch: java.lang.Exception -> L204
        L204:
            r2 = 2
            com.kuaishou.weapon.p0.y$c r3 = new com.kuaishou.weapon.p0.y$c     // Catch: java.lang.Exception -> L340
            r3.<init>()     // Catch: java.lang.Exception -> L340
            java.lang.String r6 = "b"
            org.json.JSONObject r6 = r15.getJSONObject(r6)     // Catch: java.lang.Exception -> L340
            java.lang.String r9 = "bc"
            int r9 = r6.optInt(r9, r2)     // Catch: java.lang.Exception -> L340
            r3.b(r9)     // Catch: java.lang.Exception -> L340
            java.lang.String r9 = "bi"
            r13 = 12
            int r9 = r6.optInt(r9, r13)     // Catch: java.lang.Exception -> L340
            r3.c(r9)     // Catch: java.lang.Exception -> L340
            java.lang.String r9 = "bs"
            r13 = 1
            int r9 = r6.optInt(r9, r13)     // Catch: java.lang.Exception -> L340
            r3.a(r9)     // Catch: java.lang.Exception -> L340
            java.lang.String r9 = "pry"
            org.json.JSONObject r9 = r6.getJSONObject(r9)     // Catch: java.lang.Exception -> L291
            com.kuaishou.weapon.p0.y$c$b r13 = new com.kuaishou.weapon.p0.y$c$b     // Catch: java.lang.Exception -> L291
            r13.<init>()     // Catch: java.lang.Exception -> L291
            java.lang.String r2 = "gifa"
            r17 = r15
            r15 = 1
            int r2 = r9.optInt(r2, r15)     // Catch: java.lang.Exception -> L293
            r13.e(r2)     // Catch: java.lang.Exception -> L293
            java.lang.String r2 = "gnci"
            int r2 = r9.optInt(r2, r15)     // Catch: java.lang.Exception -> L293
            r13.d(r2)     // Catch: java.lang.Exception -> L293
            java.lang.String r2 = "gsl"
            int r2 = r9.optInt(r2, r15)     // Catch: java.lang.Exception -> L293
            r13.f(r2)     // Catch: java.lang.Exception -> L293
            java.lang.String r2 = "gso"
            int r2 = r9.optInt(r2, r15)     // Catch: java.lang.Exception -> L293
            r13.c(r2)     // Catch: java.lang.Exception -> L293
            java.lang.String r2 = "gno"
            int r2 = r9.optInt(r2, r15)     // Catch: java.lang.Exception -> L293
            r13.a(r2)     // Catch: java.lang.Exception -> L293
            java.lang.String r2 = "gnon"
            int r2 = r9.optInt(r2, r15)     // Catch: java.lang.Exception -> L293
            r13.b(r2)     // Catch: java.lang.Exception -> L293
            java.lang.String r2 = "rl"
            int r2 = r9.optInt(r2, r15)     // Catch: java.lang.Exception -> L293
            r13.g(r2)     // Catch: java.lang.Exception -> L293
            java.lang.String r2 = "grs"
            int r2 = r9.optInt(r2, r15)     // Catch: java.lang.Exception -> L293
            r13.i(r2)     // Catch: java.lang.Exception -> L293
            java.lang.String r2 = "grt"
            int r2 = r9.optInt(r2, r15)     // Catch: java.lang.Exception -> L293
            r13.h(r2)     // Catch: java.lang.Exception -> L293
            r3.a(r13)     // Catch: java.lang.Exception -> L293
            goto L293
        L291:
            r17 = r15
        L293:
            java.lang.String r2 = "bcl"
            org.json.JSONObject r2 = r6.getJSONObject(r2)     // Catch: java.lang.Exception -> L342
            com.kuaishou.weapon.p0.y$c$a r6 = new com.kuaishou.weapon.p0.y$c$a     // Catch: java.lang.Exception -> L342
            r6.<init>()     // Catch: java.lang.Exception -> L342
            r9 = 1
            int r10 = r2.optInt(r10, r9)     // Catch: java.lang.Exception -> L342
            r6.a(r10)     // Catch: java.lang.Exception -> L342
            int r8 = r2.optInt(r8, r9)     // Catch: java.lang.Exception -> L342
            r6.i(r8)     // Catch: java.lang.Exception -> L342
            int r8 = r2.optInt(r7, r9)     // Catch: java.lang.Exception -> L342
            r6.b(r8)     // Catch: java.lang.Exception -> L342
            java.lang.String r8 = "s"
            int r8 = r2.optInt(r8, r9)     // Catch: java.lang.Exception -> L342
            r6.j(r8)     // Catch: java.lang.Exception -> L342
            int r8 = r2.optInt(r5, r9)     // Catch: java.lang.Exception -> L342
            r6.d(r8)     // Catch: java.lang.Exception -> L342
            java.lang.String r8 = "u"
            int r8 = r2.optInt(r8, r9)     // Catch: java.lang.Exception -> L342
            r6.k(r8)     // Catch: java.lang.Exception -> L342
            r8 = 0
            int r9 = r2.optInt(r4, r8)     // Catch: java.lang.Exception -> L342
            r6.m(r9)     // Catch: java.lang.Exception -> L342
            int r9 = r2.optInt(r1, r8)     // Catch: java.lang.Exception -> L342
            r6.f(r9)     // Catch: java.lang.Exception -> L342
            r9 = 1
            int r10 = r2.optInt(r0, r9)     // Catch: java.lang.Exception -> L342
            r6.p(r10)     // Catch: java.lang.Exception -> L342
            int r10 = r2.optInt(r12, r8)     // Catch: java.lang.Exception -> L342
            r6.e(r10)     // Catch: java.lang.Exception -> L342
            r8 = r19
            int r10 = r2.optInt(r8, r9)     // Catch: java.lang.Exception -> L33b
            r6.n(r10)     // Catch: java.lang.Exception -> L33b
            r10 = r18
            int r13 = r2.optInt(r10, r9)     // Catch: java.lang.Exception -> L338
            r6.o(r13)     // Catch: java.lang.Exception -> L338
            int r13 = r2.optInt(r11, r9)     // Catch: java.lang.Exception -> L338
            r6.l(r13)     // Catch: java.lang.Exception -> L338
            java.lang.String r13 = "rp"
            int r13 = r2.optInt(r13, r9)     // Catch: java.lang.Exception -> L338
            r6.q(r13)     // Catch: java.lang.Exception -> L338
            java.lang.String r13 = "tc"
            int r13 = r2.optInt(r13, r9)     // Catch: java.lang.Exception -> L338
            r6.g(r13)     // Catch: java.lang.Exception -> L338
            java.lang.String r13 = "il"
            int r13 = r2.optInt(r13, r9)     // Catch: java.lang.Exception -> L338
            r6.c(r13)     // Catch: java.lang.Exception -> L338
            r13 = r16
            int r15 = r2.optInt(r13, r9)     // Catch: java.lang.Exception -> L348
            r6.h(r15)     // Catch: java.lang.Exception -> L348
            java.lang.String r15 = "l"
            int r2 = r2.optInt(r15, r9)     // Catch: java.lang.Exception -> L348
            r6.r(r2)     // Catch: java.lang.Exception -> L348
            r3.a(r6)     // Catch: java.lang.Exception -> L348
            r14.a(r3)     // Catch: java.lang.Exception -> L348
            goto L348
        L338:
            r13 = r16
            goto L348
        L33b:
            r13 = r16
            r10 = r18
            goto L348
        L340:
            r17 = r15
        L342:
            r13 = r16
            r10 = r18
            r8 = r19
        L348:
            java.lang.String r2 = "cver"
            r3 = r17
            java.lang.String r2 = r3.optString(r2)     // Catch: java.lang.Exception -> L3d4
            r14.g(r2)     // Catch: java.lang.Exception -> L3d4
            com.kuaishou.weapon.p0.y$d r2 = new com.kuaishou.weapon.p0.y$d     // Catch: java.lang.Exception -> L3d4
            r2.<init>()     // Catch: java.lang.Exception -> L3d4
            org.json.JSONObject r6 = r3.getJSONObject(r7)     // Catch: java.lang.Exception -> L3d4
            java.lang.String r7 = "cc"
            r9 = 2
            int r7 = r6.optInt(r7, r9)     // Catch: java.lang.Exception -> L3d4
            r2.b(r7)     // Catch: java.lang.Exception -> L3d4
            java.lang.String r7 = "ci"
            r9 = 12
            int r7 = r6.optInt(r7, r9)     // Catch: java.lang.Exception -> L3d4
            r2.c(r7)     // Catch: java.lang.Exception -> L3d4
            java.lang.String r7 = "cs"
            r9 = 1
            int r7 = r6.optInt(r7, r9)     // Catch: java.lang.Exception -> L3d4
            r2.a(r7)     // Catch: java.lang.Exception -> L3d4
            java.lang.String r7 = "cb"
            r9 = 0
            int r7 = r6.optInt(r7, r9)     // Catch: java.lang.Exception -> L3d4
            r2.d(r7)     // Catch: java.lang.Exception -> L3d4
            java.lang.String r7 = "ccl"
            org.json.JSONObject r6 = r6.getJSONObject(r7)     // Catch: java.lang.Exception -> L3d4
            com.kuaishou.weapon.p0.y$d$a r7 = new com.kuaishou.weapon.p0.y$d$a     // Catch: java.lang.Exception -> L3d4
            r7.<init>()     // Catch: java.lang.Exception -> L3d4
            r9 = 1
            int r5 = r6.optInt(r5, r9)     // Catch: java.lang.Exception -> L3d4
            r7.a(r5)     // Catch: java.lang.Exception -> L3d4
            int r5 = r6.optInt(r11, r9)     // Catch: java.lang.Exception -> L3d4
            r7.b(r5)     // Catch: java.lang.Exception -> L3d4
            r5 = 0
            int r4 = r6.optInt(r4, r5)     // Catch: java.lang.Exception -> L3d4
            r7.c(r4)     // Catch: java.lang.Exception -> L3d4
            int r4 = r6.optInt(r12, r9)     // Catch: java.lang.Exception -> L3d4
            r7.d(r4)     // Catch: java.lang.Exception -> L3d4
            int r4 = r6.optInt(r8, r9)     // Catch: java.lang.Exception -> L3d4
            r7.e(r4)     // Catch: java.lang.Exception -> L3d4
            int r4 = r6.optInt(r10, r9)     // Catch: java.lang.Exception -> L3d4
            r7.f(r4)     // Catch: java.lang.Exception -> L3d4
            int r0 = r6.optInt(r0, r9)     // Catch: java.lang.Exception -> L3d4
            r7.g(r0)     // Catch: java.lang.Exception -> L3d4
            r0 = 0
            int r1 = r6.optInt(r1, r0)     // Catch: java.lang.Exception -> L3d4
            r7.h(r1)     // Catch: java.lang.Exception -> L3d4
            r2.a(r7)     // Catch: java.lang.Exception -> L3d4
            r14.a(r2)     // Catch: java.lang.Exception -> L3d4
            goto L3d4
        L3d2:
            r3 = r17
        L3d4:
            java.lang.String r0 = "pgver"
            java.lang.String r0 = r3.optString(r0)     // Catch: java.lang.Exception -> L448
            r14.i(r0)     // Catch: java.lang.Exception -> L448
            org.json.JSONObject r0 = r3.optJSONObject(r13)     // Catch: java.lang.Exception -> L448
            if (r0 == 0) goto L448
            com.kuaishou.weapon.p0.y$f r1 = new com.kuaishou.weapon.p0.y$f     // Catch: java.lang.Exception -> L448
            r1.<init>()     // Catch: java.lang.Exception -> L448
            java.lang.String r2 = "ps"
            r4 = 1
            int r2 = r0.optInt(r2, r4)     // Catch: java.lang.Exception -> L448
            r1.a(r2)     // Catch: java.lang.Exception -> L448
            java.lang.String r2 = "pc"
            r4 = 2
            int r2 = r0.optInt(r2, r4)     // Catch: java.lang.Exception -> L448
            r1.b(r2)     // Catch: java.lang.Exception -> L448
            java.lang.String r2 = "pi"
            r4 = 12
            int r2 = r0.optInt(r2, r4)     // Catch: java.lang.Exception -> L448
            r1.c(r2)     // Catch: java.lang.Exception -> L448
            java.lang.String r2 = "pcl"
            org.json.JSONObject r0 = r0.optJSONObject(r2)     // Catch: java.lang.Exception -> L448
            if (r0 == 0) goto L445
            com.kuaishou.weapon.p0.y$f$a r2 = new com.kuaishou.weapon.p0.y$f$a     // Catch: java.lang.Exception -> L448
            r2.<init>()     // Catch: java.lang.Exception -> L448
            java.lang.String r4 = "cp"
            r5 = 1
            int r4 = r0.optInt(r4, r5)     // Catch: java.lang.Exception -> L448
            r2.d(r4)     // Catch: java.lang.Exception -> L448
            java.lang.String r4 = "gc"
            int r4 = r0.optInt(r4, r5)     // Catch: java.lang.Exception -> L448
            r2.c(r4)     // Catch: java.lang.Exception -> L448
            java.lang.String r4 = "pke"
            int r4 = r0.optInt(r4, r5)     // Catch: java.lang.Exception -> L448
            r2.b(r4)     // Catch: java.lang.Exception -> L448
            java.lang.String r4 = "pds"
            int r4 = r0.optInt(r4, r5)     // Catch: java.lang.Exception -> L448
            r2.e(r4)     // Catch: java.lang.Exception -> L448
            java.lang.String r4 = "pam"
            int r0 = r0.optInt(r4, r5)     // Catch: java.lang.Exception -> L448
            r2.a(r0)     // Catch: java.lang.Exception -> L448
            r1.a(r2)     // Catch: java.lang.Exception -> L448
        L445:
            r14.a(r1)     // Catch: java.lang.Exception -> L448
        L448:
            java.lang.String r0 = "socver"
            java.lang.String r0 = r3.optString(r0)     // Catch: java.lang.Exception -> L48a
            r14.m(r0)     // Catch: java.lang.Exception -> L48a
            java.lang.String r0 = "soc"
            org.json.JSONObject r0 = r3.optJSONObject(r0)     // Catch: java.lang.Exception -> L48a
            if (r0 == 0) goto L48a
            com.kuaishou.weapon.p0.y$h r1 = new com.kuaishou.weapon.p0.y$h     // Catch: java.lang.Exception -> L48a
            r1.<init>()     // Catch: java.lang.Exception -> L48a
            java.lang.String r2 = "socs"
            r4 = 0
            int r2 = r0.optInt(r2, r4)     // Catch: java.lang.Exception -> L48a
            r1.c(r2)     // Catch: java.lang.Exception -> L48a
            java.lang.String r2 = "socc"
            r4 = 2
            int r2 = r0.optInt(r2, r4)     // Catch: java.lang.Exception -> L48a
            r1.d(r2)     // Catch: java.lang.Exception -> L48a
            java.lang.String r2 = "soci"
            r4 = 12
            int r2 = r0.optInt(r2, r4)     // Catch: java.lang.Exception -> L48a
            r1.b(r2)     // Catch: java.lang.Exception -> L48a
            java.lang.String r2 = "snack"
            r4 = 0
            int r0 = r0.optInt(r2, r4)     // Catch: java.lang.Exception -> L48a
            r1.a(r0)     // Catch: java.lang.Exception -> L48a
            r14.a(r1)     // Catch: java.lang.Exception -> L48a
        L48a:
            java.lang.String r0 = "hver"
            java.lang.String r0 = r3.optString(r0)     // Catch: java.lang.Exception -> L4de
            r14.d(r0)     // Catch: java.lang.Exception -> L4de
            java.lang.String r0 = "h"
            org.json.JSONObject r0 = r3.optJSONObject(r0)     // Catch: java.lang.Exception -> L4de
            if (r0 == 0) goto L4de
            com.kuaishou.weapon.p0.y$e r1 = new com.kuaishou.weapon.p0.y$e     // Catch: java.lang.Exception -> L4de
            r1.<init>()     // Catch: java.lang.Exception -> L4de
            java.lang.String r2 = "hs"
            r3 = 1
            int r2 = r0.optInt(r2, r3)     // Catch: java.lang.Exception -> L4de
            r1.b(r2)     // Catch: java.lang.Exception -> L4de
            java.lang.String r2 = "hc"
            r3 = 2
            int r2 = r0.optInt(r2, r3)     // Catch: java.lang.Exception -> L4de
            r1.c(r2)     // Catch: java.lang.Exception -> L4de
            java.lang.String r2 = "hi"
            r3 = 12
            int r2 = r0.optInt(r2, r3)     // Catch: java.lang.Exception -> L4de
            r1.a(r2)     // Catch: java.lang.Exception -> L4de
            java.lang.String r2 = "hsdc"
            r3 = 1
            int r2 = r0.optInt(r2, r3)     // Catch: java.lang.Exception -> L4de
            r1.d(r2)     // Catch: java.lang.Exception -> L4de
            java.lang.String r2 = "hlbr"
            int r2 = r0.optInt(r2, r3)     // Catch: java.lang.Exception -> L4de
            r1.e(r2)     // Catch: java.lang.Exception -> L4de
            java.lang.String r2 = "pr"
            java.lang.String r0 = r0.optString(r2)     // Catch: java.lang.Exception -> L4de
            r1.a(r0)     // Catch: java.lang.Exception -> L4de
            r14.a(r1)     // Catch: java.lang.Exception -> L4de
        L4de:
            return r14
        L4df:
            r0 = 0
            return r0
        L4e1:
            r18 = r0
            r19 = 65537(0x10001, float:9.1837E-41)
            com.baidu.titan.sdk.runtime.InterceptResult r0 = r18.invokeL(r19, r20, r21)
            if (r0 == 0) goto L4
            java.lang.Object r1 = r0.objValue
            com.kuaishou.weapon.p0.y r1 = (com.kuaishou.weapon.p0.y) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.cw.b(java.lang.String):com.kuaishou.weapon.p0.y");
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.optInt("result", 0) == 1) {
                    String a = new bn(this.a).a(jSONObject.getString("antispamPluginRsp"));
                    if (TextUtils.isEmpty(a)) {
                        return;
                    }
                    y b = b(a);
                    if (b != null) {
                        df.a(this.a).a(str, b);
                    } else {
                        df.a(this.a).b(System.currentTimeMillis());
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            try {
                String str = cu.a + cu.d;
                String a = cv.a(this.a);
                if (!TextUtils.isEmpty(a)) {
                    str = str + "?" + a;
                }
                JSONObject jSONObject = new JSONObject();
                JSONObject b = cv.b(this.a);
                if (b != null) {
                    jSONObject.put("data", new bn(this.a).c(b.toString()));
                }
                l a2 = l.a(this.a);
                m mVar = new m(str, jSONObject);
                mVar.a(WeaponHI.cookieData);
                mVar.b(WeaponHI.encryENV);
                a2.b(mVar, new j(this) { // from class: com.kuaishou.weapon.p0.cw.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ cw a;

                    @Override // com.kuaishou.weapon.p0.j
                    public void b(String str2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str2) == null) {
                        }
                    }

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = this;
                    }

                    @Override // com.kuaishou.weapon.p0.j
                    public void a(String str2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, str2) == null) {
                            try {
                                this.a.a(str2);
                            } catch (Exception unused) {
                            }
                        }
                    }
                });
            } catch (Exception unused) {
            }
        }
    }
}
