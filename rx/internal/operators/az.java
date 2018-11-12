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
    private final Long izd;
    private final rx.functions.a ize;
    private final a.d izf;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class b {
        static final az<?> izk = new az<>();
    }

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public static <T> az<T> cbF() {
        return (az<T>) b.izk;
    }

    az() {
        this.izd = null;
        this.ize = null;
        this.izf = rx.a.itt;
    }

    public az(long j) {
        this(j, null, rx.a.itt);
    }

    public az(long j, rx.functions.a aVar) {
        this(j, aVar, rx.a.itt);
    }

    public az(long j, rx.functions.a aVar, a.d dVar) {
        if (j <= 0) {
            throw new IllegalArgumentException("Buffer capacity must be > 0");
        }
        if (dVar == null) {
            throw new NullPointerException("The BackpressureOverflow strategy must not be null");
        }
        this.izd = Long.valueOf(j);
        this.ize = aVar;
        this.izf = dVar;
    }

    public rx.j<? super T> call(rx.j<? super T> jVar) {
        a aVar = new a(jVar, this.izd, this.ize, this.izf);
        jVar.add(aVar);
        jVar.setProducer(aVar.cbH());
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a<T> extends rx.j<T> implements BackpressureDrainManager.a {
        private final rx.j<? super T> child;
        private final rx.functions.a ize;
        private final a.d izf;
        private final AtomicLong izh;
        private final BackpressureDrainManager izj;
        private final ConcurrentLinkedQueue<Object> izg = new ConcurrentLinkedQueue<>();
        private final AtomicBoolean izi = new AtomicBoolean(false);

        public a(rx.j<? super T> jVar, Long l, rx.functions.a aVar, a.d dVar) {
            this.child = jVar;
            this.izh = l != null ? new AtomicLong(l.longValue()) : null;
            this.ize = aVar;
            this.izj = new BackpressureDrainManager(this);
            this.izf = dVar;
        }

        @Override // rx.j
        public void onStart() {
            request(Long.MAX_VALUE);
        }

        @Override // rx.e
        public void onCompleted() {
            if (!this.izi.get()) {
                this.izj.terminateAndDrain();
            }
        }

        @Override // rx.e
        public void onError(Throwable th) {
            if (!this.izi.get()) {
                this.izj.terminateAndDrain(th);
            }
        }

        @Override // rx.e
        public void onNext(T t) {
            if (cbG()) {
                this.izg.offer(NotificationLite.aX(t));
                this.izj.drain();
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
            return this.izg.peek();
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public Object poll() {
            Object poll = this.izg.poll();
            if (this.izh != null && poll != null) {
                this.izh.incrementAndGet();
            }
            return poll;
        }

        private boolean cbG() {
            long j;
            boolean z;
            if (this.izh == null) {
                return true;
            }
            do {
                j = this.izh.get();
                if (j <= 0) {
                    try {
                        z = this.izf.caI() && poll() != null;
                    } catch (MissingBackpressureException e) {
                        if (this.izi.compareAndSet(false, true)) {
                            unsubscribe();
                            this.child.onError(e);
                        }
                        z = false;
                    }
                    if (this.ize != null) {
                        try {
                            this.ize.call();
                        } catch (Throwable th) {
                            rx.exceptions.a.J(th);
                            this.izj.terminateAndDrain(th);
                            return false;
                        }
                    }
                    if (!z) {
                        return false;
                    }
                }
            } while (!this.izh.compareAndSet(j, j - 1));
            return true;
        }

        protected rx.f cbH() {
            return this.izj;
        }
    }
}
