package rx.internal.operators;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.Emitter;
import rx.d;
import rx.exceptions.MissingBackpressureException;
import rx.internal.subscriptions.CancellableSubscription;
import rx.internal.util.a.ae;
import rx.internal.util.a.y;
/* loaded from: classes12.dex */
public final class OnSubscribeFromEmitter<T> implements d.a<T> {
    final rx.functions.b<Emitter<T>> pQf;
    final Emitter.BackpressureMode pQg;

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.j) ((rx.j) obj));
    }

    public void call(rx.j<? super T> jVar) {
        BaseEmitter latestEmitter;
        switch (this.pQg) {
            case NONE:
                latestEmitter = new NoneEmitter(jVar);
                break;
            case ERROR:
                latestEmitter = new ErrorEmitter(jVar);
                break;
            case DROP:
                latestEmitter = new DropEmitter(jVar);
                break;
            case LATEST:
                latestEmitter = new LatestEmitter(jVar);
                break;
            default:
                latestEmitter = new BufferEmitter(jVar, rx.internal.util.g.SIZE);
                break;
        }
        jVar.add(latestEmitter);
        jVar.setProducer(latestEmitter);
        this.pQf.call(latestEmitter);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public static abstract class BaseEmitter<T> extends AtomicLong implements Emitter<T>, rx.f, rx.k {
        private static final long serialVersionUID = 7326289992464377023L;
        final rx.j<? super T> actual;
        final rx.subscriptions.d serial = new rx.subscriptions.d();

        public BaseEmitter(rx.j<? super T> jVar) {
            this.actual = jVar;
        }

        @Override // rx.e
        public void onCompleted() {
            if (!this.actual.isUnsubscribed()) {
                try {
                    this.actual.onCompleted();
                } finally {
                    this.serial.unsubscribe();
                }
            }
        }

        @Override // rx.e
        public void onError(Throwable th) {
            if (!this.actual.isUnsubscribed()) {
                try {
                    this.actual.onError(th);
                } finally {
                    this.serial.unsubscribe();
                }
            }
        }

        @Override // rx.k
        public final void unsubscribe() {
            this.serial.unsubscribe();
            onUnsubscribed();
        }

        void onUnsubscribed() {
        }

        @Override // rx.k
        public final boolean isUnsubscribed() {
            return this.serial.isUnsubscribed();
        }

        @Override // rx.f
        public final void request(long j) {
            if (a.validate(j)) {
                a.e(this, j);
                onRequested();
            }
        }

        void onRequested() {
        }

        public final void setSubscription(rx.k kVar) {
            this.serial.f(kVar);
        }

        public final void setCancellation(rx.functions.d dVar) {
            setSubscription(new CancellableSubscription(dVar));
        }

        public final long requested() {
            return get();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public static final class NoneEmitter<T> extends BaseEmitter<T> {
        private static final long serialVersionUID = 3776720187248809713L;

        public NoneEmitter(rx.j<? super T> jVar) {
            super(jVar);
        }

        @Override // rx.e
        public void onNext(T t) {
            long j;
            if (!this.actual.isUnsubscribed()) {
                this.actual.onNext(t);
                do {
                    j = get();
                    if (j == 0) {
                        return;
                    }
                } while (!compareAndSet(j, j - 1));
            }
        }
    }

    /* loaded from: classes12.dex */
    static abstract class NoOverflowBaseEmitter<T> extends BaseEmitter<T> {
        private static final long serialVersionUID = 4127754106204442833L;

        abstract void onOverflow();

        public NoOverflowBaseEmitter(rx.j<? super T> jVar) {
            super(jVar);
        }

        public void onNext(T t) {
            if (!this.actual.isUnsubscribed()) {
                if (get() != 0) {
                    this.actual.onNext(t);
                    a.c(this, 1L);
                    return;
                }
                onOverflow();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public static final class DropEmitter<T> extends NoOverflowBaseEmitter<T> {
        private static final long serialVersionUID = 8360058422307496563L;

        public DropEmitter(rx.j<? super T> jVar) {
            super(jVar);
        }

        @Override // rx.internal.operators.OnSubscribeFromEmitter.NoOverflowBaseEmitter
        void onOverflow() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public static final class ErrorEmitter<T> extends NoOverflowBaseEmitter<T> {
        private static final long serialVersionUID = 338953216916120960L;
        private boolean done;

        public ErrorEmitter(rx.j<? super T> jVar) {
            super(jVar);
        }

        @Override // rx.internal.operators.OnSubscribeFromEmitter.NoOverflowBaseEmitter, rx.e
        public void onNext(T t) {
            if (!this.done) {
                super.onNext(t);
            }
        }

        @Override // rx.internal.operators.OnSubscribeFromEmitter.BaseEmitter, rx.e
        public void onCompleted() {
            if (!this.done) {
                this.done = true;
                super.onCompleted();
            }
        }

        @Override // rx.internal.operators.OnSubscribeFromEmitter.BaseEmitter, rx.e
        public void onError(Throwable th) {
            if (this.done) {
                rx.c.c.onError(th);
                return;
            }
            this.done = true;
            super.onError(th);
        }

        @Override // rx.internal.operators.OnSubscribeFromEmitter.NoOverflowBaseEmitter
        void onOverflow() {
            onError(new MissingBackpressureException("fromEmitter: could not emit value due to lack of requests"));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public static final class BufferEmitter<T> extends BaseEmitter<T> {
        private static final long serialVersionUID = 2427151001689639875L;
        volatile boolean done;
        Throwable error;
        final Queue<Object> queue;
        final AtomicInteger wip;

        public BufferEmitter(rx.j<? super T> jVar, int i) {
            super(jVar);
            this.queue = ae.eGo() ? new y<>(i) : new rx.internal.util.atomic.f<>(i);
            this.wip = new AtomicInteger();
        }

        @Override // rx.e
        public void onNext(T t) {
            this.queue.offer(NotificationLite.next(t));
            drain();
        }

        @Override // rx.internal.operators.OnSubscribeFromEmitter.BaseEmitter, rx.e
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            drain();
        }

        @Override // rx.internal.operators.OnSubscribeFromEmitter.BaseEmitter, rx.e
        public void onCompleted() {
            this.done = true;
            drain();
        }

        @Override // rx.internal.operators.OnSubscribeFromEmitter.BaseEmitter
        void onRequested() {
            drain();
        }

        @Override // rx.internal.operators.OnSubscribeFromEmitter.BaseEmitter
        void onUnsubscribed() {
            if (this.wip.getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        void drain() {
            if (this.wip.getAndIncrement() == 0) {
                rx.j<? super T> jVar = this.actual;
                Queue<Object> queue = this.queue;
                int i = 1;
                do {
                    long j = get();
                    long j2 = 0;
                    while (j2 != j) {
                        if (jVar.isUnsubscribed()) {
                            queue.clear();
                            return;
                        }
                        boolean z = this.done;
                        Object poll = queue.poll();
                        boolean z2 = poll == null;
                        if (z && z2) {
                            Throwable th = this.error;
                            if (th != null) {
                                super.onError(th);
                                return;
                            } else {
                                super.onCompleted();
                                return;
                            }
                        } else if (z2) {
                            break;
                        } else {
                            jVar.onNext((Object) NotificationLite.getValue(poll));
                            j2 = 1 + j2;
                        }
                    }
                    if (j2 == j) {
                        if (jVar.isUnsubscribed()) {
                            queue.clear();
                            return;
                        }
                        boolean z3 = this.done;
                        boolean isEmpty = queue.isEmpty();
                        if (z3 && isEmpty) {
                            Throwable th2 = this.error;
                            if (th2 != null) {
                                super.onError(th2);
                                return;
                            } else {
                                super.onCompleted();
                                return;
                            }
                        }
                    }
                    if (j2 != 0) {
                        a.c(this, j2);
                    }
                    i = this.wip.addAndGet(-i);
                } while (i != 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public static final class LatestEmitter<T> extends BaseEmitter<T> {
        private static final long serialVersionUID = 4023437720691792495L;
        volatile boolean done;
        Throwable error;
        final AtomicReference<Object> queue;
        final AtomicInteger wip;

        public LatestEmitter(rx.j<? super T> jVar) {
            super(jVar);
            this.queue = new AtomicReference<>();
            this.wip = new AtomicInteger();
        }

        @Override // rx.e
        public void onNext(T t) {
            this.queue.set(NotificationLite.next(t));
            drain();
        }

        @Override // rx.internal.operators.OnSubscribeFromEmitter.BaseEmitter, rx.e
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            drain();
        }

        @Override // rx.internal.operators.OnSubscribeFromEmitter.BaseEmitter, rx.e
        public void onCompleted() {
            this.done = true;
            drain();
        }

        @Override // rx.internal.operators.OnSubscribeFromEmitter.BaseEmitter
        void onRequested() {
            drain();
        }

        @Override // rx.internal.operators.OnSubscribeFromEmitter.BaseEmitter
        void onUnsubscribed() {
            if (this.wip.getAndIncrement() == 0) {
                this.queue.lazySet(null);
            }
        }

        void drain() {
            if (this.wip.getAndIncrement() == 0) {
                rx.j<? super T> jVar = this.actual;
                AtomicReference<Object> atomicReference = this.queue;
                int i = 1;
                do {
                    long j = get();
                    long j2 = 0;
                    while (j2 != j) {
                        if (jVar.isUnsubscribed()) {
                            atomicReference.lazySet(null);
                            return;
                        }
                        boolean z = this.done;
                        Object andSet = atomicReference.getAndSet(null);
                        boolean z2 = andSet == null;
                        if (z && z2) {
                            Throwable th = this.error;
                            if (th != null) {
                                super.onError(th);
                                return;
                            } else {
                                super.onCompleted();
                                return;
                            }
                        } else if (z2) {
                            break;
                        } else {
                            jVar.onNext((Object) NotificationLite.getValue(andSet));
                            j2++;
                        }
                    }
                    if (j2 == j) {
                        if (jVar.isUnsubscribed()) {
                            atomicReference.lazySet(null);
                            return;
                        }
                        boolean z3 = this.done;
                        boolean z4 = atomicReference.get() == null;
                        if (z3 && z4) {
                            Throwable th2 = this.error;
                            if (th2 != null) {
                                super.onError(th2);
                                return;
                            } else {
                                super.onCompleted();
                                return;
                            }
                        }
                    }
                    if (j2 != 0) {
                        a.c(this, j2);
                    }
                    i = this.wip.addAndGet(-i);
                } while (i != 0);
            }
        }
    }
}
