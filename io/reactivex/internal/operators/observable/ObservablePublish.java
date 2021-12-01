package io.reactivex.internal.operators.observable;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.HasUpstreamObservableSource;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes3.dex */
public final class ObservablePublish<T> extends ConnectableObservable<T> implements HasUpstreamObservableSource<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final AtomicReference<PublishObserver<T>> current;
    public final ObservableSource<T> onSubscribe;
    public final ObservableSource<T> source;

    /* loaded from: classes3.dex */
    public static final class InnerDisposable<T> extends AtomicReference<Object> implements Disposable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -1100270633763673112L;
        public transient /* synthetic */ FieldHolder $fh;
        public final Observer<? super T> child;

        public InnerDisposable(Observer<? super T> observer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {observer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.child = observer;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            Object andSet;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (andSet = getAndSet(this)) == null || andSet == this) {
                return;
            }
            ((PublishObserver) andSet).remove(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? get() == this : invokeV.booleanValue;
        }

        public void setParent(PublishObserver<T> publishObserver) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, publishObserver) == null) || compareAndSet(null, publishObserver)) {
                return;
            }
            publishObserver.remove(this);
        }
    }

    /* loaded from: classes3.dex */
    public static final class PublishObserver<T> implements Observer<T>, Disposable {
        public static /* synthetic */ Interceptable $ic;
        public static final InnerDisposable[] EMPTY;
        public static final InnerDisposable[] TERMINATED;
        public transient /* synthetic */ FieldHolder $fh;
        public final AtomicReference<PublishObserver<T>> current;
        public final AtomicReference<InnerDisposable<T>[]> observers;
        public final AtomicReference<Disposable> s;
        public final AtomicBoolean shouldConnect;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(963557333, "Lio/reactivex/internal/operators/observable/ObservablePublish$PublishObserver;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(963557333, "Lio/reactivex/internal/operators/observable/ObservablePublish$PublishObserver;");
                    return;
                }
            }
            EMPTY = new InnerDisposable[0];
            TERMINATED = new InnerDisposable[0];
        }

        public PublishObserver(AtomicReference<PublishObserver<T>> atomicReference) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {atomicReference};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.s = new AtomicReference<>();
            this.observers = new AtomicReference<>(EMPTY);
            this.current = atomicReference;
            this.shouldConnect = new AtomicBoolean();
        }

        public boolean add(InnerDisposable<T> innerDisposable) {
            InnerDisposable<T>[] innerDisposableArr;
            InnerDisposable<T>[] innerDisposableArr2;
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, innerDisposable)) == null) {
                do {
                    innerDisposableArr = this.observers.get();
                    if (innerDisposableArr == TERMINATED) {
                        return false;
                    }
                    int length = innerDisposableArr.length;
                    innerDisposableArr2 = new InnerDisposable[length + 1];
                    System.arraycopy(innerDisposableArr, 0, innerDisposableArr2, 0, length);
                    innerDisposableArr2[length] = innerDisposable;
                } while (!this.observers.compareAndSet(innerDisposableArr, innerDisposableArr2));
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.observers.getAndSet(TERMINATED) == TERMINATED) {
                return;
            }
            this.current.compareAndSet(this, null);
            DisposableHelper.dispose(this.s);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.observers.get() == TERMINATED : invokeV.booleanValue;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.current.compareAndSet(this, null);
                for (InnerDisposable<T> innerDisposable : this.observers.getAndSet(TERMINATED)) {
                    innerDisposable.child.onComplete();
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, th) == null) {
                this.current.compareAndSet(this, null);
                InnerDisposable<T>[] andSet = this.observers.getAndSet(TERMINATED);
                if (andSet.length != 0) {
                    for (InnerDisposable<T> innerDisposable : andSet) {
                        innerDisposable.child.onError(th);
                    }
                    return;
                }
                RxJavaPlugins.onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, t) == null) {
                for (InnerDisposable<T> innerDisposable : this.observers.get()) {
                    innerDisposable.child.onNext(t);
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, disposable) == null) {
                DisposableHelper.setOnce(this.s, disposable);
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.observable.ObservablePublish$InnerDisposable<T>[]> */
        /* JADX WARN: Multi-variable type inference failed */
        public void remove(InnerDisposable<T> innerDisposable) {
            InnerDisposable<T>[] innerDisposableArr;
            InnerDisposable[] innerDisposableArr2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, innerDisposable) == null) {
                do {
                    innerDisposableArr = this.observers.get();
                    int length = innerDisposableArr.length;
                    if (length == 0) {
                        return;
                    }
                    int i2 = -1;
                    int i3 = 0;
                    while (true) {
                        if (i3 >= length) {
                            break;
                        } else if (innerDisposableArr[i3].equals(innerDisposable)) {
                            i2 = i3;
                            break;
                        } else {
                            i3++;
                        }
                    }
                    if (i2 < 0) {
                        return;
                    }
                    if (length == 1) {
                        innerDisposableArr2 = EMPTY;
                    } else {
                        InnerDisposable[] innerDisposableArr3 = new InnerDisposable[length - 1];
                        System.arraycopy(innerDisposableArr, 0, innerDisposableArr3, 0, i2);
                        System.arraycopy(innerDisposableArr, i2 + 1, innerDisposableArr3, i2, (length - i2) - 1);
                        innerDisposableArr2 = innerDisposableArr3;
                    }
                } while (!this.observers.compareAndSet(innerDisposableArr, innerDisposableArr2));
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class PublishSource<T> implements ObservableSource<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final AtomicReference<PublishObserver<T>> curr;

        public PublishSource(AtomicReference<PublishObserver<T>> atomicReference) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {atomicReference};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.curr = atomicReference;
        }

        @Override // io.reactivex.ObservableSource
        public void subscribe(Observer<? super T> observer) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, observer) != null) {
                return;
            }
            InnerDisposable innerDisposable = new InnerDisposable(observer);
            observer.onSubscribe(innerDisposable);
            while (true) {
                PublishObserver<T> publishObserver = this.curr.get();
                if (publishObserver == null || publishObserver.isDisposed()) {
                    PublishObserver<T> publishObserver2 = new PublishObserver<>(this.curr);
                    if (this.curr.compareAndSet(publishObserver, publishObserver2)) {
                        publishObserver = publishObserver2;
                    } else {
                        continue;
                    }
                }
                if (publishObserver.add(innerDisposable)) {
                    innerDisposable.setParent(publishObserver);
                    return;
                }
            }
        }
    }

    public ObservablePublish(ObservableSource<T> observableSource, ObservableSource<T> observableSource2, AtomicReference<PublishObserver<T>> atomicReference) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {observableSource, observableSource2, atomicReference};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.onSubscribe = observableSource;
        this.source = observableSource2;
        this.current = atomicReference;
    }

    public static <T> ConnectableObservable<T> create(ObservableSource<T> observableSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, observableSource)) == null) {
            AtomicReference atomicReference = new AtomicReference();
            return RxJavaPlugins.onAssembly((ConnectableObservable) new ObservablePublish(new PublishSource(atomicReference), observableSource, atomicReference));
        }
        return (ConnectableObservable) invokeL.objValue;
    }

    @Override // io.reactivex.observables.ConnectableObservable
    public void connect(Consumer<? super Disposable> consumer) {
        PublishObserver<T> publishObserver;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, consumer) == null) {
            while (true) {
                publishObserver = this.current.get();
                if (publishObserver != null && !publishObserver.isDisposed()) {
                    break;
                }
                PublishObserver<T> publishObserver2 = new PublishObserver<>(this.current);
                if (this.current.compareAndSet(publishObserver, publishObserver2)) {
                    publishObserver = publishObserver2;
                    break;
                }
            }
            boolean z = true;
            z = (publishObserver.shouldConnect.get() || !publishObserver.shouldConnect.compareAndSet(false, true)) ? false : false;
            try {
                consumer.accept(publishObserver);
                if (z) {
                    this.source.subscribe(publishObserver);
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                throw ExceptionHelper.wrapOrThrow(th);
            }
        }
    }

    @Override // io.reactivex.internal.fuseable.HasUpstreamObservableSource
    public ObservableSource<T> source() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.source : (ObservableSource) invokeV.objValue;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, observer) == null) {
            this.onSubscribe.subscribe(observer);
        }
    }
}
