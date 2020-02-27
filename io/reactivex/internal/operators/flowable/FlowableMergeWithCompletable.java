package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.j;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class FlowableMergeWithCompletable<T> extends a<T, T> {
    final io.reactivex.e other;

    @Override // io.reactivex.g
    protected void a(org.a.c<? super T> cVar) {
        MergeWithSubscriber mergeWithSubscriber = new MergeWithSubscriber(cVar);
        cVar.onSubscribe(mergeWithSubscriber);
        this.nwr.a((j) mergeWithSubscriber);
        this.other.a(mergeWithSubscriber.otherObserver);
    }

    /* loaded from: classes7.dex */
    static final class MergeWithSubscriber<T> extends AtomicInteger implements j<T>, org.a.d {
        private static final long serialVersionUID = -4592979584110982903L;
        final org.a.c<? super T> actual;
        volatile boolean mainDone;
        volatile boolean otherDone;
        final AtomicReference<org.a.d> mainSubscription = new AtomicReference<>();
        final OtherObserver otherObserver = new OtherObserver(this);
        final AtomicThrowable error = new AtomicThrowable();
        final AtomicLong requested = new AtomicLong();

        MergeWithSubscriber(org.a.c<? super T> cVar) {
            this.actual = cVar;
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d dVar) {
            SubscriptionHelper.deferredSetOnce(this.mainSubscription, this.requested, dVar);
        }

        @Override // org.a.c
        public void onNext(T t) {
            io.reactivex.internal.util.e.a(this.actual, t, this, this.error);
        }

        @Override // org.a.c
        public void onError(Throwable th) {
            SubscriptionHelper.cancel(this.mainSubscription);
            io.reactivex.internal.util.e.a((org.a.c<?>) this.actual, th, (AtomicInteger) this, this.error);
        }

        @Override // org.a.c
        public void onComplete() {
            this.mainDone = true;
            if (this.otherDone) {
                io.reactivex.internal.util.e.a(this.actual, this, this.error);
            }
        }

        @Override // org.a.d
        public void request(long j) {
            SubscriptionHelper.deferredRequest(this.mainSubscription, this.requested, j);
        }

        @Override // org.a.d
        public void cancel() {
            SubscriptionHelper.cancel(this.mainSubscription);
            DisposableHelper.dispose(this.otherObserver);
        }

        void otherError(Throwable th) {
            SubscriptionHelper.cancel(this.mainSubscription);
            io.reactivex.internal.util.e.a((org.a.c<?>) this.actual, th, (AtomicInteger) this, this.error);
        }

        void otherComplete() {
            this.otherDone = true;
            if (this.mainDone) {
                io.reactivex.internal.util.e.a(this.actual, this, this.error);
            }
        }

        /* loaded from: classes7.dex */
        static final class OtherObserver extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.c {
            private static final long serialVersionUID = -2935427570954647017L;
            final MergeWithSubscriber<?> parent;

            OtherObserver(MergeWithSubscriber<?> mergeWithSubscriber) {
                this.parent = mergeWithSubscriber;
            }

            @Override // io.reactivex.c
            public void onSubscribe(io.reactivex.disposables.b bVar) {
                DisposableHelper.setOnce(this, bVar);
            }

            @Override // io.reactivex.c
            public void onError(Throwable th) {
                this.parent.otherError(th);
            }

            @Override // io.reactivex.c
            public void onComplete() {
                this.parent.otherComplete();
            }
        }
    }
}
