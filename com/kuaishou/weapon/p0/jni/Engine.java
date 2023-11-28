package com.kuaishou.weapon.p0.jni;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Member;
/* loaded from: classes10.dex */
public class Engine {
    public static /* synthetic */ Interceptable $ic;
    public static volatile Engine instance;
    public static volatile int loadSoCount;
    public static volatile boolean loadSuccess;
    public static volatile String soPath;
    public static volatile String soVersion;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-349254581, "Lcom/kuaishou/weapon/p0/jni/Engine;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-349254581, "Lcom/kuaishou/weapon/p0/jni/Engine;");
        }
    }

    public static native String abc();

    public static native String bcd();

    public static native int mmo(Member member, int i, int i2);

    public static native int mqc(Member member, int i);

    public static native int off();

    public static native String tao(int i, long j, Object obj);

    public native byte[] ac(byte[] bArr, byte[] bArr2);

    public native byte[] ar(byte[] bArr, byte[] bArr2);

    public native String cde();

    public native byte[] dc(byte[] bArr, byte[] bArr2);

    public native String def();

    public native byte[] dr(byte[] bArr, byte[] bArr2);

    public native String efg();

    public native String eopq(int i, int i2, int i3, String str);

    public native String fgh();

    public native String ghi();

    public native String hij();

    public native String klm(int i, String str);

    public native String nop();

    public native String pqr(int i, int i2, int i3, String str);

    public native String qrs();

    public native String stu(int i, int i2, int i3, int i4, String str);

    public Engine() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:47:0x00df
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public static com.kuaishou.weapon.p0.jni.Engine getInstance(android.content.Context r8) {
        /*
            com.baidu.titan.sdk.runtime.Interceptable r0 = com.kuaishou.weapon.p0.jni.Engine.$ic
            if (r0 != 0) goto Lee
        L4:
            java.lang.String r0 = com.kuaishou.weapon.p0.jni.Engine.soVersion
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto Leb
            boolean r0 = com.kuaishou.weapon.p0.jni.Engine.loadSuccess
            if (r0 != 0) goto Leb
            com.kuaishou.weapon.p0.jni.Engine r0 = com.kuaishou.weapon.p0.jni.Engine.instance
            if (r0 != 0) goto Leb
            java.lang.Class<com.kuaishou.weapon.p0.jni.Engine> r0 = com.kuaishou.weapon.p0.jni.Engine.class
            monitor-enter(r0)
            java.lang.String r1 = "weapon"
            com.kuaishou.weapon.p0.jni.Engine r2 = com.kuaishou.weapon.p0.jni.Engine.instance     // Catch: java.lang.Throwable -> Le8
            if (r2 != 0) goto L24
            com.kuaishou.weapon.p0.jni.Engine r2 = new com.kuaishou.weapon.p0.jni.Engine     // Catch: java.lang.Throwable -> Le8
            r2.<init>()     // Catch: java.lang.Throwable -> Le8
            com.kuaishou.weapon.p0.jni.Engine.instance = r2     // Catch: java.lang.Throwable -> Le8
        L24:
            java.lang.String r2 = "re_po_rt"
            com.kuaishou.weapon.p0.h r2 = com.kuaishou.weapon.p0.h.a(r8, r2)     // Catch: java.lang.Throwable -> Le8
            r3 = 0
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lbb
            r4.<init>()     // Catch: java.lang.Throwable -> Lbb
            r4.append(r1)     // Catch: java.lang.Throwable -> Lbb
            java.lang.String r5 = com.kuaishou.weapon.p0.jni.Engine.soVersion     // Catch: java.lang.Throwable -> Lbb
            java.lang.String r6 = "."
            java.lang.String r7 = ""
            java.lang.String r5 = r5.replace(r6, r7)     // Catch: java.lang.Throwable -> Lbb
            r4.append(r5)     // Catch: java.lang.Throwable -> Lbb
            java.lang.String r5 = ".so"
            r4.append(r5)     // Catch: java.lang.Throwable -> Lbb
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> Lbb
            boolean r4 = com.kuaishou.weapon.p0.bp.a(r8, r4)     // Catch: java.lang.Throwable -> Lbb
            if (r4 != 0) goto L55
            com.kuaishou.weapon.p0.jni.Engine.loadSuccess = r3     // Catch: java.lang.Throwable -> Lbb
            com.kuaishou.weapon.p0.jni.Engine r8 = com.kuaishou.weapon.p0.jni.Engine.instance     // Catch: java.lang.Throwable -> Lbb
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Le8
            return r8
        L55:
            java.lang.String r4 = "plc001_lss_v_s"
            java.lang.String r5 = ""
            java.lang.String r4 = r2.b(r4, r5)     // Catch: java.lang.Throwable -> Lbb
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Throwable -> Lbb
            if (r5 == 0) goto L6a
            java.lang.String r4 = com.kuaishou.weapon.p0.jni.Engine.soVersion     // Catch: java.lang.Throwable -> Lbb
            java.lang.String r5 = "plc001_lss_v_s"
            r2.c(r5, r4, r3)     // Catch: java.lang.Throwable -> Lbb
        L6a:
            java.lang.String r5 = "plc001_lps_t_p0"
            int r5 = r2.c(r5)     // Catch: java.lang.Throwable -> Lbb
            com.kuaishou.weapon.p0.jni.Engine.loadSoCount = r5     // Catch: java.lang.Throwable -> Lbb
            java.lang.String r5 = com.kuaishou.weapon.p0.jni.Engine.soVersion     // Catch: java.lang.Throwable -> Lbb
            boolean r4 = android.text.TextUtils.equals(r4, r5)     // Catch: java.lang.Throwable -> Lbb
            if (r4 != 0) goto L83
            java.lang.String r4 = com.kuaishou.weapon.p0.jni.Engine.soVersion     // Catch: java.lang.Throwable -> Lbb
            com.kuaishou.weapon.p0.jni.Engine.loadSoCount = r3     // Catch: java.lang.Throwable -> Lbb
            java.lang.String r5 = "plc001_lss_v_s"
            r2.c(r5, r4, r3)     // Catch: java.lang.Throwable -> Lbb
        L83:
            int r4 = com.kuaishou.weapon.p0.jni.Engine.loadSoCount     // Catch: java.lang.Throwable -> Lbb
            r5 = 1
            int r4 = r4 + r5
            r6 = 10
            if (r4 >= r6) goto Ldf
            int r4 = com.kuaishou.weapon.p0.jni.Engine.loadSoCount     // Catch: java.lang.Throwable -> Lbb
            int r4 = r4 + r5
            com.kuaishou.weapon.p0.jni.Engine.loadSoCount = r4     // Catch: java.lang.Throwable -> Lbb
            java.lang.String r4 = "plc001_lps_t_p0"
            int r6 = com.kuaishou.weapon.p0.jni.Engine.loadSoCount     // Catch: java.lang.Throwable -> Lbb
            r2.d(r4, r6)     // Catch: java.lang.Throwable -> Lbb
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lbb
            r4.<init>()     // Catch: java.lang.Throwable -> Lbb
            r4.append(r1)     // Catch: java.lang.Throwable -> Lbb
            java.lang.String r1 = com.kuaishou.weapon.p0.jni.Engine.soVersion     // Catch: java.lang.Throwable -> Lbb
            java.lang.String r6 = "."
            java.lang.String r7 = ""
            java.lang.String r1 = r1.replace(r6, r7)     // Catch: java.lang.Throwable -> Lbb
            r4.append(r1)     // Catch: java.lang.Throwable -> Lbb
            java.lang.String r1 = r4.toString()     // Catch: java.lang.Throwable -> Lbb
            java.lang.System.loadLibrary(r1)     // Catch: java.lang.Throwable -> Lbb
            bcd()     // Catch: java.lang.Throwable -> Lbb
            com.kuaishou.weapon.p0.jni.Engine.loadSoCount = r3     // Catch: java.lang.Throwable -> Lbb
            com.kuaishou.weapon.p0.jni.Engine.loadSuccess = r5     // Catch: java.lang.Throwable -> Lbb
            goto Ldf
        Lbb:
            r1 = move-exception
            com.kuaishou.weapon.p0.jni.Engine.loadSuccess = r3     // Catch: java.lang.Throwable -> Le8
            java.util.HashMap r3 = new java.util.HashMap     // Catch: java.lang.Exception -> Ldf java.lang.Throwable -> Le8
            r3.<init>()     // Catch: java.lang.Exception -> Ldf java.lang.Throwable -> Le8
            java.lang.String r4 = "e"
            java.lang.String r1 = r1.getMessage()     // Catch: java.lang.Exception -> Ldf java.lang.Throwable -> Le8
            r3.put(r4, r1)     // Catch: java.lang.Exception -> Ldf java.lang.Throwable -> Le8
            java.lang.String r1 = "v"
            java.lang.String r4 = com.kuaishou.weapon.p0.jni.Engine.soVersion     // Catch: java.lang.Exception -> Ldf java.lang.Throwable -> Le8
            r3.put(r1, r4)     // Catch: java.lang.Exception -> Ldf java.lang.Throwable -> Le8
            java.lang.String r1 = "l"
            java.lang.String r4 = com.kuaishou.weapon.p0.ck.m     // Catch: java.lang.Exception -> Ldf java.lang.Throwable -> Le8
            r3.put(r1, r4)     // Catch: java.lang.Exception -> Ldf java.lang.Throwable -> Le8
            java.lang.String r1 = com.kuaishou.weapon.p0.ck.a     // Catch: java.lang.Exception -> Ldf java.lang.Throwable -> Le8
            com.kuaishou.weapon.p0.bh.a(r8, r1, r3)     // Catch: java.lang.Exception -> Ldf java.lang.Throwable -> Le8
        Ldf:
            java.lang.String r8 = "plc001_lps_t_p0"
            int r1 = com.kuaishou.weapon.p0.jni.Engine.loadSoCount     // Catch: java.lang.Throwable -> Le8
            r2.d(r8, r1)     // Catch: java.lang.Throwable -> Le8
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Le8
            goto Leb
        Le8:
            r8 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Le8
            throw r8
        Leb:
            com.kuaishou.weapon.p0.jni.Engine r8 = com.kuaishou.weapon.p0.jni.Engine.instance
            return r8
        Lee:
            r5 = r0
            r6 = 65540(0x10004, float:9.1841E-41)
            r7 = 0
            com.baidu.titan.sdk.runtime.InterceptResult r0 = r5.invokeL(r6, r7, r8)
            if (r0 == 0) goto L4
            java.lang.Object r1 = r0.objValue
            com.kuaishou.weapon.p0.jni.Engine r1 = (com.kuaishou.weapon.p0.jni.Engine) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.jni.Engine.getInstance(android.content.Context):com.kuaishou.weapon.p0.jni.Engine");
    }
}
