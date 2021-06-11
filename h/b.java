package h;

import h.g;
import rx.internal.operators.CompletableOnSubscribeConcatIterable;
/* loaded from: classes8.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final f f71666a;

    /* loaded from: classes8.dex */
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
    /* loaded from: classes8.dex */
    public class C1967b implements f {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f71667e;

        /* renamed from: h.b$b$a */
        /* loaded from: classes8.dex */
        public class a implements h.c {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ g.a f71669e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ h.c f71670f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ h.o.d.h f71671g;

            /* renamed from: h.b$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public class C1968a implements h.n.a {
                public C1968a() {
                }

                @Override // h.n.a
                public void call() {
                    try {
                        a.this.f71670f.onCompleted();
                    } finally {
                        a.this.f71671g.unsubscribe();
                    }
                }
            }

            /* renamed from: h.b$b$a$b  reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public class C1969b implements h.n.a {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f71673e;

                public C1969b(Throwable th) {
                    this.f71673e = th;
                }

                @Override // h.n.a
                public void call() {
                    try {
                        a.this.f71670f.onError(this.f71673e);
                    } finally {
                        a.this.f71671g.unsubscribe();
                    }
                }
            }

            public a(C1967b c1967b, g.a aVar, h.c cVar, h.o.d.h hVar) {
                this.f71669e = aVar;
                this.f71670f = cVar;
                this.f71671g = hVar;
            }

            @Override // h.c
            public void onCompleted() {
                this.f71669e.b(new C1968a());
            }

            @Override // h.c
            public void onError(Throwable th) {
                this.f71669e.b(new C1969b(th));
            }

            @Override // h.c
            public void onSubscribe(k kVar) {
                this.f71671g.a(kVar);
            }
        }

        public C1967b(g gVar) {
            this.f71667e = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(h.c cVar) {
            h.o.d.h hVar = new h.o.d.h();
            g.a createWorker = this.f71667e.createWorker();
            hVar.a(createWorker);
            cVar.onSubscribe(hVar);
            b.this.j(new a(this, createWorker, cVar, hVar));
        }
    }

    /* loaded from: classes8.dex */
    public class c implements h.c {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h.u.c f71675e;

        public c(b bVar, h.u.c cVar) {
            this.f71675e = cVar;
        }

        @Override // h.c
        public void onCompleted() {
            this.f71675e.unsubscribe();
        }

        @Override // h.c
        public void onError(Throwable th) {
            h.r.c.j(th);
            this.f71675e.unsubscribe();
            b.c(th);
        }

        @Override // h.c
        public void onSubscribe(k kVar) {
            this.f71675e.a(kVar);
        }
    }

    /* loaded from: classes8.dex */
    public static class d implements f {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(h.c cVar) {
            cVar.onSubscribe(h.u.e.c());
        }
    }

    /* loaded from: classes8.dex */
    public class e implements f {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f71676e;

        /* loaded from: classes8.dex */
        public class a implements h.n.a {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ h.c f71678e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ g.a f71679f;

            public a(h.c cVar, g.a aVar) {
                this.f71678e = cVar;
                this.f71679f = aVar;
            }

            @Override // h.n.a
            public void call() {
                try {
                    b.this.j(this.f71678e);
                } finally {
                    this.f71679f.unsubscribe();
                }
            }
        }

        public e(g gVar) {
            this.f71676e = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(h.c cVar) {
            g.a createWorker = this.f71676e.createWorker();
            createWorker.b(new a(cVar, createWorker));
        }
    }

    /* loaded from: classes8.dex */
    public interface f extends h.n.b<h.c> {
    }

    static {
        new b(new a(), false);
        new b(new d(), false);
    }

    public b(f fVar) {
        this.f71666a = h.r.c.g(fVar);
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
        return b(new C1967b(gVar));
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
            h.r.c.e(this, this.f71666a).call(cVar);
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
        this.f71666a = z ? h.r.c.g(fVar) : fVar;
    }
}
