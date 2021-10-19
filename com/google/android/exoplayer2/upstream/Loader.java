package com.google.android.exoplayer2.upstream;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import c.i.b.a.h0.n;
import c.i.b.a.i0.t;
import c.i.b.a.i0.v;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
/* loaded from: classes9.dex */
public final class Loader implements n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final ExecutorService f70559a;

    /* renamed from: b  reason: collision with root package name */
    public b<? extends c> f70560b;

    /* renamed from: c  reason: collision with root package name */
    public IOException f70561c;

    /* loaded from: classes9.dex */
    public static final class UnexpectedLoaderException extends IOException {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UnexpectedLoaderException(Throwable th) {
            super("Unexpected " + th.getClass().getSimpleName() + ": " + th.getMessage(), th);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {th};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (Throwable) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface a<T extends c> {
        void l(T t, long j2, long j3, boolean z);

        void m(T t, long j2, long j3);

        int n(T t, long j2, long j3, IOException iOException);
    }

    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes9.dex */
    public final class b<T extends c> extends Handler implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final T f70562e;

        /* renamed from: f  reason: collision with root package name */
        public final a<T> f70563f;

        /* renamed from: g  reason: collision with root package name */
        public final int f70564g;

        /* renamed from: h  reason: collision with root package name */
        public final long f70565h;

        /* renamed from: i  reason: collision with root package name */
        public IOException f70566i;

        /* renamed from: j  reason: collision with root package name */
        public int f70567j;
        public volatile Thread k;
        public volatile boolean l;
        public final /* synthetic */ Loader m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Loader loader, Looper looper, T t, a<T> aVar, int i2, long j2) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {loader, looper, t, aVar, Integer.valueOf(i2), Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.m = loader;
            this.f70562e = t;
            this.f70563f = aVar;
            this.f70564g = i2;
            this.f70565h = j2;
        }

        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.l = z;
                this.f70566i = null;
                if (hasMessages(0)) {
                    removeMessages(0);
                    if (!z) {
                        sendEmptyMessage(1);
                    }
                } else {
                    this.f70562e.cancelLoad();
                    if (this.k != null) {
                        this.k.interrupt();
                    }
                }
                if (z) {
                    c();
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    this.f70563f.l(this.f70562e, elapsedRealtime, elapsedRealtime - this.f70565h, true);
                }
            }
        }

        public final void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f70566i = null;
                this.m.f70559a.execute(this.m.f70560b);
            }
        }

        public final void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.m.f70560b = null;
            }
        }

        public final long d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? Math.min((this.f70567j - 1) * 1000, 5000) : invokeV.longValue;
        }

        public void e(int i2) throws IOException {
            IOException iOException;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048580, this, i2) == null) && (iOException = this.f70566i) != null && this.f70567j > i2) {
                throw iOException;
            }
        }

        public void f(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048581, this, j2) == null) {
                c.i.b.a.i0.a.f(this.m.f70560b == null);
                this.m.f70560b = this;
                if (j2 > 0) {
                    sendEmptyMessageDelayed(0, j2);
                } else {
                    b();
                }
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048582, this, message) == null) || this.l) {
                return;
            }
            int i2 = message.what;
            if (i2 == 0) {
                b();
            } else if (i2 != 4) {
                c();
                long elapsedRealtime = SystemClock.elapsedRealtime();
                long j2 = elapsedRealtime - this.f70565h;
                if (this.f70562e.b()) {
                    this.f70563f.l(this.f70562e, elapsedRealtime, j2, false);
                    return;
                }
                int i3 = message.what;
                if (i3 == 1) {
                    this.f70563f.l(this.f70562e, elapsedRealtime, j2, false);
                } else if (i3 == 2) {
                    try {
                        this.f70563f.m(this.f70562e, elapsedRealtime, j2);
                    } catch (RuntimeException e2) {
                        this.m.f70561c = new UnexpectedLoaderException(e2);
                    }
                } else if (i3 != 3) {
                } else {
                    IOException iOException = (IOException) message.obj;
                    this.f70566i = iOException;
                    int n = this.f70563f.n(this.f70562e, elapsedRealtime, j2, iOException);
                    if (n == 3) {
                        this.m.f70561c = this.f70566i;
                    } else if (n != 2) {
                        this.f70567j = n != 1 ? 1 + this.f70567j : 1;
                        f(d());
                    }
                }
            } else {
                throw ((Error) message.obj);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                try {
                    this.k = Thread.currentThread();
                    if (!this.f70562e.b()) {
                        t.a("load:" + this.f70562e.getClass().getSimpleName());
                        try {
                            this.f70562e.a();
                            t.c();
                        } catch (Throwable th) {
                            t.c();
                            throw th;
                        }
                    }
                    if (this.l) {
                        return;
                    }
                    sendEmptyMessage(2);
                } catch (IOException e2) {
                    if (this.l) {
                        return;
                    }
                    obtainMessage(3, e2).sendToTarget();
                } catch (OutOfMemoryError e3) {
                    if (this.l) {
                        return;
                    }
                    obtainMessage(3, new UnexpectedLoaderException(e3)).sendToTarget();
                } catch (Error e4) {
                    if (!this.l) {
                        obtainMessage(4, e4).sendToTarget();
                    }
                    throw e4;
                } catch (InterruptedException unused) {
                    c.i.b.a.i0.a.f(this.f70562e.b());
                    if (this.l) {
                        return;
                    }
                    sendEmptyMessage(2);
                } catch (Exception e5) {
                    if (this.l) {
                        return;
                    }
                    obtainMessage(3, new UnexpectedLoaderException(e5)).sendToTarget();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface c {
        void a() throws IOException, InterruptedException;

        boolean b();

        void cancelLoad();
    }

    /* loaded from: classes9.dex */
    public interface d {
        void i();
    }

    /* loaded from: classes9.dex */
    public static final class e extends Handler implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final d f70568e;

        public e(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f70568e = dVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                this.f70568e.i();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && getLooper().getThread().isAlive()) {
                sendEmptyMessage(0);
            }
        }
    }

    public Loader(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f70559a = v.B(str);
    }

    @Override // c.i.b.a.h0.n
    public void a() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            h(Integer.MIN_VALUE);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f70560b.a(false);
        }
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f70560b != null : invokeV.booleanValue;
    }

    public void h(int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            IOException iOException = this.f70561c;
            if (iOException == null) {
                b<? extends c> bVar = this.f70560b;
                if (bVar != null) {
                    if (i2 == Integer.MIN_VALUE) {
                        i2 = bVar.f70564g;
                    }
                    bVar.e(i2);
                    return;
                }
                return;
            }
            throw iOException;
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            j(null);
        }
    }

    public boolean j(d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, dVar)) == null) {
            b<? extends c> bVar = this.f70560b;
            boolean z = true;
            if (bVar != null) {
                bVar.a(true);
                if (dVar != null) {
                    this.f70559a.execute(new e(dVar));
                }
            } else if (dVar != null) {
                dVar.i();
                this.f70559a.shutdown();
                return z;
            }
            z = false;
            this.f70559a.shutdown();
            return z;
        }
        return invokeL.booleanValue;
    }

    public <T extends c> long k(T t, a<T> aVar, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048582, this, t, aVar, i2)) == null) {
            Looper myLooper = Looper.myLooper();
            c.i.b.a.i0.a.f(myLooper != null);
            long elapsedRealtime = SystemClock.elapsedRealtime();
            new b(this, myLooper, t, aVar, i2, elapsedRealtime).f(0L);
            return elapsedRealtime;
        }
        return invokeLLI.longValue;
    }
}
