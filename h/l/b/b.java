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
/* loaded from: classes2.dex */
public class b extends g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Handler f71880a;

    /* loaded from: classes2.dex */
    public static class a extends g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final Handler f71881e;

        /* renamed from: f  reason: collision with root package name */
        public final h.l.a.b f71882f;

        /* renamed from: g  reason: collision with root package name */
        public volatile boolean f71883g;

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
            this.f71881e = handler;
            this.f71882f = h.l.a.a.a().b();
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
                if (this.f71883g) {
                    return e.c();
                }
                this.f71882f.c(aVar);
                RunnableC2050b runnableC2050b = new RunnableC2050b(aVar, this.f71881e);
                Message obtain = Message.obtain(this.f71881e, runnableC2050b);
                obtain.obj = this;
                this.f71881e.sendMessageDelayed(obtain, timeUnit.toMillis(j));
                if (this.f71883g) {
                    this.f71881e.removeCallbacks(runnableC2050b);
                    return e.c();
                }
                return runnableC2050b;
            }
            return (k) invokeCommon.objValue;
        }

        @Override // h.k
        public boolean isUnsubscribed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f71883g : invokeV.booleanValue;
        }

        @Override // h.k
        public void unsubscribe() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.f71883g = true;
                this.f71881e.removeCallbacksAndMessages(this);
            }
        }
    }

    /* renamed from: h.l.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class RunnableC2050b implements Runnable, k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final h.n.a f71884e;

        /* renamed from: f  reason: collision with root package name */
        public final Handler f71885f;

        /* renamed from: g  reason: collision with root package name */
        public volatile boolean f71886g;

        public RunnableC2050b(h.n.a aVar, Handler handler) {
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
            this.f71884e = aVar;
            this.f71885f = handler;
        }

        @Override // h.k
        public boolean isUnsubscribed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f71886g : invokeV.booleanValue;
        }

        @Override // java.lang.Runnable
        public void run() {
            IllegalStateException illegalStateException;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                try {
                    this.f71884e.call();
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
                this.f71886g = true;
                this.f71885f.removeCallbacks(this);
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
        this.f71880a = new Handler(looper);
    }

    @Override // h.g
    public g.a createWorker() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new a(this.f71880a) : (g.a) invokeV.objValue;
    }
}
