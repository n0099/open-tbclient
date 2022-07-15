package com.repackage;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.xr9;
import java.util.concurrent.TimeUnit;
import rx.exceptions.OnErrorNotImplementedException;
/* loaded from: classes6.dex */
public class fs9 extends xr9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Handler a;

    /* loaded from: classes6.dex */
    public static class a extends xr9.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Handler a;
        public final ds9 b;
        public volatile boolean c;

        public a(Handler handler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {handler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = handler;
            this.b = cs9.a().b();
        }

        @Override // com.repackage.xr9.a
        public bs9 b(hs9 hs9Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, hs9Var)) == null) ? c(hs9Var, 0L, TimeUnit.MILLISECONDS) : (bs9) invokeL.objValue;
        }

        @Override // com.repackage.xr9.a
        public bs9 c(hs9 hs9Var, long j, TimeUnit timeUnit) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{hs9Var, Long.valueOf(j), timeUnit})) == null) {
                if (this.c) {
                    return rw9.c();
                }
                this.b.c(hs9Var);
                b bVar = new b(hs9Var, this.a);
                Message obtain = Message.obtain(this.a, bVar);
                obtain.obj = this;
                this.a.sendMessageDelayed(obtain, timeUnit.toMillis(j));
                if (this.c) {
                    this.a.removeCallbacks(bVar);
                    return rw9.c();
                }
                return bVar;
            }
            return (bs9) invokeCommon.objValue;
        }

        @Override // com.repackage.bs9
        public boolean isUnsubscribed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.c : invokeV.booleanValue;
        }

        @Override // com.repackage.bs9
        public void unsubscribe() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.c = true;
                this.a.removeCallbacksAndMessages(this);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class b implements Runnable, bs9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final hs9 a;
        public final Handler b;
        public volatile boolean c;

        public b(hs9 hs9Var, Handler handler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hs9Var, handler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hs9Var;
            this.b = handler;
        }

        @Override // com.repackage.bs9
        public boolean isUnsubscribed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.c : invokeV.booleanValue;
        }

        @Override // java.lang.Runnable
        public void run() {
            IllegalStateException illegalStateException;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                try {
                    this.a.call();
                } catch (Throwable th) {
                    if (th instanceof OnErrorNotImplementedException) {
                        illegalStateException = new IllegalStateException("Exception thrown on Scheduler.Worker thread. Add `onError` handling.", th);
                    } else {
                        illegalStateException = new IllegalStateException("Fatal Exception thrown on Scheduler.Worker thread.", th);
                    }
                    ew9.c().b().a(illegalStateException);
                    Thread currentThread = Thread.currentThread();
                    currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, illegalStateException);
                }
            }
        }

        @Override // com.repackage.bs9
        public void unsubscribe() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.c = true;
                this.b.removeCallbacks(this);
            }
        }
    }

    public fs9(Looper looper) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {looper};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new Handler(looper);
    }

    @Override // com.repackage.xr9
    public xr9.a createWorker() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new a(this.a) : (xr9.a) invokeV.objValue;
    }
}
