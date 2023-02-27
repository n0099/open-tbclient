package com.kuaishou.weapon.p0;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
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
/* loaded from: classes8.dex */
public class r {
    public static /* synthetic */ Interceptable $ic = null;
    public static r e = null;
    public static final int f = 3;
    public static final String g = "1";
    public transient /* synthetic */ FieldHolder $fh;
    public volatile boolean a;
    public p3 b;
    public Context c;
    public u d;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ r b;

        /* renamed from: com.kuaishou.weapon.p0.r$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C0537a extends TimerTask {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ s a;
            public final /* synthetic */ t b;
            public final /* synthetic */ a c;

            public C0537a(a aVar, s sVar, t tVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, sVar, tVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = aVar;
                this.a = sVar;
                this.b = tVar;
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.c(this.c.a);
                    this.c.b.d.a(this.c.a);
                    File file = new File(this.b.e);
                    if (file.exists()) {
                        file.delete();
                    }
                }
            }
        }

        public a(r rVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = rVar;
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            s a;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (TextUtils.isEmpty(this.a) || (a = s.a(this.b.c.getApplicationContext(), true)) == null) {
                        return;
                    }
                    t a2 = a.a(this.a);
                    if (a2 == null) {
                        t b = this.b.d.b(this.a);
                        if (b != null) {
                            this.b.a(this.a, b.e);
                            return;
                        }
                        return;
                    }
                    new Timer().schedule(new C0537a(this, a, a2), 600000L);
                    a.c(this.a);
                    this.b.d.a(this.a);
                    File file = new File(a2.e);
                    if (file.exists()) {
                        file.delete();
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public r(Context context) {
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
        this.a = false;
        this.c = context;
        this.b = p3.a(context);
        this.d = u.a(context);
    }

    public static synchronized r a(Context context) {
        InterceptResult invokeL;
        r rVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            synchronized (r.class) {
                try {
                    if (e == null) {
                        e = new r(context);
                    }
                    rVar = e;
                } catch (Exception unused) {
                    return null;
                }
            }
            return rVar;
        }
        return (r) invokeL.objValue;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r5v0 int)] */
    private synchronized boolean a(int i, String str, String str2, boolean z, PackageInfo packageInfo) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, this, new Object[]{Integer.valueOf(i), str, str2, Boolean.valueOf(z), packageInfo})) == null) {
            synchronized (this) {
                if (z) {
                    if (this.d.b(i) != 1) {
                        return false;
                    }
                }
                t a2 = this.d.a(i);
                if (a2 == null) {
                    this.d.b(i, -1);
                    HashMap hashMap = new HashMap();
                    StringBuilder sb = new StringBuilder();
                    sb.append(i);
                    hashMap.put(PushConstants.URI_PACKAGE_NAME, sb.toString());
                    hashMap.put("pv", str);
                    hashMap.put("e", l2.m);
                    h1.a(this.c, "1002001", hashMap);
                    return false;
                } else if (!n3.a(new File(a2.e))) {
                    this.d.b(i, -1);
                    HashMap hashMap2 = new HashMap();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(i);
                    hashMap2.put(PushConstants.URI_PACKAGE_NAME, sb2.toString());
                    hashMap2.put("pv", str);
                    hashMap2.put("e", l2.n);
                    hashMap2.put("l", "CBH");
                    h1.a(this.c, "1002001", hashMap2);
                    return false;
                } else {
                    if (packageInfo != null) {
                        a2.r = packageInfo;
                    }
                    s a3 = s.a(this.c.getApplicationContext(), true);
                    if (a3.a(a2, false)) {
                        t b = a3.b(a2.e);
                        b.b = 1;
                        b.p = 1;
                        this.d.a(b);
                        return true;
                    }
                    this.d.b(i, -1);
                    a3.d(a2.e);
                    HashMap hashMap3 = new HashMap();
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(i);
                    hashMap3.put(PushConstants.URI_PACKAGE_NAME, sb3.toString());
                    hashMap3.put("pv", str);
                    hashMap3.put("e", l2.o);
                    hashMap3.put("l", "CBH");
                    h1.a(this.c, "1002001", hashMap3);
                    return false;
                }
            }
        }
        return invokeCommon.booleanValue;
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            try {
                p3 a2 = p3.a();
                if (a2 != null) {
                    a2.b("W_S_V", "1");
                }
            } catch (Exception unused) {
            }
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            d();
            b();
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            try {
                o.a().a(new a(this, str));
            } catch (Throwable unused) {
            }
        }
    }

    public void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            this.d.a(str);
            File file = new File(str2);
            if (file.exists()) {
                file.delete();
            }
        }
    }

    public synchronized boolean a(int i, String str, PackageInfo packageInfo) {
        InterceptResult invokeILL;
        boolean a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048579, this, i, str, packageInfo)) == null) {
            synchronized (this) {
                a2 = a(i, str, null, false, packageInfo);
            }
            return a2;
        }
        return invokeILL.booleanValue;
    }

    public boolean a(t tVar, String str, String str2) {
        InterceptResult invokeLLL;
        t tVar2;
        s a2;
        HashMap hashMap;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, tVar, str, str2)) == null) {
            if (tVar == null) {
                hashMap = new HashMap();
                str3 = l2.r;
            } else {
                File file = new File(tVar.e);
                if (n3.a(file)) {
                    try {
                        if (!this.d.d(tVar.a)) {
                            this.d.a(tVar);
                        }
                        a2 = s.a(this.c.getApplicationContext(), true);
                        this.d.a(tVar.a, 1);
                        b(tVar.c);
                    } catch (Throwable unused) {
                        tVar2 = tVar;
                    }
                    if (!a2.a(tVar, true)) {
                        file.delete();
                        a(tVar.a, tVar.d, null, true, null);
                        this.d.a(tVar.a, 0);
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("e", l2.u);
                        hashMap2.put("l", "CBH");
                        hashMap2.put("apk", tVar.toString());
                        h1.a(this.c, "1002001", hashMap2);
                        return false;
                    }
                    tVar2 = a2.b(tVar.e);
                    if (tVar2 == null) {
                        try {
                            this.d.a(tVar2.a, 0);
                            HashMap hashMap3 = new HashMap();
                            hashMap3.put("e", l2.s);
                            hashMap3.put("l", "CBH");
                            h1.a(this.c, "1002001", hashMap3);
                            return false;
                        } catch (Throwable unused2) {
                        }
                    }
                    try {
                        t a3 = this.d.a(tVar2.a);
                        File file2 = null;
                        if (a3 != null && !a3.d.equals(tVar2.d)) {
                            file2 = new File(a3.e);
                        }
                        tVar2.b = 1;
                        tVar2.p = 1;
                        if (this.d.a(tVar2) > 0 && file2 != null && file2.exists()) {
                            file2.delete();
                        }
                        this.d.a(tVar2.a, 0);
                        return true;
                    } catch (Throwable unused3) {
                        return false;
                    }
                }
                hashMap = new HashMap();
                str3 = l2.t;
            }
            hashMap.put("e", str3);
            hashMap.put("l", "CBH");
            h1.a(this.c, "1002001", hashMap);
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
    public synchronized void b() {
        /*
            r5 = this;
            com.baidu.titan.sdk.runtime.Interceptable r0 = com.kuaishou.weapon.p0.r.$ic
            if (r0 != 0) goto L9b
        L4:
            monitor-enter(r5)
            boolean r0 = r5.a     // Catch: java.lang.Throwable -> L99
            if (r0 == 0) goto Lb
            monitor-exit(r5)
            return
        Lb:
            r0 = 1
            r5.a = r0     // Catch: java.lang.Throwable -> L99
            com.kuaishou.weapon.p0.u r1 = r5.d     // Catch: java.lang.Throwable -> L99
            java.util.List r1 = r1.b()     // Catch: java.lang.Throwable -> L99
            java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.Throwable -> L99
        L18:
            boolean r2 = r1.hasNext()     // Catch: java.lang.Throwable -> L99
            if (r2 == 0) goto L67
            java.lang.Object r2 = r1.next()     // Catch: java.lang.Throwable -> L99
            com.kuaishou.weapon.p0.t r2 = (com.kuaishou.weapon.p0.t) r2     // Catch: java.lang.Throwable -> L99
            r3 = 0
            android.content.Context r4 = r5.c     // Catch: java.lang.Throwable -> L30
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
            int r3 = r2.a     // Catch: java.lang.Throwable -> L99
            r4.append(r3)     // Catch: java.lang.Throwable -> L99
            java.lang.String r3 = r4.toString()     // Catch: java.lang.Throwable -> L99
            r2.m = r3     // Catch: java.lang.Throwable -> L99
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L99
            r3.<init>()     // Catch: java.lang.Throwable -> L99
            java.lang.String r4 = r2.m     // Catch: java.lang.Throwable -> L99
            r3.append(r4)     // Catch: java.lang.Throwable -> L99
            java.lang.String r4 = "/lib"
            r3.append(r4)     // Catch: java.lang.Throwable -> L99
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L99
            com.kuaishou.weapon.p0.n3.b(r3)     // Catch: java.lang.Throwable -> L99
            java.lang.String r2 = r2.m     // Catch: java.lang.Throwable -> L99
            com.kuaishou.weapon.p0.n3.c(r2)     // Catch: java.lang.Throwable -> L99
            goto L18
        L67:
            com.kuaishou.weapon.p0.u r1 = r5.d     // Catch: java.lang.Throwable -> L99
            r1.a()     // Catch: java.lang.Throwable -> L99
            com.kuaishou.weapon.p0.p3 r1 = r5.b     // Catch: java.lang.Throwable -> L99
            java.lang.String r2 = "wiipaot"
            boolean r1 = r1.a(r2)     // Catch: java.lang.Throwable -> L99
            if (r1 != 0) goto L83
            com.kuaishou.weapon.p0.p3 r1 = r5.b     // Catch: java.lang.Throwable -> L99
            java.lang.String r2 = "wiipaot"
            java.lang.Boolean r3 = java.lang.Boolean.TRUE     // Catch: java.lang.Throwable -> L99
            r1.a(r2, r3, r0)     // Catch: java.lang.Throwable -> L99
            goto L88
        L80:
            r0 = move-exception
            monitor-exit(r5)
            throw r0
        L83:
            com.kuaishou.weapon.p0.u r1 = r5.d     // Catch: java.lang.Throwable -> L99
            r1.c()     // Catch: java.lang.Throwable -> L99
        L88:
            com.kuaishou.weapon.p0.o r1 = com.kuaishou.weapon.p0.o.a()     // Catch: java.lang.Throwable -> L99
            com.kuaishou.weapon.p0.v r2 = new com.kuaishou.weapon.p0.v     // Catch: java.lang.Throwable -> L99
            android.content.Context r3 = r5.c     // Catch: java.lang.Throwable -> L99
            r4 = 0
            r2.<init>(r3, r0, r4)     // Catch: java.lang.Throwable -> L99
            r1.a(r2)     // Catch: java.lang.Throwable -> L99
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
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.r.b():void");
    }

    public void b(String str) {
        s b;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            try {
                if (TextUtils.isEmpty(str) || (b = s.b()) == null) {
                    return;
                }
                b.c(str);
            } catch (Throwable unused) {
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            for (t tVar : this.d.b()) {
                s b = s.b();
                if ((b != null ? b.a(tVar.c) : null) == null) {
                    a(tVar.a, tVar.d, (PackageInfo) null);
                }
            }
        }
    }
}
