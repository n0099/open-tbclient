package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class FlowableWithLatestFrom<T, U, R> extends io.reactivex.internal.operators.flowable.a<T, R> {
    final io.reactivex.c.c<? super T, ? super U, ? extends R> combiner;
    final org.b.b<? extends U> onu;

    @Override // io.reactivex.g
    protected void a(org.b.c<? super R> cVar) {
        io.reactivex.subscribers.b bVar = new io.reactivex.subscribers.b(cVar);
        WithLatestFromSubscriber withLatestFromSubscriber = new WithLatestFromSubscriber(bVar, this.combiner);
        bVar.onSubscribe(withLatestFromSubscriber);
        this.onu.subscribe(new a(withLatestFromSubscriber));
        this.omT.a((j) withLatestFromSubscriber);
    }

    /* loaded from: classes7.dex */
    static final class WithLatestFromSubscriber<T, U, R> extends AtomicReference<U> implements io.reactivex.internal.a.a<T>, org.b.d {
        private static final long serialVersionUID = -312246233408980075L;
        final org.b.c<? super R> actual;
        final io.reactivex.c.c<? super T, ? super U, ? extends R> combiner;
        final AtomicReference<org.b.d> s = new AtomicReference<>();
        final AtomicLong requested = new AtomicLong();
        final AtomicReference<org.b.d> other = new AtomicReference<>();

        WithLatestFromSubscriber(org.b.c<? super R> cVar, io.reactivex.c.c<? super T, ? super U, ? extends R> cVar2) {
            this.actual = cVar;
            this.combiner = cVar2;
        }

        @Override // io.reactivex.j, org.b.c
        public void onSubscribe(org.b.d dVar) {
            SubscriptionHelper.deferredSetOnce(this.s, this.requested, dVar);
        }

        @Override // org.b.c
        public void onNext(T t) {
            if (!tryOnNext(t)) {
                this.s.get().request(1L);
            }
        }

        @Override // io.reactivex.internal.a.a
        public boolean tryOnNext(T t) {
            U u = get();
            if (u != null) {
                try {
                    this.actual.onNext(io.reactivex.internal.functions.a.k(this.combiner.apply(t, u), "The combiner returned a null value"));
                    return true;
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.J(th);
                    cancel();
                    this.actual.onError(th);
                    return false;
                }
            }
            return false;
        }

        @Override // org.b.c
        public void onError(Throwable th) {
            SubscriptionHelper.cancel(this.other);
            this.actual.onError(th);
        }

        @Override // org.b.c
        public void onComplete() {
            SubscriptionHelper.cancel(this.other);
            this.actual.onComplete();
        }

        @Override // org.b.d
        public void request(long j) {
            SubscriptionHelper.deferredRequest(this.s, this.requested, j);
        }

        @Override // org.b.d
        public void cancel() {
            SubscriptionHelper.cancel(this.s);
            SubscriptionHelper.cancel(this.other);
        }

        public boolean setOther(org.b.d dVar) {
            return SubscriptionHelper.setOnce(this.other, dVar);
        }

        public void otherError(Throwable th) {
            SubscriptionHelper.cancel(this.s);
            this.actual.onError(th);
        }
    }

    /* loaded from: classes7.dex */
    final class a implements j<U> {
        private final WithLatestFromSubscriber<T, U, R> onV;

        a(WithLatestFromSubscriber<T, U, R> withLatestFromSubscriber) {
            this.onV = withLatestFromSubscriber;
        }

        @Override // io.reactivex.j, org.b.c
        public void onSubscribe(org.b.d dVar) {
            if (this.onV.setOther(dVar)) {
                dVar.request(Long.MAX_VALUE);
            }
        }

        @Override // org.b.c
        public void onNext(U u) {
            this.onV.lazySet(u);
        }

        @Override // org.b.c
        public void onError(Throwable th) {
            this.onV.otherError(th);
        }

        @Override // org.b.c
        public void onComplete() {
        }
    }
}
