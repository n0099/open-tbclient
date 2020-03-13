package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class FlowableConcatWithCompletable<T> extends a<T, T> {
    final io.reactivex.e other;

    @Override // io.reactivex.g
    protected void a(org.a.c<? super T> cVar) {
        this.nwE.a((j) new ConcatWithSubscriber(cVar, this.other));
    }

    /* loaded from: classes7.dex */
    static final class ConcatWithSubscriber<T> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.c, j<T>, org.a.d {
        private static final long serialVersionUID = -7346385463600070225L;
        final org.a.c<? super T> actual;
        boolean inCompletable;
        io.reactivex.e other;
        org.a.d upstream;

        ConcatWithSubscriber(org.a.c<? super T> cVar, io.reactivex.e eVar) {
            this.actual = cVar;
            this.other = eVar;
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d dVar) {
            if (SubscriptionHelper.validate(this.upstream, dVar)) {
                this.upstream = dVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // io.reactivex.c
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }

        @Override // org.a.c
        public void onNext(T t) {
            this.actual.onNext(t);
        }

        @Override // io.reactivex.c
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // io.reactivex.c
        public void onComplete() {
            if (this.inCompletable) {
                this.actual.onComplete();
                return;
            }
            this.inCompletable = true;
            this.upstream = SubscriptionHelper.CANCELLED;
            io.reactivex.e eVar = this.other;
            this.other = null;
            eVar.a(this);
        }

        @Override // org.a.d
        public void request(long j) {
            this.upstream.request(j);
        }

        @Override // org.a.d
        public void cancel() {
            this.upstream.cancel();
            DisposableHelper.dispose(this);
        }
    }
}
