package rx.b;

import rx.exceptions.OnErrorNotImplementedException;
/* loaded from: classes7.dex */
public final class a {
    private static final rx.e<Object> oTh = new rx.e<Object>() { // from class: rx.b.a.1
        @Override // rx.e
        public final void onCompleted() {
        }

        @Override // rx.e
        public final void onError(Throwable th) {
            throw new OnErrorNotImplementedException(th);
        }

        @Override // rx.e
        public final void onNext(Object obj) {
        }
    };

    public static <T> rx.e<T> eoR() {
        return (rx.e<T>) oTh;
    }
}
