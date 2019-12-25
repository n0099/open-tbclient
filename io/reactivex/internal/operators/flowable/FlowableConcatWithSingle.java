package io.reactivex.internal.operators.flowable;

import io.reactivex.aa;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscribers.SinglePostCompleteSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import io.reactivex.y;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes4.dex */
public final class FlowableConcatWithSingle<T> extends a<T, T> {
    final aa<? extends T> other;

    @Override // io.reactivex.g
    protected void a(org.a.c<? super T> cVar) {
        this.mTG.a((j) new ConcatWithSubscriber(cVar, this.other));
    }

    /* loaded from: classes4.dex */
    static final class ConcatWithSubscriber<T> extends SinglePostCompleteSubscriber<T, T> implements y<T> {
        private static final long serialVersionUID = -7346385463600070225L;
        aa<? extends T> other;
        final AtomicReference<io.reactivex.disposables.b> otherDisposable;

        ConcatWithSubscriber(org.a.c<? super T> cVar, aa<? extends T> aaVar) {
            super(cVar);
            this.other = aaVar;
            this.otherDisposable = new AtomicReference<>();
        }

        @Override // io.reactivex.y
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.setOnce(this.otherDisposable, bVar);
        }

        @Override // org.a.c
        public void onNext(T t) {
            this.produced++;
            this.actual.onNext(t);
        }

        @Override // org.a.c
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // io.reactivex.y
        public void onSuccess(T t) {
            complete(t);
        }

        @Override // org.a.c
        public void onComplete() {
            this.s = SubscriptionHelper.CANCELLED;
            aa<? extends T> aaVar = this.other;
            this.other = null;
            aaVar.a(this);
        }

        @Override // io.reactivex.internal.subscribers.SinglePostCompleteSubscriber, org.a.d
        public void cancel() {
            super.cancel();
            DisposableHelper.dispose(this.otherDisposable);
        }
    }
}
