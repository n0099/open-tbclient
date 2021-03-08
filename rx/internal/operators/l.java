package rx.internal.operators;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import rx.a;
import rx.d;
import rx.exceptions.MissingBackpressureException;
import rx.internal.util.BackpressureDrainManager;
/* loaded from: classes4.dex */
public class l<T> implements d.b<T, T> {
    private final Long qBy = null;
    private final rx.functions.a qBz = null;
    private final a.d qBA = rx.a.qyx;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class b {
        static final l<?> qBF = new l<>();
    }

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public static <T> l<T> eMR() {
        return (l<T>) b.qBF;
    }

    l() {
    }

    public rx.j<? super T> call(rx.j<? super T> jVar) {
        a aVar = new a(jVar, this.qBy, this.qBz, this.qBA);
        jVar.add(aVar);
        jVar.setProducer(aVar.eMT());
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class a<T> extends rx.j<T> implements BackpressureDrainManager.a {
        private final rx.j<? super T> child;
        private final a.d qBA;
        private final AtomicLong qBC;
        private final BackpressureDrainManager qBE;
        private final rx.functions.a qBz;
        private final ConcurrentLinkedQueue<Object> qBB = new ConcurrentLinkedQueue<>();
        private final AtomicBoolean qBD = new AtomicBoolean(false);

        public a(rx.j<? super T> jVar, Long l, rx.functions.a aVar, a.d dVar) {
            this.child = jVar;
            this.qBC = l != null ? new AtomicLong(l.longValue()) : null;
            this.qBz = aVar;
            this.qBE = new BackpressureDrainManager(this);
            this.qBA = dVar;
        }

        @Override // rx.j
        public void onStart() {
            request(Long.MAX_VALUE);
        }

        @Override // rx.e
        public void onCompleted() {
            if (!this.qBD.get()) {
                this.qBE.terminateAndDrain();
            }
        }

        @Override // rx.e
        public void onError(Throwable th) {
            if (!this.qBD.get()) {
                this.qBE.terminateAndDrain(th);
            }
        }

        @Override // rx.e
        public void onNext(T t) {
            if (eMS()) {
                this.qBB.offer(NotificationLite.next(t));
                this.qBE.drain();
            }
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public boolean ce(Object obj) {
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
            return this.qBB.peek();
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public Object poll() {
            Object poll = this.qBB.poll();
            if (this.qBC != null && poll != null) {
                this.qBC.incrementAndGet();
            }
            return poll;
        }

        private boolean eMS() {
            long j;
            boolean z;
            if (this.qBC == null) {
                return true;
            }
            do {
                j = this.qBC.get();
                if (j <= 0) {
                    try {
                        z = this.qBA.eMj() && poll() != null;
                    } catch (MissingBackpressureException e) {
                        if (this.qBD.compareAndSet(false, true)) {
                            unsubscribe();
                            this.child.onError(e);
                        }
                        z = false;
                    }
                    if (this.qBz != null) {
                        try {
                            this.qBz.call();
                        } catch (Throwable th) {
                            rx.exceptions.a.N(th);
                            this.qBE.terminateAndDrain(th);
                            return false;
                        }
                    }
                    if (!z) {
                        return false;
                    }
                }
            } while (!this.qBC.compareAndSet(j, j - 1));
            return true;
        }

        protected rx.f eMT() {
            return this.qBE;
        }
    }
}
