package rx.internal.operators;

import java.util.NoSuchElementException;
import rx.h;
/* loaded from: classes2.dex */
public class t<T> implements h.a<T> {
    private final rx.d<T> iuM;

    public t(rx.d<T> dVar) {
        this.iuM = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // rx.functions.b
    /* renamed from: b */
    public void call(final rx.i<? super T> iVar) {
        rx.j<T> jVar = new rx.j<T>() { // from class: rx.internal.operators.t.1
            private boolean iuN;
            private boolean iuO;
            private T iuP;

            @Override // rx.j
            public void onStart() {
                request(2L);
            }

            @Override // rx.e
            public void onCompleted() {
                if (!this.iuN) {
                    if (this.iuO) {
                        iVar.onSuccess(this.iuP);
                    } else {
                        iVar.onError(new NoSuchElementException("Observable emitted no items"));
                    }
                }
            }

            @Override // rx.e
            public void onError(Throwable th) {
                iVar.onError(th);
                unsubscribe();
            }

            @Override // rx.e
            public void onNext(T t) {
                if (this.iuO) {
                    this.iuN = true;
                    iVar.onError(new IllegalArgumentException("Observable emitted too many elements"));
                    unsubscribe();
                    return;
                }
                this.iuO = true;
                this.iuP = t;
            }
        };
        iVar.add(jVar);
        this.iuM.unsafeSubscribe(jVar);
    }

    public static <T> t<T> g(rx.d<T> dVar) {
        return new t<>(dVar);
    }
}
