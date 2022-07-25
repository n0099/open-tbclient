package com.xiaomi.push.service;

import android.content.Intent;
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
import com.xiaomi.push.service.XMPushService;
import java.util.concurrent.RejectedExecutionException;
/* loaded from: classes8.dex */
public class p {
    public static /* synthetic */ Interceptable $ic;
    public static long a;
    public static long b;
    public static long c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public final a f991a;

    /* renamed from: a  reason: collision with other field name */
    public final c f992a;

    /* loaded from: classes8.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                        this.a.c = true;
                        this.a.notify();
                    }
                } finally {
                    super.finalize();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static abstract class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        public b(int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i;
        }
    }

    /* loaded from: classes8.dex */
    public static final class c extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile long a;

        /* renamed from: a  reason: collision with other field name */
        public a f993a;

        /* renamed from: a  reason: collision with other field name */
        public volatile boolean f994a;
        public long b;

        /* renamed from: b  reason: collision with other field name */
        public boolean f995b;
        public boolean c;

        /* loaded from: classes8.dex */
        public static final class a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public int a;

            /* renamed from: a  reason: collision with other field name */
            public d[] f996a;
            public int b;
            public int c;

            public a() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = 256;
                this.f996a = new d[256];
                this.b = 0;
                this.c = 0;
            }

            public /* synthetic */ a(q qVar) {
                this();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public int a(d dVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable != null && (invokeL = interceptable.invokeL(65539, this, dVar)) != null) {
                    return invokeL.intValue;
                }
                int i = 0;
                while (true) {
                    d[] dVarArr = this.f996a;
                    if (i >= dVarArr.length) {
                        return -1;
                    }
                    if (dVarArr[i] == dVar) {
                        return i;
                    }
                    i++;
                }
            }

            private void b(d dVar) {
                Intent a;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, dVar) == null) {
                    b bVar = dVar.f998a;
                    int i = bVar.a;
                    if (i == 8) {
                        XMPushService.d dVar2 = (XMPushService.d) bVar;
                        if (dVar2.a().f372a != null) {
                            dVar2.a().f372a.f902b = System.currentTimeMillis();
                            dVar2.a().f372a.b = a(dVar);
                        }
                    } else if (i == 15 && (a = ((XMPushService.i) bVar).a()) != null && "10".equals(a.getStringExtra("ext_chid"))) {
                        a.putExtra("enqueue", System.currentTimeMillis());
                        a.putExtra("num", a(dVar));
                    }
                }
            }

            private void c() {
                Interceptable interceptable = $ic;
                if (interceptable != null && interceptable.invokeV(65541, this) != null) {
                    return;
                }
                int i = this.b - 1;
                int i2 = (i - 1) / 2;
                while (true) {
                    d[] dVarArr = this.f996a;
                    if (dVarArr[i].f997a >= dVarArr[i2].f997a) {
                        return;
                    }
                    d dVar = dVarArr[i];
                    dVarArr[i] = dVarArr[i2];
                    dVarArr[i2] = dVar;
                    int i3 = i2;
                    i2 = (i2 - 1) / 2;
                    i = i3;
                }
            }

            private void c(int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null && interceptable.invokeI(65542, this, i) != null) {
                    return;
                }
                int i2 = (i * 2) + 1;
                while (true) {
                    int i3 = this.b;
                    if (i2 >= i3 || i3 <= 0) {
                        return;
                    }
                    int i4 = i2 + 1;
                    if (i4 < i3) {
                        d[] dVarArr = this.f996a;
                        if (dVarArr[i4].f997a < dVarArr[i2].f997a) {
                            i2 = i4;
                        }
                    }
                    d[] dVarArr2 = this.f996a;
                    if (dVarArr2[i].f997a < dVarArr2[i2].f997a) {
                        return;
                    }
                    d dVar = dVarArr2[i];
                    dVarArr2[i] = dVarArr2[i2];
                    dVarArr2[i2] = dVar;
                    int i5 = i2;
                    i2 = (i2 * 2) + 1;
                    i = i5;
                }
            }

            public d a() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f996a[0] : (d) invokeV.objValue;
            }

            /* renamed from: a  reason: collision with other method in class */
            public void m675a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.f996a = new d[this.a];
                    this.b = 0;
                }
            }

            public void a(int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                    for (int i2 = 0; i2 < this.b; i2++) {
                        d[] dVarArr = this.f996a;
                        if (dVarArr[i2].a == i) {
                            dVarArr[i2].a();
                        }
                    }
                    b();
                }
            }

            public void a(int i, b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(1048579, this, i, bVar) == null) {
                    for (int i2 = 0; i2 < this.b; i2++) {
                        d[] dVarArr = this.f996a;
                        if (dVarArr[i2].f998a == bVar) {
                            dVarArr[i2].a();
                        }
                    }
                    b();
                }
            }

            /* renamed from: a  reason: collision with other method in class */
            public void m676a(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) {
                    d[] dVarArr = this.f996a;
                    int length = dVarArr.length;
                    int i = this.b;
                    if (length == i) {
                        d[] dVarArr2 = new d[i * 2];
                        System.arraycopy(dVarArr, 0, dVarArr2, 0, i);
                        this.f996a = dVarArr2;
                    }
                    d[] dVarArr3 = this.f996a;
                    int i2 = this.b;
                    this.b = i2 + 1;
                    dVarArr3[i2] = dVar;
                    c();
                    b(dVar);
                }
            }

            /* renamed from: a  reason: collision with other method in class */
            public boolean m677a() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.b == 0 : invokeV.booleanValue;
            }

            /* renamed from: a  reason: collision with other method in class */
            public boolean m678a(int i) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
                    for (int i2 = 0; i2 < this.b; i2++) {
                        if (this.f996a[i2].a == i) {
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
                    int i = 0;
                    while (i < this.b) {
                        if (this.f996a[i].f1000a) {
                            this.c++;
                            b(i);
                            i--;
                        }
                        i++;
                    }
                }
            }

            public void b(int i) {
                int i2;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) || i < 0 || i >= (i2 = this.b)) {
                    return;
                }
                d[] dVarArr = this.f996a;
                int i3 = i2 - 1;
                this.b = i3;
                dVarArr[i] = dVarArr[i3];
                dVarArr[i3] = null;
                c(i);
            }
        }

        public c(String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = 0L;
            this.f994a = false;
            this.b = 50L;
            this.f993a = new a(null);
            setName(str);
            setDaemon(z);
            start();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65539, this, dVar) == null) {
                this.f993a.m676a(dVar);
                notify();
            }
        }

        public synchronized void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this) {
                    this.f995b = true;
                    this.f993a.m675a();
                    notify();
                }
            }
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m674a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f994a && SystemClock.uptimeMillis() - this.a > 600000 : invokeV.booleanValue;
        }

        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x0097, code lost:
            r10.a = android.os.SystemClock.uptimeMillis();
            r10.f994a = true;
            r2.f998a.run();
            r10.f994a = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x00a8, code lost:
            r1 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x00a9, code lost:
            monitor-enter(r10);
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x00aa, code lost:
            r10.f995b = true;
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
                    if (this.f995b) {
                        return;
                    }
                    if (!this.f993a.m677a()) {
                        long a2 = p.a();
                        d a3 = this.f993a.a();
                        synchronized (a3.f999a) {
                            if (a3.f1000a) {
                                this.f993a.b(0);
                            } else {
                                long j = a3.f997a - a2;
                                if (j > 0) {
                                    if (j > this.b) {
                                        j = this.b;
                                    }
                                    long j2 = this.b + 50;
                                    this.b = j2;
                                    if (j2 > 500) {
                                        this.b = 500L;
                                    }
                                    wait(j);
                                } else {
                                    this.b = 50L;
                                    synchronized (a3.f999a) {
                                        int a4 = this.f993a.a().f997a != a3.f997a ? this.f993a.a(a3) : 0;
                                        if (a3.f1000a) {
                                            this.f993a.b(this.f993a.a(a3));
                                        } else {
                                            a3.a(a3.f997a);
                                            this.f993a.b(a4);
                                            a3.f997a = 0L;
                                        }
                                    }
                                }
                            }
                        }
                    } else if (this.c) {
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

    /* loaded from: classes8.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: a  reason: collision with other field name */
        public long f997a;

        /* renamed from: a  reason: collision with other field name */
        public b f998a;

        /* renamed from: a  reason: collision with other field name */
        public final Object f999a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f1000a;
        public long b;

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f999a = new Object();
        }

        public void a(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                synchronized (this.f999a) {
                    this.b = j;
                }
            }
        }

        public boolean a() {
            InterceptResult invokeV;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                synchronized (this.f999a) {
                    z = !this.f1000a && this.f997a > 0;
                    this.f1000a = true;
                }
                return z;
            }
            return invokeV.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(311648704, "Lcom/xiaomi/push/service/p;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(311648704, "Lcom/xiaomi/push/service/p;");
                return;
            }
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() > 0 ? SystemClock.elapsedRealtime() : 0L;
        a = elapsedRealtime;
        b = elapsedRealtime;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public p() {
        this(false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this(((Boolean) newInitContext.callArgs[0]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public p(String str) {
        this(str, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public p(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        c cVar = new c(str, z);
        this.f992a = cVar;
        this.f991a = new a(cVar);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public p(boolean z) {
        this("Timer-" + b(), z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            synchronized (p.class) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (elapsedRealtime > b) {
                    a += elapsedRealtime - b;
                }
                b = elapsedRealtime;
                j = a;
            }
            return j;
        }
        return invokeV.longValue;
    }

    public static synchronized long b() {
        InterceptResult invokeV;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            synchronized (p.class) {
                j = c;
                c = 1 + j;
            }
            return j;
        }
        return invokeV.longValue;
    }

    private void b(b bVar, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65543, this, bVar, j) == null) {
            synchronized (this.f992a) {
                if (this.f992a.f995b) {
                    throw new IllegalStateException("Timer was canceled");
                }
                long a2 = j + a();
                if (a2 < 0) {
                    throw new IllegalArgumentException("Illegal delay to start the TimerTask: " + a2);
                }
                d dVar = new d();
                dVar.a = bVar.a;
                dVar.f998a = bVar;
                dVar.f997a = a2;
                this.f992a.a(dVar);
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m669a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            com.xiaomi.channel.commonutils.logger.b.m89a("quit. finalizer:" + this.f991a);
            this.f992a.a();
        }
    }

    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            synchronized (this.f992a) {
                this.f992a.f993a.a(i);
            }
        }
    }

    public void a(int i, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, bVar) == null) {
            synchronized (this.f992a) {
                this.f992a.f993a.a(i, bVar);
            }
        }
    }

    public void a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            if (com.xiaomi.channel.commonutils.logger.b.a() >= 1 || Thread.currentThread() == this.f992a) {
                bVar.run();
            } else {
                com.xiaomi.channel.commonutils.logger.b.d("run job outside job job thread");
                throw new RejectedExecutionException("Run job outside job thread");
            }
        }
    }

    public void a(b bVar, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048580, this, bVar, j) == null) {
            if (j >= 0) {
                b(bVar, j);
                return;
            }
            throw new IllegalArgumentException("delay < 0: " + j);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m670a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f992a.m674a() : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m671a(int i) {
        InterceptResult invokeI;
        boolean m678a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            synchronized (this.f992a) {
                m678a = this.f992a.f993a.m678a(i);
            }
            return m678a;
        }
        return invokeI.booleanValue;
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m672b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            synchronized (this.f992a) {
                this.f992a.f993a.m675a();
            }
        }
    }
}
