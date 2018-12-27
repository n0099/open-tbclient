package rx.b;

import rx.j;
/* loaded from: classes2.dex */
public final class g {
    public static <T> j<T> cfD() {
        return a(b.cfC());
    }

    public static <T> j<T> a(final rx.e<? super T> eVar) {
        return new j<T>() { // from class: rx.b.g.1
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

    public static <T> j<T> b(final j<? super T> jVar) {
        return new j<T>(jVar) { // from class: rx.b.g.2
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
