package h.q;

import h.j;
/* loaded from: classes7.dex */
public final class f {

    /* loaded from: classes7.dex */
    public static class a extends j<T> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h.e f69143e;

        public a(h.e eVar) {
            this.f69143e = eVar;
        }

        @Override // h.e
        public void onCompleted() {
            this.f69143e.onCompleted();
        }

        @Override // h.e
        public void onError(Throwable th) {
            this.f69143e.onError(th);
        }

        @Override // h.e
        public void onNext(T t) {
            this.f69143e.onNext(t);
        }
    }

    /* loaded from: classes7.dex */
    public static class b extends j<T> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f69144e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(j jVar, j jVar2) {
            super(jVar);
            this.f69144e = jVar2;
        }

        @Override // h.e
        public void onCompleted() {
            this.f69144e.onCompleted();
        }

        @Override // h.e
        public void onError(Throwable th) {
            this.f69144e.onError(th);
        }

        @Override // h.e
        public void onNext(T t) {
            this.f69144e.onNext(t);
        }
    }

    public static <T> j<T> a() {
        return b(h.q.a.a());
    }

    public static <T> j<T> b(h.e<? super T> eVar) {
        return new a(eVar);
    }

    public static <T> j<T> c(j<? super T> jVar) {
        return new b(jVar, jVar);
    }
}
