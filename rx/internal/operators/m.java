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
    private final Long nRP = null;
    private final rx.functions.a nRQ = null;
    private final a.d nRR = rx.a.nOO;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class b {
        static final m<?> nRW = new m<>();
    }

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public static <T> m<T> dOT() {
        return (m<T>) b.nRW;
    }

    m() {
    }

    public rx.j<? super T> call(rx.j<? super T> jVar) {
        a aVar = new a(jVar, this.nRP, this.nRQ, this.nRR);
        jVar.add(aVar);
        jVar.setProducer(aVar.dOV());
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class a<T> extends rx.j<T> implements BackpressureDrainManager.a {
        private final rx.j<? super T> child;
        private final rx.functions.a nRQ;
        private final a.d nRR;
        private final AtomicLong nRT;
        private final BackpressureDrainManager nRV;
        private final ConcurrentLinkedQueue<Object> nRS = new ConcurrentLinkedQueue<>();
        private final AtomicBoolean nRU = new AtomicBoolean(false);

        public a(rx.j<? super T> jVar, Long l, rx.functions.a aVar, a.d dVar) {
            this.child = jVar;
            this.nRT = l != null ? new AtomicLong(l.longValue()) : null;
            this.nRQ = aVar;
            this.nRV = new BackpressureDrainManager(this);
            this.nRR = dVar;
        }

        @Override // rx.j
        public void onStart() {
            request(Format.OFFSET_SAMPLE_RELATIVE);
        }

        @Override // rx.e
        public void onCompleted() {
            if (!this.nRU.get()) {
                this.nRV.terminateAndDrain();
            }
        }

        @Override // rx.e
        public void onError(Throwable th) {
            if (!this.nRU.get()) {
                this.nRV.terminateAndDrain(th);
            }
        }

        @Override // rx.e
        public void onNext(T t) {
            if (dOU()) {
                this.nRS.offer(NotificationLite.next(t));
                this.nRV.drain();
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
            return this.nRS.peek();
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public Object poll() {
            Object poll = this.nRS.poll();
            if (this.nRT != null && poll != null) {
                this.nRT.incrementAndGet();
            }
            return poll;
        }

        private boolean dOU() {
            long j;
            boolean z;
            if (this.nRT == null) {
                return true;
            }
            do {
                j = this.nRT.get();
                if (j <= 0) {
                    try {
                        z = this.nRR.dOm() && poll() != null;
                    } catch (MissingBackpressureException e) {
                        if (this.nRU.compareAndSet(false, true)) {
                            unsubscribe();
                            this.child.onError(e);
                        }
                        z = false;
                    }
                    if (this.nRQ != null) {
                        try {
                            this.nRQ.call();
                        } catch (Throwable th) {
                            rx.exceptions.a.H(th);
                            this.nRV.terminateAndDrain(th);
                            return false;
                        }
                    }
                    if (!z) {
                        return false;
                    }
                }
            } while (!this.nRT.compareAndSet(j, j - 1));
            return true;
        }

        protected rx.f dOV() {
            return this.nRV;
        }
    }
}
