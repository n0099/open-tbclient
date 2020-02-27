package rx.internal.operators;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import rx.d;
import rx.exceptions.MissingBackpressureException;
import rx.g;
import rx.internal.util.a.ae;
/* loaded from: classes6.dex */
public final class l<T> implements d.b<T, T> {
    private final int bufferSize;
    private final boolean delayError;
    private final rx.g scheduler;

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public l(rx.g gVar, boolean z, int i) {
        this.scheduler = gVar;
        this.delayError = z;
        this.bufferSize = i <= 0 ? rx.internal.util.g.SIZE : i;
    }

    public rx.j<? super T> call(rx.j<? super T> jVar) {
        if (!(this.scheduler instanceof rx.internal.schedulers.e) && !(this.scheduler instanceof rx.internal.schedulers.j)) {
            a aVar = new a(this.scheduler, jVar, this.delayError, this.bufferSize);
            aVar.init();
            return aVar;
        }
        return jVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class a<T> extends rx.j<T> implements rx.functions.a {
        final rx.j<? super T> child;
        final boolean delayError;
        long emitted;
        Throwable error;
        volatile boolean finished;
        final int limit;
        final g.a nPM;
        final Queue<Object> queue;
        final AtomicLong requested = new AtomicLong();
        final AtomicLong nPN = new AtomicLong();

        public a(rx.g gVar, rx.j<? super T> jVar, boolean z, int i) {
            this.child = jVar;
            this.nPM = gVar.createWorker();
            this.delayError = z;
            i = i <= 0 ? rx.internal.util.g.SIZE : i;
            this.limit = i - (i >> 2);
            if (ae.dON()) {
                this.queue = new rx.internal.util.a.q(i);
            } else {
                this.queue = new rx.internal.util.atomic.c(i);
            }
            request(i);
        }

        void init() {
            rx.j<? super T> jVar = this.child;
            jVar.setProducer(new rx.f() { // from class: rx.internal.operators.l.a.1
                @Override // rx.f
                public void request(long j) {
                    if (j > 0) {
                        rx.internal.operators.a.e(a.this.requested, j);
                        a.this.schedule();
                    }
                }
            });
            jVar.add(this.nPM);
            jVar.add(this);
        }

        @Override // rx.e
        public void onNext(T t) {
            if (!isUnsubscribed() && !this.finished) {
                if (!this.queue.offer(NotificationLite.next(t))) {
                    onError(new MissingBackpressureException());
                } else {
                    schedule();
                }
            }
        }

        @Override // rx.e
        public void onCompleted() {
            if (!isUnsubscribed() && !this.finished) {
                this.finished = true;
                schedule();
            }
        }

        @Override // rx.e
        public void onError(Throwable th) {
            if (isUnsubscribed() || this.finished) {
                rx.c.c.onError(th);
                return;
            }
            this.error = th;
            this.finished = true;
            schedule();
        }

        protected void schedule() {
            if (this.nPN.getAndIncrement() == 0) {
                this.nPM.c(this);
            }
        }

        @Override // rx.functions.a
        public void call() {
            long j;
            long j2 = this.emitted;
            Queue<Object> queue = this.queue;
            rx.j<? super T> jVar = this.child;
            long j3 = 1;
            do {
                long j4 = this.requested.get();
                while (j4 != j2) {
                    boolean z = this.finished;
                    Object poll = queue.poll();
                    boolean z2 = poll == null;
                    if (!a(z, z2, jVar, queue)) {
                        if (z2) {
                            break;
                        }
                        jVar.onNext((Object) NotificationLite.getValue(poll));
                        long j5 = j2 + 1;
                        if (j5 == this.limit) {
                            j = rx.internal.operators.a.c(this.requested, j5);
                            request(j5);
                            j5 = 0;
                        } else {
                            j = j4;
                        }
                        j4 = j;
                        j2 = j5;
                    } else {
                        return;
                    }
                }
                if (j4 != j2 || !a(this.finished, queue.isEmpty(), jVar, queue)) {
                    this.emitted = j2;
                    j3 = this.nPN.addAndGet(-j3);
                } else {
                    return;
                }
            } while (j3 != 0);
        }

        boolean a(boolean z, boolean z2, rx.j<? super T> jVar, Queue<Object> queue) {
            if (jVar.isUnsubscribed()) {
                queue.clear();
                return true;
            }
            if (z) {
                if (this.delayError) {
                    if (z2) {
                        Throwable th = this.error;
                        try {
                            if (th != null) {
                                jVar.onError(th);
                            } else {
                                jVar.onCompleted();
                            }
                        } finally {
                        }
                    }
                } else {
                    Throwable th2 = this.error;
                    if (th2 != null) {
                        queue.clear();
                        try {
                            jVar.onError(th2);
                            return true;
                        } finally {
                        }
                    } else if (z2) {
                        try {
                            jVar.onCompleted();
                            return true;
                        } finally {
                        }
                    }
                }
            }
            return false;
        }
    }
}
