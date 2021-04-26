package h.o.a;

import h.d;
import rx.exceptions.OnErrorThrowable;
/* loaded from: classes7.dex */
public final class f<T> implements d.a<T> {

    /* renamed from: e  reason: collision with root package name */
    public final h.d<T> f67732e;

    /* renamed from: f  reason: collision with root package name */
    public final h.n.f<? super T, Boolean> f67733f;

    /* loaded from: classes7.dex */
    public static final class a<T> extends h.j<T> {

        /* renamed from: e  reason: collision with root package name */
        public final h.j<? super T> f67734e;

        /* renamed from: f  reason: collision with root package name */
        public final h.n.f<? super T, Boolean> f67735f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f67736g;

        public a(h.j<? super T> jVar, h.n.f<? super T, Boolean> fVar) {
            this.f67734e = jVar;
            this.f67735f = fVar;
            request(0L);
        }

        @Override // h.e
        public void onCompleted() {
            if (this.f67736g) {
                return;
            }
            this.f67734e.onCompleted();
        }

        @Override // h.e
        public void onError(Throwable th) {
            if (this.f67736g) {
                h.r.c.j(th);
                return;
            }
            this.f67736g = true;
            this.f67734e.onError(th);
        }

        @Override // h.e
        public void onNext(T t) {
            try {
                if (this.f67735f.call(t).booleanValue()) {
                    this.f67734e.onNext(t);
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
            this.f67734e.setProducer(fVar);
        }
    }

    public f(h.d<T> dVar, h.n.f<? super T, Boolean> fVar) {
        this.f67732e = dVar;
        this.f67733f = fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.b
    /* renamed from: a */
    public void call(h.j<? super T> jVar) {
        a aVar = new a(jVar, this.f67733f);
        jVar.add(aVar);
        this.f67732e.I(aVar);
    }
}
