package h.o.a;

import h.d;
import rx.exceptions.OnErrorThrowable;
/* loaded from: classes7.dex */
public final class i<T, R> implements d.a<R> {

    /* renamed from: e  reason: collision with root package name */
    public final h.d<T> f68896e;

    /* renamed from: f  reason: collision with root package name */
    public final h.n.f<? super T, ? extends R> f68897f;

    /* loaded from: classes7.dex */
    public static final class a<T, R> extends h.j<T> {

        /* renamed from: e  reason: collision with root package name */
        public final h.j<? super R> f68898e;

        /* renamed from: f  reason: collision with root package name */
        public final h.n.f<? super T, ? extends R> f68899f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f68900g;

        public a(h.j<? super R> jVar, h.n.f<? super T, ? extends R> fVar) {
            this.f68898e = jVar;
            this.f68899f = fVar;
        }

        @Override // h.e
        public void onCompleted() {
            if (this.f68900g) {
                return;
            }
            this.f68898e.onCompleted();
        }

        @Override // h.e
        public void onError(Throwable th) {
            if (this.f68900g) {
                h.r.c.j(th);
                return;
            }
            this.f68900g = true;
            this.f68898e.onError(th);
        }

        @Override // h.e
        public void onNext(T t) {
            try {
                this.f68898e.onNext(this.f68899f.call(t));
            } catch (Throwable th) {
                h.m.a.e(th);
                unsubscribe();
                onError(OnErrorThrowable.addValueAsLastCause(th, t));
            }
        }

        @Override // h.j
        public void setProducer(h.f fVar) {
            this.f68898e.setProducer(fVar);
        }
    }

    public i(h.d<T> dVar, h.n.f<? super T, ? extends R> fVar) {
        this.f68896e = dVar;
        this.f68897f = fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.b
    /* renamed from: a */
    public void call(h.j<? super R> jVar) {
        a aVar = new a(jVar, this.f68897f);
        jVar.add(aVar);
        this.f68896e.L(aVar);
    }
}
