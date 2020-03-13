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
    private final Long nQc = null;
    private final rx.functions.a nQd = null;
    private final a.d nQe = rx.a.nNb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class b {
        static final m<?> nQj = new m<>();
    }

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public static <T> m<T> dOt() {
        return (m<T>) b.nQj;
    }

    m() {
    }

    public rx.j<? super T> call(rx.j<? super T> jVar) {
        a aVar = new a(jVar, this.nQc, this.nQd, this.nQe);
        jVar.add(aVar);
        jVar.setProducer(aVar.dOv());
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class a<T> extends rx.j<T> implements BackpressureDrainManager.a {
        private final rx.j<? super T> child;
        private final rx.functions.a nQd;
        private final a.d nQe;
        private final AtomicLong nQg;
        private final BackpressureDrainManager nQi;
        private final ConcurrentLinkedQueue<Object> nQf = new ConcurrentLinkedQueue<>();
        private final AtomicBoolean nQh = new AtomicBoolean(false);

        public a(rx.j<? super T> jVar, Long l, rx.functions.a aVar, a.d dVar) {
            this.child = jVar;
            this.nQg = l != null ? new AtomicLong(l.longValue()) : null;
            this.nQd = aVar;
            this.nQi = new BackpressureDrainManager(this);
            this.nQe = dVar;
        }

        @Override // rx.j
        public void onStart() {
            request(Format.OFFSET_SAMPLE_RELATIVE);
        }

        @Override // rx.e
        public void onCompleted() {
            if (!this.nQh.get()) {
                this.nQi.terminateAndDrain();
            }
        }

        @Override // rx.e
        public void onError(Throwable th) {
            if (!this.nQh.get()) {
                this.nQi.terminateAndDrain(th);
            }
        }

        @Override // rx.e
        public void onNext(T t) {
            if (dOu()) {
                this.nQf.offer(NotificationLite.next(t));
                this.nQi.drain();
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
            return this.nQf.peek();
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public Object poll() {
            Object poll = this.nQf.poll();
            if (this.nQg != null && poll != null) {
                this.nQg.incrementAndGet();
            }
            return poll;
        }

        private boolean dOu() {
            long j;
            boolean z;
            if (this.nQg == null) {
                return true;
            }
            do {
                j = this.nQg.get();
                if (j <= 0) {
                    try {
                        z = this.nQe.dNM() && poll() != null;
                    } catch (MissingBackpressureException e) {
                        if (this.nQh.compareAndSet(false, true)) {
                            unsubscribe();
                            this.child.onError(e);
                        }
                        z = false;
                    }
                    if (this.nQd != null) {
                        try {
                            this.nQd.call();
                        } catch (Throwable th) {
                            rx.exceptions.a.H(th);
                            this.nQi.terminateAndDrain(th);
                            return false;
                        }
                    }
                    if (!z) {
                        return false;
                    }
                }
            } while (!this.nQg.compareAndSet(j, j - 1));
            return true;
        }

        protected rx.f dOv() {
            return this.nQi;
        }
    }
}
