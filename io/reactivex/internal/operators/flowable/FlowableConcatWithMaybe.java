package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscribers.SinglePostCompleteSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import io.reactivex.m;
import io.reactivex.o;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class FlowableConcatWithMaybe<T> extends a<T, T> {
    final o<? extends T> other;

    @Override // io.reactivex.g
    protected void a(org.a.c<? super T> cVar) {
        this.nwE.a((j) new ConcatWithSubscriber(cVar, this.other));
    }

    /* loaded from: classes7.dex */
    static final class ConcatWithSubscriber<T> extends SinglePostCompleteSubscriber<T, T> implements m<T> {
        private static final long serialVersionUID = -7346385463600070225L;
        boolean inMaybe;
        o<? extends T> other;
        final AtomicReference<io.reactivex.disposables.b> otherDisposable;

        ConcatWithSubscriber(org.a.c<? super T> cVar, o<? extends T> oVar) {
            super(cVar);
            this.other = oVar;
            this.otherDisposable = new AtomicReference<>();
        }

        @Override // io.reactivex.m
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

        @Override // io.reactivex.m
        public void onSuccess(T t) {
            complete(t);
        }

        @Override // org.a.c
        public void onComplete() {
            if (this.inMaybe) {
                this.actual.onComplete();
                return;
            }
            this.inMaybe = true;
            this.s = SubscriptionHelper.CANCELLED;
            o<? extends T> oVar = this.other;
            this.other = null;
            oVar.a(this);
        }

        @Override // io.reactivex.internal.subscribers.SinglePostCompleteSubscriber, org.a.d
        public void cancel() {
            super.cancel();
            DisposableHelper.dispose(this.otherDisposable);
        }
    }
}
