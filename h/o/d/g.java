package h.o.d;

import h.g;
import h.h;
import h.i;
/* loaded from: classes7.dex */
public final class g<T> extends h.h<T> {

    /* renamed from: b  reason: collision with root package name */
    public final T f67953b;

    /* loaded from: classes7.dex */
    public class a implements h.d<T> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Object f67954e;

        public a(Object obj) {
            this.f67954e = obj;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(i<? super T> iVar) {
            iVar.c((Object) this.f67954e);
        }
    }

    /* loaded from: classes7.dex */
    public static final class b<T> implements h.d<T> {

        /* renamed from: e  reason: collision with root package name */
        public final h.o.c.b f67955e;

        /* renamed from: f  reason: collision with root package name */
        public final T f67956f;

        public b(h.o.c.b bVar, T t) {
            this.f67955e = bVar;
            this.f67956f = t;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(i<? super T> iVar) {
            iVar.a(this.f67955e.a(new d(iVar, this.f67956f)));
        }
    }

    /* loaded from: classes7.dex */
    public static final class c<T> implements h.d<T> {

        /* renamed from: e  reason: collision with root package name */
        public final h.g f67957e;

        /* renamed from: f  reason: collision with root package name */
        public final T f67958f;

        public c(h.g gVar, T t) {
            this.f67957e = gVar;
            this.f67958f = t;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(i<? super T> iVar) {
            g.a createWorker = this.f67957e.createWorker();
            iVar.a(createWorker);
            createWorker.b(new d(iVar, this.f67958f));
        }
    }

    /* loaded from: classes7.dex */
    public static final class d<T> implements h.n.a {

        /* renamed from: e  reason: collision with root package name */
        public final i<? super T> f67959e;

        /* renamed from: f  reason: collision with root package name */
        public final T f67960f;

        public d(i<? super T> iVar, T t) {
            this.f67959e = iVar;
            this.f67960f = t;
        }

        /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: T, ? super T */
        @Override // h.n.a
        public void call() {
            try {
                this.f67959e.c((T) this.f67960f);
            } catch (Throwable th) {
                this.f67959e.b(th);
            }
        }
    }

    public g(T t) {
        super(new a(t));
        this.f67953b = t;
    }

    public static <T> g<T> n(T t) {
        return new g<>(t);
    }

    public h.h<T> o(h.g gVar) {
        if (gVar instanceof h.o.c.b) {
            return h.h.b(new b((h.o.c.b) gVar, this.f67953b));
        }
        return h.h.b(new c(gVar, this.f67953b));
    }
}
