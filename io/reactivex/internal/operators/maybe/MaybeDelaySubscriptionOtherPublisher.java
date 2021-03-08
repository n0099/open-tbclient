package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import io.reactivex.m;
import io.reactivex.o;
import java.util.concurrent.atomic.AtomicReference;
import org.a.d;
/* loaded from: classes6.dex */
public final class MaybeDelaySubscriptionOtherPublisher<T, U> extends io.reactivex.internal.operators.maybe.a<T, T> {
    final org.a.b<U> qps;

    @Override // io.reactivex.k
    protected void b(m<? super T> mVar) {
        this.qps.subscribe(new a(mVar, this.source));
    }

    /* loaded from: classes6.dex */
    static final class a<T> implements io.reactivex.disposables.b, j<Object> {
        final DelayMaybeObserver<T> qqe;
        d s;
        o<T> source;

        a(m<? super T> mVar, o<T> oVar) {
            this.qqe = new DelayMaybeObserver<>(mVar);
            this.source = oVar;
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(d dVar) {
            if (SubscriptionHelper.validate(this.s, dVar)) {
                this.s = dVar;
                this.qqe.actual.onSubscribe(this);
                dVar.request(Long.MAX_VALUE);
            }
        }

        @Override // org.a.c
        public void onNext(Object obj) {
            if (this.s != SubscriptionHelper.CANCELLED) {
                this.s.cancel();
                this.s = SubscriptionHelper.CANCELLED;
                subscribeNext();
            }
        }

        @Override // org.a.c
        public void onError(Throwable th) {
            if (this.s != SubscriptionHelper.CANCELLED) {
                this.s = SubscriptionHelper.CANCELLED;
                this.qqe.actual.onError(th);
                return;
            }
            io.reactivex.d.a.onError(th);
        }

        @Override // org.a.c
        public void onComplete() {
            if (this.s != SubscriptionHelper.CANCELLED) {
                this.s = SubscriptionHelper.CANCELLED;
                subscribeNext();
            }
        }

        void subscribeNext() {
            o<T> oVar = this.source;
            this.source = null;
            oVar.a(this.qqe);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.qqe.get());
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.s.cancel();
            this.s = SubscriptionHelper.CANCELLED;
            DisposableHelper.dispose(this.qqe);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class DelayMaybeObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements m<T> {
        private static final long serialVersionUID = 706635022205076709L;
        final m<? super T> actual;

        DelayMaybeObserver(m<? super T> mVar) {
            this.actual = mVar;
        }

        @Override // io.reactivex.m
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }

        @Override // io.reactivex.m
        public void onSuccess(T t) {
            this.actual.onSuccess(t);
        }

        @Override // io.reactivex.m
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // io.reactivex.m
        public void onComplete() {
            this.actual.onComplete();
        }
    }
}
