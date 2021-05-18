package h.o.d;

import h.g;
import h.h;
import h.i;
/* loaded from: classes7.dex */
public final class g<T> extends h.h<T> {

    /* renamed from: b  reason: collision with root package name */
    public final T f68633b;

    /* loaded from: classes7.dex */
    public class a implements h.c<T> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Object f68634e;

        public a(Object obj) {
            this.f68634e = obj;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(i<? super T> iVar) {
            iVar.c((Object) this.f68634e);
        }
    }

    /* loaded from: classes7.dex */
    public static final class b<T> implements h.c<T> {

        /* renamed from: e  reason: collision with root package name */
        public final h.o.c.b f68635e;

        /* renamed from: f  reason: collision with root package name */
        public final T f68636f;

        public b(h.o.c.b bVar, T t) {
            this.f68635e = bVar;
            this.f68636f = t;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(i<? super T> iVar) {
            iVar.a(this.f68635e.a(new d(iVar, this.f68636f)));
        }
    }

    /* loaded from: classes7.dex */
    public static final class c<T> implements h.c<T> {

        /* renamed from: e  reason: collision with root package name */
        public final h.g f68637e;

        /* renamed from: f  reason: collision with root package name */
        public final T f68638f;

        public c(h.g gVar, T t) {
            this.f68637e = gVar;
            this.f68638f = t;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(i<? super T> iVar) {
            g.a createWorker = this.f68637e.createWorker();
            iVar.a(createWorker);
            createWorker.b(new d(iVar, this.f68638f));
        }
    }

    /* loaded from: classes7.dex */
    public static final class d<T> implements h.n.a {

        /* renamed from: e  reason: collision with root package name */
        public final i<? super T> f68639e;

        /* renamed from: f  reason: collision with root package name */
        public final T f68640f;

        public d(i<? super T> iVar, T t) {
            this.f68639e = iVar;
            this.f68640f = t;
        }

        /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: T, ? super T */
        @Override // h.n.a
        public void call() {
            try {
                this.f68639e.c((T) this.f68640f);
            } catch (Throwable th) {
                this.f68639e.b(th);
            }
        }
    }

    public g(T t) {
        super(new a(t));
        this.f68633b = t;
    }

    public static <T> g<T> m(T t) {
        return new g<>(t);
    }

    public h.h<T> n(h.g gVar) {
        if (gVar instanceof h.o.c.b) {
            return h.h.b(new b((h.o.c.b) gVar, this.f68633b));
        }
        return h.h.b(new c(gVar, this.f68633b));
    }
}
