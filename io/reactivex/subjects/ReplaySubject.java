package io.reactivex.subjects;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
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
/* loaded from: classes8.dex */
public final class ReplaySubject extends Subject {
    public static /* synthetic */ Interceptable $ic;
    public static final ReplayDisposable[] EMPTY;
    public static final Object[] EMPTY_ARRAY;
    public static final ReplayDisposable[] TERMINATED;
    public transient /* synthetic */ FieldHolder $fh;
    public final ReplayBuffer buffer;
    public boolean done;
    public final AtomicReference observers;

    /* loaded from: classes8.dex */
    public interface ReplayBuffer {
        void add(Object obj);

        void addFinal(Object obj);

        boolean compareAndSet(Object obj, Object obj2);

        Object get();

        Object getValue();

        Object[] getValues(Object[] objArr);

        void replay(ReplayDisposable replayDisposable);

        int size();

        void trimHead();
    }

    /* loaded from: classes8.dex */
    public final class Node extends AtomicReference {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 6404226426336033100L;
        public transient /* synthetic */ FieldHolder $fh;
        public final Object value;

        public Node(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.value = obj;
        }
    }

    /* loaded from: classes8.dex */
    public final class ReplayDisposable extends AtomicInteger implements Disposable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 466549804534799122L;
        public transient /* synthetic */ FieldHolder $fh;
        public final Observer actual;
        public volatile boolean cancelled;
        public Object index;
        public final ReplaySubject state;

        public ReplayDisposable(Observer observer, ReplaySubject replaySubject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {observer, replaySubject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !this.cancelled) {
                this.cancelled = true;
                this.state.remove(this);
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
    }

    /* loaded from: classes8.dex */
    public final class SizeAndTimeBoundReplayBuffer extends AtomicReference implements ReplayBuffer {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -8056260896137901749L;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile boolean done;
        public volatile TimedNode head;
        public final long maxAge;
        public final int maxSize;
        public final Scheduler scheduler;
        public int size;
        public TimedNode tail;
        public final TimeUnit unit;

        public SizeAndTimeBoundReplayBuffer(int i, long j, TimeUnit timeUnit, Scheduler scheduler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Long.valueOf(j), timeUnit, scheduler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.maxSize = ObjectHelper.verifyPositive(i, "maxSize");
            this.maxAge = ObjectHelper.verifyPositive(j, "maxAge");
            this.unit = (TimeUnit) ObjectHelper.requireNonNull(timeUnit, "unit is null");
            this.scheduler = (Scheduler) ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            TimedNode timedNode = new TimedNode(null, 0L);
            this.tail = timedNode;
            this.head = timedNode;
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public void add(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                TimedNode timedNode = new TimedNode(obj, this.scheduler.now(this.unit));
                TimedNode timedNode2 = this.tail;
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
                TimedNode timedNode = new TimedNode(obj, Long.MAX_VALUE);
                TimedNode timedNode2 = this.tail;
                this.tail = timedNode;
                this.size++;
                timedNode2.lazySet(timedNode);
                trimFinal();
                this.done = true;
            }
        }

        public TimedNode getHead() {
            InterceptResult invokeV;
            TimedNode timedNode;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                TimedNode timedNode2 = this.head;
                long now = this.scheduler.now(this.unit) - this.maxAge;
                Object obj = timedNode2.get();
                while (true) {
                    TimedNode timedNode3 = (TimedNode) obj;
                    timedNode = timedNode2;
                    timedNode2 = timedNode3;
                    if (timedNode2 == null || timedNode2.time > now) {
                        break;
                    }
                    obj = timedNode2.get();
                }
                return timedNode;
            }
            return (TimedNode) invokeV.objValue;
        }

        public void trim() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                int i = this.size;
                if (i > this.maxSize) {
                    this.size = i - 1;
                    this.head = (TimedNode) this.head.get();
                }
                long now = this.scheduler.now(this.unit) - this.maxAge;
                TimedNode timedNode = this.head;
                while (true) {
                    TimedNode timedNode2 = (TimedNode) timedNode.get();
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
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public Object getValue() {
            InterceptResult invokeV;
            Object obj;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                TimedNode timedNode = this.head;
                TimedNode timedNode2 = null;
                while (true) {
                    TimedNode timedNode3 = (TimedNode) timedNode.get();
                    if (timedNode3 == null) {
                        break;
                    }
                    timedNode2 = timedNode;
                    timedNode = timedNode3;
                }
                if (timedNode.time < this.scheduler.now(this.unit) - this.maxAge || (obj = timedNode.value) == null) {
                    return null;
                }
                if (!NotificationLite.isComplete(obj) && !NotificationLite.isError(obj)) {
                    return obj;
                }
                return timedNode2.value;
            }
            return invokeV.objValue;
        }

        public void trimFinal() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
                long now = this.scheduler.now(this.unit) - this.maxAge;
                TimedNode timedNode = this.head;
                while (true) {
                    TimedNode timedNode2 = (TimedNode) timedNode.get();
                    if (timedNode2.get() == null) {
                        if (timedNode.value != null) {
                            TimedNode timedNode3 = new TimedNode(null, 0L);
                            timedNode3.lazySet(timedNode.get());
                            this.head = timedNode3;
                            return;
                        }
                        this.head = timedNode;
                        return;
                    } else if (timedNode2.time > now) {
                        if (timedNode.value != null) {
                            TimedNode timedNode4 = new TimedNode(null, 0L);
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
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public Object[] getValues(Object[] objArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, objArr)) == null) {
                TimedNode head = getHead();
                int size = size(head);
                if (size == 0) {
                    if (objArr.length != 0) {
                        objArr[0] = null;
                    }
                } else {
                    if (objArr.length < size) {
                        objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), size);
                    }
                    for (int i = 0; i != size; i++) {
                        head = (TimedNode) head.get();
                        objArr[i] = head.value;
                    }
                    if (objArr.length > size) {
                        objArr[size] = null;
                    }
                }
                return objArr;
            }
            return (Object[]) invokeL.objValue;
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public void replay(ReplayDisposable replayDisposable) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048581, this, replayDisposable) != null) || replayDisposable.getAndIncrement() != 0) {
                return;
            }
            Observer observer = replayDisposable.actual;
            TimedNode timedNode = (TimedNode) replayDisposable.index;
            if (timedNode == null) {
                timedNode = getHead();
            }
            int i = 1;
            while (!replayDisposable.cancelled) {
                while (!replayDisposable.cancelled) {
                    TimedNode timedNode2 = (TimedNode) timedNode.get();
                    if (timedNode2 == null) {
                        if (timedNode.get() == null) {
                            replayDisposable.index = timedNode;
                            i = replayDisposable.addAndGet(-i);
                            if (i == 0) {
                                return;
                            }
                        }
                    } else {
                        Object obj = timedNode2.value;
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
            replayDisposable.index = null;
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public int size() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return size(getHead());
            }
            return invokeV.intValue;
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public void trimHead() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
                TimedNode timedNode = this.head;
                if (timedNode.value != null) {
                    TimedNode timedNode2 = new TimedNode(null, 0L);
                    timedNode2.lazySet(timedNode.get());
                    this.head = timedNode2;
                }
            }
        }

        public int size(TimedNode timedNode) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, timedNode)) == null) {
                int i = 0;
                while (i != Integer.MAX_VALUE) {
                    TimedNode timedNode2 = (TimedNode) timedNode.get();
                    if (timedNode2 == null) {
                        Object obj = timedNode.value;
                        if (NotificationLite.isComplete(obj) || NotificationLite.isError(obj)) {
                            return i - 1;
                        }
                        return i;
                    }
                    i++;
                    timedNode = timedNode2;
                }
                return i;
            }
            return invokeL.intValue;
        }
    }

    /* loaded from: classes8.dex */
    public final class SizeBoundReplayBuffer extends AtomicReference implements ReplayBuffer {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 1107649250281456395L;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile boolean done;
        public volatile Node head;
        public final int maxSize;
        public int size;
        public Node tail;

        public SizeBoundReplayBuffer(int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.maxSize = ObjectHelper.verifyPositive(i, "maxSize");
            Node node = new Node(null);
            this.tail = node;
            this.head = node;
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public void add(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                Node node = new Node(obj);
                Node node2 = this.tail;
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
                Node node = new Node(obj);
                Node node2 = this.tail;
                this.tail = node;
                this.size++;
                node2.lazySet(node);
                trimHead();
                this.done = true;
            }
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public Object getValue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                Node node = this.head;
                Node node2 = null;
                while (true) {
                    Node node3 = (Node) node.get();
                    if (node3 == null) {
                        break;
                    }
                    node2 = node;
                    node = node3;
                }
                Object obj = node.value;
                if (obj == null) {
                    return null;
                }
                if (!NotificationLite.isComplete(obj) && !NotificationLite.isError(obj)) {
                    return obj;
                }
                return node2.value;
            }
            return invokeV.objValue;
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public int size() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                Node node = this.head;
                int i = 0;
                while (i != Integer.MAX_VALUE) {
                    Node node2 = (Node) node.get();
                    if (node2 == null) {
                        Object obj = node.value;
                        if (NotificationLite.isComplete(obj) || NotificationLite.isError(obj)) {
                            return i - 1;
                        }
                        return i;
                    }
                    i++;
                    node = node2;
                }
                return i;
            }
            return invokeV.intValue;
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public Object[] getValues(Object[] objArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, objArr)) == null) {
                Node node = this.head;
                int size = size();
                if (size == 0) {
                    if (objArr.length != 0) {
                        objArr[0] = null;
                    }
                } else {
                    if (objArr.length < size) {
                        objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), size);
                    }
                    for (int i = 0; i != size; i++) {
                        node = (Node) node.get();
                        objArr[i] = node.value;
                    }
                    if (objArr.length > size) {
                        objArr[size] = null;
                    }
                }
                return objArr;
            }
            return (Object[]) invokeL.objValue;
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public void replay(ReplayDisposable replayDisposable) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048580, this, replayDisposable) != null) || replayDisposable.getAndIncrement() != 0) {
                return;
            }
            Observer observer = replayDisposable.actual;
            Node node = (Node) replayDisposable.index;
            if (node == null) {
                node = this.head;
            }
            int i = 1;
            while (!replayDisposable.cancelled) {
                Node node2 = (Node) node.get();
                if (node2 == null) {
                    if (node.get() != null) {
                        continue;
                    } else {
                        replayDisposable.index = node;
                        i = replayDisposable.addAndGet(-i);
                        if (i == 0) {
                            return;
                        }
                    }
                } else {
                    Object obj = node2.value;
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

        public void trim() {
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (i = this.size) > this.maxSize) {
                this.size = i - 1;
                this.head = (Node) this.head.get();
            }
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public void trimHead() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                Node node = this.head;
                if (node.value != null) {
                    Node node2 = new Node(null);
                    node2.lazySet(node.get());
                    this.head = node2;
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public final class TimedNode extends AtomicReference {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 6404226426336033100L;
        public transient /* synthetic */ FieldHolder $fh;
        public final long time;
        public final Object value;

        public TimedNode(Object obj, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {obj, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.value = obj;
            this.time = j;
        }
    }

    /* loaded from: classes8.dex */
    public final class UnboundedReplayBuffer extends AtomicReference implements ReplayBuffer {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -733876083048047795L;
        public transient /* synthetic */ FieldHolder $fh;
        public final List buffer;
        public volatile boolean done;
        public volatile int size;

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public void trimHead() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            }
        }

        public UnboundedReplayBuffer(int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.buffer = new ArrayList(ObjectHelper.verifyPositive(i, "capacityHint"));
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public void add(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                this.buffer.add(obj);
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
        public Object getValue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                int i = this.size;
                if (i == 0) {
                    return null;
                }
                List list = this.buffer;
                Object obj = list.get(i - 1);
                if (!NotificationLite.isComplete(obj) && !NotificationLite.isError(obj)) {
                    return obj;
                }
                if (i == 1) {
                    return null;
                }
                return list.get(i - 2);
            }
            return invokeV.objValue;
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public Object[] getValues(Object[] objArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, objArr)) == null) {
                int i = this.size;
                if (i == 0) {
                    if (objArr.length != 0) {
                        objArr[0] = null;
                    }
                    return objArr;
                }
                List list = this.buffer;
                Object obj = list.get(i - 1);
                if ((NotificationLite.isComplete(obj) || NotificationLite.isError(obj)) && i - 1 == 0) {
                    if (objArr.length != 0) {
                        objArr[0] = null;
                    }
                    return objArr;
                }
                if (objArr.length < i) {
                    objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), i);
                }
                for (int i2 = 0; i2 < i; i2++) {
                    objArr[i2] = list.get(i2);
                }
                if (objArr.length > i) {
                    objArr[i] = null;
                }
                return objArr;
            }
            return (Object[]) invokeL.objValue;
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public void replay(ReplayDisposable replayDisposable) {
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048580, this, replayDisposable) != null) || replayDisposable.getAndIncrement() != 0) {
                return;
            }
            List list = this.buffer;
            Observer observer = replayDisposable.actual;
            Integer num = (Integer) replayDisposable.index;
            int i2 = 0;
            if (num != null) {
                i2 = num.intValue();
            } else {
                replayDisposable.index = 0;
            }
            int i3 = 1;
            while (!replayDisposable.cancelled) {
                int i4 = this.size;
                while (i4 != i2) {
                    if (replayDisposable.cancelled) {
                        replayDisposable.index = null;
                        return;
                    }
                    Object obj = list.get(i2);
                    if (this.done && (i = i2 + 1) == i4 && i == (i4 = this.size)) {
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
                    i2++;
                }
                if (i2 == this.size) {
                    replayDisposable.index = Integer.valueOf(i2);
                    i3 = replayDisposable.addAndGet(-i3);
                    if (i3 == 0) {
                        return;
                    }
                }
            }
            replayDisposable.index = null;
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public int size() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                int i = this.size;
                if (i != 0) {
                    int i2 = i - 1;
                    Object obj = this.buffer.get(i2);
                    if (!NotificationLite.isComplete(obj) && !NotificationLite.isError(obj)) {
                        return i;
                    }
                    return i2;
                }
                return 0;
            }
            return invokeV.intValue;
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

    @CheckReturnValue
    public static ReplaySubject create() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return new ReplaySubject(new UnboundedReplayBuffer(16));
        }
        return (ReplaySubject) invokeV.objValue;
    }

    public static ReplaySubject createUnbounded() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return new ReplaySubject(new SizeBoundReplayBuffer(Integer.MAX_VALUE));
        }
        return (ReplaySubject) invokeV.objValue;
    }

    public void cleanupBuffer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.buffer.trimHead();
        }
    }

    @Override // io.reactivex.subjects.Subject
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

    public Object getValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.buffer.getValue();
        }
        return invokeV.objValue;
    }

    public Object[] getValues() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            Object[] values = getValues(EMPTY_ARRAY);
            if (values == EMPTY_ARRAY) {
                return new Object[0];
            }
            return values;
        }
        return (Object[]) invokeV.objValue;
    }

    @Override // io.reactivex.subjects.Subject
    public boolean hasComplete() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return NotificationLite.isComplete(this.buffer.get());
        }
        return invokeV.booleanValue;
    }

    @Override // io.reactivex.subjects.Subject
    public boolean hasObservers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (((ReplayDisposable[]) this.observers.get()).length != 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // io.reactivex.subjects.Subject
    public boolean hasThrowable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return NotificationLite.isError(this.buffer.get());
        }
        return invokeV.booleanValue;
    }

    public boolean hasValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.buffer.size() != 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public int observerCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return ((ReplayDisposable[]) this.observers.get()).length;
        }
        return invokeV.intValue;
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048587, this) != null) || this.done) {
            return;
        }
        this.done = true;
        Object complete = NotificationLite.complete();
        ReplayBuffer replayBuffer = this.buffer;
        replayBuffer.addFinal(complete);
        for (ReplayDisposable replayDisposable : terminate(complete)) {
            replayBuffer.replay(replayDisposable);
        }
    }

    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.buffer.size();
        }
        return invokeV.intValue;
    }

    public ReplaySubject(ReplayBuffer replayBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {replayBuffer};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.buffer = replayBuffer;
        this.observers = new AtomicReference(EMPTY);
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
            ReplayBuffer replayBuffer = this.buffer;
            replayBuffer.addFinal(error);
            for (ReplayDisposable replayDisposable : terminate(error)) {
                replayBuffer.replay(replayDisposable);
            }
        }
    }

    @Override // io.reactivex.Observer
    public void onNext(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, obj) == null) {
            ObjectHelper.requireNonNull(obj, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
            if (this.done) {
                return;
            }
            ReplayBuffer replayBuffer = this.buffer;
            replayBuffer.add(obj);
            for (ReplayDisposable replayDisposable : (ReplayDisposable[]) this.observers.get()) {
                replayBuffer.replay(replayDisposable);
            }
        }
    }

    @CheckReturnValue
    public static ReplaySubject create(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) {
            return new ReplaySubject(new UnboundedReplayBuffer(i));
        }
        return (ReplaySubject) invokeI.objValue;
    }

    @CheckReturnValue
    public static ReplaySubject createWithSize(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65541, null, i)) == null) {
            return new ReplaySubject(new SizeBoundReplayBuffer(i));
        }
        return (ReplaySubject) invokeI.objValue;
    }

    public boolean add(ReplayDisposable replayDisposable) {
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

    public Object[] getValues(Object[] objArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, objArr)) == null) {
            return this.buffer.getValues(objArr);
        }
        return (Object[]) invokeL.objValue;
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable disposable) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, disposable) == null) && this.done) {
            disposable.dispose();
        }
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer observer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, observer) == null) {
            ReplayDisposable replayDisposable = new ReplayDisposable(observer, this);
            observer.onSubscribe(replayDisposable);
            if (!replayDisposable.cancelled) {
                if (add(replayDisposable) && replayDisposable.cancelled) {
                    remove(replayDisposable);
                } else {
                    this.buffer.replay(replayDisposable);
                }
            }
        }
    }

    public ReplayDisposable[] terminate(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, obj)) == null) {
            if (this.buffer.compareAndSet(null, obj)) {
                return (ReplayDisposable[]) this.observers.getAndSet(TERMINATED);
            }
            return TERMINATED;
        }
        return (ReplayDisposable[]) invokeL.objValue;
    }

    @CheckReturnValue
    public static ReplaySubject createWithTime(long j, TimeUnit timeUnit, Scheduler scheduler) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{Long.valueOf(j), timeUnit, scheduler})) == null) {
            return new ReplaySubject(new SizeAndTimeBoundReplayBuffer(Integer.MAX_VALUE, j, timeUnit, scheduler));
        }
        return (ReplaySubject) invokeCommon.objValue;
    }

    @CheckReturnValue
    public static ReplaySubject createWithTimeAndSize(long j, TimeUnit timeUnit, Scheduler scheduler, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{Long.valueOf(j), timeUnit, scheduler, Integer.valueOf(i)})) == null) {
            return new ReplaySubject(new SizeAndTimeBoundReplayBuffer(i, j, timeUnit, scheduler));
        }
        return (ReplaySubject) invokeCommon.objValue;
    }

    public void remove(ReplayDisposable replayDisposable) {
        ReplayDisposable[] replayDisposableArr;
        ReplayDisposable[] replayDisposableArr2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, replayDisposable) == null) {
            do {
                replayDisposableArr = (ReplayDisposable[]) this.observers.get();
                if (replayDisposableArr != TERMINATED && replayDisposableArr != EMPTY) {
                    int length = replayDisposableArr.length;
                    int i = -1;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            break;
                        } else if (replayDisposableArr[i2] == replayDisposable) {
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
                } else {
                    return;
                }
            } while (!this.observers.compareAndSet(replayDisposableArr, replayDisposableArr2));
        }
    }
}
