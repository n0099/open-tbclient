package rx.internal.operators;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import rx.a;
import rx.d;
import rx.exceptions.MissingBackpressureException;
import rx.internal.util.BackpressureDrainManager;
/* loaded from: classes2.dex */
public class az<T> implements d.b<T, T> {
    private final Long iKD;
    private final rx.functions.a iKE;
    private final a.d iKF;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class b {
        static final az<?> iKK = new az<>();
    }

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public static <T> az<T> cfg() {
        return (az<T>) b.iKK;
    }

    az() {
        this.iKD = null;
        this.iKE = null;
        this.iKF = rx.a.iEU;
    }

    public az(long j) {
        this(j, null, rx.a.iEU);
    }

    public az(long j, rx.functions.a aVar) {
        this(j, aVar, rx.a.iEU);
    }

    public az(long j, rx.functions.a aVar, a.d dVar) {
        if (j <= 0) {
            throw new IllegalArgumentException("Buffer capacity must be > 0");
        }
        if (dVar == null) {
            throw new NullPointerException("The BackpressureOverflow strategy must not be null");
        }
        this.iKD = Long.valueOf(j);
        this.iKE = aVar;
        this.iKF = dVar;
    }

    public rx.j<? super T> call(rx.j<? super T> jVar) {
        a aVar = new a(jVar, this.iKD, this.iKE, this.iKF);
        jVar.add(aVar);
        jVar.setProducer(aVar.cfi());
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a<T> extends rx.j<T> implements BackpressureDrainManager.a {
        private final rx.j<? super T> child;
        private final rx.functions.a iKE;
        private final a.d iKF;
        private final AtomicLong iKH;
        private final BackpressureDrainManager iKJ;
        private final ConcurrentLinkedQueue<Object> iKG = new ConcurrentLinkedQueue<>();
        private final AtomicBoolean iKI = new AtomicBoolean(false);

        public a(rx.j<? super T> jVar, Long l, rx.functions.a aVar, a.d dVar) {
            this.child = jVar;
            this.iKH = l != null ? new AtomicLong(l.longValue()) : null;
            this.iKE = aVar;
            this.iKJ = new BackpressureDrainManager(this);
            this.iKF = dVar;
        }

        @Override // rx.j
        public void onStart() {
            request(Long.MAX_VALUE);
        }

        @Override // rx.e
        public void onCompleted() {
            if (!this.iKI.get()) {
                this.iKJ.terminateAndDrain();
            }
        }

        @Override // rx.e
        public void onError(Throwable th) {
            if (!this.iKI.get()) {
                this.iKJ.terminateAndDrain(th);
            }
        }

        @Override // rx.e
        public void onNext(T t) {
            if (cfh()) {
                this.iKG.offer(NotificationLite.aY(t));
                this.iKJ.drain();
            }
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public boolean accept(Object obj) {
            return NotificationLite.a(this.child, obj);
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public void P(Throwable th) {
            if (th != null) {
                this.child.onError(th);
            } else {
                this.child.onCompleted();
            }
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public Object peek() {
            return this.iKG.peek();
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public Object poll() {
            Object poll = this.iKG.poll();
            if (this.iKH != null && poll != null) {
                this.iKH.incrementAndGet();
            }
            return poll;
        }

        private boolean cfh() {
            long j;
            boolean z;
            if (this.iKH == null) {
                return true;
            }
            do {
                j = this.iKH.get();
                if (j <= 0) {
                    try {
                        z = this.iKF.cej() && poll() != null;
                    } catch (MissingBackpressureException e) {
                        if (this.iKI.compareAndSet(false, true)) {
                            unsubscribe();
                            this.child.onError(e);
                        }
                        z = false;
                    }
                    if (this.iKE != null) {
                        try {
                            this.iKE.call();
                        } catch (Throwable th) {
                            rx.exceptions.a.J(th);
                            this.iKJ.terminateAndDrain(th);
                            return false;
                        }
                    }
                    if (!z) {
                        return false;
                    }
                }
            } while (!this.iKH.compareAndSet(j, j - 1));
            return true;
        }

        protected rx.f cfi() {
            return this.iKJ;
        }
    }
}
