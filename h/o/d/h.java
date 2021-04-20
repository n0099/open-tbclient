package h.o.d;

import h.g;
import h.h;
/* loaded from: classes7.dex */
public final class h<T> extends h.h<T> {

    /* renamed from: b  reason: collision with root package name */
    public final T f68948b;

    /* loaded from: classes7.dex */
    public class a implements h.d<T> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Object f68949e;

        public a(Object obj) {
            this.f68949e = obj;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(h.i<? super T> iVar) {
            iVar.c((Object) this.f68949e);
        }
    }

    /* loaded from: classes7.dex */
    public static final class b<T> implements h.d<T> {

        /* renamed from: e  reason: collision with root package name */
        public final h.o.c.b f68950e;

        /* renamed from: f  reason: collision with root package name */
        public final T f68951f;

        public b(h.o.c.b bVar, T t) {
            this.f68950e = bVar;
            this.f68951f = t;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(h.i<? super T> iVar) {
            iVar.a(this.f68950e.a(new d(iVar, this.f68951f)));
        }
    }

    /* loaded from: classes7.dex */
    public static final class c<T> implements h.d<T> {

        /* renamed from: e  reason: collision with root package name */
        public final h.g f68952e;

        /* renamed from: f  reason: collision with root package name */
        public final T f68953f;

        public c(h.g gVar, T t) {
            this.f68952e = gVar;
            this.f68953f = t;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(h.i<? super T> iVar) {
            g.a createWorker = this.f68952e.createWorker();
            iVar.a(createWorker);
            createWorker.b(new d(iVar, this.f68953f));
        }
    }

    /* loaded from: classes7.dex */
    public static final class d<T> implements h.n.a {

        /* renamed from: e  reason: collision with root package name */
        public final h.i<? super T> f68954e;

        /* renamed from: f  reason: collision with root package name */
        public final T f68955f;

        public d(h.i<? super T> iVar, T t) {
            this.f68954e = iVar;
            this.f68955f = t;
        }

        /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: T, ? super T */
        @Override // h.n.a
        public void call() {
            try {
                this.f68954e.c((T) this.f68955f);
            } catch (Throwable th) {
                this.f68954e.b(th);
            }
        }
    }

    public h(T t) {
        super(new a(t));
        this.f68948b = t;
    }

    public static <T> h<T> n(T t) {
        return new h<>(t);
    }

    public h.h<T> o(h.g gVar) {
        if (gVar instanceof h.o.c.b) {
            return h.h.b(new b((h.o.c.b) gVar, this.f68948b));
        }
        return h.h.b(new c(gVar, this.f68948b));
    }
}
