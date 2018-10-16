package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import rx.d;
import rx.g;
/* loaded from: classes2.dex */
public final class bu<T> implements d.b<T, T> {
    final rx.g scheduler;
    final long time;
    final TimeUnit unit;

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public bu(long j, TimeUnit timeUnit, rx.g gVar) {
        this.time = j;
        this.unit = timeUnit;
        this.scheduler = gVar;
    }

    public rx.j<? super T> call(rx.j<? super T> jVar) {
        g.a createWorker = this.scheduler.createWorker();
        jVar.add(createWorker);
        a aVar = new a(new rx.b.f(jVar));
        createWorker.a(aVar, this.time, this.unit);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a<T> extends rx.j<T> implements rx.functions.a {
        final rx.j<? super T> child;

        public a(rx.j<? super T> jVar) {
            super(jVar);
            this.child = jVar;
        }

        @Override // rx.e
        public void onNext(T t) {
            this.child.onNext(t);
        }

        @Override // rx.e
        public void onError(Throwable th) {
            this.child.onError(th);
            unsubscribe();
        }

        @Override // rx.e
        public void onCompleted() {
            this.child.onCompleted();
            unsubscribe();
        }

        @Override // rx.functions.a
        public void call() {
            onCompleted();
        }
    }
}
