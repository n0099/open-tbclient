package h.o.a;

import h.d;
import rx.exceptions.OnErrorThrowable;
/* loaded from: classes7.dex */
public final class g<T> implements d.a<T> {

    /* renamed from: e  reason: collision with root package name */
    public final h.d<T> f67730e;

    /* renamed from: f  reason: collision with root package name */
    public final h.n.f<? super T, Boolean> f67731f;

    /* loaded from: classes7.dex */
    public static final class a<T> extends h.j<T> {

        /* renamed from: e  reason: collision with root package name */
        public final h.j<? super T> f67732e;

        /* renamed from: f  reason: collision with root package name */
        public final h.n.f<? super T, Boolean> f67733f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f67734g;

        public a(h.j<? super T> jVar, h.n.f<? super T, Boolean> fVar) {
            this.f67732e = jVar;
            this.f67733f = fVar;
            request(0L);
        }

        @Override // h.e
        public void onCompleted() {
            if (this.f67734g) {
                return;
            }
            this.f67732e.onCompleted();
        }

        @Override // h.e
        public void onError(Throwable th) {
            if (this.f67734g) {
                h.r.c.j(th);
                return;
            }
            this.f67734g = true;
            this.f67732e.onError(th);
        }

        @Override // h.e
        public void onNext(T t) {
            try {
                if (this.f67733f.call(t).booleanValue()) {
                    this.f67732e.onNext(t);
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
            this.f67732e.setProducer(fVar);
        }
    }

    public g(h.d<T> dVar, h.n.f<? super T, Boolean> fVar) {
        this.f67730e = dVar;
        this.f67731f = fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.b
    /* renamed from: a */
    public void call(h.j<? super T> jVar) {
        a aVar = new a(jVar, this.f67731f);
        jVar.add(aVar);
        this.f67730e.J(aVar);
    }
}
