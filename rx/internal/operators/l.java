package rx.internal.operators;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import rx.a;
import rx.d;
import rx.exceptions.MissingBackpressureException;
import rx.internal.util.BackpressureDrainManager;
/* loaded from: classes15.dex */
public class l<T> implements d.b<T, T> {
    private final Long quU = null;
    private final rx.functions.a quV = null;
    private final a.d quW = rx.a.qrT;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public static final class b {
        static final l<?> qvb = new l<>();
    }

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public static <T> l<T> eOB() {
        return (l<T>) b.qvb;
    }

    l() {
    }

    public rx.j<? super T> call(rx.j<? super T> jVar) {
        a aVar = new a(jVar, this.quU, this.quV, this.quW);
        jVar.add(aVar);
        jVar.setProducer(aVar.eOD());
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public static final class a<T> extends rx.j<T> implements BackpressureDrainManager.a {
        private final rx.j<? super T> child;
        private final rx.functions.a quV;
        private final a.d quW;
        private final AtomicLong quY;
        private final BackpressureDrainManager qva;
        private final ConcurrentLinkedQueue<Object> quX = new ConcurrentLinkedQueue<>();
        private final AtomicBoolean quZ = new AtomicBoolean(false);

        public a(rx.j<? super T> jVar, Long l, rx.functions.a aVar, a.d dVar) {
            this.child = jVar;
            this.quY = l != null ? new AtomicLong(l.longValue()) : null;
            this.quV = aVar;
            this.qva = new BackpressureDrainManager(this);
            this.quW = dVar;
        }

        @Override // rx.j
        public void onStart() {
            request(Long.MAX_VALUE);
        }

        @Override // rx.e
        public void onCompleted() {
            if (!this.quZ.get()) {
                this.qva.terminateAndDrain();
            }
        }

        @Override // rx.e
        public void onError(Throwable th) {
            if (!this.quZ.get()) {
                this.qva.terminateAndDrain(th);
            }
        }

        @Override // rx.e
        public void onNext(T t) {
            if (eOC()) {
                this.quX.offer(NotificationLite.next(t));
                this.qva.drain();
            }
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public boolean cd(Object obj) {
            return NotificationLite.a(this.child, obj);
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public void Z(Throwable th) {
            if (th != null) {
                this.child.onError(th);
            } else {
                this.child.onCompleted();
            }
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public Object peek() {
            return this.quX.peek();
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public Object poll() {
            Object poll = this.quX.poll();
            if (this.quY != null && poll != null) {
                this.quY.incrementAndGet();
            }
            return poll;
        }

        private boolean eOC() {
            long j;
            boolean z;
            if (this.quY == null) {
                return true;
            }
            do {
                j = this.quY.get();
                if (j <= 0) {
                    try {
                        z = this.quW.eNT() && poll() != null;
                    } catch (MissingBackpressureException e) {
                        if (this.quZ.compareAndSet(false, true)) {
                            unsubscribe();
                            this.child.onError(e);
                        }
                        z = false;
                    }
                    if (this.quV != null) {
                        try {
                            this.quV.call();
                        } catch (Throwable th) {
                            rx.exceptions.a.O(th);
                            this.qva.terminateAndDrain(th);
                            return false;
                        }
                    }
                    if (!z) {
                        return false;
                    }
                }
            } while (!this.quY.compareAndSet(j, j - 1));
            return true;
        }

        protected rx.f eOD() {
            return this.qva;
        }
    }
}
