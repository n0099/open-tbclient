package io.reactivex.processors;

import f.a.b0.a;
import f.a.x.i.b;
import g.d.c;
import g.d.d;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes7.dex */
public final class PublishProcessor<T> extends a<T> {

    /* loaded from: classes7.dex */
    public static final class PublishSubscription<T> extends AtomicLong implements d {
        public static final long serialVersionUID = 3562861878281475070L;
        public final c<? super T> actual;
        public final PublishProcessor<T> parent;

        public PublishSubscription(c<? super T> cVar, PublishProcessor<T> publishProcessor) {
            this.actual = cVar;
            this.parent = publishProcessor;
        }

        @Override // g.d.d
        public void cancel() {
            if (getAndSet(Long.MIN_VALUE) == Long.MIN_VALUE) {
                return;
            }
            this.parent.d(this);
            throw null;
        }

        public boolean isCancelled() {
            return get() == Long.MIN_VALUE;
        }

        public boolean isFull() {
            return get() == 0;
        }

        public void onComplete() {
            if (get() != Long.MIN_VALUE) {
                this.actual.onComplete();
            }
        }

        public void onError(Throwable th) {
            if (get() != Long.MIN_VALUE) {
                this.actual.onError(th);
            } else {
                f.a.a0.a.f(th);
            }
        }

        public void onNext(T t) {
            long j = get();
            if (j == Long.MIN_VALUE) {
                return;
            }
            if (j != 0) {
                this.actual.onNext(t);
                b.f(this, 1L);
                return;
            }
            cancel();
            this.actual.onError(new MissingBackpressureException("Could not emit value due to lack of requests"));
        }

        @Override // g.d.d
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                b.b(this, j);
            }
        }
    }

    public void d(PublishSubscription<T> publishSubscription) {
        throw null;
    }
}
