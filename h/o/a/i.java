package h.o.a;

import h.d;
import rx.exceptions.OnErrorThrowable;
/* loaded from: classes7.dex */
public final class i<T, R> implements d.a<R> {

    /* renamed from: e  reason: collision with root package name */
    public final h.d<T> f67737e;

    /* renamed from: f  reason: collision with root package name */
    public final h.n.f<? super T, ? extends R> f67738f;

    /* loaded from: classes7.dex */
    public static final class a<T, R> extends h.j<T> {

        /* renamed from: e  reason: collision with root package name */
        public final h.j<? super R> f67739e;

        /* renamed from: f  reason: collision with root package name */
        public final h.n.f<? super T, ? extends R> f67740f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f67741g;

        public a(h.j<? super R> jVar, h.n.f<? super T, ? extends R> fVar) {
            this.f67739e = jVar;
            this.f67740f = fVar;
        }

        @Override // h.e
        public void onCompleted() {
            if (this.f67741g) {
                return;
            }
            this.f67739e.onCompleted();
        }

        @Override // h.e
        public void onError(Throwable th) {
            if (this.f67741g) {
                h.r.c.j(th);
                return;
            }
            this.f67741g = true;
            this.f67739e.onError(th);
        }

        @Override // h.e
        public void onNext(T t) {
            try {
                this.f67739e.onNext(this.f67740f.call(t));
            } catch (Throwable th) {
                h.m.a.e(th);
                unsubscribe();
                onError(OnErrorThrowable.addValueAsLastCause(th, t));
            }
        }

        @Override // h.j
        public void setProducer(h.f fVar) {
            this.f67739e.setProducer(fVar);
        }
    }

    public i(h.d<T> dVar, h.n.f<? super T, ? extends R> fVar) {
        this.f67737e = dVar;
        this.f67738f = fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.b
    /* renamed from: a */
    public void call(h.j<? super R> jVar) {
        a aVar = new a(jVar, this.f67738f);
        jVar.add(aVar);
        this.f67737e.J(aVar);
    }
}
