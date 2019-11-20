package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import rx.g;
import rx.h;
/* loaded from: classes2.dex */
public final class o<T> implements h.a<T> {
    final h.a<T> kBE;
    final long kBF;
    final rx.g scheduler;
    final TimeUnit unit;

    public o(h.a<T> aVar, long j, TimeUnit timeUnit, rx.g gVar) {
        this.kBE = aVar;
        this.scheduler = gVar;
        this.kBF = j;
        this.unit = timeUnit;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // rx.functions.b
    /* renamed from: b */
    public void call(rx.i<? super T> iVar) {
        g.a createWorker = this.scheduler.createWorker();
        a aVar = new a(iVar, createWorker, this.kBF, this.unit);
        iVar.add(createWorker);
        iVar.add(aVar);
        this.kBE.call(aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a<T> extends rx.i<T> implements rx.functions.a {
        final rx.i<? super T> actual;
        Throwable error;
        final long kBF;
        final g.a kBG;
        final TimeUnit unit;
        T value;

        public a(rx.i<? super T> iVar, g.a aVar, long j, TimeUnit timeUnit) {
            this.actual = iVar;
            this.kBG = aVar;
            this.kBF = j;
            this.unit = timeUnit;
        }

        @Override // rx.i
        public void onSuccess(T t) {
            this.value = t;
            this.kBG.a(this, this.kBF, this.unit);
        }

        @Override // rx.i
        public void onError(Throwable th) {
            this.error = th;
            this.kBG.a(this, this.kBF, this.unit);
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
                this.kBG.unsubscribe();
            }
        }
    }
}
