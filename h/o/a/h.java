package h.o.a;

import h.d;
import rx.exceptions.OnErrorThrowable;
/* loaded from: classes8.dex */
public final class h<T, R> implements d.a<R> {

    /* renamed from: e  reason: collision with root package name */
    public final h.d<T> f71822e;

    /* renamed from: f  reason: collision with root package name */
    public final h.n.f<? super T, ? extends R> f71823f;

    /* loaded from: classes8.dex */
    public static final class a<T, R> extends h.j<T> {

        /* renamed from: e  reason: collision with root package name */
        public final h.j<? super R> f71824e;

        /* renamed from: f  reason: collision with root package name */
        public final h.n.f<? super T, ? extends R> f71825f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f71826g;

        public a(h.j<? super R> jVar, h.n.f<? super T, ? extends R> fVar) {
            this.f71824e = jVar;
            this.f71825f = fVar;
        }

        @Override // h.e
        public void onCompleted() {
            if (this.f71826g) {
                return;
            }
            this.f71824e.onCompleted();
        }

        @Override // h.e
        public void onError(Throwable th) {
            if (this.f71826g) {
                h.r.c.j(th);
                return;
            }
            this.f71826g = true;
            this.f71824e.onError(th);
        }

        @Override // h.e
        public void onNext(T t) {
            try {
                this.f71824e.onNext(this.f71825f.call(t));
            } catch (Throwable th) {
                h.m.a.e(th);
                unsubscribe();
                onError(OnErrorThrowable.addValueAsLastCause(th, t));
            }
        }

        @Override // h.j
        public void setProducer(h.f fVar) {
            this.f71824e.setProducer(fVar);
        }
    }

    public h(h.d<T> dVar, h.n.f<? super T, ? extends R> fVar) {
        this.f71822e = dVar;
        this.f71823f = fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.b
    /* renamed from: a */
    public void call(h.j<? super R> jVar) {
        a aVar = new a(jVar, this.f71823f);
        jVar.add(aVar);
        this.f71822e.I(aVar);
    }
}
