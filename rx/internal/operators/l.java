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
    private final Long kxl = null;
    private final rx.functions.a kxm = null;
    private final a.d kxn = rx.a.kuc;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class b {
        static final l<?> kxs = new l<>();
    }

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public static <T> l<T> cPz() {
        return (l<T>) b.kxs;
    }

    l() {
    }

    public rx.j<? super T> call(rx.j<? super T> jVar) {
        a aVar = new a(jVar, this.kxl, this.kxm, this.kxn);
        jVar.add(aVar);
        jVar.setProducer(aVar.cPB());
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a<T> extends rx.j<T> implements BackpressureDrainManager.a {
        private final rx.j<? super T> child;
        private final rx.functions.a kxm;
        private final a.d kxn;
        private final AtomicLong kxp;
        private final BackpressureDrainManager kxr;
        private final ConcurrentLinkedQueue<Object> kxo = new ConcurrentLinkedQueue<>();
        private final AtomicBoolean kxq = new AtomicBoolean(false);

        public a(rx.j<? super T> jVar, Long l, rx.functions.a aVar, a.d dVar) {
            this.child = jVar;
            this.kxp = l != null ? new AtomicLong(l.longValue()) : null;
            this.kxm = aVar;
            this.kxr = new BackpressureDrainManager(this);
            this.kxn = dVar;
        }

        @Override // rx.j
        public void onStart() {
            request(Long.MAX_VALUE);
        }

        @Override // rx.e
        public void onCompleted() {
            if (!this.kxq.get()) {
                this.kxr.terminateAndDrain();
            }
        }

        @Override // rx.e
        public void onError(Throwable th) {
            if (!this.kxq.get()) {
                this.kxr.terminateAndDrain(th);
            }
        }

        @Override // rx.e
        public void onNext(T t) {
            if (cPA()) {
                this.kxo.offer(NotificationLite.bq(t));
                this.kxr.drain();
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
            return this.kxo.peek();
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public Object poll() {
            Object poll = this.kxo.poll();
            if (this.kxp != null && poll != null) {
                this.kxp.incrementAndGet();
            }
            return poll;
        }

        private boolean cPA() {
            long j;
            boolean z;
            if (this.kxp == null) {
                return true;
            }
            do {
                j = this.kxp.get();
                if (j <= 0) {
                    try {
                        z = this.kxn.cOL() && poll() != null;
                    } catch (MissingBackpressureException e) {
                        if (this.kxq.compareAndSet(false, true)) {
                            unsubscribe();
                            this.child.onError(e);
                        }
                        z = false;
                    }
                    if (this.kxm != null) {
                        try {
                            this.kxm.call();
                        } catch (Throwable th) {
                            rx.exceptions.a.K(th);
                            this.kxr.terminateAndDrain(th);
                            return false;
                        }
                    }
                    if (!z) {
                        return false;
                    }
                }
            } while (!this.kxp.compareAndSet(j, j - 1));
            return true;
        }

        protected rx.f cPB() {
            return this.kxr;
        }
    }
}
