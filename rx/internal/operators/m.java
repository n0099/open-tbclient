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
    private final Long pRJ = null;
    private final rx.functions.a pRK = null;
    private final a.d pRL = rx.a.pOH;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public static final class b {
        static final m<?> pRQ = new m<>();
    }

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public static <T> m<T> eFO() {
        return (m<T>) b.pRQ;
    }

    m() {
    }

    public rx.j<? super T> call(rx.j<? super T> jVar) {
        a aVar = new a(jVar, this.pRJ, this.pRK, this.pRL);
        jVar.add(aVar);
        jVar.setProducer(aVar.eFQ());
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public static final class a<T> extends rx.j<T> implements BackpressureDrainManager.a {
        private final rx.j<? super T> child;
        private final rx.functions.a pRK;
        private final a.d pRL;
        private final AtomicLong pRN;
        private final BackpressureDrainManager pRP;
        private final ConcurrentLinkedQueue<Object> pRM = new ConcurrentLinkedQueue<>();
        private final AtomicBoolean pRO = new AtomicBoolean(false);

        public a(rx.j<? super T> jVar, Long l, rx.functions.a aVar, a.d dVar) {
            this.child = jVar;
            this.pRN = l != null ? new AtomicLong(l.longValue()) : null;
            this.pRK = aVar;
            this.pRP = new BackpressureDrainManager(this);
            this.pRL = dVar;
        }

        @Override // rx.j
        public void onStart() {
            request(Long.MAX_VALUE);
        }

        @Override // rx.e
        public void onCompleted() {
            if (!this.pRO.get()) {
                this.pRP.terminateAndDrain();
            }
        }

        @Override // rx.e
        public void onError(Throwable th) {
            if (!this.pRO.get()) {
                this.pRP.terminateAndDrain(th);
            }
        }

        @Override // rx.e
        public void onNext(T t) {
            if (eFP()) {
                this.pRM.offer(NotificationLite.next(t));
                this.pRP.drain();
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
            return this.pRM.peek();
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public Object poll() {
            Object poll = this.pRM.poll();
            if (this.pRN != null && poll != null) {
                this.pRN.incrementAndGet();
            }
            return poll;
        }

        private boolean eFP() {
            long j;
            boolean z;
            if (this.pRN == null) {
                return true;
            }
            do {
                j = this.pRN.get();
                if (j <= 0) {
                    try {
                        z = this.pRL.eFg() && poll() != null;
                    } catch (MissingBackpressureException e) {
                        if (this.pRO.compareAndSet(false, true)) {
                            unsubscribe();
                            this.child.onError(e);
                        }
                        z = false;
                    }
                    if (this.pRK != null) {
                        try {
                            this.pRK.call();
                        } catch (Throwable th) {
                            rx.exceptions.a.J(th);
                            this.pRP.terminateAndDrain(th);
                            return false;
                        }
                    }
                    if (!z) {
                        return false;
                    }
                }
            } while (!this.pRN.compareAndSet(j, j - 1));
            return true;
        }

        protected rx.f eFQ() {
            return this.pRP;
        }
    }
}
