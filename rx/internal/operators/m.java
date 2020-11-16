package rx.internal.operators;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import rx.a;
import rx.d;
import rx.exceptions.MissingBackpressureException;
import rx.internal.util.BackpressureDrainManager;
/* loaded from: classes14.dex */
public class m<T> implements d.b<T, T> {
    private final Long qhH = null;
    private final rx.functions.a qhI = null;
    private final a.d qhJ = rx.a.qeF;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
    public static final class b {
        static final m<?> qhO = new m<>();
    }

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public static <T> m<T> eFP() {
        return (m<T>) b.qhO;
    }

    m() {
    }

    public rx.j<? super T> call(rx.j<? super T> jVar) {
        a aVar = new a(jVar, this.qhH, this.qhI, this.qhJ);
        jVar.add(aVar);
        jVar.setProducer(aVar.eFR());
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
    public static final class a<T> extends rx.j<T> implements BackpressureDrainManager.a {
        private final rx.j<? super T> child;
        private final rx.functions.a qhI;
        private final a.d qhJ;
        private final AtomicLong qhL;
        private final BackpressureDrainManager qhN;
        private final ConcurrentLinkedQueue<Object> qhK = new ConcurrentLinkedQueue<>();
        private final AtomicBoolean qhM = new AtomicBoolean(false);

        public a(rx.j<? super T> jVar, Long l, rx.functions.a aVar, a.d dVar) {
            this.child = jVar;
            this.qhL = l != null ? new AtomicLong(l.longValue()) : null;
            this.qhI = aVar;
            this.qhN = new BackpressureDrainManager(this);
            this.qhJ = dVar;
        }

        @Override // rx.j
        public void onStart() {
            request(Long.MAX_VALUE);
        }

        @Override // rx.e
        public void onCompleted() {
            if (!this.qhM.get()) {
                this.qhN.terminateAndDrain();
            }
        }

        @Override // rx.e
        public void onError(Throwable th) {
            if (!this.qhM.get()) {
                this.qhN.terminateAndDrain(th);
            }
        }

        @Override // rx.e
        public void onNext(T t) {
            if (eFQ()) {
                this.qhK.offer(NotificationLite.next(t));
                this.qhN.drain();
            }
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public boolean ck(Object obj) {
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
            return this.qhK.peek();
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public Object poll() {
            Object poll = this.qhK.poll();
            if (this.qhL != null && poll != null) {
                this.qhL.incrementAndGet();
            }
            return poll;
        }

        private boolean eFQ() {
            long j;
            boolean z;
            if (this.qhL == null) {
                return true;
            }
            do {
                j = this.qhL.get();
                if (j <= 0) {
                    try {
                        z = this.qhJ.eFh() && poll() != null;
                    } catch (MissingBackpressureException e) {
                        if (this.qhM.compareAndSet(false, true)) {
                            unsubscribe();
                            this.child.onError(e);
                        }
                        z = false;
                    }
                    if (this.qhI != null) {
                        try {
                            this.qhI.call();
                        } catch (Throwable th) {
                            rx.exceptions.a.J(th);
                            this.qhN.terminateAndDrain(th);
                            return false;
                        }
                    }
                    if (!z) {
                        return false;
                    }
                }
            } while (!this.qhL.compareAndSet(j, j - 1));
            return true;
        }

        protected rx.f eFR() {
            return this.qhN;
        }
    }
}
