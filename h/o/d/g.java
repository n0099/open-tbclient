package h.o.d;

import h.g;
import h.h;
import h.i;
/* loaded from: classes7.dex */
public final class g<T> extends h.h<T> {

    /* renamed from: b  reason: collision with root package name */
    public final T f68676b;

    /* loaded from: classes7.dex */
    public class a implements h.c<T> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Object f68677e;

        public a(Object obj) {
            this.f68677e = obj;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(i<? super T> iVar) {
            iVar.c((Object) this.f68677e);
        }
    }

    /* loaded from: classes7.dex */
    public static final class b<T> implements h.c<T> {

        /* renamed from: e  reason: collision with root package name */
        public final h.o.c.b f68678e;

        /* renamed from: f  reason: collision with root package name */
        public final T f68679f;

        public b(h.o.c.b bVar, T t) {
            this.f68678e = bVar;
            this.f68679f = t;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(i<? super T> iVar) {
            iVar.a(this.f68678e.a(new d(iVar, this.f68679f)));
        }
    }

    /* loaded from: classes7.dex */
    public static final class c<T> implements h.c<T> {

        /* renamed from: e  reason: collision with root package name */
        public final h.g f68680e;

        /* renamed from: f  reason: collision with root package name */
        public final T f68681f;

        public c(h.g gVar, T t) {
            this.f68680e = gVar;
            this.f68681f = t;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(i<? super T> iVar) {
            g.a createWorker = this.f68680e.createWorker();
            iVar.a(createWorker);
            createWorker.b(new d(iVar, this.f68681f));
        }
    }

    /* loaded from: classes7.dex */
    public static final class d<T> implements h.n.a {

        /* renamed from: e  reason: collision with root package name */
        public final i<? super T> f68682e;

        /* renamed from: f  reason: collision with root package name */
        public final T f68683f;

        public d(i<? super T> iVar, T t) {
            this.f68682e = iVar;
            this.f68683f = t;
        }

        /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: T, ? super T */
        @Override // h.n.a
        public void call() {
            try {
                this.f68682e.c((T) this.f68683f);
            } catch (Throwable th) {
                this.f68682e.b(th);
            }
        }
    }

    public g(T t) {
        super(new a(t));
        this.f68676b = t;
    }

    public static <T> g<T> m(T t) {
        return new g<>(t);
    }

    public h.h<T> n(h.g gVar) {
        if (gVar instanceof h.o.c.b) {
            return h.h.b(new b((h.o.c.b) gVar, this.f68676b));
        }
        return h.h.b(new c(gVar, this.f68676b));
    }
}
