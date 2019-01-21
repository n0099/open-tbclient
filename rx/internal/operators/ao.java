package rx.internal.operators;

import java.util.HashSet;
import java.util.Set;
import rx.d;
import rx.internal.util.UtilityFunctions;
/* loaded from: classes2.dex */
public final class ao<T, U> implements d.b<T, T> {
    final rx.functions.f<? super T, ? extends U> iIh;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a {
        static final ao<?, ?> iJs = new ao<>(UtilityFunctions.cfU());
    }

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public static <T> ao<T, T> ceR() {
        return (ao<T, T>) a.iJs;
    }

    public ao(rx.functions.f<? super T, ? extends U> fVar) {
        this.iIh = fVar;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: rx.j<T>, rx.j<? super T> */
    public rx.j<? super T> call(final rx.j<? super T> jVar) {
        return (rx.j<T>) new rx.j<T>(jVar) { // from class: rx.internal.operators.ao.1
            Set<U> iJq = new HashSet();

            @Override // rx.e
            public void onNext(T t) {
                if (this.iJq.add(ao.this.iIh.call(t))) {
                    jVar.onNext(t);
                } else {
                    request(1L);
                }
            }

            @Override // rx.e
            public void onError(Throwable th) {
                this.iJq = null;
                jVar.onError(th);
            }

            @Override // rx.e
            public void onCompleted() {
                this.iJq = null;
                jVar.onCompleted();
            }
        };
    }
}
