package rx.b;

import rx.j;
/* loaded from: classes2.dex */
public final class f {
    public static <T> j<T> cQG() {
        return b(a.cQF());
    }

    public static <T> j<T> b(final rx.e<? super T> eVar) {
        return new j<T>() { // from class: rx.b.f.1
            @Override // rx.e
            public void onCompleted() {
                rx.e.this.onCompleted();
            }

            @Override // rx.e
            public void onError(Throwable th) {
                rx.e.this.onError(th);
            }

            @Override // rx.e
            public void onNext(T t) {
                rx.e.this.onNext(t);
            }
        };
    }

    public static <T> j<T> d(final j<? super T> jVar) {
        return new j<T>(jVar) { // from class: rx.b.f.2
            @Override // rx.e
            public void onCompleted() {
                jVar.onCompleted();
            }

            @Override // rx.e
            public void onError(Throwable th) {
                jVar.onError(th);
            }

            @Override // rx.e
            public void onNext(T t) {
                jVar.onNext(t);
            }
        };
    }
}
