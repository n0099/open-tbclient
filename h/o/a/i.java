package h.o.a;

import h.d;
import h.g;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import rx.Notification;
import rx.schedulers.Schedulers;
/* loaded from: classes7.dex */
public final class i<T> implements d.a<T> {
    public static final h.n.f<h.d<? extends Notification<?>>, h.d<?>> j = new a();

    /* renamed from: e  reason: collision with root package name */
    public final h.d<T> f67744e;

    /* renamed from: f  reason: collision with root package name */
    public final h.n.f<? super h.d<? extends Notification<?>>, ? extends h.d<?>> f67745f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f67746g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f67747h;

    /* renamed from: i  reason: collision with root package name */
    public final h.g f67748i;

    /* loaded from: classes7.dex */
    public static class a implements h.n.f<h.d<? extends Notification<?>>, h.d<?>> {

        /* renamed from: h.o.a.i$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C1855a implements h.n.f<Notification<?>, Notification<?>> {
            public C1855a(a aVar) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // h.n.f
            /* renamed from: a */
            public Notification<?> call(Notification<?> notification) {
                return Notification.c(null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: h.d<R>, h.d<?> */
        @Override // h.n.f
        /* renamed from: a */
        public h.d<?> call(h.d<? extends Notification<?>> dVar) {
            return dVar.k(new C1855a(this));
        }
    }

    /* loaded from: classes7.dex */
    public class b implements h.n.a {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h.j f67749e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ h.t.d f67750f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ h.o.b.a f67751g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ AtomicLong f67752h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ h.u.d f67753i;

        /* loaded from: classes7.dex */
        public class a extends h.j<T> {

            /* renamed from: e  reason: collision with root package name */
            public boolean f67754e;

            public a() {
            }

            public final void b() {
                long j;
                do {
                    j = b.this.f67752h.get();
                    if (j == Long.MAX_VALUE) {
                        return;
                    }
                } while (!b.this.f67752h.compareAndSet(j, j - 1));
            }

            @Override // h.e
            public void onCompleted() {
                if (this.f67754e) {
                    return;
                }
                this.f67754e = true;
                unsubscribe();
                b.this.f67750f.onNext(Notification.a());
            }

            @Override // h.e
            public void onError(Throwable th) {
                if (this.f67754e) {
                    return;
                }
                this.f67754e = true;
                unsubscribe();
                b.this.f67750f.onNext(Notification.b(th));
            }

            @Override // h.e
            public void onNext(T t) {
                if (this.f67754e) {
                    return;
                }
                b.this.f67749e.onNext(t);
                b();
                b.this.f67751g.b(1L);
            }

            @Override // h.j
            public void setProducer(h.f fVar) {
                b.this.f67751g.c(fVar);
            }
        }

        public b(h.j jVar, h.t.d dVar, h.o.b.a aVar, AtomicLong atomicLong, h.u.d dVar2) {
            this.f67749e = jVar;
            this.f67750f = dVar;
            this.f67751g = aVar;
            this.f67752h = atomicLong;
            this.f67753i = dVar2;
        }

        @Override // h.n.a
        public void call() {
            if (this.f67749e.isUnsubscribed()) {
                return;
            }
            a aVar = new a();
            this.f67753i.a(aVar);
            i.this.f67744e.I(aVar);
        }
    }

    /* loaded from: classes7.dex */
    public class c implements d.b<Notification<?>, Notification<?>> {

        /* loaded from: classes7.dex */
        public class a extends h.j<Notification<?>> {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ h.j f67757e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(h.j jVar, h.j jVar2) {
                super(jVar);
                this.f67757e = jVar2;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // h.e
            /* renamed from: b */
            public void onNext(Notification<?> notification) {
                if (notification.i() && i.this.f67746g) {
                    this.f67757e.onCompleted();
                } else if (notification.j() && i.this.f67747h) {
                    this.f67757e.onError(notification.e());
                } else {
                    this.f67757e.onNext(notification);
                }
            }

            @Override // h.e
            public void onCompleted() {
                this.f67757e.onCompleted();
            }

            @Override // h.e
            public void onError(Throwable th) {
                this.f67757e.onError(th);
            }

            @Override // h.j
            public void setProducer(h.f fVar) {
                fVar.request(Long.MAX_VALUE);
            }
        }

        public c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.f
        /* renamed from: a */
        public h.j<? super Notification<?>> call(h.j<? super Notification<?>> jVar) {
            return new a(jVar, jVar);
        }
    }

    /* loaded from: classes7.dex */
    public class d implements h.n.a {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h.d f67759e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ h.j f67760f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ AtomicLong f67761g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ g.a f67762h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ h.n.a f67763i;
        public final /* synthetic */ AtomicBoolean j;

        /* loaded from: classes7.dex */
        public class a extends h.j<Object> {
            public a(h.j jVar) {
                super(jVar);
            }

            @Override // h.e
            public void onCompleted() {
                d.this.f67760f.onCompleted();
            }

            @Override // h.e
            public void onError(Throwable th) {
                d.this.f67760f.onError(th);
            }

            @Override // h.e
            public void onNext(Object obj) {
                if (d.this.f67760f.isUnsubscribed()) {
                    return;
                }
                if (d.this.f67761g.get() > 0) {
                    d dVar = d.this;
                    dVar.f67762h.b(dVar.f67763i);
                    return;
                }
                d.this.j.compareAndSet(false, true);
            }

            @Override // h.j
            public void setProducer(h.f fVar) {
                fVar.request(Long.MAX_VALUE);
            }
        }

        public d(i iVar, h.d dVar, h.j jVar, AtomicLong atomicLong, g.a aVar, h.n.a aVar2, AtomicBoolean atomicBoolean) {
            this.f67759e = dVar;
            this.f67760f = jVar;
            this.f67761g = atomicLong;
            this.f67762h = aVar;
            this.f67763i = aVar2;
            this.j = atomicBoolean;
        }

        @Override // h.n.a
        public void call() {
            this.f67759e.I(new a(this.f67760f));
        }
    }

    /* loaded from: classes7.dex */
    public class e implements h.f {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AtomicLong f67765e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ h.o.b.a f67766f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f67767g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ g.a f67768h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ h.n.a f67769i;

        public e(i iVar, AtomicLong atomicLong, h.o.b.a aVar, AtomicBoolean atomicBoolean, g.a aVar2, h.n.a aVar3) {
            this.f67765e = atomicLong;
            this.f67766f = aVar;
            this.f67767g = atomicBoolean;
            this.f67768h = aVar2;
            this.f67769i = aVar3;
        }

        @Override // h.f
        public void request(long j) {
            if (j > 0) {
                h.o.a.a.b(this.f67765e, j);
                this.f67766f.request(j);
                if (this.f67767g.compareAndSet(true, false)) {
                    this.f67768h.b(this.f67769i);
                }
            }
        }
    }

    public i(h.d<T> dVar, h.n.f<? super h.d<? extends Notification<?>>, ? extends h.d<?>> fVar, boolean z, boolean z2, h.g gVar) {
        this.f67744e = dVar;
        this.f67745f = fVar;
        this.f67746g = z;
        this.f67747h = z2;
        this.f67748i = gVar;
    }

    public static <T> h.d<T> b(h.d<T> dVar) {
        return c(dVar, j);
    }

    public static <T> h.d<T> c(h.d<T> dVar, h.n.f<? super h.d<? extends Notification<?>>, ? extends h.d<?>> fVar) {
        return h.d.b(new i(dVar, fVar, true, false, Schedulers.trampoline()));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.b
    /* renamed from: a */
    public void call(h.j<? super T> jVar) {
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        AtomicLong atomicLong = new AtomicLong();
        g.a createWorker = this.f67748i.createWorker();
        jVar.add(createWorker);
        h.u.d dVar = new h.u.d();
        jVar.add(dVar);
        h.t.c<T, T> J = h.t.a.K().J();
        J.z(h.q.f.a());
        h.o.b.a aVar = new h.o.b.a();
        b bVar = new b(jVar, J, aVar, atomicLong, dVar);
        createWorker.b(new d(this, this.f67745f.call(J.j(new c())), jVar, atomicLong, createWorker, bVar, atomicBoolean));
        jVar.setProducer(new e(this, atomicLong, aVar, atomicBoolean, createWorker, bVar));
    }
}
