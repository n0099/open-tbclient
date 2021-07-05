package io.reactivex.internal.operators.maybe;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiPredicate;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes10.dex */
public final class MaybeEqualSingle<T> extends Single<Boolean> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BiPredicate<? super T, ? super T> isEqual;
    public final MaybeSource<? extends T> source1;
    public final MaybeSource<? extends T> source2;

    /* loaded from: classes10.dex */
    public static final class EqualCoordinator<T> extends AtomicInteger implements Disposable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final SingleObserver<? super Boolean> actual;
        public final BiPredicate<? super T, ? super T> isEqual;
        public final EqualObserver<T> observer1;
        public final EqualObserver<T> observer2;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public EqualCoordinator(SingleObserver<? super Boolean> singleObserver, BiPredicate<? super T, ? super T> biPredicate) {
            super(2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {singleObserver, biPredicate};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.actual = singleObserver;
            this.isEqual = biPredicate;
            this.observer1 = new EqualObserver<>(this);
            this.observer2 = new EqualObserver<>(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.observer1.dispose();
                this.observer2.dispose();
            }
        }

        public void done() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && decrementAndGet() == 0) {
                Object obj = this.observer1.value;
                Object obj2 = this.observer2.value;
                if (obj != null && obj2 != null) {
                    try {
                        this.actual.onSuccess(Boolean.valueOf(this.isEqual.test(obj, obj2)));
                        return;
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        this.actual.onError(th);
                        return;
                    }
                }
                this.actual.onSuccess(Boolean.valueOf(obj == null && obj2 == null));
            }
        }

        public void error(EqualObserver<T> equalObserver, Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, equalObserver, th) == null) {
                if (getAndSet(0) > 0) {
                    EqualObserver<T> equalObserver2 = this.observer1;
                    if (equalObserver == equalObserver2) {
                        this.observer2.dispose();
                    } else {
                        equalObserver2.dispose();
                    }
                    this.actual.onError(th);
                    return;
                }
                RxJavaPlugins.onError(th);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? DisposableHelper.isDisposed(this.observer1.get()) : invokeV.booleanValue;
        }

        public void subscribe(MaybeSource<? extends T> maybeSource, MaybeSource<? extends T> maybeSource2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, maybeSource, maybeSource2) == null) {
                maybeSource.subscribe(this.observer1);
                maybeSource2.subscribe(this.observer2);
            }
        }
    }

    /* loaded from: classes10.dex */
    public static final class EqualObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T> {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -3031974433025990931L;
        public transient /* synthetic */ FieldHolder $fh;
        public final EqualCoordinator<T> parent;
        public Object value;

        public EqualObserver(EqualCoordinator<T> equalCoordinator) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {equalCoordinator};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.parent = equalCoordinator;
        }

        public void dispose() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                DisposableHelper.dispose(this);
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.parent.done();
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                this.parent.error(this, th);
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onSubscribe(Disposable disposable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, disposable) == null) {
                DisposableHelper.setOnce(this, disposable);
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, t) == null) {
                this.value = t;
                this.parent.done();
            }
        }
    }

    public MaybeEqualSingle(MaybeSource<? extends T> maybeSource, MaybeSource<? extends T> maybeSource2, BiPredicate<? super T, ? super T> biPredicate) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {maybeSource, maybeSource2, biPredicate};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.source1 = maybeSource;
        this.source2 = maybeSource2;
        this.isEqual = biPredicate;
    }

    @Override // io.reactivex.Single
    public void subscribeActual(SingleObserver<? super Boolean> singleObserver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, singleObserver) == null) {
            EqualCoordinator equalCoordinator = new EqualCoordinator(singleObserver, this.isEqual);
            singleObserver.onSubscribe(equalCoordinator);
            equalCoordinator.subscribe(this.source1, this.source2);
        }
    }
}
