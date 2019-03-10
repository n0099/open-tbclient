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
    private final Long jYi = null;
    private final rx.functions.a jYj = null;
    private final a.d jYk = rx.a.jUY;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class b {
        static final l<?> jYp = new l<>();
    }

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public static <T> l<T> cEl() {
        return (l<T>) b.jYp;
    }

    l() {
    }

    public rx.j<? super T> call(rx.j<? super T> jVar) {
        a aVar = new a(jVar, this.jYi, this.jYj, this.jYk);
        jVar.add(aVar);
        jVar.setProducer(aVar.cEn());
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a<T> extends rx.j<T> implements BackpressureDrainManager.a {
        private final rx.j<? super T> child;
        private final rx.functions.a jYj;
        private final a.d jYk;
        private final AtomicLong jYm;
        private final BackpressureDrainManager jYo;
        private final ConcurrentLinkedQueue<Object> jYl = new ConcurrentLinkedQueue<>();
        private final AtomicBoolean jYn = new AtomicBoolean(false);

        public a(rx.j<? super T> jVar, Long l, rx.functions.a aVar, a.d dVar) {
            this.child = jVar;
            this.jYm = l != null ? new AtomicLong(l.longValue()) : null;
            this.jYj = aVar;
            this.jYo = new BackpressureDrainManager(this);
            this.jYk = dVar;
        }

        @Override // rx.j
        public void onStart() {
            request(Long.MAX_VALUE);
        }

        @Override // rx.e
        public void onCompleted() {
            if (!this.jYn.get()) {
                this.jYo.terminateAndDrain();
            }
        }

        @Override // rx.e
        public void onError(Throwable th) {
            if (!this.jYn.get()) {
                this.jYo.terminateAndDrain(th);
            }
        }

        @Override // rx.e
        public void onNext(T t) {
            if (cEm()) {
                this.jYl.offer(NotificationLite.bq(t));
                this.jYo.drain();
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
            return this.jYl.peek();
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public Object poll() {
            Object poll = this.jYl.poll();
            if (this.jYm != null && poll != null) {
                this.jYm.incrementAndGet();
            }
            return poll;
        }

        private boolean cEm() {
            long j;
            boolean z;
            if (this.jYm == null) {
                return true;
            }
            do {
                j = this.jYm.get();
                if (j <= 0) {
                    try {
                        z = this.jYk.cDy() && poll() != null;
                    } catch (MissingBackpressureException e) {
                        if (this.jYn.compareAndSet(false, true)) {
                            unsubscribe();
                            this.child.onError(e);
                        }
                        z = false;
                    }
                    if (this.jYj != null) {
                        try {
                            this.jYj.call();
                        } catch (Throwable th) {
                            rx.exceptions.a.L(th);
                            this.jYo.terminateAndDrain(th);
                            return false;
                        }
                    }
                    if (!z) {
                        return false;
                    }
                }
            } while (!this.jYm.compareAndSet(j, j - 1));
            return true;
        }

        protected rx.f cEn() {
            return this.jYo;
        }
    }
}
