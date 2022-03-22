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
import g.d;
import g.g;
import g.j;
import g.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.exceptions.OnErrorThrowable;
/* loaded from: classes8.dex */
public final class OperatorReplay<T> extends g.p.a<T> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final g.n.e f45423e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final g.d<? extends T> f45424b;

    /* renamed from: c  reason: collision with root package name */
    public final AtomicReference<f<T>> f45425c;

    /* renamed from: d  reason: collision with root package name */
    public final g.n.e<? extends e<T>> f45426d;

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
                        long j = innerProducer.get();
                        long j2 = 0;
                        while (j2 != j && (node = node2.get()) != null) {
                            Object leaveTransform = leaveTransform(node.value);
                            try {
                                if (NotificationLite.a(jVar, leaveTransform)) {
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
                                g.m.a.e(th);
                                innerProducer.unsubscribe();
                                if (NotificationLite.g(leaveTransform) || NotificationLite.f(leaveTransform)) {
                                    return;
                                }
                                jVar.onError(OnErrorThrowable.addValueAsLastCause(th, NotificationLite.e(leaveTransform)));
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
    public static final class InnerProducer<T> extends AtomicLong implements g.f, k {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.parent = fVar;
            this.child = jVar;
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

        @Override // g.k
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

        @Override // g.f
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
            this.parent.f45430e.replay(this);
        }

        @Override // g.k
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
        public final g scheduler;

        public SizeAndTimeBoundReplayBuffer(int i, long j, g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Long.valueOf(j), gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.scheduler = gVar;
            this.limit = i;
            this.maxAgeInMillis = j;
        }

        @Override // rx.internal.operators.OperatorReplay.BoundedReplayBuffer
        public Object enterTransform(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) ? new g.s.a(this.scheduler.now(), obj) : invokeL.objValue;
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
                    if (node2 == null || ((g.s.a) node2.value).a() > now) {
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
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) ? ((g.s.a) obj).b() : invokeL.objValue;
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
                        } else if (((g.s.a) node2.value).a() > now) {
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
                    if (node == null || this.size <= 1 || ((g.s.a) node.value).a() > now) {
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
                        j<? super T> jVar = innerProducer.child;
                        if (jVar == null) {
                            return;
                        }
                        long j = innerProducer.get();
                        long j2 = 0;
                        while (j2 != j && intValue < i) {
                            Object obj = get(intValue);
                            try {
                                if (NotificationLite.a(jVar, obj) || innerProducer.isUnsubscribed()) {
                                    return;
                                }
                                intValue++;
                                j2++;
                            } catch (Throwable th) {
                                g.m.a.e(th);
                                innerProducer.unsubscribe();
                                if (NotificationLite.g(obj) || NotificationLite.f(obj)) {
                                    return;
                                }
                                jVar.onError(OnErrorThrowable.addValueAsLastCause(th, NotificationLite.e(obj)));
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
    public static class a implements g.n.e {
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

        @Override // g.n.e
        public Object call() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new UnboundedReplayBuffer(16) : invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class b implements g.n.e<e<T>> {
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
        @Override // g.n.e
        public e<T> call() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new SizeBoundReplayBuffer(this.a) : (e) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class c implements g.n.e<e<T>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ long f45427b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ g f45428c;

        public c(int i, long j, g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Long.valueOf(j), gVar};
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
            this.f45427b = j;
            this.f45428c = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // g.n.e
        public e<T> call() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new SizeAndTimeBoundReplayBuffer(this.a, this.f45427b, this.f45428c) : (e) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class d implements d.a<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AtomicReference a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g.n.e f45429b;

        public d(AtomicReference atomicReference, g.n.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {atomicReference, eVar};
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
            this.f45429b = eVar;
        }

        @Override // g.d.a, g.n.b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((j) ((j) obj));
        }

        public void call(j<? super T> jVar) {
            f fVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
                while (true) {
                    fVar = (f) this.a.get();
                    if (fVar != null) {
                        break;
                    }
                    f fVar2 = new f((e) this.f45429b.call());
                    fVar2.i();
                    if (this.a.compareAndSet(fVar, fVar2)) {
                        fVar = fVar2;
                        break;
                    }
                }
                InnerProducer<T> innerProducer = new InnerProducer<>(fVar, jVar);
                fVar.g(innerProducer);
                jVar.b(innerProducer);
                fVar.f45430e.replay(innerProducer);
                jVar.f(innerProducer);
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
    public static final class f<T> extends j<T> implements k {
        public static /* synthetic */ Interceptable $ic;
        public static final InnerProducer[] t;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final e<T> f45430e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f45431f;

        /* renamed from: g  reason: collision with root package name */
        public volatile boolean f45432g;

        /* renamed from: h  reason: collision with root package name */
        public final g.o.d.d<InnerProducer<T>> f45433h;
        public InnerProducer<T>[] i;
        public volatile long j;
        public long k;
        public final AtomicBoolean l;
        public boolean m;
        public boolean n;
        public long o;
        public long p;
        public volatile g.f q;
        public List<InnerProducer<T>> r;
        public boolean s;

        /* loaded from: classes8.dex */
        public class a implements g.n.a {
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

            @Override // g.n.a
            public void call() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.f45432g) {
                    return;
                }
                synchronized (this.a.f45433h) {
                    if (!this.a.f45432g) {
                        this.a.f45433h.g();
                        this.a.j++;
                        this.a.f45432g = true;
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
            this.f45430e = eVar;
            this.f45433h = new g.o.d.d<>();
            this.i = t;
            this.l = new AtomicBoolean();
            e(0L);
        }

        @Override // g.j
        public void f(g.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
                if (this.q == null) {
                    this.q = fVar;
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
                    if (this.f45432g) {
                        return false;
                    }
                    synchronized (this.f45433h) {
                        if (this.f45432g) {
                            return false;
                        }
                        this.f45433h.a(innerProducer);
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
                synchronized (this.f45433h) {
                    InnerProducer<T>[] h2 = this.f45433h.h();
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
                b(g.u.e.a(new a(this)));
            }
        }

        public void j(long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                long j3 = this.p;
                g.f fVar = this.q;
                long j4 = j - j2;
                if (j4 == 0) {
                    if (j3 == 0 || fVar == null) {
                        return;
                    }
                    this.p = 0L;
                    fVar.request(j3);
                    return;
                }
                this.o = j;
                if (fVar == null) {
                    long j5 = j3 + j4;
                    if (j5 < 0) {
                        j5 = Long.MAX_VALUE;
                    }
                    this.p = j5;
                } else if (j3 != 0) {
                    this.p = 0L;
                    fVar.request(j3 + j4);
                } else {
                    fVar.request(j4);
                }
            }
        }

        public void k(InnerProducer<T> innerProducer) {
            InnerProducer<T>[] h2;
            long j;
            List<InnerProducer<T>> list;
            boolean z;
            long j2;
            InnerProducer<T>[] h3;
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
            if (!(interceptable == null || interceptable.invokeL(1048582, this, innerProducer) == null) || this.f45432g) {
                return;
            }
            synchronized (this.f45433h) {
                if (this.f45432g) {
                    return;
                }
                this.f45433h.e(innerProducer);
                if (this.f45433h.b()) {
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
                    synchronized (this.f45433h) {
                        innerProducerArr = this.i;
                        InnerProducer<T>[] h2 = this.f45433h.h();
                        int length = h2.length;
                        if (innerProducerArr.length != length) {
                            innerProducerArr = new InnerProducer[length];
                            this.i = innerProducerArr;
                        }
                        System.arraycopy(h2, 0, innerProducerArr, 0, length);
                        this.k = this.j;
                    }
                }
                e<T> eVar = this.f45430e;
                for (InnerProducer<T> innerProducer : innerProducerArr) {
                    if (innerProducer != null) {
                        eVar.replay(innerProducer);
                    }
                }
            }
        }

        @Override // g.e
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.f45431f) {
                return;
            }
            this.f45431f = true;
            try {
                this.f45430e.complete();
                m();
            } finally {
                unsubscribe();
            }
        }

        @Override // g.e
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048585, this, th) == null) || this.f45431f) {
                return;
            }
            this.f45431f = true;
            try {
                this.f45430e.error(th);
                m();
            } finally {
                unsubscribe();
            }
        }

        @Override // g.e
        public void onNext(T t2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048586, this, t2) == null) || this.f45431f) {
                return;
            }
            this.f45430e.next(t2);
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
        f45423e = new a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OperatorReplay(d.a<T> aVar, g.d<? extends T> dVar, AtomicReference<f<T>> atomicReference, g.n.e<? extends e<T>> eVar) {
        super(aVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, dVar, atomicReference, eVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((d.a) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f45424b = dVar;
        this.f45425c = atomicReference;
        this.f45426d = eVar;
    }

    public static <T> g.p.a<T> F(g.d<? extends T> dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, dVar)) == null) ? J(dVar, f45423e) : (g.p.a) invokeL.objValue;
    }

    public static <T> g.p.a<T> G(g.d<? extends T> dVar, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, dVar, i)) == null) {
            if (i == Integer.MAX_VALUE) {
                return F(dVar);
            }
            return J(dVar, new b(i));
        }
        return (g.p.a) invokeLI.objValue;
    }

    public static <T> g.p.a<T> H(g.d<? extends T> dVar, long j, TimeUnit timeUnit, g gVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{dVar, Long.valueOf(j), timeUnit, gVar})) == null) ? I(dVar, j, timeUnit, gVar, Integer.MAX_VALUE) : (g.p.a) invokeCommon.objValue;
    }

    public static <T> g.p.a<T> I(g.d<? extends T> dVar, long j, TimeUnit timeUnit, g gVar, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{dVar, Long.valueOf(j), timeUnit, gVar, Integer.valueOf(i)})) == null) ? J(dVar, new c(i, timeUnit.toMillis(j), gVar)) : (g.p.a) invokeCommon.objValue;
    }

    public static <T> g.p.a<T> J(g.d<? extends T> dVar, g.n.e<? extends e<T>> eVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, dVar, eVar)) == null) {
            AtomicReference atomicReference = new AtomicReference();
            return new OperatorReplay(new d(atomicReference, eVar), dVar, atomicReference, eVar);
        }
        return (g.p.a) invokeLL.objValue;
    }

    @Override // g.p.a
    public void E(g.n.b<? super k> bVar) {
        f<T> fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            while (true) {
                fVar = this.f45425c.get();
                if (fVar != null && !fVar.isUnsubscribed()) {
                    break;
                }
                f<T> fVar2 = new f<>(this.f45426d.call());
                fVar2.i();
                if (this.f45425c.compareAndSet(fVar, fVar2)) {
                    fVar = fVar2;
                    break;
                }
            }
            boolean z = true;
            z = (fVar.l.get() || !fVar.l.compareAndSet(false, true)) ? false : false;
            bVar.call(fVar);
            if (z) {
                this.f45424b.D(fVar);
            }
        }
    }
}
