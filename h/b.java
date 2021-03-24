package h;

import h.g;
import rx.internal.operators.CompletableOnSubscribeConcatIterable;
/* loaded from: classes7.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final f f67660a;

    /* loaded from: classes7.dex */
    public static class a implements f {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(h.c cVar) {
            cVar.onSubscribe(h.u.e.c());
            cVar.onCompleted();
        }
    }

    /* renamed from: h.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1863b implements f {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f67661e;

        /* renamed from: h.b$b$a */
        /* loaded from: classes7.dex */
        public class a implements h.c {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ g.a f67663e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ h.c f67664f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ h.o.d.i f67665g;

            /* renamed from: h.b$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes7.dex */
            public class C1864a implements h.n.a {
                public C1864a() {
                }

                @Override // h.n.a
                public void call() {
                    try {
                        a.this.f67664f.onCompleted();
                    } finally {
                        a.this.f67665g.unsubscribe();
                    }
                }
            }

            /* renamed from: h.b$b$a$b  reason: collision with other inner class name */
            /* loaded from: classes7.dex */
            public class C1865b implements h.n.a {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f67667e;

                public C1865b(Throwable th) {
                    this.f67667e = th;
                }

                @Override // h.n.a
                public void call() {
                    try {
                        a.this.f67664f.onError(this.f67667e);
                    } finally {
                        a.this.f67665g.unsubscribe();
                    }
                }
            }

            public a(C1863b c1863b, g.a aVar, h.c cVar, h.o.d.i iVar) {
                this.f67663e = aVar;
                this.f67664f = cVar;
                this.f67665g = iVar;
            }

            @Override // h.c
            public void onCompleted() {
                this.f67663e.b(new C1864a());
            }

            @Override // h.c
            public void onError(Throwable th) {
                this.f67663e.b(new C1865b(th));
            }

            @Override // h.c
            public void onSubscribe(k kVar) {
                this.f67665g.a(kVar);
            }
        }

        public C1863b(g gVar) {
            this.f67661e = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(h.c cVar) {
            h.o.d.i iVar = new h.o.d.i();
            g.a createWorker = this.f67661e.createWorker();
            iVar.a(createWorker);
            cVar.onSubscribe(iVar);
            b.this.j(new a(this, createWorker, cVar, iVar));
        }
    }

    /* loaded from: classes7.dex */
    public class c implements h.c {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h.u.c f67669e;

        public c(b bVar, h.u.c cVar) {
            this.f67669e = cVar;
        }

        @Override // h.c
        public void onCompleted() {
            this.f67669e.unsubscribe();
        }

        @Override // h.c
        public void onError(Throwable th) {
            h.r.c.j(th);
            this.f67669e.unsubscribe();
            b.c(th);
        }

        @Override // h.c
        public void onSubscribe(k kVar) {
            this.f67669e.a(kVar);
        }
    }

    /* loaded from: classes7.dex */
    public static class d implements f {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(h.c cVar) {
            cVar.onSubscribe(h.u.e.c());
        }
    }

    /* loaded from: classes7.dex */
    public class e implements f {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f67670e;

        /* loaded from: classes7.dex */
        public class a implements h.n.a {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ h.c f67672e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ g.a f67673f;

            public a(h.c cVar, g.a aVar) {
                this.f67672e = cVar;
                this.f67673f = aVar;
            }

            @Override // h.n.a
            public void call() {
                try {
                    b.this.j(this.f67672e);
                } finally {
                    this.f67673f.unsubscribe();
                }
            }
        }

        public e(g gVar) {
            this.f67670e = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(h.c cVar) {
            g.a createWorker = this.f67670e.createWorker();
            createWorker.b(new a(cVar, createWorker));
        }
    }

    /* loaded from: classes7.dex */
    public interface f extends h.n.b<h.c> {
    }

    static {
        new b(new a(), false);
        new b(new d(), false);
    }

    public b(f fVar) {
        this.f67660a = h.r.c.g(fVar);
    }

    public static b a(Iterable<? extends b> iterable) {
        e(iterable);
        return b(new CompletableOnSubscribeConcatIterable(iterable));
    }

    public static b b(f fVar) {
        e(fVar);
        try {
            return new b(fVar);
        } catch (NullPointerException e2) {
            throw e2;
        } catch (Throwable th) {
            h.r.c.j(th);
            throw i(th);
        }
    }

    public static void c(Throwable th) {
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }

    public static <T> T e(T t) {
        if (t != null) {
            return t;
        }
        throw null;
    }

    public static NullPointerException i(Throwable th) {
        NullPointerException nullPointerException = new NullPointerException("Actually not, but can't pass out an exception otherwise...");
        nullPointerException.initCause(th);
        return nullPointerException;
    }

    public final b d(g gVar) {
        e(gVar);
        return b(new C1863b(gVar));
    }

    public final k f() {
        h.u.c cVar = new h.u.c();
        j(new c(this, cVar));
        return cVar;
    }

    public final void g(h.c cVar) {
        if (!(cVar instanceof h.q.b)) {
            cVar = new h.q.b(cVar);
        }
        j(cVar);
    }

    public final b h(g gVar) {
        e(gVar);
        return b(new e(gVar));
    }

    public final void j(h.c cVar) {
        e(cVar);
        try {
            h.r.c.e(this, this.f67660a).call(cVar);
        } catch (NullPointerException e2) {
            throw e2;
        } catch (Throwable th) {
            h.m.a.e(th);
            Throwable d2 = h.r.c.d(th);
            h.r.c.j(d2);
            throw i(d2);
        }
    }

    public b(f fVar, boolean z) {
        this.f67660a = z ? h.r.c.g(fVar) : fVar;
    }
}
