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
    private final Long nGy = null;
    private final rx.functions.a nGz = null;
    private final a.d nGA = rx.a.nDw;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class b {
        static final m<?> nGF = new m<>();
    }

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public static <T> m<T> dPK() {
        return (m<T>) b.nGF;
    }

    m() {
    }

    public rx.j<? super T> call(rx.j<? super T> jVar) {
        a aVar = new a(jVar, this.nGy, this.nGz, this.nGA);
        jVar.add(aVar);
        jVar.setProducer(aVar.dPM());
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class a<T> extends rx.j<T> implements BackpressureDrainManager.a {
        private final rx.j<? super T> child;
        private final a.d nGA;
        private final AtomicLong nGC;
        private final BackpressureDrainManager nGE;
        private final rx.functions.a nGz;
        private final ConcurrentLinkedQueue<Object> nGB = new ConcurrentLinkedQueue<>();
        private final AtomicBoolean nGD = new AtomicBoolean(false);

        public a(rx.j<? super T> jVar, Long l, rx.functions.a aVar, a.d dVar) {
            this.child = jVar;
            this.nGC = l != null ? new AtomicLong(l.longValue()) : null;
            this.nGz = aVar;
            this.nGE = new BackpressureDrainManager(this);
            this.nGA = dVar;
        }

        @Override // rx.j
        public void onStart() {
            request(Long.MAX_VALUE);
        }

        @Override // rx.e
        public void onCompleted() {
            if (!this.nGD.get()) {
                this.nGE.terminateAndDrain();
            }
        }

        @Override // rx.e
        public void onError(Throwable th) {
            if (!this.nGD.get()) {
                this.nGE.terminateAndDrain(th);
            }
        }

        @Override // rx.e
        public void onNext(T t) {
            if (dPL()) {
                this.nGB.offer(NotificationLite.next(t));
                this.nGE.drain();
            }
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public boolean bX(Object obj) {
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
            return this.nGB.peek();
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public Object poll() {
            Object poll = this.nGB.poll();
            if (this.nGC != null && poll != null) {
                this.nGC.incrementAndGet();
            }
            return poll;
        }

        private boolean dPL() {
            long j;
            boolean z;
            if (this.nGC == null) {
                return true;
            }
            do {
                j = this.nGC.get();
                if (j <= 0) {
                    try {
                        z = this.nGA.dPc() && poll() != null;
                    } catch (MissingBackpressureException e) {
                        if (this.nGD.compareAndSet(false, true)) {
                            unsubscribe();
                            this.child.onError(e);
                        }
                        z = false;
                    }
                    if (this.nGz != null) {
                        try {
                            this.nGz.call();
                        } catch (Throwable th) {
                            rx.exceptions.a.L(th);
                            this.nGE.terminateAndDrain(th);
                            return false;
                        }
                    }
                    if (!z) {
                        return false;
                    }
                }
            } while (!this.nGC.compareAndSet(j, j - 1));
            return true;
        }

        protected rx.f dPM() {
            return this.nGE;
        }
    }
}
