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
    private final Long jXP = null;
    private final rx.functions.a jXQ = null;
    private final a.d jXR = rx.a.jUF;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class b {
        static final l<?> jXW = new l<>();
    }

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public static <T> l<T> cEb() {
        return (l<T>) b.jXW;
    }

    l() {
    }

    public rx.j<? super T> call(rx.j<? super T> jVar) {
        a aVar = new a(jVar, this.jXP, this.jXQ, this.jXR);
        jVar.add(aVar);
        jVar.setProducer(aVar.cEd());
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a<T> extends rx.j<T> implements BackpressureDrainManager.a {
        private final rx.j<? super T> child;
        private final rx.functions.a jXQ;
        private final a.d jXR;
        private final AtomicLong jXT;
        private final BackpressureDrainManager jXV;
        private final ConcurrentLinkedQueue<Object> jXS = new ConcurrentLinkedQueue<>();
        private final AtomicBoolean jXU = new AtomicBoolean(false);

        public a(rx.j<? super T> jVar, Long l, rx.functions.a aVar, a.d dVar) {
            this.child = jVar;
            this.jXT = l != null ? new AtomicLong(l.longValue()) : null;
            this.jXQ = aVar;
            this.jXV = new BackpressureDrainManager(this);
            this.jXR = dVar;
        }

        @Override // rx.j
        public void onStart() {
            request(Long.MAX_VALUE);
        }

        @Override // rx.e
        public void onCompleted() {
            if (!this.jXU.get()) {
                this.jXV.terminateAndDrain();
            }
        }

        @Override // rx.e
        public void onError(Throwable th) {
            if (!this.jXU.get()) {
                this.jXV.terminateAndDrain(th);
            }
        }

        @Override // rx.e
        public void onNext(T t) {
            if (cEc()) {
                this.jXS.offer(NotificationLite.bp(t));
                this.jXV.drain();
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
            return this.jXS.peek();
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public Object poll() {
            Object poll = this.jXS.poll();
            if (this.jXT != null && poll != null) {
                this.jXT.incrementAndGet();
            }
            return poll;
        }

        private boolean cEc() {
            long j;
            boolean z;
            if (this.jXT == null) {
                return true;
            }
            do {
                j = this.jXT.get();
                if (j <= 0) {
                    try {
                        z = this.jXR.cDo() && poll() != null;
                    } catch (MissingBackpressureException e) {
                        if (this.jXU.compareAndSet(false, true)) {
                            unsubscribe();
                            this.child.onError(e);
                        }
                        z = false;
                    }
                    if (this.jXQ != null) {
                        try {
                            this.jXQ.call();
                        } catch (Throwable th) {
                            rx.exceptions.a.L(th);
                            this.jXV.terminateAndDrain(th);
                            return false;
                        }
                    }
                    if (!z) {
                        return false;
                    }
                }
            } while (!this.jXT.compareAndSet(j, j - 1));
            return true;
        }

        protected rx.f cEd() {
            return this.jXV;
        }
    }
}
