package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import rx.d;
import rx.g;
/* loaded from: classes2.dex */
public final class u<T> implements d.a<T> {
    final rx.d<T> isM;
    final rx.g scheduler;
    final long time;
    final TimeUnit unit;

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.j) ((rx.j) obj));
    }

    public u(rx.d<T> dVar, long j, TimeUnit timeUnit, rx.g gVar) {
        this.isM = dVar;
        this.time = j;
        this.unit = timeUnit;
        this.scheduler = gVar;
    }

    public void call(rx.j<? super T> jVar) {
        g.a createWorker = this.scheduler.createWorker();
        a aVar = new a(jVar);
        aVar.add(createWorker);
        jVar.add(aVar);
        createWorker.a(aVar, this.time, this.unit);
        this.isM.unsafeSubscribe(aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a<T> extends rx.j<T> implements rx.functions.a {
        final rx.j<? super T> child;
        volatile boolean iuS;

        a(rx.j<? super T> jVar) {
            this.child = jVar;
        }

        @Override // rx.functions.a
        public void call() {
            this.iuS = true;
        }

        @Override // rx.e
        public void onNext(T t) {
            if (this.iuS) {
                this.child.onNext(t);
            }
        }

        @Override // rx.e
        public void onError(Throwable th) {
            try {
                this.child.onError(th);
            } finally {
                unsubscribe();
            }
        }

        @Override // rx.e
        public void onCompleted() {
            try {
                this.child.onCompleted();
            } finally {
                unsubscribe();
            }
        }
    }
}
