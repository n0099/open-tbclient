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
    private final Long nPR = null;
    private final rx.functions.a nPS = null;
    private final a.d nPT = rx.a.nMQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class b {
        static final m<?> nPY = new m<>();
    }

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public static <T> m<T> dOs() {
        return (m<T>) b.nPY;
    }

    m() {
    }

    public rx.j<? super T> call(rx.j<? super T> jVar) {
        a aVar = new a(jVar, this.nPR, this.nPS, this.nPT);
        jVar.add(aVar);
        jVar.setProducer(aVar.dOu());
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class a<T> extends rx.j<T> implements BackpressureDrainManager.a {
        private final rx.j<? super T> child;
        private final rx.functions.a nPS;
        private final a.d nPT;
        private final AtomicLong nPV;
        private final BackpressureDrainManager nPX;
        private final ConcurrentLinkedQueue<Object> nPU = new ConcurrentLinkedQueue<>();
        private final AtomicBoolean nPW = new AtomicBoolean(false);

        public a(rx.j<? super T> jVar, Long l, rx.functions.a aVar, a.d dVar) {
            this.child = jVar;
            this.nPV = l != null ? new AtomicLong(l.longValue()) : null;
            this.nPS = aVar;
            this.nPX = new BackpressureDrainManager(this);
            this.nPT = dVar;
        }

        @Override // rx.j
        public void onStart() {
            request(Format.OFFSET_SAMPLE_RELATIVE);
        }

        @Override // rx.e
        public void onCompleted() {
            if (!this.nPW.get()) {
                this.nPX.terminateAndDrain();
            }
        }

        @Override // rx.e
        public void onError(Throwable th) {
            if (!this.nPW.get()) {
                this.nPX.terminateAndDrain(th);
            }
        }

        @Override // rx.e
        public void onNext(T t) {
            if (dOt()) {
                this.nPU.offer(NotificationLite.next(t));
                this.nPX.drain();
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
            return this.nPU.peek();
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public Object poll() {
            Object poll = this.nPU.poll();
            if (this.nPV != null && poll != null) {
                this.nPV.incrementAndGet();
            }
            return poll;
        }

        private boolean dOt() {
            long j;
            boolean z;
            if (this.nPV == null) {
                return true;
            }
            do {
                j = this.nPV.get();
                if (j <= 0) {
                    try {
                        z = this.nPT.dNL() && poll() != null;
                    } catch (MissingBackpressureException e) {
                        if (this.nPW.compareAndSet(false, true)) {
                            unsubscribe();
                            this.child.onError(e);
                        }
                        z = false;
                    }
                    if (this.nPS != null) {
                        try {
                            this.nPS.call();
                        } catch (Throwable th) {
                            rx.exceptions.a.H(th);
                            this.nPX.terminateAndDrain(th);
                            return false;
                        }
                    }
                    if (!z) {
                        return false;
                    }
                }
            } while (!this.nPV.compareAndSet(j, j - 1));
            return true;
        }

        protected rx.f dOu() {
            return this.nPX;
        }
    }
}
