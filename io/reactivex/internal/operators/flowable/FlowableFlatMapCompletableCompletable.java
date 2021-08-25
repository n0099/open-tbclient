package io.reactivex.internal.operators.flowable;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;
/* loaded from: classes2.dex */
public final class FlowableFlatMapCompletableCompletable<T> extends Completable implements FuseToFlowable<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean delayErrors;
    public final Function<? super T, ? extends CompletableSource> mapper;
    public final int maxConcurrency;
    public final Flowable<T> source;

    /* loaded from: classes2.dex */
    public static final class FlatMapCompletableMainSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Disposable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 8443155186132538303L;
        public transient /* synthetic */ FieldHolder $fh;
        public final CompletableObserver actual;
        public final boolean delayErrors;
        public volatile boolean disposed;
        public final AtomicThrowable errors;
        public final Function<? super T, ? extends CompletableSource> mapper;
        public final int maxConcurrency;
        public Subscription s;
        public final CompositeDisposable set;

        /* loaded from: classes2.dex */
        public final class InnerObserver extends AtomicReference<Disposable> implements CompletableObserver, Disposable {
            public static /* synthetic */ Interceptable $ic = null;
            public static final long serialVersionUID = 8606673141535671828L;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ FlatMapCompletableMainSubscriber this$0;

            public InnerObserver(FlatMapCompletableMainSubscriber flatMapCompletableMainSubscriber) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {flatMapCompletableMainSubscriber};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = flatMapCompletableMainSubscriber;
            }

            @Override // io.reactivex.disposables.Disposable
            public void dispose() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    DisposableHelper.dispose(this);
                }
            }

            @Override // io.reactivex.disposables.Disposable
            public boolean isDisposed() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? DisposableHelper.isDisposed(get()) : invokeV.booleanValue;
            }

            @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
            public void onComplete() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.this$0.innerComplete(this);
                }
            }

            @Override // io.reactivex.CompletableObserver
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, th) == null) {
                    this.this$0.innerError(this, th);
                }
            }

            @Override // io.reactivex.CompletableObserver
            public void onSubscribe(Disposable disposable) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048580, this, disposable) == null) {
                    DisposableHelper.setOnce(this, disposable);
                }
            }
        }

        public FlatMapCompletableMainSubscriber(CompletableObserver completableObserver, Function<? super T, ? extends CompletableSource> function, boolean z, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {completableObserver, function, Boolean.valueOf(z), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.actual = completableObserver;
            this.mapper = function;
            this.delayErrors = z;
            this.errors = new AtomicThrowable();
            this.set = new CompositeDisposable();
            this.maxConcurrency = i2;
            lazySet(1);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.disposed = true;
                this.s.cancel();
                this.set.dispose();
            }
        }

        public void innerComplete(FlatMapCompletableMainSubscriber<T>.InnerObserver innerObserver) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, innerObserver) == null) {
                this.set.delete(innerObserver);
                onComplete();
            }
        }

        public void innerError(FlatMapCompletableMainSubscriber<T>.InnerObserver innerObserver, Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, innerObserver, th) == null) {
                this.set.delete(innerObserver);
                onError(th);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.set.isDisposed() : invokeV.booleanValue;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                if (decrementAndGet() == 0) {
                    Throwable terminate = this.errors.terminate();
                    if (terminate != null) {
                        this.actual.onError(terminate);
                    } else {
                        this.actual.onComplete();
                    }
                } else if (this.maxConcurrency != Integer.MAX_VALUE) {
                    this.s.request(1L);
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, th) == null) {
                if (this.errors.addThrowable(th)) {
                    if (this.delayErrors) {
                        if (decrementAndGet() == 0) {
                            this.actual.onError(this.errors.terminate());
                            return;
                        } else if (this.maxConcurrency != Integer.MAX_VALUE) {
                            this.s.request(1L);
                            return;
                        } else {
                            return;
                        }
                    }
                    dispose();
                    if (getAndSet(0) > 0) {
                        this.actual.onError(this.errors.terminate());
                        return;
                    }
                    return;
                }
                RxJavaPlugins.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, t) == null) {
                try {
                    CompletableSource completableSource = (CompletableSource) ObjectHelper.requireNonNull(this.mapper.apply(t), "The mapper returned a null CompletableSource");
                    getAndIncrement();
                    InnerObserver innerObserver = new InnerObserver(this);
                    if (this.disposed || !this.set.add(innerObserver)) {
                        return;
                    }
                    completableSource.subscribe(innerObserver);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.s.cancel();
                    onError(th);
                }
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048583, this, subscription) == null) && SubscriptionHelper.validate(this.s, subscription)) {
                this.s = subscription;
                this.actual.onSubscribe(this);
                int i2 = this.maxConcurrency;
                if (i2 == Integer.MAX_VALUE) {
                    subscription.request(Long.MAX_VALUE);
                } else {
                    subscription.request(i2);
                }
            }
        }
    }

    public FlowableFlatMapCompletableCompletable(Flowable<T> flowable, Function<? super T, ? extends CompletableSource> function, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {flowable, function, Boolean.valueOf(z), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.source = flowable;
        this.mapper = function;
        this.delayErrors = z;
        this.maxConcurrency = i2;
    }

    @Override // io.reactivex.internal.fuseable.FuseToFlowable
    public Flowable<T> fuseToFlowable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? RxJavaPlugins.onAssembly(new FlowableFlatMapCompletable(this.source, this.mapper, this.delayErrors, this.maxConcurrency)) : (Flowable) invokeV.objValue;
    }

    @Override // io.reactivex.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, completableObserver) == null) {
            this.source.subscribe((FlowableSubscriber) new FlatMapCompletableMainSubscriber(completableObserver, this.mapper, this.delayErrors, this.maxConcurrency));
        }
    }
}
