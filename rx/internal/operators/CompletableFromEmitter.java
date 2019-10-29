package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.b;
import rx.internal.subscriptions.CancellableSubscription;
import rx.internal.subscriptions.SequentialSubscription;
/* loaded from: classes2.dex */
public final class CompletableFromEmitter implements b.a {
    final rx.functions.b<Object> kzf;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // rx.functions.b
    /* renamed from: c */
    public void call(rx.c cVar) {
        FromEmitter fromEmitter = new FromEmitter(cVar);
        cVar.onSubscribe(fromEmitter);
        try {
            this.kzf.call(fromEmitter);
        } catch (Throwable th) {
            rx.exceptions.a.J(th);
            fromEmitter.onError(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class FromEmitter extends AtomicBoolean implements rx.k {
        private static final long serialVersionUID = 5539301318568668881L;
        final rx.c actual;
        final SequentialSubscription resource = new SequentialSubscription();

        public FromEmitter(rx.c cVar) {
            this.actual = cVar;
        }

        public void onCompleted() {
            if (compareAndSet(false, true)) {
                try {
                    this.actual.onCompleted();
                } finally {
                    this.resource.unsubscribe();
                }
            }
        }

        public void onError(Throwable th) {
            if (compareAndSet(false, true)) {
                try {
                    this.actual.onError(th);
                    return;
                } finally {
                    this.resource.unsubscribe();
                }
            }
            rx.c.c.onError(th);
        }

        public void setSubscription(rx.k kVar) {
            this.resource.update(kVar);
        }

        public void setCancellation(rx.functions.d dVar) {
            setSubscription(new CancellableSubscription(dVar));
        }

        @Override // rx.k
        public void unsubscribe() {
            if (compareAndSet(false, true)) {
                this.resource.unsubscribe();
            }
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return get();
        }
    }
}
