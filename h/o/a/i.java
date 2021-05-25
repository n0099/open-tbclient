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
    public final h.d<T> f68467e;

    /* renamed from: f  reason: collision with root package name */
    public final h.n.f<? super h.d<? extends Notification<?>>, ? extends h.d<?>> f68468f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f68469g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f68470h;

    /* renamed from: i  reason: collision with root package name */
    public final h.g f68471i;

    /* loaded from: classes7.dex */
    public static class a implements h.n.f<h.d<? extends Notification<?>>, h.d<?>> {

        /* renamed from: h.o.a.i$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C1922a implements h.n.f<Notification<?>, Notification<?>> {
            public C1922a(a aVar) {
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
            return dVar.k(new C1922a(this));
        }
    }

    /* loaded from: classes7.dex */
    public class b implements h.n.a {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h.j f68472e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ h.t.d f68473f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ h.o.b.a f68474g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ AtomicLong f68475h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ h.u.d f68476i;

        /* loaded from: classes7.dex */
        public class a extends h.j<T> {

            /* renamed from: e  reason: collision with root package name */
            public boolean f68477e;

            public a() {
            }

            public final void b() {
                long j;
                do {
                    j = b.this.f68475h.get();
                    if (j == Long.MAX_VALUE) {
                        return;
                    }
                } while (!b.this.f68475h.compareAndSet(j, j - 1));
            }

            @Override // h.e
            public void onCompleted() {
                if (this.f68477e) {
                    return;
                }
                this.f68477e = true;
                unsubscribe();
                b.this.f68473f.onNext(Notification.a());
            }

            @Override // h.e
            public void onError(Throwable th) {
                if (this.f68477e) {
                    return;
                }
                this.f68477e = true;
                unsubscribe();
                b.this.f68473f.onNext(Notification.b(th));
            }

            @Override // h.e
            public void onNext(T t) {
                if (this.f68477e) {
                    return;
                }
                b.this.f68472e.onNext(t);
                b();
                b.this.f68474g.b(1L);
            }

            @Override // h.j
            public void setProducer(h.f fVar) {
                b.this.f68474g.c(fVar);
            }
        }

        public b(h.j jVar, h.t.d dVar, h.o.b.a aVar, AtomicLong atomicLong, h.u.d dVar2) {
            this.f68472e = jVar;
            this.f68473f = dVar;
            this.f68474g = aVar;
            this.f68475h = atomicLong;
            this.f68476i = dVar2;
        }

        @Override // h.n.a
        public void call() {
            if (this.f68472e.isUnsubscribed()) {
                return;
            }
            a aVar = new a();
            this.f68476i.a(aVar);
            i.this.f68467e.I(aVar);
        }
    }

    /* loaded from: classes7.dex */
    public class c implements d.b<Notification<?>, Notification<?>> {

        /* loaded from: classes7.dex */
        public class a extends h.j<Notification<?>> {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ h.j f68480e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(h.j jVar, h.j jVar2) {
                super(jVar);
                this.f68480e = jVar2;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // h.e
            /* renamed from: b */
            public void onNext(Notification<?> notification) {
                if (notification.i() && i.this.f68469g) {
                    this.f68480e.onCompleted();
                } else if (notification.j() && i.this.f68470h) {
                    this.f68480e.onError(notification.e());
                } else {
                    this.f68480e.onNext(notification);
                }
            }

            @Override // h.e
            public void onCompleted() {
                this.f68480e.onCompleted();
            }

            @Override // h.e
            public void onError(Throwable th) {
                this.f68480e.onError(th);
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
        public final /* synthetic */ h.d f68482e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ h.j f68483f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ AtomicLong f68484g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ g.a f68485h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ h.n.a f68486i;
        public final /* synthetic */ AtomicBoolean j;

        /* loaded from: classes7.dex */
        public class a extends h.j<Object> {
            public a(h.j jVar) {
                super(jVar);
            }

            @Override // h.e
            public void onCompleted() {
                d.this.f68483f.onCompleted();
            }

            @Override // h.e
            public void onError(Throwable th) {
                d.this.f68483f.onError(th);
            }

            @Override // h.e
            public void onNext(Object obj) {
                if (d.this.f68483f.isUnsubscribed()) {
                    return;
                }
                if (d.this.f68484g.get() > 0) {
                    d dVar = d.this;
                    dVar.f68485h.b(dVar.f68486i);
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
            this.f68482e = dVar;
            this.f68483f = jVar;
            this.f68484g = atomicLong;
            this.f68485h = aVar;
            this.f68486i = aVar2;
            this.j = atomicBoolean;
        }

        @Override // h.n.a
        public void call() {
            this.f68482e.I(new a(this.f68483f));
        }
    }

    /* loaded from: classes7.dex */
    public class e implements h.f {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AtomicLong f68488e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ h.o.b.a f68489f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f68490g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ g.a f68491h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ h.n.a f68492i;

        public e(i iVar, AtomicLong atomicLong, h.o.b.a aVar, AtomicBoolean atomicBoolean, g.a aVar2, h.n.a aVar3) {
            this.f68488e = atomicLong;
            this.f68489f = aVar;
            this.f68490g = atomicBoolean;
            this.f68491h = aVar2;
            this.f68492i = aVar3;
        }

        @Override // h.f
        public void request(long j) {
            if (j > 0) {
                h.o.a.a.b(this.f68488e, j);
                this.f68489f.request(j);
                if (this.f68490g.compareAndSet(true, false)) {
                    this.f68491h.b(this.f68492i);
                }
            }
        }
    }

    public i(h.d<T> dVar, h.n.f<? super h.d<? extends Notification<?>>, ? extends h.d<?>> fVar, boolean z, boolean z2, h.g gVar) {
        this.f68467e = dVar;
        this.f68468f = fVar;
        this.f68469g = z;
        this.f68470h = z2;
        this.f68471i = gVar;
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
        g.a createWorker = this.f68471i.createWorker();
        jVar.add(createWorker);
        h.u.d dVar = new h.u.d();
        jVar.add(dVar);
        h.t.c<T, T> J = h.t.a.K().J();
        J.z(h.q.f.a());
        h.o.b.a aVar = new h.o.b.a();
        b bVar = new b(jVar, J, aVar, atomicLong, dVar);
        createWorker.b(new d(this, this.f68468f.call(J.j(new c())), jVar, atomicLong, createWorker, bVar, atomicBoolean));
        jVar.setProducer(new e(this, atomicLong, aVar, atomicBoolean, createWorker, bVar));
    }
}
