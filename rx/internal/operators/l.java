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
    private final Long jYa = null;
    private final rx.functions.a jYb = null;
    private final a.d jYc = rx.a.jUQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class b {
        static final l<?> jYh = new l<>();
    }

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public static <T> l<T> cEo() {
        return (l<T>) b.jYh;
    }

    l() {
    }

    public rx.j<? super T> call(rx.j<? super T> jVar) {
        a aVar = new a(jVar, this.jYa, this.jYb, this.jYc);
        jVar.add(aVar);
        jVar.setProducer(aVar.cEq());
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a<T> extends rx.j<T> implements BackpressureDrainManager.a {
        private final rx.j<? super T> child;
        private final rx.functions.a jYb;
        private final a.d jYc;
        private final AtomicLong jYe;
        private final BackpressureDrainManager jYg;
        private final ConcurrentLinkedQueue<Object> jYd = new ConcurrentLinkedQueue<>();
        private final AtomicBoolean jYf = new AtomicBoolean(false);

        public a(rx.j<? super T> jVar, Long l, rx.functions.a aVar, a.d dVar) {
            this.child = jVar;
            this.jYe = l != null ? new AtomicLong(l.longValue()) : null;
            this.jYb = aVar;
            this.jYg = new BackpressureDrainManager(this);
            this.jYc = dVar;
        }

        @Override // rx.j
        public void onStart() {
            request(Long.MAX_VALUE);
        }

        @Override // rx.e
        public void onCompleted() {
            if (!this.jYf.get()) {
                this.jYg.terminateAndDrain();
            }
        }

        @Override // rx.e
        public void onError(Throwable th) {
            if (!this.jYf.get()) {
                this.jYg.terminateAndDrain(th);
            }
        }

        @Override // rx.e
        public void onNext(T t) {
            if (cEp()) {
                this.jYd.offer(NotificationLite.bq(t));
                this.jYg.drain();
            }
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public boolean accept(Object obj) {
            return NotificationLite.a(this.child, obj);
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public void R(Throwable th) {
            if (th != null) {
                this.child.onError(th);
            } else {
                this.child.onCompleted();
            }
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public Object peek() {
            return this.jYd.peek();
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public Object poll() {
            Object poll = this.jYd.poll();
            if (this.jYe != null && poll != null) {
                this.jYe.incrementAndGet();
            }
            return poll;
        }

        private boolean cEp() {
            long j;
            boolean z;
            if (this.jYe == null) {
                return true;
            }
            do {
                j = this.jYe.get();
                if (j <= 0) {
                    try {
                        z = this.jYc.cDB() && poll() != null;
                    } catch (MissingBackpressureException e) {
                        if (this.jYf.compareAndSet(false, true)) {
                            unsubscribe();
                            this.child.onError(e);
                        }
                        z = false;
                    }
                    if (this.jYb != null) {
                        try {
                            this.jYb.call();
                        } catch (Throwable th) {
                            rx.exceptions.a.L(th);
                            this.jYg.terminateAndDrain(th);
                            return false;
                        }
                    }
                    if (!z) {
                        return false;
                    }
                }
            } while (!this.jYe.compareAndSet(j, j - 1));
            return true;
        }

        protected rx.f cEq() {
            return this.jYg;
        }
    }
}
