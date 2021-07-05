package h.l.b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import h.g;
import h.k;
import h.r.f;
import h.u.e;
import java.util.concurrent.TimeUnit;
import rx.exceptions.OnErrorNotImplementedException;
/* loaded from: classes10.dex */
public class b extends g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Handler f75388a;

    /* loaded from: classes10.dex */
    public static class a extends g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final Handler f75389e;

        /* renamed from: f  reason: collision with root package name */
        public final h.l.a.b f75390f;

        /* renamed from: g  reason: collision with root package name */
        public volatile boolean f75391g;

        public a(Handler handler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {handler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f75389e = handler;
            this.f75390f = h.l.a.a.a().b();
        }

        @Override // h.g.a
        public k b(h.n.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) ? c(aVar, 0L, TimeUnit.MILLISECONDS) : (k) invokeL.objValue;
        }

        @Override // h.g.a
        public k c(h.n.a aVar, long j, TimeUnit timeUnit) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{aVar, Long.valueOf(j), timeUnit})) == null) {
                if (this.f75391g) {
                    return e.c();
                }
                this.f75390f.c(aVar);
                RunnableC2094b runnableC2094b = new RunnableC2094b(aVar, this.f75389e);
                Message obtain = Message.obtain(this.f75389e, runnableC2094b);
                obtain.obj = this;
                this.f75389e.sendMessageDelayed(obtain, timeUnit.toMillis(j));
                if (this.f75391g) {
                    this.f75389e.removeCallbacks(runnableC2094b);
                    return e.c();
                }
                return runnableC2094b;
            }
            return (k) invokeCommon.objValue;
        }

        @Override // h.k
        public boolean isUnsubscribed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f75391g : invokeV.booleanValue;
        }

        @Override // h.k
        public void unsubscribe() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.f75391g = true;
                this.f75389e.removeCallbacksAndMessages(this);
            }
        }
    }

    /* renamed from: h.l.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static final class RunnableC2094b implements Runnable, k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final h.n.a f75392e;

        /* renamed from: f  reason: collision with root package name */
        public final Handler f75393f;

        /* renamed from: g  reason: collision with root package name */
        public volatile boolean f75394g;

        public RunnableC2094b(h.n.a aVar, Handler handler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, handler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f75392e = aVar;
            this.f75393f = handler;
        }

        @Override // h.k
        public boolean isUnsubscribed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f75394g : invokeV.booleanValue;
        }

        @Override // java.lang.Runnable
        public void run() {
            IllegalStateException illegalStateException;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                try {
                    this.f75392e.call();
                } catch (Throwable th) {
                    if (th instanceof OnErrorNotImplementedException) {
                        illegalStateException = new IllegalStateException("Exception thrown on Scheduler.Worker thread. Add `onError` handling.", th);
                    } else {
                        illegalStateException = new IllegalStateException("Fatal Exception thrown on Scheduler.Worker thread.", th);
                    }
                    f.c().b().a(illegalStateException);
                    Thread currentThread = Thread.currentThread();
                    currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, illegalStateException);
                }
            }
        }

        @Override // h.k
        public void unsubscribe() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f75394g = true;
                this.f75393f.removeCallbacks(this);
            }
        }
    }

    public b(Looper looper) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {looper};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f75388a = new Handler(looper);
    }

    @Override // h.g
    public g.a createWorker() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new a(this.f75388a) : (g.a) invokeV.objValue;
    }
}
