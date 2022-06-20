package rx.internal.operators;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.av9;
import com.repackage.dv9;
import com.repackage.ev9;
import com.repackage.ex9;
import com.repackage.jv9;
import com.repackage.kv9;
import com.repackage.lv9;
import com.repackage.lz9;
import com.repackage.ov9;
import com.repackage.uz9;
import com.repackage.vy9;
import com.repackage.xu9;
import com.repackage.zu9;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.exceptions.OnErrorThrowable;
/* loaded from: classes8.dex */
public final class OperatorReplay<T> extends vy9<T> {
    public static /* synthetic */ Interceptable $ic;
    public static final ov9 e;
    public transient /* synthetic */ FieldHolder $fh;
    public final xu9<? extends T> b;
    public final AtomicReference<f<T>> c;
    public final ov9<? extends e<T>> d;

    /* loaded from: classes8.dex */
    public static class BoundedReplayBuffer<T> extends AtomicReference<Node> implements e<T> {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 2346567790059478686L;
        public transient /* synthetic */ FieldHolder $fh;
        public long index;
        public int size;
        public Node tail;

        public BoundedReplayBuffer() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Node node = new Node(null, 0L);
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
            Node initialHead = getInitialHead();
            while (true) {
                initialHead = initialHead.get();
                if (initialHead == null) {
                    return;
                }
                Object leaveTransform = leaveTransform(initialHead.value);
                if (NotificationLite.f(leaveTransform) || NotificationLite.g(leaveTransform)) {
                    return;
                }
                collection.add((Object) NotificationLite.e(leaveTransform));
            }
        }

        @Override // rx.internal.operators.OperatorReplay.e
        public final void complete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                Object enterTransform = enterTransform(NotificationLite.b());
                long j = this.index + 1;
                this.index = j;
                addLast(new Node(enterTransform, j));
                truncateFinal();
            }
        }

        public Object enterTransform(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) ? obj : invokeL.objValue;
        }

        @Override // rx.internal.operators.OperatorReplay.e
        public final void error(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, th) == null) {
                Object enterTransform = enterTransform(NotificationLite.c(th));
                long j = this.index + 1;
                this.index = j;
                addLast(new Node(enterTransform, j));
                truncateFinal();
            }
        }

        public Node getInitialHead() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? get() : (Node) invokeV.objValue;
        }

        public boolean hasCompleted() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                Object obj = this.tail.value;
                return obj != null && NotificationLite.f(leaveTransform(obj));
            }
            return invokeV.booleanValue;
        }

        public boolean hasError() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                Object obj = this.tail.value;
                return obj != null && NotificationLite.g(leaveTransform(obj));
            }
            return invokeV.booleanValue;
        }

        public Object leaveTransform(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, obj)) == null) ? obj : invokeL.objValue;
        }

        @Override // rx.internal.operators.OperatorReplay.e
        public final void next(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, t) == null) {
                Object enterTransform = enterTransform(NotificationLite.h(t));
                long j = this.index + 1;
                this.index = j;
                addLast(new Node(enterTransform, j));
                truncate();
            }
        }

        public final void removeFirst() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
                Node node = get().get();
                if (node != null) {
                    this.size--;
                    setFirst(node);
                    return;
                }
                throw new IllegalStateException("Empty list!");
            }
        }

        public final void removeSome(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
                Node node = get();
                while (i > 0) {
                    node = node.get();
                    i--;
                    this.size--;
                }
                setFirst(node);
            }
        }

        @Override // rx.internal.operators.OperatorReplay.e
        public final void replay(InnerProducer<T> innerProducer) {
            dv9<? super T> dv9Var;
            Node node;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, innerProducer) == null) {
                synchronized (innerProducer) {
                    if (innerProducer.emitting) {
                        innerProducer.missed = true;
                        return;
                    }
                    innerProducer.emitting = true;
                    while (!innerProducer.isUnsubscribed()) {
                        Node node2 = (Node) innerProducer.index();
                        if (node2 == null) {
                            node2 = getInitialHead();
                            innerProducer.index = node2;
                            innerProducer.addTotalRequested(node2.index);
                        }
                        if (innerProducer.isUnsubscribed() || (dv9Var = innerProducer.child) == null) {
                            return;
                        }
                        long j = innerProducer.get();
                        long j2 = 0;
                        while (j2 != j && (node = node2.get()) != null) {
                            Object leaveTransform = leaveTransform(node.value);
                            try {
                                if (NotificationLite.a(dv9Var, leaveTransform)) {
                                    innerProducer.index = null;
                                    return;
                                }
                                j2++;
                                if (innerProducer.isUnsubscribed()) {
                                    return;
                                }
                                node2 = node;
                            } catch (Throwable th) {
                                innerProducer.index = null;
                                jv9.e(th);
                                innerProducer.unsubscribe();
                                if (NotificationLite.g(leaveTransform) || NotificationLite.f(leaveTransform)) {
                                    return;
                                }
                                dv9Var.onError(OnErrorThrowable.addValueAsLastCause(th, NotificationLite.e(leaveTransform)));
                                return;
                            }
                        }
                        if (j2 != 0) {
                            innerProducer.index = node2;
                            if (j != Long.MAX_VALUE) {
                                innerProducer.produced(j2);
                            }
                        }
                        synchronized (innerProducer) {
                            if (!innerProducer.missed) {
                                innerProducer.emitting = false;
                                return;
                            }
                            innerProducer.missed = false;
                        }
                    }
                }
            }
        }

        public final void setFirst(Node node) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048589, this, node) == null) {
                set(node);
            }
        }

        public void truncate() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            }
        }

        public void truncateFinal() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class InnerProducer<T> extends AtomicLong implements zu9, ev9 {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long UNSUBSCRIBED = Long.MIN_VALUE;
        public static final long serialVersionUID = -4453897557930727610L;
        public transient /* synthetic */ FieldHolder $fh;
        public dv9<? super T> child;
        public boolean emitting;
        public Object index;
        public boolean missed;
        public final f<T> parent;
        public final AtomicLong totalRequested;

        public InnerProducer(f<T> fVar, dv9<? super T> dv9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, dv9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.parent = fVar;
            this.child = dv9Var;
            this.totalRequested = new AtomicLong();
        }

        public void addTotalRequested(long j) {
            long j2;
            long j3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                do {
                    j2 = this.totalRequested.get();
                    j3 = j2 + j;
                    if (j3 < 0) {
                        j3 = Long.MAX_VALUE;
                    }
                } while (!this.totalRequested.compareAndSet(j2, j3));
            }
        }

        public <U> U index() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (U) this.index : (U) invokeV.objValue;
        }

        @Override // com.repackage.ev9
        public boolean isUnsubscribed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? get() == Long.MIN_VALUE : invokeV.booleanValue;
        }

        public long produced(long j) {
            InterceptResult invokeJ;
            long j2;
            long j3;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j)) == null) {
                if (j > 0) {
                    do {
                        j2 = get();
                        if (j2 == Long.MIN_VALUE) {
                            return Long.MIN_VALUE;
                        }
                        j3 = j2 - j;
                        if (j3 < 0) {
                            throw new IllegalStateException("More produced (" + j + ") than requested (" + j2 + SmallTailInfo.EMOTION_SUFFIX);
                        }
                    } while (!compareAndSet(j2, j3));
                    return j3;
                }
                throw new IllegalArgumentException("Cant produce zero or less");
            }
            return invokeJ.longValue;
        }

        @Override // com.repackage.zu9
        public void request(long j) {
            int i;
            long j2;
            long j3;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(1048580, this, j) == null) || j < 0) {
                return;
            }
            do {
                j2 = get();
                if (j2 == Long.MIN_VALUE) {
                    return;
                }
                if (j2 >= 0 && i == 0) {
                    return;
                }
                j3 = j2 + j;
                if (j3 < 0) {
                    j3 = Long.MAX_VALUE;
                }
            } while (!compareAndSet(j2, j3));
            addTotalRequested(j);
            this.parent.k(this);
            this.parent.e.replay(this);
        }

        @Override // com.repackage.ev9
        public void unsubscribe() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || get() == Long.MIN_VALUE || getAndSet(Long.MIN_VALUE) == Long.MIN_VALUE) {
                return;
            }
            this.parent.l(this);
            this.parent.k(this);
            this.child = null;
        }
    }

    /* loaded from: classes8.dex */
    public static final class Node extends AtomicReference<Node> {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 245354315435971818L;
        public transient /* synthetic */ FieldHolder $fh;
        public final long index;
        public final Object value;

        public Node(Object obj, long j) {
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
            this.index = j;
        }
    }

    /* loaded from: classes8.dex */
    public static final class SizeAndTimeBoundReplayBuffer<T> extends BoundedReplayBuffer<T> {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 3457957419649567404L;
        public transient /* synthetic */ FieldHolder $fh;
        public final int limit;
        public final long maxAgeInMillis;
        public final av9 scheduler;

        public SizeAndTimeBoundReplayBuffer(int i, long j, av9 av9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Long.valueOf(j), av9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.scheduler = av9Var;
            this.limit = i;
            this.maxAgeInMillis = j;
        }

        @Override // rx.internal.operators.OperatorReplay.BoundedReplayBuffer
        public Object enterTransform(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) ? new lz9(this.scheduler.now(), obj) : invokeL.objValue;
        }

        @Override // rx.internal.operators.OperatorReplay.BoundedReplayBuffer
        public Node getInitialHead() {
            InterceptResult invokeV;
            Node node;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                long now = this.scheduler.now() - this.maxAgeInMillis;
                Node node2 = get();
                Node node3 = node2.get();
                while (true) {
                    Node node4 = node3;
                    node = node2;
                    node2 = node4;
                    if (node2 == null || ((lz9) node2.value).a() > now) {
                        break;
                    }
                    node3 = node2.get();
                }
                return node;
            }
            return (Node) invokeV.objValue;
        }

        @Override // rx.internal.operators.OperatorReplay.BoundedReplayBuffer
        public Object leaveTransform(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) ? ((lz9) obj).b() : invokeL.objValue;
        }

        @Override // rx.internal.operators.OperatorReplay.BoundedReplayBuffer
        public void truncate() {
            Node node;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                long now = this.scheduler.now() - this.maxAgeInMillis;
                Node node2 = get();
                Node node3 = node2.get();
                int i = 0;
                while (true) {
                    Node node4 = node3;
                    node = node2;
                    node2 = node4;
                    if (node2 != null) {
                        int i2 = this.size;
                        if (i2 > this.limit) {
                            i++;
                            this.size = i2 - 1;
                            node3 = node2.get();
                        } else if (((lz9) node2.value).a() > now) {
                            break;
                        } else {
                            i++;
                            this.size--;
                            node3 = node2.get();
                        }
                    } else {
                        break;
                    }
                }
                if (i != 0) {
                    setFirst(node);
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x0040, code lost:
            setFirst(r3);
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x0043, code lost:
            return;
         */
        @Override // rx.internal.operators.OperatorReplay.BoundedReplayBuffer
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void truncateFinal() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                long now = this.scheduler.now() - this.maxAgeInMillis;
                Node node = get();
                Node node2 = node.get();
                int i = 0;
                while (true) {
                    Node node3 = node2;
                    Node node4 = node;
                    node = node3;
                    if (node == null || this.size <= 1 || ((lz9) node.value).a() > now) {
                        break;
                    }
                    i++;
                    this.size--;
                    node2 = node.get();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class SizeBoundReplayBuffer<T> extends BoundedReplayBuffer<T> {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -5898283885385201806L;
        public transient /* synthetic */ FieldHolder $fh;
        public final int limit;

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
            this.limit = i;
        }

        @Override // rx.internal.operators.OperatorReplay.BoundedReplayBuffer
        public void truncate() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.size <= this.limit) {
                return;
            }
            removeFirst();
        }
    }

    /* loaded from: classes8.dex */
    public static final class UnboundedReplayBuffer<T> extends ArrayList<Object> implements e<T> {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 7063189396499112664L;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile int size;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UnboundedReplayBuffer(int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // rx.internal.operators.OperatorReplay.e
        public void complete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                add(NotificationLite.b());
                this.size++;
            }
        }

        @Override // rx.internal.operators.OperatorReplay.e
        public void error(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                add(NotificationLite.c(th));
                this.size++;
            }
        }

        @Override // rx.internal.operators.OperatorReplay.e
        public void next(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t) == null) {
                add(NotificationLite.h(t));
                this.size++;
            }
        }

        @Override // rx.internal.operators.OperatorReplay.e
        public void replay(InnerProducer<T> innerProducer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, innerProducer) == null) {
                synchronized (innerProducer) {
                    if (innerProducer.emitting) {
                        innerProducer.missed = true;
                        return;
                    }
                    innerProducer.emitting = true;
                    while (!innerProducer.isUnsubscribed()) {
                        int i = this.size;
                        Integer num = (Integer) innerProducer.index();
                        int intValue = num != null ? num.intValue() : 0;
                        dv9<? super T> dv9Var = innerProducer.child;
                        if (dv9Var == null) {
                            return;
                        }
                        long j = innerProducer.get();
                        long j2 = 0;
                        while (j2 != j && intValue < i) {
                            Object obj = get(intValue);
                            try {
                                if (NotificationLite.a(dv9Var, obj) || innerProducer.isUnsubscribed()) {
                                    return;
                                }
                                intValue++;
                                j2++;
                            } catch (Throwable th) {
                                jv9.e(th);
                                innerProducer.unsubscribe();
                                if (NotificationLite.g(obj) || NotificationLite.f(obj)) {
                                    return;
                                }
                                dv9Var.onError(OnErrorThrowable.addValueAsLastCause(th, NotificationLite.e(obj)));
                                return;
                            }
                        }
                        if (j2 != 0) {
                            innerProducer.index = Integer.valueOf(intValue);
                            if (j != Long.MAX_VALUE) {
                                innerProducer.produced(j2);
                            }
                        }
                        synchronized (innerProducer) {
                            if (!innerProducer.missed) {
                                innerProducer.emitting = false;
                                return;
                            }
                            innerProducer.missed = false;
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class a implements ov9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.ov9
        public Object call() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new UnboundedReplayBuffer(16) : invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class b implements ov9<e<T>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        public b(int i) {
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
            this.a = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ov9
        public e<T> call() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new SizeBoundReplayBuffer(this.a) : (e) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class c implements ov9<e<T>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ long b;
        public final /* synthetic */ av9 c;

        public c(int i, long j, av9 av9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Long.valueOf(j), av9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i;
            this.b = j;
            this.c = av9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ov9
        public e<T> call() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new SizeAndTimeBoundReplayBuffer(this.a, this.b, this.c) : (e) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class d implements xu9.a<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AtomicReference a;
        public final /* synthetic */ ov9 b;

        public d(AtomicReference atomicReference, ov9 ov9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {atomicReference, ov9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = atomicReference;
            this.b = ov9Var;
        }

        @Override // com.repackage.xu9.a, com.repackage.lv9
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((dv9) ((dv9) obj));
        }

        public void call(dv9<? super T> dv9Var) {
            f fVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dv9Var) == null) {
                while (true) {
                    fVar = (f) this.a.get();
                    if (fVar != null) {
                        break;
                    }
                    f fVar2 = new f((e) this.b.call());
                    fVar2.i();
                    if (this.a.compareAndSet(fVar, fVar2)) {
                        fVar = fVar2;
                        break;
                    }
                }
                InnerProducer<T> innerProducer = new InnerProducer<>(fVar, dv9Var);
                fVar.g(innerProducer);
                dv9Var.b(innerProducer);
                fVar.e.replay(innerProducer);
                dv9Var.f(innerProducer);
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface e<T> {
        void complete();

        void error(Throwable th);

        void next(T t);

        void replay(InnerProducer<T> innerProducer);
    }

    /* loaded from: classes8.dex */
    public static final class f<T> extends dv9<T> implements ev9 {
        public static /* synthetic */ Interceptable $ic;
        public static final InnerProducer[] t;
        public transient /* synthetic */ FieldHolder $fh;
        public final e<T> e;
        public boolean f;
        public volatile boolean g;
        public final ex9<InnerProducer<T>> h;
        public InnerProducer<T>[] i;
        public volatile long j;
        public long k;
        public final AtomicBoolean l;
        public boolean m;
        public boolean n;
        public long o;
        public long p;
        public volatile zu9 q;
        public List<InnerProducer<T>> r;
        public boolean s;

        /* loaded from: classes8.dex */
        public class a implements kv9 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ f a;

            public a(f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = fVar;
            }

            @Override // com.repackage.kv9
            public void call() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.g) {
                    return;
                }
                synchronized (this.a.h) {
                    if (!this.a.g) {
                        this.a.h.g();
                        this.a.j++;
                        this.a.g = true;
                    }
                }
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1234180007, "Lrx/internal/operators/OperatorReplay$f;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1234180007, "Lrx/internal/operators/OperatorReplay$f;");
                    return;
                }
            }
            t = new InnerProducer[0];
        }

        public f(e<T> eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.e = eVar;
            this.h = new ex9<>();
            this.i = t;
            this.l = new AtomicBoolean();
            e(0L);
        }

        @Override // com.repackage.dv9
        public void f(zu9 zu9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, zu9Var) == null) {
                if (this.q == null) {
                    this.q = zu9Var;
                    k(null);
                    m();
                    return;
                }
                throw new IllegalStateException("Only a single producer can be set on a Subscriber.");
            }
        }

        public boolean g(InnerProducer<T> innerProducer) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, innerProducer)) == null) {
                if (innerProducer != null) {
                    if (this.g) {
                        return false;
                    }
                    synchronized (this.h) {
                        if (this.g) {
                            return false;
                        }
                        this.h.a(innerProducer);
                        this.j++;
                        return true;
                    }
                }
                throw null;
            }
            return invokeL.booleanValue;
        }

        public InnerProducer<T>[] h() {
            InterceptResult invokeV;
            InnerProducer<T>[] innerProducerArr;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                synchronized (this.h) {
                    InnerProducer<T>[] h = this.h.h();
                    int length = h.length;
                    innerProducerArr = new InnerProducer[length];
                    System.arraycopy(h, 0, innerProducerArr, 0, length);
                }
                return innerProducerArr;
            }
            return (InnerProducer[]) invokeV.objValue;
        }

        public void i() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                b(uz9.a(new a(this)));
            }
        }

        public void j(long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                long j3 = this.p;
                zu9 zu9Var = this.q;
                long j4 = j - j2;
                if (j4 == 0) {
                    if (j3 == 0 || zu9Var == null) {
                        return;
                    }
                    this.p = 0L;
                    zu9Var.request(j3);
                    return;
                }
                this.o = j;
                if (zu9Var == null) {
                    long j5 = j3 + j4;
                    if (j5 < 0) {
                        j5 = Long.MAX_VALUE;
                    }
                    this.p = j5;
                } else if (j3 != 0) {
                    this.p = 0L;
                    zu9Var.request(j3 + j4);
                } else {
                    zu9Var.request(j4);
                }
            }
        }

        public void k(InnerProducer<T> innerProducer) {
            InnerProducer<T>[] h;
            long j;
            List<InnerProducer<T>> list;
            boolean z;
            long j2;
            InnerProducer<T>[] h2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048581, this, innerProducer) == null) || isUnsubscribed()) {
                return;
            }
            synchronized (this) {
                if (this.m) {
                    if (innerProducer != null) {
                        List list2 = this.r;
                        if (list2 == null) {
                            list2 = new ArrayList();
                            this.r = list2;
                        }
                        list2.add(innerProducer);
                    } else {
                        this.s = true;
                    }
                    this.n = true;
                    return;
                }
                this.m = true;
                long j3 = this.o;
                if (innerProducer != null) {
                    j = Math.max(j3, innerProducer.totalRequested.get());
                } else {
                    long j4 = j3;
                    for (InnerProducer<T> innerProducer2 : h()) {
                        if (innerProducer2 != null) {
                            j4 = Math.max(j4, innerProducer2.totalRequested.get());
                        }
                    }
                    j = j4;
                }
                j(j, j3);
                while (!isUnsubscribed()) {
                    synchronized (this) {
                        if (!this.n) {
                            this.m = false;
                            return;
                        }
                        this.n = false;
                        list = this.r;
                        this.r = null;
                        z = this.s;
                        this.s = false;
                    }
                    long j5 = this.o;
                    if (list != null) {
                        j2 = j5;
                        for (InnerProducer<T> innerProducer3 : list) {
                            j2 = Math.max(j2, innerProducer3.totalRequested.get());
                        }
                    } else {
                        j2 = j5;
                    }
                    if (z) {
                        for (InnerProducer<T> innerProducer4 : h()) {
                            if (innerProducer4 != null) {
                                j2 = Math.max(j2, innerProducer4.totalRequested.get());
                            }
                        }
                    }
                    j(j2, j5);
                }
            }
        }

        public void l(InnerProducer<T> innerProducer) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048582, this, innerProducer) == null) || this.g) {
                return;
            }
            synchronized (this.h) {
                if (this.g) {
                    return;
                }
                this.h.e(innerProducer);
                if (this.h.b()) {
                    this.i = t;
                }
                this.j++;
            }
        }

        public void m() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                InnerProducer<T>[] innerProducerArr = this.i;
                if (this.k != this.j) {
                    synchronized (this.h) {
                        innerProducerArr = this.i;
                        InnerProducer<T>[] h = this.h.h();
                        int length = h.length;
                        if (innerProducerArr.length != length) {
                            innerProducerArr = new InnerProducer[length];
                            this.i = innerProducerArr;
                        }
                        System.arraycopy(h, 0, innerProducerArr, 0, length);
                        this.k = this.j;
                    }
                }
                e<T> eVar = this.e;
                for (InnerProducer<T> innerProducer : innerProducerArr) {
                    if (innerProducer != null) {
                        eVar.replay(innerProducer);
                    }
                }
            }
        }

        @Override // com.repackage.yu9
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.f) {
                return;
            }
            this.f = true;
            try {
                this.e.complete();
                m();
            } finally {
                unsubscribe();
            }
        }

        @Override // com.repackage.yu9
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048585, this, th) == null) || this.f) {
                return;
            }
            this.f = true;
            try {
                this.e.error(th);
                m();
            } finally {
                unsubscribe();
            }
        }

        @Override // com.repackage.yu9
        public void onNext(T t2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048586, this, t2) == null) || this.f) {
                return;
            }
            this.e.next(t2);
            m();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(628882651, "Lrx/internal/operators/OperatorReplay;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(628882651, "Lrx/internal/operators/OperatorReplay;");
                return;
            }
        }
        e = new a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OperatorReplay(xu9.a<T> aVar, xu9<? extends T> xu9Var, AtomicReference<f<T>> atomicReference, ov9<? extends e<T>> ov9Var) {
        super(aVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, xu9Var, atomicReference, ov9Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((xu9.a) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = xu9Var;
        this.c = atomicReference;
        this.d = ov9Var;
    }

    public static <T> vy9<T> D(xu9<? extends T> xu9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, xu9Var)) == null) ? H(xu9Var, e) : (vy9) invokeL.objValue;
    }

    public static <T> vy9<T> E(xu9<? extends T> xu9Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, xu9Var, i)) == null) {
            if (i == Integer.MAX_VALUE) {
                return D(xu9Var);
            }
            return H(xu9Var, new b(i));
        }
        return (vy9) invokeLI.objValue;
    }

    public static <T> vy9<T> F(xu9<? extends T> xu9Var, long j, TimeUnit timeUnit, av9 av9Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{xu9Var, Long.valueOf(j), timeUnit, av9Var})) == null) ? G(xu9Var, j, timeUnit, av9Var, Integer.MAX_VALUE) : (vy9) invokeCommon.objValue;
    }

    public static <T> vy9<T> G(xu9<? extends T> xu9Var, long j, TimeUnit timeUnit, av9 av9Var, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{xu9Var, Long.valueOf(j), timeUnit, av9Var, Integer.valueOf(i)})) == null) ? H(xu9Var, new c(i, timeUnit.toMillis(j), av9Var)) : (vy9) invokeCommon.objValue;
    }

    public static <T> vy9<T> H(xu9<? extends T> xu9Var, ov9<? extends e<T>> ov9Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, xu9Var, ov9Var)) == null) {
            AtomicReference atomicReference = new AtomicReference();
            return new OperatorReplay(new d(atomicReference, ov9Var), xu9Var, atomicReference, ov9Var);
        }
        return (vy9) invokeLL.objValue;
    }

    @Override // com.repackage.vy9
    public void C(lv9<? super ev9> lv9Var) {
        f<T> fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, lv9Var) == null) {
            while (true) {
                fVar = this.c.get();
                if (fVar != null && !fVar.isUnsubscribed()) {
                    break;
                }
                f<T> fVar2 = new f<>(this.d.call());
                fVar2.i();
                if (this.c.compareAndSet(fVar, fVar2)) {
                    fVar = fVar2;
                    break;
                }
            }
            boolean z = true;
            z = (fVar.l.get() || !fVar.l.compareAndSet(false, true)) ? false : false;
            lv9Var.call(fVar);
            if (z) {
                this.b.B(fVar);
            }
        }
    }
}
