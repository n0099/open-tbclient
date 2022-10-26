package rx.internal.operators;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tieba.ay9;
import com.baidu.tieba.dy9;
import com.baidu.tieba.e0a;
import com.baidu.tieba.ey9;
import com.baidu.tieba.jy9;
import com.baidu.tieba.ky9;
import com.baidu.tieba.l2a;
import com.baidu.tieba.ly9;
import com.baidu.tieba.oy9;
import com.baidu.tieba.u2a;
import com.baidu.tieba.v1a;
import com.baidu.tieba.xx9;
import com.baidu.tieba.zx9;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.exceptions.OnErrorThrowable;
/* loaded from: classes9.dex */
public final class OperatorReplay extends v1a {
    public static /* synthetic */ Interceptable $ic;
    public static final oy9 e;
    public transient /* synthetic */ FieldHolder $fh;
    public final xx9 b;
    public final AtomicReference c;
    public final oy9 d;

    /* loaded from: classes9.dex */
    public interface e {
        void complete();

        void error(Throwable th);

        void next(Object obj);

        void replay(InnerProducer innerProducer);
    }

    /* loaded from: classes9.dex */
    public final class f extends dy9 implements ey9 {
        public static /* synthetic */ Interceptable $ic;
        public static final InnerProducer[] t;
        public transient /* synthetic */ FieldHolder $fh;
        public final e e;
        public boolean f;
        public volatile boolean g;
        public final e0a h;
        public InnerProducer[] i;
        public volatile long j;
        public long k;
        public final AtomicBoolean l;
        public boolean m;
        public boolean n;
        public long o;
        public long p;
        public volatile zx9 q;
        public List r;
        public boolean s;

        /* loaded from: classes9.dex */
        public class a implements ky9 {
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

            @Override // com.baidu.tieba.ky9
            public void call() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !this.a.g) {
                    synchronized (this.a.h) {
                        if (!this.a.g) {
                            this.a.h.g();
                            this.a.j++;
                            this.a.g = true;
                        }
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

        public InnerProducer[] h() {
            InterceptResult invokeV;
            InnerProducer[] innerProducerArr;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                synchronized (this.h) {
                    Object[] h = this.h.h();
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
                b(u2a.a(new a(this)));
            }
        }

        @Override // com.baidu.tieba.yx9
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && !this.f) {
                this.f = true;
                try {
                    this.e.complete();
                    m();
                } finally {
                    unsubscribe();
                }
            }
        }

        public f(e eVar) {
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
            this.h = new e0a();
            this.i = t;
            this.l = new AtomicBoolean();
            e(0L);
        }

        @Override // com.baidu.tieba.dy9
        public void f(zx9 zx9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, zx9Var) == null) {
                if (this.q == null) {
                    this.q = zx9Var;
                    k(null);
                    m();
                    return;
                }
                throw new IllegalStateException("Only a single producer can be set on a Subscriber.");
            }
        }

        @Override // com.baidu.tieba.yx9
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048585, this, th) == null) && !this.f) {
                this.f = true;
                try {
                    this.e.error(th);
                    m();
                } finally {
                    unsubscribe();
                }
            }
        }

        @Override // com.baidu.tieba.yx9
        public void onNext(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048586, this, obj) == null) && !this.f) {
                this.e.next(obj);
                m();
            }
        }

        public boolean g(InnerProducer innerProducer) {
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

        public void l(InnerProducer innerProducer) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048582, this, innerProducer) != null) || this.g) {
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

        public void j(long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                long j3 = this.p;
                zx9 zx9Var = this.q;
                long j4 = j - j2;
                if (j4 != 0) {
                    this.o = j;
                    if (zx9Var != null) {
                        if (j3 != 0) {
                            this.p = 0L;
                            zx9Var.request(j3 + j4);
                            return;
                        }
                        zx9Var.request(j4);
                        return;
                    }
                    long j5 = j3 + j4;
                    if (j5 < 0) {
                        j5 = Long.MAX_VALUE;
                    }
                    this.p = j5;
                } else if (j3 != 0 && zx9Var != null) {
                    this.p = 0L;
                    zx9Var.request(j3);
                }
            }
        }

        public void k(InnerProducer innerProducer) {
            InnerProducer[] h;
            long j;
            List<InnerProducer> list;
            boolean z;
            long j2;
            InnerProducer[] h2;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048581, this, innerProducer) != null) || isUnsubscribed()) {
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
                    for (InnerProducer innerProducer2 : h()) {
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
                        for (InnerProducer innerProducer3 : list) {
                            j2 = Math.max(j2, innerProducer3.totalRequested.get());
                        }
                    } else {
                        j2 = j5;
                    }
                    if (z) {
                        for (InnerProducer innerProducer4 : h()) {
                            if (innerProducer4 != null) {
                                j2 = Math.max(j2, innerProducer4.totalRequested.get());
                            }
                        }
                    }
                    j(j2, j5);
                }
            }
        }

        public void m() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                InnerProducer[] innerProducerArr = this.i;
                if (this.k != this.j) {
                    synchronized (this.h) {
                        innerProducerArr = this.i;
                        Object[] h = this.h.h();
                        int length = h.length;
                        if (innerProducerArr.length != length) {
                            innerProducerArr = new InnerProducer[length];
                            this.i = innerProducerArr;
                        }
                        System.arraycopy(h, 0, innerProducerArr, 0, length);
                        this.k = this.j;
                    }
                }
                e eVar = this.e;
                for (InnerProducer innerProducer : innerProducerArr) {
                    if (innerProducer != null) {
                        eVar.replay(innerProducer);
                    }
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class BoundedReplayBuffer extends AtomicReference implements e {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 2346567790059478686L;
        public transient /* synthetic */ FieldHolder $fh;
        public long index;
        public int size;
        public Node tail;

        public Object enterTransform(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) ? obj : invokeL.objValue;
        }

        public Object leaveTransform(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, obj)) == null) ? obj : invokeL.objValue;
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

        public Node getInitialHead() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return (Node) get();
            }
            return (Node) invokeV.objValue;
        }

        public boolean hasCompleted() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                Object obj = this.tail.value;
                if (obj != null && NotificationLite.f(leaveTransform(obj))) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public boolean hasError() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                Object obj = this.tail.value;
                if (obj != null && NotificationLite.g(leaveTransform(obj))) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public final void removeFirst() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
                Node node = (Node) ((Node) get()).get();
                if (node != null) {
                    this.size--;
                    setFirst(node);
                    return;
                }
                throw new IllegalStateException("Empty list!");
            }
        }

        public final void addLast(Node node) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, node) == null) {
                this.tail.set(node);
                this.tail = node;
                this.size++;
            }
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

        @Override // rx.internal.operators.OperatorReplay.e
        public final void next(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, obj) == null) {
                Object enterTransform = enterTransform(NotificationLite.h(obj));
                long j = this.index + 1;
                this.index = j;
                addLast(new Node(enterTransform, j));
                truncate();
            }
        }

        public final void removeSome(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
                Node node = (Node) get();
                while (i > 0) {
                    node = (Node) node.get();
                    i--;
                    this.size--;
                }
                setFirst(node);
            }
        }

        public final void setFirst(Node node) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048589, this, node) == null) {
                set(node);
            }
        }

        public final void collect(Collection collection) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, collection) == null) {
                Node initialHead = getInitialHead();
                while (true) {
                    initialHead = (Node) initialHead.get();
                    if (initialHead != null) {
                        Object leaveTransform = leaveTransform(initialHead.value);
                        if (!NotificationLite.f(leaveTransform) && !NotificationLite.g(leaveTransform)) {
                            collection.add(NotificationLite.e(leaveTransform));
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        }

        @Override // rx.internal.operators.OperatorReplay.e
        public final void replay(InnerProducer innerProducer) {
            dy9 dy9Var;
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
                        if (innerProducer.isUnsubscribed() || (dy9Var = innerProducer.child) == null) {
                            return;
                        }
                        long j = innerProducer.get();
                        long j2 = 0;
                        while (j2 != j && (node = (Node) node2.get()) != null) {
                            Object leaveTransform = leaveTransform(node.value);
                            try {
                                if (NotificationLite.a(dy9Var, leaveTransform)) {
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
                                jy9.e(th);
                                innerProducer.unsubscribe();
                                if (!NotificationLite.g(leaveTransform) && !NotificationLite.f(leaveTransform)) {
                                    dy9Var.onError(OnErrorThrowable.addValueAsLastCause(th, NotificationLite.e(leaveTransform)));
                                    return;
                                }
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
    }

    /* loaded from: classes9.dex */
    public final class InnerProducer extends AtomicLong implements zx9, ey9 {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long UNSUBSCRIBED = Long.MIN_VALUE;
        public static final long serialVersionUID = -4453897557930727610L;
        public transient /* synthetic */ FieldHolder $fh;
        public dy9 child;
        public boolean emitting;
        public Object index;
        public boolean missed;
        public final f parent;
        public final AtomicLong totalRequested;

        public InnerProducer(f fVar, dy9 dy9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, dy9Var};
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
            this.child = dy9Var;
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

        public Object index() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.index;
            }
            return invokeV.objValue;
        }

        @Override // com.baidu.tieba.ey9
        public boolean isUnsubscribed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (get() == Long.MIN_VALUE) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.ey9
        public void unsubscribe() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && get() != Long.MIN_VALUE && getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.parent.l(this);
                this.parent.k(this);
                this.child = null;
            }
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

        @Override // com.baidu.tieba.zx9
        public void request(long j) {
            int i;
            long j2;
            long j3;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeJ(1048580, this, j) != null) || j < 0) {
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
    }

    /* loaded from: classes9.dex */
    public final class Node extends AtomicReference {
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

    /* loaded from: classes9.dex */
    public final class SizeAndTimeBoundReplayBuffer extends BoundedReplayBuffer {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 3457957419649567404L;
        public transient /* synthetic */ FieldHolder $fh;
        public final int limit;
        public final long maxAgeInMillis;
        public final ay9 scheduler;

        public SizeAndTimeBoundReplayBuffer(int i, long j, ay9 ay9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Long.valueOf(j), ay9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.scheduler = ay9Var;
            this.limit = i;
            this.maxAgeInMillis = j;
        }

        @Override // rx.internal.operators.OperatorReplay.BoundedReplayBuffer
        public Object enterTransform(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                return new l2a(this.scheduler.now(), obj);
            }
            return invokeL.objValue;
        }

        @Override // rx.internal.operators.OperatorReplay.BoundedReplayBuffer
        public Object leaveTransform(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
                return ((l2a) obj).b();
            }
            return invokeL.objValue;
        }

        @Override // rx.internal.operators.OperatorReplay.BoundedReplayBuffer
        public Node getInitialHead() {
            InterceptResult invokeV;
            Node node;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                long now = this.scheduler.now() - this.maxAgeInMillis;
                Node node2 = (Node) get();
                Object obj = node2.get();
                while (true) {
                    Node node3 = (Node) obj;
                    node = node2;
                    node2 = node3;
                    if (node2 == null || ((l2a) node2.value).a() > now) {
                        break;
                    }
                    obj = node2.get();
                }
                return node;
            }
            return (Node) invokeV.objValue;
        }

        @Override // rx.internal.operators.OperatorReplay.BoundedReplayBuffer
        public void truncate() {
            Node node;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                long now = this.scheduler.now() - this.maxAgeInMillis;
                Node node2 = (Node) get();
                Node node3 = (Node) node2.get();
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
                            node3 = (Node) node2.get();
                        } else if (((l2a) node2.value).a() > now) {
                            break;
                        } else {
                            i++;
                            this.size--;
                            node3 = (Node) node2.get();
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
                Node node = (Node) get();
                Node node2 = (Node) node.get();
                int i = 0;
                while (true) {
                    Node node3 = node2;
                    Node node4 = node;
                    node = node3;
                    if (node == null || this.size <= 1 || ((l2a) node.value).a() > now) {
                        break;
                    }
                    i++;
                    this.size--;
                    node2 = (Node) node.get();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public final class SizeBoundReplayBuffer extends BoundedReplayBuffer {
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
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.size > this.limit) {
                removeFirst();
            }
        }
    }

    /* loaded from: classes9.dex */
    public final class UnboundedReplayBuffer extends ArrayList implements e {
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
        public void next(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
                add(NotificationLite.h(obj));
                this.size++;
            }
        }

        @Override // rx.internal.operators.OperatorReplay.e
        public void replay(InnerProducer innerProducer) {
            int i;
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
                        if (num != null) {
                            i = num.intValue();
                        } else {
                            i = 0;
                        }
                        dy9 dy9Var = innerProducer.child;
                        if (dy9Var == null) {
                            return;
                        }
                        long j = innerProducer.get();
                        long j2 = 0;
                        while (j2 != j && i < i2) {
                            Object obj = get(i);
                            try {
                                if (NotificationLite.a(dy9Var, obj) || innerProducer.isUnsubscribed()) {
                                    return;
                                }
                                i++;
                                j2++;
                            } catch (Throwable th) {
                                jy9.e(th);
                                innerProducer.unsubscribe();
                                if (!NotificationLite.g(obj) && !NotificationLite.f(obj)) {
                                    dy9Var.onError(OnErrorThrowable.addValueAsLastCause(th, NotificationLite.e(obj)));
                                    return;
                                }
                                return;
                            }
                        }
                        if (j2 != 0) {
                            innerProducer.index = Integer.valueOf(i);
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

    /* loaded from: classes9.dex */
    public final class a implements oy9 {
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

        @Override // com.baidu.tieba.oy9, java.util.concurrent.Callable
        public Object call() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return new UnboundedReplayBuffer(16);
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public final class b implements oy9 {
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
        @Override // com.baidu.tieba.oy9, java.util.concurrent.Callable
        public e call() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return new SizeBoundReplayBuffer(this.a);
            }
            return (e) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public final class c implements oy9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ long b;
        public final /* synthetic */ ay9 c;

        public c(int i, long j, ay9 ay9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Long.valueOf(j), ay9Var};
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
            this.c = ay9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.oy9, java.util.concurrent.Callable
        public e call() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return new SizeAndTimeBoundReplayBuffer(this.a, this.b, this.c);
            }
            return (e) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public final class d implements xx9.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AtomicReference a;
        public final /* synthetic */ oy9 b;

        public d(AtomicReference atomicReference, oy9 oy9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {atomicReference, oy9Var};
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
            this.b = oy9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xx9.a, com.baidu.tieba.ly9
        public void call(dy9 dy9Var) {
            f fVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dy9Var) == null) {
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
                InnerProducer innerProducer = new InnerProducer(fVar, dy9Var);
                fVar.g(innerProducer);
                dy9Var.b(innerProducer);
                fVar.e.replay(innerProducer);
                dy9Var.f(innerProducer);
            }
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
    public OperatorReplay(xx9.a aVar, xx9 xx9Var, AtomicReference atomicReference, oy9 oy9Var) {
        super(aVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, xx9Var, atomicReference, oy9Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((xx9.a) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = xx9Var;
        this.c = atomicReference;
        this.d = oy9Var;
    }

    public static v1a D(xx9 xx9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, xx9Var)) == null) {
            return H(xx9Var, e);
        }
        return (v1a) invokeL.objValue;
    }

    public static v1a E(xx9 xx9Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, xx9Var, i)) == null) {
            if (i == Integer.MAX_VALUE) {
                return D(xx9Var);
            }
            return H(xx9Var, new b(i));
        }
        return (v1a) invokeLI.objValue;
    }

    public static v1a H(xx9 xx9Var, oy9 oy9Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, xx9Var, oy9Var)) == null) {
            AtomicReference atomicReference = new AtomicReference();
            return new OperatorReplay(new d(atomicReference, oy9Var), xx9Var, atomicReference, oy9Var);
        }
        return (v1a) invokeLL.objValue;
    }

    public static v1a F(xx9 xx9Var, long j, TimeUnit timeUnit, ay9 ay9Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{xx9Var, Long.valueOf(j), timeUnit, ay9Var})) == null) {
            return G(xx9Var, j, timeUnit, ay9Var, Integer.MAX_VALUE);
        }
        return (v1a) invokeCommon.objValue;
    }

    public static v1a G(xx9 xx9Var, long j, TimeUnit timeUnit, ay9 ay9Var, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{xx9Var, Long.valueOf(j), timeUnit, ay9Var, Integer.valueOf(i)})) == null) {
            return H(xx9Var, new c(i, timeUnit.toMillis(j), ay9Var));
        }
        return (v1a) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.v1a
    public void C(ly9 ly9Var) {
        f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ly9Var) == null) {
            while (true) {
                fVar = (f) this.c.get();
                if (fVar != null && !fVar.isUnsubscribed()) {
                    break;
                }
                f fVar2 = new f((e) this.d.call());
                fVar2.i();
                if (this.c.compareAndSet(fVar, fVar2)) {
                    fVar = fVar2;
                    break;
                }
            }
            boolean z = true;
            z = (fVar.l.get() || !fVar.l.compareAndSet(false, true)) ? false : false;
            ly9Var.call(fVar);
            if (z) {
                this.b.B(fVar);
            }
        }
    }
}
