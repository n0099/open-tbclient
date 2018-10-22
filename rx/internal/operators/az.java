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
    private final Long ixt;
    private final rx.functions.a ixu;
    private final a.d ixv;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class b {
        static final az<?> ixA = new az<>();
    }

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public static <T> az<T> cci() {
        return (az<T>) b.ixA;
    }

    az() {
        this.ixt = null;
        this.ixu = null;
        this.ixv = rx.a.irJ;
    }

    public az(long j) {
        this(j, null, rx.a.irJ);
    }

    public az(long j, rx.functions.a aVar) {
        this(j, aVar, rx.a.irJ);
    }

    public az(long j, rx.functions.a aVar, a.d dVar) {
        if (j <= 0) {
            throw new IllegalArgumentException("Buffer capacity must be > 0");
        }
        if (dVar == null) {
            throw new NullPointerException("The BackpressureOverflow strategy must not be null");
        }
        this.ixt = Long.valueOf(j);
        this.ixu = aVar;
        this.ixv = dVar;
    }

    public rx.j<? super T> call(rx.j<? super T> jVar) {
        a aVar = new a(jVar, this.ixt, this.ixu, this.ixv);
        jVar.add(aVar);
        jVar.setProducer(aVar.cck());
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a<T> extends rx.j<T> implements BackpressureDrainManager.a {
        private final rx.j<? super T> child;
        private final rx.functions.a ixu;
        private final a.d ixv;
        private final AtomicLong ixx;
        private final BackpressureDrainManager ixz;
        private final ConcurrentLinkedQueue<Object> ixw = new ConcurrentLinkedQueue<>();
        private final AtomicBoolean ixy = new AtomicBoolean(false);

        public a(rx.j<? super T> jVar, Long l, rx.functions.a aVar, a.d dVar) {
            this.child = jVar;
            this.ixx = l != null ? new AtomicLong(l.longValue()) : null;
            this.ixu = aVar;
            this.ixz = new BackpressureDrainManager(this);
            this.ixv = dVar;
        }

        @Override // rx.j
        public void onStart() {
            request(Long.MAX_VALUE);
        }

        @Override // rx.e
        public void onCompleted() {
            if (!this.ixy.get()) {
                this.ixz.terminateAndDrain();
            }
        }

        @Override // rx.e
        public void onError(Throwable th) {
            if (!this.ixy.get()) {
                this.ixz.terminateAndDrain(th);
            }
        }

        @Override // rx.e
        public void onNext(T t) {
            if (ccj()) {
                this.ixw.offer(NotificationLite.aY(t));
                this.ixz.drain();
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
            return this.ixw.peek();
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public Object poll() {
            Object poll = this.ixw.poll();
            if (this.ixx != null && poll != null) {
                this.ixx.incrementAndGet();
            }
            return poll;
        }

        private boolean ccj() {
            long j;
            boolean z;
            if (this.ixx == null) {
                return true;
            }
            do {
                j = this.ixx.get();
                if (j <= 0) {
                    try {
                        z = this.ixv.cbl() && poll() != null;
                    } catch (MissingBackpressureException e) {
                        if (this.ixy.compareAndSet(false, true)) {
                            unsubscribe();
                            this.child.onError(e);
                        }
                        z = false;
                    }
                    if (this.ixu != null) {
                        try {
                            this.ixu.call();
                        } catch (Throwable th) {
                            rx.exceptions.a.J(th);
                            this.ixz.terminateAndDrain(th);
                            return false;
                        }
                    }
                    if (!z) {
                        return false;
                    }
                }
            } while (!this.ixx.compareAndSet(j, j - 1));
            return true;
        }

        protected rx.f cck() {
            return this.ixz;
        }
    }
}
