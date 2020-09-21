package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.h;
import rx.internal.subscriptions.CancellableSubscription;
import rx.internal.subscriptions.SequentialSubscription;
/* loaded from: classes7.dex */
public final class SingleFromEmitter<T> implements h.a<T> {
    final rx.functions.b<Object<T>> oNX;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // rx.functions.b
    /* renamed from: b */
    public void call(rx.i<? super T> iVar) {
        SingleEmitterImpl singleEmitterImpl = new SingleEmitterImpl(iVar);
        iVar.add(singleEmitterImpl);
        try {
            this.oNX.call(singleEmitterImpl);
        } catch (Throwable th) {
            rx.exceptions.a.J(th);
            singleEmitterImpl.onError(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class SingleEmitterImpl<T> extends AtomicBoolean implements rx.k {
        private static final long serialVersionUID = 8082834163465882809L;
        final rx.i<? super T> actual;
        final SequentialSubscription resource = new SequentialSubscription();

        SingleEmitterImpl(rx.i<? super T> iVar) {
            this.actual = iVar;
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

        public void onSuccess(T t) {
            if (compareAndSet(false, true)) {
                try {
                    this.actual.onSuccess(t);
                } finally {
                    this.resource.unsubscribe();
                }
            }
        }

        public void onError(Throwable th) {
            if (th == null) {
                th = new NullPointerException();
            }
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
    }
}
