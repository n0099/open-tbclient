package io.reactivex.internal.operators.completable;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public final class CompletableDelay extends Completable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final long delay;
    public final boolean delayError;
    public final Scheduler scheduler;
    public final CompletableSource source;
    public final TimeUnit unit;

    /* loaded from: classes2.dex */
    public final class Delay implements CompletableObserver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final CompletableObserver s;
        public final CompositeDisposable set;
        public final /* synthetic */ CompletableDelay this$0;

        /* loaded from: classes2.dex */
        public final class OnComplete implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Delay this$1;

            public OnComplete(Delay delay) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {delay};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$1 = delay;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.this$1.s.onComplete();
                }
            }
        }

        /* loaded from: classes2.dex */
        public final class OnError implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final Throwable f73405e;
            public final /* synthetic */ Delay this$1;

            public OnError(Delay delay, Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {delay, th};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$1 = delay;
                this.f73405e = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.this$1.s.onError(this.f73405e);
                }
            }
        }

        public Delay(CompletableDelay completableDelay, CompositeDisposable compositeDisposable, CompletableObserver completableObserver) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {completableDelay, compositeDisposable, completableObserver};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = completableDelay;
            this.set = compositeDisposable;
            this.s = completableObserver;
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                CompositeDisposable compositeDisposable = this.set;
                Scheduler scheduler = this.this$0.scheduler;
                OnComplete onComplete = new OnComplete(this);
                CompletableDelay completableDelay = this.this$0;
                compositeDisposable.add(scheduler.scheduleDirect(onComplete, completableDelay.delay, completableDelay.unit));
            }
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                CompositeDisposable compositeDisposable = this.set;
                Scheduler scheduler = this.this$0.scheduler;
                OnError onError = new OnError(this, th);
                CompletableDelay completableDelay = this.this$0;
                compositeDisposable.add(scheduler.scheduleDirect(onError, completableDelay.delayError ? completableDelay.delay : 0L, this.this$0.unit));
            }
        }

        @Override // io.reactivex.CompletableObserver
        public void onSubscribe(Disposable disposable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, disposable) == null) {
                this.set.add(disposable);
                this.s.onSubscribe(this.set);
            }
        }
    }

    public CompletableDelay(CompletableSource completableSource, long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {completableSource, Long.valueOf(j), timeUnit, scheduler, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.source = completableSource;
        this.delay = j;
        this.unit = timeUnit;
        this.scheduler = scheduler;
        this.delayError = z;
    }

    @Override // io.reactivex.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, completableObserver) == null) {
            this.source.subscribe(new Delay(this, new CompositeDisposable(), completableObserver));
        }
    }
}
