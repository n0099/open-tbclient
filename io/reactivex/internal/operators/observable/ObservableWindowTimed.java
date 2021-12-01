package io.reactivex.internal.operators.observable;

import androidx.core.view.InputDeviceCompat;
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
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.observers.QueueDrainObserver;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.observers.SerializedObserver;
import io.reactivex.subjects.UnicastSubject;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes3.dex */
public final class ObservableWindowTimed<T> extends AbstractObservableWithUpstream<T, Observable<T>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int bufferSize;
    public final long maxSize;
    public final boolean restartTimerOnMaxSize;
    public final Scheduler scheduler;
    public final long timeskip;
    public final long timespan;
    public final TimeUnit unit;

    /* loaded from: classes3.dex */
    public static final class WindowExactBoundedObserver<T> extends QueueDrainObserver<T, Object, Observable<T>> implements Disposable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int bufferSize;
        public long count;
        public final long maxSize;
        public long producerIndex;
        public final boolean restartTimerOnMaxSize;
        public Disposable s;
        public final Scheduler scheduler;
        public volatile boolean terminated;
        public final AtomicReference<Disposable> timer;
        public final long timespan;
        public final TimeUnit unit;
        public UnicastSubject<T> window;
        public final Scheduler.Worker worker;

        /* loaded from: classes3.dex */
        public static final class ConsumerIndexHolder implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final long index;
            public final WindowExactBoundedObserver<?> parent;

            public ConsumerIndexHolder(long j2, WindowExactBoundedObserver<?> windowExactBoundedObserver) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {Long.valueOf(j2), windowExactBoundedObserver};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.index = j2;
                this.parent = windowExactBoundedObserver;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    WindowExactBoundedObserver<?> windowExactBoundedObserver = this.parent;
                    if (!windowExactBoundedObserver.cancelled) {
                        windowExactBoundedObserver.queue.offer(this);
                    } else {
                        windowExactBoundedObserver.terminated = true;
                        windowExactBoundedObserver.disposeTimer();
                    }
                    if (windowExactBoundedObserver.enter()) {
                        windowExactBoundedObserver.drainLoop();
                    }
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public WindowExactBoundedObserver(Observer<? super Observable<T>> observer, long j2, TimeUnit timeUnit, Scheduler scheduler, int i2, long j3, boolean z) {
            super(observer, new MpscLinkedQueue());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {observer, Long.valueOf(j2), timeUnit, scheduler, Integer.valueOf(i2), Long.valueOf(j3), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Observer) objArr2[0], (SimplePlainQueue) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.timer = new AtomicReference<>();
            this.timespan = j2;
            this.unit = timeUnit;
            this.scheduler = scheduler;
            this.bufferSize = i2;
            this.maxSize = j3;
            this.restartTimerOnMaxSize = z;
            if (z) {
                this.worker = scheduler.createWorker();
            } else {
                this.worker = null;
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.cancelled = true;
            }
        }

        public void disposeTimer() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                DisposableHelper.dispose(this.timer);
                Scheduler.Worker worker = this.worker;
                if (worker != null) {
                    worker.dispose();
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v9, resolved type: io.reactivex.subjects.UnicastSubject */
        /* JADX WARN: Multi-variable type inference failed */
        public void drainLoop() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                MpscLinkedQueue mpscLinkedQueue = (MpscLinkedQueue) this.queue;
                Observer<? super V> observer = this.actual;
                UnicastSubject<T> unicastSubject = this.window;
                int i2 = 1;
                while (!this.terminated) {
                    boolean z = this.done;
                    Object poll = mpscLinkedQueue.poll();
                    boolean z2 = poll == null;
                    boolean z3 = poll instanceof ConsumerIndexHolder;
                    if (z && (z2 || z3)) {
                        this.window = null;
                        mpscLinkedQueue.clear();
                        disposeTimer();
                        Throwable th = this.error;
                        if (th != null) {
                            unicastSubject.onError(th);
                            return;
                        } else {
                            unicastSubject.onComplete();
                            return;
                        }
                    } else if (z2) {
                        i2 = leave(-i2);
                        if (i2 == 0) {
                            return;
                        }
                    } else if (z3) {
                        ConsumerIndexHolder consumerIndexHolder = (ConsumerIndexHolder) poll;
                        if (this.restartTimerOnMaxSize || this.producerIndex == consumerIndexHolder.index) {
                            unicastSubject.onComplete();
                            this.count = 0L;
                            unicastSubject = (UnicastSubject<T>) UnicastSubject.create(this.bufferSize);
                            this.window = unicastSubject;
                            observer.onNext(unicastSubject);
                        }
                    } else {
                        unicastSubject.onNext(NotificationLite.getValue(poll));
                        long j2 = this.count + 1;
                        if (j2 >= this.maxSize) {
                            this.producerIndex++;
                            this.count = 0L;
                            unicastSubject.onComplete();
                            unicastSubject = (UnicastSubject<T>) UnicastSubject.create(this.bufferSize);
                            this.window = unicastSubject;
                            this.actual.onNext(unicastSubject);
                            if (this.restartTimerOnMaxSize) {
                                Disposable disposable = this.timer.get();
                                disposable.dispose();
                                Scheduler.Worker worker = this.worker;
                                ConsumerIndexHolder consumerIndexHolder2 = new ConsumerIndexHolder(this.producerIndex, this);
                                long j3 = this.timespan;
                                Disposable schedulePeriodically = worker.schedulePeriodically(consumerIndexHolder2, j3, j3, this.unit);
                                if (!this.timer.compareAndSet(disposable, schedulePeriodically)) {
                                    schedulePeriodically.dispose();
                                }
                            }
                        } else {
                            this.count = j2;
                        }
                    }
                }
                this.s.dispose();
                mpscLinkedQueue.clear();
                disposeTimer();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.cancelled : invokeV.booleanValue;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.done = true;
                if (enter()) {
                    drainLoop();
                }
                this.actual.onComplete();
                disposeTimer();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, th) == null) {
                this.error = th;
                this.done = true;
                if (enter()) {
                    drainLoop();
                }
                this.actual.onError(th);
                disposeTimer();
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048582, this, t) == null) || this.terminated) {
                return;
            }
            if (fastEnter()) {
                UnicastSubject<T> unicastSubject = this.window;
                unicastSubject.onNext(t);
                long j2 = this.count + 1;
                if (j2 >= this.maxSize) {
                    this.producerIndex++;
                    this.count = 0L;
                    unicastSubject.onComplete();
                    UnicastSubject<T> create = UnicastSubject.create(this.bufferSize);
                    this.window = create;
                    this.actual.onNext(create);
                    if (this.restartTimerOnMaxSize) {
                        this.timer.get().dispose();
                        Scheduler.Worker worker = this.worker;
                        ConsumerIndexHolder consumerIndexHolder = new ConsumerIndexHolder(this.producerIndex, this);
                        long j3 = this.timespan;
                        DisposableHelper.replace(this.timer, worker.schedulePeriodically(consumerIndexHolder, j3, j3, this.unit));
                    }
                } else {
                    this.count = j2;
                }
                if (leave(-1) == 0) {
                    return;
                }
            } else {
                this.queue.offer(NotificationLite.next(t));
                if (!enter()) {
                    return;
                }
            }
            drainLoop();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            Disposable schedulePeriodicallyDirect;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048583, this, disposable) == null) && DisposableHelper.validate(this.s, disposable)) {
                this.s = disposable;
                Observer<? super V> observer = this.actual;
                observer.onSubscribe(this);
                if (this.cancelled) {
                    return;
                }
                UnicastSubject<T> create = UnicastSubject.create(this.bufferSize);
                this.window = create;
                observer.onNext(create);
                ConsumerIndexHolder consumerIndexHolder = new ConsumerIndexHolder(this.producerIndex, this);
                if (this.restartTimerOnMaxSize) {
                    Scheduler.Worker worker = this.worker;
                    long j2 = this.timespan;
                    schedulePeriodicallyDirect = worker.schedulePeriodically(consumerIndexHolder, j2, j2, this.unit);
                } else {
                    Scheduler scheduler = this.scheduler;
                    long j3 = this.timespan;
                    schedulePeriodicallyDirect = scheduler.schedulePeriodicallyDirect(consumerIndexHolder, j3, j3, this.unit);
                }
                DisposableHelper.replace(this.timer, schedulePeriodicallyDirect);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class WindowExactUnboundedObserver<T> extends QueueDrainObserver<T, Object, Observable<T>> implements Observer<T>, Disposable, Runnable {
        public static /* synthetic */ Interceptable $ic;
        public static final Object NEXT;
        public transient /* synthetic */ FieldHolder $fh;
        public final int bufferSize;
        public Disposable s;
        public final Scheduler scheduler;
        public volatile boolean terminated;
        public final AtomicReference<Disposable> timer;
        public final long timespan;
        public final TimeUnit unit;
        public UnicastSubject<T> window;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1036442775, "Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowExactUnboundedObserver;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1036442775, "Lio/reactivex/internal/operators/observable/ObservableWindowTimed$WindowExactUnboundedObserver;");
                    return;
                }
            }
            NEXT = new Object();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public WindowExactUnboundedObserver(Observer<? super Observable<T>> observer, long j2, TimeUnit timeUnit, Scheduler scheduler, int i2) {
            super(observer, new MpscLinkedQueue());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {observer, Long.valueOf(j2), timeUnit, scheduler, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Observer) objArr2[0], (SimplePlainQueue) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.timer = new AtomicReference<>();
            this.timespan = j2;
            this.unit = timeUnit;
            this.scheduler = scheduler;
            this.bufferSize = i2;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.cancelled = true;
            }
        }

        public void disposeTimer() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                DisposableHelper.dispose(this.timer);
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v7, resolved type: io.reactivex.subjects.UnicastSubject */
        /* JADX WARN: Code restructure failed: missing block: B:10:0x001d, code lost:
            r7.window = null;
            r0.clear();
            disposeTimer();
            r0 = r7.error;
         */
        /* JADX WARN: Code restructure failed: missing block: B:11:0x0028, code lost:
            if (r0 == null) goto L15;
         */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x002a, code lost:
            r2.onError(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x002e, code lost:
            r2.onComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x0031, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:?, code lost:
            return;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void drainLoop() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) {
                return;
            }
            MpscLinkedQueue mpscLinkedQueue = (MpscLinkedQueue) this.queue;
            Observer<? super V> observer = this.actual;
            UnicastSubject<T> unicastSubject = this.window;
            int i2 = 1;
            while (true) {
                boolean z = this.terminated;
                boolean z2 = this.done;
                Object poll = mpscLinkedQueue.poll();
                if (!z2 || (poll != null && poll != NEXT)) {
                    if (poll == null) {
                        i2 = leave(-i2);
                        if (i2 == 0) {
                            return;
                        }
                    } else if (poll == NEXT) {
                        unicastSubject.onComplete();
                        if (!z) {
                            unicastSubject = (UnicastSubject<T>) UnicastSubject.create(this.bufferSize);
                            this.window = unicastSubject;
                            observer.onNext(unicastSubject);
                        } else {
                            this.s.dispose();
                        }
                    } else {
                        unicastSubject.onNext(NotificationLite.getValue(poll));
                    }
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.cancelled : invokeV.booleanValue;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.done = true;
                if (enter()) {
                    drainLoop();
                }
                disposeTimer();
                this.actual.onComplete();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, th) == null) {
                this.error = th;
                this.done = true;
                if (enter()) {
                    drainLoop();
                }
                disposeTimer();
                this.actual.onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048582, this, t) == null) || this.terminated) {
                return;
            }
            if (fastEnter()) {
                this.window.onNext(t);
                if (leave(-1) == 0) {
                    return;
                }
            } else {
                this.queue.offer(NotificationLite.next(t));
                if (!enter()) {
                    return;
                }
            }
            drainLoop();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048583, this, disposable) == null) && DisposableHelper.validate(this.s, disposable)) {
                this.s = disposable;
                this.window = UnicastSubject.create(this.bufferSize);
                Observer<? super V> observer = this.actual;
                observer.onSubscribe(this);
                observer.onNext(this.window);
                if (this.cancelled) {
                    return;
                }
                Scheduler scheduler = this.scheduler;
                long j2 = this.timespan;
                DisposableHelper.replace(this.timer, scheduler.schedulePeriodicallyDirect(this, j2, j2, this.unit));
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                if (this.cancelled) {
                    this.terminated = true;
                    disposeTimer();
                }
                this.queue.offer(NEXT);
                if (enter()) {
                    drainLoop();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class WindowSkipObserver<T> extends QueueDrainObserver<T, Object, Observable<T>> implements Disposable, Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int bufferSize;
        public Disposable s;
        public volatile boolean terminated;
        public final long timeskip;
        public final long timespan;
        public final TimeUnit unit;
        public final List<UnicastSubject<T>> windows;
        public final Scheduler.Worker worker;

        /* loaded from: classes3.dex */
        public final class CompletionTask implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ WindowSkipObserver this$0;
            public final UnicastSubject<T> w;

            public CompletionTask(WindowSkipObserver windowSkipObserver, UnicastSubject<T> unicastSubject) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {windowSkipObserver, unicastSubject};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = windowSkipObserver;
                this.w = unicastSubject;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.this$0.complete(this.w);
                }
            }
        }

        /* loaded from: classes3.dex */
        public static final class SubjectWork<T> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final boolean open;
            public final UnicastSubject<T> w;

            public SubjectWork(UnicastSubject<T> unicastSubject, boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {unicastSubject, Boolean.valueOf(z)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.w = unicastSubject;
                this.open = z;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public WindowSkipObserver(Observer<? super Observable<T>> observer, long j2, long j3, TimeUnit timeUnit, Scheduler.Worker worker, int i2) {
            super(observer, new MpscLinkedQueue());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {observer, Long.valueOf(j2), Long.valueOf(j3), timeUnit, worker, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Observer) objArr2[0], (SimplePlainQueue) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.timespan = j2;
            this.timeskip = j3;
            this.unit = timeUnit;
            this.worker = worker;
            this.bufferSize = i2;
            this.windows = new LinkedList();
        }

        public void complete(UnicastSubject<T> unicastSubject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, unicastSubject) == null) {
                this.queue.offer(new SubjectWork(unicastSubject, false));
                if (enter()) {
                    drainLoop();
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.cancelled = true;
            }
        }

        public void disposeWorker() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.worker.dispose();
            }
        }

        public void drainLoop() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                MpscLinkedQueue mpscLinkedQueue = (MpscLinkedQueue) this.queue;
                Observer<? super V> observer = this.actual;
                List<UnicastSubject<T>> list = this.windows;
                int i2 = 1;
                while (!this.terminated) {
                    boolean z = this.done;
                    T t = (T) mpscLinkedQueue.poll();
                    boolean z2 = t == null;
                    boolean z3 = t instanceof SubjectWork;
                    if (z && (z2 || z3)) {
                        mpscLinkedQueue.clear();
                        Throwable th = this.error;
                        if (th != null) {
                            for (UnicastSubject<T> unicastSubject : list) {
                                unicastSubject.onError(th);
                            }
                        } else {
                            for (UnicastSubject<T> unicastSubject2 : list) {
                                unicastSubject2.onComplete();
                            }
                        }
                        disposeWorker();
                        list.clear();
                        return;
                    } else if (z2) {
                        i2 = leave(-i2);
                        if (i2 == 0) {
                            return;
                        }
                    } else if (z3) {
                        SubjectWork subjectWork = (SubjectWork) t;
                        if (subjectWork.open) {
                            if (!this.cancelled) {
                                UnicastSubject<T> create = UnicastSubject.create(this.bufferSize);
                                list.add(create);
                                observer.onNext(create);
                                this.worker.schedule(new CompletionTask(this, create), this.timespan, this.unit);
                            }
                        } else {
                            list.remove(subjectWork.w);
                            subjectWork.w.onComplete();
                            if (list.isEmpty() && this.cancelled) {
                                this.terminated = true;
                            }
                        }
                    } else {
                        for (UnicastSubject<T> unicastSubject3 : list) {
                            unicastSubject3.onNext(t);
                        }
                    }
                }
                this.s.dispose();
                disposeWorker();
                mpscLinkedQueue.clear();
                list.clear();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.cancelled : invokeV.booleanValue;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.done = true;
                if (enter()) {
                    drainLoop();
                }
                this.actual.onComplete();
                disposeWorker();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, th) == null) {
                this.error = th;
                this.done = true;
                if (enter()) {
                    drainLoop();
                }
                this.actual.onError(th);
                disposeWorker();
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, t) == null) {
                if (fastEnter()) {
                    for (UnicastSubject<T> unicastSubject : this.windows) {
                        unicastSubject.onNext(t);
                    }
                    if (leave(-1) == 0) {
                        return;
                    }
                } else {
                    this.queue.offer(t);
                    if (!enter()) {
                        return;
                    }
                }
                drainLoop();
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, disposable) == null) && DisposableHelper.validate(this.s, disposable)) {
                this.s = disposable;
                this.actual.onSubscribe(this);
                if (this.cancelled) {
                    return;
                }
                UnicastSubject<T> create = UnicastSubject.create(this.bufferSize);
                this.windows.add(create);
                this.actual.onNext(create);
                this.worker.schedule(new CompletionTask(this, create), this.timespan, this.unit);
                Scheduler.Worker worker = this.worker;
                long j2 = this.timeskip;
                worker.schedulePeriodically(this, j2, j2, this.unit);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
                SubjectWork subjectWork = new SubjectWork(UnicastSubject.create(this.bufferSize), true);
                if (!this.cancelled) {
                    this.queue.offer(subjectWork);
                }
                if (enter()) {
                    drainLoop();
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ObservableWindowTimed(ObservableSource<T> observableSource, long j2, long j3, TimeUnit timeUnit, Scheduler scheduler, long j4, int i2, boolean z) {
        super(observableSource);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {observableSource, Long.valueOf(j2), Long.valueOf(j3), timeUnit, scheduler, Long.valueOf(j4), Integer.valueOf(i2), Boolean.valueOf(z)};
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
        this.timespan = j2;
        this.timeskip = j3;
        this.unit = timeUnit;
        this.scheduler = scheduler;
        this.maxSize = j4;
        this.bufferSize = i2;
        this.restartTimerOnMaxSize = z;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super Observable<T>> observer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, observer) == null) {
            SerializedObserver serializedObserver = new SerializedObserver(observer);
            long j2 = this.timespan;
            long j3 = this.timeskip;
            if (j2 == j3) {
                long j4 = this.maxSize;
                if (j4 == Long.MAX_VALUE) {
                    this.source.subscribe(new WindowExactUnboundedObserver(serializedObserver, this.timespan, this.unit, this.scheduler, this.bufferSize));
                    return;
                } else {
                    this.source.subscribe(new WindowExactBoundedObserver(serializedObserver, j2, this.unit, this.scheduler, this.bufferSize, j4, this.restartTimerOnMaxSize));
                    return;
                }
            }
            this.source.subscribe(new WindowSkipObserver(serializedObserver, j2, j3, this.unit, this.scheduler.createWorker(), this.bufferSize));
        }
    }
}
