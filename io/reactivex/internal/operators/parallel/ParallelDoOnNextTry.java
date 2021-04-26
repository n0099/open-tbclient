package io.reactivex.internal.operators.parallel;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.parallel.ParallelFailureHandling;
import io.reactivex.parallel.ParallelFlowable;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
/* loaded from: classes7.dex */
public final class ParallelDoOnNextTry<T> extends ParallelFlowable<T> {
    public final BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> errorHandler;
    public final Consumer<? super T> onNext;
    public final ParallelFlowable<T> source;

    /* renamed from: io.reactivex.internal.operators.parallel.ParallelDoOnNextTry$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$io$reactivex$parallel$ParallelFailureHandling;

        static {
            int[] iArr = new int[ParallelFailureHandling.values().length];
            $SwitchMap$io$reactivex$parallel$ParallelFailureHandling = iArr;
            try {
                iArr[ParallelFailureHandling.RETRY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$reactivex$parallel$ParallelFailureHandling[ParallelFailureHandling.SKIP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$reactivex$parallel$ParallelFailureHandling[ParallelFailureHandling.STOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class ParallelDoOnNextConditionalSubscriber<T> implements ConditionalSubscriber<T>, Subscription {
        public final ConditionalSubscriber<? super T> actual;
        public boolean done;
        public final BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> errorHandler;
        public final Consumer<? super T> onNext;
        public Subscription s;

        public ParallelDoOnNextConditionalSubscriber(ConditionalSubscriber<? super T> conditionalSubscriber, Consumer<? super T> consumer, BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> biFunction) {
            this.actual = conditionalSubscriber;
            this.onNext = consumer;
            this.errorHandler = biFunction;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.s.cancel();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.actual.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.done = true;
            this.actual.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (tryOnNext(t) || this.done) {
                return;
            }
            this.s.request(1L);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.s, subscription)) {
                this.s = subscription;
                this.actual.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            this.s.request(j);
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x003b  */
        @Override // io.reactivex.internal.fuseable.ConditionalSubscriber
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean tryOnNext(T t) {
            int i2;
            if (this.done) {
                return false;
            }
            long j = 0;
            do {
                try {
                    this.onNext.accept(t);
                    return this.actual.tryOnNext(t);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    try {
                        j++;
                        i2 = AnonymousClass1.$SwitchMap$io$reactivex$parallel$ParallelFailureHandling[((ParallelFailureHandling) ObjectHelper.requireNonNull(this.errorHandler.apply(Long.valueOf(j), th), "The errorHandler returned a null item")).ordinal()];
                        if (i2 != 1) {
                            if (i2 != 2) {
                            }
                            return false;
                        }
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        cancel();
                        onError(new CompositeException(th, th2));
                        return false;
                    }
                }
            } while (i2 != 1);
            if (i2 != 2) {
                if (i2 != 3) {
                    cancel();
                    onError(th);
                    return false;
                }
                cancel();
                onComplete();
            }
            return false;
        }
    }

    /* loaded from: classes7.dex */
    public static final class ParallelDoOnNextSubscriber<T> implements ConditionalSubscriber<T>, Subscription {
        public final Subscriber<? super T> actual;
        public boolean done;
        public final BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> errorHandler;
        public final Consumer<? super T> onNext;
        public Subscription s;

        public ParallelDoOnNextSubscriber(Subscriber<? super T> subscriber, Consumer<? super T> consumer, BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> biFunction) {
            this.actual = subscriber;
            this.onNext = consumer;
            this.errorHandler = biFunction;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.s.cancel();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.actual.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.done = true;
            this.actual.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (tryOnNext(t)) {
                return;
            }
            this.s.request(1L);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.s, subscription)) {
                this.s = subscription;
                this.actual.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            this.s.request(j);
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x003a  */
        @Override // io.reactivex.internal.fuseable.ConditionalSubscriber
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean tryOnNext(T t) {
            int i2;
            if (this.done) {
                return false;
            }
            long j = 0;
            do {
                try {
                    this.onNext.accept(t);
                    this.actual.onNext(t);
                    return true;
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    try {
                        j++;
                        i2 = AnonymousClass1.$SwitchMap$io$reactivex$parallel$ParallelFailureHandling[((ParallelFailureHandling) ObjectHelper.requireNonNull(this.errorHandler.apply(Long.valueOf(j), th), "The errorHandler returned a null item")).ordinal()];
                        if (i2 != 1) {
                            if (i2 != 2) {
                            }
                            return false;
                        }
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        cancel();
                        onError(new CompositeException(th, th2));
                        return false;
                    }
                }
            } while (i2 != 1);
            if (i2 != 2) {
                if (i2 != 3) {
                    cancel();
                    onError(th);
                    return false;
                }
                cancel();
                onComplete();
            }
            return false;
        }
    }

    public ParallelDoOnNextTry(ParallelFlowable<T> parallelFlowable, Consumer<? super T> consumer, BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> biFunction) {
        this.source = parallelFlowable;
        this.onNext = consumer;
        this.errorHandler = biFunction;
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public int parallelism() {
        return this.source.parallelism();
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public void subscribe(Subscriber<? super T>[] subscriberArr) {
        if (validate(subscriberArr)) {
            int length = subscriberArr.length;
            Subscriber<? super T>[] subscriberArr2 = new Subscriber[length];
            for (int i2 = 0; i2 < length; i2++) {
                Subscriber<? super T> subscriber = subscriberArr[i2];
                if (subscriber instanceof ConditionalSubscriber) {
                    subscriberArr2[i2] = new ParallelDoOnNextConditionalSubscriber((ConditionalSubscriber) subscriber, this.onNext, this.errorHandler);
                } else {
                    subscriberArr2[i2] = new ParallelDoOnNextSubscriber(subscriber, this.onNext, this.errorHandler);
                }
            }
            this.source.subscribe(subscriberArr2);
        }
    }
}
