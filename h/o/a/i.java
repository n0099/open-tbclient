package h.o.a;

import h.d;
import rx.exceptions.OnErrorThrowable;
/* loaded from: classes7.dex */
public final class i<T, R> implements d.a<R> {

    /* renamed from: e  reason: collision with root package name */
    public final h.d<T> f67742e;

    /* renamed from: f  reason: collision with root package name */
    public final h.n.f<? super T, ? extends R> f67743f;

    /* loaded from: classes7.dex */
    public static final class a<T, R> extends h.j<T> {

        /* renamed from: e  reason: collision with root package name */
        public final h.j<? super R> f67744e;

        /* renamed from: f  reason: collision with root package name */
        public final h.n.f<? super T, ? extends R> f67745f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f67746g;

        public a(h.j<? super R> jVar, h.n.f<? super T, ? extends R> fVar) {
            this.f67744e = jVar;
            this.f67745f = fVar;
        }

        @Override // h.e
        public void onCompleted() {
            if (this.f67746g) {
                return;
            }
            this.f67744e.onCompleted();
        }

        @Override // h.e
        public void onError(Throwable th) {
            if (this.f67746g) {
                h.r.c.j(th);
                return;
            }
            this.f67746g = true;
            this.f67744e.onError(th);
        }

        @Override // h.e
        public void onNext(T t) {
            try {
                this.f67744e.onNext(this.f67745f.call(t));
            } catch (Throwable th) {
                h.m.a.e(th);
                unsubscribe();
                onError(OnErrorThrowable.addValueAsLastCause(th, t));
            }
        }

        @Override // h.j
        public void setProducer(h.f fVar) {
            this.f67744e.setProducer(fVar);
        }
    }

    public i(h.d<T> dVar, h.n.f<? super T, ? extends R> fVar) {
        this.f67742e = dVar;
        this.f67743f = fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.b
    /* renamed from: a */
    public void call(h.j<? super R> jVar) {
        a aVar = new a(jVar, this.f67743f);
        jVar.add(aVar);
        this.f67742e.J(aVar);
    }
}
