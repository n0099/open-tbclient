package h.o.d;

import h.g;
import h.h;
/* loaded from: classes7.dex */
public final class h<T> extends h.h<T> {

    /* renamed from: b  reason: collision with root package name */
    public final T f67938b;

    /* loaded from: classes7.dex */
    public class a implements h.d<T> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Object f67939e;

        public a(Object obj) {
            this.f67939e = obj;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(h.i<? super T> iVar) {
            iVar.c((Object) this.f67939e);
        }
    }

    /* loaded from: classes7.dex */
    public static final class b<T> implements h.d<T> {

        /* renamed from: e  reason: collision with root package name */
        public final h.o.c.b f67940e;

        /* renamed from: f  reason: collision with root package name */
        public final T f67941f;

        public b(h.o.c.b bVar, T t) {
            this.f67940e = bVar;
            this.f67941f = t;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(h.i<? super T> iVar) {
            iVar.a(this.f67940e.a(new d(iVar, this.f67941f)));
        }
    }

    /* loaded from: classes7.dex */
    public static final class c<T> implements h.d<T> {

        /* renamed from: e  reason: collision with root package name */
        public final h.g f67942e;

        /* renamed from: f  reason: collision with root package name */
        public final T f67943f;

        public c(h.g gVar, T t) {
            this.f67942e = gVar;
            this.f67943f = t;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(h.i<? super T> iVar) {
            g.a createWorker = this.f67942e.createWorker();
            iVar.a(createWorker);
            createWorker.b(new d(iVar, this.f67943f));
        }
    }

    /* loaded from: classes7.dex */
    public static final class d<T> implements h.n.a {

        /* renamed from: e  reason: collision with root package name */
        public final h.i<? super T> f67944e;

        /* renamed from: f  reason: collision with root package name */
        public final T f67945f;

        public d(h.i<? super T> iVar, T t) {
            this.f67944e = iVar;
            this.f67945f = t;
        }

        /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: T, ? super T */
        @Override // h.n.a
        public void call() {
            try {
                this.f67944e.c((T) this.f67945f);
            } catch (Throwable th) {
                this.f67944e.b(th);
            }
        }
    }

    public h(T t) {
        super(new a(t));
        this.f67938b = t;
    }

    public static <T> h<T> n(T t) {
        return new h<>(t);
    }

    public h.h<T> o(h.g gVar) {
        if (gVar instanceof h.o.c.b) {
            return h.h.b(new b((h.o.c.b) gVar, this.f67938b));
        }
        return h.h.b(new c(gVar, this.f67938b));
    }
}
