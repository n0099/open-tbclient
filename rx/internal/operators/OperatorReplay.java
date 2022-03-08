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
import i.d;
import i.g;
import i.j;
import i.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.exceptions.OnErrorThrowable;
/* loaded from: classes9.dex */
public final class OperatorReplay<T> extends i.p.a<T> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final i.n.e f61063i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public final i.d<? extends T> f61064f;

    /* renamed from: g  reason: collision with root package name */
    public final AtomicReference<f<T>> f61065g;

    /* renamed from: h  reason: collision with root package name */
    public final i.n.e<? extends e<T>> f61066h;

    /* loaded from: classes9.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                long j2 = this.index + 1;
                this.index = j2;
                addLast(new Node(enterTransform, j2));
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
                long j2 = this.index + 1;
                this.index = j2;
                addLast(new Node(enterTransform, j2));
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
                long j2 = this.index + 1;
                this.index = j2;
                addLast(new Node(enterTransform, j2));
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

        @Override // rx.internal.operators.OperatorReplay.e
        public final void replay(InnerProducer<T> innerProducer) {
            j<? super T> jVar;
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
                        if (innerProducer.isUnsubscribed() || (jVar = innerProducer.child) == null) {
                            return;
                        }
                        long j2 = innerProducer.get();
                        long j3 = 0;
                        while (j3 != j2 && (node = node2.get()) != null) {
                            Object leaveTransform = leaveTransform(node.value);
                            try {
                                if (NotificationLite.a(jVar, leaveTransform)) {
                                    innerProducer.index = null;
                                    return;
                                }
                                j3++;
                                if (innerProducer.isUnsubscribed()) {
                                    return;
                                }
                                node2 = node;
                            } catch (Throwable th) {
                                innerProducer.index = null;
                                i.m.a.e(th);
                                innerProducer.unsubscribe();
                                if (NotificationLite.g(leaveTransform) || NotificationLite.f(leaveTransform)) {
                                    return;
                                }
                                jVar.onError(OnErrorThrowable.addValueAsLastCause(th, NotificationLite.e(leaveTransform)));
                                return;
                            }
                        }
                        if (j3 != 0) {
                            innerProducer.index = node2;
                            if (j2 != Long.MAX_VALUE) {
                                innerProducer.produced(j3);
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

    /* loaded from: classes9.dex */
    public static final class InnerProducer<T> extends AtomicLong implements i.f, k {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long UNSUBSCRIBED = Long.MIN_VALUE;
        public static final long serialVersionUID = -4453897557930727610L;
        public transient /* synthetic */ FieldHolder $fh;
        public j<? super T> child;
        public boolean emitting;
        public Object index;
        public boolean missed;
        public final f<T> parent;
        public final AtomicLong totalRequested;

        public InnerProducer(f<T> fVar, j<? super T> jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.parent = fVar;
            this.child = jVar;
            this.totalRequested = new AtomicLong();
        }

        public void addTotalRequested(long j2) {
            long j3;
            long j4;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) {
                do {
                    j3 = this.totalRequested.get();
                    j4 = j3 + j2;
                    if (j4 < 0) {
                        j4 = Long.MAX_VALUE;
                    }
                } while (!this.totalRequested.compareAndSet(j3, j4));
            }
        }

        public <U> U index() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (U) this.index : (U) invokeV.objValue;
        }

        @Override // i.k
        public boolean isUnsubscribed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? get() == Long.MIN_VALUE : invokeV.booleanValue;
        }

        public long produced(long j2) {
            InterceptResult invokeJ;
            long j3;
            long j4;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j2)) == null) {
                if (j2 > 0) {
                    do {
                        j3 = get();
                        if (j3 == Long.MIN_VALUE) {
                            return Long.MIN_VALUE;
                        }
                        j4 = j3 - j2;
                        if (j4 < 0) {
                            throw new IllegalStateException("More produced (" + j2 + ") than requested (" + j3 + SmallTailInfo.EMOTION_SUFFIX);
                        }
                    } while (!compareAndSet(j3, j4));
                    return j4;
                }
                throw new IllegalArgumentException("Cant produce zero or less");
            }
            return invokeJ.longValue;
        }

        @Override // i.f
        public void request(long j2) {
            int i2;
            long j3;
            long j4;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(1048580, this, j2) == null) || j2 < 0) {
                return;
            }
            do {
                j3 = get();
                if (j3 == Long.MIN_VALUE) {
                    return;
                }
                if (j3 >= 0 && i2 == 0) {
                    return;
                }
                j4 = j3 + j2;
                if (j4 < 0) {
                    j4 = Long.MAX_VALUE;
                }
            } while (!compareAndSet(j3, j4));
            addTotalRequested(j2);
            this.parent.k(this);
            this.parent.f61073i.replay(this);
        }

        @Override // i.k
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

    /* loaded from: classes9.dex */
    public static final class Node extends AtomicReference<Node> {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 245354315435971818L;
        public transient /* synthetic */ FieldHolder $fh;
        public final long index;
        public final Object value;

        public Node(Object obj, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {obj, Long.valueOf(j2)};
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
            this.index = j2;
        }
    }

    /* loaded from: classes9.dex */
    public static final class SizeAndTimeBoundReplayBuffer<T> extends BoundedReplayBuffer<T> {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 3457957419649567404L;
        public transient /* synthetic */ FieldHolder $fh;
        public final int limit;
        public final long maxAgeInMillis;
        public final g scheduler;

        public SizeAndTimeBoundReplayBuffer(int i2, long j2, g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Long.valueOf(j2), gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.scheduler = gVar;
            this.limit = i2;
            this.maxAgeInMillis = j2;
        }

        @Override // rx.internal.operators.OperatorReplay.BoundedReplayBuffer
        public Object enterTransform(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) ? new i.s.a(this.scheduler.now(), obj) : invokeL.objValue;
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
                    if (node2 == null || ((i.s.a) node2.value).a() > now) {
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
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) ? ((i.s.a) obj).b() : invokeL.objValue;
        }

        @Override // rx.internal.operators.OperatorReplay.BoundedReplayBuffer
        public void truncate() {
            Node node;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                long now = this.scheduler.now() - this.maxAgeInMillis;
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
                        } else if (((i.s.a) node2.value).a() > now) {
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
                int i2 = 0;
                while (true) {
                    Node node3 = node2;
                    Node node4 = node;
                    node = node3;
                    if (node == null || this.size <= 1 || ((i.s.a) node.value).a() > now) {
                        break;
                    }
                    i2++;
                    this.size--;
                    node2 = node.get();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
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

        @Override // rx.internal.operators.OperatorReplay.BoundedReplayBuffer
        public void truncate() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.size <= this.limit) {
                return;
            }
            removeFirst();
        }
    }

    /* loaded from: classes9.dex */
    public static final class UnboundedReplayBuffer<T> extends ArrayList<Object> implements e<T> {
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
                        int i2 = this.size;
                        Integer num = (Integer) innerProducer.index();
                        int intValue = num != null ? num.intValue() : 0;
                        j<? super T> jVar = innerProducer.child;
                        if (jVar == null) {
                            return;
                        }
                        long j2 = innerProducer.get();
                        long j3 = 0;
                        while (j3 != j2 && intValue < i2) {
                            Object obj = get(intValue);
                            try {
                                if (NotificationLite.a(jVar, obj) || innerProducer.isUnsubscribed()) {
                                    return;
                                }
                                intValue++;
                                j3++;
                            } catch (Throwable th) {
                                i.m.a.e(th);
                                innerProducer.unsubscribe();
                                if (NotificationLite.g(obj) || NotificationLite.f(obj)) {
                                    return;
                                }
                                jVar.onError(OnErrorThrowable.addValueAsLastCause(th, NotificationLite.e(obj)));
                                return;
                            }
                        }
                        if (j3 != 0) {
                            innerProducer.index = Integer.valueOf(intValue);
                            if (j2 != Long.MAX_VALUE) {
                                innerProducer.produced(j3);
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

    /* loaded from: classes9.dex */
    public static class a implements i.n.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        @Override // i.n.e
        public Object call() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new UnboundedReplayBuffer(16) : invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class b implements i.n.e<e<T>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f61067e;

        public b(int i2) {
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
            this.f61067e = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // i.n.e
        public e<T> call() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new SizeBoundReplayBuffer(this.f61067e) : (e) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class c implements i.n.e<e<T>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f61068e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f61069f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ g f61070g;

        public c(int i2, long j2, g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Long.valueOf(j2), gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61068e = i2;
            this.f61069f = j2;
            this.f61070g = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // i.n.e
        public e<T> call() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new SizeAndTimeBoundReplayBuffer(this.f61068e, this.f61069f, this.f61070g) : (e) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class d implements d.a<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AtomicReference f61071e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ i.n.e f61072f;

        public d(AtomicReference atomicReference, i.n.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {atomicReference, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61071e = atomicReference;
            this.f61072f = eVar;
        }

        @Override // i.d.a, i.n.b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((j) ((j) obj));
        }

        public void call(j<? super T> jVar) {
            f fVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
                while (true) {
                    fVar = (f) this.f61071e.get();
                    if (fVar != null) {
                        break;
                    }
                    f fVar2 = new f((e) this.f61072f.call());
                    fVar2.i();
                    if (this.f61071e.compareAndSet(fVar, fVar2)) {
                        fVar = fVar2;
                        break;
                    }
                }
                InnerProducer<T> innerProducer = new InnerProducer<>(fVar, jVar);
                fVar.g(innerProducer);
                jVar.b(innerProducer);
                fVar.f61073i.replay(innerProducer);
                jVar.f(innerProducer);
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface e<T> {
        void complete();

        void error(Throwable th);

        void next(T t);

        void replay(InnerProducer<T> innerProducer);
    }

    /* loaded from: classes9.dex */
    public static final class f<T> extends j<T> implements k {
        public static /* synthetic */ Interceptable $ic;
        public static final InnerProducer[] x;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: i  reason: collision with root package name */
        public final e<T> f61073i;

        /* renamed from: j  reason: collision with root package name */
        public boolean f61074j;
        public volatile boolean k;
        public final i.o.d.d<InnerProducer<T>> l;
        public InnerProducer<T>[] m;
        public volatile long n;
        public long o;
        public final AtomicBoolean p;
        public boolean q;
        public boolean r;
        public long s;
        public long t;
        public volatile i.f u;
        public List<InnerProducer<T>> v;
        public boolean w;

        /* loaded from: classes9.dex */
        public class a implements i.n.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ f f61075e;

            public a(f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f61075e = fVar;
            }

            @Override // i.n.a
            public void call() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f61075e.k) {
                    return;
                }
                synchronized (this.f61075e.l) {
                    if (!this.f61075e.k) {
                        this.f61075e.l.g();
                        this.f61075e.n++;
                        this.f61075e.k = true;
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
            x = new InnerProducer[0];
        }

        public f(e<T> eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f61073i = eVar;
            this.l = new i.o.d.d<>();
            this.m = x;
            this.p = new AtomicBoolean();
            e(0L);
        }

        @Override // i.j
        public void f(i.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
                if (this.u == null) {
                    this.u = fVar;
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
                    if (this.k) {
                        return false;
                    }
                    synchronized (this.l) {
                        if (this.k) {
                            return false;
                        }
                        this.l.a(innerProducer);
                        this.n++;
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
                synchronized (this.l) {
                    InnerProducer<T>[] h2 = this.l.h();
                    int length = h2.length;
                    innerProducerArr = new InnerProducer[length];
                    System.arraycopy(h2, 0, innerProducerArr, 0, length);
                }
                return innerProducerArr;
            }
            return (InnerProducer[]) invokeV.objValue;
        }

        public void i() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                b(i.u.e.a(new a(this)));
            }
        }

        public void j(long j2, long j3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
                long j4 = this.t;
                i.f fVar = this.u;
                long j5 = j2 - j3;
                if (j5 == 0) {
                    if (j4 == 0 || fVar == null) {
                        return;
                    }
                    this.t = 0L;
                    fVar.request(j4);
                    return;
                }
                this.s = j2;
                if (fVar == null) {
                    long j6 = j4 + j5;
                    if (j6 < 0) {
                        j6 = Long.MAX_VALUE;
                    }
                    this.t = j6;
                } else if (j4 != 0) {
                    this.t = 0L;
                    fVar.request(j4 + j5);
                } else {
                    fVar.request(j5);
                }
            }
        }

        public void k(InnerProducer<T> innerProducer) {
            InnerProducer<T>[] h2;
            long j2;
            List<InnerProducer<T>> list;
            boolean z;
            long j3;
            InnerProducer<T>[] h3;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048581, this, innerProducer) == null) || isUnsubscribed()) {
                return;
            }
            synchronized (this) {
                if (this.q) {
                    if (innerProducer != null) {
                        List list2 = this.v;
                        if (list2 == null) {
                            list2 = new ArrayList();
                            this.v = list2;
                        }
                        list2.add(innerProducer);
                    } else {
                        this.w = true;
                    }
                    this.r = true;
                    return;
                }
                this.q = true;
                long j4 = this.s;
                if (innerProducer != null) {
                    j2 = Math.max(j4, innerProducer.totalRequested.get());
                } else {
                    long j5 = j4;
                    for (InnerProducer<T> innerProducer2 : h()) {
                        if (innerProducer2 != null) {
                            j5 = Math.max(j5, innerProducer2.totalRequested.get());
                        }
                    }
                    j2 = j5;
                }
                j(j2, j4);
                while (!isUnsubscribed()) {
                    synchronized (this) {
                        if (!this.r) {
                            this.q = false;
                            return;
                        }
                        this.r = false;
                        list = this.v;
                        this.v = null;
                        z = this.w;
                        this.w = false;
                    }
                    long j6 = this.s;
                    if (list != null) {
                        j3 = j6;
                        for (InnerProducer<T> innerProducer3 : list) {
                            j3 = Math.max(j3, innerProducer3.totalRequested.get());
                        }
                    } else {
                        j3 = j6;
                    }
                    if (z) {
                        for (InnerProducer<T> innerProducer4 : h()) {
                            if (innerProducer4 != null) {
                                j3 = Math.max(j3, innerProducer4.totalRequested.get());
                            }
                        }
                    }
                    j(j3, j6);
                }
            }
        }

        public void l(InnerProducer<T> innerProducer) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048582, this, innerProducer) == null) || this.k) {
                return;
            }
            synchronized (this.l) {
                if (this.k) {
                    return;
                }
                this.l.e(innerProducer);
                if (this.l.b()) {
                    this.m = x;
                }
                this.n++;
            }
        }

        public void m() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                InnerProducer<T>[] innerProducerArr = this.m;
                if (this.o != this.n) {
                    synchronized (this.l) {
                        innerProducerArr = this.m;
                        InnerProducer<T>[] h2 = this.l.h();
                        int length = h2.length;
                        if (innerProducerArr.length != length) {
                            innerProducerArr = new InnerProducer[length];
                            this.m = innerProducerArr;
                        }
                        System.arraycopy(h2, 0, innerProducerArr, 0, length);
                        this.o = this.n;
                    }
                }
                e<T> eVar = this.f61073i;
                for (InnerProducer<T> innerProducer : innerProducerArr) {
                    if (innerProducer != null) {
                        eVar.replay(innerProducer);
                    }
                }
            }
        }

        @Override // i.e
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.f61074j) {
                return;
            }
            this.f61074j = true;
            try {
                this.f61073i.complete();
                m();
            } finally {
                unsubscribe();
            }
        }

        @Override // i.e
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048585, this, th) == null) || this.f61074j) {
                return;
            }
            this.f61074j = true;
            try {
                this.f61073i.error(th);
                m();
            } finally {
                unsubscribe();
            }
        }

        @Override // i.e
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048586, this, t) == null) || this.f61074j) {
                return;
            }
            this.f61073i.next(t);
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
        f61063i = new a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OperatorReplay(d.a<T> aVar, i.d<? extends T> dVar, AtomicReference<f<T>> atomicReference, i.n.e<? extends e<T>> eVar) {
        super(aVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, dVar, atomicReference, eVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((d.a) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f61064f = dVar;
        this.f61065g = atomicReference;
        this.f61066h = eVar;
    }

    public static <T> i.p.a<T> F(i.d<? extends T> dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, dVar)) == null) ? J(dVar, f61063i) : (i.p.a) invokeL.objValue;
    }

    public static <T> i.p.a<T> G(i.d<? extends T> dVar, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, dVar, i2)) == null) {
            if (i2 == Integer.MAX_VALUE) {
                return F(dVar);
            }
            return J(dVar, new b(i2));
        }
        return (i.p.a) invokeLI.objValue;
    }

    public static <T> i.p.a<T> H(i.d<? extends T> dVar, long j2, TimeUnit timeUnit, g gVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{dVar, Long.valueOf(j2), timeUnit, gVar})) == null) ? I(dVar, j2, timeUnit, gVar, Integer.MAX_VALUE) : (i.p.a) invokeCommon.objValue;
    }

    public static <T> i.p.a<T> I(i.d<? extends T> dVar, long j2, TimeUnit timeUnit, g gVar, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{dVar, Long.valueOf(j2), timeUnit, gVar, Integer.valueOf(i2)})) == null) ? J(dVar, new c(i2, timeUnit.toMillis(j2), gVar)) : (i.p.a) invokeCommon.objValue;
    }

    public static <T> i.p.a<T> J(i.d<? extends T> dVar, i.n.e<? extends e<T>> eVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, dVar, eVar)) == null) {
            AtomicReference atomicReference = new AtomicReference();
            return new OperatorReplay(new d(atomicReference, eVar), dVar, atomicReference, eVar);
        }
        return (i.p.a) invokeLL.objValue;
    }

    @Override // i.p.a
    public void E(i.n.b<? super k> bVar) {
        f<T> fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            while (true) {
                fVar = this.f61065g.get();
                if (fVar != null && !fVar.isUnsubscribed()) {
                    break;
                }
                f<T> fVar2 = new f<>(this.f61066h.call());
                fVar2.i();
                if (this.f61065g.compareAndSet(fVar, fVar2)) {
                    fVar = fVar2;
                    break;
                }
            }
            boolean z = true;
            z = (fVar.p.get() || !fVar.p.compareAndSet(false, true)) ? false : false;
            bVar.call(fVar);
            if (z) {
                this.f61064f.D(fVar);
            }
        }
    }
}
