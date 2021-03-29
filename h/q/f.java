package h.q;

import h.j;
/* loaded from: classes7.dex */
public final class f {

    /* loaded from: classes7.dex */
    public static class a extends j<T> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h.e f67986e;

        public a(h.e eVar) {
            this.f67986e = eVar;
        }

        @Override // h.e
        public void onCompleted() {
            this.f67986e.onCompleted();
        }

        @Override // h.e
        public void onError(Throwable th) {
            this.f67986e.onError(th);
        }

        @Override // h.e
        public void onNext(T t) {
            this.f67986e.onNext(t);
        }
    }

    /* loaded from: classes7.dex */
    public static class b extends j<T> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f67987e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(j jVar, j jVar2) {
            super(jVar);
            this.f67987e = jVar2;
        }

        @Override // h.e
        public void onCompleted() {
            this.f67987e.onCompleted();
        }

        @Override // h.e
        public void onError(Throwable th) {
            this.f67987e.onError(th);
        }

        @Override // h.e
        public void onNext(T t) {
            this.f67987e.onNext(t);
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
