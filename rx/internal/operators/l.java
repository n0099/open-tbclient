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
    private final Long qAW = null;
    private final rx.functions.a qAX = null;
    private final a.d qAY = rx.a.qxV;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class b {
        static final l<?> qBd = new l<>();
    }

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public static <T> l<T> eNj() {
        return (l<T>) b.qBd;
    }

    l() {
    }

    public rx.j<? super T> call(rx.j<? super T> jVar) {
        a aVar = new a(jVar, this.qAW, this.qAX, this.qAY);
        jVar.add(aVar);
        jVar.setProducer(aVar.eNl());
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class a<T> extends rx.j<T> implements BackpressureDrainManager.a {
        private final rx.j<? super T> child;
        private final rx.functions.a qAX;
        private final a.d qAY;
        private final AtomicLong qBa;
        private final BackpressureDrainManager qBc;
        private final ConcurrentLinkedQueue<Object> qAZ = new ConcurrentLinkedQueue<>();
        private final AtomicBoolean qBb = new AtomicBoolean(false);

        public a(rx.j<? super T> jVar, Long l, rx.functions.a aVar, a.d dVar) {
            this.child = jVar;
            this.qBa = l != null ? new AtomicLong(l.longValue()) : null;
            this.qAX = aVar;
            this.qBc = new BackpressureDrainManager(this);
            this.qAY = dVar;
        }

        @Override // rx.j
        public void onStart() {
            request(Long.MAX_VALUE);
        }

        @Override // rx.e
        public void onCompleted() {
            if (!this.qBb.get()) {
                this.qBc.terminateAndDrain();
            }
        }

        @Override // rx.e
        public void onError(Throwable th) {
            if (!this.qBb.get()) {
                this.qBc.terminateAndDrain(th);
            }
        }

        @Override // rx.e
        public void onNext(T t) {
            if (eNk()) {
                this.qAZ.offer(NotificationLite.next(t));
                this.qBc.drain();
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
            return this.qAZ.peek();
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public Object poll() {
            Object poll = this.qAZ.poll();
            if (this.qBa != null && poll != null) {
                this.qBa.incrementAndGet();
            }
            return poll;
        }

        private boolean eNk() {
            long j;
            boolean z;
            if (this.qBa == null) {
                return true;
            }
            do {
                j = this.qBa.get();
                if (j <= 0) {
                    try {
                        z = this.qAY.eMB() && poll() != null;
                    } catch (MissingBackpressureException e) {
                        if (this.qBb.compareAndSet(false, true)) {
                            unsubscribe();
                            this.child.onError(e);
                        }
                        z = false;
                    }
                    if (this.qAX != null) {
                        try {
                            this.qAX.call();
                        } catch (Throwable th) {
                            rx.exceptions.a.N(th);
                            this.qBc.terminateAndDrain(th);
                            return false;
                        }
                    }
                    if (!z) {
                        return false;
                    }
                }
            } while (!this.qBa.compareAndSet(j, j - 1));
            return true;
        }

        protected rx.f eNl() {
            return this.qBc;
        }
    }
}
