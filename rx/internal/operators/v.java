package rx.internal.operators;

import rx.d;
/* loaded from: classes2.dex */
public final class v<T> implements d.a<T> {
    final rx.d<T> iFW;

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.j) ((rx.j) obj));
    }

    public v(rx.d<T> dVar) {
        this.iFW = dVar;
    }

    public void call(rx.j<? super T> jVar) {
        new a(jVar).c(this.iFW);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a<T> extends b<T, T> {
        static final Object EMPTY = new Object();

        /* JADX WARN: Type inference failed for: r0v0, types: [R, java.lang.Object] */
        public a(rx.j<? super T> jVar) {
            super(jVar);
            this.value = EMPTY;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: T */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // rx.e
        public void onNext(T t) {
            this.value = t;
        }

        @Override // rx.internal.operators.b, rx.e
        public void onCompleted() {
            Object obj = this.value;
            if (obj == EMPTY) {
                complete();
            } else {
                complete(obj);
            }
        }
    }
}
