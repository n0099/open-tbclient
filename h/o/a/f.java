package h.o.a;

import h.d;
import rx.exceptions.OnErrorThrowable;
/* loaded from: classes8.dex */
public final class f<T> implements d.a<T> {

    /* renamed from: e  reason: collision with root package name */
    public final h.d<T> f71815e;

    /* renamed from: f  reason: collision with root package name */
    public final h.n.f<? super T, Boolean> f71816f;

    /* loaded from: classes8.dex */
    public static final class a<T> extends h.j<T> {

        /* renamed from: e  reason: collision with root package name */
        public final h.j<? super T> f71817e;

        /* renamed from: f  reason: collision with root package name */
        public final h.n.f<? super T, Boolean> f71818f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f71819g;

        public a(h.j<? super T> jVar, h.n.f<? super T, Boolean> fVar) {
            this.f71817e = jVar;
            this.f71818f = fVar;
            request(0L);
        }

        @Override // h.e
        public void onCompleted() {
            if (this.f71819g) {
                return;
            }
            this.f71817e.onCompleted();
        }

        @Override // h.e
        public void onError(Throwable th) {
            if (this.f71819g) {
                h.r.c.j(th);
                return;
            }
            this.f71819g = true;
            this.f71817e.onError(th);
        }

        @Override // h.e
        public void onNext(T t) {
            try {
                if (this.f71818f.call(t).booleanValue()) {
                    this.f71817e.onNext(t);
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
            this.f71817e.setProducer(fVar);
        }
    }

    public f(h.d<T> dVar, h.n.f<? super T, Boolean> fVar) {
        this.f71815e = dVar;
        this.f71816f = fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.b
    /* renamed from: a */
    public void call(h.j<? super T> jVar) {
        a aVar = new a(jVar, this.f71816f);
        jVar.add(aVar);
        this.f71815e.I(aVar);
    }
}
