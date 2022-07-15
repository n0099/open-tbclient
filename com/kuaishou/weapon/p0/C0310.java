package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.SecureRandom;
import java.util.UUID;
/* renamed from: com.kuaishou.weapon.p0.ʻᴵ  reason: contains not printable characters */
/* loaded from: classes5.dex */
public class C0310 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: ʻ  reason: contains not printable characters */
    public static String f54;
    public transient /* synthetic */ FieldHolder $fh;

    public C0310() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public static String m204(int i) {
        InterceptResult invokeI;
        int nextInt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) {
            StringBuilder sb = new StringBuilder();
            if (i < 3) {
                i = 3;
            }
            SecureRandom secureRandom = new SecureRandom();
            for (int i2 = 0; i2 < i; i2++) {
                int nextInt2 = secureRandom.nextInt(3);
                if (nextInt2 != 0) {
                    if (nextInt2 == 1) {
                        nextInt = secureRandom.nextInt(25) + 65;
                    } else if (nextInt2 == 2) {
                        nextInt = secureRandom.nextInt(25) + 97;
                    }
                    sb.append((char) nextInt);
                } else {
                    sb.append(secureRandom.nextInt(10));
                }
            }
            return sb.toString();
        }
        return (String) invokeI.objValue;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:34:0x00a0
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    /* renamed from: ʻ  reason: contains not printable characters */
    public static synchronized java.lang.String m205(android.content.Context r6) {
        /*
            com.baidu.titan.sdk.runtime.Interceptable r0 = com.kuaishou.weapon.p0.C0310.$ic
            if (r0 != 0) goto La3
        L4:
            java.lang.Class<com.kuaishou.weapon.p0.ʻᴵ> r0 = com.kuaishou.weapon.p0.C0310.class
            monitor-enter(r0)
            java.lang.String r1 = com.kuaishou.weapon.p0.C0310.f54     // Catch: java.lang.Throwable -> L9c
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L9c
            if (r1 != 0) goto L13
            java.lang.String r6 = com.kuaishou.weapon.p0.C0310.f54     // Catch: java.lang.Throwable -> L9c
            monitor-exit(r0)
            return r6
        L13:
            com.kuaishou.weapon.p0.ʽי r1 = com.kuaishou.weapon.p0.C0374.m389(r6)     // Catch: java.lang.Throwable -> L9c
            java.lang.String r2 = "a1_p_s_p_s"
            boolean r2 = r1.m408(r2)     // Catch: java.lang.Throwable -> L9c
            java.lang.String r3 = "a1_p_s_p_s_c_b"
            boolean r1 = r1.m408(r3)     // Catch: java.lang.Throwable -> L9c
            com.kuaishou.weapon.p0.ʽי r3 = com.kuaishou.weapon.p0.C0374.m389(r6)     // Catch: java.lang.Throwable -> L9c
            java.lang.String r4 = com.kuaishou.weapon.p0.C0311.m207(r6, r3)     // Catch: java.lang.Throwable -> L9c
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Throwable -> L9c
            if (r5 != 0) goto L35
            com.kuaishou.weapon.p0.C0310.f54 = r4     // Catch: java.lang.Throwable -> L9c
            monitor-exit(r0)
            return r4
        L35:
            java.lang.String r4 = ""
            java.lang.String r5 = ""
            if (r2 != 0) goto L3d
            if (r1 == 0) goto L45
        L3d:
            java.lang.String r4 = com.kuaishou.weapon.p0.C0433.m894(r6)     // Catch: java.lang.Throwable -> L9c
            java.lang.String r5 = com.kuaishou.weapon.p0.C0433.m865(r6)     // Catch: java.lang.Throwable -> L9c
        L45:
            boolean r1 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Throwable -> L9c
            if (r1 != 0) goto L55
            java.lang.String r1 = "RISK"
            boolean r1 = r4.startsWith(r1)     // Catch: java.lang.Throwable -> L9c
            if (r1 != 0) goto L55
            r1 = r4
            goto L57
        L55:
            java.lang.String r1 = "0"
        L57:
            java.lang.String r2 = m206(r6, r4, r5)     // Catch: java.lang.Throwable -> L9c
            java.lang.StringBuffer r4 = new java.lang.StringBuffer     // Catch: java.lang.Throwable -> L9c
            r4.<init>(r1)     // Catch: java.lang.Throwable -> L9c
            java.lang.StringBuffer r1 = r4.reverse()     // Catch: java.lang.Throwable -> L9c
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L9c
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9c
            r4.<init>()     // Catch: java.lang.Throwable -> L9c
            java.lang.String r2 = r2.toUpperCase()     // Catch: java.lang.Throwable -> L9c
            r4.append(r2)     // Catch: java.lang.Throwable -> L9c
            java.lang.String r2 = "|"
            r4.append(r2)     // Catch: java.lang.Throwable -> L9c
            java.lang.String r1 = r1.toUpperCase()     // Catch: java.lang.Throwable -> L9c
            r4.append(r1)     // Catch: java.lang.Throwable -> L9c
            java.lang.String r1 = r4.toString()     // Catch: java.lang.Throwable -> L9c
            com.kuaishou.weapon.p0.ʻˆ r2 = new com.kuaishou.weapon.p0.ʻˆ     // Catch: java.lang.Throwable -> L9c
            r2.<init>(r6)     // Catch: java.lang.Throwable -> L9c
            java.lang.String r4 = "OTUzc3E1N0w5NTIzMW80OUQxMGo3R1dFa0ZiandHT0w="
            java.lang.String r1 = r2.m152(r1, r4)     // Catch: java.lang.Throwable -> L9c
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L9c
            if (r2 != 0) goto L9c
            com.kuaishou.weapon.p0.C0311.m208(r1, r6, r3)     // Catch: java.lang.Throwable -> L9c
            com.kuaishou.weapon.p0.C0310.f54 = r1     // Catch: java.lang.Throwable -> L9c
            monitor-exit(r0)
            return r1
        L9c:
            java.lang.String r6 = ""
            monitor-exit(r0)
            return r6
        La0:
            r6 = move-exception
            monitor-exit(r0)
            throw r6
        La3:
            r3 = r0
            r4 = 65538(0x10002, float:9.1838E-41)
            r5 = 0
            com.baidu.titan.sdk.runtime.InterceptResult r0 = r3.invokeL(r4, r5, r6)
            if (r0 == 0) goto L4
            java.lang.Object r1 = r0.objValue
            java.lang.String r1 = (java.lang.String) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.C0310.m205(android.content.Context):java.lang.String");
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public static String m206(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, context, str, str2)) == null) {
            try {
                String uuid = UUID.randomUUID().toString();
                String packageName = context != null ? context.getPackageName() : "";
                String m174 = C0304.m174(str + str2 + packageName + uuid);
                return TextUtils.isEmpty(m174) ? "" : m174;
            } catch (Throwable unused) {
                return "";
            }
        }
        return (String) invokeLLL.objValue;
    }
}
