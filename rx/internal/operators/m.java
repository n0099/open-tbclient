package rx.internal.operators;

import com.google.android.exoplayer2.Format;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import rx.a;
import rx.d;
import rx.exceptions.MissingBackpressureException;
import rx.internal.util.BackpressureDrainManager;
/* loaded from: classes5.dex */
public class m<T> implements d.b<T, T> {
    private final Long nOV = null;
    private final rx.functions.a nOW = null;
    private final a.d nOX = rx.a.nLU;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class b {
        static final m<?> nPc = new m<>();
    }

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public static <T> m<T> dNb() {
        return (m<T>) b.nPc;
    }

    m() {
    }

    public rx.j<? super T> call(rx.j<? super T> jVar) {
        a aVar = new a(jVar, this.nOV, this.nOW, this.nOX);
        jVar.add(aVar);
        jVar.setProducer(aVar.dNd());
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class a<T> extends rx.j<T> implements BackpressureDrainManager.a {
        private final rx.j<? super T> child;
        private final rx.functions.a nOW;
        private final a.d nOX;
        private final AtomicLong nOZ;
        private final BackpressureDrainManager nPb;
        private final ConcurrentLinkedQueue<Object> nOY = new ConcurrentLinkedQueue<>();
        private final AtomicBoolean nPa = new AtomicBoolean(false);

        public a(rx.j<? super T> jVar, Long l, rx.functions.a aVar, a.d dVar) {
            this.child = jVar;
            this.nOZ = l != null ? new AtomicLong(l.longValue()) : null;
            this.nOW = aVar;
            this.nPb = new BackpressureDrainManager(this);
            this.nOX = dVar;
        }

        @Override // rx.j
        public void onStart() {
            request(Format.OFFSET_SAMPLE_RELATIVE);
        }

        @Override // rx.e
        public void onCompleted() {
            if (!this.nPa.get()) {
                this.nPb.terminateAndDrain();
            }
        }

        @Override // rx.e
        public void onError(Throwable th) {
            if (!this.nPa.get()) {
                this.nPb.terminateAndDrain(th);
            }
        }

        @Override // rx.e
        public void onNext(T t) {
            if (dNc()) {
                this.nOY.offer(NotificationLite.next(t));
                this.nPb.drain();
            }
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public boolean cg(Object obj) {
            return NotificationLite.a(this.child, obj);
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public void V(Throwable th) {
            if (th != null) {
                this.child.onError(th);
            } else {
                this.child.onCompleted();
            }
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public Object peek() {
            return this.nOY.peek();
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public Object poll() {
            Object poll = this.nOY.poll();
            if (this.nOZ != null && poll != null) {
                this.nOZ.incrementAndGet();
            }
            return poll;
        }

        private boolean dNc() {
            long j;
            boolean z;
            if (this.nOZ == null) {
                return true;
            }
            do {
                j = this.nOZ.get();
                if (j <= 0) {
                    try {
                        z = this.nOX.dMu() && poll() != null;
                    } catch (MissingBackpressureException e) {
                        if (this.nPa.compareAndSet(false, true)) {
                            unsubscribe();
                            this.child.onError(e);
                        }
                        z = false;
                    }
                    if (this.nOW != null) {
                        try {
                            this.nOW.call();
                        } catch (Throwable th) {
                            rx.exceptions.a.I(th);
                            this.nPb.terminateAndDrain(th);
                            return false;
                        }
                    }
                    if (!z) {
                        return false;
                    }
                }
            } while (!this.nOZ.compareAndSet(j, j - 1));
            return true;
        }

        protected rx.f dNd() {
            return this.nPb;
        }
    }
}
