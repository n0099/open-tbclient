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
    private final Long kAJ = null;
    private final rx.functions.a kAK = null;
    private final a.d kAL = rx.a.kxB;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class b {
        static final l<?> kAQ = new l<>();
    }

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public static <T> l<T> cQG() {
        return (l<T>) b.kAQ;
    }

    l() {
    }

    public rx.j<? super T> call(rx.j<? super T> jVar) {
        a aVar = new a(jVar, this.kAJ, this.kAK, this.kAL);
        jVar.add(aVar);
        jVar.setProducer(aVar.cQI());
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a<T> extends rx.j<T> implements BackpressureDrainManager.a {
        private final rx.j<? super T> child;
        private final rx.functions.a kAK;
        private final a.d kAL;
        private final AtomicLong kAN;
        private final BackpressureDrainManager kAP;
        private final ConcurrentLinkedQueue<Object> kAM = new ConcurrentLinkedQueue<>();
        private final AtomicBoolean kAO = new AtomicBoolean(false);

        public a(rx.j<? super T> jVar, Long l, rx.functions.a aVar, a.d dVar) {
            this.child = jVar;
            this.kAN = l != null ? new AtomicLong(l.longValue()) : null;
            this.kAK = aVar;
            this.kAP = new BackpressureDrainManager(this);
            this.kAL = dVar;
        }

        @Override // rx.j
        public void onStart() {
            request(Long.MAX_VALUE);
        }

        @Override // rx.e
        public void onCompleted() {
            if (!this.kAO.get()) {
                this.kAP.terminateAndDrain();
            }
        }

        @Override // rx.e
        public void onError(Throwable th) {
            if (!this.kAO.get()) {
                this.kAP.terminateAndDrain(th);
            }
        }

        @Override // rx.e
        public void onNext(T t) {
            if (cQH()) {
                this.kAM.offer(NotificationLite.bq(t));
                this.kAP.drain();
            }
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public boolean bz(Object obj) {
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
            return this.kAM.peek();
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public Object poll() {
            Object poll = this.kAM.poll();
            if (this.kAN != null && poll != null) {
                this.kAN.incrementAndGet();
            }
            return poll;
        }

        private boolean cQH() {
            long j;
            boolean z;
            if (this.kAN == null) {
                return true;
            }
            do {
                j = this.kAN.get();
                if (j <= 0) {
                    try {
                        z = this.kAL.cPS() && poll() != null;
                    } catch (MissingBackpressureException e) {
                        if (this.kAO.compareAndSet(false, true)) {
                            unsubscribe();
                            this.child.onError(e);
                        }
                        z = false;
                    }
                    if (this.kAK != null) {
                        try {
                            this.kAK.call();
                        } catch (Throwable th) {
                            rx.exceptions.a.K(th);
                            this.kAP.terminateAndDrain(th);
                            return false;
                        }
                    }
                    if (!z) {
                        return false;
                    }
                }
            } while (!this.kAN.compareAndSet(j, j - 1));
            return true;
        }

        protected rx.f cQI() {
            return this.kAP;
        }
    }
}
