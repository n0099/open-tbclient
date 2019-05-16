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
    private final Long kpI = null;
    private final rx.functions.a kpJ = null;
    private final a.d kpK = rx.a.kmz;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class b {
        static final l<?> kpP = new l<>();
    }

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public static <T> l<T> cLJ() {
        return (l<T>) b.kpP;
    }

    l() {
    }

    public rx.j<? super T> call(rx.j<? super T> jVar) {
        a aVar = new a(jVar, this.kpI, this.kpJ, this.kpK);
        jVar.add(aVar);
        jVar.setProducer(aVar.cLL());
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a<T> extends rx.j<T> implements BackpressureDrainManager.a {
        private final rx.j<? super T> child;
        private final rx.functions.a kpJ;
        private final a.d kpK;
        private final AtomicLong kpM;
        private final BackpressureDrainManager kpO;
        private final ConcurrentLinkedQueue<Object> kpL = new ConcurrentLinkedQueue<>();
        private final AtomicBoolean kpN = new AtomicBoolean(false);

        public a(rx.j<? super T> jVar, Long l, rx.functions.a aVar, a.d dVar) {
            this.child = jVar;
            this.kpM = l != null ? new AtomicLong(l.longValue()) : null;
            this.kpJ = aVar;
            this.kpO = new BackpressureDrainManager(this);
            this.kpK = dVar;
        }

        @Override // rx.j
        public void onStart() {
            request(Long.MAX_VALUE);
        }

        @Override // rx.e
        public void onCompleted() {
            if (!this.kpN.get()) {
                this.kpO.terminateAndDrain();
            }
        }

        @Override // rx.e
        public void onError(Throwable th) {
            if (!this.kpN.get()) {
                this.kpO.terminateAndDrain(th);
            }
        }

        @Override // rx.e
        public void onNext(T t) {
            if (cLK()) {
                this.kpL.offer(NotificationLite.bo(t));
                this.kpO.drain();
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
            return this.kpL.peek();
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public Object poll() {
            Object poll = this.kpL.poll();
            if (this.kpM != null && poll != null) {
                this.kpM.incrementAndGet();
            }
            return poll;
        }

        private boolean cLK() {
            long j;
            boolean z;
            if (this.kpM == null) {
                return true;
            }
            do {
                j = this.kpM.get();
                if (j <= 0) {
                    try {
                        z = this.kpK.cKW() && poll() != null;
                    } catch (MissingBackpressureException e) {
                        if (this.kpN.compareAndSet(false, true)) {
                            unsubscribe();
                            this.child.onError(e);
                        }
                        z = false;
                    }
                    if (this.kpJ != null) {
                        try {
                            this.kpJ.call();
                        } catch (Throwable th) {
                            rx.exceptions.a.K(th);
                            this.kpO.terminateAndDrain(th);
                            return false;
                        }
                    }
                    if (!z) {
                        return false;
                    }
                }
            } while (!this.kpM.compareAndSet(j, j - 1));
            return true;
        }

        protected rx.f cLL() {
            return this.kpO;
        }
    }
}
