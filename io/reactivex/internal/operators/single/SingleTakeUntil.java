package io.reactivex.internal.operators.single;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;
/* loaded from: classes8.dex */
public final class SingleTakeUntil extends Single {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Publisher other;
    public final SingleSource source;

    /* loaded from: classes8.dex */
    public final class TakeUntilMainObserver extends AtomicReference implements SingleObserver, Disposable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -622603812305745221L;
        public transient /* synthetic */ FieldHolder $fh;
        public final SingleObserver actual;
        public final TakeUntilOtherSubscriber other;

        public TakeUntilMainObserver(SingleObserver singleObserver) {
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
            this.other = new TakeUntilOtherSubscriber(this);
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
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return DisposableHelper.isDisposed((Disposable) get());
            }
            return invokeV.booleanValue;
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                this.other.dispose();
                Disposable disposable = (Disposable) get();
                DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
                if (disposable != disposableHelper && ((Disposable) getAndSet(disposableHelper)) != DisposableHelper.DISPOSED) {
                    this.actual.onError(th);
                } else {
                    RxJavaPlugins.onError(th);
                }
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
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, obj) == null) {
                this.other.dispose();
                if (((Disposable) getAndSet(DisposableHelper.DISPOSED)) != DisposableHelper.DISPOSED) {
                    this.actual.onSuccess(obj);
                }
            }
        }

        public void otherError(Throwable th) {
            Disposable disposable;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, th) == null) {
                Disposable disposable2 = (Disposable) get();
                DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
                if (disposable2 != disposableHelper && (disposable = (Disposable) getAndSet(disposableHelper)) != DisposableHelper.DISPOSED) {
                    if (disposable != null) {
                        disposable.dispose();
                    }
                    this.actual.onError(th);
                    return;
                }
                RxJavaPlugins.onError(th);
            }
        }
    }

    /* loaded from: classes8.dex */
    public final class TakeUntilOtherSubscriber extends AtomicReference implements FlowableSubscriber {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 5170026210238877381L;
        public transient /* synthetic */ FieldHolder $fh;
        public final TakeUntilMainObserver parent;

        public TakeUntilOtherSubscriber(TakeUntilMainObserver takeUntilMainObserver) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {takeUntilMainObserver};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.parent = takeUntilMainObserver;
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                this.parent.otherError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048579, this, obj) == null) && SubscriptionHelper.cancel(this)) {
                this.parent.otherError(new CancellationException());
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, subscription) == null) {
                SubscriptionHelper.setOnce(this, subscription, Long.MAX_VALUE);
            }
        }

        public void dispose() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SubscriptionHelper.cancel(this);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                Object obj = get();
                SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
                if (obj != subscriptionHelper) {
                    lazySet(subscriptionHelper);
                    this.parent.otherError(new CancellationException());
                }
            }
        }
    }

    public SingleTakeUntil(SingleSource singleSource, Publisher publisher) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {singleSource, publisher};
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
        this.other = publisher;
    }

    @Override // io.reactivex.Single
    public void subscribeActual(SingleObserver singleObserver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, singleObserver) == null) {
            TakeUntilMainObserver takeUntilMainObserver = new TakeUntilMainObserver(singleObserver);
            singleObserver.onSubscribe(takeUntilMainObserver);
            this.other.subscribe(takeUntilMainObserver.other);
            this.source.subscribe(takeUntilMainObserver);
        }
    }
}
