package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import rx.g;
import rx.h;
/* loaded from: classes6.dex */
public final class r<T> implements h.a<T> {
    final long delay;
    final h.a<T> onp;
    final rx.g scheduler;
    final TimeUnit unit;

    public r(h.a<T> aVar, long j, TimeUnit timeUnit, rx.g gVar) {
        this.onp = aVar;
        this.scheduler = gVar;
        this.delay = j;
        this.unit = timeUnit;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // rx.functions.b
    /* renamed from: b */
    public void call(rx.i<? super T> iVar) {
        g.a createWorker = this.scheduler.createWorker();
        a aVar = new a(iVar, createWorker, this.delay, this.unit);
        iVar.add(createWorker);
        iVar.add(aVar);
        this.onp.call(aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class a<T> extends rx.i<T> implements rx.functions.a {
        final rx.i<? super T> actual;
        final long delay;
        Throwable error;
        final g.a onq;
        final TimeUnit unit;
        T value;

        public a(rx.i<? super T> iVar, g.a aVar, long j, TimeUnit timeUnit) {
            this.actual = iVar;
            this.onq = aVar;
            this.delay = j;
            this.unit = timeUnit;
        }

        @Override // rx.i
        public void onSuccess(T t) {
            this.value = t;
            this.onq.a(this, this.delay, this.unit);
        }

        @Override // rx.i
        public void onError(Throwable th) {
            this.error = th;
            this.onq.a(this, this.delay, this.unit);
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
                this.onq.unsubscribe();
            }
        }
    }
}
