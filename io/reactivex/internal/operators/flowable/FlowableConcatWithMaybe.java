package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscribers.SinglePostCompleteSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
/* loaded from: classes7.dex */
public final class FlowableConcatWithMaybe<T> extends AbstractFlowableWithUpstream<T, T> {
    public final MaybeSource<? extends T> other;

    /* loaded from: classes7.dex */
    public static final class ConcatWithSubscriber<T> extends SinglePostCompleteSubscriber<T, T> implements MaybeObserver<T> {
        public static final long serialVersionUID = -7346385463600070225L;
        public boolean inMaybe;
        public MaybeSource<? extends T> other;
        public final AtomicReference<Disposable> otherDisposable;

        public ConcatWithSubscriber(Subscriber<? super T> subscriber, MaybeSource<? extends T> maybeSource) {
            super(subscriber);
            this.other = maybeSource;
            this.otherDisposable = new AtomicReference<>();
        }

        @Override // io.reactivex.internal.subscribers.SinglePostCompleteSubscriber, org.reactivestreams.Subscription
        public void cancel() {
            super.cancel();
            DisposableHelper.dispose(this.otherDisposable);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.inMaybe) {
                this.actual.onComplete();
                return;
            }
            this.inMaybe = true;
            this.s = SubscriptionHelper.CANCELLED;
            MaybeSource<? extends T> maybeSource = this.other;
            this.other = null;
            maybeSource.subscribe(this);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.produced++;
            this.actual.onNext(t);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.otherDisposable, disposable);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(T t) {
            complete(t);
        }
    }

    public FlowableConcatWithMaybe(Flowable<T> flowable, MaybeSource<? extends T> maybeSource) {
        super(flowable);
        this.other = maybeSource;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe((FlowableSubscriber) new ConcatWithSubscriber(subscriber, this.other));
    }
}
