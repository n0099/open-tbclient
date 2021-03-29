package h.o.a;

import h.d;
import rx.exceptions.OnErrorThrowable;
/* loaded from: classes7.dex */
public final class g<T> implements d.a<T> {

    /* renamed from: e  reason: collision with root package name */
    public final h.d<T> f67735e;

    /* renamed from: f  reason: collision with root package name */
    public final h.n.f<? super T, Boolean> f67736f;

    /* loaded from: classes7.dex */
    public static final class a<T> extends h.j<T> {

        /* renamed from: e  reason: collision with root package name */
        public final h.j<? super T> f67737e;

        /* renamed from: f  reason: collision with root package name */
        public final h.n.f<? super T, Boolean> f67738f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f67739g;

        public a(h.j<? super T> jVar, h.n.f<? super T, Boolean> fVar) {
            this.f67737e = jVar;
            this.f67738f = fVar;
            request(0L);
        }

        @Override // h.e
        public void onCompleted() {
            if (this.f67739g) {
                return;
            }
            this.f67737e.onCompleted();
        }

        @Override // h.e
        public void onError(Throwable th) {
            if (this.f67739g) {
                h.r.c.j(th);
                return;
            }
            this.f67739g = true;
            this.f67737e.onError(th);
        }

        @Override // h.e
        public void onNext(T t) {
            try {
                if (this.f67738f.call(t).booleanValue()) {
                    this.f67737e.onNext(t);
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
            this.f67737e.setProducer(fVar);
        }
    }

    public g(h.d<T> dVar, h.n.f<? super T, Boolean> fVar) {
        this.f67735e = dVar;
        this.f67736f = fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.b
    /* renamed from: a */
    public void call(h.j<? super T> jVar) {
        a aVar = new a(jVar, this.f67736f);
        jVar.add(aVar);
        this.f67735e.J(aVar);
    }
}
