package io.reactivex.internal.operators.single;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes8.dex */
public final class SingleTimeout extends Single {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final SingleSource other;
    public final Scheduler scheduler;
    public final SingleSource source;
    public final long timeout;
    public final TimeUnit unit;

    /* loaded from: classes8.dex */
    public final class TimeoutMainObserver extends AtomicReference implements SingleObserver, Runnable, Disposable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 37497744973048446L;
        public transient /* synthetic */ FieldHolder $fh;
        public final SingleObserver actual;
        public final TimeoutFallbackObserver fallback;
        public SingleSource other;
        public final AtomicReference task;

        /* loaded from: classes8.dex */
        public final class TimeoutFallbackObserver extends AtomicReference implements SingleObserver {
            public static /* synthetic */ Interceptable $ic = null;
            public static final long serialVersionUID = 2071387740092105509L;
            public transient /* synthetic */ FieldHolder $fh;
            public final SingleObserver actual;

            public TimeoutFallbackObserver(SingleObserver singleObserver) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {singleObserver};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.actual = singleObserver;
            }

            @Override // io.reactivex.SingleObserver
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                    this.actual.onError(th);
                }
            }

            @Override // io.reactivex.SingleObserver
            public void onSubscribe(Disposable disposable) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, disposable) == null) {
                    DisposableHelper.setOnce(this, disposable);
                }
            }

            @Override // io.reactivex.SingleObserver
            public void onSuccess(Object obj) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
                    this.actual.onSuccess(obj);
                }
            }
        }

        public TimeoutMainObserver(SingleObserver singleObserver, SingleSource singleSource) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {singleObserver, singleSource};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.actual = singleObserver;
            this.other = singleSource;
            this.task = new AtomicReference();
            if (singleSource != null) {
                this.fallback = new TimeoutFallbackObserver(singleObserver);
            } else {
                this.fallback = null;
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                DisposableHelper.dispose(this);
                DisposableHelper.dispose(this.task);
                TimeoutFallbackObserver timeoutFallbackObserver = this.fallback;
                if (timeoutFallbackObserver != null) {
                    DisposableHelper.dispose(timeoutFallbackObserver);
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return DisposableHelper.isDisposed((Disposable) get());
            }
            return invokeV.booleanValue;
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                Disposable disposable = (Disposable) get();
                DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
                if (disposable != disposableHelper && compareAndSet(disposable, disposableHelper)) {
                    DisposableHelper.dispose(this.task);
                    this.actual.onError(th);
                    return;
                }
                RxJavaPlugins.onError(th);
            }
        }

        @Override // io.reactivex.SingleObserver
        public void onSubscribe(Disposable disposable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, disposable) == null) {
                DisposableHelper.setOnce(this, disposable);
            }
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(Object obj) {
            Disposable disposable;
            DisposableHelper disposableHelper;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048580, this, obj) == null) && (disposable = (Disposable) get()) != (disposableHelper = DisposableHelper.DISPOSED) && compareAndSet(disposable, disposableHelper)) {
                DisposableHelper.dispose(this.task);
                this.actual.onSuccess(obj);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Disposable disposable;
            DisposableHelper disposableHelper;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (disposable = (Disposable) get()) != (disposableHelper = DisposableHelper.DISPOSED) && compareAndSet(disposable, disposableHelper)) {
                if (disposable != null) {
                    disposable.dispose();
                }
                SingleSource singleSource = this.other;
                if (singleSource == null) {
                    this.actual.onError(new TimeoutException());
                    return;
                }
                this.other = null;
                singleSource.subscribe(this.fallback);
            }
        }
    }

    public SingleTimeout(SingleSource singleSource, long j, TimeUnit timeUnit, Scheduler scheduler, SingleSource singleSource2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {singleSource, Long.valueOf(j), timeUnit, scheduler, singleSource2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.source = singleSource;
        this.timeout = j;
        this.unit = timeUnit;
        this.scheduler = scheduler;
        this.other = singleSource2;
    }

    @Override // io.reactivex.Single
    public void subscribeActual(SingleObserver singleObserver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, singleObserver) == null) {
            TimeoutMainObserver timeoutMainObserver = new TimeoutMainObserver(singleObserver, this.other);
            singleObserver.onSubscribe(timeoutMainObserver);
            DisposableHelper.replace(timeoutMainObserver.task, this.scheduler.scheduleDirect(timeoutMainObserver, this.timeout, this.unit));
            this.source.subscribe(timeoutMainObserver);
        }
    }
}
