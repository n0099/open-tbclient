package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.operators.flowable.FlowableSequenceEqual;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.w;
import io.reactivex.y;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public final class FlowableSequenceEqualSingle<T> extends w<Boolean> {
    final io.reactivex.c.d<? super T, ? super T> comparer;
    final org.a.b<? extends T> nnN;
    final org.a.b<? extends T> nnO;
    final int prefetch;

    @Override // io.reactivex.w
    public void b(y<? super Boolean> yVar) {
        EqualCoordinator equalCoordinator = new EqualCoordinator(yVar, this.prefetch, this.comparer);
        yVar.onSubscribe(equalCoordinator);
        equalCoordinator.subscribe(this.nnN, this.nnO);
    }

    /* loaded from: classes7.dex */
    static final class EqualCoordinator<T> extends AtomicInteger implements io.reactivex.disposables.b, FlowableSequenceEqual.a {
        private static final long serialVersionUID = -6178010334400373240L;
        final y<? super Boolean> actual;
        final io.reactivex.c.d<? super T, ? super T> comparer;
        final AtomicThrowable error = new AtomicThrowable();
        final FlowableSequenceEqual.EqualSubscriber<T> first;
        final FlowableSequenceEqual.EqualSubscriber<T> second;
        T v1;
        T v2;

        EqualCoordinator(y<? super Boolean> yVar, int i, io.reactivex.c.d<? super T, ? super T> dVar) {
            this.actual = yVar;
            this.comparer = dVar;
            this.first = new FlowableSequenceEqual.EqualSubscriber<>(this, i);
            this.second = new FlowableSequenceEqual.EqualSubscriber<>(this, i);
        }

        void subscribe(org.a.b<? extends T> bVar, org.a.b<? extends T> bVar2) {
            bVar.subscribe(this.first);
            bVar2.subscribe(this.second);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.first.cancel();
            this.second.cancel();
            if (getAndIncrement() == 0) {
                this.first.clear();
                this.second.clear();
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return SubscriptionHelper.isCancelled(this.first.get());
        }

        void cancelAndClear() {
            this.first.cancel();
            this.first.clear();
            this.second.cancel();
            this.second.clear();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableSequenceEqual.a
        public void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            int i = 1;
            while (true) {
                io.reactivex.internal.a.g<T> gVar = this.first.queue;
                io.reactivex.internal.a.g<T> gVar2 = this.second.queue;
                if (gVar != null && gVar2 != null) {
                    while (!isDisposed()) {
                        if (this.error.get() != null) {
                            cancelAndClear();
                            this.actual.onError(this.error.terminate());
                            return;
                        }
                        boolean z = this.first.done;
                        T t = this.v1;
                        if (t == null) {
                            try {
                                t = gVar.poll();
                                this.v1 = t;
                            } catch (Throwable th) {
                                io.reactivex.exceptions.a.L(th);
                                cancelAndClear();
                                this.error.addThrowable(th);
                                this.actual.onError(this.error.terminate());
                                return;
                            }
                        }
                        T t2 = t;
                        boolean z2 = t2 == null;
                        boolean z3 = this.second.done;
                        T t3 = this.v2;
                        if (t3 == null) {
                            try {
                                t3 = gVar2.poll();
                                this.v2 = t3;
                            } catch (Throwable th2) {
                                io.reactivex.exceptions.a.L(th2);
                                cancelAndClear();
                                this.error.addThrowable(th2);
                                this.actual.onError(this.error.terminate());
                                return;
                            }
                        }
                        T t4 = t3;
                        boolean z4 = t4 == null;
                        if (z && z3 && z2 && z4) {
                            this.actual.onSuccess(true);
                            return;
                        } else if (z && z3 && z2 != z4) {
                            cancelAndClear();
                            this.actual.onSuccess(false);
                            return;
                        } else if (!z2 && !z4) {
                            try {
                                if (!this.comparer.j(t2, t4)) {
                                    cancelAndClear();
                                    this.actual.onSuccess(false);
                                    return;
                                }
                                this.v1 = null;
                                this.v2 = null;
                                this.first.request();
                                this.second.request();
                            } catch (Throwable th3) {
                                io.reactivex.exceptions.a.L(th3);
                                cancelAndClear();
                                this.error.addThrowable(th3);
                                this.actual.onError(this.error.terminate());
                                return;
                            }
                        }
                    }
                    this.first.clear();
                    this.second.clear();
                    return;
                } else if (isDisposed()) {
                    this.first.clear();
                    this.second.clear();
                    return;
                } else if (this.error.get() != null) {
                    cancelAndClear();
                    this.actual.onError(this.error.terminate());
                    return;
                }
                int addAndGet = addAndGet(-i);
                if (addAndGet == 0) {
                    return;
                }
                i = addAndGet;
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableSequenceEqual.a
        public void innerError(Throwable th) {
            if (this.error.addThrowable(th)) {
                drain();
            } else {
                io.reactivex.e.a.onError(th);
            }
        }
    }
}
