package rx.internal.operators;

import java.util.NoSuchElementException;
import rx.h;
/* loaded from: classes2.dex */
public class t<T> implements h.a<T> {
    private final rx.d<T> iHX;

    public t(rx.d<T> dVar) {
        this.iHX = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // rx.functions.b
    /* renamed from: b */
    public void call(final rx.i<? super T> iVar) {
        rx.j<T> jVar = new rx.j<T>() { // from class: rx.internal.operators.t.1
            private boolean iHY;
            private boolean iHZ;
            private T iIa;

            @Override // rx.j
            public void onStart() {
                request(2L);
            }

            @Override // rx.e
            public void onCompleted() {
                if (!this.iHY) {
                    if (this.iHZ) {
                        iVar.onSuccess(this.iIa);
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
                if (this.iHZ) {
                    this.iHY = true;
                    iVar.onError(new IllegalArgumentException("Observable emitted too many elements"));
                    unsubscribe();
                    return;
                }
                this.iHZ = true;
                this.iIa = t;
            }
        };
        iVar.add(jVar);
        this.iHX.unsafeSubscribe(jVar);
    }

    public static <T> t<T> g(rx.d<T> dVar) {
        return new t<>(dVar);
    }
}
