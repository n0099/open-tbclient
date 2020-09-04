package rx.internal.operators;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import rx.a;
import rx.d;
import rx.exceptions.MissingBackpressureException;
import rx.internal.util.BackpressureDrainManager;
/* loaded from: classes5.dex */
public class m<T> implements d.b<T, T> {
    private final Long oGw = null;
    private final rx.functions.a oGx = null;
    private final a.d oGy = rx.a.oDu;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class b {
        static final m<?> oGD = new m<>();
    }

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public static <T> m<T> eks() {
        return (m<T>) b.oGD;
    }

    m() {
    }

    public rx.j<? super T> call(rx.j<? super T> jVar) {
        a aVar = new a(jVar, this.oGw, this.oGx, this.oGy);
        jVar.add(aVar);
        jVar.setProducer(aVar.eku());
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class a<T> extends rx.j<T> implements BackpressureDrainManager.a {
        private final rx.j<? super T> child;
        private final AtomicLong oGA;
        private final BackpressureDrainManager oGC;
        private final rx.functions.a oGx;
        private final a.d oGy;
        private final ConcurrentLinkedQueue<Object> oGz = new ConcurrentLinkedQueue<>();
        private final AtomicBoolean oGB = new AtomicBoolean(false);

        public a(rx.j<? super T> jVar, Long l, rx.functions.a aVar, a.d dVar) {
            this.child = jVar;
            this.oGA = l != null ? new AtomicLong(l.longValue()) : null;
            this.oGx = aVar;
            this.oGC = new BackpressureDrainManager(this);
            this.oGy = dVar;
        }

        @Override // rx.j
        public void onStart() {
            request(Long.MAX_VALUE);
        }

        @Override // rx.e
        public void onCompleted() {
            if (!this.oGB.get()) {
                this.oGC.terminateAndDrain();
            }
        }

        @Override // rx.e
        public void onError(Throwable th) {
            if (!this.oGB.get()) {
                this.oGC.terminateAndDrain(th);
            }
        }

        @Override // rx.e
        public void onNext(T t) {
            if (ekt()) {
                this.oGz.offer(NotificationLite.next(t));
                this.oGC.drain();
            }
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public boolean cc(Object obj) {
            return NotificationLite.a(this.child, obj);
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public void W(Throwable th) {
            if (th != null) {
                this.child.onError(th);
            } else {
                this.child.onCompleted();
            }
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public Object peek() {
            return this.oGz.peek();
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public Object poll() {
            Object poll = this.oGz.poll();
            if (this.oGA != null && poll != null) {
                this.oGA.incrementAndGet();
            }
            return poll;
        }

        private boolean ekt() {
            long j;
            boolean z;
            if (this.oGA == null) {
                return true;
            }
            do {
                j = this.oGA.get();
                if (j <= 0) {
                    try {
                        z = this.oGy.ejK() && poll() != null;
                    } catch (MissingBackpressureException e) {
                        if (this.oGB.compareAndSet(false, true)) {
                            unsubscribe();
                            this.child.onError(e);
                        }
                        z = false;
                    }
                    if (this.oGx != null) {
                        try {
                            this.oGx.call();
                        } catch (Throwable th) {
                            rx.exceptions.a.J(th);
                            this.oGC.terminateAndDrain(th);
                            return false;
                        }
                    }
                    if (!z) {
                        return false;
                    }
                }
            } while (!this.oGA.compareAndSet(j, j - 1));
            return true;
        }

        protected rx.f eku() {
            return this.oGC;
        }
    }
}
