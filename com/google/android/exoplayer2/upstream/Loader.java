package com.google.android.exoplayer2.upstream;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.f.b.a.h0.n;
import d.f.b.a.i0.t;
import d.f.b.a.i0.v;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
/* loaded from: classes5.dex */
public final class Loader implements n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final ExecutorService f32935a;

    /* renamed from: b  reason: collision with root package name */
    public b<? extends c> f32936b;

    /* renamed from: c  reason: collision with root package name */
    public IOException f32937c;

    /* loaded from: classes5.dex */
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

    /* loaded from: classes5.dex */
    public interface a<T extends c> {
        void l(T t, long j, long j2, boolean z);

        void m(T t, long j, long j2);

        int n(T t, long j, long j2, IOException iOException);
    }

    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes5.dex */
    public final class b<T extends c> extends Handler implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final T f32938e;

        /* renamed from: f  reason: collision with root package name */
        public final a<T> f32939f;

        /* renamed from: g  reason: collision with root package name */
        public final int f32940g;

        /* renamed from: h  reason: collision with root package name */
        public final long f32941h;

        /* renamed from: i  reason: collision with root package name */
        public IOException f32942i;
        public int j;
        public volatile Thread k;
        public volatile boolean l;
        public final /* synthetic */ Loader m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Loader loader, Looper looper, T t, a<T> aVar, int i2, long j) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {loader, looper, t, aVar, Integer.valueOf(i2), Long.valueOf(j)};
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
            this.f32938e = t;
            this.f32939f = aVar;
            this.f32940g = i2;
            this.f32941h = j;
        }

        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.l = z;
                this.f32942i = null;
                if (hasMessages(0)) {
                    removeMessages(0);
                    if (!z) {
                        sendEmptyMessage(1);
                    }
                } else {
                    this.f32938e.c();
                    if (this.k != null) {
                        this.k.interrupt();
                    }
                }
                if (z) {
                    c();
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    this.f32939f.l(this.f32938e, elapsedRealtime, elapsedRealtime - this.f32941h, true);
                }
            }
        }

        public final void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f32942i = null;
                this.m.f32935a.execute(this.m.f32936b);
            }
        }

        public final void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.m.f32936b = null;
            }
        }

        public final long d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? Math.min((this.j - 1) * 1000, 5000) : invokeV.longValue;
        }

        public void e(int i2) throws IOException {
            IOException iOException;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048580, this, i2) == null) && (iOException = this.f32942i) != null && this.j > i2) {
                throw iOException;
            }
        }

        public void f(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048581, this, j) == null) {
                d.f.b.a.i0.a.f(this.m.f32936b == null);
                this.m.f32936b = this;
                if (j > 0) {
                    sendEmptyMessageDelayed(0, j);
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
                long j = elapsedRealtime - this.f32941h;
                if (this.f32938e.b()) {
                    this.f32939f.l(this.f32938e, elapsedRealtime, j, false);
                    return;
                }
                int i3 = message.what;
                if (i3 == 1) {
                    this.f32939f.l(this.f32938e, elapsedRealtime, j, false);
                } else if (i3 == 2) {
                    try {
                        this.f32939f.m(this.f32938e, elapsedRealtime, j);
                    } catch (RuntimeException e2) {
                        Log.e("LoadTask", "Unexpected exception handling load completed", e2);
                        this.m.f32937c = new UnexpectedLoaderException(e2);
                    }
                } else if (i3 != 3) {
                } else {
                    IOException iOException = (IOException) message.obj;
                    this.f32942i = iOException;
                    int n = this.f32939f.n(this.f32938e, elapsedRealtime, j, iOException);
                    if (n == 3) {
                        this.m.f32937c = this.f32942i;
                    } else if (n != 2) {
                        this.j = n != 1 ? 1 + this.j : 1;
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
                    if (!this.f32938e.b()) {
                        t.a("load:" + this.f32938e.getClass().getSimpleName());
                        try {
                            this.f32938e.a();
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
                } catch (Error e3) {
                    Log.e("LoadTask", "Unexpected error loading stream", e3);
                    if (!this.l) {
                        obtainMessage(4, e3).sendToTarget();
                    }
                    throw e3;
                } catch (InterruptedException unused) {
                    d.f.b.a.i0.a.f(this.f32938e.b());
                    if (this.l) {
                        return;
                    }
                    sendEmptyMessage(2);
                } catch (Exception e4) {
                    Log.e("LoadTask", "Unexpected exception loading stream", e4);
                    if (this.l) {
                        return;
                    }
                    obtainMessage(3, new UnexpectedLoaderException(e4)).sendToTarget();
                } catch (OutOfMemoryError e5) {
                    Log.e("LoadTask", "OutOfMemory error loading stream", e5);
                    if (this.l) {
                        return;
                    }
                    obtainMessage(3, new UnexpectedLoaderException(e5)).sendToTarget();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        void a() throws IOException, InterruptedException;

        boolean b();

        void c();
    }

    /* loaded from: classes5.dex */
    public interface d {
        void i();
    }

    /* loaded from: classes5.dex */
    public static final class e extends Handler implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final d f32943e;

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
            this.f32943e = dVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                this.f32943e.i();
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
        this.f32935a = v.B(str);
    }

    @Override // d.f.b.a.h0.n
    public void a() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            h(Integer.MIN_VALUE);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f32936b.a(false);
        }
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f32936b != null : invokeV.booleanValue;
    }

    public void h(int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            IOException iOException = this.f32937c;
            if (iOException == null) {
                b<? extends c> bVar = this.f32936b;
                if (bVar != null) {
                    if (i2 == Integer.MIN_VALUE) {
                        i2 = bVar.f32940g;
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
            b<? extends c> bVar = this.f32936b;
            boolean z = true;
            if (bVar != null) {
                bVar.a(true);
                if (dVar != null) {
                    this.f32935a.execute(new e(dVar));
                }
            } else if (dVar != null) {
                dVar.i();
                this.f32935a.shutdown();
                return z;
            }
            z = false;
            this.f32935a.shutdown();
            return z;
        }
        return invokeL.booleanValue;
    }

    public <T extends c> long k(T t, a<T> aVar, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048582, this, t, aVar, i2)) == null) {
            Looper myLooper = Looper.myLooper();
            d.f.b.a.i0.a.f(myLooper != null);
            long elapsedRealtime = SystemClock.elapsedRealtime();
            new b(this, myLooper, t, aVar, i2, elapsedRealtime).f(0L);
            return elapsedRealtime;
        }
        return invokeLLI.longValue;
    }
}
