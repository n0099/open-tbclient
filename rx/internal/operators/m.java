package rx.internal.operators;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import rx.a;
import rx.d;
import rx.exceptions.MissingBackpressureException;
import rx.internal.util.BackpressureDrainManager;
/* loaded from: classes16.dex */
public class m<T> implements d.b<T, T> {
    private final Long pWK = null;
    private final rx.functions.a pWL = null;
    private final a.d pWM = rx.a.pTI;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public static final class b {
        static final m<?> pWR = new m<>();
    }

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public static <T> m<T> eBZ() {
        return (m<T>) b.pWR;
    }

    m() {
    }

    public rx.j<? super T> call(rx.j<? super T> jVar) {
        a aVar = new a(jVar, this.pWK, this.pWL, this.pWM);
        jVar.add(aVar);
        jVar.setProducer(aVar.eCb());
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public static final class a<T> extends rx.j<T> implements BackpressureDrainManager.a {
        private final rx.j<? super T> child;
        private final rx.functions.a pWL;
        private final a.d pWM;
        private final AtomicLong pWO;
        private final BackpressureDrainManager pWQ;
        private final ConcurrentLinkedQueue<Object> pWN = new ConcurrentLinkedQueue<>();
        private final AtomicBoolean pWP = new AtomicBoolean(false);

        public a(rx.j<? super T> jVar, Long l, rx.functions.a aVar, a.d dVar) {
            this.child = jVar;
            this.pWO = l != null ? new AtomicLong(l.longValue()) : null;
            this.pWL = aVar;
            this.pWQ = new BackpressureDrainManager(this);
            this.pWM = dVar;
        }

        @Override // rx.j
        public void onStart() {
            request(Long.MAX_VALUE);
        }

        @Override // rx.e
        public void onCompleted() {
            if (!this.pWP.get()) {
                this.pWQ.terminateAndDrain();
            }
        }

        @Override // rx.e
        public void onError(Throwable th) {
            if (!this.pWP.get()) {
                this.pWQ.terminateAndDrain(th);
            }
        }

        @Override // rx.e
        public void onNext(T t) {
            if (eCa()) {
                this.pWN.offer(NotificationLite.next(t));
                this.pWQ.drain();
            }
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public boolean cj(Object obj) {
            return NotificationLite.a(this.child, obj);
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public void W(Throwable th) {
            if (th != null) {
                this.child.onError(th);
            } else {
                this.child.onCompleted();
            }
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public Object peek() {
            return this.pWN.peek();
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public Object poll() {
            Object poll = this.pWN.poll();
            if (this.pWO != null && poll != null) {
                this.pWO.incrementAndGet();
            }
            return poll;
        }

        private boolean eCa() {
            long j;
            boolean z;
            if (this.pWO == null) {
                return true;
            }
            do {
                j = this.pWO.get();
                if (j <= 0) {
                    try {
                        z = this.pWM.eBr() && poll() != null;
                    } catch (MissingBackpressureException e) {
                        if (this.pWP.compareAndSet(false, true)) {
                            unsubscribe();
                            this.child.onError(e);
                        }
                        z = false;
                    }
                    if (this.pWL != null) {
                        try {
                            this.pWL.call();
                        } catch (Throwable th) {
                            rx.exceptions.a.J(th);
                            this.pWQ.terminateAndDrain(th);
                            return false;
                        }
                    }
                    if (!z) {
                        return false;
                    }
                }
            } while (!this.pWO.compareAndSet(j, j - 1));
            return true;
        }

        protected rx.f eCb() {
            return this.pWQ;
        }
    }
}
