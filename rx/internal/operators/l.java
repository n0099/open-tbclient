package rx.internal.operators;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import rx.a;
import rx.d;
import rx.exceptions.MissingBackpressureException;
import rx.internal.util.BackpressureDrainManager;
/* loaded from: classes5.dex */
public class l<T> implements d.b<T, T> {
    private final Long qAw = null;
    private final rx.functions.a qAx = null;
    private final a.d qAy = rx.a.qxv;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class b {
        static final l<?> qAD = new l<>();
    }

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public static <T> l<T> eNb() {
        return (l<T>) b.qAD;
    }

    l() {
    }

    public rx.j<? super T> call(rx.j<? super T> jVar) {
        a aVar = new a(jVar, this.qAw, this.qAx, this.qAy);
        jVar.add(aVar);
        jVar.setProducer(aVar.eNd());
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class a<T> extends rx.j<T> implements BackpressureDrainManager.a {
        private final rx.j<? super T> child;
        private final AtomicLong qAA;
        private final BackpressureDrainManager qAC;
        private final rx.functions.a qAx;
        private final a.d qAy;
        private final ConcurrentLinkedQueue<Object> qAz = new ConcurrentLinkedQueue<>();
        private final AtomicBoolean qAB = new AtomicBoolean(false);

        public a(rx.j<? super T> jVar, Long l, rx.functions.a aVar, a.d dVar) {
            this.child = jVar;
            this.qAA = l != null ? new AtomicLong(l.longValue()) : null;
            this.qAx = aVar;
            this.qAC = new BackpressureDrainManager(this);
            this.qAy = dVar;
        }

        @Override // rx.j
        public void onStart() {
            request(Long.MAX_VALUE);
        }

        @Override // rx.e
        public void onCompleted() {
            if (!this.qAB.get()) {
                this.qAC.terminateAndDrain();
            }
        }

        @Override // rx.e
        public void onError(Throwable th) {
            if (!this.qAB.get()) {
                this.qAC.terminateAndDrain(th);
            }
        }

        @Override // rx.e
        public void onNext(T t) {
            if (eNc()) {
                this.qAz.offer(NotificationLite.next(t));
                this.qAC.drain();
            }
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public boolean cd(Object obj) {
            return NotificationLite.a(this.child, obj);
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public void Y(Throwable th) {
            if (th != null) {
                this.child.onError(th);
            } else {
                this.child.onCompleted();
            }
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public Object peek() {
            return this.qAz.peek();
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public Object poll() {
            Object poll = this.qAz.poll();
            if (this.qAA != null && poll != null) {
                this.qAA.incrementAndGet();
            }
            return poll;
        }

        private boolean eNc() {
            long j;
            boolean z;
            if (this.qAA == null) {
                return true;
            }
            do {
                j = this.qAA.get();
                if (j <= 0) {
                    try {
                        z = this.qAy.eMt() && poll() != null;
                    } catch (MissingBackpressureException e) {
                        if (this.qAB.compareAndSet(false, true)) {
                            unsubscribe();
                            this.child.onError(e);
                        }
                        z = false;
                    }
                    if (this.qAx != null) {
                        try {
                            this.qAx.call();
                        } catch (Throwable th) {
                            rx.exceptions.a.N(th);
                            this.qAC.terminateAndDrain(th);
                            return false;
                        }
                    }
                    if (!z) {
                        return false;
                    }
                }
            } while (!this.qAA.compareAndSet(j, j - 1));
            return true;
        }

        protected rx.f eNd() {
            return this.qAC;
        }
    }
}
