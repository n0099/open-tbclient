package h.o.d;

import h.g;
import h.h;
import h.i;
/* loaded from: classes8.dex */
public final class g<T> extends h.h<T> {

    /* renamed from: b  reason: collision with root package name */
    public final T f71932b;

    /* loaded from: classes8.dex */
    public class a implements h.c<T> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Object f71933e;

        public a(Object obj) {
            this.f71933e = obj;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(i<? super T> iVar) {
            iVar.c((Object) this.f71933e);
        }
    }

    /* loaded from: classes8.dex */
    public static final class b<T> implements h.c<T> {

        /* renamed from: e  reason: collision with root package name */
        public final h.o.c.b f71934e;

        /* renamed from: f  reason: collision with root package name */
        public final T f71935f;

        public b(h.o.c.b bVar, T t) {
            this.f71934e = bVar;
            this.f71935f = t;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(i<? super T> iVar) {
            iVar.a(this.f71934e.a(new d(iVar, this.f71935f)));
        }
    }

    /* loaded from: classes8.dex */
    public static final class c<T> implements h.c<T> {

        /* renamed from: e  reason: collision with root package name */
        public final h.g f71936e;

        /* renamed from: f  reason: collision with root package name */
        public final T f71937f;

        public c(h.g gVar, T t) {
            this.f71936e = gVar;
            this.f71937f = t;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(i<? super T> iVar) {
            g.a createWorker = this.f71936e.createWorker();
            iVar.a(createWorker);
            createWorker.b(new d(iVar, this.f71937f));
        }
    }

    /* loaded from: classes8.dex */
    public static final class d<T> implements h.n.a {

        /* renamed from: e  reason: collision with root package name */
        public final i<? super T> f71938e;

        /* renamed from: f  reason: collision with root package name */
        public final T f71939f;

        public d(i<? super T> iVar, T t) {
            this.f71938e = iVar;
            this.f71939f = t;
        }

        /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: T, ? super T */
        @Override // h.n.a
        public void call() {
            try {
                this.f71938e.c((T) this.f71939f);
            } catch (Throwable th) {
                this.f71938e.b(th);
            }
        }
    }

    public g(T t) {
        super(new a(t));
        this.f71932b = t;
    }

    public static <T> g<T> m(T t) {
        return new g<>(t);
    }

    public h.h<T> n(h.g gVar) {
        if (gVar instanceof h.o.c.b) {
            return h.h.b(new b((h.o.c.b) gVar, this.f71932b));
        }
        return h.h.b(new c(gVar, this.f71932b));
    }
}
