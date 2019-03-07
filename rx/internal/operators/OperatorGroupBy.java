package rx.internal.operators;

import java.util.ArrayList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.d;
/* loaded from: classes2.dex */
public final class OperatorGroupBy<T, K, V> implements d.b<rx.observables.b<K, V>, T> {
    final int bufferSize;
    final boolean delayError;
    final rx.functions.f<? super T, ? extends K> jXl;
    final rx.functions.f<? super T, ? extends V> jXm;
    final rx.functions.f<rx.functions.b<K>, Map<K, Object>> jXn;

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public rx.j<? super T> call(rx.j<? super rx.observables.b<K, V>> jVar) {
        try {
            final b bVar = new b(jVar, this.jXl, this.jXm, this.bufferSize, this.delayError, this.jXn);
            jVar.add(rx.subscriptions.e.l(new rx.functions.a() { // from class: rx.internal.operators.OperatorGroupBy.1
                @Override // rx.functions.a
                public void call() {
                    bVar.cancel();
                }
            }));
            jVar.setProducer(bVar.jXr);
            return bVar;
        } catch (Throwable th) {
            rx.exceptions.a.a(th, jVar);
            rx.j<? super T> cEM = rx.b.f.cEM();
            cEM.unsubscribe();
            return cEM;
        }
    }

    /* loaded from: classes2.dex */
    public static final class a implements rx.f {
        final b<?, ?, ?> parent;

        public a(b<?, ?, ?> bVar) {
            this.parent = bVar;
        }

        @Override // rx.f
        public void request(long j) {
            this.parent.ek(j);
        }
    }

    /* loaded from: classes2.dex */
    public static final class b<T, K, V> extends rx.j<T> {
        static final Object jXt = new Object();
        final rx.j<? super rx.observables.b<K, V>> actual;
        final int bufferSize;
        final AtomicBoolean cancelled;
        final boolean delayError;
        volatile boolean done;
        Throwable error;
        final rx.functions.f<? super T, ? extends K> jXl;
        final rx.functions.f<? super T, ? extends V> jXm;
        final Map<Object, c<K, V>> jXq;
        final a jXr;
        final Queue<K> jXs;
        final AtomicInteger jXv;
        final AtomicLong requested;
        final AtomicInteger wip;
        final Queue<rx.observables.b<K, V>> queue = new ConcurrentLinkedQueue();
        final rx.internal.producers.a jXu = new rx.internal.producers.a();

        public b(rx.j<? super rx.observables.b<K, V>> jVar, rx.functions.f<? super T, ? extends K> fVar, rx.functions.f<? super T, ? extends V> fVar2, int i, boolean z, rx.functions.f<rx.functions.b<K>, Map<K, Object>> fVar3) {
            this.actual = jVar;
            this.jXl = fVar;
            this.jXm = fVar2;
            this.bufferSize = i;
            this.delayError = z;
            this.jXu.request(i);
            this.jXr = new a(this);
            this.cancelled = new AtomicBoolean();
            this.requested = new AtomicLong();
            this.jXv = new AtomicInteger(1);
            this.wip = new AtomicInteger();
            if (fVar3 == null) {
                this.jXq = new ConcurrentHashMap();
                this.jXs = null;
                return;
            }
            this.jXs = new ConcurrentLinkedQueue();
            this.jXq = a(fVar3, new a(this.jXs));
        }

        /* loaded from: classes2.dex */
        static class a<K> implements rx.functions.b<K> {
            final Queue<K> jXs;

            a(Queue<K> queue) {
                this.jXs = queue;
            }

            @Override // rx.functions.b
            public void call(K k) {
                this.jXs.offer(k);
            }
        }

        private Map<Object, c<K, V>> a(rx.functions.f<rx.functions.b<K>, Map<K, Object>> fVar, rx.functions.b<K> bVar) {
            return fVar.call(bVar);
        }

        @Override // rx.j
        public void setProducer(rx.f fVar) {
            this.jXu.setProducer(fVar);
        }

        @Override // rx.e
        public void onNext(T t) {
            boolean z;
            if (!this.done) {
                Queue<?> queue = this.queue;
                rx.j<? super rx.observables.b<K, V>> jVar = this.actual;
                try {
                    Object call = this.jXl.call(t);
                    Object obj = call != null ? call : jXt;
                    c cVar = this.jXq.get(obj);
                    if (cVar != null) {
                        z = true;
                    } else if (!this.cancelled.get()) {
                        cVar = c.a(call, this.bufferSize, (b<?, Object, T>) this, this.delayError);
                        this.jXq.put(obj, cVar);
                        this.jXv.getAndIncrement();
                        z = false;
                        queue.offer(cVar);
                        drain();
                    } else {
                        return;
                    }
                    try {
                        cVar.onNext(this.jXm.call(t));
                        if (this.jXs != null) {
                            while (true) {
                                K poll = this.jXs.poll();
                                if (poll == null) {
                                    break;
                                }
                                c<K, V> cVar2 = this.jXq.get(poll);
                                if (cVar2 != null) {
                                    cVar2.onComplete();
                                }
                            }
                        }
                        if (z) {
                            this.jXu.request(1L);
                        }
                    } catch (Throwable th) {
                        unsubscribe();
                        a(jVar, queue, th);
                    }
                } catch (Throwable th2) {
                    unsubscribe();
                    a(jVar, queue, th2);
                }
            }
        }

        @Override // rx.e
        public void onError(Throwable th) {
            if (this.done) {
                rx.c.c.onError(th);
                return;
            }
            this.error = th;
            this.done = true;
            this.jXv.decrementAndGet();
            drain();
        }

        @Override // rx.e
        public void onCompleted() {
            if (!this.done) {
                for (c<K, V> cVar : this.jXq.values()) {
                    cVar.onComplete();
                }
                this.jXq.clear();
                if (this.jXs != null) {
                    this.jXs.clear();
                }
                this.done = true;
                this.jXv.decrementAndGet();
                drain();
            }
        }

        public void ek(long j) {
            if (j < 0) {
                throw new IllegalArgumentException("n >= 0 required but it was " + j);
            }
            rx.internal.operators.a.a(this.requested, j);
            drain();
        }

        public void cancel() {
            if (this.cancelled.compareAndSet(false, true) && this.jXv.decrementAndGet() == 0) {
                unsubscribe();
            }
        }

        public void bv(K k) {
            if (k == null) {
                k = (K) jXt;
            }
            if (this.jXq.remove(k) != null && this.jXv.decrementAndGet() == 0) {
                unsubscribe();
            }
        }

        void drain() {
            if (this.wip.getAndIncrement() == 0) {
                Queue<rx.observables.b<K, V>> queue = this.queue;
                rx.j<? super rx.observables.b<K, V>> jVar = this.actual;
                int i = 1;
                while (!a(this.done, queue.isEmpty(), jVar, queue)) {
                    long j = this.requested.get();
                    long j2 = 0;
                    while (j2 != j) {
                        boolean z = this.done;
                        rx.observables.b<K, V> poll = queue.poll();
                        boolean z2 = poll == null;
                        if (!a(z, z2, jVar, queue)) {
                            if (z2) {
                                break;
                            }
                            jVar.onNext(poll);
                            j2++;
                        } else {
                            return;
                        }
                    }
                    if (j2 != 0) {
                        if (j != Long.MAX_VALUE) {
                            rx.internal.operators.a.b(this.requested, j2);
                        }
                        this.jXu.request(j2);
                    }
                    int addAndGet = this.wip.addAndGet(-i);
                    if (addAndGet == 0) {
                        return;
                    }
                    i = addAndGet;
                }
            }
        }

        void a(rx.j<? super rx.observables.b<K, V>> jVar, Queue<?> queue, Throwable th) {
            queue.clear();
            ArrayList<c> arrayList = new ArrayList(this.jXq.values());
            this.jXq.clear();
            if (this.jXs != null) {
                this.jXs.clear();
            }
            for (c cVar : arrayList) {
                cVar.onError(th);
            }
            jVar.onError(th);
        }

        boolean a(boolean z, boolean z2, rx.j<? super rx.observables.b<K, V>> jVar, Queue<?> queue) {
            if (z) {
                Throwable th = this.error;
                if (th != null) {
                    a(jVar, queue, th);
                    return true;
                } else if (z2) {
                    this.actual.onCompleted();
                    return true;
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class c<K, T> extends rx.observables.b<K, T> {
        final State<T, K> jXw;

        public static <T, K> c<K, T> a(K k, int i, b<?, K, T> bVar, boolean z) {
            return new c<>(k, new State(i, bVar, k, z));
        }

        protected c(K k, State<T, K> state) {
            super(k, state);
            this.jXw = state;
        }

        public void onNext(T t) {
            this.jXw.onNext(t);
        }

        public void onError(Throwable th) {
            this.jXw.onError(th);
        }

        public void onComplete() {
            this.jXw.onComplete();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class State<T, K> extends AtomicInteger implements d.a<T>, rx.f, rx.k {
        private static final long serialVersionUID = -3852313036005250360L;
        final boolean delayError;
        volatile boolean done;
        Throwable error;
        final K key;
        final b<?, K, T> parent;
        final Queue<Object> queue = new ConcurrentLinkedQueue();
        final AtomicBoolean cancelled = new AtomicBoolean();
        final AtomicReference<rx.j<? super T>> actual = new AtomicReference<>();
        final AtomicBoolean once = new AtomicBoolean();
        final AtomicLong requested = new AtomicLong();

        @Override // rx.functions.b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((rx.j) ((rx.j) obj));
        }

        public State(int i, b<?, K, T> bVar, K k, boolean z) {
            this.parent = bVar;
            this.key = k;
            this.delayError = z;
        }

        @Override // rx.f
        public void request(long j) {
            if (j < 0) {
                throw new IllegalArgumentException("n >= required but it was " + j);
            }
            if (j != 0) {
                rx.internal.operators.a.a(this.requested, j);
                drain();
            }
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.cancelled.get();
        }

        @Override // rx.k
        public void unsubscribe() {
            if (this.cancelled.compareAndSet(false, true) && getAndIncrement() == 0) {
                this.parent.bv(this.key);
            }
        }

        public void call(rx.j<? super T> jVar) {
            if (this.once.compareAndSet(false, true)) {
                jVar.add(this);
                jVar.setProducer(this);
                this.actual.lazySet(jVar);
                drain();
                return;
            }
            jVar.onError(new IllegalStateException("Only one Subscriber allowed!"));
        }

        public void onNext(T t) {
            if (t == null) {
                this.error = new NullPointerException();
                this.done = true;
            } else {
                this.queue.offer(NotificationLite.bp(t));
            }
            drain();
        }

        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            drain();
        }

        public void onComplete() {
            this.done = true;
            drain();
        }

        void drain() {
            if (getAndIncrement() == 0) {
                Queue<Object> queue = this.queue;
                boolean z = this.delayError;
                rx.j<? super T> jVar = this.actual.get();
                int i = 1;
                while (true) {
                    if (jVar != null) {
                        if (!checkTerminated(this.done, queue.isEmpty(), jVar, z)) {
                            long j = this.requested.get();
                            long j2 = 0;
                            while (j2 != j) {
                                boolean z2 = this.done;
                                Object poll = queue.poll();
                                boolean z3 = poll == null;
                                if (!checkTerminated(z2, z3, jVar, z)) {
                                    if (z3) {
                                        break;
                                    }
                                    jVar.onNext((Object) NotificationLite.bs(poll));
                                    j2++;
                                } else {
                                    return;
                                }
                            }
                            if (j2 != 0) {
                                if (j != Long.MAX_VALUE) {
                                    rx.internal.operators.a.b(this.requested, j2);
                                }
                                this.parent.jXu.request(j2);
                            }
                        } else {
                            return;
                        }
                    }
                    int addAndGet = addAndGet(-i);
                    if (addAndGet != 0) {
                        if (jVar == null) {
                            jVar = this.actual.get();
                            i = addAndGet;
                        } else {
                            i = addAndGet;
                        }
                    } else {
                        return;
                    }
                }
            }
        }

        boolean checkTerminated(boolean z, boolean z2, rx.j<? super T> jVar, boolean z3) {
            if (this.cancelled.get()) {
                this.queue.clear();
                this.parent.bv(this.key);
                return true;
            }
            if (z) {
                if (z3) {
                    if (z2) {
                        Throwable th = this.error;
                        if (th != null) {
                            jVar.onError(th);
                            return true;
                        }
                        jVar.onCompleted();
                        return true;
                    }
                } else {
                    Throwable th2 = this.error;
                    if (th2 != null) {
                        this.queue.clear();
                        jVar.onError(th2);
                        return true;
                    } else if (z2) {
                        jVar.onCompleted();
                        return true;
                    }
                }
            }
            return false;
        }
    }
}
