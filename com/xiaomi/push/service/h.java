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
/* loaded from: classes7.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public static long a;

    /* renamed from: b  reason: collision with root package name */
    public static long f44573b;

    /* renamed from: c  reason: collision with root package name */
    public static long f44574c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public final a f931a;

    /* renamed from: a  reason: collision with other field name */
    public final c f932a;

    /* loaded from: classes7.dex */
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
                        this.a.f44576c = true;
                        this.a.notify();
                    }
                } finally {
                    super.finalize();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
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

    /* loaded from: classes7.dex */
    public static final class c extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile long a;

        /* renamed from: a  reason: collision with other field name */
        public a f933a;

        /* renamed from: a  reason: collision with other field name */
        public volatile boolean f934a;

        /* renamed from: b  reason: collision with root package name */
        public long f44575b;

        /* renamed from: b  reason: collision with other field name */
        public boolean f935b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f44576c;

        /* loaded from: classes7.dex */
        public static final class a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public int a;

            /* renamed from: a  reason: collision with other field name */
            public d[] f936a;

            /* renamed from: b  reason: collision with root package name */
            public int f44577b;

            /* renamed from: c  reason: collision with root package name */
            public int f44578c;

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
                this.f936a = new d[256];
                this.f44577b = 0;
                this.f44578c = 0;
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
                int i = 0;
                while (true) {
                    d[] dVarArr = this.f936a;
                    if (i >= dVarArr.length) {
                        return -1;
                    }
                    if (dVarArr[i] == dVar) {
                        return i;
                    }
                    i++;
                }
            }

            private void c() {
                Interceptable interceptable = $ic;
                if (interceptable != null && interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) != null) {
                    return;
                }
                int i = this.f44577b - 1;
                int i2 = (i - 1) / 2;
                while (true) {
                    d[] dVarArr = this.f936a;
                    if (dVarArr[i].f937a >= dVarArr[i2].f937a) {
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
                if (interceptable != null && interceptable.invokeI(65541, this, i) != null) {
                    return;
                }
                int i2 = (i * 2) + 1;
                while (true) {
                    int i3 = this.f44577b;
                    if (i2 >= i3 || i3 <= 0) {
                        return;
                    }
                    int i4 = i2 + 1;
                    if (i4 < i3) {
                        d[] dVarArr = this.f936a;
                        if (dVarArr[i4].f937a < dVarArr[i2].f937a) {
                            i2 = i4;
                        }
                    }
                    d[] dVarArr2 = this.f936a;
                    if (dVarArr2[i].f937a < dVarArr2[i2].f937a) {
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
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f936a[0] : (d) invokeV.objValue;
            }

            /* renamed from: a  reason: collision with other method in class */
            public void m668a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.f936a = new d[this.a];
                    this.f44577b = 0;
                }
            }

            public void a(int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                    for (int i2 = 0; i2 < this.f44577b; i2++) {
                        d[] dVarArr = this.f936a;
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
                    for (int i2 = 0; i2 < this.f44577b; i2++) {
                        d[] dVarArr = this.f936a;
                        if (dVarArr[i2].f938a == bVar) {
                            dVarArr[i2].a();
                        }
                    }
                    b();
                }
            }

            /* renamed from: a  reason: collision with other method in class */
            public void m669a(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) {
                    d[] dVarArr = this.f936a;
                    int length = dVarArr.length;
                    int i = this.f44577b;
                    if (length == i) {
                        d[] dVarArr2 = new d[i * 2];
                        System.arraycopy(dVarArr, 0, dVarArr2, 0, i);
                        this.f936a = dVarArr2;
                    }
                    d[] dVarArr3 = this.f936a;
                    int i2 = this.f44577b;
                    this.f44577b = i2 + 1;
                    dVarArr3[i2] = dVar;
                    c();
                }
            }

            /* renamed from: a  reason: collision with other method in class */
            public boolean m670a() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f44577b == 0 : invokeV.booleanValue;
            }

            /* renamed from: a  reason: collision with other method in class */
            public boolean m671a(int i) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
                    for (int i2 = 0; i2 < this.f44577b; i2++) {
                        if (this.f936a[i2].a == i) {
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
                    while (i < this.f44577b) {
                        if (this.f936a[i].f940a) {
                            this.f44578c++;
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
                if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) || i < 0 || i >= (i2 = this.f44577b)) {
                    return;
                }
                d[] dVarArr = this.f936a;
                int i3 = i2 - 1;
                this.f44577b = i3;
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
            this.f934a = false;
            this.f44575b = 50L;
            this.f933a = new a(null);
            setName(str);
            setDaemon(z);
            start();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65539, this, dVar) == null) {
                this.f933a.m669a(dVar);
                notify();
            }
        }

        public synchronized void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this) {
                    this.f935b = true;
                    this.f933a.m668a();
                    notify();
                }
            }
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m667a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f934a && SystemClock.uptimeMillis() - this.a > 600000 : invokeV.booleanValue;
        }

        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x0097, code lost:
            r10.a = android.os.SystemClock.uptimeMillis();
            r10.f934a = true;
            r2.f938a.run();
            r10.f934a = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x00a8, code lost:
            r1 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x00a9, code lost:
            monitor-enter(r10);
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x00aa, code lost:
            r10.f935b = true;
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
                    if (this.f935b) {
                        return;
                    }
                    if (!this.f933a.m670a()) {
                        long a2 = h.a();
                        d a3 = this.f933a.a();
                        synchronized (a3.f939a) {
                            if (a3.f940a) {
                                this.f933a.b(0);
                            } else {
                                long j = a3.f937a - a2;
                                if (j > 0) {
                                    if (j > this.f44575b) {
                                        j = this.f44575b;
                                    }
                                    long j2 = this.f44575b + 50;
                                    this.f44575b = j2;
                                    if (j2 > 500) {
                                        this.f44575b = 500L;
                                    }
                                    wait(j);
                                } else {
                                    this.f44575b = 50L;
                                    synchronized (a3.f939a) {
                                        int a4 = this.f933a.a().f937a != a3.f937a ? this.f933a.a(a3) : 0;
                                        if (a3.f940a) {
                                            this.f933a.b(this.f933a.a(a3));
                                        } else {
                                            a3.a(a3.f937a);
                                            this.f933a.b(a4);
                                            a3.f937a = 0L;
                                        }
                                    }
                                }
                            }
                        }
                    } else if (this.f44576c) {
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

    /* loaded from: classes7.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: a  reason: collision with other field name */
        public long f937a;

        /* renamed from: a  reason: collision with other field name */
        public b f938a;

        /* renamed from: a  reason: collision with other field name */
        public final Object f939a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f940a;

        /* renamed from: b  reason: collision with root package name */
        public long f44579b;

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
            this.f939a = new Object();
        }

        public void a(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                synchronized (this.f939a) {
                    this.f44579b = j;
                }
            }
        }

        public boolean a() {
            InterceptResult invokeV;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                synchronized (this.f939a) {
                    z = !this.f940a && this.f937a > 0;
                    this.f940a = true;
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
        f44573b = elapsedRealtime;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public h() {
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
    public h(String str) {
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

    public h(String str, boolean z) {
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
        this.f932a = cVar;
        this.f931a = new a(cVar);
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
            synchronized (h.class) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (elapsedRealtime > f44573b) {
                    a += elapsedRealtime - f44573b;
                }
                f44573b = elapsedRealtime;
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
            synchronized (h.class) {
                j = f44574c;
                f44574c = 1 + j;
            }
            return j;
        }
        return invokeV.longValue;
    }

    private void b(b bVar, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65543, this, bVar, j) == null) {
            synchronized (this.f932a) {
                if (this.f932a.f935b) {
                    throw new IllegalStateException("Timer was canceled");
                }
                long a2 = j + a();
                if (a2 < 0) {
                    throw new IllegalArgumentException("Illegal delay to start the TimerTask: " + a2);
                }
                d dVar = new d();
                dVar.a = bVar.a;
                dVar.f938a = bVar;
                dVar.f937a = a2;
                this.f932a.a(dVar);
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m662a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            com.xiaomi.channel.commonutils.logger.b.m112a("quit. finalizer:" + this.f931a);
            this.f932a.a();
        }
    }

    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            synchronized (this.f932a) {
                this.f932a.f933a.a(i);
            }
        }
    }

    public void a(int i, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, bVar) == null) {
            synchronized (this.f932a) {
                this.f932a.f933a.a(i, bVar);
            }
        }
    }

    public void a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            if (com.xiaomi.channel.commonutils.logger.b.a() >= 1 || Thread.currentThread() == this.f932a) {
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
    public boolean m663a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f932a.m667a() : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m664a(int i) {
        InterceptResult invokeI;
        boolean m671a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            synchronized (this.f932a) {
                m671a = this.f932a.f933a.m671a(i);
            }
            return m671a;
        }
        return invokeI.booleanValue;
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m665b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            synchronized (this.f932a) {
                this.f932a.f933a.m668a();
            }
        }
    }
}
