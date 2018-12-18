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
    private final Long iGl;
    private final rx.functions.a iGm;
    private final a.d iGn;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class b {
        static final az<?> iGs = new az<>();
    }

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public static <T> az<T> cdH() {
        return (az<T>) b.iGs;
    }

    az() {
        this.iGl = null;
        this.iGm = null;
        this.iGn = rx.a.iAC;
    }

    public az(long j) {
        this(j, null, rx.a.iAC);
    }

    public az(long j, rx.functions.a aVar) {
        this(j, aVar, rx.a.iAC);
    }

    public az(long j, rx.functions.a aVar, a.d dVar) {
        if (j <= 0) {
            throw new IllegalArgumentException("Buffer capacity must be > 0");
        }
        if (dVar == null) {
            throw new NullPointerException("The BackpressureOverflow strategy must not be null");
        }
        this.iGl = Long.valueOf(j);
        this.iGm = aVar;
        this.iGn = dVar;
    }

    public rx.j<? super T> call(rx.j<? super T> jVar) {
        a aVar = new a(jVar, this.iGl, this.iGm, this.iGn);
        jVar.add(aVar);
        jVar.setProducer(aVar.cdJ());
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a<T> extends rx.j<T> implements BackpressureDrainManager.a {
        private final rx.j<? super T> child;
        private final rx.functions.a iGm;
        private final a.d iGn;
        private final AtomicLong iGp;
        private final BackpressureDrainManager iGr;
        private final ConcurrentLinkedQueue<Object> iGo = new ConcurrentLinkedQueue<>();
        private final AtomicBoolean iGq = new AtomicBoolean(false);

        public a(rx.j<? super T> jVar, Long l, rx.functions.a aVar, a.d dVar) {
            this.child = jVar;
            this.iGp = l != null ? new AtomicLong(l.longValue()) : null;
            this.iGm = aVar;
            this.iGr = new BackpressureDrainManager(this);
            this.iGn = dVar;
        }

        @Override // rx.j
        public void onStart() {
            request(Long.MAX_VALUE);
        }

        @Override // rx.e
        public void onCompleted() {
            if (!this.iGq.get()) {
                this.iGr.terminateAndDrain();
            }
        }

        @Override // rx.e
        public void onError(Throwable th) {
            if (!this.iGq.get()) {
                this.iGr.terminateAndDrain(th);
            }
        }

        @Override // rx.e
        public void onNext(T t) {
            if (cdI()) {
                this.iGo.offer(NotificationLite.aY(t));
                this.iGr.drain();
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
            return this.iGo.peek();
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public Object poll() {
            Object poll = this.iGo.poll();
            if (this.iGp != null && poll != null) {
                this.iGp.incrementAndGet();
            }
            return poll;
        }

        private boolean cdI() {
            long j;
            boolean z;
            if (this.iGp == null) {
                return true;
            }
            do {
                j = this.iGp.get();
                if (j <= 0) {
                    try {
                        z = this.iGn.ccK() && poll() != null;
                    } catch (MissingBackpressureException e) {
                        if (this.iGq.compareAndSet(false, true)) {
                            unsubscribe();
                            this.child.onError(e);
                        }
                        z = false;
                    }
                    if (this.iGm != null) {
                        try {
                            this.iGm.call();
                        } catch (Throwable th) {
                            rx.exceptions.a.J(th);
                            this.iGr.terminateAndDrain(th);
                            return false;
                        }
                    }
                    if (!z) {
                        return false;
                    }
                }
            } while (!this.iGp.compareAndSet(j, j - 1));
            return true;
        }

        protected rx.f cdJ() {
            return this.iGr;
        }
    }
}
