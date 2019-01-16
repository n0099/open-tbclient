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
    private final Long iKC;
    private final rx.functions.a iKD;
    private final a.d iKE;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class b {
        static final az<?> iKJ = new az<>();
    }

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public static <T> az<T> cfg() {
        return (az<T>) b.iKJ;
    }

    az() {
        this.iKC = null;
        this.iKD = null;
        this.iKE = rx.a.iET;
    }

    public az(long j) {
        this(j, null, rx.a.iET);
    }

    public az(long j, rx.functions.a aVar) {
        this(j, aVar, rx.a.iET);
    }

    public az(long j, rx.functions.a aVar, a.d dVar) {
        if (j <= 0) {
            throw new IllegalArgumentException("Buffer capacity must be > 0");
        }
        if (dVar == null) {
            throw new NullPointerException("The BackpressureOverflow strategy must not be null");
        }
        this.iKC = Long.valueOf(j);
        this.iKD = aVar;
        this.iKE = dVar;
    }

    public rx.j<? super T> call(rx.j<? super T> jVar) {
        a aVar = new a(jVar, this.iKC, this.iKD, this.iKE);
        jVar.add(aVar);
        jVar.setProducer(aVar.cfi());
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a<T> extends rx.j<T> implements BackpressureDrainManager.a {
        private final rx.j<? super T> child;
        private final rx.functions.a iKD;
        private final a.d iKE;
        private final AtomicLong iKG;
        private final BackpressureDrainManager iKI;
        private final ConcurrentLinkedQueue<Object> iKF = new ConcurrentLinkedQueue<>();
        private final AtomicBoolean iKH = new AtomicBoolean(false);

        public a(rx.j<? super T> jVar, Long l, rx.functions.a aVar, a.d dVar) {
            this.child = jVar;
            this.iKG = l != null ? new AtomicLong(l.longValue()) : null;
            this.iKD = aVar;
            this.iKI = new BackpressureDrainManager(this);
            this.iKE = dVar;
        }

        @Override // rx.j
        public void onStart() {
            request(Long.MAX_VALUE);
        }

        @Override // rx.e
        public void onCompleted() {
            if (!this.iKH.get()) {
                this.iKI.terminateAndDrain();
            }
        }

        @Override // rx.e
        public void onError(Throwable th) {
            if (!this.iKH.get()) {
                this.iKI.terminateAndDrain(th);
            }
        }

        @Override // rx.e
        public void onNext(T t) {
            if (cfh()) {
                this.iKF.offer(NotificationLite.aY(t));
                this.iKI.drain();
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
            return this.iKF.peek();
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public Object poll() {
            Object poll = this.iKF.poll();
            if (this.iKG != null && poll != null) {
                this.iKG.incrementAndGet();
            }
            return poll;
        }

        private boolean cfh() {
            long j;
            boolean z;
            if (this.iKG == null) {
                return true;
            }
            do {
                j = this.iKG.get();
                if (j <= 0) {
                    try {
                        z = this.iKE.cej() && poll() != null;
                    } catch (MissingBackpressureException e) {
                        if (this.iKH.compareAndSet(false, true)) {
                            unsubscribe();
                            this.child.onError(e);
                        }
                        z = false;
                    }
                    if (this.iKD != null) {
                        try {
                            this.iKD.call();
                        } catch (Throwable th) {
                            rx.exceptions.a.J(th);
                            this.iKI.terminateAndDrain(th);
                            return false;
                        }
                    }
                    if (!z) {
                        return false;
                    }
                }
            } while (!this.iKG.compareAndSet(j, j - 1));
            return true;
        }

        protected rx.f cfi() {
            return this.iKI;
        }
    }
}
