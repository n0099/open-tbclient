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
    private final Long kpM = null;
    private final rx.functions.a kpN = null;
    private final a.d kpO = rx.a.kmD;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class b {
        static final l<?> kpT = new l<>();
    }

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public static <T> l<T> cLK() {
        return (l<T>) b.kpT;
    }

    l() {
    }

    public rx.j<? super T> call(rx.j<? super T> jVar) {
        a aVar = new a(jVar, this.kpM, this.kpN, this.kpO);
        jVar.add(aVar);
        jVar.setProducer(aVar.cLM());
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a<T> extends rx.j<T> implements BackpressureDrainManager.a {
        private final rx.j<? super T> child;
        private final rx.functions.a kpN;
        private final a.d kpO;
        private final AtomicLong kpQ;
        private final BackpressureDrainManager kpS;
        private final ConcurrentLinkedQueue<Object> kpP = new ConcurrentLinkedQueue<>();
        private final AtomicBoolean kpR = new AtomicBoolean(false);

        public a(rx.j<? super T> jVar, Long l, rx.functions.a aVar, a.d dVar) {
            this.child = jVar;
            this.kpQ = l != null ? new AtomicLong(l.longValue()) : null;
            this.kpN = aVar;
            this.kpS = new BackpressureDrainManager(this);
            this.kpO = dVar;
        }

        @Override // rx.j
        public void onStart() {
            request(Long.MAX_VALUE);
        }

        @Override // rx.e
        public void onCompleted() {
            if (!this.kpR.get()) {
                this.kpS.terminateAndDrain();
            }
        }

        @Override // rx.e
        public void onError(Throwable th) {
            if (!this.kpR.get()) {
                this.kpS.terminateAndDrain(th);
            }
        }

        @Override // rx.e
        public void onNext(T t) {
            if (cLL()) {
                this.kpP.offer(NotificationLite.bo(t));
                this.kpS.drain();
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
            return this.kpP.peek();
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public Object poll() {
            Object poll = this.kpP.poll();
            if (this.kpQ != null && poll != null) {
                this.kpQ.incrementAndGet();
            }
            return poll;
        }

        private boolean cLL() {
            long j;
            boolean z;
            if (this.kpQ == null) {
                return true;
            }
            do {
                j = this.kpQ.get();
                if (j <= 0) {
                    try {
                        z = this.kpO.cKX() && poll() != null;
                    } catch (MissingBackpressureException e) {
                        if (this.kpR.compareAndSet(false, true)) {
                            unsubscribe();
                            this.child.onError(e);
                        }
                        z = false;
                    }
                    if (this.kpN != null) {
                        try {
                            this.kpN.call();
                        } catch (Throwable th) {
                            rx.exceptions.a.K(th);
                            this.kpS.terminateAndDrain(th);
                            return false;
                        }
                    }
                    if (!z) {
                        return false;
                    }
                }
            } while (!this.kpQ.compareAndSet(j, j - 1));
            return true;
        }

        protected rx.f cLM() {
            return this.kpS;
        }
    }
}
