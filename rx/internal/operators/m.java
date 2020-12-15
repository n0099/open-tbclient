package rx.internal.operators;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import rx.a;
import rx.d;
import rx.exceptions.MissingBackpressureException;
import rx.internal.util.BackpressureDrainManager;
/* loaded from: classes12.dex */
public class m<T> implements d.b<T, T> {
    private final Long pRL = null;
    private final rx.functions.a pRM = null;
    private final a.d pRN = rx.a.pOJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public static final class b {
        static final m<?> pRS = new m<>();
    }

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public static <T> m<T> eFP() {
        return (m<T>) b.pRS;
    }

    m() {
    }

    public rx.j<? super T> call(rx.j<? super T> jVar) {
        a aVar = new a(jVar, this.pRL, this.pRM, this.pRN);
        jVar.add(aVar);
        jVar.setProducer(aVar.eFR());
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public static final class a<T> extends rx.j<T> implements BackpressureDrainManager.a {
        private final rx.j<? super T> child;
        private final rx.functions.a pRM;
        private final a.d pRN;
        private final AtomicLong pRP;
        private final BackpressureDrainManager pRR;
        private final ConcurrentLinkedQueue<Object> pRO = new ConcurrentLinkedQueue<>();
        private final AtomicBoolean pRQ = new AtomicBoolean(false);

        public a(rx.j<? super T> jVar, Long l, rx.functions.a aVar, a.d dVar) {
            this.child = jVar;
            this.pRP = l != null ? new AtomicLong(l.longValue()) : null;
            this.pRM = aVar;
            this.pRR = new BackpressureDrainManager(this);
            this.pRN = dVar;
        }

        @Override // rx.j
        public void onStart() {
            request(Long.MAX_VALUE);
        }

        @Override // rx.e
        public void onCompleted() {
            if (!this.pRQ.get()) {
                this.pRR.terminateAndDrain();
            }
        }

        @Override // rx.e
        public void onError(Throwable th) {
            if (!this.pRQ.get()) {
                this.pRR.terminateAndDrain(th);
            }
        }

        @Override // rx.e
        public void onNext(T t) {
            if (eFQ()) {
                this.pRO.offer(NotificationLite.next(t));
                this.pRR.drain();
            }
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public boolean ca(Object obj) {
            return NotificationLite.a(this.child, obj);
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public void U(Throwable th) {
            if (th != null) {
                this.child.onError(th);
            } else {
                this.child.onCompleted();
            }
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public Object peek() {
            return this.pRO.peek();
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public Object poll() {
            Object poll = this.pRO.poll();
            if (this.pRP != null && poll != null) {
                this.pRP.incrementAndGet();
            }
            return poll;
        }

        private boolean eFQ() {
            long j;
            boolean z;
            if (this.pRP == null) {
                return true;
            }
            do {
                j = this.pRP.get();
                if (j <= 0) {
                    try {
                        z = this.pRN.eFh() && poll() != null;
                    } catch (MissingBackpressureException e) {
                        if (this.pRQ.compareAndSet(false, true)) {
                            unsubscribe();
                            this.child.onError(e);
                        }
                        z = false;
                    }
                    if (this.pRM != null) {
                        try {
                            this.pRM.call();
                        } catch (Throwable th) {
                            rx.exceptions.a.J(th);
                            this.pRR.terminateAndDrain(th);
                            return false;
                        }
                    }
                    if (!z) {
                        return false;
                    }
                }
            } while (!this.pRP.compareAndSet(j, j - 1));
            return true;
        }

        protected rx.f eFR() {
            return this.pRR;
        }
    }
}
