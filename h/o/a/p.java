package h.o.a;

import h.a;
import h.d;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import rx.exceptions.MissingBackpressureException;
import rx.internal.operators.NotificationLite;
import rx.internal.util.BackpressureDrainManager;
/* loaded from: classes7.dex */
public class p<T> implements d.b<T, T> {

    /* renamed from: e  reason: collision with root package name */
    public final Long f68518e = null;

    /* renamed from: f  reason: collision with root package name */
    public final h.n.a f68519f = null;

    /* renamed from: g  reason: collision with root package name */
    public final a.d f68520g = h.a.f68406b;

    /* loaded from: classes7.dex */
    public static final class a<T> extends h.j<T> implements BackpressureDrainManager.a {

        /* renamed from: f  reason: collision with root package name */
        public final AtomicLong f68522f;

        /* renamed from: g  reason: collision with root package name */
        public final h.j<? super T> f68523g;

        /* renamed from: i  reason: collision with root package name */
        public final BackpressureDrainManager f68525i;
        public final h.n.a j;
        public final a.d k;

        /* renamed from: e  reason: collision with root package name */
        public final ConcurrentLinkedQueue<Object> f68521e = new ConcurrentLinkedQueue<>();

        /* renamed from: h  reason: collision with root package name */
        public final AtomicBoolean f68524h = new AtomicBoolean(false);

        public a(h.j<? super T> jVar, Long l, h.n.a aVar, a.d dVar) {
            this.f68523g = jVar;
            this.f68522f = l != null ? new AtomicLong(l.longValue()) : null;
            this.j = aVar;
            this.f68525i = new BackpressureDrainManager(this);
            this.k = dVar;
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public void a(Throwable th) {
            if (th != null) {
                this.f68523g.onError(th);
            } else {
                this.f68523g.onCompleted();
            }
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public boolean accept(Object obj) {
            return NotificationLite.a(this.f68523g, obj);
        }

        /* JADX WARN: Removed duplicated region for block: B:32:0x0039 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:34:0x0049 A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final boolean b() {
            long j;
            boolean z;
            h.n.a aVar;
            if (this.f68522f == null) {
                return true;
            }
            do {
                j = this.f68522f.get();
                if (j <= 0) {
                    try {
                    } catch (MissingBackpressureException e2) {
                        if (this.f68524h.compareAndSet(false, true)) {
                            unsubscribe();
                            this.f68523g.onError(e2);
                        }
                    }
                    if (this.k.a() && poll() != null) {
                        z = true;
                        aVar = this.j;
                        if (aVar != null) {
                            try {
                                aVar.call();
                            } catch (Throwable th) {
                                h.m.a.e(th);
                                this.f68525i.terminateAndDrain(th);
                                return false;
                            }
                        }
                        if (!z) {
                            return false;
                        }
                    }
                    z = false;
                    aVar = this.j;
                    if (aVar != null) {
                    }
                    if (!z) {
                    }
                }
            } while (!this.f68522f.compareAndSet(j, j - 1));
            return true;
        }

        public h.f c() {
            return this.f68525i;
        }

        @Override // h.e
        public void onCompleted() {
            if (this.f68524h.get()) {
                return;
            }
            this.f68525i.terminateAndDrain();
        }

        @Override // h.e
        public void onError(Throwable th) {
            if (this.f68524h.get()) {
                return;
            }
            this.f68525i.terminateAndDrain(th);
        }

        @Override // h.e
        public void onNext(T t) {
            if (b()) {
                this.f68521e.offer(NotificationLite.h(t));
                this.f68525i.drain();
            }
        }

        @Override // h.j
        public void onStart() {
            request(Long.MAX_VALUE);
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public Object peek() {
            return this.f68521e.peek();
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public Object poll() {
            Object poll = this.f68521e.poll();
            AtomicLong atomicLong = this.f68522f;
            if (atomicLong != null && poll != null) {
                atomicLong.incrementAndGet();
            }
            return poll;
        }
    }

    /* loaded from: classes7.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public static final p<?> f68526a = new p<>();
    }

    public static <T> p<T> b() {
        return (p<T>) b.f68526a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.f
    /* renamed from: a */
    public h.j<? super T> call(h.j<? super T> jVar) {
        a aVar = new a(jVar, this.f68518e, this.f68519f, this.f68520g);
        jVar.add(aVar);
        jVar.setProducer(aVar.c());
        return aVar;
    }
}
