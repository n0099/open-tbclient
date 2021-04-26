package h.o.a;

import h.d;
import rx.exceptions.OnErrorThrowable;
/* loaded from: classes7.dex */
public final class h<T, R> implements d.a<R> {

    /* renamed from: e  reason: collision with root package name */
    public final h.d<T> f67739e;

    /* renamed from: f  reason: collision with root package name */
    public final h.n.f<? super T, ? extends R> f67740f;

    /* loaded from: classes7.dex */
    public static final class a<T, R> extends h.j<T> {

        /* renamed from: e  reason: collision with root package name */
        public final h.j<? super R> f67741e;

        /* renamed from: f  reason: collision with root package name */
        public final h.n.f<? super T, ? extends R> f67742f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f67743g;

        public a(h.j<? super R> jVar, h.n.f<? super T, ? extends R> fVar) {
            this.f67741e = jVar;
            this.f67742f = fVar;
        }

        @Override // h.e
        public void onCompleted() {
            if (this.f67743g) {
                return;
            }
            this.f67741e.onCompleted();
        }

        @Override // h.e
        public void onError(Throwable th) {
            if (this.f67743g) {
                h.r.c.j(th);
                return;
            }
            this.f67743g = true;
            this.f67741e.onError(th);
        }

        @Override // h.e
        public void onNext(T t) {
            try {
                this.f67741e.onNext(this.f67742f.call(t));
            } catch (Throwable th) {
                h.m.a.e(th);
                unsubscribe();
                onError(OnErrorThrowable.addValueAsLastCause(th, t));
            }
        }

        @Override // h.j
        public void setProducer(h.f fVar) {
            this.f67741e.setProducer(fVar);
        }
    }

    public h(h.d<T> dVar, h.n.f<? super T, ? extends R> fVar) {
        this.f67739e = dVar;
        this.f67740f = fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.b
    /* renamed from: a */
    public void call(h.j<? super R> jVar) {
        a aVar = new a(jVar, this.f67740f);
        jVar.add(aVar);
        this.f67739e.I(aVar);
    }
}
