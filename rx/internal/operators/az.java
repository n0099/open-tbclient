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
    private final Long ixs;
    private final rx.functions.a ixt;
    private final a.d ixu;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class b {
        static final az<?> ixz = new az<>();
    }

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public static <T> az<T> cci() {
        return (az<T>) b.ixz;
    }

    az() {
        this.ixs = null;
        this.ixt = null;
        this.ixu = rx.a.irI;
    }

    public az(long j) {
        this(j, null, rx.a.irI);
    }

    public az(long j, rx.functions.a aVar) {
        this(j, aVar, rx.a.irI);
    }

    public az(long j, rx.functions.a aVar, a.d dVar) {
        if (j <= 0) {
            throw new IllegalArgumentException("Buffer capacity must be > 0");
        }
        if (dVar == null) {
            throw new NullPointerException("The BackpressureOverflow strategy must not be null");
        }
        this.ixs = Long.valueOf(j);
        this.ixt = aVar;
        this.ixu = dVar;
    }

    public rx.j<? super T> call(rx.j<? super T> jVar) {
        a aVar = new a(jVar, this.ixs, this.ixt, this.ixu);
        jVar.add(aVar);
        jVar.setProducer(aVar.cck());
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a<T> extends rx.j<T> implements BackpressureDrainManager.a {
        private final rx.j<? super T> child;
        private final rx.functions.a ixt;
        private final a.d ixu;
        private final AtomicLong ixw;
        private final BackpressureDrainManager ixy;
        private final ConcurrentLinkedQueue<Object> ixv = new ConcurrentLinkedQueue<>();
        private final AtomicBoolean ixx = new AtomicBoolean(false);

        public a(rx.j<? super T> jVar, Long l, rx.functions.a aVar, a.d dVar) {
            this.child = jVar;
            this.ixw = l != null ? new AtomicLong(l.longValue()) : null;
            this.ixt = aVar;
            this.ixy = new BackpressureDrainManager(this);
            this.ixu = dVar;
        }

        @Override // rx.j
        public void onStart() {
            request(Long.MAX_VALUE);
        }

        @Override // rx.e
        public void onCompleted() {
            if (!this.ixx.get()) {
                this.ixy.terminateAndDrain();
            }
        }

        @Override // rx.e
        public void onError(Throwable th) {
            if (!this.ixx.get()) {
                this.ixy.terminateAndDrain(th);
            }
        }

        @Override // rx.e
        public void onNext(T t) {
            if (ccj()) {
                this.ixv.offer(NotificationLite.aY(t));
                this.ixy.drain();
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
            return this.ixv.peek();
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public Object poll() {
            Object poll = this.ixv.poll();
            if (this.ixw != null && poll != null) {
                this.ixw.incrementAndGet();
            }
            return poll;
        }

        private boolean ccj() {
            long j;
            boolean z;
            if (this.ixw == null) {
                return true;
            }
            do {
                j = this.ixw.get();
                if (j <= 0) {
                    try {
                        z = this.ixu.cbl() && poll() != null;
                    } catch (MissingBackpressureException e) {
                        if (this.ixx.compareAndSet(false, true)) {
                            unsubscribe();
                            this.child.onError(e);
                        }
                        z = false;
                    }
                    if (this.ixt != null) {
                        try {
                            this.ixt.call();
                        } catch (Throwable th) {
                            rx.exceptions.a.J(th);
                            this.ixy.terminateAndDrain(th);
                            return false;
                        }
                    }
                    if (!z) {
                        return false;
                    }
                }
            } while (!this.ixw.compareAndSet(j, j - 1));
            return true;
        }

        protected rx.f cck() {
            return this.ixy;
        }
    }
}
