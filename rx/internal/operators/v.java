package rx.internal.operators;

import rx.g;
import rx.h;
/* loaded from: classes5.dex */
public final class v<T> implements h.a<T> {
    final h.a<T> nQh;
    final rx.g scheduler;

    public v(h.a<T> aVar, rx.g gVar) {
        this.nQh = aVar;
        this.scheduler = gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // rx.functions.b
    /* renamed from: b */
    public void call(rx.i<? super T> iVar) {
        g.a createWorker = this.scheduler.createWorker();
        a aVar = new a(iVar, createWorker);
        iVar.add(createWorker);
        iVar.add(aVar);
        this.nQh.call(aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class a<T> extends rx.i<T> implements rx.functions.a {
        final rx.i<? super T> actual;
        Throwable error;
        final g.a nQi;
        T value;

        public a(rx.i<? super T> iVar, g.a aVar) {
            this.actual = iVar;
            this.nQi = aVar;
        }

        @Override // rx.i
        public void onSuccess(T t) {
            this.value = t;
            this.nQi.c(this);
        }

        @Override // rx.i
        public void onError(Throwable th) {
            this.error = th;
            this.nQi.c(this);
        }

        @Override // rx.functions.a
        public void call() {
            try {
                Throwable th = this.error;
                if (th != null) {
                    this.error = null;
                    this.actual.onError(th);
                } else {
                    T t = this.value;
                    this.value = null;
                    this.actual.onSuccess(t);
                }
            } finally {
                this.nQi.unsubscribe();
            }
        }
    }
}
