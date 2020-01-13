package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
/* loaded from: classes5.dex */
public final class FlowableDoFinally<T> extends a<T, T> {
    final io.reactivex.c.a onFinally;

    @Override // io.reactivex.g
    protected void a(org.a.c<? super T> cVar) {
        if (cVar instanceof io.reactivex.internal.a.a) {
            this.nvK.a((j) new DoFinallyConditionalSubscriber((io.reactivex.internal.a.a) cVar, this.onFinally));
        } else {
            this.nvK.a((j) new DoFinallySubscriber(cVar, this.onFinally));
        }
    }

    /* loaded from: classes5.dex */
    static final class DoFinallySubscriber<T> extends BasicIntQueueSubscription<T> implements j<T> {
        private static final long serialVersionUID = 4109457741734051389L;
        final org.a.c<? super T> actual;
        final io.reactivex.c.a onFinally;
        io.reactivex.internal.a.d<T> qs;
        org.a.d s;
        boolean syncFused;

        DoFinallySubscriber(org.a.c<? super T> cVar, io.reactivex.c.a aVar) {
            this.actual = cVar;
            this.onFinally = aVar;
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d dVar) {
            if (SubscriptionHelper.validate(this.s, dVar)) {
                this.s = dVar;
                if (dVar instanceof io.reactivex.internal.a.d) {
                    this.qs = (io.reactivex.internal.a.d) dVar;
                }
                this.actual.onSubscribe(this);
            }
        }

        @Override // org.a.c
        public void onNext(T t) {
            this.actual.onNext(t);
        }

        @Override // org.a.c
        public void onError(Throwable th) {
            this.actual.onError(th);
            runFinally();
        }

        @Override // org.a.c
        public void onComplete() {
            this.actual.onComplete();
            runFinally();
        }

        @Override // org.a.d
        public void cancel() {
            this.s.cancel();
            runFinally();
        }

        @Override // org.a.d
        public void request(long j) {
            this.s.request(j);
        }

        @Override // io.reactivex.internal.a.c
        public int requestFusion(int i) {
            io.reactivex.internal.a.d<T> dVar = this.qs;
            if (dVar == null || (i & 4) != 0) {
                return 0;
            }
            int requestFusion = dVar.requestFusion(i);
            if (requestFusion != 0) {
                this.syncFused = requestFusion == 1;
            }
            return requestFusion;
        }

        @Override // io.reactivex.internal.a.g
        public void clear() {
            this.qs.clear();
        }

        @Override // io.reactivex.internal.a.g
        public boolean isEmpty() {
            return this.qs.isEmpty();
        }

        @Override // io.reactivex.internal.a.g
        public T poll() throws Exception {
            T poll = this.qs.poll();
            if (poll == null && this.syncFused) {
                runFinally();
            }
            return poll;
        }

        void runFinally() {
            if (compareAndSet(0, 1)) {
                try {
                    this.onFinally.run();
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.I(th);
                    io.reactivex.e.a.onError(th);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    static final class DoFinallyConditionalSubscriber<T> extends BasicIntQueueSubscription<T> implements io.reactivex.internal.a.a<T> {
        private static final long serialVersionUID = 4109457741734051389L;
        final io.reactivex.internal.a.a<? super T> actual;
        final io.reactivex.c.a onFinally;
        io.reactivex.internal.a.d<T> qs;
        org.a.d s;
        boolean syncFused;

        DoFinallyConditionalSubscriber(io.reactivex.internal.a.a<? super T> aVar, io.reactivex.c.a aVar2) {
            this.actual = aVar;
            this.onFinally = aVar2;
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d dVar) {
            if (SubscriptionHelper.validate(this.s, dVar)) {
                this.s = dVar;
                if (dVar instanceof io.reactivex.internal.a.d) {
                    this.qs = (io.reactivex.internal.a.d) dVar;
                }
                this.actual.onSubscribe(this);
            }
        }

        @Override // org.a.c
        public void onNext(T t) {
            this.actual.onNext(t);
        }

        @Override // io.reactivex.internal.a.a
        public boolean tryOnNext(T t) {
            return this.actual.tryOnNext(t);
        }

        @Override // org.a.c
        public void onError(Throwable th) {
            this.actual.onError(th);
            runFinally();
        }

        @Override // org.a.c
        public void onComplete() {
            this.actual.onComplete();
            runFinally();
        }

        @Override // org.a.d
        public void cancel() {
            this.s.cancel();
            runFinally();
        }

        @Override // org.a.d
        public void request(long j) {
            this.s.request(j);
        }

        @Override // io.reactivex.internal.a.c
        public int requestFusion(int i) {
            io.reactivex.internal.a.d<T> dVar = this.qs;
            if (dVar == null || (i & 4) != 0) {
                return 0;
            }
            int requestFusion = dVar.requestFusion(i);
            if (requestFusion != 0) {
                this.syncFused = requestFusion == 1;
            }
            return requestFusion;
        }

        @Override // io.reactivex.internal.a.g
        public void clear() {
            this.qs.clear();
        }

        @Override // io.reactivex.internal.a.g
        public boolean isEmpty() {
            return this.qs.isEmpty();
        }

        @Override // io.reactivex.internal.a.g
        public T poll() throws Exception {
            T poll = this.qs.poll();
            if (poll == null && this.syncFused) {
                runFinally();
            }
            return poll;
        }

        void runFinally() {
            if (compareAndSet(0, 1)) {
                try {
                    this.onFinally.run();
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.I(th);
                    io.reactivex.e.a.onError(th);
                }
            }
        }
    }
}
