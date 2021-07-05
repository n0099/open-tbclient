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
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.util.concurrent.RejectedExecutionException;
/* loaded from: classes8.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static long f43657a;

    /* renamed from: b  reason: collision with root package name */
    public static long f43658b;

    /* renamed from: c  reason: collision with root package name */
    public static long f43659c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public final a f950a;

    /* renamed from: a  reason: collision with other field name */
    public final c f951a;

    /* loaded from: classes8.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final c f43660a;

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
            this.f43660a = cVar;
        }

        public void finalize() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    synchronized (this.f43660a) {
                        this.f43660a.f43664c = true;
                        this.f43660a.notify();
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

        /* renamed from: a  reason: collision with root package name */
        public int f43661a;

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
            this.f43661a = i2;
        }
    }

    /* loaded from: classes8.dex */
    public static final class c extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public volatile long f43662a;

        /* renamed from: a  reason: collision with other field name */
        public a f952a;

        /* renamed from: a  reason: collision with other field name */
        public volatile boolean f953a;

        /* renamed from: b  reason: collision with root package name */
        public long f43663b;

        /* renamed from: b  reason: collision with other field name */
        public boolean f954b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f43664c;

        /* loaded from: classes8.dex */
        public static final class a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public int f43665a;

            /* renamed from: a  reason: collision with other field name */
            public d[] f955a;

            /* renamed from: b  reason: collision with root package name */
            public int f43666b;

            /* renamed from: c  reason: collision with root package name */
            public int f43667c;

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
                this.f43665a = 256;
                this.f955a = new d[256];
                this.f43666b = 0;
                this.f43667c = 0;
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
                    d[] dVarArr = this.f955a;
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
                if (interceptable != null && interceptable.invokeV(65540, this) != null) {
                    return;
                }
                int i2 = this.f43666b - 1;
                int i3 = (i2 - 1) / 2;
                while (true) {
                    d[] dVarArr = this.f955a;
                    if (dVarArr[i2].f956a >= dVarArr[i3].f956a) {
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
                    int i4 = this.f43666b;
                    if (i3 >= i4 || i4 <= 0) {
                        return;
                    }
                    int i5 = i3 + 1;
                    if (i5 < i4) {
                        d[] dVarArr = this.f955a;
                        if (dVarArr[i5].f956a < dVarArr[i3].f956a) {
                            i3 = i5;
                        }
                    }
                    d[] dVarArr2 = this.f955a;
                    if (dVarArr2[i2].f956a < dVarArr2[i3].f956a) {
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
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f955a[0] : (d) invokeV.objValue;
            }

            /* renamed from: a  reason: collision with other method in class */
            public void m626a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.f955a = new d[this.f43665a];
                    this.f43666b = 0;
                }
            }

            public void a(int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                    for (int i3 = 0; i3 < this.f43666b; i3++) {
                        d[] dVarArr = this.f955a;
                        if (dVarArr[i3].f43668a == i2) {
                            dVarArr[i3].a();
                        }
                    }
                    b();
                }
            }

            public void a(int i2, b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(1048579, this, i2, bVar) == null) {
                    for (int i3 = 0; i3 < this.f43666b; i3++) {
                        d[] dVarArr = this.f955a;
                        if (dVarArr[i3].f957a == bVar) {
                            dVarArr[i3].a();
                        }
                    }
                    b();
                }
            }

            /* renamed from: a  reason: collision with other method in class */
            public void m627a(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) {
                    d[] dVarArr = this.f955a;
                    int length = dVarArr.length;
                    int i2 = this.f43666b;
                    if (length == i2) {
                        d[] dVarArr2 = new d[i2 * 2];
                        System.arraycopy(dVarArr, 0, dVarArr2, 0, i2);
                        this.f955a = dVarArr2;
                    }
                    d[] dVarArr3 = this.f955a;
                    int i3 = this.f43666b;
                    this.f43666b = i3 + 1;
                    dVarArr3[i3] = dVar;
                    c();
                }
            }

            /* renamed from: a  reason: collision with other method in class */
            public boolean m628a() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f43666b == 0 : invokeV.booleanValue;
            }

            /* renamed from: a  reason: collision with other method in class */
            public boolean m629a(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
                    for (int i3 = 0; i3 < this.f43666b; i3++) {
                        if (this.f955a[i3].f43668a == i2) {
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
                    while (i2 < this.f43666b) {
                        if (this.f955a[i2].f959a) {
                            this.f43667c++;
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
                if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) || i2 < 0 || i2 >= (i3 = this.f43666b)) {
                    return;
                }
                d[] dVarArr = this.f955a;
                int i4 = i3 - 1;
                this.f43666b = i4;
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
            this.f43662a = 0L;
            this.f953a = false;
            this.f43663b = 50L;
            this.f952a = new a(null);
            setName(str);
            setDaemon(z);
            start();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65539, this, dVar) == null) {
                this.f952a.m627a(dVar);
                notify();
            }
        }

        public synchronized void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this) {
                    this.f954b = true;
                    this.f952a.m626a();
                    notify();
                }
            }
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m625a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f953a && SystemClock.uptimeMillis() - this.f43662a > TTAdConstant.AD_MAX_EVENT_TIME : invokeV.booleanValue;
        }

        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x0097, code lost:
            r10.f43662a = android.os.SystemClock.uptimeMillis();
            r10.f953a = true;
            r2.f957a.run();
            r10.f953a = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x00a8, code lost:
            r1 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x00a9, code lost:
            monitor-enter(r10);
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x00aa, code lost:
            r10.f954b = true;
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
                    if (this.f954b) {
                        return;
                    }
                    if (!this.f952a.m628a()) {
                        long a2 = h.a();
                        d a3 = this.f952a.a();
                        synchronized (a3.f958a) {
                            if (a3.f959a) {
                                this.f952a.b(0);
                            } else {
                                long j = a3.f956a - a2;
                                if (j > 0) {
                                    if (j > this.f43663b) {
                                        j = this.f43663b;
                                    }
                                    long j2 = this.f43663b + 50;
                                    this.f43663b = j2;
                                    if (j2 > 500) {
                                        this.f43663b = 500L;
                                    }
                                    wait(j);
                                } else {
                                    this.f43663b = 50L;
                                    synchronized (a3.f958a) {
                                        int a4 = this.f952a.a().f956a != a3.f956a ? this.f952a.a(a3) : 0;
                                        if (a3.f959a) {
                                            this.f952a.b(this.f952a.a(a3));
                                        } else {
                                            a3.a(a3.f956a);
                                            this.f952a.b(a4);
                                            a3.f956a = 0L;
                                        }
                                    }
                                }
                            }
                        }
                    } else if (this.f43664c) {
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

        /* renamed from: a  reason: collision with root package name */
        public int f43668a;

        /* renamed from: a  reason: collision with other field name */
        public long f956a;

        /* renamed from: a  reason: collision with other field name */
        public b f957a;

        /* renamed from: a  reason: collision with other field name */
        public final Object f958a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f959a;

        /* renamed from: b  reason: collision with root package name */
        public long f43669b;

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
            this.f958a = new Object();
        }

        public void a(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                synchronized (this.f958a) {
                    this.f43669b = j;
                }
            }
        }

        public boolean a() {
            InterceptResult invokeV;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                synchronized (this.f958a) {
                    z = !this.f959a && this.f956a > 0;
                    this.f959a = true;
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
        f43657a = elapsedRealtime;
        f43658b = elapsedRealtime;
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
        this.f951a = cVar;
        this.f950a = new a(cVar);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public h(boolean z) {
        this("Timer-" + b(), z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65540, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65540, newInitContext);
                return;
            }
        }
    }

    public static synchronized long a() {
        InterceptResult invokeV;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            synchronized (h.class) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (elapsedRealtime > f43658b) {
                    f43657a += elapsedRealtime - f43658b;
                }
                f43658b = elapsedRealtime;
                j = f43657a;
            }
            return j;
        }
        return invokeV.longValue;
    }

    public static synchronized long b() {
        InterceptResult invokeV;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) {
            synchronized (h.class) {
                j = f43659c;
                f43659c = 1 + j;
            }
            return j;
        }
        return invokeV.longValue;
    }

    private void b(b bVar, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65543, this, bVar, j) == null) {
            synchronized (this.f951a) {
                if (this.f951a.f954b) {
                    throw new IllegalStateException("Timer was canceled");
                }
                long a2 = j + a();
                if (a2 < 0) {
                    throw new IllegalArgumentException("Illegal delay to start the TimerTask: " + a2);
                }
                d dVar = new d();
                dVar.f43668a = bVar.f43661a;
                dVar.f957a = bVar;
                dVar.f956a = a2;
                this.f951a.a(dVar);
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m620a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            com.xiaomi.channel.commonutils.logger.b.m70a("quit. finalizer:" + this.f950a);
            this.f951a.a();
        }
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            synchronized (this.f951a) {
                this.f951a.f952a.a(i2);
            }
        }
    }

    public void a(int i2, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, bVar) == null) {
            synchronized (this.f951a) {
                this.f951a.f952a.a(i2, bVar);
            }
        }
    }

    public void a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            if (com.xiaomi.channel.commonutils.logger.b.a() >= 1 || Thread.currentThread() == this.f951a) {
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
    public boolean m621a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f951a.m625a() : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m622a(int i2) {
        InterceptResult invokeI;
        boolean m629a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            synchronized (this.f951a) {
                m629a = this.f951a.f952a.m629a(i2);
            }
            return m629a;
        }
        return invokeI.booleanValue;
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m623b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            synchronized (this.f951a) {
                this.f951a.f952a.m626a();
            }
        }
    }
}
