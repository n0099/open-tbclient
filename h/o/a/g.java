package h.o.a;

import h.d;
import rx.exceptions.OnErrorThrowable;
/* loaded from: classes7.dex */
public final class g<T> implements d.a<T> {

    /* renamed from: e  reason: collision with root package name */
    public final h.d<T> f68742e;

    /* renamed from: f  reason: collision with root package name */
    public final h.n.f<? super T, Boolean> f68743f;

    /* loaded from: classes7.dex */
    public static final class a<T> extends h.j<T> {

        /* renamed from: e  reason: collision with root package name */
        public final h.j<? super T> f68744e;

        /* renamed from: f  reason: collision with root package name */
        public final h.n.f<? super T, Boolean> f68745f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f68746g;

        public a(h.j<? super T> jVar, h.n.f<? super T, Boolean> fVar) {
            this.f68744e = jVar;
            this.f68745f = fVar;
            request(0L);
        }

        @Override // h.e
        public void onCompleted() {
            if (this.f68746g) {
                return;
            }
            this.f68744e.onCompleted();
        }

        @Override // h.e
        public void onError(Throwable th) {
            if (this.f68746g) {
                h.r.c.j(th);
                return;
            }
            this.f68746g = true;
            this.f68744e.onError(th);
        }

        @Override // h.e
        public void onNext(T t) {
            try {
                if (this.f68745f.call(t).booleanValue()) {
                    this.f68744e.onNext(t);
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
            this.f68744e.setProducer(fVar);
        }
    }

    public g(h.d<T> dVar, h.n.f<? super T, Boolean> fVar) {
        this.f68742e = dVar;
        this.f68743f = fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.b
    /* renamed from: a */
    public void call(h.j<? super T> jVar) {
        a aVar = new a(jVar, this.f68743f);
        jVar.add(aVar);
        this.f68742e.L(aVar);
    }
}
