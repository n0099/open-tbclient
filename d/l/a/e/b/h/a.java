package d.l.a.e.b.h;

import android.os.Process;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.f.p;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.RevenueServerConst;
import d.l.a.e.b.g.e;
import d.l.a.e.b.l.f;
import java.io.InputStream;
import java.util.concurrent.Future;
/* loaded from: classes8.dex */
public class a implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final InputStream f71799a;

    /* renamed from: b  reason: collision with root package name */
    public final int f71800b;

    /* renamed from: c  reason: collision with root package name */
    public final int f71801c;

    /* renamed from: d  reason: collision with root package name */
    public final Object f71802d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f71803e;

    /* renamed from: f  reason: collision with root package name */
    public d.l.a.e.b.i.a f71804f;

    /* renamed from: g  reason: collision with root package name */
    public d.l.a.e.b.i.a f71805g;

    /* renamed from: h  reason: collision with root package name */
    public d.l.a.e.b.i.a f71806h;

    /* renamed from: i  reason: collision with root package name */
    public d.l.a.e.b.i.a f71807i;
    public d.l.a.e.b.i.a j;
    public d.l.a.e.b.i.a k;
    public volatile boolean l;
    public volatile boolean m;
    public volatile Throwable n;
    public volatile Future o;
    public int p;
    public final Runnable q;

    /* renamed from: d.l.a.e.b.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC2042a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f71808e;

        public RunnableC2042a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f71808e = aVar;
        }

        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 3, expect 1 */
        @Override // java.lang.Runnable
        public void run() {
            d.l.a.e.b.i.a k;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Process.setThreadPriority(10);
                do {
                    try {
                        k = this.f71808e.k();
                        k.f71813c = this.f71808e.f71799a.read(k.f71811a);
                        this.f71808e.j(k);
                    } catch (Throwable th) {
                        try {
                            this.f71808e.n = th;
                            th.printStackTrace();
                            synchronized (this.f71808e.f71803e) {
                                this.f71808e.m = true;
                                this.f71808e.f71803e.notify();
                                f.E(this.f71808e.f71799a);
                                return;
                            }
                        } catch (Throwable th2) {
                            synchronized (this.f71808e.f71803e) {
                                this.f71808e.m = true;
                                this.f71808e.f71803e.notify();
                                f.E(this.f71808e.f71799a);
                                throw th2;
                            }
                        }
                    }
                } while (k.f71813c != -1);
                synchronized (this.f71808e.f71803e) {
                    this.f71808e.m = true;
                    this.f71808e.f71803e.notify();
                }
                f.E(this.f71808e.f71799a);
            }
        }
    }

    public a(InputStream inputStream, int i2, int i3) throws Throwable {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {inputStream, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f71802d = new Object();
        this.f71803e = new Object();
        this.q = new RunnableC2042a(this);
        this.f71799a = inputStream;
        this.f71800b = i2;
        if (i3 < 1) {
            i3 = 1;
        } else if (i3 > 64) {
            i3 = 64;
        }
        this.f71801c = i3;
        i();
    }

    @Override // d.l.a.e.b.h.b
    public d.l.a.e.b.i.a a() throws BaseException, InterruptedException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? l() : (d.l.a.e.b.i.a) invokeV.objValue;
    }

    public final void g(d.l.a.e.b.i.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            synchronized (this.f71802d) {
                d.l.a.e.b.i.a aVar2 = this.f71805g;
                if (aVar2 == null) {
                    this.f71805g = aVar;
                    this.f71804f = aVar;
                    this.f71802d.notify();
                } else {
                    aVar2.f71814d = aVar;
                    this.f71805g = aVar;
                }
            }
        }
    }

    public final void i() throws Throwable {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.o = e.F0().submit(this.q);
        }
    }

    public final void j(d.l.a.e.b.i.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            synchronized (this.f71803e) {
                d.l.a.e.b.i.a aVar2 = this.j;
                if (aVar2 == null) {
                    this.j = aVar;
                    this.f71807i = aVar;
                    this.f71803e.notify();
                } else {
                    aVar2.f71814d = aVar;
                    this.j = aVar;
                }
            }
        }
    }

    public final d.l.a.e.b.i.a k() throws p, InterruptedException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            d.l.a.e.b.i.a aVar = this.f71806h;
            if (aVar != null) {
                if (!this.l) {
                    this.f71806h = aVar.f71814d;
                    aVar.f71814d = null;
                    return aVar;
                }
                throw new p("");
            }
            synchronized (this.f71802d) {
                if (!this.l) {
                    d.l.a.e.b.i.a aVar2 = this.f71804f;
                    if (aVar2 == null && this.p < this.f71801c) {
                        this.p++;
                        return new d.l.a.e.b.i.a(this.f71800b);
                    }
                    while (aVar2 == null) {
                        this.f71802d.wait();
                        if (!this.l) {
                            aVar2 = this.f71804f;
                        } else {
                            throw new p("");
                        }
                    }
                    this.f71806h = aVar2.f71814d;
                    this.f71805g = null;
                    this.f71804f = null;
                    aVar2.f71814d = null;
                    return aVar2;
                }
                throw new p("");
            }
        }
        return (d.l.a.e.b.i.a) invokeV.objValue;
    }

    public final d.l.a.e.b.i.a l() throws BaseException, InterruptedException {
        InterceptResult invokeV;
        d.l.a.e.b.i.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            d.l.a.e.b.i.a aVar2 = this.k;
            if (aVar2 != null) {
                this.k = aVar2.f71814d;
                aVar2.f71814d = null;
                return aVar2;
            }
            synchronized (this.f71803e) {
                aVar = this.f71807i;
                if (aVar == null) {
                    while (!this.m) {
                        this.f71803e.wait();
                        aVar = this.f71807i;
                        if (aVar != null) {
                        }
                    }
                    m();
                    throw null;
                }
                this.k = aVar.f71814d;
                this.j = null;
                this.f71807i = null;
                aVar.f71814d = null;
            }
            return aVar;
        }
        return (d.l.a.e.b.i.a) invokeV.objValue;
    }

    public final void m() throws BaseException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            Throwable th = this.n;
            if (th != null) {
                if (th instanceof p) {
                    throw new BaseException((int) RevenueServerConst.GetUserYbDetailsRequest, "async reader closed!");
                }
                f.B(th, "async_read");
                throw null;
            }
            throw new BaseException(1069, "async reader terminated!");
        }
    }

    @Override // d.l.a.e.b.h.b
    public void a(d.l.a.e.b.i.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            g(aVar);
        }
    }

    @Override // d.l.a.e.b.h.b
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this.f71802d) {
                this.l = true;
                this.f71802d.notify();
            }
            Future future = this.o;
            if (future != null) {
                try {
                    future.cancel(true);
                } catch (Throwable unused) {
                }
                this.o = null;
            }
        }
    }
}
