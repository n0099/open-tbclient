package rx.internal.operators;

import rx.d;
/* loaded from: classes2.dex */
public final class bh<T> implements d.b<T, T> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a {
        static final bh<Object> iMe = new bh<>();
    }

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public static <T> bh<T> cfo() {
        return (bh<T>) a.iMe;
    }

    bh() {
    }

    public rx.j<? super T> call(final rx.j<? super T> jVar) {
        return new rx.b.f(new rx.j<T>(jVar) { // from class: rx.internal.operators.bh.1
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
        });
    }
}
