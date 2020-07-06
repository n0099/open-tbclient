package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes7.dex */
public final class FlowableTakeLast<T> extends a<T, T> {
    final int count;

    @Override // io.reactivex.g
    protected void a(org.a.c<? super T> cVar) {
        this.nJW.a((j) new TakeLastSubscriber(cVar, this.count));
    }

    /* loaded from: classes7.dex */
    static final class TakeLastSubscriber<T> extends ArrayDeque<T> implements j<T>, org.a.d {
        private static final long serialVersionUID = 7240042530241604978L;
        final org.a.c<? super T> actual;
        volatile boolean cancelled;
        final int count;
        volatile boolean done;
        org.a.d s;
        final AtomicLong requested = new AtomicLong();
        final AtomicInteger wip = new AtomicInteger();

        TakeLastSubscriber(org.a.c<? super T> cVar, int i) {
            this.actual = cVar;
            this.count = i;
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d dVar) {
            if (SubscriptionHelper.validate(this.s, dVar)) {
                this.s = dVar;
                this.actual.onSubscribe(this);
                dVar.request(Long.MAX_VALUE);
            }
        }

        @Override // org.a.c
        public void onNext(T t) {
            if (this.count == size()) {
                poll();
            }
            offer(t);
        }

        @Override // org.a.c
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // org.a.c
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // org.a.d
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                io.reactivex.internal.util.b.a(this.requested, j);
                drain();
            }
        }

        @Override // org.a.d
        public void cancel() {
            this.cancelled = true;
            this.s.cancel();
        }

        void drain() {
            if (this.wip.getAndIncrement() == 0) {
                org.a.c<? super T> cVar = this.actual;
                long j = this.requested.get();
                while (!this.cancelled) {
                    if (this.done) {
                        long j2 = 0;
                        while (j2 != j) {
                            if (!this.cancelled) {
                                Object obj = (T) poll();
                                if (obj == null) {
                                    cVar.onComplete();
                                    return;
                                } else {
                                    cVar.onNext(obj);
                                    j2++;
                                }
                            } else {
                                return;
                            }
                        }
                        if (j2 != 0 && j != Long.MAX_VALUE) {
                            j = this.requested.addAndGet(-j2);
                        }
                    }
                    if (this.wip.decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }
    }
}
