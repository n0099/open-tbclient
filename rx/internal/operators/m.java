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
    private final Long nPa = null;
    private final rx.functions.a nPb = null;
    private final a.d nPc = rx.a.nLZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class b {
        static final m<?> nPh = new m<>();
    }

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public static <T> m<T> dNd() {
        return (m<T>) b.nPh;
    }

    m() {
    }

    public rx.j<? super T> call(rx.j<? super T> jVar) {
        a aVar = new a(jVar, this.nPa, this.nPb, this.nPc);
        jVar.add(aVar);
        jVar.setProducer(aVar.dNf());
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class a<T> extends rx.j<T> implements BackpressureDrainManager.a {
        private final rx.j<? super T> child;
        private final rx.functions.a nPb;
        private final a.d nPc;
        private final AtomicLong nPe;
        private final BackpressureDrainManager nPg;
        private final ConcurrentLinkedQueue<Object> nPd = new ConcurrentLinkedQueue<>();
        private final AtomicBoolean nPf = new AtomicBoolean(false);

        public a(rx.j<? super T> jVar, Long l, rx.functions.a aVar, a.d dVar) {
            this.child = jVar;
            this.nPe = l != null ? new AtomicLong(l.longValue()) : null;
            this.nPb = aVar;
            this.nPg = new BackpressureDrainManager(this);
            this.nPc = dVar;
        }

        @Override // rx.j
        public void onStart() {
            request(Format.OFFSET_SAMPLE_RELATIVE);
        }

        @Override // rx.e
        public void onCompleted() {
            if (!this.nPf.get()) {
                this.nPg.terminateAndDrain();
            }
        }

        @Override // rx.e
        public void onError(Throwable th) {
            if (!this.nPf.get()) {
                this.nPg.terminateAndDrain(th);
            }
        }

        @Override // rx.e
        public void onNext(T t) {
            if (dNe()) {
                this.nPd.offer(NotificationLite.next(t));
                this.nPg.drain();
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
            return this.nPd.peek();
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public Object poll() {
            Object poll = this.nPd.poll();
            if (this.nPe != null && poll != null) {
                this.nPe.incrementAndGet();
            }
            return poll;
        }

        private boolean dNe() {
            long j;
            boolean z;
            if (this.nPe == null) {
                return true;
            }
            do {
                j = this.nPe.get();
                if (j <= 0) {
                    try {
                        z = this.nPc.dMw() && poll() != null;
                    } catch (MissingBackpressureException e) {
                        if (this.nPf.compareAndSet(false, true)) {
                            unsubscribe();
                            this.child.onError(e);
                        }
                        z = false;
                    }
                    if (this.nPb != null) {
                        try {
                            this.nPb.call();
                        } catch (Throwable th) {
                            rx.exceptions.a.I(th);
                            this.nPg.terminateAndDrain(th);
                            return false;
                        }
                    }
                    if (!z) {
                        return false;
                    }
                }
            } while (!this.nPe.compareAndSet(j, j - 1));
            return true;
        }

        protected rx.f dNf() {
            return this.nPg;
        }
    }
}
