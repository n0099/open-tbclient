package rx.internal.operators;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import rx.a;
import rx.d;
import rx.exceptions.MissingBackpressureException;
import rx.internal.util.BackpressureDrainManager;
/* loaded from: classes15.dex */
public class l<T> implements d.b<T, T> {
    private final Long qtm = null;
    private final rx.functions.a qtn = null;
    private final a.d qto = rx.a.qql;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public static final class b {
        static final l<?> qtt = new l<>();
    }

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public static <T> l<T> eNX() {
        return (l<T>) b.qtt;
    }

    l() {
    }

    public rx.j<? super T> call(rx.j<? super T> jVar) {
        a aVar = new a(jVar, this.qtm, this.qtn, this.qto);
        jVar.add(aVar);
        jVar.setProducer(aVar.eNZ());
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public static final class a<T> extends rx.j<T> implements BackpressureDrainManager.a {
        private final rx.j<? super T> child;
        private final rx.functions.a qtn;
        private final a.d qto;
        private final AtomicLong qtq;
        private final BackpressureDrainManager qts;
        private final ConcurrentLinkedQueue<Object> qtp = new ConcurrentLinkedQueue<>();
        private final AtomicBoolean qtr = new AtomicBoolean(false);

        public a(rx.j<? super T> jVar, Long l, rx.functions.a aVar, a.d dVar) {
            this.child = jVar;
            this.qtq = l != null ? new AtomicLong(l.longValue()) : null;
            this.qtn = aVar;
            this.qts = new BackpressureDrainManager(this);
            this.qto = dVar;
        }

        @Override // rx.j
        public void onStart() {
            request(Long.MAX_VALUE);
        }

        @Override // rx.e
        public void onCompleted() {
            if (!this.qtr.get()) {
                this.qts.terminateAndDrain();
            }
        }

        @Override // rx.e
        public void onError(Throwable th) {
            if (!this.qtr.get()) {
                this.qts.terminateAndDrain(th);
            }
        }

        @Override // rx.e
        public void onNext(T t) {
            if (eNY()) {
                this.qtp.offer(NotificationLite.next(t));
                this.qts.drain();
            }
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public boolean cc(Object obj) {
            return NotificationLite.a(this.child, obj);
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public void Z(Throwable th) {
            if (th != null) {
                this.child.onError(th);
            } else {
                this.child.onCompleted();
            }
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public Object peek() {
            return this.qtp.peek();
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public Object poll() {
            Object poll = this.qtp.poll();
            if (this.qtq != null && poll != null) {
                this.qtq.incrementAndGet();
            }
            return poll;
        }

        private boolean eNY() {
            long j;
            boolean z;
            if (this.qtq == null) {
                return true;
            }
            do {
                j = this.qtq.get();
                if (j <= 0) {
                    try {
                        z = this.qto.eNp() && poll() != null;
                    } catch (MissingBackpressureException e) {
                        if (this.qtr.compareAndSet(false, true)) {
                            unsubscribe();
                            this.child.onError(e);
                        }
                        z = false;
                    }
                    if (this.qtn != null) {
                        try {
                            this.qtn.call();
                        } catch (Throwable th) {
                            rx.exceptions.a.O(th);
                            this.qts.terminateAndDrain(th);
                            return false;
                        }
                    }
                    if (!z) {
                        return false;
                    }
                }
            } while (!this.qtq.compareAndSet(j, j - 1));
            return true;
        }

        protected rx.f eNZ() {
            return this.qts;
        }
    }
}
