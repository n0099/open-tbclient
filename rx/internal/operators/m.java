package rx.internal.operators;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import rx.a;
import rx.d;
import rx.exceptions.MissingBackpressureException;
import rx.internal.util.BackpressureDrainManager;
/* loaded from: classes6.dex */
public class m<T> implements d.b<T, T> {
    private final Long ody = null;
    private final rx.functions.a odz = null;
    private final a.d odA = rx.a.oau;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class b {
        static final m<?> odF = new m<>();
    }

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public static <T> m<T> dUI() {
        return (m<T>) b.odF;
    }

    m() {
    }

    public rx.j<? super T> call(rx.j<? super T> jVar) {
        a aVar = new a(jVar, this.ody, this.odz, this.odA);
        jVar.add(aVar);
        jVar.setProducer(aVar.dUK());
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class a<T> extends rx.j<T> implements BackpressureDrainManager.a {
        private final rx.j<? super T> child;
        private final a.d odA;
        private final AtomicLong odC;
        private final BackpressureDrainManager odE;
        private final rx.functions.a odz;
        private final ConcurrentLinkedQueue<Object> odB = new ConcurrentLinkedQueue<>();
        private final AtomicBoolean odD = new AtomicBoolean(false);

        public a(rx.j<? super T> jVar, Long l, rx.functions.a aVar, a.d dVar) {
            this.child = jVar;
            this.odC = l != null ? new AtomicLong(l.longValue()) : null;
            this.odz = aVar;
            this.odE = new BackpressureDrainManager(this);
            this.odA = dVar;
        }

        @Override // rx.j
        public void onStart() {
            request(Long.MAX_VALUE);
        }

        @Override // rx.e
        public void onCompleted() {
            if (!this.odD.get()) {
                this.odE.terminateAndDrain();
            }
        }

        @Override // rx.e
        public void onError(Throwable th) {
            if (!this.odD.get()) {
                this.odE.terminateAndDrain(th);
            }
        }

        @Override // rx.e
        public void onNext(T t) {
            if (dUJ()) {
                this.odB.offer(NotificationLite.next(t));
                this.odE.drain();
            }
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public boolean bY(Object obj) {
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
            return this.odB.peek();
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public Object poll() {
            Object poll = this.odB.poll();
            if (this.odC != null && poll != null) {
                this.odC.incrementAndGet();
            }
            return poll;
        }

        private boolean dUJ() {
            long j;
            boolean z;
            if (this.odC == null) {
                return true;
            }
            do {
                j = this.odC.get();
                if (j <= 0) {
                    try {
                        z = this.odA.dUa() && poll() != null;
                    } catch (MissingBackpressureException e) {
                        if (this.odD.compareAndSet(false, true)) {
                            unsubscribe();
                            this.child.onError(e);
                        }
                        z = false;
                    }
                    if (this.odz != null) {
                        try {
                            this.odz.call();
                        } catch (Throwable th) {
                            rx.exceptions.a.L(th);
                            this.odE.terminateAndDrain(th);
                            return false;
                        }
                    }
                    if (!z) {
                        return false;
                    }
                }
            } while (!this.odC.compareAndSet(j, j - 1));
            return true;
        }

        protected rx.f dUK() {
            return this.odE;
        }
    }
}
