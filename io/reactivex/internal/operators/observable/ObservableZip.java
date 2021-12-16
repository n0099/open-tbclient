package io.reactivex.internal.operators.observable;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes4.dex */
public final class ObservableZip<T, R> extends Observable<R> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int bufferSize;
    public final boolean delayError;
    public final ObservableSource<? extends T>[] sources;
    public final Iterable<? extends ObservableSource<? extends T>> sourcesIterable;
    public final Function<? super Object[], ? extends R> zipper;

    /* loaded from: classes4.dex */
    public static final class ZipCoordinator<T, R> extends AtomicInteger implements Disposable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 2983708048395377667L;
        public transient /* synthetic */ FieldHolder $fh;
        public final Observer<? super R> actual;
        public volatile boolean cancelled;
        public final boolean delayError;
        public final ZipObserver<T, R>[] observers;
        public final T[] row;
        public final Function<? super Object[], ? extends R> zipper;

        public ZipCoordinator(Observer<? super R> observer, Function<? super Object[], ? extends R> function, int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {observer, function, Integer.valueOf(i2), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.actual = observer;
            this.zipper = function;
            this.observers = new ZipObserver[i2];
            this.row = (T[]) new Object[i2];
            this.delayError = z;
        }

        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                clear();
                cancelSources();
            }
        }

        public void cancelSources() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                for (ZipObserver<T, R> zipObserver : this.observers) {
                    zipObserver.dispose();
                }
            }
        }

        public boolean checkTerminated(boolean z, boolean z2, Observer<? super R> observer, boolean z3, ZipObserver<?, ?> zipObserver) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), observer, Boolean.valueOf(z3), zipObserver})) == null) {
                if (this.cancelled) {
                    cancel();
                    return true;
                } else if (z) {
                    if (z3) {
                        if (z2) {
                            Throwable th = zipObserver.error;
                            cancel();
                            if (th != null) {
                                observer.onError(th);
                            } else {
                                observer.onComplete();
                            }
                            return true;
                        }
                        return false;
                    }
                    Throwable th2 = zipObserver.error;
                    if (th2 != null) {
                        cancel();
                        observer.onError(th2);
                        return true;
                    } else if (z2) {
                        cancel();
                        observer.onComplete();
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
            return invokeCommon.booleanValue;
        }

        public void clear() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                for (ZipObserver<T, R> zipObserver : this.observers) {
                    zipObserver.queue.clear();
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.cancelled) {
                return;
            }
            this.cancelled = true;
            cancelSources();
            if (getAndIncrement() == 0) {
                clear();
            }
        }

        public void drain() {
            Throwable th;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048581, this) != null) || getAndIncrement() != 0) {
                return;
            }
            ZipObserver<T, R>[] zipObserverArr = this.observers;
            Observer<? super R> observer = this.actual;
            T[] tArr = this.row;
            boolean z = this.delayError;
            int i2 = 1;
            while (true) {
                int i3 = 0;
                int i4 = 0;
                for (ZipObserver<T, R> zipObserver : zipObserverArr) {
                    if (tArr[i4] == null) {
                        boolean z2 = zipObserver.done;
                        T poll = zipObserver.queue.poll();
                        boolean z3 = poll == null;
                        if (checkTerminated(z2, z3, observer, z, zipObserver)) {
                            return;
                        }
                        if (z3) {
                            i3++;
                        } else {
                            tArr[i4] = poll;
                        }
                    } else if (zipObserver.done && !z && (th = zipObserver.error) != null) {
                        cancel();
                        observer.onError(th);
                        return;
                    }
                    i4++;
                }
                if (i3 != 0) {
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                } else {
                    try {
                        observer.onNext((Object) ObjectHelper.requireNonNull(this.zipper.apply(tArr.clone()), "The zipper returned a null value"));
                        Arrays.fill(tArr, (Object) null);
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        cancel();
                        observer.onError(th2);
                        return;
                    }
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.cancelled : invokeV.booleanValue;
        }

        public void subscribe(ObservableSource<? extends T>[] observableSourceArr, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048583, this, observableSourceArr, i2) == null) {
                ZipObserver<T, R>[] zipObserverArr = this.observers;
                int length = zipObserverArr.length;
                for (int i3 = 0; i3 < length; i3++) {
                    zipObserverArr[i3] = new ZipObserver<>(this, i2);
                }
                lazySet(0);
                this.actual.onSubscribe(this);
                for (int i4 = 0; i4 < length && !this.cancelled; i4++) {
                    observableSourceArr[i4].subscribe(zipObserverArr[i4]);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class ZipObserver<T, R> implements Observer<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile boolean done;
        public Throwable error;
        public final ZipCoordinator<T, R> parent;
        public final SpscLinkedArrayQueue<T> queue;
        public final AtomicReference<Disposable> s;

        public ZipObserver(ZipCoordinator<T, R> zipCoordinator, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zipCoordinator, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.s = new AtomicReference<>();
            this.parent = zipCoordinator;
            this.queue = new SpscLinkedArrayQueue<>(i2);
        }

        public void dispose() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                DisposableHelper.dispose(this.s);
            }
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.done = true;
                this.parent.drain();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                this.error = th;
                this.done = true;
                this.parent.drain();
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, t) == null) {
                this.queue.offer(t);
                this.parent.drain();
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, disposable) == null) {
                DisposableHelper.setOnce(this.s, disposable);
            }
        }
    }

    public ObservableZip(ObservableSource<? extends T>[] observableSourceArr, Iterable<? extends ObservableSource<? extends T>> iterable, Function<? super Object[], ? extends R> function, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {observableSourceArr, iterable, function, Integer.valueOf(i2), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.sources = observableSourceArr;
        this.sourcesIterable = iterable;
        this.zipper = function;
        this.bufferSize = i2;
        this.delayError = z;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super R> observer) {
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, observer) == null) {
            ObservableSource<? extends T>[] observableSourceArr = this.sources;
            if (observableSourceArr == null) {
                observableSourceArr = new Observable[8];
                length = 0;
                for (ObservableSource<? extends T> observableSource : this.sourcesIterable) {
                    if (length == observableSourceArr.length) {
                        ObservableSource<? extends T>[] observableSourceArr2 = new ObservableSource[(length >> 2) + length];
                        System.arraycopy(observableSourceArr, 0, observableSourceArr2, 0, length);
                        observableSourceArr = observableSourceArr2;
                    }
                    observableSourceArr[length] = observableSource;
                    length++;
                }
            } else {
                length = observableSourceArr.length;
            }
            if (length == 0) {
                EmptyDisposable.complete(observer);
            } else {
                new ZipCoordinator(observer, this.zipper, length, this.delayError).subscribe(observableSourceArr, this.bufferSize);
            }
        }
    }
}
