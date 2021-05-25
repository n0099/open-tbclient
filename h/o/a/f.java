package h.o.a;

import h.d;
import rx.exceptions.OnErrorThrowable;
/* loaded from: classes7.dex */
public final class f<T> implements d.a<T> {

    /* renamed from: e  reason: collision with root package name */
    public final h.d<T> f68455e;

    /* renamed from: f  reason: collision with root package name */
    public final h.n.f<? super T, Boolean> f68456f;

    /* loaded from: classes7.dex */
    public static final class a<T> extends h.j<T> {

        /* renamed from: e  reason: collision with root package name */
        public final h.j<? super T> f68457e;

        /* renamed from: f  reason: collision with root package name */
        public final h.n.f<? super T, Boolean> f68458f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f68459g;

        public a(h.j<? super T> jVar, h.n.f<? super T, Boolean> fVar) {
            this.f68457e = jVar;
            this.f68458f = fVar;
            request(0L);
        }

        @Override // h.e
        public void onCompleted() {
            if (this.f68459g) {
                return;
            }
            this.f68457e.onCompleted();
        }

        @Override // h.e
        public void onError(Throwable th) {
            if (this.f68459g) {
                h.r.c.j(th);
                return;
            }
            this.f68459g = true;
            this.f68457e.onError(th);
        }

        @Override // h.e
        public void onNext(T t) {
            try {
                if (this.f68458f.call(t).booleanValue()) {
                    this.f68457e.onNext(t);
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
            this.f68457e.setProducer(fVar);
        }
    }

    public f(h.d<T> dVar, h.n.f<? super T, Boolean> fVar) {
        this.f68455e = dVar;
        this.f68456f = fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.b
    /* renamed from: a */
    public void call(h.j<? super T> jVar) {
        a aVar = new a(jVar, this.f68456f);
        jVar.add(aVar);
        this.f68455e.I(aVar);
    }
}
