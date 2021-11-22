package io.reactivex.internal.operators.observable;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.HasUpstreamObservableSource;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Timed;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public final class ObservableReplay<T> extends ConnectableObservable<T> implements HasUpstreamObservableSource<T>, Disposable {
    public static /* synthetic */ Interceptable $ic;
    public static final BufferSupplier DEFAULT_UNBOUNDED_FACTORY;
    public transient /* synthetic */ FieldHolder $fh;
    public final BufferSupplier<T> bufferFactory;
    public final AtomicReference<ReplayObserver<T>> current;
    public final ObservableSource<T> onSubscribe;
    public final ObservableSource<T> source;

    /* loaded from: classes2.dex */
    public static abstract class BoundedReplayBuffer<T> extends AtomicReference<Node> implements ReplayBuffer<T> {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 2346567790059478686L;
        public transient /* synthetic */ FieldHolder $fh;
        public int size;
        public Node tail;

        public BoundedReplayBuffer() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Node node = new Node(null);
            this.tail = node;
            set(node);
        }

        public final void addLast(Node node) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, node) == null) {
                this.tail.set(node);
                this.tail = node;
                this.size++;
            }
        }

        public final void collect(Collection<? super T> collection) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, collection) != null) {
                return;
            }
            Node head = getHead();
            while (true) {
                head = head.get();
                if (head == null) {
                    return;
                }
                Object leaveTransform = leaveTransform(head.value);
                if (NotificationLite.isComplete(leaveTransform) || NotificationLite.isError(leaveTransform)) {
                    return;
                }
                collection.add((Object) NotificationLite.getValue(leaveTransform));
            }
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.ReplayBuffer
        public final void complete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                addLast(new Node(enterTransform(NotificationLite.complete())));
                truncateFinal();
            }
        }

        public Object enterTransform(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) ? obj : invokeL.objValue;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.ReplayBuffer
        public final void error(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, th) == null) {
                addLast(new Node(enterTransform(NotificationLite.error(th))));
                truncateFinal();
            }
        }

        public Node getHead() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? get() : (Node) invokeV.objValue;
        }

        public boolean hasCompleted() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                Object obj = this.tail.value;
                return obj != null && NotificationLite.isComplete(leaveTransform(obj));
            }
            return invokeV.booleanValue;
        }

        public boolean hasError() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                Object obj = this.tail.value;
                return obj != null && NotificationLite.isError(leaveTransform(obj));
            }
            return invokeV.booleanValue;
        }

        public Object leaveTransform(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, obj)) == null) ? obj : invokeL.objValue;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.ReplayBuffer
        public final void next(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, t) == null) {
                addLast(new Node(enterTransform(NotificationLite.next(t))));
                truncate();
            }
        }

        public final void removeFirst() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
                this.size--;
                setFirst(get().get());
            }
        }

        public final void removeSome(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
                Node node = get();
                while (i2 > 0) {
                    node = node.get();
                    i2--;
                    this.size--;
                }
                setFirst(node);
            }
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.ReplayBuffer
        public final void replay(InnerDisposable<T> innerDisposable) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048588, this, innerDisposable) == null) && innerDisposable.getAndIncrement() == 0) {
                int i2 = 1;
                do {
                    Node node = (Node) innerDisposable.index();
                    if (node == null) {
                        node = getHead();
                        innerDisposable.index = node;
                    }
                    while (!innerDisposable.isDisposed()) {
                        Node node2 = node.get();
                        if (node2 != null) {
                            if (NotificationLite.accept(leaveTransform(node2.value), innerDisposable.child)) {
                                innerDisposable.index = null;
                                return;
                            }
                            node = node2;
                        } else {
                            innerDisposable.index = node;
                            i2 = innerDisposable.addAndGet(-i2);
                        }
                    }
                    return;
                } while (i2 != 0);
            }
        }

        public final void setFirst(Node node) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048589, this, node) == null) {
                set(node);
            }
        }

        public final void trimHead() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
                Node node = get();
                if (node.value != null) {
                    Node node2 = new Node(null);
                    node2.lazySet(node.get());
                    set(node2);
                }
            }
        }

        public abstract void truncate();

        public void truncateFinal() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
                trimHead();
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface BufferSupplier<T> {
        ReplayBuffer<T> call();
    }

    /* loaded from: classes2.dex */
    public static final class DisposeConsumer<R> implements Consumer<Disposable> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ObserverResourceWrapper<R> srw;

        public DisposeConsumer(ObserverResourceWrapper<R> observerResourceWrapper) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {observerResourceWrapper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.srw = observerResourceWrapper;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // io.reactivex.functions.Consumer
        public void accept(Disposable disposable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, disposable) == null) {
                this.srw.setResource(disposable);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class InnerDisposable<T> extends AtomicInteger implements Disposable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 2728361546769921047L;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile boolean cancelled;
        public final Observer<? super T> child;
        public Object index;
        public final ReplayObserver<T> parent;

        public InnerDisposable(ReplayObserver<T> replayObserver, Observer<? super T> observer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {replayObserver, observer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.parent = replayObserver;
            this.child = observer;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.parent.remove(this);
        }

        public <U> U index() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (U) this.index : (U) invokeV.objValue;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.cancelled : invokeV.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
    public static final class MulticastReplay<R, U> extends Observable<R> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Callable<? extends ConnectableObservable<U>> connectableFactory;
        public final Function<? super Observable<U>, ? extends ObservableSource<R>> selector;

        public MulticastReplay(Callable<? extends ConnectableObservable<U>> callable, Function<? super Observable<U>, ? extends ObservableSource<R>> function) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {callable, function};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.connectableFactory = callable;
            this.selector = function;
        }

        @Override // io.reactivex.Observable
        public void subscribeActual(Observer<? super R> observer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, observer) == null) {
                try {
                    ConnectableObservable connectableObservable = (ConnectableObservable) ObjectHelper.requireNonNull(this.connectableFactory.call(), "The connectableFactory returned a null ConnectableObservable");
                    ObservableSource observableSource = (ObservableSource) ObjectHelper.requireNonNull(this.selector.apply(connectableObservable), "The selector returned a null ObservableSource");
                    ObserverResourceWrapper observerResourceWrapper = new ObserverResourceWrapper(observer);
                    observableSource.subscribe(observerResourceWrapper);
                    connectableObservable.connect(new DisposeConsumer(observerResourceWrapper));
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    EmptyDisposable.error(th, observer);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class Node extends AtomicReference<Node> {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 245354315435971818L;
        public transient /* synthetic */ FieldHolder $fh;
        public final Object value;

        public Node(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.value = obj;
        }
    }

    /* loaded from: classes2.dex */
    public static final class Replay<T> extends ConnectableObservable<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ConnectableObservable<T> co;
        public final Observable<T> observable;

        public Replay(ConnectableObservable<T> connectableObservable, Observable<T> observable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {connectableObservable, observable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.co = connectableObservable;
            this.observable = observable;
        }

        @Override // io.reactivex.observables.ConnectableObservable
        public void connect(Consumer<? super Disposable> consumer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, consumer) == null) {
                this.co.connect(consumer);
            }
        }

        @Override // io.reactivex.Observable
        public void subscribeActual(Observer<? super T> observer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, observer) == null) {
                this.observable.subscribe(observer);
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface ReplayBuffer<T> {
        void complete();

        void error(Throwable th);

        void next(T t);

        void replay(InnerDisposable<T> innerDisposable);
    }

    /* loaded from: classes2.dex */
    public static final class ReplayBufferSupplier<T> implements BufferSupplier<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int bufferSize;

        public ReplayBufferSupplier(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.bufferSize = i2;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.BufferSupplier
        public ReplayBuffer<T> call() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new SizeBoundReplayBuffer(this.bufferSize) : (ReplayBuffer) invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public static final class ReplayObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final InnerDisposable[] EMPTY;
        public static final InnerDisposable[] TERMINATED;
        public static final long serialVersionUID = -533785617179540163L;
        public transient /* synthetic */ FieldHolder $fh;
        public final ReplayBuffer<T> buffer;
        public boolean done;
        public final AtomicReference<InnerDisposable[]> observers;
        public final AtomicBoolean shouldConnect;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-675366773, "Lio/reactivex/internal/operators/observable/ObservableReplay$ReplayObserver;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-675366773, "Lio/reactivex/internal/operators/observable/ObservableReplay$ReplayObserver;");
                    return;
                }
            }
            EMPTY = new InnerDisposable[0];
            TERMINATED = new InnerDisposable[0];
        }

        public ReplayObserver(ReplayBuffer<T> replayBuffer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {replayBuffer};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.buffer = replayBuffer;
            this.observers = new AtomicReference<>(EMPTY);
            this.shouldConnect = new AtomicBoolean();
        }

        public boolean add(InnerDisposable<T> innerDisposable) {
            InnerDisposable[] innerDisposableArr;
            InnerDisposable[] innerDisposableArr2;
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
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.observers.set(TERMINATED);
                DisposableHelper.dispose(this);
            }
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
            if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.done) {
                return;
            }
            this.done = true;
            this.buffer.complete();
            replayFinal();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, th) == null) {
                if (!this.done) {
                    this.done = true;
                    this.buffer.error(th);
                    replayFinal();
                    return;
                }
                RxJavaPlugins.onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048581, this, t) == null) || this.done) {
                return;
            }
            this.buffer.next(t);
            replay();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048582, this, disposable) == null) && DisposableHelper.setOnce(this, disposable)) {
                replay();
            }
        }

        public void remove(InnerDisposable<T> innerDisposable) {
            InnerDisposable[] innerDisposableArr;
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

        public void replay() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                for (InnerDisposable<T> innerDisposable : this.observers.get()) {
                    this.buffer.replay(innerDisposable);
                }
            }
        }

        public void replayFinal() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
                for (InnerDisposable<T> innerDisposable : this.observers.getAndSet(TERMINATED)) {
                    this.buffer.replay(innerDisposable);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class ReplaySource<T> implements ObservableSource<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final BufferSupplier<T> bufferFactory;
        public final AtomicReference<ReplayObserver<T>> curr;

        public ReplaySource(AtomicReference<ReplayObserver<T>> atomicReference, BufferSupplier<T> bufferSupplier) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {atomicReference, bufferSupplier};
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
            this.bufferFactory = bufferSupplier;
        }

        @Override // io.reactivex.ObservableSource
        public void subscribe(Observer<? super T> observer) {
            ReplayObserver<T> replayObserver;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, observer) == null) {
                while (true) {
                    replayObserver = this.curr.get();
                    if (replayObserver != null) {
                        break;
                    }
                    ReplayObserver<T> replayObserver2 = new ReplayObserver<>(this.bufferFactory.call());
                    if (this.curr.compareAndSet(null, replayObserver2)) {
                        replayObserver = replayObserver2;
                        break;
                    }
                }
                InnerDisposable<T> innerDisposable = new InnerDisposable<>(replayObserver, observer);
                observer.onSubscribe(innerDisposable);
                replayObserver.add(innerDisposable);
                if (innerDisposable.isDisposed()) {
                    replayObserver.remove(innerDisposable);
                } else {
                    replayObserver.buffer.replay(innerDisposable);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class ScheduledReplaySupplier<T> implements BufferSupplier<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int bufferSize;
        public final long maxAge;
        public final Scheduler scheduler;
        public final TimeUnit unit;

        public ScheduledReplaySupplier(int i2, long j, TimeUnit timeUnit, Scheduler scheduler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Long.valueOf(j), timeUnit, scheduler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.bufferSize = i2;
            this.maxAge = j;
            this.unit = timeUnit;
            this.scheduler = scheduler;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.BufferSupplier
        public ReplayBuffer<T> call() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new SizeAndTimeBoundReplayBuffer(this.bufferSize, this.maxAge, this.unit, this.scheduler) : (ReplayBuffer) invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public static final class SizeAndTimeBoundReplayBuffer<T> extends BoundedReplayBuffer<T> {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 3457957419649567404L;
        public transient /* synthetic */ FieldHolder $fh;
        public final int limit;
        public final long maxAge;
        public final Scheduler scheduler;
        public final TimeUnit unit;

        public SizeAndTimeBoundReplayBuffer(int i2, long j, TimeUnit timeUnit, Scheduler scheduler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Long.valueOf(j), timeUnit, scheduler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.scheduler = scheduler;
            this.limit = i2;
            this.maxAge = j;
            this.unit = timeUnit;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.BoundedReplayBuffer
        public Object enterTransform(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) ? new Timed(obj, this.scheduler.now(this.unit), this.unit) : invokeL.objValue;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.BoundedReplayBuffer
        public Node getHead() {
            InterceptResult invokeV;
            Node node;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                long now = this.scheduler.now(this.unit) - this.maxAge;
                Node node2 = get();
                Node node3 = node2.get();
                while (true) {
                    Node node4 = node3;
                    node = node2;
                    node2 = node4;
                    if (node2 != null) {
                        Timed timed = (Timed) node2.value;
                        if (NotificationLite.isComplete(timed.value()) || NotificationLite.isError(timed.value()) || timed.time() > now) {
                            break;
                        }
                        node3 = node2.get();
                    } else {
                        break;
                    }
                }
                return node;
            }
            return (Node) invokeV.objValue;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.BoundedReplayBuffer
        public Object leaveTransform(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) ? ((Timed) obj).value() : invokeL.objValue;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.BoundedReplayBuffer
        public void truncate() {
            Node node;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                long now = this.scheduler.now(this.unit) - this.maxAge;
                Node node2 = get();
                Node node3 = node2.get();
                int i2 = 0;
                while (true) {
                    Node node4 = node3;
                    node = node2;
                    node2 = node4;
                    if (node2 != null) {
                        int i3 = this.size;
                        if (i3 > this.limit) {
                            i2++;
                            this.size = i3 - 1;
                            node3 = node2.get();
                        } else if (((Timed) node2.value).time() > now) {
                            break;
                        } else {
                            i2++;
                            this.size--;
                            node3 = node2.get();
                        }
                    } else {
                        break;
                    }
                }
                if (i2 != 0) {
                    setFirst(node);
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x0042, code lost:
            setFirst(r3);
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x0045, code lost:
            return;
         */
        @Override // io.reactivex.internal.operators.observable.ObservableReplay.BoundedReplayBuffer
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void truncateFinal() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                long now = this.scheduler.now(this.unit) - this.maxAge;
                Node node = get();
                Node node2 = node.get();
                int i2 = 0;
                while (true) {
                    Node node3 = node2;
                    Node node4 = node;
                    node = node3;
                    if (node == null || this.size <= 1 || ((Timed) node.value).time() > now) {
                        break;
                    }
                    i2++;
                    this.size--;
                    node2 = node.get();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class SizeBoundReplayBuffer<T> extends BoundedReplayBuffer<T> {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -5898283885385201806L;
        public transient /* synthetic */ FieldHolder $fh;
        public final int limit;

        public SizeBoundReplayBuffer(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.limit = i2;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.BoundedReplayBuffer
        public void truncate() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.size <= this.limit) {
                return;
            }
            removeFirst();
        }
    }

    /* loaded from: classes2.dex */
    public static final class UnBoundedFactory implements BufferSupplier<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public UnBoundedFactory() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.BufferSupplier
        public ReplayBuffer<Object> call() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new UnboundedReplayBuffer(16) : (ReplayBuffer) invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public static final class UnboundedReplayBuffer<T> extends ArrayList<Object> implements ReplayBuffer<T> {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 7063189396499112664L;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile int size;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UnboundedReplayBuffer(int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.ReplayBuffer
        public void complete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                add(NotificationLite.complete());
                this.size++;
            }
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.ReplayBuffer
        public void error(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                add(NotificationLite.error(th));
                this.size++;
            }
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.ReplayBuffer
        public void next(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t) == null) {
                add(NotificationLite.next(t));
                this.size++;
            }
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.ReplayBuffer
        public void replay(InnerDisposable<T> innerDisposable) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048579, this, innerDisposable) == null) && innerDisposable.getAndIncrement() == 0) {
                Observer<? super T> observer = innerDisposable.child;
                int i2 = 1;
                while (!innerDisposable.isDisposed()) {
                    int i3 = this.size;
                    Integer num = (Integer) innerDisposable.index();
                    int intValue = num != null ? num.intValue() : 0;
                    while (intValue < i3) {
                        if (NotificationLite.accept(get(intValue), observer) || innerDisposable.isDisposed()) {
                            return;
                        }
                        intValue++;
                    }
                    innerDisposable.index = Integer.valueOf(intValue);
                    i2 = innerDisposable.addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1645891830, "Lio/reactivex/internal/operators/observable/ObservableReplay;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1645891830, "Lio/reactivex/internal/operators/observable/ObservableReplay;");
                return;
            }
        }
        DEFAULT_UNBOUNDED_FACTORY = new UnBoundedFactory();
    }

    public ObservableReplay(ObservableSource<T> observableSource, ObservableSource<T> observableSource2, AtomicReference<ReplayObserver<T>> atomicReference, BufferSupplier<T> bufferSupplier) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {observableSource, observableSource2, atomicReference, bufferSupplier};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.onSubscribe = observableSource;
        this.source = observableSource2;
        this.current = atomicReference;
        this.bufferFactory = bufferSupplier;
    }

    public static <T> ConnectableObservable<T> create(ObservableSource<T> observableSource, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, observableSource, i2)) == null) {
            if (i2 == Integer.MAX_VALUE) {
                return createFrom(observableSource);
            }
            return create(observableSource, new ReplayBufferSupplier(i2));
        }
        return (ConnectableObservable) invokeLI.objValue;
    }

    public static <T> ConnectableObservable<T> createFrom(ObservableSource<? extends T> observableSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, observableSource)) == null) ? create(observableSource, DEFAULT_UNBOUNDED_FACTORY) : (ConnectableObservable) invokeL.objValue;
    }

    public static <U, R> Observable<R> multicastSelector(Callable<? extends ConnectableObservable<U>> callable, Function<? super Observable<U>, ? extends ObservableSource<R>> function) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, callable, function)) == null) ? RxJavaPlugins.onAssembly(new MulticastReplay(callable, function)) : (Observable) invokeLL.objValue;
    }

    public static <T> ConnectableObservable<T> observeOn(ConnectableObservable<T> connectableObservable, Scheduler scheduler) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, connectableObservable, scheduler)) == null) ? RxJavaPlugins.onAssembly((ConnectableObservable) new Replay(connectableObservable, connectableObservable.observeOn(scheduler))) : (ConnectableObservable) invokeLL.objValue;
    }

    @Override // io.reactivex.observables.ConnectableObservable
    public void connect(Consumer<? super Disposable> consumer) {
        ReplayObserver<T> replayObserver;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, consumer) == null) {
            while (true) {
                replayObserver = this.current.get();
                if (replayObserver != null && !replayObserver.isDisposed()) {
                    break;
                }
                ReplayObserver<T> replayObserver2 = new ReplayObserver<>(this.bufferFactory.call());
                if (this.current.compareAndSet(replayObserver, replayObserver2)) {
                    replayObserver = replayObserver2;
                    break;
                }
            }
            boolean z = !replayObserver.shouldConnect.get() && replayObserver.shouldConnect.compareAndSet(false, true);
            try {
                consumer.accept(replayObserver);
                if (z) {
                    this.source.subscribe(replayObserver);
                }
            } catch (Throwable th) {
                if (z) {
                    replayObserver.shouldConnect.compareAndSet(true, false);
                }
                Exceptions.throwIfFatal(th);
                throw ExceptionHelper.wrapOrThrow(th);
            }
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.current.lazySet(null);
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ReplayObserver<T> replayObserver = this.current.get();
            return replayObserver == null || replayObserver.isDisposed();
        }
        return invokeV.booleanValue;
    }

    @Override // io.reactivex.internal.fuseable.HasUpstreamObservableSource
    public ObservableSource<T> source() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.source : (ObservableSource) invokeV.objValue;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, observer) == null) {
            this.onSubscribe.subscribe(observer);
        }
    }

    public static <T> ConnectableObservable<T> create(ObservableSource<T> observableSource, long j, TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{observableSource, Long.valueOf(j), timeUnit, scheduler})) == null) ? create(observableSource, j, timeUnit, scheduler, Integer.MAX_VALUE) : (ConnectableObservable) invokeCommon.objValue;
    }

    public static <T> ConnectableObservable<T> create(ObservableSource<T> observableSource, long j, TimeUnit timeUnit, Scheduler scheduler, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{observableSource, Long.valueOf(j), timeUnit, scheduler, Integer.valueOf(i2)})) == null) ? create(observableSource, new ScheduledReplaySupplier(i2, j, timeUnit, scheduler)) : (ConnectableObservable) invokeCommon.objValue;
    }

    public static <T> ConnectableObservable<T> create(ObservableSource<T> observableSource, BufferSupplier<T> bufferSupplier) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, observableSource, bufferSupplier)) == null) {
            AtomicReference atomicReference = new AtomicReference();
            return RxJavaPlugins.onAssembly((ConnectableObservable) new ObservableReplay(new ReplaySource(atomicReference, bufferSupplier), observableSource, atomicReference, bufferSupplier));
        }
        return (ConnectableObservable) invokeLL.objValue;
    }
}
