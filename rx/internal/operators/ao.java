package rx.internal.operators;

import java.util.HashSet;
import java.util.Set;
import rx.d;
import rx.internal.util.UtilityFunctions;
/* loaded from: classes2.dex */
public final class ao<T, U> implements d.b<T, T> {
    final rx.functions.f<? super T, ? extends U> iIg;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a {
        static final ao<?, ?> iJr = new ao<>(UtilityFunctions.cfU());
    }

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public static <T> ao<T, T> ceR() {
        return (ao<T, T>) a.iJr;
    }

    public ao(rx.functions.f<? super T, ? extends U> fVar) {
        this.iIg = fVar;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: rx.j<T>, rx.j<? super T> */
    public rx.j<? super T> call(final rx.j<? super T> jVar) {
        return (rx.j<T>) new rx.j<T>(jVar) { // from class: rx.internal.operators.ao.1
            Set<U> iJp = new HashSet();

            @Override // rx.e
            public void onNext(T t) {
                if (this.iJp.add(ao.this.iIg.call(t))) {
                    jVar.onNext(t);
                } else {
                    request(1L);
                }
            }

            @Override // rx.e
            public void onError(Throwable th) {
                this.iJp = null;
                jVar.onError(th);
            }

            @Override // rx.e
            public void onCompleted() {
                this.iJp = null;
                jVar.onCompleted();
            }
        };
    }
}
