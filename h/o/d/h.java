package h.o.d;

import h.g;
import h.h;
/* loaded from: classes7.dex */
public final class h<T> extends h.h<T> {

    /* renamed from: b  reason: collision with root package name */
    public final T f69095b;

    /* loaded from: classes7.dex */
    public class a implements h.d<T> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Object f69096e;

        public a(Object obj) {
            this.f69096e = obj;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(h.i<? super T> iVar) {
            iVar.c((Object) this.f69096e);
        }
    }

    /* loaded from: classes7.dex */
    public static final class b<T> implements h.d<T> {

        /* renamed from: e  reason: collision with root package name */
        public final h.o.c.b f69097e;

        /* renamed from: f  reason: collision with root package name */
        public final T f69098f;

        public b(h.o.c.b bVar, T t) {
            this.f69097e = bVar;
            this.f69098f = t;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(h.i<? super T> iVar) {
            iVar.a(this.f69097e.a(new d(iVar, this.f69098f)));
        }
    }

    /* loaded from: classes7.dex */
    public static final class c<T> implements h.d<T> {

        /* renamed from: e  reason: collision with root package name */
        public final h.g f69099e;

        /* renamed from: f  reason: collision with root package name */
        public final T f69100f;

        public c(h.g gVar, T t) {
            this.f69099e = gVar;
            this.f69100f = t;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(h.i<? super T> iVar) {
            g.a createWorker = this.f69099e.createWorker();
            iVar.a(createWorker);
            createWorker.b(new d(iVar, this.f69100f));
        }
    }

    /* loaded from: classes7.dex */
    public static final class d<T> implements h.n.a {

        /* renamed from: e  reason: collision with root package name */
        public final h.i<? super T> f69101e;

        /* renamed from: f  reason: collision with root package name */
        public final T f69102f;

        public d(h.i<? super T> iVar, T t) {
            this.f69101e = iVar;
            this.f69102f = t;
        }

        /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: T, ? super T */
        @Override // h.n.a
        public void call() {
            try {
                this.f69101e.c((T) this.f69102f);
            } catch (Throwable th) {
                this.f69101e.b(th);
            }
        }
    }

    public h(T t) {
        super(new a(t));
        this.f69095b = t;
    }

    public static <T> h<T> n(T t) {
        return new h<>(t);
    }

    public h.h<T> o(h.g gVar) {
        if (gVar instanceof h.o.c.b) {
            return h.h.b(new b((h.o.c.b) gVar, this.f69095b));
        }
        return h.h.b(new c(gVar, this.f69095b));
    }
}
