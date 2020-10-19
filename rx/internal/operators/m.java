package rx.internal.operators;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import rx.a;
import rx.d;
import rx.exceptions.MissingBackpressureException;
import rx.internal.util.BackpressureDrainManager;
/* loaded from: classes16.dex */
public class m<T> implements d.b<T, T> {
    private final Long pfr = null;
    private final rx.functions.a pfs = null;
    private final a.d pft = rx.a.pcp;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public static final class b {
        static final m<?> pfy = new m<>();
    }

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public static <T> m<T> esb() {
        return (m<T>) b.pfy;
    }

    m() {
    }

    public rx.j<? super T> call(rx.j<? super T> jVar) {
        a aVar = new a(jVar, this.pfr, this.pfs, this.pft);
        jVar.add(aVar);
        jVar.setProducer(aVar.esd());
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public static final class a<T> extends rx.j<T> implements BackpressureDrainManager.a {
        private final rx.j<? super T> child;
        private final rx.functions.a pfs;
        private final a.d pft;
        private final AtomicLong pfv;
        private final BackpressureDrainManager pfx;
        private final ConcurrentLinkedQueue<Object> pfu = new ConcurrentLinkedQueue<>();
        private final AtomicBoolean pfw = new AtomicBoolean(false);

        public a(rx.j<? super T> jVar, Long l, rx.functions.a aVar, a.d dVar) {
            this.child = jVar;
            this.pfv = l != null ? new AtomicLong(l.longValue()) : null;
            this.pfs = aVar;
            this.pfx = new BackpressureDrainManager(this);
            this.pft = dVar;
        }

        @Override // rx.j
        public void onStart() {
            request(Long.MAX_VALUE);
        }

        @Override // rx.e
        public void onCompleted() {
            if (!this.pfw.get()) {
                this.pfx.terminateAndDrain();
            }
        }

        @Override // rx.e
        public void onError(Throwable th) {
            if (!this.pfw.get()) {
                this.pfx.terminateAndDrain(th);
            }
        }

        @Override // rx.e
        public void onNext(T t) {
            if (esc()) {
                this.pfu.offer(NotificationLite.next(t));
                this.pfx.drain();
            }
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public boolean cf(Object obj) {
            return NotificationLite.a(this.child, obj);
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public void W(Throwable th) {
            if (th != null) {
                this.child.onError(th);
            } else {
                this.child.onCompleted();
            }
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public Object peek() {
            return this.pfu.peek();
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public Object poll() {
            Object poll = this.pfu.poll();
            if (this.pfv != null && poll != null) {
                this.pfv.incrementAndGet();
            }
            return poll;
        }

        private boolean esc() {
            long j;
            boolean z;
            if (this.pfv == null) {
                return true;
            }
            do {
                j = this.pfv.get();
                if (j <= 0) {
                    try {
                        z = this.pft.ert() && poll() != null;
                    } catch (MissingBackpressureException e) {
                        if (this.pfw.compareAndSet(false, true)) {
                            unsubscribe();
                            this.child.onError(e);
                        }
                        z = false;
                    }
                    if (this.pfs != null) {
                        try {
                            this.pfs.call();
                        } catch (Throwable th) {
                            rx.exceptions.a.J(th);
                            this.pfx.terminateAndDrain(th);
                            return false;
                        }
                    }
                    if (!z) {
                        return false;
                    }
                }
            } while (!this.pfv.compareAndSet(j, j - 1));
            return true;
        }

        protected rx.f esd() {
            return this.pfx;
        }
    }
}
