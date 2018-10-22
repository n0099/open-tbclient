package rx.internal.operators;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import rx.d;
import rx.internal.producers.SingleProducer;
/* loaded from: classes2.dex */
public final class ab {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a<T> implements d.a<T> {
        final Future<? extends T> ivb;
        private final long time;
        private final TimeUnit unit;

        @Override // rx.functions.b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((rx.j) ((rx.j) obj));
        }

        public a(Future<? extends T> future) {
            this.ivb = future;
            this.time = 0L;
            this.unit = null;
        }

        public a(Future<? extends T> future, long j, TimeUnit timeUnit) {
            this.ivb = future;
            this.time = j;
            this.unit = timeUnit;
        }

        public void call(rx.j<? super T> jVar) {
            jVar.add(rx.subscriptions.e.j(new rx.functions.a() { // from class: rx.internal.operators.ab.a.1
                @Override // rx.functions.a
                public void call() {
                    a.this.ivb.cancel(true);
                }
            }));
            try {
                if (!jVar.isUnsubscribed()) {
                    jVar.setProducer(new SingleProducer(jVar, this.unit == null ? this.ivb.get() : this.ivb.get(this.time, this.unit)));
                }
            } catch (Throwable th) {
                if (!jVar.isUnsubscribed()) {
                    rx.exceptions.a.a(th, jVar);
                }
            }
        }
    }

    public static <T> d.a<T> b(Future<? extends T> future) {
        return new a(future);
    }

    public static <T> d.a<T> a(Future<? extends T> future, long j, TimeUnit timeUnit) {
        return new a(future, j, timeUnit);
    }
}
