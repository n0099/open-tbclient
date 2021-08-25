package com.xiaomi.push.service;

import android.os.SystemClock;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.RejectedExecutionException;
/* loaded from: classes10.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static long f78020a;

    /* renamed from: b  reason: collision with root package name */
    public static long f78021b;

    /* renamed from: c  reason: collision with root package name */
    public static long f78022c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public final a f954a;

    /* renamed from: a  reason: collision with other field name */
    public final c f955a;

    /* loaded from: classes10.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final c f78023a;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
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
            this.f78023a = cVar;
        }

        public void finalize() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    synchronized (this.f78023a) {
                        this.f78023a.f78027c = true;
                        this.f78023a.notify();
                    }
                } finally {
                    super.finalize();
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public static abstract class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f78024a;

        public b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f78024a = i2;
        }
    }

    /* loaded from: classes10.dex */
    public static final class c extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public volatile long f78025a;

        /* renamed from: a  reason: collision with other field name */
        public a f956a;

        /* renamed from: a  reason: collision with other field name */
        public volatile boolean f957a;

        /* renamed from: b  reason: collision with root package name */
        public long f78026b;

        /* renamed from: b  reason: collision with other field name */
        public boolean f958b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f78027c;

        /* loaded from: classes10.dex */
        public static final class a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public int f78028a;

            /* renamed from: a  reason: collision with other field name */
            public d[] f959a;

            /* renamed from: b  reason: collision with root package name */
            public int f78029b;

            /* renamed from: c  reason: collision with root package name */
            public int f78030c;

            public a() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f78028a = 256;
                this.f959a = new d[256];
                this.f78029b = 0;
                this.f78030c = 0;
            }

            public /* synthetic */ a(i iVar) {
                this();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public int a(d dVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable != null && (invokeL = interceptable.invokeL(65539, this, dVar)) != null) {
                    return invokeL.intValue;
                }
                int i2 = 0;
                while (true) {
                    d[] dVarArr = this.f959a;
                    if (i2 >= dVarArr.length) {
                        return -1;
                    }
                    if (dVarArr[i2] == dVar) {
                        return i2;
                    }
                    i2++;
                }
            }

            private void c() {
                Interceptable interceptable = $ic;
                if (interceptable != null && interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) != null) {
                    return;
                }
                int i2 = this.f78029b - 1;
                int i3 = (i2 - 1) / 2;
                while (true) {
                    d[] dVarArr = this.f959a;
                    if (dVarArr[i2].f960a >= dVarArr[i3].f960a) {
                        return;
                    }
                    d dVar = dVarArr[i2];
                    dVarArr[i2] = dVarArr[i3];
                    dVarArr[i3] = dVar;
                    int i4 = i3;
                    i3 = (i3 - 1) / 2;
                    i2 = i4;
                }
            }

            private void c(int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null && interceptable.invokeI(AdIconUtil.AD_TEXT_ID, this, i2) != null) {
                    return;
                }
                int i3 = (i2 * 2) + 1;
                while (true) {
                    int i4 = this.f78029b;
                    if (i3 >= i4 || i4 <= 0) {
                        return;
                    }
                    int i5 = i3 + 1;
                    if (i5 < i4) {
                        d[] dVarArr = this.f959a;
                        if (dVarArr[i5].f960a < dVarArr[i3].f960a) {
                            i3 = i5;
                        }
                    }
                    d[] dVarArr2 = this.f959a;
                    if (dVarArr2[i2].f960a < dVarArr2[i3].f960a) {
                        return;
                    }
                    d dVar = dVarArr2[i2];
                    dVarArr2[i2] = dVarArr2[i3];
                    dVarArr2[i3] = dVar;
                    int i6 = i3;
                    i3 = (i3 * 2) + 1;
                    i2 = i6;
                }
            }

            public d a() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f959a[0] : (d) invokeV.objValue;
            }

            /* renamed from: a  reason: collision with other method in class */
            public void m629a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.f959a = new d[this.f78028a];
                    this.f78029b = 0;
                }
            }

            public void a(int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                    for (int i3 = 0; i3 < this.f78029b; i3++) {
                        d[] dVarArr = this.f959a;
                        if (dVarArr[i3].f78031a == i2) {
                            dVarArr[i3].a();
                        }
                    }
                    b();
                }
            }

            public void a(int i2, b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(1048579, this, i2, bVar) == null) {
                    for (int i3 = 0; i3 < this.f78029b; i3++) {
                        d[] dVarArr = this.f959a;
                        if (dVarArr[i3].f961a == bVar) {
                            dVarArr[i3].a();
                        }
                    }
                    b();
                }
            }

            /* renamed from: a  reason: collision with other method in class */
            public void m630a(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) {
                    d[] dVarArr = this.f959a;
                    int length = dVarArr.length;
                    int i2 = this.f78029b;
                    if (length == i2) {
                        d[] dVarArr2 = new d[i2 * 2];
                        System.arraycopy(dVarArr, 0, dVarArr2, 0, i2);
                        this.f959a = dVarArr2;
                    }
                    d[] dVarArr3 = this.f959a;
                    int i3 = this.f78029b;
                    this.f78029b = i3 + 1;
                    dVarArr3[i3] = dVar;
                    c();
                }
            }

            /* renamed from: a  reason: collision with other method in class */
            public boolean m631a() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f78029b == 0 : invokeV.booleanValue;
            }

            /* renamed from: a  reason: collision with other method in class */
            public boolean m632a(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
                    for (int i3 = 0; i3 < this.f78029b; i3++) {
                        if (this.f959a[i3].f78031a == i2) {
                            return true;
                        }
                    }
                    return false;
                }
                return invokeI.booleanValue;
            }

            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                    int i2 = 0;
                    while (i2 < this.f78029b) {
                        if (this.f959a[i2].f963a) {
                            this.f78030c++;
                            b(i2);
                            i2--;
                        }
                        i2++;
                    }
                }
            }

            public void b(int i2) {
                int i3;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) || i2 < 0 || i2 >= (i3 = this.f78029b)) {
                    return;
                }
                d[] dVarArr = this.f959a;
                int i4 = i3 - 1;
                this.f78029b = i4;
                dVarArr[i2] = dVarArr[i4];
                dVarArr[i4] = null;
                c(i2);
            }
        }

        public c(String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f78025a = 0L;
            this.f957a = false;
            this.f78026b = 50L;
            this.f956a = new a(null);
            setName(str);
            setDaemon(z);
            start();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65539, this, dVar) == null) {
                this.f956a.m630a(dVar);
                notify();
            }
        }

        public synchronized void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this) {
                    this.f958b = true;
                    this.f956a.m629a();
                    notify();
                }
            }
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m628a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f957a && SystemClock.uptimeMillis() - this.f78025a > 600000 : invokeV.booleanValue;
        }

        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x0097, code lost:
            r10.f78025a = android.os.SystemClock.uptimeMillis();
            r10.f957a = true;
            r2.f961a.run();
            r10.f957a = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x00a8, code lost:
            r1 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x00a9, code lost:
            monitor-enter(r10);
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x00aa, code lost:
            r10.f958b = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x00ad, code lost:
            throw r1;
         */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) {
                return;
            }
            while (true) {
                synchronized (this) {
                    if (this.f958b) {
                        return;
                    }
                    if (!this.f956a.m631a()) {
                        long a2 = h.a();
                        d a3 = this.f956a.a();
                        synchronized (a3.f962a) {
                            if (a3.f963a) {
                                this.f956a.b(0);
                            } else {
                                long j2 = a3.f960a - a2;
                                if (j2 > 0) {
                                    if (j2 > this.f78026b) {
                                        j2 = this.f78026b;
                                    }
                                    long j3 = this.f78026b + 50;
                                    this.f78026b = j3;
                                    if (j3 > 500) {
                                        this.f78026b = 500L;
                                    }
                                    wait(j2);
                                } else {
                                    this.f78026b = 50L;
                                    synchronized (a3.f962a) {
                                        int a4 = this.f956a.a().f960a != a3.f960a ? this.f956a.a(a3) : 0;
                                        if (a3.f963a) {
                                            this.f956a.b(this.f956a.a(a3));
                                        } else {
                                            a3.a(a3.f960a);
                                            this.f956a.b(a4);
                                            a3.f960a = 0L;
                                        }
                                    }
                                }
                            }
                        }
                    } else if (this.f78027c) {
                        return;
                    } else {
                        try {
                            wait();
                        } catch (InterruptedException unused) {
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f78031a;

        /* renamed from: a  reason: collision with other field name */
        public long f960a;

        /* renamed from: a  reason: collision with other field name */
        public b f961a;

        /* renamed from: a  reason: collision with other field name */
        public final Object f962a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f963a;

        /* renamed from: b  reason: collision with root package name */
        public long f78032b;

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f962a = new Object();
        }

        public void a(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) {
                synchronized (this.f962a) {
                    this.f78032b = j2;
                }
            }
        }

        public boolean a() {
            InterceptResult invokeV;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                synchronized (this.f962a) {
                    z = !this.f963a && this.f960a > 0;
                    this.f963a = true;
                }
                return z;
            }
            return invokeV.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(311648456, "Lcom/xiaomi/push/service/h;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(311648456, "Lcom/xiaomi/push/service/h;");
                return;
            }
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() > 0 ? SystemClock.elapsedRealtime() : 0L;
        f78020a = elapsedRealtime;
        f78021b = elapsedRealtime;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public h() {
        this(false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this(((Boolean) newInitContext.callArgs[0]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public h(String str) {
        this(str, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public h(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        c cVar = new c(str, z);
        this.f955a = cVar;
        this.f954a = new a(cVar);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public h(boolean z) {
        this("Timer-" + b(), z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
    }

    public static synchronized long a() {
        InterceptResult invokeV;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            synchronized (h.class) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (elapsedRealtime > f78021b) {
                    f78020a += elapsedRealtime - f78021b;
                }
                f78021b = elapsedRealtime;
                j2 = f78020a;
            }
            return j2;
        }
        return invokeV.longValue;
    }

    public static synchronized long b() {
        InterceptResult invokeV;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) {
            synchronized (h.class) {
                j2 = f78022c;
                f78022c = 1 + j2;
            }
            return j2;
        }
        return invokeV.longValue;
    }

    private void b(b bVar, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65543, this, bVar, j2) == null) {
            synchronized (this.f955a) {
                if (this.f955a.f958b) {
                    throw new IllegalStateException("Timer was canceled");
                }
                long a2 = j2 + a();
                if (a2 < 0) {
                    throw new IllegalArgumentException("Illegal delay to start the TimerTask: " + a2);
                }
                d dVar = new d();
                dVar.f78031a = bVar.f78024a;
                dVar.f961a = bVar;
                dVar.f960a = a2;
                this.f955a.a(dVar);
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m623a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            com.xiaomi.channel.commonutils.logger.b.m73a("quit. finalizer:" + this.f954a);
            this.f955a.a();
        }
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            synchronized (this.f955a) {
                this.f955a.f956a.a(i2);
            }
        }
    }

    public void a(int i2, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, bVar) == null) {
            synchronized (this.f955a) {
                this.f955a.f956a.a(i2, bVar);
            }
        }
    }

    public void a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            if (com.xiaomi.channel.commonutils.logger.b.a() >= 1 || Thread.currentThread() == this.f955a) {
                bVar.run();
            } else {
                com.xiaomi.channel.commonutils.logger.b.d("run job outside job job thread");
                throw new RejectedExecutionException("Run job outside job thread");
            }
        }
    }

    public void a(b bVar, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048580, this, bVar, j2) == null) {
            if (j2 >= 0) {
                b(bVar, j2);
                return;
            }
            throw new IllegalArgumentException("delay < 0: " + j2);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m624a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f955a.m628a() : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m625a(int i2) {
        InterceptResult invokeI;
        boolean m632a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            synchronized (this.f955a) {
                m632a = this.f955a.f956a.m632a(i2);
            }
            return m632a;
        }
        return invokeI.booleanValue;
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m626b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            synchronized (this.f955a) {
                this.f955a.f956a.m629a();
            }
        }
    }
}
