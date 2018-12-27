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
    private final Long iJv;
    private final rx.functions.a iJw;
    private final a.d iJx;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class b {
        static final az<?> iJC = new az<>();
    }

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public static <T> az<T> cey() {
        return (az<T>) b.iJC;
    }

    az() {
        this.iJv = null;
        this.iJw = null;
        this.iJx = rx.a.iDM;
    }

    public az(long j) {
        this(j, null, rx.a.iDM);
    }

    public az(long j, rx.functions.a aVar) {
        this(j, aVar, rx.a.iDM);
    }

    public az(long j, rx.functions.a aVar, a.d dVar) {
        if (j <= 0) {
            throw new IllegalArgumentException("Buffer capacity must be > 0");
        }
        if (dVar == null) {
            throw new NullPointerException("The BackpressureOverflow strategy must not be null");
        }
        this.iJv = Long.valueOf(j);
        this.iJw = aVar;
        this.iJx = dVar;
    }

    public rx.j<? super T> call(rx.j<? super T> jVar) {
        a aVar = new a(jVar, this.iJv, this.iJw, this.iJx);
        jVar.add(aVar);
        jVar.setProducer(aVar.ceA());
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a<T> extends rx.j<T> implements BackpressureDrainManager.a {
        private final rx.j<? super T> child;
        private final BackpressureDrainManager iJB;
        private final rx.functions.a iJw;
        private final a.d iJx;
        private final AtomicLong iJz;
        private final ConcurrentLinkedQueue<Object> iJy = new ConcurrentLinkedQueue<>();
        private final AtomicBoolean iJA = new AtomicBoolean(false);

        public a(rx.j<? super T> jVar, Long l, rx.functions.a aVar, a.d dVar) {
            this.child = jVar;
            this.iJz = l != null ? new AtomicLong(l.longValue()) : null;
            this.iJw = aVar;
            this.iJB = new BackpressureDrainManager(this);
            this.iJx = dVar;
        }

        @Override // rx.j
        public void onStart() {
            request(Long.MAX_VALUE);
        }

        @Override // rx.e
        public void onCompleted() {
            if (!this.iJA.get()) {
                this.iJB.terminateAndDrain();
            }
        }

        @Override // rx.e
        public void onError(Throwable th) {
            if (!this.iJA.get()) {
                this.iJB.terminateAndDrain(th);
            }
        }

        @Override // rx.e
        public void onNext(T t) {
            if (cez()) {
                this.iJy.offer(NotificationLite.aY(t));
                this.iJB.drain();
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
            return this.iJy.peek();
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public Object poll() {
            Object poll = this.iJy.poll();
            if (this.iJz != null && poll != null) {
                this.iJz.incrementAndGet();
            }
            return poll;
        }

        private boolean cez() {
            long j;
            boolean z;
            if (this.iJz == null) {
                return true;
            }
            do {
                j = this.iJz.get();
                if (j <= 0) {
                    try {
                        z = this.iJx.cdB() && poll() != null;
                    } catch (MissingBackpressureException e) {
                        if (this.iJA.compareAndSet(false, true)) {
                            unsubscribe();
                            this.child.onError(e);
                        }
                        z = false;
                    }
                    if (this.iJw != null) {
                        try {
                            this.iJw.call();
                        } catch (Throwable th) {
                            rx.exceptions.a.J(th);
                            this.iJB.terminateAndDrain(th);
                            return false;
                        }
                    }
                    if (!z) {
                        return false;
                    }
                }
            } while (!this.iJz.compareAndSet(j, j - 1));
            return true;
        }

        protected rx.f ceA() {
            return this.iJB;
        }
    }
}
