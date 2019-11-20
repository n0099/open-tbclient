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
    private final Long kAA = null;
    private final rx.functions.a kAB = null;
    private final a.d kAC = rx.a.kxs;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class b {
        static final l<?> kAH = new l<>();
    }

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public static <T> l<T> cOJ() {
        return (l<T>) b.kAH;
    }

    l() {
    }

    public rx.j<? super T> call(rx.j<? super T> jVar) {
        a aVar = new a(jVar, this.kAA, this.kAB, this.kAC);
        jVar.add(aVar);
        jVar.setProducer(aVar.cOL());
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a<T> extends rx.j<T> implements BackpressureDrainManager.a {
        private final rx.j<? super T> child;
        private final rx.functions.a kAB;
        private final a.d kAC;
        private final AtomicLong kAE;
        private final BackpressureDrainManager kAG;
        private final ConcurrentLinkedQueue<Object> kAD = new ConcurrentLinkedQueue<>();
        private final AtomicBoolean kAF = new AtomicBoolean(false);

        public a(rx.j<? super T> jVar, Long l, rx.functions.a aVar, a.d dVar) {
            this.child = jVar;
            this.kAE = l != null ? new AtomicLong(l.longValue()) : null;
            this.kAB = aVar;
            this.kAG = new BackpressureDrainManager(this);
            this.kAC = dVar;
        }

        @Override // rx.j
        public void onStart() {
            request(Long.MAX_VALUE);
        }

        @Override // rx.e
        public void onCompleted() {
            if (!this.kAF.get()) {
                this.kAG.terminateAndDrain();
            }
        }

        @Override // rx.e
        public void onError(Throwable th) {
            if (!this.kAF.get()) {
                this.kAG.terminateAndDrain(th);
            }
        }

        @Override // rx.e
        public void onNext(T t) {
            if (cOK()) {
                this.kAD.offer(NotificationLite.bl(t));
                this.kAG.drain();
            }
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public boolean bu(Object obj) {
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
            return this.kAD.peek();
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public Object poll() {
            Object poll = this.kAD.poll();
            if (this.kAE != null && poll != null) {
                this.kAE.incrementAndGet();
            }
            return poll;
        }

        private boolean cOK() {
            long j;
            boolean z;
            if (this.kAE == null) {
                return true;
            }
            do {
                j = this.kAE.get();
                if (j <= 0) {
                    try {
                        z = this.kAC.cNX() && poll() != null;
                    } catch (MissingBackpressureException e) {
                        if (this.kAF.compareAndSet(false, true)) {
                            unsubscribe();
                            this.child.onError(e);
                        }
                        z = false;
                    }
                    if (this.kAB != null) {
                        try {
                            this.kAB.call();
                        } catch (Throwable th) {
                            rx.exceptions.a.K(th);
                            this.kAG.terminateAndDrain(th);
                            return false;
                        }
                    }
                    if (!z) {
                        return false;
                    }
                }
            } while (!this.kAE.compareAndSet(j, j - 1));
            return true;
        }

        protected rx.f cOL() {
            return this.kAG;
        }
    }
}
