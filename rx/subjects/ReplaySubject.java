package rx.subjects;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.d;
import rx.e;
import rx.f;
import rx.g;
import rx.j;
import rx.k;
/* loaded from: classes14.dex */
public final class ReplaySubject<T> extends c<T, T> {
    private static final Object[] qhX = new Object[0];
    final ReplayState<T> state;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
    public interface a<T> {
        void a(ReplayProducer<T> replayProducer);

        void complete();

        void error(Throwable th);

        void next(T t);
    }

    @Override // rx.e
    public void onNext(T t) {
        this.state.onNext(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.state.onError(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.state.onCompleted();
    }

    /* loaded from: classes14.dex */
    static final class ReplayState<T> extends AtomicReference<ReplayProducer<T>[]> implements d.a<T>, e<T> {
        static final ReplayProducer[] EMPTY = new ReplayProducer[0];
        static final ReplayProducer[] TERMINATED = new ReplayProducer[0];
        private static final long serialVersionUID = 5952362471246910544L;
        final a<T> buffer;

        @Override // rx.functions.b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((j) ((j) obj));
        }

        public ReplayState(a<T> aVar) {
            this.buffer = aVar;
            lazySet(EMPTY);
        }

        public void call(j<? super T> jVar) {
            ReplayProducer<T> replayProducer = new ReplayProducer<>(jVar, this);
            jVar.add(replayProducer);
            jVar.setProducer(replayProducer);
            if (add(replayProducer) && replayProducer.isUnsubscribed()) {
                remove(replayProducer);
            } else {
                this.buffer.a(replayProducer);
            }
        }

        boolean add(ReplayProducer<T> replayProducer) {
            ReplayProducer<T>[] replayProducerArr;
            ReplayProducer[] replayProducerArr2;
            do {
                replayProducerArr = get();
                if (replayProducerArr == TERMINATED) {
                    return false;
                }
                int length = replayProducerArr.length;
                replayProducerArr2 = new ReplayProducer[length + 1];
                System.arraycopy(replayProducerArr, 0, replayProducerArr2, 0, length);
                replayProducerArr2[length] = replayProducer;
            } while (!compareAndSet(replayProducerArr, replayProducerArr2));
            return true;
        }

        void remove(ReplayProducer<T> replayProducer) {
            ReplayProducer<T>[] replayProducerArr;
            ReplayProducer[] replayProducerArr2;
            do {
                replayProducerArr = get();
                if (replayProducerArr != TERMINATED && replayProducerArr != EMPTY) {
                    int length = replayProducerArr.length;
                    int i = -1;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            break;
                        } else if (replayProducerArr[i2] == replayProducer) {
                            i = i2;
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (i >= 0) {
                        if (length == 1) {
                            replayProducerArr2 = EMPTY;
                        } else {
                            replayProducerArr2 = new ReplayProducer[length - 1];
                            System.arraycopy(replayProducerArr, 0, replayProducerArr2, 0, i);
                            System.arraycopy(replayProducerArr, i + 1, replayProducerArr2, i, (length - i) - 1);
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } while (!compareAndSet(replayProducerArr, replayProducerArr2));
        }

        @Override // rx.e
        public void onNext(T t) {
            a<T> aVar = this.buffer;
            aVar.next(t);
            for (ReplayProducer<T> replayProducer : get()) {
                aVar.a(replayProducer);
            }
        }

        @Override // rx.e
        public void onError(Throwable th) {
            a<T> aVar = this.buffer;
            aVar.error(th);
            ArrayList arrayList = null;
            for (ReplayProducer<T> replayProducer : getAndSet(TERMINATED)) {
                try {
                    aVar.a(replayProducer);
                } catch (Throwable th2) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th2);
                }
            }
            rx.exceptions.a.ho(arrayList);
        }

        @Override // rx.e
        public void onCompleted() {
            a<T> aVar = this.buffer;
            aVar.complete();
            for (ReplayProducer<T> replayProducer : getAndSet(TERMINATED)) {
                aVar.a(replayProducer);
            }
        }

        boolean isTerminated() {
            return get() == TERMINATED;
        }
    }

    /* loaded from: classes14.dex */
    static final class ReplaySizeBoundBuffer<T> implements a<T> {
        volatile boolean done;
        Throwable error;
        final int limit;
        volatile Node<T> quw;
        Node<T> qux;
        int size;

        @Override // rx.subjects.ReplaySubject.a
        public void next(T t) {
            Node<T> node = new Node<>(t);
            this.qux.set(node);
            this.qux = node;
            int i = this.size;
            if (i == this.limit) {
                this.quw = this.quw.get();
            } else {
                this.size = i + 1;
            }
        }

        @Override // rx.subjects.ReplaySubject.a
        public void error(Throwable th) {
            this.error = th;
            this.done = true;
        }

        @Override // rx.subjects.ReplaySubject.a
        public void complete() {
            this.done = true;
        }

        /* JADX DEBUG: Type inference failed for r2v3. Raw type applied. Possible types: T, ? super T */
        @Override // rx.subjects.ReplaySubject.a
        public void a(ReplayProducer<T> replayProducer) {
            Node<T> node;
            if (replayProducer.getAndIncrement() == 0) {
                j<? super T> jVar = replayProducer.actual;
                int i = 1;
                while (true) {
                    int i2 = i;
                    long j = replayProducer.requested.get();
                    long j2 = 0;
                    Node<T> node2 = (Node) replayProducer.node;
                    if (node2 == null) {
                        node2 = this.quw;
                    }
                    while (true) {
                        node = node2;
                        if (j2 == j) {
                            break;
                        } else if (jVar.isUnsubscribed()) {
                            replayProducer.node = null;
                            return;
                        } else {
                            boolean z = this.done;
                            node2 = node.get();
                            boolean z2 = node2 == null;
                            if (z && z2) {
                                replayProducer.node = null;
                                Throwable th = this.error;
                                if (th != null) {
                                    jVar.onError(th);
                                    return;
                                } else {
                                    jVar.onCompleted();
                                    return;
                                }
                            } else if (z2) {
                                break;
                            } else {
                                jVar.onNext((T) node2.value);
                                j2++;
                            }
                        }
                    }
                    if (j2 == j) {
                        if (jVar.isUnsubscribed()) {
                            replayProducer.node = null;
                            return;
                        }
                        boolean z3 = this.done;
                        boolean z4 = node.get() == null;
                        if (z3 && z4) {
                            replayProducer.node = null;
                            Throwable th2 = this.error;
                            if (th2 != null) {
                                jVar.onError(th2);
                                return;
                            } else {
                                jVar.onCompleted();
                                return;
                            }
                        }
                    }
                    if (j2 != 0 && j != Long.MAX_VALUE) {
                        rx.internal.operators.a.c(replayProducer.requested, j2);
                    }
                    replayProducer.node = node;
                    i = replayProducer.addAndGet(-i2);
                    if (i == 0) {
                        return;
                    }
                }
            }
        }

        /* loaded from: classes14.dex */
        static final class Node<T> extends AtomicReference<Node<T>> {
            private static final long serialVersionUID = 3713592843205853725L;
            final T value;

            public Node(T t) {
                this.value = t;
            }
        }
    }

    /* loaded from: classes14.dex */
    static final class ReplaySizeAndTimeBoundBuffer<T> implements a<T> {
        volatile boolean done;
        Throwable error;
        final int limit;
        final long qut;
        volatile TimedNode<T> quu;
        TimedNode<T> quv;
        final g scheduler;
        int size;

        @Override // rx.subjects.ReplaySubject.a
        public void next(T t) {
            TimedNode<T> timedNode;
            long now = this.scheduler.now();
            TimedNode<T> timedNode2 = new TimedNode<>(t, now);
            this.quv.set(timedNode2);
            this.quv = timedNode2;
            long j = now - this.qut;
            int i = this.size;
            TimedNode<T> timedNode3 = this.quu;
            if (i == this.limit) {
                timedNode = timedNode3.get();
            } else {
                timedNode = timedNode3;
                i++;
            }
            while (true) {
                TimedNode<T> timedNode4 = timedNode.get();
                if (timedNode4 == null || timedNode4.timestamp > j) {
                    break;
                }
                i--;
                timedNode = timedNode4;
            }
            this.size = i;
            if (timedNode != timedNode3) {
                this.quu = timedNode;
            }
        }

        @Override // rx.subjects.ReplaySubject.a
        public void error(Throwable th) {
            eLN();
            this.error = th;
            this.done = true;
        }

        @Override // rx.subjects.ReplaySubject.a
        public void complete() {
            eLN();
            this.done = true;
        }

        void eLN() {
            long now = this.scheduler.now() - this.qut;
            TimedNode<T> timedNode = this.quu;
            TimedNode<T> timedNode2 = timedNode;
            while (true) {
                TimedNode<T> timedNode3 = timedNode2.get();
                if (timedNode3 == null || timedNode3.timestamp > now) {
                    break;
                }
                timedNode2 = timedNode3;
            }
            if (timedNode != timedNode2) {
                this.quu = timedNode2;
            }
        }

        TimedNode<T> eLO() {
            TimedNode<T> timedNode;
            long now = this.scheduler.now() - this.qut;
            TimedNode<T> timedNode2 = this.quu;
            while (true) {
                timedNode = timedNode2;
                timedNode2 = timedNode.get();
                if (timedNode2 == null || timedNode2.timestamp > now) {
                    break;
                }
            }
            return timedNode;
        }

        /* JADX DEBUG: Type inference failed for r2v3. Raw type applied. Possible types: T, ? super T */
        @Override // rx.subjects.ReplaySubject.a
        public void a(ReplayProducer<T> replayProducer) {
            TimedNode<T> timedNode;
            if (replayProducer.getAndIncrement() == 0) {
                j<? super T> jVar = replayProducer.actual;
                int i = 1;
                while (true) {
                    int i2 = i;
                    long j = replayProducer.requested.get();
                    long j2 = 0;
                    TimedNode<T> timedNode2 = (TimedNode) replayProducer.node;
                    if (timedNode2 == null) {
                        timedNode2 = eLO();
                    }
                    while (true) {
                        timedNode = timedNode2;
                        if (j2 == j) {
                            break;
                        } else if (jVar.isUnsubscribed()) {
                            replayProducer.node = null;
                            return;
                        } else {
                            boolean z = this.done;
                            timedNode2 = timedNode.get();
                            boolean z2 = timedNode2 == null;
                            if (z && z2) {
                                replayProducer.node = null;
                                Throwable th = this.error;
                                if (th != null) {
                                    jVar.onError(th);
                                    return;
                                } else {
                                    jVar.onCompleted();
                                    return;
                                }
                            } else if (z2) {
                                break;
                            } else {
                                jVar.onNext((T) timedNode2.value);
                                j2++;
                            }
                        }
                    }
                    if (j2 == j) {
                        if (jVar.isUnsubscribed()) {
                            replayProducer.node = null;
                            return;
                        }
                        boolean z3 = this.done;
                        boolean z4 = timedNode.get() == null;
                        if (z3 && z4) {
                            replayProducer.node = null;
                            Throwable th2 = this.error;
                            if (th2 != null) {
                                jVar.onError(th2);
                                return;
                            } else {
                                jVar.onCompleted();
                                return;
                            }
                        }
                    }
                    if (j2 != 0 && j != Long.MAX_VALUE) {
                        rx.internal.operators.a.c(replayProducer.requested, j2);
                    }
                    replayProducer.node = timedNode;
                    i = replayProducer.addAndGet(-i2);
                    if (i == 0) {
                        return;
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes14.dex */
        public static final class TimedNode<T> extends AtomicReference<TimedNode<T>> {
            private static final long serialVersionUID = 3713592843205853725L;
            final long timestamp;
            final T value;

            public TimedNode(T t, long j) {
                this.value = t;
                this.timestamp = j;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
    public static final class ReplayProducer<T> extends AtomicInteger implements f, k {
        private static final long serialVersionUID = -5006209596735204567L;
        final j<? super T> actual;
        int index;
        Object node;
        final AtomicLong requested = new AtomicLong();
        final ReplayState<T> state;
        int tailIndex;

        public ReplayProducer(j<? super T> jVar, ReplayState<T> replayState) {
            this.actual = jVar;
            this.state = replayState;
        }

        @Override // rx.k
        public void unsubscribe() {
            this.state.remove(this);
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.actual.isUnsubscribed();
        }

        @Override // rx.f
        public void request(long j) {
            if (j > 0) {
                rx.internal.operators.a.e(this.requested, j);
                this.state.buffer.a(this);
            } else if (j < 0) {
                throw new IllegalArgumentException("n >= required but it was " + j);
            }
        }
    }
}
