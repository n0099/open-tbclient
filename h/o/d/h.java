package h.o.d;

import h.g;
import h.h;
/* loaded from: classes7.dex */
public final class h<T> extends h.h<T> {

    /* renamed from: b  reason: collision with root package name */
    public final T f67933b;

    /* loaded from: classes7.dex */
    public class a implements h.d<T> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Object f67934e;

        public a(Object obj) {
            this.f67934e = obj;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(h.i<? super T> iVar) {
            iVar.c((Object) this.f67934e);
        }
    }

    /* loaded from: classes7.dex */
    public static final class b<T> implements h.d<T> {

        /* renamed from: e  reason: collision with root package name */
        public final h.o.c.b f67935e;

        /* renamed from: f  reason: collision with root package name */
        public final T f67936f;

        public b(h.o.c.b bVar, T t) {
            this.f67935e = bVar;
            this.f67936f = t;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(h.i<? super T> iVar) {
            iVar.a(this.f67935e.a(new d(iVar, this.f67936f)));
        }
    }

    /* loaded from: classes7.dex */
    public static final class c<T> implements h.d<T> {

        /* renamed from: e  reason: collision with root package name */
        public final h.g f67937e;

        /* renamed from: f  reason: collision with root package name */
        public final T f67938f;

        public c(h.g gVar, T t) {
            this.f67937e = gVar;
            this.f67938f = t;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(h.i<? super T> iVar) {
            g.a createWorker = this.f67937e.createWorker();
            iVar.a(createWorker);
            createWorker.b(new d(iVar, this.f67938f));
        }
    }

    /* loaded from: classes7.dex */
    public static final class d<T> implements h.n.a {

        /* renamed from: e  reason: collision with root package name */
        public final h.i<? super T> f67939e;

        /* renamed from: f  reason: collision with root package name */
        public final T f67940f;

        public d(h.i<? super T> iVar, T t) {
            this.f67939e = iVar;
            this.f67940f = t;
        }

        /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: T, ? super T */
        @Override // h.n.a
        public void call() {
            try {
                this.f67939e.c((T) this.f67940f);
            } catch (Throwable th) {
                this.f67939e.b(th);
            }
        }
    }

    public h(T t) {
        super(new a(t));
        this.f67933b = t;
    }

    public static <T> h<T> n(T t) {
        return new h<>(t);
    }

    public h.h<T> o(h.g gVar) {
        if (gVar instanceof h.o.c.b) {
            return h.h.b(new b((h.o.c.b) gVar, this.f67933b));
        }
        return h.h.b(new c(gVar, this.f67933b));
    }
}
