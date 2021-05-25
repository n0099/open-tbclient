package h.o.a;

import h.d;
import rx.exceptions.OnErrorThrowable;
/* loaded from: classes7.dex */
public final class h<T, R> implements d.a<R> {

    /* renamed from: e  reason: collision with root package name */
    public final h.d<T> f68462e;

    /* renamed from: f  reason: collision with root package name */
    public final h.n.f<? super T, ? extends R> f68463f;

    /* loaded from: classes7.dex */
    public static final class a<T, R> extends h.j<T> {

        /* renamed from: e  reason: collision with root package name */
        public final h.j<? super R> f68464e;

        /* renamed from: f  reason: collision with root package name */
        public final h.n.f<? super T, ? extends R> f68465f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f68466g;

        public a(h.j<? super R> jVar, h.n.f<? super T, ? extends R> fVar) {
            this.f68464e = jVar;
            this.f68465f = fVar;
        }

        @Override // h.e
        public void onCompleted() {
            if (this.f68466g) {
                return;
            }
            this.f68464e.onCompleted();
        }

        @Override // h.e
        public void onError(Throwable th) {
            if (this.f68466g) {
                h.r.c.j(th);
                return;
            }
            this.f68466g = true;
            this.f68464e.onError(th);
        }

        @Override // h.e
        public void onNext(T t) {
            try {
                this.f68464e.onNext(this.f68465f.call(t));
            } catch (Throwable th) {
                h.m.a.e(th);
                unsubscribe();
                onError(OnErrorThrowable.addValueAsLastCause(th, t));
            }
        }

        @Override // h.j
        public void setProducer(h.f fVar) {
            this.f68464e.setProducer(fVar);
        }
    }

    public h(h.d<T> dVar, h.n.f<? super T, ? extends R> fVar) {
        this.f68462e = dVar;
        this.f68463f = fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.b
    /* renamed from: a */
    public void call(h.j<? super R> jVar) {
        a aVar = new a(jVar, this.f68463f);
        jVar.add(aVar);
        this.f68462e.I(aVar);
    }
}
