package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.d;
import rx.g;
/* loaded from: classes2.dex */
public final class be<T> implements d.b<T, T> {
    final rx.g scheduler;
    final long time;
    final TimeUnit unit;

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public be(long j, TimeUnit timeUnit, rx.g gVar) {
        this.time = j;
        this.unit = timeUnit;
        this.scheduler = gVar;
    }

    public rx.j<? super T> call(rx.j<? super T> jVar) {
        rx.b.f fVar = new rx.b.f(jVar);
        g.a createWorker = this.scheduler.createWorker();
        jVar.add(createWorker);
        a aVar = new a(fVar);
        jVar.add(aVar);
        createWorker.a(aVar, this.time, this.time, this.unit);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a<T> extends rx.j<T> implements rx.functions.a {
        private static final Object iyE = new Object();
        private final rx.j<? super T> subscriber;
        final AtomicReference<Object> value = new AtomicReference<>(iyE);

        public a(rx.j<? super T> jVar) {
            this.subscriber = jVar;
        }

        @Override // rx.j
        public void onStart() {
            request(Long.MAX_VALUE);
        }

        @Override // rx.e
        public void onNext(T t) {
            this.value.set(t);
        }

        @Override // rx.e
        public void onError(Throwable th) {
            this.subscriber.onError(th);
            unsubscribe();
        }

        @Override // rx.e
        public void onCompleted() {
            ccp();
            this.subscriber.onCompleted();
            unsubscribe();
        }

        @Override // rx.functions.a
        public void call() {
            ccp();
        }

        private void ccp() {
            Object andSet = this.value.getAndSet(iyE);
            if (andSet != iyE) {
                try {
                    this.subscriber.onNext(andSet);
                } catch (Throwable th) {
                    rx.exceptions.a.a(th, this);
                }
            }
        }
    }
}
