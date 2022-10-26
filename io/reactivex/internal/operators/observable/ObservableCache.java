package io.reactivex.internal.operators.observable;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.LinkedArrayList;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes8.dex */
public final class ObservableCache extends AbstractObservableWithUpstream {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final AtomicBoolean once;
    public final CacheState state;

    /* loaded from: classes8.dex */
    public final class CacheState extends LinkedArrayList implements Observer {
        public static /* synthetic */ Interceptable $ic;
        public static final ReplayDisposable[] EMPTY;
        public static final ReplayDisposable[] TERMINATED;
        public transient /* synthetic */ FieldHolder $fh;
        public final SequentialDisposable connection;
        public volatile boolean isConnected;
        public final AtomicReference observers;
        public final Observable source;
        public boolean sourceDone;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1928449024, "Lio/reactivex/internal/operators/observable/ObservableCache$CacheState;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1928449024, "Lio/reactivex/internal/operators/observable/ObservableCache$CacheState;");
                    return;
                }
            }
            EMPTY = new ReplayDisposable[0];
            TERMINATED = new ReplayDisposable[0];
        }

        public void connect() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.source.subscribe(this);
                this.isConnected = true;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CacheState(Observable observable, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {observable, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.source = observable;
            this.observers = new AtomicReference(EMPTY);
            this.connection = new SequentialDisposable();
        }

        public boolean addChild(ReplayDisposable replayDisposable) {
            ReplayDisposable[] replayDisposableArr;
            ReplayDisposable[] replayDisposableArr2;
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, replayDisposable)) == null) {
                do {
                    replayDisposableArr = (ReplayDisposable[]) this.observers.get();
                    if (replayDisposableArr == TERMINATED) {
                        return false;
                    }
                    int length = replayDisposableArr.length;
                    replayDisposableArr2 = new ReplayDisposable[length + 1];
                    System.arraycopy(replayDisposableArr, 0, replayDisposableArr2, 0, length);
                    replayDisposableArr2[length] = replayDisposable;
                } while (!this.observers.compareAndSet(replayDisposableArr, replayDisposableArr2));
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // io.reactivex.Observer
        public void onNext(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048580, this, obj) == null) && !this.sourceDone) {
                add(NotificationLite.next(obj));
                for (ReplayDisposable replayDisposable : (ReplayDisposable[]) this.observers.get()) {
                    replayDisposable.replay();
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, disposable) == null) {
                this.connection.update(disposable);
            }
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && !this.sourceDone) {
                this.sourceDone = true;
                add(NotificationLite.complete());
                this.connection.dispose();
                for (ReplayDisposable replayDisposable : (ReplayDisposable[]) this.observers.getAndSet(TERMINATED)) {
                    replayDisposable.replay();
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048579, this, th) == null) && !this.sourceDone) {
                this.sourceDone = true;
                add(NotificationLite.error(th));
                this.connection.dispose();
                for (ReplayDisposable replayDisposable : (ReplayDisposable[]) this.observers.getAndSet(TERMINATED)) {
                    replayDisposable.replay();
                }
            }
        }

        public void removeChild(ReplayDisposable replayDisposable) {
            ReplayDisposable[] replayDisposableArr;
            ReplayDisposable[] replayDisposableArr2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, replayDisposable) == null) {
                do {
                    replayDisposableArr = (ReplayDisposable[]) this.observers.get();
                    int length = replayDisposableArr.length;
                    if (length == 0) {
                        return;
                    }
                    int i = -1;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            break;
                        } else if (replayDisposableArr[i2].equals(replayDisposable)) {
                            i = i2;
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (i < 0) {
                        return;
                    }
                    if (length == 1) {
                        replayDisposableArr2 = EMPTY;
                    } else {
                        ReplayDisposable[] replayDisposableArr3 = new ReplayDisposable[length - 1];
                        System.arraycopy(replayDisposableArr, 0, replayDisposableArr3, 0, i);
                        System.arraycopy(replayDisposableArr, i + 1, replayDisposableArr3, i, (length - i) - 1);
                        replayDisposableArr2 = replayDisposableArr3;
                    }
                } while (!this.observers.compareAndSet(replayDisposableArr, replayDisposableArr2));
            }
        }
    }

    /* loaded from: classes8.dex */
    public final class ReplayDisposable extends AtomicInteger implements Disposable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 7058506693698832024L;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile boolean cancelled;
        public final Observer child;
        public Object[] currentBuffer;
        public int currentIndexInBuffer;
        public int index;
        public final CacheState state;

        public ReplayDisposable(Observer observer, CacheState cacheState) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {observer, cacheState};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.child = observer;
            this.state = cacheState;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !this.cancelled) {
                this.cancelled = true;
                this.state.removeChild(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.cancelled;
            }
            return invokeV.booleanValue;
        }

        public void replay() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || getAndIncrement() != 0) {
                return;
            }
            Observer observer = this.child;
            int i = 1;
            while (!this.cancelled) {
                int size = this.state.size();
                if (size != 0) {
                    Object[] objArr = this.currentBuffer;
                    if (objArr == null) {
                        objArr = this.state.head();
                        this.currentBuffer = objArr;
                    }
                    int length = objArr.length - 1;
                    int i2 = this.index;
                    int i3 = this.currentIndexInBuffer;
                    while (i2 < size) {
                        if (this.cancelled) {
                            return;
                        }
                        if (i3 == length) {
                            objArr = (Object[]) objArr[length];
                            i3 = 0;
                        }
                        if (NotificationLite.accept(objArr[i3], observer)) {
                            return;
                        }
                        i3++;
                        i2++;
                    }
                    if (this.cancelled) {
                        return;
                    }
                    this.index = i2;
                    this.currentIndexInBuffer = i3;
                    this.currentBuffer = objArr;
                }
                i = addAndGet(-i);
                if (i == 0) {
                    return;
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ObservableCache(Observable observable, CacheState cacheState) {
        super(observable);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {observable, cacheState};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((ObservableSource) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.state = cacheState;
        this.once = new AtomicBoolean();
    }

    public static Observable from(Observable observable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, observable)) == null) {
            return from(observable, 16);
        }
        return (Observable) invokeL.objValue;
    }

    public static Observable from(Observable observable, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, observable, i)) == null) {
            ObjectHelper.verifyPositive(i, "capacityHint");
            return RxJavaPlugins.onAssembly(new ObservableCache(observable, new CacheState(observable, i)));
        }
        return (Observable) invokeLI.objValue;
    }

    public int cachedEventCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.state.size();
        }
        return invokeV.intValue;
    }

    public boolean hasObservers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (((ReplayDisposable[]) this.state.observers.get()).length != 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isConnected() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.state.isConnected;
        }
        return invokeV.booleanValue;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer observer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, observer) == null) {
            ReplayDisposable replayDisposable = new ReplayDisposable(observer, this.state);
            observer.onSubscribe(replayDisposable);
            this.state.addChild(replayDisposable);
            if (!this.once.get() && this.once.compareAndSet(false, true)) {
                this.state.connect();
            }
            replayDisposable.replay();
        }
    }
}
