package io.reactivex.subjects;

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
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.Experimental;
import io.reactivex.annotations.Nullable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes9.dex */
public final class ReplaySubject<T> extends Subject<T> {
    public static /* synthetic */ Interceptable $ic;
    public static final ReplayDisposable[] EMPTY;
    public static final Object[] EMPTY_ARRAY;
    public static final ReplayDisposable[] TERMINATED;
    public transient /* synthetic */ FieldHolder $fh;
    public final ReplayBuffer<T> buffer;
    public boolean done;
    public final AtomicReference<ReplayDisposable<T>[]> observers;

    /* loaded from: classes9.dex */
    public static final class Node<T> extends AtomicReference<Node<T>> {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 6404226426336033100L;
        public transient /* synthetic */ FieldHolder $fh;
        public final T value;

        public Node(T t) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.value = t;
        }
    }

    /* loaded from: classes9.dex */
    public interface ReplayBuffer<T> {
        void add(T t);

        void addFinal(Object obj);

        boolean compareAndSet(Object obj, Object obj2);

        Object get();

        @Nullable
        T getValue();

        T[] getValues(T[] tArr);

        void replay(ReplayDisposable<T> replayDisposable);

        int size();

        void trimHead();
    }

    /* loaded from: classes9.dex */
    public static final class ReplayDisposable<T> extends AtomicInteger implements Disposable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 466549804534799122L;
        public transient /* synthetic */ FieldHolder $fh;
        public final Observer<? super T> actual;
        public volatile boolean cancelled;
        public Object index;
        public final ReplaySubject<T> state;

        public ReplayDisposable(Observer<? super T> observer, ReplaySubject<T> replaySubject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {observer, replaySubject};
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
            this.state = replaySubject;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.state.remove(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.cancelled : invokeV.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public static final class SizeAndTimeBoundReplayBuffer<T> extends AtomicReference<Object> implements ReplayBuffer<T> {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -8056260896137901749L;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile boolean done;
        public volatile TimedNode<Object> head;
        public final long maxAge;
        public final int maxSize;
        public final Scheduler scheduler;
        public int size;
        public TimedNode<Object> tail;
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
            this.maxSize = ObjectHelper.verifyPositive(i2, "maxSize");
            this.maxAge = ObjectHelper.verifyPositive(j, "maxAge");
            this.unit = (TimeUnit) ObjectHelper.requireNonNull(timeUnit, "unit is null");
            this.scheduler = (Scheduler) ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            TimedNode<Object> timedNode = new TimedNode<>(null, 0L);
            this.tail = timedNode;
            this.head = timedNode;
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public void add(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, t) == null) {
                TimedNode<Object> timedNode = new TimedNode<>(t, this.scheduler.now(this.unit));
                TimedNode<Object> timedNode2 = this.tail;
                this.tail = timedNode;
                this.size++;
                timedNode2.set(timedNode);
                trim();
            }
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public void addFinal(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
                TimedNode<Object> timedNode = new TimedNode<>(obj, Long.MAX_VALUE);
                TimedNode<Object> timedNode2 = this.tail;
                this.tail = timedNode;
                this.size++;
                timedNode2.lazySet(timedNode);
                trimFinal();
                this.done = true;
            }
        }

        public TimedNode<Object> getHead() {
            InterceptResult invokeV;
            TimedNode<Object> timedNode;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                TimedNode<Object> timedNode2 = this.head;
                long now = this.scheduler.now(this.unit) - this.maxAge;
                TimedNode<T> timedNode3 = timedNode2.get();
                while (true) {
                    TimedNode<T> timedNode4 = timedNode3;
                    timedNode = timedNode2;
                    timedNode2 = timedNode4;
                    if (timedNode2 == null || timedNode2.time > now) {
                        break;
                    }
                    timedNode3 = timedNode2.get();
                }
                return timedNode;
            }
            return (TimedNode) invokeV.objValue;
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        @Nullable
        public T getValue() {
            InterceptResult invokeV;
            T t;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                TimedNode<Object> timedNode = this.head;
                TimedNode<Object> timedNode2 = null;
                while (true) {
                    TimedNode<T> timedNode3 = timedNode.get();
                    if (timedNode3 == null) {
                        break;
                    }
                    timedNode2 = timedNode;
                    timedNode = timedNode3;
                }
                if (timedNode.time >= this.scheduler.now(this.unit) - this.maxAge && (t = (T) timedNode.value) != null) {
                    return (NotificationLite.isComplete(t) || NotificationLite.isError(t)) ? (T) timedNode2.value : t;
                }
                return null;
            }
            return (T) invokeV.objValue;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r6v9, resolved type: T[] */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public T[] getValues(T[] tArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, tArr)) == null) {
                TimedNode<T> head = getHead();
                int size = size(head);
                if (size == 0) {
                    if (tArr.length != 0) {
                        tArr[0] = null;
                    }
                } else {
                    if (tArr.length < size) {
                        tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), size));
                    }
                    for (int i2 = 0; i2 != size; i2++) {
                        head = head.get();
                        tArr[i2] = head.value;
                    }
                    if (tArr.length > size) {
                        tArr[size] = null;
                    }
                }
                return tArr;
            }
            return (T[]) ((Object[]) invokeL.objValue);
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public void replay(ReplayDisposable<T> replayDisposable) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048581, this, replayDisposable) == null) && replayDisposable.getAndIncrement() == 0) {
                Observer<? super T> observer = replayDisposable.actual;
                TimedNode<T> timedNode = (TimedNode) replayDisposable.index;
                if (timedNode == null) {
                    timedNode = getHead();
                }
                int i2 = 1;
                while (true) {
                    timedNode = timedNode;
                    if (replayDisposable.cancelled) {
                        replayDisposable.index = null;
                        return;
                    }
                    while (!replayDisposable.cancelled) {
                        TimedNode<T> timedNode2 = timedNode.get();
                        if (timedNode2 == null) {
                            if (timedNode.get() == null) {
                                replayDisposable.index = timedNode;
                                i2 = replayDisposable.addAndGet(-i2);
                                if (i2 == 0) {
                                    return;
                                }
                            }
                        } else {
                            Object obj = (T) timedNode2.value;
                            if (this.done && timedNode2.get() == null) {
                                if (NotificationLite.isComplete(obj)) {
                                    observer.onComplete();
                                } else {
                                    observer.onError(NotificationLite.getError(obj));
                                }
                                replayDisposable.index = null;
                                replayDisposable.cancelled = true;
                                return;
                            }
                            observer.onNext(obj);
                            timedNode = timedNode2;
                        }
                    }
                    replayDisposable.index = null;
                    return;
                }
            }
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public int size() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? size(getHead()) : invokeV.intValue;
        }

        public void trim() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) != null) {
                return;
            }
            int i2 = this.size;
            if (i2 > this.maxSize) {
                this.size = i2 - 1;
                this.head = this.head.get();
            }
            long now = this.scheduler.now(this.unit) - this.maxAge;
            TimedNode<Object> timedNode = this.head;
            while (true) {
                TimedNode<T> timedNode2 = timedNode.get();
                if (timedNode2 == null) {
                    this.head = timedNode;
                    return;
                } else if (timedNode2.time > now) {
                    this.head = timedNode;
                    return;
                } else {
                    timedNode = timedNode2;
                }
            }
        }

        public void trimFinal() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048585, this) != null) {
                return;
            }
            long now = this.scheduler.now(this.unit) - this.maxAge;
            TimedNode<Object> timedNode = this.head;
            while (true) {
                TimedNode<T> timedNode2 = timedNode.get();
                if (timedNode2.get() == null) {
                    if (timedNode.value != null) {
                        TimedNode<Object> timedNode3 = new TimedNode<>(null, 0L);
                        timedNode3.lazySet(timedNode.get());
                        this.head = timedNode3;
                        return;
                    }
                    this.head = timedNode;
                    return;
                } else if (timedNode2.time > now) {
                    if (timedNode.value != null) {
                        TimedNode<Object> timedNode4 = new TimedNode<>(null, 0L);
                        timedNode4.lazySet(timedNode.get());
                        this.head = timedNode4;
                        return;
                    }
                    this.head = timedNode;
                    return;
                } else {
                    timedNode = timedNode2;
                }
            }
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public void trimHead() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
                TimedNode<Object> timedNode = this.head;
                if (timedNode.value != null) {
                    TimedNode<Object> timedNode2 = new TimedNode<>(null, 0L);
                    timedNode2.lazySet(timedNode.get());
                    this.head = timedNode2;
                }
            }
        }

        public int size(TimedNode<Object> timedNode) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, timedNode)) == null) {
                int i2 = 0;
                while (i2 != Integer.MAX_VALUE) {
                    TimedNode<T> timedNode2 = timedNode.get();
                    if (timedNode2 == null) {
                        Object obj = timedNode.value;
                        return (NotificationLite.isComplete(obj) || NotificationLite.isError(obj)) ? i2 - 1 : i2;
                    }
                    i2++;
                    timedNode = timedNode2;
                }
                return i2;
            }
            return invokeL.intValue;
        }
    }

    /* loaded from: classes9.dex */
    public static final class SizeBoundReplayBuffer<T> extends AtomicReference<Object> implements ReplayBuffer<T> {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 1107649250281456395L;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile boolean done;
        public volatile Node<Object> head;
        public final int maxSize;
        public int size;
        public Node<Object> tail;

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
            this.maxSize = ObjectHelper.verifyPositive(i2, "maxSize");
            Node<Object> node = new Node<>(null);
            this.tail = node;
            this.head = node;
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public void add(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, t) == null) {
                Node<Object> node = new Node<>(t);
                Node<Object> node2 = this.tail;
                this.tail = node;
                this.size++;
                node2.set(node);
                trim();
            }
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public void addFinal(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
                Node<Object> node = new Node<>(obj);
                Node<Object> node2 = this.tail;
                this.tail = node;
                this.size++;
                node2.lazySet(node);
                trimHead();
                this.done = true;
            }
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        @Nullable
        public T getValue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                Node<Object> node = this.head;
                Node<Object> node2 = null;
                while (true) {
                    Node<T> node3 = node.get();
                    if (node3 == null) {
                        break;
                    }
                    node2 = node;
                    node = node3;
                }
                T t = (T) node.value;
                if (t == null) {
                    return null;
                }
                return (NotificationLite.isComplete(t) || NotificationLite.isError(t)) ? (T) node2.value : t;
            }
            return (T) invokeV.objValue;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r6v9, resolved type: T[] */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public T[] getValues(T[] tArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, tArr)) == null) {
                Node<T> node = this.head;
                int size = size();
                if (size == 0) {
                    if (tArr.length != 0) {
                        tArr[0] = null;
                    }
                } else {
                    if (tArr.length < size) {
                        tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), size));
                    }
                    for (int i2 = 0; i2 != size; i2++) {
                        node = node.get();
                        tArr[i2] = node.value;
                    }
                    if (tArr.length > size) {
                        tArr[size] = null;
                    }
                }
                return tArr;
            }
            return (T[]) ((Object[]) invokeL.objValue);
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:45:0x0017 */
        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public void replay(ReplayDisposable<T> replayDisposable) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048580, this, replayDisposable) == null) && replayDisposable.getAndIncrement() == 0) {
                Observer<? super T> observer = replayDisposable.actual;
                Node<T> node = (Node) replayDisposable.index;
                if (node == null) {
                    node = this.head;
                }
                int i2 = 1;
                while (!replayDisposable.cancelled) {
                    Node<T> node2 = node.get();
                    if (node2 == null) {
                        if (node.get() != null) {
                            continue;
                        } else {
                            replayDisposable.index = node;
                            i2 = replayDisposable.addAndGet(-i2);
                            if (i2 == 0) {
                                return;
                            }
                        }
                    } else {
                        Object obj = (T) node2.value;
                        if (this.done && node2.get() == null) {
                            if (NotificationLite.isComplete(obj)) {
                                observer.onComplete();
                            } else {
                                observer.onError(NotificationLite.getError(obj));
                            }
                            replayDisposable.index = null;
                            replayDisposable.cancelled = true;
                            return;
                        }
                        observer.onNext(obj);
                        node = node2;
                    }
                }
                replayDisposable.index = null;
            }
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public int size() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                Node<Object> node = this.head;
                int i2 = 0;
                while (i2 != Integer.MAX_VALUE) {
                    Node<T> node2 = node.get();
                    if (node2 == null) {
                        Object obj = node.value;
                        return (NotificationLite.isComplete(obj) || NotificationLite.isError(obj)) ? i2 - 1 : i2;
                    }
                    i2++;
                    node = node2;
                }
                return i2;
            }
            return invokeV.intValue;
        }

        public void trim() {
            int i2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (i2 = this.size) <= this.maxSize) {
                return;
            }
            this.size = i2 - 1;
            this.head = this.head.get();
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public void trimHead() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                Node<Object> node = this.head;
                if (node.value != null) {
                    Node<Object> node2 = new Node<>(null);
                    node2.lazySet(node.get());
                    this.head = node2;
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public static final class TimedNode<T> extends AtomicReference<TimedNode<T>> {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 6404226426336033100L;
        public transient /* synthetic */ FieldHolder $fh;
        public final long time;
        public final T value;

        public TimedNode(T t, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.value = t;
            this.time = j;
        }
    }

    /* loaded from: classes9.dex */
    public static final class UnboundedReplayBuffer<T> extends AtomicReference<Object> implements ReplayBuffer<T> {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -733876083048047795L;
        public transient /* synthetic */ FieldHolder $fh;
        public final List<Object> buffer;
        public volatile boolean done;
        public volatile int size;

        public UnboundedReplayBuffer(int i2) {
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
            this.buffer = new ArrayList(ObjectHelper.verifyPositive(i2, "capacityHint"));
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public void add(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, t) == null) {
                this.buffer.add(t);
                this.size++;
            }
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public void addFinal(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
                this.buffer.add(obj);
                trimHead();
                this.size++;
                this.done = true;
            }
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        @Nullable
        public T getValue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                int i2 = this.size;
                if (i2 != 0) {
                    List<Object> list = this.buffer;
                    T t = (T) list.get(i2 - 1);
                    if (NotificationLite.isComplete(t) || NotificationLite.isError(t)) {
                        if (i2 == 1) {
                            return null;
                        }
                        return (T) list.get(i2 - 2);
                    }
                    return t;
                }
                return null;
            }
            return (T) invokeV.objValue;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r7v9, resolved type: T[] */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public T[] getValues(T[] tArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, tArr)) == null) {
                int i2 = this.size;
                if (i2 == 0) {
                    if (tArr.length != 0) {
                        tArr[0] = null;
                    }
                    return tArr;
                }
                List<Object> list = this.buffer;
                Object obj = list.get(i2 - 1);
                if ((NotificationLite.isComplete(obj) || NotificationLite.isError(obj)) && i2 - 1 == 0) {
                    if (tArr.length != 0) {
                        tArr[0] = null;
                    }
                    return tArr;
                }
                if (tArr.length < i2) {
                    tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), i2));
                }
                for (int i3 = 0; i3 < i2; i3++) {
                    tArr[i3] = list.get(i3);
                }
                if (tArr.length > i2) {
                    tArr[i2] = null;
                }
                return tArr;
            }
            return (T[]) ((Object[]) invokeL.objValue);
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public void replay(ReplayDisposable<T> replayDisposable) {
            int i2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048580, this, replayDisposable) == null) && replayDisposable.getAndIncrement() == 0) {
                List<Object> list = this.buffer;
                Observer<? super T> observer = replayDisposable.actual;
                Integer num = (Integer) replayDisposable.index;
                int i3 = 0;
                if (num != null) {
                    i3 = num.intValue();
                } else {
                    replayDisposable.index = 0;
                }
                int i4 = 1;
                while (!replayDisposable.cancelled) {
                    int i5 = this.size;
                    while (i5 != i3) {
                        if (replayDisposable.cancelled) {
                            replayDisposable.index = null;
                            return;
                        }
                        Object obj = list.get(i3);
                        if (this.done && (i2 = i3 + 1) == i5 && i2 == (i5 = this.size)) {
                            if (NotificationLite.isComplete(obj)) {
                                observer.onComplete();
                            } else {
                                observer.onError(NotificationLite.getError(obj));
                            }
                            replayDisposable.index = null;
                            replayDisposable.cancelled = true;
                            return;
                        }
                        observer.onNext(obj);
                        i3++;
                    }
                    if (i3 == this.size) {
                        replayDisposable.index = Integer.valueOf(i3);
                        i4 = replayDisposable.addAndGet(-i4);
                        if (i4 == 0) {
                            return;
                        }
                    }
                }
                replayDisposable.index = null;
            }
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public int size() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                int i2 = this.size;
                if (i2 != 0) {
                    int i3 = i2 - 1;
                    Object obj = this.buffer.get(i3);
                    return (NotificationLite.isComplete(obj) || NotificationLite.isError(obj)) ? i3 : i2;
                }
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public void trimHead() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(160906801, "Lio/reactivex/subjects/ReplaySubject;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(160906801, "Lio/reactivex/subjects/ReplaySubject;");
                return;
            }
        }
        EMPTY = new ReplayDisposable[0];
        TERMINATED = new ReplayDisposable[0];
        EMPTY_ARRAY = new Object[0];
    }

    public ReplaySubject(ReplayBuffer<T> replayBuffer) {
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
    }

    @CheckReturnValue
    public static <T> ReplaySubject<T> create() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new ReplaySubject<>(new UnboundedReplayBuffer(16)) : (ReplaySubject) invokeV.objValue;
    }

    public static <T> ReplaySubject<T> createUnbounded() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? new ReplaySubject<>(new SizeBoundReplayBuffer(Integer.MAX_VALUE)) : (ReplaySubject) invokeV.objValue;
    }

    @CheckReturnValue
    public static <T> ReplaySubject<T> createWithSize(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(AdIconUtil.AD_TEXT_ID, null, i2)) == null) ? new ReplaySubject<>(new SizeBoundReplayBuffer(i2)) : (ReplaySubject) invokeI.objValue;
    }

    @CheckReturnValue
    public static <T> ReplaySubject<T> createWithTime(long j, TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{Long.valueOf(j), timeUnit, scheduler})) == null) ? new ReplaySubject<>(new SizeAndTimeBoundReplayBuffer(Integer.MAX_VALUE, j, timeUnit, scheduler)) : (ReplaySubject) invokeCommon.objValue;
    }

    @CheckReturnValue
    public static <T> ReplaySubject<T> createWithTimeAndSize(long j, TimeUnit timeUnit, Scheduler scheduler, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{Long.valueOf(j), timeUnit, scheduler, Integer.valueOf(i2)})) == null) ? new ReplaySubject<>(new SizeAndTimeBoundReplayBuffer(i2, j, timeUnit, scheduler)) : (ReplaySubject) invokeCommon.objValue;
    }

    public boolean add(ReplayDisposable<T> replayDisposable) {
        ReplayDisposable<T>[] replayDisposableArr;
        ReplayDisposable<T>[] replayDisposableArr2;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, replayDisposable)) == null) {
            do {
                replayDisposableArr = this.observers.get();
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

    @Experimental
    public void cleanupBuffer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.buffer.trimHead();
        }
    }

    @Override // io.reactivex.subjects.Subject
    @Nullable
    public Throwable getThrowable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Object obj = this.buffer.get();
            if (NotificationLite.isError(obj)) {
                return NotificationLite.getError(obj);
            }
            return null;
        }
        return (Throwable) invokeV.objValue;
    }

    @Nullable
    public T getValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.buffer.getValue() : (T) invokeV.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: io.reactivex.subjects.ReplaySubject<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public Object[] getValues() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            Object[] values = getValues(EMPTY_ARRAY);
            return values == EMPTY_ARRAY ? new Object[0] : values;
        }
        return (Object[]) invokeV.objValue;
    }

    @Override // io.reactivex.subjects.Subject
    public boolean hasComplete() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? NotificationLite.isComplete(this.buffer.get()) : invokeV.booleanValue;
    }

    @Override // io.reactivex.subjects.Subject
    public boolean hasObservers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.observers.get().length != 0 : invokeV.booleanValue;
    }

    @Override // io.reactivex.subjects.Subject
    public boolean hasThrowable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? NotificationLite.isError(this.buffer.get()) : invokeV.booleanValue;
    }

    public boolean hasValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.buffer.size() != 0 : invokeV.booleanValue;
    }

    public int observerCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.observers.get().length : invokeV.intValue;
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.done) {
            return;
        }
        this.done = true;
        Object complete = NotificationLite.complete();
        ReplayBuffer<T> replayBuffer = this.buffer;
        replayBuffer.addFinal(complete);
        for (ReplayDisposable<T> replayDisposable : terminate(complete)) {
            replayBuffer.replay(replayDisposable);
        }
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, th) == null) {
            ObjectHelper.requireNonNull(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.done = true;
            Object error = NotificationLite.error(th);
            ReplayBuffer<T> replayBuffer = this.buffer;
            replayBuffer.addFinal(error);
            for (ReplayDisposable<T> replayDisposable : terminate(error)) {
                replayBuffer.replay(replayDisposable);
            }
        }
    }

    @Override // io.reactivex.Observer
    public void onNext(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, t) == null) {
            ObjectHelper.requireNonNull(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
            if (this.done) {
                return;
            }
            ReplayBuffer<T> replayBuffer = this.buffer;
            replayBuffer.add(t);
            for (ReplayDisposable<T> replayDisposable : this.observers.get()) {
                replayBuffer.replay(replayDisposable);
            }
        }
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable disposable) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, disposable) == null) && this.done) {
            disposable.dispose();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: java.util.concurrent.atomic.AtomicReference<io.reactivex.subjects.ReplaySubject$ReplayDisposable<T>[]> */
    /* JADX WARN: Multi-variable type inference failed */
    public void remove(ReplayDisposable<T> replayDisposable) {
        ReplayDisposable<T>[] replayDisposableArr;
        ReplayDisposable[] replayDisposableArr2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, replayDisposable) == null) {
            do {
                replayDisposableArr = this.observers.get();
                if (replayDisposableArr == TERMINATED || replayDisposableArr == EMPTY) {
                    return;
                }
                int length = replayDisposableArr.length;
                int i2 = -1;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    } else if (replayDisposableArr[i3] == replayDisposable) {
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
                    replayDisposableArr2 = EMPTY;
                } else {
                    ReplayDisposable[] replayDisposableArr3 = new ReplayDisposable[length - 1];
                    System.arraycopy(replayDisposableArr, 0, replayDisposableArr3, 0, i2);
                    System.arraycopy(replayDisposableArr, i2 + 1, replayDisposableArr3, i2, (length - i2) - 1);
                    replayDisposableArr2 = replayDisposableArr3;
                }
            } while (!this.observers.compareAndSet(replayDisposableArr, replayDisposableArr2));
        }
    }

    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.buffer.size() : invokeV.intValue;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, observer) == null) {
            ReplayDisposable<T> replayDisposable = new ReplayDisposable<>(observer, this);
            observer.onSubscribe(replayDisposable);
            if (replayDisposable.cancelled) {
                return;
            }
            if (add(replayDisposable) && replayDisposable.cancelled) {
                remove(replayDisposable);
            } else {
                this.buffer.replay(replayDisposable);
            }
        }
    }

    public ReplayDisposable<T>[] terminate(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, obj)) == null) {
            if (this.buffer.compareAndSet(null, obj)) {
                return this.observers.getAndSet(TERMINATED);
            }
            return TERMINATED;
        }
        return (ReplayDisposable[]) invokeL.objValue;
    }

    @CheckReturnValue
    public static <T> ReplaySubject<T> create(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) ? new ReplaySubject<>(new UnboundedReplayBuffer(i2)) : (ReplaySubject) invokeI.objValue;
    }

    public T[] getValues(T[] tArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, tArr)) == null) ? this.buffer.getValues(tArr) : (T[]) ((Object[]) invokeL.objValue);
    }
}
