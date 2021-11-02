package com.kwad.sdk.core.videocache;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.Thread;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public class k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final m f65188a;

    /* renamed from: b  reason: collision with root package name */
    public final com.kwad.sdk.core.videocache.a f65189b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f65190c;

    /* renamed from: d  reason: collision with root package name */
    public final Object f65191d;

    /* renamed from: e  reason: collision with root package name */
    public final AtomicInteger f65192e;

    /* renamed from: f  reason: collision with root package name */
    public volatile Thread f65193f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f65194g;

    /* renamed from: h  reason: collision with root package name */
    public volatile int f65195h;

    /* renamed from: com.kwad.sdk.core.videocache.k$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ k f65196a;

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
            this.f65196a = kVar;
        }

        public /* synthetic */ a(k kVar, AnonymousClass1 anonymousClass1) {
            this(kVar);
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f65196a.e();
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
        this.f65190c = new Object();
        this.f65191d = new Object();
        this.f65195h = -1;
        this.f65188a = (m) j.a(mVar);
        this.f65189b = (com.kwad.sdk.core.videocache.a) j.a(aVar);
        this.f65192e = new AtomicInteger();
    }

    private void b() {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65538, this) == null) || (i2 = this.f65192e.get()) < 1) {
            return;
        }
        this.f65192e.set(0);
        throw new ProxyCacheException("Error reading source " + i2 + " times");
    }

    private void b(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            a(j, j2);
            synchronized (this.f65190c) {
                this.f65190c.notifyAll();
            }
        }
    }

    private synchronized void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            synchronized (this) {
                boolean z = (this.f65193f == null || this.f65193f.getState() == Thread.State.TERMINATED) ? false : true;
                if (!this.f65194g && !this.f65189b.d() && !z) {
                    a aVar = new a(this, null);
                    this.f65193f = new Thread(aVar, "Source reader for " + this.f65188a);
                    this.f65193f.start();
                }
            }
        }
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            synchronized (this.f65190c) {
                try {
                    try {
                        this.f65190c.wait(1000L);
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
            j2 = this.f65189b.a();
            this.f65188a.a(j2);
            j = this.f65188a.a();
            byte[] bArr = new byte[8192];
            while (true) {
                int a2 = this.f65188a.a(bArr);
                if (a2 == -1) {
                    g();
                    f();
                    break;
                }
                synchronized (this.f65191d) {
                    if (h()) {
                        return;
                    }
                    this.f65189b.a(bArr, a2);
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
            this.f65195h = 100;
            a(this.f65195h);
        }
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            synchronized (this.f65191d) {
                if (!h() && this.f65189b.a() == this.f65188a.a()) {
                    this.f65189b.c();
                }
            }
        }
    }

    private boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) ? Thread.currentThread().isInterrupted() || this.f65194g : invokeV.booleanValue;
    }

    private void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            try {
                this.f65188a.b();
            } catch (ProxyCacheException e2) {
                a(new ProxyCacheException("Error closing source " + this.f65188a, e2));
            }
        }
    }

    public int a(byte[] bArr, long j, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{bArr, Long.valueOf(j), Integer.valueOf(i2)})) == null) {
            l.a(bArr, j, i2);
            while (!this.f65189b.d() && this.f65189b.a() < i2 + j && !this.f65194g) {
                c();
                d();
                b();
            }
            int a2 = this.f65189b.a(bArr, j, i2);
            if (this.f65189b.d() && this.f65195h != 100) {
                this.f65195h = 100;
                a(100);
            }
            return a2;
        }
        return invokeCommon.intValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this.f65191d) {
                com.kwad.sdk.core.d.a.a("ProxyCache", "Shutdown proxy for " + this.f65188a);
                try {
                    this.f65194g = true;
                    if (this.f65193f != null) {
                        this.f65193f.interrupt();
                    }
                    this.f65189b.b();
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
            boolean z = i3 != this.f65195h;
            if ((i2 >= 0) && z) {
                a(i3);
            }
            this.f65195h = i3;
        }
    }

    public final void a(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, th) == null) {
            if (th instanceof InterruptedProxyCacheException) {
                com.kwad.sdk.core.d.a.a("ProxyCache", "ProxyCache is interrupted");
            } else {
                com.kwad.sdk.core.d.a.e("ProxyCache", "ProxyCache error");
            }
        }
    }
}
