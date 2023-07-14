package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class x2 implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* loaded from: classes9.dex */
    public class a implements k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x2 a;

        public a(x2 x2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = x2Var;
        }

        @Override // com.kuaishou.weapon.p0.k
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            }
        }

        @Override // com.kuaishou.weapon.p0.k
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                try {
                    this.a.a(str);
                } catch (Exception unused) {
                }
            }
        }
    }

    public x2(Context context) {
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
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:67:0x00f6
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    private com.kuaishou.weapon.p0.z b(java.lang.String r20) {
        /*
            r19 = this;
            com.baidu.titan.sdk.runtime.Interceptable r0 = com.kuaishou.weapon.p0.x2.$ic
            if (r0 != 0) goto L488
        L4:
            java.lang.String r0 = "ie"
            java.lang.String r1 = "btm"
            java.lang.String r2 = "n"
            java.lang.String r3 = "ic"
            java.lang.String r4 = "w"
            java.lang.String r5 = "d"
            java.lang.String r6 = "c"
            java.lang.String r7 = "p"
            java.lang.String r8 = "r"
            java.lang.String r9 = "ac"
            java.lang.String r10 = "a"
            java.lang.String r11 = "mc"
            java.lang.String r12 = "is"
            com.kuaishou.weapon.p0.z r14 = new com.kuaishou.weapon.p0.z     // Catch: java.lang.Exception -> L486
            r14.<init>()     // Catch: java.lang.Exception -> L486
            org.json.JSONObject r15 = new org.json.JSONObject     // Catch: java.lang.Exception -> L486
            r13 = r20
            r15.<init>(r13)     // Catch: java.lang.Exception -> L486
            java.lang.String r13 = "status"
            r16 = r7
            r7 = 1
            int r13 = r15.optInt(r13, r7)     // Catch: java.lang.Exception -> L486
            r14.h(r13)     // Catch: java.lang.Exception -> L486
            int r13 = r14.C()     // Catch: java.lang.Exception -> L486
            if (r13 == r7) goto L40
            r13 = 0
            return r13
        L40:
            java.lang.String r13 = "bwc"
            r7 = 3
            int r13 = r15.optInt(r13, r7)     // Catch: java.lang.Exception -> L486
            r14.d(r13)     // Catch: java.lang.Exception -> L486
            java.lang.String r13 = "blpc"
            int r13 = r15.optInt(r13, r7)     // Catch: java.lang.Exception -> L486
            r14.c(r13)     // Catch: java.lang.Exception -> L486
            java.lang.String r13 = "scc"
            r7 = 0
            int r13 = r15.optInt(r13, r7)     // Catch: java.lang.Exception -> L486
            r14.g(r13)     // Catch: java.lang.Exception -> L486
            java.lang.String r13 = "dpver"
            java.lang.String r13 = r15.optString(r13)     // Catch: java.lang.Exception -> L486
            r14.f(r13)     // Catch: java.lang.Exception -> L486
            java.lang.String r13 = "bver"
            java.lang.String r13 = r15.optString(r13)     // Catch: java.lang.Exception -> L486
            r14.c(r13)     // Catch: java.lang.Exception -> L486
            java.lang.String r13 = "dpd"
            r7 = 12
            int r13 = r15.optInt(r13, r7)     // Catch: java.lang.Exception -> L486
            r14.e(r13)     // Catch: java.lang.Exception -> L486
            java.lang.String r13 = "aar"
            r7 = 30
            int r7 = r15.optInt(r13, r7)     // Catch: java.lang.Exception -> L486
            r14.a(r7)     // Catch: java.lang.Exception -> L486
            java.lang.String r7 = "dir"
            java.lang.String r7 = r15.optString(r7)     // Catch: java.lang.Exception -> L486
            r14.e(r7)     // Catch: java.lang.Exception -> L486
            java.lang.String r7 = r15.optString(r12)     // Catch: java.lang.Exception -> L486
            r14.i(r7)     // Catch: java.lang.Exception -> L486
            java.lang.String r7 = "ii"
            int r7 = r15.optInt(r7)     // Catch: java.lang.Exception -> L486
            r14.f(r7)     // Catch: java.lang.Exception -> L486
            java.lang.String r7 = "act"
            r13 = 0
            int r7 = r15.optInt(r7, r13)     // Catch: java.lang.Exception -> L486
            r14.b(r7)     // Catch: java.lang.Exception -> L486
            java.lang.String r13 = "aver"
            java.lang.String r13 = r15.optString(r13)     // Catch: java.lang.Exception -> Lf4
            r14.b(r13)     // Catch: java.lang.Exception -> Lf4
            org.json.JSONObject r13 = r15.getJSONObject(r10)     // Catch: java.lang.Exception -> Lf4
            if (r13 == 0) goto Lf4
            com.kuaishou.weapon.p0.z$a r7 = new com.kuaishou.weapon.p0.z$a     // Catch: java.lang.Exception -> Lf4
            r7.<init>()     // Catch: java.lang.Exception -> Lf4
            r17 = r1
            java.lang.String r1 = "as"
            r18 = r3
            r3 = 0
            int r1 = r13.optInt(r1, r3)     // Catch: java.lang.Exception -> Lf8
            r7.e(r1)     // Catch: java.lang.Exception -> Lf8
            r1 = 3
            int r3 = r13.optInt(r9, r1)     // Catch: java.lang.Exception -> Lf8
            r7.b(r3)     // Catch: java.lang.Exception -> Lf8
            java.lang.String r1 = "ai"
            r3 = 8
            int r1 = r13.optInt(r1, r3)     // Catch: java.lang.Exception -> Lf8
            r7.c(r1)     // Catch: java.lang.Exception -> Lf8
            java.lang.String r1 = "ab"
            r3 = 0
            int r1 = r13.optInt(r1, r3)     // Catch: java.lang.Exception -> Lf8
            r7.a(r1)     // Catch: java.lang.Exception -> Lf8
            java.lang.String r1 = "am"
            int r1 = r13.optInt(r1, r3)     // Catch: java.lang.Exception -> Lf8
            r7.d(r1)     // Catch: java.lang.Exception -> Lf8
            r14.a(r7)     // Catch: java.lang.Exception -> Lf8
            goto Lf8
        Lf4:
            r17 = r1
        Lf6:
            r18 = r3
        Lf8:
            java.lang.String r1 = "acver"
            java.lang.String r1 = r15.optString(r1)     // Catch: java.lang.Exception -> L12e
            r14.a(r1)     // Catch: java.lang.Exception -> L12e
            org.json.JSONObject r1 = r15.getJSONObject(r9)     // Catch: java.lang.Exception -> L12e
            if (r1 == 0) goto L12e
            com.kuaishou.weapon.p0.z$b r3 = new com.kuaishou.weapon.p0.z$b     // Catch: java.lang.Exception -> L12e
            r3.<init>()     // Catch: java.lang.Exception -> L12e
            java.lang.String r7 = "acs"
            r9 = 1
            int r7 = r1.optInt(r7, r9)     // Catch: java.lang.Exception -> L12e
            r3.c(r7)     // Catch: java.lang.Exception -> L12e
            java.lang.String r7 = "acc"
            r9 = 3
            int r7 = r1.optInt(r7, r9)     // Catch: java.lang.Exception -> L12e
            r3.a(r7)     // Catch: java.lang.Exception -> L12e
            java.lang.String r7 = "aci"
            r9 = 8
            int r1 = r1.optInt(r7, r9)     // Catch: java.lang.Exception -> L12e
            r3.b(r1)     // Catch: java.lang.Exception -> L12e
            r14.a(r3)     // Catch: java.lang.Exception -> L12e
        L12e:
            java.lang.String r1 = "rver"
            java.lang.String r1 = r15.optString(r1)     // Catch: java.lang.Exception -> L209
            r14.l(r1)     // Catch: java.lang.Exception -> L209
            com.kuaishou.weapon.p0.z$g r1 = new com.kuaishou.weapon.p0.z$g     // Catch: java.lang.Exception -> L209
            r1.<init>()     // Catch: java.lang.Exception -> L209
            org.json.JSONObject r3 = r15.getJSONObject(r8)     // Catch: java.lang.Exception -> L209
            if (r3 == 0) goto L209
            java.lang.String r7 = "rs"
            r9 = 1
            int r7 = r3.optInt(r7, r9)     // Catch: java.lang.Exception -> L209
            r1.e(r7)     // Catch: java.lang.Exception -> L209
            java.lang.String r7 = "rc"
            r9 = 6
            int r7 = r3.optInt(r7, r9)     // Catch: java.lang.Exception -> L209
            r1.b(r7)     // Catch: java.lang.Exception -> L209
            java.lang.String r7 = "ri"
            r9 = 4
            int r7 = r3.optInt(r7, r9)     // Catch: java.lang.Exception -> L209
            r1.c(r7)     // Catch: java.lang.Exception -> L209
            java.lang.String r7 = "ro"
            r9 = 5
            int r7 = r3.optInt(r7, r9)     // Catch: java.lang.Exception -> L209
            r1.d(r7)     // Catch: java.lang.Exception -> L209
            java.lang.String r7 = "rb"
            r9 = 0
            int r7 = r3.optInt(r7, r9)     // Catch: java.lang.Exception -> L209
            r1.a(r7)     // Catch: java.lang.Exception -> L209
            java.lang.String r7 = "rcl"
            org.json.JSONObject r3 = r3.getJSONObject(r7)     // Catch: java.lang.Exception -> L209
            com.kuaishou.weapon.p0.z$g$a r7 = new com.kuaishou.weapon.p0.z$g$a     // Catch: java.lang.Exception -> L209
            r7.<init>()     // Catch: java.lang.Exception -> L209
            java.lang.String r9 = "da"
            r13 = 1
            int r9 = r3.optInt(r9, r13)     // Catch: java.lang.Exception -> L209
            r7.a(r9)     // Catch: java.lang.Exception -> L209
            java.lang.String r9 = "em"
            int r9 = r3.optInt(r9, r13)     // Catch: java.lang.Exception -> L209
            r7.c(r9)     // Catch: java.lang.Exception -> L209
            java.lang.String r9 = "li"
            int r9 = r3.optInt(r9, r13)     // Catch: java.lang.Exception -> L209
            r7.f(r9)     // Catch: java.lang.Exception -> L209
            java.lang.String r9 = "rcd"
            int r9 = r3.optInt(r9, r13)     // Catch: java.lang.Exception -> L209
            r7.h(r9)     // Catch: java.lang.Exception -> L209
            java.lang.String r9 = "dv"
            int r9 = r3.optInt(r9, r13)     // Catch: java.lang.Exception -> L209
            r7.b(r9)     // Catch: java.lang.Exception -> L209
            java.lang.String r9 = "re"
            int r9 = r3.optInt(r9, r13)     // Catch: java.lang.Exception -> L209
            r7.i(r9)     // Catch: java.lang.Exception -> L209
            java.lang.String r9 = "fr"
            int r9 = r3.optInt(r9, r13)     // Catch: java.lang.Exception -> L209
            r7.d(r9)     // Catch: java.lang.Exception -> L209
            java.lang.String r9 = "hk"
            r13 = 0
            int r9 = r3.optInt(r9, r13)     // Catch: java.lang.Exception -> L209
            r7.e(r9)     // Catch: java.lang.Exception -> L209
            java.lang.String r9 = "vp"
            int r9 = r3.optInt(r9, r13)     // Catch: java.lang.Exception -> L209
            r7.m(r9)     // Catch: java.lang.Exception -> L209
            int r9 = r3.optInt(r11, r13)     // Catch: java.lang.Exception -> L209
            r7.g(r9)     // Catch: java.lang.Exception -> L209
            java.lang.String r9 = "sc"
            r13 = 1
            int r9 = r3.optInt(r9, r13)     // Catch: java.lang.Exception -> L209
            r7.j(r9)     // Catch: java.lang.Exception -> L209
            java.lang.String r9 = "ud"
            int r9 = r3.optInt(r9, r13)     // Catch: java.lang.Exception -> L209
            r7.k(r9)     // Catch: java.lang.Exception -> L209
            java.lang.String r9 = "xp"
            int r9 = r3.optInt(r9, r13)     // Catch: java.lang.Exception -> L209
            r7.n(r9)     // Catch: java.lang.Exception -> L209
            java.lang.String r9 = "vl"
            r13 = 0
            int r3 = r3.optInt(r9, r13)     // Catch: java.lang.Exception -> L209
            r7.l(r3)     // Catch: java.lang.Exception -> L209
            r1.a(r7)     // Catch: java.lang.Exception -> L209
            r14.a(r1)     // Catch: java.lang.Exception -> L209
        L209:
            r1 = 2
            com.kuaishou.weapon.p0.z$c r3 = new com.kuaishou.weapon.p0.z$c     // Catch: java.lang.Exception -> L2e4
            r3.<init>()     // Catch: java.lang.Exception -> L2e4
            java.lang.String r7 = "b"
            org.json.JSONObject r7 = r15.getJSONObject(r7)     // Catch: java.lang.Exception -> L2e4
            java.lang.String r9 = "bc"
            int r9 = r7.optInt(r9, r1)     // Catch: java.lang.Exception -> L2e4
            r3.a(r9)     // Catch: java.lang.Exception -> L2e4
            java.lang.String r9 = "bi"
            r13 = 12
            int r9 = r7.optInt(r9, r13)     // Catch: java.lang.Exception -> L2e4
            r3.b(r9)     // Catch: java.lang.Exception -> L2e4
            java.lang.String r9 = "bs"
            r13 = 1
            int r9 = r7.optInt(r9, r13)     // Catch: java.lang.Exception -> L2e4
            r3.c(r9)     // Catch: java.lang.Exception -> L2e4
            java.lang.String r9 = "bcl"
            org.json.JSONObject r7 = r7.getJSONObject(r9)     // Catch: java.lang.Exception -> L2e4
            com.kuaishou.weapon.p0.z$c$a r9 = new com.kuaishou.weapon.p0.z$c$a     // Catch: java.lang.Exception -> L2e4
            r9.<init>()     // Catch: java.lang.Exception -> L2e4
            r13 = 1
            int r10 = r7.optInt(r10, r13)     // Catch: java.lang.Exception -> L2e4
            r9.a(r10)     // Catch: java.lang.Exception -> L2e4
            int r8 = r7.optInt(r8, r13)     // Catch: java.lang.Exception -> L2e4
            r9.m(r8)     // Catch: java.lang.Exception -> L2e4
            int r8 = r7.optInt(r6, r13)     // Catch: java.lang.Exception -> L2e4
            r9.c(r8)     // Catch: java.lang.Exception -> L2e4
            java.lang.String r8 = "s"
            int r8 = r7.optInt(r8, r13)     // Catch: java.lang.Exception -> L2e4
            r9.o(r8)     // Catch: java.lang.Exception -> L2e4
            int r8 = r7.optInt(r5, r13)     // Catch: java.lang.Exception -> L2e4
            r9.d(r8)     // Catch: java.lang.Exception -> L2e4
            java.lang.String r8 = "u"
            int r8 = r7.optInt(r8, r13)     // Catch: java.lang.Exception -> L2e4
            r9.q(r8)     // Catch: java.lang.Exception -> L2e4
            r8 = 0
            int r10 = r7.optInt(r4, r8)     // Catch: java.lang.Exception -> L2e4
            r9.r(r10)     // Catch: java.lang.Exception -> L2e4
            int r10 = r7.optInt(r2, r8)     // Catch: java.lang.Exception -> L2e4
            r9.k(r10)     // Catch: java.lang.Exception -> L2e4
            r8 = 1
            int r10 = r7.optInt(r0, r8)     // Catch: java.lang.Exception -> L2e4
            r9.f(r10)     // Catch: java.lang.Exception -> L2e4
            int r10 = r7.optInt(r12, r8)     // Catch: java.lang.Exception -> L2e4
            r9.h(r10)     // Catch: java.lang.Exception -> L2e4
            r10 = r18
            int r13 = r7.optInt(r10, r8)     // Catch: java.lang.Exception -> L2df
            r9.e(r13)     // Catch: java.lang.Exception -> L2df
            r13 = r17
            int r1 = r7.optInt(r13, r8)     // Catch: java.lang.Exception -> L2dc
            r9.b(r1)     // Catch: java.lang.Exception -> L2dc
            int r1 = r7.optInt(r11, r8)     // Catch: java.lang.Exception -> L2dc
            r9.j(r1)     // Catch: java.lang.Exception -> L2dc
            java.lang.String r1 = "rp"
            int r1 = r7.optInt(r1, r8)     // Catch: java.lang.Exception -> L2dc
            r9.n(r1)     // Catch: java.lang.Exception -> L2dc
            java.lang.String r1 = "tc"
            int r1 = r7.optInt(r1, r8)     // Catch: java.lang.Exception -> L2dc
            r9.p(r1)     // Catch: java.lang.Exception -> L2dc
            java.lang.String r1 = "il"
            int r1 = r7.optInt(r1, r8)     // Catch: java.lang.Exception -> L2dc
            r9.g(r1)     // Catch: java.lang.Exception -> L2dc
            r1 = r16
            r16 = r2
            int r2 = r7.optInt(r1, r8)     // Catch: java.lang.Exception -> L2ec
            r9.l(r2)     // Catch: java.lang.Exception -> L2ec
            java.lang.String r2 = "l"
            int r2 = r7.optInt(r2, r8)     // Catch: java.lang.Exception -> L2ec
            r9.i(r2)     // Catch: java.lang.Exception -> L2ec
            r3.a(r9)     // Catch: java.lang.Exception -> L2ec
            r14.a(r3)     // Catch: java.lang.Exception -> L2ec
            goto L2ec
        L2dc:
            r1 = r16
            goto L2ea
        L2df:
            r1 = r16
            r13 = r17
            goto L2ea
        L2e4:
            r1 = r16
            r13 = r17
            r10 = r18
        L2ea:
            r16 = r2
        L2ec:
            java.lang.String r2 = "cver"
            java.lang.String r2 = r15.optString(r2)     // Catch: java.lang.Exception -> L375
            r14.d(r2)     // Catch: java.lang.Exception -> L375
            com.kuaishou.weapon.p0.z$d r2 = new com.kuaishou.weapon.p0.z$d     // Catch: java.lang.Exception -> L375
            r2.<init>()     // Catch: java.lang.Exception -> L375
            org.json.JSONObject r3 = r15.getJSONObject(r6)     // Catch: java.lang.Exception -> L375
            java.lang.String r6 = "cc"
            r7 = 2
            int r6 = r3.optInt(r6, r7)     // Catch: java.lang.Exception -> L375
            r2.b(r6)     // Catch: java.lang.Exception -> L375
            java.lang.String r6 = "ci"
            r7 = 12
            int r6 = r3.optInt(r6, r7)     // Catch: java.lang.Exception -> L375
            r2.c(r6)     // Catch: java.lang.Exception -> L375
            java.lang.String r6 = "cs"
            r7 = 1
            int r6 = r3.optInt(r6, r7)     // Catch: java.lang.Exception -> L375
            r2.d(r6)     // Catch: java.lang.Exception -> L375
            java.lang.String r6 = "cb"
            r7 = 0
            int r6 = r3.optInt(r6, r7)     // Catch: java.lang.Exception -> L375
            r2.a(r6)     // Catch: java.lang.Exception -> L375
            java.lang.String r6 = "ccl"
            org.json.JSONObject r3 = r3.getJSONObject(r6)     // Catch: java.lang.Exception -> L375
            com.kuaishou.weapon.p0.z$d$a r6 = new com.kuaishou.weapon.p0.z$d$a     // Catch: java.lang.Exception -> L375
            r6.<init>()     // Catch: java.lang.Exception -> L375
            r7 = 1
            int r5 = r3.optInt(r5, r7)     // Catch: java.lang.Exception -> L375
            r6.b(r5)     // Catch: java.lang.Exception -> L375
            int r5 = r3.optInt(r11, r7)     // Catch: java.lang.Exception -> L375
            r6.f(r5)     // Catch: java.lang.Exception -> L375
            r5 = 0
            int r4 = r3.optInt(r4, r5)     // Catch: java.lang.Exception -> L375
            r6.h(r4)     // Catch: java.lang.Exception -> L375
            int r4 = r3.optInt(r12, r7)     // Catch: java.lang.Exception -> L375
            r6.e(r4)     // Catch: java.lang.Exception -> L375
            int r4 = r3.optInt(r10, r7)     // Catch: java.lang.Exception -> L375
            r6.c(r4)     // Catch: java.lang.Exception -> L375
            int r4 = r3.optInt(r13, r7)     // Catch: java.lang.Exception -> L375
            r6.a(r4)     // Catch: java.lang.Exception -> L375
            int r0 = r3.optInt(r0, r7)     // Catch: java.lang.Exception -> L375
            r6.d(r0)     // Catch: java.lang.Exception -> L375
            r0 = r16
            r4 = 0
            int r0 = r3.optInt(r0, r4)     // Catch: java.lang.Exception -> L375
            r6.g(r0)     // Catch: java.lang.Exception -> L375
            r2.a(r6)     // Catch: java.lang.Exception -> L375
            r14.a(r2)     // Catch: java.lang.Exception -> L375
        L375:
            java.lang.String r0 = "pgver"
            java.lang.String r0 = r15.optString(r0)     // Catch: java.lang.Exception -> L3e9
            r14.k(r0)     // Catch: java.lang.Exception -> L3e9
            org.json.JSONObject r0 = r15.optJSONObject(r1)     // Catch: java.lang.Exception -> L3e9
            if (r0 == 0) goto L3e9
            com.kuaishou.weapon.p0.z$f r1 = new com.kuaishou.weapon.p0.z$f     // Catch: java.lang.Exception -> L3e9
            r1.<init>()     // Catch: java.lang.Exception -> L3e9
            java.lang.String r2 = "ps"
            r3 = 1
            int r2 = r0.optInt(r2, r3)     // Catch: java.lang.Exception -> L3e9
            r1.c(r2)     // Catch: java.lang.Exception -> L3e9
            java.lang.String r2 = "pc"
            r3 = 2
            int r2 = r0.optInt(r2, r3)     // Catch: java.lang.Exception -> L3e9
            r1.a(r2)     // Catch: java.lang.Exception -> L3e9
            java.lang.String r2 = "pi"
            r3 = 12
            int r2 = r0.optInt(r2, r3)     // Catch: java.lang.Exception -> L3e9
            r1.b(r2)     // Catch: java.lang.Exception -> L3e9
            java.lang.String r2 = "pcl"
            org.json.JSONObject r0 = r0.optJSONObject(r2)     // Catch: java.lang.Exception -> L3e9
            if (r0 == 0) goto L3e6
            com.kuaishou.weapon.p0.z$f$a r2 = new com.kuaishou.weapon.p0.z$f$a     // Catch: java.lang.Exception -> L3e9
            r2.<init>()     // Catch: java.lang.Exception -> L3e9
            java.lang.String r3 = "cp"
            r4 = 1
            int r3 = r0.optInt(r3, r4)     // Catch: java.lang.Exception -> L3e9
            r2.a(r3)     // Catch: java.lang.Exception -> L3e9
            java.lang.String r3 = "gc"
            int r3 = r0.optInt(r3, r4)     // Catch: java.lang.Exception -> L3e9
            r2.b(r3)     // Catch: java.lang.Exception -> L3e9
            java.lang.String r3 = "pke"
            int r3 = r0.optInt(r3, r4)     // Catch: java.lang.Exception -> L3e9
            r2.e(r3)     // Catch: java.lang.Exception -> L3e9
            java.lang.String r3 = "pds"
            int r3 = r0.optInt(r3, r4)     // Catch: java.lang.Exception -> L3e9
            r2.d(r3)     // Catch: java.lang.Exception -> L3e9
            java.lang.String r3 = "pam"
            int r0 = r0.optInt(r3, r4)     // Catch: java.lang.Exception -> L3e9
            r2.c(r0)     // Catch: java.lang.Exception -> L3e9
            r1.a(r2)     // Catch: java.lang.Exception -> L3e9
        L3e6:
            r14.a(r1)     // Catch: java.lang.Exception -> L3e9
        L3e9:
            java.lang.String r0 = "socver"
            java.lang.String r0 = r15.optString(r0)     // Catch: java.lang.Exception -> L431
            r14.m(r0)     // Catch: java.lang.Exception -> L431
            java.lang.String r0 = "soc"
            org.json.JSONObject r0 = r15.optJSONObject(r0)     // Catch: java.lang.Exception -> L431
            if (r0 == 0) goto L431
            com.kuaishou.weapon.p0.z$h r1 = new com.kuaishou.weapon.p0.z$h     // Catch: java.lang.Exception -> L431
            r1.<init>()     // Catch: java.lang.Exception -> L431
            java.lang.String r2 = "socs"
            r3 = 0
            int r2 = r0.optInt(r2, r3)     // Catch: java.lang.Exception -> L431
            r1.d(r2)     // Catch: java.lang.Exception -> L431
            java.lang.String r2 = "socc"
            r3 = 2
            int r2 = r0.optInt(r2, r3)     // Catch: java.lang.Exception -> L431
            r1.b(r2)     // Catch: java.lang.Exception -> L431
            java.lang.String r2 = "soci"
            r3 = 12
            int r2 = r0.optInt(r2, r3)     // Catch: java.lang.Exception -> L431
            r1.c(r2)     // Catch: java.lang.Exception -> L431
            java.lang.String r2 = "snack"
            r3 = 0
            int r0 = r0.optInt(r2, r3)     // Catch: java.lang.Exception -> L431
            r1.a(r0)     // Catch: java.lang.Exception -> L431
            r14.a(r1)     // Catch: java.lang.Exception -> L431
        L431:
            java.lang.String r0 = "hver"
            java.lang.String r0 = r15.optString(r0)     // Catch: java.lang.Exception -> L485
            r14.h(r0)     // Catch: java.lang.Exception -> L485
            java.lang.String r0 = "h"
            org.json.JSONObject r0 = r15.optJSONObject(r0)     // Catch: java.lang.Exception -> L485
            if (r0 == 0) goto L485
            com.kuaishou.weapon.p0.z$e r1 = new com.kuaishou.weapon.p0.z$e     // Catch: java.lang.Exception -> L485
            r1.<init>()     // Catch: java.lang.Exception -> L485
            java.lang.String r2 = "hs"
            r3 = 1
            int r2 = r0.optInt(r2, r3)     // Catch: java.lang.Exception -> L485
            r1.d(r2)     // Catch: java.lang.Exception -> L485
            java.lang.String r2 = "hc"
            r3 = 2
            int r2 = r0.optInt(r2, r3)     // Catch: java.lang.Exception -> L485
            r1.a(r2)     // Catch: java.lang.Exception -> L485
            java.lang.String r2 = "hi"
            r3 = 12
            int r2 = r0.optInt(r2, r3)     // Catch: java.lang.Exception -> L485
            r1.b(r2)     // Catch: java.lang.Exception -> L485
            java.lang.String r2 = "hsdc"
            r3 = 1
            int r2 = r0.optInt(r2, r3)     // Catch: java.lang.Exception -> L485
            r1.e(r2)     // Catch: java.lang.Exception -> L485
            java.lang.String r2 = "hlbr"
            int r2 = r0.optInt(r2, r3)     // Catch: java.lang.Exception -> L485
            r1.c(r2)     // Catch: java.lang.Exception -> L485
            java.lang.String r2 = "pr"
            java.lang.String r0 = r0.optString(r2)     // Catch: java.lang.Exception -> L485
            r1.a(r0)     // Catch: java.lang.Exception -> L485
            r14.a(r1)     // Catch: java.lang.Exception -> L485
        L485:
            return r14
        L486:
            r0 = 0
            return r0
        L488:
            r17 = r0
            r18 = 65537(0x10001, float:9.1837E-41)
            com.baidu.titan.sdk.runtime.InterceptResult r0 = r17.invokeL(r18, r19, r20)
            if (r0 == 0) goto L4
            java.lang.Object r1 = r0.objValue
            com.kuaishou.weapon.p0.z r1 = (com.kuaishou.weapon.p0.z) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.x2.b(java.lang.String):com.kuaishou.weapon.p0.z");
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.optInt("result", 0) == 1) {
                    String a2 = new n1(this.a).a(jSONObject.getString("antispamPluginRsp"));
                    if (TextUtils.isEmpty(a2)) {
                        return;
                    }
                    z b = b(a2);
                    if (b != null) {
                        f3.a(this.a).a(str, b);
                    } else {
                        f3.a(this.a).a(System.currentTimeMillis());
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
                String str = v2.a + v2.d;
                String d = w2.d(this.a);
                if (!TextUtils.isEmpty(d)) {
                    str = str + "?" + d;
                }
                JSONObject jSONObject = new JSONObject();
                JSONObject b = w2.b(this.a);
                if (b != null) {
                    jSONObject.put("data", new n1(this.a).b(b.toString()));
                }
                m a2 = m.a(this.a);
                n nVar = new n(str, jSONObject);
                nVar.a(WeaponHI.cookieData);
                nVar.b(WeaponHI.encryENV);
                a2.b(nVar, new a(this));
            } catch (Exception unused) {
            }
        }
    }
}
