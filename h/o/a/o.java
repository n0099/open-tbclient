package h.o.a;

import h.d;
import h.g;
import h.o.d.k.f0;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import rx.exceptions.MissingBackpressureException;
import rx.internal.operators.NotificationLite;
/* loaded from: classes7.dex */
public final class o<T> implements d.b<T, T> {

    /* renamed from: e  reason: collision with root package name */
    public final h.g f67775e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f67776f;

    /* renamed from: g  reason: collision with root package name */
    public final int f67777g;

    /* loaded from: classes7.dex */
    public static final class a<T> extends h.j<T> implements h.n.a {

        /* renamed from: e  reason: collision with root package name */
        public final h.j<? super T> f67778e;

        /* renamed from: f  reason: collision with root package name */
        public final g.a f67779f;

        /* renamed from: g  reason: collision with root package name */
        public final boolean f67780g;

        /* renamed from: h  reason: collision with root package name */
        public final Queue<Object> f67781h;
        public final int i;
        public volatile boolean j;
        public final AtomicLong k = new AtomicLong();
        public final AtomicLong l = new AtomicLong();
        public Throwable m;
        public long n;

        /* renamed from: h.o.a.o$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C1869a implements h.f {
            public C1869a() {
            }

            @Override // h.f
            public void request(long j) {
                if (j > 0) {
                    h.o.a.a.b(a.this.k, j);
                    a.this.d();
                }
            }
        }

        public a(h.g gVar, h.j<? super T> jVar, boolean z, int i) {
            this.f67778e = jVar;
            this.f67779f = gVar.createWorker();
            this.f67780g = z;
            i = i <= 0 ? h.o.d.g.f67930g : i;
            this.i = i - (i >> 2);
            if (f0.b()) {
                this.f67781h = new h.o.d.k.r(i);
            } else {
                this.f67781h = new h.o.d.j.c(i);
            }
            request(i);
        }

        public boolean b(boolean z, boolean z2, h.j<? super T> jVar, Queue<Object> queue) {
            if (jVar.isUnsubscribed()) {
                queue.clear();
                return true;
            } else if (z) {
                if (this.f67780g) {
                    if (z2) {
                        Throwable th = this.m;
                        try {
                            if (th != null) {
                                jVar.onError(th);
                            } else {
                                jVar.onCompleted();
                            }
                            return false;
                        } finally {
                        }
                    }
                    return false;
                }
                Throwable th2 = this.m;
                if (th2 != null) {
                    queue.clear();
                    try {
                        jVar.onError(th2);
                        return true;
                    } finally {
                    }
                } else if (z2) {
                    try {
                        jVar.onCompleted();
                        return true;
                    } finally {
                    }
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        public void c() {
            h.j<? super T> jVar = this.f67778e;
            jVar.setProducer(new C1869a());
            jVar.add(this.f67779f);
            jVar.add(this);
        }

        @Override // h.n.a
        public void call() {
            long j = this.n;
            Queue<Object> queue = this.f67781h;
            h.j<? super T> jVar = this.f67778e;
            long j2 = 1;
            do {
                long j3 = this.k.get();
                while (j3 != j) {
                    boolean z = this.j;
                    Object poll = queue.poll();
                    boolean z2 = poll == null;
                    if (b(z, z2, jVar, queue)) {
                        return;
                    }
                    if (z2) {
                        break;
                    }
                    jVar.onNext((Object) NotificationLite.d(poll));
                    j++;
                    if (j == this.i) {
                        j3 = h.o.a.a.g(this.k, j);
                        request(j);
                        j = 0;
                    }
                }
                if (j3 == j && b(this.j, queue.isEmpty(), jVar, queue)) {
                    return;
                }
                this.n = j;
                j2 = this.l.addAndGet(-j2);
            } while (j2 != 0);
        }

        public void d() {
            if (this.l.getAndIncrement() == 0) {
                this.f67779f.b(this);
            }
        }

        @Override // h.e
        public void onCompleted() {
            if (isUnsubscribed() || this.j) {
                return;
            }
            this.j = true;
            d();
        }

        @Override // h.e
        public void onError(Throwable th) {
            if (!isUnsubscribed() && !this.j) {
                this.m = th;
                this.j = true;
                d();
                return;
            }
            h.r.c.j(th);
        }

        @Override // h.e
        public void onNext(T t) {
            if (isUnsubscribed() || this.j) {
                return;
            }
            if (!this.f67781h.offer(NotificationLite.g(t))) {
                onError(new MissingBackpressureException());
            } else {
                d();
            }
        }
    }

    public o(h.g gVar, boolean z, int i) {
        this.f67775e = gVar;
        this.f67776f = z;
        this.f67777g = i <= 0 ? h.o.d.g.f67930g : i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.f
    /* renamed from: a */
    public h.j<? super T> call(h.j<? super T> jVar) {
        h.g gVar = this.f67775e;
        if ((gVar instanceof h.o.c.e) || (gVar instanceof h.o.c.j)) {
            return jVar;
        }
        a aVar = new a(gVar, jVar, this.f67776f, this.f67777g);
        aVar.c();
        return aVar;
    }
}
