package io.reactivex.internal.operators.maybe;

import io.reactivex.FlowableSubscriber;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;
/* loaded from: classes7.dex */
public final class MaybeDelaySubscriptionOtherPublisher<T, U> extends AbstractMaybeWithUpstream<T, T> {
    public final Publisher<U> other;

    /* loaded from: classes7.dex */
    public static final class DelayMaybeObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T> {
        public static final long serialVersionUID = 706635022205076709L;
        public final MaybeObserver<? super T> actual;

        public DelayMaybeObserver(MaybeObserver<? super T> maybeObserver) {
            this.actual = maybeObserver;
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            this.actual.onComplete();
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(T t) {
            this.actual.onSuccess(t);
        }
    }

    /* loaded from: classes7.dex */
    public static final class OtherSubscriber<T> implements FlowableSubscriber<Object>, Disposable {
        public final DelayMaybeObserver<T> main;
        public Subscription s;
        public MaybeSource<T> source;

        public OtherSubscriber(MaybeObserver<? super T> maybeObserver, MaybeSource<T> maybeSource) {
            this.main = new DelayMaybeObserver<>(maybeObserver);
            this.source = maybeSource;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.s.cancel();
            this.s = SubscriptionHelper.CANCELLED;
            DisposableHelper.dispose(this.main);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.main.get());
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            Subscription subscription = this.s;
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (subscription != subscriptionHelper) {
                this.s = subscriptionHelper;
                subscribeNext();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            Subscription subscription = this.s;
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (subscription != subscriptionHelper) {
                this.s = subscriptionHelper;
                this.main.actual.onError(th);
                return;
            }
            RxJavaPlugins.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(Object obj) {
            Subscription subscription = this.s;
            if (subscription != SubscriptionHelper.CANCELLED) {
                subscription.cancel();
                this.s = SubscriptionHelper.CANCELLED;
                subscribeNext();
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.s, subscription)) {
                this.s = subscription;
                this.main.actual.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public void subscribeNext() {
            MaybeSource<T> maybeSource = this.source;
            this.source = null;
            maybeSource.subscribe(this.main);
        }
    }

    public MaybeDelaySubscriptionOtherPublisher(MaybeSource<T> maybeSource, Publisher<U> publisher) {
        super(maybeSource);
        this.other = publisher;
    }

    @Override // io.reactivex.Maybe
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.other.subscribe(new OtherSubscriber(maybeObserver, this.source));
    }
}
