package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* renamed from: com.kuaishou.weapon.p0.ʽʿ  reason: contains not printable characters */
/* loaded from: classes5.dex */
public class RunnableC0356 implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: ʻ  reason: contains not printable characters */
    public Context f185;

    /* renamed from: com.kuaishou.weapon.p0.ʽʿ$ʻ  reason: contains not printable characters */
    /* loaded from: classes5.dex */
    public class C0357 implements InterfaceC0353 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: ʻ  reason: contains not printable characters */
        public final /* synthetic */ RunnableC0356 f186;

        public C0357(RunnableC0356 runnableC0356) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {runnableC0356};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f186 = runnableC0356;
        }

        @Override // com.kuaishou.weapon.p0.InterfaceC0353
        /* renamed from: ʻ */
        public void mo239(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            }
        }

        @Override // com.kuaishou.weapon.p0.InterfaceC0353
        /* renamed from: ʼ */
        public void mo240(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                try {
                    this.f186.m365(str);
                } catch (Exception unused) {
                }
            }
        }
    }

    public RunnableC0356(Context context) {
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
        this.f185 = context;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:67:0x00f4
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    /* renamed from: ʼ  reason: contains not printable characters */
    private com.kuaishou.weapon.p0.C0412 m364(java.lang.String r20) {
        /*
            r19 = this;
            com.baidu.titan.sdk.runtime.Interceptable r0 = com.kuaishou.weapon.p0.RunnableC0356.$ic
            if (r0 != 0) goto L47a
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
            com.kuaishou.weapon.p0.ˏ r14 = new com.kuaishou.weapon.p0.ˏ     // Catch: java.lang.Exception -> L478
            r14.<init>()     // Catch: java.lang.Exception -> L478
            org.json.JSONObject r15 = new org.json.JSONObject     // Catch: java.lang.Exception -> L478
            r13 = r20
            r15.<init>(r13)     // Catch: java.lang.Exception -> L478
            java.lang.String r13 = "status"
            r16 = r7
            r7 = 1
            int r13 = r15.optInt(r13, r7)     // Catch: java.lang.Exception -> L478
            r14.m618(r13)     // Catch: java.lang.Exception -> L478
            int r13 = r14.m598()     // Catch: java.lang.Exception -> L478
            if (r13 == r7) goto L3e
            r13 = 0
            return r13
        L3e:
            java.lang.String r13 = "bwc"
            r7 = 3
            int r13 = r15.optInt(r13, r7)     // Catch: java.lang.Exception -> L478
            r14.m606(r13)     // Catch: java.lang.Exception -> L478
            java.lang.String r13 = "blpc"
            int r13 = r15.optInt(r13, r7)     // Catch: java.lang.Exception -> L478
            r14.m603(r13)     // Catch: java.lang.Exception -> L478
            java.lang.String r13 = "scc"
            r7 = 0
            int r13 = r15.optInt(r13, r7)     // Catch: java.lang.Exception -> L478
            r14.m615(r13)     // Catch: java.lang.Exception -> L478
            java.lang.String r13 = "dpver"
            java.lang.String r13 = r15.optString(r13)     // Catch: java.lang.Exception -> L478
            r14.m613(r13)     // Catch: java.lang.Exception -> L478
            java.lang.String r13 = "bver"
            java.lang.String r13 = r15.optString(r13)     // Catch: java.lang.Exception -> L478
            r14.m604(r13)     // Catch: java.lang.Exception -> L478
            java.lang.String r13 = "dpd"
            r7 = 12
            int r13 = r15.optInt(r13, r7)     // Catch: java.lang.Exception -> L478
            r14.m609(r13)     // Catch: java.lang.Exception -> L478
            java.lang.String r13 = "aar"
            r7 = 30
            int r7 = r15.optInt(r13, r7)     // Catch: java.lang.Exception -> L478
            r14.m588(r7)     // Catch: java.lang.Exception -> L478
            java.lang.String r7 = "dir"
            java.lang.String r7 = r15.optString(r7)     // Catch: java.lang.Exception -> L478
            r14.m610(r7)     // Catch: java.lang.Exception -> L478
            java.lang.String r7 = r15.optString(r12)     // Catch: java.lang.Exception -> L478
            r14.m621(r7)     // Catch: java.lang.Exception -> L478
            java.lang.String r7 = "ii"
            int r7 = r15.optInt(r7)     // Catch: java.lang.Exception -> L478
            r14.m612(r7)     // Catch: java.lang.Exception -> L478
            java.lang.String r7 = "act"
            r13 = 0
            int r7 = r15.optInt(r7, r13)     // Catch: java.lang.Exception -> L478
            r14.m600(r7)     // Catch: java.lang.Exception -> L478
            java.lang.String r13 = "aver"
            java.lang.String r13 = r15.optString(r13)     // Catch: java.lang.Exception -> Lf2
            r14.m601(r13)     // Catch: java.lang.Exception -> Lf2
            org.json.JSONObject r13 = r15.getJSONObject(r10)     // Catch: java.lang.Exception -> Lf2
            if (r13 == 0) goto Lf2
            com.kuaishou.weapon.p0.ˏ$ʻ r7 = new com.kuaishou.weapon.p0.ˏ$ʻ     // Catch: java.lang.Exception -> Lf2
            r7.<init>()     // Catch: java.lang.Exception -> Lf2
            r17 = r1
            java.lang.String r1 = "as"
            r18 = r3
            r3 = 0
            int r1 = r13.optInt(r1, r3)     // Catch: java.lang.Exception -> Lf6
            r7.m654(r1)     // Catch: java.lang.Exception -> Lf6
            r1 = 3
            int r3 = r13.optInt(r9, r1)     // Catch: java.lang.Exception -> Lf6
            r7.m648(r3)     // Catch: java.lang.Exception -> Lf6
            java.lang.String r1 = "ai"
            r3 = 8
            int r1 = r13.optInt(r1, r3)     // Catch: java.lang.Exception -> Lf6
            r7.m650(r1)     // Catch: java.lang.Exception -> Lf6
            java.lang.String r1 = "ab"
            r3 = 0
            int r1 = r13.optInt(r1, r3)     // Catch: java.lang.Exception -> Lf6
            r7.m646(r1)     // Catch: java.lang.Exception -> Lf6
            java.lang.String r1 = "am"
            int r1 = r13.optInt(r1, r3)     // Catch: java.lang.Exception -> Lf6
            r7.m652(r1)     // Catch: java.lang.Exception -> Lf6
            r14.m589(r7)     // Catch: java.lang.Exception -> Lf6
            goto Lf6
        Lf2:
            r17 = r1
        Lf4:
            r18 = r3
        Lf6:
            java.lang.String r1 = "acver"
            java.lang.String r1 = r15.optString(r1)     // Catch: java.lang.Exception -> L12c
            r14.m597(r1)     // Catch: java.lang.Exception -> L12c
            org.json.JSONObject r1 = r15.getJSONObject(r9)     // Catch: java.lang.Exception -> L12c
            if (r1 == 0) goto L12c
            com.kuaishou.weapon.p0.ˏ$ʼ r3 = new com.kuaishou.weapon.p0.ˏ$ʼ     // Catch: java.lang.Exception -> L12c
            r3.<init>()     // Catch: java.lang.Exception -> L12c
            java.lang.String r7 = "acs"
            r9 = 1
            int r7 = r1.optInt(r7, r9)     // Catch: java.lang.Exception -> L12c
            r3.m660(r7)     // Catch: java.lang.Exception -> L12c
            java.lang.String r7 = "acc"
            r9 = 3
            int r7 = r1.optInt(r7, r9)     // Catch: java.lang.Exception -> L12c
            r3.m656(r7)     // Catch: java.lang.Exception -> L12c
            java.lang.String r7 = "aci"
            r9 = 8
            int r1 = r1.optInt(r7, r9)     // Catch: java.lang.Exception -> L12c
            r3.m658(r1)     // Catch: java.lang.Exception -> L12c
            r14.m590(r3)     // Catch: java.lang.Exception -> L12c
        L12c:
            java.lang.String r1 = "rver"
            java.lang.String r1 = r15.optString(r1)     // Catch: java.lang.Exception -> L203
            r14.m627(r1)     // Catch: java.lang.Exception -> L203
            com.kuaishou.weapon.p0.ˏ$ˈ r1 = new com.kuaishou.weapon.p0.ˏ$ˈ     // Catch: java.lang.Exception -> L203
            r1.<init>()     // Catch: java.lang.Exception -> L203
            org.json.JSONObject r3 = r15.getJSONObject(r8)     // Catch: java.lang.Exception -> L203
            if (r3 == 0) goto L203
            java.lang.String r7 = "rs"
            r9 = 1
            int r7 = r3.optInt(r7, r9)     // Catch: java.lang.Exception -> L203
            r1.m771(r7)     // Catch: java.lang.Exception -> L203
            java.lang.String r7 = "rc"
            r9 = 6
            int r7 = r3.optInt(r7, r9)     // Catch: java.lang.Exception -> L203
            r1.m765(r7)     // Catch: java.lang.Exception -> L203
            java.lang.String r7 = "ri"
            r9 = 4
            int r7 = r3.optInt(r7, r9)     // Catch: java.lang.Exception -> L203
            r1.m767(r7)     // Catch: java.lang.Exception -> L203
            java.lang.String r7 = "ro"
            r9 = 5
            int r7 = r3.optInt(r7, r9)     // Catch: java.lang.Exception -> L203
            r1.m769(r7)     // Catch: java.lang.Exception -> L203
            java.lang.String r7 = "rb"
            r9 = 0
            int r7 = r3.optInt(r7, r9)     // Catch: java.lang.Exception -> L203
            r1.m762(r7)     // Catch: java.lang.Exception -> L203
            java.lang.String r7 = "rcl"
            org.json.JSONObject r3 = r3.getJSONObject(r7)     // Catch: java.lang.Exception -> L203
            com.kuaishou.weapon.p0.ˏ$ˈ$ʻ r7 = new com.kuaishou.weapon.p0.ˏ$ˈ$ʻ     // Catch: java.lang.Exception -> L203
            r7.<init>()     // Catch: java.lang.Exception -> L203
            java.lang.String r9 = "da"
            r13 = 1
            int r9 = r3.optInt(r9, r13)     // Catch: java.lang.Exception -> L203
            r7.m774(r9)     // Catch: java.lang.Exception -> L203
            java.lang.String r9 = "em"
            int r9 = r3.optInt(r9, r13)     // Catch: java.lang.Exception -> L203
            r7.m778(r9)     // Catch: java.lang.Exception -> L203
            java.lang.String r9 = "li"
            int r9 = r3.optInt(r9, r13)     // Catch: java.lang.Exception -> L203
            r7.m784(r9)     // Catch: java.lang.Exception -> L203
            java.lang.String r9 = "rcd"
            int r9 = r3.optInt(r9, r13)     // Catch: java.lang.Exception -> L203
            r7.m788(r9)     // Catch: java.lang.Exception -> L203
            java.lang.String r9 = "dv"
            int r9 = r3.optInt(r9, r13)     // Catch: java.lang.Exception -> L203
            r7.m776(r9)     // Catch: java.lang.Exception -> L203
            java.lang.String r9 = "re"
            int r9 = r3.optInt(r9, r13)     // Catch: java.lang.Exception -> L203
            r7.m790(r9)     // Catch: java.lang.Exception -> L203
            java.lang.String r9 = "fr"
            int r9 = r3.optInt(r9, r13)     // Catch: java.lang.Exception -> L203
            r7.m780(r9)     // Catch: java.lang.Exception -> L203
            java.lang.String r9 = "hk"
            r13 = 0
            int r9 = r3.optInt(r9, r13)     // Catch: java.lang.Exception -> L203
            r7.m782(r9)     // Catch: java.lang.Exception -> L203
            java.lang.String r9 = "vp"
            int r9 = r3.optInt(r9, r13)     // Catch: java.lang.Exception -> L203
            r7.m798(r9)     // Catch: java.lang.Exception -> L203
            int r9 = r3.optInt(r11, r13)     // Catch: java.lang.Exception -> L203
            r7.m786(r9)     // Catch: java.lang.Exception -> L203
            java.lang.String r9 = "sc"
            r13 = 1
            int r9 = r3.optInt(r9, r13)     // Catch: java.lang.Exception -> L203
            r7.m792(r9)     // Catch: java.lang.Exception -> L203
            java.lang.String r9 = "ud"
            int r9 = r3.optInt(r9, r13)     // Catch: java.lang.Exception -> L203
            r7.m794(r9)     // Catch: java.lang.Exception -> L203
            java.lang.String r9 = "xp"
            int r9 = r3.optInt(r9, r13)     // Catch: java.lang.Exception -> L203
            r7.m800(r9)     // Catch: java.lang.Exception -> L203
            java.lang.String r9 = "vl"
            r13 = 0
            int r3 = r3.optInt(r9, r13)     // Catch: java.lang.Exception -> L203
            r7.m796(r3)     // Catch: java.lang.Exception -> L203
            r1.m763(r7)     // Catch: java.lang.Exception -> L203
            r14.m595(r1)     // Catch: java.lang.Exception -> L203
        L203:
            r1 = 2
            com.kuaishou.weapon.p0.ˏ$ʽ r3 = new com.kuaishou.weapon.p0.ˏ$ʽ     // Catch: java.lang.Exception -> L2dc
            r3.<init>()     // Catch: java.lang.Exception -> L2dc
            java.lang.String r7 = "b"
            org.json.JSONObject r7 = r15.getJSONObject(r7)     // Catch: java.lang.Exception -> L2dc
            java.lang.String r9 = "bc"
            int r9 = r7.optInt(r9, r1)     // Catch: java.lang.Exception -> L2dc
            r3.m662(r9)     // Catch: java.lang.Exception -> L2dc
            java.lang.String r9 = "bi"
            r13 = 12
            int r9 = r7.optInt(r9, r13)     // Catch: java.lang.Exception -> L2dc
            r3.m665(r9)     // Catch: java.lang.Exception -> L2dc
            java.lang.String r9 = "bs"
            r13 = 1
            int r9 = r7.optInt(r9, r13)     // Catch: java.lang.Exception -> L2dc
            r3.m667(r9)     // Catch: java.lang.Exception -> L2dc
            java.lang.String r9 = "bcl"
            org.json.JSONObject r7 = r7.getJSONObject(r9)     // Catch: java.lang.Exception -> L2dc
            com.kuaishou.weapon.p0.ˏ$ʽ$ʻ r9 = new com.kuaishou.weapon.p0.ˏ$ʽ$ʻ     // Catch: java.lang.Exception -> L2dc
            r9.<init>()     // Catch: java.lang.Exception -> L2dc
            r13 = 1
            int r10 = r7.optInt(r10, r13)     // Catch: java.lang.Exception -> L2dc
            r9.m670(r10)     // Catch: java.lang.Exception -> L2dc
            int r8 = r7.optInt(r8, r13)     // Catch: java.lang.Exception -> L2dc
            r9.m694(r8)     // Catch: java.lang.Exception -> L2dc
            int r8 = r7.optInt(r6, r13)     // Catch: java.lang.Exception -> L2dc
            r9.m674(r8)     // Catch: java.lang.Exception -> L2dc
            java.lang.String r8 = "s"
            int r8 = r7.optInt(r8, r13)     // Catch: java.lang.Exception -> L2dc
            r9.m698(r8)     // Catch: java.lang.Exception -> L2dc
            int r8 = r7.optInt(r5, r13)     // Catch: java.lang.Exception -> L2dc
            r9.m676(r8)     // Catch: java.lang.Exception -> L2dc
            java.lang.String r8 = "u"
            int r8 = r7.optInt(r8, r13)     // Catch: java.lang.Exception -> L2dc
            r9.m702(r8)     // Catch: java.lang.Exception -> L2dc
            r8 = 0
            int r10 = r7.optInt(r4, r8)     // Catch: java.lang.Exception -> L2dc
            r9.m704(r10)     // Catch: java.lang.Exception -> L2dc
            int r10 = r7.optInt(r2, r8)     // Catch: java.lang.Exception -> L2dc
            r9.m690(r10)     // Catch: java.lang.Exception -> L2dc
            r8 = 1
            int r10 = r7.optInt(r0, r8)     // Catch: java.lang.Exception -> L2dc
            r9.m680(r10)     // Catch: java.lang.Exception -> L2dc
            int r10 = r7.optInt(r12, r8)     // Catch: java.lang.Exception -> L2dc
            r9.m684(r10)     // Catch: java.lang.Exception -> L2dc
            r10 = r18
            int r13 = r7.optInt(r10, r8)     // Catch: java.lang.Exception -> L2d7
            r9.m678(r13)     // Catch: java.lang.Exception -> L2d7
            r13 = r17
            int r1 = r7.optInt(r13, r8)     // Catch: java.lang.Exception -> L2d4
            r9.m672(r1)     // Catch: java.lang.Exception -> L2d4
            int r1 = r7.optInt(r11, r8)     // Catch: java.lang.Exception -> L2d4
            r9.m688(r1)     // Catch: java.lang.Exception -> L2d4
            java.lang.String r1 = "rp"
            int r1 = r7.optInt(r1, r8)     // Catch: java.lang.Exception -> L2d4
            r9.m696(r1)     // Catch: java.lang.Exception -> L2d4
            java.lang.String r1 = "tc"
            int r1 = r7.optInt(r1, r8)     // Catch: java.lang.Exception -> L2d4
            r9.m700(r1)     // Catch: java.lang.Exception -> L2d4
            java.lang.String r1 = "il"
            int r1 = r7.optInt(r1, r8)     // Catch: java.lang.Exception -> L2d4
            r9.m682(r1)     // Catch: java.lang.Exception -> L2d4
            r1 = r16
            r16 = r2
            int r2 = r7.optInt(r1, r8)     // Catch: java.lang.Exception -> L2e4
            r9.m692(r2)     // Catch: java.lang.Exception -> L2e4
            java.lang.String r2 = "l"
            int r2 = r7.optInt(r2, r8)     // Catch: java.lang.Exception -> L2e4
            r9.m686(r2)     // Catch: java.lang.Exception -> L2e4
            r3.m663(r9)     // Catch: java.lang.Exception -> L2e4
            r14.m591(r3)     // Catch: java.lang.Exception -> L2e4
            goto L2e4
        L2d4:
            r1 = r16
            goto L2e2
        L2d7:
            r1 = r16
            r13 = r17
            goto L2e2
        L2dc:
            r1 = r16
            r13 = r17
            r10 = r18
        L2e2:
            r16 = r2
        L2e4:
            java.lang.String r2 = "cver"
            java.lang.String r2 = r15.optString(r2)     // Catch: java.lang.Exception -> L36d
            r14.m607(r2)     // Catch: java.lang.Exception -> L36d
            com.kuaishou.weapon.p0.ˏ$ʾ r2 = new com.kuaishou.weapon.p0.ˏ$ʾ     // Catch: java.lang.Exception -> L36d
            r2.<init>()     // Catch: java.lang.Exception -> L36d
            org.json.JSONObject r3 = r15.getJSONObject(r6)     // Catch: java.lang.Exception -> L36d
            java.lang.String r6 = "cc"
            r7 = 2
            int r6 = r3.optInt(r6, r7)     // Catch: java.lang.Exception -> L36d
            r2.m709(r6)     // Catch: java.lang.Exception -> L36d
            java.lang.String r6 = "ci"
            r7 = 12
            int r6 = r3.optInt(r6, r7)     // Catch: java.lang.Exception -> L36d
            r2.m711(r6)     // Catch: java.lang.Exception -> L36d
            java.lang.String r6 = "cs"
            r7 = 1
            int r6 = r3.optInt(r6, r7)     // Catch: java.lang.Exception -> L36d
            r2.m713(r6)     // Catch: java.lang.Exception -> L36d
            java.lang.String r6 = "cb"
            r7 = 0
            int r6 = r3.optInt(r6, r7)     // Catch: java.lang.Exception -> L36d
            r2.m706(r6)     // Catch: java.lang.Exception -> L36d
            java.lang.String r6 = "ccl"
            org.json.JSONObject r3 = r3.getJSONObject(r6)     // Catch: java.lang.Exception -> L36d
            com.kuaishou.weapon.p0.ˏ$ʾ$ʻ r6 = new com.kuaishou.weapon.p0.ˏ$ʾ$ʻ     // Catch: java.lang.Exception -> L36d
            r6.<init>()     // Catch: java.lang.Exception -> L36d
            r7 = 1
            int r5 = r3.optInt(r5, r7)     // Catch: java.lang.Exception -> L36d
            r6.m718(r5)     // Catch: java.lang.Exception -> L36d
            int r5 = r3.optInt(r11, r7)     // Catch: java.lang.Exception -> L36d
            r6.m726(r5)     // Catch: java.lang.Exception -> L36d
            r5 = 0
            int r4 = r3.optInt(r4, r5)     // Catch: java.lang.Exception -> L36d
            r6.m730(r4)     // Catch: java.lang.Exception -> L36d
            int r4 = r3.optInt(r12, r7)     // Catch: java.lang.Exception -> L36d
            r6.m724(r4)     // Catch: java.lang.Exception -> L36d
            int r4 = r3.optInt(r10, r7)     // Catch: java.lang.Exception -> L36d
            r6.m720(r4)     // Catch: java.lang.Exception -> L36d
            int r4 = r3.optInt(r13, r7)     // Catch: java.lang.Exception -> L36d
            r6.m716(r4)     // Catch: java.lang.Exception -> L36d
            int r0 = r3.optInt(r0, r7)     // Catch: java.lang.Exception -> L36d
            r6.m722(r0)     // Catch: java.lang.Exception -> L36d
            r0 = r16
            r4 = 0
            int r0 = r3.optInt(r0, r4)     // Catch: java.lang.Exception -> L36d
            r6.m728(r0)     // Catch: java.lang.Exception -> L36d
            r2.m707(r6)     // Catch: java.lang.Exception -> L36d
            r14.m592(r2)     // Catch: java.lang.Exception -> L36d
        L36d:
            java.lang.String r0 = "pgver"
            java.lang.String r0 = r15.optString(r0)     // Catch: java.lang.Exception -> L3e1
            r14.m625(r0)     // Catch: java.lang.Exception -> L3e1
            org.json.JSONObject r0 = r15.optJSONObject(r1)     // Catch: java.lang.Exception -> L3e1
            if (r0 == 0) goto L3e1
            com.kuaishou.weapon.p0.ˏ$ˆ r1 = new com.kuaishou.weapon.p0.ˏ$ˆ     // Catch: java.lang.Exception -> L3e1
            r1.<init>()     // Catch: java.lang.Exception -> L3e1
            java.lang.String r2 = "ps"
            r3 = 1
            int r2 = r0.optInt(r2, r3)     // Catch: java.lang.Exception -> L3e1
            r1.m749(r2)     // Catch: java.lang.Exception -> L3e1
            java.lang.String r2 = "pc"
            r3 = 2
            int r2 = r0.optInt(r2, r3)     // Catch: java.lang.Exception -> L3e1
            r1.m744(r2)     // Catch: java.lang.Exception -> L3e1
            java.lang.String r2 = "pi"
            r3 = 12
            int r2 = r0.optInt(r2, r3)     // Catch: java.lang.Exception -> L3e1
            r1.m747(r2)     // Catch: java.lang.Exception -> L3e1
            java.lang.String r2 = "pcl"
            org.json.JSONObject r0 = r0.optJSONObject(r2)     // Catch: java.lang.Exception -> L3e1
            if (r0 == 0) goto L3de
            com.kuaishou.weapon.p0.ˏ$ˆ$ʻ r2 = new com.kuaishou.weapon.p0.ˏ$ˆ$ʻ     // Catch: java.lang.Exception -> L3e1
            r2.<init>()     // Catch: java.lang.Exception -> L3e1
            java.lang.String r3 = "cp"
            r4 = 1
            int r3 = r0.optInt(r3, r4)     // Catch: java.lang.Exception -> L3e1
            r2.m752(r3)     // Catch: java.lang.Exception -> L3e1
            java.lang.String r3 = "gc"
            int r3 = r0.optInt(r3, r4)     // Catch: java.lang.Exception -> L3e1
            r2.m754(r3)     // Catch: java.lang.Exception -> L3e1
            java.lang.String r3 = "pke"
            int r3 = r0.optInt(r3, r4)     // Catch: java.lang.Exception -> L3e1
            r2.m760(r3)     // Catch: java.lang.Exception -> L3e1
            java.lang.String r3 = "pds"
            int r3 = r0.optInt(r3, r4)     // Catch: java.lang.Exception -> L3e1
            r2.m758(r3)     // Catch: java.lang.Exception -> L3e1
            java.lang.String r3 = "pam"
            int r0 = r0.optInt(r3, r4)     // Catch: java.lang.Exception -> L3e1
            r2.m756(r0)     // Catch: java.lang.Exception -> L3e1
            r1.m745(r2)     // Catch: java.lang.Exception -> L3e1
        L3de:
            r14.m594(r1)     // Catch: java.lang.Exception -> L3e1
        L3e1:
            java.lang.String r0 = "socver"
            java.lang.String r0 = r15.optString(r0)     // Catch: java.lang.Exception -> L423
            r14.m629(r0)     // Catch: java.lang.Exception -> L423
            java.lang.String r0 = "soc"
            org.json.JSONObject r0 = r15.optJSONObject(r0)     // Catch: java.lang.Exception -> L423
            if (r0 == 0) goto L423
            com.kuaishou.weapon.p0.ˏ$ˉ r1 = new com.kuaishou.weapon.p0.ˏ$ˉ     // Catch: java.lang.Exception -> L423
            r1.<init>()     // Catch: java.lang.Exception -> L423
            java.lang.String r2 = "socs"
            r3 = 0
            int r2 = r0.optInt(r2, r3)     // Catch: java.lang.Exception -> L423
            r1.m808(r2)     // Catch: java.lang.Exception -> L423
            java.lang.String r2 = "socc"
            r3 = 2
            int r2 = r0.optInt(r2, r3)     // Catch: java.lang.Exception -> L423
            r1.m804(r2)     // Catch: java.lang.Exception -> L423
            java.lang.String r2 = "soci"
            r3 = 12
            int r2 = r0.optInt(r2, r3)     // Catch: java.lang.Exception -> L423
            r1.m806(r2)     // Catch: java.lang.Exception -> L423
            java.lang.String r2 = "snack"
            r3 = 0
            int r0 = r0.optInt(r2, r3)     // Catch: java.lang.Exception -> L423
            r1.m802(r0)     // Catch: java.lang.Exception -> L423
            r14.m596(r1)     // Catch: java.lang.Exception -> L423
        L423:
            java.lang.String r0 = "hver"
            java.lang.String r0 = r15.optString(r0)     // Catch: java.lang.Exception -> L477
            r14.m619(r0)     // Catch: java.lang.Exception -> L477
            java.lang.String r0 = "h"
            org.json.JSONObject r0 = r15.optJSONObject(r0)     // Catch: java.lang.Exception -> L477
            if (r0 == 0) goto L477
            com.kuaishou.weapon.p0.ˏ$ʿ r1 = new com.kuaishou.weapon.p0.ˏ$ʿ     // Catch: java.lang.Exception -> L477
            r1.<init>()     // Catch: java.lang.Exception -> L477
            java.lang.String r2 = "hs"
            r3 = 1
            int r2 = r0.optInt(r2, r3)     // Catch: java.lang.Exception -> L477
            r1.m739(r2)     // Catch: java.lang.Exception -> L477
            java.lang.String r2 = "hc"
            r3 = 2
            int r2 = r0.optInt(r2, r3)     // Catch: java.lang.Exception -> L477
            r1.m732(r2)     // Catch: java.lang.Exception -> L477
            java.lang.String r2 = "hi"
            r3 = 12
            int r2 = r0.optInt(r2, r3)     // Catch: java.lang.Exception -> L477
            r1.m735(r2)     // Catch: java.lang.Exception -> L477
            java.lang.String r2 = "hsdc"
            r3 = 1
            int r2 = r0.optInt(r2, r3)     // Catch: java.lang.Exception -> L477
            r1.m741(r2)     // Catch: java.lang.Exception -> L477
            java.lang.String r2 = "hlbr"
            int r2 = r0.optInt(r2, r3)     // Catch: java.lang.Exception -> L477
            r1.m737(r2)     // Catch: java.lang.Exception -> L477
            java.lang.String r2 = "pr"
            java.lang.String r0 = r0.optString(r2)     // Catch: java.lang.Exception -> L477
            r1.m733(r0)     // Catch: java.lang.Exception -> L477
            r14.m593(r1)     // Catch: java.lang.Exception -> L477
        L477:
            return r14
        L478:
            r0 = 0
            return r0
        L47a:
            r17 = r0
            r18 = 65537(0x10001, float:9.1837E-41)
            com.baidu.titan.sdk.runtime.InterceptResult r0 = r17.invokeL(r18, r19, r20)
            if (r0 == 0) goto L4
            java.lang.Object r1 = r0.objValue
            com.kuaishou.weapon.p0.ˏ r1 = (com.kuaishou.weapon.p0.C0412) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.RunnableC0356.m364(java.lang.String):com.kuaishou.weapon.p0.ˏ");
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                String str = C0345.f141 + C0345.f144;
                String m363 = C0355.m363(this.f185);
                if (!TextUtils.isEmpty(m363)) {
                    str = str + "?" + m363;
                }
                JSONObject jSONObject = new JSONObject();
                JSONObject m361 = C0355.m361(this.f185);
                if (m361 != null) {
                    jSONObject.put("data", new C0297(this.f185).m150(m361.toString()));
                }
                C0346.m302().mo312(new C0348(str, jSONObject), new C0357(this));
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public void m365(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.optInt("result", 0) == 1) {
                    String m148 = new C0297(this.f185).m148(jSONObject.getString("antispamPluginRsp"));
                    if (TextUtils.isEmpty(m148)) {
                        return;
                    }
                    C0412 m364 = m364(m148);
                    C0374 m389 = C0374.m389(this.f185);
                    if (m364 != null) {
                        m389.m400(str, m364);
                    } else {
                        m389.m397(System.currentTimeMillis());
                    }
                }
            } catch (Exception unused) {
            }
        }
    }
}
