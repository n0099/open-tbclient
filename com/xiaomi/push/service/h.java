package com.xiaomi.push.service;

import android.os.SystemClock;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.RejectedExecutionException;
/* loaded from: classes4.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public static long a;

    /* renamed from: b  reason: collision with root package name */
    public static long f61493b;

    /* renamed from: c  reason: collision with root package name */
    public static long f61494c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public final a f955a;

    /* renamed from: a  reason: collision with other field name */
    public final c f956a;

    /* loaded from: classes4.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final c a;

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
            this.a = cVar;
        }

        public void finalize() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    synchronized (this.a) {
                        this.a.f61496c = true;
                        this.a.notify();
                    }
                } finally {
                    super.finalize();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static abstract class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

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
            this.a = i2;
        }
    }

    /* loaded from: classes4.dex */
    public static final class c extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile long a;

        /* renamed from: a  reason: collision with other field name */
        public a f957a;

        /* renamed from: a  reason: collision with other field name */
        public volatile boolean f958a;

        /* renamed from: b  reason: collision with root package name */
        public long f61495b;

        /* renamed from: b  reason: collision with other field name */
        public boolean f959b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f61496c;

        /* loaded from: classes4.dex */
        public static final class a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public int a;

            /* renamed from: a  reason: collision with other field name */
            public d[] f960a;

            /* renamed from: b  reason: collision with root package name */
            public int f61497b;

            /* renamed from: c  reason: collision with root package name */
            public int f61498c;

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
                this.a = 256;
                this.f960a = new d[256];
                this.f61497b = 0;
                this.f61498c = 0;
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
                    d[] dVarArr = this.f960a;
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
                int i2 = this.f61497b - 1;
                int i3 = (i2 - 1) / 2;
                while (true) {
                    d[] dVarArr = this.f960a;
                    if (dVarArr[i2].f961a >= dVarArr[i3].f961a) {
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
                if (interceptable != null && interceptable.invokeI(65541, this, i2) != null) {
                    return;
                }
                int i3 = (i2 * 2) + 1;
                while (true) {
                    int i4 = this.f61497b;
                    if (i3 >= i4 || i4 <= 0) {
                        return;
                    }
                    int i5 = i3 + 1;
                    if (i5 < i4) {
                        d[] dVarArr = this.f960a;
                        if (dVarArr[i5].f961a < dVarArr[i3].f961a) {
                            i3 = i5;
                        }
                    }
                    d[] dVarArr2 = this.f960a;
                    if (dVarArr2[i2].f961a < dVarArr2[i3].f961a) {
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
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f960a[0] : (d) invokeV.objValue;
            }

            /* renamed from: a  reason: collision with other method in class */
            public void m690a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.f960a = new d[this.a];
                    this.f61497b = 0;
                }
            }

            public void a(int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                    for (int i3 = 0; i3 < this.f61497b; i3++) {
                        d[] dVarArr = this.f960a;
                        if (dVarArr[i3].a == i2) {
                            dVarArr[i3].a();
                        }
                    }
                    b();
                }
            }

            public void a(int i2, b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(1048579, this, i2, bVar) == null) {
                    for (int i3 = 0; i3 < this.f61497b; i3++) {
                        d[] dVarArr = this.f960a;
                        if (dVarArr[i3].f962a == bVar) {
                            dVarArr[i3].a();
                        }
                    }
                    b();
                }
            }

            /* renamed from: a  reason: collision with other method in class */
            public void m691a(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) {
                    d[] dVarArr = this.f960a;
                    int length = dVarArr.length;
                    int i2 = this.f61497b;
                    if (length == i2) {
                        d[] dVarArr2 = new d[i2 * 2];
                        System.arraycopy(dVarArr, 0, dVarArr2, 0, i2);
                        this.f960a = dVarArr2;
                    }
                    d[] dVarArr3 = this.f960a;
                    int i3 = this.f61497b;
                    this.f61497b = i3 + 1;
                    dVarArr3[i3] = dVar;
                    c();
                }
            }

            /* renamed from: a  reason: collision with other method in class */
            public boolean m692a() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f61497b == 0 : invokeV.booleanValue;
            }

            /* renamed from: a  reason: collision with other method in class */
            public boolean m693a(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
                    for (int i3 = 0; i3 < this.f61497b; i3++) {
                        if (this.f960a[i3].a == i2) {
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
                    while (i2 < this.f61497b) {
                        if (this.f960a[i2].f964a) {
                            this.f61498c++;
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
                if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) || i2 < 0 || i2 >= (i3 = this.f61497b)) {
                    return;
                }
                d[] dVarArr = this.f960a;
                int i4 = i3 - 1;
                this.f61497b = i4;
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
            this.a = 0L;
            this.f958a = false;
            this.f61495b = 50L;
            this.f957a = new a(null);
            setName(str);
            setDaemon(z);
            start();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65539, this, dVar) == null) {
                this.f957a.m691a(dVar);
                notify();
            }
        }

        public synchronized void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this) {
                    this.f959b = true;
                    this.f957a.m690a();
                    notify();
                }
            }
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m689a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f958a && SystemClock.uptimeMillis() - this.a > 600000 : invokeV.booleanValue;
        }

        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x0097, code lost:
            r10.a = android.os.SystemClock.uptimeMillis();
            r10.f958a = true;
            r2.f962a.run();
            r10.f958a = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x00a8, code lost:
            r1 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x00a9, code lost:
            monitor-enter(r10);
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x00aa, code lost:
            r10.f959b = true;
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
                    if (this.f959b) {
                        return;
                    }
                    if (!this.f957a.m692a()) {
                        long a2 = h.a();
                        d a3 = this.f957a.a();
                        synchronized (a3.f963a) {
                            if (a3.f964a) {
                                this.f957a.b(0);
                            } else {
                                long j2 = a3.f961a - a2;
                                if (j2 > 0) {
                                    if (j2 > this.f61495b) {
                                        j2 = this.f61495b;
                                    }
                                    long j3 = this.f61495b + 50;
                                    this.f61495b = j3;
                                    if (j3 > 500) {
                                        this.f61495b = 500L;
                                    }
                                    wait(j2);
                                } else {
                                    this.f61495b = 50L;
                                    synchronized (a3.f963a) {
                                        int a4 = this.f957a.a().f961a != a3.f961a ? this.f957a.a(a3) : 0;
                                        if (a3.f964a) {
                                            this.f957a.b(this.f957a.a(a3));
                                        } else {
                                            a3.a(a3.f961a);
                                            this.f957a.b(a4);
                                            a3.f961a = 0L;
                                        }
                                    }
                                }
                            }
                        }
                    } else if (this.f61496c) {
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

    /* loaded from: classes4.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: a  reason: collision with other field name */
        public long f961a;

        /* renamed from: a  reason: collision with other field name */
        public b f962a;

        /* renamed from: a  reason: collision with other field name */
        public final Object f963a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f964a;

        /* renamed from: b  reason: collision with root package name */
        public long f61499b;

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
            this.f963a = new Object();
        }

        public void a(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) {
                synchronized (this.f963a) {
                    this.f61499b = j2;
                }
            }
        }

        public boolean a() {
            InterceptResult invokeV;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                synchronized (this.f963a) {
                    z = !this.f964a && this.f961a > 0;
                    this.f964a = true;
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
        a = elapsedRealtime;
        f61493b = elapsedRealtime;
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
        this.f956a = cVar;
        this.f955a = new a(cVar);
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
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            synchronized (h.class) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (elapsedRealtime > f61493b) {
                    a += elapsedRealtime - f61493b;
                }
                f61493b = elapsedRealtime;
                j2 = a;
            }
            return j2;
        }
        return invokeV.longValue;
    }

    public static synchronized long b() {
        InterceptResult invokeV;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            synchronized (h.class) {
                j2 = f61494c;
                f61494c = 1 + j2;
            }
            return j2;
        }
        return invokeV.longValue;
    }

    private void b(b bVar, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65543, this, bVar, j2) == null) {
            synchronized (this.f956a) {
                if (this.f956a.f959b) {
                    throw new IllegalStateException("Timer was canceled");
                }
                long a2 = j2 + a();
                if (a2 < 0) {
                    throw new IllegalArgumentException("Illegal delay to start the TimerTask: " + a2);
                }
                d dVar = new d();
                dVar.a = bVar.a;
                dVar.f962a = bVar;
                dVar.f961a = a2;
                this.f956a.a(dVar);
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m684a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            com.xiaomi.channel.commonutils.logger.b.m134a("quit. finalizer:" + this.f955a);
            this.f956a.a();
        }
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            synchronized (this.f956a) {
                this.f956a.f957a.a(i2);
            }
        }
    }

    public void a(int i2, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, bVar) == null) {
            synchronized (this.f956a) {
                this.f956a.f957a.a(i2, bVar);
            }
        }
    }

    public void a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            if (com.xiaomi.channel.commonutils.logger.b.a() >= 1 || Thread.currentThread() == this.f956a) {
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
    public boolean m685a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f956a.m689a() : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m686a(int i2) {
        InterceptResult invokeI;
        boolean m693a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            synchronized (this.f956a) {
                m693a = this.f956a.f957a.m693a(i2);
            }
            return m693a;
        }
        return invokeI.booleanValue;
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m687b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            synchronized (this.f956a) {
                this.f956a.f957a.m690a();
            }
        }
    }
}
