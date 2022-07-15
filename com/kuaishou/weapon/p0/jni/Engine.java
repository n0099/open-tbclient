package com.kuaishou.weapon.p0.jni;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Member;
/* loaded from: classes5.dex */
public class Engine {
    public static /* synthetic */ Interceptable $ic;
    public static volatile Engine instance;
    public static volatile int loadSoCount;
    public static volatile boolean loadSuccess;
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

    public static native String abc();

    public static native String bcd();

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:69:0x014c
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public static com.kuaishou.weapon.p0.jni.Engine getInstance(android.content.Context r9) {
        /*
            com.baidu.titan.sdk.runtime.Interceptable r0 = com.kuaishou.weapon.p0.jni.Engine.$ic
            if (r0 != 0) goto L15b
        L4:
            java.lang.String r0 = com.kuaishou.weapon.p0.jni.Engine.soVersion
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L158
            boolean r0 = com.kuaishou.weapon.p0.jni.Engine.loadSuccess
            if (r0 != 0) goto L158
            com.kuaishou.weapon.p0.jni.Engine r0 = com.kuaishou.weapon.p0.jni.Engine.instance
            if (r0 != 0) goto L158
            java.lang.Class<com.kuaishou.weapon.p0.jni.Engine> r0 = com.kuaishou.weapon.p0.jni.Engine.class
            monitor-enter(r0)
            java.lang.String r1 = "weapon"
            com.kuaishou.weapon.p0.jni.Engine r2 = com.kuaishou.weapon.p0.jni.Engine.instance     // Catch: java.lang.Throwable -> L155
            if (r2 != 0) goto L24
            com.kuaishou.weapon.p0.jni.Engine r2 = new com.kuaishou.weapon.p0.jni.Engine     // Catch: java.lang.Throwable -> L155
            r2.<init>()     // Catch: java.lang.Throwable -> L155
            com.kuaishou.weapon.p0.jni.Engine.instance = r2     // Catch: java.lang.Throwable -> L155
        L24:
            com.kuaishou.weapon.p0.ʽי r2 = com.kuaishou.weapon.p0.C0374.m389(r9)     // Catch: java.lang.Throwable -> L155
            r3 = 0
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L120
            r4.<init>()     // Catch: java.lang.Throwable -> L120
            r4.append(r1)     // Catch: java.lang.Throwable -> L120
            java.lang.String r5 = com.kuaishou.weapon.p0.jni.Engine.soVersion     // Catch: java.lang.Throwable -> L120
            java.lang.String r6 = "."
            java.lang.String r7 = ""
            java.lang.String r5 = r5.replace(r6, r7)     // Catch: java.lang.Throwable -> L120
            r4.append(r5)     // Catch: java.lang.Throwable -> L120
            java.lang.String r5 = ".so"
            r4.append(r5)     // Catch: java.lang.Throwable -> L120
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L120
            boolean r4 = com.kuaishou.weapon.p0.C0299.m159(r9, r4)     // Catch: java.lang.Throwable -> L120
            if (r4 != 0) goto L64
            java.util.HashMap r1 = new java.util.HashMap     // Catch: java.lang.Throwable -> L120
            r1.<init>()     // Catch: java.lang.Throwable -> L120
            java.lang.String r4 = "l"
            java.lang.String r5 = com.kuaishou.weapon.p0.C0331.f87     // Catch: java.lang.Throwable -> L120
            r1.put(r4, r5)     // Catch: java.lang.Throwable -> L120
            java.lang.String r4 = com.kuaishou.weapon.p0.C0331.f76     // Catch: java.lang.Throwable -> L120
            com.kuaishou.weapon.p0.C0433.m856(r9, r4, r1)     // Catch: java.lang.Throwable -> L120
            com.kuaishou.weapon.p0.jni.Engine.loadSuccess = r3     // Catch: java.lang.Throwable -> L120
            com.kuaishou.weapon.p0.jni.Engine r9 = com.kuaishou.weapon.p0.jni.Engine.instance     // Catch: java.lang.Throwable -> L120
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L155
            return r9
        L64:
            java.lang.String r4 = "plc001_lss_v_s"
            java.lang.String r5 = ""
            java.lang.String r4 = r2.m395(r4, r5)     // Catch: java.lang.Throwable -> L120
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Throwable -> L120
            if (r5 == 0) goto L79
            java.lang.String r4 = com.kuaishou.weapon.p0.jni.Engine.soVersion     // Catch: java.lang.Throwable -> L120
            java.lang.String r5 = "plc001_lss_v_s"
            r2.m407(r5, r4, r3)     // Catch: java.lang.Throwable -> L120
        L79:
            java.lang.String r5 = "plc001_lps_t_p0"
            int r5 = r2.m409(r5)     // Catch: java.lang.Throwable -> L120
            com.kuaishou.weapon.p0.jni.Engine.loadSoCount = r5     // Catch: java.lang.Throwable -> L120
            java.lang.String r5 = com.kuaishou.weapon.p0.jni.Engine.soVersion     // Catch: java.lang.Throwable -> L120
            boolean r4 = android.text.TextUtils.equals(r4, r5)     // Catch: java.lang.Throwable -> L120
            if (r4 != 0) goto L92
            java.lang.String r4 = com.kuaishou.weapon.p0.jni.Engine.soVersion     // Catch: java.lang.Throwable -> L120
            com.kuaishou.weapon.p0.jni.Engine.loadSoCount = r3     // Catch: java.lang.Throwable -> L120
            java.lang.String r5 = "plc001_lss_v_s"
            r2.m407(r5, r4, r3)     // Catch: java.lang.Throwable -> L120
        L92:
            int r4 = com.kuaishou.weapon.p0.jni.Engine.loadSoCount     // Catch: java.lang.Throwable -> L120
            r5 = 1
            int r4 = r4 + r5
            r6 = 10
            if (r4 >= r6) goto L14c
            int r4 = com.kuaishou.weapon.p0.jni.Engine.loadSoCount     // Catch: java.lang.Throwable -> L120
            int r4 = r4 + r5
            com.kuaishou.weapon.p0.jni.Engine.loadSoCount = r4     // Catch: java.lang.Throwable -> L120
            java.lang.String r4 = "plc001_lps_t_p0"
            int r6 = com.kuaishou.weapon.p0.jni.Engine.loadSoCount     // Catch: java.lang.Throwable -> L120
            r2.m417(r4, r6)     // Catch: java.lang.Throwable -> L120
            java.util.HashMap r4 = new java.util.HashMap     // Catch: java.lang.Throwable -> L120
            r4.<init>()     // Catch: java.lang.Throwable -> L120
            java.lang.String r6 = "c"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L120
            r7.<init>()     // Catch: java.lang.Throwable -> L120
            int r8 = com.kuaishou.weapon.p0.jni.Engine.loadSoCount     // Catch: java.lang.Throwable -> L120
            r7.append(r8)     // Catch: java.lang.Throwable -> L120
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Throwable -> L120
            r4.put(r6, r7)     // Catch: java.lang.Throwable -> L120
            java.lang.String r6 = "v"
            java.lang.String r7 = com.kuaishou.weapon.p0.jni.Engine.soVersion     // Catch: java.lang.Throwable -> L120
            r4.put(r6, r7)     // Catch: java.lang.Throwable -> L120
            java.lang.String r6 = "l"
            java.lang.String r7 = "p"
            r4.put(r6, r7)     // Catch: java.lang.Throwable -> L120
            java.lang.String r6 = "1003001"
            com.kuaishou.weapon.p0.C0433.m856(r9, r6, r4)     // Catch: java.lang.Throwable -> L120
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L120
            r4.<init>()     // Catch: java.lang.Throwable -> L120
            r4.append(r1)     // Catch: java.lang.Throwable -> L120
            java.lang.String r1 = com.kuaishou.weapon.p0.jni.Engine.soVersion     // Catch: java.lang.Throwable -> L120
            java.lang.String r6 = "."
            java.lang.String r7 = ""
            java.lang.String r1 = r1.replace(r6, r7)     // Catch: java.lang.Throwable -> L120
            r4.append(r1)     // Catch: java.lang.Throwable -> L120
            java.lang.String r1 = r4.toString()     // Catch: java.lang.Throwable -> L120
            java.lang.System.loadLibrary(r1)     // Catch: java.lang.Throwable -> L120
            bcd()     // Catch: java.lang.Throwable -> L120
            java.util.HashMap r1 = new java.util.HashMap     // Catch: java.lang.Throwable -> L120
            r1.<init>()     // Catch: java.lang.Throwable -> L120
            java.lang.String r4 = "c"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L120
            r6.<init>()     // Catch: java.lang.Throwable -> L120
            int r7 = com.kuaishou.weapon.p0.jni.Engine.loadSoCount     // Catch: java.lang.Throwable -> L120
            r6.append(r7)     // Catch: java.lang.Throwable -> L120
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> L120
            r1.put(r4, r6)     // Catch: java.lang.Throwable -> L120
            java.lang.String r4 = "v"
            java.lang.String r6 = com.kuaishou.weapon.p0.jni.Engine.soVersion     // Catch: java.lang.Throwable -> L120
            r1.put(r4, r6)     // Catch: java.lang.Throwable -> L120
            java.lang.String r4 = "l"
            java.lang.String r6 = "s"
            r1.put(r4, r6)     // Catch: java.lang.Throwable -> L120
            java.lang.String r4 = "1003001"
            com.kuaishou.weapon.p0.C0433.m856(r9, r4, r1)     // Catch: java.lang.Throwable -> L120
            com.kuaishou.weapon.p0.jni.Engine.loadSoCount = r3     // Catch: java.lang.Throwable -> L120
            com.kuaishou.weapon.p0.jni.Engine.loadSuccess = r5     // Catch: java.lang.Throwable -> L120
            goto L14c
        L120:
            r1 = move-exception
            com.kuaishou.weapon.p0.jni.Engine.loadSuccess = r3     // Catch: java.lang.Throwable -> L155
            java.lang.String r3 = com.kuaishou.weapon.p0.jni.Engine.soVersion     // Catch: java.lang.Exception -> L14c java.lang.Throwable -> L155
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Exception -> L14c java.lang.Throwable -> L155
            if (r3 != 0) goto L14c
            java.util.HashMap r3 = new java.util.HashMap     // Catch: java.lang.Exception -> L14c java.lang.Throwable -> L155
            r3.<init>()     // Catch: java.lang.Exception -> L14c java.lang.Throwable -> L155
            java.lang.String r4 = "e"
            java.lang.String r1 = r1.getMessage()     // Catch: java.lang.Exception -> L14c java.lang.Throwable -> L155
            r3.put(r4, r1)     // Catch: java.lang.Exception -> L14c java.lang.Throwable -> L155
            java.lang.String r1 = "v"
            java.lang.String r4 = com.kuaishou.weapon.p0.jni.Engine.soVersion     // Catch: java.lang.Exception -> L14c java.lang.Throwable -> L155
            r3.put(r1, r4)     // Catch: java.lang.Exception -> L14c java.lang.Throwable -> L155
            java.lang.String r1 = "l"
            java.lang.String r4 = com.kuaishou.weapon.p0.C0331.f86     // Catch: java.lang.Exception -> L14c java.lang.Throwable -> L155
            r3.put(r1, r4)     // Catch: java.lang.Exception -> L14c java.lang.Throwable -> L155
            java.lang.String r1 = com.kuaishou.weapon.p0.C0331.f76     // Catch: java.lang.Exception -> L14c java.lang.Throwable -> L155
            com.kuaishou.weapon.p0.C0433.m856(r9, r1, r3)     // Catch: java.lang.Exception -> L14c java.lang.Throwable -> L155
        L14c:
            java.lang.String r9 = "plc001_lps_t_p0"
            int r1 = com.kuaishou.weapon.p0.jni.Engine.loadSoCount     // Catch: java.lang.Throwable -> L155
            r2.m417(r9, r1)     // Catch: java.lang.Throwable -> L155
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L155
            goto L158
        L155:
            r9 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L155
            throw r9
        L158:
            com.kuaishou.weapon.p0.jni.Engine r9 = com.kuaishou.weapon.p0.jni.Engine.instance
            return r9
        L15b:
            r6 = r0
            r7 = 65540(0x10004, float:9.1841E-41)
            r8 = 0
            com.baidu.titan.sdk.runtime.InterceptResult r0 = r6.invokeL(r7, r8, r9)
            if (r0 == 0) goto L4
            java.lang.Object r1 = r0.objValue
            com.kuaishou.weapon.p0.jni.Engine r1 = (com.kuaishou.weapon.p0.jni.Engine) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.jni.Engine.getInstance(android.content.Context):com.kuaishou.weapon.p0.jni.Engine");
    }

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
}
