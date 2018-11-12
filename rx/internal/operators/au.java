package rx.internal.operators;

import rx.d;
/* loaded from: classes2.dex */
public class au<T> implements d.b<T, T> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a {
        static final au<?> iyw = new au<>();
    }

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public static <T> au<T> cbt() {
        return (au<T>) a.iyw;
    }

    au() {
    }

    public rx.j<? super T> call(final rx.j<? super T> jVar) {
        rx.j jVar2 = (rx.j<T>) new rx.j<T>() { // from class: rx.internal.operators.au.1
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
            }
        };
        jVar.add(jVar2);
        return jVar2;
    }
}
