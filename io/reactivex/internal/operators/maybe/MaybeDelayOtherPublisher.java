package io.reactivex.internal.operators.maybe;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import io.reactivex.m;
import java.util.concurrent.atomic.AtomicReference;
import org.b.d;
/* loaded from: classes7.dex */
public final class MaybeDelayOtherPublisher<T, U> extends io.reactivex.internal.operators.maybe.a<T, T> {
    final org.b.b<U> onb;

    @Override // io.reactivex.k
    protected void b(m<? super T> mVar) {
        this.source.a(new a(mVar, this.onb));
    }

    /* loaded from: classes7.dex */
    static final class a<T, U> implements io.reactivex.disposables.b, m<T> {
        io.reactivex.disposables.b d;
        final OtherSubscriber<T> onM;
        final org.b.b<U> onN;

        a(m<? super T> mVar, org.b.b<U> bVar) {
            this.onM = new OtherSubscriber<>(mVar);
            this.onN = bVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.d.dispose();
            this.d = DisposableHelper.DISPOSED;
            SubscriptionHelper.cancel(this.onM);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return SubscriptionHelper.isCancelled(this.onM.get());
        }

        @Override // io.reactivex.m
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.d, bVar)) {
                this.d = bVar;
                this.onM.actual.onSubscribe(this);
            }
        }

        @Override // io.reactivex.m
        public void onSuccess(T t) {
            this.d = DisposableHelper.DISPOSED;
            this.onM.value = t;
            subscribeNext();
        }

        @Override // io.reactivex.m
        public void onError(Throwable th) {
            this.d = DisposableHelper.DISPOSED;
            this.onM.error = th;
            subscribeNext();
        }

        @Override // io.reactivex.m
        public void onComplete() {
            this.d = DisposableHelper.DISPOSED;
            subscribeNext();
        }

        void subscribeNext() {
            this.onN.subscribe(this.onM);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class OtherSubscriber<T> extends AtomicReference<d> implements j<Object> {
        private static final long serialVersionUID = -1215060610805418006L;
        final m<? super T> actual;
        Throwable error;
        T value;

        OtherSubscriber(m<? super T> mVar) {
            this.actual = mVar;
        }

        @Override // io.reactivex.j, org.b.c
        public void onSubscribe(d dVar) {
            if (SubscriptionHelper.setOnce(this, dVar)) {
                dVar.request(Long.MAX_VALUE);
            }
        }

        @Override // org.b.c
        public void onNext(Object obj) {
            d dVar = get();
            if (dVar != SubscriptionHelper.CANCELLED) {
                lazySet(SubscriptionHelper.CANCELLED);
                dVar.cancel();
                onComplete();
            }
        }

        @Override // org.b.c
        public void onError(Throwable th) {
            Throwable th2 = this.error;
            if (th2 == null) {
                this.actual.onError(th);
            } else {
                this.actual.onError(new CompositeException(th2, th));
            }
        }

        @Override // org.b.c
        public void onComplete() {
            Throwable th = this.error;
            if (th != null) {
                this.actual.onError(th);
                return;
            }
            T t = this.value;
            if (t != null) {
                this.actual.onSuccess(t);
            } else {
                this.actual.onComplete();
            }
        }
    }
}
