package h.t;

import h.d;
import h.j;
/* loaded from: classes7.dex */
public class c<T, R> extends d<T, R> {

    /* renamed from: f  reason: collision with root package name */
    public final h.q.d<T> f69021f;

    /* loaded from: classes7.dex */
    public class a implements d.a<R> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f69022e;

        public a(d dVar) {
            this.f69022e = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(j<? super R> jVar) {
            this.f69022e.L(jVar);
        }
    }

    public c(d<T, R> dVar) {
        super(new a(dVar));
        this.f69021f = new h.q.d<>(dVar);
    }

    @Override // h.e
    public void onCompleted() {
        this.f69021f.onCompleted();
    }

    @Override // h.e
    public void onError(Throwable th) {
        this.f69021f.onError(th);
    }

    @Override // h.e
    public void onNext(T t) {
        this.f69021f.onNext(t);
    }
}
