package com.kuaishou.weapon.p0;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sofire.d.D;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.File;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
/* renamed from: com.kuaishou.weapon.p0.ʾ  reason: contains not printable characters */
/* loaded from: classes5.dex */
public class C0392 {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: ʿ  reason: contains not printable characters */
    public static C0392 f354 = null;

    /* renamed from: ˆ  reason: contains not printable characters */
    public static final int f355 = 3;

    /* renamed from: ˈ  reason: contains not printable characters */
    public static final String f356 = "1";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: ʻ  reason: contains not printable characters */
    public volatile boolean f357;

    /* renamed from: ʼ  reason: contains not printable characters */
    public C0390 f358;

    /* renamed from: ʽ  reason: contains not printable characters */
    public Context f359;

    /* renamed from: ʾ  reason: contains not printable characters */
    public C0400 f360;

    /* renamed from: com.kuaishou.weapon.p0.ʾ$ʻ  reason: contains not printable characters */
    /* loaded from: classes5.dex */
    public class RunnableC0393 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: ʻ  reason: contains not printable characters */
        public final /* synthetic */ String f361;

        /* renamed from: ʼ  reason: contains not printable characters */
        public final /* synthetic */ C0392 f362;

        /* renamed from: com.kuaishou.weapon.p0.ʾ$ʻ$ʻ  reason: contains not printable characters */
        /* loaded from: classes5.dex */
        public class C0394 extends TimerTask {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: ʻ  reason: contains not printable characters */
            public final /* synthetic */ C0396 f363;

            /* renamed from: ʼ  reason: contains not printable characters */
            public final /* synthetic */ C0398 f364;

            /* renamed from: ʽ  reason: contains not printable characters */
            public final /* synthetic */ RunnableC0393 f365;

            public C0394(RunnableC0393 runnableC0393, C0396 c0396, C0398 c0398) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {runnableC0393, c0396, c0398};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f365 = runnableC0393;
                this.f363 = c0396;
                this.f364 = c0398;
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f363.m518(this.f365.f361);
                    this.f365.f362.f360.m535(this.f365.f361);
                    File file = new File(this.f364.f381);
                    if (file.exists()) {
                        file.delete();
                    }
                }
            }
        }

        public RunnableC0393(C0392 c0392, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c0392, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f362 = c0392;
            this.f361 = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            C0396 m508;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (TextUtils.isEmpty(this.f361) || (m508 = C0396.m508(this.f362.f359.getApplicationContext(), true)) == null) {
                        return;
                    }
                    C0398 m514 = m508.m514(this.f361);
                    if (m514 == null) {
                        C0398 m537 = this.f362.f360.m537(this.f361);
                        if (m537 != null) {
                            this.f362.m498(this.f361, m537.f381);
                            return;
                        }
                        return;
                    }
                    new Timer().schedule(new C0394(this, m508, m514), 600000L);
                    m508.m518(this.f361);
                    this.f362.f360.m535(this.f361);
                    File file = new File(m514.f381);
                    if (file.exists()) {
                        file.delete();
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public C0392(Context context) {
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
        this.f357 = false;
        this.f359 = context;
        this.f358 = C0390.m479(context);
        this.f360 = C0400.m529(context);
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public static synchronized C0392 m492(Context context) {
        InterceptResult invokeL;
        C0392 c0392;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            synchronized (C0392.class) {
                try {
                    if (f354 == null) {
                        f354 = new C0392(context);
                    }
                    c0392 = f354;
                } catch (Exception unused) {
                    return null;
                }
            }
            return c0392;
        }
        return (C0392) invokeL.objValue;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r5v0 int)] */
    /* renamed from: ʻ  reason: contains not printable characters */
    private synchronized boolean m493(int i, String str, String str2, boolean z, PackageInfo packageInfo) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, this, new Object[]{Integer.valueOf(i), str, str2, Boolean.valueOf(z), packageInfo})) == null) {
            synchronized (this) {
                if (z) {
                    if (this.f360.m536(i) != 1) {
                        return false;
                    }
                }
                C0398 m533 = this.f360.m533(i);
                if (m533 == null) {
                    this.f360.m539(i, -1);
                    HashMap hashMap = new HashMap();
                    StringBuilder sb = new StringBuilder();
                    sb.append(i);
                    hashMap.put(PushConstants.URI_PACKAGE_NAME, sb.toString());
                    hashMap.put("pv", str);
                    hashMap.put("e", C0331.f88);
                    C0433.m856(this.f359, "1002001", hashMap);
                    return false;
                } else if (!C0383.m461(new File(m533.f381))) {
                    this.f360.m539(i, -1);
                    HashMap hashMap2 = new HashMap();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(i);
                    hashMap2.put(PushConstants.URI_PACKAGE_NAME, sb2.toString());
                    hashMap2.put("pv", str);
                    hashMap2.put("e", C0331.f89);
                    hashMap2.put("l", "CBH");
                    C0433.m856(this.f359, "1002001", hashMap2);
                    return false;
                } else {
                    if (packageInfo != null) {
                        m533.f394 = packageInfo;
                    }
                    C0396 m508 = C0396.m508(this.f359.getApplicationContext(), true);
                    if (m508.m516(m533, false)) {
                        C0398 m517 = m508.m517(m533.f381);
                        m517.f378 = 1;
                        m517.f392 = 1;
                        this.f360.m532(m517);
                        return true;
                    }
                    this.f360.m539(i, -1);
                    m508.m519(m533.f381);
                    HashMap hashMap3 = new HashMap();
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(i);
                    hashMap3.put(PushConstants.URI_PACKAGE_NAME, sb3.toString());
                    hashMap3.put("pv", str);
                    hashMap3.put("e", C0331.f90);
                    hashMap3.put("l", "CBH");
                    C0433.m856(this.f359, "1002001", hashMap3);
                    return false;
                }
            }
        }
        return invokeCommon.booleanValue;
    }

    /* renamed from: ʾ  reason: contains not printable characters */
    public static void m495() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            try {
                C0390 m478 = C0390.m478();
                if (m478 != null) {
                    m478.m487("W_S_V", "1");
                }
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public void m496() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            m495();
            m501();
        }
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public void m497(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            try {
                C0358.m366().m367(new RunnableC0393(this, str));
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public void m498(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            this.f360.m535(str);
            File file = new File(str2);
            if (file.exists()) {
                file.delete();
            }
        }
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public synchronized boolean m499(int i, String str, PackageInfo packageInfo) {
        InterceptResult invokeILL;
        boolean m493;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048579, this, i, str, packageInfo)) == null) {
            synchronized (this) {
                m493 = m493(i, str, null, false, packageInfo);
            }
            return m493;
        }
        return invokeILL.booleanValue;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public boolean m500(C0398 c0398, String str, String str2) {
        InterceptResult invokeLLL;
        C0398 c03982;
        C0396 m508;
        HashMap hashMap;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, c0398, str, str2)) == null) {
            if (c0398 == null) {
                hashMap = new HashMap();
                str3 = C0331.f94;
            } else {
                File file = new File(c0398.f381);
                if (C0383.m461(file)) {
                    try {
                        if (!this.f360.m544(c0398.f377)) {
                            this.f360.m532(c0398);
                        }
                        m508 = C0396.m508(this.f359.getApplicationContext(), true);
                        this.f360.m531(c0398.f377, 1);
                        m502(c0398.f379);
                    } catch (Throwable unused) {
                        c03982 = c0398;
                    }
                    if (!m508.m516(c0398, true)) {
                        file.delete();
                        m493(c0398.f377, c0398.f380, null, true, null);
                        this.f360.m531(c0398.f377, 0);
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("e", C0331.f97);
                        hashMap2.put("l", "CBH");
                        hashMap2.put(D.COLUMU_PLUGIN_DEX_PATH, c0398.toString());
                        C0433.m856(this.f359, "1002001", hashMap2);
                        return false;
                    }
                    c03982 = m508.m517(c0398.f381);
                    if (c03982 == null) {
                        try {
                            this.f360.m531(c03982.f377, 0);
                            HashMap hashMap3 = new HashMap();
                            hashMap3.put("e", C0331.f95);
                            hashMap3.put("l", "CBH");
                            C0433.m856(this.f359, "1002001", hashMap3);
                            return false;
                        } catch (Throwable unused2) {
                        }
                    }
                    try {
                        C0398 m533 = this.f360.m533(c03982.f377);
                        File file2 = null;
                        if (m533 != null && !m533.f380.equals(c03982.f380)) {
                            file2 = new File(m533.f381);
                        }
                        c03982.f378 = 1;
                        c03982.f392 = 1;
                        if (this.f360.m532(c03982) > 0 && file2 != null && file2.exists()) {
                            file2.delete();
                        }
                        this.f360.m531(c03982.f377, 0);
                        return true;
                    } catch (Throwable unused3) {
                        return false;
                    }
                }
                hashMap = new HashMap();
                str3 = C0331.f96;
            }
            hashMap.put("e", str3);
            hashMap.put("l", "CBH");
            C0433.m856(this.f359, "1002001", hashMap);
            return false;
        }
        return invokeLLL.booleanValue;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:26:0x0080
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    /* renamed from: ʼ  reason: contains not printable characters */
    public synchronized void m501() {
        /*
            r5 = this;
            com.baidu.titan.sdk.runtime.Interceptable r0 = com.kuaishou.weapon.p0.C0392.$ic
            if (r0 != 0) goto L9b
        L4:
            monitor-enter(r5)
            boolean r0 = r5.f357     // Catch: java.lang.Throwable -> L99
            if (r0 == 0) goto Lb
            monitor-exit(r5)
            return
        Lb:
            r0 = 1
            r5.f357 = r0     // Catch: java.lang.Throwable -> L99
            com.kuaishou.weapon.p0.ˈ r1 = r5.f360     // Catch: java.lang.Throwable -> L99
            java.util.List r1 = r1.m538()     // Catch: java.lang.Throwable -> L99
            java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.Throwable -> L99
        L18:
            boolean r2 = r1.hasNext()     // Catch: java.lang.Throwable -> L99
            if (r2 == 0) goto L67
            java.lang.Object r2 = r1.next()     // Catch: java.lang.Throwable -> L99
            com.kuaishou.weapon.p0.ˆ r2 = (com.kuaishou.weapon.p0.C0398) r2     // Catch: java.lang.Throwable -> L99
            r3 = 0
            android.content.Context r4 = r5.f359     // Catch: java.lang.Throwable -> L30
            java.io.File r4 = r4.getFilesDir()     // Catch: java.lang.Throwable -> L30
            java.lang.String r3 = r4.getCanonicalPath()     // Catch: java.lang.Throwable -> L30
            goto L31
        L30:
        L31:
            if (r3 == 0) goto L18
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L99
            r4.<init>()     // Catch: java.lang.Throwable -> L99
            r4.append(r3)     // Catch: java.lang.Throwable -> L99
            java.lang.String r3 = "/."
            r4.append(r3)     // Catch: java.lang.Throwable -> L99
            int r3 = r2.f377     // Catch: java.lang.Throwable -> L99
            r4.append(r3)     // Catch: java.lang.Throwable -> L99
            java.lang.String r3 = r4.toString()     // Catch: java.lang.Throwable -> L99
            r2.f389 = r3     // Catch: java.lang.Throwable -> L99
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L99
            r3.<init>()     // Catch: java.lang.Throwable -> L99
            java.lang.String r4 = r2.f389     // Catch: java.lang.Throwable -> L99
            r3.append(r4)     // Catch: java.lang.Throwable -> L99
            java.lang.String r4 = "/lib"
            r3.append(r4)     // Catch: java.lang.Throwable -> L99
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L99
            com.kuaishou.weapon.p0.C0383.m464(r3)     // Catch: java.lang.Throwable -> L99
            java.lang.String r2 = r2.f389     // Catch: java.lang.Throwable -> L99
            com.kuaishou.weapon.p0.C0383.m466(r2)     // Catch: java.lang.Throwable -> L99
            goto L18
        L67:
            com.kuaishou.weapon.p0.ˈ r1 = r5.f360     // Catch: java.lang.Throwable -> L99
            r1.m534()     // Catch: java.lang.Throwable -> L99
            com.kuaishou.weapon.p0.ʽﹶ r1 = r5.f358     // Catch: java.lang.Throwable -> L99
            java.lang.String r2 = "wiipaot"
            boolean r1 = r1.m485(r2)     // Catch: java.lang.Throwable -> L99
            if (r1 != 0) goto L83
            com.kuaishou.weapon.p0.ʽﹶ r1 = r5.f358     // Catch: java.lang.Throwable -> L99
            java.lang.String r2 = "wiipaot"
            java.lang.Boolean r3 = java.lang.Boolean.TRUE     // Catch: java.lang.Throwable -> L99
            r1.m484(r2, r3, r0)     // Catch: java.lang.Throwable -> L99
            goto L88
        L80:
            r0 = move-exception
            monitor-exit(r5)
            throw r0
        L83:
            com.kuaishou.weapon.p0.ˈ r1 = r5.f360     // Catch: java.lang.Throwable -> L99
            r1.m540()     // Catch: java.lang.Throwable -> L99
        L88:
            com.kuaishou.weapon.p0.ʽˆ r1 = com.kuaishou.weapon.p0.C0358.m366()     // Catch: java.lang.Throwable -> L99
            com.kuaishou.weapon.p0.ˉ r2 = new com.kuaishou.weapon.p0.ˉ     // Catch: java.lang.Throwable -> L99
            android.content.Context r3 = r5.f359     // Catch: java.lang.Throwable -> L99
            r4 = 0
            r2.<init>(r3, r0, r4)     // Catch: java.lang.Throwable -> L99
            r1.m367(r2)     // Catch: java.lang.Throwable -> L99
            monitor-exit(r5)
            return
        L99:
            monitor-exit(r5)
            return
        L9b:
            r3 = r0
            r4 = 1048581(0x100005, float:1.469375E-39)
            com.baidu.titan.sdk.runtime.InterceptResult r0 = r3.invokeV(r4, r5)
            if (r0 == 0) goto L4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.C0392.m501():void");
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public void m502(String str) {
        C0396 m512;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            try {
                if (TextUtils.isEmpty(str) || (m512 = C0396.m512()) == null) {
                    return;
                }
                m512.m518(str);
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public void m503() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            for (C0398 c0398 : this.f360.m538()) {
                C0396 m512 = C0396.m512();
                if ((m512 != null ? m512.m514(c0398.f379) : null) == null) {
                    m499(c0398.f377, c0398.f380, (PackageInfo) null);
                }
            }
        }
    }
}
