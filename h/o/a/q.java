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
public class q<T> implements d.b<T, T> {

    /* renamed from: e  reason: collision with root package name */
    public final Long f68799e = null;

    /* renamed from: f  reason: collision with root package name */
    public final h.n.a f68800f = null;

    /* renamed from: g  reason: collision with root package name */
    public final a.d f68801g = h.a.f68667b;

    /* loaded from: classes7.dex */
    public static final class a<T> extends h.j<T> implements BackpressureDrainManager.a {

        /* renamed from: f  reason: collision with root package name */
        public final AtomicLong f68803f;

        /* renamed from: g  reason: collision with root package name */
        public final h.j<? super T> f68804g;
        public final BackpressureDrainManager i;
        public final h.n.a j;
        public final a.d k;

        /* renamed from: e  reason: collision with root package name */
        public final ConcurrentLinkedQueue<Object> f68802e = new ConcurrentLinkedQueue<>();

        /* renamed from: h  reason: collision with root package name */
        public final AtomicBoolean f68805h = new AtomicBoolean(false);

        public a(h.j<? super T> jVar, Long l, h.n.a aVar, a.d dVar) {
            this.f68804g = jVar;
            this.f68803f = l != null ? new AtomicLong(l.longValue()) : null;
            this.j = aVar;
            this.i = new BackpressureDrainManager(this);
            this.k = dVar;
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public void a(Throwable th) {
            if (th != null) {
                this.f68804g.onError(th);
            } else {
                this.f68804g.onCompleted();
            }
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public boolean accept(Object obj) {
            return NotificationLite.a(this.f68804g, obj);
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
            if (this.f68803f == null) {
                return true;
            }
            do {
                j = this.f68803f.get();
                if (j <= 0) {
                    try {
                    } catch (MissingBackpressureException e2) {
                        if (this.f68805h.compareAndSet(false, true)) {
                            unsubscribe();
                            this.f68804g.onError(e2);
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
                                this.i.terminateAndDrain(th);
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
            } while (!this.f68803f.compareAndSet(j, j - 1));
            return true;
        }

        public h.f c() {
            return this.i;
        }

        @Override // h.e
        public void onCompleted() {
            if (this.f68805h.get()) {
                return;
            }
            this.i.terminateAndDrain();
        }

        @Override // h.e
        public void onError(Throwable th) {
            if (this.f68805h.get()) {
                return;
            }
            this.i.terminateAndDrain(th);
        }

        @Override // h.e
        public void onNext(T t) {
            if (b()) {
                this.f68802e.offer(NotificationLite.h(t));
                this.i.drain();
            }
        }

        @Override // h.j
        public void onStart() {
            request(Long.MAX_VALUE);
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public Object peek() {
            return this.f68802e.peek();
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public Object poll() {
            Object poll = this.f68802e.poll();
            AtomicLong atomicLong = this.f68803f;
            if (atomicLong != null && poll != null) {
                atomicLong.incrementAndGet();
            }
            return poll;
        }
    }

    /* loaded from: classes7.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public static final q<?> f68806a = new q<>();
    }

    public static <T> q<T> b() {
        return (q<T>) b.f68806a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.f
    /* renamed from: a */
    public h.j<? super T> call(h.j<? super T> jVar) {
        a aVar = new a(jVar, this.f68799e, this.f68800f, this.f68801g);
        jVar.add(aVar);
        jVar.setProducer(aVar.c());
        return aVar;
    }
}
