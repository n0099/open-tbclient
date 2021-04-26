package io.reactivex.internal.operators.mixed;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.annotations.Experimental;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
@Experimental
/* loaded from: classes7.dex */
public final class FlowableConcatMapMaybe<T, R> extends Flowable<R> {
    public final ErrorMode errorMode;
    public final Function<? super T, ? extends MaybeSource<? extends R>> mapper;
    public final int prefetch;
    public final Flowable<T> source;

    /* loaded from: classes7.dex */
    public static final class ConcatMapMaybeSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        public static final int STATE_ACTIVE = 1;
        public static final int STATE_INACTIVE = 0;
        public static final int STATE_RESULT_VALUE = 2;
        public static final long serialVersionUID = -9140123220065488293L;
        public volatile boolean cancelled;
        public int consumed;
        public volatile boolean done;
        public final Subscriber<? super R> downstream;
        public long emitted;
        public final ErrorMode errorMode;
        public R item;
        public final Function<? super T, ? extends MaybeSource<? extends R>> mapper;
        public final int prefetch;
        public final SimplePlainQueue<T> queue;
        public volatile int state;
        public Subscription upstream;
        public final AtomicLong requested = new AtomicLong();
        public final AtomicThrowable errors = new AtomicThrowable();
        public final ConcatMapMaybeObserver<R> inner = new ConcatMapMaybeObserver<>(this);

        /* loaded from: classes7.dex */
        public static final class ConcatMapMaybeObserver<R> extends AtomicReference<Disposable> implements MaybeObserver<R> {
            public static final long serialVersionUID = -3051469169682093892L;
            public final ConcatMapMaybeSubscriber<?, R> parent;

            public ConcatMapMaybeObserver(ConcatMapMaybeSubscriber<?, R> concatMapMaybeSubscriber) {
                this.parent = concatMapMaybeSubscriber;
            }

            public void dispose() {
                DisposableHelper.dispose(this);
            }

            @Override // io.reactivex.MaybeObserver
            public void onComplete() {
                this.parent.innerComplete();
            }

            @Override // io.reactivex.MaybeObserver
            public void onError(Throwable th) {
                this.parent.innerError(th);
            }

            @Override // io.reactivex.MaybeObserver
            public void onSubscribe(Disposable disposable) {
                DisposableHelper.replace(this, disposable);
            }

            @Override // io.reactivex.MaybeObserver
            public void onSuccess(R r) {
                this.parent.innerSuccess(r);
            }
        }

        public ConcatMapMaybeSubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends MaybeSource<? extends R>> function, int i2, ErrorMode errorMode) {
            this.downstream = subscriber;
            this.mapper = function;
            this.prefetch = i2;
            this.errorMode = errorMode;
            this.queue = new SpscArrayQueue(i2);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.cancelled = true;
            this.upstream.cancel();
            this.inner.dispose();
            if (getAndIncrement() != 0) {
                this.queue.clear();
                this.item = null;
            }
        }

        /* JADX DEBUG: Type inference failed for r8v11. Raw type applied. Possible types: R, ? super R */
        public void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            Subscriber<? super R> subscriber = this.downstream;
            ErrorMode errorMode = this.errorMode;
            SimplePlainQueue<T> simplePlainQueue = this.queue;
            AtomicThrowable atomicThrowable = this.errors;
            AtomicLong atomicLong = this.requested;
            int i2 = this.prefetch;
            int i3 = i2 - (i2 >> 1);
            int i4 = 1;
            while (true) {
                if (this.cancelled) {
                    simplePlainQueue.clear();
                    this.item = null;
                }
                int i5 = this.state;
                if (atomicThrowable.get() == null || (errorMode != ErrorMode.IMMEDIATE && (errorMode != ErrorMode.BOUNDARY || i5 != 0))) {
                    if (i5 == 0) {
                        boolean z = this.done;
                        T poll = simplePlainQueue.poll();
                        boolean z2 = poll == null;
                        if (z && z2) {
                            Throwable terminate = atomicThrowable.terminate();
                            if (terminate == null) {
                                subscriber.onComplete();
                                return;
                            } else {
                                subscriber.onError(terminate);
                                return;
                            }
                        } else if (!z2) {
                            int i6 = this.consumed + 1;
                            if (i6 == i3) {
                                this.consumed = 0;
                                this.upstream.request(i3);
                            } else {
                                this.consumed = i6;
                            }
                            try {
                                MaybeSource maybeSource = (MaybeSource) ObjectHelper.requireNonNull(this.mapper.apply(poll), "The mapper returned a null MaybeSource");
                                this.state = 1;
                                maybeSource.subscribe(this.inner);
                            } catch (Throwable th) {
                                Exceptions.throwIfFatal(th);
                                this.upstream.cancel();
                                simplePlainQueue.clear();
                                atomicThrowable.addThrowable(th);
                                subscriber.onError(atomicThrowable.terminate());
                                return;
                            }
                        }
                    } else if (i5 == 2) {
                        long j = this.emitted;
                        if (j != atomicLong.get()) {
                            this.item = null;
                            subscriber.onNext((R) this.item);
                            this.emitted = j + 1;
                            this.state = 0;
                        }
                    }
                    i4 = addAndGet(-i4);
                    if (i4 == 0) {
                        return;
                    }
                }
            }
            simplePlainQueue.clear();
            this.item = null;
            subscriber.onError(atomicThrowable.terminate());
        }

        public void innerComplete() {
            this.state = 0;
            drain();
        }

        public void innerError(Throwable th) {
            if (this.errors.addThrowable(th)) {
                if (this.errorMode != ErrorMode.END) {
                    this.upstream.cancel();
                }
                this.state = 0;
                drain();
                return;
            }
            RxJavaPlugins.onError(th);
        }

        public void innerSuccess(R r) {
            this.item = r;
            this.state = 2;
            drain();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.errors.addThrowable(th)) {
                if (this.errorMode == ErrorMode.IMMEDIATE) {
                    this.inner.dispose();
                }
                this.done = true;
                drain();
                return;
            }
            RxJavaPlugins.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (!this.queue.offer(t)) {
                this.upstream.cancel();
                onError(new MissingBackpressureException("queue full?!"));
                return;
            }
            drain();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                this.downstream.onSubscribe(this);
                subscription.request(this.prefetch);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            BackpressureHelper.add(this.requested, j);
            drain();
        }
    }

    public FlowableConcatMapMaybe(Flowable<T> flowable, Function<? super T, ? extends MaybeSource<? extends R>> function, ErrorMode errorMode, int i2) {
        this.source = flowable;
        this.mapper = function;
        this.errorMode = errorMode;
        this.prefetch = i2;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super R> subscriber) {
        this.source.subscribe((FlowableSubscriber) new ConcatMapMaybeSubscriber(subscriber, this.mapper, this.prefetch, this.errorMode));
    }
}
