package io.reactivex.processors;

import f.a.b0.a;
import g.d.c;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
/* loaded from: classes7.dex */
public final class AsyncProcessor<T> extends a<T> {

    /* loaded from: classes7.dex */
    public static final class AsyncSubscription<T> extends DeferredScalarSubscription<T> {
        public static final long serialVersionUID = 5629876084736248016L;
        public final AsyncProcessor<T> parent;

        public AsyncSubscription(c<? super T> cVar, AsyncProcessor<T> asyncProcessor) {
            super(cVar);
            this.parent = asyncProcessor;
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, io.reactivex.internal.subscriptions.BasicIntQueueSubscription, g.d.d
        public void cancel() {
            if (super.tryCancel()) {
                this.parent.d(this);
            }
        }

        public void onComplete() {
            if (isCancelled()) {
                return;
            }
            this.actual.onComplete();
        }

        public void onError(Throwable th) {
            if (isCancelled()) {
                f.a.a0.a.f(th);
            } else {
                this.actual.onError(th);
            }
        }
    }

    public abstract void d(AsyncSubscription<T> asyncSubscription);
}
