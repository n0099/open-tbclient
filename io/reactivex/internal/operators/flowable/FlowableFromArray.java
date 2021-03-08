package io.reactivex.internal.operators.flowable;

import io.reactivex.g;
import io.reactivex.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
/* loaded from: classes6.dex */
public final class FlowableFromArray<T> extends g<T> {
    final T[] array;

    @Override // io.reactivex.g
    public void a(org.a.c<? super T> cVar) {
        if (cVar instanceof io.reactivex.internal.a.a) {
            cVar.onSubscribe(new ArrayConditionalSubscription((io.reactivex.internal.a.a) cVar, this.array));
        } else {
            cVar.onSubscribe(new ArraySubscription(cVar, this.array));
        }
    }

    /* loaded from: classes6.dex */
    static abstract class BaseArraySubscription<T> extends BasicQueueSubscription<T> {
        private static final long serialVersionUID = -2252972430506210021L;
        final T[] array;
        volatile boolean cancelled;
        int index;

        abstract void fastPath();

        abstract void slowPath(long j);

        BaseArraySubscription(T[] tArr) {
            this.array = tArr;
        }

        @Override // io.reactivex.internal.a.c
        public final int requestFusion(int i) {
            return i & 1;
        }

        @Override // io.reactivex.internal.a.f
        public final T poll() {
            int i = this.index;
            T[] tArr = this.array;
            if (i == tArr.length) {
                return null;
            }
            this.index = i + 1;
            return (T) io.reactivex.internal.functions.a.n(tArr[i], "array element is null");
        }

        @Override // io.reactivex.internal.a.f
        public final boolean isEmpty() {
            return this.index == this.array.length;
        }

        @Override // io.reactivex.internal.a.f
        public final void clear() {
            this.index = this.array.length;
        }

        @Override // org.a.d
        public final void request(long j) {
            if (SubscriptionHelper.validate(j) && io.reactivex.internal.util.b.a(this, j) == 0) {
                if (j == Long.MAX_VALUE) {
                    fastPath();
                } else {
                    slowPath(j);
                }
            }
        }

        @Override // org.a.d
        public final void cancel() {
            this.cancelled = true;
        }
    }

    /* loaded from: classes6.dex */
    static final class ArraySubscription<T> extends BaseArraySubscription<T> {
        private static final long serialVersionUID = 2587302975077663557L;
        final org.a.c<? super T> actual;

        ArraySubscription(org.a.c<? super T> cVar, T[] tArr) {
            super(tArr);
            this.actual = cVar;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableFromArray.BaseArraySubscription
        void fastPath() {
            T[] tArr = this.array;
            int length = tArr.length;
            org.a.c<? super T> cVar = this.actual;
            for (int i = this.index; i != length; i++) {
                if (!this.cancelled) {
                    T t = tArr[i];
                    if (t == null) {
                        cVar.onError(new NullPointerException("array element is null"));
                        return;
                    }
                    cVar.onNext(t);
                } else {
                    return;
                }
            }
            if (!this.cancelled) {
                cVar.onComplete();
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableFromArray.BaseArraySubscription
        void slowPath(long j) {
            T[] tArr = this.array;
            int length = tArr.length;
            int i = this.index;
            org.a.c<? super T> cVar = this.actual;
            long j2 = 0;
            while (true) {
                if (j2 != j && i != length) {
                    if (!this.cancelled) {
                        T t = tArr[i];
                        if (t == null) {
                            cVar.onError(new NullPointerException("array element is null"));
                            return;
                        }
                        cVar.onNext(t);
                        j2++;
                        i++;
                    } else {
                        return;
                    }
                } else if (i == length) {
                    if (!this.cancelled) {
                        cVar.onComplete();
                        return;
                    }
                    return;
                } else {
                    j = get();
                    if (j2 == j) {
                        this.index = i;
                        j = addAndGet(-j2);
                        if (j == 0) {
                            return;
                        }
                        j2 = 0;
                    } else {
                        continue;
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    static final class ArrayConditionalSubscription<T> extends BaseArraySubscription<T> {
        private static final long serialVersionUID = 2587302975077663557L;
        final io.reactivex.internal.a.a<? super T> actual;

        ArrayConditionalSubscription(io.reactivex.internal.a.a<? super T> aVar, T[] tArr) {
            super(tArr);
            this.actual = aVar;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableFromArray.BaseArraySubscription
        void fastPath() {
            T[] tArr = this.array;
            int length = tArr.length;
            io.reactivex.internal.a.a<? super T> aVar = this.actual;
            for (int i = this.index; i != length; i++) {
                if (!this.cancelled) {
                    T t = tArr[i];
                    if (t == null) {
                        aVar.onError(new NullPointerException("array element is null"));
                        return;
                    }
                    aVar.tryOnNext(t);
                } else {
                    return;
                }
            }
            if (!this.cancelled) {
                aVar.onComplete();
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableFromArray.BaseArraySubscription
        void slowPath(long j) {
            T[] tArr = this.array;
            int length = tArr.length;
            int i = this.index;
            io.reactivex.internal.a.a<? super T> aVar = this.actual;
            long j2 = 0;
            while (true) {
                if (j2 != j && i != length) {
                    if (!this.cancelled) {
                        T t = tArr[i];
                        if (t == null) {
                            aVar.onError(new NullPointerException("array element is null"));
                            return;
                        }
                        if (aVar.tryOnNext(t)) {
                            j2++;
                        }
                        i++;
                    } else {
                        return;
                    }
                } else if (i == length) {
                    if (!this.cancelled) {
                        aVar.onComplete();
                        return;
                    }
                    return;
                } else {
                    j = get();
                    if (j2 == j) {
                        this.index = i;
                        j = addAndGet(-j2);
                        if (j == 0) {
                            return;
                        }
                        j2 = 0;
                    } else {
                        continue;
                    }
                }
            }
        }
    }
}
