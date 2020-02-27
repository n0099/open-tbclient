package rx.internal.operators;

import com.google.android.exoplayer2.Format;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import rx.a;
import rx.d;
import rx.exceptions.MissingBackpressureException;
import rx.internal.util.BackpressureDrainManager;
/* loaded from: classes6.dex */
public class m<T> implements d.b<T, T> {
    private final Long nPP = null;
    private final rx.functions.a nPQ = null;
    private final a.d nPR = rx.a.nMO;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class b {
        static final m<?> nPW = new m<>();
    }

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public static <T> m<T> dOq() {
        return (m<T>) b.nPW;
    }

    m() {
    }

    public rx.j<? super T> call(rx.j<? super T> jVar) {
        a aVar = new a(jVar, this.nPP, this.nPQ, this.nPR);
        jVar.add(aVar);
        jVar.setProducer(aVar.dOs());
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class a<T> extends rx.j<T> implements BackpressureDrainManager.a {
        private final rx.j<? super T> child;
        private final rx.functions.a nPQ;
        private final a.d nPR;
        private final AtomicLong nPT;
        private final BackpressureDrainManager nPV;
        private final ConcurrentLinkedQueue<Object> nPS = new ConcurrentLinkedQueue<>();
        private final AtomicBoolean nPU = new AtomicBoolean(false);

        public a(rx.j<? super T> jVar, Long l, rx.functions.a aVar, a.d dVar) {
            this.child = jVar;
            this.nPT = l != null ? new AtomicLong(l.longValue()) : null;
            this.nPQ = aVar;
            this.nPV = new BackpressureDrainManager(this);
            this.nPR = dVar;
        }

        @Override // rx.j
        public void onStart() {
            request(Format.OFFSET_SAMPLE_RELATIVE);
        }

        @Override // rx.e
        public void onCompleted() {
            if (!this.nPU.get()) {
                this.nPV.terminateAndDrain();
            }
        }

        @Override // rx.e
        public void onError(Throwable th) {
            if (!this.nPU.get()) {
                this.nPV.terminateAndDrain(th);
            }
        }

        @Override // rx.e
        public void onNext(T t) {
            if (dOr()) {
                this.nPS.offer(NotificationLite.next(t));
                this.nPV.drain();
            }
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public boolean ch(Object obj) {
            return NotificationLite.a(this.child, obj);
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public void U(Throwable th) {
            if (th != null) {
                this.child.onError(th);
            } else {
                this.child.onCompleted();
            }
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public Object peek() {
            return this.nPS.peek();
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public Object poll() {
            Object poll = this.nPS.poll();
            if (this.nPT != null && poll != null) {
                this.nPT.incrementAndGet();
            }
            return poll;
        }

        private boolean dOr() {
            long j;
            boolean z;
            if (this.nPT == null) {
                return true;
            }
            do {
                j = this.nPT.get();
                if (j <= 0) {
                    try {
                        z = this.nPR.dNJ() && poll() != null;
                    } catch (MissingBackpressureException e) {
                        if (this.nPU.compareAndSet(false, true)) {
                            unsubscribe();
                            this.child.onError(e);
                        }
                        z = false;
                    }
                    if (this.nPQ != null) {
                        try {
                            this.nPQ.call();
                        } catch (Throwable th) {
                            rx.exceptions.a.H(th);
                            this.nPV.terminateAndDrain(th);
                            return false;
                        }
                    }
                    if (!z) {
                        return false;
                    }
                }
            } while (!this.nPT.compareAndSet(j, j - 1));
            return true;
        }

        protected rx.f dOs() {
            return this.nPV;
        }
    }
}
