package rx.internal.operators;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import rx.a;
import rx.d;
import rx.exceptions.MissingBackpressureException;
import rx.internal.util.BackpressureDrainManager;
/* loaded from: classes2.dex */
public class l<T> implements d.b<T, T> {
    private final Long kpJ = null;
    private final rx.functions.a kpK = null;
    private final a.d kpL = rx.a.kmA;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class b {
        static final l<?> kpQ = new l<>();
    }

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public static <T> l<T> cLL() {
        return (l<T>) b.kpQ;
    }

    l() {
    }

    public rx.j<? super T> call(rx.j<? super T> jVar) {
        a aVar = new a(jVar, this.kpJ, this.kpK, this.kpL);
        jVar.add(aVar);
        jVar.setProducer(aVar.cLN());
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a<T> extends rx.j<T> implements BackpressureDrainManager.a {
        private final rx.j<? super T> child;
        private final rx.functions.a kpK;
        private final a.d kpL;
        private final AtomicLong kpN;
        private final BackpressureDrainManager kpP;
        private final ConcurrentLinkedQueue<Object> kpM = new ConcurrentLinkedQueue<>();
        private final AtomicBoolean kpO = new AtomicBoolean(false);

        public a(rx.j<? super T> jVar, Long l, rx.functions.a aVar, a.d dVar) {
            this.child = jVar;
            this.kpN = l != null ? new AtomicLong(l.longValue()) : null;
            this.kpK = aVar;
            this.kpP = new BackpressureDrainManager(this);
            this.kpL = dVar;
        }

        @Override // rx.j
        public void onStart() {
            request(Long.MAX_VALUE);
        }

        @Override // rx.e
        public void onCompleted() {
            if (!this.kpO.get()) {
                this.kpP.terminateAndDrain();
            }
        }

        @Override // rx.e
        public void onError(Throwable th) {
            if (!this.kpO.get()) {
                this.kpP.terminateAndDrain(th);
            }
        }

        @Override // rx.e
        public void onNext(T t) {
            if (cLM()) {
                this.kpM.offer(NotificationLite.bo(t));
                this.kpP.drain();
            }
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public boolean accept(Object obj) {
            return NotificationLite.a(this.child, obj);
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public void Q(Throwable th) {
            if (th != null) {
                this.child.onError(th);
            } else {
                this.child.onCompleted();
            }
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public Object peek() {
            return this.kpM.peek();
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public Object poll() {
            Object poll = this.kpM.poll();
            if (this.kpN != null && poll != null) {
                this.kpN.incrementAndGet();
            }
            return poll;
        }

        private boolean cLM() {
            long j;
            boolean z;
            if (this.kpN == null) {
                return true;
            }
            do {
                j = this.kpN.get();
                if (j <= 0) {
                    try {
                        z = this.kpL.cKY() && poll() != null;
                    } catch (MissingBackpressureException e) {
                        if (this.kpO.compareAndSet(false, true)) {
                            unsubscribe();
                            this.child.onError(e);
                        }
                        z = false;
                    }
                    if (this.kpK != null) {
                        try {
                            this.kpK.call();
                        } catch (Throwable th) {
                            rx.exceptions.a.K(th);
                            this.kpP.terminateAndDrain(th);
                            return false;
                        }
                    }
                    if (!z) {
                        return false;
                    }
                }
            } while (!this.kpN.compareAndSet(j, j - 1));
            return true;
        }

        protected rx.f cLN() {
            return this.kpP;
        }
    }
}
