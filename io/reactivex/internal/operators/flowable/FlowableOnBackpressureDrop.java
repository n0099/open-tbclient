package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes7.dex */
public final class FlowableOnBackpressureDrop<T> extends a<T, T> implements io.reactivex.c.g<T> {
    final io.reactivex.c.g<? super T> onDrop;

    @Override // io.reactivex.c.g
    public void accept(T t) {
    }

    @Override // io.reactivex.g
    protected void a(org.b.c<? super T> cVar) {
        this.omB.a((j) new BackpressureDropSubscriber(cVar, this.onDrop));
    }

    /* loaded from: classes7.dex */
    static final class BackpressureDropSubscriber<T> extends AtomicLong implements j<T>, org.b.d {
        private static final long serialVersionUID = -6246093802440953054L;
        final org.b.c<? super T> actual;
        boolean done;
        final io.reactivex.c.g<? super T> onDrop;
        org.b.d s;

        BackpressureDropSubscriber(org.b.c<? super T> cVar, io.reactivex.c.g<? super T> gVar) {
            this.actual = cVar;
            this.onDrop = gVar;
        }

        @Override // io.reactivex.j, org.b.c
        public void onSubscribe(org.b.d dVar) {
            if (SubscriptionHelper.validate(this.s, dVar)) {
                this.s = dVar;
                this.actual.onSubscribe(this);
                dVar.request(Long.MAX_VALUE);
            }
        }

        @Override // org.b.c
        public void onNext(T t) {
            if (!this.done) {
                if (get() != 0) {
                    this.actual.onNext(t);
                    io.reactivex.internal.util.b.c(this, 1L);
                    return;
                }
                try {
                    this.onDrop.accept(t);
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.J(th);
                    cancel();
                    onError(th);
                }
            }
        }

        @Override // org.b.c
        public void onError(Throwable th) {
            if (this.done) {
                io.reactivex.e.a.onError(th);
                return;
            }
            this.done = true;
            this.actual.onError(th);
        }

        @Override // org.b.c
        public void onComplete() {
            if (!this.done) {
                this.done = true;
                this.actual.onComplete();
            }
        }

        @Override // org.b.d
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                io.reactivex.internal.util.b.a(this, j);
            }
        }

        @Override // org.b.d
        public void cancel() {
            this.s.cancel();
        }
    }
}
