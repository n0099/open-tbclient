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
/* loaded from: classes10.dex */
public class t1 {
    public static /* synthetic */ Interceptable $ic;
    public static String a;
    public transient /* synthetic */ FieldHolder $fh;

    public t1() {
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

    public static String a(int i) {
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
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:34:0x00a6
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public static synchronized java.lang.String a(android.content.Context r5) {
        /*
            com.baidu.titan.sdk.runtime.Interceptable r0 = com.kuaishou.weapon.p0.t1.$ic
            if (r0 != 0) goto La9
        L4:
            java.lang.Class<com.kuaishou.weapon.p0.t1> r0 = com.kuaishou.weapon.p0.t1.class
            monitor-enter(r0)
            java.lang.String r1 = com.kuaishou.weapon.p0.t1.a     // Catch: java.lang.Throwable -> La2
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> La2
            if (r1 != 0) goto L13
            java.lang.String r5 = com.kuaishou.weapon.p0.t1.a     // Catch: java.lang.Throwable -> La2
            monitor-exit(r0)
            return r5
        L13:
            java.lang.String r1 = "re_po_rt"
            com.kuaishou.weapon.p0.i r1 = com.kuaishou.weapon.p0.i.a(r5, r1)     // Catch: java.lang.Throwable -> La2
            java.lang.String r2 = "a1_p_s_p_s"
            boolean r2 = r1.b(r2)     // Catch: java.lang.Throwable -> La2
            java.lang.String r3 = "a1_p_s_p_s_c_b"
            boolean r1 = r1.b(r3)     // Catch: java.lang.Throwable -> La2
            com.kuaishou.weapon.p0.f3 r3 = com.kuaishou.weapon.p0.f3.a(r5)     // Catch: java.lang.Throwable -> La2
            java.lang.String r3 = com.kuaishou.weapon.p0.u1.a(r5, r3)     // Catch: java.lang.Throwable -> La2
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Throwable -> La2
            if (r4 != 0) goto L37
            com.kuaishou.weapon.p0.t1.a = r3     // Catch: java.lang.Throwable -> La2
            monitor-exit(r0)
            return r3
        L37:
            java.lang.String r3 = ""
            java.lang.String r4 = ""
            if (r2 != 0) goto L3f
            if (r1 == 0) goto L47
        L3f:
            java.lang.String r3 = com.kuaishou.weapon.p0.h1.p(r5)     // Catch: java.lang.Throwable -> La2
            java.lang.String r4 = com.kuaishou.weapon.p0.h1.c(r5)     // Catch: java.lang.Throwable -> La2
        L47:
            boolean r1 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Throwable -> La2
            if (r1 != 0) goto L57
            java.lang.String r1 = "RISK"
            boolean r1 = r3.startsWith(r1)     // Catch: java.lang.Throwable -> La2
            if (r1 != 0) goto L57
            r1 = r3
            goto L59
        L57:
            java.lang.String r1 = "0"
        L59:
            java.lang.String r2 = a(r5, r3, r4)     // Catch: java.lang.Throwable -> La2
            java.lang.StringBuffer r3 = new java.lang.StringBuffer     // Catch: java.lang.Throwable -> La2
            r3.<init>(r1)     // Catch: java.lang.Throwable -> La2
            java.lang.StringBuffer r1 = r3.reverse()     // Catch: java.lang.Throwable -> La2
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> La2
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La2
            r3.<init>()     // Catch: java.lang.Throwable -> La2
            java.lang.String r2 = r2.toUpperCase()     // Catch: java.lang.Throwable -> La2
            r3.append(r2)     // Catch: java.lang.Throwable -> La2
            java.lang.String r2 = "|"
            r3.append(r2)     // Catch: java.lang.Throwable -> La2
            java.lang.String r1 = r1.toUpperCase()     // Catch: java.lang.Throwable -> La2
            r3.append(r1)     // Catch: java.lang.Throwable -> La2
            java.lang.String r1 = r3.toString()     // Catch: java.lang.Throwable -> La2
            com.kuaishou.weapon.p0.n1 r2 = new com.kuaishou.weapon.p0.n1     // Catch: java.lang.Throwable -> La2
            r2.<init>(r5)     // Catch: java.lang.Throwable -> La2
            java.lang.String r3 = "OTUzc3E1N0w5NTIzMW80OUQxMGo3R1dFa0ZiandHT0w="
            java.lang.String r1 = r2.c(r1, r3)     // Catch: java.lang.Throwable -> La2
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> La2
            if (r2 != 0) goto La2
            com.kuaishou.weapon.p0.f3 r2 = com.kuaishou.weapon.p0.f3.a(r5)     // Catch: java.lang.Throwable -> La2
            com.kuaishou.weapon.p0.u1.a(r1, r5, r2)     // Catch: java.lang.Throwable -> La2
            com.kuaishou.weapon.p0.t1.a = r1     // Catch: java.lang.Throwable -> La2
            monitor-exit(r0)
            return r1
        La2:
            java.lang.String r5 = ""
            monitor-exit(r0)
            return r5
        La6:
            r5 = move-exception
            monitor-exit(r0)
            throw r5
        La9:
            r2 = r0
            r3 = 65538(0x10002, float:9.1838E-41)
            r4 = 0
            com.baidu.titan.sdk.runtime.InterceptResult r0 = r2.invokeL(r3, r4, r5)
            if (r0 == 0) goto L4
            java.lang.Object r1 = r0.objValue
            java.lang.String r1 = (java.lang.String) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.t1.a(android.content.Context):java.lang.String");
    }

    public static String a(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, context, str, str2)) == null) {
            try {
                String uuid = UUID.randomUUID().toString();
                String packageName = context != null ? context.getPackageName() : "";
                String a2 = g.a(str + str2 + packageName + uuid);
                return TextUtils.isEmpty(a2) ? "" : a2;
            } catch (Throwable unused) {
                return "";
            }
        }
        return (String) invokeLLL.objValue;
    }
}
