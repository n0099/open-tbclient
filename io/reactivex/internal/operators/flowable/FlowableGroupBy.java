package io.reactivex.internal.operators.flowable;

import com.google.android.exoplayer2.Format;
import io.reactivex.c.h;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.EmptyComponent;
import io.reactivex.j;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class FlowableGroupBy<T, K, V> extends io.reactivex.internal.operators.flowable.a<T, io.reactivex.b.b<K, V>> {
    final int bufferSize;
    final boolean delayError;
    final h<? super T, ? extends K> keySelector;
    final h<? super io.reactivex.c.g<Object>, ? extends Map<K, Object>> nwS;
    final h<? super T, ? extends V> valueSelector;

    @Override // io.reactivex.g
    protected void a(org.a.c<? super io.reactivex.b.b<K, V>> cVar) {
        ConcurrentLinkedQueue concurrentLinkedQueue;
        Map<K, Object> apply;
        try {
            if (this.nwS == null) {
                concurrentLinkedQueue = null;
                apply = new ConcurrentHashMap<>();
            } else {
                concurrentLinkedQueue = new ConcurrentLinkedQueue();
                apply = this.nwS.apply(new a(concurrentLinkedQueue));
            }
            this.nwt.a((j) new GroupBySubscriber(cVar, this.keySelector, this.valueSelector, this.bufferSize, this.delayError, apply, concurrentLinkedQueue));
        } catch (Exception e) {
            io.reactivex.exceptions.a.H(e);
            cVar.onSubscribe(EmptyComponent.INSTANCE);
            cVar.onError(e);
        }
    }

    /* loaded from: classes7.dex */
    public static final class GroupBySubscriber<T, K, V> extends BasicIntQueueSubscription<io.reactivex.b.b<K, V>> implements j<T> {
        static final Object NULL_KEY = new Object();
        private static final long serialVersionUID = -3688291656102519502L;
        final org.a.c<? super io.reactivex.b.b<K, V>> actual;
        final int bufferSize;
        final boolean delayError;
        boolean done;
        Throwable error;
        final Queue<b<K, V>> evictedGroups;
        volatile boolean finished;
        final Map<Object, b<K, V>> groups;
        final h<? super T, ? extends K> keySelector;
        boolean outputFused;
        final io.reactivex.internal.queue.a<io.reactivex.b.b<K, V>> queue;
        org.a.d s;
        final h<? super T, ? extends V> valueSelector;
        final AtomicBoolean cancelled = new AtomicBoolean();
        final AtomicLong requested = new AtomicLong();
        final AtomicInteger groupCount = new AtomicInteger(1);

        public GroupBySubscriber(org.a.c<? super io.reactivex.b.b<K, V>> cVar, h<? super T, ? extends K> hVar, h<? super T, ? extends V> hVar2, int i, boolean z, Map<Object, b<K, V>> map, Queue<b<K, V>> queue) {
            this.actual = cVar;
            this.keySelector = hVar;
            this.valueSelector = hVar2;
            this.bufferSize = i;
            this.delayError = z;
            this.groups = map;
            this.evictedGroups = queue;
            this.queue = new io.reactivex.internal.queue.a<>(i);
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d dVar) {
            if (SubscriptionHelper.validate(this.s, dVar)) {
                this.s = dVar;
                this.actual.onSubscribe(this);
                dVar.request(this.bufferSize);
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v7, resolved type: io.reactivex.internal.operators.flowable.FlowableGroupBy$b */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.a.c
        public void onNext(T t) {
            boolean z;
            if (!this.done) {
                io.reactivex.internal.queue.a<io.reactivex.b.b<K, V>> aVar = this.queue;
                try {
                    Object apply = this.keySelector.apply(t);
                    Object obj = apply != null ? apply : NULL_KEY;
                    b<K, V> bVar = this.groups.get(obj);
                    if (bVar != null) {
                        z = false;
                    } else if (!this.cancelled.get()) {
                        bVar = b.a(apply, this.bufferSize, (GroupBySubscriber<?, Object, T>) this, this.delayError);
                        this.groups.put(obj, bVar);
                        this.groupCount.getAndIncrement();
                        z = true;
                    } else {
                        return;
                    }
                    try {
                        bVar.onNext(io.reactivex.internal.functions.a.h(this.valueSelector.apply(t), "The valueSelector returned null"));
                        completeEvictions();
                        if (z) {
                            aVar.offer(bVar);
                            drain();
                        }
                    } catch (Throwable th) {
                        io.reactivex.exceptions.a.H(th);
                        this.s.cancel();
                        onError(th);
                    }
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.H(th2);
                    this.s.cancel();
                    onError(th2);
                }
            }
        }

        @Override // org.a.c
        public void onError(Throwable th) {
            if (this.done) {
                io.reactivex.e.a.onError(th);
                return;
            }
            this.done = true;
            for (b<K, V> bVar : this.groups.values()) {
                bVar.onError(th);
            }
            this.groups.clear();
            if (this.evictedGroups != null) {
                this.evictedGroups.clear();
            }
            this.error = th;
            this.finished = true;
            drain();
        }

        @Override // org.a.c
        public void onComplete() {
            if (!this.done) {
                for (b<K, V> bVar : this.groups.values()) {
                    bVar.onComplete();
                }
                this.groups.clear();
                if (this.evictedGroups != null) {
                    this.evictedGroups.clear();
                }
                this.done = true;
                this.finished = true;
                drain();
            }
        }

        @Override // org.a.d
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                io.reactivex.internal.util.b.a(this.requested, j);
                drain();
            }
        }

        @Override // org.a.d
        public void cancel() {
            if (this.cancelled.compareAndSet(false, true)) {
                completeEvictions();
                if (this.groupCount.decrementAndGet() == 0) {
                    this.s.cancel();
                }
            }
        }

        private void completeEvictions() {
            int i;
            if (this.evictedGroups != null) {
                int i2 = 0;
                while (true) {
                    i = i2;
                    b<K, V> poll = this.evictedGroups.poll();
                    if (poll == null) {
                        break;
                    }
                    poll.onComplete();
                    i2 = i + 1;
                }
                if (i != 0) {
                    this.groupCount.addAndGet(-i);
                }
            }
        }

        public void cancel(K k) {
            if (k == null) {
                k = (K) NULL_KEY;
            }
            this.groups.remove(k);
            if (this.groupCount.decrementAndGet() == 0) {
                this.s.cancel();
                if (getAndIncrement() == 0) {
                    this.queue.clear();
                }
            }
        }

        void drain() {
            if (getAndIncrement() == 0) {
                if (this.outputFused) {
                    drainFused();
                } else {
                    drainNormal();
                }
            }
        }

        void drainFused() {
            Throwable th;
            int i = 1;
            io.reactivex.internal.queue.a<io.reactivex.b.b<K, V>> aVar = this.queue;
            org.a.c<? super io.reactivex.b.b<K, V>> cVar = this.actual;
            while (!this.cancelled.get()) {
                boolean z = this.finished;
                if (z && !this.delayError && (th = this.error) != null) {
                    aVar.clear();
                    cVar.onError(th);
                    return;
                }
                cVar.onNext(null);
                if (z) {
                    Throwable th2 = this.error;
                    if (th2 != null) {
                        cVar.onError(th2);
                        return;
                    } else {
                        cVar.onComplete();
                        return;
                    }
                }
                i = addAndGet(-i);
                if (i == 0) {
                    return;
                }
            }
            aVar.clear();
        }

        void drainNormal() {
            io.reactivex.internal.queue.a<io.reactivex.b.b<K, V>> aVar = this.queue;
            org.a.c<? super io.reactivex.b.b<K, V>> cVar = this.actual;
            int i = 1;
            while (true) {
                long j = this.requested.get();
                long j2 = 0;
                while (j2 != j) {
                    boolean z = this.finished;
                    io.reactivex.b.b<K, V> poll = aVar.poll();
                    boolean z2 = poll == null;
                    if (!checkTerminated(z, z2, cVar, aVar)) {
                        if (z2) {
                            break;
                        }
                        cVar.onNext(poll);
                        j2++;
                    } else {
                        return;
                    }
                }
                if (j2 != j || !checkTerminated(this.finished, aVar.isEmpty(), cVar, aVar)) {
                    if (j2 != 0) {
                        if (j != Format.OFFSET_SAMPLE_RELATIVE) {
                            this.requested.addAndGet(-j2);
                        }
                        this.s.request(j2);
                    }
                    int addAndGet = addAndGet(-i);
                    if (addAndGet == 0) {
                        return;
                    }
                    i = addAndGet;
                } else {
                    return;
                }
            }
        }

        boolean checkTerminated(boolean z, boolean z2, org.a.c<?> cVar, io.reactivex.internal.queue.a<?> aVar) {
            if (this.cancelled.get()) {
                aVar.clear();
                return true;
            }
            if (this.delayError) {
                if (z && z2) {
                    Throwable th = this.error;
                    if (th != null) {
                        cVar.onError(th);
                        return true;
                    }
                    cVar.onComplete();
                    return true;
                }
            } else if (z) {
                Throwable th2 = this.error;
                if (th2 != null) {
                    aVar.clear();
                    cVar.onError(th2);
                    return true;
                } else if (z2) {
                    cVar.onComplete();
                    return true;
                }
            }
            return false;
        }

        @Override // io.reactivex.internal.a.c
        public int requestFusion(int i) {
            if ((i & 2) != 0) {
                this.outputFused = true;
                return 2;
            }
            return 0;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // io.reactivex.internal.a.g
        public io.reactivex.b.b<K, V> poll() {
            return this.queue.poll();
        }

        @Override // io.reactivex.internal.a.g
        public void clear() {
            this.queue.clear();
        }

        @Override // io.reactivex.internal.a.g
        public boolean isEmpty() {
            return this.queue.isEmpty();
        }
    }

    /* loaded from: classes7.dex */
    static final class a<K, V> implements io.reactivex.c.g<b<K, V>> {
        final Queue<b<K, V>> evictedGroups;

        a(Queue<b<K, V>> queue) {
            this.evictedGroups = queue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // io.reactivex.c.g
        /* renamed from: a */
        public void accept(b<K, V> bVar) {
            this.evictedGroups.offer(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class b<K, T> extends io.reactivex.b.b<K, T> {
        final State<T, K> nwT;

        public static <T, K> b<K, T> a(K k, int i, GroupBySubscriber<?, K, T> groupBySubscriber, boolean z) {
            return new b<>(k, new State(i, groupBySubscriber, k, z));
        }

        protected b(K k, State<T, K> state) {
            super(k);
            this.nwT = state;
        }

        @Override // io.reactivex.g
        protected void a(org.a.c<? super T> cVar) {
            this.nwT.subscribe(cVar);
        }

        public void onNext(T t) {
            this.nwT.onNext(t);
        }

        public void onError(Throwable th) {
            this.nwT.onError(th);
        }

        public void onComplete() {
            this.nwT.onComplete();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class State<T, K> extends BasicIntQueueSubscription<T> implements org.a.b<T> {
        private static final long serialVersionUID = -3852313036005250360L;
        final boolean delayError;
        volatile boolean done;
        Throwable error;
        final K key;
        boolean outputFused;
        final GroupBySubscriber<?, K, T> parent;
        int produced;
        final io.reactivex.internal.queue.a<T> queue;
        final AtomicLong requested = new AtomicLong();
        final AtomicBoolean cancelled = new AtomicBoolean();
        final AtomicReference<org.a.c<? super T>> actual = new AtomicReference<>();
        final AtomicBoolean once = new AtomicBoolean();

        State(int i, GroupBySubscriber<?, K, T> groupBySubscriber, K k, boolean z) {
            this.queue = new io.reactivex.internal.queue.a<>(i);
            this.parent = groupBySubscriber;
            this.key = k;
            this.delayError = z;
        }

        @Override // org.a.d
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                io.reactivex.internal.util.b.a(this.requested, j);
                drain();
            }
        }

        @Override // org.a.d
        public void cancel() {
            if (this.cancelled.compareAndSet(false, true)) {
                this.parent.cancel(this.key);
            }
        }

        @Override // org.a.b
        public void subscribe(org.a.c<? super T> cVar) {
            if (this.once.compareAndSet(false, true)) {
                cVar.onSubscribe(this);
                this.actual.lazySet(cVar);
                drain();
                return;
            }
            EmptySubscription.error(new IllegalStateException("Only one Subscriber allowed!"), cVar);
        }

        public void onNext(T t) {
            this.queue.offer(t);
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
                if (this.outputFused) {
                    drainFused();
                } else {
                    drainNormal();
                }
            }
        }

        void drainFused() {
            Throwable th;
            int i = 1;
            io.reactivex.internal.queue.a<T> aVar = this.queue;
            org.a.c<? super T> cVar = this.actual.get();
            while (true) {
                if (cVar != null) {
                    if (this.cancelled.get()) {
                        aVar.clear();
                        return;
                    }
                    boolean z = this.done;
                    if (z && !this.delayError && (th = this.error) != null) {
                        aVar.clear();
                        cVar.onError(th);
                        return;
                    }
                    cVar.onNext(null);
                    if (z) {
                        Throwable th2 = this.error;
                        if (th2 != null) {
                            cVar.onError(th2);
                            return;
                        } else {
                            cVar.onComplete();
                            return;
                        }
                    }
                }
                i = addAndGet(-i);
                if (i == 0) {
                    return;
                }
                if (cVar == null) {
                    cVar = this.actual.get();
                }
            }
        }

        void drainNormal() {
            io.reactivex.internal.queue.a<T> aVar = this.queue;
            boolean z = this.delayError;
            org.a.c<? super T> cVar = this.actual.get();
            int i = 1;
            while (true) {
                if (cVar != null) {
                    long j = this.requested.get();
                    long j2 = 0;
                    while (j2 != j) {
                        boolean z2 = this.done;
                        Object obj = (T) aVar.poll();
                        boolean z3 = obj == null;
                        if (!checkTerminated(z2, z3, cVar, z)) {
                            if (z3) {
                                break;
                            }
                            cVar.onNext(obj);
                            j2++;
                        } else {
                            return;
                        }
                    }
                    if (j2 != j || !checkTerminated(this.done, aVar.isEmpty(), cVar, z)) {
                        if (j2 != 0) {
                            if (j != Format.OFFSET_SAMPLE_RELATIVE) {
                                this.requested.addAndGet(-j2);
                            }
                            this.parent.s.request(j2);
                        }
                    } else {
                        return;
                    }
                }
                int addAndGet = addAndGet(-i);
                if (addAndGet != 0) {
                    if (cVar == null) {
                        cVar = this.actual.get();
                        i = addAndGet;
                    } else {
                        i = addAndGet;
                    }
                } else {
                    return;
                }
            }
        }

        boolean checkTerminated(boolean z, boolean z2, org.a.c<? super T> cVar, boolean z3) {
            if (this.cancelled.get()) {
                this.queue.clear();
                return true;
            }
            if (z) {
                if (z3) {
                    if (z2) {
                        Throwable th = this.error;
                        if (th != null) {
                            cVar.onError(th);
                            return true;
                        }
                        cVar.onComplete();
                        return true;
                    }
                } else {
                    Throwable th2 = this.error;
                    if (th2 != null) {
                        this.queue.clear();
                        cVar.onError(th2);
                        return true;
                    } else if (z2) {
                        cVar.onComplete();
                        return true;
                    }
                }
            }
            return false;
        }

        @Override // io.reactivex.internal.a.c
        public int requestFusion(int i) {
            if ((i & 2) != 0) {
                this.outputFused = true;
                return 2;
            }
            return 0;
        }

        @Override // io.reactivex.internal.a.g
        public T poll() {
            T poll = this.queue.poll();
            if (poll != null) {
                this.produced++;
                return poll;
            }
            int i = this.produced;
            if (i != 0) {
                this.produced = 0;
                this.parent.s.request(i);
            }
            return null;
        }

        @Override // io.reactivex.internal.a.g
        public boolean isEmpty() {
            return this.queue.isEmpty();
        }

        @Override // io.reactivex.internal.a.g
        public void clear() {
            this.queue.clear();
        }
    }
}
