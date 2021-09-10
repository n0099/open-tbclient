package io.reactivex.internal.operators.single;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.annotations.Nullable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import java.util.Iterator;
/* loaded from: classes2.dex */
public final class SingleFlatMapIterableObservable<T, R> extends Observable<R> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Function<? super T, ? extends Iterable<? extends R>> mapper;
    public final SingleSource<T> source;

    /* loaded from: classes2.dex */
    public static final class FlatMapIterableObserver<T, R> extends BasicIntQueueDisposable<R> implements SingleObserver<T> {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -8938804753851907758L;
        public transient /* synthetic */ FieldHolder $fh;
        public final Observer<? super R> actual;
        public volatile boolean cancelled;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f79015d;
        public volatile Iterator<? extends R> it;
        public final Function<? super T, ? extends Iterable<? extends R>> mapper;
        public boolean outputFused;

        public FlatMapIterableObserver(Observer<? super R> observer, Function<? super T, ? extends Iterable<? extends R>> function) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {observer, function};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.actual = observer;
            this.mapper = function;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.it = null;
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.cancelled = true;
                this.f79015d.dispose();
                this.f79015d = DisposableHelper.DISPOSED;
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.cancelled : invokeV.booleanValue;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.it == null : invokeV.booleanValue;
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, th) == null) {
                this.f79015d = DisposableHelper.DISPOSED;
                this.actual.onError(th);
            }
        }

        @Override // io.reactivex.SingleObserver
        public void onSubscribe(Disposable disposable) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048581, this, disposable) == null) && DisposableHelper.validate(this.f79015d, disposable)) {
                this.f79015d = disposable;
                this.actual.onSubscribe(this);
            }
        }

        /* JADX DEBUG: Type inference failed for r1v4. Raw type applied. Possible types: R, ? super R */
        @Override // io.reactivex.SingleObserver
        public void onSuccess(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, t) == null) {
                Observer<? super R> observer = this.actual;
                try {
                    Iterator<? extends R> it = this.mapper.apply(t).iterator();
                    if (!it.hasNext()) {
                        observer.onComplete();
                    } else if (this.outputFused) {
                        this.it = it;
                        observer.onNext(null);
                        observer.onComplete();
                    } else {
                        while (!this.cancelled) {
                            try {
                                observer.onNext((R) it.next());
                                if (this.cancelled) {
                                    return;
                                }
                                try {
                                    if (!it.hasNext()) {
                                        observer.onComplete();
                                        return;
                                    }
                                } catch (Throwable th) {
                                    Exceptions.throwIfFatal(th);
                                    observer.onError(th);
                                    return;
                                }
                            } catch (Throwable th2) {
                                Exceptions.throwIfFatal(th2);
                                observer.onError(th2);
                                return;
                            }
                        }
                    }
                } catch (Throwable th3) {
                    Exceptions.throwIfFatal(th3);
                    this.actual.onError(th3);
                }
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        @Nullable
        public R poll() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                Iterator<? extends R> it = this.it;
                if (it != null) {
                    R r = (R) ObjectHelper.requireNonNull(it.next(), "The iterator returned a null value");
                    if (!it.hasNext()) {
                        this.it = null;
                    }
                    return r;
                }
                return null;
            }
            return (R) invokeV.objValue;
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
                if ((i2 & 2) != 0) {
                    this.outputFused = true;
                    return 2;
                }
                return 0;
            }
            return invokeI.intValue;
        }
    }

    public SingleFlatMapIterableObservable(SingleSource<T> singleSource, Function<? super T, ? extends Iterable<? extends R>> function) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {singleSource, function};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.source = singleSource;
        this.mapper = function;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super R> observer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, observer) == null) {
            this.source.subscribe(new FlatMapIterableObserver(observer, this.mapper));
        }
    }
}
