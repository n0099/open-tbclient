package io.reactivex.internal.operators.observable;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes10.dex */
public final class ObservableSkipLastTimed<T> extends AbstractObservableWithUpstream<T, T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int bufferSize;
    public final boolean delayError;
    public final Scheduler scheduler;
    public final long time;
    public final TimeUnit unit;

    /* loaded from: classes10.dex */
    public static final class SkipLastTimedObserver<T> extends AtomicInteger implements Observer<T>, Disposable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -5677354903406201275L;
        public transient /* synthetic */ FieldHolder $fh;
        public final Observer<? super T> actual;
        public volatile boolean cancelled;
        public final boolean delayError;
        public volatile boolean done;
        public Throwable error;
        public final SpscLinkedArrayQueue<Object> queue;
        public Disposable s;
        public final Scheduler scheduler;
        public final long time;
        public final TimeUnit unit;

        public SkipLastTimedObserver(Observer<? super T> observer, long j, TimeUnit timeUnit, Scheduler scheduler, int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {observer, Long.valueOf(j), timeUnit, scheduler, Integer.valueOf(i2), Boolean.valueOf(z)};
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
            this.time = j;
            this.unit = timeUnit;
            this.scheduler = scheduler;
            this.queue = new SpscLinkedArrayQueue<>(i2);
            this.delayError = z;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.s.dispose();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        public void drain() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && getAndIncrement() == 0) {
                Observer<? super T> observer = this.actual;
                SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.queue;
                boolean z = this.delayError;
                TimeUnit timeUnit = this.unit;
                Scheduler scheduler = this.scheduler;
                long j = this.time;
                int i2 = 1;
                while (!this.cancelled) {
                    boolean z2 = this.done;
                    Long l = (Long) spscLinkedArrayQueue.peek();
                    boolean z3 = l == null;
                    long now = scheduler.now(timeUnit);
                    if (!z3 && l.longValue() > now - j) {
                        z3 = true;
                    }
                    if (z2) {
                        if (!z) {
                            Throwable th = this.error;
                            if (th != null) {
                                this.queue.clear();
                                observer.onError(th);
                                return;
                            } else if (z3) {
                                observer.onComplete();
                                return;
                            }
                        } else if (z3) {
                            Throwable th2 = this.error;
                            if (th2 != null) {
                                observer.onError(th2);
                                return;
                            } else {
                                observer.onComplete();
                                return;
                            }
                        }
                    }
                    if (z3) {
                        i2 = addAndGet(-i2);
                        if (i2 == 0) {
                            return;
                        }
                    } else {
                        spscLinkedArrayQueue.poll();
                        observer.onNext(spscLinkedArrayQueue.poll());
                    }
                }
                this.queue.clear();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.cancelled : invokeV.booleanValue;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.done = true;
                drain();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, th) == null) {
                this.error = th;
                this.done = true;
                drain();
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, t) == null) {
                this.queue.offer(Long.valueOf(this.scheduler.now(this.unit)), t);
                drain();
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048582, this, disposable) == null) && DisposableHelper.validate(this.s, disposable)) {
                this.s = disposable;
                this.actual.onSubscribe(this);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ObservableSkipLastTimed(ObservableSource<T> observableSource, long j, TimeUnit timeUnit, Scheduler scheduler, int i2, boolean z) {
        super(observableSource);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {observableSource, Long.valueOf(j), timeUnit, scheduler, Integer.valueOf(i2), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super((ObservableSource) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.time = j;
        this.unit = timeUnit;
        this.scheduler = scheduler;
        this.bufferSize = i2;
        this.delayError = z;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, observer) == null) {
            this.source.subscribe(new SkipLastTimedObserver(observer, this.time, this.unit, this.scheduler, this.bufferSize, this.delayError));
        }
    }
}
