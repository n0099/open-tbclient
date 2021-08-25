package i.l.b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import i.g;
import i.k;
import i.r.f;
import i.u.e;
import java.util.concurrent.TimeUnit;
import rx.exceptions.OnErrorNotImplementedException;
/* loaded from: classes10.dex */
public class b extends g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Handler f78355a;

    /* loaded from: classes10.dex */
    public static class a extends g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final Handler f78356e;

        /* renamed from: f  reason: collision with root package name */
        public final i.l.a.b f78357f;

        /* renamed from: g  reason: collision with root package name */
        public volatile boolean f78358g;

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
            this.f78356e = handler;
            this.f78357f = i.l.a.a.a().b();
        }

        @Override // i.g.a
        public k b(i.n.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) ? c(aVar, 0L, TimeUnit.MILLISECONDS) : (k) invokeL.objValue;
        }

        @Override // i.g.a
        public k c(i.n.a aVar, long j2, TimeUnit timeUnit) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{aVar, Long.valueOf(j2), timeUnit})) == null) {
                if (this.f78358g) {
                    return e.c();
                }
                this.f78357f.c(aVar);
                RunnableC2117b runnableC2117b = new RunnableC2117b(aVar, this.f78356e);
                Message obtain = Message.obtain(this.f78356e, runnableC2117b);
                obtain.obj = this;
                this.f78356e.sendMessageDelayed(obtain, timeUnit.toMillis(j2));
                if (this.f78358g) {
                    this.f78356e.removeCallbacks(runnableC2117b);
                    return e.c();
                }
                return runnableC2117b;
            }
            return (k) invokeCommon.objValue;
        }

        @Override // i.k
        public boolean isUnsubscribed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f78358g : invokeV.booleanValue;
        }

        @Override // i.k
        public void unsubscribe() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.f78358g = true;
                this.f78356e.removeCallbacksAndMessages(this);
            }
        }
    }

    /* renamed from: i.l.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static final class RunnableC2117b implements Runnable, k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final i.n.a f78359e;

        /* renamed from: f  reason: collision with root package name */
        public final Handler f78360f;

        /* renamed from: g  reason: collision with root package name */
        public volatile boolean f78361g;

        public RunnableC2117b(i.n.a aVar, Handler handler) {
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
            this.f78359e = aVar;
            this.f78360f = handler;
        }

        @Override // i.k
        public boolean isUnsubscribed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f78361g : invokeV.booleanValue;
        }

        @Override // java.lang.Runnable
        public void run() {
            IllegalStateException illegalStateException;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                try {
                    this.f78359e.call();
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

        @Override // i.k
        public void unsubscribe() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f78361g = true;
                this.f78360f.removeCallbacks(this);
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
        this.f78355a = new Handler(looper);
    }

    @Override // i.g
    public g.a createWorker() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new a(this.f78355a) : (g.a) invokeV.objValue;
    }
}
