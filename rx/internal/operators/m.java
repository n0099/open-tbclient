package rx.internal.operators;

import com.google.android.exoplayer2.Format;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import rx.a;
import rx.d;
import rx.exceptions.MissingBackpressureException;
import rx.internal.util.BackpressureDrainManager;
/* loaded from: classes4.dex */
public class m<T> implements d.b<T, T> {
    private final Long nfX = null;
    private final rx.functions.a nfY = null;
    private final a.d nfZ = rx.a.ncV;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class b {
        static final m<?> nge = new m<>();
    }

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public static <T> m<T> dGA() {
        return (m<T>) b.nge;
    }

    m() {
    }

    public rx.j<? super T> call(rx.j<? super T> jVar) {
        a aVar = new a(jVar, this.nfX, this.nfY, this.nfZ);
        jVar.add(aVar);
        jVar.setProducer(aVar.dGC());
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class a<T> extends rx.j<T> implements BackpressureDrainManager.a {
        private final rx.j<? super T> child;
        private final rx.functions.a nfY;
        private final a.d nfZ;
        private final AtomicLong ngb;
        private final BackpressureDrainManager ngd;
        private final ConcurrentLinkedQueue<Object> nga = new ConcurrentLinkedQueue<>();
        private final AtomicBoolean ngc = new AtomicBoolean(false);

        public a(rx.j<? super T> jVar, Long l, rx.functions.a aVar, a.d dVar) {
            this.child = jVar;
            this.ngb = l != null ? new AtomicLong(l.longValue()) : null;
            this.nfY = aVar;
            this.ngd = new BackpressureDrainManager(this);
            this.nfZ = dVar;
        }

        @Override // rx.j
        public void onStart() {
            request(Format.OFFSET_SAMPLE_RELATIVE);
        }

        @Override // rx.e
        public void onCompleted() {
            if (!this.ngc.get()) {
                this.ngd.terminateAndDrain();
            }
        }

        @Override // rx.e
        public void onError(Throwable th) {
            if (!this.ngc.get()) {
                this.ngd.terminateAndDrain(th);
            }
        }

        @Override // rx.e
        public void onNext(T t) {
            if (dGB()) {
                this.nga.offer(NotificationLite.next(t));
                this.ngd.drain();
            }
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public boolean bY(Object obj) {
            return NotificationLite.a(this.child, obj);
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public void T(Throwable th) {
            if (th != null) {
                this.child.onError(th);
            } else {
                this.child.onCompleted();
            }
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public Object peek() {
            return this.nga.peek();
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public Object poll() {
            Object poll = this.nga.poll();
            if (this.ngb != null && poll != null) {
                this.ngb.incrementAndGet();
            }
            return poll;
        }

        private boolean dGB() {
            long j;
            boolean z;
            if (this.ngb == null) {
                return true;
            }
            do {
                j = this.ngb.get();
                if (j <= 0) {
                    try {
                        z = this.nfZ.dFT() && poll() != null;
                    } catch (MissingBackpressureException e) {
                        if (this.ngc.compareAndSet(false, true)) {
                            unsubscribe();
                            this.child.onError(e);
                        }
                        z = false;
                    }
                    if (this.nfY != null) {
                        try {
                            this.nfY.call();
                        } catch (Throwable th) {
                            rx.exceptions.a.I(th);
                            this.ngd.terminateAndDrain(th);
                            return false;
                        }
                    }
                    if (!z) {
                        return false;
                    }
                }
            } while (!this.ngb.compareAndSet(j, j - 1));
            return true;
        }

        protected rx.f dGC() {
            return this.ngd;
        }
    }
}
