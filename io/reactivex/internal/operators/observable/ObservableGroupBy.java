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
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.observables.GroupedObservable;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes8.dex */
public final class ObservableGroupBy extends AbstractObservableWithUpstream {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int bufferSize;
    public final boolean delayError;
    public final Function keySelector;
    public final Function valueSelector;

    /* loaded from: classes8.dex */
    public final class GroupByObserver extends AtomicInteger implements Observer, Disposable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final Object NULL_KEY;
        public static final long serialVersionUID = -3688291656102519502L;
        public transient /* synthetic */ FieldHolder $fh;
        public final Observer actual;
        public final int bufferSize;
        public final AtomicBoolean cancelled;
        public final boolean delayError;
        public final Map groups;
        public final Function keySelector;
        public Disposable s;
        public final Function valueSelector;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1734841785, "Lio/reactivex/internal/operators/observable/ObservableGroupBy$GroupByObserver;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1734841785, "Lio/reactivex/internal/operators/observable/ObservableGroupBy$GroupByObserver;");
                    return;
                }
            }
            NULL_KEY = new Object();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.cancelled.compareAndSet(false, true) && decrementAndGet() == 0) {
                this.s.dispose();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.cancelled.get();
            }
            return invokeV.booleanValue;
        }

        public GroupByObserver(Observer observer, Function function, Function function2, int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {observer, function, function2, Integer.valueOf(i), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.cancelled = new AtomicBoolean();
            this.actual = observer;
            this.keySelector = function;
            this.valueSelector = function2;
            this.bufferSize = i;
            this.delayError = z;
            this.groups = new ConcurrentHashMap();
            lazySet(1);
        }

        public void cancel(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (obj == null) {
                    obj = NULL_KEY;
                }
                this.groups.remove(obj);
                if (decrementAndGet() == 0) {
                    this.s.dispose();
                }
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

        @Override // io.reactivex.Observer
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                ArrayList<GroupedUnicast> arrayList = new ArrayList(this.groups.values());
                this.groups.clear();
                for (GroupedUnicast groupedUnicast : arrayList) {
                    groupedUnicast.onComplete();
                }
                this.actual.onComplete();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, th) == null) {
                ArrayList<GroupedUnicast> arrayList = new ArrayList(this.groups.values());
                this.groups.clear();
                for (GroupedUnicast groupedUnicast : arrayList) {
                    groupedUnicast.onError(th);
                }
                this.actual.onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(Object obj) {
            Object obj2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, obj) == null) {
                try {
                    Object apply = this.keySelector.apply(obj);
                    if (apply != null) {
                        obj2 = apply;
                    } else {
                        obj2 = NULL_KEY;
                    }
                    GroupedUnicast groupedUnicast = (GroupedUnicast) this.groups.get(obj2);
                    if (groupedUnicast == null) {
                        if (this.cancelled.get()) {
                            return;
                        }
                        groupedUnicast = GroupedUnicast.createWith(apply, this.bufferSize, this, this.delayError);
                        this.groups.put(obj2, groupedUnicast);
                        getAndIncrement();
                        this.actual.onNext(groupedUnicast);
                    }
                    try {
                        groupedUnicast.onNext(ObjectHelper.requireNonNull(this.valueSelector.apply(obj), "The value supplied is null"));
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        this.s.dispose();
                        onError(th);
                    }
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.s.dispose();
                    onError(th2);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public final class GroupedUnicast extends GroupedObservable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final State state;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GroupedUnicast(Object obj, State state) {
            super(obj);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {obj, state};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.state = state;
        }

        public static GroupedUnicast createWith(Object obj, int i, GroupByObserver groupByObserver, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{obj, Integer.valueOf(i), groupByObserver, Boolean.valueOf(z)})) == null) {
                return new GroupedUnicast(obj, new State(i, groupByObserver, obj, z));
            }
            return (GroupedUnicast) invokeCommon.objValue;
        }

        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.state.onComplete();
            }
        }

        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                this.state.onError(th);
            }
        }

        public void onNext(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
                this.state.onNext(obj);
            }
        }

        @Override // io.reactivex.Observable
        public void subscribeActual(Observer observer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, observer) == null) {
                this.state.subscribe(observer);
            }
        }
    }

    /* loaded from: classes8.dex */
    public final class State extends AtomicInteger implements Disposable, ObservableSource {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -3852313036005250360L;
        public transient /* synthetic */ FieldHolder $fh;
        public final AtomicReference actual;
        public final AtomicBoolean cancelled;
        public final boolean delayError;
        public volatile boolean done;
        public Throwable error;
        public final Object key;
        public final AtomicBoolean once;
        public final GroupByObserver parent;
        public final SpscLinkedArrayQueue queue;

        public State(int i, GroupByObserver groupByObserver, Object obj, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), groupByObserver, obj, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.cancelled = new AtomicBoolean();
            this.once = new AtomicBoolean();
            this.actual = new AtomicReference();
            this.queue = new SpscLinkedArrayQueue(i);
            this.parent = groupByObserver;
            this.key = obj;
            this.delayError = z;
        }

        public boolean checkTerminated(boolean z, boolean z2, Observer observer, boolean z3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), observer, Boolean.valueOf(z3)})) == null) {
                if (this.cancelled.get()) {
                    this.queue.clear();
                    this.parent.cancel(this.key);
                    this.actual.lazySet(null);
                    return true;
                } else if (z) {
                    if (z3) {
                        if (z2) {
                            Throwable th = this.error;
                            this.actual.lazySet(null);
                            if (th != null) {
                                observer.onError(th);
                            } else {
                                observer.onComplete();
                            }
                            return true;
                        }
                        return false;
                    }
                    Throwable th2 = this.error;
                    if (th2 != null) {
                        this.queue.clear();
                        this.actual.lazySet(null);
                        observer.onError(th2);
                        return true;
                    } else if (z2) {
                        this.actual.lazySet(null);
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

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.cancelled.compareAndSet(false, true) && getAndIncrement() == 0) {
                this.actual.lazySet(null);
                this.parent.cancel(this.key);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.cancelled.get();
            }
            return invokeV.booleanValue;
        }

        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.done = true;
                drain();
            }
        }

        public void drain() {
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || getAndIncrement() != 0) {
                return;
            }
            SpscLinkedArrayQueue spscLinkedArrayQueue = this.queue;
            boolean z2 = this.delayError;
            Observer observer = (Observer) this.actual.get();
            int i = 1;
            while (true) {
                if (observer != null) {
                    while (true) {
                        boolean z3 = this.done;
                        Object poll = spscLinkedArrayQueue.poll();
                        if (poll == null) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (checkTerminated(z3, z, observer, z2)) {
                            return;
                        }
                        if (z) {
                            break;
                        }
                        observer.onNext(poll);
                    }
                }
                i = addAndGet(-i);
                if (i == 0) {
                    return;
                }
                if (observer == null) {
                    observer = (Observer) this.actual.get();
                }
            }
        }

        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, th) == null) {
                this.error = th;
                this.done = true;
                drain();
            }
        }

        public void onNext(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, obj) == null) {
                this.queue.offer(obj);
                drain();
            }
        }

        @Override // io.reactivex.ObservableSource
        public void subscribe(Observer observer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, observer) == null) {
                if (this.once.compareAndSet(false, true)) {
                    observer.onSubscribe(this);
                    this.actual.lazySet(observer);
                    if (this.cancelled.get()) {
                        this.actual.lazySet(null);
                        return;
                    } else {
                        drain();
                        return;
                    }
                }
                EmptyDisposable.error(new IllegalStateException("Only one Observer allowed!"), observer);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ObservableGroupBy(ObservableSource observableSource, Function function, Function function2, int i, boolean z) {
        super(observableSource);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {observableSource, function, function2, Integer.valueOf(i), Boolean.valueOf(z)};
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
        this.keySelector = function;
        this.valueSelector = function2;
        this.bufferSize = i;
        this.delayError = z;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer observer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, observer) == null) {
            this.source.subscribe(new GroupByObserver(observer, this.keySelector, this.valueSelector, this.bufferSize, this.delayError));
        }
    }
}
