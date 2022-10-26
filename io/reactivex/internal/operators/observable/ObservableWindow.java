package io.reactivex.internal.operators.observable;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.subjects.UnicastSubject;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes8.dex */
public final class ObservableWindow extends AbstractObservableWithUpstream {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int capacityHint;
    public final long count;
    public final long skip;

    /* loaded from: classes8.dex */
    public final class WindowExactObserver extends AtomicInteger implements Observer, Disposable, Runnable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -7481782523886138128L;
        public transient /* synthetic */ FieldHolder $fh;
        public final Observer actual;
        public volatile boolean cancelled;
        public final int capacityHint;
        public final long count;
        public Disposable s;
        public long size;
        public UnicastSubject window;

        public WindowExactObserver(Observer observer, long j, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {observer, Long.valueOf(j), Integer.valueOf(i)};
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
            this.count = j;
            this.capacityHint = i;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.cancelled = true;
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

        @Override // io.reactivex.Observer
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                UnicastSubject unicastSubject = this.window;
                if (unicastSubject != null) {
                    this.window = null;
                    unicastSubject.onComplete();
                }
                this.actual.onComplete();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.cancelled) {
                this.s.dispose();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, th) == null) {
                UnicastSubject unicastSubject = this.window;
                if (unicastSubject != null) {
                    this.window = null;
                    unicastSubject.onError(th);
                }
                this.actual.onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048581, this, disposable) == null) && DisposableHelper.validate(this.s, disposable)) {
                this.s = disposable;
                this.actual.onSubscribe(this);
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, obj) == null) {
                UnicastSubject unicastSubject = this.window;
                if (unicastSubject == null && !this.cancelled) {
                    unicastSubject = UnicastSubject.create(this.capacityHint, this);
                    this.window = unicastSubject;
                    this.actual.onNext(unicastSubject);
                }
                if (unicastSubject != null) {
                    unicastSubject.onNext(obj);
                    long j = this.size + 1;
                    this.size = j;
                    if (j >= this.count) {
                        this.size = 0L;
                        this.window = null;
                        unicastSubject.onComplete();
                        if (this.cancelled) {
                            this.s.dispose();
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public final class WindowSkipObserver extends AtomicBoolean implements Observer, Disposable, Runnable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 3366976432059579510L;
        public transient /* synthetic */ FieldHolder $fh;
        public final Observer actual;
        public volatile boolean cancelled;
        public final int capacityHint;
        public final long count;
        public long firstEmission;
        public long index;
        public Disposable s;
        public final long skip;
        public final ArrayDeque windows;
        public final AtomicInteger wip;

        public WindowSkipObserver(Observer observer, long j, long j2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {observer, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.wip = new AtomicInteger();
            this.actual = observer;
            this.count = j;
            this.skip = j2;
            this.capacityHint = i;
            this.windows = new ArrayDeque();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.cancelled = true;
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

        @Override // io.reactivex.Observer
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                ArrayDeque arrayDeque = this.windows;
                while (!arrayDeque.isEmpty()) {
                    ((UnicastSubject) arrayDeque.poll()).onComplete();
                }
                this.actual.onComplete();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.wip.decrementAndGet() == 0 && this.cancelled) {
                this.s.dispose();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, th) == null) {
                ArrayDeque arrayDeque = this.windows;
                while (!arrayDeque.isEmpty()) {
                    ((UnicastSubject) arrayDeque.poll()).onError(th);
                }
                this.actual.onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048581, this, disposable) == null) && DisposableHelper.validate(this.s, disposable)) {
                this.s = disposable;
                this.actual.onSubscribe(this);
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, obj) == null) {
                ArrayDeque arrayDeque = this.windows;
                long j = this.index;
                long j2 = this.skip;
                if (j % j2 == 0 && !this.cancelled) {
                    this.wip.getAndIncrement();
                    UnicastSubject create = UnicastSubject.create(this.capacityHint, this);
                    arrayDeque.offer(create);
                    this.actual.onNext(create);
                }
                long j3 = this.firstEmission + 1;
                Iterator it = arrayDeque.iterator();
                while (it.hasNext()) {
                    ((UnicastSubject) it.next()).onNext(obj);
                }
                if (j3 >= this.count) {
                    ((UnicastSubject) arrayDeque.poll()).onComplete();
                    if (arrayDeque.isEmpty() && this.cancelled) {
                        this.s.dispose();
                        return;
                    }
                    this.firstEmission = j3 - j2;
                } else {
                    this.firstEmission = j3;
                }
                this.index = j + 1;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ObservableWindow(ObservableSource observableSource, long j, long j2, int i) {
        super(observableSource);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {observableSource, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((ObservableSource) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.count = j;
        this.skip = j2;
        this.capacityHint = i;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer observer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, observer) == null) {
            if (this.count == this.skip) {
                this.source.subscribe(new WindowExactObserver(observer, this.count, this.capacityHint));
            } else {
                this.source.subscribe(new WindowSkipObserver(observer, this.count, this.skip, this.capacityHint));
            }
        }
    }
}
