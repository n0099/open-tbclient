package h.t;

import h.d;
import h.j;
/* loaded from: classes8.dex */
public class c<T, R> extends d<T, R> {

    /* renamed from: f  reason: collision with root package name */
    public final h.q.d<T> f72115f;

    /* loaded from: classes8.dex */
    public class a implements d.a<R> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f72116e;

        public a(d dVar) {
            this.f72116e = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(j<? super R> jVar) {
            this.f72116e.I(jVar);
        }
    }

    public c(d<T, R> dVar) {
        super(new a(dVar));
        this.f72115f = new h.q.d<>(dVar);
    }

    @Override // h.e
    public void onCompleted() {
        this.f72115f.onCompleted();
    }

    @Override // h.e
    public void onError(Throwable th) {
        this.f72115f.onError(th);
    }

    @Override // h.e
    public void onNext(T t) {
        this.f72115f.onNext(t);
    }
}
