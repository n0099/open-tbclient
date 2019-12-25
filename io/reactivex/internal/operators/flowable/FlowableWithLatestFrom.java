package io.reactivex.internal.operators.flowable;

import com.google.android.exoplayer2.Format;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.a.d;
/* loaded from: classes4.dex */
public final class FlowableWithLatestFrom<T, U, R> extends io.reactivex.internal.operators.flowable.a<T, R> {
    final io.reactivex.b.c<? super T, ? super U, ? extends R> combiner;
    final org.a.b<? extends U> other;

    @Override // io.reactivex.g
    protected void a(org.a.c<? super R> cVar) {
        io.reactivex.subscribers.b bVar = new io.reactivex.subscribers.b(cVar);
        WithLatestFromSubscriber withLatestFromSubscriber = new WithLatestFromSubscriber(bVar, this.combiner);
        bVar.onSubscribe(withLatestFromSubscriber);
        this.other.subscribe(new a(withLatestFromSubscriber));
        this.mTG.a((j) withLatestFromSubscriber);
    }

    /* loaded from: classes4.dex */
    static final class WithLatestFromSubscriber<T, U, R> extends AtomicReference<U> implements io.reactivex.internal.a.a<T>, d {
        private static final long serialVersionUID = -312246233408980075L;
        final org.a.c<? super R> actual;
        final io.reactivex.b.c<? super T, ? super U, ? extends R> combiner;
        final AtomicReference<d> s = new AtomicReference<>();
        final AtomicLong requested = new AtomicLong();
        final AtomicReference<d> other = new AtomicReference<>();

        WithLatestFromSubscriber(org.a.c<? super R> cVar, io.reactivex.b.c<? super T, ? super U, ? extends R> cVar2) {
            this.actual = cVar;
            this.combiner = cVar2;
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(d dVar) {
            SubscriptionHelper.deferredSetOnce(this.s, this.requested, dVar);
        }

        @Override // org.a.c
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
                    this.actual.onNext(io.reactivex.internal.functions.a.h(this.combiner.apply(t, u), "The combiner returned a null value"));
                    return true;
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.I(th);
                    cancel();
                    this.actual.onError(th);
                    return false;
                }
            }
            return false;
        }

        @Override // org.a.c
        public void onError(Throwable th) {
            SubscriptionHelper.cancel(this.other);
            this.actual.onError(th);
        }

        @Override // org.a.c
        public void onComplete() {
            SubscriptionHelper.cancel(this.other);
            this.actual.onComplete();
        }

        @Override // org.a.d
        public void request(long j) {
            SubscriptionHelper.deferredRequest(this.s, this.requested, j);
        }

        @Override // org.a.d
        public void cancel() {
            SubscriptionHelper.cancel(this.s);
            SubscriptionHelper.cancel(this.other);
        }

        public boolean setOther(d dVar) {
            return SubscriptionHelper.setOnce(this.other, dVar);
        }

        public void otherError(Throwable th) {
            SubscriptionHelper.cancel(this.s);
            this.actual.onError(th);
        }
    }

    /* loaded from: classes4.dex */
    final class a implements j<U> {
        private final WithLatestFromSubscriber<T, U, R> mUz;

        a(WithLatestFromSubscriber<T, U, R> withLatestFromSubscriber) {
            this.mUz = withLatestFromSubscriber;
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(d dVar) {
            if (this.mUz.setOther(dVar)) {
                dVar.request(Format.OFFSET_SAMPLE_RELATIVE);
            }
        }

        @Override // org.a.c
        public void onNext(U u) {
            this.mUz.lazySet(u);
        }

        @Override // org.a.c
        public void onError(Throwable th) {
            this.mUz.otherError(th);
        }

        @Override // org.a.c
        public void onComplete() {
        }
    }
}
