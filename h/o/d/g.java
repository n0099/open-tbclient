package h.o.d;

import h.g;
import h.h;
import h.i;
/* loaded from: classes8.dex */
public final class g<T> extends h.h<T> {

    /* renamed from: b  reason: collision with root package name */
    public final T f72036b;

    /* loaded from: classes8.dex */
    public class a implements h.c<T> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Object f72037e;

        public a(Object obj) {
            this.f72037e = obj;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(i<? super T> iVar) {
            iVar.c((Object) this.f72037e);
        }
    }

    /* loaded from: classes8.dex */
    public static final class b<T> implements h.c<T> {

        /* renamed from: e  reason: collision with root package name */
        public final h.o.c.b f72038e;

        /* renamed from: f  reason: collision with root package name */
        public final T f72039f;

        public b(h.o.c.b bVar, T t) {
            this.f72038e = bVar;
            this.f72039f = t;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(i<? super T> iVar) {
            iVar.a(this.f72038e.a(new d(iVar, this.f72039f)));
        }
    }

    /* loaded from: classes8.dex */
    public static final class c<T> implements h.c<T> {

        /* renamed from: e  reason: collision with root package name */
        public final h.g f72040e;

        /* renamed from: f  reason: collision with root package name */
        public final T f72041f;

        public c(h.g gVar, T t) {
            this.f72040e = gVar;
            this.f72041f = t;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(i<? super T> iVar) {
            g.a createWorker = this.f72040e.createWorker();
            iVar.a(createWorker);
            createWorker.b(new d(iVar, this.f72041f));
        }
    }

    /* loaded from: classes8.dex */
    public static final class d<T> implements h.n.a {

        /* renamed from: e  reason: collision with root package name */
        public final i<? super T> f72042e;

        /* renamed from: f  reason: collision with root package name */
        public final T f72043f;

        public d(i<? super T> iVar, T t) {
            this.f72042e = iVar;
            this.f72043f = t;
        }

        /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: T, ? super T */
        @Override // h.n.a
        public void call() {
            try {
                this.f72042e.c((T) this.f72043f);
            } catch (Throwable th) {
                this.f72042e.b(th);
            }
        }
    }

    public g(T t) {
        super(new a(t));
        this.f72036b = t;
    }

    public static <T> g<T> m(T t) {
        return new g<>(t);
    }

    public h.h<T> n(h.g gVar) {
        if (gVar instanceof h.o.c.b) {
            return h.h.b(new b((h.o.c.b) gVar, this.f72036b));
        }
        return h.h.b(new c(gVar, this.f72036b));
    }
}
