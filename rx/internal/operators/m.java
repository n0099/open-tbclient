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
    private final Long nHI = null;
    private final rx.functions.a nHJ = null;
    private final a.d nHK = rx.a.nEG;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class b {
        static final m<?> nHP = new m<>();
    }

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public static <T> m<T> dPY() {
        return (m<T>) b.nHP;
    }

    m() {
    }

    public rx.j<? super T> call(rx.j<? super T> jVar) {
        a aVar = new a(jVar, this.nHI, this.nHJ, this.nHK);
        jVar.add(aVar);
        jVar.setProducer(aVar.dQa());
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class a<T> extends rx.j<T> implements BackpressureDrainManager.a {
        private final rx.j<? super T> child;
        private final rx.functions.a nHJ;
        private final a.d nHK;
        private final AtomicLong nHM;
        private final BackpressureDrainManager nHO;
        private final ConcurrentLinkedQueue<Object> nHL = new ConcurrentLinkedQueue<>();
        private final AtomicBoolean nHN = new AtomicBoolean(false);

        public a(rx.j<? super T> jVar, Long l, rx.functions.a aVar, a.d dVar) {
            this.child = jVar;
            this.nHM = l != null ? new AtomicLong(l.longValue()) : null;
            this.nHJ = aVar;
            this.nHO = new BackpressureDrainManager(this);
            this.nHK = dVar;
        }

        @Override // rx.j
        public void onStart() {
            request(Long.MAX_VALUE);
        }

        @Override // rx.e
        public void onCompleted() {
            if (!this.nHN.get()) {
                this.nHO.terminateAndDrain();
            }
        }

        @Override // rx.e
        public void onError(Throwable th) {
            if (!this.nHN.get()) {
                this.nHO.terminateAndDrain(th);
            }
        }

        @Override // rx.e
        public void onNext(T t) {
            if (dPZ()) {
                this.nHL.offer(NotificationLite.next(t));
                this.nHO.drain();
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
            return this.nHL.peek();
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public Object poll() {
            Object poll = this.nHL.poll();
            if (this.nHM != null && poll != null) {
                this.nHM.incrementAndGet();
            }
            return poll;
        }

        private boolean dPZ() {
            long j;
            boolean z;
            if (this.nHM == null) {
                return true;
            }
            do {
                j = this.nHM.get();
                if (j <= 0) {
                    try {
                        z = this.nHK.dPq() && poll() != null;
                    } catch (MissingBackpressureException e) {
                        if (this.nHN.compareAndSet(false, true)) {
                            unsubscribe();
                            this.child.onError(e);
                        }
                        z = false;
                    }
                    if (this.nHJ != null) {
                        try {
                            this.nHJ.call();
                        } catch (Throwable th) {
                            rx.exceptions.a.L(th);
                            this.nHO.terminateAndDrain(th);
                            return false;
                        }
                    }
                    if (!z) {
                        return false;
                    }
                }
            } while (!this.nHM.compareAndSet(j, j - 1));
            return true;
        }

        protected rx.f dQa() {
            return this.nHO;
        }
    }
}
