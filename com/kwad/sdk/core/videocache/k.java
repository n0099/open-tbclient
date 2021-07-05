package com.kwad.sdk.core.videocache;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.Thread;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public class k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final m f36712a;

    /* renamed from: b  reason: collision with root package name */
    public final com.kwad.sdk.core.videocache.a f36713b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f36714c;

    /* renamed from: d  reason: collision with root package name */
    public final Object f36715d;

    /* renamed from: e  reason: collision with root package name */
    public final AtomicInteger f36716e;

    /* renamed from: f  reason: collision with root package name */
    public volatile Thread f36717f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f36718g;

    /* renamed from: h  reason: collision with root package name */
    public volatile int f36719h;

    /* renamed from: com.kwad.sdk.core.videocache.k$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ k f36720a;

        public a(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f36720a = kVar;
        }

        public /* synthetic */ a(k kVar, AnonymousClass1 anonymousClass1) {
            this(kVar);
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f36720a.e();
            }
        }
    }

    public k(m mVar, com.kwad.sdk.core.videocache.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mVar, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f36714c = new Object();
        this.f36715d = new Object();
        this.f36719h = -1;
        this.f36712a = (m) j.a(mVar);
        this.f36713b = (com.kwad.sdk.core.videocache.a) j.a(aVar);
        this.f36716e = new AtomicInteger();
    }

    private void b() {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65538, this) == null) || (i2 = this.f36716e.get()) < 1) {
            return;
        }
        this.f36716e.set(0);
        throw new ProxyCacheException("Error reading source " + i2 + " times");
    }

    private void b(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            a(j, j2);
            synchronized (this.f36714c) {
                this.f36714c.notifyAll();
            }
        }
    }

    private synchronized void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65540, this) == null) {
            synchronized (this) {
                boolean z = (this.f36717f == null || this.f36717f.getState() == Thread.State.TERMINATED) ? false : true;
                if (!this.f36718g && !this.f36713b.d() && !z) {
                    a aVar = new a(this, null);
                    this.f36717f = new Thread(aVar, "Source reader for " + this.f36712a);
                    this.f36717f.start();
                }
            }
        }
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            synchronized (this.f36714c) {
                try {
                    try {
                        this.f36714c.wait(1000L);
                    } catch (InterruptedException e2) {
                        throw new ProxyCacheException("Waiting source data is interrupted!", e2);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE, INVOKE, MOVE_EXCEPTION, IGET, INVOKE, INVOKE, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) != null) {
            return;
        }
        long j = -1;
        long j2 = 0;
        try {
            j2 = this.f36713b.a();
            this.f36712a.a(j2);
            j = this.f36712a.a();
            byte[] bArr = new byte[8192];
            while (true) {
                int a2 = this.f36712a.a(bArr);
                if (a2 == -1) {
                    g();
                    f();
                    break;
                }
                synchronized (this.f36715d) {
                    if (h()) {
                        return;
                    }
                    this.f36713b.a(bArr, a2);
                }
                j2 += a2;
                b(j2, j);
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            this.f36719h = 100;
            a(this.f36719h);
        }
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            synchronized (this.f36715d) {
                if (!h() && this.f36713b.a() == this.f36712a.a()) {
                    this.f36713b.c();
                }
            }
        }
    }

    private boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) ? Thread.currentThread().isInterrupted() || this.f36718g : invokeV.booleanValue;
    }

    private void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            try {
                this.f36712a.b();
            } catch (ProxyCacheException e2) {
                a(new ProxyCacheException("Error closing source " + this.f36712a, e2));
            }
        }
    }

    public int a(byte[] bArr, long j, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{bArr, Long.valueOf(j), Integer.valueOf(i2)})) == null) {
            l.a(bArr, j, i2);
            while (!this.f36713b.d() && this.f36713b.a() < i2 + j && !this.f36718g) {
                c();
                d();
                b();
            }
            int a2 = this.f36713b.a(bArr, j, i2);
            if (this.f36713b.d() && this.f36719h != 100) {
                this.f36719h = 100;
                a(100);
            }
            return a2;
        }
        return invokeCommon.intValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this.f36715d) {
                com.kwad.sdk.core.d.a.a("ProxyCache", "Shutdown proxy for " + this.f36712a);
                try {
                    this.f36718g = true;
                    if (this.f36717f != null) {
                        this.f36717f.interrupt();
                    }
                    this.f36713b.b();
                } catch (ProxyCacheException e2) {
                    a(e2);
                }
            }
        }
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
        }
    }

    public void a(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            int i2 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
            int i3 = i2 == 0 ? 100 : (int) ((((float) j) / ((float) j2)) * 100.0f);
            boolean z = i3 != this.f36719h;
            if ((i2 >= 0) && z) {
                a(i3);
            }
            this.f36719h = i3;
        }
    }

    public final void a(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, th) == null) {
            if (th instanceof InterruptedProxyCacheException) {
                com.kwad.sdk.core.d.a.a("ProxyCache", "ProxyCache is interrupted");
            } else {
                com.kwad.sdk.core.d.a.d("ProxyCache", "ProxyCache error");
            }
        }
    }
}
