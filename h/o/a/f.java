package h.o.a;

import h.d;
import rx.exceptions.OnErrorThrowable;
/* loaded from: classes7.dex */
public final class f<T> implements d.a<T> {

    /* renamed from: e  reason: collision with root package name */
    public final h.d<T> f68412e;

    /* renamed from: f  reason: collision with root package name */
    public final h.n.f<? super T, Boolean> f68413f;

    /* loaded from: classes7.dex */
    public static final class a<T> extends h.j<T> {

        /* renamed from: e  reason: collision with root package name */
        public final h.j<? super T> f68414e;

        /* renamed from: f  reason: collision with root package name */
        public final h.n.f<? super T, Boolean> f68415f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f68416g;

        public a(h.j<? super T> jVar, h.n.f<? super T, Boolean> fVar) {
            this.f68414e = jVar;
            this.f68415f = fVar;
            request(0L);
        }

        @Override // h.e
        public void onCompleted() {
            if (this.f68416g) {
                return;
            }
            this.f68414e.onCompleted();
        }

        @Override // h.e
        public void onError(Throwable th) {
            if (this.f68416g) {
                h.r.c.j(th);
                return;
            }
            this.f68416g = true;
            this.f68414e.onError(th);
        }

        @Override // h.e
        public void onNext(T t) {
            try {
                if (this.f68415f.call(t).booleanValue()) {
                    this.f68414e.onNext(t);
                } else {
                    request(1L);
                }
            } catch (Throwable th) {
                h.m.a.e(th);
                unsubscribe();
                onError(OnErrorThrowable.addValueAsLastCause(th, t));
            }
        }

        @Override // h.j
        public void setProducer(h.f fVar) {
            super.setProducer(fVar);
            this.f68414e.setProducer(fVar);
        }
    }

    public f(h.d<T> dVar, h.n.f<? super T, Boolean> fVar) {
        this.f68412e = dVar;
        this.f68413f = fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.b
    /* renamed from: a */
    public void call(h.j<? super T> jVar) {
        a aVar = new a(jVar, this.f68413f);
        jVar.add(aVar);
        this.f68412e.I(aVar);
    }
}
