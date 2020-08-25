package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import java.util.ArrayDeque;
/* loaded from: classes7.dex */
public final class FlowableSkipLast<T> extends a<T, T> {
    final int skip;

    @Override // io.reactivex.g
    protected void a(org.b.c<? super T> cVar) {
        this.omB.a((j) new SkipLastSubscriber(cVar, this.skip));
    }

    /* loaded from: classes7.dex */
    static final class SkipLastSubscriber<T> extends ArrayDeque<T> implements j<T>, org.b.d {
        private static final long serialVersionUID = -3807491841935125653L;
        final org.b.c<? super T> actual;
        org.b.d s;
        final int skip;

        SkipLastSubscriber(org.b.c<? super T> cVar, int i) {
            super(i);
            this.actual = cVar;
            this.skip = i;
        }

        @Override // io.reactivex.j, org.b.c
        public void onSubscribe(org.b.d dVar) {
            if (SubscriptionHelper.validate(this.s, dVar)) {
                this.s = dVar;
                this.actual.onSubscribe(this);
            }
        }

        /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: T, ? super T */
        @Override // org.b.c
        public void onNext(T t) {
            if (this.skip == size()) {
                this.actual.onNext((T) poll());
            } else {
                this.s.request(1L);
            }
            offer(t);
        }

        @Override // org.b.c
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // org.b.c
        public void onComplete() {
            this.actual.onComplete();
        }

        @Override // org.b.d
        public void request(long j) {
            this.s.request(j);
        }

        @Override // org.b.d
        public void cancel() {
            this.s.cancel();
        }
    }
}
