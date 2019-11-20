package rx.internal.operators;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.d;
import rx.exceptions.OnErrorThrowable;
/* loaded from: classes2.dex */
public final class OperatorReplay<T> extends rx.observables.a<T> {
    static final rx.functions.e kAR = new rx.functions.e() { // from class: rx.internal.operators.OperatorReplay.1
        @Override // rx.functions.e, java.util.concurrent.Callable
        public Object call() {
            return new UnboundedReplayBuffer(16);
        }
    };
    final AtomicReference<b<T>> kAJ;
    final rx.functions.e<? extends a<T>> kAQ;
    final rx.d<? extends T> kyh;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface a<T> {
        void complete();

        void error(Throwable th);

        void next(T t);

        void replay(InnerProducer<T> innerProducer);
    }

    public static <T> rx.observables.a<T> e(rx.d<? extends T> dVar) {
        return a(dVar, kAR);
    }

    public static <T> rx.observables.a<T> a(rx.d<? extends T> dVar, final int i) {
        return i == Integer.MAX_VALUE ? e(dVar) : a(dVar, new rx.functions.e<a<T>>() { // from class: rx.internal.operators.OperatorReplay.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.e, java.util.concurrent.Callable
            /* renamed from: cOM */
            public a<T> call() {
                return new SizeBoundReplayBuffer(i);
            }
        });
    }

    public static <T> rx.observables.a<T> a(rx.d<? extends T> dVar, long j, TimeUnit timeUnit, rx.g gVar) {
        return a(dVar, j, timeUnit, gVar, Integer.MAX_VALUE);
    }

    public static <T> rx.observables.a<T> a(rx.d<? extends T> dVar, long j, TimeUnit timeUnit, final rx.g gVar, final int i) {
        final long millis = timeUnit.toMillis(j);
        return a(dVar, new rx.functions.e<a<T>>() { // from class: rx.internal.operators.OperatorReplay.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.e, java.util.concurrent.Callable
            /* renamed from: cOM */
            public a<T> call() {
                return new SizeAndTimeBoundReplayBuffer(i, millis, gVar);
            }
        });
    }

    static <T> rx.observables.a<T> a(rx.d<? extends T> dVar, final rx.functions.e<? extends a<T>> eVar) {
        final AtomicReference atomicReference = new AtomicReference();
        return new OperatorReplay(new d.a<T>() { // from class: rx.internal.operators.OperatorReplay.4
            @Override // rx.functions.b
            public /* bridge */ /* synthetic */ void call(Object obj) {
                call((rx.j) ((rx.j) obj));
            }

            public void call(rx.j<? super T> jVar) {
                b bVar;
                while (true) {
                    bVar = (b) atomicReference.get();
                    if (bVar != null) {
                        break;
                    }
                    b bVar2 = new b((a) eVar.call());
                    bVar2.init();
                    if (atomicReference.compareAndSet(bVar, bVar2)) {
                        bVar = bVar2;
                        break;
                    }
                }
                InnerProducer<T> innerProducer = new InnerProducer<>(bVar, jVar);
                bVar.a(innerProducer);
                jVar.add(innerProducer);
                bVar.kAW.replay(innerProducer);
                jVar.setProducer(innerProducer);
            }
        }, dVar, atomicReference, eVar);
    }

    private OperatorReplay(d.a<T> aVar, rx.d<? extends T> dVar, AtomicReference<b<T>> atomicReference, rx.functions.e<? extends a<T>> eVar) {
        super(aVar);
        this.kyh = dVar;
        this.kAJ = atomicReference;
        this.kAQ = eVar;
    }

    @Override // rx.observables.a
    public void f(rx.functions.b<? super rx.k> bVar) {
        b<T> bVar2;
        while (true) {
            bVar2 = this.kAJ.get();
            if (bVar2 != null && !bVar2.isUnsubscribed()) {
                break;
            }
            b<T> bVar3 = new b<>(this.kAQ.call());
            bVar3.init();
            if (this.kAJ.compareAndSet(bVar2, bVar3)) {
                bVar2 = bVar3;
                break;
            }
        }
        boolean z = !bVar2.kAO.get() && bVar2.kAO.compareAndSet(false, true);
        bVar.call(bVar2);
        if (z) {
            this.kyh.a((rx.j<? super Object>) bVar2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class b<T> extends rx.j<T> implements rx.k {
        static final InnerProducer[] kAX = new InnerProducer[0];
        static final InnerProducer[] kAY = new InnerProducer[0];
        boolean done;
        boolean emitting;
        final a<T> kAW;
        volatile long kBb;
        long kBc;
        long kBd;
        long kBe;
        List<InnerProducer<T>> kBf;
        boolean kBg;
        boolean missed;
        volatile rx.f producer;
        volatile boolean terminated;
        final rx.internal.util.e<InnerProducer<T>> kAZ = new rx.internal.util.e<>();
        InnerProducer<T>[] kBa = kAX;
        final AtomicBoolean kAO = new AtomicBoolean();

        public b(a<T> aVar) {
            this.kAW = aVar;
            request(0L);
        }

        void init() {
            add(rx.subscriptions.e.l(new rx.functions.a() { // from class: rx.internal.operators.OperatorReplay.b.1
                @Override // rx.functions.a
                public void call() {
                    if (!b.this.terminated) {
                        synchronized (b.this.kAZ) {
                            if (!b.this.terminated) {
                                b.this.kAZ.terminate();
                                b.this.kBb++;
                                b.this.terminated = true;
                            }
                        }
                    }
                }
            }));
        }

        boolean a(InnerProducer<T> innerProducer) {
            boolean z = false;
            if (innerProducer == null) {
                throw new NullPointerException();
            }
            if (!this.terminated) {
                synchronized (this.kAZ) {
                    if (!this.terminated) {
                        this.kAZ.add(innerProducer);
                        this.kBb++;
                        z = true;
                    }
                }
            }
            return z;
        }

        void b(InnerProducer<T> innerProducer) {
            if (!this.terminated) {
                synchronized (this.kAZ) {
                    if (!this.terminated) {
                        this.kAZ.remove(innerProducer);
                        if (this.kAZ.isEmpty()) {
                            this.kBa = kAX;
                        }
                        this.kBb++;
                    }
                }
            }
        }

        @Override // rx.j
        public void setProducer(rx.f fVar) {
            if (this.producer != null) {
                throw new IllegalStateException("Only a single producer can be set on a Subscriber.");
            }
            this.producer = fVar;
            c(null);
            replay();
        }

        @Override // rx.e
        public void onNext(T t) {
            if (!this.done) {
                this.kAW.next(t);
                replay();
            }
        }

        @Override // rx.e
        public void onError(Throwable th) {
            if (!this.done) {
                this.done = true;
                try {
                    this.kAW.error(th);
                    replay();
                } finally {
                    unsubscribe();
                }
            }
        }

        @Override // rx.e
        public void onCompleted() {
            if (!this.done) {
                this.done = true;
                try {
                    this.kAW.complete();
                    replay();
                } finally {
                    unsubscribe();
                }
            }
        }

        void c(InnerProducer<T> innerProducer) {
            InnerProducer<T>[] cON;
            long j;
            List<InnerProducer<T>> list;
            boolean z;
            long j2;
            InnerProducer<T>[] cON2;
            if (!isUnsubscribed()) {
                synchronized (this) {
                    if (this.emitting) {
                        if (innerProducer != null) {
                            List list2 = this.kBf;
                            if (list2 == null) {
                                list2 = new ArrayList();
                                this.kBf = list2;
                            }
                            list2.add(innerProducer);
                        } else {
                            this.kBg = true;
                        }
                        this.missed = true;
                        return;
                    }
                    this.emitting = true;
                    long j3 = this.kBd;
                    if (innerProducer != null) {
                        j = Math.max(j3, innerProducer.totalRequested.get());
                    } else {
                        j = j3;
                        for (InnerProducer<T> innerProducer2 : cON()) {
                            if (innerProducer2 != null) {
                                j = Math.max(j, innerProducer2.totalRequested.get());
                            }
                        }
                    }
                    E(j, j3);
                    while (!isUnsubscribed()) {
                        synchronized (this) {
                            if (!this.missed) {
                                this.emitting = false;
                                return;
                            }
                            this.missed = false;
                            list = this.kBf;
                            this.kBf = null;
                            z = this.kBg;
                            this.kBg = false;
                        }
                        long j4 = this.kBd;
                        if (list != null) {
                            long j5 = j4;
                            for (InnerProducer<T> innerProducer3 : list) {
                                j5 = Math.max(j5, innerProducer3.totalRequested.get());
                            }
                            j2 = j5;
                        } else {
                            j2 = j4;
                        }
                        if (z) {
                            for (InnerProducer<T> innerProducer4 : cON()) {
                                if (innerProducer4 != null) {
                                    j2 = Math.max(j2, innerProducer4.totalRequested.get());
                                }
                            }
                        }
                        E(j2, j4);
                    }
                }
            }
        }

        InnerProducer<T>[] cON() {
            InnerProducer<T>[] innerProducerArr;
            synchronized (this.kAZ) {
                InnerProducer<T>[] cOX = this.kAZ.cOX();
                int length = cOX.length;
                innerProducerArr = new InnerProducer[length];
                System.arraycopy(cOX, 0, innerProducerArr, 0, length);
            }
            return innerProducerArr;
        }

        void E(long j, long j2) {
            long j3 = this.kBe;
            rx.f fVar = this.producer;
            long j4 = j - j2;
            if (j4 != 0) {
                this.kBd = j;
                if (fVar != null) {
                    if (j3 != 0) {
                        this.kBe = 0L;
                        fVar.request(j3 + j4);
                        return;
                    }
                    fVar.request(j4);
                    return;
                }
                long j5 = j3 + j4;
                if (j5 < 0) {
                    j5 = Long.MAX_VALUE;
                }
                this.kBe = j5;
            } else if (j3 != 0 && fVar != null) {
                this.kBe = 0L;
                fVar.request(j3);
            }
        }

        void replay() {
            InnerProducer<T>[] innerProducerArr = this.kBa;
            if (this.kBc != this.kBb) {
                synchronized (this.kAZ) {
                    innerProducerArr = this.kBa;
                    InnerProducer<T>[] cOX = this.kAZ.cOX();
                    int length = cOX.length;
                    if (innerProducerArr.length != length) {
                        innerProducerArr = new InnerProducer[length];
                        this.kBa = innerProducerArr;
                    }
                    System.arraycopy(cOX, 0, innerProducerArr, 0, length);
                    this.kBc = this.kBb;
                }
            }
            a<T> aVar = this.kAW;
            for (InnerProducer<T> innerProducer : innerProducerArr) {
                if (innerProducer != null) {
                    aVar.replay(innerProducer);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class InnerProducer<T> extends AtomicLong implements rx.f, rx.k {
        static final long UNSUBSCRIBED = Long.MIN_VALUE;
        private static final long serialVersionUID = -4453897557930727610L;
        rx.j<? super T> child;
        boolean emitting;
        Object index;
        boolean missed;
        final b<T> parent;
        final AtomicLong totalRequested = new AtomicLong();

        public InnerProducer(b<T> bVar, rx.j<? super T> jVar) {
            this.parent = bVar;
            this.child = jVar;
        }

        @Override // rx.f
        public void request(long j) {
            long j2;
            long j3;
            if (j >= 0) {
                do {
                    j2 = get();
                    if (j2 != Long.MIN_VALUE) {
                        if (j2 < 0 || j != 0) {
                            j3 = j2 + j;
                            if (j3 < 0) {
                                j3 = Long.MAX_VALUE;
                            }
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                } while (!compareAndSet(j2, j3));
                addTotalRequested(j);
                this.parent.c(this);
                this.parent.kAW.replay(this);
            }
        }

        void addTotalRequested(long j) {
            long j2;
            long j3;
            do {
                j2 = this.totalRequested.get();
                j3 = j2 + j;
                if (j3 < 0) {
                    j3 = Long.MAX_VALUE;
                }
            } while (!this.totalRequested.compareAndSet(j2, j3));
        }

        public long produced(long j) {
            long j2;
            long j3;
            if (j <= 0) {
                throw new IllegalArgumentException("Cant produce zero or less");
            }
            do {
                j2 = get();
                if (j2 == Long.MIN_VALUE) {
                    return Long.MIN_VALUE;
                }
                j3 = j2 - j;
                if (j3 < 0) {
                    throw new IllegalStateException("More produced (" + j + ") than requested (" + j2 + ")");
                }
            } while (!compareAndSet(j2, j3));
            return j3;
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return get() == Long.MIN_VALUE;
        }

        @Override // rx.k
        public void unsubscribe() {
            if (get() != Long.MIN_VALUE && getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.parent.b(this);
                this.parent.c(this);
                this.child = null;
            }
        }

        <U> U index() {
            return (U) this.index;
        }
    }

    /* loaded from: classes2.dex */
    static final class UnboundedReplayBuffer<T> extends ArrayList<Object> implements a<T> {
        private static final long serialVersionUID = 7063189396499112664L;
        volatile int size;

        public UnboundedReplayBuffer(int i) {
            super(i);
        }

        @Override // rx.internal.operators.OperatorReplay.a
        public void next(T t) {
            add(NotificationLite.bl(t));
            this.size++;
        }

        @Override // rx.internal.operators.OperatorReplay.a
        public void error(Throwable th) {
            add(NotificationLite.N(th));
            this.size++;
        }

        @Override // rx.internal.operators.OperatorReplay.a
        public void complete() {
            add(NotificationLite.cOx());
            this.size++;
        }

        @Override // rx.internal.operators.OperatorReplay.a
        public void replay(InnerProducer<T> innerProducer) {
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
                    rx.j<? super T> jVar = innerProducer.child;
                    if (jVar != null) {
                        long j = innerProducer.get();
                        long j2 = 0;
                        while (j2 != j && intValue < i) {
                            Object obj = get(intValue);
                            try {
                                if (!NotificationLite.a(jVar, obj) && !innerProducer.isUnsubscribed()) {
                                    intValue++;
                                    j2++;
                                } else {
                                    return;
                                }
                            } catch (Throwable th) {
                                rx.exceptions.a.K(th);
                                innerProducer.unsubscribe();
                                if (!NotificationLite.bn(obj) && !NotificationLite.bm(obj)) {
                                    jVar.onError(OnErrorThrowable.addValueAsLastCause(th, NotificationLite.bo(obj)));
                                    return;
                                }
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
                    } else {
                        return;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class Node extends AtomicReference<Node> {
        private static final long serialVersionUID = 245354315435971818L;
        final long index;
        final Object value;

        public Node(Object obj, long j) {
            this.value = obj;
            this.index = j;
        }
    }

    /* loaded from: classes2.dex */
    static class BoundedReplayBuffer<T> extends AtomicReference<Node> implements a<T> {
        private static final long serialVersionUID = 2346567790059478686L;
        long index;
        int size;
        Node tail;

        public BoundedReplayBuffer() {
            Node node = new Node(null, 0L);
            this.tail = node;
            set(node);
        }

        final void addLast(Node node) {
            this.tail.set(node);
            this.tail = node;
            this.size++;
        }

        final void removeFirst() {
            Node node = get().get();
            if (node == null) {
                throw new IllegalStateException("Empty list!");
            }
            this.size--;
            setFirst(node);
        }

        final void removeSome(int i) {
            Node node = get();
            while (i > 0) {
                node = node.get();
                i--;
                this.size--;
            }
            setFirst(node);
        }

        final void setFirst(Node node) {
            set(node);
        }

        Node getInitialHead() {
            return get();
        }

        @Override // rx.internal.operators.OperatorReplay.a
        public final void next(T t) {
            Object enterTransform = enterTransform(NotificationLite.bl(t));
            long j = this.index + 1;
            this.index = j;
            addLast(new Node(enterTransform, j));
            truncate();
        }

        @Override // rx.internal.operators.OperatorReplay.a
        public final void error(Throwable th) {
            Object enterTransform = enterTransform(NotificationLite.N(th));
            long j = this.index + 1;
            this.index = j;
            addLast(new Node(enterTransform, j));
            truncateFinal();
        }

        @Override // rx.internal.operators.OperatorReplay.a
        public final void complete() {
            Object enterTransform = enterTransform(NotificationLite.cOx());
            long j = this.index + 1;
            this.index = j;
            addLast(new Node(enterTransform, j));
            truncateFinal();
        }

        @Override // rx.internal.operators.OperatorReplay.a
        public final void replay(InnerProducer<T> innerProducer) {
            rx.j<? super T> jVar;
            Node node;
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
                    if (!innerProducer.isUnsubscribed() && (jVar = innerProducer.child) != null) {
                        long j = innerProducer.get();
                        long j2 = 0;
                        while (true) {
                            node = node2;
                            if (j2 == j || (node2 = node.get()) == null) {
                                break;
                            }
                            Object leaveTransform = leaveTransform(node2.value);
                            try {
                                if (NotificationLite.a(jVar, leaveTransform)) {
                                    innerProducer.index = null;
                                    return;
                                }
                                j2++;
                                if (innerProducer.isUnsubscribed()) {
                                    return;
                                }
                            } catch (Throwable th) {
                                innerProducer.index = null;
                                rx.exceptions.a.K(th);
                                innerProducer.unsubscribe();
                                if (!NotificationLite.bn(leaveTransform) && !NotificationLite.bm(leaveTransform)) {
                                    jVar.onError(OnErrorThrowable.addValueAsLastCause(th, NotificationLite.bo(leaveTransform)));
                                    return;
                                }
                                return;
                            }
                        }
                        if (j2 != 0) {
                            innerProducer.index = node;
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
                    } else {
                        return;
                    }
                }
            }
        }

        Object enterTransform(Object obj) {
            return obj;
        }

        Object leaveTransform(Object obj) {
            return obj;
        }

        void truncate() {
        }

        void truncateFinal() {
        }

        final void collect(Collection<? super T> collection) {
            Node initialHead = getInitialHead();
            while (true) {
                initialHead = initialHead.get();
                if (initialHead != null) {
                    Object leaveTransform = leaveTransform(initialHead.value);
                    if (!NotificationLite.bm(leaveTransform) && !NotificationLite.bn(leaveTransform)) {
                        collection.add((Object) NotificationLite.bo(leaveTransform));
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
        }

        boolean hasError() {
            return this.tail.value != null && NotificationLite.bn(leaveTransform(this.tail.value));
        }

        boolean hasCompleted() {
            return this.tail.value != null && NotificationLite.bm(leaveTransform(this.tail.value));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class SizeBoundReplayBuffer<T> extends BoundedReplayBuffer<T> {
        private static final long serialVersionUID = -5898283885385201806L;
        final int limit;

        public SizeBoundReplayBuffer(int i) {
            this.limit = i;
        }

        @Override // rx.internal.operators.OperatorReplay.BoundedReplayBuffer
        void truncate() {
            if (this.size > this.limit) {
                removeFirst();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class SizeAndTimeBoundReplayBuffer<T> extends BoundedReplayBuffer<T> {
        private static final long serialVersionUID = 3457957419649567404L;
        final int limit;
        final long maxAgeInMillis;
        final rx.g scheduler;

        public SizeAndTimeBoundReplayBuffer(int i, long j, rx.g gVar) {
            this.scheduler = gVar;
            this.limit = i;
            this.maxAgeInMillis = j;
        }

        @Override // rx.internal.operators.OperatorReplay.BoundedReplayBuffer
        Object enterTransform(Object obj) {
            return new rx.schedulers.a(this.scheduler.now(), obj);
        }

        @Override // rx.internal.operators.OperatorReplay.BoundedReplayBuffer
        Object leaveTransform(Object obj) {
            return ((rx.schedulers.a) obj).getValue();
        }

        @Override // rx.internal.operators.OperatorReplay.BoundedReplayBuffer
        Node getInitialHead() {
            long now = this.scheduler.now() - this.maxAgeInMillis;
            Node node = (Node) get();
            Node node2 = node;
            for (Node node3 = node.get(); node3 != null && ((rx.schedulers.a) node3.value).cPQ() <= now; node3 = node3.get()) {
                node2 = node3;
            }
            return node2;
        }

        @Override // rx.internal.operators.OperatorReplay.BoundedReplayBuffer
        void truncate() {
            long now = this.scheduler.now() - this.maxAgeInMillis;
            Node node = (Node) get();
            Node node2 = node;
            int i = 0;
            Node node3 = node.get();
            while (node3 != null) {
                if (this.size > this.limit) {
                    i++;
                    this.size--;
                    node2 = node3;
                    node3 = node3.get();
                } else if (((rx.schedulers.a) node3.value).cPQ() > now) {
                    break;
                } else {
                    i++;
                    this.size--;
                    node2 = node3;
                    node3 = node3.get();
                }
            }
            if (i != 0) {
                setFirst(node2);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0041, code lost:
            setFirst(r3);
         */
        /* JADX WARN: Code restructure failed: missing block: B:11:0x0044, code lost:
            return;
         */
        @Override // rx.internal.operators.OperatorReplay.BoundedReplayBuffer
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        void truncateFinal() {
            long now = this.scheduler.now() - this.maxAgeInMillis;
            Node node = (Node) get();
            Node node2 = node;
            int i = 0;
            for (Node node3 = node.get(); node3 != null && this.size > 1 && ((rx.schedulers.a) node3.value).cPQ() <= now; node3 = node3.get()) {
                i++;
                this.size--;
                node2 = node3;
            }
        }
    }
}
